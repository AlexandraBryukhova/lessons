package lesson1;

import lesson1.Animals;

import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class Serializable {

    public static void serializableObject(List<Animals> listAnimal, String file) throws IOException {

        Path path = Paths.get(file);
        try (ObjectOutputStream outputStream =
                     new ObjectOutputStream(Files.newOutputStream(path))) {
            outputStream.writeObject(listAnimal);
        }
    }

    public static List<Animals> reserializableObject(String file) throws IOException, ClassNotFoundException {
        Path path = Paths.get(file);
        List<Animals> animalList;
        try (ObjectInputStream inputStream =
                     new ObjectInputStream(Files.newInputStream(path))){
            animalList = (List<Animals>) inputStream.readObject();
        }

        return animalList;
    }

    public static void serializableTwoOutput(List<Animals> listAnimals, String file) throws IOException, ClassNotFoundException {
        Path path = Paths.get(file);
        try (DataOutputStream outputStream =
                     new DataOutputStream(Files.newOutputStream(path))) {

            outputStream.writeInt(listAnimals.size());

            for (Animals animals : listAnimals) {
                outputStream.writeUTF(animals.getName());
                outputStream.writeInt(animals.getAge());
                outputStream.writeUTF(animals.getTypeOfFood().name());
                outputStream.writeInt(animals.getFoodList().size());

                for (Food food : animals.getFoodList()) {
                    outputStream.writeUTF(food.getName());
                    outputStream.writeInt(food.getCount());
                }
            }
        }
    }

    public static List<Animals> serializableTwoInput(String file) throws IOException{

        Path path = Paths.get(file);
        List<Animals> animalList = new ArrayList<>();

        int foodCount;
        int age;
        int cFood;
        String name;
        String nameFood;
        TypeOfFood typeOfFood;

        try (DataInputStream inputStream =
                     new DataInputStream(Files.newInputStream(path))) {


            int animalCount = inputStream.readInt();

            for (int i = 0; i < animalCount; i++) {
                name = inputStream.readUTF();
                age = inputStream.readInt();
                typeOfFood = TypeOfFood.valueOf(inputStream.readUTF());
                foodCount = inputStream.readInt();
                List<Food> foodList = new ArrayList<>();

                for (int j = 0; j < foodCount; j++) {
                    nameFood = inputStream.readUTF();
                    cFood = inputStream.readInt();
                    foodList.add(new Food(nameFood, cFood));
                }
                animalList.add(new Animals(name, age, typeOfFood, foodList));
            }
        }
        return animalList;
    }
}
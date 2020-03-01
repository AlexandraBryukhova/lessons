package lesson1;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Animals implements Serializable {

    private String name;
    private int age;
    private TypeOfFood typeOfFood;
    private List<Food>  foodList;

    public Animals(String name, int age, TypeOfFood typeFood, List<Food> foodList){
        this.name = name;
        this.age =  age;
        this.typeOfFood =  typeFood;
        this.foodList =  foodList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name =  name;
    }

    public int getAge() {
        return age;
    }

    public void setAge( int age) {
        this.age =  age;
    }

    public TypeOfFood getTypeOfFood() {
        return typeOfFood;
    }

    public void setTypeOfFood(TypeOfFood typeFood) {
        this.typeOfFood = typeOfFood;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", typeOfFood=" + typeOfFood +
                ", foodList=" + foodList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animals animal = (Animals) o;
        return age == animal.age &&
                Objects.equals(name, animal.name) &&
                typeOfFood == animal.typeOfFood &&
                Objects.equals(foodList, animal.foodList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, typeOfFood, foodList);
    }
}
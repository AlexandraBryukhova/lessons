package lesson1

import java.io.Serializable;
import static org.junit.Assert.*;
import java.nio.file.NoSuchFileException;
import org.junit.Test;

class SerializableTest {

    @Test
    public void serializableObject() throws IOException, ClassNotFoundException {
        List<Animals>  animalList =  new ArrayList<Animals>();
        animalList.add(new Animals("FOX", 10, TypeOfFood.RABBIT,
                Arrays.asList(new Food("LittleRabbit", 5))));
        animalList.add(new Animals("HAWK", 10, TypeOfFood.CAPYBARA,
                Arrays.asList(new Food("BigCapybara", 3), new Food("VeryBigCapybara", 4))));

        Serializable.searializableObject(animalList, " test");
        assertEquals(animalList, Serializable.reserializableObject("test"));

    }

    @Test
    public void serializableEmpty() throws IOException, ClassNotFoundException {

        Serializable.serializableObject(Collections.emptyList(), "test");
        assertEquals(Collections.emptyList(), Serializable.reserializableObject("test"));
    }

    @Test
    public void serializableNotEquals() throws IOException, ClassNotFoundException {
        List<Animals> animalList1 = Arrays.asList(
                new Animals("WOLF", 75, TypeOfFood.BANANAS,
                        Arrays.asList(new Food("YellowBananas", 70))),
                new Animals("ELK", 76, TypeOfFood.GRASS,
                        Arrays.asList(new Food("WildFlowers", 400), new Food("Moss", 900))));

        List<Animals> animalList2 = Arrays.asList(
                new Animals("FOX", 50, TypeOfFood.RABBIT,
                        Arrays.asList(new Food("LittleRabbit", 5))),
                new Animals("HAWK", 30, TypeOfFood.CAPYBARA,
                        Arrays.asList(new Food("BigCapybara", 3), new Food("VeryBigCapybara", 4))));

        Serializable.serializableObject(animalList1, "animals1");
        Serializable.serializableObject(animalList2, "animals2");
        assertEquals(animalList1, Serializable.reserializableObject("animals1"));
        assertEquals(animalList2, Serializable.reserializableObject("animals2"));
        assertNotEquals(animalList1, Serializable.reserializableObject("animals2"));
        assertNotEquals(animalList2, Serializable.reserializableObject("animals1"));
    }

    @Test
    public void serializableErrorCatch() throws ClassNotFoundException {

        try {
            Serializable.reserializableObject("NO_FILE");
            fail();
        } catch (NoSuchFileException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            fail();
        }
    }
}
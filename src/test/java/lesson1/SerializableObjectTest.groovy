package lesson1

import java.io.Serializable;
import static org.junit.Assert.*;
import java.nio.file.NoSuchFileException;
import org.junit.Test;

public class SerializableTwoTest {

    @Test
    public void serializableOutput() throws IOException, ClassNotFoundException {
        List<Animals>  animalList =  new ArrayList<Animals>();
        animalList.add(new Animals("FOX", 10, TypeOfFood.RABBIT,
                Arrays.asList(new Food("LittleRabbit", 5))));
        animalList.add(new Animals("HAWK", 10, TypeOfFood.CAPYBARA,
                Arrays.asList(new Food("BigCapybara", 3), new Food("VeryBigCapybara", 4))));

        Serializable.serializableTwoOutput(animalList, "test");
        assertEquals(animalList, Serializable.serializableTwoInput("test"));
    }

    @Test
    public void serializableTwoInput() throws IOException, ClassNotFoundException{
        Serializable.serializableTwoOutput(Collections.emptyList(), "test");
        assertEquals(Collections.emptyList(), Serializable.serializableTwoInput("test"));
    }

    @Test
    public void serializableMechanicNotEquals() throws IOException, ClassNotFoundException {
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

        Serializable.serializableTwoOutput(animalList1, "animals1");
        Serializable.serializableTwoOutput(animalList2, "animals2");
        assertEquals(animalList1, Serializable.serializableTwoInput("animals1"));
        assertEquals(animalList2, Serializable.serializableTwioInput("animals2"));
        assertNotEquals(animalList1, Serializable.serializableTwoInput("animals2"));
        assertNotEquals(animalList2, Serializable.serializableTwoInput("animals1"));
    }

    @Test
    public void serializableTwoErrorCatch() throws ClassNotFoundException {

        try {
            Serializable.serializableTwoInput("NO_FILE");
            fail();
        } catch (NoSuchFileException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            fail();
        }
    }
}

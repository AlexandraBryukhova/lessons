package lesson1;

import java.util.Objects;
import java.io.Serializable;

public class Food implements Serializable {

    private String name;
    private int count;

    public Food (String name, String nameFood, int count) {
        this.name = name;
        this.count = count;
    }

    public Food (String nameFood, int cFood) {
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "lesson1.Food{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return count == food.count &&
                Objects.equals(name, food.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, count);
    }

}
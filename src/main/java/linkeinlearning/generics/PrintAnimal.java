package linkeinlearning.generics;

public class PrintAnimal <T extends Animal> {

    Animal animal;

    public PrintAnimal(Animal animal) {
        this.animal = animal;
    }

    public void print() {
        animal.prettyPrint();
    }
}

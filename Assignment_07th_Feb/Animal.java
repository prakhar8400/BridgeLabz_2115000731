public class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void makeSound() {
        System.out.println("Generic animal sound"); 
    }
}

public class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age); 
    }

    @Override
    public void makeSound() {
        System.out.println("Woof!"); 
    }
}

public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow!"); 
    }
}

public class Bird extends Animal {

    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Tweet!"); 
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Animal("Generic Animal", 2);
        animal1.makeSound(); // Output: Generic animal sound

        Dog dog1 = new Dog("Buddy", 3);
        dog1.makeSound(); // Output: Woof!

        Cat cat1 = new Cat("Whiskers", 1);
        cat1.makeSound(); // Output: Meow!

        Bird bird1 = new Bird("Tweety", 1);
        bird1.makeSound(); // Output: Tweet!
    }
}

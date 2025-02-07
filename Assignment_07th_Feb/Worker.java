interface Worker {
    void performDuties();
}

public class Person {
    private String name;
    private int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}

public class Chef extends Person implements Worker {

    public Chef(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println("Chef is cooking delicious food.");
    }
}

public class Waiter extends Person implements Worker {

    public Waiter(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println("Waiter is serving customers.");
    }
}

public class Main {
    public static void main(String[] args) {
        Chef chef = new Chef("John Doe", 101);
        chef.performDuties();

        Waiter waiter = new Waiter("Jane Smith", 102);
        waiter.performDuties();
    }
}


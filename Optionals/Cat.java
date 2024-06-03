public class Cat {
    private String name;
    private int age;

    Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }
    int getAge(){
        return this.age;
    }
    String getName(){
        return this.name;
    }

    void print() {
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
    }
}

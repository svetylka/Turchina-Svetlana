public class Lesson_2_4 {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Барсик"),
                new Cat("Мурзик"),
                new Cat("Пушок")
        };
        Dog dog = new Dog("Бобик");

        dog.run(150);

        for (Cat cat : cats) {
            cat.run(250);
            cat.swim(5);
        }

        dog.swim(5);

        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Собак: " + Dog.getDogCount());
        System.out.println("Котов: " + Cat.getCatCount());

        Bowl bowl = new Bowl(35);
        for (Cat cat : cats) {
            cat.eat(bowl, 15);
        }

        for (Cat cat : cats) {
            System.out.println(cat.name + " сытость: " + cat.isFull());
        }

        bowl.addFood(20);
        for (Cat cat : cats) {
            if (!cat.isFull()) {
                cat.eat(bowl, 15);
                System.out.println(cat.name + " докормлен, сытость: " + cat.isFull());
            }
        }
    }
}

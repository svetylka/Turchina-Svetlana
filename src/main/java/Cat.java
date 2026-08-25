public class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFull;

    public Cat(String name) {
        super(name, 200, 0);
        this.isFull = false;
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    public boolean isFull() {
        return isFull;
    }

    public void eat(Bowl bowl, int amount) {
        if (isFull) {
            return;
        }
        if (bowl.decreaseFood(amount)) {
            this.isFull = true;
        }
    }
}

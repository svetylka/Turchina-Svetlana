public class Bowl {
    private int foodAmount;

    public Bowl(int initialFood) {
        this.foodAmount = Math.max(initialFood, 0);
    }

    public void addFood(int amount) {
        if (amount > 0) {
            this.foodAmount += amount;
        }
    }

    public boolean decreaseFood(int amount) {
        if (amount > 0 && this.foodAmount >= amount) {
            this.foodAmount -= amount;
            return true;
        }
        return false;
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}


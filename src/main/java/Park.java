public class Park {
    public String parkName;

    public static class Attraction {
        public String attractionName;
        public String workingHours;
        public double cost;
        public Attraction(String attractionName, String workingHours, double cost) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.cost = cost;
        }
        public void displayAttractionInfo() {
            System.out.println("Аттракцион: " + attractionName + ", Время: " + workingHours + ", Цена: " + cost);
        }



    }
}

package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{

    public DigitalVideoDisc(int id, String title, String category, float cost, String director, float length) {
        super(id, title, category, cost, director, length);
    }

    public  DigitalVideoDisc(int id, String title, String category, float cost){
        super(id,title,category,cost);
    }


    @Override
    public void play(){
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}



/* public class DigitalVideoDisc {
    private static int nbDigitalVideoDiscs = 0; 
    private String title;
    private String category;
    private String director;
    private int length = 0;  
    private double cost;
    private int id; // Instance attribute for ID

    public String getTitle() {return title;    }
    public String getCategory() {return category;}
    public String getDirector() {return director;   }
    public int getLength() {return length;    }
    public double getCost() {return cost;    }
    public int getId() {return id;    }
    // Constructor with title, category, and cost parameters
    public DigitalVideoDisc(String title, String category, double cost) {
        this(title, category, null, 0, cost);
    }
    // Constructor with only title
    public DigitalVideoDisc(String title) {
        this(title, null, null, 0, 0.0); 
    }
    // Constructor with title, category, director, and cost parameters
    public DigitalVideoDisc(String title, String category, String director, double cost) {
        this(title, category, director, 0, cost); 
    }
    // Constructor with all parameters
    public DigitalVideoDisc(String title, String category, String director, int length, double cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs; 
    }

    // Setter methods
    public void setTitle(String titleSet) {title = titleSet;    }
    public void setCategory(String categorySet) {category = categorySet;    }
    public void setDirector(String directorSet) {director = directorSet;    }
    public void setLength(int lengthSet) {length = lengthSet;    }
    public void setCost(double costSet) {cost = costSet;    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DVD Title: ").append(title).append("\n")
          .append("Category: ").append(category != null ? category : "N/A").append("\n")
          .append("Director: ").append(director != null ? director : "N/A").append("\n")
          .append("Length: ").append(length > 0 ? length + " minutes" : "N/A").append("\n")
          .append("Cost: $").append(cost).append("\n")
          .append("ID: ").append(id);

        return sb.toString();
    }
} */

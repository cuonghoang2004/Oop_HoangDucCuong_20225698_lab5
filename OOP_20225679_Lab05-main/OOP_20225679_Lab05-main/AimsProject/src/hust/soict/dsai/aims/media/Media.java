
//Abstract class Media
package hust.soict.dsai.aims.media;

import java.util.*;
import hust.soict.dsai.aims.exception.*;
public abstract class Media {

    private final int id; 
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {return id;}

    public String getTitle() {return title;}

    public String getCategory() {return category;}

    public float getCost() {return cost;}

    boolean equals(Media o2) {
        return title.equals(o2.getTitle());
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public String playGUI() throws PlayerException {
        return "Playing media";
    }
 
    public void setCost(float cost) {
        this.cost = cost;
    }
    public abstract float getLength();
    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " {id= " + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", cost= " + cost + " $}";
    }
}

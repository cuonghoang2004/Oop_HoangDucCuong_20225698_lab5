
package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;
import java.util.LinkedList;

public class Store {
    private final LinkedList<Media> itemsInStore = new LinkedList<>();

    private boolean checkMedia(Media disc) {
        for (Media item : itemsInStore) {
            if (item.equals(disc)) {
                return true;
            }
        }
        return false;
    }

    public Media findMedia(String title) {
        for (Media item : itemsInStore) {
            if (item.getTitle().equals(title)) {
                return item;
            }
        }
        return null;
    }

    public LinkedList<Media> getItemsInStore() { 
        return itemsInStore; 
    }

    public void removeMedia(Media disc) {
        if (checkMedia(disc)) {
            itemsInStore.remove(disc);
            System.out.println(disc.getTitle() + " has been deleted from the store!");
        } else {
            System.out.println("There is no " + disc.getTitle() + " in the store!");
        }
    }

    public void addMedia(Media disc) {
        if (!checkMedia(disc)) {
            itemsInStore.add(disc);
            System.out.println(disc.getTitle() + " has been added to the store!");
        } else {
            System.out.println(disc.getTitle() + " already exists in the store!");
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("\n**********STORE***************\nItems in the store:\n");
        if (itemsInStore.isEmpty()) {
            string.append("There is no media in the store!\n");
        } else {
            for (Media item : itemsInStore) {
                string.append(item.getTitle())
                      .append(" - ")
                      .append(item.getCost())
                      .append(" $\n");
            }
        }
        string.append("*********************************\n");
        return string.toString();
    }
}


/* import hust.soict.dsai.aims.media.DigitalVideoDisc;
import java.util.ArrayList;

public class Store {
    private final ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<>();

    public void addDigitalVideoDisc(DigitalVideoDisc dvd) {
        itemsInStore.add(dvd);
        System.out.println("The DVD \"" + dvd.getTitle() + "\" has been added.");
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc dvd) {
        if (itemsInStore.remove(dvd)) {
            System.out.println("The DVD \"" + dvd.getTitle() + "\" has been removed.");
        } else {
            System.out.println("DVD \"" + dvd.getTitle() + "\" is not in the store.");
        }
    }

    public void printStorelist() {
        System.out.println("\n--- Store ---");
        if (itemsInStore.isEmpty()) {
            System.out.println("No DVDs in store.");
        } else {
            itemsInStore.forEach(dvd -> System.out.println(dvd));
        }
        System.out.println("-------------");
    }
} */

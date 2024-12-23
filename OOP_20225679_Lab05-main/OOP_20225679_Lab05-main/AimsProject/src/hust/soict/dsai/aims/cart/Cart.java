package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Cart {
    private final ArrayList<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media item) {
        if (itemsOrdered.contains(item)) {
            System.out.println(item.getTitle() + " is already in the cart!");
        } else {
            itemsOrdered.add(item);
            System.out.println(item.getTitle() + " is now in your cart!");
        }
    }
    public int qtyOrdered = 0;
    public void removeMedia(Media item) {
        if (itemsOrdered.contains(item)) {
            itemsOrdered.remove(item);
            System.out.println(item.getTitle() + " has been removed from your cart.");
        } else {
            System.out.println(item.getClass().getSimpleName() + " " + item.getTitle() + " is not in the cart!");
        }
    }

    public float totalCost() {
        float sum = 0;
        for (Media item : itemsOrdered) {
            sum += item.getCost();
        }
        return sum;
    }

    public void print() {
        StringBuilder output = new StringBuilder("*************CART**************************\nOrdered items:\n");
        if (itemsOrdered.isEmpty()) {
            output.append("No items\n");
        } else {
            int i = 1;
            for (Media item : itemsOrdered) {
                output.append(i)
                        .append(". [")
                        .append(item.getTitle())
                        .append("] - [")
                        .append(item.getCategory())
                        .append("] - ")
                        .append(item.getCost())
                        .append(" $\n");
                i++;
            }
        }
        output.append("Total: ")
              .append(totalCost())
              .append(" $\n");
        output.append("================================================\n");
        System.out.println(output);
    }

    
    public void searchById(int id) {
        if (id > itemsOrdered.size() || id <= 0) {
            System.out.println("No match found!");
        } else {
            Media item = itemsOrdered.get(id - 1);
            System.out.println("Result: [" + item.getTitle() +
                    "] - [" + item.getCategory() + "] - " + item.getCost() + " $\n");
        }
    }
    public String placeOrder() {
        if (itemsOrdered.isEmpty()) {
            return "Your cart is empty. No order placed.";
        }
        itemsOrdered.clear(); // Xóa giỏ hàng sau khi đặt hàng
        return "Your order has been placed successfully!";
    }

    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }


    public void searchByTitle(String title) {
        for (Media item : itemsOrdered) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Result: [" + item.getTitle() +
                        "] - [" + item.getCategory() + "] - " + item.getCost() + " $\n");
                return;
            }
        }
        System.out.println("No match found");
    }

    public Media findMedia(String title) {
        for (Media item : itemsOrdered) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }
        return null;
    }

    public void emptyCart() {
        itemsOrdered.clear();
    }

    public void sortByTitleCost() {
        itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
    }
}
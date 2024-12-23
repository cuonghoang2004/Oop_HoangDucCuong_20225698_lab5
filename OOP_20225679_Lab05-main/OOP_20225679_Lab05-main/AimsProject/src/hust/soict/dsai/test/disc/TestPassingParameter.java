package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);

        System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("Cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());

        System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        String tmpTitle = dvd1.getTitle();
        dvd1.setTitle(dvd2.getTitle());
        dvd2.setTitle(tmpTitle);
    
        String tmpCategory = dvd1.getCategory();
        dvd1.setCategory(dvd2.getCategory());
        dvd2.setCategory(tmpCategory);
    
        String tmpDirector = dvd1.getDirector();
        dvd1.setDirector(dvd2.getDirector());
        dvd2.setDirector(tmpDirector);
    
        int tmpLength = dvd1.getLength();
        dvd1.setLength(dvd2.getLength());
        dvd2.setLength(tmpLength);
    
        double tmpCost = dvd1.getCost();
        dvd1.setCost(dvd2.getCost());
        dvd2.setCost(tmpCost);
    }
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        dvd.setTitle(title); 
    }
    
}

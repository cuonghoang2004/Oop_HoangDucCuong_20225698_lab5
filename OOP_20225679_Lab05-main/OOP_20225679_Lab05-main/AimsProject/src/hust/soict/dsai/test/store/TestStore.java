
package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class TestStore {
    public static void main(String[] args) {
        
        Store store = new Store();
        
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("One Piece", "Anime", "Oda", 148, 29.5f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Songoku", "Action", "Toriyama", 136, 19.0f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Naruto", "Anime", "Kishimoto", 169, 24.5f);
        
        // Thêm DVD
        store.addDigitalVideoDisc(dvd1);
        store.addDigitalVideoDisc(dvd2);
        store.addDigitalVideoDisc(dvd3);

        // In danh sách DVD
        store.printStorelist();

        // Xóa DVD 
        store.removeDigitalVideoDisc(dvd1);
        store.removeDigitalVideoDisc(dvd2);
        store.removeDigitalVideoDisc(dvd3);

        // In lại danh sách DVD sau khi xóa
        store.printStorelist();
    }
}

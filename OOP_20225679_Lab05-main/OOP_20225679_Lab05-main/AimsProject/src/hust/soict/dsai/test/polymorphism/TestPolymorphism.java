package hust.soict.dsai.test.polymorphism;
import hust.soict.dsai.aims.media.*;
import java.util.ArrayList;
import java.util.List;

public class TestPolymorphism {
    public static void main(String[] args) {
        List<Media> media = new ArrayList<>();
        
        DigitalVideoDisc dvd = new DigitalVideoDisc(4, 
        "Lang vu dai ngay ay", 
        "Drama", 
        5.0f, 
        "Tran Van Thuy", 
        120);
    
        ArrayList<Track> tracks = new ArrayList<>();
        tracks.add(new Track("Beo dat may troi", 4));
        tracks.add(new Track("Song Hong", 3));
        
        CompactDisc cd = new CompactDisc(5, 
            "Nhac tru tinh Viet Nam", 
            "Nhac dan gian", 
            4.0f, 
            "Various Artists", 
            tracks);
        

            List<String> authors = new ArrayList<>();
            authors.add("Hoang Duc Cuong ; ");
            authors.add("Nguyen Tran Trung Quan");
            
            Book book = new Book(6, 
                "Mat Biec", 
                "Tinh cam", 
                6.5f, 
                authors);
            

        media.add(dvd);
        media.add(cd);
        media.add(book);

        for (Media item : media) {
            System.out.println(item);
        }
    }
}

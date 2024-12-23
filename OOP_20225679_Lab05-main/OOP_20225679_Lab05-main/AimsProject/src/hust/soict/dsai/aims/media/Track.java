package hust.soict.dsai.aims.media;

public class Track {
   
    private final String title;
    private final int length;
    
    public int getLength() { return length; }
    public String getTitle() { return title; }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    public boolean equals(Track tmp) {
        return (title.equals(tmp.getTitle())) && (length == tmp.getLength());
    }
}

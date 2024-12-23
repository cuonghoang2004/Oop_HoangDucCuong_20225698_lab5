package hust.soict.dsai.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;

public class StoreScreen extends JFrame {

    private static final Store store = new Store();
    private static final Cart cart = new Cart();

    public static void initSetup() {
        store.addMedia(new DigitalVideoDisc(1, "Cô Ba Sài Gòn", "Drama", 19.95f, "Nguyễn Quang Dũng", 120));
        store.addMedia(new DigitalVideoDisc(2, "Truyền Thuyết Bạch Xà", "Fantasy", 24.95f, "Trần Khải Ca", 150));
        store.addMedia(new DigitalVideoDisc(3, "Thần Đồng Đất Việt", "Animation", 18.99f));

        store.addMedia(new Book(4, "Dế Mèn Phưu Lưu Ký", "Fiction", 20.00f));
        store.addMedia(new Book(5, "Sống", "Philosophy", 202.00f));
        store.addMedia(new Book(6, "Nhà Giả Kim", "Adventure", 120.00f));

        ArrayList<Track> denVauTracks = new ArrayList<>();
        denVauTracks.add(new Track("Bài Ca Xóm Đạo", 215));
        denVauTracks.add(new Track("Màu Nước Mắt", 195));
        denVauTracks.add(new Track("Đưa Nhau Đi Trốn", 300));
        CompactDisc cd1 = new CompactDisc(7, "Đen Vâu - 1000 Năm Có Một", "Music", 1500.98f, "Đen Vâu", denVauTracks);
        store.addMedia(cd1);

        ArrayList<Track> vuCatTuongTracks = new ArrayList<>();
        vuCatTuongTracks.add(new Track("Gió Thì Thầm", 214));
        vuCatTuongTracks.add(new Track("Hành Tinh Song Song", 210));
        CompactDisc cd2 = new CompactDisc(8, "Vũ Cát Tường - Giải Miên", "Music", 2000.22f, "Vũ Cát Tường", vuCatTuongTracks);
        store.addMedia(cd2);

        ArrayList<Track> bichPhuongTracks = new ArrayList<>();
        bichPhuongTracks.add(new Track("Gửi Anh Xa Nhớ", 245));
        bichPhuongTracks.add(new Track("Cớ Sao Lại Làm Lặng Im", 0));
        CompactDisc cd3 = new CompactDisc(9, "Bích Phương - Nghe Này, Tình Yêu!", "Music", 1000.98f, "Bích Phương", bichPhuongTracks);
        store.addMedia(cd3);
    }


    public static void main(String[] args) {
        initSetup();
        new StoreScreen(store);
    }

    public StoreScreen(Store store) {
        super("Store");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 768);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu updateStoreMenu = new JMenu("Update Store");
        JMenuItem addBookItem = new JMenuItem("Add Book");
        JMenuItem addCDItem = new JMenuItem("Add CD");
        JMenuItem addDVDItem = new JMenuItem("Add DVD");

        updateStoreMenu.add(addBookItem);
        updateStoreMenu.add(addCDItem);
        updateStoreMenu.add(addDVDItem);

        addBookItem.addActionListener(new MenuActionListener());
        addCDItem.addActionListener(new MenuActionListener());
        addDVDItem.addActionListener(new MenuActionListener());

        menu.add(updateStoreMenu);

        JMenuItem viewStoreMenu = new JMenuItem("View store");
        JMenuItem viewCartMenu = new JMenuItem("View cart");

        viewStoreMenu.addActionListener(e -> new StoreScreen(store));
        viewCartMenu.addActionListener(e -> new CartScreen(cart));

        menu.add(viewStoreMenu);
        menu.add(viewCartMenu);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 50));
        title.setForeground(Color.CYAN);

        JButton cartButton = new JButton("View cart");
        cartButton.setPreferredSize(new Dimension(120, 50));
        cartButton.addActionListener(e -> new CartScreen(cart));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartButton);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    private JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = new ArrayList<>(store.getItemsInStore());
        for (Media media : mediaInStore) {
            MediaStore cell = new MediaStore(media, cart);
            center.add(cell);
        }

        return center;
    }

    private class MenuActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            switch (command) {
                case "Add Book" -> new AddBookToStoreScreen(store);
                case "Add CD" -> new AddCompactDiscToStoreScreen(store);
                case "Add DVD" -> new AddDigitalVideoDiscToStoreScreen(store);
            }
        }
    }
}

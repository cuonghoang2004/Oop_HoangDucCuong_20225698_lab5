package hust.soict.dsai.aims.screen;

import javax.swing.*;
import java.awt.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;

public class MediaStore extends JPanel {

    public MediaStore(Media media, Cart cart) {
        if (media == null || cart == null) {
            throw new IllegalArgumentException("Media and Cart cannot be null");
        }

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(media.getCost() + "$");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addToCartButton = new JButton("Add to cart");
        addToCartButton.addActionListener(e -> {
            cart.addMedia(media);
            JOptionPane.showMessageDialog(null, 
                media.getTitle() + " has been added to the cart!", 
                "Success", JOptionPane.INFORMATION_MESSAGE);
        });
        container.add(addToCartButton);

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(e -> {
                try {
                    ((Playable) media).play();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, 
                        "Error while playing: " + ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}

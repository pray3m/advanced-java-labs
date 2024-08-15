import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ImageTextChangerApp is a simple Java Swing application that demonstrates:
 * 1. Displaying an image in a JFrame.
 * 2. Showing custom text below the image.
 * 3. Including a button that, when clicked, toggles the displayed text between "Initial Text" and "Text Changed!".
 */

public class ImageTextChangerApp {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Image Text Changer App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        ImageIcon imageIcon = new ImageIcon("/Users/pray3m/Developer/IdeaProjects/advance-java-practical/java-gui-swing/src/image.jpg");
        JLabel imageLabel = new JLabel(imageIcon);
        panel.add(imageLabel, BorderLayout.CENTER);

        JLabel textLabel = new JLabel("Initial Text", SwingConstants.CENTER);
        panel.add(textLabel, BorderLayout.NORTH);

        JButton btn = new JButton("Change Text");
        panel.add(btn, BorderLayout.SOUTH);

        btn.addActionListener(new ActionListener() {
            private boolean isInitialText = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (isInitialText) {
                    textLabel.setText("Text Changed!");
                } else {
                    textLabel.setText("Initial Text");
                }
                isInitialText = !isInitialText;
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}

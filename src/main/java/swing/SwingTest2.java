package swing;

import javax.swing.*;
import java.awt.*;

/**
 * @author vons0
 */
public class SwingTest2 {
    private static final int SIZE = 20;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("von");
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(300, 100);
        jFrame.setLayout(new GridLayout());
        for (int i = 0; i < SIZE; i++) {
            jFrame.add(new Button("Button:" + i));
        }
    }
}

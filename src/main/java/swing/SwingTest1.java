package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

/**
 * @author vons0
 */
public class SwingTest1 {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Hello swing");
        JLabel a_label = new JLabel("A label");
        frame.add(a_label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setVisible(true);
        TimeUnit.SECONDS.sleep(1);
        JButton button = new JButton();
        button.setText("点击啊");
        JTextField textField = new JTextField();
        button.addActionListener(e -> {
            String actionCommand = e.getActionCommand();
            System.out.println(actionCommand);
            textField.setText("啊啊啊 我被点击啊");
        });
        frame.add(button);
        frame.add(textField);
        frame.setLayout(new FlowLayout());
        SwingUtilities.invokeLater(() -> a_label.setText("this is a different"));
    }
}

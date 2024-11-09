import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;


public class KeyEvent {
    private JPanel Event;
    private JTextArea editableTextArea;
    private JTextArea nonEditableTextArea;


    public KeyEvent() {
        editableTextArea.setName("editableTextArea");
        nonEditableTextArea.setName("nonEditableTextArea");

        editableTextArea.setEnabled(true);
        nonEditableTextArea.setEnabled((false));
        nonEditableTextArea.setDisabledTextColor(Color.BLACK);

        editableTextArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {

                String inputText = editableTextArea.getText();
                StringBuilder convertedText = new StringBuilder();
                for (char c: inputText.toCharArray()) {
                    if ("aeiou".indexOf(Character.toLowerCase(c)) != -1) {
                        convertedText.append(Character.toUpperCase(c));
                    } else {
                        convertedText.append(c);
                    }
                }
                nonEditableTextArea.setText(convertedText.toString());
            }
        });

    }

    private void setDefaultCloseOperation(int exitOnClose) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(KeyEvent::new);
    }
}
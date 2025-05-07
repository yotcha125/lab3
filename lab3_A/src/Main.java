import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    private JTextField inputField;
    private JTextArea outputArea;
    private JButton generateButton;

    public Main() {
        setTitle("Цифровые узоры");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Панель для ввода
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(new JLabel("Введите N:"));
        inputField = new JTextField(10);
        inputPanel.add(inputField);
        generateButton = new JButton("Сгенерировать");
        inputPanel.add(generateButton);
        add(inputPanel, BorderLayout.NORTH);

        // Поле для вывода
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Обработчик кнопки
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generatePattern();
            }
        });
    }

    private void generatePattern() {
        try {
            int N = Integer.parseInt(inputField.getText());
            outputArea.setText(""); // Очистка поля вывода


            int i = 1;
            while (i <= N) {
                int j = i;
                StringBuilder row = new StringBuilder();
                while (j <= 2 * N - 1) {
                    row.append(j).append(" ");
                    j += 2;
                }
                outputArea.append(row.toString().trim() + "\n");
                i++;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Пожалуйста, введите целое число!", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    private JTextField inputField;
    private JTextArea outputArea;
    private JButton generateButton;

    public Main() {
        setTitle("Пирамидальный узор");
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
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
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

            int i = N;
            do {
                int j = i;
                StringBuilder line = new StringBuilder();

                for (int k = 0; k < (N - (N - i + 1)); k++) {
                    line.append("    ");
                }
                do {
                    line.append(j).append("   ");
                    j++;
                } while (j <= N);
                outputArea.append(line.toString() + "\n");
                i--;
            } while (i >= 1);

            i = 2;
            do {
                int j = i;
                StringBuilder line = new StringBuilder();
                
                for (int k = 0; k < (N - (N - i + 1)); k++) {
                    line.append("    ");
                }
                do {
                    line.append(j).append("   ");
                    j++;
                } while (j <= N);
                outputArea.append(line.toString() + "\n");
                i++;
            } while (i <= N);

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
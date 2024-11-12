package Condicional;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SequenciaFibonacci extends JFrame {
    private JTextArea outputArea;
    private JTextField inputField;

    public SequenciaFibonacci() {
        setTitle("Sequência de Fibonacci | por @john1santoz");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Fonte personalizada
        Font font = new Font("SansSerif", Font.PLAIN, 18);

        // Painel de entrada
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Digite um número:");
        label.setFont(font);
        inputPanel.add(label);

        inputField = new JTextField(10);
        inputField.setFont(font);
        inputPanel.add(inputField);

        JButton calcularButton = new JButton("Calcular");
        calcularButton.setFont(font);
        inputPanel.add(calcularButton);

        JButton limparButton = new JButton("Limpar");
        limparButton.setFont(font);
        inputPanel.add(limparButton);

        add(inputPanel, BorderLayout.NORTH);

        // Área de saída
        outputArea = new JTextArea();
        outputArea.setFont(font);
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.CENTER);

        // Ação do botão "Calcular"
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularFibonacci();
            }
        });

        // Ação do botão "Limpar"
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
    }

    // Método para calcular a sequência de Fibonacci
    private void calcularFibonacci() {
        outputArea.setText(""); // Limpa a área de saída

        try {
            int numero = Integer.parseInt(inputField.getText());
            if (numero < 0) {
                outputArea.setText("Por favor, insira um número positivo.");
                return;
            }

            int primeiroTermo = 0;
            int segundoTermo = 1;

            outputArea.append("Sequência de Fibonacci até " + numero + ":\n");

            while (primeiroTermo <= numero) {
                outputArea.append(primeiroTermo + " ");
                int proximoTermo = primeiroTermo + segundoTermo;
                primeiroTermo = segundoTermo;
                segundoTermo = proximoTermo;
            }
        } catch (NumberFormatException ex) {
            outputArea.setText("Entrada inválida! Por favor, insira um número inteiro.");
        }
    }

    // Método para limpar os campos
    private void limparCampos() {
        inputField.setText("");
        outputArea.setText("");
    }

    // Método principal
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SequenciaFibonacci frame = new SequenciaFibonacci();
            frame.setVisible(true);
        });
    }
}




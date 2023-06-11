package CalculadoraIMC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraIMC extends JFrame {

    private JPanel panelMain;
    private JButton okButton;
    private JTextField pesoTextField;
    private JTextField alturaTextField;
    private JLabel pesoLabel;
    private JLabel alturaLabel;
    private JLabel classificacaoLabel;

    public CalculadoraIMC() {
        setTitle("Calculadora IMC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        panelMain = new JPanel();
        panelMain.setLayout(new GridLayout(4, 2));

        pesoLabel = new JLabel("Peso (kg):");
        pesoTextField = new JTextField();

        alturaLabel = new JLabel("Altura (metros):");
        alturaTextField = new JTextField();

        classificacaoLabel = new JLabel();

        panelMain.add(pesoLabel);
        panelMain.add(pesoTextField);
        panelMain.add(alturaLabel);
        panelMain.add(alturaTextField);
        panelMain.add(classificacaoLabel);

        okButton = new JButton("Calcular");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularIMC();
            }
        });

        panelMain.add(okButton);

        add(panelMain);
    }

    private void calcularIMC() {
        try {
            double peso = Double.parseDouble(pesoTextField.getText());
            double altura = Double.parseDouble(alturaTextField.getText());
            double imc = peso / (altura * altura);

            String imcFormatado = String.format("%.2f", imc);
            String classificacao = obterClassificacaoIMC(imc);

            classificacaoLabel.setText("Classificação: " + classificacao);

            JOptionPane.showMessageDialog(this, "IMC: " + imcFormatado + " (" + classificacao + ")");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite valores numéricos válidos para peso e altura.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String obterClassificacaoIMC(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc < 24.9) {
            return "Peso normal";
        } else if (imc < 29.9) {
            return "Sobrepeso";
        } else if (imc < 34.9) {
            return "Obesidade grau 1";
        } else if (imc < 39.9) {
            return "Obesidade grau 2";
        } else {
            return "Obesidade grau 3";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculadoraIMC().setVisible(true);
            }
        });
    }
}











/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.projeto_calculadora.view;

import br.edu.ifsuldeminas.projeto_calculadora.controller.ControleCalculadora;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author 15730547633
 */
public class TelaCalculadora extends JFrame {
    private JTextField visor;
    private ControleCalculadora controle;
    private StringBuilder input;

    public TelaCalculadora() {
        controle = new ControleCalculadora();
        input = new StringBuilder();
        initComponents();
    }

    private void initComponents() {
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        visor = new JTextField();
        visor.setBounds(10, 10, 270, 50);
        visor.setHorizontalAlignment(JTextField.RIGHT);
        add(visor);

        String[] labels = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "C", "=", "+"};
        int x = 10, y = 70;
        for (int i = 0; i < labels.length; i++) {
            JButton button = new JButton(labels[i]);
            button.setBounds(x, y, 60, 60);
            button.addActionListener(new ButtonClickListener());
            add(button);
            x += 70;
            if ((i + 1) % 4 == 0) {
                x = 10;
                y += 70;
            }
        }

        JButton sqrtButton = new JButton("√");
        sqrtButton.setBounds(220, 340, 60, 60);
        sqrtButton.addActionListener(new ButtonClickListener());
        add(sqrtButton);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if ("0123456789".contains(command)) {
                input.append(command);
                visor.setText(input.toString());
            } else if ("C".equals(command)) {
                input.setLength(0);
                visor.setText("");
                controle.setNovoCalculo(true);
            } else if ("=".equals(command)) {
                try {
                    controle.setValor2(Double.parseDouble(input.toString()));
                    double resultado = controle.calcular();
                    visor.setText(String.valueOf(resultado));
                    input.setLength(0);
                    input.append(resultado);
                } catch (ArithmeticException ex) {
                    visor.setText("Erro: " + ex.getMessage());
                }
            } else if ("√".equals(command)) {
                try {
                    controle.setValor1(Double.parseDouble(visor.getText()));
                    controle.setOperador("√");
                    double resultado = controle.calcular();
                    visor.setText(String.valueOf(resultado));
                    input.setLength(0);
                    input.append(resultado);
                } catch (Exception ex) {
                    visor.setText("Erro");
                }
            } else {
                if (controle.isNovoCalculo()) {
                    controle.setValor1(Double.parseDouble(input.toString()));
                    controle.setOperador(command);
                    input.setLength(0);
                    visor.setText("");
                    controle.setNovoCalculo(false);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaCalculadora().setVisible(true));
    }
}
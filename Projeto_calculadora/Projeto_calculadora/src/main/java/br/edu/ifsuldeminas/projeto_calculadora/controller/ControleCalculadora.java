/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.projeto_calculadora.controller;
import br.edu.ifsuldeminas.projeto_calculadora.model.Calculadora;

/**
 *
 * @author 15730547633
 */
public class ControleCalculadora {
     private Calculadora calculadora;
    private double valor1;
    private double valor2;
    private String operador;
    private boolean novoCalculo;

    public ControleCalculadora() {
        calculadora = new Calculadora();
        novoCalculo = true;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public void setValor1(double valor1) {
        this.valor1 = valor1;
    }

    public void setValor2(double valor2) {
        this.valor2 = valor2;
    }

    public double calcular() throws ArithmeticException {
        double resultado = 0;
        switch (operador) {
            case "+":
                resultado = calculadora.soma(valor1, valor2);
                break;
            case "-":
                resultado = calculadora.subtrai(valor1, valor2);
                break;
            case "*":
                resultado = calculadora.multiplica(valor1, valor2);
                break;
            case "/":
                resultado = calculadora.divide(valor1, valor2);
                break;
            case "√":
                resultado = calculadora.raizQuadrada(valor1);
                break;
        }
        novoCalculo = true;
        return resultado;
    }

    public boolean isNovoCalculo() {
        return novoCalculo;
    }

    public void setNovoCalculo(boolean novoCalculo) {
        this.novoCalculo = novoCalculo;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.projeto_calculadora.model;

/**
 *
 * @author 15730547633
 */
public class Calculadora {
    public double soma(double a, double b) {
        return a + b;
    }

    public double subtrai(double a, double b) {
        return a - b;
    }

    public double multiplica(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Divisão por zero");
        }
        return a / b;
    }

    public double raizQuadrada(double a) {
        return Math.sqrt(a);
    }
    
}

package com.alpha;

import java.util.Scanner;
// Created by: Jason Dockery
// program finished: 09/27/2019

public class Module1 {
    Module1Data m1d = new Module1Data();
    Scanner scanner = new Scanner(System.in);
    double input;

    public static void main(String[] args) {

        Module1 m1 = new Module1();
        System.out.println("Application launched");
        System.out.println("Please enter a floating point number to be squared and cubed");
        m1.input = m1.scanner.nextDouble();
        System.out.println("int squared: " + m1.m1d.square((int)m1.input));
        System.out.println("double squared: " + m1.m1d.square((int)m1.input));
        System.out.println("int cubed: " + m1.m1d.square((int)m1.input));
        System.out.println("double cubed: " + m1.m1d.square((int)m1.input));
        System.out.println("Computations completed");
    }

}
class Module1Data {
    int square (int number){
        return (int)number*(int)number;
    }
    double square( double number){
        return (int)number*(int)number;
    }
    int intCubed( double number){
        return (int)number*(int)number*(int)number;
    }
    double doubleCubed( double number){
        return (int)number*(int)number*(int)number;
    }
}
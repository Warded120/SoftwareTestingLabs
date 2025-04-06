package com.ivan.lab1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HumanBmi humanBmi = new HumanBmi(80,1.52);
        System.out.println(humanBmi.getResult());
    }
}
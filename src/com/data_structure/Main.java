package com.data_structure;

import com.data_structure.array.Array;

public class Main {
    public static void main(String[] args) {
        Array numbers = new Array(3);
        numbers.addItem(11);
        numbers.addItem(22);
        numbers.addItem(33);
        numbers.removeItemAt(1);
        numbers.print();
        System.out.println("index: " + numbers.indexOf(33));
    }
}

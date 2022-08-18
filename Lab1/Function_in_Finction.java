package com.company;

public class Function_in_Finction {
    public static void main(String[] args) {
        function1();
    }

    static void function1(){
        function2();
        System.out.println("function 1");
    }
    static void function2(){
        function3();
        System.out.println("function 2");
    }
    static void function3(){
        function4();
        System.out.println("function 3");
    }
    static void function4(){
        System.out.println("function 4");
    }
}

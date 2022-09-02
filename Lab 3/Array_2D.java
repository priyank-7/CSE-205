package com.company;

import java.util.Scanner;

class Array2D_ {

    private int rows;
    private int columns;
    private int [][] arr;

    public Array2D_(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.arr = new int[rows][columns];
    }

    //  Return number of rows
    public int numRows() {
        return rows;
    }

    //  Return number of columns
    public int numColumns() {
        return columns;
    }

    //  Set the item at the given index
    public void setitem(int i_row, int j_col, int value) throws Exception{
        try {
            arr[i_row][j_col] = value;
        }
        catch (Exception e){
            throw new ArrayIndexOutOfBoundsException("Enter correct index");
//            System.out.println("Enter correct index");
        }
    }

    //  Clear value according to input
    public void clear(int value) throws Exception{
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = value;
            }
        }
    }

    //  return the value at given
    public int getitem(int i1, int i2){
        try {
            return arr[i1][i2];
        }
        catch (Exception e){
            throw new ArrayIndexOutOfBoundsException("Enter correct index");
//            System.out.println("Enter correct index");
        }
    }

    //  Display the value
    public void display(){
        System.out.println();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }


}
public class Array_2D {
    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);
        
        Array2D_ arr = new Array2D_(2,2);     //  Creating a new Matrix

        System.out.println(arr.numRows());              //  Returns number of Rows
        System.out.println(arr.numColumns());           //  Returns number of Columns

        for (int i = 0; i < arr.numRows(); i++) {
            for (int j = 0; j < arr.numColumns(); j++) {
                System.out.print("Array ["+i+"]["+j+"] = ");
                int n = sc.nextInt();
                arr.setitem(i,j,n);             //  Setting thr item at given index
            }
        }
        arr.display();

        arr.clear(7);               //  Clear() --> Setting each element to given value
        arr.display();

        System.out.println(arr.getitem(12,12));
    }
}

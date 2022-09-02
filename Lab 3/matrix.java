package com.company;

import java.util.Arrays;
import java.util.Scanner;

                            //  This file contains all the method of Q-2 and Q-3
                            //  This file contains all the method of Q-2 and Q-3

class Matrix_ {

    private int rows;
    private int columns;
    private int [][] arr;

    Object_Array obj = new Object_Array();

    public Matrix_(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.arr = new int [rows][columns];
    }

    //  return the number of rows
    public int numRows() {
        return rows;
    }

    //  return thr number of colum
    public int numColumns() {
        return columns;
    }

    // return a value at given (row,colum)
    public int getitem(int i1, int i2){
        try {
            return arr[i1][i2];
        }
        catch (Exception e){
            System.out.println("Enter correct index");
            return -1;
        }
    }

    //  Setting the item
    public void setitem(int row, int column, int scalar){
        if (scalar == 0){
            return;
        }
        try{
            arr[row][column] = scalar;
            Node node = new Node(row, column, scalar);
            obj.add(node);
        }
        catch (Exception e){
            System.out.println("Enter correct index");
        }
    }

    //  Scaling the matrix
    public void scaleBy(int scalar){
        obj.scale(scalar);
        for (int i = 0; i < obj.getSize(); i++) {
            int row = obj.getNode(i).getRow();
            int col = obj.getNode(i).getColum();
           arr[row][col] = obj.getNode(i).getData();
        }
    }

    //  Transpose the matrix
    public int[][] transpose(){

        for (int i = 0; i < obj.getSize(); i++){
            int row = obj.getNode(i).getRow();
            int colum = obj.getNode(i).getColum();
            this.arr[row][colum] = 0;
        }
        obj.transpose();
        for (int i = 0; i < obj.getSize(); i++) {
            int row = obj.getNode(i).getRow();
            int colum = obj.getNode(i).getColum();
            arr[row][colum] = obj.getNode(i).getData();
        }
        return arr;
    }

    //  Addition of two matrix
    public int[][] addMatrix(Matrix_ m1, Matrix_ m2){

        if (m1.numColumns() != m2.numColumns() && m1.numRows() != m2.numRows()){
            System.out.println("Summation of matrices is not possible");
            return new int[][]{{-1},{-1}};
        }
        int [][] addition = new int[m1.rows][m1.columns];
        for (int i = 0; i < m1.obj.getSize(); i++) {
            addition[m1.obj.getNode(i).getRow()][m1.obj.getNode(i).getRow()] += m1.obj.getNode(i).getData();
        }
        for (int i = 0; i < m2.obj.getSize(); i++) {
            addition[m2.obj.getNode(i).getRow()][m2.obj.getNode(i).getRow()] += m2.obj.getNode(i).getData();
        }
        return addition;
    }


    //  Subtraction of two matrix
    public int[][] subtract(Matrix_ m1, Matrix_ m2){

        if (m1.numColumns() != m2.numColumns() && m1.numRows() != m2.numRows()){
            System.out.println("Summation of matrices is not possible");
            return new int[][]{{-1},{-1}};
        }
        int [][] subtraction = new int[m1.rows][m1.columns];
        for (int i = 0; i < m1.obj.getSize(); i++) {
            subtraction[m1.obj.getNode(i).getRow()][m1.obj.getNode(i).getRow()] += m1.obj.getNode(i).getData();
        }
        for (int i = 0; i < m2.obj.getSize(); i++) {
            subtraction[m2.obj.getNode(i).getRow()][m2.obj.getNode(i).getRow()] -= m2.obj.getNode(i).getData();
        }
        return subtraction;
    }

    //  Multiplication of matrix
    public int[][] multiply(Matrix_ m1, Matrix_ m2) throws Exception{
        int [][] multi = new int[m1.rows][m2.columns];
        if (m1.numColumns() == m2.numRows()){

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    for (int k = 0; k < m1.columns; k++) {
                        multi[i][j] = m1.arr[i][k] * m2.arr[k][j];
                    }
                }
            }
            return multi;
        }
        else {
            throw new Exception("multiplication can not be possible");
        }
    }

    //  Display the matrix
    public void display(){
        for (int [] a: arr) {
            System.out.println(Arrays.toString(a));
        }
    }
}

//  Create a node to store the non-zero value, row, colum;
class Node{
    private int data;
    private int row;
    private int colum;

    public Node(int data) {
        this.data = data;
    }

    public int getRow() {
        return row;
    }

    public int getColum() {
        return colum;
    }

    public Node(int row, int colum, int data) {
        this.row = row;
        this.colum = colum;
        this.data = data;
    }

    public void InterChange() {

        int temp = this.row;
        this.row = this.colum;
        this.colum = temp;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }
}


//  Create an array to store node
class Object_Array{

    private int size = 0;
    private int DEFAULT_SIZE = 10;
    private Node [] objArray = new Node[DEFAULT_SIZE];

    public Object_Array(){}

    public int getSize() {
        return size;
    }

    public void add(Node node){

        if (size == objArray.length){
            DEFAULT_SIZE = DEFAULT_SIZE * 2;
            Node[] temp = new Node[DEFAULT_SIZE];
            this.objArray = temp;
            for (int i = 0; i < size; i++) {
                objArray[i] = objArray[i];
            }
        }
        objArray[size] = node;
        size++;
    }

    private void isfull(){
        if (size == objArray.length){
            extend();
            return;
        }
        return;
    }
    private void extend(){
        Node [] temp = new Node[size * 2];
        for (int i = 0; i < size; i++) {
            temp[i] = objArray[i];
        }
        objArray = temp;
    }

    public Node getNode(int i) {
        return objArray[i];
    }

    public void scale(int scalar){
        for (int i = 0; i < size; i++) {
            objArray[i].setData(objArray[i].getData()*scalar);
        }
    }

    public void transpose(){
        for (int i = 0; i < size; i++) {
            objArray[i].InterChange();
        }
    }

}
public class matrix {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Matrix_ m = new Matrix_(3, 3);       //  Initialize the Matrix
        for (int i = 0; i < m.numRows(); i++) {
            for (int j = 0; j < m.numColumns(); j++) {
                System.out.print("Array [" + i + "][" + j + "] = ");
                int n = sc.nextInt();
                m.setitem(i, j, n);           //  Setting the value at given index
            }
        }

        m.display();
        System.out.println();

        System.out.println(m.numRows());    //  Print the number of Rows
        System.out.println();

        System.out.println(m.numColumns());     //  Print the number of columns
        System.out.println();

        System.out.println(m.getitem(1, 3));        //  print the value at given index

    }
}
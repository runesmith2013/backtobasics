package com.rob.java.b2b;

public class TestRecursion {


    public int headRecursionSum(int n) {

        //-- a stop condition
        if (n >=1) {

             //-- recursive call
             return headRecursionSum(n-1) +n;
         }


         return n;
    }

    public int tailRecursionSum(int currentSum, int n) {

        if (n <= 1) {
            return currentSum + n;
        }

        //-- no need to store stack frame
        return tailRecursionSum(currentSum+ n, n-1);

    }


    public int powerOfTen(int n) {
        if (n ==0) {
            return 1;
        }
        return powerOfTen(n -1) * 10;
    }


    public String decimalToBinary(int n) {
        if (n <=1) {
            return String.valueOf(n);
        }
        return decimalToBinary(n/2) + String.valueOf( n%2);
    }

    /*
    public int calculateTreeHeight(BinaryNode root) {

        if (root != null) {
            if ( root.getLeft()!= null || root.getRight() != null) {
                return 1+ max(calculateTreeHeight(root.left), calculateTreeHeight(root.right));
            }
        }


    } */


}

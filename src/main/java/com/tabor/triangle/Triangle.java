package com.tabor.triangle;

class Triangle {

    private int side1;
    private int side2;
    private int side3;

    Triangle(int side1, int side2, int side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        verifyTriangle();
    }

    private void verifyTriangle() {
        if(side1 <= 0 || side2 <= 0 || side3 <= 0) throw new IllegalArgumentException();
    }

    boolean isEquilateral(){
        return side1 == side2 && side1 == side3;
    }

    boolean isIsosceles(){
        return side1 == side2 || side1 == side3 || side2 == side3;
    }

    boolean isScalene() {
        return !(isEquilateral() && isIsosceles());
    }
}

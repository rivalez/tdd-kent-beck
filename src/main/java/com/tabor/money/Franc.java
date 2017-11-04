package com.tabor.money;

/**
 * Created by marek on 04.11.2017.
 */
class Franc extends Money {

    Franc(int amount) {
        this.amount = amount;
    }

    Money times(int multiplier) {
        return new Franc(amount * multiplier);
    }
}
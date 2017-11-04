package com.tabor.money;

/**
 * Created by marek on 04.11.2017.
 */
class Dollar extends Money {

    Dollar(int amount){
        this.amount = amount;
    }

    Money times(int multiplier){
        return new Dollar(amount * multiplier);
    }

}

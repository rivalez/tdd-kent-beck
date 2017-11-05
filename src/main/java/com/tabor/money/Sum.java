package com.tabor.money;

/**
 * Created by marek on 05.11.2017.
 */
class Sum implements Expression {

    Money augend;
    Money addend;

    Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }
}
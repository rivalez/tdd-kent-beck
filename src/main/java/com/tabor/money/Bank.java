package com.tabor.money;

/**
 * Created by marek on 05.11.2017.
 */
class Bank {
    Money reduce(Expression source, String to) {
        Sum sum = (Sum) source;
        int amount = sum.augend.amount + sum.addend.amount;
        return new Money(amount, to);
    }
}

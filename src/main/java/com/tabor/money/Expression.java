package com.tabor.money;

/**
 * Created by marek on 05.11.2017.
 */
interface Expression {
    Money reduce(Bank bank, String to);

    Expression plus(Expression addend);

    Expression times(int multiplier);
}

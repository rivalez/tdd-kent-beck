package com.tabor.money;

/**
 * Created by marek on 04.11.2017.
 */
class Dollar extends Money {

    Dollar(int amount, String currency) {
        super(amount, currency);
    }

    String currency() {
        return currency;
    }

}

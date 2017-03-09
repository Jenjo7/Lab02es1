package com.example.giannisavini.lab02;

/**
 * Created by gianni.savini on 09/03/2017.
 */
public enum State {

    ITALIA("Roma"),
    GERMANIA("Berlino"),
    REGNO_UNITO("Lçondra");

    private String capital;

    private State(final String capital) {
        this.capital = capital;
    }

    public String getCapital() {
        return this.capital;
    }
}

package mindera.mindswap;

import mindera.mindswap.sims.SimsCharacter;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Sims!");
        SimsCharacter duarte = new SimsCharacter();
        duarte.buyHouse();
    }
}
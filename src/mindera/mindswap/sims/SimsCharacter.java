package mindera.mindswap.sims;

import mindera.mindswap.house.House;

public class SimsCharacter {
    private String name;
    private int wallet;
    private int staminaLevel;
    private int maxStaminaLevel;
    House house;


    public SimsCharacter() {
        this.name = name;
        this.wallet = 100000;
        this.staminaLevel = maxStaminaLevel;
        this.maxStaminaLevel = 100;
        this.house = house;
    }

    private void balanceAfterHouse(){
        wallet = wallet -= house.getPrice();

    }
    public void buyHouse(){
        if(house == null){
            house = new House();
            balanceAfterHouse();
            System.out.println("Congratulations, you bought a house! You spend " + house.getPrice() + " and have " + wallet + " in your wallet!");
        } else {
            System.out.println("You already have a house!");
        }
    }
}

package mindera.mindswap.sims;

import mindera.mindswap.exceptions.DontHaveHouseException;
import mindera.mindswap.exceptions.YouNeedToBuyAHouse;
import mindera.mindswap.house.House;

public class SimsCharacter {
    private String name;
    private int wallet;
    private int staminaLevel;
    private final int maxStaminaLevel;
    private boolean haveHouse;
    House house;



    public SimsCharacter() {
        this.name = name;
        this.wallet = 100000;
        this.staminaLevel = 100;
        this.maxStaminaLevel = staminaLevel;
        this.house = null;
        this.haveHouse = false;
    }

    private void balanceAfterHouse(){
        wallet = wallet -= house.getPrice();

    }
    public void buyHouse(){
        if(house == null){
            house = new House();
            balanceAfterHouse();
            setHaveHouse(true);
            //message handler
            System.out.println("Congratulations, you bought a house! You spend " + house.getPrice() + " and have " + wallet + " in your wallet!");
        } else {
            System.out.println("You already have a house!");
        }

    }


    public void setHaveHouse(boolean haveHouse) {
        this.haveHouse = haveHouse;
    }

    public boolean hasHouse() throws DontHaveHouseException, YouNeedToBuyAHouse {
        if (getHouse() == null) {
            throw new DontHaveHouseException();
        }
        return false;
    }

    public int getStamina() {
        return staminaLevel;
    }

    public House getHouse() throws YouNeedToBuyAHouse {
        if (house != null) {
            return house;
        }
        throw new YouNeedToBuyAHouse();
    }

    public void reduceStamina(int stamina) {
        staminaLevel -= stamina;
    }

    public void setStaminaLevel(int staminaLevel) {
        this.staminaLevel = staminaLevel;
    }

    public void increaseStamina(int food) {
        staminaLevel += food;
    }
    public void makeMoney(int money){
        wallet += money;
    }

    public void spendMoney(int money) {
        wallet -= money;
    }
}

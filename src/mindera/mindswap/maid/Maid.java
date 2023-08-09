package mindera.mindswap.maid;

import mindera.mindswap.house.House;
import mindera.mindswap.house.Room;
import mindera.mindswap.sims.SimsCharacter;

public class Maid {
    private int priceAllHouse;
    private int priceRoom;

    public Maid(){
        this.priceAllHouse = 100;
        this.priceRoom = 30;
    }

    public void cleanHouse(House house, SimsCharacter simsCharacter){
        if(simsCharacter.getWallet() >= priceAllHouse){
            house.setCleannessLevel(house.getMaxCleannessLevel());
            simsCharacter.spendMoney(priceAllHouse);
            System.out.println("Maid cleaned the house! It's now sparkling clean. You paid " + priceAllHouse + " coins.");
        } else {
            System.out.println("You don't have enough money to call maid!");
        }
    }

    public void cleanRoom(Room room, SimsCharacter simsCharacter){
        if(simsCharacter.getWallet() >= priceRoom){
            room.setCleannessLevel(room.getMaxCleannessLevel());
            simsCharacter.spendMoney(priceRoom);
            System.out.println("Maid cleaned the room! It's now sparkling clean. You paid " + priceAllHouse + " coins.");
        } else {
            System.out.println("You don't have enough money to call maid!");
        }
    }
}

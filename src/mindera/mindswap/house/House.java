package mindera.mindswap.house;

import mindera.mindswap.sims.SimsCharacter;

public class House {
    private int price;
    private int maxCleannessLevel;
    private int cleannessLevel;

    public House(){
        this.price = 50000;
        this.maxCleannessLevel = 500;
        this.cleannessLevel = maxCleannessLevel;
    }

    public int getPrice() {
        return price;
    }

    public int getHouseCleannessLevel(){
        return cleannessLevel;
    }

    public void setCleannessLevel(int cleannessLevel){
        this.cleannessLevel = maxCleannessLevel;
    }

    public void reduceHouseCleanness(int dirtyLevel){
        cleannessLevel -= dirtyLevel;
        if (cleannessLevel < 0) {
            cleannessLevel = 0;
        }
    }
    public int getMaxCleannessLevel(){
        return maxCleannessLevel;
    }

    public void useRoom(RoomType roomType, SimsCharacter simsCharacter){
        Room room = roomType.getRoom();

        if (room != null){
            room.start(simsCharacter);
            if(getHouseCleannessLevel() < 100){
                System.out.println("Your house is too dirty! Call the maid");
            }
        } else {
            System.out.println("This room doesn't exist!");
        }
    }
}

package mindera.mindswap.house;

import java.util.ArrayList;
import java.util.List;

public class House {
    private int price;
    private int maxCleannessLevel;
    private int cleannessLevel;
    private List<Room> rooms;


    public House(){
        this.price = 50000;
        this.maxCleannessLevel = 500;
        this.cleannessLevel = 500;
    }

    private void buildRooms() {
        rooms = new ArrayList<>();
        for (RoomType r: RoomType.values()) {
            rooms.add(r.getRoom());
        }
    }

    public int getPrice() {
        return price;
    }

    public int getHouseCleannessLevel(){
        return cleannessLevel;
    }

    public void setCleannessLevel(){
        this.cleannessLevel = cleannessLevel;
    }

    public void reduceHouseCleanness(int dirtyLevel){
        cleannessLevel -= dirtyLevel;
    }
    public int getMaxCleannessLevel(){
        return maxCleannessLevel;
    }
}

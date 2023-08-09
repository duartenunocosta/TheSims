package mindera.mindswap.house;

import mindera.mindswap.house.rooms.*;

public enum RoomType{
    KITCHEN(new Kitchen(100)),
    LIVING_ROOM (new LivingRoom(100)),
    BATHROOM (new Bathroom(100)),
    BEDROOM(new Bedroom(100)),
    OFFICE(new Office(100)),
    GARDEN(new Garden(0));

    private final Room room;


    RoomType(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }
}

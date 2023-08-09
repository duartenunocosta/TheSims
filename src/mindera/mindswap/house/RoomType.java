package mindera.mindswap.house;

import mindera.mindswap.house.rooms.*;

public enum RoomType{
    KITCHEN(new Kitchen()),
    LIVING_ROOM (new LivingRoom()),
    BATHROOM (new Bathroom()),
    BEDROOM(new Bedroom()),
    OFFICE(new Office()),
    GARDEN(new Garden());

    private final Room room;


    RoomType(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }
}

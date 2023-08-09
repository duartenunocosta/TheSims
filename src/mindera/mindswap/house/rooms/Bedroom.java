package mindera.mindswap.house.rooms;

import mindera.mindswap.exceptions.YouNeedToBuyAHouse;
import mindera.mindswap.house.Room;
import mindera.mindswap.sims.SimsCharacter;

public class Bedroom extends Room {

    public Bedroom( int cleannessLevel) {
        super(cleannessLevel);
    }

    @Override
    public void start(SimsCharacter simsCharacter) {
        super.start(simsCharacter);
    }
    @Override
    protected void reduceHouseCleanness(int dirtyLevel) throws YouNeedToBuyAHouse {
        SimsCharacter.getHouse().reduceHouseCleanness(dirtyLevel);
    }
}


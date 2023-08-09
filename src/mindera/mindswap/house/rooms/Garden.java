package mindera.mindswap.house.rooms;

import mindera.mindswap.exceptions.DontHaveHouseException;
import mindera.mindswap.exceptions.YouNeedToBuyAHouse;
import mindera.mindswap.house.Room;
import mindera.mindswap.sims.SimsCharacter;

public class Garden extends Room {
    public Garden(int cleannessLevel) {
        super(cleannessLevel);
    }

    @Override
    public void start(SimsCharacter simsCharacter) {
            try {
                if (!simsCharacter.hasHouse()) {
                    throw new DontHaveHouseException();
                }
                if(simsCharacter.getStamina() < 10){
                    System.out.println("You need to sleep!");
                    return;
                }
                simsCharacter.reduceStamina(10);
                System.out.println("Read is a good therapy!");
            } catch (DontHaveHouseException h) {
                System.out.println(h.getMessage());
            }
    }

    @Override
    protected void reduceHouseCleanness(int dirtyLevel) throws YouNeedToBuyAHouse {
        SimsCharacter.getHouse().reduceHouseCleanness(dirtyLevel);
    }
}



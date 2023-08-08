package mindera.mindswap.house.rooms;

import mindera.mindswap.exceptions.DontHaveHouseException;
import mindera.mindswap.exceptions.YouNeedToBuyAHouse;
import mindera.mindswap.house.Room;
import mindera.mindswap.sims.SimsCharacter;

public class Office extends Room {
    @Override
    public void start(SimsCharacter simsCharacter) {
        try {
            if (!simsCharacter.hasHouse()) {
                throw new DontHaveHouseException();
            }
            if(simsCharacter.getStamina() < 50){
                System.out.println("You need to sleep!");
            }
            if (getRoomCleannessLevel() < 40) {
                System.out.println("Such a mess you need to call the maid!");
                return;
            }
            simsCharacter.reduceStamina(50);
            System.out.println("Working hard! I need to do this code!");
            reduceRoomCleanness(20);
            simsCharacter.makeMoney(100);
            simsCharacter.getHouse().reduceHouseCleanness(100);
        } catch (DontHaveHouseException h) {
            System.out.println(h.getMessage());
        } catch (YouNeedToBuyAHouse e) {
            throw new RuntimeException(e);
        }
    }
}


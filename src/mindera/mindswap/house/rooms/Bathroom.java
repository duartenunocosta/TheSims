package mindera.mindswap.house.rooms;

import mindera.mindswap.exceptions.DontHaveHouseException;
import mindera.mindswap.exceptions.YouNeedToBuyAHouse;
import mindera.mindswap.house.Room;
import mindera.mindswap.sims.SimsCharacter;

public class Bathroom extends Room {
    @Override
    public void start(SimsCharacter simsCharacter) {
        try {
            if (!simsCharacter.hasHouse()) {
                throw new DontHaveHouseException();
            }
            if(simsCharacter.getStamina() < 10){
                System.out.println("You need to sleep!");
            }
            if (getRoomCleannessLevel() < 40) {
                System.out.println("Such a mess you need to call the maid!");
                return;
            }
                simsCharacter.reduceStamina(10);
                System.out.println("Uff, I'm feeling fresh!");
                reduceRoomCleanness(40);
                simsCharacter.getHouse().reduceHouseCleanness(100);
        } catch (DontHaveHouseException h) {
            System.out.println(h.getMessage());
        } catch (YouNeedToBuyAHouse e) {
            throw new RuntimeException(e);
        }
    }
}

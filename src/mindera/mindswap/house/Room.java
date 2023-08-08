package mindera.mindswap.house;

import mindera.mindswap.exceptions.DontHaveHouseException;
import mindera.mindswap.exceptions.YouNeedToBuyAHouse;
import mindera.mindswap.sims.SimsCharacter;

public abstract class Room implements RoomHandler {
    private int maxCleannessLevel;
    private int cleannessLevel;
    private boolean available;

    public Room() {

    }

    public Room(int maxCleannessLevel) {
        this.maxCleannessLevel = 100;
        this.cleannessLevel = 100;
        this.available = true;

    }

    @Override
    public void start(SimsCharacter simsCharacter) {
        try {
            if (!simsCharacter.hasHouse()) {
                throw new DontHaveHouseException();
            }

            if (simsCharacter.getHouse().getHouseCleannessLevel() >= 100 && getRoomCleannessLevel() >= 20) {
                simsCharacter.setStaminaLevel(100);
                System.out.println("zzzzzzzzz");
                reduceRoomCleanness(20);
                simsCharacter.getHouse().reduceHouseCleanness(100);
            } else {
                System.out.println("Such a mess you need to call the maid!");
            }
        } catch (DontHaveHouseException h) {
            System.out.println(h.getMessage());
        } catch (YouNeedToBuyAHouse e) {
            throw new RuntimeException(e);
        }
    }

        protected void reduceRoomCleanness(int dirtyLevel){
            cleannessLevel -= dirtyLevel;
        }

        protected int getRoomCleannessLevel() {
            return cleannessLevel;
        }

}

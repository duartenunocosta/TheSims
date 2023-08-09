package mindera.mindswap.house;

import mindera.mindswap.exceptions.DontHaveHouseException;
import mindera.mindswap.exceptions.YouNeedToBuyAHouse;
import mindera.mindswap.sims.SimsCharacter;

public abstract class Room implements RoomHandler {
    private int maxCleannessLevel;
    protected int cleannessLevel;
    private boolean available;

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

    protected void reduceRoomCleanness(int dirtyLevel) throws YouNeedToBuyAHouse {
        cleannessLevel -= dirtyLevel;
        if (cleannessLevel < 0) {
            cleannessLevel = 0;
        }
        reduceHouseCleanness(dirtyLevel);
    }

    protected abstract void reduceHouseCleanness(int dirtyLevel) throws YouNeedToBuyAHouse;

    protected int getRoomCleannessLevel() {
            return cleannessLevel;
        }

    public void setCleannessLevel(int cleannessLevel) {
        this.cleannessLevel = maxCleannessLevel;
    }

    public int getMaxCleannessLevel(){
        return maxCleannessLevel;
    }
}

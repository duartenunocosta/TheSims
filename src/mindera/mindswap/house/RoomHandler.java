package mindera.mindswap.house;

import mindera.mindswap.exceptions.DontHaveHouseException;
import mindera.mindswap.sims.SimsCharacter;

public interface RoomHandler {
    void start(SimsCharacter simsCharacter) throws DontHaveHouseException;
}
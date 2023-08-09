package mindera.mindswap;

import mindera.mindswap.exceptions.DontHaveHouseException;
import mindera.mindswap.exceptions.YouNeedToBuyAHouse;
import mindera.mindswap.house.RoomType;
import mindera.mindswap.sims.SimsCharacter;

public class Main {
    public static void main(String[] args) throws YouNeedToBuyAHouse, DontHaveHouseException {
        System.out.println("Welcome to Sims!");
        SimsCharacter duarte = new SimsCharacter();
        duarte.buyHouse();
        System.out.println(duarte.hasHouse());
        duarte.interactWithHouse("/ bathroom");
        System.out.println(duarte.getHouse().getHouseCleannessLevel());
        duarte.interactWithHouse("/ bathroom");
        System.out.println(duarte.getHouse().getHouseCleannessLevel());
        duarte.interactWithHouse("/ bathroom");
        System.out.println(duarte.getHouse().getHouseCleannessLevel());
        duarte.callMaid(RoomType.BATHROOM);
        duarte.interactWithHouse("/ bathroom");
        System.out.println(duarte.getHouse().getHouseCleannessLevel());
        duarte.interactWithHouse("/ bathroom");
        System.out.println(duarte.getHouse().getHouseCleannessLevel());
        duarte.interactWithHouse("/ bathroom");
        System.out.println(duarte.getHouse().getHouseCleannessLevel());
        duarte.callMaid(RoomType.BATHROOM);
        duarte.interactWithHouse("/ bathroom");
        System.out.println(duarte.getHouse().getHouseCleannessLevel());
        duarte.callMaid(null);
        duarte.interactWithHouse("/ bathroom");
        System.out.println(duarte.getHouse().getHouseCleannessLevel());

    }
}
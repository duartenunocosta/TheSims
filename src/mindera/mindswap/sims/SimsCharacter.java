package mindera.mindswap.sims;

import mindera.mindswap.exceptions.DontHaveHouseException;
import mindera.mindswap.exceptions.YouNeedToBuyAHouse;
import mindera.mindswap.house.House;
import mindera.mindswap.house.Room;
import mindera.mindswap.house.RoomType;
import mindera.mindswap.maid.Maid;

public class SimsCharacter {
    private String name;
    private int wallet;
    private int staminaLevel;
    private final int maxStaminaLevel;
    private boolean haveHouse;
    static House house;



    public SimsCharacter() {
        this.name = name;
        this.wallet = 100000;
        this.staminaLevel = 100;
        this.maxStaminaLevel = staminaLevel;
        this.house = null;
        this.haveHouse = false;
    }

    public void buyHouse(){
        if(house == null){
            house = new House();
            balanceAfterHouse();
            setHaveHouse(true);
            //message handler
            System.out.println("Congratulations, you bought a house! You spend " + house.getPrice() + " and have " + wallet + " in your wallet!");
        } else {
            System.out.println("You already have a house!");
        }

    }

    public void interactWithHouse(String command) {
        if (house != null && house.getHouseCleannessLevel() >= 0) {
            String[] commandParts = command.split(" ");
            if (commandParts.length == 2 && commandParts[0].equalsIgnoreCase("/")) {
                String roomName = commandParts[1].toUpperCase();
                try {
                    RoomType selectedRoomType = RoomType.valueOf(roomName);
                    house.useRoom(selectedRoomType, this);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid room name.");
                }
            } else {
                System.out.println("Invalid command. Usage: / <room>");
            }
        } else {
            System.out.println("You don't have a house yet.");
        }
    }

    public void callMaid(RoomType roomType) {
        if (house != null) {
            int maidPrice = 100; // Defina o preço da maid aqui
            Maid maid = new Maid();

            if (roomType == null) {
                System.out.println("Choose an option: 1. Clean the house / 2. Clean a specific room");
                int choice = 1; // Obtenha a escolha do jogador

                if (choice == 1) {
                    maid.cleanHouse(house, this);
                } else if (choice == 2) {
                    System.out.println("Choose a room to clean: ");
                    String roomCommand = "/ ";
                    RoomType selectedRoomType = RoomType.valueOf(roomCommand.toUpperCase());
                    maid.cleanRoom(selectedRoomType.getRoom(), this);
                } else {
                    System.out.println("Invalid choice.");
                }
            } else {
                Room room = roomType.getRoom();
                if (room != null) {
                    maid.cleanRoom(room, this);
                } else {
                    System.out.println("This room doesn't exist!");
                }
            }
        } else {
            System.out.println("You don't have a house yet.");
        }
    }
    public int getWallet() {
        return wallet;
    }
    public int getStamina() {
        return staminaLevel;
    }
    public void setStaminaLevel(int staminaLevel) {
        this.staminaLevel = staminaLevel;
    }

    public void increaseStamina(int food) {
        staminaLevel += food;
    }
    public void makeMoney(int money){
        wallet += money;
    }

    public void spendMoney(int money) {
        wallet -= money;
    }
    public void setHaveHouse(boolean haveHouse) {
        this.haveHouse = haveHouse;
    }

    public boolean hasHouse() {
        return house != null;
    }



    public static House getHouse() throws YouNeedToBuyAHouse {
        if (house != null) {
            return house;
        }
        throw new YouNeedToBuyAHouse();
    }

    public void reduceStamina(int stamina) {
        staminaLevel -= stamina;
        if (staminaLevel < 0) {
            staminaLevel = 0;
        }
    }
    private void balanceAfterHouse(){
        wallet = wallet -= house.getPrice();
    }
}


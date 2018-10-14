/*
 * The main() class file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Gail Lee, Carolyn Murray, Drazen Lucic
 */
package cityofaaron;

import model.*;

/**
 *
 * @author Drazen
 */
public class CityOfAaron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player player = new Player();
        player.setName("Peter");
    
        
        Game game = new Game();
        game.setPlayer(player);
        
        System.out.format("The player's name is %s.\n", player.getName());
        System.out.format("Team member is %s %s.\n",
                TeamMember.DRAZEN_LUCIC.getTitle(),
                TeamMember.DRAZEN_LUCIC.getName());
  
        // Made by Carolyn
        Location locationFarm = new Location ();
        locationFarm.setDescription("This is a corn farm.");
        locationFarm.setSymbol("Cob");
        
        System.out.format("Location symbol is %s. %s\n",
                locationFarm.getSymbol(),
                locationFarm.getDescription());
        
        // Made by Gail Lee
        ListItem wheat = new ListItem ();
        wheat.setName("wheat");
        wheat.setNumber(25);
        
        System.out.format("ListItem name is %s. ListItem number %d\n",
                wheat.getName (),
                wheat.getNumber ());
        
        //Made by Drazen
        
        CropData cropData = new CropData();
        cropData.setYear(2018);
        cropData.setPopulation(100000);
        cropData.setAcresOwned(5000);
        cropData.setCropYield(20);
        cropData.setWheatInStore(400);
        cropData.setNumberWhoDied(0);
        cropData.setNewPeople(50);
        cropData.setHarvest(2500);
        cropData.setPeopleFed(100000);
        cropData.setAcresPlanted(4800);
        cropData.setWheatForPeople(4000);
        
        System.out.format("The year is: %d.\n", cropData.getYear());
        System.out.format("The population is %d.\n", cropData.getPopulation());
        System.out.format("Acres owned is %d.\n", cropData.getAcresOwned());
        System.out.format("Crop yield is %d.\n", cropData.getCropYield());
        System.out.format("Wheat in store is %d.\n", cropData.getWheatInStore());
        System.out.format("Number who died is %d.\n", cropData.getNumberWhoDied());
        System.out.format("New people is %d.\n", cropData.getNewPeople());
        System.out.format("Harvest is %d.\n", cropData.getHarvest());
        System.out.format("People fed is %d.\n", cropData.getPeopleFed());
        System.out.format("Acres planted is %d.\n", cropData.getAcresPlanted());
        System.out.format("Wheat for people is %d.\n", cropData.getWheatForPeople());
        
    }
}

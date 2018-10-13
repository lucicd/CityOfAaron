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
        locationFarm.setDescription("This is an Animal Farm.");
        locationFarm.setSymbol("Sheep");
        
        System.out.format("Location symbol is %s. %s\n",
                locationFarm.getSymbol(),
                locationFarm.getDescription());
    }
}

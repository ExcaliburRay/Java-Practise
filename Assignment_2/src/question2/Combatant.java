
package question2;


import java.util.Random;

/**
 * class Combatant is used to count on winning times within 10000 times for each player
 * @author ray
 */
public class Combatant {

    /**
     * main function is used to set several parameters to each player and count on winning times within 10000 times for each player,
     * therefore, the best player is born.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player player = new Player();
		Random random = new Random();
		player.setNameOne("DeadPool");
		player.setNameTwo("Kingkong");
		player.setNameTwo("Spiderman");
		int countDeadPoolWin = 0;
		int countKingkongWin = 0;
		int countSpidermanWin = 0;
		// the possibility of deadpool win in common
		for(int i=0;i<10000;i++) {
                    //make sure every player is alive
			player.setPlayerOneState(true);
			player.setPlayerTwoState(true);
			player.setPlayerThreeState(true);
			//set possibility of each player
			player.setPlayerOneAccuracy(random.nextInt(3)+1);
			player.setPlayerTwoAccuracy(random.nextInt(2)+1);
			//deadpool hit the target,round one
			if(player.ShootAtTarget(player.getPlayerOneAccuracy())==true) {
				player.setPlayerThreeState(false);
				//let deadpool and Kingkong hit each other until somebody die
				while(player.getPlayerOneState()==true&&player.getPlayerTwoState()==true)  {
					player.setPlayerOneAccuracy(random.nextInt(3)+1);
					player.setPlayerTwoAccuracy(random.nextInt(2)+1);
					//kingkong hit the target,round one,etc.
					if(player.ShootAtTarget(player.getPlayerTwoAccuracy())==true) {
						player.setPlayerOneState(false);
						countKingkongWin++;
						break;
					//deadpool hit the target,round two,etc.
					}else if(player.ShootAtTarget(player.getPlayerOneAccuracy())==true) {
						player.setPlayerTwoState(false);
						countDeadPoolWin++;
						break;
					}
				}
				//deadpool failed, kingkong hit the target,round one
			}else if(player.ShootAtTarget(player.getPlayerTwoAccuracy())==true) {
					player.setPlayerThreeState(false);
					while(player.getPlayerOneState()==true&&player.getPlayerTwoState()==true) {
						player.setPlayerOneAccuracy(random.nextInt(3)+1);
						player.setPlayerTwoAccuracy(random.nextInt(2)+1);
						//deadpool hit the target,round two
						if(player.ShootAtTarget(player.getPlayerOneAccuracy())==true) {
							player.setPlayerTwoState(false);
							countDeadPoolWin++;
							break;
						//kingkong hit the target,round two
						}else if(player.ShootAtTarget(player.getPlayerTwoAccuracy())==true) {
							player.setPlayerOneState(false);
							countKingkongWin++;
							break;
						}
					}
					//Kingkong failed,spiderman shoot Kingkong,round one
			}else {
					player.setPlayerTwoState(false);
					player.setPlayerOneAccuracy(random.nextInt(3)+1);
                                        //Deadpool shoot the target, round two, etc...
					if(player.ShootAtTarget(player.getPlayerOneAccuracy())==true) {
						player.setPlayerThreeState(false);
						countDeadPoolWin++;
					}
                                        //Spiderman shoot the target, round two, etc...
					else {
						player.setPlayerOneState(false);
						countSpidermanWin++;
					}
				}
			}
                //compare the winning times around three players and calculate the best one 
		if(countDeadPoolWin>countKingkongWin&&countDeadPoolWin>countSpidermanWin) {
			System.out.println("DeadPool is the best player");
		}else if(countKingkongWin>countDeadPoolWin&&countKingkongWin>countSpidermanWin) {
			System.out.println("Kingkong is the best player");
		}else {
			System.out.println("Spiderman is the best player");
		}
		System.out.println("Deadpool won "+countDeadPoolWin+"/10,000 fights"+" in common");
		System.out.println("Kingkong won "+countKingkongWin+"/10,000 fights"+" in common");
		System.out.println("Spiderman won "+countSpidermanWin+"/10,000 fights"+" in common");
		System.out.println("-------------------------------------------------------");
		countDeadPoolWin=0;
		countKingkongWin=0;
		countSpidermanWin=0;	
                //loop
		for(int i=0;i<10000;i++) {
                    //make sure every player is alive
			player.setPlayerOneState(true);
			player.setPlayerTwoState(true);
			player.setPlayerThreeState(true);
                        //set possibility of each player
			player.setPlayerOneAccuracy(random.nextInt(3)+1);
			player.setPlayerTwoAccuracy(random.nextInt(2)+1);
                        //kingkong hit the target,round one,etc.
			if(player.ShootAtTarget(player.getPlayerTwoAccuracy())==true) {
				player.setPlayerThreeState(false);
                                ////let deadpool and Kingkong hit each other until somebody die
				while(player.getPlayerOneState()==true&&player.getPlayerTwoState()==true) {
                                        //set possibility of each player
                                        player.setPlayerOneAccuracy(random.nextInt(3)+1);
					player.setPlayerTwoAccuracy(random.nextInt(2)+1);
                                        //deadpool hit the target,round two, etc.
					if(player.ShootAtTarget(player.getPlayerOneAccuracy())==true) {
						player.setPlayerTwoState(false);
						countDeadPoolWin++;
						break;
                                        //Kingkong hit the target,round two, etc.
					}else if(player.ShootAtTarget(player.getPlayerTwoAccuracy())==true) {
						player.setPlayerOneState(false);
						countKingkongWin++;
						break;
					}
				}//Kingkong failed,spiderman shoot Kingkong,round one
			}else {
					player.setPlayerTwoState(false);
					player.setPlayerOneAccuracy(random.nextInt(3)+1);
                                        //Deadpool shoot the target, round two, etc...
					if(player.ShootAtTarget(player.getPlayerOneAccuracy())==true) {
						player.setPlayerThreeState(false);
						countDeadPoolWin++;
					}
                                        //Spiderman shoot the target, round two, etc...
					else {
						player.setPlayerOneState(false);
						countSpidermanWin++;
					}
				}
			
		}
                //compare the winning times around three players and calculate the best one 
		if(countDeadPoolWin>countKingkongWin&&countDeadPoolWin>countSpidermanWin) {
			System.out.println("DeadPool is the best player"+" if Deadpool miss his first shot");
		}else if(countKingkongWin>countDeadPoolWin&&countKingkongWin>countSpidermanWin) {
			System.out.println("Kingkong is the best player"+" if Deadpool miss his first shot");
		}else {
			System.out.println("Spiderman is the best player"+" if Deadpool miss his first shot");
		}
		System.out.println("Deadpool won "+countDeadPoolWin+"/10,000 fights"+" if Deadpool miss his first shot");
		System.out.println("Kingkong won "+countKingkongWin+"/10,000 fights"+" if Deadpool miss his first shot");
		System.out.println("Spiderman won "+countSpidermanWin+"/10,000 fights"+" if Deadpool miss his first shot");
	}
}
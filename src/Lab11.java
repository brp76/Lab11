import java.util.*;

public class Lab11 {

	public static void main(String[] args) {
		Player player = new Player();
		Random _rng = new Random();
		
		do {
			Monster monster = generateMonster(_rng);
			System.out.println("You encounter a " + monster.getName() + "!");
			System.out.printf("HP: %d MP: %d\n", player.getHP(), player.getMP());
			System.out.printf("Monster HP: %d\n", monster.getHP());
			System.exit(0);
			do {
				
			} while (monster.isAlive() == true);
		} while (player.isAlive() == true);
		

	}

	public static Monster generateMonster(Random _rng) {
		Monster _m = null;
		int monsterType = _rng.nextInt(11);
    	switch (monsterType){
    	case 0: case 1: case 2: case 3: case 4:
    		_m = new Goblin();
    		break;
    	case 5: case 6: case 7: case 8:
    		_m = new Troll();
    		break;
    	case 9: case 10:
    		_m = new Dragon();
    		break;	
    	}
    	return _m;
	}	
}

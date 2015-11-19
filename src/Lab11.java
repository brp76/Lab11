import java.util.*;

public class Lab11 {

	public static void main(String[] args) {
		Player player = new Player();
		Random _rng = new Random();
		Scanner sc = new Scanner(System.in);
		char choice = ' ';
		int dmg = 0, hit = 0, tempGold = 0;
		
		do {
			//Monster monster = generateMonster(_rng);
			Monster monster = new Goblin();
			System.out.println("You encounter a " + monster.getName() + "!");
			
			do {
				System.out.printf("HP: %d MP: %d\n", player.getHP(), player.getMP());
				System.out.printf("Monster HP: %d\n", monster.getHP());
				System.out.print("(A)ttack\n(B)erserk\n(M)agic\n(R)un Away\nYour choice > ");
				choice = sc.next().charAt(0);
				
				switch (choice) {
				case 'A': case 'a':
					dmg = player.attack(monster);
					hit = monster.attack(dmg);
					System.out.printf("You dealt %d points of damage, and you received %d points.\n", dmg, hit);
					player.setHP(hit);
					break;
				}
				
				if(monster.isAlive() == false) {
					System.out.println("You have defeated the " + monster.getName() + "!");
					tempGold = monster.getGold();
					System.out.printf("You have gained %d gold pieces!\n", tempGold);
;					player.setGold(tempGold);
					System.out.println("Total Gold: " + player.getGold());
				}
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

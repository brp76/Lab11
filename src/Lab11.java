import java.util.*;

public class Lab11 {

	public static void main(String[] args) {
		Player player = new Player();
		Random _rng = new Random();
		Scanner sc = new Scanner(System.in);
		char choice = ' ';
		int dmg = 0, hit = 0, tempGold = 0;
		boolean run = false;
		
		do {
			Monster monster = generateMonster(_rng);
			System.out.println("....................");
			System.out.println("You encounter a " + monster.getName() + "!");
			run = false;
			
			do {
				System.out.printf("HP: %d MP: %d\n", player.getHP(), player.getMP());
				System.out.printf("Monster HP: %d\n", monster.getHP());
				System.out.print("(A)ttack\n(B)erserk\n(M)agic\n(R)un Away\nYour choice > ");
				choice = sc.next().charAt(0);
				
				switch (choice) {
				// Attack
				case 'A': case 'a':
					dmg = player.attack(monster);
					hit = monster.attack(dmg);
					System.out.printf("You dealt %d points of damage, and you received %d points.\n", dmg, hit);
					player.setHP(hit);
					break;
				// Berserk
				case 'B': case 'b':
					dmg = player.beserk(monster);
					hit = 2 * monster.attack(dmg);
					System.out.printf("You dealt %d points of damage, and you received %d points.\n", dmg, hit);
					player.setHP(hit);
					break;
				// Magic
				case 'M': case 'm':
					dmg = 0;
					hit = monster.attack(dmg);
					player.setHP(-1);
					player.setMP(1);
					System.out.println("You feel revitalized!");
					System.out.printf("You are healed! But the monster attacks for %d points\n", hit);
					player.setHP(hit);
					break;
				// Run Away
				case 'R': case 'r':
					dmg = 5000;
					hit = monster.attack(dmg);
					System.out.printf("You run away! But the monster attacks for %d points\n", hit);
					player.setHP(hit);
					run = true;
					break;
				}
				
				// Defeat
				if (player.isAlive() == false) {
					System.out.println("You have been vanquished by the " + monster.getName()+"...");
					System.out.println("RIPEROONS!");
					sc.close();
					return;
				}
				
				// Kill monster
				if (monster.isAlive() == false && run == false) {
					System.out.println("You have defeated the " + monster.getName() + "!");
					tempGold = monster.getGold();
					System.out.printf("You have gained %d gold pieces!\n", tempGold);
					player.setGold(tempGold);
				}
				
				// Victory
				if (monster.getName() == "Dragon" && run == false && monster.isAlive() == false) {
					System.out.println(". . . . . . . . . .\nYou have completed your quest!\n");
					monster = new Goblin();
					System.out.println("Goblins defeated: " + monster.getDefeats());
					monster = new Troll();
					System.out.println("Trolls defeated:  " + monster.getDefeats());
					monster = new Dragon();
					System.out.println("Dragons defeated: " + monster.getDefeats());
					System.out.println("Total Gold: " + player.getGold());
					sc.close();
					return;
				}
			} while (monster.isAlive() == true);
		} while (player.isAlive() == true);
		sc.close();
	}
	
	// Randomly generates monster type
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

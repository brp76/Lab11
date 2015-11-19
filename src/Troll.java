
public class Troll extends Monster {
	
	public static int _defeats = 0;

    public Troll() {
    	_hp = 30;
    }
    
    public String getName() {
    	return "Troll";
    }
    
    public int attack(int hit) {
    	_hp -= hit;

    	if (_hp < 0) {
    		_defeats++;
    	}

    	int damage = _rng.nextInt(10) + 1;
    	
		return damage;
    }

}

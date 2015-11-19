
public class Dragon extends Monster {
	
	public static int _defeats = 0;

    public Dragon() {
    	_hp = 100;
    }
    
    public String getName() {
    	return "Dragon";
    }
    
    public int attack(int hit) {
    	_hp -= hit;

    	if (_hp <= 0) {
    		_defeats++;
    	}

    	// Deal 1-20 damage to player
    	int damage = _rng.nextInt(20) + 1;
    	
		return damage;
    }

    public int getDefeats(){
    	return _defeats;
    }
}

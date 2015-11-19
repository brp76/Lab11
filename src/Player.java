import java.util.*;

public class Player {
	
	public int _hp = 100, _mp = 3, _gold = 0;
	
	public boolean status = true;
	
	public Random _rng = new Random();
	
	public int attack(Monster m) {
		int damage = _rng.nextInt(15) + 1;
		return damage;
	}
	
	public int beserk(Monster m) {
		int damage = _rng.nextInt(15) + 1;
		damage *= 3;
		return damage;
	}

	public void setHP(int hit) {
		if (hit == -1) {
			_hp = 100;
			return;
		}
		_hp -= hit;
	}
	
	public void setMP(int mana) {
		_mp -= mana;
	}
	
	public void setGold(int hoard) {
		_gold += hoard;
	}
	
	public boolean isAlive() {
    	if (_hp <= 0) {
    		status = false;
    	} else {
    		status = true;
    	}
    	return status;
    }
	
	public int getHP() {
		return _hp;
	}
	
	public int getMP() {
		return _mp;
	}
	
	public int getGold() {
		return _gold;
	}
}

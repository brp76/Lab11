import java.util.*;

public class Monster {

	public int _hp = 0;
    
    public boolean status = true;

    public Random _rng = new Random();
    
    public Hoard _hoard = new Hoard();
    
    public Monster(){
    }
    
  /*  public Monster getMonster() {
    	return _m;
    }*/
    
    public String getName() {
    	return "Monster";
    }
    
    public int attack(int hit) {
    	return 0;
    }
    
    public boolean isAlive() {
    	if (_hp < 0) {
    		status = false;
    	} else {
    		status = true;
    	}
    	return status;
    }
    
    public int getHP() {
		return _hp;
	}

    public int getGold() {
    	return _hoard.getGold();
    }
}
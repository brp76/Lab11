import java.util.*;

public class Hoard{
	
	private int _gold = 0;
	
	public Hoard(){
		// Generate random gold amount 1-100
		Random _rng = new Random();
		_gold = _rng.nextInt(100) + 1;
	}
	
	public int getGold() {
		return _gold;
	}
}

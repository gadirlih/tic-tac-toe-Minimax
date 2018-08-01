
public class Seed {

	public static Seed NOUGHT = new Seed(0);
	public static Seed CROSS = new Seed(1);
	public static Seed EMPTY = new Seed(2);
	
	public Seed(int num){
		if(num == 1)IS_CROSS = true;
		else if(num == 0)IS_NOUGHT = true;
		else if(num == 2)IS_EMPTY = true;
	}
	private boolean IS_CROSS = false;
	private boolean IS_NOUGHT = false;
	private boolean IS_EMPTY = false;
	
}

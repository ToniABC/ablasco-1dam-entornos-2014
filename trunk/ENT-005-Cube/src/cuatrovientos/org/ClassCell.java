package cuatrovientos.org;

import java.util.Random;

/**
 * CubeProject
 * @author Toni
 *
 */
public class ClassCell {

	private int Damage;
	private char Type;
	private boolean Use;
	
	/**
	 * @return the damage
	 */
	public int getDamage() {
		return Damage;
	}
	/**
	 * @param damage the damage to set
	 */
	public void setDamage(int damage) {
		this.Damage = damage;
	}
	/**
	 * @return the type
	 */
	public char getType() {
		return Type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(char type) {
		this.Type = type;
	}
	/**
	 * @return the use
	 */
	public boolean isUse() {
		return Use;
	}
	/**
	 * @param use the use to set
	 */
	public void setUse(boolean use) {
		this.Use = use;
	}
	
	/**
	 * 
	 */
	public ClassCell(char type, boolean use) {

		Random random = new Random();
		this.Damage = random.nextInt(4);
		this.Type = type;
		this.Use = use;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 
	@Override
	public String toString() {
		return "ClassCell [Damage=" + Damage + ", Type=" + Type + ", Use="
				+ Use + "]";
	}
	*/
	
}

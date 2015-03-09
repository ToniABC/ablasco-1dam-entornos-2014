package cuatrovientos.org;

import java.util.Random;
import java.util.Vector;

/**
 * Cube Project
 * @author Toni
 *
 */
public class ClassPrison {

	private int Size;
	private Vector<ClassCell> VectorSize;
	private int Life;
	private int Position;
	private boolean Die;
	private boolean Escape;
	
	/**
	 * @return the size
	 */
	public int getSize() {
		return Size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.Size = size;
	}
	/**
	 * @return the vectorSize
	 */
	public Vector<ClassCell> getVectorSize() {
		return VectorSize;
	}
	/**
	 * @param vectorSize the vectorSize to set
	 */
	public void setVectorSize(Vector<ClassCell> vectorSize) {
		this.VectorSize = vectorSize;
	}
	/**
	 * @return the life
	 */
	public int getLife() {
		return Life;
	}
	/**
	 * @param life the life to set
	 */
	public void setLife(int life) {
		this.Life = life;
	}
	/**
	 * @return the position
	 */
	public int getPosition() {
		return Position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(int position) {
		this.Position = position;
	}
	/**
	 * @return the die
	 */
	public boolean isDie() {
		return Die;
	}
	/**
	 * @param die the die to set
	 */
	public void setDie(boolean die) {
		this.Die = die;
	}
	/**
	 * @return the escape
	 */
	public boolean isEscape() {
		return Escape;
	}
	/**
	 * @param escape the escape to set
	 */
	public void setEscape(boolean escape) {
		this.Escape = escape;
	}
	
	
	/**
	 * @param vectorSize
	 */
	public ClassPrison(int size) {
		
		this.Size = size;
		this.VectorSize = new Vector<ClassCell> ();
		this.Life = size*3/2;
		this.Die = false;
		this.Escape = false;
		
		cells();

	}
	
	private void cells() {
		
		Random random = new Random();
		int intEnter;
		int intExit;
		
		intEnter = random.nextInt(Size*Size);
		
		do{
			intExit = random.nextInt(Size*Size);
		} while (intEnter==intExit);
		
		for (int i = 0; i < Size*Size; i++) {
			
			if (i == intEnter) {
				Position = i;
				VectorSize.add(new ClassCell('E', true));
			} else {
				if (i == intExit) {
					VectorSize.add(new ClassCell('S', true));
				}
				else {
					VectorSize.add(new ClassCell(' ', false));
				}
			}
			
			// System.out.println(VectorSize.elementAt(i).toString());
		}
	}

	public void movePlayer(String charMove) {
		
		switch (charMove) {
		case "W":
			if (Position/Size != 0) {
				Position = Position - Size;
				move();
			} else {
				System.out.println("(No puedes ir hacia arriba)");
			}

			break;

		case "X":
			if (Position/Size != Size - 1) {
				Position = Position + Size;
				move();
			} else {
				System.out.println("(No puedes ir hacia abajo)");
			}
			
			break;
			
		case "A":
			if (Position%Size != 0) {
				Position = Position - 1;
				move();
			} else {
				System.out.println("(No puedes ir hacia la izquierda)");
			}

			break;
	
		case "D":
			if (Position%Size != Size - 1) {
				Position = Position + 1;
				move();
			} else {
				System.out.println("(No puedes ir hacia la derecha)");
			}
			
			break;
			
		default:
			break;
		}
	}
	
	private void move () {

		if (VectorSize.elementAt(Position).getType() == 'S') {
			
			Escape = true;
			System.out.println("ENHORABUENA, HAS CONSEGUIDO ESCAPAR CON VIDA");
			
		} else {
			
			if (!VectorSize.elementAt(Position).isUse()) {
				
				Life = Life - VectorSize.elementAt(Position).getDamage();
				VectorSize.elementAt(Position).setType((char) ('0' + VectorSize.elementAt(Position).getDamage()));
				VectorSize.elementAt(Position).setUse(true);
				
				if (Life <= 0) {
					System.out.println("VAYA, HAS MUERTO ANTES DE ESCAPAR");
					Die = true;
				} else {
					System.out.println("TE QUEDAN " + Life + " PUNTOS PARA MORIR");
					
					showPrison();
				}
			}
		}
		
	}
	
	public void showPrison() {

		System.out.println();
		
		for (int i = 0; i < Size*Size; i++) {
			if (i%Size == Size-1) {
				System.out.println("[" + VectorSize.elementAt(i).getType() + "]");
			} else {
				System.out.print("[" + VectorSize.elementAt(i).getType() + "]");
			}
		}
	}
}

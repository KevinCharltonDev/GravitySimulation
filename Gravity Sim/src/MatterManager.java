import java.util.ArrayList;

public class MatterManager {

	ArrayList<MassBody> list = new ArrayList<MassBody>();
	private int make;
	final int HALF_WIDTH = 64;
	final int SPACE_BETWEEN = 6;
	double iter = 1;

	public MatterManager() {
		for(int i = 1; i < 2*HALF_WIDTH; i++){
			for (int j = 1; j < 2*HALF_WIDTH; j++){
				make = (int) (Math.random() * 50 + 1);
				if (make > 8){
				list.add(new MassBody((i*Math.sin(iter/7)*SPACE_BETWEEN)+640,(j*Math.cos(iter/7)*SPACE_BETWEEN)+360));
				iter ++;
				
				}
			}
		}
		
	}

	public void determineAllVectors() {
		for (int i = 0; i < list.size(); i++) {
			for (int j = i+1; j < list.size(); j++) {
				list.get(i).calculateAcceleration(list.get(j));
			}
		}
	}

	public void gravitateAll() {
		for (int i = 0; i < list.size(); i++) {
			list.get(i).gravitate();
		}
	}
	public void printAllLocs(){
		for(MassBody m: list){
			int x = (int) m.x;
			int y = (int) m.y;
			System.out.println(x + "," + y);
		}
	}

}

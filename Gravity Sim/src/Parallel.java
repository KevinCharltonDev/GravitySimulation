
public class Parallel implements Runnable{

	
	@Override
	public void run() {
		
	}
	
	public void run(MassBody m, MassBody n){
		m.calculateAcceleration(n);
	}
}


public class MassBody {
	public double x;
	public double y;
	private double deltaX = 0;
	private double deltaY = 0;
	public double dist;
	private final double GRAVITY = .01;

	public MassBody(double xCoord, double yCoord) {
		this.x = xCoord;
		this.y = yCoord;
		double x1 = xCoord-640;
		double y1 = yCoord-360;
		double hyp = Math.sqrt(Math.pow(x1, 2)+Math.pow(y1, 2));
		deltaY +=  .000004*x1*hyp;
		deltaX += -.000004*y1*hyp;
	}

	public void calculateAcceleration(MassBody other) {
		
		double dist = ((this.x-other.x)*(this.x-other.x)+(this.y-other.y)*(this.y-other.y));
		if (dist > 1) {
		double gravDist = GRAVITY/dist;
		dist = Math.sqrt(dist);
		gravDist /= 1;
		double accX = (this.x-other.x) * gravDist;
		double accY = (this.y-other.y) * gravDist;
		applyAcceleration(accX, accY);
		other.applyAcceleration(-accX, -accY);
		}
	}

	private void applyAcceleration(double accX, double accY) {
		deltaX -= accX;
		deltaY -= accY;
		deltaX *= .99999998;
		deltaY *= .99999998;
	}
	
	public void gravitate(){
		x += deltaX;
		y += deltaY;
	}

}

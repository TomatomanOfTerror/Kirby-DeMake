import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 * Rotates out ImageView to use as a character Animation
 * @author Samuel
 *
 */
public class Animator extends ImageView{
	private AnimationTimer time;
	private int count;
	Rectangle target;
	ImageView defaultImg;
	
	/**
	 * Sets up base to bind Animator to and the default image
	 * @param base Rectangle to bind to
	 * @param defaultImg base image to use
	 */
	public Animator(Rectangle base, ImageView defaultImg)
	{
		target = base;
		setImg(defaultImg);
		this.defaultImg = defaultImg;
		idle();
	}
	
	/**
	 * Runs a sequence passed in.
	 * @param sequence Sequence to use for animation
	 */
	public void play(Sequence sequence) {
		count = 0;
		run(sequence);
	}
	
	/**
	 * Stops animation, reverts to default image
	 */
	public void stop() {
		if(time!=null) {
			idle();
			count = 0;
			setImg(defaultImg);
		}
	}
	
	/**
	 * Keeps ImageView bound to Rectangle location
	 */
	private void updatePos() {
		this.setTranslateX(target.getTranslateX());
		this.setTranslateY(target.getTranslateY());
	}
	
	/**
	 * Alters timer so it is only updating position
	 */
	private void idle() {
		if(time != null) {
			time.stop();
		}
		time = new AnimationTimer() {
			public void handle(long l) {
				updatePos();
			}
		};
		time.start();
	}
	
	/**
	 * Alters timer to run sequence and update position
	 * @param s sequence to update
	 */
	private void run(Sequence s) {
		if(time != null) {
			time.stop();
		}
		time = new AnimationTimer() {
			public void handle(long l) {
				setImg(s.getImg());
				if(count == 60/s.getSize()) {
					count = 0;
					s.next();	
				}
				count++;
				updatePos();
			}
		};
		time.start();
	}
	
	/**
	 * Sets the Animator image
	 * @param x new Image for animator
	 */
	private void setImg(ImageView x) {
		this.setImage(x.getImage());
	}
}


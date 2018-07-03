import javafx.scene.image.ImageView;


/**
 * Support class for Animator, which stores ImageViews to call for animation
 * and facilitates rotating through the animation
 * @author Samuel
 *
 */
public class Sequence {
	private ImageView[] animation;
	private ImageView current;
	private int count;
	
	/**
	 * Builds array with images and starts on first ImageView passed in
	 * @param images list of images passed in
	 */
	public Sequence(ImageView... images)
	{
		animation = images;
		count = 0;
		current = animation[count];
	}
	/**
	 * changes current image to next image in sequence
	 */
	public void next(){
		count++;
		if(count == animation.length)
		{
			count = 0;
		}
		current = animation[count];
	}
	
	public ImageView getImg() {
		return current;
	}
	public int getSize() {
		return animation.length;
	}
}

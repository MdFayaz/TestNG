package examples.practise;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageUtils {
	

	public void resizeImage(BufferedImage image, int type, Rectangle rect){
		Graphics2D graphs = new BufferedImage(rect.width, rect.height, type).createGraphics();
		
		graphs.drawImage(image, 0, 0, rect.width, rect.height, null);
		graphs.dispose();
		
	}
	
	private BufferedImage getBufferedImage(){
		BufferedImage image = null;
		try {
			Robot robot = new Robot();
			Rectangle rect = getRequiredArea();
			image = robot.createScreenCapture(rect);
			IMG_PATH += "resized_screenshot.jpg";
			resizeImage(image, BufferedImage.TYPE_INT_ARGB, rect);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	private Rectangle getRequiredArea(){
		int titleBarHeight = 25;
		
		Dimension screenDimension = getToolkit().getScreenSize();
		Rectangle winRect = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		
		Rectangle rect = new Rectangle(0, titleBarHeight, screenDimension.width, winRect.height - titleBarHeight);
		System.out.println("Rectangle r: " + rect);
		return rect;
	}
	
	private Toolkit getToolkit(){
		return Toolkit.getDefaultToolkit();
	}
	
	public void takeScreenshot() {
		BufferedImage image = null;
		try {
			image = getBufferedImage();
			ImageIO.write(image, "png", new File(IMG_PATH));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ImageUtils iu = new ImageUtils();
		iu.takeScreenshot();
	}
	
	private String IMG_PATH = "C:\\Users\\Fayaz\\Pictures\\";
	
}

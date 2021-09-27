package Model;

import java.net.URL;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Jet {
	
	private Double posX;
	private Double posY;
	
	private ImageView imageJet;
	
	public Jet(Double x, Double y) {
		posX = x;
		posY = y;
		
        URL imageJeturl = getClass().getResource("../Images/jet.png");
        imageJet = new ImageView(new Image(imageJeturl.toExternalForm()));
        
        imageJet.setLayoutX(x);
        imageJet.setLayoutY(y);

	}

	public Double getPosX() {
		return posX;
	}

	public void setPosX(Double posX) {
		this.posX = posX;
        imageJet.setLayoutX(this.posX);
	}

	public Double getPosY() {
		return posY;
	}

	public void setPosY(Double posY) {
		this.posY = posY;
        imageJet.setLayoutY(this.posY);
	}

	public ImageView getImageJet() {
		return imageJet;
	}

	public void setImageJet(ImageView imageJet) {
		this.imageJet = imageJet;
	}

}

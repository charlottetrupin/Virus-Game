package Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class Player {

    ///////////////////// CONSTANTS /////////////////////////
    public static final int totalLife = 3;
    public static final int totalMunition = 10;

    ///////////////////// ATTRIBUTES /////////////////////////

    /* position of the left up corner
     * that defines the position of the virus */
    private Double posX;
    private Double posY;

    /* images of the player */
    ImageView imageView;
    Image imagePlayer;
    Image imageG;
    Image imageD;
    Image imageShoot;

    /* jets that are displayed on the window */
    private ListJet listJet;

    /* number of jet the player has */
    private int availableJet;

    /* number of life the player has */
    private int life;



    ///////////////////// CONSTRUCTOR ///////////////////////
    public Player(ImageView i){
        this.posX = i.getLayoutX();
        this.posY = i.getLayoutY();

        this.imageView = i;
        this.imagePlayer = i.getImage();
        this.imageG = i.getImage();
        URL imageDUrl = getClass().getResource("../Images/playerD.png");
        this.imageD = new Image(imageDUrl.toExternalForm());
        URL imageShootUrl = getClass().getResource("../Images/playerShooting.png");
        this.imageShoot = new Image(imageShootUrl.toExternalForm());

        this.listJet = new ListJet();
        this.availableJet = totalMunition;
        this.life = totalLife;
    }


    ///////////////////// METHODS ///////////////////////
    public Double getPosY() {  return posY; }

    public Double getPosX() { return posX; }
    public void setPosX(Double posX) {
        this.posX = posX;
        this.imageView.setLayoutX(posX);
    }

    public int getLife() { return life; }
    public void setLife(int life) { this.life = life; }

    public Image getImageD() { return imageD; }
    public Image getImageG() { return imageG; }
    public Image getImageShoot() { return imageShoot; }

    public Image getImagePlayer() { return imagePlayer; }
    public void setImagePlayer(Image imagePlayer) {
        this.imageView.setImage(imagePlayer);
        this.imagePlayer = imagePlayer;
    }

    public ImageView getImageViewPlayer(){ return this.imageView; }

    public ListJet getListJet() { return listJet; }

    public int getAvailableJet() { return availableJet; }
    public void setAvailableJet(int jetOnHand) { this.availableJet = jetOnHand; }


}

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {

    BufferedImage starImage;
    BufferedImage enemyImage;
    BufferedImage playerImage;

    //BackBuffered
    BufferedImage backBuffered;
    Graphics graphics;

    public int positionXStar = 1024;
    int positionYStar = 200;

    public int positionXPlayer = 512;
    public int positionYPlayer = 300;

    public int positionXEnemy = 100;
    public int positionYEnemy = 200;

    public int speedXEnemy = 2;
    public int speedYEnemy = 2;


    public GameCanvas() {
        this.setSize(1024, 600);

        this.setupBackBuffered();

        this.setupCharacter();

        this.setVisible(true);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupCharacter() {
        this.starImage = this.loadImage("resources/images/star.png");
        this.enemyImage = this.loadImage("resources/images/circle.png");
        this.playerImage = this.loadImage("resources/images/circle.png");
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        this.graphics.setColor(Color.BLACK);
        this.graphics.fillRect(0, 0, 1024, 600);

        this.graphics.drawImage(this.starImage, this.positionXStar, this.positionYStar, 5, 5, null);

        this.graphics.drawImage(this.enemyImage, this.positionXEnemy, this.positionYEnemy, 20, 20, null);

        this.graphics.drawImage(this.playerImage, this.positionXPlayer, this.positionYPlayer, 20, 20, null);

        this.repaint();
    }

    public void runAll() {
        this.positionXStar -= 3;
        this.runEnemy();
    }

    private void runEnemy() {
        this.positionXEnemy += this.speedXEnemy;
        this.positionYEnemy += this.speedYEnemy;

        if (this.positionXEnemy < 0 || this.positionXEnemy > 1024 - 20)
            this.speedXEnemy = -this.speedXEnemy;

        if (this.positionYEnemy < 0 || this.positionYEnemy > 600 - 20)
            this.speedYEnemy = -this.speedYEnemy;
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }
}

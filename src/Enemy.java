import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy {

    public int x;
    public int y;
    public BufferedImage image;
    public int velocityX;
    public int velocityY;

    public Enemy(int x, int y, BufferedImage image, int velocityX, int velocityY) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public Enemy() {

    }

    public void run() {
        this.x += this.velocityX;
        this.y += this.velocityY;
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, this.x, this.y, 5, 5, null);
    }
}

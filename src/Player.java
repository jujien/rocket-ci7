import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
    public int x;
    public int y;
    public BufferedImage image;

    public Player(int x, int y, BufferedImage image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, this.x, this.y, 5, 5, null);
    }
}

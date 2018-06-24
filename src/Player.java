import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
    public Vector2D position;
    public BufferedImage image;

    public Player() {
        this.position = new Vector2D();
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, (int)this.position.x, (int)this.position.y, 20, 20, null);
    }
}

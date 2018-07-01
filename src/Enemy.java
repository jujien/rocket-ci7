import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Enemy {

    public Vector2D position;
    public BufferedImage image;
    public Vector2D velocity;
    private List<BulletEnemy> bulletEnemies;
    private int count = 0;

    public Enemy() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.bulletEnemies = new ArrayList<>();
    }

    public void run() {
        this.position.addUp(this.velocity);
        if (this.count == 30) {
            for (double angle = 0.0; angle < 360.0; angle += 360.0 / 10.0) {
                BulletEnemy bulletEnemy = new BulletEnemy();
                bulletEnemy.position.set(this.position);
                bulletEnemy.velocity.set(
                        (new Vector2D(3.0f, 0.0f)).rotate(angle)
                );
                this.bulletEnemies.add(bulletEnemy);
            }
            this.count = 0;
        } else {
            this.count += 1;
        }

        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());

    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, (int)this.position.x, (int)this.position.y, 20, 20, null);
        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
    }
}

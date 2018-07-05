import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Enemy extends GameObject {

    public Vector2D velocity;
    private List<BulletEnemy> bulletEnemies;
    private int count = 0;

    public Enemy() {
        this.velocity = new Vector2D();
        this.bulletEnemies = new ArrayList<>();
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20);
    }

    @Override
    public void run() {
        super.run();

//        if (this.count == 30) {
//            for (double angle = 0.0; angle < 360.0; angle += 360.0 / 10.0) {
//                BulletEnemy bulletEnemy = new BulletEnemy();
//                bulletEnemy.position.set(this.position);
//                bulletEnemy.velocity.set(
//                        (new Vector2D(3.0f, 0.0f)).rotate(angle)
//                );
//                this.bulletEnemies.add(bulletEnemy);
//            }
//            this.count = 0;
//        } else {
//            this.count += 1;
//        }
        Player player = GameObjectManager.instance.findPlayer();
        if (player != null) {
            Vector2D velocity = player.position
                    .subtract(this.position)
                    .normalize()
                    .multiply(1.5f);
            this.velocity.set(velocity);
        }
        this.position.addUp(this.velocity);
        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());

    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
    }
}

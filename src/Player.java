import java.awt.*;

public class Player {
    public Vector2D position;
    public Vector2D velocity;
    public double angle = 0.0;
    public Renderer renderer;

    public Player() {
        this.position = new Vector2D();
        this.renderer = new PolygonRenderer(
                Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.velocity = new Vector2D(3.5f, 0);
    }

    public void run() {
        this.position.addUp(this.velocity);
        ((PolygonRenderer) this.renderer).angle = this.angle;
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }
}

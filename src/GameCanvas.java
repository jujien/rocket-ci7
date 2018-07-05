import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class GameCanvas extends JPanel {

    BufferedImage backBuffered;
    Graphics graphics;
    Background background;

    public Player player = new Player();
    public Enemy enemy = new Enemy();
    private CreateStar createStar = new CreateStar();


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
        this.background = new Background();
        this.setupPlayer();
        this.setupEnemy();
    }

    private void setupPlayer() {
        this.player.position.set(100, 200);
    }

    private void setupEnemy() {
        this.enemy.position.set(800, 400);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        this.background.render(this.graphics);
        this.player.render(this.graphics);
        this.enemy.render(this.graphics);
        this.createStar.render(this.graphics);
        this.repaint();
    }

    public void runAll() {
        this.runEnemy();
        this.player.run();
        this.createStar.run();
    }

    private void runEnemy() {
        Vector2D velocity = this.player.position
                .subtract(this.enemy.position)
                .normalize()
                .multiply(1.5f);
        this.enemy.velocity.set(velocity);
        this.enemy.run();
    }
}

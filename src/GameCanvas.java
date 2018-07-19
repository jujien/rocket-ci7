import base.GameObject;
import base.GameObjectManager;
import game.background.Background;
import game.enemy.CreateEnemy;
import game.enemy.Enemy;
import game.star.CreateStar;
import game.player.Player;
import scene.GamePlayScene;
import scene.SceneManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {

    BufferedImage backBuffered;
    Graphics graphics;

    public GameCanvas() {

        this.setSize(1024, 600);

        this.setupBackBuffered();

        this.setVisible(true);

        SceneManager.instance.changeScene(new GamePlayScene());
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        GameObjectManager.instance.renderAll(this.graphics);
        this.repaint();
    }

    public void runAll() {
        GameObjectManager.instance.runAll();
        SceneManager.instance.performChangeSceneIfNeeded();
    }

}

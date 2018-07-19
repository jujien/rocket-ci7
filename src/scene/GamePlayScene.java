package scene;

import base.GameObjectManager;
import game.background.Background;
import game.enemy.CreateEnemy;
import game.player.Player;
import game.star.CreateStar;

public class GamePlayScene implements Scene {
    @Override
    public void init() {
        this.setupCharacter();
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }

    private void setupCharacter() {
        GameObjectManager.instance.add(new Background());
        //GameObjectManager.instance.add(new CreateStar());
        CreateStar createStar = GameObjectManager.instance.recycle(CreateStar.class);
        createStar.configAction();
        //GameObjectManager.instance.add(new Enemy());
        CreateEnemy createEnemy = GameObjectManager.instance.recycle(CreateEnemy.class);
        createEnemy.configAction();
        this.setupPlayer();

    }

    private void setupPlayer() {
        Player player = new Player();
        player.position.set(100, 200);
        GameObjectManager.instance.add(player);
    }
}

package game.player;

import base.FrameCounter;
import base.GameObjectAttributes;
import base.GameObjectManager;

public class PlayerShoot implements GameObjectAttributes<Player> {

    private FrameCounter frameCounter;


    public PlayerShoot() {
        this.frameCounter = new FrameCounter(30);
    }

    @Override
    public void run(Player gameObject) {
        if (this.frameCounter.run()) {
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(gameObject.position);
            bulletPlayer.velocity.set(gameObject.velocity.copy().multiply(1.5f));
            GameObjectManager.instance.add(bulletPlayer);
            this.frameCounter.reset();
        }
    }
}

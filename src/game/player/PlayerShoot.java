package game.player;

import base.FrameCounter;
import base.GameObjectAttributes;
import base.GameObjectManager;
import input.KeyboardInput;

public class PlayerShoot implements GameObjectAttributes<Player> {

    private FrameCounter frameCounter;

    public ShootState shootState = ShootState.single;

    public PlayerShoot() {
        this.frameCounter = new FrameCounter(30);
    }

    @Override
    public void run(Player gameObject) {
        if (KeyboardInput.instance.isSpace)
            switch (this.shootState) {
                case single:

                    break;
                case triple:
                    break;
            }
            if (this.frameCounter.run()) {
                BulletPlayer bulletPlayer = new BulletPlayer();
                bulletPlayer.position.set(gameObject.position);
                bulletPlayer.velocity.set(gameObject.velocity.copy().multiply(1.5f));
                GameObjectManager.instance.add(bulletPlayer);
                this.frameCounter.reset();
            }
    }
}

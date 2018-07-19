package game.player;

import base.FrameCounter;
import base.GameObjectAttributes;
import base.GameObjectManager;
import input.KeyboardInput;
import utils.Utils;

import javax.sound.sampled.Clip;

public class PlayerShoot implements GameObjectAttributes<Player> {

    private FrameCounter frameCounter;

    public ShootState shootState = ShootState.single;

    private Clip clip;

    public PlayerShoot() {
        this.frameCounter = new FrameCounter(30);
        this.clip = Utils.loadAudio("resources/audio/shot.wav");
    }

    @Override
    public void run(Player gameObject) {
        if (KeyboardInput.instance.isSpace)
            if (this.frameCounter.run()) {
                BulletPlayer bulletPlayer = GameObjectManager.instance.recycle(BulletPlayer.class);
                bulletPlayer.position.set(gameObject.position);
                bulletPlayer.velocity.set(gameObject.velocity.copy().multiply(1.5f));
                this.frameCounter.reset();

                this.clip.loop(1);
                this.clip.start();
            }
    }
}

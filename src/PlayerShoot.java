import java.util.ArrayList;
import java.util.List;

public class PlayerShoot implements PlayerAttack {

    private FrameCounter frameCounter;


    public PlayerShoot() {
        this.frameCounter = new FrameCounter(30);
    }

    @Override
    public void run(Player player) {
        if (this.frameCounter.run()) {
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(player.position);
            bulletPlayer.velocity.set(player.velocity.copy().multiply(1.5f));;
            this.frameCounter.reset();
        }
    }
}

import java.util.ArrayList;
import java.util.List;

public class PlayerShoot implements PlayerAttack {

    public List<BulletPlayer> bulletPlayers;
    private FrameCounter frameCounter;


    public PlayerShoot() {
        this.bulletPlayers = new ArrayList<>();
        this.frameCounter = new FrameCounter(30);
    }

    @Override
    public void run(Player player) {
        if (this.frameCounter.run()) {
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(player.position);
            bulletPlayer.velocity.set(player.velocity.copy().multiply(1.5f));
            this.bulletPlayers.add(bulletPlayer);
            this.frameCounter.reset();
        }
        this.bulletPlayers.forEach(bulletPlayer ->  bulletPlayer.run());

    }
}

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateStar extends GameObject {

    private FrameCounter frameCounter;
    private Random random;
    private List<Star> stars;

    public CreateStar() {
        this.frameCounter = new FrameCounter(30);
        this.random = new Random();
        this.stars = new ArrayList<>();
    }

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            Star star = new Star();
            star.position.set(1024, this.random.nextInt(600));
            star.velocity.set(-(this.random.nextInt(3) + 1), 0);
            this.stars.add(star);

            this.frameCounter.reset();
        }

        this.stars.forEach(star -> star.run());
    }

    @Override
    public void render(Graphics graphics) {
        this.stars.forEach(star -> star.render(graphics));
    }
}

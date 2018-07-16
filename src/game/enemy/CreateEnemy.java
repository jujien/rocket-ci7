package game.enemy;

import action.*;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class CreateEnemy extends GameObject {

    private Random random = new Random();

    public CreateEnemy() {
    }

    public void configAction() {
        //cach 1:
//        WaitAction waitAction = new WaitAction(40);
//        Action create = new ActionAdapter() {
//            @Override
//            public boolean run(GameObject owner) {
//                Enemy enemy = GameObjectManager.instance.recycle(Enemy.class);
//                enemy.position.set(random.nextInt(1024), random.nextInt(600));
//                return true;
//            }
//        };
//
//        SequenceAction sequenceAction = new SequenceAction(waitAction, create);
//        RepeatActionForever repeatActionForever = new RepeatActionForever(sequenceAction);
//
//        this.addAction(repeatActionForever);

        // cach 2:
        this.addAction(
                new RepeatActionForever(
                        new SequenceAction(
                                new WaitAction(40),
                                new ActionAdapter() {
                                    @Override
                                    public boolean run(GameObject owner) {
                                        Enemy enemy = GameObjectManager.instance.recycle(Enemy.class);
                                        enemy.position.set(random.nextInt(1024), random.nextInt(600));
                                        return true;
                                    }
                                }
                        )
                )
        );
    }
}

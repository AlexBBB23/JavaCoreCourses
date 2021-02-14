package gb.bocharov.lesson21.obstacles;

import gb.bocharov.lesson21.Competitors.Competitor;
import gb.bocharov.lesson21.obstacles.Obstacle;

public class Water extends Obstacle {
    private int distance;

    public Water(int distance) {
        this.distance = distance;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.swim(distance);
    }
}
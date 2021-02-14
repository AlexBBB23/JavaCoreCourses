package gb.bocharov.lesson21.obstacles;

import gb.bocharov.lesson21.Competitors.Competitor;
import gb.bocharov.lesson21.obstacles.Obstacle;

public class Wall extends Obstacle {
        private int height;

        public Wall(int height) {
            this.height = height;
        }

        @Override
        public void doIt(Competitor competitor) {
            competitor.jump(height);
        }
    }


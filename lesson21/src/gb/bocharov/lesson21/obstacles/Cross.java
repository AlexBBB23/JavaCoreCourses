package gb.bocharov.lesson21.obstacles;

import gb.bocharov.lesson21.Competitors.Competitor;

public class Cross extends Obstacle {
        private int distance;

        public Cross(int distance) {
            this.distance = distance;
        }

        @Override
        public void doIt(Competitor competitor) {
            competitor.run(distance);
        }
    }


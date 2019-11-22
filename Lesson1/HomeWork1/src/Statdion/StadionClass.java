package Statdion;

import Competitors.CompetitionClass;
import Obstacle.ObstacleClass;
import Obstacle.ObstacleType;

public class StadionClass {

    ObstacleClass[] obstacles=null;

    public StadionClass(ObstacleClass[] obstacles) {
        this.obstacles = obstacles;
    }


    public void  startCompetition(CompetitionClass competitor){

        if ((obstacles == null) || (competitor == null)) {
            System.out.println("Error, objects are not ready.");
            return ;
        }

        for (ObstacleClass o : obstacles) {
            ObstacleType obstacleType = o.getObstacleType();
            int obstacleValue = o.getObstacleValue();
            int competitorValue = (obstacleType == ObstacleType.WALL) ? competitor.getMaxHeight() : competitor.getMaxDistance();

            if (o.getObstacleType() == ObstacleType.WALL) competitor.jump();
            else competitor.run();

            boolean result = competitorValue >= obstacleValue;

            System.out.println("The result is " + (result ? "OK!" : "FAIL!"));
            if (! result) break;
        }

    }
}

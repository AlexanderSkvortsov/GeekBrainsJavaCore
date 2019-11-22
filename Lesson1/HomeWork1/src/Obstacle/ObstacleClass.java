package Obstacle;

public class ObstacleClass {
    private int obstacleValue;
    private ObstacleType obstacleType =  ObstacleType.UNDEFINED;

    public ObstacleClass(int value, ObstacleType obstacleType) {
        this.obstacleValue = value;
        this.obstacleType  = obstacleType;
    }

    public int getObstacleValue() {
        return obstacleValue;
    }

    public ObstacleType getObstacleType() {
        return obstacleType ;
    }

}

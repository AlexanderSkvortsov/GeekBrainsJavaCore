import Competitors.CatClass;
import Competitors.CompetitionClass;
import Competitors.HumanClass;
import Competitors.RobotClass;
import Obstacle.ObstacleClass;
import Obstacle.RaceTrackClass;
import Obstacle.WallClass;
import Statdion.StadionClass;

public class MainClass {
    public static void main(String[] args) {

        ObstacleClass []  obstacles= {new RaceTrackClass(3000), new WallClass(2000) };

        CompetitionClass [] competitors = { new HumanClass("Иван",3000,500),
                                            new RobotClass("Вертер",30000,1000),
                                            new CatClass("Мурзик",5000,2000)
                                          };

        StadionClass stadion = new StadionClass(obstacles);

        for (CompetitionClass c: competitors) {

                stadion.startCompetition(c);

        }

    }
}

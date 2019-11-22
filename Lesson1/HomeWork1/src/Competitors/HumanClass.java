package Competitors;

public class HumanClass implements CompetitionClass {
    private String name;
    private int maxDistance;
    private int maxHeight;
    private CompetitorType competitorType =  CompetitorType.HUMAN;

    public HumanClass(String name, int maxDistance, int maxHeight) {
        this.name = name;
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
    }

    public String getName() {
        return name;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public CompetitorType getCompetitorType() {
        return competitorType;
    }

    @Override
    public void jump() {
        System.out.println(competitorType + " " +name + " is jump");
    }

    @Override
    public void run() {
        System.out.println(competitorType + " " +name +" is run");
    }

}

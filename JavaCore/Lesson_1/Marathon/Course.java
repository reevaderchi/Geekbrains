package Lesson_1.Marathon;

public class Course {

    Obstacle[] obstacles = {new Cross(80), new Wall(2), new Water(10)};

    public void doIt(Team team) {
        for (Competitor c : team.competitors) {
            for (int i = 0; i < obstacles.length; i++) {
                obstacles[i].doIt(c);
                if (!c.isOnDistance()) break;
            }
        }
    }

}

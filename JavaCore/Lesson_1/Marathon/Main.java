package Lesson_1.Marathon;

public class Main {
    public static void main(String[] args) {

        Team team = new Team("one");

        Course course = new Course();

        course.doIt(team);

        team.showResults();

        team.generalTeamInfo();

    }
}
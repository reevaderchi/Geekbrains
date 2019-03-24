package Lesson_1.Marathon;

public class Team {
    String teamName;

    Competitor[] competitors =  {new Human("Боб"), new Cat("Барсик"), new Dog("Бобик"), new Hamster ("Хамстер")};

    public Team (String teamName) {

        this.teamName = teamName;

    }

    public void generalTeamInfo() {

        for (Competitor c: competitors) {c.info();}
    }


    public void showResults() {
        for (Competitor c: competitors) {
            if (c.isOnDistance()) {
               c.winnersInfo();
            }

        }
    }

}

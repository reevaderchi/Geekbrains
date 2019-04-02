package Lesson_1.Marathon;

import Lesson_1.Marathon.Competitor.*;
import Lesson_1.Marathon.Obstacle.Course;
import Lesson_1.Marathon.Obstacle.Cross;
import Lesson_1.Marathon.Obstacle.Obstacle;
import Lesson_1.Marathon.Obstacle.Wall;

public class Main {
    public static void main(String[] args) {
        Team team = new Team("Rocket", new Human("Bob"), new Cat("Vaska"), new Dog("Bobik"));
        Course course = new Course(new Cross(80), new Wall(2), new Wall(1), new Cross(120));
        course.doIt(team);
        team.showWinners();
    }
}




//public class Team {
//    String teamName;
//
//    Competitor[] competitors =  {new Human("Боб"), new Cat("Барсик"), new Dog("Бобик"), new Hamster ("Хамстер")};
//
//    public Team (String teamName) {
//
//        this.teamName = teamName;
//
//    }




//public class Team {
//    private String nameTeam = "unknown";
//    Human[] athletes = {new Man("Михаил"), new Woman("Жанна"), new Kid("Женя")};
//    public Human[] teamHuman = new Human[4];
//    Random random = new Random();
//
//    // Формируем команду
//    public Team(String nameTeam) {
//        this.nameTeam = nameTeam;
//        for (int i = 0; i < 4; i++) {
//            int ran = random.nextInt(3);
//            teamHuman[i] = athletes[ran];
//        }
//    }
//
//    // Вывод информации о членах команды
//    public void showTheTeam() {
//        System.out.println("Team: " + nameTeam);
//        for (Human a : teamHuman) {
//            System.out.println(a);
//            System.out.println("Лимит дистанции кросса: " + a.run_limit);
//            if (a instanceof Swimable)
//                System.out.println("Лимит дистанции водоема: " + ((Swimable) a).getSwimLimit());
//            if (a instanceof Jumpable)
//                System.out.println("Лимит высоты прыжка: " + ((Jumpable) a).getJumpLimit());
//        }
//        System.out.println();
//    }



//
//public class Team {
//
//    private String teamName;
//    private Competitor[] competitors;
//
//    public Team(String teamName, Human bruce, Cat oskar, Dog bond, Cat silvester){
//        this.teamName = teamName;
//        this.competitors = competitors;
//    }
//
////Competitor[] competitors = {new Human("Mark"), new Cat("May"), new Dog("Gav")};






//
//    char[] sst = str.toCharArray();
//        for(char c : sst) switch(c) {
//                // Латиница
//                case 'e' :
//                vowels++;
//                break;
//                case 'u' :
//                vowels++;
//                break;
//                case 'i' :
//                vowels++;
//                break;
//                case 'o' :
//                vowels++;
//                break;
//                case 'a' :
//                vowels++;
//                break;
//                // Кирилица
//                case 'у' :
//                vowels++;
//                break;
//                case 'е' :
//                vowels++;
//                break;
//                case 'ы' :
//                vowels++;
//                break;
//                case 'а' :
//                vowels++;
//                break;
//                case 'о' :
//                vowels++;
//                break;
//                case 'я' :
//                vowels++;
//                break;
//                case 'и' :
//                vowels++;
//                break;
//                case 'ю' :
//                vowels++;
//                break;
//                }
//                return vowels;
//
//
////////////
//
//
//
//
//
//public Team () {
//        this.members = new Competitor[] {
//        new Human("Боб"), new Cat("Барсик"),
//        new Dog("Бобик"), new Dog("Шарик",500, 5, 100),
//
//        };
//        }
//
//
//
//
//        Sportler[] groupOne = {new Sportler("ИГОРЬ",37, 13.5f), new Sportler("ИГОРЬ",37, 13.5f)}
//        groupOne[0] = new Sportler("ИГОРЬ",37, 13.5f);
//        groupOne[1] = new Sportler("ЛЕВА",25, 10.5f);
//        groupOne[2] = new Sportler("ЛЕНЯ",33, 12f);
//        groupOne[3] = new Sportler("КАЧОК",27, 14.2f);
//
//
//
//////////
//
//
//public Team(Competitor[] team) {
//        this.team = team;
//        }
//
//
////////////////
//
//
//
//public Team(String t1, Competitor p1, Competitor p2, Competitor p3, Competitor p4){
//        teamName = t1;
//        player[0] = p1;
//        player[1] = p2;
//        player[2] = p3;
//        player[3] = p4;
//        }
//
//        //////////
//
//
//        Competitor[] competitors;
//public Team(String HumanName, String CatName, String DogName){
//        Competitor[] _competitors = {new Human(HumanName), new Cat(CatName), new Dog(DogName)};
//        competitors = _competitors;
//        }
//

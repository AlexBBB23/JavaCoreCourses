package gb.bocharov.lesson21;
import gb.bocharov.lesson21.Competitors.*;
import gb.bocharov.lesson21.obstacles.*;

public class MainApp {
    public static void main(String[] args) {

        Competitor[] competitors = {new Human("Steve"), new Cat("Barsik"), new Dog("Bobik")};
        Obstacle[] obstacles = {new Cross(400), new Wall(2), new Water(1)};

        Team team = new Team("Apple", competitors);

        System.out.println("============created new team============");
        System.out.println(team.getTeamName());

        System.out.println("============greeting team members============");
        team.showResults();

        // new Course
        Course course = new Course(obstacles);

        System.out.println("============team goes to course============");
        course.doIt(team);

        System.out.println("============show team Results============");
        team.showResults();

        System.out.println("============team members finished course============");
        team.showMembersFinishedCourse();
    }
}
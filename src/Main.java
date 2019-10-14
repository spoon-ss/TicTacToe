import com.controlers.GameStarter;

public class Main {

    public static void main(String[] args) {
	// write your code here
        GameStarter gameStart = new GameStarter();
        gameStart.playWithOneAIAndOneHuman(6,6,3,"p1", "p2");
        gameStart.play();
        System.out.println(gameStart.getResult());
    }
}

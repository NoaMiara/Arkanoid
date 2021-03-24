

import biuoop.GUI;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Ass 6 game.
 */
public class Ass6Game {
    /**
     * The entry point of application.
     *
     * @param args the input arguments.
     */
    public static void main(String[] args) {
        GameFlow gameFlow = new GameFlow(new AnimationRunner(new GUI("Arkanoid", 800, 600)));
        List<LevelInformation> levelInformations = new ArrayList<>();
        DirectHit directHit = new DirectHit();
        WideEasy wideEasy = new WideEasy();
        Green3 green3 = new Green3();
        FinalFour finalFour = new FinalFour();
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("1")) {
                levelInformations.add(directHit);
            }
            if (args[i].equals("2")) {
                levelInformations.add(wideEasy);
            }
            if (args[i].equals("3")) {
                levelInformations.add(green3);
            }
            if (args[i].equals("4")) {
                levelInformations.add(finalFour);
            }
        }
        if (levelInformations.size() == 0) {
            levelInformations.add(directHit);
            levelInformations.add(wideEasy);
            levelInformations.add(green3);
            levelInformations.add(finalFour);
        }
        gameFlow.runLevels(levelInformations);
    }
}

package services;

import utils.InputUtil;
import utils.MenuUtil;

import java.util.InputMismatchException;

public class ManagmentService {

    private GameService gameService;

    public ManagmentService() {
        gameService = new GameService();
    }

    public void manage() {


        while (true) {
            int options =0;
            try {
                 options = MenuUtil.showMenu();
            }catch (InputMismatchException exception){
                System.out.println("Wrong input");
                continue;
            }

            switch (options) {

                case 1:
                    gameService.start();
                    break;
                case 2:
                    gameService.addWord();
                    break;
                case 3:
                    gameService.seeHistory();
                    break;
                case 0:
                    System.out.println("BYE BYE \uD83D\uDD90");
                    System.exit(0);
            }
        }
    }
}

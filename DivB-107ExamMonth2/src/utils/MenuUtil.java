package utils;

import enums.Menu;

public class MenuUtil {

    public static int showMenu(){
        System.out.println(" ================Translator App=====================\n" +
                        Menu.START.getPrintMenu() +
                Menu.ADD_WORD.getPrintMenu() +
                Menu.SEE_HISTORY.getPrintMenu() +
                Menu.EXIT.getPrintMenu() +
                "  ==================================================\n");

        return InputUtil.Inputint("Choose options: ");
    }
}

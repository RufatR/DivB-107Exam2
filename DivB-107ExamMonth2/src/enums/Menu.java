package enums;

public enum Menu {
    START("[1].Start\n"),
    ADD_WORD("[2].Add Word\n"),
    SEE_HISTORY("[3].See History\n"),
    EXIT("[0].Exit!\n");

    private String printMenu;

    Menu(String printMenu){
        this.printMenu = printMenu;
    }

    public String getPrintMenu() {
        return printMenu;
    }
}

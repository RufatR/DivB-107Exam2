package enums;

public enum Exception {
    ILLEGAL_CHARACTER_EXCEPTION("Yanlis simvol daxil edildi!"),
    ILLEGAL_POINT_EXCEPTION("Point menfi deyer ala bilmez!");


    private String message ;

    Exception(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

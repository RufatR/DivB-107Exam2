package enums;

public class AppException extends IllegalArgumentException{

    public AppException(Exception exception){
        super(exception.getMessage());
    }

}

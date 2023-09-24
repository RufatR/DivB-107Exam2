import services.GameService;
import services.ManagmentService;
import utils.MenuUtil;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Main {
    public static void main(String[] args) {
        new ManagmentService().manage();

    }
}
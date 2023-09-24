package services;

import enums.AppException;
import enums.Exception;
import files.GlobalFilePath;
import models.Words;
import services.interfaces.FileServiceInt;
import services.interfaces.GameServiceInt;
import utils.InputUtil;
import utils.RandomUtil;

import java.io.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GameService implements GameServiceInt {
    private FileService fileService;

    public GameService() {
        fileService = new FileService();
    }

    @Override
    public void start() {
        Words[] words = fileService.readFile();
        int point = 0;
        int sehvSayi = 0;


        LocalDateTime startTIme = LocalDateTime.now();
        for (int i = 0; i < 10; i++) {

            Words word = words[RandomUtil.randomIndex(words.length)];

            String az = InputUtil.InputString(word.getEng() + "::::");

            if (word.getAz().equals(az)) {
                point++;
            } else {
                sehvSayi++;
            }
            if (sehvSayi == 3) {
                point = point - sehvSayi;
                sehvSayi = 0;
            }
        }
        LocalDateTime endTime = LocalDateTime.now();

        Duration duration = Duration.between(startTIme, endTime);
        long seconds = duration.getSeconds();


        System.out.println("++++++++++++End+++++++++++");
        try {
            if (point < 0) {
                throw new AppException(Exception.ILLEGAL_POINT_EXCEPTION);
            }
            System.out.println("Your point is: " + point);
            switch (point) {
                case 0:case 1:case 2:System.out.println("Your english level is: A0");
                    break;
                case 3:case 4:System.out.println("Your english level is A1");
                    break;
                case 5:case 6:System.out.println("Your english level is B1");
                    break;
                case 7:case 8:System.out.println("Your english level is C1");
                    break;
                case 9:case 10:System.out.println("Your english level is C2");
                    break;
            }
            gameLog(point, seconds);
        } catch (AppException exception) {
            System.out.println(exception.getMessage());
        }


    }

    @Override
    public void addWord() {
        int sozSayi = InputUtil.Inputint("How many words do u want to add? PLease enter: ");

        for (int i = 0; i < sozSayi; i++) {
            try {
                String eng = InputUtil.InputString("English: ");
                String az = InputUtil.InputString("Azerbaijan: ");
                if (!eng.contains("([a-zA-Z0-9]+)|(['()+,\\-.=]+)") || !az.contains("([a-zA-Z0-9]+)|(['()+,\\-.=]+)")) {
                    throw new AppException(Exception.ILLEGAL_CHARACTER_EXCEPTION);
                }
                fileService.writeToFile(new Words(eng, az));
            } catch (AppException exception) {
                System.out.println(exception.getMessage());
            }

        }
    }

    @Override
    public void seeHistory() {
        File file = new File(GlobalFilePath.GAME_LOG_PATH);

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void gameLog(int point, long seconds) {
        File file = new File("C:\\Users\\User\\IdeaProjects\\DivB-107ExamMonth2\\src\\files\\GameLogs.txt");
        LocalDateTime ld = LocalDateTime.now();
        String gameLog = "New Game Started at -> Time: " + ld.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss")) +
                " Point- " + point + " Game Time: " + seconds;
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            bufferedWriter.newLine();
            bufferedWriter.write(gameLog);
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package services;

import files.GlobalFilePath;
import models.Words;
import services.interfaces.FileServiceInt;
import static files.GlobalFilePath.*;

import java.io.*;

public class FileService implements FileServiceInt {

    @Override
    public Words[] readFile() {
        File file = new File(FILE_PATH);


        try( InputStream inputStream = new FileInputStream(file)) {

            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

            byte[] bytes = bufferedInputStream.readAllBytes();
            String EngAz = new String(bytes);
            String[] engAzArr = EngAz.split("\n");

            Words[] words = new Words[engAzArr.length];

            for (int i = 0; i < words.length; i++) {
                String[] twoSize = engAzArr[i].split(":");
                words[i] = new Words(twoSize[0],twoSize[1]);
            }

            return words;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void writeToFile(Words words) {
        File file = new File(FILE_PATH);


        try (OutputStream outputStream = new FileOutputStream(file,true)){
            outputStream.write(words.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

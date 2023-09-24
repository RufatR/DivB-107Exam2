package services.interfaces;

import models.Words;

public interface FileServiceInt {
    Words[] readFile();

    void writeToFile(Words words);

}

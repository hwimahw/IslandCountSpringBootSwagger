package ru.ncd;

import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class FileInputStream {

      InputStream fileStream;

    public void setFileStream(InputStream fileStream) {
        this.fileStream = fileStream;
    }
}

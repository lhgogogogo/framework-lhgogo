package com.lhgogo.springframework.core.io;

import java.io.*;

/**
 * @author ：linhui
 * @description ：
 * @date ：2023-04-03 10:22
 * @version: 文件获取资源
 */

public class FileSystemResource implements Resource{

    private final File file;

    private final String path;

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    public FileSystemResource(String path) {
        this.file = new File(path);
        this.path = path;
    }


    @Override
    public InputStream getInputStream() throws IOException  {
        return new FileInputStream(this.file);
    }

    public final String getPath(){
        return this.path;
    }
}

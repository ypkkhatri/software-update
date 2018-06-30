package com.yog.dev.sw.update.beans;

/**
 *
 * @author Yougeshwar
 */
public class Dependency {

    private final String file;
    private final long size;

    public Dependency(String file, long size) {
        this.file = file;
        this.size = size;
    }

    public String getFile() {
        return file;
    }

    public long getSize() {
        return size;
    }
    
}

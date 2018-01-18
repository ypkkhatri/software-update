package com.yog.dev.sw.update.beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yougeshwar
 */
public class Update {

    private final String version;
    private final String mainFile;
    private final List<Dependency> dependencies;
    private final long size;
    private double fullSize;

    public Update(String version, String mainFile, long size) {
        this.version = version;
        this.mainFile = mainFile;
        this.dependencies = new ArrayList<>();
        this.size = size;
        this.fullSize = -1;
    }

    public String getMainFile() {
        return mainFile;
    }

    public String getVersion() {
        return version;
    }

    public long getSize() {
        return size;
    }

    public List<Dependency> getDependencies() {
        return dependencies;
    }

    public void addDependency(Dependency dependency) {
        dependencies.add(dependency);
    }

    public double getFullSize() {
        if (fullSize == -1) {
            fullSize = 0;
            fullSize += this.size;
            dependencies.forEach((d) -> {
                fullSize += d.getSize();
            });

            fullSize = fullSize / 1024d / 1024d;
        }
        return fullSize;
    }
}

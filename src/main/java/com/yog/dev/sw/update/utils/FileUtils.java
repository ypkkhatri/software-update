package com.yog.dev.sw.update.utils;

import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Yougeshwar
 */
public class FileUtils {

    public static long download(String from, String to, boolean createDir) throws Exception {
        Path path = Paths.get(to);

        if (createDir) {
            Files.createDirectories(path.getParent());
        }

        try {
            Files.createFile(path);
        } catch (FileAlreadyExistsException ex) {
        }
        URL url = new URL(from);
        try (ReadableByteChannel rbc = Channels.newChannel(url.openStream());
                FileOutputStream fos = new FileOutputStream(to)) {
            return fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
    }
}

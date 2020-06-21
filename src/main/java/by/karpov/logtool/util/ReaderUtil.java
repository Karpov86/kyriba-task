package by.karpov.logtool.util;

import by.karpov.logtool.entity.SimpleLog;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderUtil {

    private static final Path PATH_DIR = Paths.get("logs/");
    private static final String DELIMITER = "\\s\\|\\s";

    public static List<SimpleLog> getSimpleLogEntityList() throws IOException {
        List<String> strings = new ArrayList<>();

        List<Path> pathList = Files
                .walk(PATH_DIR)
                .filter(path -> path.getFileName().toString().endsWith(".txt"))
                .collect(Collectors.toList());
        for (Path path : pathList) {
            strings.addAll(Files.lines(path).collect(Collectors.toList()));
        }
        return strings.stream().map(line -> new SimpleLog.Builder()
                .setDateTime(LocalDateTime.parse(line.split(DELIMITER)[0]))
                .setNameUser(line.split(DELIMITER)[1])
                .setMessage(line.split(DELIMITER)[2])
                .build())
                .collect(Collectors.toList());
    }
}

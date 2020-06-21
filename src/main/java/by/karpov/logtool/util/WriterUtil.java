package by.karpov.logtool.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class WriterUtil {

    public static void writeResultFile(String fileName, List<String> filteredList, List<String> groupedList) throws IOException {
        filteredList
                .stream()
                .map(groupedList::add)
                .collect(Collectors.toList());

        Path path = Files.createFile(Paths.get(fileName));
        Files.write(path, groupedList, StandardCharsets.UTF_8);
    }
}

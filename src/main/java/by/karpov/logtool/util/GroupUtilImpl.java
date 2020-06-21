package by.karpov.logtool.util;

import by.karpov.logtool.entity.SimpleLog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupUtilImpl implements GroupUtil<SimpleLog> {

    @Override
    public List<String> groupByUserName(List<SimpleLog> simpleLogList) {
        List<String> lines = new ArrayList<>();
        Map<String, Long> collect =
                simpleLogList
                        .stream()
                        .collect(Collectors.groupingBy(SimpleLog::getNameUser, Collectors.counting()));
        for (Map.Entry<String, Long> item : collect.entrySet()) {
            lines.add(item.getKey() + " - " + item.getValue());
        }
        return lines;
    }
}

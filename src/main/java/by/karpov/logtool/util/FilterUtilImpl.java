package by.karpov.logtool.util;

import by.karpov.logtool.entity.SimpleLog;

import java.util.List;
import java.util.stream.Collectors;

public class FilterUtilImpl implements FilterUtil<SimpleLog> {

    @Override
    public List<String> filterByUserName(List<SimpleLog> simpleLogList, String userName) {

        return simpleLogList
                .stream()
                .filter(simpleLog -> simpleLog.getNameUser().equals(userName))
                .map(s -> s.getDateTime() + " | " + s.getNameUser() + " | " + s.getMessage())
                .collect(Collectors.toList());
    }
}

package by.karpov.logtool.util;

import java.util.List;

public interface GroupUtil<T> {

    List<String> groupByUserName(List<T> list);

}

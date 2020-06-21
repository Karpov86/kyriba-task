package by.karpov.logtool.util;

import java.util.List;

public interface FilterUtil<T> {

    List<String> filterByUserName(List<T> list, String userName);

}

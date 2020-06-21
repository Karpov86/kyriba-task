import by.karpov.logtool.entity.SimpleLog;
import by.karpov.logtool.util.FilterUtilImpl;
import by.karpov.logtool.util.GroupUtilImpl;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static by.karpov.logtool.util.ReaderUtil.getSimpleLogEntityList;
import static by.karpov.logtool.util.WriterUtil.writeResultFile;

public class App {

    private static final FilterUtilImpl filterUtil = new FilterUtilImpl();
    private static final GroupUtilImpl groupUtil = new GroupUtilImpl();

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        //gets all logs
        List<SimpleLog> simpleLogList = getSimpleLogEntityList();

        //filtering by user name
        System.out.println("Insert name to filter: ");
        String userName = "";
        while (!hasUserName(simpleLogList, userName)) {
            userName = convertFirstCharToUpperCase(in.nextLine());
            if (!hasUserName(simpleLogList, userName)) {
                System.out.println("User not found, insert name to filter: ");
            } else {
                System.out.print("User found ");
                filterUtil.filterByUserName(simpleLogList, userName);
                System.out.println(", filter applied");
            }
        }

        //grouping by user name
        System.out.println("Group by user name");
        List<String> groupByUserName = groupUtil.groupByUserName(simpleLogList);

        //saving result file
        System.out.println("Insert file name to save: ");
        String fileName = in.nextLine();
        writeResultFile(fileName, filterUtil.filterByUserName(simpleLogList, userName), groupByUserName);
        System.out.println("File save as - " + "\"" + fileName + ".txt" + "\"");
    }

    static String convertFirstCharToUpperCase(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    static boolean hasUserName(List<SimpleLog> simpleLogList, String userName) {
        return simpleLogList
                .stream()
                .map(SimpleLog::getNameUser)
                .anyMatch(name -> name.equals(userName));
    }
}

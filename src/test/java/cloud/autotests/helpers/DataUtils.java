package cloud.autotests.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtils {

    static Date currentDate = new Date();
    static SimpleDateFormat dateNow = new SimpleDateFormat("dd.MM.yy.hh.mm.ss");


    public static String getCurrentDateInString() {
        return dateNow.format(currentDate);
    }

}

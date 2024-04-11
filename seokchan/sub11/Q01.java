package source.seokchan.sub11;

import source.ch08_class.common.MyUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Q01 {
    public static void main(String[] args) {
        String file = UUID.randomUUID().toString();
        System.out.println(file);

        String id = MyUtil.makeUniqueID();
        System.out.println(id);

    }
}

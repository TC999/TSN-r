package com.acse.ottn.util;

import java.io.ObjectStreamException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class T {

    /* renamed from: a  reason: collision with root package name */
    private static T f6787a;

    private T() {
    }

    public static String a(long j4) {
        return new SimpleDateFormat("MM\u6708dd\u65e5  #  HH:mm").format(new Date(j4)).replaceAll("#", b(j4));
    }

    public static String a(String str) {
        int i4;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5HH\u65f6mm\u5206ss\u79d2");
        Long.valueOf(str).longValue();
        try {
            Date parse = simpleDateFormat.parse(simpleDateFormat.format(new Date(Integer.parseInt(str) * 1000)));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse);
            i4 = calendar.get(7);
        } catch (ParseException e4) {
            e4.printStackTrace();
            i4 = 0;
        }
        if (i4 == 1) {
            return "\u661f\u671f\u65e5";
        }
        if (i4 == 2) {
            return "\u661f\u671f\u4e00";
        }
        if (i4 == 3) {
            return "\u661f\u671f\u4e8c";
        }
        if (i4 == 4) {
            return "\u661f\u671f\u4e09";
        }
        if (i4 == 5) {
            return "\u661f\u671f\u56db";
        }
        if (i4 == 6) {
            return "\u661f\u671f\u4e94";
        }
        if (i4 == 7) {
            return "\u661f\u671f\u516d";
        }
        return null;
    }

    public static String a(String str, String str2) {
        return b(str + "000", str2) + "  " + b(str);
    }

    private static String b(long j4) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j4));
        int i4 = calendar.get(7);
        if (i4 == 1) {
            return "\u5468\u65e5";
        }
        if (i4 == 2) {
            return "\u5468\u4e00";
        }
        if (i4 == 3) {
            return "\u5468\u4e8c";
        }
        if (i4 == 4) {
            return "\u5468\u4e09";
        }
        if (i4 == 5) {
            return "\u5468\u56db";
        }
        if (i4 == 6) {
            return "\u5468\u4e94";
        }
        if (i4 == 7) {
            return "\u5468\u516d";
        }
        return null;
    }

    public static String b(String str) {
        int i4;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Long.valueOf(str).longValue();
        try {
            Date parse = simpleDateFormat.parse(simpleDateFormat.format(new Date(Integer.parseInt(str) * 1000)));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse);
            i4 = calendar.get(7);
        } catch (ParseException e4) {
            e4.printStackTrace();
            i4 = 0;
        }
        if (i4 == 1) {
            return "\u661f\u671f\u65e5";
        }
        if (i4 == 2) {
            return "\u661f\u671f\u4e00";
        }
        if (i4 == 3) {
            return "\u661f\u671f\u4e8c";
        }
        if (i4 == 4) {
            return "\u661f\u671f\u4e09";
        }
        if (i4 == 5) {
            return "\u661f\u671f\u56db";
        }
        if (i4 == 6) {
            return "\u661f\u671f\u4e94";
        }
        if (i4 == 7) {
            return "\u661f\u671f\u516d";
        }
        return null;
    }

    public static String b(String str, String str2) {
        return new SimpleDateFormat(str2).format(new Date(Long.valueOf(str).longValue()));
    }

    public static String c() {
        return new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5  HH\u65f6mm\u5206").format(new Date());
    }

    public static String c(String str, String str2) {
        try {
            return String.valueOf(new SimpleDateFormat(str2, Locale.CHINA).parse(str).getTime()).substring(0, 10);
        } catch (ParseException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static T d() {
        if (f6787a == null) {
            synchronized (T.class) {
                if (f6787a == null) {
                    f6787a = new T();
                }
            }
        }
        return f6787a;
    }

    private Object e() throws ObjectStreamException {
        return f6787a;
    }

    public static String[] g(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5HH\u65f6mm\u5206ss\u79d2");
        Long.valueOf(str).longValue();
        return simpleDateFormat.format(new Date(Integer.parseInt(str) * 1000)).split("[\u5e74\u6708\u65e5\u65f6\u5206\u79d2]");
    }

    public static String i(String str) {
        return new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5").format(new Date(Long.valueOf(str).longValue()));
    }

    public String a() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
    }

    public int b() {
        return Integer.parseInt(new SimpleDateFormat("HHmm", Locale.CHINA).format(new Date(System.currentTimeMillis())));
    }

    public long c(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).parse(str).getTime();
        } catch (ParseException e4) {
            e4.printStackTrace();
            return 0L;
        }
    }

    public String[] d(String str) {
        return str.split("[\u5e74\u6708\u65e5\u65f6\u5206\u79d2]");
    }

    public String e(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5HH\u65f6mm\u5206ss\u79d2");
        Long.valueOf(str).longValue();
        return simpleDateFormat.format(new Date(Integer.parseInt(str) * 1000));
    }

    public String f(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Long.valueOf(str).longValue();
        return simpleDateFormat.format(new Date(Integer.parseInt(str) * 1000));
    }

    public String h(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5HH\u65f6mm\u5206");
        Long.valueOf(str).longValue();
        return simpleDateFormat.format(new Date(Integer.parseInt(str) * 1000));
    }

    public String j(String str) {
        int i4;
        try {
            Date parse = new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5HH\u65f6mm\u5206ss\u79d2").parse(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse);
            i4 = calendar.get(7);
        } catch (ParseException e4) {
            e4.printStackTrace();
            i4 = 0;
        }
        if (i4 == 1) {
            return "\u661f\u671f\u65e5";
        }
        if (i4 == 2) {
            return "\u661f\u671f\u4e00";
        }
        if (i4 == 3) {
            return "\u661f\u671f\u4e8c";
        }
        if (i4 == 4) {
            return "\u661f\u671f\u4e09";
        }
        if (i4 == 5) {
            return "\u661f\u671f\u56db";
        }
        if (i4 == 6) {
            return "\u661f\u671f\u4e94";
        }
        if (i4 == 7) {
            return "\u661f\u671f\u516d";
        }
        return null;
    }

    public String k(String str) {
        int i4;
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").parse(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse);
            i4 = calendar.get(7);
        } catch (ParseException e4) {
            e4.printStackTrace();
            i4 = 0;
        }
        if (i4 == 1) {
            return "\u661f\u671f\u65e5";
        }
        if (i4 == 2) {
            return "\u661f\u671f\u4e00";
        }
        if (i4 == 3) {
            return "\u661f\u671f\u4e8c";
        }
        if (i4 == 4) {
            return "\u661f\u671f\u4e09";
        }
        if (i4 == 5) {
            return "\u661f\u671f\u56db";
        }
        if (i4 == 6) {
            return "\u661f\u671f\u4e94";
        }
        if (i4 == 7) {
            return "\u661f\u671f\u516d";
        }
        return null;
    }
}

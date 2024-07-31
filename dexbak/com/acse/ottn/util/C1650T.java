package com.acse.ottn.util;

import java.io.ObjectStreamException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.acse.ottn.util.T */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1650T {

    /* renamed from: a */
    private static C1650T f3277a;

    private C1650T() {
    }

    /* renamed from: a */
    public static String m56160a(long j) {
        return new SimpleDateFormat("MM月dd日  #  HH:mm").format(new Date(j)).replaceAll("#", m56156b(j));
    }

    /* renamed from: a */
    public static String m56159a(String str) {
        int i;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        Long.valueOf(str).longValue();
        try {
            Date parse = simpleDateFormat.parse(simpleDateFormat.format(new Date(Integer.parseInt(str) * 1000)));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse);
            i = calendar.get(7);
        } catch (ParseException e) {
            e.printStackTrace();
            i = 0;
        }
        if (i == 1) {
            return "星期日";
        }
        if (i == 2) {
            return "星期一";
        }
        if (i == 3) {
            return "星期二";
        }
        if (i == 4) {
            return "星期三";
        }
        if (i == 5) {
            return "星期四";
        }
        if (i == 6) {
            return "星期五";
        }
        if (i == 7) {
            return "星期六";
        }
        return null;
    }

    /* renamed from: a */
    public static String m56158a(String str, String str2) {
        return m56154b(str + "000", str2) + "  " + m56155b(str);
    }

    /* renamed from: b */
    private static String m56156b(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j));
        int i = calendar.get(7);
        if (i == 1) {
            return "周日";
        }
        if (i == 2) {
            return "周一";
        }
        if (i == 3) {
            return "周二";
        }
        if (i == 4) {
            return "周三";
        }
        if (i == 5) {
            return "周四";
        }
        if (i == 6) {
            return "周五";
        }
        if (i == 7) {
            return "周六";
        }
        return null;
    }

    /* renamed from: b */
    public static String m56155b(String str) {
        int i;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Long.valueOf(str).longValue();
        try {
            Date parse = simpleDateFormat.parse(simpleDateFormat.format(new Date(Integer.parseInt(str) * 1000)));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse);
            i = calendar.get(7);
        } catch (ParseException e) {
            e.printStackTrace();
            i = 0;
        }
        if (i == 1) {
            return "星期日";
        }
        if (i == 2) {
            return "星期一";
        }
        if (i == 3) {
            return "星期二";
        }
        if (i == 4) {
            return "星期三";
        }
        if (i == 5) {
            return "星期四";
        }
        if (i == 6) {
            return "星期五";
        }
        if (i == 7) {
            return "星期六";
        }
        return null;
    }

    /* renamed from: b */
    public static String m56154b(String str, String str2) {
        return new SimpleDateFormat(str2).format(new Date(Long.valueOf(str).longValue()));
    }

    /* renamed from: c */
    public static String m56153c() {
        return new SimpleDateFormat("yyyy年MM月dd日  HH时mm分").format(new Date());
    }

    /* renamed from: c */
    public static String m56151c(String str, String str2) {
        try {
            return String.valueOf(new SimpleDateFormat(str2, Locale.CHINA).parse(str).getTime()).substring(0, 10);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: d */
    public static C1650T m56150d() {
        if (f3277a == null) {
            synchronized (C1650T.class) {
                if (f3277a == null) {
                    f3277a = new C1650T();
                }
            }
        }
        return f3277a;
    }

    /* renamed from: e */
    private Object m56148e() throws ObjectStreamException {
        return f3277a;
    }

    /* renamed from: g */
    public static String[] m56145g(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        Long.valueOf(str).longValue();
        return simpleDateFormat.format(new Date(Integer.parseInt(str) * 1000)).split("[年月日时分秒]");
    }

    /* renamed from: i */
    public static String m56143i(String str) {
        return new SimpleDateFormat("yyyy年MM月dd日").format(new Date(Long.valueOf(str).longValue()));
    }

    /* renamed from: a */
    public String m56161a() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
    }

    /* renamed from: b */
    public int m56157b() {
        return Integer.parseInt(new SimpleDateFormat("HHmm", Locale.CHINA).format(new Date(System.currentTimeMillis())));
    }

    /* renamed from: c */
    public long m56152c(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).parse(str).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* renamed from: d */
    public String[] m56149d(String str) {
        return str.split("[年月日时分秒]");
    }

    /* renamed from: e */
    public String m56147e(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        Long.valueOf(str).longValue();
        return simpleDateFormat.format(new Date(Integer.parseInt(str) * 1000));
    }

    /* renamed from: f */
    public String m56146f(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Long.valueOf(str).longValue();
        return simpleDateFormat.format(new Date(Integer.parseInt(str) * 1000));
    }

    /* renamed from: h */
    public String m56144h(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
        Long.valueOf(str).longValue();
        return simpleDateFormat.format(new Date(Integer.parseInt(str) * 1000));
    }

    /* renamed from: j */
    public String m56142j(String str) {
        int i;
        try {
            Date parse = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒").parse(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse);
            i = calendar.get(7);
        } catch (ParseException e) {
            e.printStackTrace();
            i = 0;
        }
        if (i == 1) {
            return "星期日";
        }
        if (i == 2) {
            return "星期一";
        }
        if (i == 3) {
            return "星期二";
        }
        if (i == 4) {
            return "星期三";
        }
        if (i == 5) {
            return "星期四";
        }
        if (i == 6) {
            return "星期五";
        }
        if (i == 7) {
            return "星期六";
        }
        return null;
    }

    /* renamed from: k */
    public String m56141k(String str) {
        int i;
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").parse(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse);
            i = calendar.get(7);
        } catch (ParseException e) {
            e.printStackTrace();
            i = 0;
        }
        if (i == 1) {
            return "星期日";
        }
        if (i == 2) {
            return "星期一";
        }
        if (i == 3) {
            return "星期二";
        }
        if (i == 4) {
            return "星期三";
        }
        if (i == 5) {
            return "星期四";
        }
        if (i == 6) {
            return "星期五";
        }
        if (i == 7) {
            return "星期六";
        }
        return null;
    }
}

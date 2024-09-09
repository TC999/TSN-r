package cn.jiguang.f;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f3633b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> f3634c = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public static String f3632a = "yyyyMMdd_HHmm";

    /* renamed from: d  reason: collision with root package name */
    private static final TimeZone f3635d = TimeZone.getTimeZone("UTC");

    /* renamed from: e  reason: collision with root package name */
    private static final ThreadLocal<SimpleDateFormat> f3636e = new ThreadLocal<SimpleDateFormat>() { // from class: cn.jiguang.f.b.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ROOT);
            simpleDateFormat.setTimeZone(b.f3635d);
            return simpleDateFormat;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class a extends ThreadLocal<SimpleDateFormat> {

        /* renamed from: a  reason: collision with root package name */
        private String f3637a;

        a(String str) {
            this.f3637a = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat(this.f3637a, Locale.ENGLISH);
        }
    }

    public static long a(int i4) {
        Calendar calendar = Calendar.getInstance();
        calendar.roll(6, i4);
        return calendar.getTime().getTime();
    }

    public static String a() {
        return a("yyyyMMdd HH:mm:ss.SSS").format(new Date());
    }

    public static String a(Date date) {
        return f3636e.get().format(date);
    }

    public static SimpleDateFormat a(String str) {
        ThreadLocal<SimpleDateFormat> threadLocal = f3634c.get(str);
        if (threadLocal == null) {
            synchronized (f3633b) {
                threadLocal = f3634c.get(str);
                if (threadLocal == null) {
                    threadLocal = new a(str);
                    f3634c.put(str, threadLocal);
                }
            }
        }
        return threadLocal.get();
    }

    public static String b() {
        return a("yyyy-MM-dd_HH:mm:ss").format(new Date());
    }

    public static Date c() {
        return Calendar.getInstance(f3635d).getTime();
    }
}

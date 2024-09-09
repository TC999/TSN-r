package cn.jiguang.ag;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f2181b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> f2182c = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public static String f2180a = "yyyyMMdd_HHmm";

    /* renamed from: d  reason: collision with root package name */
    private static final TimeZone f2183d = TimeZone.getTimeZone("UTC");

    /* renamed from: e  reason: collision with root package name */
    private static final ThreadLocal<SimpleDateFormat> f2184e = new ThreadLocal<SimpleDateFormat>() { // from class: cn.jiguang.ag.b.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ROOT);
            simpleDateFormat.setTimeZone(b.f2183d);
            return simpleDateFormat;
        }
    };

    public static Date a(long j4) {
        Calendar calendar = Calendar.getInstance(f2183d);
        calendar.setTimeInMillis(j4);
        return calendar.getTime();
    }
}

package cn.jpush.android.ad;

import android.text.TextUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f3980a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> f3981b = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class a extends ThreadLocal<SimpleDateFormat> {

        /* renamed from: a  reason: collision with root package name */
        private String f3982a;

        a(String str) {
            this.f3982a = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat(this.f3982a, Locale.ENGLISH);
        }
    }

    public static SimpleDateFormat a(String str) {
        ThreadLocal<SimpleDateFormat> threadLocal = f3981b.get(str);
        if (threadLocal == null) {
            synchronized (f3980a) {
                threadLocal = f3981b.get(str);
                if (threadLocal == null) {
                    threadLocal = new a(str);
                    f3981b.put(str, threadLocal);
                }
            }
        }
        return threadLocal.get();
    }

    public static long b(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return a("yyyy-MM-dd HH:mm:ss").parse(str).getTime();
        } catch (ParseException unused) {
            return -1L;
        }
    }
}

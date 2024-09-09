package cn.jiguang.bj;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f2656a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> f2657b = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class a extends ThreadLocal<SimpleDateFormat> {

        /* renamed from: a  reason: collision with root package name */
        private String f2658a;

        a(String str) {
            this.f2658a = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat(this.f2658a, Locale.ENGLISH);
        }
    }

    public static String a(long j4) {
        return a("yyyyMMdd HH:mm:ss.SSS").format(new Date(j4));
    }

    public static SimpleDateFormat a(String str) {
        ThreadLocal<SimpleDateFormat> threadLocal = f2657b.get(str);
        if (threadLocal == null) {
            synchronized (f2656a) {
                threadLocal = f2657b.get(str);
                if (threadLocal == null) {
                    threadLocal = new a(str);
                    f2657b.put(str, threadLocal);
                }
            }
        }
        return threadLocal.get();
    }
}

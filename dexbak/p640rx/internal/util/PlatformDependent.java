package p640rx.internal.util;

/* renamed from: rx.internal.util.i */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class PlatformDependent {

    /* renamed from: a */
    public static final int f46506a = 0;

    /* renamed from: b */
    private static final int f46507b;

    /* renamed from: c */
    private static final boolean f46508c;

    static {
        int m837c = m837c();
        f46507b = m837c;
        f46508c = m837c != 0;
    }

    private PlatformDependent() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static int m839a() {
        return f46507b;
    }

    /* renamed from: b */
    public static boolean m838b() {
        return f46508c;
    }

    /* renamed from: c */
    private static int m837c() {
        try {
            return ((Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null)).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }
}

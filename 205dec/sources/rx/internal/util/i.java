package rx.internal.util;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: PlatformDependent.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final int f63937a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static final int f63938b;

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f63939c;

    static {
        int c4 = c();
        f63938b = c4;
        f63939c = c4 != 0;
    }

    private i() {
        throw new IllegalStateException("No instances!");
    }

    public static int a() {
        return f63938b;
    }

    public static boolean b() {
        return f63939c;
    }

    private static int c() {
        try {
            return ((Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null)).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }
}

package p1;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Preconditions.java */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class a {
    private a() {
        throw new AssertionError("No instances.");
    }

    public static <T> T a(T t3, String str) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(str);
    }
}

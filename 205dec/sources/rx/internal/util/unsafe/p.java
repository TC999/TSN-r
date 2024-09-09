package rx.internal.util.unsafe;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: Pow2.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class p {
    private p() {
        throw new IllegalStateException("No instances!");
    }

    public static boolean a(int i4) {
        return (i4 & (i4 + (-1))) == 0;
    }

    public static int b(int i4) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i4 - 1));
    }
}

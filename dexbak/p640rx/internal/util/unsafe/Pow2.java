package p640rx.internal.util.unsafe;

/* renamed from: rx.internal.util.unsafe.p */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Pow2 {
    private Pow2() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static boolean m757a(int i) {
        return (i & (i + (-1))) == 0;
    }

    /* renamed from: b */
    public static int m756b(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }
}

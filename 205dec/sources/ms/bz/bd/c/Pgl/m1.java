package ms.bz.bd.c.Pgl;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class m1 {

    /* renamed from: c  reason: collision with root package name */
    private static volatile m1 f61416c;

    /* renamed from: a  reason: collision with root package name */
    private int f61417a = 0;

    /* renamed from: b  reason: collision with root package name */
    private Throwable f61418b = null;

    private m1() {
    }

    public static m1 a() {
        if (f61416c == null) {
            synchronized (m1.class) {
                if (f61416c == null) {
                    f61416c = new m1();
                }
            }
        }
        return f61416c;
    }

    public synchronized Throwable b() {
        return this.f61418b;
    }
}

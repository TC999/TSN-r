package h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: NumericWheelAdapter.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class b implements c {

    /* renamed from: c  reason: collision with root package name */
    public static final int f54727c = 9;

    /* renamed from: d  reason: collision with root package name */
    private static final int f54728d = 0;

    /* renamed from: a  reason: collision with root package name */
    private int f54729a;

    /* renamed from: b  reason: collision with root package name */
    private int f54730b;

    public b() {
        this(0, 9);
    }

    @Override // h.c
    public int a() {
        return (this.f54730b - this.f54729a) + 1;
    }

    @Override // h.c
    public Object getItem(int i4) {
        if (i4 >= 0 && i4 < a()) {
            return Integer.valueOf(this.f54729a + i4);
        }
        return 0;
    }

    @Override // h.c
    public int indexOf(Object obj) {
        try {
            return ((Integer) obj).intValue() - this.f54729a;
        } catch (Exception unused) {
            return -1;
        }
    }

    public b(int i4, int i5) {
        this.f54729a = i4;
        this.f54730b = i5;
    }
}

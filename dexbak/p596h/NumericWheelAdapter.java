package p596h;

/* renamed from: h.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class NumericWheelAdapter implements WheelAdapter {

    /* renamed from: c */
    public static final int f40155c = 9;

    /* renamed from: d */
    private static final int f40156d = 0;

    /* renamed from: a */
    private int f40157a;

    /* renamed from: b */
    private int f40158b;

    public NumericWheelAdapter() {
        this(0, 9);
    }

    @Override // p596h.WheelAdapter
    /* renamed from: a */
    public int mo12730a() {
        return (this.f40158b - this.f40157a) + 1;
    }

    @Override // p596h.WheelAdapter
    public Object getItem(int i) {
        if (i >= 0 && i < mo12730a()) {
            return Integer.valueOf(this.f40157a + i);
        }
        return 0;
    }

    @Override // p596h.WheelAdapter
    public int indexOf(Object obj) {
        try {
            return ((Integer) obj).intValue() - this.f40157a;
        } catch (Exception unused) {
            return -1;
        }
    }

    public NumericWheelAdapter(int i, int i2) {
        this.f40157a = i;
        this.f40158b = i2;
    }
}

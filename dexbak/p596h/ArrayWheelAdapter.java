package p596h;

import java.util.List;

/* renamed from: h.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ArrayWheelAdapter<T> implements WheelAdapter {

    /* renamed from: c */
    public static final int f40152c = 4;

    /* renamed from: a */
    private List<T> f40153a;

    /* renamed from: b */
    private int f40154b;

    public ArrayWheelAdapter(List<T> list, int i) {
        this.f40153a = list;
        this.f40154b = i;
    }

    @Override // p596h.WheelAdapter
    /* renamed from: a */
    public int mo12730a() {
        return this.f40153a.size();
    }

    @Override // p596h.WheelAdapter
    public Object getItem(int i) {
        return (i < 0 || i >= this.f40153a.size()) ? "" : this.f40153a.get(i);
    }

    @Override // p596h.WheelAdapter
    public int indexOf(Object obj) {
        return this.f40153a.indexOf(obj);
    }

    public ArrayWheelAdapter(List<T> list) {
        this(list, 4);
    }
}

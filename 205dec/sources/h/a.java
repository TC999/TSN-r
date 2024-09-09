package h;

import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ArrayWheelAdapter.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class a<T> implements c {

    /* renamed from: c  reason: collision with root package name */
    public static final int f54724c = 4;

    /* renamed from: a  reason: collision with root package name */
    private List<T> f54725a;

    /* renamed from: b  reason: collision with root package name */
    private int f54726b;

    public a(List<T> list, int i4) {
        this.f54725a = list;
        this.f54726b = i4;
    }

    @Override // h.c
    public int a() {
        return this.f54725a.size();
    }

    @Override // h.c
    public Object getItem(int i4) {
        return (i4 < 0 || i4 >= this.f54725a.size()) ? "" : this.f54725a.get(i4);
    }

    @Override // h.c
    public int indexOf(Object obj) {
        return this.f54725a.indexOf(obj);
    }

    public a(List<T> list) {
        this(list, 4);
    }
}

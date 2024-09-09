package cn.jiguang.v;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class i<E> {

    /* renamed from: a  reason: collision with root package name */
    private Comparator<E> f3876a;

    /* renamed from: b  reason: collision with root package name */
    private int f3877b;

    public i(Comparator<E> comparator) {
        a(comparator);
    }

    private boolean a(List<E> list, int i4, int i5, E e4) {
        while (i4 <= i5) {
            int i6 = (i4 + i5) >> 1;
            int compare = this.f3876a.compare(list.get(i6), e4);
            if (compare == 0) {
                this.f3877b = i6;
                return true;
            } else if (compare < 0) {
                i4 = i6 + 1;
            } else {
                i5 = i6 - 1;
            }
        }
        this.f3877b = i4;
        return false;
    }

    public List<E> a(List<E> list, List<E> list2) {
        if (this.f3876a == null || list == null || list.isEmpty() || list2 == null || list2.isEmpty()) {
            return null;
        }
        int size = list.size();
        int size2 = list2.size();
        int i4 = size - 1;
        int i5 = size2 - 1;
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        int i7 = 0;
        while (i6 < size && i7 < size2) {
            E e4 = list.get(i6);
            E e5 = list2.get(i7);
            int compare = this.f3876a.compare(e4, e5);
            if (compare == 0) {
                arrayList.add(e4);
            } else if (compare >= 0) {
                if (a(list2, i7 + 1, i5, e4)) {
                    arrayList.add(e4);
                    i7 = this.f3877b + 1;
                } else {
                    i7 = this.f3877b;
                }
                i6++;
            } else if (a(list, i6 + 1, i4, e5)) {
                arrayList.add(e5);
                i6 = this.f3877b;
            } else {
                i6 = this.f3877b;
                i7++;
            }
            i6++;
            i7++;
        }
        return arrayList;
    }

    public void a(Comparator<E> comparator) {
        this.f3876a = comparator;
    }
}

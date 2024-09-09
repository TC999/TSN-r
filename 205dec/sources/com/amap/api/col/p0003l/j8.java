package com.amap.api.col.p0003l;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: WifiCollector.java */
/* renamed from: com.amap.api.col.3l.j8  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class j8 {

    /* renamed from: b  reason: collision with root package name */
    private j9 f8224b;

    /* renamed from: a  reason: collision with root package name */
    private List<k9> f8223a = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<k9> f8225c = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WifiCollector.java */
    /* renamed from: com.amap.api.col.3l.j8$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class a implements Comparator<k9> {
        a() {
        }

        private static int a(k9 k9Var, k9 k9Var2) {
            return k9Var2.f8255c - k9Var.f8255c;
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(k9 k9Var, k9 k9Var2) {
            return a(k9Var, k9Var2);
        }
    }

    private static List<k9> b(List<k9> list) {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (int i4 = 0; i4 < list.size(); i4++) {
            k9 k9Var = list.get(i4);
            hashMap.put(Integer.valueOf(k9Var.f8255c), k9Var);
        }
        arrayList.addAll(hashMap.values());
        return arrayList;
    }

    private boolean c(j9 j9Var) {
        float f4 = j9Var.f8156g;
        float f5 = 10.0f;
        if (f4 > 10.0f) {
            f5 = 200.0f;
        } else if (f4 > 2.0f) {
            f5 = 50.0f;
        }
        return j9Var.a(this.f8224b) > ((double) f5);
    }

    private static boolean d(j9 j9Var, long j4, long j5) {
        return j4 > 0 && j5 - j4 < ((long) ((j9Var.f8156g > 10.0f ? 1 : (j9Var.f8156g == 10.0f ? 0 : -1)) >= 0 ? 2000 : 3500));
    }

    private static boolean e(List<k9> list, List<k9> list2) {
        if (list != null && list2 != null) {
            int size = list.size();
            int size2 = list2.size();
            int i4 = size + size2;
            if (size <= size2) {
                list2 = list;
                list = list2;
            }
            HashMap hashMap = new HashMap(list.size());
            for (k9 k9Var : list) {
                hashMap.put(Long.valueOf(k9Var.f8253a), 1);
            }
            int i5 = 0;
            for (k9 k9Var2 : list2) {
                if (((Integer) hashMap.get(Long.valueOf(k9Var2.f8253a))) != null) {
                    i5++;
                }
            }
            double d4 = i5;
            Double.isNaN(d4);
            double d5 = i4;
            Double.isNaN(d5);
            if (d4 * 2.0d >= d5 * 0.5d) {
                return true;
            }
        }
        return false;
    }

    private List<k9> f(List<k9> list) {
        Collections.sort(list, new a());
        return list;
    }

    private void g(List<k9> list, List<k9> list2) {
        list.clear();
        if (list2 != null) {
            List<k9> f4 = f(b(list2));
            int size = f4.size();
            if (size > 40) {
                size = 40;
            }
            for (int i4 = 0; i4 < size; i4++) {
                list.add(f4.get(i4));
            }
        }
    }

    private boolean h(j9 j9Var, List<k9> list, boolean z3, long j4, long j5) {
        if (z3 && d(j9Var, j4, j5) && list != null && list.size() > 0) {
            if (this.f8224b != null) {
                boolean c4 = c(j9Var);
                return !c4 ? !e(list, this.f8223a) : c4;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<k9> a(j9 j9Var, List<k9> list, boolean z3, long j4, long j5) {
        if (h(j9Var, list, z3, j4, j5)) {
            g(this.f8225c, list);
            this.f8223a.clear();
            this.f8223a.addAll(list);
            this.f8224b = j9Var;
            return this.f8225c;
        }
        return null;
    }
}

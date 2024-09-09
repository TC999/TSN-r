package cn.jiguang.bv;

import android.content.Context;
import android.text.TextUtils;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<d> f2939a = new Comparator<d>() { // from class: cn.jiguang.bv.e.1
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            if (dVar.equals(dVar2)) {
                return 0;
            }
            int i4 = dVar.f2935b;
            int i5 = dVar2.f2935b;
            if (i4 > i5) {
                return -1;
            }
            if (i4 < i5) {
                return 1;
            }
            int i6 = dVar.f2938e;
            int i7 = dVar2.f2938e;
            if (i6 > i7) {
                return -1;
            }
            if (i6 < i7) {
                return 1;
            }
            long j4 = dVar.f2937d;
            if (j4 != 0) {
                long j5 = dVar2.f2937d;
                if (j5 != 0) {
                    if (j4 < j5) {
                        return -1;
                    }
                    if (j4 > j5) {
                        return 1;
                    }
                }
            }
            long j6 = dVar.f2936c;
            if (j6 != 0) {
                long j7 = dVar2.f2936c;
                if (j7 != 0) {
                    if (j6 > j7 + 180000) {
                        return -1;
                    }
                    if (j6 < j7 - 180000) {
                        return 1;
                    }
                }
            }
            return 0;
        }
    };

    public static LinkedHashSet<g> a(Context context, LinkedHashSet<g> linkedHashSet, long j4) {
        if ((linkedHashSet != null ? linkedHashSet.size() : 0) == 0) {
            return new LinkedHashSet<>();
        }
        LinkedList linkedList = new LinkedList();
        Iterator<g> it = linkedHashSet.iterator();
        boolean z3 = true;
        while (it.hasNext()) {
            g next = it.next();
            if (next.a()) {
                cn.jiguang.g.a<String> f4 = cn.jiguang.g.a.f(next.toString());
                cn.jiguang.g.a<String> g4 = cn.jiguang.g.a.g(next.toString());
                String str = (String) cn.jiguang.g.b.a(context, g4);
                if (TextUtils.isEmpty(str)) {
                    str = (String) cn.jiguang.g.b.a(context, f4);
                }
                d a4 = d.a(str);
                if (a4 == null) {
                    a4 = new d(next);
                }
                if (z3) {
                    a4.f2938e = 1;
                    z3 = false;
                }
                if (j4 > 0) {
                    a4.f2936c = j4;
                    cn.jiguang.g.b.a(context, g4.a((cn.jiguang.g.a<String>) a4.a()));
                }
                linkedList.add(a4);
            }
        }
        return a(context, a(linkedList, f2939a));
    }

    public static LinkedHashSet<g> a(Context context, LinkedList<LinkedList<d>> linkedList) {
        boolean e4 = cn.jiguang.cn.a.e(context);
        LinkedHashSet<g> linkedHashSet = new LinkedHashSet<>();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<LinkedList<d>> it = linkedList.iterator();
        while (it.hasNext()) {
            Iterator<d> it2 = it.next().iterator();
            while (it2.hasNext()) {
                g gVar = it2.next().f2934a;
                if (gVar.f2943a.contains(":")) {
                    arrayList.add(gVar);
                } else {
                    arrayList2.add(gVar);
                }
            }
        }
        linkedHashSet.clear();
        if (e4) {
            linkedHashSet.addAll(arrayList);
            linkedHashSet.addAll(arrayList2);
        } else {
            linkedHashSet.addAll(arrayList2);
            linkedHashSet.addAll(arrayList);
        }
        return linkedHashSet;
    }

    private static <T> LinkedList<LinkedList<T>> a(Collection<T> collection, Comparator<T> comparator) {
        boolean z3;
        int size = collection != null ? collection.size() : 0;
        if (size == 0) {
            return new LinkedList<>();
        }
        LinkedList<LinkedList<T>> linkedList = new LinkedList<>();
        if (size == 1) {
            linkedList.add(new LinkedList<>(collection));
            return linkedList;
        }
        SecureRandom secureRandom = new SecureRandom();
        for (T t3 : collection) {
            for (int i4 = 0; i4 < linkedList.size(); i4++) {
                LinkedList<T> linkedList2 = linkedList.get(i4);
                int compare = comparator.compare(t3, linkedList2.getFirst());
                if (compare == 0) {
                    linkedList2.add(secureRandom.nextInt(linkedList2.size() + 1), t3);
                } else if (compare < 0) {
                    LinkedList<T> linkedList3 = new LinkedList<>();
                    linkedList3.add(t3);
                    linkedList.add(i4, linkedList3);
                }
                z3 = true;
            }
            z3 = false;
            if (!z3) {
                LinkedList<T> linkedList4 = new LinkedList<>();
                linkedList4.add(t3);
                linkedList.add(linkedList4);
            }
        }
        return linkedList;
    }

    public static void a(Context context, g gVar, int i4, long j4) {
        if (gVar != null) {
            cn.jiguang.g.a<String> f4 = cn.jiguang.g.a.f(gVar.toString());
            cn.jiguang.g.a<String> g4 = cn.jiguang.g.a.g(gVar.toString());
            String str = (String) cn.jiguang.g.b.a(context, g4);
            if (TextUtils.isEmpty(str)) {
                str = (String) cn.jiguang.g.b.a(context, f4);
            }
            d a4 = d.a(str);
            if (a4 == null) {
                a4 = new d(gVar);
            }
            a4.f2937d = j4;
            a4.f2935b = i4;
            cn.jiguang.g.b.a(context, g4.a((cn.jiguang.g.a<String>) a4.a()));
        }
    }
}

package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.f0;
import kotlin.collections.y0;
import kotlin.collections.z0;
import kotlin.l0;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import org.jetbrains.annotations.NotNull;

/* compiled from: BuiltinSpecialProperties.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final f f56733a = new f();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Map<kotlin.reflect.jvm.internal.impl.name.c, kotlin.reflect.jvm.internal.impl.name.f> f56734b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final Map<kotlin.reflect.jvm.internal.impl.name.f, List<kotlin.reflect.jvm.internal.impl.name.f>> f56735c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final Set<kotlin.reflect.jvm.internal.impl.name.c> f56736d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final Set<kotlin.reflect.jvm.internal.impl.name.f> f56737e;

    static {
        kotlin.reflect.jvm.internal.impl.name.c d4;
        kotlin.reflect.jvm.internal.impl.name.c d5;
        kotlin.reflect.jvm.internal.impl.name.c c4;
        kotlin.reflect.jvm.internal.impl.name.c c5;
        kotlin.reflect.jvm.internal.impl.name.c d6;
        kotlin.reflect.jvm.internal.impl.name.c c6;
        kotlin.reflect.jvm.internal.impl.name.c c7;
        kotlin.reflect.jvm.internal.impl.name.c c8;
        Map<kotlin.reflect.jvm.internal.impl.name.c, kotlin.reflect.jvm.internal.impl.name.f> W;
        int Z;
        int j4;
        int Z2;
        Set<kotlin.reflect.jvm.internal.impl.name.f> L5;
        List L1;
        kotlin.reflect.jvm.internal.impl.name.d dVar = j.a.f56127s;
        d4 = g.d(dVar, "name");
        d5 = g.d(dVar, "ordinal");
        c4 = g.c(j.a.P, "size");
        kotlin.reflect.jvm.internal.impl.name.c cVar = j.a.T;
        c5 = g.c(cVar, "size");
        d6 = g.d(j.a.f56103g, "length");
        c6 = g.c(cVar, "keys");
        c7 = g.c(cVar, "values");
        c8 = g.c(cVar, "entries");
        W = z0.W(l0.a(d4, kotlin.reflect.jvm.internal.impl.name.f.f("name")), l0.a(d5, kotlin.reflect.jvm.internal.impl.name.f.f("ordinal")), l0.a(c4, kotlin.reflect.jvm.internal.impl.name.f.f("size")), l0.a(c5, kotlin.reflect.jvm.internal.impl.name.f.f("size")), l0.a(d6, kotlin.reflect.jvm.internal.impl.name.f.f("length")), l0.a(c6, kotlin.reflect.jvm.internal.impl.name.f.f("keySet")), l0.a(c7, kotlin.reflect.jvm.internal.impl.name.f.f("values")), l0.a(c8, kotlin.reflect.jvm.internal.impl.name.f.f("entrySet")));
        f56734b = W;
        Set<Map.Entry<kotlin.reflect.jvm.internal.impl.name.c, kotlin.reflect.jvm.internal.impl.name.f>> entrySet = W.entrySet();
        Z = kotlin.collections.y.Z(entrySet, 10);
        ArrayList<Pair> arrayList = new ArrayList(Z);
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            arrayList.add(new Pair(((kotlin.reflect.jvm.internal.impl.name.c) entry.getKey()).g(), entry.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair pair : arrayList) {
            kotlin.reflect.jvm.internal.impl.name.f fVar = (kotlin.reflect.jvm.internal.impl.name.f) pair.getSecond();
            Object obj = linkedHashMap.get(fVar);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(fVar, obj);
            }
            ((List) obj).add((kotlin.reflect.jvm.internal.impl.name.f) pair.getFirst());
        }
        j4 = y0.j(linkedHashMap.size());
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(j4);
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Object key = entry2.getKey();
            L1 = f0.L1((Iterable) entry2.getValue());
            linkedHashMap2.put(key, L1);
        }
        f56735c = linkedHashMap2;
        Set<kotlin.reflect.jvm.internal.impl.name.c> keySet = f56734b.keySet();
        f56736d = keySet;
        Z2 = kotlin.collections.y.Z(keySet, 10);
        ArrayList arrayList2 = new ArrayList(Z2);
        for (kotlin.reflect.jvm.internal.impl.name.c cVar2 : keySet) {
            arrayList2.add(cVar2.g());
        }
        L5 = f0.L5(arrayList2);
        f56737e = L5;
    }

    private f() {
    }

    @NotNull
    public final Map<kotlin.reflect.jvm.internal.impl.name.c, kotlin.reflect.jvm.internal.impl.name.f> a() {
        return f56734b;
    }

    @NotNull
    public final List<kotlin.reflect.jvm.internal.impl.name.f> b(@NotNull kotlin.reflect.jvm.internal.impl.name.f name1) {
        List<kotlin.reflect.jvm.internal.impl.name.f> F;
        kotlin.jvm.internal.f0.p(name1, "name1");
        List<kotlin.reflect.jvm.internal.impl.name.f> list = f56735c.get(name1);
        if (list == null) {
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }
        return list;
    }

    @NotNull
    public final Set<kotlin.reflect.jvm.internal.impl.name.c> c() {
        return f56736d;
    }

    @NotNull
    public final Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
        return f56737e;
    }
}

package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FakePureImplementationsProvider.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class l {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final l f56743a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<kotlin.reflect.jvm.internal.impl.name.c, kotlin.reflect.jvm.internal.impl.name.c> f56744b;

    static {
        l lVar = new l();
        f56743a = lVar;
        f56744b = new HashMap<>();
        lVar.c(j.a.Y, lVar.a("java.util.ArrayList", "java.util.LinkedList"));
        lVar.c(j.a.f56092a0, lVar.a("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        lVar.c(j.a.f56094b0, lVar.a("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        lVar.c(new kotlin.reflect.jvm.internal.impl.name.c("java.util.function.Function"), lVar.a("java.util.function.UnaryOperator"));
        lVar.c(new kotlin.reflect.jvm.internal.impl.name.c("java.util.function.BiFunction"), lVar.a("java.util.function.BinaryOperator"));
    }

    private l() {
    }

    private final List<kotlin.reflect.jvm.internal.impl.name.c> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        int length = strArr.length;
        int i4 = 0;
        while (i4 < length) {
            String str = strArr[i4];
            i4++;
            arrayList.add(new kotlin.reflect.jvm.internal.impl.name.c(str));
        }
        return arrayList;
    }

    private final void c(kotlin.reflect.jvm.internal.impl.name.c cVar, List<kotlin.reflect.jvm.internal.impl.name.c> list) {
        AbstractMap abstractMap = f56744b;
        for (Object obj : list) {
            kotlin.reflect.jvm.internal.impl.name.c cVar2 = (kotlin.reflect.jvm.internal.impl.name.c) obj;
            abstractMap.put(obj, cVar);
        }
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.name.c b(@NotNull kotlin.reflect.jvm.internal.impl.name.c classFqName) {
        f0.p(classFqName, "classFqName");
        return f56744b.get(classFqName);
    }
}

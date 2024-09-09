package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.y;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import org.jetbrains.annotations.NotNull;

/* compiled from: CompanionObjectMapping.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final c f56021a = new c();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Set<kotlin.reflect.jvm.internal.impl.name.b> f56022b;

    static {
        int Z;
        List p4;
        List p42;
        List<kotlin.reflect.jvm.internal.impl.name.c> p43;
        Set<PrimitiveType> set = PrimitiveType.NUMBER_TYPES;
        Z = y.Z(set, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (PrimitiveType primitiveType : set) {
            arrayList.add(j.c(primitiveType));
        }
        kotlin.reflect.jvm.internal.impl.name.c l4 = j.a.f56105h.l();
        f0.o(l4, "string.toSafe()");
        p4 = kotlin.collections.f0.p4(arrayList, l4);
        kotlin.reflect.jvm.internal.impl.name.c l5 = j.a.f56109j.l();
        f0.o(l5, "_boolean.toSafe()");
        p42 = kotlin.collections.f0.p4(p4, l5);
        kotlin.reflect.jvm.internal.impl.name.c l6 = j.a.f56127s.l();
        f0.o(l6, "_enum.toSafe()");
        p43 = kotlin.collections.f0.p4(p42, l6);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (kotlin.reflect.jvm.internal.impl.name.c cVar : p43) {
            linkedHashSet.add(kotlin.reflect.jvm.internal.impl.name.b.m(cVar));
        }
        f56022b = linkedHashSet;
    }

    private c() {
    }

    @NotNull
    public final Set<kotlin.reflect.jvm.internal.impl.name.b> a() {
        return f56022b;
    }

    @NotNull
    public final Set<kotlin.reflect.jvm.internal.impl.name.b> b() {
        return f56022b;
    }
}

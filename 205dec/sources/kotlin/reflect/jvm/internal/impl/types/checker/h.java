package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;

/* compiled from: KotlinTypeRefiner.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final c0<p<x>> f58279a = new c0<>("KotlinTypeRefiner");

    @NotNull
    public static final c0<p<x>> a() {
        return f58279a;
    }

    @NotNull
    public static final List<e0> b(@NotNull g gVar, @NotNull Iterable<? extends e0> types) {
        int Z;
        f0.p(gVar, "<this>");
        f0.p(types, "types");
        Z = kotlin.collections.y.Z(types, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (e0 e0Var : types) {
            arrayList.add(gVar.h(e0Var));
        }
        return arrayList;
    }
}

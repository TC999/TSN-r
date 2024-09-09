package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.j1;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.storage.n;
import kotlin.text.w;
import kotlin.text.x;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BuiltInFictitiousFunctionClassFactory.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a implements h2.b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final n f56027a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final d0 f56028b;

    public a(@NotNull n storageManager, @NotNull d0 module) {
        f0.p(storageManager, "storageManager");
        f0.p(module, "module");
        this.f56027a = storageManager;
        this.f56028b = module;
    }

    @Override // h2.b
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> a(@NotNull kotlin.reflect.jvm.internal.impl.name.c packageFqName) {
        Set k4;
        f0.p(packageFqName, "packageFqName");
        k4 = j1.k();
        return k4;
    }

    @Override // h2.b
    public boolean b(@NotNull kotlin.reflect.jvm.internal.impl.name.c packageFqName, @NotNull f name) {
        boolean u22;
        boolean u23;
        boolean u24;
        boolean u25;
        f0.p(packageFqName, "packageFqName");
        f0.p(name, "name");
        String b4 = name.b();
        f0.o(b4, "name.asString()");
        u22 = w.u2(b4, "Function", false, 2, null);
        if (!u22) {
            u23 = w.u2(b4, "KFunction", false, 2, null);
            if (!u23) {
                u24 = w.u2(b4, "SuspendFunction", false, 2, null);
                if (!u24) {
                    u25 = w.u2(b4, "KSuspendFunction", false, 2, null);
                    if (!u25) {
                        return false;
                    }
                }
            }
        }
        return FunctionClassKind.Companion.c(b4, packageFqName) != null;
    }

    @Override // h2.b
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.d c(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId) {
        boolean V2;
        Object r22;
        Object m22;
        f0.p(classId, "classId");
        if (classId.k() || classId.l()) {
            return null;
        }
        String b4 = classId.i().b();
        f0.o(b4, "classId.relativeClassName.asString()");
        V2 = x.V2(b4, "Function", false, 2, null);
        if (V2) {
            kotlin.reflect.jvm.internal.impl.name.c h4 = classId.h();
            f0.o(h4, "classId.packageFqName");
            FunctionClassKind.a.C1122a c4 = FunctionClassKind.Companion.c(b4, h4);
            if (c4 == null) {
                return null;
            }
            FunctionClassKind a4 = c4.a();
            int b5 = c4.b();
            List<g0> g02 = this.f56028b.j0(h4).g0();
            ArrayList arrayList = new ArrayList();
            for (Object obj : g02) {
                if (obj instanceof kotlin.reflect.jvm.internal.impl.builtins.b) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                if (obj2 instanceof kotlin.reflect.jvm.internal.impl.builtins.f) {
                    arrayList2.add(obj2);
                }
            }
            r22 = kotlin.collections.f0.r2(arrayList2);
            g0 g0Var = (kotlin.reflect.jvm.internal.impl.builtins.f) r22;
            if (g0Var == null) {
                m22 = kotlin.collections.f0.m2(arrayList);
                g0Var = (kotlin.reflect.jvm.internal.impl.builtins.b) m22;
            }
            return new b(this.f56027a, g0Var, a4, b5);
        }
        return null;
    }
}

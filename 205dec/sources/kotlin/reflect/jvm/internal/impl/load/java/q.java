package kotlin.reflect.jvm.internal.impl.load.java;

import i2.a;
import java.util.HashMap;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaDescriptorVisibilities.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class q {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.s f56977a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.s f56978b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.s f56979c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final Map<i1, kotlin.reflect.jvm.internal.impl.descriptors.s> f56980d;

    /* compiled from: JavaDescriptorVisibilities.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.descriptors.p {
        a(i1 i1Var) {
            super(i1Var);
        }

        private static /* synthetic */ void g(int i4) {
            Object[] objArr = new Object[3];
            if (i4 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$1";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.s
        public boolean e(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e eVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            return q.d(oVar, kVar);
        }
    }

    /* compiled from: JavaDescriptorVisibilities.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class b extends kotlin.reflect.jvm.internal.impl.descriptors.p {
        b(i1 i1Var) {
            super(i1Var);
        }

        private static /* synthetic */ void g(int i4) {
            Object[] objArr = new Object[3];
            if (i4 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.s
        public boolean e(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e eVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            return q.e(eVar, oVar, kVar);
        }
    }

    /* compiled from: JavaDescriptorVisibilities.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class c extends kotlin.reflect.jvm.internal.impl.descriptors.p {
        c(i1 i1Var) {
            super(i1Var);
        }

        private static /* synthetic */ void g(int i4) {
            Object[] objArr = new Object[3];
            if (i4 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$3";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.s
        public boolean e(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e eVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            return q.e(eVar, oVar, kVar);
        }
    }

    static {
        a aVar = new a(a.C1079a.f54762c);
        f56977a = aVar;
        b bVar = new b(a.c.f54764c);
        f56978b = bVar;
        c cVar = new c(a.b.f54763c);
        f56979c = cVar;
        f56980d = new HashMap();
        f(aVar);
        f(bVar);
        f(cVar);
    }

    private static /* synthetic */ void a(int i4) {
        String str = (i4 == 5 || i4 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i4 == 5 || i4 == 6) ? 2 : 3];
        switch (i4) {
            case 1:
                objArr[0] = "from";
                break;
            case 2:
                objArr[0] = "first";
                break;
            case 3:
                objArr[0] = "second";
                break;
            case 4:
                objArr[0] = "visibility";
                break;
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
                break;
            default:
                objArr[0] = "what";
                break;
        }
        if (i4 == 5 || i4 == 6) {
            objArr[1] = "toDescriptorVisibility";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
        }
        if (i4 == 2 || i4 == 3) {
            objArr[2] = "areInSamePackage";
        } else if (i4 == 4) {
            objArr[2] = "toDescriptorVisibility";
        } else if (i4 != 5 && i4 != 6) {
            objArr[2] = "isVisibleForProtectedAndPackage";
        }
        String format = String.format(str, objArr);
        if (i4 != 5 && i4 != 6) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar2) {
        if (kVar == null) {
            a(2);
        }
        if (kVar2 == null) {
            a(3);
        }
        g0 g0Var = (g0) kotlin.reflect.jvm.internal.impl.resolve.d.r(kVar, g0.class, false);
        g0 g0Var2 = (g0) kotlin.reflect.jvm.internal.impl.resolve.d.r(kVar2, g0.class, false);
        return (g0Var2 == null || g0Var == null || !g0Var.e().equals(g0Var2.e())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e eVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (oVar == null) {
            a(0);
        }
        if (kVar == null) {
            a(1);
        }
        if (d(kotlin.reflect.jvm.internal.impl.resolve.d.M(oVar), kVar)) {
            return true;
        }
        return kotlin.reflect.jvm.internal.impl.descriptors.r.f56529c.e(eVar, oVar, kVar);
    }

    private static void f(kotlin.reflect.jvm.internal.impl.descriptors.s sVar) {
        f56980d.put(sVar.b(), sVar);
    }

    @NotNull
    public static kotlin.reflect.jvm.internal.impl.descriptors.s g(@NotNull i1 i1Var) {
        if (i1Var == null) {
            a(4);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.s sVar = f56980d.get(i1Var);
        if (sVar == null) {
            kotlin.reflect.jvm.internal.impl.descriptors.s j4 = kotlin.reflect.jvm.internal.impl.descriptors.r.j(i1Var);
            if (j4 == null) {
                a(5);
            }
            return j4;
        }
        return sVar;
    }
}

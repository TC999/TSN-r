package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import m2.l;
import m2.n;
import m2.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaResolverCache.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f56702a = new a();

    /* compiled from: JavaResolverCache.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class a implements g {
        a() {
        }

        private static /* synthetic */ void f(int i4) {
            Object[] objArr = new Object[3];
            switch (i4) {
                case 1:
                    objArr[0] = "member";
                    break;
                case 2:
                case 4:
                case 6:
                case 8:
                    objArr[0] = "descriptor";
                    break;
                case 3:
                    objArr[0] = "element";
                    break;
                case 5:
                    objArr[0] = "field";
                    break;
                case 7:
                    objArr[0] = "javaClass";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1";
            switch (i4) {
                case 1:
                case 2:
                    objArr[2] = "recordMethod";
                    break;
                case 3:
                case 4:
                    objArr[2] = "recordConstructor";
                    break;
                case 5:
                case 6:
                    objArr[2] = "recordField";
                    break;
                case 7:
                case 8:
                    objArr[2] = "recordClass";
                    break;
                default:
                    objArr[2] = "getClassResolvedFromSource";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.components.g
        public void a(@NotNull m2.g gVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
            if (gVar == null) {
                f(7);
            }
            if (dVar == null) {
                f(8);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.components.g
        public void b(@NotNull n nVar, @NotNull p0 p0Var) {
            if (nVar == null) {
                f(5);
            }
            if (p0Var == null) {
                f(6);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.components.g
        public void c(@NotNull l lVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.j jVar) {
            if (lVar == null) {
                f(3);
            }
            if (jVar == null) {
                f(4);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.components.g
        @Nullable
        public kotlin.reflect.jvm.internal.impl.descriptors.d d(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar) {
            if (cVar == null) {
                f(0);
                return null;
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.components.g
        public void e(@NotNull q qVar, @NotNull u0 u0Var) {
            if (qVar == null) {
                f(1);
            }
            if (u0Var == null) {
                f(2);
            }
        }
    }

    void a(@NotNull m2.g gVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar);

    void b(@NotNull n nVar, @NotNull p0 p0Var);

    void c(@NotNull l lVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.j jVar);

    @Nullable
    kotlin.reflect.jvm.internal.impl.descriptors.d d(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar);

    void e(@NotNull q qVar, @NotNull u0 u0Var);
}

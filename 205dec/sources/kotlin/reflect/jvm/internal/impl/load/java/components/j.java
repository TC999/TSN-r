package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.types.e0;
import m2.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SignaturePropagator.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface j {

    /* renamed from: a  reason: collision with root package name */
    public static final j f56709a = new a();

    /* compiled from: SignaturePropagator.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class a implements j {
        a() {
        }

        private static /* synthetic */ void c(int i4) {
            Object[] objArr = new Object[3];
            switch (i4) {
                case 1:
                    objArr[0] = "owner";
                    break;
                case 2:
                    objArr[0] = "returnType";
                    break;
                case 3:
                    objArr[0] = "valueParameters";
                    break;
                case 4:
                    objArr[0] = "typeParameters";
                    break;
                case 5:
                    objArr[0] = "descriptor";
                    break;
                case 6:
                    objArr[0] = "signatureErrors";
                    break;
                default:
                    objArr[0] = "method";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1";
            if (i4 == 5 || i4 == 6) {
                objArr[2] = "reportSignatureErrors";
            } else {
                objArr[2] = "resolvePropagatedSignature";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.components.j
        public void a(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull List<String> list) {
            if (callableMemberDescriptor == null) {
                c(5);
            }
            if (list == null) {
                c(6);
            }
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.components.j
        @NotNull
        public b b(@NotNull r rVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull e0 e0Var, @Nullable e0 e0Var2, @NotNull List<d1> list, @NotNull List<a1> list2) {
            if (rVar == null) {
                c(0);
            }
            if (dVar == null) {
                c(1);
            }
            if (e0Var == null) {
                c(2);
            }
            if (list == null) {
                c(3);
            }
            if (list2 == null) {
                c(4);
            }
            return new b(e0Var, e0Var2, list, list2, Collections.emptyList(), false);
        }
    }

    /* compiled from: SignaturePropagator.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final e0 f56710a;

        /* renamed from: b  reason: collision with root package name */
        private final e0 f56711b;

        /* renamed from: c  reason: collision with root package name */
        private final List<d1> f56712c;

        /* renamed from: d  reason: collision with root package name */
        private final List<a1> f56713d;

        /* renamed from: e  reason: collision with root package name */
        private final List<String> f56714e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f56715f;

        public b(@NotNull e0 e0Var, @Nullable e0 e0Var2, @NotNull List<d1> list, @NotNull List<a1> list2, @NotNull List<String> list3, boolean z3) {
            if (e0Var == null) {
                a(0);
            }
            if (list == null) {
                a(1);
            }
            if (list2 == null) {
                a(2);
            }
            if (list3 == null) {
                a(3);
            }
            this.f56710a = e0Var;
            this.f56711b = e0Var2;
            this.f56712c = list;
            this.f56713d = list2;
            this.f56714e = list3;
            this.f56715f = z3;
        }

        private static /* synthetic */ void a(int i4) {
            String str = (i4 == 4 || i4 == 5 || i4 == 6 || i4 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i4 == 4 || i4 == 5 || i4 == 6 || i4 == 7) ? 2 : 3];
            switch (i4) {
                case 1:
                    objArr[0] = "valueParameters";
                    break;
                case 2:
                    objArr[0] = "typeParameters";
                    break;
                case 3:
                    objArr[0] = "signatureErrors";
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
                    break;
                default:
                    objArr[0] = "returnType";
                    break;
            }
            if (i4 == 4) {
                objArr[1] = "getReturnType";
            } else if (i4 == 5) {
                objArr[1] = "getValueParameters";
            } else if (i4 == 6) {
                objArr[1] = "getTypeParameters";
            } else if (i4 != 7) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
            } else {
                objArr[1] = "getErrors";
            }
            if (i4 != 4 && i4 != 5 && i4 != 6 && i4 != 7) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i4 != 4 && i4 != 5 && i4 != 6 && i4 != 7) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @NotNull
        public List<String> b() {
            List<String> list = this.f56714e;
            if (list == null) {
                a(7);
            }
            return list;
        }

        @Nullable
        public e0 c() {
            return this.f56711b;
        }

        @NotNull
        public e0 d() {
            e0 e0Var = this.f56710a;
            if (e0Var == null) {
                a(4);
            }
            return e0Var;
        }

        @NotNull
        public List<a1> e() {
            List<a1> list = this.f56713d;
            if (list == null) {
                a(6);
            }
            return list;
        }

        @NotNull
        public List<d1> f() {
            List<d1> list = this.f56712c;
            if (list == null) {
                a(5);
            }
            return list;
        }

        public boolean g() {
            return this.f56715f;
        }
    }

    void a(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull List<String> list);

    @NotNull
    b b(@NotNull r rVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull e0 e0Var, @Nullable e0 e0Var2, @NotNull List<d1> list, @NotNull List<a1> list2);
}

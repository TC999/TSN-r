package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.d0;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.f1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.g1;
import kotlin.reflect.jvm.internal.impl.types.h1;
import kotlin.reflect.jvm.internal.impl.types.l1;
import kotlin.reflect.jvm.internal.impl.types.m0;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r2.r;

/* compiled from: ClassicTypeSystemContext.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface b extends g1, r2.r {

    /* compiled from: ClassicTypeSystemContext.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {

        /* compiled from: ClassicTypeSystemContext.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.types.checker.b$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class C1180a extends TypeCheckerState.a.AbstractC1179a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f58274a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ f1 f58275b;

            C1180a(b bVar, f1 f1Var) {
                this.f58274a = bVar;
                this.f58275b = f1Var;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.a
            @NotNull
            public r2.i a(@NotNull TypeCheckerState state, @NotNull r2.g type) {
                f0.p(state, "state");
                f0.p(type, "type");
                b bVar = this.f58274a;
                e0 n4 = this.f58275b.n((e0) bVar.l(type), Variance.INVARIANT);
                f0.o(n4, "substitutor.safeSubstitu\u2026VARIANT\n                )");
                r2.i g4 = bVar.g(n4);
                f0.m(g4);
                return g4;
            }
        }

        public static boolean A(@NotNull b bVar, @NotNull r2.g receiver, @NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            f0.p(fqName, "fqName");
            if (receiver instanceof e0) {
                return ((e0) receiver).getAnnotations().i(fqName);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static r2.i A0(@NotNull b bVar, @NotNull r2.i receiver, boolean z3) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof m0) {
                return ((m0) receiver).O0(z3);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        public static boolean B(@NotNull b bVar, @NotNull r2.g receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            return r.a.d(bVar, receiver);
        }

        public static boolean C(@NotNull b bVar, @NotNull r2.n receiver, @Nullable r2.m mVar) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof a1) {
                if (mVar == null ? true : mVar instanceof y0) {
                    return kotlin.reflect.jvm.internal.impl.types.typeUtil.a.l((a1) receiver, (y0) mVar, null, 4, null);
                }
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        public static boolean D(@NotNull b bVar, @NotNull r2.i a4, @NotNull r2.i b4) {
            f0.p(bVar, "this");
            f0.p(a4, "a");
            f0.p(b4, "b");
            if (a4 instanceof m0) {
                if (b4 instanceof m0) {
                    return ((m0) a4).G0() == ((m0) b4).G0();
                }
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + b4 + ", " + n0.d(b4.getClass())).toString());
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + a4 + ", " + n0.d(a4.getClass())).toString());
        }

        @NotNull
        public static r2.g E(@NotNull b bVar, @NotNull List<? extends r2.g> types) {
            f0.p(bVar, "this");
            f0.p(types, "types");
            return d.a(types);
        }

        public static boolean F(@NotNull b bVar, @NotNull r2.m receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof y0) {
                return kotlin.reflect.jvm.internal.impl.builtins.h.u0((y0) receiver, j.a.f56093b);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        public static boolean G(@NotNull b bVar, @NotNull r2.g receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            return r.a.e(bVar, receiver);
        }

        public static boolean H(@NotNull b bVar, @NotNull r2.i receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            return r.a.f(bVar, receiver);
        }

        public static boolean I(@NotNull b bVar, @NotNull r2.m receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof y0) {
                return ((y0) receiver).b() instanceof kotlin.reflect.jvm.internal.impl.descriptors.d;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        public static boolean J(@NotNull b bVar, @NotNull r2.m receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof y0) {
                kotlin.reflect.jvm.internal.impl.descriptors.f b4 = ((y0) receiver).b();
                kotlin.reflect.jvm.internal.impl.descriptors.d dVar = b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) b4 : null;
                return (dVar == null || !b0.a(dVar) || dVar.i() == ClassKind.ENUM_ENTRY || dVar.i() == ClassKind.ANNOTATION_CLASS) ? false : true;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        public static boolean K(@NotNull b bVar, @NotNull r2.g receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            return r.a.g(bVar, receiver);
        }

        public static boolean L(@NotNull b bVar, @NotNull r2.m receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof y0) {
                return ((y0) receiver).c();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        public static boolean M(@NotNull b bVar, @NotNull r2.g receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            return r.a.h(bVar, receiver);
        }

        public static boolean N(@NotNull b bVar, @NotNull r2.g receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof e0) {
                return g0.a((e0) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        public static boolean O(@NotNull b bVar, @NotNull r2.m receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof y0) {
                kotlin.reflect.jvm.internal.impl.descriptors.f b4 = ((y0) receiver).b();
                kotlin.reflect.jvm.internal.impl.descriptors.d dVar = b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) b4 : null;
                return dVar != null && kotlin.reflect.jvm.internal.impl.resolve.e.b(dVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        public static boolean P(@NotNull b bVar, @NotNull r2.i receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            return r.a.i(bVar, receiver);
        }

        public static boolean Q(@NotNull b bVar, @NotNull r2.m receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof y0) {
                return receiver instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.n;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        public static boolean R(@NotNull b bVar, @NotNull r2.m receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof y0) {
                return receiver instanceof d0;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        public static boolean S(@NotNull b bVar, @NotNull r2.g receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            return r.a.j(bVar, receiver);
        }

        public static boolean T(@NotNull b bVar, @NotNull r2.i receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof m0) {
                return ((m0) receiver).I0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        public static boolean U(@NotNull b bVar, @NotNull r2.g receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            return r.a.k(bVar, receiver);
        }

        public static boolean V(@NotNull b bVar, @NotNull r2.m receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof y0) {
                return kotlin.reflect.jvm.internal.impl.builtins.h.u0((y0) receiver, j.a.f56095c);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        public static boolean W(@NotNull b bVar, @NotNull r2.g receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof e0) {
                return h1.m((e0) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        public static boolean X(@NotNull b bVar, @NotNull r2.b receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            return receiver instanceof kotlin.reflect.jvm.internal.impl.resolve.calls.inference.a;
        }

        public static boolean Y(@NotNull b bVar, @NotNull r2.i receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof e0) {
                return kotlin.reflect.jvm.internal.impl.builtins.h.q0((e0) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        public static boolean Z(@NotNull b bVar, @NotNull r2.b receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof i) {
                return ((i) receiver).T0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        public static boolean a(@NotNull b bVar, @NotNull r2.m c12, @NotNull r2.m c22) {
            f0.p(bVar, "this");
            f0.p(c12, "c1");
            f0.p(c22, "c2");
            if (c12 instanceof y0) {
                if (c22 instanceof y0) {
                    return f0.g(c12, c22);
                }
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + c22 + ", " + n0.d(c22.getClass())).toString());
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + c12 + ", " + n0.d(c12.getClass())).toString());
        }

        public static boolean a0(@NotNull b bVar, @NotNull r2.i receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof m0) {
                if (!g0.a((e0) receiver)) {
                    m0 m0Var = (m0) receiver;
                    if (!(m0Var.H0().b() instanceof z0) && (m0Var.H0().b() != null || (receiver instanceof kotlin.reflect.jvm.internal.impl.resolve.calls.inference.a) || (receiver instanceof i) || (receiver instanceof kotlin.reflect.jvm.internal.impl.types.n) || (m0Var.H0() instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.n) || b0(bVar, receiver))) {
                        return true;
                    }
                }
                return false;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        public static int b(@NotNull b bVar, @NotNull r2.g receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof e0) {
                return ((e0) receiver).G0().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        private static boolean b0(b bVar, r2.i iVar) {
            return (iVar instanceof o0) && bVar.e(((o0) iVar).C0());
        }

        @NotNull
        public static r2.k c(@NotNull b bVar, @NotNull r2.i receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof m0) {
                return (r2.k) receiver;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        public static boolean c0(@NotNull b bVar, @NotNull r2.l receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.a1) {
                return ((kotlin.reflect.jvm.internal.impl.types.a1) receiver).b();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @Nullable
        public static r2.b d(@NotNull b bVar, @NotNull r2.i receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof m0) {
                if (receiver instanceof o0) {
                    return bVar.b(((o0) receiver).C0());
                }
                if (receiver instanceof i) {
                    return (i) receiver;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        public static boolean d0(@NotNull b bVar, @NotNull r2.i receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof m0) {
                if (!(receiver instanceof kotlin.reflect.jvm.internal.impl.types.e)) {
                    if (!((receiver instanceof kotlin.reflect.jvm.internal.impl.types.n) && (((kotlin.reflect.jvm.internal.impl.types.n) receiver).T0() instanceof kotlin.reflect.jvm.internal.impl.types.e))) {
                        return false;
                    }
                }
                return true;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @Nullable
        public static r2.c e(@NotNull b bVar, @NotNull r2.i receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof m0) {
                if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.n) {
                    return (kotlin.reflect.jvm.internal.impl.types.n) receiver;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        public static boolean e0(@NotNull b bVar, @NotNull r2.i receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof m0) {
                if (!(receiver instanceof t0)) {
                    if (!((receiver instanceof kotlin.reflect.jvm.internal.impl.types.n) && (((kotlin.reflect.jvm.internal.impl.types.n) receiver).T0() instanceof t0))) {
                        return false;
                    }
                }
                return true;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @Nullable
        public static r2.d f(@NotNull b bVar, @NotNull r2.e receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.y) {
                if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.t) {
                    return (kotlin.reflect.jvm.internal.impl.types.t) receiver;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        public static boolean f0(@NotNull b bVar, @NotNull r2.g receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            return (receiver instanceof l1) && (((l1) receiver).H0() instanceof n);
        }

        @Nullable
        public static r2.e g(@NotNull b bVar, @NotNull r2.g receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof e0) {
                l1 K0 = ((e0) receiver).K0();
                if (K0 instanceof kotlin.reflect.jvm.internal.impl.types.y) {
                    return (kotlin.reflect.jvm.internal.impl.types.y) K0;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        public static boolean g0(@NotNull b bVar, @NotNull r2.m receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof y0) {
                kotlin.reflect.jvm.internal.impl.descriptors.f b4 = ((y0) receiver).b();
                return b4 != null && kotlin.reflect.jvm.internal.impl.builtins.h.z0(b4);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static r2.g getType(@NotNull b bVar, @NotNull r2.l receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.a1) {
                return ((kotlin.reflect.jvm.internal.impl.types.a1) receiver).getType().K0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @Nullable
        public static r2.i h(@NotNull b bVar, @NotNull r2.g receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof e0) {
                l1 K0 = ((e0) receiver).K0();
                if (K0 instanceof m0) {
                    return (m0) K0;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static r2.i h0(@NotNull b bVar, @NotNull r2.e receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.y) {
                return ((kotlin.reflect.jvm.internal.impl.types.y) receiver).P0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static r2.l i(@NotNull b bVar, @NotNull r2.g receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof e0) {
                return kotlin.reflect.jvm.internal.impl.types.typeUtil.a.a((e0) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static r2.i i0(@NotNull b bVar, @NotNull r2.g receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            return r.a.l(bVar, receiver);
        }

        @Nullable
        public static r2.i j(@NotNull b bVar, @NotNull r2.i type, @NotNull CaptureStatus status) {
            f0.p(bVar, "this");
            f0.p(type, "type");
            f0.p(status, "status");
            if (type instanceof m0) {
                return k.b((m0) type, status);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + type + ", " + n0.d(type.getClass())).toString());
        }

        @Nullable
        public static r2.g j0(@NotNull b bVar, @NotNull r2.b receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof i) {
                return ((i) receiver).S0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static CaptureStatus k(@NotNull b bVar, @NotNull r2.b receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof i) {
                return ((i) receiver).Q0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static r2.g k0(@NotNull b bVar, @NotNull r2.g receiver) {
            l1 b4;
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof l1) {
                b4 = c.b((l1) receiver);
                return b4;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static r2.g l(@NotNull b bVar, @NotNull r2.i lowerBound, @NotNull r2.i upperBound) {
            f0.p(bVar, "this");
            f0.p(lowerBound, "lowerBound");
            f0.p(upperBound, "upperBound");
            if (lowerBound instanceof m0) {
                if (upperBound instanceof m0) {
                    return kotlin.reflect.jvm.internal.impl.types.f0.d((m0) lowerBound, (m0) upperBound);
                }
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + bVar + ", " + n0.d(bVar.getClass())).toString());
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + bVar + ", " + n0.d(bVar.getClass())).toString());
        }

        @NotNull
        public static r2.g l0(@NotNull b bVar, @NotNull r2.g receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            return g1.a.a(bVar, receiver);
        }

        @Nullable
        public static List<r2.i> m(@NotNull b bVar, @NotNull r2.i receiver, @NotNull r2.m constructor) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            f0.p(constructor, "constructor");
            return r.a.a(bVar, receiver, constructor);
        }

        @NotNull
        public static TypeCheckerState m0(@NotNull b bVar, boolean z3, boolean z4) {
            f0.p(bVar, "this");
            return kotlin.reflect.jvm.internal.impl.types.checker.a.b(z3, z4, bVar, null, null, 24, null);
        }

        @NotNull
        public static r2.l n(@NotNull b bVar, @NotNull r2.k receiver, int i4) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            return r.a.b(bVar, receiver, i4);
        }

        @NotNull
        public static r2.i n0(@NotNull b bVar, @NotNull r2.c receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.n) {
                return ((kotlin.reflect.jvm.internal.impl.types.n) receiver).T0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static r2.l o(@NotNull b bVar, @NotNull r2.g receiver, int i4) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof e0) {
                return ((e0) receiver).G0().get(i4);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        public static int o0(@NotNull b bVar, @NotNull r2.m receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof y0) {
                return ((y0) receiver).getParameters().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @Nullable
        public static r2.l p(@NotNull b bVar, @NotNull r2.i receiver, int i4) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            return r.a.c(bVar, receiver, i4);
        }

        @NotNull
        public static Collection<r2.g> p0(@NotNull b bVar, @NotNull r2.i receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            r2.m f4 = bVar.f(receiver);
            if (f4 instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.n) {
                return ((kotlin.reflect.jvm.internal.impl.resolve.constants.n) f4).h();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static kotlin.reflect.jvm.internal.impl.name.d q(@NotNull b bVar, @NotNull r2.m receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof y0) {
                kotlin.reflect.jvm.internal.impl.descriptors.f b4 = ((y0) receiver).b();
                if (b4 != null) {
                    return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.j((kotlin.reflect.jvm.internal.impl.descriptors.d) b4);
                }
                throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static r2.l q0(@NotNull b bVar, @NotNull r2.a receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof j) {
                return ((j) receiver).getProjection();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static r2.n r(@NotNull b bVar, @NotNull r2.m receiver, int i4) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof y0) {
                a1 a1Var = ((y0) receiver).getParameters().get(i4);
                f0.o(a1Var, "this.parameters[index]");
                return a1Var;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        public static int r0(@NotNull b bVar, @NotNull r2.k receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            return r.a.m(bVar, receiver);
        }

        @Nullable
        public static PrimitiveType s(@NotNull b bVar, @NotNull r2.m receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof y0) {
                kotlin.reflect.jvm.internal.impl.descriptors.f b4 = ((y0) receiver).b();
                if (b4 != null) {
                    return kotlin.reflect.jvm.internal.impl.builtins.h.P((kotlin.reflect.jvm.internal.impl.descriptors.d) b4);
                }
                throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static TypeCheckerState.a s0(@NotNull b bVar, @NotNull r2.i type) {
            f0.p(bVar, "this");
            f0.p(type, "type");
            if (type instanceof m0) {
                return new C1180a(bVar, kotlin.reflect.jvm.internal.impl.types.z0.f58460c.a((e0) type).c());
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + type + ", " + n0.d(type.getClass())).toString());
        }

        @Nullable
        public static PrimitiveType t(@NotNull b bVar, @NotNull r2.m receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof y0) {
                kotlin.reflect.jvm.internal.impl.descriptors.f b4 = ((y0) receiver).b();
                if (b4 != null) {
                    return kotlin.reflect.jvm.internal.impl.builtins.h.S((kotlin.reflect.jvm.internal.impl.descriptors.d) b4);
                }
                throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static Collection<r2.g> t0(@NotNull b bVar, @NotNull r2.m receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof y0) {
                Collection<e0> j4 = ((y0) receiver).j();
                f0.o(j4, "this.supertypes");
                return j4;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static r2.g u(@NotNull b bVar, @NotNull r2.n receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof a1) {
                return kotlin.reflect.jvm.internal.impl.types.typeUtil.a.i((a1) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static r2.a u0(@NotNull b bVar, @NotNull r2.b receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof i) {
                return ((i) receiver).H0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @Nullable
        public static r2.g v(@NotNull b bVar, @NotNull r2.g receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof e0) {
                return kotlin.reflect.jvm.internal.impl.resolve.e.e((e0) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static r2.m v0(@NotNull b bVar, @NotNull r2.g receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            return r.a.n(bVar, receiver);
        }

        @Nullable
        public static r2.n w(@NotNull b bVar, @NotNull r2.t receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof n) {
                return ((n) receiver).a();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static r2.m w0(@NotNull b bVar, @NotNull r2.i receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof m0) {
                return ((m0) receiver).H0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @Nullable
        public static r2.n x(@NotNull b bVar, @NotNull r2.m receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof y0) {
                kotlin.reflect.jvm.internal.impl.descriptors.f b4 = ((y0) receiver).b();
                if (b4 instanceof a1) {
                    return (a1) b4;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static r2.i x0(@NotNull b bVar, @NotNull r2.e receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.y) {
                return ((kotlin.reflect.jvm.internal.impl.types.y) receiver).Q0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static TypeVariance y(@NotNull b bVar, @NotNull r2.l receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof kotlin.reflect.jvm.internal.impl.types.a1) {
                Variance c4 = ((kotlin.reflect.jvm.internal.impl.types.a1) receiver).c();
                f0.o(c4, "this.projectionKind");
                return r2.q.a(c4);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static r2.i y0(@NotNull b bVar, @NotNull r2.g receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            return r.a.o(bVar, receiver);
        }

        @NotNull
        public static TypeVariance z(@NotNull b bVar, @NotNull r2.n receiver) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof a1) {
                Variance o4 = ((a1) receiver).o();
                f0.o(o4, "this.variance");
                return r2.q.a(o4);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + n0.d(receiver.getClass())).toString());
        }

        @NotNull
        public static r2.g z0(@NotNull b bVar, @NotNull r2.g receiver, boolean z3) {
            f0.p(bVar, "this");
            f0.p(receiver, "receiver");
            if (receiver instanceof r2.i) {
                return bVar.a((r2.i) receiver, z3);
            }
            if (receiver instanceof r2.e) {
                r2.e eVar = (r2.e) receiver;
                return bVar.R(bVar.a(bVar.d(eVar), z3), bVar.a(bVar.c(eVar), z3));
            }
            throw new IllegalStateException("sealed".toString());
        }
    }

    @NotNull
    r2.g R(@NotNull r2.i iVar, @NotNull r2.i iVar2);

    @Override // r2.p
    @NotNull
    r2.i a(@NotNull r2.i iVar, boolean z3);

    @Override // r2.p
    @Nullable
    r2.b b(@NotNull r2.i iVar);

    @Override // r2.p
    @NotNull
    r2.i c(@NotNull r2.e eVar);

    @Override // r2.p
    @NotNull
    r2.i d(@NotNull r2.e eVar);

    @Override // r2.p
    boolean e(@NotNull r2.i iVar);

    @Override // r2.p
    @NotNull
    r2.m f(@NotNull r2.i iVar);

    @Override // r2.p
    @Nullable
    r2.i g(@NotNull r2.g gVar);
}

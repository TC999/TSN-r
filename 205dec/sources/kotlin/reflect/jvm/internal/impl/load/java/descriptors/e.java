package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import com.acse.ottn.f3;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.s;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaMethodDescriptor.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class e extends g0 implements kotlin.reflect.jvm.internal.impl.load.java.descriptors.a {
    public static final a.InterfaceC1126a<d1> F = new a();
    public static final a.InterfaceC1126a<Boolean> G = new b();
    static final /* synthetic */ boolean H = false;
    private c D;
    private final boolean E;

    /* compiled from: JavaMethodDescriptor.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class a implements a.InterfaceC1126a<d1> {
        a() {
        }
    }

    /* compiled from: JavaMethodDescriptor.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class b implements a.InterfaceC1126a<Boolean> {
        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JavaMethodDescriptor.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public enum c {
        NON_STABLE_DECLARED(false, false),
        STABLE_DECLARED(true, false),
        NON_STABLE_SYNTHESIZED(false, true),
        STABLE_SYNTHESIZED(true, true);
        

        /* renamed from: a  reason: collision with root package name */
        public final boolean f56726a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f56727b;

        c(boolean z3, boolean z4) {
            this.f56726a = z3;
            this.f56727b = z4;
        }

        private static /* synthetic */ void a(int i4) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor$ParameterNamesStatus", f3.f5657f));
        }

        @NotNull
        public static c b(boolean z3, boolean z4) {
            c cVar = z3 ? z4 ? STABLE_SYNTHESIZED : STABLE_DECLARED : z4 ? NON_STABLE_SYNTHESIZED : NON_STABLE_DECLARED;
            if (cVar == null) {
                a(0);
            }
            return cVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected e(@NotNull k kVar, @Nullable u0 u0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar2, @NotNull CallableMemberDescriptor.Kind kind, @NotNull v0 v0Var, boolean z3) {
        super(kVar, u0Var, fVar, fVar2, kind, v0Var);
        if (kVar == null) {
            B(0);
        }
        if (fVar == null) {
            B(1);
        }
        if (fVar2 == null) {
            B(2);
        }
        if (kind == null) {
            B(3);
        }
        if (v0Var == null) {
            B(4);
        }
        this.D = null;
        this.E = z3;
    }

    private static /* synthetic */ void B(int i4) {
        String str = (i4 == 12 || i4 == 17 || i4 == 20) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i4 == 12 || i4 == 17 || i4 == 20) ? 2 : 3];
        switch (i4) {
            case 1:
            case 6:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 14:
                objArr[0] = "kind";
                break;
            case 4:
            case 8:
            case 16:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 9:
                objArr[0] = "typeParameters";
                break;
            case 10:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 11:
                objArr[0] = "visibility";
                break;
            case 12:
            case 17:
            case 20:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 18:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 19:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i4 == 12) {
            objArr[1] = "initialize";
        } else if (i4 == 17) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i4 != 20) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i4) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "createJavaMethod";
                break;
            case 9:
            case 10:
            case 11:
                objArr[2] = "initialize";
                break;
            case 12:
            case 17:
            case 20:
                break;
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 18:
            case 19:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i4 != 12 && i4 != 17 && i4 != 20) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @NotNull
    public static e k1(@NotNull k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar2, @NotNull v0 v0Var, boolean z3) {
        if (kVar == null) {
            B(5);
        }
        if (fVar == null) {
            B(6);
        }
        if (fVar2 == null) {
            B(7);
        }
        if (v0Var == null) {
            B(8);
        }
        return new e(kVar, null, fVar, fVar2, CallableMemberDescriptor.Kind.DECLARATION, v0Var, z3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p
    public boolean L0() {
        return this.D.f56726a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean e0() {
        return this.D.f56727b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.g0
    @NotNull
    public g0 j1(@Nullable s0 s0Var, @Nullable s0 s0Var2, @NotNull List<? extends a1> list, @NotNull List<d1> list2, @Nullable e0 e0Var, @Nullable Modality modality, @NotNull s sVar, @Nullable Map<? extends a.InterfaceC1126a<?>, ?> map) {
        if (list == null) {
            B(9);
        }
        if (list2 == null) {
            B(10);
        }
        if (sVar == null) {
            B(11);
        }
        g0 j12 = super.j1(s0Var, s0Var2, list, list2, e0Var, modality, sVar, map);
        a1(kotlin.reflect.jvm.internal.impl.util.i.f58483a.a(j12).a());
        if (j12 == null) {
            B(12);
        }
        return j12;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.g0, kotlin.reflect.jvm.internal.impl.descriptors.impl.p
    @NotNull
    /* renamed from: l1 */
    public e G0(@NotNull k kVar, @Nullable w wVar, @NotNull CallableMemberDescriptor.Kind kind, @Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar2, @NotNull v0 v0Var) {
        if (kVar == null) {
            B(13);
        }
        if (kind == null) {
            B(14);
        }
        if (fVar2 == null) {
            B(15);
        }
        if (v0Var == null) {
            B(16);
        }
        u0 u0Var = (u0) wVar;
        if (fVar == null) {
            fVar = getName();
        }
        e eVar = new e(kVar, u0Var, fVar2, fVar, kind, v0Var, this.E);
        eVar.n1(L0(), e0());
        return eVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.a
    @NotNull
    /* renamed from: m1 */
    public e Z(@Nullable e0 e0Var, @NotNull List<i> list, @NotNull e0 e0Var2, @Nullable Pair<a.InterfaceC1126a<?>, ?> pair) {
        if (list == null) {
            B(18);
        }
        if (e0Var2 == null) {
            B(19);
        }
        e eVar = (e) x().b(h.a(list, h(), this)).m(e0Var2).e(e0Var == null ? null : kotlin.reflect.jvm.internal.impl.resolve.c.f(this, e0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b())).a().l().build();
        if (pair != null) {
            eVar.P0(pair.getFirst(), pair.getSecond());
        }
        if (eVar == null) {
            B(20);
        }
        return eVar;
    }

    public void n1(boolean z3, boolean z4) {
        this.D = c.b(z3, z4);
    }
}

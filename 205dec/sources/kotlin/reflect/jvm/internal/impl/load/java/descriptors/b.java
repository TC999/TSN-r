package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.List;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaClassConstructorDescriptor.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class b extends kotlin.reflect.jvm.internal.impl.descriptors.impl.f implements a {
    static final /* synthetic */ boolean H = false;
    private Boolean F;
    private Boolean G;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @Nullable b bVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, boolean z3, @NotNull CallableMemberDescriptor.Kind kind, @NotNull v0 v0Var) {
        super(dVar, bVar, fVar, z3, kind, v0Var);
        if (dVar == null) {
            B(0);
        }
        if (fVar == null) {
            B(1);
        }
        if (kind == null) {
            B(2);
        }
        if (v0Var == null) {
            B(3);
        }
        this.F = null;
        this.G = null;
    }

    private static /* synthetic */ void B(int i4) {
        String str = (i4 == 11 || i4 == 18) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i4 == 11 || i4 == 18) ? 2 : 3];
        switch (i4) {
            case 1:
            case 5:
            case 9:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 13:
                objArr[0] = "kind";
                break;
            case 3:
            case 6:
            case 10:
                objArr[0] = "source";
                break;
            case 4:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 7:
            case 12:
                objArr[0] = "newOwner";
                break;
            case 11:
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
                break;
            case 14:
                objArr[0] = "sourceElement";
                break;
            case 16:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 17:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i4 == 11) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i4 != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i4) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "createJavaConstructor";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 11:
            case 18:
                break;
            case 12:
            case 13:
            case 14:
            case 15:
                objArr[2] = "createDescriptor";
                break;
            case 16:
            case 17:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i4 != 11 && i4 != 18) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @NotNull
    public static b n1(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, boolean z3, @NotNull v0 v0Var) {
        if (dVar == null) {
            B(4);
        }
        if (fVar == null) {
            B(5);
        }
        if (v0Var == null) {
            B(6);
        }
        return new b(dVar, null, fVar, z3, CallableMemberDescriptor.Kind.DECLARATION, v0Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p
    public boolean L0() {
        return this.F.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p
    public void T0(boolean z3) {
        this.F = Boolean.valueOf(z3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p
    public void U0(boolean z3) {
        this.G = Boolean.valueOf(z3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean e0() {
        return this.G.booleanValue();
    }

    @NotNull
    protected b m1(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @Nullable b bVar, @NotNull CallableMemberDescriptor.Kind kind, @NotNull v0 v0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar) {
        if (dVar == null) {
            B(12);
        }
        if (kind == null) {
            B(13);
        }
        if (v0Var == null) {
            B(14);
        }
        if (fVar == null) {
            B(15);
        }
        return new b(dVar, bVar, fVar, this.D, kind, v0Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.f
    @NotNull
    /* renamed from: o1 */
    public b i1(@NotNull k kVar, @Nullable w wVar, @NotNull CallableMemberDescriptor.Kind kind, @Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar2, @NotNull v0 v0Var) {
        if (kVar == null) {
            B(7);
        }
        if (kind == null) {
            B(8);
        }
        if (fVar2 == null) {
            B(9);
        }
        if (v0Var == null) {
            B(10);
        }
        if (kind != CallableMemberDescriptor.Kind.DECLARATION && kind != CallableMemberDescriptor.Kind.SYNTHESIZED) {
            throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + kVar + "\nkind: " + kind);
        }
        b m12 = m1((kotlin.reflect.jvm.internal.impl.descriptors.d) kVar, (b) wVar, kind, v0Var, fVar2);
        m12.T0(L0());
        m12.U0(e0());
        return m12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.a
    @NotNull
    /* renamed from: p1 */
    public b Z(@Nullable e0 e0Var, @NotNull List<i> list, @NotNull e0 e0Var2, @Nullable Pair<a.InterfaceC1126a<?>, ?> pair) {
        if (list == null) {
            B(16);
        }
        if (e0Var2 == null) {
            B(17);
        }
        b i12 = i1(b(), null, i(), null, getAnnotations(), getSource());
        i12.M0(e0Var == null ? null : kotlin.reflect.jvm.internal.impl.resolve.c.f(i12, e0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b()), M(), getTypeParameters(), h.a(list, h(), i12), e0Var2, s(), getVisibility());
        if (pair != null) {
            i12.P0(pair.getFirst(), pair.getSecond());
        }
        return i12;
    }
}

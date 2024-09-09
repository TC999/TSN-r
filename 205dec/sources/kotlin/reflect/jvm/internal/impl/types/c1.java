package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

/* compiled from: TypeProjectionImpl.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class c1 extends b1 {

    /* renamed from: a  reason: collision with root package name */
    private final Variance f58272a;

    /* renamed from: b  reason: collision with root package name */
    private final e0 f58273b;

    public c1(@NotNull Variance variance, @NotNull e0 e0Var) {
        if (variance == null) {
            d(0);
        }
        if (e0Var == null) {
            d(1);
        }
        this.f58272a = variance;
        this.f58273b = e0Var;
    }

    private static /* synthetic */ void d(int i4) {
        String str = (i4 == 4 || i4 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i4 == 4 || i4 == 5) ? 2 : 3];
        switch (i4) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "type";
                break;
            case 4:
            case 5:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
                break;
            case 6:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "projection";
                break;
        }
        if (i4 == 4) {
            objArr[1] = "getProjectionKind";
        } else if (i4 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
        } else {
            objArr[1] = "getType";
        }
        if (i4 == 3) {
            objArr[2] = "replaceType";
        } else if (i4 != 4 && i4 != 5) {
            if (i4 != 6) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "refine";
            }
        }
        String format = String.format(str, objArr);
        if (i4 != 4 && i4 != 5) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.a1
    @NotNull
    public a1 a(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (gVar == null) {
            d(6);
        }
        return new c1(this.f58272a, gVar.h(this.f58273b));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.a1
    public boolean b() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.a1
    @NotNull
    public Variance c() {
        Variance variance = this.f58272a;
        if (variance == null) {
            d(4);
        }
        return variance;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.a1
    @NotNull
    public e0 getType() {
        e0 e0Var = this.f58273b;
        if (e0Var == null) {
            d(5);
        }
        return e0Var;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c1(@NotNull e0 e0Var) {
        this(Variance.INVARIANT, e0Var);
        if (e0Var == null) {
            d(2);
        }
    }
}

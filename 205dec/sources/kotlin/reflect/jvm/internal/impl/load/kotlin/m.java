package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.k;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;

/* compiled from: methodSignatureMapping.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class m implements l<k> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final m f57248a = new m();

    /* compiled from: methodSignatureMapping.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f57249a;

        static {
            int[] iArr = new int[PrimitiveType.values().length];
            iArr[PrimitiveType.BOOLEAN.ordinal()] = 1;
            iArr[PrimitiveType.CHAR.ordinal()] = 2;
            iArr[PrimitiveType.BYTE.ordinal()] = 3;
            iArr[PrimitiveType.SHORT.ordinal()] = 4;
            iArr[PrimitiveType.INT.ordinal()] = 5;
            iArr[PrimitiveType.FLOAT.ordinal()] = 6;
            iArr[PrimitiveType.LONG.ordinal()] = 7;
            iArr[PrimitiveType.DOUBLE.ordinal()] = 8;
            f57249a = iArr;
        }
    }

    private m() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.l
    @NotNull
    /* renamed from: g */
    public k b(@NotNull k possiblyPrimitiveType) {
        f0.p(possiblyPrimitiveType, "possiblyPrimitiveType");
        if (possiblyPrimitiveType instanceof k.d) {
            k.d dVar = (k.d) possiblyPrimitiveType;
            if (dVar.i() != null) {
                String f4 = kotlin.reflect.jvm.internal.impl.resolve.jvm.d.c(dVar.i().getWrapperFqName()).f();
                f0.o(f4, "byFqNameWithoutInnerClas\u2026apperFqName).internalName");
                return e(f4);
            }
            return possiblyPrimitiveType;
        }
        return possiblyPrimitiveType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.l
    @NotNull
    /* renamed from: h */
    public k a(@NotNull String representation) {
        JvmPrimitiveType jvmPrimitiveType;
        k cVar;
        boolean z3;
        f0.p(representation, "representation");
        representation.length();
        char charAt = representation.charAt(0);
        JvmPrimitiveType[] values = JvmPrimitiveType.values();
        int length = values.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                jvmPrimitiveType = null;
                break;
            }
            jvmPrimitiveType = values[i4];
            i4++;
            if (jvmPrimitiveType.getDesc().charAt(0) == charAt) {
                z3 = true;
                continue;
            } else {
                z3 = false;
                continue;
            }
            if (z3) {
                break;
            }
        }
        if (jvmPrimitiveType == null) {
            if (charAt == 'V') {
                return new k.d(null);
            }
            if (charAt == '[') {
                String substring = representation.substring(1);
                f0.o(substring, "this as java.lang.String).substring(startIndex)");
                cVar = new k.a(a(substring));
            } else {
                if (charAt == 'L') {
                    kotlin.text.x.a3(representation, ';', false, 2, null);
                }
                String substring2 = representation.substring(1, representation.length() - 1);
                f0.o(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                cVar = new k.c(substring2);
            }
            return cVar;
        }
        return new k.d(jvmPrimitiveType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.l
    @NotNull
    /* renamed from: i */
    public k.c e(@NotNull String internalName) {
        f0.p(internalName, "internalName");
        return new k.c(internalName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.l
    @NotNull
    /* renamed from: j */
    public k c(@NotNull PrimitiveType primitiveType) {
        f0.p(primitiveType, "primitiveType");
        switch (a.f57249a[primitiveType.ordinal()]) {
            case 1:
                return k.f57236a.a();
            case 2:
                return k.f57236a.c();
            case 3:
                return k.f57236a.b();
            case 4:
                return k.f57236a.h();
            case 5:
                return k.f57236a.f();
            case 6:
                return k.f57236a.e();
            case 7:
                return k.f57236a.g();
            case 8:
                return k.f57236a.d();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.l
    @NotNull
    /* renamed from: k */
    public k f() {
        return e("java/lang/Class");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.l
    @NotNull
    /* renamed from: l */
    public String d(@NotNull k type) {
        f0.p(type, "type");
        if (type instanceof k.a) {
            return f0.C("[", d(((k.a) type).i()));
        }
        if (type instanceof k.d) {
            JvmPrimitiveType i4 = ((k.d) type).i();
            String desc = i4 == null ? "V" : i4.getDesc();
            f0.o(desc, "type.jvmPrimitiveType?.desc ?: \"V\"");
            return desc;
        } else if (type instanceof k.c) {
            return 'L' + ((k.c) type).i() + ';';
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}

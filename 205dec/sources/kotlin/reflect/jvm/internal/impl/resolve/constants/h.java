package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConstantValueFactory.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final h f57831a = new h();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstantValueFactory.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends Lambda implements d2.l<d0, e0> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e0 f57832a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(e0 e0Var) {
            super(1);
            this.f57832a = e0Var;
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final e0 invoke(@NotNull d0 it) {
            f0.p(it, "it");
            return this.f57832a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstantValueFactory.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends Lambda implements d2.l<d0, e0> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PrimitiveType f57833a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(PrimitiveType primitiveType) {
            super(1);
            this.f57833a = primitiveType;
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final e0 invoke(@NotNull d0 module) {
            f0.p(module, "module");
            m0 O = module.k().O(this.f57833a);
            f0.o(O, "module.builtIns.getPrimi\u2026KotlinType(componentType)");
            return O;
        }
    }

    private h() {
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.b a(List<?> list, PrimitiveType primitiveType) {
        List<Object> G5;
        G5 = kotlin.collections.f0.G5(list);
        ArrayList arrayList = new ArrayList();
        for (Object obj : G5) {
            g<?> c4 = c(obj);
            if (c4 != null) {
                arrayList.add(c4);
            }
        }
        return new kotlin.reflect.jvm.internal.impl.resolve.constants.b(arrayList, new b(primitiveType));
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.resolve.constants.b b(@NotNull List<? extends g<?>> value, @NotNull e0 type) {
        f0.p(value, "value");
        f0.p(type, "type");
        return new kotlin.reflect.jvm.internal.impl.resolve.constants.b(value, new a(type));
    }

    @Nullable
    public final g<?> c(@Nullable Object obj) {
        List<?> gy;
        List<?> ay;
        List<?> by;
        List<?> Zx;
        List<?> dy;
        List<?> cy;
        List<?> fy;
        List<?> Yx;
        if (obj instanceof Byte) {
            return new d(((Number) obj).byteValue());
        }
        if (obj instanceof Short) {
            return new u(((Number) obj).shortValue());
        }
        if (obj instanceof Integer) {
            return new m(((Number) obj).intValue());
        }
        if (obj instanceof Long) {
            return new r(((Number) obj).longValue());
        }
        if (obj instanceof Character) {
            return new e(((Character) obj).charValue());
        }
        if (obj instanceof Float) {
            return new l(((Number) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new i(((Number) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return new c(((Boolean) obj).booleanValue());
        }
        if (obj instanceof String) {
            return new v((String) obj);
        }
        if (obj instanceof byte[]) {
            Yx = kotlin.collections.p.Yx((byte[]) obj);
            return a(Yx, PrimitiveType.BYTE);
        } else if (obj instanceof short[]) {
            fy = kotlin.collections.p.fy((short[]) obj);
            return a(fy, PrimitiveType.SHORT);
        } else if (obj instanceof int[]) {
            cy = kotlin.collections.p.cy((int[]) obj);
            return a(cy, PrimitiveType.INT);
        } else if (obj instanceof long[]) {
            dy = kotlin.collections.p.dy((long[]) obj);
            return a(dy, PrimitiveType.LONG);
        } else if (obj instanceof char[]) {
            Zx = kotlin.collections.p.Zx((char[]) obj);
            return a(Zx, PrimitiveType.CHAR);
        } else if (obj instanceof float[]) {
            by = kotlin.collections.p.by((float[]) obj);
            return a(by, PrimitiveType.FLOAT);
        } else if (obj instanceof double[]) {
            ay = kotlin.collections.p.ay((double[]) obj);
            return a(ay, PrimitiveType.DOUBLE);
        } else if (obj instanceof boolean[]) {
            gy = kotlin.collections.p.gy((boolean[]) obj);
            return a(gy, PrimitiveType.BOOLEAN);
        } else if (obj == null) {
            return new s();
        } else {
            return null;
        }
    }
}

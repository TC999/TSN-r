package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Set;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.j1;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.p;
import kotlin.r;
import org.jetbrains.annotations.NotNull;

/* compiled from: PrimitiveType.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public enum PrimitiveType {
    BOOLEAN("Boolean"),
    CHAR("Char"),
    BYTE("Byte"),
    SHORT("Short"),
    INT("Int"),
    FLOAT("Float"),
    LONG("Long"),
    DOUBLE("Double");
    
    @NotNull
    public static final a Companion = new a(null);
    @JvmField
    @NotNull
    public static final Set<PrimitiveType> NUMBER_TYPES;
    @NotNull
    private final p arrayTypeFqName$delegate;
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.name.f arrayTypeName;
    @NotNull
    private final p typeFqName$delegate;
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.name.f typeName;

    /* compiled from: PrimitiveType.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    /* compiled from: PrimitiveType.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.a<kotlin.reflect.jvm.internal.impl.name.c> {
        b() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.name.c invoke() {
            kotlin.reflect.jvm.internal.impl.name.c c4 = j.f56084m.c(PrimitiveType.this.getArrayTypeName());
            f0.o(c4, "BUILT_INS_PACKAGE_FQ_NAME.child(arrayTypeName)");
            return c4;
        }
    }

    /* compiled from: PrimitiveType.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.a<kotlin.reflect.jvm.internal.impl.name.c> {
        c() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.name.c invoke() {
            kotlin.reflect.jvm.internal.impl.name.c c4 = j.f56084m.c(PrimitiveType.this.getTypeName());
            f0.o(c4, "BUILT_INS_PACKAGE_FQ_NAME.child(this.typeName)");
            return c4;
        }
    }

    static {
        PrimitiveType primitiveType;
        PrimitiveType primitiveType2;
        PrimitiveType primitiveType3;
        PrimitiveType primitiveType4;
        PrimitiveType primitiveType5;
        PrimitiveType primitiveType6;
        Set<PrimitiveType> u3;
        u3 = j1.u(r0, primitiveType, primitiveType2, primitiveType3, primitiveType4, primitiveType5, primitiveType6);
        NUMBER_TYPES = u3;
    }

    PrimitiveType(String str) {
        p c4;
        p c5;
        kotlin.reflect.jvm.internal.impl.name.f f4 = kotlin.reflect.jvm.internal.impl.name.f.f(str);
        f0.o(f4, "identifier(typeName)");
        this.typeName = f4;
        kotlin.reflect.jvm.internal.impl.name.f f5 = kotlin.reflect.jvm.internal.impl.name.f.f(f0.C(str, "Array"));
        f0.o(f5, "identifier(\"${typeName}Array\")");
        this.arrayTypeName = f5;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        c4 = r.c(lazyThreadSafetyMode, new c());
        this.typeFqName$delegate = c4;
        c5 = r.c(lazyThreadSafetyMode, new b());
        this.arrayTypeFqName$delegate = c5;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.c getArrayTypeFqName() {
        return (kotlin.reflect.jvm.internal.impl.name.c) this.arrayTypeFqName$delegate.getValue();
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.f getArrayTypeName() {
        return this.arrayTypeName;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.c getTypeFqName() {
        return (kotlin.reflect.jvm.internal.impl.name.c) this.typeFqName$delegate.getValue();
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.f getTypeName() {
        return this.typeName;
    }
}

package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.d;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.d;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RuntimeTypeMapper.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0003\u0006\u0007\bB\t\b\u0004\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H&\u0082\u0001\u0004\t\n\u000b\f\u00a8\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/e;", "", "", "a", "<init>", "()V", "b", "c", "d", "Lkotlin/reflect/jvm/internal/e$c;", "Lkotlin/reflect/jvm/internal/e$b;", "Lkotlin/reflect/jvm/internal/e$a;", "Lkotlin/reflect/jvm/internal/e$d;", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class e {

    /* compiled from: RuntimeTypeMapper.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0004\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/e$a;", "Lkotlin/reflect/jvm/internal/e;", "", "a", "Ljava/lang/reflect/Field;", "Ljava/lang/reflect/Field;", "b", "()Ljava/lang/reflect/Field;", "field", "<init>", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends e {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final Field f55930a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull Field field) {
            super(null);
            kotlin.jvm.internal.f0.p(field, "field");
            this.f55930a = field;
        }

        @Override // kotlin.reflect.jvm.internal.e
        @NotNull
        public String a() {
            StringBuilder sb = new StringBuilder();
            String name = this.f55930a.getName();
            kotlin.jvm.internal.f0.o(name, "field.name");
            sb.append(kotlin.reflect.jvm.internal.impl.load.java.x.b(name));
            sb.append("()");
            Class<?> type = this.f55930a.getType();
            kotlin.jvm.internal.f0.o(type, "field.type");
            sb.append(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.b(type));
            return sb.toString();
        }

        @NotNull
        public final Field b() {
            return this.f55930a;
        }
    }

    /* compiled from: RuntimeTypeMapper.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0005\u001a\u0004\b\t\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/e$b;", "Lkotlin/reflect/jvm/internal/e;", "", "a", "Ljava/lang/reflect/Method;", "Ljava/lang/reflect/Method;", "b", "()Ljava/lang/reflect/Method;", "getterMethod", "c", "setterMethod", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends e {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final Method f55931a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final Method f55932b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull Method getterMethod, @Nullable Method method) {
            super(null);
            kotlin.jvm.internal.f0.p(getterMethod, "getterMethod");
            this.f55931a = getterMethod;
            this.f55932b = method;
        }

        @Override // kotlin.reflect.jvm.internal.e
        @NotNull
        public String a() {
            String b4;
            b4 = c0.b(this.f55931a);
            return b4;
        }

        @NotNull
        public final Method b() {
            return this.f55931a;
        }

        @Nullable
        public final Method c() {
            return this.f55932b;
        }
    }

    /* compiled from: RuntimeTypeMapper.kt */
    @Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\u0006\u0010 \u001a\u00020\u001b\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lkotlin/reflect/jvm/internal/e$c;", "Lkotlin/reflect/jvm/internal/e;", "", "c", "a", "Lkotlin/reflect/jvm/internal/impl/descriptors/p0;", "Lkotlin/reflect/jvm/internal/impl/descriptors/p0;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;", "b", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;", "getProto", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;", "proto", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/c;", "d", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/c;", "getNameResolver", "()Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/g;", "e", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/g;", "getTypeTable", "()Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;", "typeTable", "f", "Ljava/lang/String;", "string", "<init>", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends e {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final p0 f55933a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final ProtoBuf.Property f55934b;
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private final JvmProtoBuf.JvmPropertySignature f55935c;
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.c f55936d;
        @NotNull

        /* renamed from: e  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.g f55937e;
        @NotNull

        /* renamed from: f  reason: collision with root package name */
        private final String f55938f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull p0 descriptor, @NotNull ProtoBuf.Property proto, @NotNull JvmProtoBuf.JvmPropertySignature signature, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.g typeTable) {
            super(null);
            String str;
            kotlin.jvm.internal.f0.p(descriptor, "descriptor");
            kotlin.jvm.internal.f0.p(proto, "proto");
            kotlin.jvm.internal.f0.p(signature, "signature");
            kotlin.jvm.internal.f0.p(nameResolver, "nameResolver");
            kotlin.jvm.internal.f0.p(typeTable, "typeTable");
            this.f55933a = descriptor;
            this.f55934b = proto;
            this.f55935c = signature;
            this.f55936d = nameResolver;
            this.f55937e = typeTable;
            if (signature.hasGetter()) {
                str = kotlin.jvm.internal.f0.C(nameResolver.getString(signature.getGetter().getName()), nameResolver.getString(signature.getGetter().getDesc()));
            } else {
                d.a d4 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.g.d(kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.g.f57549a, proto, nameResolver, typeTable, false, 8, null);
                if (d4 != null) {
                    String d5 = d4.d();
                    str = kotlin.reflect.jvm.internal.impl.load.java.x.b(d5) + c() + "()" + d4.e();
                } else {
                    throw new KotlinReflectionInternalError(kotlin.jvm.internal.f0.C("No field signature for property: ", descriptor));
                }
            }
            this.f55938f = str;
        }

        private final String c() {
            kotlin.reflect.jvm.internal.impl.descriptors.k b4 = this.f55933a.b();
            kotlin.jvm.internal.f0.o(b4, "descriptor.containingDeclaration");
            if (kotlin.jvm.internal.f0.g(this.f55933a.getVisibility(), kotlin.reflect.jvm.internal.impl.descriptors.r.f56530d) && (b4 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e)) {
                ProtoBuf.Class U0 = ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e) b4).U0();
                GeneratedMessageLite.f<ProtoBuf.Class, Integer> classModuleName = JvmProtoBuf.f57495i;
                kotlin.jvm.internal.f0.o(classModuleName, "classModuleName");
                Integer num = (Integer) kotlin.reflect.jvm.internal.impl.metadata.deserialization.e.a(U0, classModuleName);
                return kotlin.jvm.internal.f0.C("$", kotlin.reflect.jvm.internal.impl.name.g.a(num == null ? "main" : this.f55936d.getString(num.intValue())));
            } else if (kotlin.jvm.internal.f0.g(this.f55933a.getVisibility(), kotlin.reflect.jvm.internal.impl.descriptors.r.f56527a) && (b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.g0)) {
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f K = ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.i) this.f55933a).K();
                if (K instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.j) {
                    kotlin.reflect.jvm.internal.impl.load.kotlin.j jVar = (kotlin.reflect.jvm.internal.impl.load.kotlin.j) K;
                    return jVar.e() != null ? kotlin.jvm.internal.f0.C("$", jVar.g().b()) : "";
                }
                return "";
            } else {
                return "";
            }
        }

        @Override // kotlin.reflect.jvm.internal.e
        @NotNull
        public String a() {
            return this.f55938f;
        }

        @NotNull
        public final p0 b() {
            return this.f55933a;
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.c d() {
            return this.f55936d;
        }

        @NotNull
        public final ProtoBuf.Property e() {
            return this.f55934b;
        }

        @NotNull
        public final JvmProtoBuf.JvmPropertySignature f() {
            return this.f55935c;
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.g g() {
            return this.f55937e;
        }
    }

    /* compiled from: RuntimeTypeMapper.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0005\u001a\u0004\b\t\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/e$d;", "Lkotlin/reflect/jvm/internal/e;", "", "a", "Lkotlin/reflect/jvm/internal/d$e;", "Lkotlin/reflect/jvm/internal/d$e;", "b", "()Lkotlin/reflect/jvm/internal/d$e;", "getterSignature", "c", "setterSignature", "<init>", "(Lkotlin/reflect/jvm/internal/d$e;Lkotlin/reflect/jvm/internal/d$e;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d extends e {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final d.e f55939a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final d.e f55940b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull d.e getterSignature, @Nullable d.e eVar) {
            super(null);
            kotlin.jvm.internal.f0.p(getterSignature, "getterSignature");
            this.f55939a = getterSignature;
            this.f55940b = eVar;
        }

        @Override // kotlin.reflect.jvm.internal.e
        @NotNull
        public String a() {
            return this.f55939a.a();
        }

        @NotNull
        public final d.e b() {
            return this.f55939a;
        }

        @Nullable
        public final d.e c() {
            return this.f55940b;
        }
    }

    private e() {
    }

    public /* synthetic */ e(kotlin.jvm.internal.u uVar) {
        this();
    }

    @NotNull
    public abstract String a();
}

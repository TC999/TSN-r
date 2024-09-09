package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.d;
import kotlin.reflect.jvm.internal.e;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.q0;
import kotlin.reflect.jvm.internal.impl.descriptors.r0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.d;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;

/* compiled from: RuntimeTypeMapper.kt */
@Metadata(bv = {}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\bH\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eJ\u0012\u0010\u0015\u001a\u00020\u00142\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u0018*\u0006\u0012\u0002\b\u00030\u00128BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lkotlin/reflect/jvm/internal/b0;", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/w;", "descriptor", "", "b", "Lkotlin/reflect/jvm/internal/d$e;", "d", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "", "e", "possiblySubstitutedFunction", "Lkotlin/reflect/jvm/internal/d;", "g", "Lkotlin/reflect/jvm/internal/impl/descriptors/p0;", "possiblyOverriddenProperty", "Lkotlin/reflect/jvm/internal/e;", "f", "Ljava/lang/Class;", "klass", "Lkotlin/reflect/jvm/internal/impl/name/b;", "c", "Lkotlin/reflect/jvm/internal/impl/name/b;", "JAVA_LANG_VOID", "Lkotlin/reflect/jvm/internal/impl/builtins/PrimitiveType;", "getPrimitiveType", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "primitiveType", "<init>", "()V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b0 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final b0 f55877a = new b0();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.b f55878b;

    static {
        kotlin.reflect.jvm.internal.impl.name.b m4 = kotlin.reflect.jvm.internal.impl.name.b.m(new kotlin.reflect.jvm.internal.impl.name.c("java.lang.Void"));
        kotlin.jvm.internal.f0.o(m4, "topLevel(FqName(\"java.lang.Void\"))");
        f55878b = m4;
    }

    private b0() {
    }

    private final PrimitiveType a(Class<?> cls) {
        if (cls.isPrimitive()) {
            return JvmPrimitiveType.get(cls.getSimpleName()).getPrimitiveType();
        }
        return null;
    }

    private final boolean b(kotlin.reflect.jvm.internal.impl.descriptors.w wVar) {
        if (kotlin.reflect.jvm.internal.impl.resolve.c.m(wVar) || kotlin.reflect.jvm.internal.impl.resolve.c.n(wVar)) {
            return true;
        }
        return kotlin.jvm.internal.f0.g(wVar.getName(), kotlin.reflect.jvm.internal.impl.builtins.jvm.a.f56155e.a()) && wVar.h().isEmpty();
    }

    private final d.e d(kotlin.reflect.jvm.internal.impl.descriptors.w wVar) {
        return new d.e(new d.b(e(wVar), kotlin.reflect.jvm.internal.impl.load.kotlin.u.c(wVar, false, false, 1, null)));
    }

    private final String e(CallableMemberDescriptor callableMemberDescriptor) {
        String b4 = kotlin.reflect.jvm.internal.impl.load.java.d0.b(callableMemberDescriptor);
        if (b4 == null) {
            if (callableMemberDescriptor instanceof q0) {
                String b5 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.o(callableMemberDescriptor).getName().b();
                kotlin.jvm.internal.f0.o(b5, "descriptor.propertyIfAccessor.name.asString()");
                return kotlin.reflect.jvm.internal.impl.load.java.x.b(b5);
            } else if (callableMemberDescriptor instanceof r0) {
                String b6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.o(callableMemberDescriptor).getName().b();
                kotlin.jvm.internal.f0.o(b6, "descriptor.propertyIfAccessor.name.asString()");
                return kotlin.reflect.jvm.internal.impl.load.java.x.e(b6);
            } else {
                String b7 = callableMemberDescriptor.getName().b();
                kotlin.jvm.internal.f0.o(b7, "descriptor.name.asString()");
                return b7;
            }
        }
        return b4;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.b c(@NotNull Class<?> klass) {
        kotlin.jvm.internal.f0.p(klass, "klass");
        if (klass.isArray()) {
            Class<?> componentType = klass.getComponentType();
            kotlin.jvm.internal.f0.o(componentType, "klass.componentType");
            PrimitiveType a4 = a(componentType);
            if (a4 == null) {
                kotlin.reflect.jvm.internal.impl.name.b m4 = kotlin.reflect.jvm.internal.impl.name.b.m(j.a.f56107i.l());
                kotlin.jvm.internal.f0.o(m4, "topLevel(StandardNames.FqNames.array.toSafe())");
                return m4;
            }
            return new kotlin.reflect.jvm.internal.impl.name.b(kotlin.reflect.jvm.internal.impl.builtins.j.f56084m, a4.getArrayTypeName());
        } else if (kotlin.jvm.internal.f0.g(klass, Void.TYPE)) {
            return f55878b;
        } else {
            PrimitiveType a5 = a(klass);
            if (a5 == null) {
                kotlin.reflect.jvm.internal.impl.name.b a6 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.a(klass);
                if (!a6.k()) {
                    kotlin.reflect.jvm.internal.impl.builtins.jvm.c cVar = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.f56159a;
                    kotlin.reflect.jvm.internal.impl.name.c b4 = a6.b();
                    kotlin.jvm.internal.f0.o(b4, "classId.asSingleFqName()");
                    kotlin.reflect.jvm.internal.impl.name.b n4 = cVar.n(b4);
                    if (n4 != null) {
                        return n4;
                    }
                }
                return a6;
            }
            return new kotlin.reflect.jvm.internal.impl.name.b(kotlin.reflect.jvm.internal.impl.builtins.j.f56084m, a5.getTypeName());
        }
    }

    @NotNull
    public final e f(@NotNull p0 possiblyOverriddenProperty) {
        kotlin.jvm.internal.f0.p(possiblyOverriddenProperty, "possiblyOverriddenProperty");
        p0 a4 = ((p0) kotlin.reflect.jvm.internal.impl.resolve.d.L(possiblyOverriddenProperty)).a();
        kotlin.jvm.internal.f0.o(a4, "unwrapFakeOverride(possi\u2026rriddenProperty).original");
        if (a4 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.i) {
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.i iVar = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.i) a4;
            ProtoBuf.Property d02 = iVar.d0();
            GeneratedMessageLite.f<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> propertySignature = JvmProtoBuf.f57490d;
            kotlin.jvm.internal.f0.o(propertySignature, "propertySignature");
            JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) kotlin.reflect.jvm.internal.impl.metadata.deserialization.e.a(d02, propertySignature);
            if (jvmPropertySignature != null) {
                return new e.c(a4, d02, jvmPropertySignature, iVar.J(), iVar.G());
            }
        } else if (a4 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.f) {
            v0 source = ((kotlin.reflect.jvm.internal.impl.load.java.descriptors.f) a4).getSource();
            l2.a aVar = source instanceof l2.a ? (l2.a) source : null;
            m2.l c4 = aVar == null ? null : aVar.c();
            if (c4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.r) {
                return new e.a(((kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.r) c4).S());
            }
            if (c4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.u) {
                Method S = ((kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.u) c4).S();
                r0 setter = a4.getSetter();
                v0 source2 = setter == null ? null : setter.getSource();
                l2.a aVar2 = source2 instanceof l2.a ? (l2.a) source2 : null;
                m2.l c5 = aVar2 == null ? null : aVar2.c();
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.u uVar = c5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.u ? (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.u) c5 : null;
                return new e.b(S, uVar != null ? uVar.S() : null);
            }
            throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java field " + a4 + " (source = " + c4 + ')');
        }
        q0 getter = a4.getGetter();
        kotlin.jvm.internal.f0.m(getter);
        d.e d4 = d(getter);
        r0 setter2 = a4.getSetter();
        return new e.d(d4, setter2 != null ? d(setter2) : null);
    }

    @NotNull
    public final d g(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.w possiblySubstitutedFunction) {
        d.b b4;
        d.b e4;
        kotlin.jvm.internal.f0.p(possiblySubstitutedFunction, "possiblySubstitutedFunction");
        kotlin.reflect.jvm.internal.impl.descriptors.w a4 = ((kotlin.reflect.jvm.internal.impl.descriptors.w) kotlin.reflect.jvm.internal.impl.resolve.d.L(possiblySubstitutedFunction)).a();
        kotlin.jvm.internal.f0.o(a4, "unwrapFakeOverride(possi\u2026titutedFunction).original");
        if (a4 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.c) {
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.c cVar = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.c) a4;
            kotlin.reflect.jvm.internal.impl.protobuf.n d02 = cVar.d0();
            if ((d02 instanceof ProtoBuf.Function) && (e4 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.g.f57549a.e((ProtoBuf.Function) d02, cVar.J(), cVar.G())) != null) {
                return new d.e(e4);
            }
            if ((d02 instanceof ProtoBuf.Constructor) && (b4 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.g.f57549a.b((ProtoBuf.Constructor) d02, cVar.J(), cVar.G())) != null) {
                kotlin.reflect.jvm.internal.impl.descriptors.k b5 = possiblySubstitutedFunction.b();
                kotlin.jvm.internal.f0.o(b5, "possiblySubstitutedFunction.containingDeclaration");
                if (kotlin.reflect.jvm.internal.impl.resolve.e.b(b5)) {
                    return new d.e(b4);
                }
                return new d.C1114d(b4);
            }
            return d(a4);
        }
        if (a4 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.e) {
            v0 source = ((kotlin.reflect.jvm.internal.impl.load.java.descriptors.e) a4).getSource();
            l2.a aVar = source instanceof l2.a ? (l2.a) source : null;
            m2.l c4 = aVar == null ? null : aVar.c();
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.u uVar = c4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.u ? (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.u) c4 : null;
            if (uVar != null) {
                return new d.c(uVar.S());
            }
            throw new KotlinReflectionInternalError(kotlin.jvm.internal.f0.C("Incorrect resolution sequence for Java method ", a4));
        } else if (a4 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.b) {
            v0 source2 = ((kotlin.reflect.jvm.internal.impl.load.java.descriptors.b) a4).getSource();
            l2.a aVar2 = source2 instanceof l2.a ? (l2.a) source2 : null;
            m2.l c5 = aVar2 != null ? aVar2.c() : null;
            if (c5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.o) {
                return new d.b(((kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.o) c5).S());
            }
            if (c5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.l) {
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.l lVar = (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.l) c5;
                if (lVar.m()) {
                    return new d.a(lVar.r());
                }
            }
            throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java constructor " + a4 + " (" + c5 + ')');
        } else if (b(a4)) {
            return d(a4);
        } else {
            throw new KotlinReflectionInternalError("Unknown origin of " + a4 + " (" + a4.getClass() + ')');
        }
    }
}

package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.f1;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.q0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.a1;
import kotlin.reflect.jvm.internal.impl.types.d0;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.h1;
import kotlin.reflect.jvm.internal.impl.types.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: descriptorBasedTypeSignatureMapping.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c {
    @NotNull
    public static final String a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d klass, @NotNull x<?> typeMappingConfiguration) {
        String j22;
        f0.p(klass, "klass");
        f0.p(typeMappingConfiguration, "typeMappingConfiguration");
        String b4 = typeMappingConfiguration.b(klass);
        if (b4 == null) {
            kotlin.reflect.jvm.internal.impl.descriptors.k b5 = klass.b();
            f0.o(b5, "klass.containingDeclaration");
            String identifier = kotlin.reflect.jvm.internal.impl.name.h.b(klass.getName()).getIdentifier();
            f0.o(identifier, "safeIdentifier(klass.name).identifier");
            if (b5 instanceof g0) {
                kotlin.reflect.jvm.internal.impl.name.c e4 = ((g0) b5).e();
                if (e4.d()) {
                    return identifier;
                }
                StringBuilder sb = new StringBuilder();
                String b6 = e4.b();
                f0.o(b6, "fqName.asString()");
                j22 = kotlin.text.w.j2(b6, '.', '/', false, 4, null);
                sb.append(j22);
                sb.append('/');
                sb.append(identifier);
                return sb.toString();
            }
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar = b5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) b5 : null;
            if (dVar != null) {
                String c4 = typeMappingConfiguration.c(dVar);
                if (c4 == null) {
                    c4 = a(dVar, typeMappingConfiguration);
                }
                return c4 + '$' + identifier;
            }
            throw new IllegalArgumentException("Unexpected container: " + b5 + " for " + klass);
        }
        return b4;
    }

    public static /* synthetic */ String b(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, x xVar, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            xVar = y.f57263a;
        }
        return a(dVar, xVar);
    }

    public static final boolean c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a descriptor) {
        f0.p(descriptor, "descriptor");
        if (descriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.j) {
            return true;
        }
        e0 returnType = descriptor.getReturnType();
        f0.m(returnType);
        if (kotlin.reflect.jvm.internal.impl.builtins.h.A0(returnType)) {
            e0 returnType2 = descriptor.getReturnType();
            f0.m(returnType2);
            if (!h1.m(returnType2) && !(descriptor instanceof q0)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1, types: [T, java.lang.Object] */
    @NotNull
    public static final <T> T d(@NotNull e0 kotlinType, @NotNull l<T> factory, @NotNull z mode, @NotNull x<? extends T> typeMappingConfiguration, @Nullable i<T> iVar, @NotNull d2.q<? super e0, ? super T, ? super z, f1> writeGenericType) {
        Object obj;
        e0 e0Var;
        Object d4;
        f0.p(kotlinType, "kotlinType");
        f0.p(factory, "factory");
        f0.p(mode, "mode");
        f0.p(typeMappingConfiguration, "typeMappingConfiguration");
        f0.p(writeGenericType, "writeGenericType");
        e0 d5 = typeMappingConfiguration.d(kotlinType);
        if (d5 == null) {
            if (kotlin.reflect.jvm.internal.impl.builtins.g.o(kotlinType)) {
                return (T) d(kotlin.reflect.jvm.internal.impl.builtins.k.a(kotlinType), factory, mode, typeMappingConfiguration, iVar, writeGenericType);
            }
            kotlin.reflect.jvm.internal.impl.types.checker.q qVar = kotlin.reflect.jvm.internal.impl.types.checker.q.f58304a;
            Object b4 = a0.b(qVar, kotlinType, factory, mode);
            if (b4 == null) {
                y0 H0 = kotlinType.H0();
                if (H0 instanceof d0) {
                    d0 d0Var = (d0) H0;
                    e0 f4 = d0Var.f();
                    if (f4 == null) {
                        f4 = typeMappingConfiguration.f(d0Var.j());
                    }
                    return (T) d(kotlin.reflect.jvm.internal.impl.types.typeUtil.a.t(f4), factory, mode, typeMappingConfiguration, iVar, writeGenericType);
                }
                kotlin.reflect.jvm.internal.impl.descriptors.f b5 = H0.b();
                if (b5 != null) {
                    if (kotlin.reflect.jvm.internal.impl.types.w.r(b5)) {
                        T t3 = (T) factory.e("error/NonExistentClass");
                        typeMappingConfiguration.e(kotlinType, (kotlin.reflect.jvm.internal.impl.descriptors.d) b5);
                        if (iVar != 0) {
                            iVar.c(t3);
                        }
                        return t3;
                    }
                    boolean z3 = b5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d;
                    if (z3 && kotlin.reflect.jvm.internal.impl.builtins.h.c0(kotlinType)) {
                        if (kotlinType.G0().size() == 1) {
                            a1 a1Var = kotlinType.G0().get(0);
                            e0 type = a1Var.getType();
                            f0.o(type, "memberProjection.type");
                            if (a1Var.c() == Variance.IN_VARIANCE) {
                                d4 = factory.e("java/lang/Object");
                                if (iVar != 0) {
                                    iVar.b();
                                    iVar.c(d4);
                                    iVar.a();
                                }
                            } else {
                                if (iVar != 0) {
                                    iVar.b();
                                }
                                Variance c4 = a1Var.c();
                                f0.o(c4, "memberProjection.projectionKind");
                                d4 = d(type, factory, mode.f(c4, true), typeMappingConfiguration, iVar, writeGenericType);
                                if (iVar != 0) {
                                    iVar.a();
                                }
                            }
                            return (T) factory.a(f0.C("[", factory.d(d4)));
                        }
                        throw new UnsupportedOperationException("arrays must have one type argument");
                    } else if (z3) {
                        if (kotlin.reflect.jvm.internal.impl.resolve.e.b(b5) && !mode.c() && (e0Var = (e0) kotlin.reflect.jvm.internal.impl.types.x.a(qVar, kotlinType)) != null) {
                            return (T) d(e0Var, factory, mode.g(), typeMappingConfiguration, iVar, writeGenericType);
                        }
                        if (mode.e() && kotlin.reflect.jvm.internal.impl.builtins.h.j0((kotlin.reflect.jvm.internal.impl.descriptors.d) b5)) {
                            obj = (Object) factory.f();
                        } else {
                            kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) b5;
                            kotlin.reflect.jvm.internal.impl.descriptors.d a4 = dVar.a();
                            f0.o(a4, "descriptor.original");
                            T a5 = typeMappingConfiguration.a(a4);
                            if (a5 == null) {
                                if (dVar.i() == ClassKind.ENUM_ENTRY) {
                                    dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) dVar.b();
                                }
                                kotlin.reflect.jvm.internal.impl.descriptors.d a6 = dVar.a();
                                f0.o(a6, "enumClassIfEnumEntry.original");
                                obj = (Object) factory.e(a(a6, typeMappingConfiguration));
                            } else {
                                obj = (Object) a5;
                            }
                        }
                        writeGenericType.invoke(kotlinType, obj, mode);
                        return (T) obj;
                    } else if (b5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.a1) {
                        T t4 = (T) d(kotlin.reflect.jvm.internal.impl.types.typeUtil.a.i((kotlin.reflect.jvm.internal.impl.descriptors.a1) b5), factory, mode, typeMappingConfiguration, null, kotlin.reflect.jvm.internal.impl.utils.d.b());
                        if (iVar != 0) {
                            kotlin.reflect.jvm.internal.impl.name.f name = b5.getName();
                            f0.o(name, "descriptor.getName()");
                            iVar.e(name, t4);
                        }
                        return t4;
                    } else if ((b5 instanceof z0) && mode.b()) {
                        return (T) d(((z0) b5).I(), factory, mode, typeMappingConfiguration, iVar, writeGenericType);
                    } else {
                        throw new UnsupportedOperationException(f0.C("Unknown type ", kotlinType));
                    }
                }
                throw new UnsupportedOperationException(f0.C("no descriptor for type constructor of ", kotlinType));
            }
            ?? r9 = (Object) a0.a(factory, b4, mode.d());
            writeGenericType.invoke(kotlinType, r9, mode);
            return r9;
        }
        return (T) d(d5, factory, mode, typeMappingConfiguration, iVar, writeGenericType);
    }

    public static /* synthetic */ Object e(e0 e0Var, l lVar, z zVar, x xVar, i iVar, d2.q qVar, int i4, Object obj) {
        if ((i4 & 32) != 0) {
            qVar = kotlin.reflect.jvm.internal.impl.utils.d.b();
        }
        return d(e0Var, lVar, zVar, xVar, iVar, qVar);
    }
}

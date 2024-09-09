package k1;

import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: JvmClassMapping.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u001b\n\u0002\b\u0004\u001a!\u0010\u0004\u001a\u00020\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u0006\u0012\u0002\b\u00030\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\"-\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00068G\u00a2\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\"-\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00068F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\t\"+\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\t\"+\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00078G\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"&\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00028\u00008\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\";\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00068\u00c7\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0017\u0010\t\"'\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0019*\u00028\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001d"}, d2 = {"", "T", "", "", "j", "([Ljava/lang/Object;)Z", "Lkotlin/reflect/d;", "Ljava/lang/Class;", "c", "(Lkotlin/reflect/d;)Ljava/lang/Class;", "getJavaClass$annotations", "(Lkotlin/reflect/d;)V", "java", "f", "javaPrimitiveType", "e", "javaObjectType", "g", "(Ljava/lang/Class;)Lkotlin/reflect/d;", "kotlin", "b", "(Ljava/lang/Object;)Ljava/lang/Class;", "javaClass", "h", "getRuntimeClassOfKClassInstance$annotations", "", "a", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/d;", "annotationClass", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
@JvmName(name = "JvmClassMappingKt")
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class a {
    @NotNull
    public static final <T extends Annotation> kotlin.reflect.d<? extends T> a(@NotNull T annotationClass) {
        f0.p(annotationClass, "$this$annotationClass");
        Class<? extends Annotation> annotationType = annotationClass.annotationType();
        f0.o(annotationType, "(this as java.lang.annot\u2026otation).annotationType()");
        kotlin.reflect.d<? extends T> g4 = g(annotationType);
        if (g4 != null) {
            return g4;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.reflect.KClass<out T>");
    }

    @NotNull
    public static final <T> Class<T> b(@NotNull T javaClass) {
        f0.p(javaClass, "$this$javaClass");
        return (Class<T>) javaClass.getClass();
    }

    @JvmName(name = "getJavaClass")
    @NotNull
    public static final <T> Class<T> c(@NotNull kotlin.reflect.d<T> java) {
        f0.p(java, "$this$java");
        Class<T> cls = (Class<T>) ((r) java).q();
        if (cls != null) {
            return cls;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<T>");
    }

    public static /* synthetic */ void d(kotlin.reflect.d dVar) {
    }

    @NotNull
    public static final <T> Class<T> e(@NotNull kotlin.reflect.d<T> javaObjectType) {
        f0.p(javaObjectType, "$this$javaObjectType");
        Class<T> cls = (Class<T>) ((r) javaObjectType).q();
        if (cls.isPrimitive()) {
            String name = cls.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    return name.equals("double") ? Double.class : cls;
                case 104431:
                    return name.equals("int") ? Integer.class : cls;
                case 3039496:
                    return name.equals("byte") ? Byte.class : cls;
                case 3052374:
                    return name.equals("char") ? Character.class : cls;
                case 3327612:
                    return name.equals("long") ? Long.class : cls;
                case 3625364:
                    return name.equals("void") ? Void.class : cls;
                case 64711720:
                    return name.equals("boolean") ? Boolean.class : cls;
                case 97526364:
                    return name.equals("float") ? Float.class : cls;
                case 109413500:
                    return name.equals("short") ? Short.class : cls;
                default:
                    return cls;
            }
        }
        return cls;
    }

    @Nullable
    public static final <T> Class<T> f(@NotNull kotlin.reflect.d<T> javaPrimitiveType) {
        f0.p(javaPrimitiveType, "$this$javaPrimitiveType");
        Class<T> cls = (Class<T>) ((r) javaPrimitiveType).q();
        if (cls.isPrimitive()) {
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -2056817302:
                if (name.equals("java.lang.Integer")) {
                    return Integer.TYPE;
                }
                break;
            case -527879800:
                if (name.equals("java.lang.Float")) {
                    return Float.TYPE;
                }
                break;
            case -515992664:
                if (name.equals("java.lang.Short")) {
                    return Short.TYPE;
                }
                break;
            case 155276373:
                if (name.equals("java.lang.Character")) {
                    return Character.TYPE;
                }
                break;
            case 344809556:
                if (name.equals("java.lang.Boolean")) {
                    return Boolean.TYPE;
                }
                break;
            case 398507100:
                if (name.equals("java.lang.Byte")) {
                    return Byte.TYPE;
                }
                break;
            case 398795216:
                if (name.equals("java.lang.Long")) {
                    return Long.TYPE;
                }
                break;
            case 399092968:
                if (name.equals("java.lang.Void")) {
                    return Void.TYPE;
                }
                break;
            case 761287205:
                if (name.equals("java.lang.Double")) {
                    return Double.TYPE;
                }
                break;
        }
        return null;
    }

    @JvmName(name = "getKotlinClass")
    @NotNull
    public static final <T> kotlin.reflect.d<T> g(@NotNull Class<T> kotlin2) {
        f0.p(kotlin2, "$this$kotlin");
        return n0.d(kotlin2);
    }

    @JvmName(name = "getRuntimeClassOfKClassInstance")
    @NotNull
    public static final <T> Class<kotlin.reflect.d<T>> h(@NotNull kotlin.reflect.d<T> javaClass) {
        f0.p(javaClass, "$this$javaClass");
        return (Class<kotlin.reflect.d<T>>) javaClass.getClass();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'java' property to get Java class corresponding to this Kotlin class or cast this instance to Any if you really want to get the runtime Java class of this implementation of KClass.", replaceWith = @ReplaceWith(expression = "(this as Any).javaClass", imports = {}))
    public static /* synthetic */ void i(kotlin.reflect.d dVar) {
    }

    public static final /* synthetic */ <T> boolean j(Object[] isArrayOf) {
        f0.p(isArrayOf, "$this$isArrayOf");
        f0.y(4, "T");
        return Object.class.isAssignableFrom(isArrayOf.getClass().getComponentType());
    }
}

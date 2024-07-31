package p612k1;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.lang.annotation.Annotation;
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u001b\n\u0002\b\u0004\u001a!\u0010\u0004\u001a\u00020\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005\"-\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00068G¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\"-\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00068F¢\u0006\u0006\u001a\u0004\b\r\u0010\t\"+\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00068F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\t\"+\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00078G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"&\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00028\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\";\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00068Ç\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0017\u0010\t\"'\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0019*\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, m12616d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", "", "j", "([Ljava/lang/Object;)Z", "Lkotlin/reflect/d;", "Ljava/lang/Class;", "c", "(Lkotlin/reflect/d;)Ljava/lang/Class;", "getJavaClass$annotations", "(Lkotlin/reflect/d;)V", "java", "f", "javaPrimitiveType", "e", "javaObjectType", "g", "(Ljava/lang/Class;)Lkotlin/reflect/d;", "kotlin", "b", "(Ljava/lang/Object;)Ljava/lang/Class;", "javaClass", "h", "getRuntimeClassOfKClassInstance$annotations", "", "a", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/d;", "annotationClass", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
@JvmName(name = "JvmClassMappingKt")
/* renamed from: k1.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class JvmClassMapping {
    @NotNull
    /* renamed from: a */
    public static final <T extends Annotation> KClass<? extends T> m12628a(@NotNull T annotationClass) {
        C14342f0.m8184p(annotationClass, "$this$annotationClass");
        Class<? extends Annotation> annotationType = annotationClass.annotationType();
        C14342f0.m8185o(annotationType, "(this as java.lang.annot…otation).annotationType()");
        KClass<? extends T> m12622g = m12622g(annotationType);
        if (m12622g != null) {
            return m12622g;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.reflect.KClass<out T>");
    }

    @NotNull
    /* renamed from: b */
    public static final <T> Class<T> m12627b(@NotNull T javaClass) {
        C14342f0.m8184p(javaClass, "$this$javaClass");
        return (Class<T>) javaClass.getClass();
    }

    @JvmName(name = "getJavaClass")
    @NotNull
    /* renamed from: c */
    public static final <T> Class<T> m12626c(@NotNull KClass<T> java) {
        C14342f0.m8184p(java, "$this$java");
        Class<T> cls = (Class<T>) ((ClassBasedDeclarationContainer) java).mo8048q();
        if (cls != null) {
            return cls;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<T>");
    }

    /* renamed from: d */
    public static /* synthetic */ void m12625d(KClass kClass) {
    }

    @NotNull
    /* renamed from: e */
    public static final <T> Class<T> m12624e(@NotNull KClass<T> javaObjectType) {
        C14342f0.m8184p(javaObjectType, "$this$javaObjectType");
        Class<T> cls = (Class<T>) ((ClassBasedDeclarationContainer) javaObjectType).mo8048q();
        if (cls.isPrimitive()) {
            String name = cls.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    return name.equals("double") ? Double.class : cls;
                case 104431:
                    return name.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL) ? Integer.class : cls;
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
    /* renamed from: f */
    public static final <T> Class<T> m12623f(@NotNull KClass<T> javaPrimitiveType) {
        C14342f0.m8184p(javaPrimitiveType, "$this$javaPrimitiveType");
        Class<T> cls = (Class<T>) ((ClassBasedDeclarationContainer) javaPrimitiveType).mo8048q();
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
    /* renamed from: g */
    public static final <T> KClass<T> m12622g(@NotNull Class<T> kotlin2) {
        C14342f0.m8184p(kotlin2, "$this$kotlin");
        return Reflection.m8123d(kotlin2);
    }

    @JvmName(name = "getRuntimeClassOfKClassInstance")
    @NotNull
    /* renamed from: h */
    public static final <T> Class<KClass<T>> m12621h(@NotNull KClass<T> javaClass) {
        C14342f0.m8184p(javaClass, "$this$javaClass");
        return (Class<KClass<T>>) javaClass.getClass();
    }

    @Annotations(level = DeprecationLevel.ERROR, message = "Use 'java' property to get Java class corresponding to this Kotlin class or cast this instance to Any if you really want to get the runtime Java class of this implementation of KClass.", replaceWith = @ReplaceWith(expression = "(this as Any).javaClass", imports = {}))
    /* renamed from: i */
    public static /* synthetic */ void m12620i(KClass kClass) {
    }

    /* renamed from: j */
    public static final /* synthetic */ <T> boolean m12619j(Object[] isArrayOf) {
        C14342f0.m8184p(isArrayOf, "$this$isArrayOf");
        C14342f0.m8175y(4, ExifInterface.GPS_DIRECTION_TRUE);
        return Object.class.isAssignableFrom(isArrayOf.getClass().getComponentType());
    }
}

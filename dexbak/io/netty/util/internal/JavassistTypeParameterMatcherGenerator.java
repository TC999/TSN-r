package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Method;
import javassist.ClassClassPath;
import javassist.ClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import okhttp3.HttpUrl;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class JavassistTypeParameterMatcherGenerator {
    private static final ClassPool classPool;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(JavassistTypeParameterMatcherGenerator.class);

    static {
        ClassPool classPool2 = new ClassPool(true);
        classPool = classPool2;
        classPool2.appendClassPath(new ClassClassPath(NoOpTypeParameterMatcher.class));
    }

    private JavassistTypeParameterMatcherGenerator() {
    }

    public static void appendClassPath(ClassPath classPath) {
        classPool.appendClassPath(classPath);
    }

    public static ClassPool classPool() {
        return classPool;
    }

    public static TypeParameterMatcher generate(Class<?> cls) {
        ClassLoader contextClassLoader = PlatformDependent.getContextClassLoader();
        if (contextClassLoader == null) {
            contextClassLoader = PlatformDependent.getSystemClassLoader();
        }
        return generate(cls, contextClassLoader);
    }

    private static String typeName(Class<?> cls) {
        if (cls.isArray()) {
            return typeName(cls.getComponentType()) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        return cls.getName();
    }

    public static void appendClassPath(String str) throws NotFoundException {
        classPool.appendClassPath(str);
    }

    public static TypeParameterMatcher generate(Class<?> cls, ClassLoader classLoader) {
        String typeName = typeName(cls);
        String str = "io.netty.util.internal.__matchers__." + typeName + "Matcher";
        try {
            try {
                return (TypeParameterMatcher) Class.forName(str, true, classLoader).newInstance();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        } catch (Exception unused) {
            CtClass andRename = classPool.getAndRename(NoOpTypeParameterMatcher.class.getName(), str);
            andRename.setModifiers(andRename.getModifiers() | 16);
            andRename.getDeclaredMethod("match").setBody("{ return $1 instanceof " + typeName + "; }");
            byte[] bytecode = andRename.toBytecode();
            andRename.detach();
            Class cls2 = Integer.TYPE;
            Method declaredMethod = ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, cls2, cls2);
            declaredMethod.setAccessible(true);
            Class cls3 = (Class) declaredMethod.invoke(classLoader, str, bytecode, 0, Integer.valueOf(bytecode.length));
            if (cls != Object.class) {
                logger.debug("Generated: {}", cls3.getName());
            }
            return (TypeParameterMatcher) cls3.newInstance();
        }
    }
}

package io.netty.util;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Constructor;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class ResourceLeakDetectorFactory {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ResourceLeakDetectorFactory.class);
    private static volatile ResourceLeakDetectorFactory factoryInstance = new DefaultResourceLeakDetectorFactory();

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static final class DefaultResourceLeakDetectorFactory extends ResourceLeakDetectorFactory {
        private final Constructor<?> customClassConstructor;

        DefaultResourceLeakDetectorFactory() {
            String str;
            try {
                str = (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: io.netty.util.ResourceLeakDetectorFactory.DefaultResourceLeakDetectorFactory.1
                    @Override // java.security.PrivilegedAction
                    public String run() {
                        return SystemPropertyUtil.get("io.netty.customResourceLeakDetector");
                    }
                });
            } catch (Throwable th) {
                ResourceLeakDetectorFactory.logger.error("Could not access System property: io.netty.customResourceLeakDetector", th);
                str = null;
            }
            this.customClassConstructor = str != null ? customClassConstructor(str) : null;
        }

        private static Constructor<?> customClassConstructor(String str) {
            try {
                Class<?> cls = Class.forName(str, true, PlatformDependent.getSystemClassLoader());
                if (ResourceLeakDetector.class.isAssignableFrom(cls)) {
                    return cls.getConstructor(Class.class, Integer.TYPE, Long.TYPE);
                }
                ResourceLeakDetectorFactory.logger.error("Class {} does not inherit from ResourceLeakDetector.", str);
                return null;
            } catch (Throwable th) {
                ResourceLeakDetectorFactory.logger.error("Could not load custom resource leak detector class provided: {}", str, th);
                return null;
            }
        }

        @Override // io.netty.util.ResourceLeakDetectorFactory
        public <T> ResourceLeakDetector<T> newResourceLeakDetector(Class<T> cls, int i, long j) {
            Constructor<?> constructor = this.customClassConstructor;
            if (constructor != null) {
                try {
                    ResourceLeakDetector<T> resourceLeakDetector = (ResourceLeakDetector) constructor.newInstance(cls, Integer.valueOf(i), Long.valueOf(j));
                    ResourceLeakDetectorFactory.logger.debug("Loaded custom ResourceLeakDetector: {}", this.customClassConstructor.getDeclaringClass().getName());
                    return resourceLeakDetector;
                } catch (Throwable th) {
                    ResourceLeakDetectorFactory.logger.error("Could not load custom resource leak detector provided: {} with the given resource: {}", this.customClassConstructor.getDeclaringClass().getName(), cls, th);
                }
            }
            ResourceLeakDetector<T> resourceLeakDetector2 = new ResourceLeakDetector<>((Class<?>) cls, i, j);
            ResourceLeakDetectorFactory.logger.debug("Loaded default ResourceLeakDetector: {}", resourceLeakDetector2);
            return resourceLeakDetector2;
        }
    }

    public static ResourceLeakDetectorFactory instance() {
        return factoryInstance;
    }

    public static void setResourceLeakDetectorFactory(ResourceLeakDetectorFactory resourceLeakDetectorFactory) {
        factoryInstance = (ResourceLeakDetectorFactory) ObjectUtil.checkNotNull(resourceLeakDetectorFactory, "factory");
    }

    public final <T> ResourceLeakDetector<T> newResourceLeakDetector(Class<T> cls) {
        return newResourceLeakDetector(cls, 128, Long.MAX_VALUE);
    }

    public abstract <T> ResourceLeakDetector<T> newResourceLeakDetector(Class<T> cls, int i, long j);
}

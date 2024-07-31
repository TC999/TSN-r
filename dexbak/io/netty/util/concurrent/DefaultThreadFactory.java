package io.netty.util.concurrent;

import io.netty.util.internal.StringUtil;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class DefaultThreadFactory implements ThreadFactory {
    private static final AtomicInteger poolId = new AtomicInteger();
    private final boolean daemon;
    private final AtomicInteger nextId;
    private final String prefix;
    private final int priority;
    protected final ThreadGroup threadGroup;

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    private static final class DefaultRunnableDecorator implements Runnable {

        /* renamed from: r */
        private final Runnable f40294r;

        DefaultRunnableDecorator(Runnable runnable) {
            this.f40294r = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f40294r.run();
            } finally {
                FastThreadLocal.removeAll();
            }
        }
    }

    public DefaultThreadFactory(Class<?> cls) {
        this(cls, false, 5);
    }

    public static String toPoolName(Class<?> cls) {
        if (cls != null) {
            String simpleClassName = StringUtil.simpleClassName(cls);
            int length = simpleClassName.length();
            if (length != 0) {
                if (length != 1) {
                    if (Character.isUpperCase(simpleClassName.charAt(0)) && Character.isLowerCase(simpleClassName.charAt(1))) {
                        return Character.toLowerCase(simpleClassName.charAt(0)) + simpleClassName.substring(1);
                    }
                    return simpleClassName;
                }
                return simpleClassName.toLowerCase(Locale.US);
            }
            return "unknown";
        }
        throw new NullPointerException("poolType");
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        DefaultRunnableDecorator defaultRunnableDecorator = new DefaultRunnableDecorator(runnable);
        Thread newThread = newThread(defaultRunnableDecorator, this.prefix + this.nextId.incrementAndGet());
        try {
            if (newThread.isDaemon()) {
                if (!this.daemon) {
                    newThread.setDaemon(false);
                }
            } else if (this.daemon) {
                newThread.setDaemon(true);
            }
            int priority = newThread.getPriority();
            int i = this.priority;
            if (priority != i) {
                newThread.setPriority(i);
            }
        } catch (Exception unused) {
        }
        return newThread;
    }

    public DefaultThreadFactory(String str) {
        this(str, false, 5);
    }

    public DefaultThreadFactory(Class<?> cls, boolean z) {
        this(cls, z, 5);
    }

    public DefaultThreadFactory(String str, boolean z) {
        this(str, z, 5);
    }

    public DefaultThreadFactory(Class<?> cls, int i) {
        this(cls, false, i);
    }

    public DefaultThreadFactory(String str, int i) {
        this(str, false, i);
    }

    public DefaultThreadFactory(Class<?> cls, boolean z, int i) {
        this(toPoolName(cls), z, i);
    }

    public DefaultThreadFactory(String str, boolean z, int i, ThreadGroup threadGroup) {
        this.nextId = new AtomicInteger();
        if (str == null) {
            throw new NullPointerException("poolName");
        }
        if (i >= 1 && i <= 10) {
            this.prefix = str + '-' + poolId.incrementAndGet() + '-';
            this.daemon = z;
            this.priority = i;
            this.threadGroup = threadGroup;
            return;
        }
        throw new IllegalArgumentException("priority: " + i + " (expected: Thread.MIN_PRIORITY <= priority <= Thread.MAX_PRIORITY)");
    }

    protected Thread newThread(Runnable runnable, String str) {
        return new FastThreadLocalThread(this.threadGroup, runnable, str);
    }

    public DefaultThreadFactory(String str, boolean z, int i) {
        this(str, z, i, System.getSecurityManager() == null ? Thread.currentThread().getThreadGroup() : System.getSecurityManager().getThreadGroup());
    }
}

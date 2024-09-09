package xyz.adscope.amps.tool.thread;

import android.text.TextUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSThreadFactory implements ThreadFactory {
    private static final AtomicInteger threadNum = new AtomicInteger(1);
    private final AtomicInteger NEW_NUM = new AtomicInteger(1);
    private final int priority;
    private final ThreadGroup threadGroup;
    private final String threadName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AMPSThreadFactory(int i4, String str) {
        ThreadGroup threadGroup;
        this.priority = i4;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.threadGroup = threadGroup;
        if (TextUtils.isEmpty(str)) {
            this.threadName = "amps-adsdk-background-" + threadNum.getAndIncrement() + "-thread-";
            return;
        }
        this.threadName = str + threadNum.getAndIncrement() + "-thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        ThreadGroup threadGroup = this.threadGroup;
        Thread thread = new Thread(threadGroup, runnable, this.threadName + this.NEW_NUM.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (this.priority == 1) {
            thread.setPriority(1);
        } else if (thread.getPriority() != 5) {
            thread.setPriority(3);
        } else {
            thread.setPriority(5);
        }
        return thread;
    }
}

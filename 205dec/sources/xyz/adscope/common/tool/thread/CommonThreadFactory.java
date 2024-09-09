package xyz.adscope.common.tool.thread;

import android.text.TextUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class CommonThreadFactory implements ThreadFactory {

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicInteger f65048e = new AtomicInteger(1);

    /* renamed from: a  reason: collision with root package name */
    public final ThreadGroup f65049a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicInteger f65050b = new AtomicInteger(1);

    /* renamed from: c  reason: collision with root package name */
    public final String f65051c;

    /* renamed from: d  reason: collision with root package name */
    public final int f65052d;

    public CommonThreadFactory(int i4, String str) {
        StringBuilder sb;
        this.f65052d = i4;
        SecurityManager securityManager = System.getSecurityManager();
        this.f65049a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        if (TextUtils.isEmpty(str)) {
            sb = new StringBuilder();
            str = "common-adsdk-background-";
        } else {
            sb = new StringBuilder();
        }
        sb.append(str);
        sb.append(f65048e.getAndIncrement());
        sb.append("-thread-");
        this.f65051c = sb.toString();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        ThreadGroup threadGroup = this.f65049a;
        Thread thread = new Thread(threadGroup, runnable, this.f65051c + this.f65050b.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        int i4 = 1;
        if (this.f65052d != 1) {
            i4 = 5;
            if (thread.getPriority() != 5) {
                thread.setPriority(3);
                return thread;
            }
        }
        thread.setPriority(i4);
        return thread;
    }
}

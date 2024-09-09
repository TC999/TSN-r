package com.bytedance.c.xv.c.w;

import android.text.TextUtils;
import com.bytedance.c.xv.c.w.w;
import com.bytedance.sdk.component.gd.sr.xv;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class b implements ThreadFactory {

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicInteger f26661e = new AtomicInteger(1);

    /* renamed from: a  reason: collision with root package name */
    private final ThreadGroup f26662a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicInteger f26663b = new AtomicInteger(1);

    /* renamed from: c  reason: collision with root package name */
    private final String f26664c;

    /* renamed from: d  reason: collision with root package name */
    private final w.c f26665d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(w.c cVar, String str) {
        ThreadGroup threadGroup;
        this.f26665d = cVar;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.f26662a = threadGroup;
        if (TextUtils.isEmpty(str)) {
            this.f26664c = "ttdefault-" + f26661e.getAndIncrement() + "-thread-";
            return;
        }
        this.f26664c = str + f26661e.getAndIncrement() + "-thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        ThreadGroup threadGroup = this.f26662a;
        xv xvVar = new xv(threadGroup, runnable, this.f26664c + this.f26663b.getAndIncrement(), 0L);
        if (xvVar.isDaemon()) {
            xvVar.setDaemon(false);
        }
        w.c cVar = this.f26665d;
        if (cVar != null && cVar.c() == w.c.LOW.c()) {
            xvVar.setPriority(1);
        } else if (xvVar.getPriority() != 5) {
            xvVar.setPriority(3);
        } else {
            xvVar.setPriority(5);
        }
        return xvVar;
    }
}

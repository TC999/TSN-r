package cn.jpush.android.ad;

import cn.jiguang.api.JCoreManager;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import java.lang.Thread;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f3983a;

    /* renamed from: e  reason: collision with root package name */
    protected String f3984e;

    /* JADX INFO: Access modifiers changed from: protected */
    public f() {
        this.f3983a = new Thread.UncaughtExceptionHandler() { // from class: cn.jpush.android.ad.f.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                JCoreManager.onEvent(null, JPushConstants.SDK_TYPE, 93, null, null, thread, th);
                StringBuilder sb = new StringBuilder();
                sb.append("name: ");
                sb.append(f.this.f3984e);
                sb.append(", thread id:");
                sb.append(thread != null ? thread.getName() : "");
                sb.append("-");
                sb.append(thread != null ? Long.valueOf(thread.getId()) : "");
                sb.append("\n e:");
                sb.append(th);
                Logger.e("JPushRunnable", sb.toString());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(String str) {
        this.f3984e = str;
        this.f3983a = new Thread.UncaughtExceptionHandler() { // from class: cn.jpush.android.ad.f.2
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                JCoreManager.onEvent(null, JPushConstants.SDK_TYPE, 93, null, null, thread, th);
                StringBuilder sb = new StringBuilder();
                sb.append("name: ");
                sb.append(f.this.f3984e);
                sb.append(", thread id: ");
                sb.append(thread != null ? thread.getName() : "");
                sb.append("-");
                sb.append(thread != null ? Long.valueOf(thread.getId()) : "");
                sb.append("\n e:");
                sb.append(th);
                Logger.e("JPushRunnable", sb.toString());
            }
        };
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(this.f3983a);
        a();
        Thread.currentThread().setUncaughtExceptionHandler(null);
    }
}

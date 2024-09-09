package com.tencent.open.log;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.tauth.Tencent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a extends Tracer implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private b f51757a;

    /* renamed from: b  reason: collision with root package name */
    private FileWriter f51758b;

    /* renamed from: c  reason: collision with root package name */
    private File f51759c;

    /* renamed from: d  reason: collision with root package name */
    private char[] f51760d;

    /* renamed from: e  reason: collision with root package name */
    private volatile f f51761e;

    /* renamed from: f  reason: collision with root package name */
    private volatile f f51762f;

    /* renamed from: g  reason: collision with root package name */
    private volatile f f51763g;

    /* renamed from: h  reason: collision with root package name */
    private volatile f f51764h;

    /* renamed from: i  reason: collision with root package name */
    private volatile boolean f51765i;

    /* renamed from: j  reason: collision with root package name */
    private HandlerThread f51766j;

    /* renamed from: k  reason: collision with root package name */
    private Handler f51767k;

    public a(b bVar) {
        this(c.f51779b, true, g.f51799a, bVar);
    }

    private void f() {
        if (Thread.currentThread() == this.f51766j && !this.f51765i) {
            this.f51765i = true;
            i();
            try {
                try {
                    this.f51764h.a(g(), this.f51760d);
                } catch (IOException e4) {
                    SLog.e("FileTracer", "flushBuffer exception", e4);
                }
                this.f51765i = false;
            } finally {
                this.f51764h.b();
            }
        }
    }

    private Writer g() {
        File a4 = c().a();
        if (a4 != null && (!a4.equals(this.f51759c) || this.f51758b == null)) {
            this.f51759c = a4;
            h();
            try {
                this.f51758b = new FileWriter(this.f51759c, true);
            } catch (IOException unused) {
                this.f51758b = null;
                SLog.e("openSDK_LOG", "-->obtainFileWriter() app specific file permission denied");
            }
            a(a4);
        }
        return this.f51758b;
    }

    private void h() {
        try {
            FileWriter fileWriter = this.f51758b;
            if (fileWriter != null) {
                fileWriter.flush();
                this.f51758b.close();
            }
        } catch (IOException e4) {
            SLog.e("openSDK_LOG", "-->closeAppSpecificFileWriter() exception:", e4);
        }
    }

    private void i() {
        synchronized (this) {
            if (this.f51763g == this.f51761e) {
                this.f51763g = this.f51762f;
                this.f51764h = this.f51761e;
            } else {
                this.f51763g = this.f51761e;
                this.f51764h = this.f51762f;
            }
        }
    }

    public void a() {
        if (this.f51767k.hasMessages(1024)) {
            this.f51767k.removeMessages(1024);
        }
        this.f51767k.sendEmptyMessage(1024);
    }

    public void b() {
        h();
        this.f51766j.quit();
    }

    public b c() {
        return this.f51757a;
    }

    @Override // com.tencent.open.log.Tracer
    protected void doTrace(int i4, Thread thread, long j4, String str, String str2, Throwable th) {
        a(e().a(i4, thread, j4, str, str2, th));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1024) {
            return true;
        }
        f();
        return true;
    }

    public a(int i4, boolean z3, g gVar, b bVar) {
        super(i4, z3, gVar);
        this.f51765i = false;
        a(bVar);
        this.f51761e = new f();
        this.f51762f = new f();
        this.f51763g = this.f51761e;
        this.f51764h = this.f51762f;
        this.f51760d = new char[bVar.c()];
        HandlerThread handlerThread = new HandlerThread(bVar.b(), bVar.d());
        this.f51766j = handlerThread;
        handlerThread.start();
        if (!this.f51766j.isAlive() || this.f51766j.getLooper() == null) {
            return;
        }
        this.f51767k = new Handler(this.f51766j.getLooper(), this);
    }

    private boolean b(File file) {
        if (file == null) {
            return false;
        }
        String name = file.getName();
        SLog.d("FileTracer", "name=" + name);
        return !TextUtils.isEmpty(name) && name.length() == 47 && name.startsWith("com.tencent.mobileqq_connectSdk.") && name.endsWith(".log");
    }

    private void a(String str) {
        this.f51763g.a(str);
        if (this.f51763g.a() >= c().c()) {
            a();
        }
    }

    private void a(File file) {
        File[] listFiles;
        File parentFile = file.getParentFile();
        if (parentFile == null || !parentFile.exists() || !parentFile.isDirectory() || (listFiles = parentFile.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (b(file2)) {
                String name = file2.getName();
                if (b.a(System.currentTimeMillis() - (Tencent.USE_ONE_HOUR ? 3600000L : 259200000L)).compareTo(name.substring(32, 43)) > 0) {
                    SLog.d("FileTracer", "delete name=" + name + ", success=" + file2.delete());
                }
            }
        }
    }

    public void a(b bVar) {
        this.f51757a = bVar;
    }
}

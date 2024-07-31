package com.tencent.open.log;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.kuaishou.weapon.p205p0.C7193bi;
import com.tencent.tauth.Tencent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.log.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13036a extends Tracer implements Handler.Callback {

    /* renamed from: a */
    private C13037b f37357a;

    /* renamed from: b */
    private FileWriter f37358b;

    /* renamed from: c */
    private File f37359c;

    /* renamed from: d */
    private char[] f37360d;

    /* renamed from: e */
    private volatile C13045f f37361e;

    /* renamed from: f */
    private volatile C13045f f37362f;

    /* renamed from: g */
    private volatile C13045f f37363g;

    /* renamed from: h */
    private volatile C13045f f37364h;

    /* renamed from: i */
    private volatile boolean f37365i;

    /* renamed from: j */
    private HandlerThread f37366j;

    /* renamed from: k */
    private Handler f37367k;

    public C13036a(C13037b c13037b) {
        this(C13038c.f37379b, true, C13046g.f37399a, c13037b);
    }

    /* renamed from: f */
    private void m15106f() {
        if (Thread.currentThread() == this.f37366j && !this.f37365i) {
            this.f37365i = true;
            m15103i();
            try {
                try {
                    this.f37364h.m15071a(m15105g(), this.f37360d);
                } catch (IOException e) {
                    SLog.m15128e("FileTracer", "flushBuffer exception", e);
                }
                this.f37365i = false;
            } finally {
                this.f37364h.m15069b();
            }
        }
    }

    /* renamed from: g */
    private Writer m15105g() {
        File m15102a = m15107c().m15102a();
        if (m15102a != null && (!m15102a.equals(this.f37359c) || this.f37358b == null)) {
            this.f37359c = m15102a;
            m15104h();
            try {
                this.f37358b = new FileWriter(this.f37359c, true);
            } catch (IOException unused) {
                this.f37358b = null;
                SLog.m15129e(SLog.TAG, "-->obtainFileWriter() app specific file permission denied");
            }
            m15111a(m15102a);
        }
        return this.f37358b;
    }

    /* renamed from: h */
    private void m15104h() {
        try {
            FileWriter fileWriter = this.f37358b;
            if (fileWriter != null) {
                fileWriter.flush();
                this.f37358b.close();
            }
        } catch (IOException e) {
            SLog.m15128e(SLog.TAG, "-->closeAppSpecificFileWriter() exception:", e);
        }
    }

    /* renamed from: i */
    private void m15103i() {
        synchronized (this) {
            if (this.f37363g == this.f37361e) {
                this.f37363g = this.f37362f;
                this.f37364h = this.f37361e;
            } else {
                this.f37363g = this.f37361e;
                this.f37364h = this.f37362f;
            }
        }
    }

    /* renamed from: a */
    public void m15113a() {
        if (this.f37367k.hasMessages(1024)) {
            this.f37367k.removeMessages(1024);
        }
        this.f37367k.sendEmptyMessage(1024);
    }

    /* renamed from: b */
    public void m15109b() {
        m15104h();
        this.f37366j.quit();
    }

    /* renamed from: c */
    public C13037b m15107c() {
        return this.f37357a;
    }

    @Override // com.tencent.open.log.Tracer
    protected void doTrace(int i, Thread thread, long j, String str, String str2, Throwable th) {
        m15110a(m15114e().m15067a(i, thread, j, str, str2, th));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1024) {
            return true;
        }
        m15106f();
        return true;
    }

    public C13036a(int i, boolean z, C13046g c13046g, C13037b c13037b) {
        super(i, z, c13046g);
        this.f37365i = false;
        m15112a(c13037b);
        this.f37361e = new C13045f();
        this.f37362f = new C13045f();
        this.f37363g = this.f37361e;
        this.f37364h = this.f37362f;
        this.f37360d = new char[c13037b.m15093c()];
        HandlerThread handlerThread = new HandlerThread(c13037b.m15097b(), c13037b.m15089d());
        this.f37366j = handlerThread;
        handlerThread.start();
        if (!this.f37366j.isAlive() || this.f37366j.getLooper() == null) {
            return;
        }
        this.f37367k = new Handler(this.f37366j.getLooper(), this);
    }

    /* renamed from: b */
    private boolean m15108b(File file) {
        if (file == null) {
            return false;
        }
        String name = file.getName();
        SLog.m15131d("FileTracer", "name=" + name);
        return !TextUtils.isEmpty(name) && name.length() == 47 && name.startsWith("com.tencent.mobileqq_connectSdk.") && name.endsWith(".log");
    }

    /* renamed from: a */
    private void m15110a(String str) {
        this.f37363g.m15070a(str);
        if (this.f37363g.m15072a() >= m15107c().m15093c()) {
            m15113a();
        }
    }

    /* renamed from: a */
    private void m15111a(File file) {
        File[] listFiles;
        File parentFile = file.getParentFile();
        if (parentFile == null || !parentFile.exists() || !parentFile.isDirectory() || (listFiles = parentFile.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (m15108b(file2)) {
                String name = file2.getName();
                if (C13037b.m15100a(System.currentTimeMillis() - (Tencent.USE_ONE_HOUR ? C7193bi.f24584s : 259200000L)).compareTo(name.substring(32, 43)) > 0) {
                    SLog.m15131d("FileTracer", "delete name=" + name + ", success=" + file2.delete());
                }
            }
        }
    }

    /* renamed from: a */
    public void m15112a(C13037b c13037b) {
        this.f37357a = c13037b;
    }
}

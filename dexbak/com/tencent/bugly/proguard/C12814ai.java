package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ai */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12814ai {

    /* renamed from: b */
    private static C12814ai f36505b;

    /* renamed from: a */
    public InterfaceC12813ah f36506a;

    /* renamed from: d */
    private final Context f36508d;

    /* renamed from: f */
    private long f36510f;

    /* renamed from: g */
    private long f36511g;

    /* renamed from: e */
    private Map<Integer, Long> f36509e = new HashMap();

    /* renamed from: h */
    private LinkedBlockingQueue<Runnable> f36512h = new LinkedBlockingQueue<>();

    /* renamed from: i */
    private LinkedBlockingQueue<Runnable> f36513i = new LinkedBlockingQueue<>();

    /* renamed from: j */
    private final Object f36514j = new Object();

    /* renamed from: k */
    private long f36515k = 0;

    /* renamed from: l */
    private int f36516l = 0;

    /* renamed from: c */
    private final C12920w f36507c = C12920w.m15509a();

    private C12814ai(Context context) {
        this.f36508d = context;
    }

    /* renamed from: b */
    static /* synthetic */ int m15896b(C12814ai c12814ai) {
        int i = c12814ai.f36516l - 1;
        c12814ai.f36516l = i;
        return i;
    }

    /* renamed from: a */
    public static synchronized C12814ai m15905a(Context context) {
        C12814ai c12814ai;
        synchronized (C12814ai.class) {
            if (f36505b == null) {
                f36505b = new C12814ai(context);
            }
            c12814ai = f36505b;
        }
        return c12814ai;
    }

    /* renamed from: b */
    public final boolean m15897b(int i) {
        if (C12904p.f36892c) {
            C12820al.m15874c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - m15912a(i);
        C12820al.m15874c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", Long.valueOf(currentTimeMillis / 1000), Integer.valueOf(i));
        if (currentTimeMillis < 30000) {
            C12820al.m15878a("[UploadManager] Data only be uploaded once in %d seconds.", 30L);
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static synchronized C12814ai m15913a() {
        C12814ai c12814ai;
        synchronized (C12814ai.class) {
            c12814ai = f36505b;
        }
        return c12814ai;
    }

    /* renamed from: a */
    public final void m15909a(int i, C12884bq c12884bq, String str, String str2, InterfaceC12813ah interfaceC12813ah, long j, boolean z) {
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            m15901a(new RunnableC12817aj(this.f36508d, i, c12884bq.f36791g, C12806ae.m15931a((Object) c12884bq), str, str2, interfaceC12813ah, z), true, true, j);
        } catch (Throwable th2) {
            th = th2;
            if (C12820al.m15877a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m15898b() {
        C12818ak m15887a = C12818ak.m15887a();
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
        final LinkedBlockingQueue linkedBlockingQueue2 = new LinkedBlockingQueue();
        synchronized (this.f36514j) {
            C12820al.m15874c("[UploadManager] Try to poll all upload task need and put them into temp queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            int size = this.f36512h.size();
            final int size2 = this.f36513i.size();
            if (size == 0 && size2 == 0) {
                C12820al.m15874c("[UploadManager] There is no upload task in queue.", new Object[0]);
                return;
            }
            size2 = (m15887a == null || !m15887a.m15883c()) ? 0 : 0;
            m15900a(this.f36512h, linkedBlockingQueue, size);
            m15900a(this.f36513i, linkedBlockingQueue2, size2);
            m15907a(size, linkedBlockingQueue);
            if (size2 > 0) {
                C12820al.m15874c("[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(size2), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            }
            C12818ak m15887a2 = C12818ak.m15887a();
            if (m15887a2 != null) {
                m15887a2.m15886a(new Runnable() { // from class: com.tencent.bugly.proguard.ai.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        Runnable runnable;
                        for (int i = 0; i < size2 && (runnable = (Runnable) linkedBlockingQueue2.poll()) != null; i++) {
                            runnable.run();
                        }
                    }
                });
            }
        }
    }

    /* renamed from: a */
    private void m15911a(int i, int i2, byte[] bArr, String str, String str2, InterfaceC12813ah interfaceC12813ah, boolean z) {
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            m15901a(new RunnableC12817aj(this.f36508d, i, i2, bArr, str, str2, interfaceC12813ah, 0, 0, false), z, false, 0L);
        } catch (Throwable th2) {
            th = th2;
            if (C12820al.m15877a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void m15908a(int i, C12884bq c12884bq, String str, String str2, InterfaceC12813ah interfaceC12813ah, boolean z) {
        m15911a(i, c12884bq.f36791g, C12806ae.m15931a((Object) c12884bq), str, str2, interfaceC12813ah, z);
    }

    /* renamed from: a */
    public final long m15899a(boolean z) {
        long j;
        long m15823b = C12828ap.m15823b();
        int i = z ? 5 : 3;
        List<C12923y> m15508a = this.f36507c.m15508a(i);
        if (m15508a != null && m15508a.size() > 0) {
            j = 0;
            try {
                C12923y c12923y = m15508a.get(0);
                if (c12923y.f36972e >= m15823b) {
                    j = C12828ap.m15807d(c12923y.f36974g);
                    if (i == 3) {
                        this.f36510f = j;
                    } else {
                        this.f36511g = j;
                    }
                    m15508a.remove(c12923y);
                }
            } catch (Throwable th) {
                C12820al.m15877a(th);
            }
            if (m15508a.size() > 0) {
                this.f36507c.m15489a(m15508a);
            }
        } else {
            j = z ? this.f36511g : this.f36510f;
        }
        C12820al.m15874c("[UploadManager] Local network consume: %d KB", Long.valueOf(j / 1024));
        return j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final synchronized void m15906a(long j, boolean z) {
        int i = z ? 5 : 3;
        C12923y c12923y = new C12923y();
        c12923y.f36969b = i;
        c12923y.f36972e = C12828ap.m15823b();
        c12923y.f36970c = "";
        c12923y.f36971d = "";
        c12923y.f36974g = C12828ap.m15813c(j);
        this.f36507c.m15487b(i);
        this.f36507c.m15495a(c12923y);
        if (z) {
            this.f36511g = j;
        } else {
            this.f36510f = j;
        }
        C12820al.m15874c("[UploadManager] Network total consume: %d KB", Long.valueOf(j / 1024));
    }

    /* renamed from: a */
    public final synchronized void m15910a(int i, long j) {
        if (i < 0) {
            C12820al.m15872e("[UploadManager] Unknown uploading ID: %d", Integer.valueOf(i));
            return;
        }
        this.f36509e.put(Integer.valueOf(i), Long.valueOf(j));
        C12923y c12923y = new C12923y();
        c12923y.f36969b = i;
        c12923y.f36972e = j;
        c12923y.f36970c = "";
        c12923y.f36971d = "";
        c12923y.f36974g = new byte[0];
        this.f36507c.m15487b(i);
        this.f36507c.m15495a(c12923y);
        C12820al.m15874c("[UploadManager] Uploading(ID:%d) time: %s", Integer.valueOf(i), C12828ap.m15845a(j));
    }

    /* renamed from: a */
    public final synchronized long m15912a(int i) {
        if (i >= 0) {
            Long l = this.f36509e.get(Integer.valueOf(i));
            if (l != null) {
                return l.longValue();
            }
        } else {
            C12820al.m15872e("[UploadManager] Unknown upload ID: %d", Integer.valueOf(i));
        }
        return 0L;
    }

    /* renamed from: a */
    private static void m15900a(LinkedBlockingQueue<Runnable> linkedBlockingQueue, LinkedBlockingQueue<Runnable> linkedBlockingQueue2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            Runnable peek = linkedBlockingQueue.peek();
            if (peek == null) {
                return;
            }
            try {
                linkedBlockingQueue2.put(peek);
                linkedBlockingQueue.poll();
            } catch (Throwable th) {
                C12820al.m15872e("[UploadManager] Failed to add upload task to temp urgent queue: %s", th.getMessage());
            }
        }
    }

    /* renamed from: a */
    private void m15907a(int i, LinkedBlockingQueue<Runnable> linkedBlockingQueue) {
        C12818ak m15887a = C12818ak.m15887a();
        if (i > 0) {
            C12820al.m15874c("[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(i), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        }
        for (int i2 = 0; i2 < i; i2++) {
            final Runnable poll = linkedBlockingQueue.poll();
            if (poll == null) {
                return;
            }
            synchronized (this.f36514j) {
                if (this.f36516l >= 2 && m15887a != null) {
                    m15887a.m15886a(poll);
                } else {
                    C12820al.m15878a("[UploadManager] Create and start a new thread to execute a upload task: %s", "BUGLY_ASYNC_UPLOAD");
                    if (C12828ap.m15834a(new Runnable() { // from class: com.tencent.bugly.proguard.ai.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            poll.run();
                            synchronized (C12814ai.this.f36514j) {
                                C12814ai.m15896b(C12814ai.this);
                            }
                        }
                    }, "BUGLY_ASYNC_UPLOAD") != null) {
                        synchronized (this.f36514j) {
                            this.f36516l++;
                        }
                    } else {
                        C12820al.m15873d("[UploadManager] Failed to start a thread to execute asynchronous upload task,will try again next time.", new Object[0]);
                        m15902a(poll, true);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m15902a(Runnable runnable, boolean z) {
        if (runnable == null) {
            C12820al.m15878a("[UploadManager] Upload task should not be null", new Object[0]);
            return false;
        }
        try {
            C12820al.m15874c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.f36514j) {
                if (z) {
                    this.f36512h.put(runnable);
                } else {
                    this.f36513i.put(runnable);
                }
            }
            return true;
        } catch (Throwable th) {
            C12820al.m15872e("[UploadManager] Failed to add upload task to queue: %s", th.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    private void m15903a(Runnable runnable, long j) {
        if (runnable == null) {
            C12820al.m15873d("[UploadManager] Upload task should not be null", new Object[0]);
            return;
        }
        C12820al.m15874c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        Thread m15834a = C12828ap.m15834a(runnable, "BUGLY_SYNC_UPLOAD");
        if (m15834a == null) {
            C12820al.m15872e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
            m15902a(runnable, true);
            return;
        }
        try {
            m15834a.join(j);
        } catch (Throwable th) {
            C12820al.m15872e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", th.getMessage());
            m15902a(runnable, true);
            m15898b();
        }
    }

    /* renamed from: a */
    private void m15901a(Runnable runnable, boolean z, boolean z2, long j) {
        C12820al.m15874c("[UploadManager] Add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (z2) {
            m15903a(runnable, j);
            return;
        }
        m15902a(runnable, z);
        m15898b();
    }
}

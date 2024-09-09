package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class ai {

    /* renamed from: b  reason: collision with root package name */
    private static ai f50879b;

    /* renamed from: a  reason: collision with root package name */
    public ah f50880a;

    /* renamed from: d  reason: collision with root package name */
    private final Context f50882d;

    /* renamed from: f  reason: collision with root package name */
    private long f50884f;

    /* renamed from: g  reason: collision with root package name */
    private long f50885g;

    /* renamed from: e  reason: collision with root package name */
    private Map<Integer, Long> f50883e = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    private LinkedBlockingQueue<Runnable> f50886h = new LinkedBlockingQueue<>();

    /* renamed from: i  reason: collision with root package name */
    private LinkedBlockingQueue<Runnable> f50887i = new LinkedBlockingQueue<>();

    /* renamed from: j  reason: collision with root package name */
    private final Object f50888j = new Object();

    /* renamed from: k  reason: collision with root package name */
    private long f50889k = 0;

    /* renamed from: l  reason: collision with root package name */
    private int f50890l = 0;

    /* renamed from: c  reason: collision with root package name */
    private final w f50881c = w.a();

    private ai(Context context) {
        this.f50882d = context;
    }

    static /* synthetic */ int b(ai aiVar) {
        int i4 = aiVar.f50890l - 1;
        aiVar.f50890l = i4;
        return i4;
    }

    public static synchronized ai a(Context context) {
        ai aiVar;
        synchronized (ai.class) {
            if (f50879b == null) {
                f50879b = new ai(context);
            }
            aiVar = f50879b;
        }
        return aiVar;
    }

    public final boolean b(int i4) {
        if (p.f51258c) {
            al.c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - a(i4);
        al.c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", Long.valueOf(currentTimeMillis / 1000), Integer.valueOf(i4));
        if (currentTimeMillis < PolicyConfig.mServerBusyRetryBaseInternal) {
            al.a("[UploadManager] Data only be uploaded once in %d seconds.", 30L);
            return false;
        }
        return true;
    }

    public static synchronized ai a() {
        ai aiVar;
        synchronized (ai.class) {
            aiVar = f50879b;
        }
        return aiVar;
    }

    public final void a(int i4, bq bqVar, String str, String str2, ah ahVar, long j4, boolean z3) {
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            a(new aj(this.f50882d, i4, bqVar.f51158g, ae.a((Object) bqVar), str, str2, ahVar, z3), true, true, j4);
        } catch (Throwable th2) {
            th = th2;
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private void b() {
        ak a4 = ak.a();
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
        final LinkedBlockingQueue linkedBlockingQueue2 = new LinkedBlockingQueue();
        synchronized (this.f50888j) {
            al.c("[UploadManager] Try to poll all upload task need and put them into temp queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            int size = this.f50886h.size();
            final int size2 = this.f50887i.size();
            if (size == 0 && size2 == 0) {
                al.c("[UploadManager] There is no upload task in queue.", new Object[0]);
                return;
            }
            size2 = (a4 == null || !a4.c()) ? 0 : 0;
            a(this.f50886h, linkedBlockingQueue, size);
            a(this.f50887i, linkedBlockingQueue2, size2);
            a(size, linkedBlockingQueue);
            if (size2 > 0) {
                al.c("[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(size2), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            }
            ak a5 = ak.a();
            if (a5 != null) {
                a5.a(new Runnable() { // from class: com.tencent.bugly.proguard.ai.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        Runnable runnable;
                        for (int i4 = 0; i4 < size2 && (runnable = (Runnable) linkedBlockingQueue2.poll()) != null; i4++) {
                            runnable.run();
                        }
                    }
                });
            }
        }
    }

    private void a(int i4, int i5, byte[] bArr, String str, String str2, ah ahVar, boolean z3) {
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            a(new aj(this.f50882d, i4, i5, bArr, str, str2, ahVar, 0, 0, false), z3, false, 0L);
        } catch (Throwable th2) {
            th = th2;
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final void a(int i4, bq bqVar, String str, String str2, ah ahVar, boolean z3) {
        a(i4, bqVar.f51158g, ae.a((Object) bqVar), str, str2, ahVar, z3);
    }

    public final long a(boolean z3) {
        long j4;
        long b4 = ap.b();
        int i4 = z3 ? 5 : 3;
        List<y> a4 = this.f50881c.a(i4);
        if (a4 != null && a4.size() > 0) {
            j4 = 0;
            try {
                y yVar = a4.get(0);
                if (yVar.f51338e >= b4) {
                    j4 = ap.d(yVar.f51340g);
                    if (i4 == 3) {
                        this.f50884f = j4;
                    } else {
                        this.f50885g = j4;
                    }
                    a4.remove(yVar);
                }
            } catch (Throwable th) {
                al.a(th);
            }
            if (a4.size() > 0) {
                this.f50881c.a(a4);
            }
        } else {
            j4 = z3 ? this.f50885g : this.f50884f;
        }
        al.c("[UploadManager] Local network consume: %d KB", Long.valueOf(j4 / 1024));
        return j4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized void a(long j4, boolean z3) {
        int i4 = z3 ? 5 : 3;
        y yVar = new y();
        yVar.f51335b = i4;
        yVar.f51338e = ap.b();
        yVar.f51336c = "";
        yVar.f51337d = "";
        yVar.f51340g = ap.c(j4);
        this.f50881c.b(i4);
        this.f50881c.a(yVar);
        if (z3) {
            this.f50885g = j4;
        } else {
            this.f50884f = j4;
        }
        al.c("[UploadManager] Network total consume: %d KB", Long.valueOf(j4 / 1024));
    }

    public final synchronized void a(int i4, long j4) {
        if (i4 < 0) {
            al.e("[UploadManager] Unknown uploading ID: %d", Integer.valueOf(i4));
            return;
        }
        this.f50883e.put(Integer.valueOf(i4), Long.valueOf(j4));
        y yVar = new y();
        yVar.f51335b = i4;
        yVar.f51338e = j4;
        yVar.f51336c = "";
        yVar.f51337d = "";
        yVar.f51340g = new byte[0];
        this.f50881c.b(i4);
        this.f50881c.a(yVar);
        al.c("[UploadManager] Uploading(ID:%d) time: %s", Integer.valueOf(i4), ap.a(j4));
    }

    public final synchronized long a(int i4) {
        if (i4 >= 0) {
            Long l4 = this.f50883e.get(Integer.valueOf(i4));
            if (l4 != null) {
                return l4.longValue();
            }
        } else {
            al.e("[UploadManager] Unknown upload ID: %d", Integer.valueOf(i4));
        }
        return 0L;
    }

    private static void a(LinkedBlockingQueue<Runnable> linkedBlockingQueue, LinkedBlockingQueue<Runnable> linkedBlockingQueue2, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            Runnable peek = linkedBlockingQueue.peek();
            if (peek == null) {
                return;
            }
            try {
                linkedBlockingQueue2.put(peek);
                linkedBlockingQueue.poll();
            } catch (Throwable th) {
                al.e("[UploadManager] Failed to add upload task to temp urgent queue: %s", th.getMessage());
            }
        }
    }

    private void a(int i4, LinkedBlockingQueue<Runnable> linkedBlockingQueue) {
        ak a4 = ak.a();
        if (i4 > 0) {
            al.c("[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(i4), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        }
        for (int i5 = 0; i5 < i4; i5++) {
            final Runnable poll = linkedBlockingQueue.poll();
            if (poll == null) {
                return;
            }
            synchronized (this.f50888j) {
                if (this.f50890l >= 2 && a4 != null) {
                    a4.a(poll);
                } else {
                    al.a("[UploadManager] Create and start a new thread to execute a upload task: %s", "BUGLY_ASYNC_UPLOAD");
                    if (ap.a(new Runnable() { // from class: com.tencent.bugly.proguard.ai.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            poll.run();
                            synchronized (ai.this.f50888j) {
                                ai.b(ai.this);
                            }
                        }
                    }, "BUGLY_ASYNC_UPLOAD") != null) {
                        synchronized (this.f50888j) {
                            this.f50890l++;
                        }
                    } else {
                        al.d("[UploadManager] Failed to start a thread to execute asynchronous upload task,will try again next time.", new Object[0]);
                        a(poll, true);
                    }
                }
            }
        }
    }

    private boolean a(Runnable runnable, boolean z3) {
        if (runnable == null) {
            al.a("[UploadManager] Upload task should not be null", new Object[0]);
            return false;
        }
        try {
            al.c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.f50888j) {
                if (z3) {
                    this.f50886h.put(runnable);
                } else {
                    this.f50887i.put(runnable);
                }
            }
            return true;
        } catch (Throwable th) {
            al.e("[UploadManager] Failed to add upload task to queue: %s", th.getMessage());
            return false;
        }
    }

    private void a(Runnable runnable, long j4) {
        if (runnable == null) {
            al.d("[UploadManager] Upload task should not be null", new Object[0]);
            return;
        }
        al.c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        Thread a4 = ap.a(runnable, "BUGLY_SYNC_UPLOAD");
        if (a4 == null) {
            al.e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
            a(runnable, true);
            return;
        }
        try {
            a4.join(j4);
        } catch (Throwable th) {
            al.e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", th.getMessage());
            a(runnable, true);
            b();
        }
    }

    private void a(Runnable runnable, boolean z3, boolean z4, long j4) {
        al.c("[UploadManager] Add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (z4) {
            a(runnable, j4);
            return;
        }
        a(runnable, z3);
        b();
    }
}

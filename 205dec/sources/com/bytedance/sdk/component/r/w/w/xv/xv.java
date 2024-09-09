package com.bytedance.sdk.component.r.w.w.xv;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.debug.EventDebugUtils;
import com.bytedance.sdk.component.r.w.c.ux;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends HandlerThread implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private static int f30163a = 10;
    private static int bk = 200;

    /* renamed from: c  reason: collision with root package name */
    protected ux f30164c;
    private final long ev;

    /* renamed from: f  reason: collision with root package name */
    private volatile int f30165f;
    private final String fp;
    private volatile String fz;
    private final long gd;

    /* renamed from: i  reason: collision with root package name */
    private final com.bytedance.sdk.component.r.c.ux f30166i;
    private final String ia;

    /* renamed from: j  reason: collision with root package name */
    private com.bytedance.sdk.component.r.w.c.w f30167j;

    /* renamed from: k  reason: collision with root package name */
    private final List<com.bytedance.sdk.component.r.c.w> f30168k;

    /* renamed from: p  reason: collision with root package name */
    private volatile Handler f30169p;

    /* renamed from: q  reason: collision with root package name */
    private final com.bytedance.sdk.component.r.w.w.w f30170q;

    /* renamed from: r  reason: collision with root package name */
    private final AtomicInteger f30171r;

    /* renamed from: s  reason: collision with root package name */
    private volatile int f30172s;
    private sr sr;

    /* renamed from: t  reason: collision with root package name */
    private final String f30173t;

    /* renamed from: u  reason: collision with root package name */
    private final HashMap<String, List<com.bytedance.sdk.component.r.c.w>> f30174u;
    private final PriorityBlockingQueue<com.bytedance.sdk.component.r.c.w> ux;

    /* renamed from: w  reason: collision with root package name */
    private volatile boolean f30175w;
    private final Object xv;
    private final String ys;

    public xv(PriorityBlockingQueue<com.bytedance.sdk.component.r.c.w> priorityBlockingQueue, com.bytedance.sdk.component.r.c.ux uxVar, com.bytedance.sdk.component.r.w.w.w wVar) {
        super(uxVar.ux() + "_log");
        this.f30175w = true;
        this.xv = new Object();
        this.f30171r = new AtomicInteger(0);
        this.ev = 5000L;
        this.gd = 5000000000L;
        this.f30168k = new ArrayList();
        this.f30173t = "after_upload";
        this.ys = "dispatch_new_event";
        this.fp = "notify_least_once";
        this.ia = "prepare_upload";
        this.f30172s = 0;
        this.fz = "DEFAULT";
        this.f30174u = new HashMap<>();
        this.ux = priorityBlockingQueue;
        this.f30166i = uxVar;
        this.f30170q = wVar;
        this.f30164c = new com.bytedance.sdk.component.r.w.c.xv(uxVar);
        this.sr = new sr(uxVar, wVar);
    }

    private void ev() {
        if (this.ux.size() >= 100) {
            for (int i4 = 0; i4 < 100; i4++) {
                com.bytedance.sdk.component.r.c.w poll = this.ux.poll();
                if (poll instanceof com.bytedance.sdk.component.r.w.sr.c) {
                    com.bytedance.sdk.component.r.w.xv.xv.c("ignore tm", this.f30166i);
                } else if (poll != null) {
                    c(poll);
                } else {
                    com.bytedance.sdk.component.r.w.xv.xv.sr("event == null", this.f30166i);
                }
            }
        }
    }

    private void f() {
        while (xv()) {
            try {
                com.bytedance.sdk.component.r.c.w poll = this.ux.poll(60000L, TimeUnit.MILLISECONDS);
                int size = this.ux.size();
                com.bytedance.sdk.component.r.w.xv.xv.c("poll size:" + size, this.f30166i);
                if (poll instanceof com.bytedance.sdk.component.r.w.sr.c) {
                    c(poll, size);
                } else if (poll == null) {
                    int incrementAndGet = this.f30171r.incrementAndGet();
                    if (c(incrementAndGet)) {
                        r();
                        return;
                    } else if (incrementAndGet < 4) {
                        com.bytedance.sdk.component.r.w.xv.xv.xv("flush once begin; timeoutCount:" + incrementAndGet, this.f30166i);
                        this.f30165f = 1;
                        w(4, "batch_once");
                        xv(null);
                    }
                } else {
                    c(poll);
                    xv(poll);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                com.bytedance.sdk.component.r.w.xv.xv.sr("run exception:" + th.getMessage(), this.f30166i);
                com.bytedance.sdk.component.r.w.xv.w.c(com.bytedance.sdk.component.r.w.w.w.f30136c.ux(), 1, this.f30166i);
            }
        }
    }

    private boolean gd() {
        return this.f30170q.f30140w && (this.f30165f == 4 || this.f30165f == 7 || this.f30165f == 6 || this.f30165f == 5 || this.f30165f == 2);
    }

    private void k() {
        long nanoTime;
        StringBuilder sb;
        boolean z3;
        c("after_upload");
        com.bytedance.sdk.component.r.w.xv.xv.c("afterUpload message:" + com.bytedance.sdk.component.r.w.xv.c.w(this.f30165f), this.f30166i);
        if (this.f30165f == 2) {
            synchronized (this.xv) {
                try {
                    try {
                        long nanoTime2 = System.nanoTime();
                        this.xv.wait(5000L);
                        nanoTime = System.nanoTime() - nanoTime2;
                        sb = new StringBuilder();
                        sb.append("afterUpload delta:");
                        sb.append(nanoTime);
                        sb.append(" start:");
                        sb.append(nanoTime2);
                        sb.append(" condition:");
                    } catch (InterruptedException e4) {
                        com.bytedance.sdk.component.r.w.xv.xv.sr("wait exception:" + e4.getMessage(), this.f30166i);
                        e4.printStackTrace();
                    }
                    if (!this.f30170q.f30140w && !this.f30170q.xv) {
                        z3 = false;
                        sb.append(z3);
                        com.bytedance.sdk.component.r.w.xv.xv.c(sb.toString(), this.f30166i);
                        if (nanoTime < 5000000000L && 5000000000L - nanoTime >= 50000000) {
                            if (!this.f30170q.f30140w && !this.f30170q.xv) {
                                com.bytedance.sdk.component.r.w.xv.xv.xv("afterUpload meet notifyRunOnce flush memory db again", this.f30166i);
                                com.bytedance.sdk.component.r.w.xv.w.c(com.bytedance.sdk.component.r.w.w.w.f30136c.sr(), 1, this.f30166i);
                                c(2, "continue");
                                return;
                            }
                            com.bytedance.sdk.component.r.w.xv.xv.sr("afterUpload wait serverBusy", this.f30166i);
                            return;
                        }
                        com.bytedance.sdk.component.r.w.xv.xv.sr("afterUpload wait timeout", this.f30166i);
                    }
                    z3 = true;
                    sb.append(z3);
                    com.bytedance.sdk.component.r.w.xv.xv.c(sb.toString(), this.f30166i);
                    if (nanoTime < 5000000000L) {
                        if (!this.f30170q.f30140w) {
                            com.bytedance.sdk.component.r.w.xv.xv.xv("afterUpload meet notifyRunOnce flush memory db again", this.f30166i);
                            com.bytedance.sdk.component.r.w.xv.w.c(com.bytedance.sdk.component.r.w.w.w.f30136c.sr(), 1, this.f30166i);
                            c(2, "continue");
                            return;
                        }
                        com.bytedance.sdk.component.r.w.xv.xv.sr("afterUpload wait serverBusy", this.f30166i);
                        return;
                    }
                    com.bytedance.sdk.component.r.w.xv.xv.sr("afterUpload wait timeout", this.f30166i);
                } finally {
                }
            }
        }
    }

    private void p() {
        com.bytedance.sdk.component.r.c.sr sr = this.f30166i.sr();
        if (this.ux.size() == 0) {
            c(false);
            if (this.f30169p.hasMessages(11)) {
                this.f30169p.removeMessages(11);
            }
            if (this.f30169p.hasMessages(1)) {
                this.f30169p.removeMessages(1);
            }
            long j4 = bk;
            if (sr != null && sr.a() != null) {
                j4 = sr.a().xv();
            }
            this.f30169p.sendEmptyMessageDelayed(11, j4);
            com.bytedance.sdk.component.r.w.xv.xv.c("_delay", "handler send delay:" + j4 + " size:" + this.f30168k.size(), this.f30166i);
            return;
        }
        com.bytedance.sdk.component.r.w.xv.xv.c("_delay", "continue save event until size >= 10 \uff1a" + this.f30175w + " " + this.f30168k.size(), this.f30166i);
    }

    private void r() {
        com.bytedance.sdk.component.r.w.xv.w.c(com.bytedance.sdk.component.r.w.w.w.f30136c.gd(), 1, this.f30166i);
        c(false);
        this.f30170q.w();
        com.bytedance.sdk.component.r.w.xv.xv.xv("exit log thread", this.f30166i);
    }

    private void sr() {
        com.bytedance.sdk.component.r.w.xv.xv.c("sendServerBusyOrRoutineErrorRetryMessage", this.f30166i);
        ux();
        c(1, "busy_error");
    }

    private void ux() {
        if (!isAlive()) {
            com.bytedance.sdk.component.r.w.xv.xv.c("th dead", this.f30166i);
            this.f30170q.c(this.f30166i.ux());
        } else if (xv()) {
        } else {
            com.bytedance.sdk.component.r.w.xv.xv.c("monitor  mLogThread ", this.f30166i);
            c(6, "quit");
        }
    }

    public ux c() {
        return this.f30164c;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i4 = message.what;
        try {
        } catch (Throwable th) {
            com.bytedance.sdk.component.r.w.xv.xv.sr("error:" + th.getMessage(), this.f30166i);
        }
        if (i4 == 1) {
            com.bytedance.sdk.component.r.w.xv.xv.c("HANDLER_MESSAGE_INIT", this.f30166i);
            c(true);
            f();
        } else if (i4 != 2 && i4 != 3) {
            if (i4 == 11) {
                com.bytedance.sdk.component.r.w.xv.xv.c("_opt", "do upload", this.f30166i);
                ArrayList arrayList = new ArrayList(this.f30168k);
                this.f30168k.clear();
                c(arrayList, false, EventDebugUtils.DEBUG_UPLOAD_CACHE_TIME_OUT);
            }
            return true;
        } else {
            com.bytedance.sdk.component.r.w.xv.xv.c("-----------------server busy handleMessage---------------- ", this.f30166i);
            sr();
        }
        return true;
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        this.f30169p = new Handler(getLooper(), this);
        this.f30170q.c(this.f30169p);
        this.f30169p.sendEmptyMessage(1);
        com.bytedance.sdk.component.r.w.xv.xv.c("onLooperPrepared", this.f30166i);
    }

    public Handler w() {
        return this.f30169p;
    }

    public boolean xv() {
        return this.f30175w;
    }

    private void w(int i4, String str) {
        this.f30172s = i4;
        this.fz = str;
    }

    private void xv(com.bytedance.sdk.component.r.c.w wVar) {
        if (w(wVar)) {
            return;
        }
        boolean c4 = c(this.f30165f, this.f30170q.f30140w, "needUpload check", wVar);
        com.bytedance.sdk.component.r.w.xv.xv.c("_opt", "prepareUpload check end debugMessage:" + this.f30172s + " origin:" + this.fz, this.f30166i);
        if (c4) {
            ux uxVar = this.f30164c;
            int i4 = this.f30165f;
            List<com.bytedance.sdk.component.r.c.w> c5 = uxVar.c(i4, wVar, this.f30172s + "_" + this.fz);
            if (this.f30165f != 2 && this.f30165f != 1) {
                this.f30174u.clear();
            } else {
                String c6 = com.bytedance.sdk.component.r.w.xv.c.c(c5);
                if (com.bytedance.sdk.component.r.w.xv.c.c(c5, this.f30174u.get(c6), this.f30166i)) {
                    this.f30174u.clear();
                    this.f30167j = this.f30164c.c(-3, c5);
                    com.bytedance.sdk.component.r.w.xv.xv.sr("_delete", "flush_memory_db or batch_once meet repeat, so force delete", this.f30166i);
                    c("prepare_upload");
                    return;
                } else if (!TextUtils.isEmpty(c6)) {
                    this.f30174u.put(c6, c5);
                }
            }
            if (c5 != null && c5.size() != 0) {
                com.bytedance.sdk.component.r.w.xv.xv.xv("_opt", "prepare upload result -> need true, size=" + c5.size(), this.f30166i);
                c(c5, this.f30165f);
            } else {
                com.bytedance.sdk.component.r.w.xv.xv.xv("_opt", "prepare upload result -> need true, no event need upload", this.f30166i);
                c("prepare_upload");
                c4 = false;
            }
        } else {
            com.bytedance.sdk.component.r.w.xv.xv.xv("_opt", "prepare upload result -> need false", this.f30166i);
            this.f30174u.clear();
            c("prepare_upload");
        }
        com.bytedance.sdk.component.r.w.xv.xv.w("_opt", "loop  needupload:" + c4, this.f30166i);
    }

    public void c(boolean z3) {
        this.f30175w = z3;
    }

    public boolean c(int i4, boolean z3, String str, com.bytedance.sdk.component.r.c.w wVar) {
        com.bytedance.sdk.component.r.c.ux uxVar = this.f30166i;
        if (uxVar == null) {
            return false;
        }
        com.bytedance.sdk.component.r.c.sr sr = uxVar.sr();
        if (sr != null && sr.c(this.f30166i.getContext())) {
            return this.f30164c.c(i4, z3, str, wVar);
        }
        com.bytedance.sdk.component.r.w.xv.xv.sr("AdThread NET IS NOT AVAILABLE!!!", this.f30166i);
        return false;
    }

    private boolean w(com.bytedance.sdk.component.r.c.w wVar) {
        sr srVar;
        com.bytedance.sdk.component.r.c.ux uxVar;
        if (com.bytedance.sdk.component.r.w.xv.c.c(this.f30166i) && (uxVar = this.f30166i) != null && uxVar.xv()) {
            com.bytedance.sdk.component.r.w.xv.xv.xv("prepared upload cancel meet delay before init set\u3002" + com.bytedance.sdk.component.r.w.xv.c.xv(wVar, this.f30166i), this.f30166i);
            return true;
        }
        if (gd()) {
            com.bytedance.sdk.component.r.w.xv.xv.xv("prepared upload cancel meet busy:" + com.bytedance.sdk.component.r.w.xv.c.w(this.f30165f), this.f30166i);
            com.bytedance.sdk.component.r.w.xv.w.c(com.bytedance.sdk.component.r.w.w.w.f30136c.c(), 1, this.f30166i);
            if (this.ux.size() == 0) {
                if (!this.f30169p.hasMessages(2) && (srVar = this.sr) != null) {
                    srVar.c();
                } else {
                    c(false);
                }
            }
            return true;
        }
        return false;
    }

    public void c(com.bytedance.sdk.component.r.c.w wVar, boolean z3) {
        if (wVar == null) {
            return;
        }
        com.bytedance.sdk.component.r.w.xv.xv.c("other thread ignore result : " + z3 + " isRun:" + this.f30175w + " adType: " + ((int) wVar.sr()), this.f30166i);
        if (z3) {
            if (this.f30169p != null) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(wVar);
                c(arrayList, true, EventDebugUtils.DEBUG_UPLOAD_IGNORE_RESULT);
                return;
            }
            com.bytedance.sdk.component.r.w.xv.xv.sr("other thread handler is null\uff0cignore is true", this.f30166i);
            return;
        }
        this.ux.add(wVar);
        w("dispatch_new_event");
    }

    private void w(List<com.bytedance.sdk.component.r.c.w> list, String str) {
        this.f30168k.addAll(list);
        com.bytedance.sdk.component.r.w.xv.xv.c("_opt", "uploadBatchOptimize:" + str + " size:" + this.f30168k.size(), this.f30166i);
        com.bytedance.sdk.component.r.c.sr sr = this.f30166i.sr();
        if (sr != null && sr.a() != null) {
            f30163a = sr.a().sr();
        }
        if (this.f30168k.size() >= f30163a) {
            if (this.f30169p.hasMessages(11)) {
                this.f30169p.removeMessages(11);
            }
            ArrayList arrayList = new ArrayList(this.f30168k);
            this.f30168k.clear();
            c(arrayList, false, EventDebugUtils.DEBUG_UPLOAD_MAX_SIZE);
            return;
        }
        p();
    }

    public void c(int i4, String str) {
        try {
            boolean z3 = this.f30170q.f30140w;
            boolean c4 = c(i4, z3, str + " check", null);
            com.bytedance.sdk.component.r.w.xv.xv.xv("notify runOnce check: " + c4 + " " + com.bytedance.sdk.component.r.w.xv.c.w(i4) + " from" + str, this.f30166i);
            if (i4 == 6 || c4) {
                com.bytedance.sdk.component.r.w.sr.c cVar = new com.bytedance.sdk.component.r.w.sr.c();
                cVar.w(i4);
                cVar.xv(str);
                this.ux.add(cVar);
                w("notify_least_once");
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.r.w.xv.xv.sr(th.getMessage(), this.f30166i);
        }
    }

    private void c(com.bytedance.sdk.component.r.c.w wVar, int i4) {
        this.f30171r.set(0);
        com.bytedance.sdk.component.r.w.sr.c cVar = (com.bytedance.sdk.component.r.w.sr.c) wVar;
        int k4 = cVar.k();
        if (i4 == 0) {
            w(1, cVar.p());
            this.f30165f = k4;
            if (this.f30165f != 6) {
                com.bytedance.sdk.component.r.w.xv.w.c(com.bytedance.sdk.component.r.w.w.w.f30136c.ev(), 1, this.f30166i);
                xv(wVar);
            }
        } else if (k4 == 1) {
            this.f30165f = 1;
            w(2, cVar.p());
            xv(wVar);
        } else if (k4 == 2) {
            com.bytedance.sdk.component.r.w.xv.xv.c("before size:" + i4, this.f30166i);
            ev();
            com.bytedance.sdk.component.r.w.xv.xv.c("after size :" + i4, this.f30166i);
            this.f30165f = 2;
            w(3, cVar.p());
            xv(wVar);
        }
    }

    private void w(String str) {
        if (!xv()) {
            if (this.f30169p == null) {
                return;
            }
            if (!this.f30169p.hasMessages(1)) {
                com.bytedance.sdk.component.r.w.xv.xv.c("send message to event loop init:" + str, this.f30166i);
                this.f30169p.sendEmptyMessage(1);
                return;
            }
            com.bytedance.sdk.component.r.w.xv.xv.c("wait handler message init:" + str, this.f30166i);
            return;
        }
        com.bytedance.sdk.component.r.w.xv.xv.c("event loop already:" + str, this.f30166i);
    }

    private boolean c(int i4) {
        return i4 >= 4 && this.sr.f30152c.get() == 0 && !this.f30170q.f30140w && !this.f30170q.xv;
    }

    private void c(com.bytedance.sdk.component.r.c.w wVar) {
        this.f30171r.set(0);
        if (this.f30170q.f30140w) {
            w(5, "new_busy");
            this.f30165f = 5;
        } else if (this.f30170q.xv) {
            w(6, "new_error");
            this.f30165f = 7;
        } else {
            w(7, "new_event");
            this.f30165f = 4;
        }
        com.bytedance.sdk.component.r.w.xv.w.c(com.bytedance.sdk.component.r.w.w.w.f30136c.ys(), 1, this.f30166i);
        this.f30164c.c(wVar, this.f30165f);
        com.bytedance.sdk.component.r.w.xv.c.c(this.f30165f, wVar, this.f30166i);
        com.bytedance.sdk.component.r.w.xv.c.ev(wVar, this.f30166i);
    }

    private void c(String str) {
        if (this.f30168k.size() != 0) {
            p();
        } else {
            w(str);
        }
    }

    private void c(List<com.bytedance.sdk.component.r.c.w> list, String str) {
        c(list, false, str);
    }

    private void c(List<com.bytedance.sdk.component.r.c.w> list, int i4) {
        com.bytedance.sdk.component.r.w.xv.c.c(list, this.ux.size(), this.f30166i);
        com.bytedance.sdk.component.r.c.w wVar = list.get(0);
        if (wVar == null) {
            com.bytedance.sdk.component.r.w.xv.xv.sr("_error", "adLogEvent is null", this.f30166i);
        } else if (list.size() <= 1 && !com.bytedance.sdk.component.r.w.xv.c.w(this.f30166i) && !com.bytedance.sdk.component.r.w.xv.c.sr(this.f30166i)) {
            if (wVar.ux() == 1) {
                c(list, EventDebugUtils.DEBUG_HIGH_PRIORITY);
                com.bytedance.sdk.component.r.w.xv.xv.w("PADLT", "Single high priority \uff08 applog \uff09", this.f30166i);
            } else if (wVar.sr() == 0 && wVar.ux() == 2) {
                if (wVar.w() == 3) {
                    c(list, "version_v3_single_directly");
                } else {
                    w(list, "singleOptimize");
                }
            } else if (wVar.sr() == 1) {
                com.bytedance.sdk.component.r.w.xv.xv.w("PADLT", "Stats batch report \uff08 stats \uff09", this.f30166i);
                c(list, "stats_directly");
            } else if (wVar.sr() == 3) {
                c(list, "adType_v3_directly");
            } else if (wVar.sr() == 2) {
                com.bytedance.sdk.component.r.w.xv.xv.w("PADLT", "Single high priority \uff08 stats \uff09", this.f30166i);
                c(list, "other_directly");
            } else {
                com.bytedance.sdk.component.r.w.xv.xv.c("_opt", "adLogEvent adType error", this.f30166i);
            }
        } else {
            com.bytedance.sdk.component.r.w.xv.xv.w("PADLT", "Batch report\uff08 local or stats \uff09", this.f30166i);
            if (wVar.sr() == 0 && wVar.ux() == 2 && i4 == 4) {
                if (wVar.w() == 3) {
                    c(list, "version_v3_batch");
                    return;
                } else {
                    w(list, "batchOptimize");
                    return;
                }
            }
            c(list, EventDebugUtils.DEBUG_BATCH_READ);
        }
    }

    private void c(List<com.bytedance.sdk.component.r.c.w> list, boolean z3, String str) {
        this.sr.c(list, z3, str, this.f30165f, this.xv, this.f30167j);
        if (z3) {
            return;
        }
        k();
    }
}

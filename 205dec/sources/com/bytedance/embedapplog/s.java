package com.bytedance.embedapplog;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class s {

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicLong f26793f = new AtomicLong(1000);
    private static c ys;

    /* renamed from: a  reason: collision with root package name */
    private int f26794a;
    private String bk;

    /* renamed from: c  reason: collision with root package name */
    private final n f26795c;
    private int ev;
    private long gd = -1;

    /* renamed from: k  reason: collision with root package name */
    private long f26796k;

    /* renamed from: p  reason: collision with root package name */
    private volatile boolean f26797p;

    /* renamed from: r  reason: collision with root package name */
    private long f26798r;
    private wo sr;

    /* renamed from: t  reason: collision with root package name */
    private bm f26799t;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private final ck f26800w;
    private wo xv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c extends ox {
        private c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ck ckVar, n nVar) {
        this.f26800w = ckVar;
        this.f26795c = nVar;
    }

    public static long sr() {
        return f26793f.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c ux() {
        if (ys == null) {
            ys = new c();
        }
        ys.f26814w = System.currentTimeMillis();
        return ys;
    }

    public String c() {
        return this.ux;
    }

    public boolean w() {
        return this.f26797p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean xv() {
        return w() && this.f26796k == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Bundle c(long j4, long j5) {
        Bundle bundle;
        bundle = null;
        if (this.f26795c.ux() && xv()) {
            long j6 = this.f26798r;
            if (j6 > 0 && j4 - j6 > j5) {
                bundle = new Bundle();
                bundle.putInt("session_no", this.f26794a);
                int i4 = this.ev + 1;
                this.ev = i4;
                bundle.putInt("send_times", i4);
                bundle.putLong("current_duration", (j4 - this.f26798r) / 1000);
                bundle.putString("session_start_time", up.w(this.gd));
                this.f26798r = j4;
            }
        }
        return bundle;
    }

    public void w(up upVar) {
        if (upVar != null) {
            if (this.f26795c.i()) {
                upVar.ev = com.bytedance.embedapplog.c.sr();
            }
            upVar.f26810f = com.bytedance.embedapplog.c.gd();
            upVar.f26813r = com.bytedance.embedapplog.c.ev();
            upVar.sr = this.ux;
            upVar.xv = sr();
        }
    }

    private synchronized void c(up upVar, ArrayList<up> arrayList, boolean z3) {
        long j4 = upVar instanceof c ? -1L : upVar.f26814w;
        this.ux = UUID.randomUUID().toString();
        f26793f.set(1000L);
        this.gd = j4;
        this.f26797p = z3;
        this.f26796k = 0L;
        this.f26798r = 0L;
        if (be.f26702w) {
            be.c("startSession, " + this.ux + ", hadUi:" + z3 + " data:" + upVar, null);
        }
        if (z3) {
            Calendar calendar = Calendar.getInstance();
            String str = "" + calendar.get(1) + calendar.get(2) + calendar.get(5);
            if (TextUtils.isEmpty(this.bk)) {
                this.bk = this.f26795c.w();
                this.f26794a = this.f26795c.xv();
            }
            if (!str.equals(this.bk)) {
                this.bk = str;
                this.f26794a = 1;
            } else {
                this.f26794a++;
            }
            this.f26795c.c(str, this.f26794a);
            this.ev = 0;
            this.f26798r = upVar.f26814w;
        }
        if (j4 != -1) {
            bm bmVar = new bm(false);
            bmVar.sr = this.ux;
            bmVar.xv = sr();
            bmVar.f26814w = this.gd;
            bmVar.f26709t = this.f26797p ? false : true;
            bmVar.bk = this.f26800w.xv();
            bmVar.f26707a = this.f26800w.w();
            bmVar.f26810f = com.bytedance.embedapplog.c.gd();
            bmVar.f26813r = com.bytedance.embedapplog.c.ev();
            if (this.f26795c.i()) {
                bmVar.ev = com.bytedance.embedapplog.c.sr();
            }
            arrayList.add(bmVar);
            this.f26799t = bmVar;
            if (be.f26702w) {
                be.c("gen launch, " + bmVar.sr + ", hadUi:" + z3, null);
            }
        }
    }

    public static boolean c(up upVar) {
        if (upVar instanceof wo) {
            return ((wo) upVar).p();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(up upVar, ArrayList<up> arrayList) {
        boolean z3 = upVar instanceof wo;
        boolean c4 = c(upVar);
        boolean z4 = true;
        if (this.gd == -1) {
            c(upVar, arrayList, c(upVar));
        } else if (!this.f26797p && c4) {
            c(upVar, arrayList, true);
        } else {
            long j4 = this.f26796k;
            if (j4 != 0 && upVar.f26814w > j4 + this.f26795c.j()) {
                if (!g.w() && g.c()) {
                    c(upVar, arrayList, c4);
                }
            } else if (this.gd > upVar.f26814w + 7200000) {
                c(upVar, arrayList, c4);
            } else {
                z4 = false;
            }
        }
        if (z3) {
            wo woVar = (wo) upVar;
            if (woVar.p()) {
                this.f26796k = 0L;
                arrayList.add(upVar);
                if (TextUtils.isEmpty(woVar.bk)) {
                    wo woVar2 = this.sr;
                    if (woVar2 != null && (woVar.f26814w - woVar2.f26814w) - woVar2.f26832a < 500) {
                        woVar.bk = woVar2.f26834t;
                    } else {
                        wo woVar3 = this.xv;
                        if (woVar3 != null && (woVar.f26814w - woVar3.f26814w) - woVar3.f26832a < 500) {
                            woVar.bk = woVar3.f26834t;
                        }
                    }
                }
            } else {
                Bundle c5 = c(upVar.f26814w, 0L);
                if (c5 != null) {
                    com.bytedance.embedapplog.c.c("play_session", c5);
                }
                this.f26796k = woVar.f26814w;
                arrayList.add(upVar);
                if (woVar.k()) {
                    this.xv = woVar;
                } else {
                    this.sr = woVar;
                    this.xv = null;
                }
            }
        } else if (!(upVar instanceof c)) {
            arrayList.add(upVar);
        }
        w(upVar);
        return z4;
    }
}

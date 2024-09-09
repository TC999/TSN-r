package com.bytedance.sdk.component.r.w.w.xv;

import android.os.Handler;
import android.os.Message;
import com.bytedance.sdk.component.r.c.p;
import com.bytedance.sdk.component.r.c.ux;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {
    private final com.bytedance.sdk.component.r.w.w.w ev;

    /* renamed from: r  reason: collision with root package name */
    private final ux f30154r;

    /* renamed from: w  reason: collision with root package name */
    private xv f30155w;
    private volatile long xv = 0;
    private volatile long sr = 0;
    private final AtomicInteger ux = new AtomicInteger(0);

    /* renamed from: f  reason: collision with root package name */
    private final AtomicInteger f30153f = new AtomicInteger(0);

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f30152c = new AtomicInteger(0);

    public sr(ux uxVar, com.bytedance.sdk.component.r.w.w.w wVar) {
        this.f30154r = uxVar;
        this.ev = wVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(List<com.bytedance.sdk.component.r.c.w> list, boolean z3, long j4, int i4, Object obj) {
        w c4;
        try {
            com.bytedance.sdk.component.r.w.xv.w.c(com.bytedance.sdk.component.r.w.w.w.f30136c.ls(), 1, this.f30154r);
            if (list.get(0).sr() == 0) {
                c4 = com.bytedance.sdk.component.r.w.w.ev().c(list);
                c(c4, list);
                if (c4 != null) {
                    com.bytedance.sdk.component.r.w.xv.c.c(list, c4.sr, this.f30154r);
                }
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (com.bytedance.sdk.component.r.c.w wVar : list) {
                        jSONArray.put(wVar.r());
                    }
                    jSONObject.put("stats_list", jSONArray);
                } catch (Exception e4) {
                    com.bytedance.sdk.component.r.w.xv.xv.sr("json exception:" + e4.getMessage(), this.f30154r);
                }
                c4 = com.bytedance.sdk.component.r.w.w.ev().c(jSONObject);
            }
            w wVar2 = c4;
            this.f30152c.decrementAndGet();
            c(z3, wVar2, list, j4, obj, i4);
        } catch (Throwable th) {
            com.bytedance.sdk.component.r.w.xv.xv.sr("inner exception:" + th.getMessage(), this.f30154r);
            com.bytedance.sdk.component.r.w.xv.w.c(com.bytedance.sdk.component.r.w.w.w.f30136c.ux(), 1, this.f30154r);
            this.f30152c.decrementAndGet();
        }
    }

    public void c(List<com.bytedance.sdk.component.r.c.w> list, boolean z3, String str, int i4, Object obj, com.bytedance.sdk.component.r.w.c.w wVar) {
        this.f30155w = this.ev.ux();
        long currentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.r.w.xv.c.c(list, i4, str, this.f30154r);
        if (this.f30154r.p() != null) {
            c(list, z3, currentTimeMillis, obj, i4);
            return;
        }
        com.bytedance.sdk.component.r.w.xv.c.c(list, str, wVar);
        c(list, z3, currentTimeMillis, i4, obj);
    }

    private void c(final List<com.bytedance.sdk.component.r.c.w> list, final boolean z3, final long j4, final int i4, final Object obj) {
        com.bytedance.sdk.component.r.c.sr sr = this.f30154r.sr();
        if (sr != null) {
            Executor gd = sr.gd();
            if (list.get(0).ux() == 1) {
                gd = sr.ev();
            }
            Executor executor = gd;
            if (executor == null) {
                return;
            }
            this.f30152c.incrementAndGet();
            executor.execute(new com.bytedance.sdk.component.r.w.ux.w("csj_log_upload") { // from class: com.bytedance.sdk.component.r.w.w.xv.sr.1
                @Override // java.lang.Runnable
                public void run() {
                    sr.this.w(list, z3, j4, i4, obj);
                }
            });
        }
    }

    private void c(w wVar, List<com.bytedance.sdk.component.r.c.w> list) {
        if (wVar == null || !wVar.f30161c) {
            return;
        }
        List<com.bytedance.sdk.component.r.c.xv> c4 = com.bytedance.sdk.component.r.w.c.c();
        if (list == null || c4 == null || c4.size() == 0) {
            return;
        }
        for (com.bytedance.sdk.component.r.c.w wVar2 : list) {
            if (wVar2.ux() == 1) {
                String c5 = com.bytedance.sdk.component.r.w.xv.c.c(wVar2, this.f30154r);
                String f4 = com.bytedance.sdk.component.r.w.xv.c.f(wVar2, this.f30154r);
                for (com.bytedance.sdk.component.r.c.xv xvVar : c4) {
                    if (xvVar != null) {
                        xvVar.c(c5, f4);
                    }
                }
            }
        }
    }

    private void c(List<com.bytedance.sdk.component.r.c.w> list, final boolean z3, final long j4, final Object obj, final int i4) {
        this.f30152c.incrementAndGet();
        com.bytedance.sdk.component.r.w.xv.w.c(com.bytedance.sdk.component.r.w.w.w.f30136c.ls(), 1, this.f30154r);
        try {
            this.f30154r.p().c(list, new p() { // from class: com.bytedance.sdk.component.r.w.w.xv.sr.2
                @Override // com.bytedance.sdk.component.r.c.p
                public void c(List<c> list2) {
                    try {
                        sr.this.f30152c.decrementAndGet();
                        if (list2 == null || list2.size() == 0) {
                            return;
                        }
                        int size = list2.size();
                        for (int i5 = 0; i5 < size; i5++) {
                            c cVar = list2.get(i5);
                            if (cVar != null) {
                                sr.this.c(z3, cVar.c(), cVar.w(), j4, obj, i4);
                            }
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            });
        } catch (Exception e4) {
            com.bytedance.sdk.component.r.w.xv.xv.sr("outer exception\uff1a" + e4.getMessage(), this.f30154r);
            com.bytedance.sdk.component.r.w.xv.w.c(com.bytedance.sdk.component.r.w.w.w.f30136c.ux(), 1, this.f30154r);
            this.f30152c.decrementAndGet();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z3, w wVar, List<com.bytedance.sdk.component.r.c.w> list, long j4, Object obj, int i4) {
        if (z3) {
            return;
        }
        if (wVar != null) {
            int i5 = wVar.f30162w;
            if (wVar.ux) {
                i5 = -1;
            } else if (i5 < 0) {
                i5 = -2;
            }
            i5 = (i5 == 510 || i5 == 511) ? -2 : -2;
            if (!wVar.f30161c && ((i5 >= 500 && i5 < 509) || i5 > 513)) {
                i5 = -2;
            }
            if (list != null) {
                com.bytedance.sdk.component.r.w.xv.xv.c("preprocessResult code is " + i5 + " sz:" + list.size() + "  count:" + this.f30152c.get(), this.f30154r);
            }
            c(i5, list, j4, obj, i4);
            return;
        }
        c(-1, list, j4, obj, i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x011e A[Catch: all -> 0x0168, TryCatch #0 {, blocks: (B:7:0x0009, B:9:0x0021, B:11:0x0027, B:62:0x011e, B:63:0x0128, B:22:0x0040, B:24:0x0055, B:25:0x005c, B:27:0x005e, B:29:0x006b, B:30:0x0072, B:32:0x0074, B:34:0x0087, B:35:0x008a, B:36:0x008f, B:38:0x0095, B:40:0x009b, B:42:0x00a9, B:43:0x00ac, B:45:0x00b2, B:46:0x00b5, B:47:0x00dd, B:49:0x00eb, B:50:0x00f2, B:52:0x00f4, B:54:0x0101, B:55:0x0108, B:57:0x010a, B:59:0x0116, B:60:0x0119, B:68:0x0166), top: B:73:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(int r7, java.util.List<com.bytedance.sdk.component.r.c.w> r8, long r9, java.lang.Object r11, int r12) {
        /*
            Method dump skipped, instructions count: 363
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.r.w.w.xv.sr.c(int, java.util.List, long, java.lang.Object, int):void");
    }

    public void c(int i4, long j4, Handler handler) {
        if (handler == null) {
            com.bytedance.sdk.component.r.w.xv.xv.sr("mHandler == null", this.f30154r);
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = i4;
        if (i4 == 2) {
            int incrementAndGet = this.ux.incrementAndGet();
            long j5 = (((incrementAndGet - 1) % 4) + 1) * j4;
            com.bytedance.sdk.component.r.w.xv.xv.c("sendMonitorMessage:" + i4 + "  busy:" + incrementAndGet + "  l:" + j5, this.f30154r);
            handler.sendMessageDelayed(obtain, j5);
        } else if (i4 == 3) {
            int incrementAndGet2 = this.f30153f.incrementAndGet();
            com.bytedance.sdk.component.r.w.xv.xv.c("sendMonitorMessage:" + i4 + "  error:" + incrementAndGet2, this.f30154r);
            handler.sendMessageDelayed(obtain, ((long) (((incrementAndGet2 + (-1)) % 4) + 1)) * j4);
        } else {
            com.bytedance.sdk.component.r.w.xv.xv.sr("sendMonitorMessage error state", this.f30154r);
        }
    }

    public void c() {
        this.ev.f30140w = false;
        this.sr = 0L;
        this.xv = 0L;
        this.ux.set(0);
        this.f30153f.set(0);
    }
}

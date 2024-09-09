package com.bytedance.sdk.gromore.init;

import android.content.Context;
import android.os.SystemClock;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bytedance.msdk.api.sr.c;
import com.bytedance.msdk.api.sr.ev;
import com.bytedance.msdk.api.sr.k;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f31274c;
    private static volatile boolean sr;

    /* renamed from: w  reason: collision with root package name */
    private static volatile boolean f31275w;
    private static volatile Result xv;
    private EventListener ux;

    /* JADX INFO: Access modifiers changed from: private */
    public void xv() {
        if (this.ux != null) {
            sr = true;
            f.ux = SystemClock.elapsedRealtime();
            com.bytedance.msdk.xv.r.c();
            com.bytedance.msdk.adapter.sr.xv.w("TMe", "sdk init call callback success");
            xv = com.bykv.c.c.c.c.a.a().e(true).f();
            this.ux.onEvent(0, xv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        synchronized (xv.class) {
            if (!f31275w) {
                f31275w = true;
                com.bytedance.msdk.adapter.sr.f.sr(new Runnable() { // from class: com.bytedance.sdk.gromore.init.xv.2
                    @Override // java.lang.Runnable
                    public void run() {
                        xv.this.xv();
                    }
                });
            } else {
                com.bytedance.msdk.adapter.sr.xv.w("TMe", "\u901a\u77e5\u6210\u529f\u6216\u5931\u8d25\u4e86\u4e0d\u5728\u901a\u77e5");
            }
        }
    }

    public void c(Context context, com.bytedance.sdk.gromore.c.w.c cVar, EventListener eventListener) {
        this.ux = eventListener;
        if (cVar != null) {
            com.bytedance.msdk.f.sr.ux.c(cVar);
            com.bytedance.msdk.adapter.sr.xv.w("TMe", "init csjm " + f31274c);
            if (!f31274c) {
                com.bytedance.msdk.adapter.sr.xv.w("TMe", "init csjm ");
                f31274c = true;
                f31275w = false;
                com.bytedance.msdk.core.bk.c.c().w();
                com.bytedance.msdk.core.bk.c.c().c(new com.bytedance.msdk.core.bk.w() { // from class: com.bytedance.sdk.gromore.init.xv.1
                    @Override // com.bytedance.msdk.core.bk.w
                    public void c() {
                        com.bytedance.msdk.core.bk.c.c().c((com.bytedance.msdk.core.bk.w) null);
                        xv.this.w();
                    }

                    @Override // com.bytedance.msdk.core.bk.w
                    public void c(int i4, String str) {
                        com.bytedance.msdk.core.bk.c.c().c((com.bytedance.msdk.core.bk.w) null);
                        xv.this.c(i4, str);
                    }
                });
                com.bytedance.msdk.api.sr.gd.c(context, c(cVar));
                com.bytedance.msdk.api.sr.gd.sr();
                return;
            }
            com.bytedance.msdk.adapter.sr.xv.w("TMe", "init csjm already");
            if (eventListener != null && xv != null) {
                eventListener.onEvent(0, xv);
                return;
            } else {
                com.bytedance.msdk.adapter.sr.xv.w("TMe", "sdk\u6b63\u5728\u521d\u59cb\u5316....");
                return;
            }
        }
        com.bytedance.msdk.adapter.sr.xv.w("TMe", "init csjm configValueSet is null");
    }

    private void w(int i4, String str) {
        if (i4 == 40004) {
            com.bytedance.msdk.adapter.sr.xv.w("TMe", "sdk init call code is 40004 callback success");
            xv();
        } else if (this.ux != null) {
            f.ux = SystemClock.elapsedRealtime();
            com.bytedance.msdk.xv.r.c();
            com.bytedance.msdk.adapter.sr.xv.w("TMe", "sdk init call callback fail");
            xv = com.bykv.c.c.c.c.a.a().e(false).b(i4).d(str).f();
            this.ux.onEvent(0, xv);
        }
    }

    public boolean c() {
        return sr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i4, String str) {
        synchronized (xv.class) {
            if (!f31275w) {
                f31275w = true;
                w(i4, str);
            } else {
                com.bytedance.msdk.adapter.sr.xv.w("TMe", "\u901a\u77e5\u6210\u529f\u6216\u5931\u8d25\u4e86\u4e0d\u5728\u901a\u77e5");
            }
        }
    }

    private com.bytedance.msdk.api.sr.c c(com.bytedance.sdk.gromore.c.w.c cVar) {
        return new c.C0403c().c(cVar.ux()).w(cVar.f()).c(cVar.sr()).xv(cVar.ys()).w(cVar.fp()).c(w.c(cVar.ia())).c(cVar.s()).xv(cVar.fz()).c(cVar.u()).sr(cVar.a()).c(new k.c().c(cVar.r()).w(cVar.ev()).c(cVar.gd()).c(cVar.p()).w(cVar.k()).c(cVar.bk()).xv(cVar.t()).c(w.c(cVar.s())).c()).c(new ev.c().c(cVar.q()).c(cVar.i()).w(cVar.j()).xv(cVar.ls()).c()).c(new r(cVar.gb())).c(cVar.w()).c();
    }
}

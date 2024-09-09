package com.bytedance.msdk.core.r.c;

import android.content.Context;
import android.os.Handler;
import com.bytedance.msdk.adapter.sr.ux;
import com.bytedance.msdk.core.k.w;
import com.bytedance.msdk.core.r.xv;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c extends com.bytedance.msdk.core.r.w.c {

    /* renamed from: c  reason: collision with root package name */
    private RunnableC0418c f28093c;

    /* renamed from: w  reason: collision with root package name */
    private boolean f28094w;

    /* renamed from: com.bytedance.msdk.core.r.c.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class RunnableC0418c implements Runnable {

        /* renamed from: w  reason: collision with root package name */
        private int f28096w;
        private boolean xv;

        public RunnableC0418c(int i4, boolean z3) {
            this.f28096w = i4;
            this.xv = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((xv) c.this).f28159r != null) {
                ((xv) c.this).f28159r.ux().put("serverBidding_timeout", Boolean.TRUE);
            }
            c.this.f28094w = true;
            com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", ux.c(((xv) c.this).gd) + "wfRequestAfExchange with LabelValueAuto !!!");
            c.super.w(this.f28096w, this.xv);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, String str, int i4) {
        super(context, str, i4);
        this.f28094w = false;
    }

    @Override // com.bytedance.msdk.core.r.xv
    public void j() {
        RunnableC0418c runnableC0418c;
        com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", ux.c(this.gd) + "cancel wfRequestAfExchange with LabelValueAuto !!!");
        Handler handler = this.f28157p;
        if (handler == null || (runnableC0418c = this.f28093c) == null) {
            return;
        }
        handler.removeCallbacks(runnableC0418c);
    }

    @Override // com.bytedance.msdk.core.r.xv
    public void ls() {
        w wVar;
        if (this.f28157p == null || this.f28093c == null || (wVar = this.f28159r) == null || wVar.f() != 4 || this.f28094w) {
            return;
        }
        this.f28157p.removeCallbacks(this.f28093c);
        this.f28157p.post(this.f28093c);
    }

    @Override // com.bytedance.msdk.core.r.f, com.bytedance.msdk.core.r.ux
    public void w(int i4, boolean z3) {
        w wVar;
        if (this.f28157p != null && (wVar = this.f28159r) != null && wVar.f() == 4) {
            w wVar2 = this.f28159r;
            if (wVar2 != null) {
                wVar2.ux().put("serverBidding_timeout", Boolean.FALSE);
            }
            this.f28094w = false;
            com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", ux.c(this.gd) + "wfRequestAfExchange with LabelValueAuto timeout:" + this.f28159r.r());
            RunnableC0418c runnableC0418c = new RunnableC0418c(i4, z3);
            this.f28093c = runnableC0418c;
            this.f28157p.postDelayed(runnableC0418c, (long) this.f28159r.r());
            return;
        }
        super.w(i4, z3);
    }
}

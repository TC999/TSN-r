package com.bytedance.msdk.core.admanager;

import android.content.Context;
import com.bytedance.msdk.core.gd.bk;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class sr extends com.bytedance.msdk.core.r.c.c {
    /* JADX INFO: Access modifiers changed from: protected */
    public sr(Context context, String str, int i4) {
        super(context, str, i4);
    }

    private com.bytedance.msdk.api.c a() {
        com.bytedance.msdk.api.c.w wVar;
        if (!this.oo || (wVar = this.f28155k) == null) {
            return null;
        }
        wVar.c(com.bytedance.msdk.core.r.r.xv());
        com.bytedance.msdk.api.w.c cVar = new com.bytedance.msdk.api.w.c(40047, com.bytedance.msdk.api.c.c(40047));
        com.bytedance.msdk.api.c.w wVar2 = this.f28155k;
        com.bytedance.msdk.core.k.w wVar3 = this.f28159r;
        com.bytedance.msdk.xv.r.c(wVar2, wVar3 != null ? wVar3.mt() : null, true, wx(), 40047, this.me);
        com.bytedance.msdk.api.c.w wVar4 = this.f28155k;
        com.bytedance.msdk.core.k.w wVar5 = this.f28159r;
        com.bytedance.msdk.xv.r.c(wVar4, cVar, wVar5 != null ? wVar5.mt() : null, wx());
        return cVar;
    }

    private com.bytedance.msdk.api.c p() {
        com.bytedance.msdk.api.c.w wVar;
        if (!this.au || (wVar = this.f28155k) == null) {
            return null;
        }
        wVar.c(com.bytedance.msdk.core.r.r.xv());
        com.bytedance.msdk.api.w.c cVar = new com.bytedance.msdk.api.w.c(40048, com.bytedance.msdk.api.c.c(40048));
        com.bytedance.msdk.api.c.w wVar2 = this.f28155k;
        com.bytedance.msdk.core.k.w wVar3 = this.f28159r;
        com.bytedance.msdk.xv.r.c(wVar2, wVar3 != null ? wVar3.mt() : null, true, wx(), 40048, this.me);
        com.bytedance.msdk.api.c.w wVar4 = this.f28155k;
        com.bytedance.msdk.core.k.w wVar5 = this.f28159r;
        com.bytedance.msdk.xv.r.c(wVar4, cVar, wVar5 != null ? wVar5.mt() : null, wx());
        return cVar;
    }

    public static int w(String str) {
        if (!bk.c().ev(str)) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--: \u547d\u4e2d\u5c55\u793a\u9891\u6b21");
            return 840041;
        } else if (bk.c().xv(str)) {
            return 0;
        } else {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--: \u547d\u4e2d\u5c55\u793a\u95f4\u9694");
            return 840042;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean k() {
        if (this.f28155k == null) {
            return true;
        }
        final com.bytedance.msdk.api.c p3 = p();
        if (p3 == null && (p3 = a()) == null) {
            return true;
        }
        com.bytedance.msdk.adapter.sr.f.xv(new Runnable() { // from class: com.bytedance.msdk.core.admanager.sr.1
            @Override // java.lang.Runnable
            public void run() {
                sr.this.c(p3);
            }
        });
        return false;
    }
}

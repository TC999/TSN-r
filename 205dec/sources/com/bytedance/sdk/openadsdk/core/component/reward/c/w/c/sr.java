package com.bytedance.sdk.openadsdk.core.component.reward.c.w.c;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.xv.p;
import com.bytedance.sdk.openadsdk.core.component.reward.xv.w;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ox;
import com.bytedance.sdk.openadsdk.core.u.yu;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr extends c {

    /* renamed from: w  reason: collision with root package name */
    c f32244w;

    public sr(Activity activity, me meVar) {
        super(activity, meVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.c.w.c.c, com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public w.c c(p pVar) {
        ArrayList<ox> ux = yu.ux(this.f32775f);
        if (ux == null) {
            return new w.c(false, 0, "");
        }
        Iterator<ox> it = ux.iterator();
        while (it.hasNext()) {
            ox next = it.next();
            if (next.xv() == 1) {
                this.f32244w = new xv(this.f32778r, this.f32775f, next);
            }
            c cVar = this.f32244w;
            if (cVar != null) {
                cVar.xv(this.f32776k);
                this.f32244w.sr(this.f32777p);
                this.f32244w.c(this.f32243c);
                this.f32244w.w(ux());
                this.f32244w.c(this.ys);
                w.c c4 = this.f32244w.c(pVar);
                if (c4.xv()) {
                    return c4;
                }
            }
        }
        return new w.c(false, 0, "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public void w(String str) {
        super.w(str);
        c cVar = this.f32244w;
        if (cVar == null) {
            return;
        }
        cVar.w(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public String c() {
        c cVar = this.f32244w;
        if (cVar == null) {
            return null;
        }
        return cVar.c();
    }
}

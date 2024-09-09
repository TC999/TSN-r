package com.bytedance.sdk.openadsdk.core.component.reward.xv;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.xv.w;
import com.bytedance.sdk.openadsdk.core.u.m;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ox;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class bk extends c {
    c fp;

    public bk(Activity activity, me meVar) {
        super(activity, meVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public String c() {
        c cVar = this.fp;
        if (cVar == null) {
            return null;
        }
        return cVar.c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.c, com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public w.c w(p pVar) {
        ArrayList<ox> u3 = m.u(this.f32775f);
        if (u3 == null) {
            return new w.c(false, 0, "");
        }
        Iterator<ox> it = u3.iterator();
        while (it.hasNext()) {
            ox next = it.next();
            switch (next.xv()) {
                case 1:
                    this.fp = new a(this.f32778r, this.f32775f, next);
                    break;
                case 2:
                    this.fp = new k(this.f32778r, this.f32775f, next);
                    break;
                case 3:
                    this.fp = new f(this.f32778r, this.f32775f, next);
                    break;
                case 4:
                    this.fp = new r(this.f32778r, this.f32775f, next);
                    break;
                case 5:
                    this.fp = new gd(this.f32778r, this.f32775f, next);
                    break;
                case 6:
                    this.fp = new sr(this.f32778r, this.f32775f, next);
                    break;
            }
            c cVar = this.fp;
            if (cVar != null) {
                cVar.c(this.xv);
                this.fp.c(this.f32765c);
                this.fp.w(this.f32766w);
                this.fp.w(this.sr);
                this.fp.xv(this.f32776k);
                this.fp.sr(this.f32777p);
                this.fp.xv(this.ux);
                this.fp.c(this.ys);
                this.fp.w(ux());
                w.c w3 = this.fp.w(pVar);
                if (w3.xv()) {
                    return w3;
                }
            }
        }
        return new w.c(false, 0, "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public void w(String str) {
        super.w(str);
        c cVar = this.fp;
        if (cVar == null) {
            return;
        }
        cVar.w(str);
    }
}

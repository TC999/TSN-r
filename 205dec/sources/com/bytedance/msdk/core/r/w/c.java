package com.bytedance.msdk.core.r.w;

import android.content.Context;
import com.bytedance.msdk.core.k.p;
import com.bytedance.msdk.core.r.f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c extends f {
    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, String str, int i4) {
        super(context, str, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.r.ux
    public boolean sr(final List<p> list) {
        if (this.wv) {
            ArrayList<Future> arrayList = new ArrayList();
            boolean z3 = false;
            for (final int i4 = 0; i4 < list.size(); i4++) {
                try {
                    Future c4 = com.bytedance.msdk.adapter.sr.f.c(new Callable<Boolean>() { // from class: com.bytedance.msdk.core.r.w.c.2
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.util.concurrent.Callable
                        public Boolean call() {
                            return Boolean.valueOf(c.this.c((p) list.get(i4), list.size()));
                        }
                    });
                    if (c4 != null) {
                        arrayList.add(c4);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            for (Future future : arrayList) {
                try {
                    Boolean bool = (Boolean) future.get(500L, TimeUnit.MILLISECONDS);
                    if (bool != null) {
                        z3 = bool.booleanValue();
                    }
                } catch (Throwable unused) {
                }
            }
            return z3;
        }
        return super.sr(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.r.ux
    public void xv(final List<p> list) {
        if (this.wv) {
            com.bytedance.msdk.adapter.sr.f.sr(new Runnable() { // from class: com.bytedance.msdk.core.r.w.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.super.xv(list);
                }
            });
        } else {
            super.xv(list);
        }
    }
}

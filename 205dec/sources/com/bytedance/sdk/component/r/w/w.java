package com.bytedance.sdk.component.r.w;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.r.c.f;
import com.bytedance.sdk.component.r.c.gd;
import com.bytedance.sdk.component.r.c.r;
import com.bytedance.sdk.component.r.c.sr;
import com.bytedance.sdk.component.r.c.ux;
import com.bytedance.sdk.component.utils.s;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements r {
    private static volatile com.bytedance.sdk.component.r.c.c.c sr;

    /* renamed from: c  reason: collision with root package name */
    private ux f30110c;

    /* renamed from: w  reason: collision with root package name */
    private Context f30111w;
    private gd xv;

    public w(com.bytedance.sdk.component.r.c.c cVar) {
        c(cVar);
    }

    public static com.bytedance.sdk.component.r.c.c.c ev() {
        if (sr == null) {
            synchronized (w.class) {
                if (sr == null) {
                    sr = new com.bytedance.sdk.component.r.w.ux.c();
                }
            }
        }
        return sr;
    }

    private boolean gd() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    @Override // com.bytedance.sdk.component.r.c.r
    public gd f() {
        return this.xv;
    }

    @Override // com.bytedance.sdk.component.r.c.r
    public sr r() {
        ux uxVar = this.f30110c;
        if (uxVar == null) {
            return null;
        }
        return uxVar.sr();
    }

    @Override // com.bytedance.sdk.component.r.c.r
    public void sr() {
        com.bytedance.sdk.component.r.w.f.c.c(this.f30110c).c();
    }

    @Override // com.bytedance.sdk.component.r.c.r
    public ux ux() {
        ux uxVar = this.f30110c;
        if (uxVar == null) {
            return null;
        }
        return uxVar;
    }

    @Override // com.bytedance.sdk.component.r.c.r
    public void xv() {
        com.bytedance.sdk.component.r.w.xv.xv.c("flushMemoryAndDB", this.f30110c);
        gd gdVar = this.xv;
        if (gdVar != null) {
            gdVar.xv();
        }
    }

    public void w(ux uxVar) {
        this.f30110c = uxVar;
        this.f30111w = uxVar.getContext();
        this.xv = new com.bytedance.sdk.component.r.w.w.w(this.f30110c);
    }

    public w() {
    }

    @Override // com.bytedance.sdk.component.r.c.r
    public void w() {
        final sr sr2;
        ux uxVar = this.f30110c;
        if (uxVar == null || (sr2 = uxVar.sr()) == null || this.f30110c.getContext() == null || sr2.ev() == null) {
            return;
        }
        if (this.f30110c.k()) {
            if (c(this.f30110c.getContext(), sr2)) {
                gd gdVar = this.xv;
                if (gdVar != null) {
                    gdVar.w();
                    return;
                }
                return;
            } else if (gd()) {
                sr2.ev().execute(new com.bytedance.sdk.component.r.w.ux.w("stop") { // from class: com.bytedance.sdk.component.r.w.w.2
                    @Override // java.lang.Runnable
                    public void run() {
                        w.this.w(sr2.p());
                    }
                });
                return;
            } else {
                w(sr2.p());
                return;
            }
        }
        gd gdVar2 = this.xv;
        if (gdVar2 != null) {
            gdVar2.w();
        }
    }

    public void c(ux uxVar) {
        w(uxVar);
    }

    @Override // com.bytedance.sdk.component.r.c.r
    public void c(f fVar) {
        ux uxVar = this.f30110c;
        if (uxVar != null) {
            if (fVar == null) {
                fVar = com.bytedance.sdk.component.r.w.c.c.c.w.f30055c;
            }
            uxVar.c(fVar);
        }
    }

    @Override // com.bytedance.sdk.component.r.c.r
    public void c(boolean z3) {
        ux uxVar = this.f30110c;
        if (uxVar != null) {
            uxVar.c(z3);
        }
    }

    private boolean c(Context context, sr srVar) {
        if (context == null || srVar == null) {
            return false;
        }
        if (srVar.p() == 1) {
            return srVar.t();
        }
        try {
            return s.c(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    @Override // com.bytedance.sdk.component.r.c.r
    public void c() {
        final sr sr2;
        com.bytedance.sdk.component.r.w.xv.xv.c("EventMultiUtils start", this.f30110c);
        ux uxVar = this.f30110c;
        if (uxVar == null || (sr2 = uxVar.sr()) == null || this.f30110c.getContext() == null || sr2.ev() == null) {
            return;
        }
        if (this.f30110c.k()) {
            if (c(this.f30110c.getContext(), sr2)) {
                gd gdVar = this.xv;
                if (gdVar != null) {
                    gdVar.c();
                    return;
                }
                return;
            } else if (gd()) {
                sr2.ev().execute(new com.bytedance.sdk.component.r.w.ux.w(CampaignEx.JSON_NATIVE_VIDEO_START) { // from class: com.bytedance.sdk.component.r.w.w.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.sdk.component.r.w.xv.xv.c("TTExecutor start", w.this.f30110c);
                        w.this.c(sr2.p());
                    }
                });
                return;
            } else {
                c(sr2.p());
                return;
            }
        }
        gd gdVar2 = this.xv;
        if (gdVar2 != null) {
            gdVar2.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i4) {
        if (i4 == 0 || i4 == 2) {
            com.bytedance.sdk.component.r.w.w.w.c.w(this.f30110c);
        } else if (i4 == 1) {
            com.bytedance.sdk.component.r.w.w.w.w.xv(this.f30110c);
        }
    }

    private void w(final com.bytedance.sdk.component.r.c.w wVar) {
        ux uxVar = this.f30110c;
        if (uxVar != null && this.xv != null) {
            final sr sr2 = uxVar.sr();
            if (wVar == null || sr2 == null || this.f30110c.getContext() == null || sr2.ev() == null) {
                return;
            }
            if (this.f30110c.k()) {
                boolean c4 = c(this.f30110c.getContext(), sr2);
                com.bytedance.sdk.component.r.w.xv.xv.c("dispatchEvent mainProcess:" + c4, this.f30110c);
                if (c4) {
                    this.xv.c(wVar);
                    return;
                }
                com.bytedance.sdk.component.r.w.xv.xv.c("sub thread dispatch:" + gd(), this.f30110c);
                if (gd()) {
                    sr2.ev().execute(new com.bytedance.sdk.component.r.w.ux.w("dispatchEvent") { // from class: com.bytedance.sdk.component.r.w.w.3
                        @Override // java.lang.Runnable
                        public void run() {
                            w.this.c(wVar, sr2.p());
                        }
                    });
                    return;
                } else {
                    c(wVar, sr2.p());
                    return;
                }
            }
            this.xv.c(wVar);
            return;
        }
        Log.e("log_error", "dispatch event configManager is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i4) {
        if (i4 == 0 || i4 == 2) {
            com.bytedance.sdk.component.r.w.w.w.c.c(this.f30110c);
        } else if (i4 == 1) {
            com.bytedance.sdk.component.r.w.w.w.w.w(this.f30110c);
        }
    }

    @Override // com.bytedance.sdk.component.r.c.r
    public void c(com.bytedance.sdk.component.r.c.w wVar) {
        w(wVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.component.r.c.w wVar, int i4) {
        if (i4 == 0 || i4 == 2) {
            com.bytedance.sdk.component.r.w.w.w.c.c(wVar, this.f30110c);
        } else if (i4 == 1) {
            com.bytedance.sdk.component.r.w.w.w.w.c(wVar, this.f30110c);
        }
    }

    @Override // com.bytedance.sdk.component.r.c.r
    public void c(final String str, final List<String> list, final boolean z3, Map<String, String> map) {
        ux uxVar = this.f30110c;
        if (uxVar == null) {
            Log.e("log_error", "track configManager is null");
            return;
        }
        final sr sr2 = uxVar.sr();
        if (sr2 == null || this.f30110c.getContext() == null || sr2.ev() == null || !sr2.f()) {
            return;
        }
        if (sr2.p() == 1) {
            if (list == null || list.isEmpty()) {
                return;
            }
        } else if (sr2.p() == 0 && (TextUtils.isEmpty(str) || list == null || list.isEmpty())) {
            return;
        }
        if (this.f30110c.k() && !c(this.f30110c.getContext(), sr2)) {
            if (gd()) {
                sr2.ev().execute(new com.bytedance.sdk.component.r.w.ux.w("trackFailed") { // from class: com.bytedance.sdk.component.r.w.w.4
                    @Override // java.lang.Runnable
                    public void run() {
                        w.this.c(str, list, z3, sr2.p());
                    }
                });
                return;
            } else {
                c(str, list, z3, sr2.p());
                return;
            }
        }
        com.bytedance.sdk.component.r.w.f.c.c(this.f30110c).c(str, list, z3, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, List<String> list, boolean z3, int i4) {
        if (i4 == 0) {
            com.bytedance.sdk.component.r.w.w.w.c.c(str, list, z3, this.f30110c);
        } else if (i4 == 1) {
            com.bytedance.sdk.component.r.w.w.w.w.c(str, list, z3, this.f30110c);
        }
    }

    @Override // com.bytedance.sdk.component.r.c.r
    public void c(final String str) {
        ux uxVar = this.f30110c;
        if (uxVar == null) {
            com.bytedance.sdk.component.r.w.xv.xv.sr("log_error", "trackFailedUrls configManager is null", uxVar);
            return;
        }
        final sr sr2 = uxVar.sr();
        if (sr2 == null || this.f30110c.getContext() == null || sr2.ev() == null || !sr2.f()) {
            return;
        }
        if (sr2.p() == 0 && TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f30110c.k() && !c(this.f30110c.getContext(), sr2)) {
            if (gd()) {
                sr2.ev().execute(new com.bytedance.sdk.component.r.w.ux.w("trackFailed") { // from class: com.bytedance.sdk.component.r.w.w.5
                    @Override // java.lang.Runnable
                    public void run() {
                        w.this.c(str, sr2.p());
                    }
                });
                return;
            } else {
                c(str, sr2.p());
                return;
            }
        }
        com.bytedance.sdk.component.r.w.f.c.c(this.f30110c).c(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, int i4) {
        if (i4 == 0) {
            com.bytedance.sdk.component.r.w.w.w.c.c(str, this.f30110c);
        } else if (i4 == 1) {
            com.bytedance.sdk.component.r.w.w.w.w.c(str, this.f30110c);
        }
    }
}

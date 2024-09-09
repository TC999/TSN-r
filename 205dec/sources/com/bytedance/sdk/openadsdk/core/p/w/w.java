package com.bytedance.sdk.openadsdk.core.p.w;

import android.os.Looper;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.openadsdk.core.q;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends p {

    /* renamed from: c  reason: collision with root package name */
    private String f34262c;

    /* renamed from: f  reason: collision with root package name */
    private String f34263f;
    private long sr;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.p.w.c f34264w;
    private long xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class c {

        /* renamed from: c  reason: collision with root package name */
        private String f34265c;

        /* renamed from: f  reason: collision with root package name */
        private com.bytedance.sdk.openadsdk.core.p.w.c f34266f;
        private String sr;
        private String ux;

        /* renamed from: w  reason: collision with root package name */
        private long f34267w;
        private long xv;

        public c c(String str) {
            this.f34265c = str;
            return this;
        }

        public c w(long j4) {
            this.xv = j4;
            return this;
        }

        public c xv(String str) {
            this.ux = str;
            return this;
        }

        public c c(com.bytedance.sdk.openadsdk.core.p.w.c cVar) {
            this.f34266f = cVar;
            return this;
        }

        public c w(String str) {
            this.sr = str;
            return this;
        }

        public c c(long j4) {
            this.f34267w = j4;
            return this;
        }

        public void c() {
            w wVar = new w("tt_csj_download_thread");
            wVar.f34263f = this.ux;
            wVar.ux = this.sr;
            wVar.sr = this.xv;
            wVar.xv = this.f34267w;
            wVar.f34262c = this.f34265c;
            wVar.f34264w = this.f34266f;
            w.w(wVar);
        }
    }

    public w(String str) {
        super(str);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f34264w == null) {
            return;
        }
        String str = this.f34262c;
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -1013269933:
                if (str.equals("onIdle")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1739685:
                if (str.equals("onInstalled")) {
                    c4 = 1;
                    break;
                }
                break;
            case 899044717:
                if (str.equals("onDownloadActive")) {
                    c4 = 2;
                    break;
                }
                break;
            case 1040018084:
                if (str.equals("onDownloadFailed")) {
                    c4 = 3;
                    break;
                }
                break;
            case 1326673813:
                if (str.equals("onDownloadPaused")) {
                    c4 = 4;
                    break;
                }
                break;
            case 1675860249:
                if (str.equals("onDownloadFinished")) {
                    c4 = 5;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                this.f34264w.c();
                return;
            case 1:
                this.f34264w.c(this.ux, this.f34263f);
                return;
            case 2:
                this.f34264w.c(this.xv, this.sr, this.ux, this.f34263f);
                return;
            case 3:
                this.f34264w.xv(this.xv, this.sr, this.ux, this.f34263f);
                return;
            case 4:
                this.f34264w.w(this.xv, this.sr, this.ux, this.f34263f);
                return;
            case 5:
                this.f34264w.c(this.xv, this.ux, this.f34263f);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            q.f().post(runnable);
        } else {
            runnable.run();
        }
    }
}

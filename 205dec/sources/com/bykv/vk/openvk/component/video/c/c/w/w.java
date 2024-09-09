package com.bykv.vk.openvk.component.video.c.c.w;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.component.video.api.ux.c;
import com.bykv.vk.openvk.component.video.api.xv.sr;
import com.bytedance.sdk.component.w.c.a;
import com.bytedance.sdk.component.w.c.t;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private Context f24984c;
    private File sr;
    private File ux;

    /* renamed from: w  reason: collision with root package name */
    private sr f24987w;
    private volatile boolean xv = false;

    /* renamed from: f  reason: collision with root package name */
    private final List<c.InterfaceC0336c> f24985f = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    private volatile boolean f24986r = false;

    public w(Context context, sr srVar) {
        this.sr = null;
        this.ux = null;
        this.f24984c = context;
        this.f24987w = srVar;
        this.sr = com.bykv.vk.openvk.component.video.c.ux.xv.w(srVar.ux(), srVar.ia());
        this.ux = com.bykv.vk.openvk.component.video.c.ux.xv.xv(srVar.ux(), srVar.ia());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sr() {
        try {
            this.ux.delete();
            this.sr.delete();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ux() {
        try {
            if (this.sr.renameTo(this.ux)) {
                return;
            }
            throw new IOException("Error renaming file " + this.sr + " to " + this.ux + " for completion!");
        } finally {
        }
    }

    private void xv() {
        a.c cVar;
        if (com.bykv.vk.openvk.component.video.api.xv.xv() != null) {
            cVar = com.bykv.vk.openvk.component.video.api.xv.xv().w();
        } else {
            cVar = new a.c("v_preload");
        }
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        cVar.c(this.f24987w.fz(), timeUnit).w(this.f24987w.u(), timeUnit).xv(this.f24987w.i(), timeUnit);
        a c4 = cVar.c();
        t.c cVar2 = new t.c();
        final long length = this.sr.length();
        int f4 = this.f24987w.f();
        boolean bk = this.f24987w.bk();
        int w3 = this.f24987w.w();
        if (w3 > 0) {
            if (w3 >= this.f24987w.a()) {
                bk = true;
            } else {
                f4 = w3;
            }
        }
        if (bk) {
            cVar2.c("RANGE", "bytes=" + length + "-").c(this.f24987w.fp()).c().w();
        } else {
            cVar2.c("RANGE", "bytes=" + length + "-" + f4).c(this.f24987w.fp()).c().w();
        }
        c4.c(cVar2.w()).c(new com.bytedance.sdk.component.w.c.xv() { // from class: com.bykv.vk.openvk.component.video.c.c.w.w.1
            @Override // com.bytedance.sdk.component.w.c.xv
            public void onFailure(com.bytedance.sdk.component.w.c.w wVar, IOException iOException) {
                w wVar2 = w.this;
                wVar2.c(wVar2.f24987w, (int) MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, iOException.getMessage());
                xv.c(w.this.f24987w);
            }

            /* JADX WARN: Removed duplicated region for block: B:110:0x0197 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:47:0x017f A[Catch: all -> 0x01ca, TryCatch #6 {all -> 0x01ca, blocks: (B:31:0x0105, B:32:0x010a, B:34:0x0113, B:36:0x011b, B:39:0x016b, B:41:0x0171, B:47:0x017f, B:49:0x019c, B:51:0x01a8, B:53:0x01b6, B:54:0x01bb), top: B:100:0x0105 }] */
            /* JADX WARN: Removed duplicated region for block: B:80:0x024e A[Catch: all -> 0x0298, TryCatch #4 {all -> 0x0298, blocks: (B:78:0x023e, B:80:0x024e, B:81:0x0252), top: B:96:0x023e }] */
            @Override // com.bytedance.sdk.component.w.c.xv
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onResponse(com.bytedance.sdk.component.w.c.w r23, com.bytedance.sdk.component.w.c.fp r24) throws java.io.IOException {
                /*
                    Method dump skipped, instructions count: 738
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.c.c.w.w.AnonymousClass1.onResponse(com.bytedance.sdk.component.w.c.w, com.bytedance.sdk.component.w.c.fp):void");
            }
        });
    }

    private boolean w() {
        if (this.ux.exists()) {
            return true;
        }
        if (this.f24987w.bk()) {
            return false;
        }
        if (this.sr.length() >= this.f24987w.f()) {
            return true;
        }
        return this.f24987w.w() > 0 && this.sr.length() >= ((long) this.f24987w.w());
    }

    public void c(c.InterfaceC0336c interfaceC0336c) {
        if (this.f24986r) {
            synchronized (c.InterfaceC0336c.class) {
                this.f24985f.add(interfaceC0336c);
            }
            return;
        }
        this.f24985f.add(interfaceC0336c);
        if (w()) {
            com.bykv.vk.openvk.component.video.api.f.xv.w("VideoPreload", "Cache file is exist");
            this.f24987w.gd(1);
            c(this.f24987w, 200);
            xv.c(this.f24987w);
            return;
        }
        this.f24986r = true;
        this.f24987w.gd(0);
        xv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(sr srVar, int i4) {
        synchronized (c.InterfaceC0336c.class) {
            for (c.InterfaceC0336c interfaceC0336c : this.f24985f) {
                if (interfaceC0336c != null) {
                    interfaceC0336c.w(srVar, i4);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public sr c() {
        return this.f24987w;
    }

    public void c(boolean z3) {
        this.xv = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(sr srVar, int i4) {
        synchronized (c.InterfaceC0336c.class) {
            for (c.InterfaceC0336c interfaceC0336c : this.f24985f) {
                if (interfaceC0336c != null) {
                    interfaceC0336c.c(srVar, i4);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(sr srVar, int i4, String str) {
        synchronized (c.InterfaceC0336c.class) {
            for (c.InterfaceC0336c interfaceC0336c : this.f24985f) {
                if (interfaceC0336c != null) {
                    interfaceC0336c.c(srVar, i4, str);
                }
            }
        }
    }
}

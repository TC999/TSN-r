package com.bykv.vk.openvk.component.video.c.sr;

import com.bykv.vk.openvk.component.video.c.sr.xv;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c implements xv {

    /* renamed from: c  reason: collision with root package name */
    protected boolean f24991c = false;
    private xv.sr ev;

    /* renamed from: f  reason: collision with root package name */
    private xv.r f24992f;

    /* renamed from: r  reason: collision with root package name */
    private xv.InterfaceC0337xv f24993r;
    private xv.c sr;
    private xv.f ux;

    /* renamed from: w  reason: collision with root package name */
    private xv.ux f24994w;
    private xv.w xv;

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv
    public final void c(xv.ux uxVar) {
        this.f24994w = uxVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void sr() {
        try {
            xv.f fVar = this.ux;
            if (fVar != null) {
                fVar.xv(this);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.xv.xv("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnSeekComplete error: ", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void w() {
        try {
            xv.ux uxVar = this.f24994w;
            if (uxVar != null) {
                uxVar.w(this);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.xv.xv("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnPrepared error: ", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void xv() {
        try {
            xv.w wVar = this.xv;
            if (wVar != null) {
                wVar.c(this);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.xv.xv("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnCompletion error: ", th);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv
    public final void c(xv.w wVar) {
        this.xv = wVar;
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv
    public final void c(xv.c cVar) {
        this.sr = cVar;
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv
    public final void c(xv.f fVar) {
        this.ux = fVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean w(int i4, int i5) {
        try {
            xv.sr srVar = this.ev;
            if (srVar != null) {
                return srVar.w(this, i4, i5);
            }
            return false;
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.xv.xv("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", th);
            return false;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv
    public final void c(xv.InterfaceC0337xv interfaceC0337xv) {
        this.f24993r = interfaceC0337xv;
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv
    public final void c(xv.sr srVar) {
        this.ev = srVar;
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv
    public final void c(xv.r rVar) {
        this.f24992f = rVar;
    }

    public void c() {
        this.f24994w = null;
        this.sr = null;
        this.xv = null;
        this.ux = null;
        this.f24992f = null;
        this.f24993r = null;
        this.ev = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(int i4) {
        try {
            xv.c cVar = this.sr;
            if (cVar != null) {
                cVar.c(this, i4);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.xv.xv("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnBufferingUpdate error: ", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(int i4, int i5, int i6, int i7) {
        try {
            xv.r rVar = this.f24992f;
            if (rVar != null) {
                rVar.c(this, i4, i5, i6, i7);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.xv.xv("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnVideoSizeChanged error: ", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean c(int i4, int i5) {
        try {
            xv.InterfaceC0337xv interfaceC0337xv = this.f24993r;
            if (interfaceC0337xv != null) {
                return interfaceC0337xv.c(this, i4, i5);
            }
            return false;
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.xv.xv("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", th);
            return false;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv
    public void c(boolean z3) {
        this.f24991c = z3;
    }
}

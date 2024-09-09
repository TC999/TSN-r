package com.bytedance.sdk.component.k.w;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.component.ttvideo.SeekCompletionListener;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback;
import com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader;
import com.bykv.vk.component.ttvideo.player.TTPlayerClient;
import com.bykv.vk.component.ttvideo.playerwrapper.MediaPlayerWrapper;
import com.bykv.vk.component.ttvideo.utils.Error;
import com.bykv.vk.openvk.component.video.api.c;
import com.bykv.vk.openvk.component.video.api.xv;
import com.bykv.vk.openvk.component.video.api.xv.sr;
import com.bytedance.sdk.component.utils.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements com.bykv.vk.openvk.component.video.api.c, n.c {

    /* renamed from: w  reason: collision with root package name */
    public static volatile boolean f29916w;

    /* renamed from: a  reason: collision with root package name */
    private long f29917a;
    private boolean ba;
    private int fz;

    /* renamed from: i  reason: collision with root package name */
    private SurfaceTexture f29920i;
    private n ls;

    /* renamed from: q  reason: collision with root package name */
    private SurfaceHolder f29925q;

    /* renamed from: u  reason: collision with root package name */
    private int f29929u;
    private TTVideoEngine xv;
    private volatile boolean sr = false;
    private boolean ux = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f29919f = false;

    /* renamed from: r  reason: collision with root package name */
    private boolean f29926r = false;
    private boolean ev = false;
    private boolean gd = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f29924p = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f29922k = false;
    private long bk = 0;

    /* renamed from: t  reason: collision with root package name */
    private long f29928t = 0;
    private long ys = 0;
    private int fp = 0;
    private int ia = 0;

    /* renamed from: s  reason: collision with root package name */
    private boolean f29927s = false;

    /* renamed from: j  reason: collision with root package name */
    private final List<WeakReference<c.InterfaceC0334c>> f29921j = Collections.synchronizedList(new ArrayList());
    private volatile int gb = 200;

    /* renamed from: n  reason: collision with root package name */
    private long f29923n = 0;
    private Runnable ck = new Runnable() { // from class: com.bytedance.sdk.component.k.w.w.1
        @Override // java.lang.Runnable
        public void run() {
            long fz = w.this.fz();
            if (w.this.s() > 0) {
                if (w.this.f29923n != fz) {
                    if (xv.sr()) {
                        com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "run: lastCur = ", Long.valueOf(w.this.f29923n), "  curPosition=", Long.valueOf(fz));
                    }
                    w wVar = w.this;
                    wVar.c(fz, wVar.s());
                }
                w.this.f29923n = fz;
            }
            if (!w.this.ev) {
                if (w.this.ls != null) {
                    w.this.ls.postDelayed(this, w.this.gb);
                    return;
                }
                return;
            }
            w wVar2 = w.this;
            wVar2.c(wVar2.s(), w.this.s());
        }
    };

    /* renamed from: c  reason: collision with root package name */
    CountDownLatch f29918c = new CountDownLatch(1);

    /* renamed from: z  reason: collision with root package name */
    private final ArrayList<Runnable> f29930z = new ArrayList<>();

    public w(Context context, String str) {
        c(context, "vd_" + str);
    }

    private void gb() {
        this.xv.setVideoEngineSimpleCallback(new VideoEngineSimpleCallback() { // from class: com.bytedance.sdk.component.k.w.w.8
            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onBufferEnd(int i4) {
                if (w.this.fp == i4) {
                    w.this.f29928t += System.currentTimeMillis() - w.this.ys;
                }
                com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "onBufferEnd: code =", Integer.valueOf(i4));
                for (WeakReference weakReference : w.this.f29921j) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((c.InterfaceC0334c) weakReference.get()).c((com.bykv.vk.openvk.component.video.api.c) w.this, i4);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onBufferStart(int i4, int i5, int i6) {
                w.this.fp = i4;
                w.this.ia++;
                w.this.ys = System.currentTimeMillis();
                com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "onBufferStart: reason =", Integer.valueOf(i4), "  afterFirstFrame =", Integer.valueOf(i5), "  action=", Integer.valueOf(i6));
                for (WeakReference weakReference : w.this.f29921j) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((c.InterfaceC0334c) weakReference.get()).c(w.this, i4, i5, i6);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onBufferingUpdate(TTVideoEngine tTVideoEngine, int i4) {
                com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "onBufferingUpdate: percent =", Integer.valueOf(i4));
                for (WeakReference weakReference : w.this.f29921j) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((c.InterfaceC0334c) weakReference.get()).w(w.this, i4);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onCompletion(TTVideoEngine tTVideoEngine) {
                com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "onCompletion: ");
                w.this.ev = true;
                if (w.this.ls != null) {
                    w.this.ls.removeCallbacks(w.this.ck);
                }
                for (WeakReference weakReference : w.this.f29921j) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((c.InterfaceC0334c) weakReference.get()).c(w.this);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onError(Error error) {
                com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "onError: ");
                com.bykv.vk.openvk.component.video.api.xv.w wVar = new com.bykv.vk.openvk.component.video.api.xv.w(error.getCode(), error.getInternalCode());
                for (WeakReference weakReference : w.this.f29921j) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((c.InterfaceC0334c) weakReference.get()).c(w.this, wVar);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onLoadStateChanged(TTVideoEngine tTVideoEngine, int i4) {
                com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "onLoadStateChanged: loadState =", Integer.valueOf(i4));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onMDLHitCache(String str, long j4) {
                com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "onMDLHitCache: MDLPlayTaskKey =", str, " hitCacheSize = ", Long.valueOf(j4));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onPlaybackStateChanged(TTVideoEngine tTVideoEngine, int i4) {
                com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "onPlaybackStateChanged: playbackState =", Integer.valueOf(i4));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onPrepare(TTVideoEngine tTVideoEngine) {
                com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "onPrepare: ");
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onPrepared(TTVideoEngine tTVideoEngine) {
                com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "onPrepared: ");
                w.this.gd = true;
                for (WeakReference weakReference : w.this.f29921j) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((c.InterfaceC0334c) weakReference.get()).w(w.this);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onRenderSeekComplete(int i4) {
                com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "onRenderSeekComplete: isSeekInCached = ", Integer.valueOf(i4));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onRenderStart(TTVideoEngine tTVideoEngine) {
                com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "onRenderStart: ");
                w.this.bk = System.currentTimeMillis() - w.this.f29917a;
                for (WeakReference weakReference : w.this.f29921j) {
                    if (weakReference != null && weakReference.get() != null) {
                        w wVar = w.this;
                        ((c.InterfaceC0334c) weakReference.get()).c(wVar, wVar.bk);
                    }
                }
                w.this.f29927s = true;
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onRetry(int i4) {
                com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "onRetry: playType = ", Integer.valueOf(i4));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onUseMDLCacheEnd() {
                com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "onUseMDLCacheEnd: ");
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onVideoSizeChanged(TTVideoEngine tTVideoEngine, int i4, int i5) {
                com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "onVideoSizeChanged: width = ", Integer.valueOf(i4), " height = ", Integer.valueOf(i5));
                w.this.fz = i4;
                w.this.f29929u = i5;
                for (WeakReference weakReference : w.this.f29921j) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((c.InterfaceC0334c) weakReference.get()).c((com.bykv.vk.openvk.component.video.api.c) w.this, i4, i5);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.f29924p = true;
        this.f29919f = true;
        n nVar = this.ls;
        if (nVar != null) {
            nVar.sendEmptyMessage(100);
        }
    }

    private void j() {
        ArrayList<Runnable> arrayList = this.f29930z;
        boolean z3 = arrayList == null || arrayList.isEmpty();
        com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_TTVideo", "isPendingAction:" + z3);
        if (z3) {
            return;
        }
        q();
    }

    private void ls() {
        ArrayList<Runnable> arrayList = this.f29930z;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.f29930z.clear();
    }

    private void n() {
        this.ux = false;
        this.f29919f = false;
        this.ev = false;
        this.gd = false;
        this.f29924p = false;
    }

    private void q() {
        if (this.ba) {
            return;
        }
        this.ba = true;
        Iterator it = new ArrayList(this.f29930z).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f29930z.clear();
        this.ba = false;
    }

    public static boolean u() {
        return f29916w;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void c(float f4) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void c(int i4) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public long fp() {
        if (this.ia == 0) {
            return 0L;
        }
        if (this.f29928t == 0 && this.ys != 0) {
            this.f29928t = System.currentTimeMillis() - this.ys;
        }
        return this.f29928t;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public long fz() {
        try {
            return this.xv.getCurrentPlaybackTime();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.xv.xv(th.getMessage());
            return 0L;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public int ia() {
        return this.ia;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public long s() {
        return this.xv.getDuration();
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public boolean ys() {
        return this.f29926r;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public int a() {
        com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "getVideoHeight: ");
        return this.f29929u;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public boolean bk() {
        return this.xv.getPlaybackState() == 1;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public SurfaceTexture ev() {
        return this.f29920i;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public boolean f() {
        return this.f29927s;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public boolean gd() {
        return this.ev;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public int k() {
        com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "getVideoWidth: ");
        return this.fz;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public boolean p() {
        return this.f29924p;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public SurfaceHolder r() {
        return this.f29925q;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public boolean t() {
        return this.xv.getPlaybackState() == 2;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void ux() {
        ls();
        n nVar = this.ls;
        if (nVar != null) {
            nVar.removeCallbacksAndMessages(null);
            nVar.sendEmptyMessage(103);
            if (nVar.getLooper() != null) {
                nVar.post(new Runnable() { // from class: com.bytedance.sdk.component.k.w.w.7
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            com.bytedance.sdk.component.gd.w.c.c().c(w.this.ls);
                            w.this.ls = null;
                        } catch (Throwable th) {
                            com.bykv.vk.openvk.component.video.api.f.xv.sr("CSJ_VIDEO_TTVideo", "release error:" + th.getMessage());
                        }
                    }
                });
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void sr() {
        com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "stop: ");
        n nVar = this.ls;
        if (nVar != null) {
            nVar.sendEmptyMessage(105);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void w() {
        com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "play: ");
        n nVar = this.ls;
        if (nVar != null) {
            nVar.postDelayed(this.ck, this.gb);
            nVar.post(new Runnable() { // from class: com.bytedance.sdk.component.k.w.w.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (w.this.xv != null) {
                            w.this.xv.play();
                            for (WeakReference weakReference : w.this.f29921j) {
                                if (weakReference != null && weakReference.get() != null) {
                                    ((c.InterfaceC0334c) weakReference.get()).ux(w.this);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "play: catch exception:" + th.getMessage());
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void xv() {
        com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "pause: ");
        n nVar = this.ls;
        if (nVar != null) {
            nVar.removeMessages(100);
            nVar.sendEmptyMessage(101);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j4, long j5) {
        for (WeakReference<c.InterfaceC0334c> weakReference : this.f29921j) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().c(this, j4, j5);
            }
        }
    }

    private void w(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!this.f29926r) {
            runnable.run();
        } else {
            c(runnable);
        }
    }

    private void c(Context context, String str) {
        this.xv = c.c(context);
        if (this.ls == null) {
            com.bytedance.sdk.component.gd.w.c c4 = com.bytedance.sdk.component.gd.w.c.c();
            this.ls = c4.c(this, "csj_" + str);
        }
        gb();
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void w(boolean z3) {
        this.f29922k = z3;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void w(int i4) {
        this.gb = i4;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void c(final SurfaceHolder surfaceHolder) {
        com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "setDisplay:  SurfaceView");
        w(true);
        this.f29925q = surfaceHolder;
        w(new Runnable() { // from class: com.bytedance.sdk.component.k.w.w.2
            @Override // java.lang.Runnable
            public void run() {
                if (w.this.ls != null) {
                    w.this.ls.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void c(final SurfaceTexture surfaceTexture) {
        w(true);
        this.f29920i = surfaceTexture;
        w(new Runnable() { // from class: com.bytedance.sdk.component.k.w.w.3
            @Override // java.lang.Runnable
            public void run() {
                if (w.this.ls != null) {
                    w.this.ls.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void c(sr srVar) {
        this.xv.setDirectUrlUseDataLoader(srVar.fp(), srVar.ia(), (String) null, srVar.ux());
        this.ux = true;
        this.ia = 0;
        com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "TTVideoPlayer setDirectUrlUseDataLoader:  url =", srVar.fp(), " isH265=", Boolean.valueOf(srVar.t()), " presize=", Integer.valueOf(srVar.f()), " path=", srVar.ux(), " fileName =", srVar.ia());
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void c() {
        TTVideoEngine tTVideoEngine = this.xv;
        boolean isMute = tTVideoEngine != null ? tTVideoEngine.isMute() : false;
        this.ia = 0;
        this.f29928t = 0L;
        this.ys = 0L;
        this.ev = false;
        c(true, 0L, isMute);
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void c(boolean z3, long j4, boolean z4) {
        com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "start: firstSeek:" + j4 + " first:" + z3 + " quiet:" + z4);
        n nVar = this.ls;
        if (nVar != null) {
            nVar.postDelayed(this.ck, this.gb);
        }
        this.f29917a = System.currentTimeMillis();
        this.xv.setStartTime((int) j4);
        this.xv.setIsMute(z4);
        if (this.sr && this.ux) {
            i();
        } else {
            com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "seekTo: ", "Can not exec play, please exec setDataSource && setSurface before seek");
            c(new Runnable() { // from class: com.bytedance.sdk.component.k.w.w.4
                @Override // java.lang.Runnable
                public void run() {
                    w.this.i();
                }
            });
        }
        com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "start:end");
        this.f29918c.countDown();
    }

    private synchronized void c(Runnable runnable) {
        this.f29930z.add(runnable);
    }

    @Override // com.bytedance.sdk.component.utils.n.c
    public void c(Message message) {
        int i4 = message.what;
        try {
            if (i4 == 105) {
                TTVideoEngine tTVideoEngine = this.xv;
                if (tTVideoEngine != null) {
                    tTVideoEngine.stop();
                }
            } else if (i4 == 110) {
                TTVideoEngine tTVideoEngine2 = this.xv;
                if (tTVideoEngine2 != null) {
                    tTVideoEngine2.setSurfaceHolder((SurfaceHolder) message.obj);
                    this.sr = true;
                    this.f29918c.await(1L, TimeUnit.SECONDS);
                    j();
                }
            } else if (i4 != 111) {
                switch (i4) {
                    case 100:
                        TTVideoEngine tTVideoEngine3 = this.xv;
                        if (tTVideoEngine3 != null) {
                            tTVideoEngine3.play();
                            return;
                        }
                        return;
                    case 101:
                        TTVideoEngine tTVideoEngine4 = this.xv;
                        if (tTVideoEngine4 != null && this.ls != null) {
                            tTVideoEngine4.pause();
                            for (WeakReference<c.InterfaceC0334c> weakReference : this.f29921j) {
                                if (weakReference != null && weakReference.get() != null) {
                                    weakReference.get().sr(this);
                                }
                            }
                            this.ls.removeCallbacks(this.ck);
                            return;
                        }
                        return;
                    case 102:
                        n();
                        return;
                    case 103:
                        TTVideoEngine tTVideoEngine5 = this.xv;
                        if (tTVideoEngine5 != null) {
                            tTVideoEngine5.release();
                        }
                        this.f29926r = true;
                        for (WeakReference<c.InterfaceC0334c> weakReference2 : this.f29921j) {
                            if (weakReference2 != null && weakReference2.get() != null) {
                                weakReference2.get().xv(this);
                            }
                        }
                        return;
                    default:
                        return;
                }
            } else if (this.xv != null) {
                com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "setSurface: TextureView ");
                this.xv.setSurface(new Surface((SurfaceTexture) message.obj));
                this.sr = true;
                this.f29918c.await(1L, TimeUnit.SECONDS);
                j();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void c(long j4) {
        com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "seekTo: ");
        if (this.f29919f) {
            this.xv.seekTo((int) j4, new SeekCompletionListener() { // from class: com.bytedance.sdk.component.k.w.w.6
                @Override // com.bykv.vk.component.ttvideo.SeekCompletionListener
                public void onCompletion(boolean z3) {
                    for (WeakReference weakReference : w.this.f29921j) {
                        if (weakReference != null && weakReference.get() != null) {
                            ((c.InterfaceC0334c) weakReference.get()).c(w.this, z3);
                        }
                    }
                    com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "seekTo: ", " isSuccess =", Boolean.valueOf(z3));
                }
            });
        } else {
            com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "seekTo: ", "Can not exec seek, please exec setDataSource before seek");
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void c(c.InterfaceC0334c interfaceC0334c) {
        if (interfaceC0334c == null) {
            return;
        }
        for (WeakReference<c.InterfaceC0334c> weakReference : this.f29921j) {
            if (weakReference != null && weakReference.get() == interfaceC0334c) {
                return;
            }
        }
        this.f29921j.add(new WeakReference<>(interfaceC0334c));
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void c(boolean z3) {
        com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_TTVideo", "setIsMute: ");
        this.xv.setIsMute(z3);
    }

    public static void c(Context context, String str, int i4, String[] strArr, long[] jArr, boolean z3, VideoEventEngineUploader videoEventEngineUploader) {
        boolean z4;
        try {
            TTPlayerClient.create(new MediaPlayerWrapper(), xv.getContext()).release();
            c.c(context, str, i4, strArr, jArr, videoEventEngineUploader);
            c.c(z3);
            z4 = true;
        } catch (Throwable unused) {
            z4 = false;
        }
        f29916w = z4;
    }
}

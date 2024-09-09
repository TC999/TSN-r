package com.bytedance.sdk.component.k.c;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.component.ttvideo.ILiveListener;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.ILiveSettingBundle;
import com.bykv.vk.component.ttvideo.INetworkClient;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.VideoLiveManager;
import com.bykv.vk.component.ttvideo.log.LiveError;
import com.bykv.vk.openvk.component.video.api.c;
import com.bykv.vk.openvk.component.video.api.xv;
import com.bykv.vk.openvk.component.video.api.xv.sr;
import com.bykv.vk.openvk.component.video.api.xv.w;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.component.w.c.a;
import com.bytedance.sdk.component.w.c.fp;
import com.bytedance.sdk.component.w.c.t;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements com.bykv.vk.openvk.component.video.api.c, n.c {

    /* renamed from: c  reason: collision with root package name */
    private ILivePlayer f29883c;
    private volatile sr ck;
    private JSONObject eq;

    /* renamed from: f  reason: collision with root package name */
    private n f29884f;
    private SurfaceTexture gb;

    /* renamed from: i  reason: collision with root package name */
    private long f29885i;
    private SurfaceHolder ls;
    private int sr;
    private int ux;
    private boolean wv;
    private boolean xk;
    private final Context xv;
    private long ys;

    /* renamed from: w  reason: collision with root package name */
    private final List<WeakReference<c.InterfaceC0334c>> f29895w = Collections.synchronizedList(new ArrayList());

    /* renamed from: r  reason: collision with root package name */
    private volatile boolean f29891r = false;
    private volatile boolean ev = false;
    private volatile boolean gd = false;

    /* renamed from: p  reason: collision with root package name */
    private volatile boolean f29889p = false;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f29887k = false;

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f29882a = false;
    private volatile boolean bk = false;

    /* renamed from: t  reason: collision with root package name */
    private volatile boolean f29893t = true;
    private long fp = 0;
    private long ia = 0;

    /* renamed from: s  reason: collision with root package name */
    private final int f29892s = 0;
    private int fz = 0;

    /* renamed from: u  reason: collision with root package name */
    private long f29894u = 0;

    /* renamed from: q  reason: collision with root package name */
    private long f29890q = 0;

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f29886j = false;

    /* renamed from: n  reason: collision with root package name */
    private volatile int f29888n = 200;

    /* renamed from: z  reason: collision with root package name */
    private long f29897z = 0;
    private final ArrayList<Runnable> ba = new ArrayList<>();

    /* renamed from: y  reason: collision with root package name */
    private final Runnable f29896y = new Runnable() { // from class: com.bytedance.sdk.component.k.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            long fz = c.this.fz();
            c.this.f29890q += c.this.f29888n;
            if (c.this.s() > 0 && c.this.f29897z != fz) {
                if (xv.sr()) {
                    com.bykv.vk.openvk.component.video.api.f.xv.w("TTLiveVideoPlayer", "run: lastCur = " + c.this.f29897z + "  currentPosition=" + fz);
                }
                c cVar = c.this;
                cVar.c(fz, cVar.s());
            }
            c.this.f29897z = fz;
            if (c.this.fz() >= c.this.f29885i) {
                c.this.f29887k = true;
                c.this.ux();
                for (WeakReference weakReference : c.this.f29895w) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((c.InterfaceC0334c) weakReference.get()).c(c.this);
                    }
                }
            }
            if (!c.this.f29887k) {
                if (c.this.f29884f != null) {
                    c.this.f29884f.postDelayed(this, c.this.f29888n);
                    return;
                }
                return;
            }
            c cVar2 = c.this;
            cVar2.c(cVar2.s(), c.this.s());
        }
    };
    private CountDownLatch me = new CountDownLatch(1);
    private final ILiveListener yu = new ILiveListener() { // from class: com.bytedance.sdk.component.k.c.c.6

        /* renamed from: w  reason: collision with root package name */
        private boolean f29907w = false;

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onAbrSwitch(String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onAudioRenderStall(int i4) {
            com.bykv.vk.openvk.component.video.api.f.xv.c("TTLiveVideoPlayer", "audio render stall time " + i4);
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onCacheFileCompletion() {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onCompletion() {
            if (c.this.f29884f == null) {
                return;
            }
            c.this.f29884f.removeCallbacks(c.this.f29896y);
            for (WeakReference weakReference : c.this.f29895w) {
                if (weakReference != null && weakReference.get() != null) {
                    ((c.InterfaceC0334c) weakReference.get()).c(c.this, -1, -1, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onError(LiveError liveError) {
            if (liveError != null) {
                com.bykv.vk.openvk.component.video.api.f.xv.c("TTLiveVideoPlayer", "ILiveListener onError: " + liveError.code);
                if (this.f29907w) {
                    return;
                }
                this.f29907w = true;
                w wVar = new w(liveError.code, 0, liveError.getInfoJSON());
                for (WeakReference weakReference : c.this.f29895w) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((c.InterfaceC0334c) weakReference.get()).c(c.this, wVar);
                    }
                }
            }
            c.this.f29893t = true;
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onFirstFrame(boolean z3) {
            if (c.this.f29884f == null) {
                return;
            }
            c.this.f29886j = true;
            com.bykv.vk.openvk.component.video.api.f.xv.c("TTLiveVideoPlayer", "onFirstFrame->first frame , firstFrameWaitTime=" + c.this.fp);
            c.this.f29884f.removeCallbacks(c.this.f29896y);
            if (c.this.f29885i > 0) {
                c.this.f29884f.postDelayed(c.this.f29896y, c.this.f29888n);
            }
            c.this.f29893t = false;
            if (z3) {
                c.this.fp = System.currentTimeMillis() - c.this.ys;
                com.bykv.vk.openvk.component.video.api.f.xv.c("TTLiveVideoPlayer", "onFirstFrame->first frame , firstFrameWaitTime=" + c.this.fp);
                for (WeakReference weakReference : c.this.f29895w) {
                    if (weakReference != null && weakReference.get() != null) {
                        c cVar = c.this;
                        ((c.InterfaceC0334c) weakReference.get()).c(cVar, cVar.fp);
                    }
                }
                return;
            }
            com.bykv.vk.openvk.component.video.api.f.xv.xv("TTLiveVideoPlayer", "onFirstFrame-> not first frame , isFirstFrame=" + z3);
            for (WeakReference weakReference2 : c.this.f29895w) {
                if (weakReference2 != null && weakReference2.get() != null) {
                    ((c.InterfaceC0334c) weakReference2.get()).c((com.bykv.vk.openvk.component.video.api.c) c.this, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onMonitorLog(JSONObject jSONObject, String str) {
            for (WeakReference weakReference : c.this.f29895w) {
                if (weakReference != null && weakReference.get() != null) {
                    ((c.InterfaceC0334c) weakReference.get()).c(c.this, jSONObject, str);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onPrepared() {
            com.bykv.vk.openvk.component.video.api.f.xv.w("TTLiveVideoPlayer", "onPrepared.....");
            c.this.f29882a = true;
            for (WeakReference weakReference : c.this.f29895w) {
                if (weakReference != null && weakReference.get() != null) {
                    ((c.InterfaceC0334c) weakReference.get()).w(c.this);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onReportALog(int i4, String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onResolutionDegrade(String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onSeiUpdate(String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onStallEnd() {
            if (c.this.f29884f == null) {
                return;
            }
            if (c.this.f29885i > 0) {
                c.this.f29884f.postDelayed(c.this.f29896y, c.this.f29888n);
            }
            c.this.ia += System.currentTimeMillis() - c.this.f29894u;
            for (WeakReference weakReference : c.this.f29895w) {
                if (weakReference != null && weakReference.get() != null) {
                    ((c.InterfaceC0334c) weakReference.get()).c((com.bykv.vk.openvk.component.video.api.c) c.this, -1);
                }
            }
            com.bykv.vk.openvk.component.video.api.f.xv.c("TTLiveVideoPlayer", "stall end, \u5361\u987f\u7ed3\u675f\u65f6\u957f time \uff1a" + c.this.ia);
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onStallStart() {
            if (c.this.f29884f == null) {
                return;
            }
            c.ys(c.this);
            c.this.f29894u = System.currentTimeMillis();
            c.this.f29884f.removeCallbacks(c.this.f29896y);
            com.bykv.vk.openvk.component.video.api.f.xv.c("TTLiveVideoPlayer", "stall start, \u5361\u987f\u5f00\u59cb ......");
            for (WeakReference weakReference : c.this.f29895w) {
                if (weakReference != null && weakReference.get() != null) {
                    ((c.InterfaceC0334c) weakReference.get()).c(c.this, -1, -1, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onVideoRenderStall(int i4) {
            com.bykv.vk.openvk.component.video.api.f.xv.c("TTLiveVideoPlayer", "video render stall time " + i4);
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onVideoSizeChanged(int i4, int i5) {
            com.bykv.vk.openvk.component.video.api.f.xv.c("TTLiveVideoPlayer", "onVideoSizeChanged->width:" + i4 + " height:" + i5);
            c.this.sr = i4;
            c.this.ux = i5;
            for (WeakReference weakReference : c.this.f29895w) {
                if (weakReference != null && weakReference.get() != null) {
                    ((c.InterfaceC0334c) weakReference.get()).c((com.bykv.vk.openvk.component.video.api.c) c.this, i4, i5);
                }
            }
        }
    };

    /* renamed from: com.bytedance.sdk.component.k.c.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class C0448c implements INetworkClient {

        /* renamed from: c  reason: collision with root package name */
        private final a f29908c;

        public C0448c() {
            a.c w3 = xv.xv().w();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            this.f29908c = w3.c(10L, timeUnit).w(10L, timeUnit).xv(10L, timeUnit).c();
        }

        @Override // com.bykv.vk.component.ttvideo.INetworkClient
        public INetworkClient.Result doPost(String str, String str2) {
            return null;
        }

        @Override // com.bykv.vk.component.ttvideo.INetworkClient
        public INetworkClient.Result doRequest(String str, String str2) {
            String str3;
            String str4;
            String str5 = null;
            String str6 = null;
            JSONObject jSONObject = null;
            try {
                try {
                    fp c4 = this.f29908c.c(new t.c().c(str).w("host", str2).w()).c();
                    if (c4.sr()) {
                        str4 = c4.f().w();
                        try {
                            str6 = c4.r().toString();
                            jSONObject = new JSONObject(str4);
                        } catch (JSONException e4) {
                            e = e4;
                            String str7 = str6;
                            str5 = str4;
                            str3 = str7;
                            return INetworkClient.Result.newBuilder().setBody(str5).setHeader(str3).setException(e).build();
                        }
                    } else {
                        str4 = null;
                    }
                    return INetworkClient.Result.newBuilder().setResponse(jSONObject).setBody(str4).build();
                } catch (IOException e5) {
                    return INetworkClient.Result.newBuilder().setException(e5).build();
                } catch (Exception e6) {
                    return INetworkClient.Result.newBuilder().setException(e6).build();
                }
            } catch (JSONException e7) {
                e = e7;
                str3 = null;
            }
        }
    }

    public c(Context context, boolean z3, long j4, JSONObject jSONObject) {
        this.f29884f = null;
        this.f29885i = 0L;
        this.xv = context;
        this.eq = jSONObject;
        this.f29885i = j4 > 0 ? j4 * 1000 : -1L;
        if (this.f29884f == null) {
            this.f29884f = com.bytedance.sdk.component.gd.w.c.c().c(this, "tt-live-video-player");
        }
        xv(z3);
    }

    private synchronized void i() {
        com.bykv.vk.openvk.component.video.api.f.xv.c("TTLiveVideoPlayer", "mExecutingActions:" + this.wv);
        if (this.wv) {
            return;
        }
        this.wv = true;
        Iterator it = new ArrayList(this.ba).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.ba.clear();
        com.bykv.vk.openvk.component.video.api.f.xv.c("TTLiveVideoPlayer", "mExecutingActions clear");
        this.wv = false;
    }

    private void q() {
        n nVar = this.f29884f;
        if (nVar == null || nVar.getLooper() == null) {
            return;
        }
        this.f29884f.post(new Runnable() { // from class: com.bytedance.sdk.component.k.c.c.5
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f29884f == null || c.this.f29884f.getLooper() == null) {
                    return;
                }
                try {
                    com.bykv.vk.openvk.component.video.api.f.xv.c("TTLiveVideoPlayer", "onDestory............");
                    c.this.gb = null;
                    c.this.ls = null;
                    com.bytedance.sdk.component.gd.w.c.c().c(c.this.f29884f);
                    c.this.f29884f = null;
                } catch (Throwable th) {
                    com.bykv.vk.openvk.component.video.api.f.xv.c("TTLiveVideoPlayer", "onDestroy error: ", th);
                }
            }
        });
    }

    private synchronized void u() {
        ArrayList<Runnable> arrayList = this.ba;
        if (arrayList != null && !arrayList.isEmpty()) {
            i();
            return;
        }
        com.bykv.vk.openvk.component.video.api.f.xv.c("TTLiveVideoPlayer", "no need exec");
    }

    static /* synthetic */ int ys(c cVar) {
        int i4 = cVar.fz;
        cVar.fz = i4 + 1;
        return i4;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void c(float f4) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void c(int i4) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void c(long j4) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public long fz() {
        return this.f29890q;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public long s() {
        return this.f29885i;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public int a() {
        return this.ux;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public boolean bk() {
        ILivePlayer iLivePlayer = this.f29883c;
        if (iLivePlayer != null) {
            try {
                return iLivePlayer.isPlaying();
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.f.xv.w("TTLiveVideoPlayer", "isPlaying: catch exception:", th);
                return false;
            }
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public SurfaceTexture ev() {
        return this.gb;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public long fp() {
        return this.ia;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public boolean gd() {
        com.bykv.vk.openvk.component.video.api.f.xv.xv("TTLiveVideoPlayer", "TTLiveVideoPlayer...isCompleted......isComplete....=" + this.f29887k);
        return this.f29887k;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public int ia() {
        return this.fz;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public int k() {
        return this.sr;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public boolean p() {
        return this.bk;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public SurfaceHolder r() {
        return this.ls;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public boolean t() {
        return this.f29893t;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public boolean ys() {
        return this.gd;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public boolean f() {
        return this.f29886j;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void ux() {
        n nVar = this.f29884f;
        if (nVar != null) {
            nVar.removeCallbacks(this.f29896y);
            nVar.sendEmptyMessage(103);
            q();
        }
        com.bykv.vk.openvk.component.video.api.f.xv.xv("TTLiveVideoPlayer", "TTLiveVideoPlayer...release......release....");
    }

    private void xv(final boolean z3) {
        n nVar = this.f29884f;
        if (nVar != null) {
            nVar.post(new Runnable() { // from class: com.bytedance.sdk.component.k.c.c.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ILiveSettingBundle iLiveSettingBundle = new ILiveSettingBundle() { // from class: com.bytedance.sdk.component.k.c.c.2.1
                            /* JADX WARN: Multi-variable type inference failed */
                            /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
                            /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
                            /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Integer] */
                            @Override // com.bykv.vk.component.ttvideo.ILiveSettingBundle
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct code enable 'Show inconsistent code' option in preferences
                            */
                            public <T> T getSettingsValueForKey(java.lang.String r2, T r3) {
                                /*
                                    r1 = this;
                                    r2.hashCode()
                                    java.lang.String r0 = "live_enable_close_play_retry"
                                    boolean r0 = r2.equals(r0)
                                    if (r0 != 0) goto L14
                                    java.lang.String r0 = "live_sdk_cancel_sdk_dns_fail_retry"
                                    boolean r2 = r2.equals(r0)
                                    if (r2 != 0) goto L23
                                    goto L30
                                L14:
                                    java.lang.Class r2 = r3.getClass()
                                    java.lang.Class<java.lang.Integer> r0 = java.lang.Integer.class
                                    if (r2 != r0) goto L23
                                    java.lang.String r2 = "1"
                                    java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                                    goto L24
                                L23:
                                    r2 = r3
                                L24:
                                    java.lang.Class r3 = r3.getClass()
                                    java.lang.Class<java.lang.Boolean> r0 = java.lang.Boolean.class
                                    if (r3 != r0) goto L2f
                                    java.lang.Boolean r3 = java.lang.Boolean.TRUE
                                    goto L30
                                L2f:
                                    r3 = r2
                                L30:
                                    return r3
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.k.c.c.AnonymousClass2.AnonymousClass1.getSettingsValueForKey(java.lang.String, java.lang.Object):java.lang.Object");
                            }
                        };
                        c cVar = c.this;
                        cVar.f29883c = VideoLiveManager.newBuilder(cVar.xv).setProjectKey("pangle_ad_live").setNetworkClient(new C0448c()).setForceHttpDns(false).setForceTTNetHttpDns(false).setSettingsBundle(iLiveSettingBundle).setPlayerType(1).setListener(c.this.yu).build();
                        c.this.f29883c.setIntOption(69, z3 ? 1 : 0);
                        ILivePlayer iLivePlayer = c.this.f29883c;
                        iLivePlayer.setStringOption(72, com.bytedance.sdk.openadsdk.api.plugin.w.c(c.this.xv, null).getAbsolutePath() + "/pangle_live/");
                    } catch (Exception e4) {
                        com.bykv.vk.openvk.component.video.api.f.xv.sr("TTLiveVideoPlayer", e4.getMessage());
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void sr() {
        com.bykv.vk.openvk.component.video.api.f.xv.xv("TTLiveVideoPlayer", "TTLiveVideoPlayer...stop......stop....currentPosition=" + fz());
        n nVar = this.f29884f;
        if (nVar != null) {
            nVar.removeCallbacks(this.f29896y);
            nVar.sendEmptyMessage(105);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void w() {
        n nVar = this.f29884f;
        if (nVar != null) {
            nVar.post(new Runnable() { // from class: com.bytedance.sdk.component.k.c.c.4
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.f29883c == null || c.this.bk()) {
                        return;
                    }
                    try {
                        c.this.f29883c.play();
                        c cVar = c.this;
                        cVar.c(cVar.xk);
                        for (WeakReference weakReference : c.this.f29895w) {
                            if (weakReference != null && weakReference.get() != null) {
                                ((c.InterfaceC0334c) weakReference.get()).ux(c.this);
                            }
                        }
                    } catch (Throwable th) {
                        com.bykv.vk.openvk.component.video.api.f.xv.w("TTLiveVideoPlayer", "play: catch exception", th);
                    }
                    c.this.f29893t = false;
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void xv() {
        com.bykv.vk.openvk.component.video.api.f.xv.xv("TTLiveVideoPlayer", "TTLiveVideoPlayer...pause......pause....currentPosition=" + fz());
        n nVar = this.f29884f;
        if (nVar != null) {
            nVar.removeCallbacks(this.f29896y);
            nVar.sendEmptyMessage(101);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void w(boolean z3) {
        this.f29889p = z3;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void w(int i4) {
        this.f29888n = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j4, long j5) {
        for (WeakReference<c.InterfaceC0334c> weakReference : this.f29895w) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().c(this, j4, j5);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void c(sr srVar) {
        if (srVar == null) {
            return;
        }
        this.ck = srVar;
        com.bykv.vk.openvk.component.video.api.f.xv.w("TTLiveVideoPlayer", "setDataSource: model = " + srVar.fp());
        n nVar = this.f29884f;
        if (nVar != null) {
            nVar.sendEmptyMessage(107);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void c() {
        this.fz = 0;
        this.ia = 0L;
        this.f29894u = 0L;
        c(true, 0L, false);
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void c(boolean z3, final long j4, final boolean z4) {
        if (this.f29891r && this.ev && this.f29883c != null) {
            this.f29890q = j4;
            this.ys = System.currentTimeMillis();
            c(z4);
            n nVar = this.f29884f;
            if (nVar != null) {
                nVar.sendEmptyMessage(100);
            }
            com.bytedance.sdk.component.utils.a.sr("TTLiveVideoPlayer", "TTLiveVideoPlayer...play......");
        } else {
            com.bytedance.sdk.component.utils.a.w("TTLiveVideoPlayer", "start , some status : isPrepared=" + this.f29882a + ",isSetData=" + this.ev + ",mLivePlayer =" + this.f29883c);
            c(new Runnable() { // from class: com.bytedance.sdk.component.k.c.c.3
                @Override // java.lang.Runnable
                public void run() {
                    com.bykv.vk.openvk.component.video.api.f.xv.c("TTLiveVideoPlayer", "start runnable");
                    c.this.f29890q = j4;
                    c.this.ys = System.currentTimeMillis();
                    c.this.c(z4);
                    if (c.this.f29884f != null) {
                        c.this.f29884f.sendEmptyMessage(100);
                    }
                }
            });
        }
        com.bykv.vk.openvk.component.video.api.f.xv.c("TTLiveVideoPlayer", "start:end");
        this.me.countDown();
    }

    private synchronized void c(Runnable runnable) {
        this.ba.add(runnable);
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void c(boolean z3) {
        this.xk = z3;
        if (this.f29883c != null) {
            com.bykv.vk.openvk.component.video.api.f.xv.xv("TTLiveVideoPlayer", "TTLiveVideoPlayer...setQuietPlay......isMute=" + z3);
            try {
                this.f29883c.setMute(Boolean.valueOf(z3));
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.f.xv.w("TTLiveVideoPlayer", "setMute: catch exception:", th);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void c(SurfaceHolder surfaceHolder) {
        this.ls = surfaceHolder;
        com.bykv.vk.openvk.component.video.api.f.xv.xv("TTLiveVideoPlayer", "TTLiveVideoPlayer...SurfaceHolder......" + surfaceHolder);
        n nVar = this.f29884f;
        if (nVar != null) {
            nVar.obtainMessage(110, surfaceHolder).sendToTarget();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void c(SurfaceTexture surfaceTexture) {
        this.gb = surfaceTexture;
        n nVar = this.f29884f;
        if (nVar != null) {
            nVar.obtainMessage(111, surfaceTexture).sendToTarget();
        }
        com.bykv.vk.openvk.component.video.api.f.xv.xv("TTLiveVideoPlayer", "setSurface...surface=");
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void c(c.InterfaceC0334c interfaceC0334c) {
        if (interfaceC0334c == null) {
            return;
        }
        for (WeakReference<c.InterfaceC0334c> weakReference : this.f29895w) {
            if (weakReference != null && weakReference.get() == interfaceC0334c) {
                return;
            }
        }
        this.f29895w.add(new WeakReference<>(interfaceC0334c));
    }

    @Override // com.bytedance.sdk.component.utils.n.c
    public void c(Message message) {
        int i4 = message.what;
        com.bykv.vk.openvk.component.video.api.f.xv.c("TTLiveVideoPlayer", "what:" + i4);
        try {
            switch (i4) {
                case 100:
                    w();
                    this.bk = true;
                    return;
                case 101:
                    ILivePlayer iLivePlayer = this.f29883c;
                    if (iLivePlayer != null) {
                        iLivePlayer.stop();
                        for (WeakReference<c.InterfaceC0334c> weakReference : this.f29895w) {
                            if (weakReference != null && weakReference.get() != null) {
                                weakReference.get().sr(this);
                            }
                        }
                        this.f29893t = true;
                        return;
                    }
                    return;
                case 102:
                    ILivePlayer iLivePlayer2 = this.f29883c;
                    if (iLivePlayer2 != null) {
                        iLivePlayer2.reset();
                        this.f29893t = true;
                        return;
                    }
                    return;
                case 103:
                    ILivePlayer iLivePlayer3 = this.f29883c;
                    if (iLivePlayer3 != null) {
                        iLivePlayer3.release();
                        this.gd = true;
                        this.f29893t = true;
                        return;
                    }
                    return;
                case 104:
                case 106:
                case 108:
                case 109:
                default:
                    return;
                case 105:
                    ILivePlayer iLivePlayer4 = this.f29883c;
                    if (iLivePlayer4 != null) {
                        iLivePlayer4.stop();
                        this.f29893t = true;
                        return;
                    }
                    return;
                case 107:
                    if (this.f29883c == null || this.ck == null) {
                        return;
                    }
                    String fp = this.ck.fp();
                    c(fp);
                    this.f29883c.setStreamInfo(fp);
                    this.ev = true;
                    com.bykv.vk.openvk.component.video.api.f.xv.w("TTLiveVideoPlayer", "set Datasource:" + this.ev);
                    this.fz = 0;
                    return;
                case 110:
                    ILivePlayer iLivePlayer5 = this.f29883c;
                    if (iLivePlayer5 != null) {
                        SurfaceHolder surfaceHolder = (SurfaceHolder) message.obj;
                        iLivePlayer5.setSurfaceHolder(surfaceHolder);
                        this.f29883c.setSurface(surfaceHolder.getSurface());
                        this.f29891r = true;
                        com.bykv.vk.openvk.component.video.api.f.xv.c("TTLiveVideoPlayer", "OP_SET_DISPLAY");
                        this.me.await(1L, TimeUnit.SECONDS);
                        u();
                        return;
                    }
                    return;
                case 111:
                    ILivePlayer iLivePlayer6 = this.f29883c;
                    if (iLivePlayer6 != null) {
                        iLivePlayer6.setSurface(new Surface(this.gb));
                        this.f29891r = true;
                        com.bykv.vk.openvk.component.video.api.f.xv.c("TTLiveVideoPlayer", "OP_SET_SURFACE");
                        this.me.await(1L, TimeUnit.SECONDS);
                        u();
                        return;
                    }
                    return;
            }
        } catch (Exception e4) {
            com.bykv.vk.openvk.component.video.api.f.xv.c("TTLiveVideoPlayer", "exception:" + e4.getMessage());
        }
    }

    private void c(String str) {
        String str2 = LiveConfigKey.UHD;
        try {
            JSONObject jSONObject = this.eq;
            if (jSONObject == null) {
                return;
            }
            com.bykv.vk.openvk.component.video.api.f.xv.w("TTLiveVideoPlayer", "live " + jSONObject);
            int optInt = jSONObject.optInt("enable");
            String optString = jSONObject.optString("appids");
            if (optInt == 1 && !TextUtils.isEmpty(optString)) {
                JSONObject jSONObject2 = new JSONObject(str);
                JSONObject optJSONObject = jSONObject2.optJSONObject("common");
                JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                if (optJSONObject != null && optJSONObject2 != null) {
                    String optString2 = optJSONObject.optString("app_id");
                    com.bykv.vk.openvk.component.video.api.f.xv.w("TTLiveVideoPlayer", "api " + optString2);
                    if (optString.contains(optString2)) {
                        if (optJSONObject2.optJSONObject(LiveConfigKey.UHD) == null) {
                            if (optJSONObject2.optJSONObject(LiveConfigKey.HIGH) != null) {
                                str2 = LiveConfigKey.HIGH;
                            } else if (optJSONObject2.optJSONObject(LiveConfigKey.STANDARD) != null) {
                                str2 = LiveConfigKey.STANDARD;
                            } else {
                                str2 = optJSONObject2.optJSONObject(LiveConfigKey.LOW) != null ? LiveConfigKey.LOW : null;
                            }
                        }
                        if (TextUtils.isEmpty(str2)) {
                            return;
                        }
                        com.bykv.vk.openvk.component.video.api.f.xv.w("TTLiveVideoPlayer", "update reso:" + str2);
                        this.f29883c.setStringOption(43, str2);
                    }
                }
            }
        } catch (Exception e4) {
            com.bykv.vk.openvk.component.video.api.f.xv.w("TTLiveVideoPlayer", "updateStream: catch exception:", e4.getMessage());
        }
    }
}

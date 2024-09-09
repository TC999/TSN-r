package com.devlin_n.videoplayer.player;

import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.OrientationEventListener;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.devlin_n.videoplayer.R;
import com.devlin_n.videoplayer.controller.BaseVideoController;
import com.devlin_n.videoplayer.widget.ResizeSurfaceView;
import com.devlin_n.videoplayer.widget.ResizeTextureView;
import com.devlin_n.videoplayer.widget.StatusView;
import com.stub.StubApp;
import java.io.File;
import java.io.IOException;
import java.util.List;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.ui.widget.DanmakuView;
import tv.danmaku.ijk.media.player.AndroidMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class IjkVideoView extends FrameLayout implements BaseVideoController.d {
    public static final int B0 = 1;
    public static final int C0 = 2;
    public static final int D0 = 3;
    public static final int E0 = 4;
    public static final int M = -1;
    public static final int N = 0;
    public static final int O = 1;
    public static final int P = 2;
    public static final int Q = 3;
    public static final int R = 4;
    public static final int S = 5;
    public static final int T = 6;
    public static final int U = 7;
    public static final int V = 10;
    public static final int W = 11;

    /* renamed from: p0  reason: collision with root package name */
    public static final int f36926p0 = 0;
    protected boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private IMediaPlayer.OnErrorListener F;
    private IMediaPlayer.OnCompletionListener G;
    private IMediaPlayer.OnInfoListener H;
    private IMediaPlayer.OnBufferingUpdateListener I;
    private IMediaPlayer.OnPreparedListener J;
    private IMediaPlayer.OnVideoSizeChangedListener K;

    /* renamed from: L  reason: collision with root package name */
    private com.danikula.videocache.e f36927L;

    /* renamed from: a  reason: collision with root package name */
    private IMediaPlayer f36928a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private BaseVideoController f36929b;

    /* renamed from: c  reason: collision with root package name */
    private b1.d f36930c;

    /* renamed from: d  reason: collision with root package name */
    private ResizeSurfaceView f36931d;

    /* renamed from: e  reason: collision with root package name */
    private ResizeTextureView f36932e;

    /* renamed from: f  reason: collision with root package name */
    private SurfaceTexture f36933f;

    /* renamed from: g  reason: collision with root package name */
    private DanmakuView f36934g;

    /* renamed from: h  reason: collision with root package name */
    private DanmakuContext f36935h;

    /* renamed from: i  reason: collision with root package name */
    private master.flame.danmaku.danmaku.parser.a f36936i;

    /* renamed from: j  reason: collision with root package name */
    private FrameLayout f36937j;

    /* renamed from: k  reason: collision with root package name */
    private StatusView f36938k;

    /* renamed from: l  reason: collision with root package name */
    private int f36939l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f36940m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f36941n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f36942o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f36943p;

    /* renamed from: q  reason: collision with root package name */
    private String f36944q;

    /* renamed from: r  reason: collision with root package name */
    private List<com.devlin_n.videoplayer.player.b> f36945r;

    /* renamed from: s  reason: collision with root package name */
    private int f36946s;

    /* renamed from: t  reason: collision with root package name */
    private int f36947t;

    /* renamed from: u  reason: collision with root package name */
    private String f36948u;

    /* renamed from: v  reason: collision with root package name */
    private int f36949v;

    /* renamed from: w  reason: collision with root package name */
    private AudioManager f36950w;
    @NonNull

    /* renamed from: x  reason: collision with root package name */
    private m f36951x;

    /* renamed from: y  reason: collision with root package name */
    private int f36952y;

    /* renamed from: z  reason: collision with root package name */
    protected OrientationEventListener f36953z;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    class a implements IMediaPlayer.OnVideoSizeChangedListener {
        a() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i4, int i5, int i6, int i7) {
            int videoWidth = iMediaPlayer.getVideoWidth();
            int videoHeight = iMediaPlayer.getVideoHeight();
            if (videoWidth == 0 || videoHeight == 0) {
                return;
            }
            if (IjkVideoView.this.f36942o) {
                IjkVideoView.this.f36931d.setScreenScale(IjkVideoView.this.f36952y);
                IjkVideoView.this.f36931d.a(videoWidth, videoHeight);
                return;
            }
            IjkVideoView.this.f36932e.setScreenScale(IjkVideoView.this.f36952y);
            IjkVideoView.this.f36932e.a(videoWidth, videoHeight);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    class b implements com.danikula.videocache.e {
        b() {
        }

        @Override // com.danikula.videocache.e
        public void a(File file, String str, int i4) {
            IjkVideoView.this.f36939l = i4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    class c extends OrientationEventListener {

        /* renamed from: c  reason: collision with root package name */
        private static final int f36956c = 1;

        /* renamed from: d  reason: collision with root package name */
        private static final int f36957d = 2;

        /* renamed from: e  reason: collision with root package name */
        private static final int f36958e = 3;

        /* renamed from: a  reason: collision with root package name */
        private int f36959a;

        c(Context context) {
            super(context);
            this.f36959a = 0;
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i4) {
            int i5;
            int i6;
            if (i4 >= 340) {
                if (IjkVideoView.this.B || IjkVideoView.this.C || (i6 = this.f36959a) == 1) {
                    return;
                }
                if ((i6 == 2 || i6 == 3) && !IjkVideoView.this.b()) {
                    this.f36959a = 1;
                    return;
                }
                this.f36959a = 1;
                c1.f.l(IjkVideoView.this.getContext()).setRequestedOrientation(1);
                IjkVideoView.this.f();
            } else if (i4 >= 260 && i4 <= 280) {
                int i7 = this.f36959a;
                if (i7 == 2) {
                    return;
                }
                if (i7 == 1 && IjkVideoView.this.b()) {
                    this.f36959a = 2;
                    return;
                }
                this.f36959a = 2;
                if (!IjkVideoView.this.b()) {
                    IjkVideoView.this.i();
                }
                c1.f.l(IjkVideoView.this.getContext()).setRequestedOrientation(0);
            } else if (i4 < 70 || i4 > 90 || (i5 = this.f36959a) == 3) {
            } else {
                if (i5 == 1 && IjkVideoView.this.b()) {
                    this.f36959a = 3;
                    return;
                }
                this.f36959a = 3;
                if (!IjkVideoView.this.b()) {
                    IjkVideoView.this.i();
                }
                c1.f.l(IjkVideoView.this.getContext()).setRequestedOrientation(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class d implements SurfaceHolder.Callback {
        d() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i4, int i5, int i6) {
            if (IjkVideoView.this.f36928a != null) {
                IjkVideoView.this.f36928a.setDisplay(surfaceHolder);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class e implements TextureView.SurfaceTextureListener {
        e() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i4, int i5) {
            if (IjkVideoView.this.f36933f != null) {
                IjkVideoView.this.f36932e.setSurfaceTexture(IjkVideoView.this.f36933f);
                return;
            }
            IjkVideoView.this.f36933f = surfaceTexture;
            IjkVideoView.this.f36928a.setSurface(new Surface(surfaceTexture));
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return IjkVideoView.this.f36933f == null;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i4, int i5) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c1.a.d = true;
            IjkVideoView.this.f36937j.removeView(IjkVideoView.this.f36938k);
            IjkVideoView.this.U();
            IjkVideoView.this.j0();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IjkVideoView.this.f36928a.reset();
            IjkVideoView.this.f36928a.release();
            IjkVideoView.this.f36928a = null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    class h implements IMediaPlayer.OnErrorListener {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
        /* loaded from: E:\TSN-r\205dec\6241084.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IjkVideoView.this.f36937j.removeView(IjkVideoView.this.f36938k);
                IjkVideoView.this.a0();
                IjkVideoView.this.j0();
            }
        }

        h() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
        public boolean onError(IMediaPlayer iMediaPlayer, int i4, int i5) {
            IjkVideoView.this.f36949v = -1;
            if (IjkVideoView.this.f36930c != null) {
                IjkVideoView.this.f36930c.onError();
            }
            if (IjkVideoView.this.f36929b != null) {
                IjkVideoView.this.f36929b.setPlayState(IjkVideoView.this.f36949v);
            }
            IjkVideoView ijkVideoView = IjkVideoView.this;
            ijkVideoView.f36947t = ijkVideoView.getCurrentPosition();
            IjkVideoView.this.f36937j.removeView(IjkVideoView.this.f36938k);
            if (IjkVideoView.this.f36938k == null) {
                IjkVideoView.this.f36938k = new StatusView(IjkVideoView.this.getContext());
            }
            IjkVideoView.this.f36938k.setMessage(IjkVideoView.this.getResources().getString(R.string.error_message));
            IjkVideoView.this.f36938k.b(IjkVideoView.this.getResources().getString(R.string.retry), new a());
            IjkVideoView.this.f36937j.addView(IjkVideoView.this.f36938k);
            return true;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    class i implements IMediaPlayer.OnCompletionListener {
        i() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
        public void onCompletion(IMediaPlayer iMediaPlayer) {
            IjkVideoView.this.f36949v = 5;
            if (IjkVideoView.this.f36930c != null) {
                IjkVideoView.this.f36930c.onComplete();
            }
            if (IjkVideoView.this.f36929b != null) {
                IjkVideoView.this.f36929b.setPlayState(IjkVideoView.this.f36949v);
            }
            IjkVideoView.this.setKeepScreenOn(false);
            IjkVideoView.q(IjkVideoView.this);
            if (IjkVideoView.this.f36945r == null || IjkVideoView.this.f36945r.size() <= 1 || IjkVideoView.this.f36946s >= IjkVideoView.this.f36945r.size()) {
                return;
            }
            IjkVideoView.this.Y();
            IjkVideoView.this.a0();
            IjkVideoView.this.j0();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    class j implements IMediaPlayer.OnInfoListener {
        j() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
        public boolean onInfo(IMediaPlayer iMediaPlayer, int i4, int i5) {
            if (IjkVideoView.this.f36930c != null) {
                IjkVideoView.this.f36930c.a(i4, i5);
            }
            if (i4 == 3) {
                if (IjkVideoView.this.getWindowVisibility() != 0) {
                    IjkVideoView.this.pause();
                    return true;
                }
                return true;
            } else if (i4 == 10001) {
                if (IjkVideoView.this.f36932e != null) {
                    IjkVideoView.this.f36932e.setRotation(i5);
                    return true;
                }
                return true;
            } else if (i4 == 701) {
                IjkVideoView.this.f36949v = 6;
                if (IjkVideoView.this.f36929b != null) {
                    IjkVideoView.this.f36929b.setPlayState(IjkVideoView.this.f36949v);
                    return true;
                }
                return true;
            } else if (i4 != 702) {
                return true;
            } else {
                IjkVideoView.this.f36949v = 7;
                if (IjkVideoView.this.f36929b != null) {
                    IjkVideoView.this.f36929b.setPlayState(IjkVideoView.this.f36949v);
                    return true;
                }
                return true;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    class k implements IMediaPlayer.OnBufferingUpdateListener {
        k() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i4) {
            if (IjkVideoView.this.D) {
                return;
            }
            IjkVideoView.this.f36939l = i4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    class l implements IMediaPlayer.OnPreparedListener {
        l() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
        public void onPrepared(IMediaPlayer iMediaPlayer) {
            IjkVideoView.this.f36949v = 2;
            if (IjkVideoView.this.f36930c != null) {
                IjkVideoView.this.f36930c.onPrepared();
            }
            if (IjkVideoView.this.f36929b != null) {
                IjkVideoView.this.f36929b.setPlayState(IjkVideoView.this.f36949v);
            }
            if (IjkVideoView.this.f36947t > 0) {
                IjkVideoView ijkVideoView = IjkVideoView.this;
                ijkVideoView.seekTo(ijkVideoView.f36947t);
            }
            IjkVideoView.this.start();
        }
    }

    public IjkVideoView(@NonNull Context context) {
        this(context, null);
    }

    private void N() {
        this.f36937j.removeView(this.f36931d);
        ResizeSurfaceView resizeSurfaceView = new ResizeSurfaceView(getContext());
        this.f36931d = resizeSurfaceView;
        SurfaceHolder holder = resizeSurfaceView.getHolder();
        holder.addCallback(new d());
        holder.setFormat(1);
        this.f36937j.addView(this.f36931d, 0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    private void O() {
        this.f36937j.removeView(this.f36932e);
        this.f36933f = null;
        ResizeTextureView resizeTextureView = new ResizeTextureView(getContext());
        this.f36932e = resizeTextureView;
        resizeTextureView.setSurfaceTextureListener(new e());
        this.f36937j.addView(this.f36932e, 0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean S() {
        if (c1.d.a(getContext()) != 4 || c1.a.d) {
            return false;
        }
        this.f36937j.removeView(this.f36938k);
        if (this.f36938k == null) {
            this.f36938k = new StatusView(getContext());
        }
        this.f36938k.setMessage(getResources().getString(R.string.wifi_tip));
        this.f36938k.b(getResources().getString(R.string.continue_play), new f());
        this.f36937j.addView(this.f36938k);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (this.f36928a == null) {
            if (this.f36943p) {
                this.f36928a = new AndroidMediaPlayer();
            } else {
                IjkMediaPlayer ijkMediaPlayer = new IjkMediaPlayer();
                this.f36928a = ijkMediaPlayer;
                ijkMediaPlayer.setOption(4, "mediacodec", 1L);
                ((IjkMediaPlayer) this.f36928a).setOption(4, "mediacodec-auto-rotate", 1L);
                ((IjkMediaPlayer) this.f36928a).setOption(4, "mediacodec-handle-resolution-change", 1L);
            }
            this.f36950w = (AudioManager) StubApp.getOrigApplicationContext(getContext().getApplicationContext()).getSystemService("audio");
            this.f36928a.setAudioStreamType(3);
            this.f36928a.setOnErrorListener(this.F);
            this.f36928a.setOnCompletionListener(this.G);
            this.f36928a.setOnInfoListener(this.H);
            this.f36928a.setOnBufferingUpdateListener(this.I);
            this.f36928a.setOnPreparedListener(this.J);
            this.f36928a.setOnVideoSizeChangedListener(this.K);
            this.f36949v = 0;
            BaseVideoController baseVideoController = this.f36929b;
            if (baseVideoController != null) {
                baseVideoController.setPlayState(0);
            }
        }
        if (this.f36942o) {
            N();
        } else {
            O();
        }
        DanmakuView danmakuView = this.f36934g;
        if (danmakuView != null) {
            this.f36937j.removeView(danmakuView);
            this.f36937j.addView(this.f36934g, 1);
        }
    }

    private void V() {
        c1.a.b = c1.f.d(getContext(), false);
        c1.a.a = c1.f.e(getContext());
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f36937j = frameLayout;
        frameLayout.setBackgroundColor(-16777216);
        addView(this.f36937j, new FrameLayout.LayoutParams(-1, -1));
    }

    private boolean W() {
        int i4;
        return (this.f36928a == null || (i4 = this.f36949v) == -1 || i4 == 0 || i4 == 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        com.devlin_n.videoplayer.player.b bVar = this.f36945r.get(this.f36946s);
        if (bVar != null) {
            this.f36944q = bVar.f36976a;
            this.f36948u = bVar.f36977b;
            this.f36947t = 0;
            f0(bVar.f36978c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        this.f36928a.reset();
        IMediaPlayer iMediaPlayer = this.f36928a;
        if (iMediaPlayer instanceof IjkMediaPlayer) {
            U();
            return;
        }
        iMediaPlayer.setVolume(1.0f, 1.0f);
        this.f36928a.setOnErrorListener(this.F);
        this.f36928a.setOnCompletionListener(this.G);
        this.f36928a.setOnInfoListener(this.H);
        this.f36928a.setOnBufferingUpdateListener(this.I);
        this.f36928a.setOnPreparedListener(this.J);
        this.f36928a.setOnVideoSizeChangedListener(this.K);
    }

    private com.danikula.videocache.i getCacheServer() {
        return com.devlin_n.videoplayer.player.a.c(StubApp.getOrigApplicationContext(getContext().getApplicationContext()));
    }

    private void i0() {
        if (W()) {
            Intent intent = new Intent(getContext(), BackgroundPlayService.class);
            intent.putExtra("url", this.f36944q);
            getCurrentPosition();
            intent.putExtra("position", getDuration() <= 0 ? 0 : this.f36947t);
            intent.putExtra("enable_cache", this.D);
            StubApp.getOrigApplicationContext(getContext().getApplicationContext()).startService(intent);
            c1.f.l(getContext()).finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0() {
        String str = this.f36944q;
        if (str == null || str.trim().equals("")) {
            return;
        }
        try {
            if (this.D) {
                com.danikula.videocache.i cacheServer = getCacheServer();
                String j4 = cacheServer.j(this.f36944q);
                cacheServer.p(this.f36927L, this.f36944q);
                if (cacheServer.m(this.f36944q)) {
                    this.f36939l = 100;
                }
                this.f36928a.setDataSource(j4);
            } else {
                this.f36928a.setDataSource(this.f36944q);
            }
            this.f36928a.prepareAsync();
            this.f36949v = 1;
            BaseVideoController baseVideoController = this.f36929b;
            if (baseVideoController != null) {
                baseVideoController.setPlayState(1);
                this.f36929b.setPlayerState(this.f36940m ? 11 : 10);
            }
            DanmakuView danmakuView = this.f36934g;
            if (danmakuView != null) {
                danmakuView.i(this.f36936i, this.f36935h);
            }
        } catch (IOException e4) {
            this.f36949v = -1;
            BaseVideoController baseVideoController2 = this.f36929b;
            if (baseVideoController2 != null) {
                baseVideoController2.setPlayState(-1);
            }
            e4.printStackTrace();
        }
    }

    static /* synthetic */ int q(IjkVideoView ijkVideoView) {
        int i4 = ijkVideoView.f36946s;
        ijkVideoView.f36946s = i4 + 1;
        return i4;
    }

    public IjkVideoView M(DanmakuView danmakuView, DanmakuContext danmakuContext, master.flame.danmaku.danmaku.parser.a aVar) {
        this.f36934g = danmakuView;
        this.f36935h = danmakuContext;
        this.f36936i = aVar;
        return this;
    }

    public IjkVideoView P() {
        this.E = true;
        return this;
    }

    public IjkVideoView Q() {
        this.C = true;
        return this;
    }

    public IjkVideoView R() {
        this.A = true;
        if (this.f36953z == null) {
            this.f36953z = new c(getContext());
        }
        return this;
    }

    public IjkVideoView T() {
        this.D = true;
        return this;
    }

    public boolean X() {
        BaseVideoController baseVideoController = this.f36929b;
        if (baseVideoController != null && this.B) {
            baseVideoController.g();
            Toast.makeText(getContext(), R.string.lock_tip, 0).show();
            return true;
        } else if (!this.C && this.f36940m) {
            c1.f.l(getContext()).setRequestedOrientation(1);
            f();
            BaseVideoController baseVideoController2 = this.f36929b;
            if (baseVideoController2 != null) {
                baseVideoController2.setPlayerState(10);
            }
            return true;
        } else {
            return false;
        }
    }

    public void Z() {
        if (this.f36928a != null) {
            new Thread(new g()).start();
            this.f36949v = 0;
            BaseVideoController baseVideoController = this.f36929b;
            if (baseVideoController != null) {
                baseVideoController.setPlayState(0);
            }
            this.f36951x.a();
            setKeepScreenOn(false);
        }
        DanmakuView danmakuView = this.f36934g;
        if (danmakuView != null) {
            danmakuView.release();
            this.f36934g = null;
        }
        OrientationEventListener orientationEventListener = this.f36953z;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        if (this.D) {
            getCacheServer().u(this.f36927L);
        }
        this.f36937j.removeView(this.f36932e);
        this.f36937j.removeView(this.f36931d);
        this.f36937j.removeView(this.f36938k);
        SurfaceTexture surfaceTexture = this.f36933f;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f36933f = null;
        }
        this.B = false;
        this.f36947t = 0;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public void a() {
        this.f36946s++;
        List<com.devlin_n.videoplayer.player.b> list = this.f36945r;
        if (list == null || list.size() <= 1 || this.f36946s >= this.f36945r.size()) {
            return;
        }
        Y();
        a0();
        j0();
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public boolean b() {
        return this.f36940m;
    }

    public void b0() {
        if (W() && !this.f36928a.isPlaying() && this.f36949v != 5) {
            this.f36928a.start();
            this.f36949v = 3;
            BaseVideoController baseVideoController = this.f36929b;
            if (baseVideoController != null) {
                baseVideoController.setPlayState(3);
            }
            this.f36951x.b();
            setKeepScreenOn(true);
        }
        DanmakuView danmakuView = this.f36934g;
        if (danmakuView != null && danmakuView.isPrepared() && this.f36934g.isPaused()) {
            this.f36934g.resume();
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public void c() {
        c1.f.l(getContext()).setRequestedOrientation(0);
        i();
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    /* renamed from: c0 */
    public IjkVideoView e(int i4) {
        this.f36952y = i4;
        ResizeSurfaceView resizeSurfaceView = this.f36931d;
        if (resizeSurfaceView != null) {
            resizeSurfaceView.setScreenScale(i4);
        }
        ResizeTextureView resizeTextureView = this.f36932e;
        if (resizeTextureView != null) {
            resizeTextureView.setScreenScale(i4);
        }
        return this;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public void d() {
        if (com.devlin_n.floatWindowPermission.b.f().c(getContext())) {
            i0();
        } else {
            com.devlin_n.floatWindowPermission.b.f().b(getContext());
        }
    }

    public IjkVideoView d0(String str) {
        if (str != null) {
            this.f36948u = str;
        }
        return this;
    }

    public IjkVideoView e0(String str) {
        this.f36944q = str;
        return this;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public void f() {
        if (this.f36940m) {
            c1.f.o(getContext(), true, true);
            c1.f.m(getContext());
            ((ViewGroup) c1.f.l(getContext()).findViewById(16908290)).removeView(this.f36937j);
            addView(this.f36937j, new FrameLayout.LayoutParams(-1, -1));
            this.f36940m = false;
            BaseVideoController baseVideoController = this.f36929b;
            if (baseVideoController != null) {
                baseVideoController.setPlayerState(10);
            }
        }
    }

    public IjkVideoView f0(BaseVideoController baseVideoController) {
        this.f36937j.removeView(this.f36929b);
        if (baseVideoController != null) {
            baseVideoController.setMediaPlayer(this);
            this.f36929b = baseVideoController;
            this.f36937j.addView(this.f36929b, new FrameLayout.LayoutParams(-1, -1));
        }
        return this;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public void g() {
        StubApp.getOrigApplicationContext(getContext().getApplicationContext()).stopService(new Intent(getContext(), BackgroundPlayService.class));
    }

    public IjkVideoView g0(List<com.devlin_n.videoplayer.player.b> list) {
        this.f36945r = list;
        Y();
        return this;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public int getBufferPercentage() {
        if (this.f36928a != null) {
            return this.f36939l;
        }
        return 0;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public int getCurrentPosition() {
        if (W()) {
            int currentPosition = (int) this.f36928a.getCurrentPosition();
            this.f36947t = currentPosition;
            return currentPosition;
        }
        return 0;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public int getDuration() {
        if (W()) {
            return (int) this.f36928a.getDuration();
        }
        return 0;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public String getTitle() {
        return this.f36948u;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public void h() {
        if (this.f36941n) {
            this.f36928a.setVolume(1.0f, 1.0f);
            this.f36941n = false;
            return;
        }
        this.f36928a.setVolume(0.0f, 0.0f);
        this.f36941n = true;
    }

    public IjkVideoView h0(String str, int i4) {
        this.f36944q = str;
        this.f36947t = i4;
        return this;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public void i() {
        if (this.f36940m) {
            return;
        }
        c1.f.k(getContext(), true, true);
        c1.f.i(getContext());
        removeView(this.f36937j);
        ((ViewGroup) c1.f.l(getContext()).findViewById(16908290)).addView(this.f36937j, new FrameLayout.LayoutParams(-1, -1));
        this.f36940m = true;
        BaseVideoController baseVideoController = this.f36929b;
        if (baseVideoController != null) {
            baseVideoController.setPlayerState(11);
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public boolean isMute() {
        return this.f36941n;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public boolean isPlaying() {
        IMediaPlayer iMediaPlayer = this.f36928a;
        return iMediaPlayer != null && iMediaPlayer.isPlaying();
    }

    public void k0() {
        IMediaPlayer iMediaPlayer = this.f36928a;
        if (iMediaPlayer != null) {
            iMediaPlayer.stop();
            this.f36928a.release();
            this.f36928a = null;
            this.f36949v = 0;
            BaseVideoController baseVideoController = this.f36929b;
            if (baseVideoController != null) {
                baseVideoController.setPlayState(0);
            }
            this.f36951x.a();
            setKeepScreenOn(false);
        }
    }

    public IjkVideoView l0() {
        this.f36943p = true;
        return this;
    }

    public IjkVideoView m0() {
        this.f36942o = true;
        return this;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public void pause() {
        if (W()) {
            if (this.f36928a.isPlaying()) {
                this.f36928a.pause();
                this.f36949v = 4;
                BaseVideoController baseVideoController = this.f36929b;
                if (baseVideoController != null) {
                    baseVideoController.setPlayState(4);
                }
                setKeepScreenOn(false);
                this.f36951x.a();
            }
            DanmakuView danmakuView = this.f36934g;
            if (danmakuView == null || !danmakuView.isPrepared()) {
                return;
            }
            this.f36934g.pause();
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public void seekTo(int i4) {
        if (W()) {
            long j4 = i4;
            this.f36928a.seekTo(j4);
            DanmakuView danmakuView = this.f36934g;
            if (danmakuView != null) {
                danmakuView.h(Long.valueOf(j4));
            }
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public void setLock(boolean z3) {
        this.B = z3;
    }

    public void setVideoListener(b1.d dVar) {
        this.f36930c = dVar;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public void start() {
        OrientationEventListener orientationEventListener;
        if (this.f36949v == 0) {
            if (this.C) {
                c();
            }
            if (this.E) {
                com.devlin_n.videoplayer.player.c.b().d();
                com.devlin_n.videoplayer.player.c.b().e(this);
            }
            if (this.A && (orientationEventListener = this.f36953z) != null) {
                orientationEventListener.enable();
            }
            if (S()) {
                return;
            }
            U();
            j0();
        } else if (W()) {
            this.f36928a.start();
            this.f36949v = 3;
            BaseVideoController baseVideoController = this.f36929b;
            if (baseVideoController != null) {
                baseVideoController.setPlayState(3);
            }
            DanmakuView danmakuView = this.f36934g;
            if (danmakuView != null && danmakuView.isPrepared() && this.f36934g.isPaused()) {
                this.f36934g.resume();
            }
        }
        setKeepScreenOn(true);
        this.f36951x.b();
    }

    public IjkVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36946s = 0;
        this.f36948u = "";
        this.f36949v = 0;
        this.f36951x = new m(this, null);
        this.f36952y = 0;
        this.F = new h();
        this.G = new i();
        this.H = new j();
        this.I = new k();
        this.J = new l();
        this.K = new a();
        this.f36927L = new b();
        V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class m implements AudioManager.OnAudioFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        boolean f36971a;

        /* renamed from: b  reason: collision with root package name */
        boolean f36972b;

        /* renamed from: c  reason: collision with root package name */
        int f36973c;

        private m() {
            this.f36971a = false;
            this.f36972b = false;
            this.f36973c = 0;
        }

        boolean a() {
            if (IjkVideoView.this.f36950w == null) {
                return false;
            }
            this.f36971a = false;
            return 1 == IjkVideoView.this.f36950w.abandonAudioFocus(this);
        }

        boolean b() {
            if (this.f36973c == 1) {
                return true;
            }
            if (IjkVideoView.this.f36950w == null) {
                return false;
            }
            if (1 == IjkVideoView.this.f36950w.requestAudioFocus(this, 3, 1)) {
                this.f36973c = 1;
                return true;
            }
            this.f36971a = true;
            return false;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i4) {
            if (this.f36973c == i4) {
                return;
            }
            this.f36973c = i4;
            if (i4 == -3 || i4 == -2) {
                if (IjkVideoView.this.isPlaying()) {
                    this.f36972b = true;
                    IjkVideoView.this.pause();
                }
            } else if (i4 == -1) {
                if (IjkVideoView.this.isPlaying()) {
                    this.f36972b = true;
                    IjkVideoView.this.pause();
                }
            } else if (i4 == 1 || i4 == 2) {
                if (this.f36971a || this.f36972b) {
                    IjkVideoView.this.start();
                    this.f36971a = false;
                    this.f36972b = false;
                }
            }
        }

        /* synthetic */ m(IjkVideoView ijkVideoView, d dVar) {
            this();
        }
    }
}

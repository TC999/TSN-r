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
import androidx.core.view.ViewCompat;
import com.danikula.videocache.C6556i;
import com.danikula.videocache.InterfaceC6542e;
import com.devlin_n.floatWindowPermission.FloatWindowManager;
import com.devlin_n.videoplayer.C6596R;
import com.devlin_n.videoplayer.controller.BaseVideoController;
import com.devlin_n.videoplayer.widget.ResizeSurfaceView;
import com.devlin_n.videoplayer.widget.ResizeTextureView;
import com.devlin_n.videoplayer.widget.StatusView;
import com.stub.StubApp;
import java.io.File;
import java.io.IOException;
import java.util.List;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;
import master.flame.danmaku.p621ui.widget.DanmakuView;
import p597h0.VideoListener;
import p601i0.C13583a;
import p601i0.C13584f;
import p601i0.KeyUtil;
import p601i0.NetworkUtil;
import tv.danmaku.ijk.media.player.AndroidMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class IjkVideoView extends FrameLayout implements BaseVideoController.InterfaceC6607d {

    /* renamed from: A0 */
    public static final int f23304A0 = 1;

    /* renamed from: B0 */
    public static final int f23305B0 = 2;

    /* renamed from: C0 */
    public static final int f23306C0 = 3;

    /* renamed from: D0 */
    public static final int f23307D0 = 4;

    /* renamed from: M */
    public static final int f23308M = -1;

    /* renamed from: N */
    public static final int f23309N = 0;

    /* renamed from: O */
    public static final int f23310O = 1;

    /* renamed from: P */
    public static final int f23311P = 2;

    /* renamed from: Q */
    public static final int f23312Q = 3;

    /* renamed from: R */
    public static final int f23313R = 4;

    /* renamed from: S */
    public static final int f23314S = 5;

    /* renamed from: T */
    public static final int f23315T = 6;

    /* renamed from: U */
    public static final int f23316U = 7;

    /* renamed from: V */
    public static final int f23317V = 10;

    /* renamed from: W */
    public static final int f23318W = 11;

    /* renamed from: p0 */
    public static final int f23319p0 = 0;

    /* renamed from: A */
    protected boolean f23320A;

    /* renamed from: B */
    private boolean f23321B;

    /* renamed from: C */
    private boolean f23322C;

    /* renamed from: D */
    private boolean f23323D;

    /* renamed from: E */
    private boolean f23324E;

    /* renamed from: F */
    private IMediaPlayer.OnErrorListener f23325F;

    /* renamed from: G */
    private IMediaPlayer.OnCompletionListener f23326G;

    /* renamed from: H */
    private IMediaPlayer.OnInfoListener f23327H;

    /* renamed from: I */
    private IMediaPlayer.OnBufferingUpdateListener f23328I;

    /* renamed from: J */
    private IMediaPlayer.OnPreparedListener f23329J;

    /* renamed from: K */
    private IMediaPlayer.OnVideoSizeChangedListener f23330K;

    /* renamed from: L */
    private InterfaceC6542e f23331L;

    /* renamed from: a */
    private IMediaPlayer f23332a;
    @Nullable

    /* renamed from: b */
    private BaseVideoController f23333b;

    /* renamed from: c */
    private VideoListener f23334c;

    /* renamed from: d */
    private ResizeSurfaceView f23335d;

    /* renamed from: e */
    private ResizeTextureView f23336e;

    /* renamed from: f */
    private SurfaceTexture f23337f;

    /* renamed from: g */
    private DanmakuView f23338g;

    /* renamed from: h */
    private DanmakuContext f23339h;

    /* renamed from: i */
    private BaseDanmakuParser f23340i;

    /* renamed from: j */
    private FrameLayout f23341j;

    /* renamed from: k */
    private StatusView f23342k;

    /* renamed from: l */
    private int f23343l;

    /* renamed from: m */
    private boolean f23344m;

    /* renamed from: n */
    private boolean f23345n;

    /* renamed from: o */
    private boolean f23346o;

    /* renamed from: p */
    private boolean f23347p;

    /* renamed from: q */
    private String f23348q;

    /* renamed from: r */
    private List<VideoModel> f23349r;

    /* renamed from: s */
    private int f23350s;

    /* renamed from: t */
    private int f23351t;

    /* renamed from: u */
    private String f23352u;

    /* renamed from: v */
    private int f23353v;

    /* renamed from: w */
    private AudioManager f23354w;
    @NonNull

    /* renamed from: x */
    private C6629m f23355x;

    /* renamed from: y */
    private int f23356y;

    /* renamed from: z */
    protected OrientationEventListener f23357z;

    /* renamed from: com.devlin_n.videoplayer.player.IjkVideoView$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C6616a implements IMediaPlayer.OnVideoSizeChangedListener {
        C6616a() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
            int videoWidth = iMediaPlayer.getVideoWidth();
            int videoHeight = iMediaPlayer.getVideoHeight();
            if (videoWidth == 0 || videoHeight == 0) {
                return;
            }
            if (IjkVideoView.this.f23346o) {
                IjkVideoView.this.f23335d.setScreenScale(IjkVideoView.this.f23356y);
                IjkVideoView.this.f23335d.m35668a(videoWidth, videoHeight);
                return;
            }
            IjkVideoView.this.f23336e.setScreenScale(IjkVideoView.this.f23356y);
            IjkVideoView.this.f23336e.m35667a(videoWidth, videoHeight);
        }
    }

    /* renamed from: com.devlin_n.videoplayer.player.IjkVideoView$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C6617b implements InterfaceC6542e {
        C6617b() {
        }

        @Override // com.danikula.videocache.InterfaceC6542e
        /* renamed from: a */
        public void mo35682a(File file, String str, int i) {
            IjkVideoView.this.f23343l = i;
        }
    }

    /* renamed from: com.devlin_n.videoplayer.player.IjkVideoView$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C6618c extends OrientationEventListener {

        /* renamed from: c */
        private static final int f23360c = 1;

        /* renamed from: d */
        private static final int f23361d = 2;

        /* renamed from: e */
        private static final int f23362e = 3;

        /* renamed from: a */
        private int f23363a;

        C6618c(Context context) {
            super(context);
            this.f23363a = 0;
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i) {
            int i2;
            int i3;
            if (i >= 340) {
                if (IjkVideoView.this.f23321B || IjkVideoView.this.f23322C || (i3 = this.f23363a) == 1) {
                    return;
                }
                if ((i3 == 2 || i3 == 3) && !IjkVideoView.this.mo35720b()) {
                    this.f23363a = 1;
                    return;
                }
                this.f23363a = 1;
                C13584f.m12699l(IjkVideoView.this.getContext()).setRequestedOrientation(1);
                IjkVideoView.this.mo35712f();
            } else if (i >= 260 && i <= 280) {
                int i4 = this.f23363a;
                if (i4 == 2) {
                    return;
                }
                if (i4 == 1 && IjkVideoView.this.mo35720b()) {
                    this.f23363a = 2;
                    return;
                }
                this.f23363a = 2;
                if (!IjkVideoView.this.mo35720b()) {
                    IjkVideoView.this.mo35704j();
                }
                C13584f.m12699l(IjkVideoView.this.getContext()).setRequestedOrientation(0);
            } else if (i < 70 || i > 90 || (i2 = this.f23363a) == 3) {
            } else {
                if (i2 == 1 && IjkVideoView.this.mo35720b()) {
                    this.f23363a = 3;
                    return;
                }
                this.f23363a = 3;
                if (!IjkVideoView.this.mo35720b()) {
                    IjkVideoView.this.mo35704j();
                }
                C13584f.m12699l(IjkVideoView.this.getContext()).setRequestedOrientation(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.devlin_n.videoplayer.player.IjkVideoView$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class SurfaceHolder$CallbackC6619d implements SurfaceHolder.Callback {
        SurfaceHolder$CallbackC6619d() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            if (IjkVideoView.this.f23332a != null) {
                IjkVideoView.this.f23332a.setDisplay(surfaceHolder);
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
    /* renamed from: com.devlin_n.videoplayer.player.IjkVideoView$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class TextureView$SurfaceTextureListenerC6620e implements TextureView.SurfaceTextureListener {
        TextureView$SurfaceTextureListenerC6620e() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            if (IjkVideoView.this.f23337f != null) {
                IjkVideoView.this.f23336e.setSurfaceTexture(IjkVideoView.this.f23337f);
                return;
            }
            IjkVideoView.this.f23337f = surfaceTexture;
            IjkVideoView.this.f23332a.setSurface(new Surface(surfaceTexture));
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return IjkVideoView.this.f23337f == null;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.devlin_n.videoplayer.player.IjkVideoView$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class View$OnClickListenerC6621f implements View.OnClickListener {
        View$OnClickListenerC6621f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C13583a.f40165d = true;
            IjkVideoView.this.f23341j.removeView(IjkVideoView.this.f23342k);
            IjkVideoView.this.m35727V();
            IjkVideoView.this.m35701k0();
        }
    }

    /* renamed from: com.devlin_n.videoplayer.player.IjkVideoView$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class RunnableC6622g implements Runnable {
        RunnableC6622g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IjkVideoView.this.f23332a.reset();
            IjkVideoView.this.f23332a.release();
            IjkVideoView.this.f23332a = null;
        }
    }

    /* renamed from: com.devlin_n.videoplayer.player.IjkVideoView$h */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C6623h implements IMediaPlayer.OnErrorListener {

        /* renamed from: com.devlin_n.videoplayer.player.IjkVideoView$h$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class View$OnClickListenerC6624a implements View.OnClickListener {
            View$OnClickListenerC6624a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IjkVideoView.this.f23341j.removeView(IjkVideoView.this.f23342k);
                IjkVideoView.this.m35719b0();
                IjkVideoView.this.m35701k0();
            }
        }

        C6623h() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
        public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
            IjkVideoView.this.f23353v = -1;
            if (IjkVideoView.this.f23334c != null) {
                IjkVideoView.this.f23334c.onError();
            }
            if (IjkVideoView.this.f23333b != null) {
                IjkVideoView.this.f23333b.setPlayState(IjkVideoView.this.f23353v);
            }
            IjkVideoView ijkVideoView = IjkVideoView.this;
            ijkVideoView.f23351t = ijkVideoView.getCurrentPosition();
            IjkVideoView.this.f23341j.removeView(IjkVideoView.this.f23342k);
            if (IjkVideoView.this.f23342k == null) {
                IjkVideoView.this.f23342k = new StatusView(IjkVideoView.this.getContext());
            }
            IjkVideoView.this.f23342k.setMessage(IjkVideoView.this.getResources().getString(C6596R.C6602string.error_message));
            IjkVideoView.this.f23342k.m35665b(IjkVideoView.this.getResources().getString(C6596R.C6602string.retry), new View$OnClickListenerC6624a());
            IjkVideoView.this.f23341j.addView(IjkVideoView.this.f23342k);
            return true;
        }
    }

    /* renamed from: com.devlin_n.videoplayer.player.IjkVideoView$i */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C6625i implements IMediaPlayer.OnCompletionListener {
        C6625i() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
        public void onCompletion(IMediaPlayer iMediaPlayer) {
            IjkVideoView.this.f23353v = 5;
            if (IjkVideoView.this.f23334c != null) {
                IjkVideoView.this.f23334c.onComplete();
            }
            if (IjkVideoView.this.f23333b != null) {
                IjkVideoView.this.f23333b.setPlayState(IjkVideoView.this.f23353v);
            }
            IjkVideoView.this.setKeepScreenOn(false);
            IjkVideoView.m35691r(IjkVideoView.this);
            if (IjkVideoView.this.f23349r == null || IjkVideoView.this.f23349r.size() <= 1 || IjkVideoView.this.f23350s >= IjkVideoView.this.f23349r.size()) {
                return;
            }
            IjkVideoView.this.m35723Z();
            IjkVideoView.this.m35719b0();
            IjkVideoView.this.m35701k0();
        }
    }

    /* renamed from: com.devlin_n.videoplayer.player.IjkVideoView$j */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C6626j implements IMediaPlayer.OnInfoListener {
        C6626j() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
        public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
            if (IjkVideoView.this.f23334c != null) {
                IjkVideoView.this.f23334c.mo12729a(i, i2);
            }
            if (i == 3) {
                if (IjkVideoView.this.getWindowVisibility() != 0) {
                    IjkVideoView.this.pause();
                    return true;
                }
                return true;
            } else if (i == 10001) {
                if (IjkVideoView.this.f23336e != null) {
                    IjkVideoView.this.f23336e.setRotation(i2);
                    return true;
                }
                return true;
            } else if (i == 701) {
                IjkVideoView.this.f23353v = 6;
                if (IjkVideoView.this.f23333b != null) {
                    IjkVideoView.this.f23333b.setPlayState(IjkVideoView.this.f23353v);
                    return true;
                }
                return true;
            } else if (i != 702) {
                return true;
            } else {
                IjkVideoView.this.f23353v = 7;
                if (IjkVideoView.this.f23333b != null) {
                    IjkVideoView.this.f23333b.setPlayState(IjkVideoView.this.f23353v);
                    return true;
                }
                return true;
            }
        }
    }

    /* renamed from: com.devlin_n.videoplayer.player.IjkVideoView$k */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C6627k implements IMediaPlayer.OnBufferingUpdateListener {
        C6627k() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
            if (IjkVideoView.this.f23323D) {
                return;
            }
            IjkVideoView.this.f23343l = i;
        }
    }

    /* renamed from: com.devlin_n.videoplayer.player.IjkVideoView$l */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C6628l implements IMediaPlayer.OnPreparedListener {
        C6628l() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
        public void onPrepared(IMediaPlayer iMediaPlayer) {
            IjkVideoView.this.f23353v = 2;
            if (IjkVideoView.this.f23334c != null) {
                IjkVideoView.this.f23334c.mo12728b();
            }
            if (IjkVideoView.this.f23333b != null) {
                IjkVideoView.this.f23333b.setPlayState(IjkVideoView.this.f23353v);
            }
            if (IjkVideoView.this.f23351t > 0) {
                IjkVideoView ijkVideoView = IjkVideoView.this;
                ijkVideoView.seekTo(ijkVideoView.f23351t);
            }
            IjkVideoView.this.start();
        }
    }

    public IjkVideoView(@NonNull Context context) {
        this(context, null);
    }

    /* renamed from: O */
    private void m35734O() {
        this.f23341j.removeView(this.f23335d);
        ResizeSurfaceView resizeSurfaceView = new ResizeSurfaceView(getContext());
        this.f23335d = resizeSurfaceView;
        SurfaceHolder holder = resizeSurfaceView.getHolder();
        holder.addCallback(new SurfaceHolder$CallbackC6619d());
        holder.setFormat(1);
        this.f23341j.addView(this.f23335d, 0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    /* renamed from: P */
    private void m35733P() {
        this.f23341j.removeView(this.f23336e);
        this.f23337f = null;
        ResizeTextureView resizeTextureView = new ResizeTextureView(getContext());
        this.f23336e = resizeTextureView;
        resizeTextureView.setSurfaceTextureListener(new TextureView$SurfaceTextureListenerC6620e());
        this.f23341j.addView(this.f23336e, 0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    /* renamed from: T */
    private boolean m35729T() {
        if (NetworkUtil.m12716a(getContext()) != 4 || C13583a.f40165d) {
            return false;
        }
        this.f23341j.removeView(this.f23342k);
        if (this.f23342k == null) {
            this.f23342k = new StatusView(getContext());
        }
        this.f23342k.setMessage(getResources().getString(C6596R.C6602string.wifi_tip));
        this.f23342k.m35665b(getResources().getString(C6596R.C6602string.continue_play), new View$OnClickListenerC6621f());
        this.f23341j.addView(this.f23342k);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V */
    public void m35727V() {
        if (this.f23332a == null) {
            if (this.f23347p) {
                this.f23332a = new AndroidMediaPlayer();
            } else {
                IjkMediaPlayer ijkMediaPlayer = new IjkMediaPlayer();
                this.f23332a = ijkMediaPlayer;
                ijkMediaPlayer.setOption(4, "mediacodec", 1L);
                ((IjkMediaPlayer) this.f23332a).setOption(4, "mediacodec-auto-rotate", 1L);
                ((IjkMediaPlayer) this.f23332a).setOption(4, "mediacodec-handle-resolution-change", 1L);
            }
            this.f23354w = (AudioManager) StubApp.getOrigApplicationContext(getContext().getApplicationContext()).getSystemService("audio");
            this.f23332a.setAudioStreamType(3);
            this.f23332a.setOnErrorListener(this.f23325F);
            this.f23332a.setOnCompletionListener(this.f23326G);
            this.f23332a.setOnInfoListener(this.f23327H);
            this.f23332a.setOnBufferingUpdateListener(this.f23328I);
            this.f23332a.setOnPreparedListener(this.f23329J);
            this.f23332a.setOnVideoSizeChangedListener(this.f23330K);
            this.f23353v = 0;
            BaseVideoController baseVideoController = this.f23333b;
            if (baseVideoController != null) {
                baseVideoController.setPlayState(0);
            }
        }
        if (this.f23346o) {
            m35734O();
        } else {
            m35733P();
        }
        DanmakuView danmakuView = this.f23338g;
        if (danmakuView != null) {
            this.f23341j.removeView(danmakuView);
            this.f23341j.addView(this.f23338g, 1);
        }
    }

    /* renamed from: W */
    private void m35726W() {
        C13583a.f40163b = C13584f.m12707d(getContext(), false);
        C13583a.f40162a = C13584f.m12706e(getContext());
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f23341j = frameLayout;
        frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.f23341j, new FrameLayout.LayoutParams(-1, -1));
    }

    /* renamed from: X */
    private boolean m35725X() {
        int i;
        return (this.f23332a == null || (i = this.f23353v) == -1 || i == 0 || i == 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z */
    public void m35723Z() {
        VideoModel videoModel = this.f23349r.get(this.f23350s);
        if (videoModel != null) {
            this.f23348q = videoModel.f23380a;
            this.f23352u = videoModel.f23381b;
            this.f23351t = 0;
            m35709g0(videoModel.f23382c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b0 */
    public void m35719b0() {
        this.f23332a.reset();
        IMediaPlayer iMediaPlayer = this.f23332a;
        if (iMediaPlayer instanceof IjkMediaPlayer) {
            m35727V();
            return;
        }
        iMediaPlayer.setVolume(1.0f, 1.0f);
        this.f23332a.setOnErrorListener(this.f23325F);
        this.f23332a.setOnCompletionListener(this.f23326G);
        this.f23332a.setOnInfoListener(this.f23327H);
        this.f23332a.setOnBufferingUpdateListener(this.f23328I);
        this.f23332a.setOnPreparedListener(this.f23329J);
        this.f23332a.setOnVideoSizeChangedListener(this.f23330K);
    }

    private C6556i getCacheServer() {
        return VideoCacheManager.m35677c(StubApp.getOrigApplicationContext(getContext().getApplicationContext()));
    }

    /* renamed from: j0 */
    private void m35703j0() {
        if (m35725X()) {
            Intent intent = new Intent(getContext(), BackgroundPlayService.class);
            intent.putExtra("url", this.f23348q);
            getCurrentPosition();
            intent.putExtra("position", getDuration() <= 0 ? 0 : this.f23351t);
            intent.putExtra(KeyUtil.f40168c, this.f23323D);
            StubApp.getOrigApplicationContext(getContext().getApplicationContext()).startService(intent);
            C13584f.m12699l(getContext()).finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0 */
    public void m35701k0() {
        String str = this.f23348q;
        if (str == null || str.trim().equals("")) {
            return;
        }
        try {
            if (this.f23323D) {
                C6556i cacheServer = getCacheServer();
                String m35905j = cacheServer.m35905j(this.f23348q);
                cacheServer.m35899p(this.f23331L, this.f23348q);
                if (cacheServer.m35902m(this.f23348q)) {
                    this.f23343l = 100;
                }
                this.f23332a.setDataSource(m35905j);
            } else {
                this.f23332a.setDataSource(this.f23348q);
            }
            this.f23332a.prepareAsync();
            this.f23353v = 1;
            BaseVideoController baseVideoController = this.f23333b;
            if (baseVideoController != null) {
                baseVideoController.setPlayState(1);
                this.f23333b.setPlayerState(this.f23344m ? 11 : 10);
            }
            DanmakuView danmakuView = this.f23338g;
            if (danmakuView != null) {
                danmakuView.mo2924i(this.f23340i, this.f23339h);
            }
        } catch (IOException e) {
            this.f23353v = -1;
            BaseVideoController baseVideoController2 = this.f23333b;
            if (baseVideoController2 != null) {
                baseVideoController2.setPlayState(-1);
            }
            e.printStackTrace();
        }
    }

    /* renamed from: r */
    static /* synthetic */ int m35691r(IjkVideoView ijkVideoView) {
        int i = ijkVideoView.f23350s;
        ijkVideoView.f23350s = i + 1;
        return i;
    }

    /* renamed from: N */
    public IjkVideoView m35735N(DanmakuView danmakuView, DanmakuContext danmakuContext, BaseDanmakuParser baseDanmakuParser) {
        this.f23338g = danmakuView;
        this.f23339h = danmakuContext;
        this.f23340i = baseDanmakuParser;
        return this;
    }

    /* renamed from: Q */
    public IjkVideoView m35732Q() {
        this.f23324E = true;
        return this;
    }

    /* renamed from: R */
    public IjkVideoView m35731R() {
        this.f23322C = true;
        return this;
    }

    /* renamed from: S */
    public IjkVideoView m35730S() {
        this.f23320A = true;
        if (this.f23357z == null) {
            this.f23357z = new C6618c(getContext());
        }
        return this;
    }

    /* renamed from: U */
    public IjkVideoView m35728U() {
        this.f23323D = true;
        return this;
    }

    /* renamed from: Y */
    public boolean m35724Y() {
        BaseVideoController baseVideoController = this.f23333b;
        if (baseVideoController != null && this.f23321B) {
            baseVideoController.mo35758g();
            Toast.makeText(getContext(), C6596R.C6602string.lock_tip, 0).show();
            return true;
        } else if (!this.f23322C && this.f23344m) {
            C13584f.m12699l(getContext()).setRequestedOrientation(1);
            mo35712f();
            BaseVideoController baseVideoController2 = this.f23333b;
            if (baseVideoController2 != null) {
                baseVideoController2.setPlayerState(10);
            }
            return true;
        } else {
            return false;
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.InterfaceC6607d
    /* renamed from: a */
    public void mo35722a() {
        this.f23350s++;
        List<VideoModel> list = this.f23349r;
        if (list == null || list.size() <= 1 || this.f23350s >= this.f23349r.size()) {
            return;
        }
        m35723Z();
        m35719b0();
        m35701k0();
    }

    /* renamed from: a0 */
    public void m35721a0() {
        if (this.f23332a != null) {
            new Thread(new RunnableC6622g()).start();
            this.f23353v = 0;
            BaseVideoController baseVideoController = this.f23333b;
            if (baseVideoController != null) {
                baseVideoController.setPlayState(0);
            }
            this.f23355x.m35681a();
            setKeepScreenOn(false);
        }
        DanmakuView danmakuView = this.f23338g;
        if (danmakuView != null) {
            danmakuView.release();
            this.f23338g = null;
        }
        OrientationEventListener orientationEventListener = this.f23357z;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        if (this.f23323D) {
            getCacheServer().m35894u(this.f23331L);
        }
        this.f23341j.removeView(this.f23336e);
        this.f23341j.removeView(this.f23335d);
        this.f23341j.removeView(this.f23342k);
        SurfaceTexture surfaceTexture = this.f23337f;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f23337f = null;
        }
        this.f23321B = false;
        this.f23351t = 0;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.InterfaceC6607d
    /* renamed from: b */
    public boolean mo35720b() {
        return this.f23344m;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.InterfaceC6607d
    /* renamed from: c */
    public void mo35718c() {
        C13584f.m12699l(getContext()).setRequestedOrientation(0);
        mo35704j();
    }

    /* renamed from: c0 */
    public void m35717c0() {
        if (m35725X() && !this.f23332a.isPlaying() && this.f23353v != 5) {
            this.f23332a.start();
            this.f23353v = 3;
            BaseVideoController baseVideoController = this.f23333b;
            if (baseVideoController != null) {
                baseVideoController.setPlayState(3);
            }
            this.f23355x.m35680b();
            setKeepScreenOn(true);
        }
        DanmakuView danmakuView = this.f23338g;
        if (danmakuView != null && danmakuView.isPrepared() && this.f23338g.isPaused()) {
            this.f23338g.resume();
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.InterfaceC6607d
    /* renamed from: d */
    public void mo35716d() {
        if (FloatWindowManager.m35819f().m35822c(getContext())) {
            m35703j0();
        } else {
            FloatWindowManager.m35819f().m35823b(getContext());
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.InterfaceC6607d
    /* renamed from: d0 */
    public IjkVideoView mo35714e(int i) {
        this.f23356y = i;
        ResizeSurfaceView resizeSurfaceView = this.f23335d;
        if (resizeSurfaceView != null) {
            resizeSurfaceView.setScreenScale(i);
        }
        ResizeTextureView resizeTextureView = this.f23336e;
        if (resizeTextureView != null) {
            resizeTextureView.setScreenScale(i);
        }
        return this;
    }

    /* renamed from: e0 */
    public IjkVideoView m35713e0(String str) {
        if (str != null) {
            this.f23352u = str;
        }
        return this;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.InterfaceC6607d
    /* renamed from: f */
    public void mo35712f() {
        if (this.f23344m) {
            C13584f.m12696o(getContext(), true, true);
            C13584f.m12698m(getContext());
            ((ViewGroup) C13584f.m12699l(getContext()).findViewById(16908290)).removeView(this.f23341j);
            addView(this.f23341j, new FrameLayout.LayoutParams(-1, -1));
            this.f23344m = false;
            BaseVideoController baseVideoController = this.f23333b;
            if (baseVideoController != null) {
                baseVideoController.setPlayerState(10);
            }
        }
    }

    /* renamed from: f0 */
    public IjkVideoView m35711f0(String str) {
        this.f23348q = str;
        return this;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.InterfaceC6607d
    /* renamed from: g */
    public boolean mo35710g() {
        return this.f23345n;
    }

    /* renamed from: g0 */
    public IjkVideoView m35709g0(BaseVideoController baseVideoController) {
        this.f23341j.removeView(this.f23333b);
        if (baseVideoController != null) {
            baseVideoController.setMediaPlayer(this);
            this.f23333b = baseVideoController;
            this.f23341j.addView(this.f23333b, new FrameLayout.LayoutParams(-1, -1));
        }
        return this;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.InterfaceC6607d
    public int getBufferPercentage() {
        if (this.f23332a != null) {
            return this.f23343l;
        }
        return 0;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.InterfaceC6607d
    public int getCurrentPosition() {
        if (m35725X()) {
            int currentPosition = (int) this.f23332a.getCurrentPosition();
            this.f23351t = currentPosition;
            return currentPosition;
        }
        return 0;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.InterfaceC6607d
    public int getDuration() {
        if (m35725X()) {
            return (int) this.f23332a.getDuration();
        }
        return 0;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.InterfaceC6607d
    public String getTitle() {
        return this.f23352u;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.InterfaceC6607d
    /* renamed from: h */
    public void mo35708h() {
        StubApp.getOrigApplicationContext(getContext().getApplicationContext()).stopService(new Intent(getContext(), BackgroundPlayService.class));
    }

    /* renamed from: h0 */
    public IjkVideoView m35707h0(List<VideoModel> list) {
        this.f23349r = list;
        m35723Z();
        return this;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.InterfaceC6607d
    /* renamed from: i */
    public void mo35706i() {
        if (this.f23345n) {
            this.f23332a.setVolume(1.0f, 1.0f);
            this.f23345n = false;
            return;
        }
        this.f23332a.setVolume(0.0f, 0.0f);
        this.f23345n = true;
    }

    /* renamed from: i0 */
    public IjkVideoView m35705i0(String str, int i) {
        this.f23348q = str;
        this.f23351t = i;
        return this;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.InterfaceC6607d
    public boolean isPlaying() {
        IMediaPlayer iMediaPlayer = this.f23332a;
        return iMediaPlayer != null && iMediaPlayer.isPlaying();
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.InterfaceC6607d
    /* renamed from: j */
    public void mo35704j() {
        if (this.f23344m) {
            return;
        }
        C13584f.m12700k(getContext(), true, true);
        C13584f.m12702i(getContext());
        removeView(this.f23341j);
        ((ViewGroup) C13584f.m12699l(getContext()).findViewById(16908290)).addView(this.f23341j, new FrameLayout.LayoutParams(-1, -1));
        this.f23344m = true;
        BaseVideoController baseVideoController = this.f23333b;
        if (baseVideoController != null) {
            baseVideoController.setPlayerState(11);
        }
    }

    /* renamed from: l0 */
    public void m35699l0() {
        IMediaPlayer iMediaPlayer = this.f23332a;
        if (iMediaPlayer != null) {
            iMediaPlayer.stop();
            this.f23332a.release();
            this.f23332a = null;
            this.f23353v = 0;
            BaseVideoController baseVideoController = this.f23333b;
            if (baseVideoController != null) {
                baseVideoController.setPlayState(0);
            }
            this.f23355x.m35681a();
            setKeepScreenOn(false);
        }
    }

    /* renamed from: m0 */
    public IjkVideoView m35697m0() {
        this.f23347p = true;
        return this;
    }

    /* renamed from: n0 */
    public IjkVideoView m35695n0() {
        this.f23346o = true;
        return this;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.InterfaceC6607d
    public void pause() {
        if (m35725X()) {
            if (this.f23332a.isPlaying()) {
                this.f23332a.pause();
                this.f23353v = 4;
                BaseVideoController baseVideoController = this.f23333b;
                if (baseVideoController != null) {
                    baseVideoController.setPlayState(4);
                }
                setKeepScreenOn(false);
                this.f23355x.m35681a();
            }
            DanmakuView danmakuView = this.f23338g;
            if (danmakuView == null || !danmakuView.isPrepared()) {
                return;
            }
            this.f23338g.pause();
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.InterfaceC6607d
    public void seekTo(int i) {
        if (m35725X()) {
            long j = i;
            this.f23332a.seekTo(j);
            DanmakuView danmakuView = this.f23338g;
            if (danmakuView != null) {
                danmakuView.mo2925h(Long.valueOf(j));
            }
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.InterfaceC6607d
    public void setLock(boolean z) {
        this.f23321B = z;
    }

    public void setVideoListener(VideoListener videoListener) {
        this.f23334c = videoListener;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.InterfaceC6607d
    public void start() {
        OrientationEventListener orientationEventListener;
        if (this.f23353v == 0) {
            if (this.f23322C) {
                mo35718c();
            }
            if (this.f23324E) {
                VideoViewManager.m35674b().m35672d();
                VideoViewManager.m35674b().m35671e(this);
            }
            if (this.f23320A && (orientationEventListener = this.f23357z) != null) {
                orientationEventListener.enable();
            }
            if (m35729T()) {
                return;
            }
            m35727V();
            m35701k0();
        } else if (m35725X()) {
            this.f23332a.start();
            this.f23353v = 3;
            BaseVideoController baseVideoController = this.f23333b;
            if (baseVideoController != null) {
                baseVideoController.setPlayState(3);
            }
            DanmakuView danmakuView = this.f23338g;
            if (danmakuView != null && danmakuView.isPrepared() && this.f23338g.isPaused()) {
                this.f23338g.resume();
            }
        }
        setKeepScreenOn(true);
        this.f23355x.m35680b();
    }

    public IjkVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23350s = 0;
        this.f23352u = "";
        this.f23353v = 0;
        this.f23355x = new C6629m(this, null);
        this.f23356y = 0;
        this.f23325F = new C6623h();
        this.f23326G = new C6625i();
        this.f23327H = new C6626j();
        this.f23328I = new C6627k();
        this.f23329J = new C6628l();
        this.f23330K = new C6616a();
        this.f23331L = new C6617b();
        m35726W();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.devlin_n.videoplayer.player.IjkVideoView$m */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C6629m implements AudioManager.OnAudioFocusChangeListener {

        /* renamed from: a */
        boolean f23375a;

        /* renamed from: b */
        boolean f23376b;

        /* renamed from: c */
        int f23377c;

        private C6629m() {
            this.f23375a = false;
            this.f23376b = false;
            this.f23377c = 0;
        }

        /* renamed from: a */
        boolean m35681a() {
            if (IjkVideoView.this.f23354w == null) {
                return false;
            }
            this.f23375a = false;
            return 1 == IjkVideoView.this.f23354w.abandonAudioFocus(this);
        }

        /* renamed from: b */
        boolean m35680b() {
            if (this.f23377c == 1) {
                return true;
            }
            if (IjkVideoView.this.f23354w == null) {
                return false;
            }
            if (1 == IjkVideoView.this.f23354w.requestAudioFocus(this, 3, 1)) {
                this.f23377c = 1;
                return true;
            }
            this.f23375a = true;
            return false;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            if (this.f23377c == i) {
                return;
            }
            this.f23377c = i;
            if (i == -3 || i == -2) {
                if (IjkVideoView.this.isPlaying()) {
                    this.f23376b = true;
                    IjkVideoView.this.pause();
                }
            } else if (i == -1) {
                if (IjkVideoView.this.isPlaying()) {
                    this.f23376b = true;
                    IjkVideoView.this.pause();
                }
            } else if (i == 1 || i == 2) {
                if (this.f23375a || this.f23376b) {
                    IjkVideoView.this.start();
                    this.f23375a = false;
                    this.f23376b = false;
                }
            }
        }

        /* synthetic */ C6629m(IjkVideoView ijkVideoView, SurfaceHolder$CallbackC6619d surfaceHolder$CallbackC6619d) {
            this();
        }
    }
}

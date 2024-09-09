package com.qq.e.comm.plugin.o0.h;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.q2;
import com.qq.e.comm.util.GDTLogger;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f extends TextureView implements TextureView.SurfaceTextureListener, com.qq.e.comm.plugin.o0.h.e, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnVideoSizeChangedListener, q2.a, MediaPlayer.OnInfoListener {
    private static final int V = com.qq.e.comm.plugin.d0.a.d().f().a("skvsrmr", 3);
    private static Boolean W;
    private r A;
    private long B;
    private int C;
    private int D;
    private Handler E;
    private Handler F;
    private HandlerThread G;
    private int H;
    private float I;
    private float J;
    private final com.qq.e.comm.plugin.o0.h.i K;

    /* renamed from: L  reason: collision with root package name */
    private p f45136L;
    private s M;
    private boolean N;
    private Boolean O;
    private String P;
    private AtomicBoolean Q;
    private boolean R;
    private int S;
    private int T;
    private long U;

    /* renamed from: c  reason: collision with root package name */
    private volatile int f45137c;

    /* renamed from: d  reason: collision with root package name */
    private volatile int f45138d;

    /* renamed from: e  reason: collision with root package name */
    private volatile int f45139e;

    /* renamed from: f  reason: collision with root package name */
    private SurfaceTexture f45140f;

    /* renamed from: g  reason: collision with root package name */
    private volatile MediaPlayer f45141g;

    /* renamed from: h  reason: collision with root package name */
    private AudioManager f45142h;

    /* renamed from: i  reason: collision with root package name */
    private Surface f45143i;

    /* renamed from: j  reason: collision with root package name */
    private int f45144j;

    /* renamed from: k  reason: collision with root package name */
    private int f45145k;

    /* renamed from: l  reason: collision with root package name */
    private com.qq.e.comm.plugin.g0.e f45146l;

    /* renamed from: m  reason: collision with root package name */
    private AtomicBoolean f45147m;

    /* renamed from: n  reason: collision with root package name */
    private AtomicBoolean f45148n;

    /* renamed from: o  reason: collision with root package name */
    private AtomicBoolean f45149o;

    /* renamed from: p  reason: collision with root package name */
    private AtomicBoolean f45150p;

    /* renamed from: q  reason: collision with root package name */
    private AtomicBoolean f45151q;

    /* renamed from: r  reason: collision with root package name */
    private AtomicBoolean f45152r;

    /* renamed from: s  reason: collision with root package name */
    private volatile int f45153s;

    /* renamed from: t  reason: collision with root package name */
    private AtomicBoolean f45154t;

    /* renamed from: u  reason: collision with root package name */
    private AtomicBoolean f45155u;

    /* renamed from: v  reason: collision with root package name */
    private com.qq.e.comm.plugin.o0.h.b f45156v;

    /* renamed from: w  reason: collision with root package name */
    private o f45157w;

    /* renamed from: x  reason: collision with root package name */
    private Boolean f45158x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f45159y;

    /* renamed from: z  reason: collision with root package name */
    private t f45160z;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f45157w != null) {
                f.this.f45157w.onVideoResume();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f45157w != null) {
                f.this.f45157w.onVideoStart();
                float f4 = f.this.f45151q.get() ? 0.0f : 0.8f;
                if (f.this.f45141g == null || f.this.f45160z == t.ERROR) {
                    return;
                }
                try {
                    f.this.f45141g.setVolume(f4, f4);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f45157w != null) {
                f.this.f45157w.onVideoPause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f45157w != null) {
                f.this.f45157w.onVideoStop();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.o0.h.f$f  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class RunnableC0869f implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f45166c;

        RunnableC0869f(int i4) {
            this.f45166c = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f45166c == f.this.T) {
                if (f.this.o()) {
                    int currentTimeMillis = (int) (System.currentTimeMillis() - f.this.U);
                    if (f.this.N) {
                        f fVar = f.this;
                        fVar.N = fVar.f45136L.a(currentTimeMillis, f.this.f45160z, f.this.I);
                    }
                }
            } else {
                f.this.U = System.currentTimeMillis();
                f.this.T = this.f45166c;
                f.this.f45136L.a(this.f45166c, f.this.getDuration());
                if (f.this.M != null) {
                    f.this.M.a(this.f45166c);
                }
            }
            f.this.F();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f45157w != null) {
                f.this.f45157w.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f45157w != null) {
                f.this.f45157w.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f45156v != null) {
                f.this.f45156v.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f45156v != null) {
                f.this.f45156v.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class k implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Exception f45172c;

        k(Exception exc) {
            this.f45172c = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f45157w != null) {
                f.this.f45157w.a(5003, this.f45172c);
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class l implements Runnable {
        l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f45157w != null) {
                f.this.f45157w.onVideoComplete();
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class m implements Runnable {
        m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f45157w != null) {
                f.this.f45157w.onVideoReady();
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class n implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f45176c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f45177d;

        n(int i4, int i5) {
            this.f45176c = i4;
            this.f45177d = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f45157w != null) {
                o oVar = f.this.f45157w;
                int i4 = this.f45176c;
                oVar.a(i4, new Exception(this.f45177d + ""));
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface o {
        void a();

        void a(int i4, Exception exc);

        void b();

        void c();

        void onVideoComplete();

        void onVideoPause();

        void onVideoReady();

        void onVideoResume();

        void onVideoStart();

        void onVideoStop();
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface p {
        void a(int i4);

        void a(int i4, int i5);

        boolean a(int i4, t tVar, float f4);
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class r {

        /* renamed from: c  reason: collision with root package name */
        public static final r f45182c = new r("DEFAULT", 0);

        /* renamed from: d  reason: collision with root package name */
        public static final r f45183d = new r("CROP", 1);

        /* renamed from: e  reason: collision with root package name */
        public static final r f45184e = new r("CENTER_CROP", 2);

        private r(String str, int i4) {
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface s {
        void a(int i4);
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public enum t {
        ERROR(0),
        UNINITIALIZED(1),
        PREPARED(2),
        PLAY(3),
        STOP(4),
        PAUSE(5),
        END(6);
        

        /* renamed from: c  reason: collision with root package name */
        int f45193c;

        t(int i4) {
            this.f45193c = i4;
        }

        public int a() {
            return this.f45193c;
        }

        public static t a(int i4) {
            switch (i4) {
                case 1:
                    return ERROR;
                case 2:
                    return UNINITIALIZED;
                case 3:
                    return PLAY;
                case 4:
                    return STOP;
                case 5:
                    return PAUSE;
                case 6:
                    return END;
                default:
                    return UNINITIALIZED;
            }
        }
    }

    public f(Context context) {
        super(context);
        this.f45140f = null;
        this.f45141g = null;
        this.f45143i = null;
        this.f45147m = new AtomicBoolean(false);
        this.f45148n = new AtomicBoolean(false);
        this.f45149o = new AtomicBoolean(false);
        this.f45150p = new AtomicBoolean(false);
        this.f45151q = new AtomicBoolean(false);
        this.f45152r = new AtomicBoolean(false);
        this.f45154t = new AtomicBoolean(false);
        this.f45155u = new AtomicBoolean(false);
        this.f45160z = t.UNINITIALIZED;
        this.A = r.f45182c;
        this.B = 0L;
        this.C = 0;
        this.D = 0;
        this.H = -1;
        this.I = 1.0f;
        this.J = 1.0f;
        this.N = true;
        this.Q = new AtomicBoolean(false);
        this.R = false;
        this.S = 0;
        HandlerThread handlerThread = new HandlerThread(f.class.getSimpleName());
        this.G = handlerThread;
        handlerThread.start();
        this.E = new q2(this, this.G.getLooper());
        this.F = new Handler();
        this.E.sendEmptyMessage(6);
        setSurfaceTextureListener(this);
        this.K = new com.qq.e.comm.plugin.o0.h.i();
    }

    private void A() {
        try {
            this.f45141g.reset();
        } catch (Throwable th) {
            d1.a(th.getMessage(), th);
        }
    }

    private void B() {
        try {
            if (this.f45141g == null || this.f45160z == t.ERROR || this.f45151q.get()) {
                return;
            }
            d1.a("Set volume off.", new Object[0]);
            this.f45141g.setVolume(0.0f, 0.0f);
            this.f45151q.set(true);
            H();
        } catch (Exception e4) {
            d1.a("MediaPlayer set volume off error", e4);
        }
    }

    private void C() {
        try {
            if (this.f45141g == null || this.f45160z == t.ERROR || !this.f45151q.get()) {
                return;
            }
            d1.a("Set volume on.", new Object[0]);
            this.f45141g.setVolume(0.8f, 0.8f);
            this.f45151q.set(false);
            I();
        } catch (Exception e4) {
            d1.a("MediaPlayer set volume on error", e4);
        }
    }

    private void D() {
        this.F.post(new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        if (this.f45136L == null) {
            return;
        }
        if (!o()) {
            this.T = 0;
            this.U = 0L;
            return;
        }
        if (this.U == 0) {
            this.U = System.currentTimeMillis();
        }
        this.E.sendEmptyMessageDelayed(14, 500L);
    }

    private void H() {
        AudioManager audioManager = this.f45142h;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(null);
        }
    }

    private void I() {
        AudioManager audioManager;
        if (this.f45151q.get() || this.f45160z != t.PLAY || (audioManager = this.f45142h) == null) {
            return;
        }
        audioManager.requestAudioFocus(null, 3, 2);
    }

    private void n() {
        m();
        this.f45142h = (AudioManager) getContext().getSystemService("audio");
        this.f45141g.setOnPreparedListener(this);
        this.f45141g.setOnCompletionListener(this);
        this.f45141g.setOnErrorListener(this);
        this.f45141g.setOnSeekCompleteListener(this);
        this.f45141g.setOnVideoSizeChangedListener(this);
        this.f45141g.setOnInfoListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        t tVar;
        return this.f45141g != null && ((tVar = this.f45160z) == t.PLAY || tVar == t.PREPARED || (tVar == t.UNINITIALIZED && this.f45147m.get()));
    }

    private boolean p() {
        t tVar;
        return (this.f45141g == null || (tVar = this.f45160z) == t.ERROR || tVar == t.UNINITIALIZED) ? false : true;
    }

    private void q() {
        if (this.f45136L == null) {
            return;
        }
        this.F.post(new RunnableC0869f(getCurrentPosition()));
    }

    private void r() {
        if (this.f45140f == null) {
            d1.a("SurfaceTexture is not available, can't open video.", new Object[0]);
        } else if (this.f45141g == null) {
            d1.a("MediaPlayer is null, can't open video.", new Object[0]);
        } else {
            if (this.f45143i == null) {
                this.f45143i = new Surface(this.f45140f);
            }
            this.f45141g.setSurface(this.f45143i);
            this.f45148n.set(true);
            if (this.f45147m.get() && this.f45150p.get() && this.f45149o.get()) {
                d1.a("SurfaceTexture is available and play() was called.", new Object[0]);
                play();
            }
        }
    }

    private void t() {
        t tVar = this.f45160z;
        if (tVar == t.UNINITIALIZED) {
            d1.a("pause() was called but video is not initialized.", new Object[0]);
        } else if (tVar == t.PREPARED) {
            d1.a("pause() was called but video is just prepared, not playing.", new Object[0]);
        } else if (tVar == t.PAUSE) {
            d1.a("pause() was called but video already paused.", new Object[0]);
        } else if (tVar == t.STOP) {
            d1.a("pause() was called but video already stopped.", new Object[0]);
        } else if (tVar == t.END) {
            d1.a("pause() was called but video already ended.", new Object[0]);
        } else if (this.f45141g == null) {
            d1.a("pause() was called but MediaPlayer is null.", new Object[0]);
        } else {
            this.f45160z = t.PAUSE;
            if (this.f45141g.isPlaying()) {
                this.R = true;
                this.f45141g.pause();
            }
            this.H = getCurrentPosition();
            H();
            this.F.post(new d());
        }
    }

    private void u() {
        t tVar;
        if (this.f45159y) {
            d1.a("play() was called but video is locked.", new Object[0]);
        } else if (!this.f45147m.get()) {
            d1.a("play() was called but video data source was not set.", new Object[0]);
        } else {
            this.f45150p.set(true);
            if (!this.f45149o.get()) {
                d1.a("play() was called but video is not prepared yet, waiting.", new Object[0]);
            } else if (!this.f45148n.get()) {
                d1.a("play() was called but SurfaceTexture is not available yet, waiting.", new Object[0]);
            } else if (this.f45160z == t.PLAY) {
                d1.a("play() was called but video is already playing.", new Object[0]);
            } else if (this.f45141g == null) {
                d1.a("play() was called but MediaPlayer is null.", new Object[0]);
            } else if (!this.R && (tVar = this.f45160z) != t.PAUSE) {
                if (tVar != t.END && tVar != t.STOP) {
                    this.f45160z = t.PLAY;
                    I();
                    this.f45141g.start();
                    this.F.post(new c());
                    a(this.J);
                    return;
                }
                d1.a("play() was called but video already ended/stopped, starting over.", new Object[0]);
                b(this.P);
                this.f45150p.set(true);
            } else {
                d1.a("play() was called but video is paused, resuming.", new Object[0]);
                this.f45160z = t.PLAY;
                this.R = false;
                this.f45141g.start();
                F();
                I();
                this.H = getCurrentPosition();
                this.F.post(new b());
                a(this.J);
            }
        }
    }

    private void v() {
        try {
            if (this.f45141g != null) {
                this.f45141g.prepareAsync();
                F();
            }
        } catch (IllegalArgumentException e4) {
            d1.a(e4.getMessage(), new Object[0]);
        } catch (IllegalStateException e5) {
            d1.a(e5.getMessage(), new Object[0]);
        } catch (SecurityException e6) {
            d1.a(e6.getMessage(), new Object[0]);
        }
    }

    private synchronized void w() {
        HandlerThread handlerThread = this.G;
        if (handlerThread != null) {
            handlerThread.quit();
            this.G = null;
        }
    }

    private void y() {
        if (this.f45141g != null) {
            A();
            this.f45141g.release();
            this.f45141g = null;
            this.f45160z = t.UNINITIALIZED;
            this.Q.set(true);
            this.f45147m.set(false);
        }
    }

    private void z() {
        d1.a(hashCode() + " reInit", new Object[0]);
        n();
        int i4 = this.S;
        if (i4 > 0) {
            a(i4);
        }
        float f4 = this.f45151q.get() ? 0.0f : 1.0f;
        this.f45141g.setVolume(f4, f4);
        if (this.P != null) {
            try {
                this.f45141g.setDataSource(this.P);
                this.f45147m.set(true);
                v();
                return;
            } catch (Exception e4) {
                d1.a(e4.getMessage(), e4);
                return;
            }
        }
        d1.a(hashCode() + " reInit failed, path is null");
    }

    public void E() {
        if (System.currentTimeMillis() - this.B < 100) {
            return;
        }
        this.B = System.currentTimeMillis();
        if (this.f45156v == null || this.f45154t.get()) {
            return;
        }
        if (this.f45156v.isShown()) {
            l();
        } else {
            D();
        }
    }

    public void G() {
        this.E.sendEmptyMessage(3);
    }

    public void J() {
        this.E.sendEmptyMessage(16);
    }

    boolean K() {
        t tVar = this.f45160z;
        return tVar == t.UNINITIALIZED || tVar == t.END || tVar == t.ERROR || tVar == t.PAUSE;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    protected void finalize() {
        try {
            super.finalize();
            w();
        } catch (Throwable unused) {
        }
    }

    @Override // com.qq.e.comm.plugin.o0.h.e
    public int getCurrentPosition() {
        try {
            if (p()) {
                if (this.f45160z == t.END) {
                    return getDuration();
                }
                return this.f45141g.getCurrentPosition();
            }
            return 0;
        } catch (Exception e4) {
            d1.a("MediaPlayer get current position error", e4);
            e4.printStackTrace();
            return 0;
        }
    }

    @Override // com.qq.e.comm.plugin.o0.h.e
    public int getDuration() {
        if (this.f45139e == 0) {
            try {
                if (p() && this.f45149o.get()) {
                    this.f45139e = this.f45141g.getDuration();
                }
            } catch (Exception e4) {
                d1.a("MediaPlayer can not get Duration", e4);
            }
        }
        return this.f45139e;
    }

    @Override // com.qq.e.comm.plugin.o0.h.e
    public t getVideoState() {
        return this.f45160z;
    }

    @Override // com.qq.e.comm.plugin.util.q2.a
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                u();
                return;
            case 2:
                t();
                return;
            case 3:
                b(message.arg1 == 1, message.arg2 == 1);
                return;
            case 4:
                y();
                return;
            case 5:
                z();
                return;
            case 6:
                n();
                return;
            case 7:
                b(String.valueOf(message.obj));
                return;
            case 8:
                B();
                return;
            case 9:
                C();
                return;
            case 10:
                b(message.arg1);
                return;
            case 11:
                r();
                return;
            case 12:
                j();
                return;
            case 13:
                f();
                return;
            case 14:
                q();
                return;
            case 15:
                this.f45159y = true;
                t();
                return;
            case 16:
                this.f45159y = false;
                u();
                return;
            case 17:
                b(((Float) message.obj).floatValue());
                return;
            default:
                return;
        }
    }

    @Override // com.qq.e.comm.plugin.o0.h.e
    public boolean isPlaying() {
        try {
            if (!p() || this.f45141g == null) {
                return false;
            }
            return this.f45141g.isPlaying();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d1.a(hashCode() + " attached", new Object[0]);
        q.a().b(this);
        if (this.Q.get()) {
            this.E.sendEmptyMessage(5);
            this.Q.set(false);
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        t tVar = this.f45160z;
        t tVar2 = t.END;
        if (tVar != tVar2) {
            this.f45160z = tVar2;
            d1.a("Video is ended.", new Object[0]);
            if (this.f45155u.get()) {
                com.qq.e.comm.plugin.o0.b.a().d();
            }
            H();
            this.F.post(new l());
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d1.a(hashCode() + " detach", new Object[0]);
        this.E.sendEmptyMessage(13);
        if (this.f45141g != null) {
            q.a().a(this);
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i4, int i5) {
        com.qq.e.comm.plugin.g0.e eVar;
        if (this.f45160z == t.END && (eVar = this.f45146l) != null) {
            if (W == null) {
                W = Boolean.valueOf(com.qq.e.comm.plugin.t.c.a("vieac", "", 0, eVar.p0()) == 1);
            }
            if (W.booleanValue()) {
                return true;
            }
            com.qq.e.comm.plugin.o0.e.a(this.f45146l);
        }
        if (this.f45155u.get()) {
            com.qq.e.comm.plugin.o0.b.a().a(i4);
        }
        t tVar = this.f45160z;
        t tVar2 = t.ERROR;
        if (tVar != tVar2) {
            this.f45160z = tVar2;
            GDTLogger.e("\u89c6\u9891\u64ad\u653e\u9519\u8bef\uff0c\u9519\u8bef\u4fe1\u606f\uff1a, what = " + i4 + ", extra = " + i5);
            H();
            this.F.post(new n(i4, i5));
        }
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i4, int i5) {
        if (i4 == 701) {
            this.f45158x = Boolean.TRUE;
            g();
            return false;
        } else if (i4 != 702) {
            return false;
        } else {
            this.f45158x = Boolean.FALSE;
            h();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r8, int r9) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.o0.h.f.onMeasure(int, int):void");
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f45160z = t.PREPARED;
        this.f45149o.set(true);
        d1.a("Video is prepared.", new Object[0]);
        b(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
        a(this.J);
        this.F.post(new m());
        if (this.f45152r.get()) {
            d1.a("Player is prepared and seekTo() was called.", new Object[0]);
            a(this.f45153s);
        }
        if (this.f45150p.get() && this.f45148n.get()) {
            d1.a("Player is prepared and play() was called.", new Object[0]);
            play();
        }
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        d1.a("onSeekComplete: " + mediaPlayer.getCurrentPosition(), new Object[0]);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i4, int i5) {
        d1.a("onSurfaceTextureAvailable", new Object[0]);
        SurfaceTexture surfaceTexture2 = this.f45140f;
        if (surfaceTexture2 == null) {
            this.f45140f = surfaceTexture;
        } else if (Build.VERSION.SDK_INT >= 16) {
            setSurfaceTexture(surfaceTexture2);
        } else {
            surfaceTexture2.release();
            this.f45140f = surfaceTexture;
            Surface surface = this.f45143i;
            if (surface != null) {
                surface.release();
            }
            this.f45143i = new Surface(this.f45140f);
        }
        this.E.sendEmptyMessage(11);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        d1.a("onSurfaceTextureDestroyed", new Object[0]);
        this.f45150p.set(false);
        this.f45148n.set(false);
        return this.f45140f == null;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i4, int i5) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.f45140f = surfaceTexture;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i4, int i5) {
        b(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
        if (this.f45137c == 0 || this.f45138d == 0) {
            return;
        }
        this.F.post(new a());
    }

    public void pause() {
        this.E.sendEmptyMessage(2);
    }

    @Override // com.qq.e.comm.plugin.o0.h.e
    public void play() {
        this.E.sendEmptyMessage(1);
    }

    public void s() {
        this.E.sendEmptyMessage(15);
    }

    public void x() {
        this.E.sendEmptyMessage(4);
    }

    private void e() {
        com.qq.e.comm.plugin.o0.h.b bVar = this.f45156v;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    private void f() {
        this.S = getCurrentPosition();
        if (!this.f45155u.get() || this.S <= 0 || com.qq.e.comm.plugin.o0.b.a().c()) {
            return;
        }
        com.qq.e.comm.plugin.o0.b.a().d();
    }

    private void g() {
        this.F.post(new h());
    }

    private void h() {
        this.F.post(new g());
    }

    private void j() {
        o oVar = this.f45157w;
        if (oVar != null) {
            oVar.b();
        }
        q.a().b(this);
        int currentPosition = getCurrentPosition();
        if (this.f45155u.get() && currentPosition > 0 && !com.qq.e.comm.plugin.o0.b.a().c()) {
            com.qq.e.comm.plugin.o0.b.a().d();
        }
        if (this.f45141g != null) {
            A();
            this.f45141g.release();
            this.f45141g = null;
            this.f45160z = t.UNINITIALIZED;
            this.f45140f = null;
        }
        w();
    }

    private void l() {
        this.F.post(new i());
    }

    private void m() {
        this.f45149o.set(false);
        if (this.f45141g == null) {
            this.f45141g = new MediaPlayer();
        } else {
            try {
                this.f45141g.reset();
            } catch (Throwable unused) {
                this.f45141g = new MediaPlayer();
            }
        }
        this.f45150p.set(false);
        this.f45152r.set(false);
        this.f45139e = 0;
        this.f45153s = 0;
        this.f45160z = t.UNINITIALIZED;
    }

    public void b(int i4, int i5) {
        if (i4 <= 0 || i5 <= 0) {
            return;
        }
        this.K.a(i4, i5);
        this.f45137c = i4;
        this.f45138d = i5;
        com.qq.e.comm.plugin.o0.h.b bVar = this.f45156v;
        if (bVar == null || !(bVar instanceof com.qq.e.comm.plugin.gdtnativead.p.a)) {
            return;
        }
        if (i4 == this.C && i5 == this.D) {
            return;
        }
        this.C = i4;
        this.D = i5;
        ((com.qq.e.comm.plugin.gdtnativead.p.a) this.f45156v).a(i4, i5);
    }

    @Override // com.qq.e.comm.plugin.o0.h.e
    public void c() {
        this.E.sendEmptyMessage(8);
    }

    @Override // com.qq.e.comm.plugin.o0.h.e
    public o d() {
        return this.f45157w;
    }

    public void i() {
        int i4;
        p pVar = this.f45136L;
        if (pVar != null) {
            Boolean bool = this.O;
            if (bool == null) {
                i4 = -1;
            } else {
                i4 = bool.booleanValue() ? 1 : 0;
            }
            pVar.a(i4);
        }
        d1.a(hashCode() + " free", new Object[0]);
        this.E.sendEmptyMessage(12);
    }

    public String k() {
        return this.P;
    }

    public void a(s sVar) {
        this.M = sVar;
    }

    @Override // com.qq.e.comm.plugin.o0.h.e
    public void a(o oVar) {
        Boolean bool;
        com.qq.e.comm.plugin.g0.e eVar = this.f45146l;
        if (eVar == null) {
            this.f45157w = oVar;
        } else {
            this.f45157w = new com.qq.e.comm.plugin.o0.a(this, oVar, eVar);
        }
        if (oVar == null || (bool = this.f45158x) == null) {
            return;
        }
        if (bool.booleanValue()) {
            g();
        } else {
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class q {

        /* renamed from: c  reason: collision with root package name */
        private static volatile q f45179c;

        /* renamed from: a  reason: collision with root package name */
        private ArrayBlockingQueue<WeakReference<f>> f45180a;

        /* renamed from: b  reason: collision with root package name */
        private int f45181b = -1;

        private q() {
            this.f45180a = null;
            this.f45180a = new ArrayBlockingQueue<>(16);
        }

        public static q a() {
            if (f45179c == null) {
                synchronized (q.class) {
                    if (f45179c == null) {
                        f45179c = new q();
                    }
                }
            }
            return f45179c;
        }

        public boolean b(f fVar) {
            if (fVar == null) {
                return false;
            }
            WeakReference<f> weakReference = null;
            Iterator<WeakReference<f>> it = this.f45180a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WeakReference<f> next = it.next();
                if (fVar == next.get()) {
                    weakReference = next;
                    break;
                }
            }
            if (weakReference != null) {
                boolean remove = this.f45180a.remove(weakReference);
                d1.a(fVar.hashCode() + " removed from cache, result = " + remove + ", size = " + this.f45180a.size(), new Object[0]);
                return remove;
            }
            d1.a(fVar.hashCode() + " not in cache", new Object[0]);
            return false;
        }

        public boolean a(f fVar) {
            if (fVar == null) {
                d1.a("view == null, return");
                return false;
            }
            int b4 = b();
            if (b4 == 0) {
                d1.a("maxCount == 0, return", new Object[0]);
                return false;
            }
            if (this.f45180a.size() == b()) {
                WeakReference<f> poll = this.f45180a.poll();
                if (poll != null) {
                    f fVar2 = poll.get();
                    if (fVar2 != null) {
                        d1.a(fVar2.hashCode() + "'s player will be released, maxCacheCount = " + b4);
                        fVar2.x();
                    } else {
                        d1.a("player is released, remove it", new Object[0]);
                    }
                } else {
                    d1.a("queue is empty, why?!");
                }
            }
            boolean offer = this.f45180a.offer(new WeakReference<>(fVar));
            d1.a(fVar.hashCode() + " add to cache, result = " + offer + ", size = " + this.f45180a.size(), new Object[0]);
            return offer;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0062  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private int b() {
            /*
                r5 = this;
                int r0 = r5.f45181b
                if (r0 < 0) goto L5
                return r0
            L5:
                com.qq.e.comm.plugin.d0.a r0 = com.qq.e.comm.plugin.d0.a.d()
                com.qq.e.comm.plugin.d0.d.h r0 = r0.f()
                r1 = 5
                r2 = 0
                if (r0 == 0) goto L40
                java.lang.String r3 = "maxCachedPlayerCount"
                java.lang.String r0 = r0.c(r3)
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "player cache count str = "
                r3.append(r4)
                r3.append(r0)
                java.lang.String r3 = r3.toString()
                java.lang.Object[] r4 = new java.lang.Object[r2]
                com.qq.e.comm.plugin.util.d1.a(r3, r4)
                boolean r3 = android.text.TextUtils.isEmpty(r0)
                if (r3 != 0) goto L40
                int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Exception -> L38
                goto L41
            L38:
                r0 = move-exception
                java.lang.String r3 = r0.getMessage()
                com.qq.e.comm.plugin.util.d1.a(r3, r0)
            L40:
                r0 = 5
            L41:
                if (r0 >= 0) goto L62
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "player cache count = "
                r3.append(r4)
                r3.append(r0)
                java.lang.String r0 = ", set to default: "
                r3.append(r0)
                r3.append(r1)
                java.lang.String r0 = r3.toString()
                java.lang.Object[] r2 = new java.lang.Object[r2]
                com.qq.e.comm.plugin.util.d1.a(r0, r2)
                goto L63
            L62:
                r1 = r0
            L63:
                r5.f45181b = r1
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.o0.h.f.q.b():int");
        }
    }

    private void b(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("127.0.0.1")) {
            str = str.replace("12345567", String.valueOf(hashCode()));
        }
        m();
        try {
            this.f45141g.setDataSource(str);
            this.f45147m.set(true);
            this.P = str;
            v();
        } catch (Exception e4) {
            d1.a(e4.getMessage(), new Object[0]);
            this.f45160z = t.ERROR;
            this.F.post(new k(e4));
        }
    }

    public void a(p pVar) {
        if (pVar == null) {
            return;
        }
        this.f45136L = pVar;
    }

    public void a(com.qq.e.comm.plugin.g0.e eVar) {
        if (eVar == null) {
            return;
        }
        this.f45146l = eVar;
        this.f45155u.set(eVar.b1());
        o oVar = this.f45157w;
        if (oVar instanceof com.qq.e.comm.plugin.o0.a) {
            return;
        }
        this.f45157w = new com.qq.e.comm.plugin.o0.a(this, oVar, eVar);
    }

    @Deprecated
    public void a(int i4, int i5) {
        this.f45144j = i4;
        this.f45145k = i5;
    }

    public void a(com.qq.e.comm.plugin.o0.h.b bVar) {
        this.f45156v = bVar;
        if (this.f45137c > 0 && this.f45138d > 0) {
            com.qq.e.comm.plugin.o0.h.b bVar2 = this.f45156v;
            if (bVar2 instanceof com.qq.e.comm.plugin.gdtnativead.p.a) {
                ((com.qq.e.comm.plugin.gdtnativead.p.a) bVar2).a(this.f45137c, this.f45138d);
            }
        }
        l();
        e();
    }

    private void b(boolean z3, boolean z4) {
        t tVar = this.f45160z;
        if (tVar == t.UNINITIALIZED) {
            d1.a("stop() was called but video is not initialized.", new Object[0]);
        } else if (tVar == t.PREPARED) {
            d1.a("stop() was called but video is just prepared, not playing.", new Object[0]);
        } else if (tVar == t.STOP) {
            d1.a("stop() was called but video already stopped.", new Object[0]);
        } else if (tVar == t.END) {
            d1.a("stop() was called but video already ended.", new Object[0]);
        } else if (tVar == t.ERROR) {
            d1.a("stop() was called but video already encountered error.", new Object[0]);
        } else if (this.f45141g == null) {
            d1.a("stop() was called but MediaPlayer is null.", new Object[0]);
        } else {
            this.f45160z = t.STOP;
            H();
            this.F.post(new e());
            if (z3 || this.f45141g.isPlaying()) {
                this.f45141g.seekTo(z4 ? 0 : getDuration());
                this.f45141g.pause();
                l();
            }
            if (z3) {
                this.R = false;
            }
        }
    }

    public void a(String str) {
        Message obtain = Message.obtain();
        obtain.what = 7;
        obtain.obj = str;
        this.E.sendMessage(obtain);
        if (this.O == null) {
            this.O = Boolean.valueOf(!str.startsWith("http"));
        }
    }

    public void a(boolean z3, boolean z4) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.arg1 = z3 ? 1 : 0;
        obtain.arg2 = z4 ? 1 : 0;
        this.E.sendMessage(obtain);
    }

    public void a(int i4) {
        Message obtain = Message.obtain();
        obtain.what = 10;
        obtain.arg1 = i4;
        this.E.sendMessage(obtain);
    }

    @Override // com.qq.e.comm.plugin.o0.h.e
    public void a() {
        this.E.sendEmptyMessage(9);
    }

    public void a(float f4) {
        if (f4 > V || f4 < 0.0f || f4 == this.I) {
            return;
        }
        this.J = f4;
        if (K()) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = Float.valueOf(f4);
        this.E.sendMessage(obtain);
    }

    public void a(boolean z3) {
        this.f45154t.set(z3);
    }

    public void a(r rVar) {
        this.A = rVar;
    }

    private void b(int i4) {
        try {
            if (p()) {
                this.f45141g.seekTo(i4);
                this.f45152r.set(false);
                this.f45153s = 0;
                return;
            }
        } catch (Exception e4) {
            d1.a("MediaPlayer can not seek", e4);
        }
        this.f45152r.set(true);
        this.f45153s = i4;
    }

    @Override // com.qq.e.comm.plugin.o0.h.e
    public int b() {
        if (this.H < 0) {
            this.H = getCurrentPosition();
        }
        return this.H;
    }

    private void b(float f4) {
        try {
            if (Build.VERSION.SDK_INT < 23 || this.f45141g == null || K() || this.I == f4) {
                return;
            }
            d1.a("Set speed on.", new Object[0]);
            PlaybackParams playbackParams = this.f45141g.getPlaybackParams();
            playbackParams.setSpeed(f4);
            this.f45141g.setPlaybackParams(playbackParams);
            this.I = f4;
        } catch (Exception e4) {
            d1.a("MediaPlayer set speed on error", e4);
        }
    }
}

package com.qq.e.comm.plugin.o0.f;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.qq.e.comm.plugin.o0.f.a;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.q2;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, q2.a {

    /* renamed from: s  reason: collision with root package name */
    private static final String f45039s = b.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    private AudioManager f45041d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f45042e;

    /* renamed from: f  reason: collision with root package name */
    private volatile int f45043f;

    /* renamed from: g  reason: collision with root package name */
    private String f45044g;

    /* renamed from: m  reason: collision with root package name */
    private final Handler f45050m;

    /* renamed from: n  reason: collision with root package name */
    private final Handler f45051n;

    /* renamed from: o  reason: collision with root package name */
    private HandlerThread f45052o;

    /* renamed from: p  reason: collision with root package name */
    private i f45053p;

    /* renamed from: q  reason: collision with root package name */
    private com.qq.e.comm.plugin.g0.e f45054q;

    /* renamed from: c  reason: collision with root package name */
    private volatile MediaPlayer f45040c = null;

    /* renamed from: h  reason: collision with root package name */
    private final AtomicBoolean f45045h = new AtomicBoolean(false);

    /* renamed from: i  reason: collision with root package name */
    private final AtomicBoolean f45046i = new AtomicBoolean(false);

    /* renamed from: j  reason: collision with root package name */
    private final AtomicBoolean f45047j = new AtomicBoolean(false);

    /* renamed from: k  reason: collision with root package name */
    private final AtomicBoolean f45048k = new AtomicBoolean(false);

    /* renamed from: l  reason: collision with root package name */
    private int f45049l = 1;

    /* renamed from: r  reason: collision with root package name */
    private int f45055r = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.o0.f.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class RunnableC0865b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Throwable f45058c;

        RunnableC0865b(Throwable th) {
            this.f45058c = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f45053p != null) {
                b.this.f45053p.a(this.f45058c);
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
            if (b.this.f45053p != null) {
                b.this.f45053p.d();
                float f4 = b.this.f45048k.get() ? 0.0f : 0.8f;
                if (b.this.f45040c == null || b.this.f45049l == 0) {
                    return;
                }
                try {
                    b.this.f45040c.setVolume(f4, f4);
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
            if (b.this.f45053p != null) {
                b.this.f45053p.e();
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
            if (b.this.f45053p != null) {
                b.this.f45053p.c();
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f45053p != null) {
                b.this.f45053p.f();
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f45053p != null) {
                b.this.f45053p.b();
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
            if (b.this.f45053p != null) {
                b.this.f45053p.a();
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface i {
        void a();

        void a(Throwable th);

        void b();

        void c();

        void d();

        void e();

        void f();
    }

    public b(Context context) {
        this.f45042e = context;
        HandlerThread handlerThread = new HandlerThread(b.class.getSimpleName());
        this.f45052o = handlerThread;
        handlerThread.start();
        this.f45050m = new q2(this, this.f45052o.getLooper());
        this.f45051n = new Handler(Looper.getMainLooper());
    }

    private void h() {
        this.f45045h.set(false);
        if (this.f45040c == null) {
            this.f45040c = new MediaPlayer();
        } else {
            try {
                this.f45040c.reset();
            } catch (Throwable unused) {
                this.f45040c = new MediaPlayer();
            }
        }
        this.f45047j.set(false);
        this.f45043f = 0;
        this.f45049l = 1;
        this.f45041d = (AudioManager) this.f45042e.getSystemService("audio");
        this.f45040c.setOnPreparedListener(this);
        this.f45040c.setOnCompletionListener(this);
        this.f45040c.setOnErrorListener(this);
        this.f45040c.setOnInfoListener(this);
    }

    private boolean i() {
        int i4;
        return (this.f45040c == null || (i4 = this.f45049l) == 0 || i4 == 1) ? false : true;
    }

    private void k() {
        this.f45047j.set(true);
        if (!this.f45045h.get()) {
            d1.a(f45039s, "play() was called but audio data source was not set");
        } else if (!this.f45046i.get()) {
            d1.a(f45039s, "play() was called but MediaPlayer is not prepared yet, waiting");
        } else if (this.f45049l == 3) {
            d1.a(f45039s, "play() was called but audio is already playing");
        } else if (this.f45040c == null) {
            d1.a(f45039s, "play() was called but MediaPlayer is null");
        } else {
            int i4 = this.f45049l;
            if (i4 != 6 && i4 != 4) {
                d1.a(f45039s, "play() was called");
                t();
                this.f45040c.start();
                this.f45049l = 3;
                this.f45051n.post(new c());
                return;
            }
            d1.a(f45039s, "play() was called but audio already ended/stopped, starting over.");
            c(this.f45044g);
            this.f45047j.set(true);
        }
    }

    private synchronized void l() {
        HandlerThread handlerThread = this.f45052o;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f45052o = null;
        }
    }

    private void m() {
        try {
            this.f45040c.reset();
        } catch (Throwable th) {
            d1.a(th.getMessage(), th);
        }
    }

    private void o() {
        try {
            if (this.f45040c == null || this.f45049l == 0 || this.f45048k.get()) {
                return;
            }
            d1.a(f45039s, "Set volume off.");
            this.f45040c.setVolume(0.0f, 0.0f);
            this.f45048k.set(true);
            this.f45051n.post(new d());
            s();
        } catch (Exception e4) {
            d1.a(f45039s, "MediaPlayer set volume off error", e4);
        }
    }

    private void q() {
        try {
            if (this.f45040c == null || this.f45049l == 0 || !this.f45048k.get()) {
                return;
            }
            d1.a(f45039s, "Set volume on.");
            this.f45040c.setVolume(0.8f, 0.8f);
            this.f45048k.set(false);
            this.f45051n.post(new e());
            t();
        } catch (Exception e4) {
            d1.a("MediaPlayer set volume on error", e4);
        }
    }

    private void s() {
        AudioManager audioManager = this.f45041d;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(null);
        }
    }

    private void t() {
        AudioManager audioManager;
        if (this.f45048k.get() || this.f45049l != 3 || (audioManager = this.f45041d) == null) {
            return;
        }
        audioManager.requestAudioFocus(null, 3, 2);
    }

    public int e() {
        return this.f45049l;
    }

    public int f() {
        try {
            if (i()) {
                if (this.f45049l == 6) {
                    return g();
                }
                return this.f45040c.getCurrentPosition();
            }
            return 0;
        } catch (Exception e4) {
            d1.a(f45039s, "MediaPlayer get current position error", e4);
            return 0;
        }
    }

    public int g() {
        if (this.f45043f == 0) {
            try {
                if (i() && this.f45046i.get()) {
                    this.f45043f = this.f45040c.getDuration();
                }
            } catch (Exception e4) {
                d1.a(f45039s, "MediaPlayer can not get Duration", e4);
            }
        }
        return this.f45043f;
    }

    @Override // com.qq.e.comm.plugin.util.q2.a
    public void handleMessage(Message message) {
        int i4 = message.what;
        if (i4 == 1) {
            c(String.valueOf(message.obj));
        } else if (i4 == 2) {
            k();
        } else if (i4 == 3) {
            b();
        } else if (i4 == 5) {
            o();
        } else if (i4 == 6) {
            q();
        } else if (i4 != 7) {
        } else {
            d();
        }
    }

    public void j() {
        this.f45050m.sendEmptyMessage(2);
    }

    public void n() {
        this.f45050m.sendEmptyMessage(5);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        if (this.f45049l != 6) {
            this.f45049l = 6;
            d1.a(f45039s, "Audio is ended.");
            s();
            this.f45051n.post(new g());
        }
        int i4 = this.f45055r;
        if (i4 > 0) {
            this.f45055r = i4 - 1;
            j();
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i4, int i5) {
        return false;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i4, int i5) {
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        d1.a(f45039s, "Audio is prepared");
        this.f45049l = 2;
        this.f45046i.set(true);
        this.f45051n.post(new f());
        if (this.f45047j.get()) {
            d1.a(f45039s, "Player is prepared and play() was called");
            j();
        }
    }

    public void p() {
        this.f45050m.sendEmptyMessage(6);
    }

    public void r() {
        this.f45050m.sendEmptyMessage(3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f45056a;

        a(String str) {
            this.f45056a = str;
        }

        @Override // com.qq.e.comm.plugin.o0.f.a.b
        public void a(String str) {
            d1.a(b.f45039s, "download audio success, Url : %s", this.f45056a);
            b.this.d(str);
        }

        @Override // com.qq.e.comm.plugin.o0.f.a.b
        public void a(String str, int i4) {
            d1.a(b.f45039s, "download audio onError, Url : %s, error code: %s", str, Integer.valueOf(i4));
        }
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f45044g = str;
        h();
        String a4 = com.qq.e.comm.plugin.o0.f.a.a(str);
        if (!TextUtils.isEmpty(a4)) {
            d(a4);
        } else {
            a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        try {
            this.f45047j.set(false);
            this.f45045h.set(true);
            this.f45040c.setDataSource(str);
            this.f45040c.prepareAsync();
        } catch (Throwable th) {
            d1.a(f45039s, "setDataWithPrepare error", th);
            this.f45049l = 0;
            this.f45051n.post(new RunnableC0865b(th));
        }
    }

    public void b(String str) {
        Message message = new Message();
        message.what = 1;
        message.obj = str;
        this.f45050m.sendMessage(message);
    }

    public void a(i iVar) {
        this.f45053p = iVar;
    }

    private void a(String str) {
        String str2 = f45039s;
        d1.a(str2, "download audio, Url : " + str);
        com.qq.e.comm.plugin.o0.f.a.a(this.f45054q, str, new a(str));
    }

    private void b() {
        int i4 = this.f45049l;
        if (i4 == 1) {
            d1.a(f45039s, "stop() was called but audio is not initialized");
        } else if (i4 == 2) {
            d1.a(f45039s, "stop() was called but audio is just prepared, not playing");
        } else if (i4 == 4) {
            d1.a(f45039s, "stop() was called but audio already stopped");
        } else if (i4 == 6) {
            d1.a(f45039s, "stop() was called but audio already ended");
        } else if (i4 == 0) {
            d1.a(f45039s, "stop() was called but audio already encountered error");
        } else if (this.f45040c == null) {
            d1.a(f45039s, "stop() was called but MediaPlayer is null");
        } else {
            d1.a(f45039s, "stop() was called");
            this.f45049l = 4;
            s();
            this.f45040c.stop();
            this.f45051n.post(new h());
        }
    }

    public void a(int i4) {
        this.f45055r = i4;
        this.f45040c.setLooping(this.f45055r == -1);
    }

    private void d() {
        if (this.f45040c != null) {
            m();
            this.f45040c.release();
            this.f45040c = null;
            this.f45049l = 1;
        }
        l();
    }

    public void c() {
        this.f45050m.sendEmptyMessage(7);
    }
}

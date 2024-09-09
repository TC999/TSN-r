package com.bykv.vk.component.ttvideo;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.component.ttvideo.DataLoaderHelper;
import com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader;
import com.bykv.vk.component.ttvideo.log.d;
import com.bykv.vk.component.ttvideo.log.e;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.component.ttvideo.player.TTPlayerConfiger;
import com.bykv.vk.component.ttvideo.utils.EngineThreadPool;
import com.bykv.vk.component.ttvideo.utils.Error;
import com.bykv.vk.component.ttvideo.utils.TTVideoEngineLog;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\4499832.dex */
public class TTVideoEngine implements com.bykv.vk.component.ttvideo.log.a, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
    public static final int ENGINE_STATE_ERROR = 4;
    public static final int ENGINE_STATE_PLAYER_RUNNING = 3;
    public static final int ENGINE_STATE_RELEASE = 5;
    public static final int ENGINE_STATE_UNKNOWN = 0;
    public static final int LOAD_STATE_ERROR = 3;
    public static final int LOAD_STATE_PLAYABLE = 1;
    public static final int LOAD_STATE_STALLED = 2;
    public static final int LOAD_STATE_UNKNOWN = 0;
    public static final int PLAYBACK_STATE_ERROR = 3;
    public static final int PLAYBACK_STATE_PAUSED = 2;
    public static final int PLAYBACK_STATE_PLAYING = 1;
    public static final int PLAYBACK_STATE_STOPPED = 0;
    public static final int PLAYER_BUFFERING_DATA_OF_MILLISECONDS = 118;
    public static final int PLAYER_BUFFERING_TIMEOUT = 11;
    public static final int PLAYER_MAX_BUFFERING_DATA_OF_MILLISECONDS = 202;
    public static final int PLAYER_NETWORK_TIMEOUT = 12;
    public static final int PLAYER_OPTION_ENABLE_DATALOADER = 160;
    public static final int PLAYER_OPTION_NOTIFY_BUFFERING_DIRECTLY = 322;
    public static final int PLAYER_OPTION_OUTPUT_LOG = 472;
    public static final int PLAYER_TIME_BASE = 1000000;
    public static final int PLAYER_TYPE_OS = 1;
    public static final int PLAYER_TYPE_OWN = 0;

    /* renamed from: l0  reason: collision with root package name */
    private static boolean f24818l0;
    VideoEngineSimpleCallback B;
    SeekCompletionListener C;
    private final Context D;
    private Surface E;
    private SurfaceHolder F;
    private final com.bykv.vk.component.ttvideo.log.b G;
    private MediaPlayer H;
    private Handler I;
    private boolean K;
    private final com.bykv.vk.component.ttvideo.utils.a W;

    /* renamed from: a  reason: collision with root package name */
    private boolean f24820a;

    /* renamed from: b  reason: collision with root package name */
    private int f24822b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f24824c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f24826d;

    /* renamed from: e  reason: collision with root package name */
    private int f24828e;

    /* renamed from: e0  reason: collision with root package name */
    private long f24829e0;

    /* renamed from: f0  reason: collision with root package name */
    private long f24831f0;

    /* renamed from: g0  reason: collision with root package name */
    private FileDescriptor f24833g0;

    /* renamed from: h  reason: collision with root package name */
    private boolean f24834h;

    /* renamed from: h0  reason: collision with root package name */
    private com.bykv.vk.component.ttvideo.b f24835h0;

    /* renamed from: i  reason: collision with root package name */
    private boolean f24836i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f24838j;

    /* renamed from: o  reason: collision with root package name */
    private boolean f24845o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f24846p;

    /* renamed from: t  reason: collision with root package name */
    private boolean f24850t;

    /* renamed from: v  reason: collision with root package name */
    private boolean f24852v;

    /* renamed from: x  reason: collision with root package name */
    private int f24854x;

    /* renamed from: y  reason: collision with root package name */
    private String f24855y;

    /* renamed from: z  reason: collision with root package name */
    private int f24856z;

    /* renamed from: f  reason: collision with root package name */
    private boolean f24830f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f24832g = true;

    /* renamed from: k  reason: collision with root package name */
    private int f24840k = 0;

    /* renamed from: l  reason: collision with root package name */
    private int f24842l = 0;

    /* renamed from: m  reason: collision with root package name */
    private int f24843m = 0;

    /* renamed from: n  reason: collision with root package name */
    private int f24844n = 0;

    /* renamed from: q  reason: collision with root package name */
    private int f24847q = 0;

    /* renamed from: r  reason: collision with root package name */
    private int f24848r = 30;

    /* renamed from: s  reason: collision with root package name */
    private int f24849s = 5000;

    /* renamed from: u  reason: collision with root package name */
    private int f24851u = 1;

    /* renamed from: w  reason: collision with root package name */
    private boolean f24853w = true;
    private final HashMap<String, String> A = new HashMap<>();
    private int J = 0;

    /* renamed from: L  reason: collision with root package name */
    private float f24819L = -1.0f;
    private boolean M = false;
    private String N = "";
    private boolean O = false;
    private String P = "";
    private int Q = 0;
    private boolean R = false;
    private Error S = null;
    private boolean T = false;
    private boolean U = false;
    private int V = -1;
    private boolean X = false;
    private final Map<String, String> Y = new HashMap();
    private final List<String> Z = new ArrayList();

    /* renamed from: a0  reason: collision with root package name */
    private String f24821a0 = null;

    /* renamed from: b0  reason: collision with root package name */
    private boolean f24823b0 = false;

    /* renamed from: c0  reason: collision with root package name */
    private long f24825c0 = 0;

    /* renamed from: d0  reason: collision with root package name */
    private int f24827d0 = -1;

    /* renamed from: i0  reason: collision with root package name */
    private int f24837i0 = 0;

    /* renamed from: j0  reason: collision with root package name */
    private int f24839j0 = 0;

    /* renamed from: k0  reason: collision with root package name */
    private int f24841k0 = 5000;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MediaPlayer f24857a;

        a(TTVideoEngine tTVideoEngine, MediaPlayer mediaPlayer) {
            this.f24857a = mediaPlayer;
        }

        @Override // java.lang.Runnable
        public void run() {
            MediaPlayer mediaPlayer = this.f24857a;
            if (mediaPlayer != null) {
                try {
                    mediaPlayer.release();
                } catch (Exception e4) {
                    TTVideoEngineLog.i("TTVideoEngine", "release Exception " + e4);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 10) {
                String str = (String) message.obj;
                long j4 = message.arg1;
                if (TTVideoEngine.this.f24822b != 5 && TTVideoEngine.this.Y.containsKey(str)) {
                    TTVideoEngineLog.d("TTVideoEngine", "using mdl cache, key :" + str + " size = " + j4);
                    VideoEngineSimpleCallback videoEngineSimpleCallback = TTVideoEngine.this.B;
                    if (videoEngineSimpleCallback != null) {
                        videoEngineSimpleCallback.onMDLHitCache(str, j4);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, String> f24859a;

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<TTVideoEngine> f24860b;

        public c(TTVideoEngine tTVideoEngine, Map<String, String> map) {
            this.f24860b = new WeakReference<>(tTVideoEngine);
            this.f24859a = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Map<String, String> map;
            TTVideoEngine tTVideoEngine = this.f24860b.get();
            if (tTVideoEngine == null || tTVideoEngine.f24822b == 5 || (map = this.f24859a) == null || map.size() <= 0) {
                return;
            }
            for (String str : this.f24859a.keySet()) {
                String str2 = this.f24859a.get(str);
                long cacheFileSizeByFilePath = !TextUtils.isEmpty(str2) ? TTVideoEngine.getCacheFileSizeByFilePath(str, str2) : TTVideoEngine.getCacheFileSize(str);
                if (tTVideoEngine.I != null) {
                    int i4 = (int) cacheFileSizeByFilePath;
                    tTVideoEngine.I.sendMessage(Message.obtain(tTVideoEngine.I, 10, i4, i4, str));
                }
            }
        }
    }

    public TTVideoEngine(Context context, int i4) {
        TTVideoEngineLog.i("TTVideoEngine", "init, type:" + i4 + ", context:" + context + ", this:" + this);
        this.D = context;
        this.f24856z = i4;
        this.f24850t = f24818l0;
        this.G = new d(context, this);
        this.W = new com.bykv.vk.component.ttvideo.utils.a();
        e.instance.a(context);
    }

    private String a(String str, String str2, long j4, String[] strArr, String str3) {
        String _proxyUrl = DataLoaderHelper.getDataLoader()._proxyUrl(str, str2, j4, strArr, str3);
        if (!TextUtils.isEmpty(_proxyUrl)) {
            TTVideoEngineLog.i("TTVideoEngine", "_mdlUrl get proxyUrl: key = " + str + ", videoId = " + str2);
            if (TextUtils.isEmpty(str2)) {
                str2 = str;
            }
            this.f24821a0 = str2;
            if (!TextUtils.isEmpty(str)) {
                this.Y.put(str, str3);
            }
            d();
        }
        return _proxyUrl;
    }

    private void a(int i4, int i5) {
        if (this.f24842l != i4) {
            TTVideoEngineLog.i("TTVideoEngine", "load state changed prev:" + this.f24842l + ", new:" + i4);
            if (i4 == 2 && this.f24820a && !this.f24824c && this.f24842l != 3) {
                this.V = i5;
            }
            this.f24842l = i4;
            VideoEngineSimpleCallback videoEngineSimpleCallback = this.B;
            if (videoEngineSimpleCallback != null) {
                if (this.T || i4 != 3) {
                    videoEngineSimpleCallback.onLoadStateChanged(this, i4);
                }
            }
        }
    }

    private void a(Error error) {
        TTVideoEngineLog.d("TTVideoEngine", "_notifyError " + error);
        com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
        if (aVar != null) {
            this.G.b(aVar.b());
        }
        this.G.a(error, 0);
        this.f24838j = false;
        VideoEngineSimpleCallback videoEngineSimpleCallback = this.B;
        if (videoEngineSimpleCallback != null) {
            videoEngineSimpleCallback.onError(error);
        }
        this.Q = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x01a7, code lost:
        if (r13 != null) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.String r13, java.util.HashMap r14) {
        /*
            Method dump skipped, instructions count: 499
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.TTVideoEngine.a(java.lang.String, java.util.HashMap):void");
    }

    private void a(boolean z3, int i4) {
        com.bykv.vk.component.ttvideo.utils.a aVar;
        TTVideoEngineLog.i("TTVideoEngine", "_stop, mState:" + this.f24822b + ", this:" + this);
        int i5 = this.f24822b;
        if (i5 == 0 || i5 == 3) {
            this.f24826d = true;
        }
        if (this.H != null && z3 && !isSystemPlayer() && this.f24834h) {
            this.H.stop();
        }
        com.bykv.vk.component.ttvideo.utils.a aVar2 = this.W;
        if (aVar2 != null) {
            aVar2.e();
        }
        if (this.f24840k != 0 && (aVar = this.W) != null) {
            this.G.b(aVar.b());
        }
        this.G.c(i4);
        e(0);
        this.f24820a = false;
        this.f24845o = false;
        this.f24846p = false;
        this.f24825c0 = 0L;
        this.Q = 0;
    }

    public static void addTask(PreloaderURLItem preloaderURLItem) {
        DataLoaderHelper.getDataLoader().addTask(preloaderURLItem);
    }

    private void b() {
        this.M = false;
        this.O = false;
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer != null && mediaPlayer.getPlayerType() == 0) {
            this.H.release();
            this.H = null;
        }
        m();
        this.f24822b = 0;
        this.Q = 0;
        this.P = null;
        this.N = null;
        this.f24855y = null;
        this.f24833g0 = null;
        this.f24823b0 = false;
        this.f24820a = false;
        this.f24845o = false;
        this.f24846p = false;
        this.W.c();
        this.X = false;
        this.f24825c0 = 0L;
        this.f24827d0 = -1;
        this.Z.clear();
        this.f24826d = false;
        this.f24832g = true;
        this.f24828e = 0;
    }

    private void b(int i4) {
        TTVideoEngineLog.i("TTVideoEngine", "buffering end,this:" + this + ", code:" + i4);
        com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
        if (aVar != null && this.f24820a) {
            aVar.d();
        }
        this.V = -1;
        VideoEngineSimpleCallback videoEngineSimpleCallback = this.B;
        if (videoEngineSimpleCallback != null) {
            videoEngineSimpleCallback.onBufferEnd(i4);
        }
        a(1, i4);
    }

    private void b(Error error) {
        TTVideoEngineLog.i("TTVideoEngine", "videoEngine failed:" + error.toString());
        if (this.f24826d) {
            this.f24822b = 0;
            return;
        }
        int f4 = f();
        if (!this.R) {
            int i4 = this.J;
            if (i4 != 0) {
                this.f24828e = i4;
                this.J = 0;
            } else if (!isSystemPlayer() || (isSystemPlayer() && this.f24834h)) {
                int i5 = this.f24843m;
                if (i5 <= 0 || f4 - i5 <= -1000) {
                    this.f24828e = f4;
                } else {
                    this.f24828e = 0;
                }
            }
        }
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer != null && mediaPlayer.isOSPlayer()) {
            this.H.release();
            this.H = null;
            this.f24830f = true;
            a(error);
            return;
        }
        this.f24822b = 4;
        if (this.Q >= this.f24851u) {
            TTVideoEngineLog.e("TTVideoEngine", "videoEngine retry failed");
            a(error);
        } else if (error.notNeedRetry()) {
            TTVideoEngineLog.e("TTVideoEngine", "not need retry");
            a(error);
        } else {
            this.R = true;
            if (this.Q == this.f24851u - 1 || error.needFallbackOS()) {
                MediaPlayer mediaPlayer2 = this.H;
                if (mediaPlayer2 != null) {
                    mediaPlayer2.release();
                    this.H = null;
                }
                this.f24856z = 1;
            }
            this.G.a(error, 0, 0);
            VideoEngineSimpleCallback videoEngineSimpleCallback = this.B;
            if (videoEngineSimpleCallback != null) {
                videoEngineSimpleCallback.onRetry(this.f24856z);
            }
            this.Q++;
            TTVideoEngineLog.d("TTVideoEngine", "retry " + this.Q);
            a(this.M ? this.N : this.P, this.A);
        }
    }

    private void b(String str) {
        if (TextUtils.isEmpty(str)) {
            TTVideoEngineLog.d("TTVideoEngine", "log first url . url is null");
            return;
        }
        if (this.f24832g) {
            this.f24832g = false;
            this.G.a(str, "");
        }
        this.G.a(str);
    }

    private void c() {
        TTVideoEngineLog.i("TTVideoEngine", "_audioRenderStart, this:" + this);
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer == null) {
            return;
        }
        if (!this.f24846p) {
            this.f24846p = true;
        }
        if (!this.f24820a && mediaPlayer.getIntOption(62, -100) == 0 && !this.f24836i && this.T && this.f24830f) {
            k();
        }
    }

    private void c(int i4) {
        TTVideoEngineLog.i("TTVideoEngine", "buffering start,this:" + this + ", code:" + i4);
        com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
        if (aVar != null) {
            aVar.e();
        }
        boolean z3 = this.f24823b0;
        VideoEngineSimpleCallback videoEngineSimpleCallback = this.B;
        if (videoEngineSimpleCallback != null) {
            videoEngineSimpleCallback.onBufferStart(i4, z3 ? 1 : 0, 0);
        }
        a(2, i4);
    }

    private void c(boolean z3) {
        TTVideoEngineLog.i("TTVideoEngine", "seek complete");
        com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
        if (aVar != null && z3 && this.f24820a) {
            aVar.d();
        }
        SeekCompletionListener seekCompletionListener = this.C;
        if (seekCompletionListener != null) {
            seekCompletionListener.onCompletion(z3);
            this.C = null;
        }
    }

    public static void cancelAllPreloadTasks() {
        DataLoaderHelper.getDataLoader().cancelAllTasks();
    }

    public static void cancelPreloadTask(String str) {
        DataLoaderHelper.getDataLoader().cancelTask(str);
    }

    public static void clearAllCaches() {
        DataLoaderHelper.getDataLoader().clearAllCaches();
    }

    public static void closeDataLoader() {
        DataLoaderHelper.getDataLoader().close();
    }

    private void d() {
        DataLoaderHelper.getDataLoader()._addEngine(this, this.f24821a0);
    }

    private void d(int i4) {
        TTVideoEngineLog.i("TTVideoEngine", "render seek complete:" + i4);
        this.G.a();
        if (this.f24824c) {
            this.f24824c = false;
        }
        if (this.B != null) {
            TTVideoEngineLog.i("TTVideoEngine", "render seek complete call back " + i4);
            this.B.onRenderSeekComplete(i4);
        }
    }

    private void e() {
        DataLoaderHelper.getDataLoader()._removeEngine(this, this.f24821a0);
        for (String str : this.Y.keySet()) {
            DataLoaderHelper.getDataLoader()._removePlayTask(str);
        }
        n();
    }

    private void e(int i4) {
        if (this.f24840k != i4) {
            TTVideoEngineLog.i("TTVideoEngine", "playback state changed prev:" + this.f24840k + ", new:" + i4);
            this.f24840k = i4;
            VideoEngineSimpleCallback videoEngineSimpleCallback = this.B;
            if (videoEngineSimpleCallback != null) {
                videoEngineSimpleCallback.onPlaybackStateChanged(this, i4);
            }
        }
    }

    private int f() {
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getCurrentPosition();
    }

    public static void forceRemoveCacheFile(String str) {
        DataLoaderHelper.getDataLoader().removeCacheFile(str, true);
    }

    private void g() {
        if (this.I != null) {
            return;
        }
        this.I = new b(getLooper());
    }

    public static long getCacheFileSize(String str) {
        return DataLoaderHelper.getDataLoader().getCacheSize(str);
    }

    public static long getCacheFileSizeByFilePath(String str, String str2) {
        return DataLoaderHelper.getDataLoader().getCacheSizeByFilePath(str, str2);
    }

    public static DataLoaderHelper.DataLoaderCacheInfo getCacheInfoByFilePath(String str, String str2) {
        return DataLoaderHelper.getDataLoader().getCacheInfoByFilePath(str, str2);
    }

    public static String getEngineVersion() {
        return "1.0.2";
    }

    public static Looper getLooper() {
        return Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper();
    }

    private void h() {
        if (this.G != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f24825c0 = currentTimeMillis;
            this.G.a(currentTimeMillis, (String) null);
        }
    }

    private void i() {
        if (this.f24820a) {
            return;
        }
        this.G.a();
        this.f24820a = true;
    }

    private void j() {
        com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
        if (aVar != null) {
            aVar.a();
        }
        if (this.M || this.O || this.f24833g0 != null) {
            h();
            b(this.M ? this.N : this.P);
            a(this.M ? this.N : this.P, this.A);
        }
    }

    private void k() {
        TTVideoEngineLog.i("TTVideoEngine", "start to render,this:" + this);
        if (this.T) {
            e(1);
        }
        i();
        if (!this.f24845o) {
            this.f24845o = true;
        }
        this.f24823b0 = true;
        a(1, -1);
        com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
        if (aVar != null) {
            aVar.d();
        }
        if (this.R) {
            if (this.f24828e != 0 && isSystemPlayer()) {
                a(this.f24828e);
            }
            this.R = false;
        }
        if (this.J != 0 && isSystemPlayer()) {
            a(this.J);
        }
        this.J = 0;
        this.Q = 0;
        if (this.B != null) {
            TTVideoEngineLog.i("TTVideoEngine", "notify render start");
            this.B.onRenderStart(this);
        }
    }

    private void l() {
        TTVideoEngineLog.d("TTVideoEngine", "_replayOrResume state:" + this.f24840k + ", playtime:" + this.f24825c0);
        if (p()) {
            if (this.M || this.O || this.f24833g0 != null) {
                h();
                a(this.M ? this.N : this.P, this.A);
                return;
            }
            return;
        }
        if (this.X || (this.f24840k == 0 && this.f24825c0 == 0)) {
            h();
            com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
            if (aVar != null) {
                aVar.a();
            }
        }
        o();
    }

    private void m() {
        TTVideoEngineLog.i("TTVideoEngine", "reset, this:" + this);
        this.T = false;
        this.U = false;
        this.f24834h = false;
        this.A.clear();
        a(true, 6);
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(null);
            this.H.reset();
        }
        this.f24820a = false;
        this.f24845o = false;
        this.f24846p = false;
        this.R = false;
        this.G.reset();
    }

    private void n() {
        this.Y.clear();
        this.f24821a0 = null;
    }

    private void o() {
        TTVideoEngineLog.i("TTVideoEngine", "_resumeVideo, shouldplay:" + this.T + ", mediaplayer:" + this.H + ", prepared:" + this.f24834h);
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer == null || !this.T) {
            return;
        }
        mediaPlayer.setScreenOnWhilePlaying(this.f24853w);
        int i4 = this.f24854x;
        if (i4 != 0) {
            this.H.setWakeMode(this.D, i4);
        }
        if (!this.f24834h) {
            this.f24836i = false;
            return;
        }
        this.H.setIntOption(100, this.J);
        this.H.start();
        com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
        if (aVar != null && this.f24820a) {
            aVar.d();
        }
        if (this.H.getIntOption(62, -100) == 0 && !this.f24845o && (this.f24840k == 0 || this.X)) {
            k();
        } else {
            e(1);
        }
    }

    private boolean p() {
        int i4 = this.f24840k;
        if ((i4 == 0 || i4 == 3) && !this.f24834h) {
            return true;
        }
        return (this.H == null || !isSystemPlayer() || this.f24834h) ? false : true;
    }

    public static void removeCacheFile(String str) {
        DataLoaderHelper.getDataLoader().removeCacheFile(str, false);
    }

    public static void setCacheInfoLists(String[] strArr, long[] jArr) {
        DataLoaderHelper.getDataLoader().setCacheInfoLists(strArr, jArr);
    }

    public static void setIntValue(int i4, int i5) {
        DataLoaderHelper.getDataLoader().setIntValue(i4, i5);
    }

    public static void setStringValue(int i4, String str) {
        DataLoaderHelper.getDataLoader().setStringValue(i4, str);
    }

    public static void setVideoEventUploader(VideoEventEngineUploader videoEventEngineUploader) {
        TTVideoEngineLog.i("TTVideoEngine", "setVideoEventUploader uploader");
        e.instance.a(videoEventEngineUploader);
        DataLoaderHelper.getDataLoader().setEngineUploader(videoEventEngineUploader);
    }

    public static void startDataLoader(Context context) {
        DataLoaderHelper.getDataLoader().setContext(context);
        try {
            DataLoaderHelper.getDataLoader().start();
            f24818l0 = true;
            TTVideoEngineLog.d("TTVideoEngine", "DataLoader Start");
        } catch (Exception e4) {
            TTVideoEngineLog.d("TTVideoEngine", "DataLoader Start Fail");
            throw e4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.B != null) {
            TTVideoEngineLog.i("TTVideoEngine", "notify cache end. source id: " + this.f24821a0);
            this.B.onUseMDLCacheEnd();
        }
    }

    void a(int i4) {
        com.bykv.vk.component.ttvideo.utils.a aVar;
        TTVideoEngineLog.i("TTVideoEngine", "_seekTo:" + i4);
        if (this.H == null || !this.f24838j) {
            c(false);
            return;
        }
        if (!this.f24824c && (aVar = this.W) != null) {
            aVar.e();
        }
        this.f24824c = true;
        this.H.seekTo(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Surface surface) {
        TTVideoEngineLog.i("TTVideoEngine", "_doSetPlayerSurface surface:" + surface + ", pre-surface:" + this.E + ", this:" + this);
        this.E = surface;
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(surface);
        }
    }

    void a(String str) {
        if (str != null && !str.equals(this.P)) {
            TTVideoEngineLog.i("TTVideoEngine", String.format("set direct url:%s", str));
            b();
        }
        this.f24838j = false;
        this.O = true;
        this.P = str;
    }

    void a(boolean z3) {
        TTVideoEngineLog.i("TTVideoEngine", "_play, mState:" + this.f24822b + ", byPlay:" + z3 + ", this:" + this);
        this.f24838j = true;
        this.f24836i = false;
        g();
        if (z3) {
            this.G.d(10);
        }
        int i4 = this.f24822b;
        if (i4 != 0) {
            if (i4 == 3) {
                l();
                return;
            } else if (i4 != 4) {
                return;
            }
        }
        j();
    }

    void b(boolean z3) {
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer != null) {
            mediaPlayer.setIsMute(z3);
        }
    }

    public int getBufferingType() {
        return this.V;
    }

    public int getCurrentPlaybackTime() {
        TTVideoEngineLog.i("TTVideoEngine", "getCurrentPlaybackTime state:" + this.f24822b);
        int i4 = this.f24822b;
        if (i4 == 3) {
            return f();
        }
        if (i4 == 4) {
            return this.f24828e;
        }
        return -1;
    }

    public int getCurrentPlaybackTimeAsync() {
        return isSystemPlayer() ? getCurrentPlaybackTime() : this.f24827d0;
    }

    public int getDuration() {
        return this.f24843m;
    }

    public int getLoadState() {
        return this.f24842l;
    }

    public int getLoadedProgress() {
        return this.f24844n;
    }

    public int getPlaybackState() {
        return this.f24840k;
    }

    public boolean isLooping() {
        return this.f24852v;
    }

    public boolean isMute() {
        MediaPlayer mediaPlayer = this.H;
        return mediaPlayer != null ? mediaPlayer.isMute() : this.K;
    }

    public boolean isSystemPlayer() {
        MediaPlayer mediaPlayer = this.H;
        return mediaPlayer == null ? this.f24856z == 1 : mediaPlayer.isOSPlayer();
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i4) {
        if (this.M) {
            i4 = 100;
        }
        this.f24844n = i4;
        VideoEngineSimpleCallback videoEngineSimpleCallback = this.B;
        if (videoEngineSimpleCallback != null) {
            videoEngineSimpleCallback.onBufferingUpdate(this, i4);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        TTVideoEngineLog.i("TTVideoEngine", "receive onCompletion,this:" + this);
        if (!this.f24852v) {
            this.X = true;
            e(0);
            com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
            if (aVar != null) {
                aVar.e();
                this.G.b(this.W.b());
            }
            this.G.a(3);
            this.f24820a = false;
            this.f24845o = false;
            this.f24846p = false;
            this.f24828e = 0;
            this.R = false;
            this.f24838j = false;
        }
        VideoEngineSimpleCallback videoEngineSimpleCallback = this.B;
        if (videoEngineSimpleCallback != null) {
            videoEngineSimpleCallback.onCompletion(this);
        }
        if (mediaPlayer != null && mediaPlayer.isOSPlayer()) {
            this.f24834h = false;
        }
        this.J = 0;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i4, int i5) {
        com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
        if (aVar != null) {
            aVar.e();
        }
        e(3);
        a(3, -1);
        Error error = new Error((mediaPlayer == null || !mediaPlayer.isOSPlayer()) ? Error.VideoOwnPlayer : Error.VideoOSPlayer, i4, i5, null);
        this.S = error;
        b(error);
        return true;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i4, int i5) {
        if (i4 == -268435438) {
            TTVideoEngineLog.i("TTVideoEngine", "player position update " + i5);
            this.f24827d0 = i5;
        } else if (i4 == 3) {
            TTVideoEngineLog.i("TTVideoEngine", "player callback render start");
            k();
        } else if (i4 == 801) {
            c(false);
        } else if (i4 == 251658248) {
            d(i5);
        } else if (i4 == 251658252) {
            c();
        } else if (i4 == 701) {
            c(i5);
        } else if (i4 == 702) {
            b(i5);
        }
        return false;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        TTVideoEngineLog.i("TTVideoEngine", "onPrepared");
        if (this.U) {
            return;
        }
        if (mediaPlayer == null) {
            TTVideoEngineLog.e("TTVideoEngine", "onPrepared mediaPlayer is null!");
            return;
        }
        int intOption = mediaPlayer.getIntOption(141, -1);
        TTVideoEngineLog.i("TTVideoEngine", "onPrepared videoCodecId " + intOption);
        this.S = null;
        int duration = mediaPlayer.getDuration();
        this.f24843m = duration;
        this.f24834h = true;
        this.G.e(duration);
        VideoEngineSimpleCallback videoEngineSimpleCallback = this.B;
        if (videoEngineSimpleCallback != null) {
            videoEngineSimpleCallback.onPrepared(this);
        }
        if ((this.f24836i || !this.T) && this.f24830f) {
            return;
        }
        mediaPlayer.start();
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        c(true);
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i4, int i5) {
        TTVideoEngineLog.i("TTVideoEngine", "video size changed = " + i4 + ", " + i5);
        VideoEngineSimpleCallback videoEngineSimpleCallback = this.B;
        if (videoEngineSimpleCallback != null) {
            videoEngineSimpleCallback.onVideoSizeChanged(this, i4, i5);
        }
    }

    public void pause() {
        TTVideoEngineLog.i("TTVideoEngine", "pause, " + this);
        this.T = false;
        if (!this.f24834h) {
            this.f24836i = true;
            e(2);
            return;
        }
        if (this.H != null) {
            TTVideoEngineLog.i("TTVideoEngine", "player will pause");
            this.H.pause();
            e(2);
        }
        com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
        if (aVar != null) {
            aVar.e();
        }
    }

    public void play() {
        TTVideoEngineLog.i("TTVideoEngine", "play, " + this);
        if (this.f24822b == 5) {
            TTVideoEngineLog.e("TTVideoEngine", "already released, return");
            return;
        }
        boolean z3 = true;
        this.T = true;
        this.U = false;
        this.f24826d = false;
        if (!this.f24830f && this.f24825c0 <= 0 && !this.f24834h) {
            z3 = false;
        }
        a(z3);
        this.X = false;
    }

    public void prepare() {
        TTVideoEngineLog.i("TTVideoEngine", "prepare, " + this);
        this.f24830f = false;
        this.T = false;
        this.U = false;
        this.f24826d = false;
        a(false);
        this.X = false;
    }

    public void release() {
        TTVideoEngineLog.i("TTVideoEngine", "release, " + this);
        this.U = true;
        this.T = false;
        a(false, 1);
        MediaPlayer mediaPlayer = this.H;
        this.H = null;
        if (mediaPlayer != null) {
            EngineThreadPool.a().execute(new a(this, mediaPlayer));
        }
        e();
        this.f24822b = 5;
    }

    public void reset() {
        b();
    }

    public void seekTo(int i4, SeekCompletionListener seekCompletionListener) {
        TTVideoEngineLog.i("TTVideoEngine", "seek to time:" + i4);
        this.C = seekCompletionListener;
        a(i4);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j4, long j5) {
        this.f24829e0 = j4;
        this.f24831f0 = j5;
        b();
        this.f24833g0 = fileDescriptor;
    }

    public void setDirectURL(String str) {
        a(str);
    }

    public void setDirectUrlUseDataLoader(String str, String str2) {
        setDirectUrlUseDataLoader(str, str2, this.f24855y);
    }

    public void setDirectUrlUseDataLoader(String str, String str2, String str3) {
        setDirectUrlUseDataLoader(str, str2, str3, (String) null);
    }

    public void setDirectUrlUseDataLoader(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setDirectUrlUseDataLoader(new String[]{str}, str2, str3, str4);
    }

    public void setDirectUrlUseDataLoader(String[] strArr, String str, String str2, String str3) {
        if (strArr == null || strArr.length == 0 || TextUtils.isEmpty(strArr[0])) {
            TTVideoEngineLog.e("TTVideoEngine", "invalid urls list, it is empty");
            return;
        }
        this.f24855y = str2;
        if (TextUtils.isEmpty(str) || !this.f24850t) {
            a(strArr[0]);
            return;
        }
        n();
        TTVideoEngineLog.i("TTVideoEngine", "setDirectUrlUseDataLoader key:" + str + ", videoId:" + str2 + ", filePath:" + str3);
        String a4 = a(str, str2, 0L, strArr, str3);
        if (!this.Z.contains(str)) {
            this.Z.add(str);
        }
        if (TextUtils.isEmpty(a4)) {
            setDirectURL(strArr[0]);
        } else {
            setDirectURL(a4);
        }
    }

    public void setIntOption(int i4, int i5) {
        MediaPlayer mediaPlayer;
        int i6;
        if (i4 == 11) {
            this.f24848r = i5;
            mediaPlayer = this.H;
            if (mediaPlayer != null) {
                i6 = 81;
                mediaPlayer.setIntOption(i6, i5);
            }
        } else if (i4 == 12) {
            this.f24849s = i5;
            MediaPlayer mediaPlayer2 = this.H;
            if (mediaPlayer2 != null) {
                mediaPlayer2.setIntOption(9, 1000000 * i5);
            }
        } else if (i4 == 118) {
            this.f24839j0 = i5;
            mediaPlayer = this.H;
            if (mediaPlayer != null) {
                i6 = 86;
                mediaPlayer.setIntOption(i6, i5);
            }
        } else if (i4 == 160) {
            this.f24850t = i5 >= 1;
            TTVideoEngineLog.d("TTVideoEngine", "DataLoaderEnable is: " + this.f24850t);
        } else if (i4 == 202) {
            this.f24841k0 = i5;
            mediaPlayer = this.H;
            if (mediaPlayer != null) {
                i6 = 110;
                mediaPlayer.setIntOption(i6, i5);
            }
        } else if (i4 == 322) {
            this.f24837i0 = i5;
            mediaPlayer = this.H;
            if (mediaPlayer != null) {
                i6 = 211;
                mediaPlayer.setIntOption(i6, i5);
            }
        } else if (i4 == 472) {
            this.f24847q = i5;
            MediaPlayer mediaPlayer3 = this.H;
            if (mediaPlayer3 != null) {
                mediaPlayer3.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, i5);
            }
            DataLoaderHelper.getDataLoader().setIntValue(512, i5);
        }
        TTVideoEngineLog.i("TTVideoEngine", "set int option key:" + i4 + " value:" + i5);
    }

    public void setIsMute(boolean z3) {
        TTVideoEngineLog.i("TTVideoEngine", String.format("setIsMute:%s", Boolean.valueOf(z3)));
        this.K = z3;
        b(z3);
    }

    public void setLocalURL(String str) {
        if (str != null && !str.equals(this.N)) {
            TTVideoEngineLog.i("TTVideoEngine", String.format("set local url:%s", str));
            b();
        }
        this.f24838j = false;
        this.M = true;
        this.N = str;
    }

    public void setLooping(boolean z3) {
        TTVideoEngineLog.i("TTVideoEngine", "setLooping:" + z3);
        this.f24852v = z3;
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(z3);
        }
    }

    public void setMaxRetryCount(int i4) {
        this.f24851u = i4;
    }

    public void setScreenOnWhilePlaying(boolean z3) {
        TTVideoEngineLog.i("TTVideoEngine", "setScreenOnWhilePlaying:" + z3);
        this.f24853w = z3;
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer != null) {
            mediaPlayer.setScreenOnWhilePlaying(z3);
        }
    }

    public void setStartTime(int i4) {
        TTVideoEngineLog.i("TTVideoEngine", "setStartTime:" + i4);
        this.J = i4;
    }

    public void setSurface(Surface surface) {
        TTVideoEngineLog.i("TTVideoEngine", "setSurface surface:" + surface + ", pre-surface:" + this.E + ", this:" + this);
        a(surface);
    }

    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        Surface surface;
        TTVideoEngineLog.i("TTVideoEngine", "setSurfaceHolder = " + surfaceHolder + ", this:" + this);
        this.F = surfaceHolder;
        if (surfaceHolder == null) {
            surface = null;
        } else {
            com.bykv.vk.component.ttvideo.b bVar = new com.bykv.vk.component.ttvideo.b(this);
            this.f24835h0 = bVar;
            this.F.addCallback(bVar);
            surface = this.F.getSurface();
        }
        a(surface);
    }

    public void setTrackVolume(float f4) {
        TTVideoEngineLog.i("TTVideoEngine", "setTrackVolume " + f4);
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer == null) {
            return;
        }
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        if (f4 > 1.0f) {
            f4 = 1.0f;
        }
        this.f24819L = f4;
        mediaPlayer.setVolume(f4, f4);
    }

    public void setVideoEngineSimpleCallback(VideoEngineSimpleCallback videoEngineSimpleCallback) {
        TTVideoEngineLog.d("TTVideoEngine", "setVideoEngineSimpleCallback " + videoEngineSimpleCallback);
        this.B = videoEngineSimpleCallback;
    }

    public void setWakeMode(int i4) {
        TTVideoEngineLog.i("TTVideoEngine", "setWakeMode:" + i4);
        this.f24854x = i4;
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer != null) {
            mediaPlayer.setWakeMode(this.D, i4);
        }
    }

    public void start() {
        TTVideoEngineLog.i("TTVideoEngine", "start, " + this);
        this.T = true;
        this.U = false;
        this.f24826d = false;
        a(true);
        this.X = false;
    }

    public void stop() {
        TTVideoEngineLog.i("TTVideoEngine", "stop, " + this);
        this.T = false;
        this.f24823b0 = false;
        this.U = true;
        a(true, 0);
        e();
    }

    @Override // com.bykv.vk.component.ttvideo.log.a
    public Map versionInfo() {
        HashMap hashMap = new HashMap();
        String value = TTPlayerConfiger.getValue(14, "");
        TTVideoEngineLog.i("TTVideoEngine", "SDK version:1.0.2, player version:" + value);
        hashMap.put("pc", value);
        hashMap.put("sdk_version", "1.0.2");
        hashMap.put("sv", "5.6");
        return hashMap;
    }
}

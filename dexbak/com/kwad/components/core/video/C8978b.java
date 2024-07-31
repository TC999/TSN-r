package com.kwad.components.core.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.video.p331a.AbstractC8971a;
import com.kwad.components.core.video.p331a.C8974d;
import com.kwad.components.core.video.p331a.InterfaceC8973c;
import com.kwad.sdk.contentalliance.p383a.p384a.C9877a;
import com.kwad.sdk.contentalliance.p383a.p384a.C9878b;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.p411a.C10532d;
import com.kwad.sdk.core.video.p411a.C10535e;
import com.kwad.sdk.core.video.p411a.InterfaceC10522c;
import com.kwad.sdk.core.video.p411a.p412a.C10519a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.utils.C11095g;
import com.stub.StubApp;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.kwad.components.core.video.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8978b {

    /* renamed from: TL */
    private static boolean f28949TL;

    /* renamed from: TM */
    private static final AtomicInteger f28950TM = new AtomicInteger(0);
    private final String TAG;

    /* renamed from: TN */
    private volatile int f28951TN;

    /* renamed from: TO */
    private InterfaceC10522c f28952TO;

    /* renamed from: TP */
    private int f28953TP;

    /* renamed from: TQ */
    private long f28954TQ;

    /* renamed from: TR */
    private Runnable f28955TR;

    /* renamed from: TS */
    private C9878b f28956TS;

    /* renamed from: TT */
    private int f28957TT;

    /* renamed from: TU */
    private List<InterfaceC10522c.InterfaceC10526d> f28958TU;

    /* renamed from: TV */
    private final AtomicBoolean f28959TV;

    /* renamed from: TW */
    private boolean f28960TW;

    /* renamed from: TX */
    private final int f28961TX;

    /* renamed from: TY */
    private volatile List<InterfaceC9001k> f28962TY;

    /* renamed from: TZ */
    private volatile List<InterfaceC8973c> f28963TZ;

    /* renamed from: Tv */
    private int f28964Tv;

    /* renamed from: Tw */
    private int f28965Tw;

    /* renamed from: Ua */
    private volatile List<InterfaceC10522c.InterfaceC10527e> f28966Ua;

    /* renamed from: Ub */
    private final InterfaceC10522c.InterfaceC10528f f28967Ub;

    /* renamed from: Uc */
    private InterfaceC10522c.InterfaceC10527e f28968Uc;

    /* renamed from: Ud */
    private InterfaceC10522c.InterfaceC10531i f28969Ud;

    /* renamed from: Ue */
    private InterfaceC10522c.InterfaceC10524b f28970Ue;

    /* renamed from: Uf */
    private InterfaceC10522c.InterfaceC10525c f28971Uf;

    /* renamed from: Ug */
    private InterfaceC10522c.InterfaceC10526d f28972Ug;

    /* renamed from: Uh */
    private InterfaceC10522c.InterfaceC10523a f28973Uh;

    /* renamed from: fS */
    private Handler f28974fS;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private long mStartTime;

    /* renamed from: com.kwad.components.core.video.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8990a {
        @WorkerThread
        void onReleaseSuccess();
    }

    public C8978b(@Nullable DetailVideoView detailVideoView) {
        this(detailVideoView, 0);
    }

    /* renamed from: aM */
    private void m29473aM(int i) {
        for (InterfaceC8973c interfaceC8973c : this.f28963TZ) {
            if (i == 0) {
                interfaceC8973c.onStart();
            } else if (i == 1) {
                interfaceC8973c.onReset();
            } else if (i == 2) {
                try {
                    interfaceC8973c.onRelease();
                } catch (Exception e) {
                    C10331c.printStackTrace(e);
                }
            }
        }
    }

    /* renamed from: aP */
    private void m29472aP(final boolean z) {
        if (this.f28952TO == null) {
            return;
        }
        C10331c.m26248i(this.TAG, "start prepareAsync");
        if (this.f28960TW) {
            if (this.f28959TV.compareAndSet(false, true)) {
                C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.video.b.10
                    /* JADX WARN: Removed duplicated region for block: B:19:0x0071 A[Catch: all -> 0x007c, TRY_ENTER, TryCatch #5 {Exception -> 0x007f, blocks: (B:17:0x006a, B:18:0x0070, B:19:0x0071, B:20:0x007a), top: B:34:0x006a }] */
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void doTask() {
                        /*
                            r5 = this;
                            com.kwad.components.core.video.b r0 = com.kwad.components.core.video.C8978b.this
                            java.lang.String r0 = com.kwad.components.core.video.C8978b.m29466c(r0)
                            java.lang.StringBuilder r1 = new java.lang.StringBuilder
                            java.lang.String r2 = "prepareAsync now:"
                            r1.<init>(r2)
                            com.kwad.components.core.video.b r2 = com.kwad.components.core.video.C8978b.this
                            int r2 = com.kwad.components.core.video.C8978b.m29470b(r2)
                            java.lang.String r2 = com.kwad.components.core.video.C8978b.getStateString(r2)
                            r1.append(r2)
                            java.lang.String r1 = r1.toString()
                            com.kwad.sdk.core.p397e.C10331c.m26248i(r0, r1)
                            com.kwad.components.core.video.b r0 = com.kwad.components.core.video.C8978b.this
                            com.kwad.sdk.core.video.a.c r0 = com.kwad.components.core.video.C8978b.m29460e(r0)
                            if (r0 != 0) goto L2a
                            return
                        L2a:
                            r0 = 0
                            com.kwad.components.core.video.b r1 = com.kwad.components.core.video.C8978b.this     // Catch: java.lang.Throwable -> L47
                            com.kwad.sdk.core.video.a.c r1 = com.kwad.components.core.video.C8978b.m29460e(r1)     // Catch: java.lang.Throwable -> L47
                            monitor-enter(r1)     // Catch: java.lang.Throwable -> L47
                            com.kwad.components.core.video.b r2 = com.kwad.components.core.video.C8978b.this     // Catch: java.lang.Throwable -> L44
                            boolean r3 = r2     // Catch: java.lang.Throwable -> L44
                            com.kwad.components.core.video.C8978b.m29483a(r2, r3)     // Catch: java.lang.Throwable -> L44
                            monitor-exit(r1)     // Catch: java.lang.Throwable -> L44
                        L3a:
                            com.kwad.components.core.video.b r1 = com.kwad.components.core.video.C8978b.this
                            java.util.concurrent.atomic.AtomicBoolean r1 = com.kwad.components.core.video.C8978b.m29457h(r1)
                            r1.set(r0)
                            goto L6a
                        L44:
                            r2 = move-exception
                            monitor-exit(r1)     // Catch: java.lang.Throwable -> L44
                            throw r2     // Catch: java.lang.Throwable -> L47
                        L47:
                            r1 = move-exception
                            com.kwad.components.core.video.b r2 = com.kwad.components.core.video.C8978b.this     // Catch: java.lang.Throwable -> L84
                            java.lang.String r2 = com.kwad.components.core.video.C8978b.m29466c(r2)     // Catch: java.lang.Throwable -> L84
                            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L84
                            java.lang.String r4 = "prepareAsync Exception:"
                            r3.<init>(r4)     // Catch: java.lang.Throwable -> L84
                            com.kwad.components.core.video.b r4 = com.kwad.components.core.video.C8978b.this     // Catch: java.lang.Throwable -> L84
                            int r4 = com.kwad.components.core.video.C8978b.m29470b(r4)     // Catch: java.lang.Throwable -> L84
                            java.lang.String r4 = com.kwad.components.core.video.C8978b.getStateString(r4)     // Catch: java.lang.Throwable -> L84
                            r3.append(r4)     // Catch: java.lang.Throwable -> L84
                            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L84
                            com.kwad.sdk.core.p397e.C10331c.m26249e(r2, r3, r1)     // Catch: java.lang.Throwable -> L84
                            goto L3a
                        L6a:
                            com.kwad.components.core.video.b r0 = com.kwad.components.core.video.C8978b.this     // Catch: java.lang.Exception -> L7f
                            java.util.concurrent.atomic.AtomicBoolean r0 = com.kwad.components.core.video.C8978b.m29457h(r0)     // Catch: java.lang.Exception -> L7f
                            monitor-enter(r0)     // Catch: java.lang.Exception -> L7f
                            com.kwad.components.core.video.b r1 = com.kwad.components.core.video.C8978b.this     // Catch: java.lang.Throwable -> L7c
                            java.util.concurrent.atomic.AtomicBoolean r1 = com.kwad.components.core.video.C8978b.m29457h(r1)     // Catch: java.lang.Throwable -> L7c
                            r1.notifyAll()     // Catch: java.lang.Throwable -> L7c
                            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7c
                            goto L83
                        L7c:
                            r1 = move-exception
                            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7c
                            throw r1     // Catch: java.lang.Exception -> L7f
                        L7f:
                            r0 = move-exception
                            com.kwad.sdk.core.p397e.C10331c.printStackTrace(r0)
                        L83:
                            return
                        L84:
                            r1 = move-exception
                            com.kwad.components.core.video.b r2 = com.kwad.components.core.video.C8978b.this
                            java.util.concurrent.atomic.AtomicBoolean r2 = com.kwad.components.core.video.C8978b.m29457h(r2)
                            r2.set(r0)
                            goto L90
                        L8f:
                            throw r1
                        L90:
                            goto L8f
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.video.C8978b.C898010.doTask():void");
                    }
                });
                return;
            }
            return;
        }
        try {
            m29471aQ(z);
        } catch (Throwable th) {
            if (getMediaPlayerType() != 2) {
                int i = this.f28957TT;
                this.f28957TT = i + 1;
                if (i <= 4) {
                    m29445rv();
                }
            }
            String str = this.TAG;
            C10331c.m26248i(str, "prepareAsync Exception:" + getStateString(this.f28951TN));
            C10331c.printStackTrace(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aQ */
    public void m29471aQ(boolean z) {
        boolean prepareAsync;
        m29481a(this.f28956TS);
        if (z) {
            prepareAsync = this.f28952TO.mo25542FZ();
        } else {
            prepareAsync = this.f28952TO.prepareAsync();
        }
        String str = this.TAG;
        C10331c.m26248i(str, "prepareAsync forcePrepare: " + z + ", result: " + prepareAsync);
    }

    public static String getStateString(int i) {
        switch (i) {
            case -1:
                return "STATE_ERROR";
            case 0:
                return "STATE_IDLE";
            case 1:
                return "STATE_PREPARING";
            case 2:
                return "STATE_PREPARED";
            case 3:
                return "STATE_STARTED";
            case 4:
                return "STATE_PLAYING";
            case 5:
                return "STATE_PAUSED";
            case 6:
                return "STATE_BUFFERING_PLAYING";
            case 7:
                return "STATE_BUFFERING_PAUSED";
            case 8:
                return "PLAYER_STATE_STOPPED";
            case 9:
                return "STATE_COMPLETED";
            default:
                return "STATE_UNKNOWN";
        }
    }

    private void reset() {
        String str = this.TAG;
        C10331c.m26248i(str, "reset:" + getStateString(this.f28951TN) + "->STATE_IDLE");
        m29473aM(1);
        this.f28952TO.reset();
        this.f28951TN = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: rq */
    public void m29449rq() {
        long currentPosition = getCurrentPosition();
        long duration = getDuration();
        if (this.f28962TY != null) {
            for (InterfaceC9001k interfaceC9001k : this.f28962TY) {
                interfaceC9001k.onMediaPlayProgress(duration, currentPosition);
            }
        }
    }

    /* renamed from: rt */
    private void m29447rt() {
        this.f28952TO.mo25552a(this.f28967Ub);
        this.f28952TO.mo25548b(this.f28968Uc);
        this.f28952TO.mo25549a(this.f28969Ud);
        this.f28952TO.mo25554a(this.f28970Ue);
        this.f28952TO.mo25553a(this.f28971Uf);
        this.f28952TO.mo25547c(this.f28972Ug);
        this.f28952TO.mo25555a(this.f28973Uh);
    }

    /* renamed from: ru */
    private void m29446ru() {
        InterfaceC10522c interfaceC10522c = this.f28952TO;
        if (interfaceC10522c == null) {
            return;
        }
        interfaceC10522c.mo25553a((InterfaceC10522c.InterfaceC10525c) null);
        this.f28952TO.mo25554a((InterfaceC10522c.InterfaceC10524b) null);
        this.f28952TO.mo25548b(null);
        this.f28952TO.mo25549a((InterfaceC10522c.InterfaceC10531i) null);
        this.f28952TO.mo25547c(null);
        this.f28952TO.mo25551a((InterfaceC10522c.InterfaceC10529g) null);
        this.f28952TO.mo25555a((InterfaceC10522c.InterfaceC10523a) null);
    }

    /* renamed from: rw */
    private void m29444rw() {
        m29443rx();
        if (this.f28955TR == null) {
            this.f28955TR = new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.video.b.3
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    C8978b.this.m29449rq();
                    if (C8978b.this.f28955TR != null) {
                        C8978b.this.f28974fS.postDelayed(C8978b.this.f28955TR, 500L);
                    }
                }
            };
        }
        this.f28974fS.post(this.f28955TR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: rx */
    public void m29443rx() {
        Runnable runnable = this.f28955TR;
        if (runnable != null) {
            this.f28974fS.removeCallbacks(runnable);
            this.f28955TR = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeepScreenOn(boolean z) {
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            detailVideoView.setKeepScreenOn(z);
        }
    }

    private void setPlayType(int i) {
        VideoPlayerStatus videoPlayerStatus;
        C9878b c9878b = this.f28956TS;
        if (c9878b == null || (videoPlayerStatus = c9878b.videoPlayerStatus) == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = i;
    }

    public final void clear() {
        this.f28962TY.clear();
        this.f28963TZ.clear();
    }

    public final int getBufferPercentage() {
        return this.f28953TP;
    }

    public final String getCurrentPlayingUrl() {
        InterfaceC10522c interfaceC10522c = this.f28952TO;
        return interfaceC10522c == null ? "" : interfaceC10522c.getCurrentPlayingUrl();
    }

    public final long getCurrentPosition() {
        InterfaceC10522c interfaceC10522c = this.f28952TO;
        if (interfaceC10522c != null) {
            return interfaceC10522c.getCurrentPosition();
        }
        return 0L;
    }

    public final long getDuration() {
        InterfaceC10522c interfaceC10522c = this.f28952TO;
        if (interfaceC10522c != null) {
            return interfaceC10522c.getDuration();
        }
        return 0L;
    }

    public final int getMediaPlayerType() {
        InterfaceC10522c interfaceC10522c = this.f28952TO;
        if (interfaceC10522c != null) {
            return interfaceC10522c.getMediaPlayerType();
        }
        return 0;
    }

    public final long getPlayDuration() {
        InterfaceC10522c interfaceC10522c = this.f28952TO;
        if (interfaceC10522c != null) {
            return interfaceC10522c.getCurrentPosition();
        }
        return 0L;
    }

    public final int getVideoHeight() {
        InterfaceC10522c interfaceC10522c = this.f28952TO;
        if (interfaceC10522c != null) {
            return interfaceC10522c.getVideoHeight();
        }
        return 0;
    }

    public final int getVideoWidth() {
        InterfaceC10522c interfaceC10522c = this.f28952TO;
        if (interfaceC10522c != null) {
            return interfaceC10522c.getVideoWidth();
        }
        return 0;
    }

    public final boolean isPlaying() {
        InterfaceC10522c interfaceC10522c = this.f28952TO;
        if (interfaceC10522c != null) {
            return interfaceC10522c.isPlaying();
        }
        return false;
    }

    @Deprecated
    public final boolean isPrepared() {
        return this.f28951TN == 2 || this.f28951TN == 3 || this.f28951TN == 5 || this.f28951TN == 8 || this.f28951TN == 9;
    }

    @Deprecated
    public final boolean isPreparing() {
        return this.f28951TN == 1;
    }

    public final void onPlayStateChanged(final int i) {
        if (this.f28962TY == null) {
            return;
        }
        C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.video.b.2
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                for (InterfaceC9001k interfaceC9001k : C8978b.this.f28962TY) {
                    switch (i) {
                        case -1:
                            C8978b.this.setKeepScreenOn(false);
                            C8978b.this.m29443rx();
                            interfaceC9001k.onMediaPlayError(C8978b.this.f28964Tv, C8978b.this.f28965Tw);
                            break;
                        case 1:
                            interfaceC9001k.onMediaPreparing();
                            break;
                        case 2:
                            interfaceC9001k.onMediaPrepared();
                            break;
                        case 3:
                            C8978b.this.setKeepScreenOn(true);
                            interfaceC9001k.onMediaPlayStart();
                            break;
                        case 4:
                            C8978b.this.setKeepScreenOn(true);
                            interfaceC9001k.onMediaPlaying();
                            break;
                        case 5:
                            C8978b.this.setKeepScreenOn(false);
                            interfaceC9001k.onMediaPlayPaused();
                            break;
                        case 6:
                            interfaceC9001k.onVideoPlayBufferingPlaying();
                            break;
                        case 7:
                            interfaceC9001k.onVideoPlayBufferingPaused();
                            break;
                        case 9:
                            if (C8978b.this.f28952TO != null && !C8978b.this.f28952TO.isLooping()) {
                                C8978b.this.setKeepScreenOn(false);
                                C8978b.this.m29443rx();
                            }
                            interfaceC9001k.onMediaPlayCompleted();
                            break;
                    }
                }
            }
        });
    }

    public final boolean pause() {
        boolean z;
        String str = this.TAG;
        C10331c.m26248i(str, "pause mCurrentState: " + getStateString(this.f28951TN));
        if (this.f28951TN == 4) {
            this.f28952TO.pause();
            C10331c.m26248i(this.TAG, "pause STATE_PLAYING->STATE_PAUSED");
            this.f28951TN = 5;
            onPlayStateChanged(this.f28951TN);
            C10519a.m25561ev("videoPausePlay");
            z = true;
        } else {
            z = false;
        }
        if (this.f28951TN == 6) {
            this.f28952TO.pause();
            C10331c.m26248i(this.TAG, "pause STATE_BUFFERING_PLAYING->STATE_PAUSED");
            this.f28951TN = 7;
            onPlayStateChanged(this.f28951TN);
            z = true;
        }
        if (this.f28951TN == 3) {
            this.f28952TO.pause();
            C10331c.m26248i(this.TAG, "pause STATE_STARTED->STATE_PAUSED");
            this.f28951TN = 5;
            onPlayStateChanged(this.f28951TN);
            C10519a.m25561ev("videoPausePlay");
            z = true;
        }
        if (this.f28951TN == 9 && this.f28952TO.isLooping()) {
            this.f28952TO.pause();
            String str2 = this.TAG;
            C10331c.m26248i(str2, "pause " + getStateString(this.f28951TN) + "->STATE_PAUSED");
            this.f28951TN = 5;
            onPlayStateChanged(this.f28951TN);
            return true;
        }
        return z;
    }

    public final void prepareAsync() {
        m29472aP(false);
    }

    public final void release() {
        m29487a((InterfaceC8990a) null);
    }

    public final void releaseSync() {
        m29486a((InterfaceC8990a) null, false);
    }

    public final void restart() {
        if (this.f28952TO != null && this.f28951TN == 9) {
            start();
        }
        setPlayType(3);
    }

    public final void resume() {
        try {
            if (this.f28952TO == null) {
                C10331c.m26250e(this.TAG, "resume but mMediaPlayer is null");
                return;
            }
            String str = this.TAG;
            C10331c.m26248i(str, "resume state: " + getStateString(this.f28951TN));
            if (this.f28951TN != 2 && this.f28951TN != 3 && this.f28951TN != 0) {
                if (this.f28951TN == 5) {
                    this.f28952TO.start();
                    String str2 = this.TAG;
                    C10331c.m26248i(str2, "resume:" + getStateString(this.f28951TN) + "->STATE_PLAYING");
                    this.f28951TN = 4;
                    onPlayStateChanged(this.f28951TN);
                    setPlayType(2);
                    C10519a.m25561ev("videoResumePlay");
                    return;
                } else if (this.f28951TN == 7) {
                    this.f28952TO.start();
                    String str3 = this.TAG;
                    C10331c.m26248i(str3, "resume:" + getStateString(this.f28951TN) + "->STATE_BUFFERING_PLAYING");
                    this.f28951TN = 6;
                    onPlayStateChanged(this.f28951TN);
                    return;
                } else if (this.f28951TN != 1) {
                    String str4 = this.TAG;
                    C10331c.m26246w(str4, "resume: " + getStateString(this.f28951TN) + " 此时不能调用resume()方法.");
                    return;
                } else {
                    return;
                }
            }
            String str5 = this.TAG;
            C10331c.m26248i(str5, "resume:" + getStateString(this.f28951TN) + "->start()");
            start();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: rs */
    public final InterfaceC10522c m29448rs() {
        return this.f28952TO;
    }

    /* renamed from: rv */
    public final void m29445rv() {
        if (this.f28952TO == null) {
            C10331c.m26246w("resetAndPlay", "mMediaPlayer is null");
        } else if (this.f28951TN != 2 && this.f28951TN != 3 && this.f28951TN != 4 && this.f28951TN != 5) {
            reset();
            m29446ru();
            m29447rt();
            prepareAsync();
        } else {
            C10331c.m26246w("resetAndPlay", "can not resetAndPlay in state:");
        }
    }

    public final void seekTo(long j) {
        InterfaceC10522c interfaceC10522c = this.f28952TO;
        if (interfaceC10522c != null) {
            interfaceC10522c.seekTo(j);
        }
    }

    public final void setAudioEnabled(boolean z) {
        if (z) {
            setVolume(1.0f, 1.0f);
        } else {
            setVolume(0.0f, 0.0f);
        }
    }

    public final void setRadius(float f, float f2, float f3, float f4) {
        this.mDetailVideoView.setRadius(f, f2, f3, f4);
    }

    public final void setSpeed(float f) {
        InterfaceC10522c interfaceC10522c = this.f28952TO;
        if (interfaceC10522c == null) {
            return;
        }
        interfaceC10522c.setSpeed(f);
    }

    public final void setSurface(Surface surface) {
        InterfaceC10522c interfaceC10522c = this.f28952TO;
        if (interfaceC10522c != null) {
            interfaceC10522c.setSurface(surface);
        }
    }

    public final void setVolume(float f, float f2) {
        InterfaceC10522c interfaceC10522c = this.f28952TO;
        if (interfaceC10522c == null) {
            return;
        }
        try {
            interfaceC10522c.setVolume(f, f2);
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
        }
    }

    public final void start() {
        try {
            if (this.f28952TO == null) {
                return;
            }
            String str = this.TAG;
            C10331c.m26248i(str, "start state: " + getStateString(this.f28951TN));
            m29473aM(0);
            if (this.f28951TN == 0) {
                C10331c.m26248i(this.TAG, "start still not prepared well forcePrepare");
                m29472aP(true);
                return;
            }
            if (this.f28951TN != 2 && this.f28951TN != 9) {
                if (this.f28951TN == 3) {
                    this.f28952TO.start();
                    return;
                }
                return;
            }
            this.mStartTime = System.currentTimeMillis();
            this.f28952TO.start();
            C10519a.m25561ev("videoStartPlay");
            long j = this.f28954TQ;
            if (j != 0) {
                this.f28952TO.seekTo((int) j);
            }
            String str2 = this.TAG;
            C10331c.m26248i(str2, "start:" + getStateString(this.f28951TN) + "->STATE_STARTED");
            C9878b c9878b = this.f28956TS;
            if (c9878b != null && c9878b.videoPlayerStatus != null) {
                if (this.f28951TN == 2) {
                    if (this.f28956TS.videoPlayerStatus.mVideoPlayerType == 0) {
                        setPlayType(1);
                    } else {
                        setPlayType(3);
                    }
                } else if (this.f28951TN == 9) {
                    setPlayType(3);
                }
            }
            this.f28951TN = 3;
            onPlayStateChanged(this.f28951TN);
            m29444rw();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void stopAndPrepareAsync() {
        String str = this.TAG;
        C10331c.m26248i(str, "stopAndPrepareAsync state: " + getStateString(this.f28951TN));
        if (this.f28951TN == 1 || this.f28951TN == 2) {
            return;
        }
        if (this.f28951TN == 3 || this.f28951TN == 4 || this.f28951TN == 5 || this.f28951TN == 6 || this.f28951TN == 7 || this.f28951TN == 8 || this.f28951TN == 9) {
            try {
                this.f28952TO.stop();
                this.f28951TN = 8;
                onPlayStateChanged(this.f28951TN);
                prepareAsync();
                return;
            } catch (Exception unused) {
            }
        }
        release();
    }

    private C8978b(@Nullable DetailVideoView detailVideoView, int i) {
        this.f28951TN = 0;
        this.f28974fS = new Handler(Looper.getMainLooper());
        this.mStartTime = 0L;
        this.f28957TT = 0;
        this.f28958TU = new CopyOnWriteArrayList();
        this.f28959TV = new AtomicBoolean(false);
        this.f28960TW = false;
        this.f28962TY = new CopyOnWriteArrayList();
        this.f28963TZ = new CopyOnWriteArrayList();
        this.f28966Ua = new CopyOnWriteArrayList();
        this.f28967Ub = new InterfaceC10522c.InterfaceC10528f() { // from class: com.kwad.components.core.video.b.1
            @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c.InterfaceC10528f
            /* renamed from: ry */
            public final void mo25546ry() {
                C8978b.this.f28951TN = 1;
                C8978b c8978b = C8978b.this;
                c8978b.onPlayStateChanged(c8978b.f28951TN);
            }
        };
        this.f28968Uc = new InterfaceC10522c.InterfaceC10527e() { // from class: com.kwad.components.core.video.b.4
            @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c.InterfaceC10527e
            /* renamed from: a */
            public final void mo25501a(InterfaceC10522c interfaceC10522c) {
                try {
                    String str = C8978b.this.TAG;
                    C10331c.m26248i(str, "onPrepared:" + C8978b.getStateString(C8978b.this.f28951TN) + "->STATE_PREPARED");
                    C8978b.this.f28951TN = 2;
                    C8978b c8978b = C8978b.this;
                    c8978b.onPlayStateChanged(c8978b.f28951TN);
                    for (InterfaceC10522c.InterfaceC10527e interfaceC10527e : C8978b.this.f28966Ua) {
                        interfaceC10527e.mo25501a(C8978b.this.f28952TO);
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
        this.f28969Ud = new InterfaceC10522c.InterfaceC10531i() { // from class: com.kwad.components.core.video.b.5
            @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c.InterfaceC10531i
            /* renamed from: k */
            public final void mo25500k(int i2, int i3) {
                if (C8978b.this.mDetailVideoView != null) {
                    C8978b.this.mDetailVideoView.adaptVideoSize(i2, i3);
                }
                String str = C8978b.this.TAG;
                C10331c.m26248i(str, "onVideoSizeChanged ——> width：" + i2 + "， height：" + i3);
            }
        };
        this.f28970Ue = new InterfaceC10522c.InterfaceC10524b() { // from class: com.kwad.components.core.video.b.6
            @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c.InterfaceC10524b
            /* renamed from: oZ */
            public final void mo25499oZ() {
                C8978b.this.f28951TN = 9;
                C8978b c8978b = C8978b.this;
                c8978b.onPlayStateChanged(c8978b.f28951TN);
                C10519a.m25561ev("videoFinishPlay");
            }
        };
        this.f28971Uf = new InterfaceC10522c.InterfaceC10525c() { // from class: com.kwad.components.core.video.b.7
            @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c.InterfaceC10525c
            /* renamed from: l */
            public final boolean mo25498l(int i2, int i3) {
                if (i2 != -38) {
                    C8978b.this.f28951TN = -1;
                    C8978b.this.f28964Tv = i2;
                    C8978b.this.f28965Tw = i3;
                    C8978b c8978b = C8978b.this;
                    c8978b.onPlayStateChanged(c8978b.f28951TN);
                    String str = C8978b.this.TAG;
                    C10331c.m26248i(str, "onError ——> STATE_ERROR ———— what：" + i2 + ", extra: " + i3);
                    return true;
                }
                return true;
            }
        };
        this.f28972Ug = new InterfaceC10522c.InterfaceC10526d() { // from class: com.kwad.components.core.video.b.8
            @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c.InterfaceC10526d
            /* renamed from: m */
            public final boolean mo25497m(int i2, int i3) {
                if (i2 == 3) {
                    C8978b.this.f28951TN = 4;
                    C8978b c8978b = C8978b.this;
                    c8978b.onPlayStateChanged(c8978b.f28951TN);
                    String str = C8978b.this.TAG;
                    C10331c.m26248i(str, "onInfo:" + C8978b.getStateString(C8978b.this.f28951TN) + "->STATE_PLAYING, time: " + (System.currentTimeMillis() - C8978b.this.mStartTime));
                } else if (i2 == 701) {
                    if (C8978b.this.f28951TN == 5 || C8978b.this.f28951TN == 7) {
                        C8978b.this.f28951TN = 7;
                        C10331c.m26248i(C8978b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED");
                    } else {
                        C8978b.this.f28951TN = 6;
                        C10331c.m26248i(C8978b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING");
                    }
                    C8978b c8978b2 = C8978b.this;
                    c8978b2.onPlayStateChanged(c8978b2.f28951TN);
                } else if (i2 == 702) {
                    if (C8978b.this.f28951TN == 6) {
                        C8978b.this.f28951TN = 4;
                        C8978b c8978b3 = C8978b.this;
                        c8978b3.onPlayStateChanged(c8978b3.f28951TN);
                        C10331c.m26248i(C8978b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                    }
                    if (C8978b.this.f28951TN == 7) {
                        C8978b.this.f28951TN = 5;
                        C8978b c8978b4 = C8978b.this;
                        c8978b4.onPlayStateChanged(c8978b4.f28951TN);
                        C10331c.m26248i(C8978b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED");
                    }
                } else if (i2 != 10001) {
                    if (i2 == 801) {
                        C10331c.m26248i(C8978b.this.TAG, "视频不能seekTo，为直播视频");
                    } else {
                        String str2 = C8978b.this.TAG;
                        C10331c.m26248i(str2, "onInfo ——> what：" + i2);
                    }
                }
                C8978b c8978b5 = C8978b.this;
                c8978b5.m29475a(c8978b5.f28952TO, i2, i3);
                return true;
            }
        };
        this.f28973Uh = new InterfaceC10522c.InterfaceC10523a() { // from class: com.kwad.components.core.video.b.9
            @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c.InterfaceC10523a
            /* renamed from: av */
            public final void mo25496av(int i2) {
                C8978b.this.f28953TP = i2;
            }
        };
        this.mDetailVideoView = detailVideoView;
        if (detailVideoView != null) {
            this.mContext = StubApp.getOrigApplicationContext(detailVideoView.getContext().getApplicationContext());
        }
        this.f28961TX = 0;
        String str = "DetailMediaPlayerImpl[0]";
        this.TAG = str;
        C10331c.m26248i(str, "create DetailMediaPlayerImpl");
    }

    /* renamed from: c */
    public final void m29464c(InterfaceC9001k interfaceC9001k) {
        this.f28962TY.add(interfaceC9001k);
    }

    /* renamed from: d */
    public final void m29461d(InterfaceC9001k interfaceC9001k) {
        this.f28962TY.remove(interfaceC9001k);
    }

    /* renamed from: a */
    public final void m29480a(@NonNull C9878b c9878b, @NonNull DetailVideoView detailVideoView) {
        m29478a(c9878b, true, false, detailVideoView);
    }

    /* renamed from: b */
    public final void m29467b(InterfaceC10522c.InterfaceC10526d interfaceC10526d) {
        if (interfaceC10526d == null) {
            return;
        }
        this.f28958TU.remove(interfaceC10526d);
    }

    /* renamed from: a */
    public final void m29478a(@NonNull C9878b c9878b, boolean z, boolean z2, @NonNull DetailVideoView detailVideoView) {
        String str = this.TAG;
        C10331c.m26248i(str, "initMediaPlayer enablePreLoad:" + z);
        if (c9878b == null || detailVideoView == null) {
            return;
        }
        InterfaceC10522c m25525a = C10535e.m25525a(this.mContext, z, C10251d.m26497yn(), C10251d.m26496yo(), this.f28961TX);
        m25525a.setLooping(false);
        m29479a(c9878b, z2, detailVideoView, m25525a);
    }

    /* renamed from: a */
    private void m29479a(@NonNull C9878b c9878b, boolean z, @NonNull DetailVideoView detailVideoView, @NonNull InterfaceC10522c interfaceC10522c) {
        String str = this.TAG;
        C10331c.m26248i(str, "initMediaPlayer " + this.f28952TO);
        if (c9878b == null || detailVideoView == null || interfaceC10522c == null) {
            return;
        }
        if (this.mContext == null) {
            this.mContext = StubApp.getOrigApplicationContext(detailVideoView.getContext().getApplicationContext());
        }
        this.f28960TW = z;
        this.f28956TS = c9878b;
        AbstractC8971a m29496a = C8974d.m29496a(c9878b.adTemplate, this.mAdTemplate, c9878b.videoUrl);
        m29464c(m29496a);
        m29488a(m29496a);
        DetailVideoView detailVideoView2 = this.mDetailVideoView;
        if (detailVideoView2 != detailVideoView) {
            C10331c.m26248i(this.TAG, "initMediaPlayer videoView changed");
            if (detailVideoView2 != null) {
                detailVideoView2.setMediaPlayer(null);
                detailVideoView.setKeepScreenOn(detailVideoView2.getKeepScreenOn());
                detailVideoView2.setKeepScreenOn(false);
            }
            this.mDetailVideoView = detailVideoView;
        }
        detailVideoView.setMediaPlayer(this);
        if (this.f28952TO != interfaceC10522c) {
            C10331c.m26248i(this.TAG, "initMediaPlayer mediaPlayer changed");
            InterfaceC10522c interfaceC10522c2 = this.f28952TO;
            if (interfaceC10522c2 != null) {
                interfaceC10522c.setLooping(interfaceC10522c2.isLooping());
                m29446ru();
                this.f28952TO.release();
            }
            this.f28952TO = interfaceC10522c;
            reset();
            m29447rt();
            interfaceC10522c.setAudioStreamType(3);
        } else {
            C10331c.m26248i(this.TAG, "initMediaPlayer mediaPlayer not changed");
            reset();
            m29446ru();
            m29447rt();
        }
        this.f28952TO.setSurface(detailVideoView.f28880Uq);
    }

    public C8978b(@Nullable DetailVideoView detailVideoView, @NonNull AdTemplate adTemplate) {
        this(detailVideoView);
        this.mAdTemplate = adTemplate;
    }

    public final void start(long j) {
        this.f28954TQ = j;
        start();
    }

    /* renamed from: a */
    public final void m29476a(InterfaceC10522c.InterfaceC10527e interfaceC10527e) {
        this.f28966Ua.add(interfaceC10527e);
    }

    /* renamed from: a */
    public final void m29477a(InterfaceC10522c.InterfaceC10526d interfaceC10526d) {
        if (interfaceC10526d == null) {
            return;
        }
        this.f28958TU.add(interfaceC10526d);
    }

    /* renamed from: a */
    public final void m29475a(InterfaceC10522c interfaceC10522c, int i, int i2) {
        Iterator<InterfaceC10522c.InterfaceC10526d> it = this.f28958TU.iterator();
        while (it.hasNext()) {
            InterfaceC10522c.InterfaceC10526d next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.mo25497m(i, i2);
            }
        }
    }

    /* renamed from: a */
    public final void m29481a(@NonNull C9878b c9878b) {
        try {
            if (!TextUtils.isEmpty(c9878b.videoUrl)) {
                String str = this.TAG;
                C10331c.m26254d(str, "videoUrl=" + c9878b.videoUrl);
                this.f28952TO.mo25536a(c9878b);
                return;
            }
            C10331c.m26250e(this.TAG, "videoUrl is null");
        } catch (Exception e) {
            C10331c.printStackTrace(e);
        }
    }

    /* renamed from: a */
    public final void m29486a(final InterfaceC8990a interfaceC8990a, boolean z) {
        if (this.f28952TO == null) {
            return;
        }
        String str = this.TAG;
        C10331c.m26248i(str, "release:" + getStateString(this.f28951TN) + "->STATE_IDLE");
        setKeepScreenOn(false);
        this.f28974fS.removeCallbacksAndMessages(null);
        m29443rx();
        m29446ru();
        this.mDetailVideoView = null;
        final InterfaceC10522c interfaceC10522c = this.f28952TO;
        if (interfaceC10522c != null) {
            if (z) {
                C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.video.b.11
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        C8978b.this.m29474a(interfaceC10522c, interfaceC8990a);
                    }
                });
            } else {
                m29474a(interfaceC10522c, interfaceC8990a);
            }
            this.f28952TO = null;
        }
        this.f28951TN = 0;
        this.f28957TT = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m29474a(InterfaceC10522c interfaceC10522c, InterfaceC8990a interfaceC8990a) {
        if (interfaceC10522c == null) {
            return;
        }
        String str = this.TAG;
        C10331c.m26248i(str, "releaseMediaPlayer:" + getStateString(this.f28951TN) + "->STATE_IDLE");
        try {
            m29473aM(2);
            interfaceC10522c.release();
            if (interfaceC8990a != null) {
                interfaceC8990a.onReleaseSuccess();
            }
        } catch (Throwable th) {
            C10331c.printStackTrace(th);
        }
    }

    /* renamed from: a */
    public final void m29487a(InterfaceC8990a interfaceC8990a) {
        m29486a(interfaceC8990a, true);
    }

    /* renamed from: a */
    private void m29488a(InterfaceC8973c interfaceC8973c) {
        this.f28963TZ.add(interfaceC8973c);
    }

    /* renamed from: a */
    public final void m29482a(C9877a c9877a) {
        InterfaceC10522c interfaceC10522c = this.f28952TO;
        if (interfaceC10522c instanceof C10532d) {
            ((C10532d) interfaceC10522c).m25537a(c9877a);
        }
    }
}

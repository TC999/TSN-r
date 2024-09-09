package com.kwad.components.core.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import com.stub.StubApp;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    private static boolean TL;
    private static final AtomicInteger TM = new AtomicInteger(0);
    private final String TAG;
    private volatile int TN;
    private com.kwad.sdk.core.video.a.c TO;
    private int TP;
    private long TQ;
    private Runnable TR;
    private com.kwad.sdk.contentalliance.a.a.b TS;
    private int TT;
    private List<c.d> TU;
    private final AtomicBoolean TV;
    private boolean TW;
    private final int TX;
    private volatile List<k> TY;
    private volatile List<com.kwad.components.core.video.a.c> TZ;
    private int Tv;
    private int Tw;
    private volatile List<c.e> Ua;
    private final c.f Ub;
    private c.e Uc;
    private c.i Ud;
    private c.b Ue;
    private c.InterfaceC0702c Uf;
    private c.d Ug;
    private c.a Uh;
    private Handler fS;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private long mStartTime;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        @WorkerThread
        void onReleaseSuccess();
    }

    public b(@Nullable DetailVideoView detailVideoView) {
        this(detailVideoView, 0);
    }

    private void aM(int i4) {
        for (com.kwad.components.core.video.a.c cVar : this.TZ) {
            if (i4 == 0) {
                cVar.onStart();
            } else if (i4 == 1) {
                cVar.onReset();
            } else if (i4 == 2) {
                try {
                    cVar.onRelease();
                } catch (Exception e4) {
                    com.kwad.sdk.core.e.c.printStackTrace(e4);
                }
            }
        }
    }

    private void aP(final boolean z3) {
        if (this.TO == null) {
            return;
        }
        com.kwad.sdk.core.e.c.i(this.TAG, "start prepareAsync");
        if (this.TW) {
            if (this.TV.compareAndSet(false, true)) {
                com.kwad.sdk.utils.g.execute(new ay() { // from class: com.kwad.components.core.video.b.10
                    /* JADX WARN: Removed duplicated region for block: B:19:0x0071 A[Catch: all -> 0x007c, TRY_ENTER, TryCatch #5 {Exception -> 0x007f, blocks: (B:17:0x006a, B:18:0x0070, B:19:0x0071, B:20:0x007a), top: B:34:0x006a }] */
                    @Override // com.kwad.sdk.utils.ay
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void doTask() {
                        /*
                            r5 = this;
                            com.kwad.components.core.video.b r0 = com.kwad.components.core.video.b.this
                            java.lang.String r0 = com.kwad.components.core.video.b.c(r0)
                            java.lang.StringBuilder r1 = new java.lang.StringBuilder
                            java.lang.String r2 = "prepareAsync now:"
                            r1.<init>(r2)
                            com.kwad.components.core.video.b r2 = com.kwad.components.core.video.b.this
                            int r2 = com.kwad.components.core.video.b.b(r2)
                            java.lang.String r2 = com.kwad.components.core.video.b.getStateString(r2)
                            r1.append(r2)
                            java.lang.String r1 = r1.toString()
                            com.kwad.sdk.core.e.c.i(r0, r1)
                            com.kwad.components.core.video.b r0 = com.kwad.components.core.video.b.this
                            com.kwad.sdk.core.video.a.c r0 = com.kwad.components.core.video.b.e(r0)
                            if (r0 != 0) goto L2a
                            return
                        L2a:
                            r0 = 0
                            com.kwad.components.core.video.b r1 = com.kwad.components.core.video.b.this     // Catch: java.lang.Throwable -> L47
                            com.kwad.sdk.core.video.a.c r1 = com.kwad.components.core.video.b.e(r1)     // Catch: java.lang.Throwable -> L47
                            monitor-enter(r1)     // Catch: java.lang.Throwable -> L47
                            com.kwad.components.core.video.b r2 = com.kwad.components.core.video.b.this     // Catch: java.lang.Throwable -> L44
                            boolean r3 = r2     // Catch: java.lang.Throwable -> L44
                            com.kwad.components.core.video.b.a(r2, r3)     // Catch: java.lang.Throwable -> L44
                            monitor-exit(r1)     // Catch: java.lang.Throwable -> L44
                        L3a:
                            com.kwad.components.core.video.b r1 = com.kwad.components.core.video.b.this
                            java.util.concurrent.atomic.AtomicBoolean r1 = com.kwad.components.core.video.b.h(r1)
                            r1.set(r0)
                            goto L6a
                        L44:
                            r2 = move-exception
                            monitor-exit(r1)     // Catch: java.lang.Throwable -> L44
                            throw r2     // Catch: java.lang.Throwable -> L47
                        L47:
                            r1 = move-exception
                            com.kwad.components.core.video.b r2 = com.kwad.components.core.video.b.this     // Catch: java.lang.Throwable -> L84
                            java.lang.String r2 = com.kwad.components.core.video.b.c(r2)     // Catch: java.lang.Throwable -> L84
                            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L84
                            java.lang.String r4 = "prepareAsync Exception:"
                            r3.<init>(r4)     // Catch: java.lang.Throwable -> L84
                            com.kwad.components.core.video.b r4 = com.kwad.components.core.video.b.this     // Catch: java.lang.Throwable -> L84
                            int r4 = com.kwad.components.core.video.b.b(r4)     // Catch: java.lang.Throwable -> L84
                            java.lang.String r4 = com.kwad.components.core.video.b.getStateString(r4)     // Catch: java.lang.Throwable -> L84
                            r3.append(r4)     // Catch: java.lang.Throwable -> L84
                            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L84
                            com.kwad.sdk.core.e.c.e(r2, r3, r1)     // Catch: java.lang.Throwable -> L84
                            goto L3a
                        L6a:
                            com.kwad.components.core.video.b r0 = com.kwad.components.core.video.b.this     // Catch: java.lang.Exception -> L7f
                            java.util.concurrent.atomic.AtomicBoolean r0 = com.kwad.components.core.video.b.h(r0)     // Catch: java.lang.Exception -> L7f
                            monitor-enter(r0)     // Catch: java.lang.Exception -> L7f
                            com.kwad.components.core.video.b r1 = com.kwad.components.core.video.b.this     // Catch: java.lang.Throwable -> L7c
                            java.util.concurrent.atomic.AtomicBoolean r1 = com.kwad.components.core.video.b.h(r1)     // Catch: java.lang.Throwable -> L7c
                            r1.notifyAll()     // Catch: java.lang.Throwable -> L7c
                            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7c
                            goto L83
                        L7c:
                            r1 = move-exception
                            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7c
                            throw r1     // Catch: java.lang.Exception -> L7f
                        L7f:
                            r0 = move-exception
                            com.kwad.sdk.core.e.c.printStackTrace(r0)
                        L83:
                            return
                        L84:
                            r1 = move-exception
                            com.kwad.components.core.video.b r2 = com.kwad.components.core.video.b.this
                            java.util.concurrent.atomic.AtomicBoolean r2 = com.kwad.components.core.video.b.h(r2)
                            r2.set(r0)
                            goto L90
                        L8f:
                            throw r1
                        L90:
                            goto L8f
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.video.b.AnonymousClass10.doTask():void");
                    }
                });
                return;
            }
            return;
        }
        try {
            aQ(z3);
        } catch (Throwable th) {
            if (getMediaPlayerType() != 2) {
                int i4 = this.TT;
                this.TT = i4 + 1;
                if (i4 <= 4) {
                    rv();
                }
            }
            String str = this.TAG;
            com.kwad.sdk.core.e.c.i(str, "prepareAsync Exception:" + getStateString(this.TN));
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(boolean z3) {
        boolean prepareAsync;
        a(this.TS);
        if (z3) {
            prepareAsync = this.TO.FZ();
        } else {
            prepareAsync = this.TO.prepareAsync();
        }
        String str = this.TAG;
        com.kwad.sdk.core.e.c.i(str, "prepareAsync forcePrepare: " + z3 + ", result: " + prepareAsync);
    }

    public static String getStateString(int i4) {
        switch (i4) {
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
        com.kwad.sdk.core.e.c.i(str, "reset:" + getStateString(this.TN) + "->STATE_IDLE");
        aM(1);
        this.TO.reset();
        this.TN = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rq() {
        long currentPosition = getCurrentPosition();
        long duration = getDuration();
        if (this.TY != null) {
            for (k kVar : this.TY) {
                kVar.onMediaPlayProgress(duration, currentPosition);
            }
        }
    }

    private void rt() {
        this.TO.a(this.Ub);
        this.TO.b(this.Uc);
        this.TO.a(this.Ud);
        this.TO.a(this.Ue);
        this.TO.a(this.Uf);
        this.TO.c(this.Ug);
        this.TO.a(this.Uh);
    }

    private void ru() {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar == null) {
            return;
        }
        cVar.a((c.InterfaceC0702c) null);
        this.TO.a((c.b) null);
        this.TO.b(null);
        this.TO.a((c.i) null);
        this.TO.c(null);
        this.TO.a((c.g) null);
        this.TO.a((c.a) null);
    }

    private void rw() {
        rx();
        if (this.TR == null) {
            this.TR = new ay() { // from class: com.kwad.components.core.video.b.3
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    b.this.rq();
                    if (b.this.TR != null) {
                        b.this.fS.postDelayed(b.this.TR, 500L);
                    }
                }
            };
        }
        this.fS.post(this.TR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rx() {
        Runnable runnable = this.TR;
        if (runnable != null) {
            this.fS.removeCallbacks(runnable);
            this.TR = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeepScreenOn(boolean z3) {
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            detailVideoView.setKeepScreenOn(z3);
        }
    }

    private void setPlayType(int i4) {
        VideoPlayerStatus videoPlayerStatus;
        com.kwad.sdk.contentalliance.a.a.b bVar = this.TS;
        if (bVar == null || (videoPlayerStatus = bVar.videoPlayerStatus) == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = i4;
    }

    public final void clear() {
        this.TY.clear();
        this.TZ.clear();
    }

    public final int getBufferPercentage() {
        return this.TP;
    }

    public final String getCurrentPlayingUrl() {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        return cVar == null ? "" : cVar.getCurrentPlayingUrl();
    }

    public final long getCurrentPosition() {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    public final long getDuration() {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar != null) {
            return cVar.getDuration();
        }
        return 0L;
    }

    public final int getMediaPlayerType() {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar != null) {
            return cVar.getMediaPlayerType();
        }
        return 0;
    }

    public final long getPlayDuration() {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    public final int getVideoHeight() {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar != null) {
            return cVar.getVideoHeight();
        }
        return 0;
    }

    public final int getVideoWidth() {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar != null) {
            return cVar.getVideoWidth();
        }
        return 0;
    }

    public final boolean isPlaying() {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar != null) {
            return cVar.isPlaying();
        }
        return false;
    }

    @Deprecated
    public final boolean isPrepared() {
        return this.TN == 2 || this.TN == 3 || this.TN == 5 || this.TN == 8 || this.TN == 9;
    }

    @Deprecated
    public final boolean isPreparing() {
        return this.TN == 1;
    }

    public final void onPlayStateChanged(final int i4) {
        if (this.TY == null) {
            return;
        }
        bn.runOnUiThread(new ay() { // from class: com.kwad.components.core.video.b.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                for (k kVar : b.this.TY) {
                    switch (i4) {
                        case -1:
                            b.this.setKeepScreenOn(false);
                            b.this.rx();
                            kVar.onMediaPlayError(b.this.Tv, b.this.Tw);
                            break;
                        case 1:
                            kVar.onMediaPreparing();
                            break;
                        case 2:
                            kVar.onMediaPrepared();
                            break;
                        case 3:
                            b.this.setKeepScreenOn(true);
                            kVar.onMediaPlayStart();
                            break;
                        case 4:
                            b.this.setKeepScreenOn(true);
                            kVar.onMediaPlaying();
                            break;
                        case 5:
                            b.this.setKeepScreenOn(false);
                            kVar.onMediaPlayPaused();
                            break;
                        case 6:
                            kVar.onVideoPlayBufferingPlaying();
                            break;
                        case 7:
                            kVar.onVideoPlayBufferingPaused();
                            break;
                        case 9:
                            if (b.this.TO != null && !b.this.TO.isLooping()) {
                                b.this.setKeepScreenOn(false);
                                b.this.rx();
                            }
                            kVar.onMediaPlayCompleted();
                            break;
                    }
                }
            }
        });
    }

    public final boolean pause() {
        boolean z3;
        String str = this.TAG;
        com.kwad.sdk.core.e.c.i(str, "pause mCurrentState: " + getStateString(this.TN));
        if (this.TN == 4) {
            this.TO.pause();
            com.kwad.sdk.core.e.c.i(this.TAG, "pause STATE_PLAYING->STATE_PAUSED");
            this.TN = 5;
            onPlayStateChanged(this.TN);
            com.kwad.sdk.core.video.a.a.a.ev("videoPausePlay");
            z3 = true;
        } else {
            z3 = false;
        }
        if (this.TN == 6) {
            this.TO.pause();
            com.kwad.sdk.core.e.c.i(this.TAG, "pause STATE_BUFFERING_PLAYING->STATE_PAUSED");
            this.TN = 7;
            onPlayStateChanged(this.TN);
            z3 = true;
        }
        if (this.TN == 3) {
            this.TO.pause();
            com.kwad.sdk.core.e.c.i(this.TAG, "pause STATE_STARTED->STATE_PAUSED");
            this.TN = 5;
            onPlayStateChanged(this.TN);
            com.kwad.sdk.core.video.a.a.a.ev("videoPausePlay");
            z3 = true;
        }
        if (this.TN == 9 && this.TO.isLooping()) {
            this.TO.pause();
            String str2 = this.TAG;
            com.kwad.sdk.core.e.c.i(str2, "pause " + getStateString(this.TN) + "->STATE_PAUSED");
            this.TN = 5;
            onPlayStateChanged(this.TN);
            return true;
        }
        return z3;
    }

    public final void prepareAsync() {
        aP(false);
    }

    public final void release() {
        a((a) null);
    }

    public final void releaseSync() {
        a((a) null, false);
    }

    public final void restart() {
        if (this.TO != null && this.TN == 9) {
            start();
        }
        setPlayType(3);
    }

    public final void resume() {
        try {
            if (this.TO == null) {
                com.kwad.sdk.core.e.c.e(this.TAG, "resume but mMediaPlayer is null");
                return;
            }
            String str = this.TAG;
            com.kwad.sdk.core.e.c.i(str, "resume state: " + getStateString(this.TN));
            if (this.TN != 2 && this.TN != 3 && this.TN != 0) {
                if (this.TN == 5) {
                    this.TO.start();
                    String str2 = this.TAG;
                    com.kwad.sdk.core.e.c.i(str2, "resume:" + getStateString(this.TN) + "->STATE_PLAYING");
                    this.TN = 4;
                    onPlayStateChanged(this.TN);
                    setPlayType(2);
                    com.kwad.sdk.core.video.a.a.a.ev("videoResumePlay");
                    return;
                } else if (this.TN == 7) {
                    this.TO.start();
                    String str3 = this.TAG;
                    com.kwad.sdk.core.e.c.i(str3, "resume:" + getStateString(this.TN) + "->STATE_BUFFERING_PLAYING");
                    this.TN = 6;
                    onPlayStateChanged(this.TN);
                    return;
                } else if (this.TN != 1) {
                    String str4 = this.TAG;
                    com.kwad.sdk.core.e.c.w(str4, "resume: " + getStateString(this.TN) + " \u6b64\u65f6\u4e0d\u80fd\u8c03\u7528resume()\u65b9\u6cd5.");
                    return;
                } else {
                    return;
                }
            }
            String str5 = this.TAG;
            com.kwad.sdk.core.e.c.i(str5, "resume:" + getStateString(this.TN) + "->start()");
            start();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final com.kwad.sdk.core.video.a.c rs() {
        return this.TO;
    }

    public final void rv() {
        if (this.TO == null) {
            com.kwad.sdk.core.e.c.w("resetAndPlay", "mMediaPlayer is null");
        } else if (this.TN != 2 && this.TN != 3 && this.TN != 4 && this.TN != 5) {
            reset();
            ru();
            rt();
            prepareAsync();
        } else {
            com.kwad.sdk.core.e.c.w("resetAndPlay", "can not resetAndPlay in state:");
        }
    }

    public final void seekTo(long j4) {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar != null) {
            cVar.seekTo(j4);
        }
    }

    public final void setAudioEnabled(boolean z3) {
        if (z3) {
            setVolume(1.0f, 1.0f);
        } else {
            setVolume(0.0f, 0.0f);
        }
    }

    public final void setRadius(float f4, float f5, float f6, float f7) {
        this.mDetailVideoView.setRadius(f4, f5, f6, f7);
    }

    public final void setSpeed(float f4) {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar == null) {
            return;
        }
        cVar.setSpeed(f4);
    }

    public final void setSurface(Surface surface) {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar != null) {
            cVar.setSurface(surface);
        }
    }

    public final void setVolume(float f4, float f5) {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar == null) {
            return;
        }
        try {
            cVar.setVolume(f4, f5);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
    }

    public final void start() {
        try {
            if (this.TO == null) {
                return;
            }
            String str = this.TAG;
            com.kwad.sdk.core.e.c.i(str, "start state: " + getStateString(this.TN));
            aM(0);
            if (this.TN == 0) {
                com.kwad.sdk.core.e.c.i(this.TAG, "start still not prepared well forcePrepare");
                aP(true);
                return;
            }
            if (this.TN != 2 && this.TN != 9) {
                if (this.TN == 3) {
                    this.TO.start();
                    return;
                }
                return;
            }
            this.mStartTime = System.currentTimeMillis();
            this.TO.start();
            com.kwad.sdk.core.video.a.a.a.ev("videoStartPlay");
            long j4 = this.TQ;
            if (j4 != 0) {
                this.TO.seekTo((int) j4);
            }
            String str2 = this.TAG;
            com.kwad.sdk.core.e.c.i(str2, "start:" + getStateString(this.TN) + "->STATE_STARTED");
            com.kwad.sdk.contentalliance.a.a.b bVar = this.TS;
            if (bVar != null && bVar.videoPlayerStatus != null) {
                if (this.TN == 2) {
                    if (this.TS.videoPlayerStatus.mVideoPlayerType == 0) {
                        setPlayType(1);
                    } else {
                        setPlayType(3);
                    }
                } else if (this.TN == 9) {
                    setPlayType(3);
                }
            }
            this.TN = 3;
            onPlayStateChanged(this.TN);
            rw();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void stopAndPrepareAsync() {
        String str = this.TAG;
        com.kwad.sdk.core.e.c.i(str, "stopAndPrepareAsync state: " + getStateString(this.TN));
        if (this.TN == 1 || this.TN == 2) {
            return;
        }
        if (this.TN == 3 || this.TN == 4 || this.TN == 5 || this.TN == 6 || this.TN == 7 || this.TN == 8 || this.TN == 9) {
            try {
                this.TO.stop();
                this.TN = 8;
                onPlayStateChanged(this.TN);
                prepareAsync();
                return;
            } catch (Exception unused) {
            }
        }
        release();
    }

    private b(@Nullable DetailVideoView detailVideoView, int i4) {
        this.TN = 0;
        this.fS = new Handler(Looper.getMainLooper());
        this.mStartTime = 0L;
        this.TT = 0;
        this.TU = new CopyOnWriteArrayList();
        this.TV = new AtomicBoolean(false);
        this.TW = false;
        this.TY = new CopyOnWriteArrayList();
        this.TZ = new CopyOnWriteArrayList();
        this.Ua = new CopyOnWriteArrayList();
        this.Ub = new c.f() { // from class: com.kwad.components.core.video.b.1
            @Override // com.kwad.sdk.core.video.a.c.f
            public final void ry() {
                b.this.TN = 1;
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.TN);
            }
        };
        this.Uc = new c.e() { // from class: com.kwad.components.core.video.b.4
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    String str = b.this.TAG;
                    com.kwad.sdk.core.e.c.i(str, "onPrepared:" + b.getStateString(b.this.TN) + "->STATE_PREPARED");
                    b.this.TN = 2;
                    b bVar = b.this;
                    bVar.onPlayStateChanged(bVar.TN);
                    for (c.e eVar : b.this.Ua) {
                        eVar.a(b.this.TO);
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
        this.Ud = new c.i() { // from class: com.kwad.components.core.video.b.5
            @Override // com.kwad.sdk.core.video.a.c.i
            public final void k(int i5, int i6) {
                if (b.this.mDetailVideoView != null) {
                    b.this.mDetailVideoView.adaptVideoSize(i5, i6);
                }
                String str = b.this.TAG;
                com.kwad.sdk.core.e.c.i(str, "onVideoSizeChanged \u2014\u2014> width\uff1a" + i5 + "\uff0c height\uff1a" + i6);
            }
        };
        this.Ue = new c.b() { // from class: com.kwad.components.core.video.b.6
            @Override // com.kwad.sdk.core.video.a.c.b
            public final void oZ() {
                b.this.TN = 9;
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.TN);
                com.kwad.sdk.core.video.a.a.a.ev("videoFinishPlay");
            }
        };
        this.Uf = new c.InterfaceC0702c() { // from class: com.kwad.components.core.video.b.7
            @Override // com.kwad.sdk.core.video.a.c.InterfaceC0702c
            public final boolean l(int i5, int i6) {
                if (i5 != -38) {
                    b.this.TN = -1;
                    b.this.Tv = i5;
                    b.this.Tw = i6;
                    b bVar = b.this;
                    bVar.onPlayStateChanged(bVar.TN);
                    String str = b.this.TAG;
                    com.kwad.sdk.core.e.c.i(str, "onError \u2014\u2014> STATE_ERROR \u2014\u2014\u2014\u2014 what\uff1a" + i5 + ", extra: " + i6);
                    return true;
                }
                return true;
            }
        };
        this.Ug = new c.d() { // from class: com.kwad.components.core.video.b.8
            @Override // com.kwad.sdk.core.video.a.c.d
            public final boolean m(int i5, int i6) {
                if (i5 == 3) {
                    b.this.TN = 4;
                    b bVar = b.this;
                    bVar.onPlayStateChanged(bVar.TN);
                    String str = b.this.TAG;
                    com.kwad.sdk.core.e.c.i(str, "onInfo:" + b.getStateString(b.this.TN) + "->STATE_PLAYING, time: " + (System.currentTimeMillis() - b.this.mStartTime));
                } else if (i5 == 701) {
                    if (b.this.TN == 5 || b.this.TN == 7) {
                        b.this.TN = 7;
                        com.kwad.sdk.core.e.c.i(b.this.TAG, "onInfo \u2014\u2014> MEDIA_INFO_BUFFERING_START\uff1aSTATE_BUFFERING_PAUSED");
                    } else {
                        b.this.TN = 6;
                        com.kwad.sdk.core.e.c.i(b.this.TAG, "onInfo \u2014\u2014> MEDIA_INFO_BUFFERING_START\uff1aSTATE_BUFFERING_PLAYING");
                    }
                    b bVar2 = b.this;
                    bVar2.onPlayStateChanged(bVar2.TN);
                } else if (i5 == 702) {
                    if (b.this.TN == 6) {
                        b.this.TN = 4;
                        b bVar3 = b.this;
                        bVar3.onPlayStateChanged(bVar3.TN);
                        com.kwad.sdk.core.e.c.i(b.this.TAG, "onInfo \u2014\u2014> MEDIA_INFO_BUFFERING_END\uff1a STATE_PLAYING");
                    }
                    if (b.this.TN == 7) {
                        b.this.TN = 5;
                        b bVar4 = b.this;
                        bVar4.onPlayStateChanged(bVar4.TN);
                        com.kwad.sdk.core.e.c.i(b.this.TAG, "onInfo \u2014\u2014> MEDIA_INFO_BUFFERING_END\uff1a STATE_PAUSED");
                    }
                } else if (i5 != 10001) {
                    if (i5 == 801) {
                        com.kwad.sdk.core.e.c.i(b.this.TAG, "\u89c6\u9891\u4e0d\u80fdseekTo\uff0c\u4e3a\u76f4\u64ad\u89c6\u9891");
                    } else {
                        String str2 = b.this.TAG;
                        com.kwad.sdk.core.e.c.i(str2, "onInfo \u2014\u2014> what\uff1a" + i5);
                    }
                }
                b bVar5 = b.this;
                bVar5.a(bVar5.TO, i5, i6);
                return true;
            }
        };
        this.Uh = new c.a() { // from class: com.kwad.components.core.video.b.9
            @Override // com.kwad.sdk.core.video.a.c.a
            public final void av(int i5) {
                b.this.TP = i5;
            }
        };
        this.mDetailVideoView = detailVideoView;
        if (detailVideoView != null) {
            this.mContext = StubApp.getOrigApplicationContext(detailVideoView.getContext().getApplicationContext());
        }
        this.TX = 0;
        String str = "DetailMediaPlayerImpl[0]";
        this.TAG = str;
        com.kwad.sdk.core.e.c.i(str, "create DetailMediaPlayerImpl");
    }

    public final void c(k kVar) {
        this.TY.add(kVar);
    }

    public final void d(k kVar) {
        this.TY.remove(kVar);
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar, @NonNull DetailVideoView detailVideoView) {
        a(bVar, true, false, detailVideoView);
    }

    public final void b(c.d dVar) {
        if (dVar == null) {
            return;
        }
        this.TU.remove(dVar);
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar, boolean z3, boolean z4, @NonNull DetailVideoView detailVideoView) {
        String str = this.TAG;
        com.kwad.sdk.core.e.c.i(str, "initMediaPlayer enablePreLoad:" + z3);
        if (bVar == null || detailVideoView == null) {
            return;
        }
        com.kwad.sdk.core.video.a.c a4 = com.kwad.sdk.core.video.a.e.a(this.mContext, z3, com.kwad.sdk.core.config.d.yn(), com.kwad.sdk.core.config.d.yo(), this.TX);
        a4.setLooping(false);
        a(bVar, z4, detailVideoView, a4);
    }

    private void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar, boolean z3, @NonNull DetailVideoView detailVideoView, @NonNull com.kwad.sdk.core.video.a.c cVar) {
        String str = this.TAG;
        com.kwad.sdk.core.e.c.i(str, "initMediaPlayer " + this.TO);
        if (bVar == null || detailVideoView == null || cVar == null) {
            return;
        }
        if (this.mContext == null) {
            this.mContext = StubApp.getOrigApplicationContext(detailVideoView.getContext().getApplicationContext());
        }
        this.TW = z3;
        this.TS = bVar;
        com.kwad.components.core.video.a.a a4 = com.kwad.components.core.video.a.d.a(bVar.adTemplate, this.mAdTemplate, bVar.videoUrl);
        c(a4);
        a(a4);
        DetailVideoView detailVideoView2 = this.mDetailVideoView;
        if (detailVideoView2 != detailVideoView) {
            com.kwad.sdk.core.e.c.i(this.TAG, "initMediaPlayer videoView changed");
            if (detailVideoView2 != null) {
                detailVideoView2.setMediaPlayer(null);
                detailVideoView.setKeepScreenOn(detailVideoView2.getKeepScreenOn());
                detailVideoView2.setKeepScreenOn(false);
            }
            this.mDetailVideoView = detailVideoView;
        }
        detailVideoView.setMediaPlayer(this);
        if (this.TO != cVar) {
            com.kwad.sdk.core.e.c.i(this.TAG, "initMediaPlayer mediaPlayer changed");
            com.kwad.sdk.core.video.a.c cVar2 = this.TO;
            if (cVar2 != null) {
                cVar.setLooping(cVar2.isLooping());
                ru();
                this.TO.release();
            }
            this.TO = cVar;
            reset();
            rt();
            cVar.setAudioStreamType(3);
        } else {
            com.kwad.sdk.core.e.c.i(this.TAG, "initMediaPlayer mediaPlayer not changed");
            reset();
            ru();
            rt();
        }
        this.TO.setSurface(detailVideoView.Uq);
    }

    public b(@Nullable DetailVideoView detailVideoView, @NonNull AdTemplate adTemplate) {
        this(detailVideoView);
        this.mAdTemplate = adTemplate;
    }

    public final void start(long j4) {
        this.TQ = j4;
        start();
    }

    public final void a(c.e eVar) {
        this.Ua.add(eVar);
    }

    public final void a(c.d dVar) {
        if (dVar == null) {
            return;
        }
        this.TU.add(dVar);
    }

    public final void a(com.kwad.sdk.core.video.a.c cVar, int i4, int i5) {
        Iterator<c.d> it = this.TU.iterator();
        while (it.hasNext()) {
            c.d next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.m(i4, i5);
            }
        }
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar) {
        try {
            if (!TextUtils.isEmpty(bVar.videoUrl)) {
                String str = this.TAG;
                com.kwad.sdk.core.e.c.d(str, "videoUrl=" + bVar.videoUrl);
                this.TO.a(bVar);
                return;
            }
            com.kwad.sdk.core.e.c.e(this.TAG, "videoUrl is null");
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTrace(e4);
        }
    }

    public final void a(final a aVar, boolean z3) {
        if (this.TO == null) {
            return;
        }
        String str = this.TAG;
        com.kwad.sdk.core.e.c.i(str, "release:" + getStateString(this.TN) + "->STATE_IDLE");
        setKeepScreenOn(false);
        this.fS.removeCallbacksAndMessages(null);
        rx();
        ru();
        this.mDetailVideoView = null;
        final com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar != null) {
            if (z3) {
                com.kwad.sdk.utils.g.execute(new ay() { // from class: com.kwad.components.core.video.b.11
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        b.this.a(cVar, aVar);
                    }
                });
            } else {
                a(cVar, aVar);
            }
            this.TO = null;
        }
        this.TN = 0;
        this.TT = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.core.video.a.c cVar, a aVar) {
        if (cVar == null) {
            return;
        }
        String str = this.TAG;
        com.kwad.sdk.core.e.c.i(str, "releaseMediaPlayer:" + getStateString(this.TN) + "->STATE_IDLE");
        try {
            aM(2);
            cVar.release();
            if (aVar != null) {
                aVar.onReleaseSuccess();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
    }

    public final void a(a aVar) {
        a(aVar, true);
    }

    private void a(com.kwad.components.core.video.a.c cVar) {
        this.TZ.add(cVar);
    }

    public final void a(com.kwad.sdk.contentalliance.a.a.a aVar) {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar instanceof com.kwad.sdk.core.video.a.d) {
            ((com.kwad.sdk.core.video.a.d) cVar).a(aVar);
        }
    }
}

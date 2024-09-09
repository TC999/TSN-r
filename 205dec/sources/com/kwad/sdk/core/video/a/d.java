package com.kwad.sdk.core.video.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import com.kwad.sdk.n.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.video.ksvodplayerkit.IKSVodPlayer;
import com.kwai.video.ksvodplayerkit.KSVodConstants;
import com.kwai.video.ksvodplayerkit.KSVodPlayerWrapper;
import com.kwai.video.ksvodplayerkit.KSVodVideoContext;
import com.kwai.video.player.IKwaiMediaPlayer;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d extends com.kwad.sdk.core.video.a.a {
    private static volatile boolean aBm;
    private static final Queue<d> aBn = new ConcurrentLinkedQueue();
    private final String TAG;
    private com.kwad.sdk.contentalliance.a.a.b TS;
    private String aBd;
    private MediaDataSource aBe;
    private final Object aBf;
    private boolean aBg;
    private final KSVodPlayerWrapper aBi;
    private final a aBj;
    private boolean aBk;
    private boolean aBl;
    private boolean aBo;
    private int mSarDen;
    private int mSarNum;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a implements IKSVodPlayer.OnBufferingUpdateListener, IKSVodPlayer.OnErrorListener, IKSVodPlayer.OnEventListener, IKSVodPlayer.OnPreparedListener, IKSVodPlayer.OnVideoSizeChangedListener, IKSVodPlayer.OnVodPlayerReleaseListener {
        final String TAG;
        final WeakReference<d> mWeakMediaPlayer;

        a(d dVar, String str) {
            this.mWeakMediaPlayer = new WeakReference<>(dVar);
            this.TAG = str;
        }

        private d Ge() {
            return this.mWeakMediaPlayer.get();
        }

        public final void onBufferingUpdate(int i4) {
            d Ge = Ge();
            if (Ge != null) {
                Ge.notifyOnBufferingUpdate(i4);
            }
        }

        public final void onError(int i4, int i5) {
            d Ge = Ge();
            if (Ge != null) {
                d.a(Ge, false);
                Ge.notifyOnError(i4, i5);
            }
        }

        public final void onEvent(@KSVodConstants.KSVodPlayerEventType int i4, int i5) {
            String str = this.TAG;
            com.kwad.sdk.core.e.c.i(str, "onEvent, what: " + i4);
            try {
                d Ge = Ge();
                if (Ge != null) {
                    if (i4 == 10100) {
                        Ge.notifyOnSeekComplete();
                    } else if (i4 == 10101) {
                        Ge.notifyOnCompletion();
                    } else {
                        if (i4 == 10209) {
                            Ge.Gd();
                        }
                        Ge.notifyOnInfo(i4, i5);
                    }
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }

        public final void onPlayerRelease() {
            com.kwad.sdk.core.e.c.i(this.TAG, "onPlayerRelease");
        }

        public final void onPrepared() {
            com.kwad.sdk.core.e.c.i(this.TAG, "onPrepared");
            d Ge = Ge();
            if (Ge != null) {
                Ge.notifyOnPrepared();
            }
        }

        public final void onVideoSizeChanged(int i4, int i5, int i6, int i7) {
            String str = this.TAG;
            com.kwad.sdk.core.e.c.i(str, "onVideoSizeChanged width: " + i4 + ", height: " + i5 + ", sarNum:" + i6 + ", sarDen:" + i7);
            d Ge = Ge();
            if (Ge != null) {
                Ge.w(i4, i5);
                Ge.mSarNum = i6;
                Ge.mSarDen = i7;
            }
        }
    }

    public d(int i4) {
        Object obj = new Object();
        this.aBf = obj;
        this.aBl = false;
        this.aBo = true;
        synchronized (obj) {
            this.aBi = new KSVodPlayerWrapper(l.Ob());
        }
        String str = "KSMediaPlayer[" + i4 + "]";
        this.TAG = str;
        this.aBj = new a(this, str);
        Ga();
        setLooping(false);
        com.kwad.sdk.core.e.c.i(str, "create KwaiMediaPlayer");
    }

    private void FY() {
        MediaDataSource mediaDataSource = this.aBe;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            this.aBe = null;
        }
    }

    private void Ga() {
        this.aBi.setOnPreparedListener(this.aBj);
        this.aBi.setBufferingUpdateListener(this.aBj);
        this.aBi.setOnEventListener(this.aBj);
        this.aBi.setVideoSizeChangedListener(this.aBj);
        this.aBi.setOnErrorListener(this.aBj);
    }

    private void Gb() {
        this.aBi.setOnPreparedListener((IKSVodPlayer.OnPreparedListener) null);
        this.aBi.setBufferingUpdateListener((IKSVodPlayer.OnBufferingUpdateListener) null);
        this.aBi.setOnEventListener((IKSVodPlayer.OnEventListener) null);
        this.aBi.setVideoSizeChangedListener((IKSVodPlayer.OnVideoSizeChangedListener) null);
        this.aBi.setOnErrorListener((IKSVodPlayer.OnErrorListener) null);
    }

    private void Gc() {
        String str = this.TAG;
        com.kwad.sdk.core.e.c.i(str, "realPrepare hasCallPrepare: " + this.aBl);
        if (this.aBl) {
            return;
        }
        try {
            this.aBl = true;
            int prepareAsync = this.aBi.prepareAsync();
            FX();
            String str2 = this.TAG;
            com.kwad.sdk.core.e.c.i(str2, "realPrepare result: " + prepareAsync);
        } catch (IllegalStateException e4) {
            com.kwad.sdk.core.e.c.e(this.TAG, "realPrepare failed ", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gd() {
        Iterator<d> it = aBn.iterator();
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                i4 = 0;
                break;
            } else if (it.next() == this) {
                break;
            } else {
                i4++;
            }
        }
        String str = this.TAG;
        com.kwad.sdk.core.e.c.i(str, "preloadNextPlayer next player index: " + i4);
        int i5 = i4 + 1;
        if (i5 < aBn.size()) {
            com.kwad.sdk.core.e.c.i(this.TAG, "----------------preloadNextPlayer prepare next player----------------");
            for (int i6 = 0; i6 < i5; i6++) {
                aBn.poll();
            }
            Queue<d> queue = aBn;
            d poll = queue.poll();
            queue.clear();
            if (poll != null) {
                poll.prepareAsync();
            } else {
                com.kwad.sdk.core.e.c.i(this.TAG, "----------------preloadNextPlayer prepareAsync next player is null----------------");
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean FZ() {
        com.kwad.sdk.core.e.c.i(this.TAG, "forcePrepareAsync");
        Gc();
        return true;
    }

    public final void bn(boolean z3) {
        this.aBo = z3;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getAudioSessionId() {
        return this.aBi.getKwaiMediaPlayer().getAudioSessionId();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getCurrentPlayingUrl() {
        KSVodPlayerWrapper kSVodPlayerWrapper = this.aBi;
        return kSVodPlayerWrapper == null ? "" : kSVodPlayerWrapper.getCurrentPlayUrl();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getCurrentPosition() {
        try {
            return this.aBi.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getDataSource() {
        return this.aBd;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getDuration() {
        try {
            return this.aBi.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getMediaPlayerType() {
        return 2;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoHeight() {
        return this.aBi.getKwaiMediaPlayer().getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoWidth() {
        return this.aBi.getKwaiMediaPlayer().getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isLooping() {
        return this.aBk;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isPlaying() {
        try {
            return this.aBi.isPlaying();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void pause() {
        this.aBi.pause();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean prepareAsync() {
        if (this.aBo) {
            Queue<d> queue = aBn;
            if (!queue.contains(this)) {
                queue.offer(this);
            }
            int size = queue.size();
            if (size == 1) {
                com.kwad.sdk.core.e.c.i(this.TAG, "prepareAsync first");
                Gc();
                return true;
            }
            String str = this.TAG;
            com.kwad.sdk.core.e.c.i(str, "prepareAsync pending size: " + size);
            return false;
        }
        Gc();
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void release() {
        Queue<d> queue = aBn;
        boolean remove = queue.remove(this);
        String str = this.TAG;
        com.kwad.sdk.core.e.c.i(str, "release remote player ret: " + remove + ", player list size: " + queue.size());
        this.aBg = true;
        this.aBi.releaseAsync(new IKSVodPlayer.OnVodPlayerReleaseListener() { // from class: com.kwad.sdk.core.video.a.d.1
            public final void onPlayerRelease() {
                com.kwad.sdk.core.e.c.i(d.this.TAG, "onPlayerRelease");
            }
        });
        try {
            FY();
            resetListeners();
            Gb();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void reset() {
        this.aBl = false;
        try {
            IKwaiMediaPlayer kwaiMediaPlayer = this.aBi.getKwaiMediaPlayer();
            if (kwaiMediaPlayer != null) {
                kwaiMediaPlayer.reset();
            }
        } catch (IllegalStateException unused) {
        }
        FY();
        resetListeners();
        Ga();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void seekTo(long j4) {
        this.aBi.seekTo((int) j4);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setAudioStreamType(int i4) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(FileDescriptor fileDescriptor) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(String str) {
        setDataSource(str, (Map<String, String>) null);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.aBf) {
            if (!this.aBg) {
                this.aBi.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setLooping(boolean z3) {
        this.aBk = z3;
        this.aBi.setLooping(z3);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setScreenOnWhilePlaying(boolean z3) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setSpeed(float f4) {
        this.aBi.setSpeed(f4);
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public final void setSurface(Surface surface) {
        this.aBi.setSurface(surface);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setVolume(float f4, float f5) {
        this.aBi.setVolume(f4, f5);
        com.kwad.sdk.core.video.a.a.f(f4);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void start() {
        com.kwad.sdk.core.e.c.i(this.TAG, CampaignEx.JSON_NATIVE_VIDEO_START);
        this.aBi.start();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void stop() {
        this.aBi.stop();
    }

    private void setDataSource(String str, Map<String, String> map) {
        this.aBd = str;
        this.aBi.setDataSource(str, (Map) null);
    }

    static /* synthetic */ boolean a(d dVar, boolean z3) {
        dVar.aBl = false;
        return false;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar) {
        this.TS = bVar;
        a(bVar.aoR);
        f fVar = (f) ServiceProvider.get(f.class);
        if (!TextUtils.isEmpty(bVar.manifest) && fVar != null && fVar.tB()) {
            setDataSource(bVar.manifest, (Map<String, String>) null);
        } else {
            setDataSource(bVar.videoUrl, (Map<String, String>) null);
        }
    }

    public final void a(com.kwad.sdk.contentalliance.a.a.a aVar) {
        if (this.aBi == null || aVar == null) {
            return;
        }
        KSVodVideoContext kSVodVideoContext = new KSVodVideoContext();
        kSVodVideoContext.mVideoId = String.valueOf(aVar.photoId);
        kSVodVideoContext.mClickTime = aVar.clickTime;
        kSVodVideoContext.mExtra = aVar.Ba();
        this.aBi.updateVideoContext(kSVodVideoContext);
    }
}

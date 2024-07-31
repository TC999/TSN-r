package com.kwad.sdk.core.video.p411a;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import com.kwad.sdk.contentalliance.p383a.p384a.C9877a;
import com.kwad.sdk.contentalliance.p383a.p384a.C9878b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.p445n.C10887l;
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

/* renamed from: com.kwad.sdk.core.video.a.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10532d extends AbstractC10518a {
    private static volatile boolean aBm;
    private static final Queue<C10532d> aBn = new ConcurrentLinkedQueue();
    private final String TAG;

    /* renamed from: TS */
    private C9878b f29594TS;
    private String aBd;
    private MediaDataSource aBe;
    private final Object aBf;
    private boolean aBg;
    private final KSVodPlayerWrapper aBi;
    private final C10534a aBj;
    private boolean aBk;
    private boolean aBl;
    private boolean aBo;
    private int mSarDen;
    private int mSarNum;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.core.video.a.d$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10534a implements IKSVodPlayer.OnBufferingUpdateListener, IKSVodPlayer.OnErrorListener, IKSVodPlayer.OnEventListener, IKSVodPlayer.OnPreparedListener, IKSVodPlayer.OnVideoSizeChangedListener, IKSVodPlayer.OnVodPlayerReleaseListener {
        final String TAG;
        final WeakReference<C10532d> mWeakMediaPlayer;

        C10534a(C10532d c10532d, String str) {
            this.mWeakMediaPlayer = new WeakReference<>(c10532d);
            this.TAG = str;
        }

        /* renamed from: Ge */
        private C10532d m25529Ge() {
            return this.mWeakMediaPlayer.get();
        }

        public final void onBufferingUpdate(int i) {
            C10532d m25529Ge = m25529Ge();
            if (m25529Ge != null) {
                m25529Ge.notifyOnBufferingUpdate(i);
            }
        }

        public final void onError(int i, int i2) {
            C10532d m25529Ge = m25529Ge();
            if (m25529Ge != null) {
                C10532d.m25533a(m25529Ge, false);
                m25529Ge.notifyOnError(i, i2);
            }
        }

        public final void onEvent(@KSVodConstants.KSVodPlayerEventType int i, int i2) {
            String str = this.TAG;
            C10331c.m26248i(str, "onEvent, what: " + i);
            try {
                C10532d m25529Ge = m25529Ge();
                if (m25529Ge != null) {
                    if (i == 10100) {
                        m25529Ge.notifyOnSeekComplete();
                    } else if (i == 10101) {
                        m25529Ge.notifyOnCompletion();
                    } else {
                        if (i == 10209) {
                            m25529Ge.m25538Gd();
                        }
                        m25529Ge.notifyOnInfo(i, i2);
                    }
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }

        public final void onPlayerRelease() {
            C10331c.m26248i(this.TAG, "onPlayerRelease");
        }

        public final void onPrepared() {
            C10331c.m26248i(this.TAG, "onPrepared");
            C10532d m25529Ge = m25529Ge();
            if (m25529Ge != null) {
                m25529Ge.notifyOnPrepared();
            }
        }

        public final void onVideoSizeChanged(int i, int i2, int i3, int i4) {
            String str = this.TAG;
            C10331c.m26248i(str, "onVideoSizeChanged width: " + i + ", height: " + i2 + ", sarNum:" + i3 + ", sarDen:" + i4);
            C10532d m25529Ge = m25529Ge();
            if (m25529Ge != null) {
                m25529Ge.m25562w(i, i2);
                m25529Ge.mSarNum = i3;
                m25529Ge.mSarDen = i4;
            }
        }
    }

    public C10532d(int i) {
        Object obj = new Object();
        this.aBf = obj;
        this.aBl = false;
        this.aBo = true;
        synchronized (obj) {
            this.aBi = new KSVodPlayerWrapper(C10887l.m24567Ob());
        }
        String str = "KSMediaPlayer[" + i + "]";
        this.TAG = str;
        this.aBj = new C10534a(this, str);
        m25541Ga();
        setLooping(false);
        C10331c.m26248i(str, "create KwaiMediaPlayer");
    }

    /* renamed from: FY */
    private void m25543FY() {
        MediaDataSource mediaDataSource = this.aBe;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.aBe = null;
        }
    }

    /* renamed from: Ga */
    private void m25541Ga() {
        this.aBi.setOnPreparedListener(this.aBj);
        this.aBi.setBufferingUpdateListener(this.aBj);
        this.aBi.setOnEventListener(this.aBj);
        this.aBi.setVideoSizeChangedListener(this.aBj);
        this.aBi.setOnErrorListener(this.aBj);
    }

    /* renamed from: Gb */
    private void m25540Gb() {
        this.aBi.setOnPreparedListener((IKSVodPlayer.OnPreparedListener) null);
        this.aBi.setBufferingUpdateListener((IKSVodPlayer.OnBufferingUpdateListener) null);
        this.aBi.setOnEventListener((IKSVodPlayer.OnEventListener) null);
        this.aBi.setVideoSizeChangedListener((IKSVodPlayer.OnVideoSizeChangedListener) null);
        this.aBi.setOnErrorListener((IKSVodPlayer.OnErrorListener) null);
    }

    /* renamed from: Gc */
    private void m25539Gc() {
        String str = this.TAG;
        C10331c.m26248i(str, "realPrepare hasCallPrepare: " + this.aBl);
        if (this.aBl) {
            return;
        }
        try {
            this.aBl = true;
            int prepareAsync = this.aBi.prepareAsync();
            m25565FX();
            String str2 = this.TAG;
            C10331c.m26248i(str2, "realPrepare result: " + prepareAsync);
        } catch (IllegalStateException e) {
            C10331c.m26249e(this.TAG, "realPrepare failed ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Gd */
    public void m25538Gd() {
        Iterator<C10532d> it = aBn.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = 0;
                break;
            } else if (it.next() == this) {
                break;
            } else {
                i++;
            }
        }
        String str = this.TAG;
        C10331c.m26248i(str, "preloadNextPlayer next player index: " + i);
        int i2 = i + 1;
        if (i2 < aBn.size()) {
            C10331c.m26248i(this.TAG, "----------------preloadNextPlayer prepare next player----------------");
            for (int i3 = 0; i3 < i2; i3++) {
                aBn.poll();
            }
            Queue<C10532d> queue = aBn;
            C10532d poll = queue.poll();
            queue.clear();
            if (poll != null) {
                poll.prepareAsync();
            } else {
                C10331c.m26248i(this.TAG, "----------------preloadNextPlayer prepareAsync next player is null----------------");
            }
        }
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    /* renamed from: FZ */
    public final boolean mo25542FZ() {
        C10331c.m26248i(this.TAG, "forcePrepareAsync");
        m25539Gc();
        return true;
    }

    /* renamed from: bn */
    public final void m25530bn(boolean z) {
        this.aBo = z;
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final int getAudioSessionId() {
        return this.aBi.getKwaiMediaPlayer().getAudioSessionId();
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final String getCurrentPlayingUrl() {
        KSVodPlayerWrapper kSVodPlayerWrapper = this.aBi;
        return kSVodPlayerWrapper == null ? "" : kSVodPlayerWrapper.getCurrentPlayUrl();
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final long getCurrentPosition() {
        try {
            return this.aBi.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final String getDataSource() {
        return this.aBd;
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final long getDuration() {
        try {
            return this.aBi.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final int getMediaPlayerType() {
        return 2;
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final int getVideoHeight() {
        return this.aBi.getKwaiMediaPlayer().getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final int getVideoWidth() {
        return this.aBi.getKwaiMediaPlayer().getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final boolean isLooping() {
        return this.aBk;
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final boolean isPlaying() {
        try {
            return this.aBi.isPlaying();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void pause() {
        this.aBi.pause();
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final boolean prepareAsync() {
        if (this.aBo) {
            Queue<C10532d> queue = aBn;
            if (!queue.contains(this)) {
                queue.offer(this);
            }
            int size = queue.size();
            if (size == 1) {
                C10331c.m26248i(this.TAG, "prepareAsync first");
                m25539Gc();
                return true;
            }
            String str = this.TAG;
            C10331c.m26248i(str, "prepareAsync pending size: " + size);
            return false;
        }
        m25539Gc();
        return true;
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void release() {
        Queue<C10532d> queue = aBn;
        boolean remove = queue.remove(this);
        String str = this.TAG;
        C10331c.m26248i(str, "release remote player ret: " + remove + ", player list size: " + queue.size());
        this.aBg = true;
        this.aBi.releaseAsync(new IKSVodPlayer.OnVodPlayerReleaseListener() { // from class: com.kwad.sdk.core.video.a.d.1
            public final void onPlayerRelease() {
                C10331c.m26248i(C10532d.this.TAG, "onPlayerRelease");
            }
        });
        try {
            m25543FY();
            resetListeners();
            m25540Gb();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void reset() {
        this.aBl = false;
        try {
            IKwaiMediaPlayer kwaiMediaPlayer = this.aBi.getKwaiMediaPlayer();
            if (kwaiMediaPlayer != null) {
                kwaiMediaPlayer.reset();
            }
        } catch (IllegalStateException unused) {
        }
        m25543FY();
        resetListeners();
        m25541Ga();
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void seekTo(long j) {
        this.aBi.seekTo((int) j);
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void setAudioStreamType(int i) {
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void setDataSource(Context context, Uri uri) {
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) {
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void setDataSource(FileDescriptor fileDescriptor) {
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void setDataSource(String str) {
        setDataSource(str, (Map<String, String>) null);
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.aBf) {
            if (!this.aBg) {
                this.aBi.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void setLooping(boolean z) {
        this.aBk = z;
        this.aBi.setLooping(z);
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void setScreenOnWhilePlaying(boolean z) {
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void setSpeed(float f) {
        this.aBi.setSpeed(f);
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    @TargetApi(14)
    public final void setSurface(Surface surface) {
        this.aBi.setSurface(surface);
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void setVolume(float f, float f2) {
        this.aBi.setVolume(f, f2);
        AbstractC10518a.m25563f(f);
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void start() {
        C10331c.m26248i(this.TAG, CampaignEx.JSON_NATIVE_VIDEO_START);
        this.aBi.start();
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    public final void stop() {
        this.aBi.stop();
    }

    private void setDataSource(String str, Map<String, String> map) {
        this.aBd = str;
        this.aBi.setDataSource(str, (Map) null);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m25533a(C10532d c10532d, boolean z) {
        c10532d.aBl = false;
        return false;
    }

    @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c
    /* renamed from: a */
    public final void mo25536a(@NonNull C9878b c9878b) {
        this.f29594TS = c9878b;
        m25537a(c9878b.aoR);
        InterfaceC10536f interfaceC10536f = (InterfaceC10536f) ServiceProvider.get(InterfaceC10536f.class);
        if (!TextUtils.isEmpty(c9878b.manifest) && interfaceC10536f != null && interfaceC10536f.mo24871tB()) {
            setDataSource(c9878b.manifest, (Map<String, String>) null);
        } else {
            setDataSource(c9878b.videoUrl, (Map<String, String>) null);
        }
    }

    /* renamed from: a */
    public final void m25537a(C9877a c9877a) {
        if (this.aBi == null || c9877a == null) {
            return;
        }
        KSVodVideoContext kSVodVideoContext = new KSVodVideoContext();
        kSVodVideoContext.mVideoId = String.valueOf(c9877a.photoId);
        kSVodVideoContext.mClickTime = c9877a.clickTime;
        kSVodVideoContext.mExtra = c9877a.m27479Ba();
        this.aBi.updateVideoContext(kSVodVideoContext);
    }
}

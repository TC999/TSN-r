package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.kwad.sdk.contentalliance.p383a.p384a.C9877a;
import com.kwad.sdk.contentalliance.p383a.p384a.C9878b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.video.C10517a;
import com.kwad.sdk.core.video.p411a.C10535e;
import com.kwad.sdk.core.video.p411a.InterfaceC10522c;
import com.kwad.sdk.core.video.p411a.InterfaceC10536f;
import com.kwad.sdk.core.video.p411a.p412a.C10519a;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10971i;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.utils.C11137y;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@Deprecated
/* renamed from: com.kwad.sdk.core.video.videoview.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class TextureView$SurfaceTextureListenerC10537a extends AdBasePvFrameLayout implements TextureView.SurfaceTextureListener, InterfaceC10547c {
    private static AtomicBoolean aBz = new AtomicBoolean(false);

    /* renamed from: TN */
    private int f29597TN;

    /* renamed from: TO */
    private InterfaceC10522c f29598TO;

    /* renamed from: TP */
    private int f29599TP;

    /* renamed from: TQ */
    private long f29600TQ;

    /* renamed from: TS */
    private C9878b f29601TS;

    /* renamed from: Uc */
    private InterfaceC10522c.InterfaceC10527e f29602Uc;

    /* renamed from: Ud */
    private InterfaceC10522c.InterfaceC10531i f29603Ud;

    /* renamed from: Ue */
    private InterfaceC10522c.InterfaceC10524b f29604Ue;

    /* renamed from: Uf */
    private InterfaceC10522c.InterfaceC10525c f29605Uf;

    /* renamed from: Ug */
    private InterfaceC10522c.InterfaceC10526d f29606Ug;

    /* renamed from: Uh */
    private InterfaceC10522c.InterfaceC10523a f29607Uh;

    /* renamed from: Up */
    private SurfaceTexture f29608Up;

    /* renamed from: Uq */
    private Surface f29609Uq;
    private boolean aBA;
    private boolean aBB;
    private ImageView aBC;
    private AudioManager aBv;
    private C10517a aBw;
    private AbstractC10545b aBx;
    private boolean aBy;

    /* renamed from: dd */
    private C9877a f29610dd;

    /* renamed from: hR */
    private FrameLayout f29611hR;
    private Context mContext;
    private Map<String, String> mHeaders;
    private String mUrl;

    public TextureView$SurfaceTextureListenerC10537a(Context context) {
        this(context, null);
    }

    /* renamed from: Gh */
    private ImageView m25521Gh() {
        ImageView imageView = new ImageView(this.mContext);
        addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        return imageView;
    }

    /* renamed from: Gi */
    private boolean m25520Gi() {
        return this.f29597TN == 6;
    }

    /* renamed from: Gk */
    private void m25519Gk() {
        if (this.f29598TO == null) {
            InterfaceC10536f interfaceC10536f = (InterfaceC10536f) ServiceProvider.get(InterfaceC10536f.class);
            boolean z = true;
            InterfaceC10522c m25525a = C10535e.m25525a(this.mContext, false, interfaceC10536f != null && interfaceC10536f.mo24870yn(), (interfaceC10536f == null || !interfaceC10536f.mo24869yo()) ? false : false, 0);
            this.f29598TO = m25525a;
            m25525a.setAudioStreamType(3);
            if (this.aBA) {
                return;
            }
            this.f29598TO.setVolume(0.0f, 0.0f);
        }
    }

    /* renamed from: Gl */
    private void m25518Gl() {
        this.f29611hR.removeView(this.aBw);
        this.f29611hR.addView(this.aBw, 0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    /* renamed from: Gm */
    private void m25517Gm() {
        C9877a c9877a;
        this.f29611hR.setKeepScreenOn(true);
        this.f29598TO.mo25548b(this.f29602Uc);
        this.f29598TO.mo25549a(this.f29603Ud);
        this.f29598TO.mo25554a(this.f29604Ue);
        this.f29598TO.mo25553a(this.f29605Uf);
        this.f29598TO.mo25547c(this.f29606Ug);
        this.f29598TO.mo25555a(this.f29607Uh);
        try {
            C9878b c9878b = this.f29601TS;
            if (c9878b != null && (c9877a = this.f29610dd) != null) {
                c9878b.aoR = c9877a;
            }
            this.f29598TO.mo25536a(c9878b);
            if (this.f29609Uq == null) {
                this.f29609Uq = new Surface(this.f29608Up);
            }
            this.f29598TO.setSurface(this.f29609Uq);
            if (this.f29598TO.prepareAsync()) {
                this.f29597TN = 1;
                this.aBx.onPlayStateChanged(1);
                C10331c.m26248i("KSVideoPlayerViewView", "STATE_PREPARING");
            }
        } catch (Exception e) {
            C10331c.printStackTrace(e);
            C10331c.m26249e("KSVideoPlayerViewView", "打开播放器发生错误", e);
        }
    }

    /* renamed from: Gn */
    private void m25516Gn() {
        AudioManager audioManager = this.aBv;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(null);
            this.aBv = null;
        }
        InterfaceC10522c interfaceC10522c = this.f29598TO;
        if (interfaceC10522c != null) {
            interfaceC10522c.release();
            this.f29598TO = null;
            C10519a.m25561ev("videoFinishPlay");
        }
        C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.core.video.videoview.a.7
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                TextureView$SurfaceTextureListenerC10537a.this.f29611hR.removeView(TextureView$SurfaceTextureListenerC10537a.this.aBw);
            }
        });
        Surface surface = this.f29609Uq;
        if (surface != null) {
            surface.release();
            this.f29609Uq = null;
        }
        SurfaceTexture surfaceTexture = this.f29608Up;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f29608Up = null;
        }
        this.f29597TN = 0;
    }

    /* renamed from: eh */
    private void m25509eh(AdTemplate adTemplate) {
        InterfaceC10971i interfaceC10971i = (InterfaceC10971i) ServiceProvider.get(InterfaceC10971i.class);
        if (interfaceC10971i != null) {
            interfaceC10971i.load(this.aBC, C10487e.m25637dU(adTemplate), adTemplate);
        }
    }

    private void init() {
        this.aBC = m25521Gh();
        this.f29611hR = new FrameLayout(this.mContext);
        addView(this.f29611hR, new FrameLayout.LayoutParams(-1, -1));
    }

    /* renamed from: rz */
    private void m25502rz() {
        if (this.aBw == null) {
            C10517a c10517a = new C10517a(this.mContext);
            this.aBw = c10517a;
            c10517a.setSurfaceTextureListener(this);
        }
    }

    private void setPlayType(int i) {
        VideoPlayerStatus videoPlayerStatus;
        C9878b c9878b = this.f29601TS;
        if (c9878b == null || (videoPlayerStatus = c9878b.videoPlayerStatus) == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = i;
    }

    @Override // com.kwad.sdk.core.video.videoview.InterfaceC10547c
    /* renamed from: Gj */
    public final boolean mo25490Gj() {
        return this.f29597TN == 7;
    }

    /* renamed from: a */
    public final void m25515a(@NonNull C9878b c9878b, Map<String, String> map) {
        this.f29601TS = c9878b;
        this.mUrl = c9878b.videoUrl;
        this.mHeaders = null;
        m25509eh(c9878b.adTemplate);
    }

    @Override // com.kwad.sdk.core.video.videoview.InterfaceC10547c
    public final int getBufferPercentage() {
        return this.f29599TP;
    }

    public final AbstractC10545b getController() {
        return this.aBx;
    }

    @Override // com.kwad.sdk.core.video.videoview.InterfaceC10547c
    public final long getCurrentPosition() {
        InterfaceC10522c interfaceC10522c = this.f29598TO;
        if (interfaceC10522c != null) {
            return interfaceC10522c.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.kwad.sdk.core.video.videoview.InterfaceC10547c
    public final long getDuration() {
        InterfaceC10522c interfaceC10522c = this.f29598TO;
        if (interfaceC10522c != null) {
            return interfaceC10522c.getDuration();
        }
        return 0L;
    }

    public final int getMaxVolume() {
        AudioManager audioManager = this.aBv;
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(3);
        }
        return 0;
    }

    public final AbstractC10545b getVideoController() {
        return this.aBx;
    }

    public final int getVolume() {
        AudioManager audioManager = this.aBv;
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return 0;
    }

    public final boolean isCompleted() {
        return this.f29597TN == 9;
    }

    @Override // com.kwad.sdk.core.video.videoview.InterfaceC10547c
    public final boolean isIdle() {
        return this.f29597TN == 0;
    }

    @Override // com.kwad.sdk.core.video.videoview.InterfaceC10547c
    public final boolean isPaused() {
        return this.f29597TN == 5;
    }

    public final boolean isPlaying() {
        return this.f29597TN == 4;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        SurfaceTexture surfaceTexture2 = this.f29608Up;
        if (surfaceTexture2 == null) {
            this.f29608Up = surfaceTexture;
            m25517Gm();
            return;
        }
        this.aBw.setSurfaceTexture(surfaceTexture2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // com.kwad.sdk.core.video.videoview.InterfaceC10547c
    public final void pause() {
        InterfaceC10522c interfaceC10522c = this.f29598TO;
        if (interfaceC10522c == null) {
            return;
        }
        int i = this.f29597TN;
        if (i == 4) {
            interfaceC10522c.pause();
            C10519a.m25561ev("videoPausePlay");
            this.f29597TN = 5;
            this.aBx.onPlayStateChanged(5);
            C10331c.m26248i("KSVideoPlayerViewView", "STATE_PAUSED");
        } else if (i == 6) {
            interfaceC10522c.pause();
            C10519a.m25561ev("videoPausePlay");
            this.f29597TN = 7;
            this.aBx.onPlayStateChanged(7);
            C10331c.m26248i("KSVideoPlayerViewView", "STATE_BUFFERING_PAUSED");
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.InterfaceC10547c
    public final void release() {
        if (this.aBy) {
            if (!isPlaying() && !m25520Gi() && !mo25490Gj() && !isPaused()) {
                if (isCompleted()) {
                    C11137y.m23577e(this.mContext, this.mUrl, 0L);
                }
            } else {
                C11137y.m23577e(this.mContext, this.mUrl, getCurrentPosition());
            }
        }
        m25516Gn();
        AbstractC10545b abstractC10545b = this.aBx;
        if (abstractC10545b != null) {
            abstractC10545b.reset();
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.InterfaceC10547c
    public final void restart() {
        int i = this.f29597TN;
        if (i == 5) {
            this.f29598TO.start();
            C10519a.m25561ev("videoResumePlay");
            this.f29597TN = 4;
            this.aBx.onPlayStateChanged(4);
            setPlayType(2);
            C10331c.m26248i("KSVideoPlayerViewView", "STATE_PLAYING");
        } else if (i == 7) {
            this.f29598TO.start();
            C10519a.m25561ev("videoResumePlay");
            this.f29597TN = 6;
            this.aBx.onPlayStateChanged(6);
            C10331c.m26248i("KSVideoPlayerViewView", "STATE_BUFFERING_PLAYING");
        } else if (i != 9 && i != -1) {
            C10331c.m26248i("KSVideoPlayerViewView", "KSVideoPlayer在状态为 " + this.f29597TN + " 时不能调用restart()方法.");
        } else {
            this.f29598TO.reset();
            m25517Gm();
            setPlayType(3);
        }
    }

    public final void seekTo(int i) {
        InterfaceC10522c interfaceC10522c = this.f29598TO;
        if (interfaceC10522c != null) {
            interfaceC10522c.seekTo(i);
        }
    }

    public final void setController(AbstractC10545b abstractC10545b) {
        this.f29611hR.removeView(this.aBx);
        this.aBx = abstractC10545b;
        abstractC10545b.reset();
        this.f29611hR.addView(this.aBx, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.kwad.sdk.core.video.videoview.InterfaceC10547c
    public final void setKsPlayLogParam(@NonNull C9877a c9877a) {
        this.f29610dd = c9877a;
    }

    public final void setLooping(boolean z) {
        InterfaceC10522c interfaceC10522c = this.f29598TO;
        if (interfaceC10522c != null) {
            interfaceC10522c.setLooping(z);
        }
    }

    public final void setPortraitFullscreen(boolean z) {
        this.aBB = z;
    }

    public final void setVideoSoundEnable(boolean z) {
        this.aBA = z;
        InterfaceC10522c interfaceC10522c = this.f29598TO;
        if (interfaceC10522c != null) {
            if (z) {
                interfaceC10522c.setVolume(1.0f, 1.0f);
            } else {
                interfaceC10522c.setVolume(0.0f, 0.0f);
            }
        }
    }

    public final void setVolume(int i) {
        AudioManager audioManager = this.aBv;
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i, 0);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.InterfaceC10547c
    public final void start() {
        VideoPlayerStatus videoPlayerStatus;
        if (this.f29597TN == 0) {
            m25519Gk();
            m25502rz();
            m25518Gl();
            C9878b c9878b = this.f29601TS;
            if (c9878b != null && (videoPlayerStatus = c9878b.videoPlayerStatus) != null) {
                if (videoPlayerStatus.mVideoPlayerType == 0) {
                    setPlayType(1);
                } else {
                    setPlayType(3);
                }
            }
            C10519a.m25561ev("videoStartPlay");
            return;
        }
        C10331c.m26248i("KSVideoPlayerViewView", "KSVideoPlayer只有在状态为STATE_IDLE时才能调用start方法.");
    }

    private TextureView$SurfaceTextureListenerC10537a(Context context, AttributeSet attributeSet) {
        super(context, null);
        this.f29597TN = 0;
        this.aBy = false;
        this.aBA = false;
        this.aBB = false;
        this.f29602Uc = new InterfaceC10522c.InterfaceC10527e() { // from class: com.kwad.sdk.core.video.videoview.a.1
            @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c.InterfaceC10527e
            /* renamed from: a */
            public final void mo25501a(InterfaceC10522c interfaceC10522c) {
                try {
                    TextureView$SurfaceTextureListenerC10537a.this.f29597TN = 2;
                    TextureView$SurfaceTextureListenerC10537a.this.aBx.onPlayStateChanged(TextureView$SurfaceTextureListenerC10537a.this.f29597TN);
                    C10331c.m26248i("KSVideoPlayerViewView", "onPrepared ——> STATE_PREPARED");
                    interfaceC10522c.start();
                    if (TextureView$SurfaceTextureListenerC10537a.this.aBy) {
                        interfaceC10522c.seekTo((int) C11137y.m23623T(TextureView$SurfaceTextureListenerC10537a.this.mContext, TextureView$SurfaceTextureListenerC10537a.this.mUrl));
                    }
                    if (TextureView$SurfaceTextureListenerC10537a.this.f29600TQ != 0) {
                        interfaceC10522c.seekTo((int) TextureView$SurfaceTextureListenerC10537a.this.f29600TQ);
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
        this.f29603Ud = new InterfaceC10522c.InterfaceC10531i() { // from class: com.kwad.sdk.core.video.videoview.a.2
            @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c.InterfaceC10531i
            /* renamed from: k */
            public final void mo25500k(int i, int i2) {
                if (!TextureView$SurfaceTextureListenerC10537a.this.aBB || i2 <= i) {
                    TextureView$SurfaceTextureListenerC10537a.this.aBw.adaptVideoSize(i, i2);
                    C10331c.m26248i("KSVideoPlayerViewView", "onVideoSizeChanged ——> width：" + i + "， height：" + i2);
                }
            }
        };
        this.f29604Ue = new InterfaceC10522c.InterfaceC10524b() { // from class: com.kwad.sdk.core.video.videoview.a.3
            @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c.InterfaceC10524b
            /* renamed from: oZ */
            public final void mo25499oZ() {
                if (TextureView$SurfaceTextureListenerC10537a.this.f29597TN != 9) {
                    TextureView$SurfaceTextureListenerC10537a.this.f29597TN = 9;
                    TextureView$SurfaceTextureListenerC10537a.this.aBx.onPlayStateChanged(TextureView$SurfaceTextureListenerC10537a.this.f29597TN);
                    C10331c.m26248i("KSVideoPlayerViewView", "onCompletion ——> STATE_COMPLETED");
                    TextureView$SurfaceTextureListenerC10537a.this.f29611hR.setKeepScreenOn(false);
                }
            }
        };
        this.f29605Uf = new InterfaceC10522c.InterfaceC10525c() { // from class: com.kwad.sdk.core.video.videoview.a.4
            @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c.InterfaceC10525c
            /* renamed from: l */
            public final boolean mo25498l(int i, int i2) {
                if (i != -38) {
                    TextureView$SurfaceTextureListenerC10537a.this.f29597TN = -1;
                    TextureView$SurfaceTextureListenerC10537a.this.aBx.mo25494n(i, i2);
                    TextureView$SurfaceTextureListenerC10537a.this.aBx.onPlayStateChanged(TextureView$SurfaceTextureListenerC10537a.this.f29597TN);
                    C10331c.m26248i("KSVideoPlayerViewView", "onError ——> STATE_ERROR ———— what：" + i + ", extra: " + i2);
                    return true;
                }
                return true;
            }
        };
        this.f29606Ug = new InterfaceC10522c.InterfaceC10526d() { // from class: com.kwad.sdk.core.video.videoview.a.5
            @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c.InterfaceC10526d
            /* renamed from: m */
            public final boolean mo25497m(int i, int i2) {
                if (i == 3) {
                    TextureView$SurfaceTextureListenerC10537a.this.f29597TN = 4;
                    TextureView$SurfaceTextureListenerC10537a.this.aBx.onPlayStateChanged(TextureView$SurfaceTextureListenerC10537a.this.f29597TN);
                    C10331c.m26248i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING");
                    return true;
                } else if (i == 701) {
                    if (TextureView$SurfaceTextureListenerC10537a.this.f29597TN != 5 && TextureView$SurfaceTextureListenerC10537a.this.f29597TN != 7) {
                        TextureView$SurfaceTextureListenerC10537a.this.f29597TN = 6;
                        C10331c.m26248i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING");
                    } else {
                        TextureView$SurfaceTextureListenerC10537a.this.f29597TN = 7;
                        C10331c.m26248i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED");
                    }
                    TextureView$SurfaceTextureListenerC10537a.this.aBx.onPlayStateChanged(TextureView$SurfaceTextureListenerC10537a.this.f29597TN);
                    return true;
                } else if (i == 702) {
                    if (TextureView$SurfaceTextureListenerC10537a.this.f29597TN == 6) {
                        TextureView$SurfaceTextureListenerC10537a.this.f29597TN = 4;
                        TextureView$SurfaceTextureListenerC10537a.this.aBx.onPlayStateChanged(TextureView$SurfaceTextureListenerC10537a.this.f29597TN);
                        C10331c.m26248i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                    }
                    if (TextureView$SurfaceTextureListenerC10537a.this.f29597TN == 7) {
                        TextureView$SurfaceTextureListenerC10537a.this.f29597TN = 5;
                        TextureView$SurfaceTextureListenerC10537a.this.aBx.onPlayStateChanged(TextureView$SurfaceTextureListenerC10537a.this.f29597TN);
                        C10331c.m26248i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED");
                        return true;
                    }
                    return true;
                } else if (i == 10001) {
                    if (TextureView$SurfaceTextureListenerC10537a.this.aBw != null) {
                        TextureView$SurfaceTextureListenerC10537a.this.aBw.setRotation(i2);
                        C10331c.m26248i("KSVideoPlayerViewView", "视频旋转角度：" + i2);
                        return true;
                    }
                    return true;
                } else if (i == 801) {
                    C10331c.m26248i("KSVideoPlayerViewView", "视频不能seekTo，为直播视频");
                    return true;
                } else {
                    C10331c.m26248i("KSVideoPlayerViewView", "onInfo ——> what：" + i);
                    return true;
                }
            }
        };
        this.f29607Uh = new InterfaceC10522c.InterfaceC10523a() { // from class: com.kwad.sdk.core.video.videoview.a.6
            @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c.InterfaceC10523a
            /* renamed from: av */
            public final void mo25496av(int i) {
                TextureView$SurfaceTextureListenerC10537a.this.f29599TP = i;
            }
        };
        this.mContext = context;
        init();
    }
}

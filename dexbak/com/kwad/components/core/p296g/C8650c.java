package com.kwad.components.core.p296g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.kwad.components.core.p286b.C8543c;
import com.kwad.components.core.p296g.RunnableC8647a;
import com.kwad.components.core.video.InterfaceC8997h;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.p434g.InterfaceC10761a;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.kwad.components.core.g.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8650c implements ImageLoadingListener {

    /* renamed from: LF */
    private C8649b f28297LF;
    @Nullable

    /* renamed from: LG */
    private RunnableC8647a f28298LG;

    /* renamed from: LJ */
    private long f28301LJ;

    /* renamed from: hj */
    private long f28303hj;

    /* renamed from: LH */
    private int f28299LH = 1;

    /* renamed from: LI */
    private int f28300LI = 16;

    /* renamed from: LK */
    private List<InterfaceC8997h> f28302LK = new CopyOnWriteArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.core.g.c$6 */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static /* synthetic */ class C86596 {

        /* renamed from: $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType */
        static final /* synthetic */ int[] f28316x5c614925;

        static {
            int[] iArr = new int[FailReason.FailType.values().length];
            f28316x5c614925 = iArr;
            try {
                iArr[FailReason.FailType.IO_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28316x5c614925[FailReason.FailType.DECODING_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f28316x5c614925[FailReason.FailType.NETWORK_DENIED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f28316x5c614925[FailReason.FailType.OUT_OF_MEMORY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f28316x5c614925[FailReason.FailType.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public C8650c() {
        RunnableC8647a runnableC8647a = new RunnableC8647a(new Handler(Looper.getMainLooper()));
        this.f28298LG = runnableC8647a;
        runnableC8647a.m30078a(new RunnableC8647a.InterfaceC8648a() { // from class: com.kwad.components.core.g.c.1

            /* renamed from: LL */
            private boolean f28304LL = false;

            /* renamed from: LM */
            private boolean f28305LM = false;

            /* renamed from: lb */
            private void m30064lb() {
                if (this.f28304LL) {
                    return;
                }
                C8650c.this.m30069b(new InterfaceC10761a<InterfaceC8997h>() { // from class: com.kwad.components.core.g.c.1.2
                    /* renamed from: e */
                    private static void m30060e(InterfaceC8997h interfaceC8997h) {
                        interfaceC8997h.onMediaPlayCompleted();
                    }

                    @Override // com.kwad.sdk.p434g.InterfaceC10761a
                    public final /* synthetic */ void accept(InterfaceC8997h interfaceC8997h) {
                        m30060e(interfaceC8997h);
                    }
                });
                this.f28304LL = true;
            }

            /* renamed from: oD */
            private void m30063oD() {
                if (this.f28305LM) {
                    return;
                }
                C10331c.m26254d("KSImagePlayer", "onFirstFrame: ");
                this.f28305LM = true;
                C8650c.this.m30069b(new InterfaceC10761a<InterfaceC8997h>() { // from class: com.kwad.components.core.g.c.1.3
                    /* renamed from: e */
                    private static void m30059e(InterfaceC8997h interfaceC8997h) {
                        interfaceC8997h.onMediaPlayStart();
                    }

                    @Override // com.kwad.sdk.p434g.InterfaceC10761a
                    public final /* synthetic */ void accept(InterfaceC8997h interfaceC8997h) {
                        m30059e(interfaceC8997h);
                    }
                });
            }

            @Override // com.kwad.components.core.p296g.RunnableC8647a.InterfaceC8648a
            /* renamed from: y */
            public final void mo30062y(final long j) {
                C10331c.m26254d("KSImagePlayer", "onTimerProgress: " + j);
                if (j == 0) {
                    m30063oD();
                }
                C8650c.this.f28303hj = j;
                C8650c.this.m30069b(new InterfaceC10761a<InterfaceC8997h>() { // from class: com.kwad.components.core.g.c.1.1
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.p434g.InterfaceC10761a
                    /* renamed from: e */
                    public void accept(InterfaceC8997h interfaceC8997h) {
                        interfaceC8997h.onMediaPlayProgress(C8650c.this.f28301LJ, j);
                    }
                });
                if (C8650c.this.f28303hj < C8650c.this.f28301LJ || C8650c.this.f28301LJ <= 0) {
                    return;
                }
                m30064lb();
            }
        });
    }

    /* renamed from: a */
    static /* synthetic */ int m30073a(C8650c c8650c, FailReason.FailType failType) {
        return m30071a(failType);
    }

    /* renamed from: oC */
    private void m30066oC() {
        C8649b c8649b = this.f28297LF;
        if (c8649b != null) {
            c8649b.setImageGravity(this.f28299LH | this.f28300LI);
        }
    }

    /* renamed from: c */
    public final void m30068c(InterfaceC8997h interfaceC8997h) {
        if (interfaceC8997h != null) {
            this.f28302LK.add(interfaceC8997h);
        }
    }

    /* renamed from: d */
    public final void m30067d(InterfaceC8997h interfaceC8997h) {
        if (interfaceC8997h != null) {
            this.f28302LK.remove(interfaceC8997h);
        }
    }

    public final void destroy() {
        this.f28302LK.clear();
        C8649b c8649b = this.f28297LF;
        if (c8649b != null && c8649b.getParent() != null) {
            ((ViewGroup) this.f28297LF.getParent()).removeView(this.f28297LF);
        }
        this.f28297LF = null;
        RunnableC8647a runnableC8647a = this.f28298LG;
        if (runnableC8647a != null) {
            runnableC8647a.destroy();
            this.f28298LG = null;
        }
    }

    public final FrameLayout getImagePlayerView(Context context) {
        if (this.f28297LF == null) {
            this.f28297LF = new C8649b(context);
        }
        return this.f28297LF;
    }

    public final long getPlayDuration() {
        return this.f28303hj;
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
        return false;
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingCancelled(String str, View view) {
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingFailed(String str, View view, final FailReason failReason) {
        m30069b(new InterfaceC10761a<InterfaceC8997h>() { // from class: com.kwad.components.core.g.c.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            /* renamed from: e */
            public void accept(InterfaceC8997h interfaceC8997h) {
                interfaceC8997h.onMediaPlayError(-1, C8650c.m30073a(C8650c.this, failReason.getType()));
            }
        });
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingStarted(String str, View view) {
    }

    public final void pause() {
        RunnableC8647a runnableC8647a = this.f28298LG;
        if (runnableC8647a != null) {
            runnableC8647a.pause();
        }
        m30069b(new InterfaceC10761a<InterfaceC8997h>() { // from class: com.kwad.components.core.g.c.2
            /* renamed from: e */
            private static void m30058e(InterfaceC8997h interfaceC8997h) {
                interfaceC8997h.onMediaPlayPaused();
            }

            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            public final /* synthetic */ void accept(InterfaceC8997h interfaceC8997h) {
                m30058e(interfaceC8997h);
            }
        });
    }

    public final void play() {
        RunnableC8647a runnableC8647a = this.f28298LG;
        if (runnableC8647a != null) {
            runnableC8647a.start();
        }
    }

    public final void resume() {
        RunnableC8647a runnableC8647a = this.f28298LG;
        if (runnableC8647a != null) {
            runnableC8647a.resume();
            m30069b(new InterfaceC10761a<InterfaceC8997h>() { // from class: com.kwad.components.core.g.c.3
                /* renamed from: e */
                private static void m30057e(InterfaceC8997h interfaceC8997h) {
                    interfaceC8997h.onMediaPlaying();
                }

                @Override // com.kwad.sdk.p434g.InterfaceC10761a
                public final /* synthetic */ void accept(InterfaceC8997h interfaceC8997h) {
                    m30057e(interfaceC8997h);
                }
            });
        }
    }

    public final void setHorizontalGravity(int i) {
        this.f28300LI = C8543c.m30407aj(i);
        m30066oC();
    }

    public final void setImageScaleType(ImageView.ScaleType scaleType) {
        C8649b c8649b = this.f28297LF;
        if (c8649b != null) {
            c8649b.setImageScaleType(scaleType);
        }
    }

    public final void setRadius(float f, float f2, float f3, float f4) {
        C8649b c8649b = this.f28297LF;
        if (c8649b != null) {
            c8649b.setRadius(f, f2, f3, f4);
        }
    }

    public final void setURLs(List<String> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        String str = list.get(0);
        C8649b c8649b = this.f28297LF;
        if (c8649b != null) {
            c8649b.m30077a(str, this);
        }
    }

    public final void setVerticalGravity(int i) {
        this.f28300LI = C8543c.m30408ai(i);
        m30066oC();
    }

    public final void skipToEnd() {
        m30069b(new InterfaceC10761a<InterfaceC8997h>() { // from class: com.kwad.components.core.g.c.4
            /* renamed from: e */
            private static void m30056e(InterfaceC8997h interfaceC8997h) {
                interfaceC8997h.onMediaPlayCompleted();
            }

            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            public final /* synthetic */ void accept(InterfaceC8997h interfaceC8997h) {
                m30056e(interfaceC8997h);
            }
        });
    }

    public final void stop() {
        RunnableC8647a runnableC8647a = this.f28298LG;
        if (runnableC8647a != null) {
            runnableC8647a.stop();
        }
    }

    /* renamed from: z */
    public final void m30065z(long j) {
        this.f28301LJ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public <T> void m30069b(InterfaceC10761a<InterfaceC8997h> interfaceC10761a) {
        List<InterfaceC8997h> list;
        if (interfaceC10761a == null || (list = this.f28302LK) == null) {
            return;
        }
        for (InterfaceC8997h interfaceC8997h : list) {
            interfaceC10761a.accept(interfaceC8997h);
        }
    }

    /* renamed from: a */
    private static int m30071a(FailReason.FailType failType) {
        int i = C86596.f28316x5c614925[failType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return i != 4 ? -1 : -5;
                }
                return -4;
            }
            return -3;
        }
        return -2;
    }
}

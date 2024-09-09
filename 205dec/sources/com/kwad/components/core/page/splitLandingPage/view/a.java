package com.kwad.components.core.page.splitLandingPage.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.s.n;
import com.kwad.components.core.video.a;
import com.kwad.components.core.video.e;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.n.l;
import java.io.PrintStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private ImageView IL;
    @Nullable
    private WindowManager Qe;
    private com.kwad.components.core.page.splitLandingPage.a.a Qf;
    private FrameLayout Qg;
    private FrameLayout Qh;
    private e Qi;
    private final WindowManager.LayoutParams Qj = new WindowManager.LayoutParams();
    private InterfaceC0645a Qk;
    private ImageView eM;
    private com.kwad.sdk.core.video.videoview.a eN;
    private Context mContext;
    private ViewGroup yG;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.core.page.splitLandingPage.view.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface InterfaceC0645a {
        boolean pX();
    }

    @SuppressLint({"ClickableViewAccessibility", "InflateParams"})
    public a(Context context, com.kwad.components.core.page.splitLandingPage.a.a aVar) {
        if (context == null) {
            return;
        }
        Context wrapContextIfNeed = l.wrapContextIfNeed(context);
        this.mContext = wrapContextIfNeed;
        this.Qf = aVar;
        WindowManager windowManager = (WindowManager) wrapContextIfNeed.getSystemService("window");
        this.Qe = windowManager;
        if (windowManager == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.ksad_split_mini_video, (ViewGroup) null);
        this.yG = viewGroup;
        this.Qg = (FrameLayout) viewGroup.findViewById(R.id.ksad_split_texture);
        this.Qh = (FrameLayout) this.yG.findViewById(R.id.ksad_video_container);
        this.eM = (ImageView) this.yG.findViewById(R.id.ksad_video_first_frame_container);
        this.IL = (ImageView) this.yG.findViewById(R.id.ksad_split_mini_close_btn);
        this.Qg.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.1
            float Ql = 0.0f;
            float Qm = 0.0f;

            /* renamed from: top  reason: collision with root package name */
            float f38648top = 0.0f;
            float left = 0.0f;
            long Qn = 0;

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.Qj == null) {
                    return false;
                }
                if (motionEvent.getActionMasked() == 0) {
                    this.Ql = motionEvent.getRawX();
                    this.Qm = motionEvent.getRawY();
                    this.left = a.this.Qj.x;
                    this.f38648top = a.this.Qj.y;
                    this.Qn = SystemClock.elapsedRealtime();
                    PrintStream printStream = System.out;
                    printStream.println(" actionDownX " + this.Ql + " actionDownX " + this.Ql);
                } else if (motionEvent.getActionMasked() == 2) {
                    float rawX = motionEvent.getRawX() - this.Ql;
                    float rawY = motionEvent.getRawY() - this.Qm;
                    if (Math.sqrt((rawX * rawX) + (rawY * rawY)) > 15.0d) {
                        a.this.Qj.x = (int) (this.left + rawX);
                        a.this.Qj.y = (int) (this.f38648top + rawY);
                        if (a.this.Qe != null) {
                            try {
                                a.this.Qe.updateViewLayout(a.this.yG, a.this.Qj);
                            } catch (Exception e4) {
                                com.kwad.components.core.d.a.reportSdkCaughtException(e4);
                                c.printStackTraceOnly(e4);
                            }
                        }
                    }
                    return true;
                } else if (motionEvent.getActionMasked() == 1) {
                    float rawX2 = motionEvent.getRawX() - this.Ql;
                    float rawY2 = motionEvent.getRawY() - this.Qm;
                    float elapsedRealtime = (float) (SystemClock.elapsedRealtime() - this.Qn);
                    if (Math.sqrt((rawX2 * rawX2) + (rawY2 * rawY2)) < 15.0d && elapsedRealtime > 30.0f && elapsedRealtime < 300.0f && a.this.Qk != null && a.this.Qf != null && com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.dQ(a.this.Qf.getAdTemplate()))) {
                        a.this.Qk.pX();
                    }
                }
                return true;
            }
        });
    }

    public final Animator aH(boolean z3) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(n.h(this.yG, z3), n.h(this.eM, z3));
        return animatorSet;
    }

    public final boolean isVisible() {
        return this.yG.getAlpha() > 0.0f;
    }

    public final void pW() {
        this.Qi.ad();
    }

    public final boolean pZ() {
        int i4;
        int i5;
        int i6;
        int i7;
        if (this.Qf == null || this.Qe == null) {
            return false;
        }
        b(new KsAdVideoPlayConfig.Builder().videoSoundEnable(this.Qf.getAdTemplate().mIsAudioEnable).build());
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(this.Qf.getAdTemplate());
        int R = com.kwad.sdk.core.response.b.a.R(dQ);
        int Q = com.kwad.sdk.core.response.b.a.Q(dQ);
        Rect rect = new Rect();
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (R > Q) {
            int i8 = displayMetrics.widthPixels;
            rect.right = i8;
            rect.left = i8 - com.kwad.sdk.d.a.a.a(this.mContext, 86.0f);
            int a4 = displayMetrics.heightPixels - com.kwad.sdk.d.a.a.a(this.mContext, 252.0f);
            rect.bottom = a4;
            rect.top = a4 - com.kwad.sdk.d.a.a.a(this.mContext, 154.0f);
        } else {
            int i9 = displayMetrics.widthPixels;
            rect.right = i9;
            rect.left = i9 - com.kwad.sdk.d.a.a.a(this.mContext, 154.0f);
            int a5 = displayMetrics.heightPixels - com.kwad.sdk.d.a.a.a(this.mContext, 252.0f);
            rect.bottom = a5;
            rect.top = a5 - com.kwad.sdk.d.a.a.a(this.mContext, 86.0f);
        }
        rect.left -= com.kwad.sdk.d.a.a.a(this.mContext, 12.0f);
        int a6 = rect.right - com.kwad.sdk.d.a.a.a(this.mContext, 12.0f);
        rect.right = a6;
        WindowManager.LayoutParams layoutParams = this.Qj;
        layoutParams.type = 1003;
        layoutParams.flags = 8;
        layoutParams.gravity = 51;
        layoutParams.format = 1;
        layoutParams.width = displayMetrics.widthPixels;
        layoutParams.height = displayMetrics.heightPixels;
        int i10 = rect.left;
        layoutParams.x = i10;
        layoutParams.y = rect.top;
        layoutParams.width = (a6 - i10) + com.kwad.sdk.d.a.a.a(this.mContext, 12.0f);
        this.Qj.height = (rect.bottom - rect.top) + com.kwad.sdk.d.a.a.a(this.mContext, 12.0f);
        float f4 = (rect.left * displayMetrics.widthPixels) / ((i4 + i5) - rect.right);
        this.yG.setPivotX(f4);
        this.yG.setPivotY((rect.top * displayMetrics.heightPixels) / ((i6 + i7) - rect.bottom));
        this.yG.setAlpha(0.0f);
        if (this.Qe != null) {
            try {
                if (this.yG.getWindowToken() == null) {
                    this.Qe.addView(this.yG, this.Qj);
                }
            } catch (Exception e4) {
                com.kwad.components.core.d.a.reportSdkCaughtException(e4);
                c.printStackTraceOnly(e4);
            }
        }
        this.IL.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.this.pW();
                a.this.aH(false).start();
            }
        });
        return true;
    }

    public final void qa() {
        com.kwad.sdk.core.video.videoview.a aVar = this.eN;
        if (aVar == null || aVar.isPlaying()) {
            return;
        }
        this.Qi.rL();
    }

    private void b(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        AdTemplate adTemplate = this.Qf.getAdTemplate();
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        String url = com.kwad.sdk.core.response.b.a.br(dQ).getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.eM.setImageDrawable(null);
            KSImageLoader.loadImage(this.eM, url, adTemplate);
            this.eM.setVisibility(0);
        } else {
            this.eM.setVisibility(8);
        }
        String K = com.kwad.sdk.core.response.b.a.K(dQ);
        if (TextUtils.isEmpty(K)) {
            return;
        }
        com.kwad.sdk.core.video.videoview.a ew = AdVideoPlayerViewCache.getInstance().ew(K);
        this.eN = ew;
        if (ew == null) {
            this.eN = new com.kwad.sdk.core.video.videoview.a(this.mContext);
            com.kwad.sdk.core.response.b.a.ab(dQ);
            this.eN.a(new b.a(adTemplate).a(adTemplate.mVideoPlayerStatus).cR(com.kwad.sdk.core.response.b.e.dS(adTemplate)).cS(h.b(com.kwad.sdk.core.response.b.e.dR(adTemplate))).b(new com.kwad.sdk.contentalliance.a.a.a(adTemplate, System.currentTimeMillis())).Bb(), null);
            this.eN.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
            e eVar = new e(this.mContext, adTemplate, this.eN, ksAdVideoPlayConfig);
            this.Qi = eVar;
            eVar.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.eN.setController(this.Qi);
            this.Qi.setAutoRelease(false);
        } else {
            e eVar2 = (e) ew.getController();
            this.Qi = eVar2;
            eVar2.setAutoRelease(false);
            this.Qi.getAdTemplate().mAdWebVideoPageShowing = true;
        }
        this.eN.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
        if (this.eN.getParent() != null) {
            ((ViewGroup) this.eN.getParent()).removeView(this.eN);
        }
        if (this.Qh.getTag() != null) {
            FrameLayout frameLayout = this.Qh;
            frameLayout.removeView((View) frameLayout.getTag());
            this.Qh.setTag(null);
        }
        this.Qh.addView(this.eN);
        this.Qh.setTag(this.eN);
        this.Qi.setAlpha(0.01f);
        this.Qi.setVideoPlayCallback(new a.c() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.3
            @Override // com.kwad.components.core.video.a.c
            public final void bl() {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void bm() {
                a.this.pW();
                a.this.aH(false).start();
            }

            @Override // com.kwad.components.core.video.a.c
            public final void e(long j4) {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
            }
        });
    }

    public final void a(InterfaceC0645a interfaceC0645a) {
        this.Qk = interfaceC0645a;
    }
}

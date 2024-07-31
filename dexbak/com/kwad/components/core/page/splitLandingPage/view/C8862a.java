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
import com.kwad.components.core.p288d.C8571a;
import com.kwad.components.core.p330s.C8951n;
import com.kwad.components.core.page.splitLandingPage.p324a.C8860a;
import com.kwad.components.core.video.C8993e;
import com.kwad.components.core.video.View$OnClickListenerC8966a;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.p383a.p384a.C9877a;
import com.kwad.sdk.contentalliance.p383a.p384a.C9878b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.response.p409b.C10490h;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.video.videoview.TextureView$SurfaceTextureListenerC10537a;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.p445n.C10887l;
import java.io.PrintStream;

/* renamed from: com.kwad.components.core.page.splitLandingPage.view.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8862a {

    /* renamed from: IL */
    private ImageView f28684IL;
    @Nullable

    /* renamed from: Qe */
    private WindowManager f28685Qe;

    /* renamed from: Qf */
    private C8860a f28686Qf;

    /* renamed from: Qg */
    private FrameLayout f28687Qg;

    /* renamed from: Qh */
    private FrameLayout f28688Qh;

    /* renamed from: Qi */
    private C8993e f28689Qi;

    /* renamed from: Qj */
    private final WindowManager.LayoutParams f28690Qj = new WindowManager.LayoutParams();

    /* renamed from: Qk */
    private InterfaceC8866a f28691Qk;

    /* renamed from: eM */
    private ImageView f28692eM;

    /* renamed from: eN */
    private TextureView$SurfaceTextureListenerC10537a f28693eN;
    private Context mContext;

    /* renamed from: yG */
    private ViewGroup f28694yG;

    /* renamed from: com.kwad.components.core.page.splitLandingPage.view.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8866a {
        /* renamed from: pX */
        boolean mo29710pX();
    }

    @SuppressLint({"ClickableViewAccessibility", "InflateParams"})
    public C8862a(Context context, C8860a c8860a) {
        if (context == null) {
            return;
        }
        Context wrapContextIfNeed = C10887l.wrapContextIfNeed(context);
        this.mContext = wrapContextIfNeed;
        this.f28686Qf = c8860a;
        WindowManager windowManager = (WindowManager) wrapContextIfNeed.getSystemService("window");
        this.f28685Qe = windowManager;
        if (windowManager == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(C9659R.C9663layout.ksad_split_mini_video, (ViewGroup) null);
        this.f28694yG = viewGroup;
        this.f28687Qg = (FrameLayout) viewGroup.findViewById(C9659R.C9662id.ksad_split_texture);
        this.f28688Qh = (FrameLayout) this.f28694yG.findViewById(C9659R.C9662id.ksad_video_container);
        this.f28692eM = (ImageView) this.f28694yG.findViewById(C9659R.C9662id.ksad_video_first_frame_container);
        this.f28684IL = (ImageView) this.f28694yG.findViewById(C9659R.C9662id.ksad_split_mini_close_btn);
        this.f28687Qg.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.1

            /* renamed from: Ql */
            float f28695Ql = 0.0f;

            /* renamed from: Qm */
            float f28696Qm = 0.0f;

            /* renamed from: top  reason: collision with root package name */
            float f47203top = 0.0f;
            float left = 0.0f;

            /* renamed from: Qn */
            long f28697Qn = 0;

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (C8862a.this.f28690Qj == null) {
                    return false;
                }
                if (motionEvent.getActionMasked() == 0) {
                    this.f28695Ql = motionEvent.getRawX();
                    this.f28696Qm = motionEvent.getRawY();
                    this.left = C8862a.this.f28690Qj.x;
                    this.f47203top = C8862a.this.f28690Qj.y;
                    this.f28697Qn = SystemClock.elapsedRealtime();
                    PrintStream printStream = System.out;
                    printStream.println(" actionDownX " + this.f28695Ql + " actionDownX " + this.f28695Ql);
                } else if (motionEvent.getActionMasked() == 2) {
                    float rawX = motionEvent.getRawX() - this.f28695Ql;
                    float rawY = motionEvent.getRawY() - this.f28696Qm;
                    if (Math.sqrt((rawX * rawX) + (rawY * rawY)) > 15.0d) {
                        C8862a.this.f28690Qj.x = (int) (this.left + rawX);
                        C8862a.this.f28690Qj.y = (int) (this.f47203top + rawY);
                        if (C8862a.this.f28685Qe != null) {
                            try {
                                C8862a.this.f28685Qe.updateViewLayout(C8862a.this.f28694yG, C8862a.this.f28690Qj);
                            } catch (Exception e) {
                                C8571a.reportSdkCaughtException(e);
                                C10331c.printStackTraceOnly(e);
                            }
                        }
                    }
                    return true;
                } else if (motionEvent.getActionMasked() == 1) {
                    float rawX2 = motionEvent.getRawX() - this.f28695Ql;
                    float rawY2 = motionEvent.getRawY() - this.f28696Qm;
                    float elapsedRealtime = (float) (SystemClock.elapsedRealtime() - this.f28697Qn);
                    if (Math.sqrt((rawX2 * rawX2) + (rawY2 * rawY2)) < 15.0d && elapsedRealtime > 30.0f && elapsedRealtime < 300.0f && C8862a.this.f28691Qk != null && C8862a.this.f28686Qf != null && C10483a.m25956aF(C10487e.m25641dQ(C8862a.this.f28686Qf.getAdTemplate()))) {
                        C8862a.this.f28691Qk.mo29710pX();
                    }
                }
                return true;
            }
        });
    }

    /* renamed from: aH */
    public final Animator m29719aH(boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(C8951n.m29526h(this.f28694yG, z), C8951n.m29526h(this.f28692eM, z));
        return animatorSet;
    }

    public final boolean isVisible() {
        return this.f28694yG.getAlpha() > 0.0f;
    }

    /* renamed from: pW */
    public final void m29713pW() {
        this.f28689Qi.m29431ad();
    }

    /* renamed from: pZ */
    public final boolean m29712pZ() {
        int i;
        int i2;
        int i3;
        int i4;
        if (this.f28686Qf == null || this.f28685Qe == null) {
            return false;
        }
        m29717b(new KsAdVideoPlayConfig.Builder().videoSoundEnable(this.f28686Qf.getAdTemplate().mIsAudioEnable).build());
        AdInfo m25641dQ = C10487e.m25641dQ(this.f28686Qf.getAdTemplate());
        int m25970R = C10483a.m25970R(m25641dQ);
        int m25971Q = C10483a.m25971Q(m25641dQ);
        Rect rect = new Rect();
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (m25970R > m25971Q) {
            int i5 = displayMetrics.widthPixels;
            rect.right = i5;
            rect.left = i5 - C10751a.m24924a(this.mContext, 86.0f);
            int m24924a = displayMetrics.heightPixels - C10751a.m24924a(this.mContext, 252.0f);
            rect.bottom = m24924a;
            rect.top = m24924a - C10751a.m24924a(this.mContext, 154.0f);
        } else {
            int i6 = displayMetrics.widthPixels;
            rect.right = i6;
            rect.left = i6 - C10751a.m24924a(this.mContext, 154.0f);
            int m24924a2 = displayMetrics.heightPixels - C10751a.m24924a(this.mContext, 252.0f);
            rect.bottom = m24924a2;
            rect.top = m24924a2 - C10751a.m24924a(this.mContext, 86.0f);
        }
        rect.left -= C10751a.m24924a(this.mContext, 12.0f);
        int m24924a3 = rect.right - C10751a.m24924a(this.mContext, 12.0f);
        rect.right = m24924a3;
        WindowManager.LayoutParams layoutParams = this.f28690Qj;
        layoutParams.type = 1003;
        layoutParams.flags = 8;
        layoutParams.gravity = 51;
        layoutParams.format = 1;
        layoutParams.width = displayMetrics.widthPixels;
        layoutParams.height = displayMetrics.heightPixels;
        int i7 = rect.left;
        layoutParams.x = i7;
        layoutParams.y = rect.top;
        layoutParams.width = (m24924a3 - i7) + C10751a.m24924a(this.mContext, 12.0f);
        this.f28690Qj.height = (rect.bottom - rect.top) + C10751a.m24924a(this.mContext, 12.0f);
        float f = (rect.left * displayMetrics.widthPixels) / ((i + i2) - rect.right);
        this.f28694yG.setPivotX(f);
        this.f28694yG.setPivotY((rect.top * displayMetrics.heightPixels) / ((i3 + i4) - rect.bottom));
        this.f28694yG.setAlpha(0.0f);
        if (this.f28685Qe != null) {
            try {
                if (this.f28694yG.getWindowToken() == null) {
                    this.f28685Qe.addView(this.f28694yG, this.f28690Qj);
                }
            } catch (Exception e) {
                C8571a.reportSdkCaughtException(e);
                C10331c.printStackTraceOnly(e);
            }
        }
        this.f28684IL.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C8862a.this.m29713pW();
                C8862a.this.m29719aH(false).start();
            }
        });
        return true;
    }

    /* renamed from: qa */
    public final void m29711qa() {
        TextureView$SurfaceTextureListenerC10537a textureView$SurfaceTextureListenerC10537a = this.f28693eN;
        if (textureView$SurfaceTextureListenerC10537a == null || textureView$SurfaceTextureListenerC10537a.isPlaying()) {
            return;
        }
        this.f28689Qi.m29427rL();
    }

    /* renamed from: b */
    private void m29717b(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        AdTemplate adTemplate = this.f28686Qf.getAdTemplate();
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        String url = C10483a.m25862br(m25641dQ).getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.f28692eM.setImageDrawable(null);
            KSImageLoader.loadImage(this.f28692eM, url, adTemplate);
            this.f28692eM.setVisibility(0);
        } else {
            this.f28692eM.setVisibility(8);
        }
        String m25977K = C10483a.m25977K(m25641dQ);
        if (TextUtils.isEmpty(m25977K)) {
            return;
        }
        TextureView$SurfaceTextureListenerC10537a m25522ew = AdVideoPlayerViewCache.getInstance().m25522ew(m25977K);
        this.f28693eN = m25522ew;
        if (m25522ew == null) {
            this.f28693eN = new TextureView$SurfaceTextureListenerC10537a(this.mContext);
            C10483a.m25934ab(m25641dQ);
            this.f28693eN.m25515a(new C9878b.C9879a(adTemplate).m27475a(adTemplate.mVideoPlayerStatus).m27470cR(C10487e.m25639dS(adTemplate)).m27469cS(C10490h.m25611b(C10487e.m25640dR(adTemplate))).m27474b(new C9877a(adTemplate, System.currentTimeMillis())).m27477Bb(), null);
            this.f28693eN.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
            C8993e c8993e = new C8993e(this.mContext, adTemplate, this.f28693eN, ksAdVideoPlayConfig);
            this.f28689Qi = c8993e;
            c8993e.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.f28693eN.setController(this.f28689Qi);
            this.f28689Qi.setAutoRelease(false);
        } else {
            C8993e c8993e2 = (C8993e) m25522ew.getController();
            this.f28689Qi = c8993e2;
            c8993e2.setAutoRelease(false);
            this.f28689Qi.getAdTemplate().mAdWebVideoPageShowing = true;
        }
        this.f28693eN.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
        if (this.f28693eN.getParent() != null) {
            ((ViewGroup) this.f28693eN.getParent()).removeView(this.f28693eN);
        }
        if (this.f28688Qh.getTag() != null) {
            FrameLayout frameLayout = this.f28688Qh;
            frameLayout.removeView((View) frameLayout.getTag());
            this.f28688Qh.setTag(null);
        }
        this.f28688Qh.addView(this.f28693eN);
        this.f28688Qh.setTag(this.f28693eN);
        this.f28689Qi.setAlpha(0.01f);
        this.f28689Qi.setVideoPlayCallback(new View$OnClickListenerC8966a.InterfaceC8970c() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.3
            @Override // com.kwad.components.core.video.View$OnClickListenerC8966a.InterfaceC8970c
            /* renamed from: bl */
            public final void mo28935bl() {
            }

            @Override // com.kwad.components.core.video.View$OnClickListenerC8966a.InterfaceC8970c
            /* renamed from: bm */
            public final void mo28934bm() {
                C8862a.this.m29713pW();
                C8862a.this.m29719aH(false).start();
            }

            @Override // com.kwad.components.core.video.View$OnClickListenerC8966a.InterfaceC8970c
            /* renamed from: e */
            public final void mo28933e(long j) {
            }

            @Override // com.kwad.components.core.video.View$OnClickListenerC8966a.InterfaceC8970c
            public final void onVideoPlayStart() {
            }
        });
    }

    /* renamed from: a */
    public final void m29721a(InterfaceC8866a interfaceC8866a) {
        this.f28691Qk = interfaceC8866a;
    }
}

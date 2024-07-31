package com.kwad.components.core.widget;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.p317o.C8766a;
import com.kwad.components.core.p330s.RunnableC8957o;
import com.kwad.components.core.video.C8993e;
import com.kwad.components.core.video.View$OnClickListenerC8966a;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.contentalliance.p383a.p384a.C9877a;
import com.kwad.sdk.contentalliance.p383a.p384a.C9878b;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.download.p395a.AbstractC10298a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.C10493b;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.response.p409b.C10490h;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.video.videoview.TextureView$SurfaceTextureListenerC10537a;
import com.kwad.sdk.core.view.ScaleAnimSeekBar;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.utils.C11008ac;
import com.kwad.sdk.utils.C11015ai;
import com.kwad.sdk.utils.C11062bl;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class FeedVideoView extends AbstractDialogInterface$OnDismissListenerC9367b<AdResultData, AdTemplate> implements NestedScrollingChild {

    /* renamed from: PQ */
    private NestedScrollingChildHelper f29444PQ;

    /* renamed from: Qi */
    private C8993e f29445Qi;
    private RatioFrameLayout abB;
    private TextView abC;
    private TextView abD;
    private TextView abE;
    private View abF;
    private KSCornerImageView abG;
    private TextView abH;
    private ScaleAnimSeekBar abI;
    private ImageView abJ;
    private ImageView abK;
    private ImageView abL;
    private ViewGroup abM;
    private ViewGroup abN;
    private TextView abO;
    private ViewGroup abP;
    private ViewGroup abQ;
    private int abR;
    private boolean abS;
    private boolean abT;
    private long abU;
    private boolean abV;
    private KsAdVideoPlayConfig abW;
    private InterfaceC9357a abX;
    private View abY;
    private boolean abZ;
    private Runnable aca;
    private RunnableC8957o acb;

    /* renamed from: bU */
    private View.OnClickListener f29446bU;

    /* renamed from: cB */
    private List<Integer> f29447cB;

    /* renamed from: cx */
    private KsAppDownloadListener f29448cx;

    /* renamed from: eB */
    private TextView f29449eB;

    /* renamed from: eM */
    private ImageView f29450eM;

    /* renamed from: eN */
    private TextureView$SurfaceTextureListenerC10537a f29451eN;
    private C8619c mApkDownloadHelper;

    /* renamed from: com.kwad.components.core.widget.FeedVideoView$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9357a {
        /* renamed from: pq */
        void mo28931pq();

        /* renamed from: pr */
        void mo28930pr();
    }

    public FeedVideoView(@NonNull Context context) {
        super(context);
        this.abR = 100;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.5
            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.abM.setVisibility(8);
                FeedVideoView.this.abL.setVisibility(8);
                if (FeedVideoView.this.f29445Qi != null) {
                    FeedVideoView.this.f29445Qi.m29505aO(true);
                }
            }
        };
        this.aca = runnable;
        this.acb = new RunnableC8957o(runnable);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.f29448cx == null) {
            this.f29448cx = new AbstractC10298a() { // from class: com.kwad.components.core.widget.FeedVideoView.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    FeedVideoView.this.abE.setText(C10483a.m25957aE(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    FeedVideoView.this.abE.setText(C10483a.m25882bY(FeedVideoView.this.mAdTemplate));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    FeedVideoView.this.abE.setText(C10483a.m25957aE(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    FeedVideoView.this.abE.setText(C10483a.m25933ac(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.core.download.p395a.AbstractC10298a
                public final void onPaused(int i) {
                    FeedVideoView.this.abE.setText(C10483a.m25794dn(i));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    FeedVideoView.this.abE.setText(C10483a.m25795dm(i));
                }
            };
        }
        return this.f29448cx;
    }

    /* renamed from: tn */
    private boolean m28939tn() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = elapsedRealtime - this.abU;
        if (j > 888) {
            this.abU = elapsedRealtime;
        }
        return j > 888;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: to */
    public void m28938to() {
        InterfaceC9357a interfaceC9357a = this.abX;
        if (interfaceC9357a != null) {
            interfaceC9357a.mo28931pq();
        }
        if ((this.abR == 100) && m28939tn()) {
            this.abN.setVisibility(0);
            this.abO.setText(this.mAdInfo.adBaseInfo.adDescription);
            boolean z = C10483a.m25970R(this.mAdInfo) > C10483a.m25971Q(this.mAdInfo);
            this.abS = C11015ai.m24121cl(getContext());
            getContext();
            this.abT = C11015ai.m24123LZ();
            if (!z) {
                C11015ai.m24119cn(getContext());
            } else {
                C11015ai.m24118co(getContext());
            }
            ViewGroup viewGroup = (ViewGroup) this.abP.getParent();
            this.abQ = viewGroup;
            if (viewGroup != null) {
                viewGroup.removeView(this.abP);
                View view = new View(this.abP.getContext());
                this.abY = view;
                view.setLayoutParams(new ViewGroup.LayoutParams(this.abP.getWidth(), this.abP.getHeight()));
                viewGroup.addView(this.abY);
            }
            C11015ai.m24122b(getContext(), false);
            Activity m24559dn = C10887l.m24559dn(getContext());
            if (m24559dn != null) {
                ViewGroup viewGroup2 = (ViewGroup) m24559dn.getWindow().getDecorView();
                this.abP.setLayoutParams(new ViewGroup.LayoutParams(viewGroup2.getWidth(), viewGroup2.getHeight()));
                if (z && viewGroup2.getWidth() != 0) {
                    this.abB.setRatio(viewGroup2.getHeight() / viewGroup2.getWidth());
                }
                viewGroup2.addView(this.abP, new FrameLayout.LayoutParams(-1, -1));
                setUIWithStateAndMode(101);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: tp */
    public void m28937tp() {
        if ((this.abR == 101) & m28939tn()) {
            this.abN.setVisibility(8);
            if (this.abS) {
                C11015ai.m24121cl(getContext());
            } else {
                C11015ai.m24120cm(getContext());
            }
            if (this.abT) {
                C11015ai.m24118co(getContext());
            } else {
                C11015ai.m24119cn(getContext());
            }
            C11015ai.m24122b(getContext(), true);
            ViewGroup viewGroup = (ViewGroup) this.abP.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.abP);
            }
            this.abP.setLayoutParams(new ViewGroup.LayoutParams(this.abQ.getWidth(), this.abQ.getHeight()));
            this.abB.setRatio(0.5600000023841858d);
            View view = this.abY;
            if (view != null) {
                this.abQ.removeView(view);
                this.abY = null;
            }
            this.abQ.addView(this.abP, new FrameLayout.LayoutParams(-1, -2));
            this.abP.requestLayout();
            setUIWithStateAndMode(100);
        }
        InterfaceC9357a interfaceC9357a = this.abX;
        if (interfaceC9357a != null) {
            interfaceC9357a.mo28930pr();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.InterfaceC11153i
    /* renamed from: A */
    public final void mo23527A(View view) {
        super.mo23527A(view);
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b, com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aM */
    public final void mo26182aM() {
        super.mo26182aM();
        TextureView$SurfaceTextureListenerC10537a textureView$SurfaceTextureListenerC10537a = this.f29451eN;
        if (textureView$SurfaceTextureListenerC10537a == null || textureView$SurfaceTextureListenerC10537a.isPlaying()) {
            return;
        }
        m28942qa();
        if (getHandler() != null) {
            getHandler().removeCallbacks(this.acb);
            getHandler().postDelayed(this.acb, 5000L);
        }
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b, com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aN */
    public final void mo26181aN() {
        super.mo26181aN();
        if (this.f29451eN != null) {
            m28940rp();
            if (getHandler() != null) {
                getHandler().removeCallbacks(this.acb);
                getHandler().postDelayed(this.acb, 5000L);
            }
        }
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b
    /* renamed from: bc */
    protected final void mo28890bc() {
        this.f29444PQ = new NestedScrollingChildHelper(this);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(C9659R.C9662id.ksad_video_container);
        this.abB = ratioFrameLayout;
        ratioFrameLayout.setRatio(0.5600000023841858d);
        this.f29450eM = (ImageView) findViewById(C9659R.C9662id.ksad_video_first_frame_container);
        this.f29449eB = (TextView) findViewById(C9659R.C9662id.ksad_video_text_below);
        ScaleAnimSeekBar scaleAnimSeekBar = (ScaleAnimSeekBar) findViewById(C9659R.C9662id.ksad_web_video_seek_bar);
        this.abI = scaleAnimSeekBar;
        scaleAnimSeekBar.setMaxProgress(100);
        this.abI.setMinProgress(0);
        this.abE = (TextView) findViewById(C9659R.C9662id.ksad_video_text_below_action_bar);
        this.abF = findViewById(C9659R.C9662id.ksad_video_text_below_action_icon_layout);
        this.abH = (TextView) findViewById(C9659R.C9662id.ksad_video_text_below_action_title);
        this.abG = (KSCornerImageView) findViewById(C9659R.C9662id.ksad_video_text_below_action_icon);
        this.abC = (TextView) findViewById(C9659R.C9662id.ksad_video_control_play_total);
        this.abD = (TextView) findViewById(C9659R.C9662id.ksad_video_control_play_duration);
        this.abJ = (ImageView) findViewById(C9659R.C9662id.ksad_video_control_play_button);
        this.abL = (ImageView) findViewById(C9659R.C9662id.ksad_video_control_play_status);
        this.abK = (ImageView) findViewById(C9659R.C9662id.ksad_video_control_fullscreen);
        this.abM = (ViewGroup) findViewById(C9659R.C9662id.ksad_video_control_container);
        this.abP = (ViewGroup) findViewById(C9659R.C9662id.ksad_feed_video_container);
        this.abN = (ViewGroup) findViewById(C9659R.C9662id.ksad_video_control_fullscreen_container);
        this.abO = (TextView) findViewById(C9659R.C9662id.ksad_video_control_fullscreen_title);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f29444PQ.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f29444PQ.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f29444PQ.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f29444PQ.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b
    protected int getLayoutId() {
        return C9659R.C9663layout.ksad_feed_video;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.f29444PQ.hasNestedScrollingParent();
    }

    public final boolean isComplete() {
        TextureView$SurfaceTextureListenerC10537a textureView$SurfaceTextureListenerC10537a = this.f29451eN;
        if (textureView$SurfaceTextureListenerC10537a != null) {
            return textureView$SurfaceTextureListenerC10537a.isCompleted();
        }
        return true;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.f29444PQ.isNestedScrollingEnabled();
    }

    /* renamed from: pW */
    public final void m28944pW() {
        this.f29445Qi.m29430rI();
    }

    /* renamed from: qa */
    public final void m28942qa() {
        this.f29445Qi.m29427rL();
        this.f29445Qi.setVisibility(0);
        this.f29445Qi.setAlpha(1.0f);
        this.abJ.setImageDrawable(getContext().getResources().getDrawable(C9659R.C9661drawable.ksad_video_player_pause_btn));
        this.abL.setImageDrawable(getContext().getResources().getDrawable(C9659R.C9661drawable.ksad_video_player_pause_center));
    }

    public final void release() {
        C8993e c8993e = this.f29445Qi;
        if (c8993e != null) {
            c8993e.release();
        }
    }

    /* renamed from: rp */
    public final void m28940rp() {
        this.f29445Qi.m29428rK();
        this.abL.setVisibility(0);
        this.abL.setImageDrawable(getContext().getResources().getDrawable(C9659R.C9661drawable.ksad_video_play_176));
        this.abJ.setImageDrawable(getContext().getResources().getDrawable(C9659R.C9661drawable.ksad_video_player_play_btn));
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.f29444PQ.setNestedScrollingEnabled(z);
    }

    public void setOnEndBtnClickListener(View.OnClickListener onClickListener) {
        this.f29446bU = onClickListener;
    }

    protected void setUIWithStateAndMode(int i) {
        if (i == 101) {
            this.abK.setImageDrawable(getContext().getResources().getDrawable(C9659R.C9661drawable.ksad_video_player_exit_fullscreen_btn));
        } else {
            this.abK.setImageDrawable(getContext().getResources().getDrawable(C9659R.C9661drawable.ksad_video_player_fullscreen_btn));
        }
        this.abR = i;
    }

    public void setWindowFullScreenListener(InterfaceC9357a interfaceC9357a) {
        this.abX = interfaceC9357a;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.f29444PQ.startNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.f29444PQ.stopNestedScroll();
    }

    /* renamed from: tq */
    public final boolean m28936tq() {
        if (this.abR == 101) {
            m28937tp();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m28959c(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.f29447cB;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.f29447cB.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                C9908c.m27348a((AdTemplate) this.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m28963a(FeedVideoView feedVideoView, boolean z) {
        feedVideoView.abZ = true;
        return true;
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b
    /* renamed from: b */
    public final void mo28891b(@NonNull AdResultData adResultData) {
        super.mo28891b((FeedVideoView) adResultData);
    }

    /* renamed from: a */
    public final void m28962a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, C8619c c8619c) {
        this.mApkDownloadHelper = c8619c;
        this.abZ = false;
        C10493b m25862br = C10483a.m25862br(this.mAdInfo);
        this.abW = ksAdVideoPlayConfig;
        String url = m25862br.getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.f29450eM.setImageDrawable(null);
            KSImageLoader.loadImage(this.f29450eM, url, this.mAdTemplate);
            this.f29450eM.setVisibility(0);
        } else {
            this.f29450eM.setVisibility(8);
        }
        this.f29447cB = C10483a.m25867bm(this.mAdInfo);
        String m25977K = C10483a.m25977K(this.mAdInfo);
        if (TextUtils.isEmpty(m25977K)) {
            return;
        }
        this.f29451eN = AdVideoPlayerViewCache.getInstance().m25522ew(m25977K);
        if (C10483a.m25919aq(this.mAdInfo)) {
            this.f29449eB.setVisibility(8);
            View view = this.abF;
            if (view != null) {
                view.setVisibility(0);
                this.abE.setText(C10483a.m25957aE(this.mAdInfo));
                this.abH.setText(C10483a.m25823cc(this.mAdInfo));
                KSImageLoader.loadAppIcon(this.abG, C10483a.m25820cf(this.mAdInfo), this.mAdTemplate, 4);
                C8619c c8619c2 = this.mApkDownloadHelper;
                if (c8619c2 != null) {
                    c8619c2.m30151b(getAppDownloadListener());
                }
                this.abE.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        if (FeedVideoView.this.f29446bU != null) {
                            FeedVideoView.this.f29446bU.onClick(view2);
                        }
                    }
                });
            }
        } else {
            View view2 = this.abF;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            this.f29449eB.setVisibility(0);
        }
        TextureView$SurfaceTextureListenerC10537a textureView$SurfaceTextureListenerC10537a = this.f29451eN;
        if (textureView$SurfaceTextureListenerC10537a == null) {
            this.f29451eN = new TextureView$SurfaceTextureListenerC10537a(getContext());
            C10483a.m25934ab(this.mAdInfo);
            this.f29451eN.m25515a(new C9878b.C9879a(this.mAdTemplate).m27475a(this.mAdTemplate.mVideoPlayerStatus).m27470cR(C10487e.m25639dS(this.mAdTemplate)).m27469cS(C10490h.m25611b(C10487e.m25640dR(this.mAdTemplate))).m27474b(new C9877a(this.mAdTemplate, System.currentTimeMillis())).m27477Bb(), null);
            C8993e c8993e = new C8993e(this.mContext, this.mAdTemplate, this.f29451eN, ksAdVideoPlayConfig);
            this.f29445Qi = c8993e;
            c8993e.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.f29451eN.setController(this.f29445Qi);
            this.f29445Qi.setAutoRelease(false);
            if (C10251d.m26566Bv() == 2) {
                AdVideoPlayerViewCache.getInstance().m25523a(m25977K, this.f29451eN);
            }
        } else {
            if (textureView$SurfaceTextureListenerC10537a.getTag() != null) {
                try {
                    this.f29447cB = (List) this.f29451eN.getTag();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            C8993e c8993e2 = (C8993e) this.f29451eN.getController();
            this.f29445Qi = c8993e2;
            c8993e2.setAutoRelease(false);
            this.f29445Qi.getAdTemplate().mAdWebVideoPageShowing = true;
        }
        this.f29451eN.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
        if (this.f29451eN.getParent() != null) {
            ((ViewGroup) this.f29451eN.getParent()).removeView(this.f29451eN);
            this.f29445Qi.m29430rI();
        }
        if (this.abB.getTag() != null) {
            RatioFrameLayout ratioFrameLayout = this.abB;
            ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
            this.abB.setTag(null);
        }
        this.abB.addView(this.f29451eN);
        this.abB.setTag(this.f29451eN);
        this.abM.setVisibility(8);
        this.abL.setVisibility(8);
        if (this.mAdInfo.adConversionInfo.h5Type == 1) {
            this.f29449eB.setVisibility(8);
        } else {
            this.f29449eB.setVisibility(0);
            this.f29449eB.setText(this.mAdInfo.adBaseInfo.adDescription);
        }
        m28966a(this.f29445Qi, this.f29451eN);
    }

    public FeedVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abR = 100;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.5
            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.abM.setVisibility(8);
                FeedVideoView.this.abL.setVisibility(8);
                if (FeedVideoView.this.f29445Qi != null) {
                    FeedVideoView.this.f29445Qi.m29505aO(true);
                }
            }
        };
        this.aca = runnable;
        this.acb = new RunnableC8957o(runnable);
    }

    public FeedVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.abR = 100;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.5
            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.abM.setVisibility(8);
                FeedVideoView.this.abL.setVisibility(8);
                if (FeedVideoView.this.f29445Qi != null) {
                    FeedVideoView.this.f29445Qi.m29505aO(true);
                }
            }
        };
        this.aca = runnable;
        this.acb = new RunnableC8957o(runnable);
    }

    /* renamed from: a */
    private void m28966a(View$OnClickListenerC8966a view$OnClickListenerC8966a, final TextureView$SurfaceTextureListenerC10537a textureView$SurfaceTextureListenerC10537a) {
        this.abP.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FeedVideoView.this.abM.getVisibility() == 8) {
                    if (!FeedVideoView.this.f29451eN.isCompleted()) {
                        FeedVideoView.this.abM.setVisibility(0);
                        FeedVideoView.this.abL.setVisibility(0);
                        if (FeedVideoView.this.f29445Qi != null) {
                            FeedVideoView.this.f29445Qi.m29505aO(false);
                        }
                        if (FeedVideoView.this.getHandler() != null) {
                            FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.aca);
                            FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.acb, 5000L);
                        }
                    } else if (FeedVideoView.this.abR == 101) {
                        FeedVideoView.this.abM.setVisibility(0);
                        FeedVideoView.this.abL.setVisibility(8);
                        if (FeedVideoView.this.f29445Qi != null) {
                            FeedVideoView.this.f29445Qi.m29505aO(false);
                        }
                        if (FeedVideoView.this.getHandler() != null) {
                            FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.aca);
                            FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.acb, 5000L);
                        }
                    } else if (FeedVideoView.this.f29446bU != null) {
                        FeedVideoView.this.f29446bU.onClick(view);
                    }
                } else if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.aca);
                    if (FeedVideoView.this.abV) {
                        return;
                    }
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.acb, 1000L);
                }
            }
        });
        view$OnClickListenerC8966a.setVideoPlayCallback(new View$OnClickListenerC8966a.InterfaceC8970c() { // from class: com.kwad.components.core.widget.FeedVideoView.7

            /* renamed from: cC */
            private boolean f29452cC = false;

            @Override // com.kwad.components.core.video.View$OnClickListenerC8966a.InterfaceC8970c
            /* renamed from: bl */
            public final void mo28935bl() {
                if (!FeedVideoView.this.abZ) {
                    FeedVideoView.m28963a(FeedVideoView.this, true);
                    if (C10483a.m25922an(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.f29451eN.setVideoSoundEnable(!C10483a.m25920ap(FeedVideoView.this.mAdInfo));
                    }
                    if (C10483a.m25922an(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.f29451eN.setLooping(C10483a.m25921ao(FeedVideoView.this.mAdInfo));
                    }
                }
                if (this.f29452cC) {
                    return;
                }
                this.f29452cC = true;
                C8766a.m29888qi().m29902b(FeedVideoView.this.mAdTemplate, System.currentTimeMillis(), 1);
            }

            @Override // com.kwad.components.core.video.View$OnClickListenerC8966a.InterfaceC8970c
            /* renamed from: bm */
            public final void mo28934bm() {
                C9908c.m27323bL(FeedVideoView.this.mAdTemplate);
                FeedVideoView.this.abM.setVisibility(8);
                FeedVideoView.this.abL.setVisibility(8);
                FeedVideoView.this.abI.setProgress(100);
                FeedVideoView.this.abD.setText(C11062bl.m23867ab(textureView$SurfaceTextureListenerC10537a.getDuration()));
            }

            @Override // com.kwad.components.core.video.View$OnClickListenerC8966a.InterfaceC8970c
            /* renamed from: e */
            public final void mo28933e(long j) {
                FeedVideoView.this.m28959c(j);
                float duration = (((float) j) * 100.0f) / ((float) textureView$SurfaceTextureListenerC10537a.getDuration());
                if (!FeedVideoView.this.abV) {
                    FeedVideoView.this.abI.setProgress((int) duration);
                    FeedVideoView.this.abD.setText(C11062bl.m23867ab(j));
                }
                FeedVideoView.this.abC.setText(C11062bl.m23867ab(textureView$SurfaceTextureListenerC10537a.getDuration()));
            }

            @Override // com.kwad.components.core.video.View$OnClickListenerC8966a.InterfaceC8970c
            public final void onVideoPlayStart() {
                if (!FeedVideoView.this.abZ) {
                    FeedVideoView.m28963a(FeedVideoView.this, true);
                    if (C10483a.m25922an(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.f29451eN.setVideoSoundEnable(true ^ C10483a.m25920ap(FeedVideoView.this.mAdInfo));
                    }
                    if (C10483a.m25922an(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.f29451eN.setLooping(C10483a.m25921ao(FeedVideoView.this.mAdInfo));
                    }
                }
                C9908c.m27324bK(FeedVideoView.this.mAdTemplate);
                FeedVideoView.this.abC.setText(C11062bl.m23867ab(textureView$SurfaceTextureListenerC10537a.getDuration()));
            }
        });
        this.f29445Qi.setAdClickListener(new View$OnClickListenerC8966a.InterfaceC8968a() { // from class: com.kwad.components.core.widget.FeedVideoView.8
            @Override // com.kwad.components.core.video.View$OnClickListenerC8966a.InterfaceC8968a
            /* renamed from: a */
            public final void mo28932a(int i, C11008ac.C11009a c11009a) {
                int i2 = 171;
                int i3 = 2;
                boolean z = false;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (C10483a.m25922an(FeedVideoView.this.mAdInfo) == 0) {
                                i2 = 108;
                            }
                        } else {
                            i2 = C10483a.m25922an(FeedVideoView.this.mAdInfo) != 0 ? 50 : 83;
                            i3 = 1;
                            z = true;
                        }
                    } else if (C10483a.m25922an(FeedVideoView.this.mAdInfo) == 0) {
                        i2 = 82;
                    }
                } else if (C10483a.m25922an(FeedVideoView.this.mAdInfo) == 0) {
                    i2 = 13;
                }
                C8615a.m30233a(new C8615a.C8616a(FeedVideoView.this.getContext()).m30198aq(FeedVideoView.this.mAdTemplate).m30193at(true).m30189b(FeedVideoView.this.mApkDownloadHelper).m30205an(i3).m30202ao(z).m30197aq(true).m30207am(i2).m30185d(c11009a).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.core.widget.FeedVideoView.8.1
                    @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
                    public final void onAdClicked() {
                        FeedVideoView.this.m28885tj();
                    }
                }));
            }
        });
        this.abI.setOnSeekBarChangeListener(new ScaleAnimSeekBar.InterfaceC10590a() { // from class: com.kwad.components.core.widget.FeedVideoView.9
            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.InterfaceC10590a
            /* renamed from: a */
            public final void mo25362a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z) {
                if (z) {
                    FeedVideoView.this.abI.m25377bo(true);
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.acb);
                    FeedVideoView.this.abV = true;
                    FeedVideoView.this.abD.setText(C11062bl.m23867ab((int) ((textureView$SurfaceTextureListenerC10537a.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress())));
                }
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.InterfaceC10590a
            /* renamed from: tr */
            public final void mo25361tr() {
                FeedVideoView.this.abI.m25377bo(true);
                FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.acb);
                FeedVideoView.this.abV = true;
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.InterfaceC10590a
            /* renamed from: a */
            public final void mo25363a(ScaleAnimSeekBar scaleAnimSeekBar) {
                FeedVideoView.this.abI.m25377bo(false);
                textureView$SurfaceTextureListenerC10537a.seekTo((int) ((textureView$SurfaceTextureListenerC10537a.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress()));
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.acb);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.acb, 5000L);
                }
                FeedVideoView.this.abV = false;
            }
        });
        this.abJ.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (!textureView$SurfaceTextureListenerC10537a.isPaused() && !textureView$SurfaceTextureListenerC10537a.isIdle()) {
                    if (textureView$SurfaceTextureListenerC10537a.isPlaying()) {
                        FeedVideoView.this.f29445Qi.m29428rK();
                        FeedVideoView.this.abL.setVisibility(0);
                        FeedVideoView.this.abL.setImageDrawable(FeedVideoView.this.getContext().getResources().getDrawable(C9659R.C9661drawable.ksad_video_play_176));
                        FeedVideoView.this.abJ.setImageDrawable(FeedVideoView.this.getContext().getResources().getDrawable(C9659R.C9661drawable.ksad_video_player_play_btn));
                    }
                } else {
                    FeedVideoView.this.f29445Qi.m29427rL();
                    FeedVideoView.this.abJ.setImageDrawable(FeedVideoView.this.getResources().getDrawable(C9659R.C9661drawable.ksad_video_player_pause_btn));
                    FeedVideoView.this.abL.setImageDrawable(FeedVideoView.this.getResources().getDrawable(C9659R.C9661drawable.ksad_video_player_pause_center));
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.acb);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.acb, 5000L);
                }
            }
        });
        this.abL.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (!FeedVideoView.this.f29451eN.isPaused() && !FeedVideoView.this.f29451eN.isIdle()) {
                    if (FeedVideoView.this.f29451eN.isPlaying()) {
                        FeedVideoView.this.m28940rp();
                    }
                } else {
                    FeedVideoView.this.m28942qa();
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.acb);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.acb, 5000L);
                }
            }
        });
        this.abN.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedVideoView.this.m28937tp();
            }
        });
        this.abK.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FeedVideoView.this.abR == 100) {
                    FeedVideoView.this.m28938to();
                } else if (FeedVideoView.this.abR == 101) {
                    FeedVideoView.this.m28937tp();
                }
            }
        });
    }
}

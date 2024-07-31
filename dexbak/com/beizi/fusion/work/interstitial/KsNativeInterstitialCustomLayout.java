package com.beizi.fusion.work.interstitial;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.beizi.fusion.C3025R;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p072g.BeiZiImageUtils;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3138av;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import java.util.ArrayList;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class KsNativeInterstitialCustomLayout extends FrameLayout {

    /* renamed from: a */
    Context f12173a;

    /* renamed from: b */
    private ArrayList<View> f12174b;

    /* renamed from: c */
    private InterfaceC3359a f12175c;

    /* renamed from: com.beizi.fusion.work.interstitial.KsNativeInterstitialCustomLayout$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3359a {
        /* renamed from: b */
        void mo47048b();

        /* renamed from: b_ */
        void mo47042b_();
    }

    public KsNativeInterstitialCustomLayout(@NonNull Context context) {
        this(context, null);
    }

    public boolean onBindData(KsNativeAd ksNativeAd, float f, float f2, AdSpacesBean.RenderViewBean renderViewBean, KsNativeAd.AdInteractionListener adInteractionListener, KsNativeAd.VideoPlayListener videoPlayListener, View.OnClickListener onClickListener) {
        if (ksNativeAd == null) {
            setVisibility(8);
            return false;
        }
        int m48304a = C3138av.m48304a(getContext(), f);
        int m48304a2 = f2 > 0.0f ? C3138av.m48304a(getContext(), f2) : -2;
        FrameLayout frameLayout = (FrameLayout) findViewById(C3025R.C3028id.beizi_media_view);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(C3025R.C3028id.beizi_ad_cover_image_container);
        int materialType = ksNativeAd.getMaterialType();
        if (materialType == 1) {
            int videoWidth = ksNativeAd.getVideoWidth();
            int videoHeight = ksNativeAd.getVideoHeight();
            C3116af.m48494c("BeiZis", "interstitial videoWidth = " + videoWidth + ",videoHeight = " + videoHeight);
            if (videoWidth != 0 && videoHeight != 0) {
                m48304a2 = Math.round((videoHeight / videoWidth) * m48304a);
            }
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(m48304a, m48304a2));
            frameLayout2.setVisibility(8);
            frameLayout.setVisibility(0);
            ksNativeAd.setVideoPlayListener(videoPlayListener);
            View videoView = ksNativeAd.getVideoView(getContext(), new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).dataFlowAutoStart(false).build());
            if (videoView != null && videoView.getParent() == null) {
                frameLayout.removeAllViews();
                frameLayout.addView(videoView);
            }
        } else if (materialType != 2 && materialType != 3) {
            return false;
        } else {
            if (ksNativeAd.getImageList() != null && !ksNativeAd.getImageList().isEmpty()) {
                C3116af.m48494c("BeiZis", "interstitial imageList size = " + ksNativeAd.getImageList().size());
                KsImage ksImage = ksNativeAd.getImageList().get(0);
                if (ksImage != null && ksImage.isValid()) {
                    int width = ksImage.getWidth();
                    int height = ksImage.getHeight();
                    C3116af.m48494c("BeiZis", "interstitial imageWidth = " + width + ",imageHeight = " + height);
                    if (width != 0 && height != 0) {
                        float f3 = height / width;
                        if (f3 >= 0.375f && f3 <= 2.667f) {
                            m48304a2 = Math.round(f3 * m48304a);
                        } else {
                            C3116af.m48494c("BeiZis", "interstitial aspectRatio = " + f3 + " not proper , return fail ! ");
                            return false;
                        }
                    }
                    frameLayout2.setVisibility(0);
                    frameLayout.setVisibility(8);
                    ImageView imageView = new ImageView(getContext());
                    BeiZiImageUtils.m48258a(getContext()).m48256a(ksImage.getImageUrl()).m48246a(imageView);
                    frameLayout2.addView(imageView, new FrameLayout.LayoutParams(m48304a, m48304a2));
                }
            }
        }
        C3116af.m48494c("BeiZis", "interstitial adWidth = " + m48304a + ",adHeight = " + m48304a2);
        ((FrameLayout) findViewById(C3025R.C3028id.beizi_root_container)).setLayoutParams(new FrameLayout.LayoutParams(m48304a, m48304a2));
        ImageView imageView2 = (ImageView) findViewById(C3025R.C3028id.beizi_close);
        imageView2.setOnClickListener(onClickListener);
        m47225a(imageView2, renderViewBean, m48304a, m48304a2);
        this.f12174b.add(frameLayout2);
        C3116af.m48494c("BeiZis", "interstitial mContext instanceof Activity ? " + (this.f12173a instanceof Activity));
        Context context = this.f12173a;
        if (context instanceof Activity) {
            ksNativeAd.registerViewForInteraction((Activity) context, this, this.f12174b, adInteractionListener);
        }
        return true;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        InterfaceC3359a interfaceC3359a;
        C3116af.m48494c("BeiZis", "interstitial visibility = " + i);
        if (i == 0 && (interfaceC3359a = this.f12175c) != null) {
            interfaceC3359a.mo47042b_();
        }
        super.onWindowVisibilityChanged(i);
    }

    public void setViewInteractionListener(InterfaceC3359a interfaceC3359a) {
        this.f12175c = interfaceC3359a;
    }

    public KsNativeInterstitialCustomLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: a */
    private void m47226a() {
        Context context = getContext();
        this.f12173a = context;
        LayoutInflater.from(context).inflate(C3025R.C3029layout.ks_native_interstitial_custom_view, this);
        this.f12174b = new ArrayList<>();
    }

    public KsNativeInterstitialCustomLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m47226a();
    }

    /* renamed from: a */
    private void m47225a(View view, AdSpacesBean.RenderViewBean renderViewBean, int i, int i2) {
        int m48304a;
        if (renderViewBean == null) {
            return;
        }
        int[] m47224a = m47224a(renderViewBean, i, i2);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.work.interstitial.KsNativeInterstitialCustomLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                KsNativeInterstitialCustomLayout.this.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.interstitial.KsNativeInterstitialCustomLayout.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (KsNativeInterstitialCustomLayout.this.f12175c != null) {
                            KsNativeInterstitialCustomLayout.this.f12175c.mo47048b();
                        }
                    }
                }, 500L);
            }
        });
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            String location = renderViewBean.getLocation();
            location.hashCode();
            char c = 65535;
            switch (location.hashCode()) {
                case -1568638786:
                    if (location.equals("rightdown")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1106589470:
                    if (location.equals("leftup")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1200601527:
                    if (location.equals("rightup")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1718905129:
                    if (location.equals("leftdown")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    layoutParams2.gravity = 85;
                    layoutParams2.rightMargin = m47224a[0];
                    layoutParams2.bottomMargin = m47224a[1];
                    break;
                case 1:
                    layoutParams2.gravity = 51;
                    layoutParams2.leftMargin = m47224a[0];
                    layoutParams2.topMargin = m47224a[1];
                    break;
                case 2:
                    layoutParams2.gravity = 53;
                    layoutParams2.rightMargin = m47224a[0];
                    layoutParams2.topMargin = m47224a[1];
                    break;
                case 3:
                    layoutParams2.gravity = 83;
                    layoutParams2.leftMargin = m47224a[0];
                    layoutParams2.bottomMargin = m47224a[1];
                    break;
            }
            String size = renderViewBean.getSize();
            if (size != null) {
                if (size.endsWith("%")) {
                    m48304a = (i * Integer.parseInt(size.substring(0, size.indexOf("%")))) / 100;
                } else {
                    m48304a = C3138av.m48304a(getContext(), Integer.parseInt(size));
                }
                layoutParams2.width = m48304a;
                layoutParams2.height = m48304a;
            }
            C3116af.m48494c("BeiZis", "interstitial params = " + layoutParams2);
        }
    }

    /* renamed from: a */
    private int[] m47224a(AdSpacesBean.RenderViewBean renderViewBean, int i, int i2) {
        String borderWidth = renderViewBean.getBorderWidth();
        String borderHeight = renderViewBean.getBorderHeight();
        int[] iArr = new int[2];
        if (borderWidth.endsWith("%")) {
            iArr[0] = (i * Integer.parseInt(borderWidth.substring(0, borderWidth.indexOf("%")))) / 100;
        } else {
            iArr[0] = C3138av.m48304a(getContext(), Integer.parseInt(borderWidth));
        }
        if (borderHeight.endsWith("%")) {
            iArr[1] = (i2 * Integer.parseInt(borderHeight.substring(0, borderHeight.indexOf("%")))) / 100;
        } else {
            iArr[1] = C3138av.m48304a(getContext(), Integer.parseInt(borderHeight));
        }
        return iArr;
    }
}

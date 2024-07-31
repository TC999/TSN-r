package com.beizi.fusion.work.interstitial;

import android.content.Context;
import android.text.TextUtils;
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
import com.p518qq.p519e.ads.cfg.VideoOption;
import com.p518qq.p519e.ads.nativ.MediaView;
import com.p518qq.p519e.ads.nativ.NativeADEventListener;
import com.p518qq.p519e.ads.nativ.NativeADMediaListener;
import com.p518qq.p519e.ads.nativ.NativeUnifiedADData;
import com.p518qq.p519e.ads.nativ.widget.NativeAdContainer;
import java.util.ArrayList;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GdtNativeInterstitialCustomLayout extends FrameLayout {

    /* renamed from: a */
    private ArrayList<View> f12169a;

    /* renamed from: b */
    private InterfaceC3356a f12170b;

    /* renamed from: com.beizi.fusion.work.interstitial.GdtNativeInterstitialCustomLayout$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3356a {
        /* renamed from: a_ */
        void mo47100a_();

        /* renamed from: b */
        void mo47099b();
    }

    public GdtNativeInterstitialCustomLayout(@NonNull Context context) {
        this(context, null);
    }

    public boolean onBindData(NativeUnifiedADData nativeUnifiedADData, float f, float f2, AdSpacesBean.RenderViewBean renderViewBean, NativeADEventListener nativeADEventListener, NativeADMediaListener nativeADMediaListener, View.OnClickListener onClickListener) {
        if (nativeUnifiedADData == null) {
            setVisibility(8);
            return false;
        }
        int m48304a = C3138av.m48304a(getContext(), f);
        int m48304a2 = f2 > 0.0f ? C3138av.m48304a(getContext(), f2) : -2;
        C3116af.m48494c("BeiZis", "interstitial getPictureWidth = " + nativeUnifiedADData.getPictureWidth() + ",getPictureHeight = " + nativeUnifiedADData.getPictureHeight());
        int pictureWidth = nativeUnifiedADData.getPictureWidth();
        int pictureHeight = nativeUnifiedADData.getPictureHeight();
        if (pictureWidth != 0 && pictureHeight != 0) {
            float f3 = pictureHeight / pictureWidth;
            if (f3 >= 0.375f && f3 <= 2.667f) {
                m48304a2 = Math.round(f3 * m48304a);
            } else {
                C3116af.m48494c("BeiZis", "interstitial aspectRatio = " + f3 + " not proper , return fail ! ");
                return false;
            }
        }
        C3116af.m48494c("BeiZis", "interstitial adWidth = " + m48304a + ",adHeight = " + m48304a2);
        NativeAdContainer nativeAdContainer = (NativeAdContainer) findViewById(C3025R.C3028id.beizi_root_container);
        nativeAdContainer.setLayoutParams(new FrameLayout.LayoutParams(m48304a, m48304a2));
        C3116af.m48494c("BeiZis", "interstitial imageWidth = " + pictureWidth + ",imageHeight = " + pictureHeight);
        FrameLayout frameLayout = (FrameLayout) findViewById(C3025R.C3028id.beizi_ad_cover_image_container);
        ImageView imageView = new ImageView(getContext());
        String imgUrl = nativeUnifiedADData.getImgUrl();
        if (!TextUtils.isEmpty(imgUrl)) {
            BeiZiImageUtils.m48258a(getContext()).m48256a(imgUrl).m48246a(imageView);
        }
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(m48304a, m48304a2));
        ImageView imageView2 = (ImageView) findViewById(C3025R.C3028id.beizi_close);
        imageView2.setOnClickListener(onClickListener);
        m47229a(imageView2, renderViewBean, m48304a, m48304a2);
        this.f12169a.add(frameLayout);
        nativeUnifiedADData.bindAdToView(getContext(), nativeAdContainer, null, this.f12169a);
        if (nativeUnifiedADData.getAdPatternType() == 2) {
            MediaView mediaView = (MediaView) findViewById(C3025R.C3028id.beizi_media_view);
            mediaView.setLayoutParams(new FrameLayout.LayoutParams(m48304a, m48304a2));
            VideoOption.Builder builder = new VideoOption.Builder();
            builder.setAutoPlayPolicy(1);
            builder.setAutoPlayMuted(true);
            builder.setDetailPageMuted(true);
            builder.setNeedCoverImage(true);
            builder.setNeedProgressBar(true);
            builder.setEnableDetailPage(true);
            builder.setEnableUserControl(false);
            nativeUnifiedADData.bindMediaView(mediaView, builder.build(), nativeADMediaListener);
            frameLayout.setVisibility(8);
            mediaView.setVisibility(0);
        }
        nativeUnifiedADData.setNativeAdEventListener(nativeADEventListener);
        return true;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        InterfaceC3356a interfaceC3356a;
        C3116af.m48494c("BeiZis", "interstitial visibility = " + i);
        if (i == 0 && (interfaceC3356a = this.f12170b) != null) {
            interfaceC3356a.mo47100a_();
        }
        super.onWindowVisibilityChanged(i);
    }

    public void setViewInteractionListener(InterfaceC3356a interfaceC3356a) {
        this.f12170b = interfaceC3356a;
    }

    public GdtNativeInterstitialCustomLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: a */
    private void m47230a() {
        LayoutInflater.from(getContext()).inflate(C3025R.C3029layout.gdt_native_interstitial_custom_view, this);
        this.f12169a = new ArrayList<>();
    }

    public GdtNativeInterstitialCustomLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m47230a();
    }

    /* renamed from: a */
    private void m47229a(View view, AdSpacesBean.RenderViewBean renderViewBean, int i, int i2) {
        int m48304a;
        if (renderViewBean == null) {
            return;
        }
        int[] m47228a = m47228a(renderViewBean, i, i2);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.work.interstitial.GdtNativeInterstitialCustomLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                GdtNativeInterstitialCustomLayout.this.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.interstitial.GdtNativeInterstitialCustomLayout.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (GdtNativeInterstitialCustomLayout.this.f12170b != null) {
                            GdtNativeInterstitialCustomLayout.this.f12170b.mo47099b();
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
                    layoutParams2.rightMargin = m47228a[0];
                    layoutParams2.bottomMargin = m47228a[1];
                    break;
                case 1:
                    layoutParams2.gravity = 51;
                    layoutParams2.leftMargin = m47228a[0];
                    layoutParams2.topMargin = m47228a[1];
                    break;
                case 2:
                    layoutParams2.gravity = 53;
                    layoutParams2.rightMargin = m47228a[0];
                    layoutParams2.topMargin = m47228a[1];
                    break;
                case 3:
                    layoutParams2.gravity = 83;
                    layoutParams2.leftMargin = m47228a[0];
                    layoutParams2.bottomMargin = m47228a[1];
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
    private int[] m47228a(AdSpacesBean.RenderViewBean renderViewBean, int i, int i2) {
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

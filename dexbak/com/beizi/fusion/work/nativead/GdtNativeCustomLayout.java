package com.beizi.fusion.work.nativead;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.beizi.fusion.C3025R;
import com.beizi.fusion.p072g.BeiZiImageUtils;
import com.beizi.fusion.p072g.C3138av;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import com.p518qq.p519e.ads.cfg.VideoOption;
import com.p518qq.p519e.ads.nativ.MediaView;
import com.p518qq.p519e.ads.nativ.NativeADEventListener;
import com.p518qq.p519e.ads.nativ.NativeADMediaListener;
import com.p518qq.p519e.ads.nativ.NativeUnifiedADData;
import com.p518qq.p519e.ads.nativ.widget.NativeAdContainer;
import java.util.ArrayList;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GdtNativeCustomLayout extends FrameLayout {

    /* renamed from: a */
    private ArrayList<View> f12266a;

    public GdtNativeCustomLayout(@NonNull Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private void m47018a() {
        LayoutInflater.from(getContext()).inflate(C3025R.C3029layout.beizi_native_custom_view, this);
        this.f12266a = new ArrayList<>();
    }

    public void onBindData(NativeUnifiedADData nativeUnifiedADData, float f, float f2, NativeADEventListener nativeADEventListener, NativeADMediaListener nativeADMediaListener, View.OnClickListener onClickListener) {
        if (nativeUnifiedADData == null) {
            setVisibility(8);
            return;
        }
        int m48304a = C3138av.m48304a(getContext(), f);
        int m48304a2 = f2 > 0.0f ? C3138av.m48304a(getContext(), f2) : -2;
        NativeAdContainer nativeAdContainer = (NativeAdContainer) findViewById(C3025R.C3028id.beizi_root_container);
        nativeAdContainer.setLayoutParams(new FrameLayout.LayoutParams(m48304a, m48304a2));
        int pictureWidth = ((nativeUnifiedADData.getPictureWidth() != 0 ? nativeUnifiedADData.getPictureWidth() : PredefinedCaptureConfigurations.f24405o) * m48304a2) / (nativeUnifiedADData.getPictureHeight() != 0 ? nativeUnifiedADData.getPictureHeight() : PredefinedCaptureConfigurations.f24404n);
        FrameLayout frameLayout = (FrameLayout) findViewById(C3025R.C3028id.beizi_ad_cover_image_container);
        ImageView imageView = new ImageView(getContext());
        String imgUrl = nativeUnifiedADData.getImgUrl();
        if (!TextUtils.isEmpty(imgUrl)) {
            BeiZiImageUtils.m48258a(getContext()).m48256a(imgUrl).m48246a(imageView);
        }
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(pictureWidth, m48304a2));
        LinearLayout linearLayout = (LinearLayout) findViewById(C3025R.C3028id.beizi_right_view);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        int i = m48304a - pictureWidth;
        layoutParams.width = i;
        layoutParams.height = m48304a2;
        linearLayout.setLayoutParams(layoutParams);
        ImageView imageView2 = (ImageView) findViewById(C3025R.C3028id.beizi_ad_logo);
        String iconUrl = nativeUnifiedADData.getIconUrl();
        if (!TextUtils.isEmpty(iconUrl)) {
            BeiZiImageUtils.m48258a(getContext()).m48256a(iconUrl).m48246a(imageView2);
        }
        TextView textView = (TextView) findViewById(C3025R.C3028id.beizi_ad_action);
        ((ImageView) findViewById(C3025R.C3028id.beizi_close)).setOnClickListener(onClickListener);
        this.f12266a.add(frameLayout);
        this.f12266a.add(linearLayout);
        this.f12266a.add(imageView2);
        this.f12266a.add(textView);
        nativeUnifiedADData.bindAdToView(getContext(), nativeAdContainer, null, this.f12266a);
        if (nativeUnifiedADData.getAdPatternType() == 2) {
            MediaView mediaView = (MediaView) findViewById(C3025R.C3028id.beizi_media_view);
            mediaView.setLayoutParams(new FrameLayout.LayoutParams(pictureWidth, m48304a2));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams2.width = i;
            layoutParams2.height = m48304a2;
            linearLayout.setLayoutParams(layoutParams2);
            VideoOption.Builder builder = new VideoOption.Builder();
            builder.setAutoPlayPolicy(1);
            builder.setAutoPlayMuted(true);
            builder.setDetailPageMuted(false);
            builder.setNeedCoverImage(true);
            builder.setNeedProgressBar(true);
            builder.setEnableDetailPage(true);
            builder.setEnableUserControl(false);
            nativeUnifiedADData.bindMediaView(mediaView, builder.build(), nativeADMediaListener);
            frameLayout.setVisibility(8);
            mediaView.setVisibility(0);
        }
        nativeUnifiedADData.setNativeAdEventListener(nativeADEventListener);
        m47017a(textView, nativeUnifiedADData);
    }

    public GdtNativeCustomLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GdtNativeCustomLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m47018a();
    }

    /* renamed from: a */
    private void m47017a(TextView textView, NativeUnifiedADData nativeUnifiedADData) {
        if (nativeUnifiedADData == null) {
            textView.setText("浏览");
        } else if (!nativeUnifiedADData.isAppAd()) {
            textView.setText("浏览");
        } else {
            int appStatus = nativeUnifiedADData.getAppStatus();
            if (appStatus == 0) {
                textView.setText("下载");
            } else if (appStatus == 1) {
                textView.setText("启动");
            } else if (appStatus == 2) {
                textView.setText("更新");
            } else if (appStatus == 4) {
                textView.setText(nativeUnifiedADData.getProgress() + "%");
            } else if (appStatus == 8) {
                textView.setText("安装");
            } else if (appStatus != 16) {
                textView.setText("浏览");
            } else {
                textView.setText("下载失败，重新下载");
            }
        }
    }
}

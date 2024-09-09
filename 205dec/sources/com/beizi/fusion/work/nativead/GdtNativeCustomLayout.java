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
import com.beizi.fusion.R;
import com.beizi.fusion.g.av;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class GdtNativeCustomLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<View> f15774a;

    public GdtNativeCustomLayout(@NonNull Context context) {
        this(context, null);
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.beizi_native_custom_view, this);
        this.f15774a = new ArrayList<>();
    }

    public void onBindData(NativeUnifiedADData nativeUnifiedADData, float f4, float f5, NativeADEventListener nativeADEventListener, NativeADMediaListener nativeADMediaListener, View.OnClickListener onClickListener) {
        if (nativeUnifiedADData == null) {
            setVisibility(8);
            return;
        }
        int a4 = av.a(getContext(), f4);
        int a5 = f5 > 0.0f ? av.a(getContext(), f5) : -2;
        NativeAdContainer nativeAdContainer = (NativeAdContainer) findViewById(R.id.beizi_root_container);
        nativeAdContainer.setLayoutParams(new FrameLayout.LayoutParams(a4, a5));
        int pictureWidth = ((nativeUnifiedADData.getPictureWidth() != 0 ? nativeUnifiedADData.getPictureWidth() : 1280) * a5) / (nativeUnifiedADData.getPictureHeight() != 0 ? nativeUnifiedADData.getPictureHeight() : 720);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.beizi_ad_cover_image_container);
        ImageView imageView = new ImageView(getContext());
        String imgUrl = nativeUnifiedADData.getImgUrl();
        if (!TextUtils.isEmpty(imgUrl)) {
            com.beizi.fusion.g.i.a(getContext()).a(imgUrl).a(imageView);
        }
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(pictureWidth, a5));
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.beizi_right_view);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        int i4 = a4 - pictureWidth;
        layoutParams.width = i4;
        layoutParams.height = a5;
        linearLayout.setLayoutParams(layoutParams);
        ImageView imageView2 = (ImageView) findViewById(R.id.beizi_ad_logo);
        String iconUrl = nativeUnifiedADData.getIconUrl();
        if (!TextUtils.isEmpty(iconUrl)) {
            com.beizi.fusion.g.i.a(getContext()).a(iconUrl).a(imageView2);
        }
        TextView textView = (TextView) findViewById(R.id.beizi_ad_action);
        ((ImageView) findViewById(R.id.beizi_close)).setOnClickListener(onClickListener);
        this.f15774a.add(frameLayout);
        this.f15774a.add(linearLayout);
        this.f15774a.add(imageView2);
        this.f15774a.add(textView);
        nativeUnifiedADData.bindAdToView(getContext(), nativeAdContainer, null, this.f15774a);
        if (nativeUnifiedADData.getAdPatternType() == 2) {
            MediaView mediaView = (MediaView) findViewById(R.id.beizi_media_view);
            mediaView.setLayoutParams(new FrameLayout.LayoutParams(pictureWidth, a5));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams2.width = i4;
            layoutParams2.height = a5;
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
        a(textView, nativeUnifiedADData);
    }

    public GdtNativeCustomLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GdtNativeCustomLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        a();
    }

    private void a(TextView textView, NativeUnifiedADData nativeUnifiedADData) {
        if (nativeUnifiedADData == null) {
            textView.setText("\u6d4f\u89c8");
        } else if (!nativeUnifiedADData.isAppAd()) {
            textView.setText("\u6d4f\u89c8");
        } else {
            int appStatus = nativeUnifiedADData.getAppStatus();
            if (appStatus == 0) {
                textView.setText("\u4e0b\u8f7d");
            } else if (appStatus == 1) {
                textView.setText("\u542f\u52a8");
            } else if (appStatus == 2) {
                textView.setText("\u66f4\u65b0");
            } else if (appStatus == 4) {
                textView.setText(nativeUnifiedADData.getProgress() + "%");
            } else if (appStatus == 8) {
                textView.setText("\u5b89\u88c5");
            } else if (appStatus != 16) {
                textView.setText("\u6d4f\u89c8");
            } else {
                textView.setText("\u4e0b\u8f7d\u5931\u8d25\uff0c\u91cd\u65b0\u4e0b\u8f7d");
            }
        }
    }
}

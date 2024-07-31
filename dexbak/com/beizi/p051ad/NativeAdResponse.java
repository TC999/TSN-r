package com.beizi.p051ad;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.beizi.p051ad.internal.nativead.NativeAdEventListener;
import com.beizi.p051ad.internal.nativead.NativeAdShownListener;
import com.beizi.p051ad.internal.network.ServerResponse;
import com.beizi.p051ad.lance.ApkBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.beizi.ad.NativeAdResponse */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface NativeAdResponse {

    /* renamed from: com.beizi.ad.NativeAdResponse$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC2748a {
        BeiZi,
        BAIDU,
        AFP,
        GDT
    }

    /* renamed from: com.beizi.ad.NativeAdResponse$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC2749b {
        CONTENT,
        APP_INSTALL
    }

    void destroy();

    ServerResponse.AdLogoInfo getAdUrl();

    String getAdvertiser();

    ApkBean getApkInfo();

    String getBody();

    String getCallToAction();

    ArrayList<String> getClickTrackers();

    String getHeadline();

    Bitmap getIcon();

    String getIconUrl();

    Bitmap getImage();

    String getImageUrl();

    ArrayList<String> getImageUrls();

    ArrayList<String> getImpTrackers();

    String getLandingPageUrl();

    EnumC2749b getNativeAdType();

    HashMap<String, Object> getNativeElements();

    List<? extends View> getNativeInfoListView();

    EnumC2748a getNetworkIdentifier();

    String getPrice();

    double getStarRating();

    String getStore();

    ArrayList<String> getTexts();

    ArrayList<String> getVedioUrls();

    ServerResponse.AdLogoInfo getlogoUrl();

    void handleClick(Context context);

    void handleClick(Context context, View view, String str, String str2, String str3, String str4, int i);

    boolean hasExpired();

    void regesterClickListener(View view, NativeAdEventListener nativeAdEventListener);

    boolean regesterShow(View view);

    boolean regesterShow(View view, NativeAdShownListener nativeAdShownListener);

    boolean registerView(View view, NativeAdEventListener nativeAdEventListener);

    boolean registerViewList(View view, List<View> list, NativeAdEventListener nativeAdEventListener);

    void sendClickLog();

    void sendImpLog();

    void setIcon(Bitmap bitmap);

    void setImage(Bitmap bitmap);

    void setNativeInfoListView(List<? extends View> list);

    void unregisterViews();
}

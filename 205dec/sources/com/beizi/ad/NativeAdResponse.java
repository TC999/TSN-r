package com.beizi.ad;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.beizi.ad.internal.nativead.NativeAdEventListener;
import com.beizi.ad.internal.nativead.NativeAdShownListener;
import com.beizi.ad.internal.network.ServerResponse;
import com.beizi.ad.lance.ApkBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface NativeAdResponse {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum a {
        BeiZi,
        BAIDU,
        AFP,
        GDT
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum b {
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

    b getNativeAdType();

    HashMap<String, Object> getNativeElements();

    List<? extends View> getNativeInfoListView();

    a getNetworkIdentifier();

    String getPrice();

    double getStarRating();

    String getStore();

    ArrayList<String> getTexts();

    ArrayList<String> getVedioUrls();

    ServerResponse.AdLogoInfo getlogoUrl();

    void handleClick(Context context);

    void handleClick(Context context, View view, String str, String str2, String str3, String str4, int i4);

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

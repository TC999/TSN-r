package com.qq.e.comm.plugin.dysi;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public interface IGDTSDK {
    void bindData(String str);

    void cancelAnimation(String str);

    void clickAdContinued(String str);

    void cod(String str);

    int findViewByTag(String str);

    int getSettingInt(String str);

    String getSettingString(String str);

    void interactionContinued(String str);

    void loadAd(String str, String str2);

    void log(String str);

    void observeDLEngine(String str);

    void rco(String str);

    void setReducedTime(int i4);

    void setTimeout(String str, int i4);

    void showAnimation(String str);

    void showAnimationFraction(String str, double d4);

    void tar(int i4);

    void track(String str);

    void vibrateMobilePhone(String str);
}

package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;

/* renamed from: com.baidu.mobads.sdk.internal.j */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public enum EnumC2713j {
    NEWS("news", 0),
    IMAGE(SocializeProtocolConstants.IMAGE, 1),
    VIDEO("video", 2),
    TOPIC("topic", 3),
    AD(UMCommonContent.f37822az, 4),
    HOTDOC("hotkey", 5),
    SMALLVIDEO("smallvideo", 6),
    RECALLNEWS("recallNews", 8),
    POLICETASK("policetask", 9);
    

    /* renamed from: j */
    String f9093j;

    /* renamed from: k */
    int f9094k;

    EnumC2713j(String str, int i) {
        this.f9093j = str;
        this.f9094k = i;
    }

    /* renamed from: b */
    public String m50371b() {
        return this.f9093j;
    }

    /* renamed from: c */
    public int m50369c() {
        return this.f9094k;
    }

    /* renamed from: b */
    public static EnumC2713j m50370b(String str) {
        EnumC2713j[] values;
        for (EnumC2713j enumC2713j : values()) {
            if (enumC2713j != null && TextUtils.isEmpty(enumC2713j.f9093j) && enumC2713j.f9093j.equals(str)) {
                return enumC2713j;
            }
        }
        return null;
    }
}

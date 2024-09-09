package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public enum j {
    NEWS("news", 0),
    IMAGE("image", 1),
    VIDEO("video", 2),
    TOPIC("topic", 3),
    AD("ad", 4),
    HOTDOC("hotkey", 5),
    SMALLVIDEO("smallvideo", 6),
    RECALLNEWS("recallNews", 8),
    POLICETASK("policetask", 9);
    

    /* renamed from: j  reason: collision with root package name */
    String f12879j;

    /* renamed from: k  reason: collision with root package name */
    int f12880k;

    j(String str, int i4) {
        this.f12879j = str;
        this.f12880k = i4;
    }

    public String b() {
        return this.f12879j;
    }

    public int c() {
        return this.f12880k;
    }

    public static j b(String str) {
        j[] values;
        for (j jVar : values()) {
            if (jVar != null && TextUtils.isEmpty(jVar.f12879j) && jVar.f12879j.equals(str)) {
                return jVar;
            }
        }
        return null;
    }
}

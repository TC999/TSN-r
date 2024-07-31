package com.mbridge.msdk.mbjscommon.windvane;

import com.baidu.mobads.sdk.internal.C2573a;

/* renamed from: com.mbridge.msdk.mbjscommon.windvane.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public enum MimeTypeEnum {
    JS("js", "application/x-javascript"),
    CSS("css", "text/css"),
    JPG("jpg", "image/jpeg"),
    JPEG("jpep", "image/jpeg"),
    PNG("png", "image/png"),
    WEBP("webp", "image/webp"),
    GIF("gif", "image/gif"),
    HTM("htm", "text/html"),
    HTML(C2573a.f8447f, "text/html");
    

    /* renamed from: j */
    private String f31572j;

    /* renamed from: k */
    private String f31573k;

    MimeTypeEnum(String str, String str2) {
        this.f31572j = str;
        this.f31573k = str2;
    }

    /* renamed from: a */
    public final String m21394a() {
        return this.f31572j;
    }

    /* renamed from: b */
    public final String m21393b() {
        return this.f31573k;
    }
}

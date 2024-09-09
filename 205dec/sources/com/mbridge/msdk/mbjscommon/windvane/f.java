package com.mbridge.msdk.mbjscommon.windvane;

/* compiled from: MimeTypeEnum.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public enum f {
    JS("js", "application/x-javascript"),
    CSS("css", "text/css"),
    JPG("jpg", "image/jpeg"),
    JPEG("jpep", "image/jpeg"),
    PNG("png", "image/png"),
    WEBP("webp", "image/webp"),
    GIF("gif", "image/gif"),
    HTM("htm", "text/html"),
    HTML("html", "text/html");
    

    /* renamed from: j  reason: collision with root package name */
    private String f40344j;

    /* renamed from: k  reason: collision with root package name */
    private String f40345k;

    f(String str, String str2) {
        this.f40344j = str;
        this.f40345k = str2;
    }

    public final String a() {
        return this.f40344j;
    }

    public final String b() {
        return this.f40345k;
    }
}

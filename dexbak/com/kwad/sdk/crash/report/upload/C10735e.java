package com.kwad.sdk.crash.report.upload;

/* renamed from: com.kwad.sdk.crash.report.upload.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10735e {
    private final int aHC;
    private final String aHD;
    public static C10735e aHt = new C10735e(-11, "Please init.");
    public static C10735e aHu = new C10735e(-12, "error when zip_file");
    public static C10735e aHv = new C10735e(-13, "There is no valid network.");
    public static C10735e aHw = new C10735e(-14, "Token is invalid.");
    public static C10735e aHx = new C10735e(-15, "upload task execute frequence exceed.");
    public static C10735e aHy = new C10735e(-16, "process request fail.");
    public static C10735e aHz = new C10735e(-17, "sever response error http code");
    public static C10735e aHA = new C10735e(-18, "sever response error result code");
    public static C10735e aHB = new C10735e(-19, "server bad response.");

    private C10735e(int i, String str) {
        this.aHC = i;
        this.aHD = str;
    }

    /* renamed from: wn */
    public final String m25009wn() {
        return this.aHD;
    }
}

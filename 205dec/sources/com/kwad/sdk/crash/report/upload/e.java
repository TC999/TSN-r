package com.kwad.sdk.crash.report.upload;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e {
    private final int aHC;
    private final String aHD;
    public static e aHt = new e(-11, "Please init.");
    public static e aHu = new e(-12, "error when zip_file");
    public static e aHv = new e(-13, "There is no valid network.");
    public static e aHw = new e(-14, "Token is invalid.");
    public static e aHx = new e(-15, "upload task execute frequence exceed.");
    public static e aHy = new e(-16, "process request fail.");
    public static e aHz = new e(-17, "sever response error http code");
    public static e aHA = new e(-18, "sever response error result code");
    public static e aHB = new e(-19, "server bad response.");

    private e(int i4, String str) {
        this.aHC = i4;
        this.aHD = str;
    }

    public final String wn() {
        return this.aHD;
    }
}

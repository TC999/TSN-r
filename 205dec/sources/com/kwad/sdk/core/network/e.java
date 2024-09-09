package com.kwad.sdk.core.network;

import com.bytedance.msdk.api.AdError;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e {
    public final int errorCode;
    public final String msg;
    public static e avt = new e(-1, "\u8bf7\u6c42\u8d85\u65f6\u4e8b\u4ef6");
    public static e avu = new e(-2, "\u8bf7\u6c42\u5f02\u5e38");
    public static e avv = new e(-1000, "\u8be5\u4e1a\u52a1\u7ec4\u4ef6\u672a\u52a0\u8f7d");
    public static e avw = new e(AdError.ERROR_CODE_REQUEST_PB_ERROR, "\u7f51\u7edc\u9519\u8bef");
    public static e avx = new e(AdError.ERROR_CODE_APP_EMPTY, "\u6570\u636e\u89e3\u6790\u9519\u8bef");
    public static e avy = new e(AdError.ERROR_CODE_WAP_EMPTY, "\u6570\u636e\u4e3a\u7a7a");
    public static e avz = new e(AdError.ERROR_CODE_ADSLOT_EMPTY, "\u89c6\u9891\u8d44\u6e90\u7f13\u5b58\u5931\u8d25");
    public static e avA = new e(AdError.ERROR_CODE_ADSLOT_SIZE_EMPTY, "\u7f51\u7edc\u8d85\u65f6");
    public static e avB = new e(AdError.ERROR_CODE_ADCOUNT_ERROR, "\u56fe\u7247\u4e0b\u8f7d\u5931\u8d25");
    public static e avC = new e(AdError.ERROR_CODE_IMAGE_SIZE, "\u5e7f\u544a\u573a\u666f\u4e0d\u5339\u914d");
    public static e avD = new e(AdError.ERROR_CODE_MEDIA_ID, "\u5e7f\u544a\u52a0\u8f7d\u5f02\u5e38");
    public static e avE = new e(AdError.ERROR_CODE_MEDIA_TYPE, "activity\u573a\u666f\u4e0d\u5339\u914d");
    public static e avF = new e(AdError.ERROR_CODE_AD_TYPE, "sdk\u521d\u59cb\u5316\u5931\u8d25");
    public static e avG = new e(AdError.ERROR_CODE_ACCESS_METHOD_PASS, "\u6743\u9650\u672a\u5f00\u542f");
    public static e avH = new e(100006, "\u66f4\u591a\u89c6\u9891\u8bf7\u524d\u5f80\u5feb\u624bApp\u67e5\u770b");
    public static e avI = new e(100007, "\u590d\u5236\u94fe\u63a5\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
    public static e avJ = new e(100008, "\u5185\u5bb9\u6709\u70b9\u654f\u611f\uff0c\u4e0d\u53ef\u4ee5\u53d1\u9001\u54e6");
    public static e avK = new e(130001, "\u6570\u636e\u4e0d\u5b58\u5728");
    public static e avL = new e(0, "\u7f51\u7edc\u8d85\u65f6");

    private e(int i4, String str) {
        this.errorCode = i4;
        this.msg = str;
    }
}

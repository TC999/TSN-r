package com.kwad.sdk;

import com.clj.fastble.BleManager;

/* renamed from: com.kwad.sdk.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10752e {
    public static final C10752e akC = new C10752e(BleManager.f22896l, "其他异常");
    public static final C10752e akD = new C10752e(10001, "初始化参数异常");
    public int code;
    public String msg;

    public C10752e(int i, String str) {
        this.code = i;
        this.msg = str;
    }
}

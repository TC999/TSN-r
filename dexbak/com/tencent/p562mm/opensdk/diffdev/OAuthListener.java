package com.tencent.p562mm.opensdk.diffdev;

/* renamed from: com.tencent.mm.opensdk.diffdev.OAuthListener */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface OAuthListener {
    void onAuthFinish(OAuthErrCode oAuthErrCode, String str);

    void onAuthGotQrcode(String str, byte[] bArr);

    void onQrcodeScanned();
}

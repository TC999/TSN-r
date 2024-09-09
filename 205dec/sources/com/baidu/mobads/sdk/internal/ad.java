package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.baidu.mobads.sdk.internal.f;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ad implements f.a {

    /* renamed from: a  reason: collision with root package name */
    private BaiduNativeManager.FeedAdListener f12332a;

    public ad(BaiduNativeManager.FeedAdListener feedAdListener) {
        this.f12332a = feedAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.f.a
    public void a(List<NativeResponse> list) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f12332a;
        if (feedAdListener != null) {
            feedAdListener.onNativeLoad(list);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.f.a
    public void b(int i4, String str) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f12332a;
        if (feedAdListener != null) {
            feedAdListener.onNativeFail(i4, str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.f.a
    public void c() {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f12332a;
        if (feedAdListener != null) {
            feedAdListener.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.f.a
    public void a(int i4, String str) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f12332a;
        if (feedAdListener != null) {
            feedAdListener.onNoAd(i4, str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.f.a
    public void b(NativeResponse nativeResponse) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f12332a;
        if (feedAdListener != null && (feedAdListener instanceof BaiduNativeManager.PortraitVideoAdListener)) {
            ((BaiduNativeManager.PortraitVideoAdListener) feedAdListener).onAdClick();
        } else if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.f.a
    public void a(NativeResponse nativeResponse) {
        if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).onADExposed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.f.a
    public void a(NativeResponse nativeResponse, int i4) {
        if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).onADExposureFailed(i4);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.f.a
    public void b() {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f12332a;
        if (feedAdListener != null) {
            feedAdListener.onVideoDownloadSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.f.a
    public void a() {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f12332a;
        if (feedAdListener != null) {
            feedAdListener.onLpClosed();
        }
    }
}

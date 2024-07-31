package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.baidu.mobads.sdk.internal.C2705f;
import java.util.List;

/* renamed from: com.baidu.mobads.sdk.internal.ad */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2584ad implements C2705f.InterfaceC2706a {

    /* renamed from: a */
    private BaiduNativeManager.FeedAdListener f8536a;

    public C2584ad(BaiduNativeManager.FeedAdListener feedAdListener) {
        this.f8536a = feedAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.C2705f.InterfaceC2706a
    /* renamed from: a */
    public void mo50401a(List<NativeResponse> list) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f8536a;
        if (feedAdListener != null) {
            feedAdListener.onNativeLoad(list);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.C2705f.InterfaceC2706a
    /* renamed from: b */
    public void mo50399b(int i, String str) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f8536a;
        if (feedAdListener != null) {
            feedAdListener.onNativeFail(i, str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.C2705f.InterfaceC2706a
    /* renamed from: c */
    public void mo50397c() {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f8536a;
        if (feedAdListener != null) {
            feedAdListener.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.C2705f.InterfaceC2706a
    /* renamed from: a */
    public void mo50404a(int i, String str) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f8536a;
        if (feedAdListener != null) {
            feedAdListener.onNoAd(i, str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.C2705f.InterfaceC2706a
    /* renamed from: b */
    public void mo50398b(NativeResponse nativeResponse) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f8536a;
        if (feedAdListener != null && (feedAdListener instanceof BaiduNativeManager.PortraitVideoAdListener)) {
            ((BaiduNativeManager.PortraitVideoAdListener) feedAdListener).onAdClick();
        } else if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.C2705f.InterfaceC2706a
    /* renamed from: a */
    public void mo50403a(NativeResponse nativeResponse) {
        if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).onADExposed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.C2705f.InterfaceC2706a
    /* renamed from: a */
    public void mo50402a(NativeResponse nativeResponse, int i) {
        if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).onADExposureFailed(i);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.C2705f.InterfaceC2706a
    /* renamed from: b */
    public void mo50400b() {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f8536a;
        if (feedAdListener != null) {
            feedAdListener.onVideoDownloadSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.C2705f.InterfaceC2706a
    /* renamed from: a */
    public void mo50405a() {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f8536a;
        if (feedAdListener != null) {
            feedAdListener.onLpClosed();
        }
    }
}

package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.FullScreenVideoAd;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.ScreenVideoAdListener;

/* renamed from: com.baidu.mobads.sdk.internal.dk */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2693dk extends C2701ds {

    /* renamed from: a */
    private FullScreenVideoAd.FullScreenVideoAdListener f8998a;

    public C2693dk(Context context, String str, boolean z) {
        super(context, str, z, IAdInterListener.AdProdType.PRODUCT_FULLSCREENVIDEO);
    }

    @Override // com.baidu.mobads.sdk.internal.C2701ds
    /* renamed from: a */
    public void mo50473a(ScreenVideoAdListener screenVideoAdListener) {
        super.mo50473a(screenVideoAdListener);
        if (screenVideoAdListener instanceof FullScreenVideoAd.FullScreenVideoAdListener) {
            this.f8998a = (FullScreenVideoAd.FullScreenVideoAdListener) screenVideoAdListener;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.C2701ds, com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: g */
    protected void mo50465g(String str) {
        FullScreenVideoAd.FullScreenVideoAdListener fullScreenVideoAdListener = this.f8998a;
        if (fullScreenVideoAdListener != null) {
            fullScreenVideoAdListener.onAdSkip(Float.parseFloat(str));
        }
    }
}

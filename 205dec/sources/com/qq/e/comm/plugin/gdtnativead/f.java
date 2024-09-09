package com.qq.e.comm.plugin.gdtnativead;

import android.content.Context;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.plugin.util.d1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f implements NEADI {

    /* renamed from: c  reason: collision with root package name */
    NEADI f43772c;

    static {
        com.qq.e.comm.plugin.dl.i.a().b(com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD);
    }

    public f(Context context, ADSize aDSize, String str, String str2, String str3, ADListener aDListener) {
        if (com.qq.e.comm.plugin.e0.d.d.a(context).b(str2)) {
            this.f43772c = new h(context, aDSize, str, str2, aDListener);
        } else {
            this.f43772c = new g(context, aDSize, str, str2, str3, aDListener);
        }
    }

    @Override // com.qq.e.comm.pi.NEADI
    public String getAdNetWorkName() {
        d1.a("gdt_tag_callback", "getAdNetWorkName()");
        return this.f43772c.getAdNetWorkName();
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void loadAd(int i4) {
        d1.a("gdt_tag_callback", "loadUrl(count)");
        this.f43772c.loadAd(i4);
    }

    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setMaxVideoDuration(int i4) {
        d1.a("gdt_tag_callback", "setMaxVideoDuration(maxVideoDuration)");
        this.f43772c.setMaxVideoDuration(i4);
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setMinVideoDuration(int i4) {
        d1.a("gdt_tag_callback", "setMinVideoDuration(minVideoDuration)");
        this.f43772c.setMinVideoDuration(i4);
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        d1.a("gdt_tag_callback", "setServerSideVerificationOptions()");
        this.f43772c.setServerSideVerificationOptions(serverSideVerificationOptions);
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setVideoOption(VideoOption videoOption) {
        d1.a("gdt_tag_callback", "setVideoOption(videoOption)");
        this.f43772c.setVideoOption(videoOption);
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void loadAd(int i4, LoadAdParams loadAdParams) {
        d1.a("gdt_tag_callback", "loadUrl(count, params)");
        this.f43772c.loadAd(i4, loadAdParams);
    }
}

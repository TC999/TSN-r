package com.qq.e.comm.plugin.nativeadunified;

import android.content.Context;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.plugin.util.d1;
import java.util.List;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class j implements NUADI {

    /* renamed from: c  reason: collision with root package name */
    private NUADI f44958c;

    public j(Context context, String str, String str2, String str3, ADListener aDListener) {
        if (com.qq.e.comm.plugin.e0.d.d.a(context).b(str2)) {
            this.f44958c = new k(context, str, str2, aDListener);
        } else {
            this.f44958c = new i(context, str, str2, str3, aDListener);
        }
    }

    @Override // com.qq.e.comm.pi.NUADI
    public String getAdNetWorkName() {
        d1.a("gdt_tag_callback", "getAdNetWorkName()");
        return this.f44958c.getAdNetWorkName();
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void loadData(int i4) {
        d1.a("gdt_tag_callback", "loadData(count)");
        this.f44958c.loadData(i4);
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setCategories(List<String> list) {
        d1.a("gdt_tag_callback", "setCategories(categories)");
        this.f44958c.setCategories(list);
    }

    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setMaxVideoDuration(int i4) {
        d1.a("gdt_tag_callback", "setMaxVideoDuration(maxVideoDuration)");
        this.f44958c.setMaxVideoDuration(i4);
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setMinVideoDuration(int i4) {
        d1.a("gdt_tag_callback", "setMinVideoDuration(minVideoDuration)");
        this.f44958c.setMinVideoDuration(i4);
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setVastClassName(String str) {
        d1.a("gdt_tag_callback", "setVastClassName(className)");
        this.f44958c.setVastClassName(str);
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void loadData(int i4, LoadAdParams loadAdParams) {
        d1.a("gdt_tag_callback", "loadData(count, params)");
        this.f44958c.loadData(i4, loadAdParams);
    }
}

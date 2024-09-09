package com.qq.e.comm.plugin.a0;

import android.content.Intent;
import com.qq.e.ads.hybrid.HybridADListener;
import com.qq.e.ads.hybrid.HybridADSetting;
import com.qq.e.comm.pi.HADI;
import com.qq.e.comm.plugin.d0.b.e;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.plugin.util.q1;
import com.qq.e.comm.plugin.util.w0;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b implements HADI {

    /* renamed from: c  reason: collision with root package name */
    private final HybridADListener f41708c;

    /* renamed from: d  reason: collision with root package name */
    private final HybridADSetting f41709d;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f41708c != null) {
                b.this.f41708c.onPageShow();
            }
        }
    }

    public b(HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        this.f41709d = hybridADSetting;
        this.f41708c = hybridADListener;
    }

    @Override // com.qq.e.comm.pi.HADI
    public void loadUrl(String str) {
        d1.a("gdt_tag_callback", "loadUrl(url)");
        Intent intent = new Intent();
        intent.setClassName(com.qq.e.comm.plugin.d0.a.d().a(), q1.a());
        intent.addFlags(268435456);
        intent.putExtra("appid", com.qq.e.comm.plugin.d0.a.d().b().a());
        intent.putExtra("gdt_activity_delegate_name", com.qq.e.comm.plugin.a.HYBRID_AD_PAGE);
        String valueOf = String.valueOf(w0.a());
        intent.putExtra("objectId", valueOf);
        com.qq.e.comm.plugin.d0.b.c cVar = (com.qq.e.comm.plugin.d0.b.c) e.a(valueOf, com.qq.e.comm.plugin.d0.b.c.class);
        HybridADSetting hybridADSetting = this.f41709d;
        if (hybridADSetting == null) {
            hybridADSetting = new HybridADSetting();
        }
        cVar.a(hybridADSetting);
        cVar.a(this.f41708c);
        intent.putExtra("url", str);
        com.qq.e.comm.plugin.d0.a.d().a().startActivity(intent);
        p0.a((Runnable) new a());
        v.a(21042, null, 1);
    }
}

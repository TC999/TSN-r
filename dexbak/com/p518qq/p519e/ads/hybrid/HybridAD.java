package com.p518qq.p519e.ads.hybrid;

import android.content.Context;
import com.p518qq.p519e.ads.AbstractAD;
import com.p518qq.p519e.comm.p520pi.HADI;
import com.p518qq.p519e.comm.p520pi.POFactory;
import com.p518qq.p519e.comm.util.AdErrorConvertor;
import com.p518qq.p519e.comm.util.GDTLogger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.qq.e.ads.hybrid.HybridAD */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class HybridAD extends AbstractAD<HADI> implements HADI {

    /* renamed from: f */
    private HybridADListener f32777f;

    /* renamed from: g */
    private CountDownLatch f32778g = new CountDownLatch(1);

    /* renamed from: h */
    private HybridADSetting f32779h;

    public HybridAD(Context context, HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        this.f32779h = hybridADSetting;
        this.f32777f = hybridADListener;
        m20414a(context, "NO_POS_ID");
    }

    /* renamed from: a */
    protected HADI m20390a(POFactory pOFactory) {
        return pOFactory.getHybridAD(this.f32779h, this.f32777f);
    }

    @Override // com.p518qq.p519e.ads.AbstractAD
    /* renamed from: a */
    protected /* bridge */ /* synthetic */ HADI mo20371a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return m20390a(pOFactory);
    }

    @Override // com.p518qq.p519e.ads.AbstractAD
    /* renamed from: a */
    protected /* bridge */ /* synthetic */ void mo20368a(HADI hadi) {
        m20387c();
    }

    @Override // com.p518qq.p519e.ads.AbstractAD
    /* renamed from: b */
    protected void mo20366b(int i) {
        HybridADListener hybridADListener = this.f32777f;
        if (hybridADListener != null) {
            hybridADListener.onError(AdErrorConvertor.formatErrorCode(i));
        }
        this.f32778g.countDown();
    }

    /* renamed from: c */
    protected void m20387c() {
        this.f32778g.countDown();
    }

    @Override // com.p518qq.p519e.comm.p520pi.HADI
    public void loadUrl(final String str) {
        if (m20416a()) {
            if (!m20409b()) {
                new Thread(new Runnable() { // from class: com.qq.e.ads.hybrid.HybridAD.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            HybridAD.this.f32778g.await(30L, TimeUnit.SECONDS);
                            if (!HybridAD.this.m20409b() || ((AbstractAD) HybridAD.this).f32719a == null) {
                                GDTLogger.m20307e("初始化错误：广告实例未被初始化");
                                HybridAD.this.m20415a(2001);
                            } else {
                                ((HADI) ((AbstractAD) HybridAD.this).f32719a).loadUrl(str);
                            }
                        } catch (InterruptedException unused) {
                            GDTLogger.m20307e("初始化错误：广告实例未被初始化");
                            HybridAD.this.m20415a(2001);
                        }
                    }
                }).start();
                return;
            }
            T t = this.f32719a;
            if (t != 0) {
                ((HADI) t).loadUrl(str);
            } else {
                m20410a("loadUrl");
            }
        }
    }
}

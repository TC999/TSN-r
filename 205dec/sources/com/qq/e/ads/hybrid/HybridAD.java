package com.qq.e.ads.hybrid;

import android.content.Context;
import com.qq.e.ads.AbstractAD;
import com.qq.e.comm.pi.HADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class HybridAD extends AbstractAD<HADI> implements HADI {

    /* renamed from: f  reason: collision with root package name */
    private HybridADListener f41492f;

    /* renamed from: g  reason: collision with root package name */
    private CountDownLatch f41493g = new CountDownLatch(1);

    /* renamed from: h  reason: collision with root package name */
    private HybridADSetting f41494h;

    public HybridAD(Context context, HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        this.f41494h = hybridADSetting;
        this.f41492f = hybridADListener;
        a(context, "NO_POS_ID");
    }

    protected HADI a(POFactory pOFactory) {
        return pOFactory.getHybridAD(this.f41494h, this.f41492f);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected /* bridge */ /* synthetic */ HADI a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return a(pOFactory);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected /* bridge */ /* synthetic */ void a(HADI hadi) {
        c();
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i4) {
        HybridADListener hybridADListener = this.f41492f;
        if (hybridADListener != null) {
            hybridADListener.onError(AdErrorConvertor.formatErrorCode(i4));
        }
        this.f41493g.countDown();
    }

    protected void c() {
        this.f41493g.countDown();
    }

    @Override // com.qq.e.comm.pi.HADI
    public void loadUrl(final String str) {
        if (a()) {
            if (!b()) {
                new Thread(new Runnable() { // from class: com.qq.e.ads.hybrid.HybridAD.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            HybridAD.this.f41493g.await(30L, TimeUnit.SECONDS);
                            if (!HybridAD.this.b() || ((AbstractAD) HybridAD.this).f41434a == null) {
                                GDTLogger.e("\u521d\u59cb\u5316\u9519\u8bef\uff1a\u5e7f\u544a\u5b9e\u4f8b\u672a\u88ab\u521d\u59cb\u5316");
                                HybridAD.this.a(2001);
                            } else {
                                ((HADI) ((AbstractAD) HybridAD.this).f41434a).loadUrl(str);
                            }
                        } catch (InterruptedException unused) {
                            GDTLogger.e("\u521d\u59cb\u5316\u9519\u8bef\uff1a\u5e7f\u544a\u5b9e\u4f8b\u672a\u88ab\u521d\u59cb\u5316");
                            HybridAD.this.a(2001);
                        }
                    }
                }).start();
                return;
            }
            Object obj = this.f41434a;
            if (obj != null) {
                ((HADI) obj).loadUrl(str);
            } else {
                a("loadUrl");
            }
        }
    }
}

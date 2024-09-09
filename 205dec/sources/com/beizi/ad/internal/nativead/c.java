package com.beizi.ad.internal.nativead;

import android.util.Log;
import com.beizi.ad.NativeAdResponse;
import com.beizi.ad.R;
import com.beizi.ad.internal.e;
import com.beizi.ad.internal.k;
import com.beizi.ad.internal.m;
import com.beizi.ad.internal.network.ServerResponse;
import com.beizi.ad.internal.utilities.HaoboLog;
import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.concurrent.RejectedExecutionException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: NativeAdRequestManagerImpl.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class c extends m {

    /* renamed from: a  reason: collision with root package name */
    private final SoftReference<b> f13950a;

    /* renamed from: b  reason: collision with root package name */
    private com.beizi.ad.internal.nativead.a.a f13951b;

    public c(b bVar) {
        this.f13950a = new SoftReference<>(bVar);
    }

    @Override // com.beizi.ad.internal.f
    public void a() {
        b bVar = this.f13950a.get();
        if (bVar == null) {
            HaoboLog.e(HaoboLog.baseLogTag, "Before execute request manager, you should set ad request!");
            return;
        }
        g();
        try {
            bVar.a(this);
            bVar.executeOnExecutor(com.beizi.ad.lance.a.c.b().c(), new Void[0]);
        } catch (IllegalStateException e4) {
            Log.d("lance", "ignored:" + e4.getMessage());
        } catch (RejectedExecutionException e5) {
            String str = HaoboLog.baseLogTag;
            HaoboLog.e(str, "Concurrent Thread Exception while firing new ad request: " + e5.getMessage());
        }
    }

    @Override // com.beizi.ad.internal.f
    public e c() {
        b bVar = this.f13950a.get();
        if (bVar != null) {
            return bVar.g();
        }
        return null;
    }

    @Override // com.beizi.ad.internal.f
    public com.beizi.ad.b.a d() {
        return null;
    }

    @Override // com.beizi.ad.internal.m
    public void e() {
        b bVar = this.f13950a.get();
        if (bVar != null) {
            bVar.cancel(true);
        }
        a((LinkedList<com.beizi.ad.internal.a.a>) null);
        com.beizi.ad.internal.nativead.a.a aVar = this.f13951b;
        if (aVar != null) {
            aVar.a(true);
            this.f13951b = null;
        }
    }

    @Override // com.beizi.ad.internal.f
    public void a(int i4) {
        h();
        b bVar = this.f13950a.get();
        if (bVar != null) {
            bVar.h().a(i4);
        }
    }

    @Override // com.beizi.ad.internal.f
    public void a(final ServerResponse serverResponse) {
        b bVar = this.f13950a.get();
        if (bVar != null) {
            boolean containsAds = serverResponse.containsAds();
            boolean z3 = (b() == null || b().isEmpty()) ? false : true;
            Log.d("lance", containsAds + "=====" + z3);
            if (!containsAds && !z3) {
                HaoboLog.w(HaoboLog.httpRespLogTag, HaoboLog.getString(R.string.response_no_ads));
                bVar.h().a(3);
                return;
            }
            if (containsAds) {
                a(serverResponse.getMediationAds());
            }
            if (b() != null && !b().isEmpty()) {
                com.beizi.ad.internal.a.a i4 = i();
                if (i4 != null) {
                    i4.a(serverResponse.getExtras());
                }
                this.f13951b = com.beizi.ad.internal.nativead.a.a.a(i4, this, serverResponse);
                return;
            }
            final a aVar = (a) serverResponse.getNativeAdResponse();
            aVar.a(bVar.g().a());
            aVar.a(bVar.a());
            aVar.b(bVar.b());
            a(new com.beizi.ad.internal.network.b() { // from class: com.beizi.ad.internal.nativead.c.1
                @Override // com.beizi.ad.internal.network.b
                public k a() {
                    return k.NATIVE;
                }

                @Override // com.beizi.ad.internal.network.b
                public boolean b() {
                    return false;
                }

                @Override // com.beizi.ad.internal.network.b
                public com.beizi.ad.internal.view.c c() {
                    return null;
                }

                @Override // com.beizi.ad.internal.network.b
                public NativeAdResponse d() {
                    return aVar;
                }

                @Override // com.beizi.ad.internal.network.b
                public String e() {
                    return "";
                }

                @Override // com.beizi.ad.internal.network.b
                public String f() {
                    return serverResponse.getPrice();
                }

                @Override // com.beizi.ad.internal.network.b
                public String g() {
                    return serverResponse.getAdId();
                }

                @Override // com.beizi.ad.internal.network.b
                public void h() {
                    aVar.destroy();
                }

                @Override // com.beizi.ad.internal.network.b
                public boolean i() {
                    return serverResponse.isDownloadApp();
                }
            });
        }
    }

    public void a(com.beizi.ad.internal.network.b bVar) {
        h();
        if (this.f13951b != null) {
            this.f13951b = null;
        }
        b bVar2 = this.f13950a.get();
        if (bVar2 != null) {
            bVar2.h().a(bVar);
        } else {
            bVar.h();
        }
    }
}

package com.beizi.ad.internal.a;

import android.app.Activity;
import com.beizi.ad.R;
import com.beizi.ad.internal.k;
import com.beizi.ad.internal.network.ServerResponse;
import com.beizi.ad.internal.utilities.HaoboLog;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: MediationInterstitialAdViewController.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class f extends b {
    private f(Activity activity, com.beizi.ad.internal.f fVar, a aVar, com.beizi.ad.internal.c cVar, ServerResponse serverResponse) {
        super(fVar, aVar, cVar, k.INTERSTITIAL, serverResponse);
        if (a(g.class)) {
            HaoboLog.d(HaoboLog.mediationLogTag, HaoboLog.getString(R.string.mediated_request));
            e();
            g();
            int i4 = 0;
            try {
                if (activity != null) {
                    ((g) this.f13528b).a(this, activity, this.f13529c.b(), this.f13529c.e(), a());
                    i4 = -1;
                } else {
                    HaoboLog.e(HaoboLog.mediationLogTag, HaoboLog.getString(R.string.mediated_request_null_activity));
                }
            } catch (Error e4) {
                HaoboLog.e(HaoboLog.mediationLogTag, HaoboLog.getString(R.string.mediated_request_error), e4);
            } catch (Exception e5) {
                HaoboLog.e(HaoboLog.mediationLogTag, HaoboLog.getString(R.string.mediated_request_exception), e5);
            }
            if (i4 != -1) {
                a(i4);
            }
        }
    }

    public static f a(Activity activity, com.beizi.ad.internal.f fVar, a aVar, com.beizi.ad.internal.c cVar, ServerResponse serverResponse) {
        f fVar2 = new f(activity, fVar, aVar, cVar, serverResponse);
        if (fVar2.f13533g) {
            return null;
        }
        return fVar2;
    }

    @Override // com.beizi.ad.internal.a.b
    public void c() {
        if (this.f13528b == null || d()) {
            return;
        }
        ((g) this.f13528b).a();
    }

    @Override // com.beizi.ad.internal.a.b
    public void i() {
        this.f13535i = true;
        com.beizi.ad.b.b bVar = this.f13528b;
        if (bVar != null) {
            bVar.e();
        }
    }

    @Override // com.beizi.ad.internal.a.b
    public void j() {
        com.beizi.ad.b.b bVar = this.f13528b;
        if (bVar != null) {
            bVar.c();
        }
    }

    @Override // com.beizi.ad.internal.a.b
    public void k() {
        com.beizi.ad.b.b bVar = this.f13528b;
        if (bVar != null) {
            bVar.d();
        }
    }
}

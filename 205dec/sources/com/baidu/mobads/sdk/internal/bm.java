package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.internal.bj;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
class bm implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IOAdEvent f12494a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ bj.a f12495b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bj.a aVar, IOAdEvent iOAdEvent) {
        this.f12495b = aVar;
        this.f12494a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        HashMap hashMap;
        IOAdEvent iOAdEvent = this.f12494a;
        if (iOAdEvent == null || TextUtils.isEmpty(iOAdEvent.getType())) {
            return;
        }
        String type = this.f12494a.getType();
        if (x.K.equals(type)) {
            bj.this.a(this.f12494a);
        } else if (x.N.equals(type)) {
            bj.this.f12487n = this.f12494a.getMessage();
            bj.this.q();
        } else if (x.O.equals(type)) {
            bj.this.e(this.f12494a);
        } else if (x.P.equals(type)) {
            bj.this.f(this.f12494a);
        } else if (x.X.equals(type)) {
            bj.this.g(this.f12494a);
        } else {
            String str = "";
            int i4 = 0;
            int i5 = 0;
            r5 = false;
            boolean z3 = false;
            if (x.f13038s.equals(type)) {
                HashMap hashMap2 = (HashMap) this.f12494a.getData();
                if (hashMap2 != null) {
                    str = (String) hashMap2.get("error_message");
                    Object obj = hashMap2.get("error_code");
                    Integer num = obj;
                    if (obj == null) {
                        num = 0;
                    }
                    i4 = ((Integer) num).intValue();
                }
                bj.this.b(str, i4);
            } else if (x.M.equals(type)) {
                HashMap hashMap3 = (HashMap) this.f12494a.getData();
                if (hashMap3 != null) {
                    str = (String) hashMap3.get("error_message");
                    Object obj2 = hashMap3.get("error_code");
                    Integer num2 = obj2;
                    if (obj2 == null) {
                        num2 = 0;
                    }
                    i5 = ((Integer) num2).intValue();
                }
                bj.this.a(i5, str);
            } else if (x.I.equals(type)) {
                bj.this.h(this.f12494a);
            } else if (x.Y.equals(type)) {
                bj.this.d();
            } else if (x.Z.equals(type)) {
                bj.this.d(this.f12494a);
            } else if (x.ab.equals(type)) {
                bj.this.s();
            } else if (x.ac.equals(type)) {
                IOAdEvent iOAdEvent2 = this.f12494a;
                if (iOAdEvent2 != null && (hashMap = (HashMap) iOAdEvent2.getData()) != null) {
                    z3 = "1".equals((String) hashMap.get("serverVerify"));
                }
                bj.this.b(z3);
            } else if (x.ad.equals(type)) {
                bj.this.b_();
            } else if (x.ae.equals(type)) {
                bj.this.c_();
            } else if (x.f13019L.equals(type)) {
                bj.this.b(this.f12494a);
            } else if (x.af.equals(type)) {
                bj.this.a(this.f12494a.getMessage(), 1 == this.f12494a.getCode());
            } else if (x.ag.equals(type)) {
                bj.this.e(this.f12494a.getMessage());
            } else if (x.ah.equals(type)) {
                bj.this.f(this.f12494a.getMessage());
            } else if (x.ai.equals(type)) {
                bj.this.d(this.f12494a.getMessage());
            } else if (x.E.equals(type)) {
                bj.this.g(this.f12494a.getMessage());
            } else if (x.aa.equals(type)) {
                bj.this.t();
            } else if (x.aj.equals(type)) {
                bj.this.b(this.f12494a.getMessage(), 1 == this.f12494a.getCode());
            } else if (x.am.equals(type)) {
                bj.this.c(this.f12494a);
            } else if (x.ak.equals(type)) {
                bj.this.u();
            } else if (x.al.equals(type)) {
                bj.this.v();
            } else if (x.ao.equals(type)) {
                bj.this.i(this.f12494a);
            } else if (x.ap.equals(type)) {
                bj.this.j(this.f12494a);
            } else if (x.an.equals(type)) {
                bj.this.k(this.f12494a);
            }
        }
    }
}

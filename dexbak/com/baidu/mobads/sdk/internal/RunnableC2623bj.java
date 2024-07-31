package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.internal.AbstractC2619bg;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.sdk.internal.bj */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class RunnableC2623bj implements Runnable {

    /* renamed from: a */
    final /* synthetic */ IOAdEvent f8675a;

    /* renamed from: b */
    final /* synthetic */ AbstractC2619bg.C2620a f8676b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2623bj(AbstractC2619bg.C2620a c2620a, IOAdEvent iOAdEvent) {
        this.f8676b = c2620a;
        this.f8675a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        HashMap hashMap;
        IOAdEvent iOAdEvent = this.f8675a;
        if (iOAdEvent == null || TextUtils.isEmpty(iOAdEvent.getType())) {
            return;
        }
        String type = this.f8675a.getType();
        if (C2736x.f9244J.equals(type)) {
            AbstractC2619bg.this.mo50455a(this.f8675a);
        } else if (C2736x.f9247M.equals(type)) {
            AbstractC2619bg.this.f8669n = this.f8675a.getMessage();
            AbstractC2619bg.this.mo50422q();
        } else if (C2736x.f9248N.equals(type)) {
            AbstractC2619bg.this.mo50511e(this.f8675a);
        } else if (C2736x.f9249O.equals(type)) {
            AbstractC2619bg.this.mo50509f(this.f8675a);
        } else if (C2736x.f9257W.equals(type)) {
            AbstractC2619bg.this.mo50429g(this.f8675a);
        } else {
            String str = "";
            int i = 0;
            int i2 = 0;
            r5 = false;
            boolean z = false;
            if (C2736x.f9320r.equals(type)) {
                HashMap hashMap2 = (HashMap) this.f8675a.getData();
                if (hashMap2 != null) {
                    str = (String) hashMap2.get("error_message");
                    Object obj = hashMap2.get("error_code");
                    Integer num = obj;
                    if (obj == null) {
                        num = 0;
                    }
                    i = ((Integer) num).intValue();
                }
                AbstractC2619bg.this.mo50442b(str, i);
            } else if (C2736x.f9246L.equals(type)) {
                HashMap hashMap3 = (HashMap) this.f8675a.getData();
                if (hashMap3 != null) {
                    str = (String) hashMap3.get("error_message");
                    Object obj2 = hashMap3.get("error_code");
                    Integer num2 = obj2;
                    if (obj2 == null) {
                        num2 = 0;
                    }
                    i2 = ((Integer) num2).intValue();
                }
                AbstractC2619bg.this.mo50459a(i2, str);
            } else if (C2736x.f9242H.equals(type)) {
                AbstractC2619bg.this.mo50427h(this.f8675a);
            } else if (C2736x.f9258X.equals(type)) {
                AbstractC2619bg.this.mo50436d();
            } else if (C2736x.f9259Y.equals(type)) {
                AbstractC2619bg.this.mo50580d(this.f8675a);
            } else if (C2736x.f9278aa.equals(type)) {
                AbstractC2619bg.this.mo50461s();
            } else if (C2736x.f9279ab.equals(type)) {
                IOAdEvent iOAdEvent2 = this.f8675a;
                if (iOAdEvent2 != null && (hashMap = (HashMap) iOAdEvent2.getData()) != null) {
                    z = "1".equals((String) hashMap.get("serverVerify"));
                }
                AbstractC2619bg.this.mo50468b(z);
            } else if (C2736x.f9280ac.equals(type)) {
                AbstractC2619bg.this.mo50440b_();
            } else if (C2736x.f9281ad.equals(type)) {
                AbstractC2619bg.this.mo50437c_();
            } else if (C2736x.f9245K.equals(type)) {
                AbstractC2619bg.this.mo50516b(this.f8675a);
            } else if (C2736x.f9282ae.equals(type)) {
                AbstractC2619bg.this.mo50447a(this.f8675a.getMessage(), 1 == this.f8675a.getCode());
            } else if (C2736x.f9283af.equals(type)) {
                AbstractC2619bg.this.mo50433e(this.f8675a.getMessage());
            } else if (C2736x.f9284ag.equals(type)) {
                AbstractC2619bg.this.mo50431f(this.f8675a.getMessage());
            } else if (C2736x.f9285ah.equals(type)) {
                AbstractC2619bg.this.mo50512d(this.f8675a.getMessage());
            } else if (C2736x.f9238D.equals(type)) {
                AbstractC2619bg.this.mo50465g(this.f8675a.getMessage());
            } else if (C2736x.f9260Z.equals(type)) {
                AbstractC2619bg.this.mo50421t();
            } else if (C2736x.f9286ai.equals(type)) {
                AbstractC2619bg.this.mo50441b(this.f8675a.getMessage(), 1 == this.f8675a.getCode());
            } else if (C2736x.f9289al.equals(type)) {
                AbstractC2619bg.this.mo50515c(this.f8675a);
            } else if (C2736x.f9287aj.equals(type)) {
                AbstractC2619bg.this.mo50420u();
            } else if (C2736x.f9288ak.equals(type)) {
                AbstractC2619bg.this.mo50419v();
            } else if (C2736x.f9291an.equals(type)) {
                AbstractC2619bg.this.mo50506i(this.f8675a);
            } else if (C2736x.f9292ao.equals(type)) {
                AbstractC2619bg.this.mo50505j(this.f8675a);
            } else if (C2736x.f9290am.equals(type)) {
                AbstractC2619bg.this.mo50504k(this.f8675a);
            }
        }
    }
}

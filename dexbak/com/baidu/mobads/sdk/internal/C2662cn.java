package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.mobads.sdk.internal.cn */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2662cn extends AbstractRunnableC2710i {

    /* renamed from: b */
    final /* synthetic */ C2660cm f8862b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2662cn(C2660cm c2660cm) {
        this.f8862b = c2660cm;
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractRunnableC2710i
    /* renamed from: i */
    protected Object mo50376i() {
        String m50627a;
        String m50627a2;
        Context context;
        String m50627a3;
        try {
            m50627a = this.f8862b.m50627a("key_crash_trace");
            m50627a2 = this.f8862b.m50627a("key_crash_ad");
            if (TextUtils.isEmpty(m50627a)) {
                return null;
            }
            C2657cj m50646a = C2657cj.m50646a();
            context = this.f8862b.f8860m;
            m50646a.m50645a(context);
            m50627a3 = this.f8862b.m50627a("key_crash_source");
            m50646a.m50642a(m50627a3, m50627a, m50627a2);
            this.f8862b.m50617g();
            return null;
        } catch (Exception e) {
            C2634bs.m50744a().m50738a(e);
            return null;
        }
    }
}

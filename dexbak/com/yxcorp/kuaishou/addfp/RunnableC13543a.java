package com.yxcorp.kuaishou.addfp;

import android.content.Context;
import android.os.Build;
import com.yxcorp.kuaishou.addfp.android.p576a.C13546c;
import com.yxcorp.kuaishou.addfp.android.p577b.C13554f;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.yxcorp.kuaishou.addfp.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class RunnableC13543a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ KWEGIDDFP f40035a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC13543a(KWEGIDDFP kwegiddfp) {
        this.f40035a = kwegiddfp;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        String str;
        ResponseDfpCallback responseDfpCallback;
        ResponseDfpCallback responseDfpCallback2;
        Context unused;
        try {
            context = this.f40035a.mParamContext;
            if (context == null) {
                responseDfpCallback2 = this.f40035a.mCallBack;
                responseDfpCallback2.onFailed(-3, "parameter error");
                return;
            }
            unused = this.f40035a.mParamContext;
            int i = C13554f.f40057c;
            if (Build.VERSION.SDK_INT >= 28) {
                C13554f.m12876a();
            }
            KWEGIDDFP kwegiddfp = this.f40035a;
            context2 = kwegiddfp.mParamContext;
            kwegiddfp.mPkgName = context2.getPackageName();
            C13546c m12898c = C13546c.m12898c();
            str = this.f40035a.mPkgName;
            m12898c.m12899b(str);
            KWEGIDDFP kwegiddfp2 = this.f40035a;
            responseDfpCallback = kwegiddfp2.mCallBack;
            kwegiddfp2.getEGid(responseDfpCallback);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

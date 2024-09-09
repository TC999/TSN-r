package com.yxcorp.kuaishou.addfp;

import android.content.Context;
import android.os.Build;
import com.yxcorp.kuaishou.addfp.android.a.c;
import com.yxcorp.kuaishou.addfp.android.b.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ KWEGIDDFP f54542a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(KWEGIDDFP kwegiddfp) {
        this.f54542a = kwegiddfp;
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
            context = this.f54542a.mParamContext;
            if (context == null) {
                responseDfpCallback2 = this.f54542a.mCallBack;
                responseDfpCallback2.onFailed(-3, "parameter error");
                return;
            }
            unused = this.f54542a.mParamContext;
            int i4 = f.f54564c;
            if (Build.VERSION.SDK_INT >= 28) {
                f.a();
            }
            KWEGIDDFP kwegiddfp = this.f54542a;
            context2 = kwegiddfp.mParamContext;
            kwegiddfp.mPkgName = context2.getPackageName();
            c c4 = c.c();
            str = this.f54542a.mPkgName;
            c4.b(str);
            KWEGIDDFP kwegiddfp2 = this.f54542a;
            responseDfpCallback = kwegiddfp2.mCallBack;
            kwegiddfp2.getEGid(responseDfpCallback);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

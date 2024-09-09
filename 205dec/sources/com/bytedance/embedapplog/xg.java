package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.embedapplog.xv;
import com.bytedance.embedapplog.zg;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class xg<SERVICE> implements zg {

    /* renamed from: c  reason: collision with root package name */
    private final String f26837c;

    /* renamed from: w  reason: collision with root package name */
    private oh<Boolean> f26838w = new oh<Boolean>() { // from class: com.bytedance.embedapplog.xg.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.oh
        /* renamed from: xv */
        public Boolean c(Object... objArr) {
            return Boolean.valueOf(zr.c((Context) objArr[0], xg.this.f26837c));
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public xg(String str) {
        this.f26837c = str;
    }

    protected abstract xv.w<SERVICE, String> c();

    @Override // com.bytedance.embedapplog.zg
    public zg.c w(Context context) {
        return c((String) new xv(context, xv(context), c()).c());
    }

    protected abstract Intent xv(Context context);

    @Override // com.bytedance.embedapplog.zg
    public boolean c(Context context) {
        if (context == null) {
            return false;
        }
        return this.f26838w.w(context).booleanValue();
    }

    private zg.c c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        zg.c cVar = new zg.c();
        cVar.f26861w = str;
        return cVar;
    }
}

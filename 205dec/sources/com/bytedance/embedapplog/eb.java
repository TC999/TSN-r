package com.bytedance.embedapplog;

import android.os.Bundle;
import com.bytedance.embedapplog.bs;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class eb extends bs.c {

    /* renamed from: c  reason: collision with root package name */
    private volatile String f26722c = "";

    @Override // com.bytedance.embedapplog.bs
    public void c(int i4, long j4, boolean z3, float f4, double d4, String str) {
    }

    @Override // com.bytedance.embedapplog.bs
    public void c(int i4, Bundle bundle) {
        if (i4 != 0 || bundle == null) {
            return;
        }
        this.f26722c = bundle.getString("oa_id_flag");
    }

    public String w() {
        return this.f26722c;
    }
}

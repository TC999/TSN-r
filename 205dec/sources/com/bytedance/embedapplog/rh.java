package com.bytedance.embedapplog;

import android.os.Bundle;
import com.bytedance.embedapplog.bs;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class rh extends bs.c {

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f26792c = false;

    @Override // com.bytedance.embedapplog.bs
    public void c(int i4, long j4, boolean z3, float f4, double d4, String str) {
    }

    @Override // com.bytedance.embedapplog.bs
    public void c(int i4, Bundle bundle) {
        if (i4 != 0 || bundle == null) {
            return;
        }
        this.f26792c = bundle.getBoolean("oa_id_limit_state");
    }

    public boolean w() {
        return this.f26792c;
    }
}

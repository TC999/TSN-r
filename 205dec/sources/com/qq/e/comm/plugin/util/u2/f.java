package com.qq.e.comm.plugin.util.u2;

import android.text.TextUtils;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class f extends a {
    f(boolean z3) {
        super(z3);
    }

    @Override // com.qq.e.comm.plugin.util.u2.a
    protected int b() {
        return 1130003;
    }

    @Override // com.qq.e.comm.plugin.util.u2.a
    protected String[] c() {
        String c4 = com.qq.e.comm.plugin.d0.a.d().f().c("mcClaNa");
        return !TextUtils.isEmpty(c4) ? c4.split(",") : new String[0];
    }
}
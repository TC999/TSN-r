package com.qq.e.comm.plugin.m.c;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.plugin.util.s0;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
abstract class f implements com.qq.e.comm.plugin.m.a {

    /* renamed from: a  reason: collision with root package name */
    private String f44652a = "";

    @Override // com.qq.e.comm.plugin.m.a
    public String b(Context context) {
        if (TextUtils.isEmpty(this.f44652a)) {
            String a4 = a(context);
            if (!TextUtils.isEmpty(a4)) {
                this.f44652a = s0.a(a4.toLowerCase());
            }
        }
        return this.f44652a;
    }
}

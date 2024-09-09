package com.mbridge.msdk.widget.custom.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import java.io.File;

/* compiled from: InflaterUtil.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f41192a;

    /* renamed from: b  reason: collision with root package name */
    private com.mbridge.msdk.widget.custom.a.b f41193b;

    private c(Context context) {
        this.f41193b = null;
        com.mbridge.msdk.widget.custom.a.b a4 = com.mbridge.msdk.widget.custom.a.b.a();
        this.f41193b = a4;
        a4.a("");
    }

    public static c a(Context context) {
        if (f41192a == null) {
            f41192a = new c(context);
        }
        return f41192a;
    }

    public final View a(String str) {
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return null;
        }
        return this.f41193b.f(str);
    }
}

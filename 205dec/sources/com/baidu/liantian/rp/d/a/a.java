package com.baidu.liantian.rp.d.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.liantian.b;
import com.baidu.liantian.b.e;
import com.baidu.liantian.b.h;
import org.json.JSONObject;

/* compiled from: ReportEngine.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f12264a;

    public a(Context context) {
        this.f12264a = context;
    }

    public final boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        b.a();
        try {
            TextUtils.isEmpty(str2);
            b.a();
            String a4 = h.a(this.f12264a, e.b() + "p/1/r", str);
            if (TextUtils.isEmpty(a4)) {
                return false;
            }
            return new JSONObject(a4).getInt("response") == 1;
        } catch (Throwable unused) {
            e.a();
            return true;
        }
    }
}

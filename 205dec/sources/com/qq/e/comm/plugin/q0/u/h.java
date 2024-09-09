package com.qq.e.comm.plugin.q0.u;

import android.text.TextUtils;
import com.qq.e.comm.plugin.util.a1;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class h extends i {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final h f45622a = new h();
    }

    public static h b() {
        return b.f45622a;
    }

    @Override // com.qq.e.comm.plugin.q0.u.i
    public String a() {
        return "ping";
    }

    @Override // com.qq.e.comm.plugin.q0.u.i
    public void a(com.qq.e.comm.plugin.q0.h hVar, com.qq.e.comm.plugin.q0.s.d dVar) {
        JSONObject d4 = dVar.d();
        if (d4 == null || !d4.has("url")) {
            return;
        }
        String optString = d4.optString("url");
        boolean optBoolean = d4.optBoolean("imp", false);
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        a1.a(optString, optBoolean);
    }

    private h() {
    }
}

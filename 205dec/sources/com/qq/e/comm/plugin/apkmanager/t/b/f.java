package com.qq.e.comm.plugin.apkmanager.t.b;

import com.qq.e.comm.plugin.apkmanager.k;
import com.qq.e.comm.plugin.q0.h;
import com.qq.e.comm.plugin.q0.u.i;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f extends i {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final f f41899a = new f();
    }

    public static f b() {
        return b.f41899a;
    }

    @Override // com.qq.e.comm.plugin.q0.u.i
    public String a() {
        return "updateDownloadProgress";
    }

    @Override // com.qq.e.comm.plugin.q0.u.i
    public void a(h hVar, com.qq.e.comm.plugin.q0.s.d dVar) {
        JSONObject d4 = dVar.d();
        if (d4 == null) {
            return;
        }
        k.e().a(d4.optInt("taskId"), d4.optInt("progress"), d4.optLong("totalSize"));
    }

    private f() {
    }
}

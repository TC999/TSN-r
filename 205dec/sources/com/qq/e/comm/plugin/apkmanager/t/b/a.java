package com.qq.e.comm.plugin.apkmanager.t.b;

import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import com.qq.e.comm.plugin.apkmanager.k;
import com.qq.e.comm.plugin.q0.h;
import com.qq.e.comm.plugin.q0.s.e;
import com.qq.e.comm.plugin.q0.u.i;
import com.qq.e.comm.plugin.util.d1;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a extends i {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final a f41893a = new a();
    }

    public static a b() {
        return b.f41893a;
    }

    @Override // com.qq.e.comm.plugin.q0.u.i
    public String a() {
        return "loadDownloadingTask";
    }

    @Override // com.qq.e.comm.plugin.q0.u.i
    public void a(h hVar, com.qq.e.comm.plugin.q0.s.d dVar) {
        List<ApkDownloadTask> d4 = k.e().d();
        if (d4 != null && !d4.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                for (ApkDownloadTask apkDownloadTask : d4) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("taskId", apkDownloadTask.t());
                    jSONObject2.put("logoUrl", apkDownloadTask.k());
                    jSONObject2.put("appName", apkDownloadTask.p());
                    jSONObject2.put("pkgName", apkDownloadTask.r());
                    jSONObject2.put("progress", apkDownloadTask.b("progress"));
                    jSONObject2.put("totalSize", apkDownloadTask.c("totalSize"));
                    jSONObject2.put("status", apkDownloadTask.o());
                    jSONObject2.put("nTag", apkDownloadTask.d("notifyTag"));
                    jSONObject2.put("nId", apkDownloadTask.b("notifyId"));
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("list", jSONArray);
            } catch (JSONException unused) {
                hVar.c().a(new com.qq.e.comm.plugin.q0.s.e(dVar, e.a.f45549d, ""));
                d1.a("LoadDownloadingTask Json Err");
            }
            hVar.c().a(new com.qq.e.comm.plugin.q0.s.e(dVar, e.a.f45548c, jSONObject));
            return;
        }
        hVar.c().a(new com.qq.e.comm.plugin.q0.s.e(dVar, e.a.f45549d, ""));
    }

    private a() {
    }
}

package com.qq.e.comm.plugin.e0.d.i;

import android.content.Context;
import com.qq.e.comm.plugin.util.d0;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.j0;
import com.qq.e.mediation.interfaces.IS2SAdapter;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.e0.d.i.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class RunnableC0809a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f42851c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ b f42852d;

        RunnableC0809a(List list, b bVar) {
            this.f42851c = list;
            this.f42852d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap = new HashMap();
            List list = this.f42851c;
            if (list != null && list.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                for (com.qq.e.comm.plugin.e0.e.d dVar : this.f42851c) {
                    dVar.w();
                    dVar.c(2);
                    jSONArray.put(a.d(dVar));
                    hashMap.put(Integer.valueOf(dVar.a()), dVar);
                }
                this.f42852d.a(jSONArray, hashMap);
                return;
            }
            this.f42852d.a(new JSONArray(), hashMap);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface b {
        void a(JSONArray jSONArray, Map<Integer, com.qq.e.comm.plugin.e0.e.d> map);
    }

    private static String b(com.qq.e.comm.plugin.e0.e.d dVar) {
        try {
            return c(dVar).getSDKVersion();
        } catch (Exception e4) {
            d1.a("BidderTokenProviderFactory", "getAdnSDKVersion error", e4);
            return "";
        }
    }

    private static IS2SAdapter c(com.qq.e.comm.plugin.e0.e.d dVar) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return (IS2SAdapter) Class.forName(dVar.e()).asSubclass(IS2SAdapter.class).getDeclaredConstructor(Context.class, String.class, String.class, String.class).newInstance(com.qq.e.comm.plugin.d0.a.d().a(), dVar.b(), dVar.p(), dVar.j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject d(com.qq.e.comm.plugin.e0.e.d dVar) {
        j0 j0Var = new j0(e(dVar));
        j0Var.a("adnet_id", dVar.a()).a("app_id", dVar.b()).a("placement_id", dVar.p()).a("adnsdk_version", b(dVar));
        j0Var.a("auction_json", new j0(dVar.j()).a().optString("auction_json"));
        return j0Var.a();
    }

    private static JSONObject e(com.qq.e.comm.plugin.e0.e.d dVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("token", c(dVar).getBidderToken(com.qq.e.comm.plugin.d0.a.d().a()));
        } catch (Exception e4) {
            d1.a("BidderTokenProviderFactory", "getToken error", e4);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(List<com.qq.e.comm.plugin.e0.e.d> list, b bVar) {
        d0.f46407c.execute(new RunnableC0809a(list, bVar));
    }
}

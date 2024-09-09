package com.acse.ottn;

import android.app.Activity;
import android.text.TextUtils;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.util.HelpShopAppUtil;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.ObjectStreamException;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class i2 {

    /* renamed from: a  reason: collision with root package name */
    public static i2 f5736a;

    /* renamed from: b  reason: collision with root package name */
    public static Activity f5737b;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements Consumer<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f5738a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f5739b;

        public a(String str, c cVar) {
            this.f5738a = str;
            this.f5739b = cVar;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(String str) throws Exception {
            z1.a("MobclickAgentUtil", "\u7edf\u8ba1\u53d1\u9001\u6210\u529f ==" + this.f5738a);
            if ("heart_beat".equals(this.f5738a)) {
                JSONObject jSONObject = new JSONObject(str);
                g1.a().b("appHeartbeat", p0.d().a());
                g1.a().b("aes_key", jSONObject.getString("aes_key"));
                g1.a().a("send_state", jSONObject.getString("send_state").equals("1"));
                g1.a().a("send_page_read_state", jSONObject.getString("send_page_read_state").equals("1"));
                g1.a().b("show_ad_activity", str);
                g1.a().b("ocr_screen_scroll", jSONObject.getString("ocr_screen_scroll"));
                c cVar = this.f5739b;
                if (cVar != null) {
                    cVar.a();
                }
                z1.a("MobclickAgentUtil", "appStatistics s= " + str);
            } else if ("open_app".equals(this.f5738a)) {
                JSONObject jSONObject2 = new JSONObject(str);
                if (jSONObject2.getInt("code") == 1) {
                    g1.a().b("softkeyboard_content", jSONObject2.getString("content"));
                }
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements Consumer<Throwable> {
        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            z1.a("MobclickAgentUtil", "\u7edf\u8ba1\u53d1\u9001\u5931\u8d25 throwable =" + th.getMessage());
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface c {
        void a();
    }

    public static i2 a() {
        if (f5736a == null) {
            synchronized (i2.class) {
                if (f5736a == null) {
                    f5736a = new i2();
                }
            }
        }
        return f5736a;
    }

    public final Object b() throws ObjectStreamException {
        return f5736a;
    }

    public void b(String str, String str2) {
        if (TextUtils.isEmpty(HelpShopAppUtil.getHmKey())) {
            return;
        }
        HelpShopAppUtil.getInstance();
        if (TextUtils.isEmpty(HelpShopAppUtil.sessionID())) {
            return;
        }
        a(str, str2, null);
    }

    public void b(String str, String str2, c cVar) {
        if (TextUtils.isEmpty(HelpShopAppUtil.getHmKey())) {
            return;
        }
        HelpShopAppUtil.getInstance();
        if (TextUtils.isEmpty(HelpShopAppUtil.sessionID())) {
            return;
        }
        a(str, str2, cVar);
    }

    public void a(Activity activity) {
        f5737b = activity;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(HelpShopAppUtil.getHmKey())) {
            return;
        }
        HelpShopAppUtil.getInstance();
        if (TextUtils.isEmpty(HelpShopAppUtil.sessionID())) {
            return;
        }
        a(str, null, null);
    }

    public static Map<String, String> a(String str, String str2) {
        TreeMap treeMap = new TreeMap();
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionID());
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        treeMap.put("open_all_permission", AcseHelpManager.isOPenAllPermission() ? "1" : "0");
        treeMap.put("flow_permission", com.acse.ottn.b.d().b() ? "1" : "0");
        treeMap.put("accessiblity_permission", com.acse.ottn.b.d().f() ? "1" : "0");
        treeMap.put("battery_permission", g1.a().a("open_battery_white") ? "1" : "0");
        treeMap.put("statistics_type", str);
        treeMap.put("mobile_id", c4.o());
        if ("heart_beat".equals(str)) {
            treeMap.put("is_snt", "2");
        } else {
            treeMap.put("is_snt", "0");
        }
        if (!TextUtils.isEmpty(str2)) {
            treeMap.put("accessiblity_list", str2);
        }
        treeMap.put("mobile", c4.b());
        treeMap.put("mobile_version_release", j0.f5783y);
        treeMap.put("app_versione", j0.f5782x);
        treeMap.put("app_system_model", c4.d());
        treeMap.put("time", System.currentTimeMillis() + "");
        treeMap.put("system_model", c4.p());
        return treeMap;
    }

    public final void a(String str, String str2, c cVar) {
        z1.a("MobclickAgentUtil", "\u57cb\u70b9");
        new f0().a(q0.a().a(a(str, str2), str)).subscribeOn(Schedulers.newThread()).observeOn(h.a()).subscribe(new a(str, cVar), new b());
    }
}

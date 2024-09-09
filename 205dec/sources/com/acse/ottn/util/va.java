package com.acse.ottn.util;

import android.app.Activity;
import android.text.TextUtils;
import com.acse.ottn.activity.AcseHelpManager;
import io.reactivex.schedulers.Schedulers;
import java.io.ObjectStreamException;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class va {

    /* renamed from: a  reason: collision with root package name */
    private static va f6891a;

    /* renamed from: b  reason: collision with root package name */
    private static Activity f6892b;

    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public interface a {
        void onSuccess();
    }

    private va() {
    }

    public static va a() {
        if (f6891a == null) {
            synchronized (va.class) {
                if (f6891a == null) {
                    f6891a = new va();
                }
            }
        }
        return f6891a;
    }

    private Object b() throws ObjectStreamException {
        return f6891a;
    }

    private static Map<String, String> b(String str) {
        TreeMap treeMap = new TreeMap();
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionID());
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        treeMap.put("open_all_permission", AcseHelpManager.isOPenAllPermission() ? "1" : "0");
        treeMap.put("flow_permission", C1442n.c().b() ? "1" : "0");
        treeMap.put("accessiblity_permission", C1442n.c().e() ? "1" : "0");
        treeMap.put("battery_permission", C1419ba.a().a("open_battery_white") ? "1" : "0");
        treeMap.put("statistics_type", str);
        treeMap.put("package_name", HelpShopAppUtil.getContext().getPackageName());
        treeMap.put("mobile_id", Ka.o());
        if ("heart_beat".equals(str)) {
            treeMap.put("is_snt", "2");
        } else {
            treeMap.put("is_snt", "0");
        }
        treeMap.put("mobile", Ka.b());
        treeMap.put("mobile_version_release", CommonUtil.CURRECT_SYSTEM_VERSION);
        treeMap.put("app_versione", CommonUtil.CURRECT_APP_VERSION);
        treeMap.put("app_system_model", Ka.d());
        treeMap.put("time", System.currentTimeMillis() + "");
        treeMap.put("system_model", Ka.p());
        return treeMap;
    }

    private void b(String str, a aVar) {
        ra.a("MobclickAgentUtil", "\u57cb\u70b9");
        new com.acse.ottn.a.a().a(V.a().a(b(str), str)).subscribeOn(Schedulers.newThread()).observeOn(F.a()).subscribe(new ta(this, str, aVar), new ua(this));
    }

    public void a(Activity activity) {
        f6892b = activity;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(HelpShopAppUtil.getHmKey())) {
            return;
        }
        HelpShopAppUtil.getInstance();
        if (TextUtils.isEmpty(HelpShopAppUtil.sessionID())) {
            return;
        }
        b(str, null);
    }

    public void a(String str, a aVar) {
        if (TextUtils.isEmpty(HelpShopAppUtil.getHmKey())) {
            return;
        }
        HelpShopAppUtil.getInstance();
        if (TextUtils.isEmpty(HelpShopAppUtil.sessionID())) {
            return;
        }
        b(str, aVar);
    }
}

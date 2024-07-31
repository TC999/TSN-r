package com.acse.ottn.util;

import android.app.Activity;
import android.text.TextUtils;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.p030a.C1249a;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import io.netty.handler.codec.rtsp.RtspHeaders;
import io.reactivex.schedulers.Schedulers;
import java.io.ObjectStreamException;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.acse.ottn.util.va */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1703va {

    /* renamed from: a */
    private static C1703va f3381a;

    /* renamed from: b */
    private static Activity f3382b;

    /* renamed from: com.acse.ottn.util.va$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1704a {
        void onSuccess();
    }

    private C1703va() {
    }

    /* renamed from: a */
    public static C1703va m55903a() {
        if (f3381a == null) {
            synchronized (C1703va.class) {
                if (f3381a == null) {
                    f3381a = new C1703va();
                }
            }
        }
        return f3381a;
    }

    /* renamed from: b */
    private Object m55899b() throws ObjectStreamException {
        return f3381a;
    }

    /* renamed from: b */
    private static Map<String, String> m55898b(String str) {
        TreeMap treeMap = new TreeMap();
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionID());
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        treeMap.put("open_all_permission", AcseHelpManager.isOPenAllPermission() ? "1" : "0");
        treeMap.put("flow_permission", C1684n.m55975c().m55984b() ? "1" : "0");
        treeMap.put("accessiblity_permission", C1684n.m55975c().m55965e() ? "1" : "0");
        treeMap.put("battery_permission", C1661ba.m56097a().m56096a("open_battery_white") ? "1" : "0");
        treeMap.put("statistics_type", str);
        treeMap.put("package_name", HelpShopAppUtil.getContext().getPackageName());
        treeMap.put("mobile_id", C1638Ka.m56178o());
        if ("heart_beat".equals(str)) {
            treeMap.put("is_snt", "2");
        } else {
            treeMap.put("is_snt", "0");
        }
        treeMap.put("mobile", C1638Ka.m56193b());
        treeMap.put("mobile_version_release", CommonUtil.CURRECT_SYSTEM_VERSION);
        treeMap.put("app_versione", CommonUtil.CURRECT_APP_VERSION);
        treeMap.put("app_system_model", C1638Ka.m56189d());
        treeMap.put(RtspHeaders.Values.TIME, System.currentTimeMillis() + "");
        treeMap.put("system_model", C1638Ka.m56177p());
        return treeMap;
    }

    /* renamed from: b */
    private void m55897b(String str, InterfaceC1704a interfaceC1704a) {
        C1694ra.m55917a("MobclickAgentUtil", "埋点");
        new C1249a().m57376a(C1652V.m56140a().m56134a(m55898b(str), str)).subscribeOn(Schedulers.newThread()).observeOn(ExecutorC1627F.m56271a()).subscribe(new C1699ta(this, str, interfaceC1704a), new C1701ua(this));
    }

    /* renamed from: a */
    public void m55902a(Activity activity) {
        f3382b = activity;
    }

    /* renamed from: a */
    public void m55901a(String str) {
        if (TextUtils.isEmpty(HelpShopAppUtil.getHmKey())) {
            return;
        }
        HelpShopAppUtil.getInstance();
        if (TextUtils.isEmpty(HelpShopAppUtil.sessionID())) {
            return;
        }
        m55897b(str, null);
    }

    /* renamed from: a */
    public void m55900a(String str, InterfaceC1704a interfaceC1704a) {
        if (TextUtils.isEmpty(HelpShopAppUtil.getHmKey())) {
            return;
        }
        HelpShopAppUtil.getInstance();
        if (TextUtils.isEmpty(HelpShopAppUtil.sessionID())) {
            return;
        }
        m55897b(str, interfaceC1704a);
    }
}

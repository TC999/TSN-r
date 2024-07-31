package com.acse.ottn.util;

import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.p030a.C1249a;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.google.gson.Gson;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import io.reactivex.schedulers.Schedulers;
import java.io.ObjectStreamException;
import java.util.TreeMap;

/* renamed from: com.acse.ottn.util.na */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1685na {

    /* renamed from: a */
    private static C1685na f3350a;

    /* renamed from: com.acse.ottn.util.na$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1686a {
        /* renamed from: a */
        void m55940a(boolean z);
    }

    private C1685na() {
    }

    /* renamed from: b */
    public static C1685na m55943b() {
        if (f3350a == null) {
            synchronized (C1685na.class) {
                if (f3350a == null) {
                    f3350a = new C1685na();
                }
            }
        }
        return f3350a;
    }

    /* renamed from: c */
    private Object m55941c() throws ObjectStreamException {
        return f3350a;
    }

    /* renamed from: a */
    public void m55947a() {
        TreeMap treeMap = new TreeMap();
        new Gson();
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        treeMap.put(UMCommonContent.f37751H, C1638Ka.m56184i());
        treeMap.put("device_product", C1638Ka.m56183j());
        treeMap.put(UMCommonContent.f37749F, C1638Ka.m56193b());
        treeMap.put("system_model", C1638Ka.m56177p());
        treeMap.put(UMCommonContent.f37748E, C1638Ka.m56195a());
        treeMap.put("device_device", C1638Ka.m56189d());
        treeMap.put("device_fubgerprint", C1638Ka.m56187f());
        treeMap.put("device_SDK", C1638Ka.m56182k() + "");
        treeMap.put("system_version", C1661ba.m56097a().m56086d("getSystemVersion"));
        treeMap.put("plunin_version", "0");
        treeMap.put("is_snt", "0");
        new C1249a().m57372e(C1652V.m56140a().m56134a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(ExecutorC1627F.m56271a()).subscribe(new C1667ea(this), new C1669fa(this));
    }

    /* renamed from: a */
    public void m55946a(AcseHelpManager.OnOpenPermission onOpenPermission) {
        TreeMap treeMap = new TreeMap();
        new Gson();
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        treeMap.put(UMCommonContent.f37751H, C1638Ka.m56184i());
        treeMap.put("device_product", C1638Ka.m56183j());
        treeMap.put(UMCommonContent.f37749F, C1638Ka.m56193b());
        treeMap.put("system_model", C1638Ka.m56177p());
        treeMap.put(UMCommonContent.f37748E, C1638Ka.m56195a());
        treeMap.put("device_device", C1638Ka.m56189d());
        treeMap.put("device_fubgerprint", C1638Ka.m56187f());
        treeMap.put("device_SDK", C1638Ka.m56182k() + "");
        treeMap.put("system_version", C1661ba.m56097a().m56086d("getSystemVersion"));
        treeMap.put("plunin_version", C1688oa.m55939a().m55935a(HelpShopAppUtil.getContext().getPackageName()).getVersion());
        treeMap.put("is_snt", "0");
        new C1249a().m57369h(C1652V.m56140a().m56134a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(ExecutorC1627F.m56271a()).subscribe(new C1675ia(this, onOpenPermission), new C1677ja(this, onOpenPermission));
    }

    /* renamed from: a */
    public void m55945a(InterfaceC1686a interfaceC1686a) {
        TreeMap treeMap = new TreeMap();
        new Gson();
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        new C1249a().m57363n(C1652V.m56140a().m56134a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(ExecutorC1627F.m56271a()).subscribe(new C1683ma(this, interfaceC1686a), new C1665da(this, interfaceC1686a));
    }

    /* renamed from: a */
    public void m55944a(String str) {
        TreeMap treeMap = new TreeMap();
        new Gson();
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        treeMap.put(ConstantHelper.LOG_VS, C1688oa.m55939a().m55935a(HelpShopAppUtil.getContext().getPackageName()).getVersion());
        treeMap.put("is_snt", "0");
        treeMap.put("state", str);
        new C1249a().m57373d(C1652V.m56140a().m56134a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(ExecutorC1627F.m56271a()).subscribe(new C1679ka(this, str), new C1681la(this));
    }

    /* renamed from: b */
    public void m55942b(AcseHelpManager.OnOpenPermission onOpenPermission) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        treeMap.put(UMCommonContent.f37751H, C1638Ka.m56184i());
        treeMap.put("device_product", C1638Ka.m56183j());
        treeMap.put(UMCommonContent.f37749F, C1638Ka.m56193b());
        treeMap.put("system_model", C1638Ka.m56177p());
        treeMap.put(UMCommonContent.f37748E, C1638Ka.m56195a());
        treeMap.put("device_device", C1638Ka.m56189d());
        treeMap.put("device_fubgerprint", C1638Ka.m56187f());
        treeMap.put("device_SDK", C1638Ka.m56182k() + "");
        treeMap.put("system_version", C1661ba.m56097a().m56086d("getSystemVersion"));
        treeMap.put("plunin_version", C1688oa.m55939a().m55935a(HelpShopAppUtil.getContext().getPackageName()).getVersion());
        treeMap.put("is_snt", "0");
        new C1249a().m57365l(C1652V.m56140a().m56134a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(ExecutorC1627F.m56271a()).subscribe(new C1671ga(this, onOpenPermission), new C1673ha(this, onOpenPermission));
    }
}

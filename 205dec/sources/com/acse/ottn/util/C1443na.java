package com.acse.ottn.util;

import com.acse.ottn.activity.AcseHelpManager;
import com.google.gson.Gson;
import io.reactivex.schedulers.Schedulers;
import java.io.ObjectStreamException;
import java.util.TreeMap;

/* renamed from: com.acse.ottn.util.na  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class C1443na {

    /* renamed from: a  reason: collision with root package name */
    private static C1443na f6860a;

    /* renamed from: com.acse.ottn.util.na$a */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public interface a {
        void a(boolean z3);
    }

    private C1443na() {
    }

    public static C1443na b() {
        if (f6860a == null) {
            synchronized (C1443na.class) {
                if (f6860a == null) {
                    f6860a = new C1443na();
                }
            }
        }
        return f6860a;
    }

    private Object c() throws ObjectStreamException {
        return f6860a;
    }

    public void a() {
        TreeMap treeMap = new TreeMap();
        new Gson();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        treeMap.put("device_manufacturer", Ka.i());
        treeMap.put("device_product", Ka.j());
        treeMap.put("device_brand", Ka.b());
        treeMap.put("system_model", Ka.p());
        treeMap.put("device_board", Ka.a());
        treeMap.put("device_device", Ka.d());
        treeMap.put("device_fubgerprint", Ka.f());
        treeMap.put("device_SDK", Ka.k() + "");
        treeMap.put("system_version", C1419ba.a().d("getSystemVersion"));
        treeMap.put("plunin_version", "0");
        treeMap.put("is_snt", "0");
        new com.acse.ottn.a.a().e(V.a().a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(F.a()).subscribe(new C1425ea(this), new C1427fa(this));
    }

    public void a(AcseHelpManager.OnOpenPermission onOpenPermission) {
        TreeMap treeMap = new TreeMap();
        new Gson();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        treeMap.put("device_manufacturer", Ka.i());
        treeMap.put("device_product", Ka.j());
        treeMap.put("device_brand", Ka.b());
        treeMap.put("system_model", Ka.p());
        treeMap.put("device_board", Ka.a());
        treeMap.put("device_device", Ka.d());
        treeMap.put("device_fubgerprint", Ka.f());
        treeMap.put("device_SDK", Ka.k() + "");
        treeMap.put("system_version", C1419ba.a().d("getSystemVersion"));
        treeMap.put("plunin_version", oa.a().a(HelpShopAppUtil.getContext().getPackageName()).getVersion());
        treeMap.put("is_snt", "0");
        new com.acse.ottn.a.a().h(V.a().a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(F.a()).subscribe(new C1433ia(this, onOpenPermission), new C1435ja(this, onOpenPermission));
    }

    public void a(a aVar) {
        TreeMap treeMap = new TreeMap();
        new Gson();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        new com.acse.ottn.a.a().n(V.a().a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(F.a()).subscribe(new C1441ma(this, aVar), new C1423da(this, aVar));
    }

    public void a(String str) {
        TreeMap treeMap = new TreeMap();
        new Gson();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        treeMap.put("version", oa.a().a(HelpShopAppUtil.getContext().getPackageName()).getVersion());
        treeMap.put("is_snt", "0");
        treeMap.put("state", str);
        new com.acse.ottn.a.a().d(V.a().a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(F.a()).subscribe(new C1437ka(this, str), new C1439la(this));
    }

    public void b(AcseHelpManager.OnOpenPermission onOpenPermission) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        treeMap.put("device_manufacturer", Ka.i());
        treeMap.put("device_product", Ka.j());
        treeMap.put("device_brand", Ka.b());
        treeMap.put("system_model", Ka.p());
        treeMap.put("device_board", Ka.a());
        treeMap.put("device_device", Ka.d());
        treeMap.put("device_fubgerprint", Ka.f());
        treeMap.put("device_SDK", Ka.k() + "");
        treeMap.put("system_version", C1419ba.a().d("getSystemVersion"));
        treeMap.put("plunin_version", oa.a().a(HelpShopAppUtil.getContext().getPackageName()).getVersion());
        treeMap.put("is_snt", "0");
        new com.acse.ottn.a.a().l(V.a().a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(F.a()).subscribe(new C1429ga(this, onOpenPermission), new C1431ha(this, onOpenPermission));
    }
}

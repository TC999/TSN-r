package com.acse.ottn.util;

import android.view.accessibility.AccessibilityEvent;
import com.acse.ottn.model.AccessiblityModel;
import io.reactivex.schedulers.Schedulers;
import java.io.ObjectStreamException;
import java.util.TreeMap;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class D {

    /* renamed from: a  reason: collision with root package name */
    private static D f6711a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f6712b = "acse_ShopHelperService";

    private D() {
    }

    public static D c() {
        if (f6711a == null) {
            synchronized (D.class) {
                if (f6711a == null) {
                    f6711a = new D();
                }
            }
        }
        return f6711a;
    }

    private Object d() throws ObjectStreamException {
        return f6711a;
    }

    public void a(AccessibilityEvent accessibilityEvent) {
    }

    public void a(AccessiblityModel accessiblityModel) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        treeMap.put("para", accessiblityModel.getData().getCoupon_activity_name());
        treeMap.put("app", accessiblityModel.getData().getPackage_name());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        treeMap.put("is_snt", "0");
        new com.acse.ottn.a.c().c(V.a().a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(F.a()).subscribe(new B(this), new C(this));
    }

    public void b() {
    }
}

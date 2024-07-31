package com.acse.ottn.util;

import android.view.accessibility.AccessibilityEvent;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.p030a.C1252c;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import io.reactivex.schedulers.Schedulers;
import java.io.ObjectStreamException;
import java.util.TreeMap;

/* renamed from: com.acse.ottn.util.D */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1623D {

    /* renamed from: a */
    private static C1623D f3138a = null;

    /* renamed from: b */
    private static String f3139b = "acse_ShopHelperService";

    private C1623D() {
    }

    /* renamed from: c */
    public static C1623D m56293c() {
        if (f3138a == null) {
            synchronized (C1623D.class) {
                if (f3138a == null) {
                    f3138a = new C1623D();
                }
            }
        }
        return f3138a;
    }

    /* renamed from: d */
    private Object m56292d() throws ObjectStreamException {
        return f3138a;
    }

    /* renamed from: a */
    public void m56296a(AccessibilityEvent accessibilityEvent) {
    }

    /* renamed from: a */
    public void m56295a(AccessiblityModel accessiblityModel) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        treeMap.put("para", accessiblityModel.getData().getCoupon_activity_name());
        treeMap.put(Constants.JumpUrlConstants.SRC_TYPE_APP, accessiblityModel.getData().getPackage_name());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        treeMap.put("is_snt", "0");
        new C1252c().m57357c(C1652V.m56140a().m56134a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(ExecutorC1627F.m56271a()).subscribe(new C1619B(this), new C1621C(this));
    }

    /* renamed from: b */
    public void m56294b() {
    }
}

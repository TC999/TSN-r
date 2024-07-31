package com.acse.ottn.util;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.p030a.C1252c;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.google.gson.Gson;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import io.reactivex.schedulers.Schedulers;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/* renamed from: com.acse.ottn.util.Da */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1624Da {

    /* renamed from: a */
    private static C1624Da f3140a = null;

    /* renamed from: b */
    private static String f3141b = "ScrolledReadUtil";

    /* renamed from: c */
    private List<String> f3142c;

    /* renamed from: d */
    int f3143d = 0;

    private C1624Da() {
    }

    /* renamed from: a */
    private void m56289a(AccessibilityService accessibilityService, List<String> list, String str, String str2) {
        String str3 = f3141b;
        C1694ra.m55917a(str3, "current packageName  =" + str2);
        if (!C1684n.m55975c().m55984b() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        TreeMap treeMap = new TreeMap();
        Gson gson = new Gson();
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        treeMap.put(Constants.JumpUrlConstants.SRC_TYPE_APP, str);
        HelpShopAppUtil.getInstance();
        treeMap.put("marker", HelpShopAppUtil.sessionNewID());
        if (list != null) {
            treeMap.put("data", gson.toJson(list));
            String str4 = f3141b;
            C1694ra.m55917a(str4, "getCouponInfo string =" + gson.toJson(list));
        } else {
            treeMap.put("data", "");
        }
        treeMap.put("product_info", C1661ba.m56097a().m56086d("goods_info"));
        treeMap.put("new_version", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO);
        treeMap.put("coupon_type", C1652V.m56140a().m56122g(str));
        treeMap.put("genuine_packagename", str2);
        treeMap.put(UMCommonContent.f37749F, C1638Ka.m56193b());
        treeMap.put("is_snt", CommonUtil.SNT_VERSION);
        treeMap.put(ConstantHelper.LOG_VS, CommonUtil.CURRECT_APP_VERSION);
        new C1252c().m57356d(C1652V.m56140a().m56134a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(ExecutorC1627F.m56271a()).subscribe(new C1620Ba(this, str), new C1622Ca(this));
    }

    /* renamed from: b */
    public static C1624Da m56285b() {
        if (f3140a == null) {
            synchronized (C1624Da.class) {
                if (f3140a == null) {
                    f3140a = new C1624Da();
                }
            }
        }
        return f3140a;
    }

    /* renamed from: c */
    private Object m56284c() throws ObjectStreamException {
        return f3140a;
    }

    /* renamed from: a */
    public void m56290a(AccessibilityService accessibilityService, String str, String str2) {
        List<String> list = this.f3142c;
        if (list != null) {
            list.removeAll(list);
            this.f3142c = null;
        }
        this.f3142c = new ArrayList();
        m56288a(accessibilityService.getRootInActiveWindow());
        if (m56286a(this.f3142c)) {
            C1661ba.m56097a().m56088b("scroll_state", CommonUtil.SCROLLED_SCREEN_CALCLE);
            m56289a(accessibilityService, this.f3142c, str, str2);
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void m56288a(AccessibilityNodeInfo accessibilityNodeInfo) {
        String trim;
        ArrayList arrayList;
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getChildCount() != 0) {
            if (accessibilityNodeInfo != null) {
                for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                    if (accessibilityNodeInfo.getChild(i) != null) {
                        m56288a(accessibilityNodeInfo.getChild(i));
                    }
                }
                return;
            }
            return;
        }
        C1694ra.m55917a("zkj_samon", "info" + accessibilityNodeInfo.toString());
        if (accessibilityNodeInfo.getText() != null) {
            if (accessibilityNodeInfo.getText().length() >= 25 || accessibilityNodeInfo.getText().length() <= 2) {
                return;
            }
            trim = accessibilityNodeInfo.getText().toString().trim();
            this.f3143d = C1652V.m56140a().m56137a(trim, this.f3143d);
            if (!C1652V.m56140a().m56139a(this.f3143d)) {
                List<String> list = this.f3142c;
                if (list != null) {
                    list.removeAll(list);
                    this.f3142c = null;
                    this.f3143d = 0;
                    arrayList = new ArrayList();
                    this.f3142c = arrayList;
                    C1661ba.m56097a().m56088b("scroll_state", "0");
                    return;
                }
                return;
            }
            this.f3142c.add(trim);
        } else if (accessibilityNodeInfo.getContentDescription() != null && accessibilityNodeInfo.getContentDescription().length() < 25 && accessibilityNodeInfo.getContentDescription().length() > 2) {
            trim = accessibilityNodeInfo.getContentDescription().toString().trim();
            this.f3143d = C1652V.m56140a().m56137a(trim, this.f3143d);
            if (!C1652V.m56140a().m56139a(this.f3143d)) {
                List<String> list2 = this.f3142c;
                if (list2 != null) {
                    list2.removeAll(list2);
                    this.f3142c = null;
                    this.f3143d = 0;
                    arrayList = new ArrayList();
                    this.f3142c = arrayList;
                    C1661ba.m56097a().m56088b("scroll_state", "0");
                    return;
                }
                return;
            }
            this.f3142c.add(trim);
        }
    }

    /* renamed from: a */
    public boolean m56286a(List<String> list) {
        if (list == null || list.size() == 0) {
            C1694ra.m55917a(f3141b, "lists = null");
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).trim().equals("进店逛逛") || list.get(i).trim().equals("天猫国际") || list.get(i).trim().equals("去频道逛逛")) {
                C1694ra.m55917a("zkj_samon", "包含");
                return true;
            }
        }
        return false;
    }
}

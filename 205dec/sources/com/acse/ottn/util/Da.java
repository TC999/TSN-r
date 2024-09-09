package com.acse.ottn.util;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.gson.Gson;
import io.reactivex.schedulers.Schedulers;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class Da {

    /* renamed from: a  reason: collision with root package name */
    private static Da f6713a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f6714b = "ScrolledReadUtil";

    /* renamed from: c  reason: collision with root package name */
    private List<String> f6715c;

    /* renamed from: d  reason: collision with root package name */
    int f6716d = 0;

    private Da() {
    }

    private void a(AccessibilityService accessibilityService, List<String> list, String str, String str2) {
        String str3 = f6714b;
        ra.a(str3, "current packageName  =" + str2);
        if (!C1442n.c().b() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        TreeMap treeMap = new TreeMap();
        Gson gson = new Gson();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        treeMap.put("app", str);
        HelpShopAppUtil.getInstance();
        treeMap.put("marker", HelpShopAppUtil.sessionNewID());
        if (list != null) {
            treeMap.put("data", gson.toJson(list));
            String str4 = f6714b;
            ra.a(str4, "getCouponInfo string =" + gson.toJson(list));
        } else {
            treeMap.put("data", "");
        }
        treeMap.put("product_info", C1419ba.a().d("goods_info"));
        treeMap.put("new_version", "8");
        treeMap.put("coupon_type", V.a().g(str));
        treeMap.put("genuine_packagename", str2);
        treeMap.put("device_brand", Ka.b());
        treeMap.put("is_snt", CommonUtil.SNT_VERSION);
        treeMap.put("version", CommonUtil.CURRECT_APP_VERSION);
        new com.acse.ottn.a.c().d(V.a().a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(F.a()).subscribe(new Ba(this, str), new Ca(this));
    }

    public static Da b() {
        if (f6713a == null) {
            synchronized (Da.class) {
                if (f6713a == null) {
                    f6713a = new Da();
                }
            }
        }
        return f6713a;
    }

    private Object c() throws ObjectStreamException {
        return f6713a;
    }

    public void a(AccessibilityService accessibilityService, String str, String str2) {
        List<String> list = this.f6715c;
        if (list != null) {
            list.removeAll(list);
            this.f6715c = null;
        }
        this.f6715c = new ArrayList();
        a(accessibilityService.getRootInActiveWindow());
        if (a(this.f6715c)) {
            C1419ba.a().b("scroll_state", CommonUtil.SCROLLED_SCREEN_CALCLE);
            a(accessibilityService, this.f6715c, str, str2);
        }
    }

    @SuppressLint({"NewApi"})
    public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        String trim;
        ArrayList arrayList;
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getChildCount() != 0) {
            if (accessibilityNodeInfo != null) {
                for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                    if (accessibilityNodeInfo.getChild(i4) != null) {
                        a(accessibilityNodeInfo.getChild(i4));
                    }
                }
                return;
            }
            return;
        }
        ra.a("zkj_samon", "info" + accessibilityNodeInfo.toString());
        if (accessibilityNodeInfo.getText() != null) {
            if (accessibilityNodeInfo.getText().length() >= 25 || accessibilityNodeInfo.getText().length() <= 2) {
                return;
            }
            trim = accessibilityNodeInfo.getText().toString().trim();
            this.f6716d = V.a().a(trim, this.f6716d);
            if (!V.a().a(this.f6716d)) {
                List<String> list = this.f6715c;
                if (list != null) {
                    list.removeAll(list);
                    this.f6715c = null;
                    this.f6716d = 0;
                    arrayList = new ArrayList();
                    this.f6715c = arrayList;
                    C1419ba.a().b("scroll_state", "0");
                    return;
                }
                return;
            }
            this.f6715c.add(trim);
        } else if (accessibilityNodeInfo.getContentDescription() != null && accessibilityNodeInfo.getContentDescription().length() < 25 && accessibilityNodeInfo.getContentDescription().length() > 2) {
            trim = accessibilityNodeInfo.getContentDescription().toString().trim();
            this.f6716d = V.a().a(trim, this.f6716d);
            if (!V.a().a(this.f6716d)) {
                List<String> list2 = this.f6715c;
                if (list2 != null) {
                    list2.removeAll(list2);
                    this.f6715c = null;
                    this.f6716d = 0;
                    arrayList = new ArrayList();
                    this.f6715c = arrayList;
                    C1419ba.a().b("scroll_state", "0");
                    return;
                }
                return;
            }
            this.f6715c.add(trim);
        }
    }

    public boolean a(List<String> list) {
        if (list == null || list.size() == 0) {
            ra.a(f6714b, "lists = null");
            return false;
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (list.get(i4).trim().equals("\u8fdb\u5e97\u901b\u901b") || list.get(i4).trim().equals("\u5929\u732b\u56fd\u9645") || list.get(i4).trim().equals("\u53bb\u9891\u9053\u901b\u901b")) {
                ra.a("zkj_samon", "\u5305\u542b");
                return true;
            }
        }
        return false;
    }
}

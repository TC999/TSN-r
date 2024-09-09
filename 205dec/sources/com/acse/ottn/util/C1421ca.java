package com.acse.ottn.util;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.acse.ottn.util.ca  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class C1421ca {

    /* renamed from: a  reason: collision with root package name */
    private static C1421ca f6813a;

    /* renamed from: b  reason: collision with root package name */
    private List<HashMap<String, String>> f6814b = new ArrayList();

    private C1421ca() {
    }

    public static C1421ca c() {
        if (f6813a == null) {
            synchronized (C1421ca.class) {
                if (f6813a == null) {
                    f6813a = new C1421ca();
                }
            }
        }
        return f6813a;
    }

    private Object g() throws ObjectStreamException {
        return f6813a;
    }

    public String a() {
        if (C1419ba.a() == null) {
            return CommonUtil.CURRENT_ACCESSIBLITY_OPEN;
        }
        String d4 = C1419ba.a().d("accessiblity_state");
        return TextUtils.isEmpty(d4) ? CommonUtil.CURRENT_ACCESSIBLITY_OPEN : d4;
    }

    public void a(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i4 = displayMetrics.widthPixels;
        int i5 = displayMetrics.heightPixels;
        if (C1419ba.a() != null) {
            C1419ba.a().b("screenWidth", i4);
            C1419ba.a().b("screenHight", i5);
        }
    }

    public void a(String str) {
        if (C1419ba.a() == null) {
            return;
        }
        C1419ba.a().b("accessiblity_state", str);
    }

    public void a(List<HashMap<String, String>> list) {
        this.f6814b = list;
    }

    public String b() {
        try {
            if (HelpShopAppUtil.getContext() == null) {
                return "demo";
            }
            PackageManager packageManager = HelpShopAppUtil.getContext().getPackageManager();
            return packageManager.getPackageInfo(HelpShopAppUtil.getContext().getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public List<HashMap<String, String>> d() {
        return this.f6814b;
    }

    public boolean e() {
        return "huawei".equals(Ka.b()) || "honor".equals(Ka.b()) || "tdtech".equals(Ka.b()) || "ptac".equals(Ka.b()) || "tyh612m".equals(Ka.p()) || Ka.s();
    }

    public boolean f() {
        return e() || "oppo".equals(Ka.b()) || "vivo".equals(Ka.b()) || "xiaomi".equals(Ka.b()) || "redmi".equals(Ka.b()) || "realme".equals(Ka.b()) || "oneplus".equals(Ka.b()) || "blackshark".equals(Ka.b()) || "samsung".equals(Ka.b());
    }
}

package com.acse.ottn.util;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bxkj.student.C4229c;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.acse.ottn.util.ca */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1663ca {

    /* renamed from: a */
    private static C1663ca f3303a;

    /* renamed from: b */
    private List<HashMap<String, String>> f3304b = new ArrayList();

    private C1663ca() {
    }

    /* renamed from: c */
    public static C1663ca m56080c() {
        if (f3303a == null) {
            synchronized (C1663ca.class) {
                if (f3303a == null) {
                    f3303a = new C1663ca();
                }
            }
        }
        return f3303a;
    }

    /* renamed from: g */
    private Object m56076g() throws ObjectStreamException {
        return f3303a;
    }

    /* renamed from: a */
    public String m56085a() {
        if (C1661ba.m56097a() == null) {
            return CommonUtil.CURRENT_ACCESSIBLITY_OPEN;
        }
        String m56086d = C1661ba.m56097a().m56086d("accessiblity_state");
        return TextUtils.isEmpty(m56086d) ? CommonUtil.CURRENT_ACCESSIBLITY_OPEN : m56086d;
    }

    /* renamed from: a */
    public void m56084a(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        if (C1661ba.m56097a() != null) {
            C1661ba.m56097a().m56089b("screenWidth", i);
            C1661ba.m56097a().m56089b("screenHight", i2);
        }
    }

    /* renamed from: a */
    public void m56083a(String str) {
        if (C1661ba.m56097a() == null) {
            return;
        }
        C1661ba.m56097a().m56088b("accessiblity_state", str);
    }

    /* renamed from: a */
    public void m56082a(List<HashMap<String, String>> list) {
        this.f3304b = list;
    }

    /* renamed from: b */
    public String m56081b() {
        try {
            if (HelpShopAppUtil.getContext() == null) {
                return "demo";
            }
            PackageManager packageManager = HelpShopAppUtil.getContext().getPackageManager();
            return packageManager.getPackageInfo(HelpShopAppUtil.getContext().getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: d */
    public List<HashMap<String, String>> m56079d() {
        return this.f3304b;
    }

    /* renamed from: e */
    public boolean m56078e() {
        return "huawei".equals(C1638Ka.m56193b()) || "honor".equals(C1638Ka.m56193b()) || "tdtech".equals(C1638Ka.m56193b()) || "ptac".equals(C1638Ka.m56193b()) || "tyh612m".equals(C1638Ka.m56177p()) || C1638Ka.m56174s();
    }

    /* renamed from: f */
    public boolean m56077f() {
        return m56078e() || "oppo".equals(C1638Ka.m56193b()) || "vivo".equals(C1638Ka.m56193b()) || C4229c.f16088d.equals(C1638Ka.m56193b()) || "redmi".equals(C1638Ka.m56193b()) || "realme".equals(C1638Ka.m56193b()) || "oneplus".equals(C1638Ka.m56193b()) || "blackshark".equals(C1638Ka.m56193b()) || "samsung".equals(C1638Ka.m56193b());
    }
}

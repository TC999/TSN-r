package com.acse.ottn.util;

import android.text.TextUtils;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.model.AdPackageModel;
import com.acse.ottn.model.PageSettingTypeModel;
import com.acse.ottn.model.ShowWindowModel;
import com.google.gson.Gson;
import java.io.ObjectStreamException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* renamed from: com.acse.ottn.util.V */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1652V {

    /* renamed from: a */
    private static C1652V f3279a = null;

    /* renamed from: b */
    private static String f3280b = "V";

    private C1652V() {
    }

    /* renamed from: a */
    public static C1652V m56140a() {
        if (f3279a == null) {
            synchronized (C1652V.class) {
                if (f3279a == null) {
                    f3279a = new C1652V();
                }
            }
        }
        return f3279a;
    }

    /* renamed from: c */
    private Object m56128c() throws ObjectStreamException {
        return f3279a;
    }

    /* renamed from: h */
    private boolean m56121h(String str) {
        return str.matches(".*\\d+.*");
    }

    /* renamed from: a */
    public int m56137a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        int length = str.length();
        if (length < 2048) {
            length += i;
        }
        String str2 = f3280b;
        C1694ra.m55917a(str2, "总长度=" + length);
        return length;
    }

    /* renamed from: a */
    public PageSettingTypeModel m56138a(String str) {
        String str2 = f3280b;
        C1694ra.m55917a(str2, "getCurrentPageSettingData json =" + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (PageSettingTypeModel) new Gson().fromJson(str, (Class<Object>) PageSettingTypeModel.class);
    }

    /* renamed from: a */
    public RequestBody m56134a(Map map, String str) {
        StringBuilder sb;
        Gson gson = new Gson();
        String json = gson.toJson(map);
        C1694ra.m55917a("RetrofitServiceManager", "samon importantData =" + json);
        TreeMap treeMap = new TreeMap();
        if (!"heart_beat".equals(str)) {
            String replaceAll = C1625E.m56283a().m56274b(json, false).replaceAll("\\n", "");
            if (!TextUtils.isEmpty(CommonUtil.getDecryptKey(false))) {
                treeMap.put("sdk_version", CommonUtil.SDK_VERSION);
                treeMap.put("content", replaceAll);
                json = gson.toJson(treeMap);
                sb = new StringBuilder();
            }
            return RequestBody.create(MediaType.parse("application/json,utf-8"), json);
        }
        treeMap.put("heart_beat", "1");
        String replaceAll2 = C1625E.m56283a().m56274b(json, true).replaceAll("\\n", "");
        treeMap.put("sdk_version", CommonUtil.SDK_VERSION);
        treeMap.put("content", replaceAll2);
        json = gson.toJson(treeMap);
        sb = new StringBuilder();
        sb.append("samon all request data = ");
        sb.append(json);
        C1694ra.m55917a("RetrofitServiceManager", sb.toString());
        return RequestBody.create(MediaType.parse("application/json,utf-8"), json);
    }

    /* renamed from: a */
    public boolean m56139a(int i) {
        return i <= 81920;
    }

    /* renamed from: a */
    public boolean m56136a(List<String> list) {
        if (list == null || list.size() == 0) {
            C1694ra.m55917a(f3280b, "lists = null");
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains("￥") || list.get(i).contains("¥")) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean m56135a(List<String> list, String str, int i) {
        if (list == null || list.size() == 0) {
            C1694ra.m55917a(f3280b, "lists = null");
            return false;
        } else if (m56129b(list)) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (list.get(i2).trim().contains("￥") || list.get(i2).trim().contains("¥")) {
                    return list.size() >= i;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    /* renamed from: b */
    public int m56132b(int i) {
        String str;
        String str2;
        if (AcseHelpManager.mIsDebug) {
            str = f3280b;
            str2 = "setReadTime is debug";
        } else {
            str = f3280b;
            str2 = "setReadTime is release";
        }
        C1694ra.m55917a(str, str2);
        return i;
    }

    /* renamed from: b */
    public AdPackageModel m56133b() {
        if (C1661ba.m56097a() == null) {
            return new AdPackageModel();
        }
        String m56086d = C1661ba.m56097a().m56086d("show_ad_activity");
        return TextUtils.isEmpty(m56086d) ? new AdPackageModel() : (AdPackageModel) new Gson().fromJson(m56086d, (Class<Object>) AdPackageModel.class);
    }

    /* renamed from: b */
    public PageSettingTypeModel m56131b(String str) {
        try {
            if (C1661ba.m56097a() != null) {
                AdPackageModel m56133b = m56140a().m56133b();
                if (m56133b != null) {
                    C1694ra.m55915b(f3280b, "getShowAdActivityPackageName adPackageModel is not null ");
                    C1661ba.m56097a().m56088b("read_timeout", m56133b.getRead_timeout());
                    C1661ba.m56097a().m56088b("readpage_activity_type", m56133b.getReadpage_activity_type());
                    C1661ba.m56097a().m56089b("delay_read_time", m56133b.getDelay_readpage_time());
                    if (TextUtils.isEmpty(m56133b.getNew_package_setting())) {
                        C1694ra.m55915b(f3280b, "getShowAdActivityPackageName getNew_package_setting is not null ");
                        return null;
                    }
                    return m56138a(C1690pa.m55931b(m56133b.getNew_package_setting()).get(str));
                }
                C1694ra.m55915b(f3280b, "getShowAdActivityPackageName adPackageModel is null ");
            }
        } catch (Exception e) {
            String str2 = f3280b;
            C1694ra.m55915b(str2, "getShowAdActivityPackageName Exception e =" + e.getMessage());
        }
        return null;
    }

    /* renamed from: b */
    public boolean m56130b(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains("月销") || str.contains("已售") || str.matches("[1-9]\\d*\\.?\\d*") || str.contains("￥") || str.contains("¥")) {
            return true;
        }
        if (str.length() > i || m56121h(str)) {
            return m56126c(str, 2);
        }
        return false;
    }

    /* renamed from: b */
    public boolean m56129b(List<String> list) {
        if (list == null || list.size() == 0) {
            C1694ra.m55917a(f3280b, "lists = null");
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).replace("0", "").length() > 17) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public void m56127c(String str) {
        int length = str.length();
        C1694ra.m55917a("samon-->", length + "b");
    }

    /* renamed from: c */
    public boolean m56126c(String str, int i) {
        return str.split("，").length < i;
    }

    /* renamed from: d */
    public boolean m56125d(String str) {
        AdPackageModel m56133b;
        try {
            if (C1661ba.m56097a() != null && (m56133b = m56140a().m56133b()) != null) {
                for (int i = 0; i < m56133b.getKeywords_names().size(); i++) {
                    if (str.toLowerCase().contains(m56133b.getKeywords_names().get(i))) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            String str2 = f3280b;
            C1694ra.m55915b(str2, "isAccordType Exception e =" + e.getMessage());
        }
        return false;
    }

    /* renamed from: e */
    public boolean m56124e(String str) {
        AdPackageModel m56133b;
        try {
            if (C1661ba.m56097a() != null && (m56133b = m56140a().m56133b()) != null) {
                for (int i = 0; i < m56133b.getNew_package_name().size(); i++) {
                    if (str.toLowerCase().equals(m56133b.getNew_package_name().get(i))) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            String str2 = f3280b;
            C1694ra.m55915b(str2, "isContainPackageName Exception e =" + e.getMessage());
        }
        return false;
    }

    /* renamed from: f */
    public boolean m56123f(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    public String m56122g(String str) {
        C1694ra.m55915b(f3280b, "isShowBigPicture ");
        if (str.equals(C1631H.m56262a().f3173J)) {
            str = C1631H.m56262a().f3237wa;
        }
        String str2 = f3280b;
        C1694ra.m55915b(str2, "pageName= " + str);
        String m56086d = C1661ba.m56097a().m56086d(str);
        ShowWindowModel showWindowModel = (TextUtils.isEmpty(m56086d) || m56086d == null) ? new ShowWindowModel() : (ShowWindowModel) new Gson().fromJson(m56086d, new C1651U(this).getType());
        showWindowModel.setAppName(str);
        String m56161a = C1650T.m56150d().m56161a();
        String str3 = f3280b;
        C1694ra.m55915b(str3, "date= " + m56161a);
        String str4 = f3280b;
        C1694ra.m55915b(str4, "label.getShowBigWindowData()= " + showWindowModel.getShowBigWindowData());
        return !showWindowModel.getShowBigWindowData().equals(m56161a) ? "1" : "0";
    }
}

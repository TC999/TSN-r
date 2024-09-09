package com.acse.ottn.util;

import android.text.TextUtils;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.g3;
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

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class V {

    /* renamed from: a  reason: collision with root package name */
    private static V f6789a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f6790b = "V";

    private V() {
    }

    public static V a() {
        if (f6789a == null) {
            synchronized (V.class) {
                if (f6789a == null) {
                    f6789a = new V();
                }
            }
        }
        return f6789a;
    }

    private Object c() throws ObjectStreamException {
        return f6789a;
    }

    private boolean h(String str) {
        return str.matches(".*\\d+.*");
    }

    public int a(String str, int i4) {
        if (TextUtils.isEmpty(str)) {
            return i4;
        }
        int length = str.length();
        if (length < 2048) {
            length += i4;
        }
        String str2 = f6790b;
        ra.a(str2, "\u603b\u957f\u5ea6=" + length);
        return length;
    }

    public PageSettingTypeModel a(String str) {
        String str2 = f6790b;
        ra.a(str2, "getCurrentPageSettingData json =" + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (PageSettingTypeModel) new Gson().fromJson(str, (Class<Object>) PageSettingTypeModel.class);
    }

    public RequestBody a(Map map, String str) {
        StringBuilder sb;
        Gson gson = new Gson();
        String json = gson.toJson(map);
        ra.a(g3.f5672e, "samon importantData =" + json);
        TreeMap treeMap = new TreeMap();
        if (!"heart_beat".equals(str)) {
            String replaceAll = E.a().b(json, false).replaceAll("\\n", "");
            if (!TextUtils.isEmpty(CommonUtil.getDecryptKey(false))) {
                treeMap.put("sdk_version", CommonUtil.SDK_VERSION);
                treeMap.put("content", replaceAll);
                json = gson.toJson(treeMap);
                sb = new StringBuilder();
            }
            return RequestBody.create(MediaType.parse("application/json,utf-8"), json);
        }
        treeMap.put("heart_beat", "1");
        String replaceAll2 = E.a().b(json, true).replaceAll("\\n", "");
        treeMap.put("sdk_version", CommonUtil.SDK_VERSION);
        treeMap.put("content", replaceAll2);
        json = gson.toJson(treeMap);
        sb = new StringBuilder();
        sb.append("samon all request data = ");
        sb.append(json);
        ra.a(g3.f5672e, sb.toString());
        return RequestBody.create(MediaType.parse("application/json,utf-8"), json);
    }

    public boolean a(int i4) {
        return i4 <= 81920;
    }

    public boolean a(List<String> list) {
        if (list == null || list.size() == 0) {
            ra.a(f6790b, "lists = null");
            return false;
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (list.get(i4).contains("\uffe5") || list.get(i4).contains("\u00a5")) {
                return true;
            }
        }
        return false;
    }

    public boolean a(List<String> list, String str, int i4) {
        if (list == null || list.size() == 0) {
            ra.a(f6790b, "lists = null");
            return false;
        } else if (b(list)) {
            for (int i5 = 0; i5 < list.size(); i5++) {
                if (list.get(i5).trim().contains("\uffe5") || list.get(i5).trim().contains("\u00a5")) {
                    return list.size() >= i4;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    public int b(int i4) {
        String str;
        String str2;
        if (AcseHelpManager.mIsDebug) {
            str = f6790b;
            str2 = "setReadTime is debug";
        } else {
            str = f6790b;
            str2 = "setReadTime is release";
        }
        ra.a(str, str2);
        return i4;
    }

    public AdPackageModel b() {
        if (C1419ba.a() == null) {
            return new AdPackageModel();
        }
        String d4 = C1419ba.a().d("show_ad_activity");
        return TextUtils.isEmpty(d4) ? new AdPackageModel() : (AdPackageModel) new Gson().fromJson(d4, (Class<Object>) AdPackageModel.class);
    }

    public PageSettingTypeModel b(String str) {
        try {
            if (C1419ba.a() != null) {
                AdPackageModel b4 = a().b();
                if (b4 != null) {
                    ra.b(f6790b, "getShowAdActivityPackageName adPackageModel is not null ");
                    C1419ba.a().b("read_timeout", b4.getRead_timeout());
                    C1419ba.a().b("readpage_activity_type", b4.getReadpage_activity_type());
                    C1419ba.a().b("delay_read_time", b4.getDelay_readpage_time());
                    if (TextUtils.isEmpty(b4.getNew_package_setting())) {
                        ra.b(f6790b, "getShowAdActivityPackageName getNew_package_setting is not null ");
                        return null;
                    }
                    return a(pa.b(b4.getNew_package_setting()).get(str));
                }
                ra.b(f6790b, "getShowAdActivityPackageName adPackageModel is null ");
            }
        } catch (Exception e4) {
            String str2 = f6790b;
            ra.b(str2, "getShowAdActivityPackageName Exception e =" + e4.getMessage());
        }
        return null;
    }

    public boolean b(String str, int i4) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains("\u6708\u9500") || str.contains("\u5df2\u552e") || str.matches("[1-9]\\d*\\.?\\d*") || str.contains("\uffe5") || str.contains("\u00a5")) {
            return true;
        }
        if (str.length() > i4 || h(str)) {
            return c(str, 2);
        }
        return false;
    }

    public boolean b(List<String> list) {
        if (list == null || list.size() == 0) {
            ra.a(f6790b, "lists = null");
            return false;
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (list.get(i4).replace("0", "").length() > 17) {
                return true;
            }
        }
        return false;
    }

    public void c(String str) {
        int length = str.length();
        ra.a("samon-->", length + "b");
    }

    public boolean c(String str, int i4) {
        return str.split("\uff0c").length < i4;
    }

    public boolean d(String str) {
        AdPackageModel b4;
        try {
            if (C1419ba.a() != null && (b4 = a().b()) != null) {
                for (int i4 = 0; i4 < b4.getKeywords_names().size(); i4++) {
                    if (str.toLowerCase().contains(b4.getKeywords_names().get(i4))) {
                        return true;
                    }
                }
            }
        } catch (Exception e4) {
            String str2 = f6790b;
            ra.b(str2, "isAccordType Exception e =" + e4.getMessage());
        }
        return false;
    }

    public boolean e(String str) {
        AdPackageModel b4;
        try {
            if (C1419ba.a() != null && (b4 = a().b()) != null) {
                for (int i4 = 0; i4 < b4.getNew_package_name().size(); i4++) {
                    if (str.toLowerCase().equals(b4.getNew_package_name().get(i4))) {
                        return true;
                    }
                }
            }
        } catch (Exception e4) {
            String str2 = f6790b;
            ra.b(str2, "isContainPackageName Exception e =" + e4.getMessage());
        }
        return false;
    }

    public boolean f(String str) {
        for (int i4 = 0; i4 < str.length(); i4++) {
            if (Character.isDigit(str.charAt(i4))) {
                return true;
            }
        }
        return false;
    }

    public String g(String str) {
        ra.b(f6790b, "isShowBigPicture ");
        if (str.equals(H.a().J)) {
            str = H.a().wa;
        }
        String str2 = f6790b;
        ra.b(str2, "pageName= " + str);
        String d4 = C1419ba.a().d(str);
        ShowWindowModel showWindowModel = (TextUtils.isEmpty(d4) || d4 == null) ? new ShowWindowModel() : (ShowWindowModel) new Gson().fromJson(d4, new U(this).getType());
        showWindowModel.setAppName(str);
        String a4 = T.d().a();
        String str3 = f6790b;
        ra.b(str3, "date= " + a4);
        String str4 = f6790b;
        ra.b(str4, "label.getShowBigWindowData()= " + showWindowModel.getShowBigWindowData());
        return !showWindowModel.getShowBigWindowData().equals(a4) ? "1" : "0";
    }
}

package com.acse.ottn;

import android.text.TextUtils;
import android.util.Log;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.model.AdPackageModel;
import com.acse.ottn.model.PageSettingTypeModel;
import com.acse.ottn.model.ShowWindowModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.ObjectStreamException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class q0 {

    /* renamed from: a  reason: collision with root package name */
    public static q0 f6148a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f6149b = "q0";

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a extends TypeToken<ShowWindowModel> {
        public a() {
        }
    }

    public static q0 a() {
        if (f6148a == null) {
            synchronized (q0.class) {
                if (f6148a == null) {
                    f6148a = new q0();
                }
            }
        }
        return f6148a;
    }

    public int b(int i4) {
        if (AcseHelpManager.mIsDebug) {
            z1.a(f6149b, "setReadTime is debug");
            return i4;
        }
        z1.a(f6149b, "setReadTime is release");
        return i4;
    }

    public final Object c() throws ObjectStreamException {
        return f6148a;
    }

    public void d(String str) {
        int length = str.length();
        z1.a("samon-->", length + "b");
    }

    public boolean e(String str) {
        AdPackageModel b4;
        try {
            if (g1.a() != null && (b4 = a().b()) != null) {
                for (int i4 = 0; i4 < b4.getKeywords_names().size(); i4++) {
                    if (str.toLowerCase().contains(b4.getKeywords_names().get(i4))) {
                        return true;
                    }
                }
            }
        } catch (Exception e4) {
            String str2 = f6149b;
            Log.d(str2, "isAccordType Exception e =" + e4.getMessage());
        }
        return false;
    }

    public boolean f(String str) {
        AdPackageModel b4;
        try {
            if (g1.a() != null && (b4 = a().b()) != null) {
                for (int i4 = 0; i4 < b4.getNew_package_name().size(); i4++) {
                    if (str.toLowerCase().equals(b4.getNew_package_name().get(i4))) {
                        return true;
                    }
                }
            }
        } catch (Exception e4) {
            String str2 = f6149b;
            Log.d(str2, "isContainPackageName Exception e =" + e4.getMessage());
        }
        return false;
    }

    public boolean g(String str) {
        for (int i4 = 0; i4 < str.length(); i4++) {
            if (Character.isDigit(str.charAt(i4))) {
                return true;
            }
        }
        return false;
    }

    public String h(String str) {
        ShowWindowModel showWindowModel;
        z1.b(f6149b, "isShowBigPicture ");
        if (str.equals(n.a().I)) {
            str = n.a().f6030v0;
        }
        String str2 = f6149b;
        z1.b(str2, "pageName= " + str);
        String d4 = g1.a().d(str);
        Gson gson = new Gson();
        if (!TextUtils.isEmpty(d4) && d4 != null) {
            showWindowModel = (ShowWindowModel) gson.fromJson(d4, new a().getType());
        } else {
            showWindowModel = new ShowWindowModel();
        }
        showWindowModel.setAppName(str);
        String a4 = p0.d().a();
        String str3 = f6149b;
        z1.b(str3, "date= " + a4);
        String str4 = f6149b;
        z1.b(str4, "label.getShowBigWindowData()= " + showWindowModel.getShowBigWindowData());
        return !showWindowModel.getShowBigWindowData().equals(a4) ? "1" : "0";
    }

    public boolean c(List<String> list) {
        if (list != null && list.size() != 0) {
            for (int i4 = 0; i4 < list.size(); i4++) {
                if (list.get(i4).replace("0", "").length() > 17) {
                    return true;
                }
            }
            return false;
        }
        z1.a(f6149b, "lists = null");
        return false;
    }

    public PageSettingTypeModel b(String str) {
        String str2 = f6149b;
        z1.a(str2, "getCurrentPageSettingData json =" + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (PageSettingTypeModel) new Gson().fromJson(str, (Class<Object>) PageSettingTypeModel.class);
    }

    public PageSettingTypeModel c(String str) {
        try {
            if (g1.a() != null) {
                AdPackageModel b4 = a().b();
                if (b4 != null) {
                    z1.b(f6149b, "getShowAdActivityPackageName adPackageModel is not null ");
                    g1.a().b("read_timeout", b4.getRead_timeout());
                    g1.a().b("readpage_activity_type", b4.getReadpage_activity_type());
                    g1.a().b("delay_read_time", b4.getDelay_readpage_time());
                    if (TextUtils.isEmpty(b4.getNew_package_setting())) {
                        z1.b(f6149b, "getShowAdActivityPackageName getNew_package_setting is not null ");
                        return null;
                    }
                    return b(t1.b(b4.getNew_package_setting()).get(str));
                }
                z1.b(f6149b, "getShowAdActivityPackageName adPackageModel is null ");
            }
        } catch (Exception e4) {
            String str2 = f6149b;
            Log.d(str2, "getShowAdActivityPackageName Exception e =" + e4.getMessage());
        }
        return null;
    }

    public boolean a(List<String> list) {
        if (list != null && list.size() != 0) {
            for (int i4 = 0; i4 < list.size(); i4++) {
                if (list.get(i4).contains("\uffe5") || list.get(i4).contains("\u00a5")) {
                    return true;
                }
            }
            return false;
        }
        z1.a(f6149b, "lists = null");
        return false;
    }

    public AdPackageModel b() {
        if (g1.a() == null) {
            return new AdPackageModel();
        }
        String d4 = g1.a().d("show_ad_activity");
        if (TextUtils.isEmpty(d4)) {
            return new AdPackageModel();
        }
        return (AdPackageModel) new Gson().fromJson(d4, (Class<Object>) AdPackageModel.class);
    }

    public boolean a(List<String> list, int i4) {
        if (list != null && list.size() != 0) {
            if (c(list)) {
                for (int i5 = 0; i5 < list.size(); i5++) {
                    if (list.get(i5).trim().contains("\uffe5") || list.get(i5).trim().contains("\u00a5")) {
                        return list.size() >= i4;
                    }
                }
                return false;
            }
            return false;
        }
        z1.a(f6149b, "lists = null");
        return false;
    }

    public boolean b(String str, int i4) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains("\u6708\u9500") || str.contains("\u5df2\u552e") || str.matches("[1-9]\\d*\\.?\\d*") || str.contains("\uffe5") || str.contains("\u00a5")) {
            return true;
        }
        if (str.length() > i4 || a(str)) {
            return c(str, 2);
        }
        return false;
    }

    public RequestBody a(Map map, String str) {
        Gson gson = new Gson();
        String json = gson.toJson(map);
        String str2 = f6149b;
        Log.d(str2, "\u5185\u5bb9  getTitle=" + json);
        z1.a(g3.f5672e, "samon importantData =" + json);
        TreeMap treeMap = new TreeMap();
        if ("heart_beat".equals(str)) {
            treeMap.put("heart_beat", "1");
            String replaceAll = f.a().b(json, true).replaceAll("\\n", "");
            treeMap.put("sdk_version", j0.f5770l);
            treeMap.put("content", replaceAll);
            String json2 = gson.toJson(treeMap);
            z1.a(g3.f5672e, "samon all request data = " + json2);
            return RequestBody.create(MediaType.parse("application/json,utf-8"), json2);
        }
        String replaceAll2 = f.a().b(json, false).replaceAll("\\n", "");
        if (TextUtils.isEmpty(j0.a(false))) {
            return RequestBody.create(MediaType.parse("application/json,utf-8"), json);
        }
        treeMap.put("sdk_version", j0.f5770l);
        treeMap.put("content", replaceAll2);
        String json3 = gson.toJson(treeMap);
        z1.a(g3.f5672e, "samon all request data = " + json3);
        return RequestBody.create(MediaType.parse("application/json,utf-8"), json3);
    }

    public boolean c(String str, int i4) {
        return str.split("\uff0c").length < i4;
    }

    public String b(List<String> list) {
        if (list != null && list.size() != 0) {
            for (int i4 = 0; i4 < list.size(); i4++) {
                if (list.get(i4).contains("https")) {
                    return list.get(i4);
                }
            }
            return "";
        }
        z1.a(f6149b, "lists = null");
        return "";
    }

    public int a(String str, int i4) {
        if (TextUtils.isEmpty(str)) {
            return i4;
        }
        int length = str.length();
        return length < 2048 ? length + i4 : length;
    }

    public boolean a(int i4) {
        if (i4 > 8192) {
            g1.a().b("scroll_state", j0.f5774p);
            return false;
        }
        return true;
    }

    public final boolean a(String str) {
        return str.matches(".*\\d+.*");
    }
}

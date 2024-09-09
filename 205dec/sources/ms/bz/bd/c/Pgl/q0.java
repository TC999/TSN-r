package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class q0 {
    public static String a(Context context) {
        if (context == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(b(context));
        try {
            for (InputMethodInfo inputMethodInfo : ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList()) {
                String packageName = inputMethodInfo.getPackageName();
                if (!TextUtils.isEmpty(packageName) && sb.indexOf(packageName) < 0) {
                    sb.append("[<!>]");
                    sb.append(packageName);
                }
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    private static String b(Context context) {
        String str;
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "default_input_method");
        } catch (Throwable th) {
            try {
                str = "null_" + th.getMessage();
            } catch (Throwable unused) {
                return "null_";
            }
        }
        if (TextUtils.isEmpty(str)) {
            return "null_";
        }
        if (str.contains(TTPathConst.sSeparator)) {
            str = str.split(TTPathConst.sSeparator)[0];
        }
        return str;
    }

    public static String c(Context context) {
        if (context == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(b(context));
        try {
            for (InputMethodInfo inputMethodInfo : ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList()) {
                String packageName = inputMethodInfo.getPackageName();
                String str = context.getPackageManager().getApplicationInfo(packageName, 0).sourceDir;
                if (!TextUtils.isEmpty(packageName) && sb.indexOf(packageName) < 0) {
                    sb.append("[<!>]");
                    sb.append(str);
                }
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    public static String d(Context context) {
        int i4;
        List list;
        JSONArray jSONArray = new JSONArray();
        if (context == null) {
            return jSONArray.toString();
        }
        String str = null;
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            Method declaredMethod = wifiManager.getClass().getDeclaredMethod(new String(pbly.d("6765745363616e526573756c7473")), new Class[0]);
            list = declaredMethod != null ? (List) declaredMethod.invoke(wifiManager, new Object[0]) : null;
        } catch (Throwable unused) {
        }
        if (list != null && list.size() > 0) {
            Collections.sort(list, new r0());
            for (i4 = 0; i4 < list.size() && i4 < 10; i4++) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ss", n1.a(((ScanResult) list.get(i4)).SSID));
                    jSONObject.put("bs", n1.a(((ScanResult) list.get(i4)).BSSID));
                    jSONArray.put(jSONObject);
                } catch (JSONException unused2) {
                }
            }
            str = jSONArray.toString();
            return str == null ? "[]" : str.trim();
        }
        return jSONArray.toString();
    }
}

package cn.jiguang.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import cn.jiguang.a.a;
import cn.jiguang.api.JDispatchAction;
import cn.jiguang.bk.c;
import cn.jiguang.bk.g;
import cn.jiguang.bq.d;
import com.bytedance.msdk.api.AdError;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class ActionManager {
    private static final String SDK_TYPE = "sdk_type";
    private static final String SDK_VERSION = "version";
    private static final String TAG = "ActionManager";
    private static volatile ActionManager detachDataManager;
    private static final Object lock = new Object();
    private static HashMap<String, JDispatchAction> actionMap = new HashMap<>();
    private static HashMap<String, String> actionStringMap = new HashMap<>();

    public ActionManager() {
        c.a();
    }

    public static void addAction(String str, String str2) {
        Log.d(TAG, "addAction type:" + str + ",action:" + str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (actionMap.containsKey(str)) {
            d.c(TAG, "has same type action");
            return;
        }
        try {
            Object newInstance = Class.forName(str2).newInstance();
            if (newInstance instanceof JDispatchAction) {
                actionStringMap.put(str, str2);
                actionMap.put(str, (JDispatchAction) newInstance);
            } else {
                d.i(TAG, "this action is not a JDispatchAction,please check and extends JDispatchAction");
            }
        } catch (Throwable th) {
            d.j(TAG, "#unexcepted - instance " + str2 + " class failed:" + th);
        }
    }

    public static HashMap<String, String> getActionMap() {
        return actionStringMap;
    }

    public static HashMap<String, JDispatchAction> getDispatchActionMap() {
        return actionMap;
    }

    public static ActionManager getInstance() {
        if (detachDataManager == null) {
            synchronized (lock) {
                if (detachDataManager == null) {
                    detachDataManager = new ActionManager();
                }
            }
        }
        return detachDataManager;
    }

    public static JDispatchAction getJDispatchAction(String str) {
        return actionMap.get(str);
    }

    public static boolean wrapSdkTypeVersionInfo(JSONObject jSONObject) {
        boolean z3 = false;
        if (jSONObject == null) {
            d.i(TAG, "wrapSdkTypeVersionInfo failed ,container is null");
            return false;
        }
        try {
            if (g.a(g.b())) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("version", a.f2010b);
                jSONObject2.put("sdk_type", g.b());
                try {
                    jSONObject.put("core_sdk_ver", jSONObject2);
                    z3 = true;
                } catch (JSONException unused) {
                    return true;
                }
            }
            for (Map.Entry<String, JDispatchAction> entry : actionMap.entrySet()) {
                JDispatchAction value = entry.getValue();
                if (g.a(value.getSdkType())) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("version", value.getSdkVersion(entry.getKey()));
                    jSONObject3.put("sdk_type", value.getSdkType());
                    jSONObject.put(value.getReportVersionKey(entry.getKey()), jSONObject3);
                    z3 = true;
                }
            }
            return z3;
        } catch (JSONException unused2) {
            return z3;
        }
    }

    public void handleMessage(Context context, String str, Object obj) {
        d.a(TAG, "onSended type:" + str + ",actionMap size:" + actionMap.size());
        if (TextUtils.isEmpty(str)) {
            for (Map.Entry<String, JDispatchAction> entry : actionMap.entrySet()) {
                entry.getValue().handleMessage(context, entry.getKey(), obj);
            }
            return;
        }
        JDispatchAction jDispatchAction = actionMap.get(str);
        if (jDispatchAction != null) {
            jDispatchAction.handleMessage(context, str, obj);
        }
    }

    public Map<Integer, Bundle> loadPInfo() {
        int i4;
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, JDispatchAction> entry : actionMap.entrySet()) {
            Bundle pInfo = entry.getValue().getPInfo(entry.getKey());
            if (pInfo != null && (i4 = pInfo.getInt("pid", 0)) > 0) {
                hashMap.put(Integer.valueOf(i4), pInfo);
            }
        }
        return hashMap;
    }

    public boolean wrapSdkVersionInfo(JSONObject jSONObject) {
        Object dataByCmd;
        if (jSONObject == null) {
            d.i(TAG, "wrapSdkVersionInfo failed ,container is null");
            return false;
        }
        try {
            jSONObject.put("core_sdk_ver", a.f2010b);
            for (Map.Entry<String, JDispatchAction> entry : actionMap.entrySet()) {
                JDispatchAction value = entry.getValue();
                jSONObject.put(value.getReportVersionKey(entry.getKey()), value.getSdkVersion(entry.getKey()));
                Object dataByCmd2 = value.getDataByCmd(null, AdError.ERROR_CODE_THIRD_SDK_NOT_INIT);
                if (dataByCmd2 != null && (dataByCmd2 instanceof String) && (dataByCmd = value.getDataByCmd(null, AdError.ERROR_CODE_THIRD_SDK_PARARM_ERROR)) != null && (dataByCmd instanceof String)) {
                    jSONObject.put((String) dataByCmd2, (String) dataByCmd);
                }
            }
            return true;
        } catch (JSONException unused) {
            return true;
        }
    }
}

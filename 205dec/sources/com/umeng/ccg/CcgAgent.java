package com.umeng.ccg;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class CcgAgent {
    private static Map<String, ArrayList<String>> forbidSdkTable;
    private static Object lock = new Object();
    private static ArrayList<ConfigListener> callbacks = new ArrayList<>();
    private static Object actionInfoLock = new Object();
    private static Map<String, ActionInfo> actionInfoTable = new HashMap();

    static {
        HashMap hashMap = new HashMap();
        forbidSdkTable = hashMap;
        hashMap.put("col_apl", new ArrayList());
        forbidSdkTable.put("col_lbs", new ArrayList<>());
        forbidSdkTable.put("col_wifi", new ArrayList<>());
        forbidSdkTable.put("col_bs", new ArrayList<>());
    }

    public static ActionInfo getActionInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (actionInfoLock) {
                r1 = actionInfoTable.containsKey(str) ? actionInfoTable.get(str) : null;
            }
        }
        return r1;
    }

    public static String[] getCollectItemList() {
        return new String[]{"col_apl", "col_lbs", "col_wifi", "col_bs"};
    }

    public static ArrayList<String> getForbidSdkArray(String str) {
        if (forbidSdkTable.containsKey(str)) {
            return forbidSdkTable.get(str);
        }
        return null;
    }

    public static ArrayList<String> getRegistedModuleList() {
        ArrayList<String> arrayList;
        synchronized (actionInfoLock) {
            arrayList = new ArrayList<>(actionInfoTable.keySet());
        }
        return arrayList;
    }

    public static boolean hasRegistedActionInfo() {
        boolean z3;
        synchronized (actionInfoLock) {
            z3 = actionInfoTable.size() > 0;
        }
        return z3;
    }

    public static void init(Context context) {
        d.a().a(context);
    }

    public static void notifyConfigReady(JSONObject jSONObject) {
        synchronized (lock) {
            int size = callbacks.size();
            if (size > 0) {
                for (int i4 = 0; i4 < size; i4++) {
                    callbacks.get(i4).onConfigReady(jSONObject);
                }
            }
        }
    }

    public static void registerActionInfo(ActionInfo actionInfo) {
        Context appContext = UMGlobalContext.getAppContext();
        if (actionInfo != null) {
            synchronized (actionInfoLock) {
                try {
                    String module = actionInfo.getModule(UMGlobalContext.getAppContext());
                    if (!TextUtils.isEmpty(module) && !actionInfoTable.containsKey(module)) {
                        String[] supportAction = actionInfo.getSupportAction(appContext);
                        if (supportAction != null) {
                            for (String str : supportAction) {
                                boolean switchState = actionInfo.getSwitchState(appContext, str);
                                if (forbidSdkTable.containsKey(str)) {
                                    ArrayList<String> arrayList = forbidSdkTable.get(str);
                                    if (!switchState) {
                                        arrayList.add(module);
                                    }
                                }
                            }
                        }
                        actionInfoTable.put(module, actionInfo);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static void registerConfigListener(ConfigListener configListener) {
        if (configListener != null) {
            synchronized (lock) {
                callbacks.add(configListener);
            }
        }
    }
}

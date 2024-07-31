package com.umeng.ccg;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class CcgAgent {
    private static Map<String, ArrayList<String>> forbidSdkTable;
    private static Object lock = new Object();
    private static ArrayList<ConfigListener> callbacks = new ArrayList<>();
    private static Object actionInfoLock = new Object();
    private static Map<String, ActionInfo> actionInfoTable = new HashMap();

    static {
        HashMap hashMap = new HashMap();
        forbidSdkTable = hashMap;
        hashMap.put(CcgConstant.f38534e, new ArrayList());
        forbidSdkTable.put(CcgConstant.f38533d, new ArrayList<>());
        forbidSdkTable.put(CcgConstant.f38531b, new ArrayList<>());
        forbidSdkTable.put(CcgConstant.f38532c, new ArrayList<>());
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
        return new String[]{CcgConstant.f38534e, CcgConstant.f38533d, CcgConstant.f38531b, CcgConstant.f38532c};
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
        boolean z;
        synchronized (actionInfoLock) {
            z = actionInfoTable.size() > 0;
        }
        return z;
    }

    public static void init(Context context) {
        Monitor.m14095a().m14094a(context);
    }

    public static void notifyConfigReady(JSONObject jSONObject) {
        synchronized (lock) {
            int size = callbacks.size();
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    callbacks.get(i).onConfigReady(jSONObject);
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

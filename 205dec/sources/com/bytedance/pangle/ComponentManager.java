package com.bytedance.pangle;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import com.bytedance.pangle.activity.IntentUtils;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.receiver.PluginBroadcastReceiver;
import com.bytedance.pangle.receiver.c;
import com.bytedance.pangle.util.MethodUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ComponentManager {
    public static HashMap<String, List<String>> stubActivity2TargetActivities = new HashMap<>();
    public static HashMap<String, String> targetString2StubActivity = new HashMap<>();
    public static HashMap<String, String> targetString2PluginPkgName = new HashMap<>();

    public static String getTargetStubActivityString(String str) {
        return targetString2StubActivity.get(str);
    }

    private static boolean isSupportLibIso(String str) {
        try {
            return PluginManager.getInstance().getPlugin(str).mIsSupportLibIso;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void realStartActivity(Object obj, Context context, Intent intent, Bundle bundle, String str) {
        if (context instanceof PluginContext) {
            context = ((PluginContext) context).mOriginContext;
        }
        if (intent.getComponent() != null) {
            String className = intent.getComponent().getClassName();
            Zeus.loadPlugin(str);
            String targetStubActivityString = getTargetStubActivityString(className);
            if (!TextUtils.isEmpty(targetStubActivityString)) {
                IntentUtils.a(intent, str);
                intent.setComponent(new ComponentName(context, targetStubActivityString));
                intent.putExtra("targetPlugin", className);
            }
        }
        try {
            if (!isSupportLibIso(str) && (obj instanceof Fragment)) {
                ((Fragment) obj).startActivity(intent, bundle);
            } else if (obj instanceof android.app.Fragment) {
                ((android.app.Fragment) obj).startActivity(intent, bundle);
            } else {
                context.startActivity(intent, bundle);
            }
        } catch (Throwable th) {
            throw new RuntimeException("component = " + intent.getComponent(), th);
        }
    }

    private static void realStartActivityForResult(Object obj, Activity activity, Intent intent, int i4, Bundle bundle, String str) {
        if (intent.getComponent() != null) {
            String className = intent.getComponent().getClassName();
            Zeus.loadPlugin(str);
            String targetStubActivityString = getTargetStubActivityString(className);
            if (!TextUtils.isEmpty(targetStubActivityString)) {
                IntentUtils.a(intent, str);
                intent.setComponent(new ComponentName(activity, targetStubActivityString));
                intent.putExtra("targetPlugin", className);
            }
        }
        try {
            if (!isSupportLibIso(str) && (obj instanceof Fragment)) {
                ((Fragment) obj).startActivityForResult(intent, i4, bundle);
            } else if (obj instanceof android.app.Fragment) {
                ((android.app.Fragment) obj).startActivityForResult(intent, i4, bundle);
            } else {
                activity.startActivityForResult(intent, i4, bundle);
            }
        } catch (Throwable th) {
            throw new RuntimeException("component =  " + intent.getComponent(), th);
        }
    }

    public static void registerActivity(String str, String str2, String... strArr) {
        if (strArr != null) {
            for (String str3 : strArr) {
                List<String> list = stubActivity2TargetActivities.get(str2);
                if (list == null) {
                    list = new ArrayList<>();
                    stubActivity2TargetActivities.put(str2, list);
                }
                list.add(str3);
                targetString2StubActivity.put(str3, str2);
                targetString2PluginPkgName.put(str3, str);
            }
        }
    }

    public static Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str) {
        Intent registerReceiver;
        Zeus.loadPlugin(str);
        com.bytedance.pangle.receiver.c a4 = com.bytedance.pangle.receiver.c.a();
        if (intentFilter == null || intentFilter.actionsIterator() == null) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
                return context.registerReceiver(null, intentFilter, 2);
            }
            return context.registerReceiver(null, intentFilter);
        }
        com.bytedance.pangle.receiver.a aVar = new com.bytedance.pangle.receiver.a();
        if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
            registerReceiver = context.registerReceiver(aVar, intentFilter, 2);
        } else {
            registerReceiver = context.registerReceiver(aVar, intentFilter);
        }
        a4.f28891b.put(pluginBroadcastReceiver, aVar);
        a4.a(intentFilter, pluginBroadcastReceiver);
        return registerReceiver;
    }

    public static void startActivity(Object obj, Intent intent, Bundle bundle, String str) {
        if (obj instanceof Context) {
            realStartActivity(null, (Context) obj, intent, bundle, str);
        } else if (!isSupportLibIso(str) && (obj instanceof Fragment)) {
            realStartActivity(obj, ((Fragment) obj).getActivity(), intent, bundle, str);
        } else if (obj instanceof android.app.Fragment) {
            realStartActivity(obj, ((android.app.Fragment) obj).getActivity(), intent, bundle, str);
        } else {
            try {
                MethodUtils.invokeMethod(obj, "startActivity", new Object[]{intent, bundle}, new Class[]{Intent.class, Bundle.class});
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }
    }

    public static void startActivityForResult(Object obj, Intent intent, int i4, Bundle bundle, String str) {
        if (obj instanceof Activity) {
            realStartActivityForResult(null, (Activity) obj, intent, i4, null, str);
        } else if (!isSupportLibIso(str) && (obj instanceof Fragment)) {
            realStartActivityForResult(obj, ((Fragment) obj).getActivity(), intent, i4, null, str);
        } else if (obj instanceof android.app.Fragment) {
            realStartActivityForResult(obj, ((android.app.Fragment) obj).getActivity(), intent, i4, null, str);
        } else {
            try {
                MethodUtils.invokeMethod(obj, "startActivityForResult", new Object[]{intent, Integer.valueOf(i4), bundle}, new Class[]{Intent.class, Integer.TYPE, Bundle.class});
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }
    }

    public static void unregisterReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver) {
        if (pluginBroadcastReceiver != null) {
            com.bytedance.pangle.receiver.c a4 = com.bytedance.pangle.receiver.c.a();
            for (Map.Entry<String, c.a> entry : a4.f28890a.entrySet()) {
                c.a value = entry.getValue();
                if (value != null) {
                    try {
                        if (value.f28894b.size() > 0) {
                            value.f28894b.remove(pluginBroadcastReceiver);
                        }
                    } catch (Throwable th) {
                        ZeusLogger.w("Zeus/receiver_pangle", "unregisterReceiver-plugin-receiver->action:" + value.f28893a + "[exception]:", th);
                    }
                }
                BroadcastReceiver broadcastReceiver = a4.f28891b.get(pluginBroadcastReceiver);
                if (broadcastReceiver != null) {
                    try {
                        a4.f28892c.remove(Integer.valueOf(broadcastReceiver.hashCode()));
                        a4.f28891b.remove(pluginBroadcastReceiver);
                        context.unregisterReceiver(broadcastReceiver);
                    } catch (Throwable th2) {
                        ZeusLogger.w("Zeus/receiver_pangle", "unregisterReceiver-\u79fb\u9664\u7cfb\u7edf\u6ce8\u518c\u7684\u5e7f\u64ad\u53d1\u751f\u5f02\u5e38:", th2);
                    }
                }
            }
        }
    }

    public static void startActivity(Context context, Intent intent, String str) {
        realStartActivity(null, context, intent, null, str);
    }

    public static void startActivityForResult(Activity activity, Intent intent, int i4, Bundle bundle, String str) {
        realStartActivityForResult(null, activity, intent, i4, bundle, str);
    }

    public static void startActivity(Context context, Intent intent, Bundle bundle, String str) {
        realStartActivity(null, context, intent, bundle, str);
    }

    public static Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler, String str2) {
        Intent registerReceiver;
        Zeus.loadPlugin(str2);
        com.bytedance.pangle.receiver.c a4 = com.bytedance.pangle.receiver.c.a();
        if (intentFilter == null || intentFilter.actionsIterator() == null) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
                return context.registerReceiver(null, intentFilter, 2);
            }
            return context.registerReceiver(null, intentFilter);
        }
        com.bytedance.pangle.receiver.a aVar = new com.bytedance.pangle.receiver.a();
        if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
            registerReceiver = context.registerReceiver(aVar, intentFilter, str, handler, 2);
        } else {
            registerReceiver = context.registerReceiver(aVar, intentFilter, str, handler);
        }
        a4.f28891b.put(pluginBroadcastReceiver, aVar);
        if (handler != null) {
            a4.f28892c.add(Integer.valueOf(aVar.hashCode()));
        }
        a4.a(intentFilter, pluginBroadcastReceiver);
        return registerReceiver;
    }

    public static Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, int i4, String str) {
        int i5;
        Zeus.loadPlugin(str);
        com.bytedance.pangle.receiver.c a4 = com.bytedance.pangle.receiver.c.a();
        if (intentFilter == null || intentFilter.actionsIterator() == null || (i5 = Build.VERSION.SDK_INT) < 26) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            if (i5 >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
                return context.registerReceiver(null, intentFilter, 2);
            }
            return context.registerReceiver(null, intentFilter);
        }
        com.bytedance.pangle.receiver.a aVar = new com.bytedance.pangle.receiver.a();
        Intent registerReceiver = context.registerReceiver(aVar, intentFilter, i4);
        a4.f28891b.put(pluginBroadcastReceiver, aVar);
        a4.a(intentFilter, pluginBroadcastReceiver);
        return registerReceiver;
    }

    public static Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i4, String str2) {
        int i5;
        Zeus.loadPlugin(str2);
        com.bytedance.pangle.receiver.c a4 = com.bytedance.pangle.receiver.c.a();
        if (intentFilter == null || intentFilter.actionsIterator() == null || (i5 = Build.VERSION.SDK_INT) < 26) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            if (i5 >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
                return context.registerReceiver(null, intentFilter, 2);
            }
            return context.registerReceiver(null, intentFilter);
        }
        com.bytedance.pangle.receiver.a aVar = new com.bytedance.pangle.receiver.a();
        Intent registerReceiver = context.registerReceiver(aVar, intentFilter, str, handler, i4);
        a4.f28891b.put(pluginBroadcastReceiver, aVar);
        if (handler != null) {
            a4.f28892c.add(Integer.valueOf(aVar.hashCode()));
        }
        a4.a(intentFilter, pluginBroadcastReceiver);
        return registerReceiver;
    }
}

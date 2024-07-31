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
import com.bytedance.pangle.receiver.C6189a;
import com.bytedance.pangle.receiver.C6197c;
import com.bytedance.pangle.receiver.PluginBroadcastReceiver;
import com.bytedance.pangle.util.MethodUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Keep
/* loaded from: E:\fuckcool\tsn\5141176.dex */
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
                IntentUtils.m37273a(intent, str);
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

    private static void realStartActivityForResult(Object obj, Activity activity, Intent intent, int i, Bundle bundle, String str) {
        if (intent.getComponent() != null) {
            String className = intent.getComponent().getClassName();
            Zeus.loadPlugin(str);
            String targetStubActivityString = getTargetStubActivityString(className);
            if (!TextUtils.isEmpty(targetStubActivityString)) {
                IntentUtils.m37273a(intent, str);
                intent.setComponent(new ComponentName(activity, targetStubActivityString));
                intent.putExtra("targetPlugin", className);
            }
        }
        try {
            if (!isSupportLibIso(str) && (obj instanceof Fragment)) {
                ((Fragment) obj).startActivityForResult(intent, i, bundle);
            } else if (obj instanceof android.app.Fragment) {
                ((android.app.Fragment) obj).startActivityForResult(intent, i, bundle);
            } else {
                activity.startActivityForResult(intent, i, bundle);
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
        Zeus.loadPlugin(str);
        C6197c m37017a = C6197c.m37017a();
        if (intentFilter == null || intentFilter.actionsIterator() == null) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            return context.registerReceiver(null, intentFilter);
        }
        C6189a c6189a = new C6189a();
        Intent registerReceiver = context.registerReceiver(c6189a, intentFilter);
        m37017a.f22130b.put(pluginBroadcastReceiver, c6189a);
        m37017a.m37015a(intentFilter, pluginBroadcastReceiver);
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

    public static void startActivityForResult(Object obj, Intent intent, int i, Bundle bundle, String str) {
        if (obj instanceof Activity) {
            realStartActivityForResult(null, (Activity) obj, intent, i, null, str);
        } else if (!isSupportLibIso(str) && (obj instanceof Fragment)) {
            realStartActivityForResult(obj, ((Fragment) obj).getActivity(), intent, i, null, str);
        } else if (obj instanceof android.app.Fragment) {
            realStartActivityForResult(obj, ((android.app.Fragment) obj).getActivity(), intent, i, null, str);
        } else {
            try {
                MethodUtils.invokeMethod(obj, "startActivityForResult", new Object[]{intent, Integer.valueOf(i), bundle}, new Class[]{Intent.class, Integer.TYPE, Bundle.class});
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }
    }

    public static void unregisterReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver) {
        if (pluginBroadcastReceiver != null) {
            C6197c m37017a = C6197c.m37017a();
            for (Map.Entry<String, C6197c.C6198a> entry : m37017a.f22129a.entrySet()) {
                C6197c.C6198a value = entry.getValue();
                if (value != null) {
                    try {
                        if (value.f22133b.size() > 0) {
                            value.f22133b.remove(pluginBroadcastReceiver);
                        }
                    } catch (Throwable th) {
                        ZeusLogger.m37076w(ZeusLogger.TAG_RECEIVER, "unregisterReceiver-plugin-receiver->action:" + value.f22132a + "[exception]:", th);
                    }
                }
                BroadcastReceiver broadcastReceiver = m37017a.f22130b.get(pluginBroadcastReceiver);
                if (broadcastReceiver != null) {
                    try {
                        m37017a.f22131c.remove(Integer.valueOf(broadcastReceiver.hashCode()));
                        m37017a.f22130b.remove(pluginBroadcastReceiver);
                        context.unregisterReceiver(broadcastReceiver);
                    } catch (Throwable th2) {
                        ZeusLogger.m37076w(ZeusLogger.TAG_RECEIVER, "unregisterReceiver-移除系统注册的广播发生异常:", th2);
                    }
                }
            }
        }
    }

    public static Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler, String str2) {
        Zeus.loadPlugin(str2);
        C6197c m37017a = C6197c.m37017a();
        if (intentFilter == null || intentFilter.actionsIterator() == null) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            return context.registerReceiver(null, intentFilter);
        }
        C6189a c6189a = new C6189a();
        Intent registerReceiver = context.registerReceiver(c6189a, intentFilter, str, handler);
        m37017a.f22130b.put(pluginBroadcastReceiver, c6189a);
        if (handler != null) {
            m37017a.f22131c.add(Integer.valueOf(c6189a.hashCode()));
        }
        m37017a.m37015a(intentFilter, pluginBroadcastReceiver);
        return registerReceiver;
    }

    public static void startActivity(Context context, Intent intent, String str) {
        realStartActivity(null, context, intent, null, str);
    }

    public static void startActivityForResult(Activity activity, Intent intent, int i, Bundle bundle, String str) {
        realStartActivityForResult(null, activity, intent, i, bundle, str);
    }

    public static void startActivity(Context context, Intent intent, Bundle bundle, String str) {
        realStartActivity(null, context, intent, bundle, str);
    }

    public static Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, int i, String str) {
        Zeus.loadPlugin(str);
        C6197c m37017a = C6197c.m37017a();
        if (intentFilter == null || intentFilter.actionsIterator() == null || Build.VERSION.SDK_INT < 26) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            return context.registerReceiver(null, intentFilter);
        }
        C6189a c6189a = new C6189a();
        Intent registerReceiver = context.registerReceiver(c6189a, intentFilter, i);
        m37017a.f22130b.put(pluginBroadcastReceiver, c6189a);
        m37017a.m37015a(intentFilter, pluginBroadcastReceiver);
        return registerReceiver;
    }

    public static Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i, String str2) {
        Zeus.loadPlugin(str2);
        C6197c m37017a = C6197c.m37017a();
        if (intentFilter == null || intentFilter.actionsIterator() == null || Build.VERSION.SDK_INT < 26) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            return context.registerReceiver(null, intentFilter);
        }
        C6189a c6189a = new C6189a();
        Intent registerReceiver = context.registerReceiver(c6189a, intentFilter, str, handler, i);
        m37017a.f22130b.put(pluginBroadcastReceiver, c6189a);
        if (handler != null) {
            m37017a.f22131c.add(Integer.valueOf(c6189a.hashCode()));
        }
        m37017a.m37015a(intentFilter, pluginBroadcastReceiver);
        return registerReceiver;
    }
}

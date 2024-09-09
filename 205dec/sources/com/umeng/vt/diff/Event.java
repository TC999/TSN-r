package com.umeng.vt.diff;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.tunnel.UMChannelAgent;
import com.umeng.vt.diff.util.ClassLoadUtil;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class Event {
    private static final int MAX_PROPERTY_LENGTH = 128;

    public static void commit(Context context, View view, String str, Map<String, Object> map, Boolean bool) {
        if (bool.booleanValue()) {
            if (UMChannelAgent.init()) {
                if (view != null) {
                    String textPropertyFromView = textPropertyFromView(view);
                    if (!TextUtils.isEmpty(textPropertyFromView)) {
                        map.put("_$!text", textPropertyFromView);
                    }
                    map.put("_$!pg", view.getContext().getClass().getName());
                } else {
                    map.put("_$!pg", context.getClass().getName());
                }
                map.put("_$!style", 1);
                map.put("_$!uapp_pg", getPageName());
                UMRTLog.e("MobclickRT", "config:\u4e8b\u4ef6\u540d: " + str);
                if (map.containsKey("_$!text")) {
                    UMRTLog.e("MobclickRT", "config:\u4e8b\u4ef6\u540d: " + str + "; \u53c2\u6570\uff1a" + ((String) map.get("_$!text")));
                }
                if (map.containsKey("_$!pg")) {
                    UMRTLog.e("MobclickRT", "config:\u4e8b\u4ef6\u540d: " + str + "; \u9875\u9762\uff1a" + ((String) map.get("_$!pg")));
                }
                if (map.containsKey("_$!uapp_pg")) {
                    UMRTLog.e("MobclickRT", "config:\u4e8b\u4ef6\u540d: " + str + "; UApp\u9875\u9762\u8def\u5f84\uff1a" + ((String) map.get("_$!uapp_pg")));
                }
                UMChannelAgent.onDebugEvent(context, str, map);
                return;
            }
            return;
        }
        if (view != null) {
            String textPropertyFromView2 = textPropertyFromView(view);
            if (!TextUtils.isEmpty(textPropertyFromView2)) {
                map.put("_$!text", textPropertyFromView2);
            }
            map.put("_$!pg", view.getContext().getClass().getName());
        } else {
            map.put("_$!pg", context.getClass().getName());
        }
        map.put("_$!style", 1);
        map.put("_$!uapp_pg", getPageName());
        UMRTLog.e("MobclickRT", "release:\u4e8b\u4ef6\u540d: " + str);
        if (map.containsKey("_$!text")) {
            UMRTLog.e("MobclickRT", "release:\u4e8b\u4ef6\u540d: " + str + "; \u53c2\u6570\uff1a" + ((String) map.get("_$!text")));
        }
        if (map.containsKey("_$!pg")) {
            UMRTLog.e("MobclickRT", "release:\u4e8b\u4ef6\u540d: " + str + "; \u9875\u9762\uff1a" + ((String) map.get("_$!pg")));
        }
        if (map.containsKey("_$!uapp_pg")) {
            UMRTLog.e("MobclickRT", "release:\u4e8b\u4ef6\u540d: " + str + "; UApp\u9875\u9762\u8def\u5f84\uff1a" + ((String) map.get("_$!uapp_pg")));
        }
        MobclickAgent.onEventObject(context, str, map);
    }

    public static String getActivityName(View view) {
        Context context;
        if (view == null || (context = view.getContext()) == null) {
            return null;
        }
        if (context instanceof ContextWrapper) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (context instanceof Activity) {
            return context.getClass().getCanonicalName();
        }
        return null;
    }

    public static String getPageName(View view) {
        String pageName = getPageName();
        if (pageName == null || pageName.equals("") || pageName.equals("VT")) {
            String activityName = getActivityName(view);
            return (activityName == null || activityName.equals("")) ? "VT" : activityName;
        }
        return pageName;
    }

    public static void init(Context context, String str, String str2, int i4, String str3) {
    }

    public static void openDebug(String str) {
    }

    private static void reflectTrack(Context context, String str, Map<String, Object> map) {
        Method method;
        try {
            Class<?> findClass = ClassLoadUtil.findClass("com.umeng.analytics.MobclickAgent");
            if (findClass == null || (method = findClass.getMethod("onEvent", Context.class, String.class, Map.class)) == null) {
                return;
            }
            method.invoke(null, context, str, map);
        } catch (Exception unused) {
        }
    }

    private static String textPropertyFromView(View view) {
        if (view instanceof TextView) {
            CharSequence text = ((TextView) view).getText();
            if (text != null) {
                return text.toString();
            }
            return null;
        } else if (view instanceof ViewGroup) {
            StringBuilder sb = new StringBuilder();
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            boolean z3 = false;
            for (int i4 = 0; i4 < childCount && sb.length() < 128; i4++) {
                String textPropertyFromView = textPropertyFromView(viewGroup.getChildAt(i4));
                if (textPropertyFromView != null && textPropertyFromView.length() > 0) {
                    if (z3) {
                        sb.append(", ");
                    }
                    sb.append(textPropertyFromView);
                    z3 = true;
                }
            }
            if (sb.length() > 128) {
                return sb.substring(0, 128);
            }
            if (z3) {
                return sb.toString();
            }
            return null;
        } else {
            return null;
        }
    }

    public static String getPageName() {
        String currenPageName = PageNameMonitor.getInstance().getCurrenPageName();
        return TextUtils.isEmpty(currenPageName) ? "" : currenPageName;
    }
}

package xyz.adscope.ad.tool.persistent.sp;

import android.content.Context;
import java.util.Map;
import xyz.adscope.ad.AdScopeSDK;
import xyz.adscope.common.sp.CommonSpUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdScopeSpUtil {
    public static void clear(Context context) {
        if (AdScopeSDK.getContext() != null) {
            CommonSpUtil.clear(AdScopeSDK.getContext());
        }
    }

    public static boolean contains(String str) {
        if (AdScopeSDK.getContext() != null) {
            return CommonSpUtil.contains(AdScopeSDK.getContext(), str);
        }
        return false;
    }

    public static Object get(String str, Object obj) {
        if (AdScopeSDK.getContext() != null) {
            return CommonSpUtil.get(AdScopeSDK.getContext(), str, obj);
        }
        return null;
    }

    public static Map<String, ?> getAll() {
        if (AdScopeSDK.getContext() != null) {
            return CommonSpUtil.getAll(AdScopeSDK.getContext());
        }
        return null;
    }

    public static String getString(String str) {
        if (AdScopeSDK.getContext() != null) {
            return CommonSpUtil.getString(AdScopeSDK.getContext(), str);
        }
        return null;
    }

    public static void put(String str, Object obj) {
        if (AdScopeSDK.getContext() != null) {
            CommonSpUtil.put(AdScopeSDK.getContext(), str, obj);
        }
    }

    public static void putString(String str, String str2) {
        if (AdScopeSDK.getContext() != null) {
            CommonSpUtil.putString(AdScopeSDK.getContext(), str, str2);
        }
    }

    public static void remove(String str) {
        if (AdScopeSDK.getContext() != null) {
            CommonSpUtil.remove(AdScopeSDK.getContext(), str);
        }
    }
}

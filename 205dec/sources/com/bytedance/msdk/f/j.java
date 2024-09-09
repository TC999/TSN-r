package com.bytedance.msdk.f;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class j extends HashMap<String, Object> {
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    @Nullable
    /* renamed from: c */
    public Object put(String str, Object obj) {
        if ("gm_usb".equals(str)) {
            if (!com.bytedance.msdk.core.c.w().eq()) {
                obj = "\u63a5\u53e3\u83b7\u53d6\u65e0\u6743\u9650\uff0c\u8bf7\u8054\u7cfb\u5546\u52a1\u5f00\u901a";
            }
            return super.put(str, obj);
        }
        if ("usePolicy".equals(str) && com.bytedance.msdk.core.c.w().me() && (obj instanceof JSONObject)) {
            JSONObject jSONObject = (JSONObject) obj;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!com.bytedance.msdk.core.w.k().sr().containsKey(next)) {
                    com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "KEY_USE_POLICY\u7684adLoad\u53c2\u6570\u4e2d\u5b58\u5728\u4e0d\u5408\u6cd5key\uff1a" + next + "\uff0c\u8be5key\u5c06\u88ab\u79fb\u9664\uff0c\u5982\u9700\u8981\u81ea\u5b9a\u4e49key \u8bf7\u901a\u8fc7 KEY_USE_POLICY \u4e2d\u7684 KEY_USE_POLICY_OBJ_CUSTOM \u5b9e\u73b0");
                } else {
                    Object opt = jSONObject.opt(next);
                    if (opt != null && !c(String.valueOf(opt))) {
                        Log.e("TTMediationSDK", "adLoad\u53c2\u6570\u4e2dkey\u4e3a " + next + " \u5b57\u6bb5\u7684\u503c\uff0c" + opt + " \u5b58\u5728\u4e0d\u5408\u6cd5\u8f93\u5165");
                    }
                }
            }
        }
        return super.put(str, obj);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    @Nullable
    public Object get(@Nullable Object obj) {
        if ("gm_usb".equals(obj)) {
            com.bytedance.msdk.core.w.k().c(true);
            if (!com.bytedance.msdk.core.c.w().eq()) {
                return "\u63a5\u53e3\u83b7\u53d6\u65e0\u6743\u9650\uff0c\u8bf7\u8054\u7cfb\u5546\u52a1\u5f00\u901a";
            }
        } else if ("gm_policy".equals(obj)) {
            if (!com.bytedance.msdk.core.c.w().me()) {
                return "\u63a5\u53e3\u83b7\u53d6\u65e0\u6743\u9650\uff0c\u8bf7\u8054\u7cfb\u5546\u52a1\u5f00\u901a";
            }
            Object obj2 = get("prime_rit");
            if (obj2 instanceof String) {
                String str = (String) obj2;
                com.bytedance.msdk.core.w.w xk = com.bytedance.msdk.core.c.w().xk();
                if (xk != null) {
                    return xk.c(str, this);
                }
            }
        }
        return super.get(obj);
    }

    @Override // java.util.HashMap, java.util.Map
    @Nullable
    public Object getOrDefault(@Nullable Object obj, @Nullable Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(@NonNull Map<? extends String, ?> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<? extends String, ?> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[A-Za-z0-9-_]{1,100}");
    }
}

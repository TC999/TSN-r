package com.bytedance.msdk.core.s;

import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {
    public static <T> T c(Class<T> cls) {
        if (cls != Boolean.class && cls != Boolean.TYPE) {
            if (cls != Integer.class && cls != Integer.TYPE) {
                if (cls != Long.class && cls != Long.TYPE) {
                    if (cls != Float.class && cls != Float.TYPE) {
                        if (cls == Double.class || cls == Double.TYPE) {
                            return (T) Double.valueOf(0.0d);
                        }
                        return null;
                    }
                    return (T) Float.valueOf(0.0f);
                }
                return (T) 0L;
            }
            return (T) 0;
        }
        return (T) Boolean.FALSE;
    }

    public static Object c(Map<String, Object> map) {
        if (map != null) {
            return map.get("key_baidu_request_parameters");
        }
        return null;
    }
}

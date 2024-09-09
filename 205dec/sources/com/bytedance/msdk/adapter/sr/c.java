package com.bytedance.msdk.adapter.sr;

import android.content.Context;
import com.bytedance.pangle.wrapper.PluginActivityWrapper;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {
    public static Object c(Context context) {
        if (context != null) {
            Object obj = null;
            try {
                if (context.getClass() == PluginActivityWrapper.class) {
                    obj = ((PluginActivityWrapper) context).mOriginActivity;
                } else if (context.getClass() == PluginApplicationWrapper.class) {
                    obj = ((PluginApplicationWrapper) context).mOriginApplication;
                }
                if (obj != null) {
                    return obj;
                }
            } catch (Throwable unused) {
            }
        }
        return context;
    }
}

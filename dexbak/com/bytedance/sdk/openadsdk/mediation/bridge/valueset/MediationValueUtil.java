package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import com.github.mikephil.charting.utils.Utils;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MediationValueUtil {
    public static <T> T checkClassType(Class<T> cls) {
        if (cls != Boolean.class && cls != Boolean.TYPE) {
            if (cls != Integer.class && cls != Integer.TYPE) {
                if (cls != Long.class && cls != Long.TYPE) {
                    if (cls != Float.class && cls != Float.TYPE) {
                        if (cls == Double.class || cls == Double.TYPE) {
                            return (T) Double.valueOf((double) Utils.DOUBLE_EPSILON);
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
}

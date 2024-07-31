package com.bytedance.msdk.adapter.config;

import android.text.TextUtils;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashSet;
import java.util.Set;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class DefaultAdapterClasses {

    /* renamed from: a */
    private static final Set<String> f21328a;

    static {
        HashSet hashSet = new HashSet();
        f21328a = hashSet;
        hashSet.add(MediationConstant.PANGLE_ADN_CLASS_NAME);
        hashSet.add(MediationConstant.UNITY_ADN_CLASS_NAME);
        hashSet.add(MediationConstant.BAIDU_ADN_CLASS_NAME);
        hashSet.add(MediationConstant.SIGMOB_ADN_CLASS_NAME);
        hashSet.add(MediationConstant.ADMOB_ADN_CLASS_NAME);
        hashSet.add(MediationConstant.GDT_ADN_CLASS_NAME);
        hashSet.add(MediationConstant.KS_ADN_CLASS_NAME);
        hashSet.add(MediationConstant.MINTEGRAL_ADN_CLASS_NAME);
        hashSet.add(MediationConstant.KLEVIN_ADN_CLASS_NAME);
    }

    public static Class<?> getClass(String str) {
        String classNameByAdnName = getClassNameByAdnName(str);
        if (!TextUtils.isEmpty(classNameByAdnName)) {
            try {
                return Class.forName(classNameByAdnName);
            } catch (Throwable th) {
                th.printStackTrace();
                Logger.m37557e("TTMediationSDK_ADAPTER", "DefaultAdapterClasses#getClass error:" + th.toString());
            }
        }
        return null;
    }

    public static String getClassNameByAdnName(String str) {
        return "pangle".equals(str) ? MediationConstant.PANGLE_ADN_CLASS_NAME : "unity".equals(str) ? MediationConstant.UNITY_ADN_CLASS_NAME : "baidu".equals(str) ? MediationConstant.BAIDU_ADN_CLASS_NAME : "admob".equals(str) ? MediationConstant.ADMOB_ADN_CLASS_NAME : "gdt".equals(str) ? MediationConstant.GDT_ADN_CLASS_NAME : "ks".equals(str) ? MediationConstant.KS_ADN_CLASS_NAME : "sigmob".equals(str) ? MediationConstant.SIGMOB_ADN_CLASS_NAME : "mintegral".equals(str) ? MediationConstant.MINTEGRAL_ADN_CLASS_NAME : "klevin".equals(str) ? MediationConstant.KLEVIN_ADN_CLASS_NAME : "";
    }

    public static Set<String> getClassNamesSet() {
        return f21328a;
    }
}

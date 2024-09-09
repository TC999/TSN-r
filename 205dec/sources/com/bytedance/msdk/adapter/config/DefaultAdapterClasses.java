package com.bytedance.msdk.adapter.config;

import android.text.TextUtils;
import com.bytedance.msdk.adapter.util.Logger;
import java.util.HashSet;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class DefaultAdapterClasses {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f26938a;

    static {
        HashSet hashSet = new HashSet();
        f26938a = hashSet;
        hashSet.add("com.bytedance.msdk.adapter.pangle.PangleAdapterConfiguration");
        hashSet.add("com.bytedance.msdk.adapter.unity.UnityAdapterConfiguration");
        hashSet.add("com.bytedance.msdk.adapter.baidu.BaiduAdapterConfiguration");
        hashSet.add("com.bytedance.msdk.adapter.sigmob.SigmobAdapterConfiguration");
        hashSet.add("com.bytedance.msdk.adapter.admob.AdmobAdapterConfiguration");
        hashSet.add("com.bytedance.msdk.adapter.gdt.GdtAdapterConfiguration");
        hashSet.add("com.bytedance.msdk.adapter.ks.KsAdapterConfiguration");
        hashSet.add("com.bytedance.msdk.adapter.mintegral.MintegralAdapterConfiguration");
        hashSet.add("com.bytedance.msdk.adapter.klevin.KlevinAdapterConfiguration");
    }

    public static Class<?> getClass(String str) {
        String classNameByAdnName = getClassNameByAdnName(str);
        if (!TextUtils.isEmpty(classNameByAdnName)) {
            try {
                return Class.forName(classNameByAdnName);
            } catch (Throwable th) {
                th.printStackTrace();
                Logger.e("TTMediationSDK_ADAPTER", "DefaultAdapterClasses#getClass error:" + th.toString());
            }
        }
        return null;
    }

    public static String getClassNameByAdnName(String str) {
        return "pangle".equals(str) ? "com.bytedance.msdk.adapter.pangle.PangleAdapterConfiguration" : "unity".equals(str) ? "com.bytedance.msdk.adapter.unity.UnityAdapterConfiguration" : "baidu".equals(str) ? "com.bytedance.msdk.adapter.baidu.BaiduAdapterConfiguration" : "admob".equals(str) ? "com.bytedance.msdk.adapter.admob.AdmobAdapterConfiguration" : "gdt".equals(str) ? "com.bytedance.msdk.adapter.gdt.GdtAdapterConfiguration" : "ks".equals(str) ? "com.bytedance.msdk.adapter.ks.KsAdapterConfiguration" : "sigmob".equals(str) ? "com.bytedance.msdk.adapter.sigmob.SigmobAdapterConfiguration" : "mintegral".equals(str) ? "com.bytedance.msdk.adapter.mintegral.MintegralAdapterConfiguration" : "klevin".equals(str) ? "com.bytedance.msdk.adapter.klevin.KlevinAdapterConfiguration" : "";
    }

    public static Set<String> getClassNamesSet() {
        return f26938a;
    }
}

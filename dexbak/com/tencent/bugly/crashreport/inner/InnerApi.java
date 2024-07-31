package com.tencent.bugly.crashreport.inner;

import com.tencent.bugly.proguard.C12820al;
import com.tencent.bugly.proguard.C12853au;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class InnerApi {
    public static void postCocos2dxCrashAsync(int i, String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            C12820al.m15872e("post cocos2d-x fail args null", new Object[0]);
        } else if (i != 5 && i != 6) {
            C12820al.m15872e("post cocos2d-x fail category illeagle: %d", Integer.valueOf(i));
        } else {
            C12820al.m15878a("post cocos2d-x crash %s %s", str, str2);
            C12853au.m15734a(Thread.currentThread(), i, str, str2, str3, null);
        }
    }

    public static void postH5CrashAsync(Thread thread, String str, String str2, String str3, Map<String, String> map) {
        if (str != null && str2 != null && str3 != null) {
            C12820al.m15878a("post h5 crash %s %s", str, str2);
            C12853au.m15734a(thread, 8, str, str2, str3, map);
            return;
        }
        C12820al.m15872e("post h5 fail args null", new Object[0]);
    }

    public static void postU3dCrashAsync(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            C12820al.m15872e("post u3d fail args null", new Object[0]);
        }
        C12820al.m15878a("post u3d crash %s %s", str, str2);
        C12853au.m15734a(Thread.currentThread(), 4, str, str2, str3, null);
    }
}

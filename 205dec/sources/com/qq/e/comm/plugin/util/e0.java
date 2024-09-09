package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e0 {
    public static boolean a(String str) {
        return i2.b(str, "ase", "1");
    }

    public static String b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            int a4 = com.qq.e.comm.plugin.d0.a.d().f().a("urlLimit", AVMDLDataLoader.KeyIsLiveSetLoaderType);
            int length = str.length() + str2.length();
            if (length <= a4) {
                return i2.c(str, "mu_p", str2);
            }
            d1.a("gdt_tag_p", "\u70b9\u51fburl\u8d85\u957f \uff0c url = %s ,p = %s", str, str2);
            com.qq.e.comm.plugin.n0.v.a(100162, null, Integer.valueOf(length / 1000));
        }
        return str;
    }

    public static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            int a4 = com.qq.e.comm.plugin.d0.a.d().f().a("urlLimit", AVMDLDataLoader.KeyIsLiveSetLoaderType);
            int length = str.length() + str2.length();
            if (length <= a4) {
                return i2.c(str, "mu_p", str2);
            }
            d1.a("gdt_tag_p", "\u70b9\u51fburl\u8d85\u957f \uff0c url = %s ,p = %s", str, str2);
            com.qq.e.comm.plugin.n0.v.a(100022, null, Integer.valueOf(length / 1000));
        }
        return str;
    }
}

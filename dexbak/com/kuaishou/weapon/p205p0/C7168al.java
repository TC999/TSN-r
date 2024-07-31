package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.al */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7168al {
    /* renamed from: a */
    public static boolean m34377a(Context context) {
        try {
            String[] strArr = {"/storage/emulated/0/DCIM/Camera/virtual.mp4", "/storage/emulated/0/DCIM/Camera1/virtual.mp4", "/storage/emulated/0/DCIM/Camera1/no-silent.jpg", "/storage/emulated/0/DCIM/Camera1/disable.jpg", "/storage/emulated/0/DCIM/Camera1/no_toast.jpg"};
            for (int i = 0; i < 5; i++) {
                if (new File(strArr[i]).exists()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* renamed from: b */
    public static JSONObject m34376b() {
        JSONObject jSONObject = new JSONObject();
        try {
            String[] strArr = {"/system/lib/.aa", "/sdcard/my/34.png", "/sdcard/my/do_not_change.txt", "/sdcard/my/34.mp4", "/sdcard/my/44.mp4", "/sdcard/QQ=99932701/", "/sdcard/QQ=99932701/Dict.txt"};
            int i = 0;
            for (int i2 = 0; i2 < 7; i2++) {
                if (new File(strArr[i2]).exists()) {
                    i |= 1 << i2;
                }
            }
            if (i > 0) {
                jSONObject.put("files", i);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* renamed from: c */
    public static int m34374c() {
        String[] strArr = {"/system/lib.aa", "/system/lib/ccc"};
        int i = 0;
        for (int i2 = 0; i2 < 2; i2++) {
            try {
                if (new File(strArr[i2]).exists()) {
                    i |= 1 << i2;
                }
            } catch (Exception unused) {
            }
        }
        return i;
    }

    /* renamed from: a */
    public static JSONObject m34378a() {
        JSONObject jSONObject = new JSONObject();
        try {
            int i = 0;
            String[] strArr = {"persist.sys.virtual_camera_flag", "persist.sys.camera_type", "persist.sys.camera_rotation"};
            for (int i2 = 0; i2 < 3; i2++) {
                String m34444a = C7157aa.m34446a().m34444a(strArr[i2]);
                if (!TextUtils.isEmpty(m34444a)) {
                    jSONObject.put(strArr[i2].substring(strArr[i2].lastIndexOf(46) + 1), m34444a);
                }
            }
            try {
                Class.forName("android.hardware.mockcamera.MockCamera");
                jSONObject.put("MockCamera", 1);
            } catch (ClassNotFoundException unused) {
            }
            String[] strArr2 = {"/sdcard/.imei.txt", "/sdcard/key.txt", "/sdcard/video/1.mp4", "/sdcard/video/test.txt", "/sdcard/video/.aa", "/sdcard/video/.new", "/sdcard/video/.old"};
            for (int i3 = 2; i3 < 7; i3++) {
                if (new File(strArr2[i3]).exists()) {
                    i = (1 << i3) | i;
                }
            }
            if (i > 0) {
                jSONObject.put("files", i);
            }
        } catch (Exception unused2) {
        }
        return jSONObject;
    }

    /* renamed from: b */
    public static JSONObject m34375b(Context context) {
        String[] strArr = {"/sdcard/my/44.mp4", "/system/lib/lic"};
        String[] strArr2 = {"com.yky"};
        JSONObject jSONObject = new JSONObject();
        try {
            int m34144a = C7200bp.m34144a(strArr);
            if (m34144a > 0) {
                jSONObject.put("f", m34144a);
            }
            PackageManager packageManager = context.getPackageManager();
            for (int i = 0; i <= 0; i++) {
                try {
                    packageManager.getApplicationInfo(strArr2[0], 0);
                    jSONObject.put(strArr2[0], 1);
                } catch (PackageManager.NameNotFoundException | JSONException unused) {
                }
            }
        } catch (Exception unused2) {
        }
        return jSONObject;
    }
}

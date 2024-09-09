package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class al {
    public static boolean a(Context context) {
        try {
            String[] strArr = {"/storage/emulated/0/DCIM/Camera/virtual.mp4", "/storage/emulated/0/DCIM/Camera1/virtual.mp4", "/storage/emulated/0/DCIM/Camera1/no-silent.jpg", "/storage/emulated/0/DCIM/Camera1/disable.jpg", "/storage/emulated/0/DCIM/Camera1/no_toast.jpg"};
            for (int i4 = 0; i4 < 5; i4++) {
                if (new File(strArr[i4]).exists()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            String[] strArr = {"/system/lib/.aa", "/sdcard/my/34.png", "/sdcard/my/do_not_change.txt", "/sdcard/my/34.mp4", "/sdcard/my/44.mp4", "/sdcard/QQ=99932701/", "/sdcard/QQ=99932701/Dict.txt"};
            int i4 = 0;
            for (int i5 = 0; i5 < 7; i5++) {
                if (new File(strArr[i5]).exists()) {
                    i4 |= 1 << i5;
                }
            }
            if (i4 > 0) {
                jSONObject.put("files", i4);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static int c() {
        String[] strArr = {"/system/lib.aa", "/system/lib/ccc"};
        int i4 = 0;
        for (int i5 = 0; i5 < 2; i5++) {
            try {
                if (new File(strArr[i5]).exists()) {
                    i4 |= 1 << i5;
                }
            } catch (Exception unused) {
            }
        }
        return i4;
    }

    public static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            int i4 = 0;
            String[] strArr = {"persist.sys.virtual_camera_flag", "persist.sys.camera_type", "persist.sys.camera_rotation"};
            for (int i5 = 0; i5 < 3; i5++) {
                String a4 = aa.a().a(strArr[i5]);
                if (!TextUtils.isEmpty(a4)) {
                    jSONObject.put(strArr[i5].substring(strArr[i5].lastIndexOf(46) + 1), a4);
                }
            }
            try {
                Class.forName("android.hardware.mockcamera.MockCamera");
                jSONObject.put("MockCamera", 1);
            } catch (ClassNotFoundException unused) {
            }
            String[] strArr2 = {"/sdcard/.imei.txt", "/sdcard/key.txt", "/sdcard/video/1.mp4", "/sdcard/video/test.txt", "/sdcard/video/.aa", "/sdcard/video/.new", "/sdcard/video/.old"};
            for (int i6 = 2; i6 < 7; i6++) {
                if (new File(strArr2[i6]).exists()) {
                    i4 = (1 << i6) | i4;
                }
            }
            if (i4 > 0) {
                jSONObject.put("files", i4);
            }
        } catch (Exception unused2) {
        }
        return jSONObject;
    }

    public static JSONObject b(Context context) {
        String[] strArr = {"/sdcard/my/44.mp4", "/system/lib/lic"};
        String[] strArr2 = {"com.yky"};
        JSONObject jSONObject = new JSONObject();
        try {
            int a4 = bp.a(strArr);
            if (a4 > 0) {
                jSONObject.put("f", a4);
            }
            PackageManager packageManager = context.getPackageManager();
            for (int i4 = 0; i4 <= 0; i4++) {
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

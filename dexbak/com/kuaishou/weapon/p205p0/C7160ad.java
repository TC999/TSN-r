package com.kuaishou.weapon.p205p0;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import tv.cjump.jni.DeviceUtils;

/* renamed from: com.kuaishou.weapon.p0.ad */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7160ad {
    /* renamed from: a */
    private String m34429a(String str) {
        int read;
        try {
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                byte[] bArr = new byte[1024];
                FileInputStream fileInputStream = new FileInputStream(file);
                String str2 = null;
                do {
                    read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    str2 = new String(bArr, 0, read);
                } while (read <= 0);
                fileInputStream.close();
                return str2;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static boolean m34428b() {
        if ("nokia".equalsIgnoreCase(Build.MANUFACTURER) && ("Nokia_N1".equalsIgnoreCase(Build.DEVICE) || "N1".equalsIgnoreCase(Build.MODEL))) {
            return false;
        }
        try {
            Process start = new ProcessBuilder("/system/bin/cat", "/proc/cpuinfo").start();
            StringBuffer stringBuffer = new StringBuffer();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream(), "utf-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (TextUtils.isEmpty(readLine)) {
                    break;
                }
                stringBuffer.append(readLine);
            }
            bufferedReader.close();
            String lowerCase = stringBuffer.toString().toLowerCase();
            if (!lowerCase.contains("intel") && !lowerCase.contains(DeviceUtils.f47125a)) {
                if (!lowerCase.contains("amd")) {
                    return false;
                }
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public boolean m34430a() {
        try {
            String m34429a = m34429a("/proc/tty/drivers");
            boolean z = !TextUtils.isEmpty(m34429a) && m34429a.contains("goldfish");
            if (!z) {
                String m34429a2 = m34429a("/proc/cpuinfo");
                if (!TextUtils.isEmpty(m34429a2)) {
                    if (m34429a2.contains("goldfish")) {
                        return true;
                    }
                }
            }
            return z;
        } catch (Exception unused) {
            return false;
        }
    }
}

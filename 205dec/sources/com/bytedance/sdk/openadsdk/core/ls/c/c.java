package com.bytedance.sdk.openadsdk.core.ls.c;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.ls.w;
import com.bytedance.sdk.openadsdk.core.xv.ux;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements w {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f33875c;

    /* renamed from: w  reason: collision with root package name */
    private static final FileFilter f33876w = new FileFilter() { // from class: com.bytedance.sdk.openadsdk.core.ls.c.c.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (name.startsWith("cpu")) {
                for (int i4 = 3; i4 < name.length(); i4++) {
                    if (!Character.isDigit(name.charAt(i4))) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    };

    @TargetApi(16)
    public static long c(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    private static int ev() {
        int xv = xv() / 1000;
        if (xv <= 1600) {
            return 0;
        }
        if (xv <= 2000) {
            return 1;
        }
        return xv <= 2500 ? 2 : 3;
    }

    public static int sr() {
        try {
            int w3 = w("/sys/devices/system/cpu/possible");
            if (w3 == -1) {
                w3 = w("/sys/devices/system/cpu/present");
            }
            return w3 == -1 ? new File("/sys/devices/system/cpu/").listFiles(f33876w).length : w3;
        } catch (NullPointerException | SecurityException unused) {
            return -1;
        }
    }

    public static c w() {
        if (f33875c == null) {
            synchronized (c.class) {
                if (f33875c == null) {
                    f33875c = new c();
                }
            }
        }
        return f33875c;
    }

    public static int xv() {
        int i4 = -1;
        for (int i5 = 0; i5 < sr(); i5++) {
            try {
                File file = new File("/sys/devices/system/cpu/cpu" + i5 + "/cpufreq/cpuinfo_max_freq");
                if (file.exists() && file.canRead()) {
                    byte[] bArr = new byte[128];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        int i6 = 0;
                        while (Character.isDigit(bArr[i6]) && i6 < 128) {
                            i6++;
                        }
                        Integer valueOf = Integer.valueOf(Integer.parseInt(new String(bArr, 0, i6)));
                        if (valueOf.intValue() > i4) {
                            i4 = valueOf.intValue();
                        }
                    } catch (NumberFormatException unused) {
                    } catch (Throwable th) {
                        fileInputStream.close();
                        throw th;
                    }
                    fileInputStream.close();
                }
            } catch (IOException unused2) {
                return -1;
            }
        }
        if (i4 == -1) {
            FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
            int c4 = c("cpu MHz", fileInputStream2) * 1000;
            if (c4 > i4) {
                i4 = c4;
            }
            fileInputStream2.close();
        }
        return i4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ls.w
    public String c() {
        return "DeviceRate";
    }

    public int f() {
        int w3 = w(ls.getContext());
        int ev = ev();
        int i4 = 2;
        if (w3 != 0 && w3 != 1 && ev != 0) {
            if (w3 != 2 || ev < 1) {
                if (w3 <= 2) {
                    i4 = -1000;
                } else if (ev > 1) {
                    i4 = 0;
                }
            }
            i4 = 1;
        }
        a.w("DeviceRateStrategy", "ram level is " + w3 + " cpu level is " + ev + " level is " + i4);
        c("ram_level", String.valueOf(w3));
        c("cpu_level", String.valueOf(ev));
        c("update_time", String.valueOf(System.currentTimeMillis()));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ram", w3);
            jSONObject.put("cpu", ev);
            jSONObject.put("level", i4);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        com.bytedance.sdk.openadsdk.core.fz.a.c().sr(jSONObject);
        c(i4);
        return i4;
    }

    public boolean r() {
        String c4 = c("update_time");
        return c4.isEmpty() || System.currentTimeMillis() - Long.parseLong(c4) >= 15552000000L;
    }

    public void ux() {
        if (ls.w().uj() && r()) {
            f();
        }
    }

    private static int c(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[1024];
        try {
            int read = fileInputStream.read(bArr);
            int i4 = 0;
            while (i4 < read) {
                if (bArr[i4] == 10 || i4 == 0) {
                    if (bArr[i4] == 10) {
                        i4++;
                    }
                    for (int i5 = i4; i5 < read; i5++) {
                        int i6 = i5 - i4;
                        if (bArr[i5] != str.charAt(i6)) {
                            break;
                        } else if (i6 == str.length() - 1) {
                            return c(bArr, i5);
                        }
                    }
                    continue;
                }
                i4++;
            }
            return -1;
        } catch (IOException | NumberFormatException e4) {
            e4.printStackTrace();
            return -1;
        }
    }

    private static int w(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            int xv = xv(readLine);
            fileInputStream.close();
            return xv;
        } catch (IOException unused) {
            return -1;
        }
    }

    private static int c(byte[] bArr, int i4) {
        while (i4 < bArr.length && bArr[i4] != 10) {
            if (Character.isDigit(bArr[i4])) {
                int i5 = i4 + 1;
                while (i5 < bArr.length && Character.isDigit(bArr[i5])) {
                    i5++;
                }
                return Integer.parseInt(new String(bArr, 0, i4, i5 - i4));
            }
            i4++;
        }
        return -1;
    }

    private static int w(Context context) {
        long c4 = c(context) / 1048576;
        if (c4 <= 2000) {
            return 0;
        }
        if (c4 <= 3000) {
            return 1;
        }
        if (c4 <= 4000) {
            return 2;
        }
        return c4 <= 6000 ? 3 : 4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ls.w
    public String c(String str) {
        return com.bytedance.sdk.component.f.xv.w.w.c(c(), ls.getContext()).w(str, "");
    }

    private static int xv(String str) {
        if (str == null || !str.matches("0-[\\d]+$")) {
            return -1;
        }
        return Integer.valueOf(str.substring(2)).intValue() + 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ls.w
    public void c(String str, String str2) {
        com.bytedance.sdk.component.f.xv.w.w.c(c(), ls.getContext()).c(str, str2);
    }

    private void c(int i4) {
        c("device_level", String.valueOf(i4));
        ux.c().bk(i4);
    }
}

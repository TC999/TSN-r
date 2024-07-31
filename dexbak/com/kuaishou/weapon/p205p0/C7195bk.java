package com.kuaishou.weapon.p205p0;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* renamed from: com.kuaishou.weapon.p0.bk */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7195bk {

    /* renamed from: a */
    private static final String f24595a = "/proc/cpuinfo";

    /* renamed from: a */
    public static String m34214a() {
        try {
            String str = Build.CPU_ABI;
            String str2 = Build.CPU_ABI2;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (!TextUtils.isEmpty(str2)) {
                sb.append(";" + str2);
            }
            String m34262a = C7191bh.m34262a("ro.product.cpu.abilist");
            if (!TextUtils.isEmpty(m34262a)) {
                sb.append(";" + m34262a);
            }
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: b */
    public static C7194bj m34213b() {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        String[] split;
        try {
            fileInputStream = new FileInputStream(new File(f24595a));
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        C7194bj c7194bj = new C7194bj();
                        int i = 0;
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                if (!TextUtils.isEmpty(readLine)) {
                                    if (readLine.contains("Processor")) {
                                        String[] split2 = readLine.split(":");
                                        if (split2 != null) {
                                            String trim = split2[1].trim();
                                            if (!TextUtils.isEmpty(trim)) {
                                                c7194bj.m34216b(trim);
                                            }
                                        }
                                    }
                                    if (readLine.contains("processor")) {
                                        String[] split3 = readLine.split(":");
                                        if (split3 != null) {
                                            String trim2 = split3[1].trim();
                                            if (!TextUtils.isEmpty(trim2)) {
                                                i = Integer.parseInt(trim2) + 1;
                                            }
                                        }
                                    }
                                    if (readLine.contains("Hardware") && (split = readLine.split(":")) != null) {
                                        String str = split[1];
                                        if (!TextUtils.isEmpty(str)) {
                                            c7194bj.m34218a(str);
                                        }
                                    }
                                }
                            } else {
                                c7194bj.m34219a(i);
                                bufferedReader.close();
                                inputStreamReader.close();
                                fileInputStream.close();
                                return c7194bj;
                            }
                        }
                    } catch (Throwable unused) {
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return null;
                    }
                } catch (Throwable unused2) {
                    bufferedReader = null;
                }
            } catch (Throwable unused3) {
                inputStreamReader = null;
                bufferedReader = null;
            }
        } catch (Throwable unused4) {
            inputStreamReader = null;
            fileInputStream = null;
            bufferedReader = null;
        }
    }
}

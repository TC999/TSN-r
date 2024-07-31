package com.umeng.commonsdk.internal.utils;

import android.os.Build;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/* renamed from: com.umeng.commonsdk.internal.utils.e */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ExecShell {

    /* compiled from: ExecShell.java */
    /* renamed from: com.umeng.commonsdk.internal.utils.e$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum EnumC13233a {
        check_su_binary(new String[]{"/system/xbin/which", "su"});
        

        /* renamed from: b */
        String[] f38867b;

        EnumC13233a(String[] strArr) {
            this.f38867b = strArr;
        }
    }

    /* renamed from: a */
    public ArrayList m13908a(EnumC13233a enumC13233a) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT > 28) {
            return arrayList;
        }
        try {
            Process exec = Runtime.getRuntime().exec(enumC13233a.f38867b);
            new BufferedWriter(new OutputStreamWriter(exec.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine);
                } catch (Exception unused) {
                }
            }
            return arrayList;
        } catch (Exception unused2) {
            return null;
        }
    }
}

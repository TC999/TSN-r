package com.kuaishou.weapon.p205p0;

import android.os.Process;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;

/* renamed from: com.kuaishou.weapon.p0.af */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7162af {

    /* renamed from: a */
    private String[] f24475a = {"/sbin/.magisk/", "/sbin/.core/mirror", "/sbin/.core/img", "/sbin/.core/db-0/magisk.db"};

    /* renamed from: a */
    public int m34422a() {
        File file = new File(String.format("/proc/%d/mounts", Integer.valueOf(Process.myPid())));
        try {
            HashSet hashSet = new HashSet();
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    String[] strArr = this.f24475a;
                    int length = strArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        } else if (readLine.contains(strArr[i])) {
                            hashSet.add(readLine);
                            break;
                        } else {
                            i++;
                        }
                    }
                } else {
                    bufferedReader.close();
                    fileInputStream.close();
                    return hashSet.size();
                }
            }
        } catch (Exception unused) {
            return 0;
        }
    }
}

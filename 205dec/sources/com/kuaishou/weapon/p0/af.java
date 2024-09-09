package com.kuaishou.weapon.p0;

import android.os.Process;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class af {

    /* renamed from: a  reason: collision with root package name */
    private String[] f37994a = {"/sbin/.magisk/", "/sbin/.core/mirror", "/sbin/.core/img", "/sbin/.core/db-0/magisk.db"};

    public int a() {
        File file = new File(String.format("/proc/%d/mounts", Integer.valueOf(Process.myPid())));
        try {
            HashSet hashSet = new HashSet();
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    String[] strArr = this.f37994a;
                    int length = strArr.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length) {
                            break;
                        } else if (readLine.contains(strArr[i4])) {
                            hashSet.add(readLine);
                            break;
                        } else {
                            i4++;
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

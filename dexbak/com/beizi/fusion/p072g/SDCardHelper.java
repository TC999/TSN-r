package com.beizi.fusion.p072g;

import java.io.File;

/* renamed from: com.beizi.fusion.g.ao */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class SDCardHelper {

    /* renamed from: a */
    private static String f11303a = "extra";

    /* renamed from: a */
    public static void m48380a(File file) {
        try {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        m48380a(file2);
                    }
                }
                file.delete();
            } else if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.bytedance.sdk.openadsdk.k.c;

import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class w {
    public static int c(InputStream inputStream, OutputStream outputStream) {
        long w3 = w(inputStream, outputStream);
        if (w3 > 2147483647L) {
            return -1;
        }
        return (int) w3;
    }

    private static long w(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        long j4 = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (-1 == read) {
                    return j4;
                }
                outputStream.write(bArr, 0, read);
                j4 += read;
            } catch (Exception unused) {
                return 0L;
            }
        }
    }

    public static boolean c(HashMap<String, HashMap<String, byte[]>> hashMap, String str) {
        try {
            Set<String> keySet = hashMap.keySet();
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(str));
            byte[] bArr = new byte[4096];
            for (String str2 : keySet) {
                HashMap<String, byte[]> hashMap2 = hashMap.get(str2);
                if (hashMap2 != null) {
                    for (String str3 : hashMap2.keySet()) {
                        byte[] bArr2 = hashMap2.get(str3);
                        if (bArr2 != null) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr2);
                            zipOutputStream.putNextEntry(new ZipEntry(str3));
                            while (true) {
                                int read = byteArrayInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                zipOutputStream.write(bArr, 0, read);
                            }
                            byteArrayInputStream.close();
                        }
                    }
                }
            }
            zipOutputStream.close();
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static void c(String str, String str2) {
        try {
            File file = new File(str);
            if (file.isDirectory()) {
                String[] list = file.list();
                byte[] bArr = new byte[4096];
                ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(str2));
                for (String str3 : list) {
                    File file2 = new File(file, str3);
                    if (!file2.isDirectory()) {
                        String path = file2.getPath();
                        int lastIndexOf = path.lastIndexOf(TTPathConst.sSeparator);
                        if (lastIndexOf != -1 && lastIndexOf != path.length()) {
                            path = path.substring(lastIndexOf + 1);
                        }
                        FileInputStream fileInputStream = new FileInputStream(file2);
                        zipOutputStream.putNextEntry(new ZipEntry(path));
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            zipOutputStream.write(bArr, 0, read);
                        }
                        fileInputStream.close();
                    }
                }
                zipOutputStream.close();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}

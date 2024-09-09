package com.bytedance.sdk.openadsdk.k.c;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class c {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f35933c = {71, 73, 70, 56, 55, 97};

    /* renamed from: w  reason: collision with root package name */
    private static final byte[] f35934w = {71, 73, 70, 56, 57, 97};
    private static final byte[] xv = {-1, -40, -1};
    private static final byte[] sr = {-119, 80, 78, 71, 13, 10, 26, 10};

    public static byte[] c(String str) {
        File file = new File(str);
        if (file.exists()) {
            try {
                return c(new FileInputStream(file));
            } catch (Exception e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static void w(String str) throws Exception {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            int length = listFiles.length;
            for (int i4 = 0; i4 < length; i4++) {
                if (listFiles[i4].isDirectory()) {
                    w(listFiles[i4].getAbsolutePath());
                } else {
                    listFiles[i4].delete();
                }
            }
            file.delete();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean c(java.io.InputStream r14, java.lang.String r15, java.lang.String r16, long r17) {
        /*
            Method dump skipped, instructions count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.k.c.c.c(java.io.InputStream, java.lang.String, java.lang.String, long):boolean");
    }

    public static byte[] c(InputStream inputStream) {
        if (inputStream == null) {
            return new byte[0];
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                c(bufferedInputStream, byteArrayOutputStream, 2048);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    bufferedInputStream.close();
                    byteArrayOutputStream.close();
                } catch (Exception unused) {
                }
                return byteArray;
            } catch (IOException e4) {
                e4.printStackTrace();
                try {
                    bufferedInputStream.close();
                    byteArrayOutputStream.close();
                } catch (Exception unused2) {
                }
                return new byte[0];
            }
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
                byteArrayOutputStream.close();
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    private static long c(InputStream inputStream, OutputStream outputStream, int i4) throws IOException {
        byte[] bArr = new byte[i4];
        int read = inputStream.read(bArr);
        long j4 = 0;
        while (read >= 0) {
            outputStream.write(bArr, 0, read);
            j4 += read;
            read = inputStream.read(bArr);
        }
        return j4;
    }
}

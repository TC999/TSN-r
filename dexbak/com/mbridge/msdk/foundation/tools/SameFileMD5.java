package com.mbridge.msdk.foundation.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.mbridge.msdk.foundation.tools.u */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class SameFileMD5 {

    /* renamed from: a */
    protected static char[] f31156a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b */
    protected static MessageDigest f31157b = null;

    /* renamed from: c */
    private static String f31158c = "SameFileMD5";

    static {
        f31157b = null;
        try {
            f31157b = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.err.println(SameFileMD5.class.getName() + "初始化失败，MessageDigest不支持MD5Util.");
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static String m21760a(File file) throws IOException {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    f31157b.update(fileInputStream2.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, file.length()));
                    byte[] digest = f31157b.digest();
                    String m21759a = m21759a(digest, 0, digest.length);
                    fileInputStream2.close();
                    return m21759a;
                } catch (Exception e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    SameLogTool.m21735b(f31158c, "FILE EXCEPTION", e);
                    if (fileInputStream != null) {
                        fileInputStream.close();
                        return "";
                    }
                    return "";
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    private static String m21759a(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2 * 2);
        int i3 = i2 + i;
        while (i < i3) {
            byte b = bArr[i];
            char[] cArr = f31156a;
            char c = cArr[(b & 240) >> 4];
            char c2 = cArr[b & 15];
            stringBuffer.append(c);
            stringBuffer.append(c2);
            i++;
        }
        return stringBuffer.toString();
    }
}

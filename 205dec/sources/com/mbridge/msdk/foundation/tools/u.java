package com.mbridge.msdk.foundation.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: SameFileMD5.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    protected static char[] f39929a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b  reason: collision with root package name */
    protected static MessageDigest f39930b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f39931c = "SameFileMD5";

    static {
        f39930b = null;
        try {
            f39930b = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e4) {
            System.err.println(u.class.getName() + "\u521d\u59cb\u5316\u5931\u8d25\uff0cMessageDigest\u4e0d\u652f\u6301MD5Util.");
            e4.printStackTrace();
        }
    }

    public static String a(File file) throws IOException {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    f39930b.update(fileInputStream2.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, file.length()));
                    byte[] digest = f39930b.digest();
                    String a4 = a(digest, 0, digest.length);
                    fileInputStream2.close();
                    return a4;
                } catch (Exception e4) {
                    e = e4;
                    fileInputStream = fileInputStream2;
                    x.b(f39931c, "FILE EXCEPTION", e);
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
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static String a(byte[] bArr, int i4, int i5) {
        StringBuffer stringBuffer = new StringBuffer(i5 * 2);
        int i6 = i5 + i4;
        while (i4 < i6) {
            byte b4 = bArr[i4];
            char[] cArr = f39929a;
            char c4 = cArr[(b4 & 240) >> 4];
            char c5 = cArr[b4 & 15];
            stringBuffer.append(c4);
            stringBuffer.append(c5);
            i4++;
        }
        return stringBuffer.toString();
    }
}

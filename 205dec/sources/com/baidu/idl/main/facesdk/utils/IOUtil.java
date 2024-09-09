package com.baidu.idl.main.facesdk.utils;

import java.io.Closeable;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class IOUtil {
    public static void close(Closeable... closeableArr) throws IOException {
        if (closeableArr != null) {
            for (Closeable closeable : closeableArr) {
                if (closeable != null) {
                    closeable.close();
                }
            }
        }
    }

    public static void closeQuietly(Closeable... closeableArr) {
        try {
            close(closeableArr);
        } catch (IOException unused) {
        }
    }
}

package com.bytedance.sdk.component.ux.xv.c.c;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
final class sr {

    /* renamed from: c  reason: collision with root package name */
    static final Charset f30275c = Charset.forName("US-ASCII");

    /* renamed from: w  reason: collision with root package name */
    static final Charset f30276w = Charset.forName("UTF-8");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    c(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete file: " + file2);
                }
            }
            return;
        }
        throw new IOException("not a readable directory: " + file);
    }
}

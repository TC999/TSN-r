package com.bumptech.glide.load.data.mediastore;

import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: FileService.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
class a {
    public boolean a(File file) {
        return file.exists();
    }

    public File b(String str) {
        return new File(str);
    }

    public long c(File file) {
        return file.length();
    }
}

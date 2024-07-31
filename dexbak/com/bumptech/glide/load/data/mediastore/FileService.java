package com.bumptech.glide.load.data.mediastore;

import java.io.File;

/* renamed from: com.bumptech.glide.load.data.mediastore.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class FileService {
    /* renamed from: a */
    public boolean m45459a(File file) {
        return file.exists();
    }

    /* renamed from: b */
    public File m45458b(String str) {
        return new File(str);
    }

    /* renamed from: c */
    public long m45457c(File file) {
        return file.length();
    }
}

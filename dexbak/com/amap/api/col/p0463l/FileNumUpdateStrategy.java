package com.amap.api.col.p0463l;

import java.io.File;

/* renamed from: com.amap.api.col.3l.q7 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class FileNumUpdateStrategy extends UpdateStrategy {

    /* renamed from: b */
    private int f5135b;

    /* renamed from: c */
    private String f5136c;

    public FileNumUpdateStrategy(String str, UpdateStrategy updateStrategy) {
        super(updateStrategy);
        this.f5135b = 30;
        this.f5136c = str;
    }

    /* renamed from: f */
    private static int m54099f(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.list().length;
            }
            return 0;
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "fus", "gfn");
            return 0;
        }
    }

    @Override // com.amap.api.col.p0463l.UpdateStrategy
    /* renamed from: d */
    protected final boolean mo53576d() {
        return m54099f(this.f5136c) >= this.f5135b;
    }
}

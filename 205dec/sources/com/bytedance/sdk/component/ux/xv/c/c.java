package com.bytedance.sdk.component.ux.xv.c;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.io.File;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements com.bytedance.sdk.component.ux.w, Cloneable {

    /* renamed from: f  reason: collision with root package name */
    private static volatile com.bytedance.sdk.component.ux.w f30255f;

    /* renamed from: c  reason: collision with root package name */
    private long f30256c;
    private boolean sr;
    private File ux;

    /* renamed from: w  reason: collision with root package name */
    private int f30257w;
    private boolean xv;

    public c(int i4, long j4, File file) {
        this(i4, j4, i4 != 0, j4 != 0, file);
    }

    private static long ev() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    public static com.bytedance.sdk.component.ux.w r() {
        return f30255f;
    }

    @Override // com.bytedance.sdk.component.ux.w
    @ATSMethod(1)
    public long c() {
        return this.f30256c;
    }

    @Override // com.bytedance.sdk.component.ux.w
    @ATSMethod(6)
    public boolean f() {
        return true;
    }

    @Override // com.bytedance.sdk.component.ux.w
    @ATSMethod(4)
    public boolean sr() {
        return this.sr;
    }

    @Override // com.bytedance.sdk.component.ux.w
    @ATSMethod(5)
    public File ux() {
        return this.ux;
    }

    @Override // com.bytedance.sdk.component.ux.w
    @ATSMethod(2)
    public int w() {
        return this.f30257w;
    }

    @Override // com.bytedance.sdk.component.ux.w
    @ATSMethod(3)
    public boolean xv() {
        return this.xv;
    }

    public c(int i4, long j4, boolean z3, boolean z4, File file) {
        this.f30256c = j4;
        this.f30257w = i4;
        this.xv = z3;
        this.sr = z4;
        this.ux = file;
    }

    public static void c(Context context, com.bytedance.sdk.component.ux.w wVar) {
        if (wVar != null) {
            f30255f = wVar;
        } else {
            f30255f = c(new File(com.bytedance.sdk.openadsdk.api.plugin.w.w(context), "image"));
        }
    }

    public static com.bytedance.sdk.component.ux.w c(File file) {
        int min;
        long min2;
        file.mkdirs();
        if (f30255f == null) {
            min = Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, 31457280);
            min2 = Math.min(ev() / 16, 41943040L);
        } else {
            min = Math.min(f30255f.w() / 2, 31457280);
            min2 = Math.min(f30255f.c() / 2, 41943040L);
        }
        return new c(Math.max(min, 26214400), Math.max(min2, 20971520L), file);
    }
}

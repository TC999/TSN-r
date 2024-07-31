package com.amap.api.col.p0463l;

import android.opengl.GLES20;

/* renamed from: com.amap.api.col.3l.t1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GlShader {

    /* renamed from: a */
    public int f5337a;

    /* renamed from: b */
    public int f5338b;

    /* renamed from: c */
    public int f5339c;

    /* renamed from: d */
    private boolean f5340d;

    /* renamed from: a */
    public final void m53893a() {
        int i = this.f5337a;
        if (i >= 0) {
            GLES20.glDeleteProgram(i);
        }
        int i2 = this.f5338b;
        if (i2 >= 0) {
            GLES20.glDeleteShader(i2);
        }
        int i3 = this.f5339c;
        if (i3 >= 0) {
            GLES20.glDeleteShader(i3);
        }
        this.f5340d = true;
    }
}

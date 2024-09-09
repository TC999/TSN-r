package com.amap.api.col.p0003l;

import android.opengl.GLES20;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: GlShader.java */
/* renamed from: com.amap.api.col.3l.t1  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class t1 {

    /* renamed from: a  reason: collision with root package name */
    public int f8980a;

    /* renamed from: b  reason: collision with root package name */
    public int f8981b;

    /* renamed from: c  reason: collision with root package name */
    public int f8982c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8983d;

    public final void a() {
        int i4 = this.f8980a;
        if (i4 >= 0) {
            GLES20.glDeleteProgram(i4);
        }
        int i5 = this.f8981b;
        if (i5 >= 0) {
            GLES20.glDeleteShader(i5);
        }
        int i6 = this.f8982c;
        if (i6 >= 0) {
            GLES20.glDeleteShader(i6);
        }
        this.f8983d = true;
    }
}

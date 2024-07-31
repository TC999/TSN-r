package com.amap.api.col.p0463l;

/* renamed from: com.amap.api.col.3l.u1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class GlShaderManager {

    /* renamed from: a */
    private C1954a f5431a;

    /* renamed from: b */
    private C1955b f5432b;

    /* renamed from: c */
    private C1955b f5433c;

    /* compiled from: GlShaderManager.java */
    /* renamed from: com.amap.api.col.3l.u1$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C1954a extends GlShader {
    }

    /* compiled from: GlShaderManager.java */
    /* renamed from: com.amap.api.col.3l.u1$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C1955b extends GlShader {
    }

    /* renamed from: a */
    public final synchronized void m53807a() {
        C1954a c1954a = this.f5431a;
        if (c1954a != null) {
            c1954a.m53893a();
            this.f5431a = null;
        }
        C1955b c1955b = this.f5432b;
        if (c1955b != null) {
            c1955b.m53893a();
            this.f5432b = null;
        }
        C1955b c1955b2 = this.f5433c;
        if (c1955b2 != null) {
            c1955b2.m53893a();
            this.f5433c = null;
        }
    }
}

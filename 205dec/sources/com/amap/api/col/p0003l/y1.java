package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.col.p0003l.x1;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.amap.mapcore.FileUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: CustomStyleTextureTask.java */
/* renamed from: com.amap.api.col.3l.y1  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class y1 extends a8 {

    /* renamed from: a  reason: collision with root package name */
    private Context f9512a;

    /* renamed from: b  reason: collision with root package name */
    private x1 f9513b;

    /* renamed from: c  reason: collision with root package name */
    private e2 f9514c;

    /* renamed from: d  reason: collision with root package name */
    private a f9515d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: CustomStyleTextureTask.java */
    /* renamed from: com.amap.api.col.3l.y1$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        void a(String str, e2 e2Var);
    }

    public y1(Context context) {
        this.f9512a = context;
        if (this.f9513b == null) {
            this.f9513b = new x1(context, "");
        }
    }

    private static String a(Context context) {
        return FileUtil.getMapBaseStorage(context);
    }

    private static void e(String str, byte[] bArr) {
        FileUtil.writeDatasToFile(str, bArr);
    }

    public final void b() {
        y2.a().b(this);
    }

    public final void c(e2 e2Var) {
        this.f9514c = e2Var;
    }

    public final void d(String str) {
        x1 x1Var = this.f9513b;
        if (x1Var != null) {
            x1Var.b(str);
        }
    }

    @Override // com.amap.api.col.p0003l.a8
    public final void runTask() {
        try {
            if (MapsInitializer.getNetWorkEnable()) {
                x1 x1Var = this.f9513b;
                if (x1Var != null) {
                    x1.a n4 = x1Var.n();
                    String str = null;
                    if (n4 != null && n4.f9387a != null) {
                        str = a(this.f9512a) + "/custom_texture_data";
                        e(str, n4.f9387a);
                    }
                    a aVar = this.f9515d;
                    if (aVar != null) {
                        aVar.a(str, this.f9514c);
                    }
                }
                u5.g(this.f9512a, a3.s());
            }
        } catch (Throwable th) {
            u5.p(th, "CustomStyleTask", "download customStyle");
            th.printStackTrace();
        }
    }

    public final void a() {
        this.f9512a = null;
        if (this.f9513b != null) {
            this.f9513b = null;
        }
    }

    public final void b(a aVar) {
        this.f9515d = aVar;
    }
}

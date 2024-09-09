package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.col.p0003l.u;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ScaleRotateGestureDetector.java */
/* renamed from: com.amap.api.col.3l.v  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class v extends u {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: ScaleRotateGestureDetector.java */
    /* renamed from: com.amap.api.col.3l.v$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static abstract class a implements u.a {
        @Override // com.amap.api.col.p0003l.u.a
        public final boolean a(u uVar) {
            return d((v) uVar);
        }

        @Override // com.amap.api.col.p0003l.u.a
        public final boolean b(u uVar) {
            return e((v) uVar);
        }

        @Override // com.amap.api.col.p0003l.u.a
        public final void c(u uVar) {
            f((v) uVar);
        }

        public abstract boolean d(v vVar);

        public abstract boolean e(v vVar);

        public abstract void f(v vVar);
    }

    public v(Context context, a aVar) {
        super(context, aVar);
    }

    public final float s() {
        return (float) (((Math.atan2(m(), l()) - Math.atan2(k(), j())) * 180.0d) / 3.141592653589793d);
    }
}

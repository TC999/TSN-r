package com.amap.api.col.p0463l;

import android.content.Context;
import com.amap.api.col.p0463l.ScaleGestureDetector;

/* renamed from: com.amap.api.col.3l.v */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ScaleRotateGestureDetector extends ScaleGestureDetector {

    /* compiled from: ScaleRotateGestureDetector.java */
    /* renamed from: com.amap.api.col.3l.v$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static abstract class AbstractC1966a implements ScaleGestureDetector.InterfaceC1953a {
        @Override // com.amap.api.col.p0463l.ScaleGestureDetector.InterfaceC1953a
        /* renamed from: a */
        public final boolean mo53678a(ScaleGestureDetector scaleGestureDetector) {
            return mo53675d((ScaleRotateGestureDetector) scaleGestureDetector);
        }

        @Override // com.amap.api.col.p0463l.ScaleGestureDetector.InterfaceC1953a
        /* renamed from: b */
        public final boolean mo53677b(ScaleGestureDetector scaleGestureDetector) {
            return mo53674e((ScaleRotateGestureDetector) scaleGestureDetector);
        }

        @Override // com.amap.api.col.p0463l.ScaleGestureDetector.InterfaceC1953a
        /* renamed from: c */
        public final void mo53676c(ScaleGestureDetector scaleGestureDetector) {
            mo53673f((ScaleRotateGestureDetector) scaleGestureDetector);
        }

        /* renamed from: d */
        public abstract boolean mo53675d(ScaleRotateGestureDetector scaleRotateGestureDetector);

        /* renamed from: e */
        public abstract boolean mo53674e(ScaleRotateGestureDetector scaleRotateGestureDetector);

        /* renamed from: f */
        public abstract void mo53673f(ScaleRotateGestureDetector scaleRotateGestureDetector);
    }

    public ScaleRotateGestureDetector(Context context, AbstractC1966a abstractC1966a) {
        super(context, abstractC1966a);
    }

    /* renamed from: s */
    public final float m53679s() {
        return (float) (((Math.atan2(m53818m(), m53819l()) - Math.atan2(m53820k(), m53821j())) * 180.0d) / 3.141592653589793d);
    }
}

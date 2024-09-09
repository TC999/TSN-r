package com.qq.e.comm.plugin.dl;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Pair;
import android.view.View;
import com.qq.e.dl.l.h;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class v extends com.qq.e.dl.l.a<b> {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a implements h.e {
        @Override // com.qq.e.dl.l.h.e
        public com.qq.e.dl.l.h a(com.qq.e.dl.a aVar) {
            if (com.qq.e.comm.plugin.t.c.a("cacit", "", 0) == 1) {
                return null;
            }
            return new v(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b extends com.qq.e.comm.plugin.r0.p.d implements com.qq.e.dl.l.e<v> {

        /* renamed from: g  reason: collision with root package name */
        protected com.qq.e.dl.l.h f42621g;

        public b(Context context) {
            super(context);
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            int i4;
            com.qq.e.dl.l.h hVar = this.f42621g;
            com.qq.e.dl.l.i.d g4 = hVar == null ? null : hVar.g();
            int i5 = 0;
            if (g4 != null) {
                i5 = getWidth();
                i4 = getHeight();
                g4.a(canvas, i5, i4);
            } else {
                i4 = 0;
            }
            super.draw(canvas);
            if (g4 != null) {
                g4.b(canvas, i5, i4);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i4, int i5) {
            com.qq.e.dl.l.k.a i6 = this.f42621g.i();
            Pair<Integer, Integer> d4 = i6.d(i4, i5);
            super.onMeasure(((Integer) d4.first).intValue(), ((Integer) d4.second).intValue());
            Pair<Integer, Integer> c4 = i6.c(i4, i5);
            if (c4 != null) {
                super.onMeasure(((Integer) c4.first).intValue(), ((Integer) c4.second).intValue());
            }
        }

        @Override // android.view.View
        protected void onVisibilityChanged(View view, int i4) {
            com.qq.e.dl.l.h hVar = this.f42621g;
            if (hVar != null) {
                hVar.a(view, i4);
            }
        }

        @Override // android.view.View
        public void setBackgroundColor(int i4) {
            this.f42621g.e(i4);
        }

        @Override // com.qq.e.dl.l.e
        public void a(v vVar) {
            this.f42621g = vVar;
        }
    }

    public v(com.qq.e.dl.a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.a
    /* renamed from: b */
    public b a(com.qq.e.dl.a aVar) {
        return new b(aVar.b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.h
    public boolean a(String str, com.qq.e.dl.k.g gVar) {
        if (((str.hashCode() == -1169023802 && str.equals("adModel")) ? (char) 0 : '\uffff') != 0) {
            return super.a(str, gVar);
        }
        ((b) this.f47039w).a((com.qq.e.comm.plugin.g0.e) gVar.c(new JSONObject[0]));
        return true;
    }
}

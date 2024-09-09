package com.qq.e.comm.plugin.dl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.dl.l.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class g0 extends com.qq.e.dl.l.a<b> {

    /* renamed from: x  reason: collision with root package name */
    private String f42438x;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a implements h.e {
        @Override // com.qq.e.dl.l.h.e
        public com.qq.e.dl.l.h a(com.qq.e.dl.a aVar) {
            return new g0(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b extends FrameLayout implements com.qq.e.dl.l.e<g0> {

        /* renamed from: c  reason: collision with root package name */
        private g0 f42439c;

        /* renamed from: d  reason: collision with root package name */
        private com.qq.e.comm.plugin.dl.p0.d f42440d;

        public b(Context context) {
            this(context, null);
        }

        @Override // android.view.View
        protected void onVisibilityChanged(View view, int i4) {
            this.f42439c.a(view, i4);
        }

        public b(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        public b(Context context, AttributeSet attributeSet, int i4) {
            super(context, attributeSet, i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            removeAllViews();
            if (this.f42440d != null) {
                this.f42439c.a().g().b(this.f42440d);
                this.f42440d = null;
            }
            int min = Math.min(this.f42439c.j().o(), this.f42439c.j().d());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(min, min);
            layoutParams.gravity = 17;
            if (!"doubleArrow".equals(this.f42439c.f42438x)) {
                if (!"3d".equals(this.f42439c.f42438x)) {
                    if ("doubleLine".equals(this.f42439c.f42438x)) {
                        addView(new com.qq.e.comm.plugin.dl.p0.a(getContext(), min), layoutParams);
                        this.f42440d = new com.qq.e.comm.plugin.dl.p0.c(getContext(), min);
                        this.f42439c.a().g().a(this.f42440d);
                        this.f42439c.a().g().b();
                        addView((View) this.f42440d, layoutParams);
                        return;
                    }
                    return;
                }
                this.f42440d = new com.qq.e.comm.plugin.dl.p0.e(getContext(), min);
                this.f42439c.a().g().a(this.f42440d);
                addView((View) this.f42440d, layoutParams);
                return;
            }
            addView(new com.qq.e.comm.plugin.dl.p0.a(getContext(), min), layoutParams);
            this.f42440d = new com.qq.e.comm.plugin.dl.p0.b(getContext(), min);
            this.f42439c.a().g().a(this.f42440d);
            addView((View) this.f42440d, layoutParams);
        }

        @Override // com.qq.e.dl.l.e
        public void a(g0 g0Var) {
            this.f42439c = g0Var;
        }
    }

    public g0(com.qq.e.dl.a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.a
    /* renamed from: b */
    public b a(com.qq.e.dl.a aVar) {
        return new b(aVar.b());
    }

    @Override // com.qq.e.dl.l.h
    public void c() {
        super.c();
        ((b) this.f47039w).a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.h
    public void u() {
        super.u();
        if (((com.qq.e.dl.l.k.b) this.f47070h).d()) {
            return;
        }
        ((b) this.f47039w).a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.h
    public boolean a(String str, com.qq.e.dl.k.g gVar) {
        if (((str.hashCode() == -169578751 && str.equals("twistType")) ? (char) 0 : '\uffff') != 0) {
            return super.a(str, gVar);
        }
        this.f42438x = gVar.toString();
        return true;
    }
}

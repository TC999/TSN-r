package com.qq.e.dl.l.k.e;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qq.e.dl.l.f;
import com.qq.e.dl.l.h;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class a extends com.qq.e.dl.l.k.b<c> {
    public a(h hVar, c cVar) {
        super(hVar, cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.k.a
    /* renamed from: b */
    public FrameLayout.LayoutParams a(com.qq.e.dl.l.b bVar) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams) new f(bVar));
        layoutParams.gravity = bVar.c();
        return layoutParams;
    }

    @Override // com.qq.e.dl.l.k.a
    protected void a(h hVar) {
        ((c) this.f47188g).addView(hVar.m(), a(hVar.j()));
    }
}

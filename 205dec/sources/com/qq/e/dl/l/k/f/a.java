package com.qq.e.dl.l.k.f;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.qq.e.dl.l.f;
import com.qq.e.dl.l.h;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class a extends com.qq.e.dl.l.k.b<b> {

    /* renamed from: h  reason: collision with root package name */
    private boolean f47192h;

    public a(h hVar, b bVar) {
        super(hVar, bVar);
        this.f47192h = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.k.a
    /* renamed from: b */
    public LinearLayout.LayoutParams a(com.qq.e.dl.l.b bVar) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams) new f(bVar));
        layoutParams.gravity = bVar.c();
        return layoutParams;
    }

    public boolean e() {
        return this.f47192h;
    }

    @Override // com.qq.e.dl.l.k.a
    protected void a(h hVar) {
        ((b) this.f47188g).addView(hVar.m(), a(hVar.j()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i4) {
        ((b) this.f47188g).setGravity(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i4) {
        if (i4 == 0) {
            this.f47192h = false;
            ((b) this.f47188g).setOrientation(0);
        } else if (i4 == 1) {
            this.f47192h = false;
            ((b) this.f47188g).setOrientation(1);
        } else if (i4 == 2) {
            this.f47192h = true;
            ((b) this.f47188g).setOrientation(0);
        } else if (i4 != 3) {
        } else {
            this.f47192h = true;
            ((b) this.f47188g).setOrientation(1);
        }
    }
}

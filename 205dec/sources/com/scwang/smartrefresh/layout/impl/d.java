package com.scwang.smartrefresh.layout.impl;

import android.view.MotionEvent;
import android.view.View;
import r0.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ScrollBoundaryDeciderAdapter.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class d implements i {

    /* renamed from: a  reason: collision with root package name */
    protected MotionEvent f48040a;

    /* renamed from: b  reason: collision with root package name */
    protected i f48041b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f48042c;

    @Override // r0.i
    public boolean a(View view) {
        i iVar = this.f48041b;
        if (iVar != null) {
            return iVar.a(view);
        }
        return com.scwang.smartrefresh.layout.util.d.b(view, this.f48040a);
    }

    @Override // r0.i
    public boolean b(View view) {
        i iVar = this.f48041b;
        if (iVar != null) {
            return iVar.b(view);
        }
        if (this.f48042c) {
            return !com.scwang.smartrefresh.layout.util.d.d(view, this.f48040a);
        }
        return com.scwang.smartrefresh.layout.util.d.a(view, this.f48040a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(MotionEvent motionEvent) {
        this.f48040a = motionEvent;
    }

    public void d(boolean z3) {
        this.f48042c = z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(i iVar) {
        this.f48041b = iVar;
    }
}

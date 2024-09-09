package com.bytedance.sdk.component.widget.recycler;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class ev {

    /* renamed from: c  reason: collision with root package name */
    protected final RecyclerView.gd f30589c;

    /* renamed from: w  reason: collision with root package name */
    final Rect f30590w;
    private int xv;

    public abstract int c(View view);

    public void c() {
        this.xv = f();
    }

    public abstract void c(int i4);

    public abstract int ev();

    public abstract int f();

    public abstract int f(View view);

    public abstract int r();

    public abstract int sr();

    public abstract int sr(View view);

    public abstract int ux();

    public abstract int ux(View view);

    public int w() {
        if (Integer.MIN_VALUE == this.xv) {
            return 0;
        }
        return f() - this.xv;
    }

    public abstract int w(View view);

    public abstract int xv();

    public abstract int xv(View view);

    private ev(RecyclerView.gd gdVar) {
        this.xv = Integer.MIN_VALUE;
        this.f30590w = new Rect();
        this.f30589c = gdVar;
    }

    public static ev c(RecyclerView.gd gdVar, int i4) {
        if (i4 != 0) {
            if (i4 == 1) {
                return w(gdVar);
            }
            throw new IllegalArgumentException("invalid orientation");
        }
        return c(gdVar);
    }

    public static ev w(RecyclerView.gd gdVar) {
        return new ev(gdVar) { // from class: com.bytedance.sdk.component.widget.recycler.ev.2
            @Override // com.bytedance.sdk.component.widget.recycler.ev
            public void c(int i4) {
                this.f30589c.p(i4);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ev
            public int ev() {
                return this.f30589c.j();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ev
            public int f(View view) {
                RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                return this.f30589c.ux(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ev
            public int r() {
                return this.f30589c.ba();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ev
            public int sr() {
                return this.f30589c.gb() - this.f30589c.ba();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ev
            public int ux() {
                return this.f30589c.gb();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ev
            public int w(View view) {
                return this.f30589c.p(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).bottomMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ev
            public int xv() {
                return this.f30589c.ck();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ev
            public int c(View view) {
                return this.f30589c.ev(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).topMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ev
            public int sr(View view) {
                this.f30589c.c(view, true, this.f30590w);
                return this.f30590w.top;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ev
            public int ux(View view) {
                RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                return this.f30589c.f(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ev
            public int xv(View view) {
                this.f30589c.c(view, true, this.f30590w);
                return this.f30590w.bottom;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ev
            public int f() {
                return (this.f30589c.gb() - this.f30589c.ck()) - this.f30589c.ba();
            }
        };
    }

    public static ev c(RecyclerView.gd gdVar) {
        return new ev(gdVar) { // from class: com.bytedance.sdk.component.widget.recycler.ev.1
            @Override // com.bytedance.sdk.component.widget.recycler.ev
            public void c(int i4) {
                this.f30589c.gd(i4);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ev
            public int ev() {
                return this.f30589c.q();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ev
            public int f(View view) {
                RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                return this.f30589c.f(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ev
            public int r() {
                return this.f30589c.z();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ev
            public int sr() {
                return this.f30589c.ls() - this.f30589c.z();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ev
            public int ux() {
                return this.f30589c.ls();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ev
            public int w(View view) {
                return this.f30589c.gd(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).rightMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ev
            public int xv() {
                return this.f30589c.n();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ev
            public int c(View view) {
                return this.f30589c.r(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).leftMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ev
            public int sr(View view) {
                this.f30589c.c(view, true, this.f30590w);
                return this.f30590w.left;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ev
            public int ux(View view) {
                RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                return this.f30589c.ux(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ev
            public int xv(View view) {
                this.f30589c.c(view, true, this.f30590w);
                return this.f30590w.right;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ev
            public int f() {
                return (this.f30589c.ls() - this.f30589c.n()) - this.f30589c.z();
            }
        };
    }
}

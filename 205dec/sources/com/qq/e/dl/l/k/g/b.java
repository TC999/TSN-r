package com.qq.e.dl.l.k.g;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qq.e.dl.l.f;
import com.qq.e.dl.l.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b extends com.qq.e.dl.l.k.b<e> {

    /* renamed from: h  reason: collision with root package name */
    private final LinearLayoutManager f47207h;

    public b(h hVar, e eVar) {
        super(hVar, eVar);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(eVar.getContext(), 0, false);
        this.f47207h = linearLayoutManager;
        eVar.setLayoutManager(linearLayoutManager);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i4) {
        this.f47207h.setOrientation(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        boolean z3 = this.f47207h.getOrientation() == 1;
        int height = (z3 ? ((e) this.f47188g).getHeight() : ((e) this.f47188g).getWidth()) / 2;
        int childCount = ((e) this.f47188g).getChildCount();
        int i4 = childCount / 2;
        while (i4 >= 0 && i4 < childCount) {
            View childAt = ((e) this.f47188g).getChildAt(i4);
            ViewGroup.MarginLayoutParams marginLayoutParams = childAt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) childAt.getLayoutParams() : null;
            if (z3) {
                int top2 = childAt.getTop();
                if (marginLayoutParams != null) {
                    top2 -= marginLayoutParams.topMargin;
                }
                if (top2 > height) {
                    i4--;
                } else {
                    int bottom = childAt.getBottom();
                    if (marginLayoutParams != null) {
                        bottom += marginLayoutParams.bottomMargin;
                    }
                    if (bottom >= height) {
                        return i4;
                    }
                    i4++;
                }
            } else {
                int left = childAt.getLeft();
                if (marginLayoutParams != null) {
                    left -= marginLayoutParams.leftMargin;
                }
                if (left > height) {
                    i4--;
                } else {
                    int right = childAt.getRight();
                    if (marginLayoutParams != null) {
                        right += marginLayoutParams.rightMargin;
                    }
                    if (right >= height) {
                        return i4;
                    }
                    i4++;
                }
            }
        }
        return -1;
    }

    @Override // com.qq.e.dl.l.k.a
    protected void e(int i4, int i5) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f47207h.findFirstCompletelyVisibleItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f47207h.findFirstVisibleItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f47207h.findLastCompletelyVisibleItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.f47207h.findLastVisibleItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.f47207h.getOrientation();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.k.a
    public ViewGroup.LayoutParams a(com.qq.e.dl.l.b bVar) {
        return new RecyclerView.LayoutParams((ViewGroup.MarginLayoutParams) new f(bVar));
    }

    @Override // com.qq.e.dl.l.k.a
    protected void a(h hVar) {
        hVar.m().setLayoutParams(a(hVar.j()));
    }
}

package com.bytedance.adsdk.ugeno.c.c;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.component.widget.recycler.ux;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class e extends RecyclerView.t {

    /* renamed from: a  reason: collision with root package name */
    private boolean f26009a = false;

    /* renamed from: b  reason: collision with root package name */
    private a f26010b;

    /* renamed from: c  reason: collision with root package name */
    private int f26011c;

    public e(a aVar) {
        this.f26010b = aVar;
    }

    private int a(View view) {
        Rect rect = new Rect();
        if (!view.getLocalVisibleRect(rect) || view.getMeasuredHeight() <= 0) {
            return -1;
        }
        return (rect.height() * 100) / view.getMeasuredHeight();
    }

    private boolean f(View view, int i4) {
        return view != null && view.getLocalVisibleRect(new Rect()) && view.getVisibility() == 0 && a(view) >= i4;
    }

    public abstract void b();

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.t
    public void c(RecyclerView recyclerView, int i4) {
        super.c(recyclerView, i4);
        Log.d("OnScrollListener", "onScrollStateChanged: newState = " + i4);
        ux uxVar = (ux) recyclerView.getLayoutManager();
        if (i4 == 0) {
            int a4 = uxVar.a();
            Log.d("OnScrollListener", "firstItemPosition = " + this.f26011c + "; lastItemPosition = " + a4);
            if (!f(uxVar.w(a4), 50)) {
                a4--;
            }
            int max = Math.max(0, Math.max(a4, this.f26011c));
            for (int min = Math.min(this.f26011c, a4); min <= max; min++) {
                e(min, uxVar.w(min));
                Log.d("OnScrollListener", "onScrollStateChanged: show pos = " + min);
            }
            this.f26011c = a4;
            int eq = uxVar.eq();
            this.f26010b.b(recyclerView);
            if ((a4 == eq - 1 && this.f26009a) || eq == 1) {
                b();
            }
        }
        g(recyclerView, i4);
    }

    public abstract void d(int i4, int i5);

    public abstract void e(int i4, View view);

    public abstract void g(RecyclerView recyclerView, int i4);

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.t
    public void c(RecyclerView recyclerView, int i4, int i5) {
        super.c(recyclerView, i4, i5);
        if (i5 == 0) {
            ux uxVar = (ux) recyclerView.getLayoutManager();
            this.f26011c = uxVar.p();
            int a4 = uxVar.a();
            if (!f(uxVar.w(a4), 50)) {
                a4--;
            }
            int max = Math.max(0, Math.max(a4, this.f26011c));
            for (int i6 = this.f26011c; i6 <= max; i6++) {
                Log.d("OnScrollListener", "onScrolled: show pos = " + i6);
                e(i6, uxVar.w(i6));
            }
        }
        this.f26009a = i5 > 0;
        this.f26010b.c();
        d(i4, i5);
    }
}

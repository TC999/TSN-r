package com.bytedance.adsdk.ugeno.c.c;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.adsdk.ugeno.c.c.d;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.component.widget.recycler.ux;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static int f25982d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static int f25983e = 1;

    /* renamed from: a  reason: collision with root package name */
    private d.a f25984a;

    /* renamed from: b  reason: collision with root package name */
    private int f25985b = 60;

    /* renamed from: c  reason: collision with root package name */
    private int f25986c = f25983e;

    private int a(View view) {
        Rect rect = new Rect();
        if (!view.getLocalVisibleRect(rect) || view.getMeasuredHeight() <= 0) {
            return -1;
        }
        return (rect.height() * 100) / view.getMeasuredHeight();
    }

    private boolean d(View view, int i4) {
        return view.getLocalVisibleRect(new Rect()) && view.getVisibility() == 0 && a(view) >= i4;
    }

    private int e(View view) {
        double c4 = l0.b.c(view.getContext());
        Double.isNaN(c4);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return Math.abs((iArr[1] + (view.getHeight() / 2)) - ((int) (c4 / 2.3d)));
    }

    public int b(RecyclerView recyclerView) {
        d.a aVar;
        View xv;
        d.a aVar2 = null;
        ux uxVar = recyclerView.getLayoutManager() instanceof ux ? (ux) recyclerView.getLayoutManager() : null;
        if (uxVar != null) {
            int a4 = uxVar.a();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (int p3 = uxVar.p(); p3 <= a4; p3++) {
                RecyclerView.j sr = recyclerView.sr(p3);
                if ((sr instanceof d.a) && (xv = (aVar = (d.a) sr).xv()) != null && d(xv, this.f25985b)) {
                    if (this.f25986c == f25982d) {
                        aVar.w();
                        this.f25984a = aVar;
                        return p3;
                    }
                    linkedHashMap.put(Integer.valueOf(p3), aVar);
                }
            }
            int i4 = Integer.MAX_VALUE;
            int i5 = -1;
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                int e4 = e(((d.a) entry.getValue()).xv());
                if (e4 < i4) {
                    i5 = ((Integer) entry.getKey()).intValue();
                    aVar2 = (d.a) entry.getValue();
                    i4 = e4;
                }
            }
            d.a aVar3 = this.f25984a;
            if (aVar3 != aVar2) {
                if (aVar3 != null) {
                    aVar3.c();
                }
                this.f25984a = aVar2;
            }
            d.a aVar4 = this.f25984a;
            if (aVar4 != null) {
                aVar4.w();
                return i5;
            }
        }
        return -1;
    }

    public void c() {
        d.a aVar = this.f25984a;
        if (aVar == null || aVar.xv() == null || d(this.f25984a.xv(), this.f25985b)) {
            return;
        }
        this.f25984a.c();
    }
}

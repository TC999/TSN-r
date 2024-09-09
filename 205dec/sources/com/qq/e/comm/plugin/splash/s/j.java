package com.qq.e.comm.plugin.splash.s;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.comm.plugin.b.k;
import com.qq.e.comm.plugin.g0.c0;
import com.qq.e.comm.plugin.r0.o;
import com.qq.e.comm.plugin.splash.s.b;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.l;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class j {
    public static b a(com.qq.e.comm.plugin.splash.h hVar, b.InterfaceC0895b interfaceC0895b, boolean z3) {
        i iVar;
        c0 b4 = hVar.b();
        if (!b4.Y0() || com.qq.e.comm.plugin.splash.j.d()) {
            iVar = new i(hVar, interfaceC0895b, b4.l1() && !z3);
            hVar.f46103o = 3;
        } else {
            iVar = null;
        }
        if (iVar == null || iVar.a() == null) {
            hVar.c().d(null);
            f fVar = new f(hVar, interfaceC0895b);
            hVar.f46103o = 10;
            return fVar;
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static View a(Context context, View.OnClickListener onClickListener) {
        ImageView imageView = new ImageView(context);
        imageView.setId(4);
        l.a(imageView);
        imageView.setOnClickListener(onClickListener);
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static View a(FrameLayout frameLayout, String str, View.OnClickListener onClickListener, boolean z3) {
        o oVar = new o(frameLayout.getContext(), str);
        oVar.b(12, f1.b(frameLayout.getContext(), frameLayout.getHeight()) - 12, frameLayout);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) oVar.getLayoutParams();
        int i4 = d.f46198f;
        layoutParams.bottomMargin = i4;
        layoutParams.bottomMargin = i4 + (z3 ? d.f46200h : 0);
        layoutParams.leftMargin = d.f46198f;
        layoutParams.topMargin = 0;
        layoutParams.gravity = 83;
        oVar.setLayoutParams(layoutParams);
        oVar.a(onClickListener);
        oVar.setId(8);
        return oVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Pair<FrameLayout.LayoutParams, FrameLayout.LayoutParams> a(boolean z3) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, d.f46199g);
        layoutParams.gravity = 80;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        int i4 = d.f46198f;
        layoutParams2.leftMargin = i4;
        layoutParams2.bottomMargin = i4;
        if (z3) {
            i4 = (i4 * 2) + d.f46194b;
        }
        layoutParams2.rightMargin = i4;
        return new Pair<>(layoutParams, layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Pair<FrameLayout.LayoutParams, FrameLayout.LayoutParams> a(boolean z3, int i4, boolean z4, k.b bVar, boolean z5) {
        int i5 = d.f46198f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(d.f46194b, d.f46193a);
        layoutParams.setMargins(i5, i5, i5, i5);
        int i6 = d.f46198f;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(i6 - bVar.f42016a, i6 - bVar.f42017b, i6 - bVar.f42018c, i6 - bVar.f42019d);
        if (z3 || i4 == 0 || i4 == 1) {
            layoutParams2.gravity = 8388661;
            layoutParams.gravity = 8388693;
            layoutParams2.topMargin += z4 ? d.f46196d : 0;
        } else if (i4 == 2) {
            layoutParams2.gravity = 8388659;
            layoutParams.gravity = 8388693;
            layoutParams2.topMargin += z4 ? d.f46196d : 0;
        } else {
            layoutParams2.gravity = 8388693;
            layoutParams.gravity = 8388659;
            int i7 = layoutParams2.bottomMargin + (z4 ? d.f46196d : 0);
            layoutParams2.bottomMargin = i7;
            layoutParams2.bottomMargin = i7 + (z5 ? d.f46200h : 0);
        }
        return new Pair<>(layoutParams2, layoutParams);
    }
}

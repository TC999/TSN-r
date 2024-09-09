package com.qq.e.dl.l;

import android.view.ViewGroup;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f extends ViewGroup.MarginLayoutParams {
    public f(b bVar) {
        super(a(bVar.o()), a(bVar.d()));
        ((ViewGroup.MarginLayoutParams) this).topMargin = bVar.h();
        ((ViewGroup.MarginLayoutParams) this).bottomMargin = bVar.e();
        ((ViewGroup.MarginLayoutParams) this).leftMargin = bVar.f();
        ((ViewGroup.MarginLayoutParams) this).rightMargin = bVar.g();
    }

    private static int a(int i4) {
        if (i4 >= 0) {
            return i4;
        }
        if (i4 == -1) {
            return -1;
        }
        if (i4 == -2) {
            return -2;
        }
        return i4;
    }
}

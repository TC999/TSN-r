package com.qq.e.comm.plugin.dl;

import android.view.View;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class j implements com.qq.e.dl.d {
    @Override // com.qq.e.dl.d
    public void a(View view, int i4) {
        if (view == null || i4 == 0) {
            return;
        }
        int i5 = 8;
        if (i4 == 1) {
            i5 = 2;
        } else if (i4 == 2) {
            i5 = 1;
        } else if (i4 != 4) {
            if (i4 == 8) {
                i5 = 4;
            } else if (i4 != 10) {
                return;
            } else {
                i5 = 0;
            }
        }
        com.qq.e.comm.plugin.util.z.a(view, i5);
    }
}

package com.qq.e.comm.plugin.d.g;

import java.io.File;
import java.util.Arrays;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class g implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    private final String[] f42198c;

    /* renamed from: d  reason: collision with root package name */
    private int f42199d;

    /* renamed from: e  reason: collision with root package name */
    private int f42200e;

    public g() {
        String[] list = com.qq.e.comm.plugin.d.a.c().list();
        this.f42198c = list;
        if (list != null) {
            Arrays.sort(list);
            this.f42199d = this.f42198c.length - 1;
            return;
        }
        this.f42199d = -1;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i4 = this.f42199d;
        if (i4 < 0 || this.f42200e >= 3) {
            return;
        }
        String str = this.f42198c[i4];
        File file = new File(com.qq.e.comm.plugin.d.a.c(), str);
        if (file.exists()) {
            if (!new f().a(new b(str, file))) {
                int i5 = this.f42200e + 1;
                this.f42200e = i5;
                if (i5 >= 3) {
                    return;
                }
            }
        }
        int i6 = this.f42199d - 1;
        this.f42199d = i6;
        if (i6 >= 0) {
            com.qq.e.comm.plugin.d.b.a().postDelayed(this, 2000L);
        }
    }
}

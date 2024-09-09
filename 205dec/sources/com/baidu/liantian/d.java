package com.baidu.liantian;

import android.content.Context;
import android.os.FileObserver;
import java.io.File;

/* compiled from: MyFileObserver.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class d extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    private String f12223a;

    /* renamed from: b  reason: collision with root package name */
    private String f12224b;

    /* renamed from: c  reason: collision with root package name */
    private int f12225c;

    /* renamed from: d  reason: collision with root package name */
    private Context f12226d;

    public d(Context context, int i4, String str, String str2) {
        super(str, 4095);
        try {
            this.f12223a = str;
            this.f12224b = str2;
            this.f12225c = i4;
            this.f12226d = context;
            new File(this.f12223a).exists();
            b.a();
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    @Override // android.os.FileObserver
    public void onEvent(int i4, String str) {
        if (i4 == 2 || i4 == 4 || i4 == 64 || i4 == 128 || i4 == 512 || i4 == 1024 || i4 == 2048) {
            try {
                new Thread() { // from class: com.baidu.liantian.d.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public final void run() {
                        try {
                            super.run();
                            b.a();
                            synchronized (d.class) {
                                if (!com.baidu.liantian.b.e.c(d.this.f12223a)) {
                                    b.a();
                                    com.baidu.liantian.b.e.b(d.this.f12224b, d.this.f12223a);
                                    com.baidu.liantian.b.e.a(d.this.f12223a, true);
                                    c.a(new File(d.this.f12223a));
                                    c.a(d.this.f12226d, d.this.f12225c, new File(d.this.f12223a), new File(d.this.f12224b));
                                    d.this.f12223a.toString();
                                    b.a();
                                    com.baidu.liantian.a.a.a(d.this.f12226d).b(d.this.f12225c, -1);
                                }
                            }
                        } catch (Throwable unused) {
                            com.baidu.liantian.b.e.a();
                        }
                    }
                }.start();
            } catch (Throwable unused) {
                com.baidu.liantian.b.e.a();
            }
        }
    }

    public final boolean a() {
        try {
            File file = new File(this.f12224b);
            if (file.exists()) {
                return file.delete();
            }
            return false;
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
            return false;
        }
    }
}

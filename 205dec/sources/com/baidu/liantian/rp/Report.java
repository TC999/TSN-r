package com.baidu.liantian.rp;

import android.content.Context;
import android.os.Message;
import com.baidu.liantian.b;
import com.baidu.liantian.b.e;
import com.baidu.liantian.b.f;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class Report {

    /* renamed from: a  reason: collision with root package name */
    private static Report f12238a;

    /* renamed from: b  reason: collision with root package name */
    private Context f12239b;

    private Report(Context context) {
        this.f12239b = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public static synchronized Report getInstance(Context context) {
        Report report;
        synchronized (Report.class) {
            if (f12238a == null) {
                f12238a = new Report(context);
            }
            report = f12238a;
        }
        return report;
    }

    public void fr() {
        try {
            f a4 = f.a(this.f12239b);
            Message message = new Message();
            message.what = 9;
            a4.f12125a.a(message);
        } catch (Throwable unused) {
            e.a();
        }
    }

    public void i(String str, String str2, String str3, String str4, String str5) {
        try {
            e.a(this.f12239b, str, str2, str3, str4, str5);
        } catch (Throwable unused) {
            e.a();
        }
    }

    public void n() {
        try {
            f a4 = f.a(this.f12239b);
            Message message = new Message();
            message.what = 6;
            a4.f12125a.a(message);
        } catch (Throwable unused) {
            e.a();
        }
    }

    public void r(boolean z3) {
        try {
            f.a(this.f12239b).a();
        } catch (Throwable unused) {
            e.a();
        }
    }

    public void s(String str) {
        try {
            b.a();
            e.c(this.f12239b, str);
        } catch (Throwable unused) {
            e.a();
        }
    }

    public void sr(String str) {
        try {
            b.a();
            f a4 = f.a(this.f12239b);
            Message message = new Message();
            message.what = 11;
            message.obj = str;
            a4.f12125a.a(message);
        } catch (Throwable unused) {
            e.a();
        }
    }

    public void w(String str) {
        try {
            e.d(this.f12239b, str);
        } catch (Throwable unused) {
            e.a();
        }
    }
}

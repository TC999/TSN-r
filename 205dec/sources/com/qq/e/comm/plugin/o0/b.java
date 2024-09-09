package com.qq.e.comm.plugin.o0;

import android.os.Build;
import android.text.TextUtils;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.u1;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private AtomicBoolean f45029a;

    /* renamed from: b  reason: collision with root package name */
    private AtomicInteger f45030b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f45031c;

    /* renamed from: d  reason: collision with root package name */
    private int f45032d;

    /* renamed from: e  reason: collision with root package name */
    private int f45033e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.o0.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class C0863b {

        /* renamed from: a  reason: collision with root package name */
        private static b f45034a = new b();
    }

    public static b a() {
        return C0863b.f45034a;
    }

    public int b() {
        return this.f45033e;
    }

    public boolean c() {
        d1.a("HdVideoUtils.hasHdVideoPlayFailed: " + this.f45030b.get(), new Object[0]);
        return this.f45030b.get() > 0;
    }

    public void d() {
        d1.a("HdVideoUtils.setIsHdVideoPlayedSuccess", new Object[0]);
        this.f45029a.set(true);
    }

    private b() {
        this.f45029a = new AtomicBoolean(false);
        this.f45030b = new AtomicInteger(0);
        this.f45033e = 1;
        this.f45031c = u1.a("sphdv", true);
        this.f45032d = u1.a("hdrefver", 0);
    }

    private void b(int i4) {
        this.f45032d = i4;
        u1.b("hdrefver", i4);
        u1.b("sphdv", true);
        this.f45031c = true;
    }

    public void a(int i4) {
        v.b(1130024, null, Integer.valueOf(i4));
        int incrementAndGet = this.f45030b.incrementAndGet();
        d1.a("HdVideoUtils.recordHdVideoPlayFailed: currentTimes = " + incrementAndGet + ", mIsHdVideoPlayedSuccess = " + this.f45029a.get(), new Object[0]);
        if (incrementAndGet == 3) {
            this.f45031c = false;
            if (this.f45029a.get()) {
                v.b(1130026, null, Integer.valueOf(i4));
                return;
            }
            v.b(1130025, null, Integer.valueOf(i4));
            u1.b("sphdv", false);
        }
    }

    public boolean a(com.qq.e.comm.plugin.d0.a aVar) {
        if (Build.VERSION.SDK_INT < 21) {
            this.f45033e = 2;
            return false;
        } else if (aVar.f().a("nshd", 1) != 1) {
            d1.a("HdVideoUtils.isSupportHd control server disable", new Object[0]);
            this.f45033e = 3;
            return false;
        } else {
            String str = com.qq.e.comm.plugin.d0.a.d().c().f42280j;
            if (TextUtils.isEmpty(str)) {
                this.f45033e = 4;
                return false;
            }
            String b4 = aVar.f().b("nshdbd", "");
            String lowerCase = str.toLowerCase();
            d1.a("HdVideoUtils.isSupportHd lowerCaseModel: " + lowerCase, new Object[0]);
            if (!"oppo a37m,oppo a59m,oppo a59s,oppo a59st,oppo r9km,oppo r9m,oppo r9s,oppo r9tm,vivo v3m a,vivo x5pro d,vivo x6d,vivo x6l,vivo x6plus d,vivo y67,vivo y67a,vivo y67l,jmm al10,sea-al10,redmi 6a,m5 note,kuliao k10".contains(lowerCase) && !b4.contains(lowerCase)) {
                int a4 = aVar.f().a("reshdv", 0);
                d1.a("HdVideoUtils.isSupportHd version: " + a4 + ", mRefreshVersion: " + this.f45032d, new Object[0]);
                if (a4 > this.f45032d) {
                    b(a4);
                    return true;
                }
                d1.a("HdVideoUtils.isSupportHd mIsSupportHdInDevicesRecord: " + this.f45031c, new Object[0]);
                if (!this.f45031c) {
                    this.f45033e = 6;
                }
                return this.f45031c;
            }
            this.f45033e = 5;
            return false;
        }
    }
}

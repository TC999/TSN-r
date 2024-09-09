package com.qq.e.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.managers.a;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class AbstractAD<T> {

    /* renamed from: a  reason: collision with root package name */
    protected T f41434a;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f41438e;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f41436c = false;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f41437d = false;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f41435b = new Handler(Looper.getMainLooper());

    private void b(final Context context, final String str, final String str2) {
        this.f41438e = true;
        if (a.b().d()) {
            final String a4 = a.b().a();
            if (com.qq.e.comm.a.a(context)) {
                this.f41437d = true;
                a.f41630g.execute(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            final POFactory pOFactory = a.b().c().getPOFactory();
                            AbstractAD.this.f41435b.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        POFactory pOFactory2 = pOFactory;
                                        if (pOFactory2 != null) {
                                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                            AbstractAD abstractAD = AbstractAD.this;
                                            abstractAD.f41434a = (T) abstractAD.a(context, pOFactory2, a4, str, str2);
                                            AbstractAD.this.f41436c = true;
                                            AbstractAD abstractAD2 = AbstractAD.this;
                                            T t3 = abstractAD2.f41434a;
                                            if (t3 == null) {
                                                abstractAD2.a(200103);
                                            } else {
                                                abstractAD2.a((AbstractAD) t3);
                                            }
                                        } else {
                                            AbstractAD.this.f41436c = true;
                                            AbstractAD.this.a(200102);
                                        }
                                    } catch (Throwable th) {
                                        GDTLogger.e("\u521d\u59cb\u5316\u9519\u8bef\uff1a\u521d\u59cb\u5316\u5e7f\u544a\u5b9e\u4f8b\u65f6\u53d1\u751f\u5f02\u5e38", th);
                                        AbstractAD.this.f41436c = true;
                                        AbstractAD.this.a(2001);
                                    }
                                }
                            });
                        } catch (Throwable th) {
                            GDTLogger.e("\u521d\u59cb\u5316\u9519\u8bef\uff1a\u521d\u59cb\u5316\u63d2\u4ef6\u65f6\u53d1\u751f\u5f02\u5e38", th);
                            AbstractAD.this.f41436c = true;
                            AbstractAD.this.a(200102);
                        }
                    }
                });
                return;
            }
            GDTLogger.e("Manifest\u6587\u4ef6\u4e2dActivity/Service/Permission\u7684\u58f0\u660e\u6709\u95ee\u9898\u6216\u8005Permission\u6743\u9650\u672a\u6388\u4e88");
            a(4002);
            return;
        }
        a(2003);
    }

    protected abstract T a(Context context, POFactory pOFactory, String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(final int i4) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            b(i4);
        } else {
            this.f41435b.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractAD.this.b(i4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            b(context, str, "");
            return;
        }
        GDTLogger.e("\u521d\u59cb\u5316\u9519\u8bef\uff1a\u53c2\u6570\u9519\u8befcontext\u6216posId\u4e3a\u7a7a");
        a(2001);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            b(context, str, str2);
            return;
        }
        GDTLogger.e("\u521d\u59cb\u5316\u9519\u8bef\uff1a\u53c2\u6570\u9519\u8bef\uff0ccontext\u3001posId\u3001token \u4e0d\u53ef\u4e3a\u7a7a");
        a(2001);
    }

    protected abstract void a(T t3);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str) {
        GDTLogger.e(getClass().getSimpleName() + ":\u8c03\u7528\u65b9\u6cd5 " + str + "\u5f02\u5e38\uff0c\u5e7f\u544a\u5b9e\u4f8b\u8fd8\u672a\u521d\u59cb\u5316");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a() {
        return this.f41438e && this.f41437d;
    }

    protected abstract void b(int i4);

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean b() {
        return this.f41436c;
    }
}

package com.p518qq.p519e.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.p518qq.p519e.comm.C11814a;
import com.p518qq.p519e.comm.constants.ErrorCode;
import com.p518qq.p519e.comm.managers.C11815a;
import com.p518qq.p519e.comm.p520pi.POFactory;
import com.p518qq.p519e.comm.util.GDTLogger;

/* renamed from: com.qq.e.ads.AbstractAD */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractAD<T> {

    /* renamed from: a */
    protected T f32719a;

    /* renamed from: e */
    private volatile boolean f32723e;

    /* renamed from: c */
    private volatile boolean f32721c = false;

    /* renamed from: d */
    private volatile boolean f32722d = false;

    /* renamed from: b */
    private final Handler f32720b = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private void m20408b(final Context context, final String str, final String str2) {
        this.f32723e = true;
        if (C11815a.m20349b().m20347d()) {
            final String m20354a = C11815a.m20349b().m20354a();
            if (C11814a.m20357a(context)) {
                this.f32722d = true;
                C11815a.f32896g.execute(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            final POFactory pOFactory = C11815a.m20349b().m20348c().getPOFactory();
                            AbstractAD.this.f32720b.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        POFactory pOFactory2 = pOFactory;
                                        if (pOFactory2 != null) {
                                            RunnableC118011 runnableC118011 = RunnableC118011.this;
                                            AbstractAD abstractAD = AbstractAD.this;
                                            abstractAD.f32719a = (T) abstractAD.mo20371a(context, pOFactory2, m20354a, str, str2);
                                            AbstractAD.this.f32721c = true;
                                            AbstractAD abstractAD2 = AbstractAD.this;
                                            T t = abstractAD2.f32719a;
                                            if (t == null) {
                                                abstractAD2.m20415a(ErrorCode.POFACTORY_GET_INTERFACE_ERROR);
                                            } else {
                                                abstractAD2.mo20368a((AbstractAD) t);
                                            }
                                        } else {
                                            AbstractAD.this.f32721c = true;
                                            AbstractAD.this.m20415a(ErrorCode.PLUGIN_INIT_ERROR);
                                        }
                                    } catch (Throwable th) {
                                        GDTLogger.m20306e("初始化错误：初始化广告实例时发生异常", th);
                                        AbstractAD.this.f32721c = true;
                                        AbstractAD.this.m20415a(2001);
                                    }
                                }
                            });
                        } catch (Throwable th) {
                            GDTLogger.m20306e("初始化错误：初始化插件时发生异常", th);
                            AbstractAD.this.f32721c = true;
                            AbstractAD.this.m20415a(ErrorCode.PLUGIN_INIT_ERROR);
                        }
                    }
                });
                return;
            }
            GDTLogger.m20307e("Manifest文件中Activity/Service/Permission的声明有问题或者Permission权限未授予");
            m20415a(4002);
            return;
        }
        m20415a(2003);
    }

    /* renamed from: a */
    protected abstract T mo20371a(Context context, POFactory pOFactory, String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m20415a(final int i) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            mo20366b(i);
        } else {
            this.f32720b.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractAD.this.mo20366b(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m20414a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            m20408b(context, str, "");
            return;
        }
        GDTLogger.m20307e("初始化错误：参数错误context或posId为空");
        m20415a(2001);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m20413a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            m20408b(context, str, str2);
            return;
        }
        GDTLogger.m20307e("初始化错误：参数错误，context、posId、token 不可为空");
        m20415a(2001);
    }

    /* renamed from: a */
    protected abstract void mo20368a(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m20410a(String str) {
        GDTLogger.m20307e(getClass().getSimpleName() + ":调用方法 " + str + "异常，广告实例还未初始化");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean m20416a() {
        return this.f32723e && this.f32722d;
    }

    /* renamed from: b */
    protected abstract void mo20366b(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final boolean m20409b() {
        return this.f32721c;
    }
}

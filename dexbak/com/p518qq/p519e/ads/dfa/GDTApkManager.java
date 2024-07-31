package com.p518qq.p519e.ads.dfa;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.p518qq.p519e.comm.C11814a;
import com.p518qq.p519e.comm.managers.C11815a;
import com.p518qq.p519e.comm.p520pi.DFA;
import com.p518qq.p519e.comm.p520pi.POFactory;
import com.p518qq.p519e.comm.util.GDTLogger;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.qq.e.ads.dfa.GDTApkManager */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class GDTApkManager {

    /* renamed from: a */
    private DFA f32768a;

    /* renamed from: b */
    private boolean f32769b = false;

    /* renamed from: c */
    private boolean f32770c = false;

    /* renamed from: d */
    private AtomicInteger f32771d = new AtomicInteger(0);

    /* renamed from: e */
    private Context f32772e;

    public GDTApkManager(Context context, IGDTApkListener iGDTApkListener) {
        if (C11815a.m20349b().m20347d()) {
            m20396a(context, C11815a.m20349b().m20354a(), iGDTApkListener);
        }
    }

    /* renamed from: a */
    private void m20396a(Context context, String str, final IGDTApkListener iGDTApkListener) {
        if (TextUtils.isEmpty(str) || context == null) {
            GDTLogger.m20307e("初始化错误：GDTApkManager 构造失败，Context和appID不能为空");
        } else if (!C11814a.m20357a(context)) {
            GDTLogger.m20307e("初始化错误：必需的 Activity/Service/Permission 没有在AndroidManifest.xml中声明");
        } else {
            this.f32769b = true;
            this.f32772e = context;
            C11815a.f32896g.execute(new Runnable() { // from class: com.qq.e.ads.dfa.GDTApkManager.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        final POFactory pOFactory = C11815a.m20349b().m20348c().getPOFactory();
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.dfa.GDTApkManager.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (pOFactory != null) {
                                        GDTApkManager.this.f32768a = C11815a.m20349b().m20348c().getPOFactory().getGDTApkDelegate(iGDTApkListener);
                                        GDTApkManager.this.f32770c = true;
                                        while (GDTApkManager.this.f32771d.getAndDecrement() > 0) {
                                            GDTApkManager.this.loadGDTApk();
                                        }
                                    }
                                } finally {
                                    try {
                                    } finally {
                                    }
                                }
                            }
                        });
                    } catch (Throwable th) {
                        GDTLogger.m20306e("初始化错误：初始化时发生异常", th);
                    }
                }
            });
        }
    }

    public final void loadGDTApk() {
        if (this.f32769b) {
            if (!this.f32770c) {
                this.f32771d.incrementAndGet();
                return;
            }
            DFA dfa = this.f32768a;
            if (dfa != null) {
                dfa.loadGDTApk();
            } else {
                GDTLogger.m20307e("调用loadGDTApk失败，实例未被正常初始化");
            }
        }
    }

    public final void startInstall(GDTApk gDTApk) {
        DFA dfa = this.f32768a;
        if (dfa != null) {
            dfa.startInstall(this.f32772e, gDTApk);
        }
    }
}

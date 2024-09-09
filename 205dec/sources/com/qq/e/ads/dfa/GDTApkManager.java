package com.qq.e.ads.dfa;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.managers.a;
import com.qq.e.comm.pi.DFA;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class GDTApkManager {

    /* renamed from: a  reason: collision with root package name */
    private DFA f41483a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f41484b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f41485c = false;

    /* renamed from: d  reason: collision with root package name */
    private AtomicInteger f41486d = new AtomicInteger(0);

    /* renamed from: e  reason: collision with root package name */
    private Context f41487e;

    public GDTApkManager(Context context, IGDTApkListener iGDTApkListener) {
        if (a.b().d()) {
            a(context, a.b().a(), iGDTApkListener);
        }
    }

    private void a(Context context, String str, final IGDTApkListener iGDTApkListener) {
        if (TextUtils.isEmpty(str) || context == null) {
            GDTLogger.e("\u521d\u59cb\u5316\u9519\u8bef\uff1aGDTApkManager \u6784\u9020\u5931\u8d25\uff0cContext\u548cappID\u4e0d\u80fd\u4e3a\u7a7a");
        } else if (!com.qq.e.comm.a.a(context)) {
            GDTLogger.e("\u521d\u59cb\u5316\u9519\u8bef\uff1a\u5fc5\u9700\u7684 Activity/Service/Permission \u6ca1\u6709\u5728AndroidManifest.xml\u4e2d\u58f0\u660e");
        } else {
            this.f41484b = true;
            this.f41487e = context;
            a.f41630g.execute(new Runnable() { // from class: com.qq.e.ads.dfa.GDTApkManager.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        final POFactory pOFactory = a.b().c().getPOFactory();
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.dfa.GDTApkManager.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (pOFactory != null) {
                                        GDTApkManager.this.f41483a = a.b().c().getPOFactory().getGDTApkDelegate(iGDTApkListener);
                                        GDTApkManager.this.f41485c = true;
                                        while (GDTApkManager.this.f41486d.getAndDecrement() > 0) {
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
                        GDTLogger.e("\u521d\u59cb\u5316\u9519\u8bef\uff1a\u521d\u59cb\u5316\u65f6\u53d1\u751f\u5f02\u5e38", th);
                    }
                }
            });
        }
    }

    public final void loadGDTApk() {
        if (this.f41484b) {
            if (!this.f41485c) {
                this.f41486d.incrementAndGet();
                return;
            }
            DFA dfa = this.f41483a;
            if (dfa != null) {
                dfa.loadGDTApk();
            } else {
                GDTLogger.e("\u8c03\u7528loadGDTApk\u5931\u8d25\uff0c\u5b9e\u4f8b\u672a\u88ab\u6b63\u5e38\u521d\u59cb\u5316");
            }
        }
    }

    public final void startInstall(GDTApk gDTApk) {
        DFA dfa = this.f41483a;
        if (dfa != null) {
            dfa.startInstall(this.f41487e, gDTApk);
        }
    }
}

package com.beizi.ad.lance;

import android.content.Context;
import com.beizi.ad.lance.a.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: OnLineState.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    private static b f14382c;

    /* renamed from: a  reason: collision with root package name */
    public c f14383a;

    /* renamed from: b  reason: collision with root package name */
    private String f14384b = "OnLineState";

    private b(Context context) {
        if (context == null) {
            l.c("OnLineState", "OnLineState init failed,because context cann't be null ");
            return;
        }
        c cVar = new c();
        this.f14383a = cVar;
        cVar.a(context);
    }

    public static b a(Context context) {
        if (f14382c == null) {
            synchronized (b.class) {
                if (f14382c == null) {
                    f14382c = new b(context);
                }
            }
        }
        return f14382c;
    }

    public void a(a aVar) {
        c cVar = this.f14383a;
        if (cVar != null) {
            cVar.a(aVar);
        } else {
            l.a(this.f14384b, "please init OnLineState first ,you can init it with 'OnLineState.init(context);' in you BaseApplication ");
        }
    }
}

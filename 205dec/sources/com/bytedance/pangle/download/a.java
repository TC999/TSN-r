package com.bytedance.pangle.download;

import android.app.Activity;
import com.bytedance.pangle.Zeus;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f28690b;

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f28691a = new CopyOnWriteArrayList();

    public a() {
        Zeus.getAppApplication().registerActivityLifecycleCallbacks(new com.bytedance.pangle.a() { // from class: com.bytedance.pangle.download.a.1
            @Override // com.bytedance.pangle.a, android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityResumed(Activity activity) {
                Iterator it = a.this.f28691a.iterator();
                while (it.hasNext()) {
                    it.next();
                    b.a();
                }
            }
        });
    }

    public static a a() {
        if (f28690b == null) {
            synchronized (a.class) {
                if (f28690b == null) {
                    f28690b = new a();
                }
            }
        }
        return f28690b;
    }
}

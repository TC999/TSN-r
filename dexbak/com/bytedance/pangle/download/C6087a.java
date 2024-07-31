package com.bytedance.pangle.download;

import android.app.Activity;
import com.bytedance.pangle.C6057a;
import com.bytedance.pangle.Zeus;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.bytedance.pangle.download.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6087a {

    /* renamed from: b */
    private static volatile C6087a f21929b;

    /* renamed from: a */
    public final List<String> f21930a = new CopyOnWriteArrayList();

    public C6087a() {
        Zeus.getAppApplication().registerActivityLifecycleCallbacks(new C6057a() { // from class: com.bytedance.pangle.download.a.1
            @Override // com.bytedance.pangle.C6057a, android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityResumed(Activity activity) {
                Iterator it = C6087a.this.f21930a.iterator();
                while (it.hasNext()) {
                    it.next();
                    C6089b.m37205a();
                }
            }
        });
    }

    /* renamed from: a */
    public static C6087a m37207a() {
        if (f21929b == null) {
            synchronized (C6087a.class) {
                if (f21929b == null) {
                    f21929b = new C6087a();
                }
            }
        }
        return f21929b;
    }
}

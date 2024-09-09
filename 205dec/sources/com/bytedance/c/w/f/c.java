package com.bytedance.c.w.f;

import android.content.Context;
import android.os.Handler;
import com.bytedance.c.w.b;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private List<a> f26530a;

    private c(Handler handler, Context context) {
        ArrayList arrayList = new ArrayList(3);
        this.f26530a = arrayList;
        arrayList.add(new b(handler, 0L, 15000L));
    }

    public static c a(Handler handler, Context context) {
        return new c(handler, context);
    }

    public void b() {
        b.k.a("[ScheduleTaskManager] execute, task size=" + this.f26530a.size());
        for (a aVar : this.f26530a) {
            try {
                aVar.a();
            } catch (Throwable unused) {
            }
        }
    }
}

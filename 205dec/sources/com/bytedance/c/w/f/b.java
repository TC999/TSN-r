package com.bytedance.c.w.f;

import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.c.w.b;
import com.bytedance.c.w.d;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class b extends a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Handler handler, long j4, long j5) {
        super(handler, j4, j5);
    }

    @Override // java.lang.Runnable
    public void run() {
        String d4 = d.a().d();
        if (!TextUtils.isEmpty(d4) && !"0".equals(d4)) {
            d.l().b(d4);
            b.k.a("[DeviceIdTask] did is " + d4);
            return;
        }
        b(d());
        b.k.a("[DeviceIdTask] did is null, continue check.");
    }
}

package com.bytedance.sdk.component.f;

import android.content.Context;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private static volatile Context f29794c;

    public static void c(Context context) {
        if (f29794c == null && context != null) {
            f29794c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    public static Context getContext() {
        return f29794c;
    }
}

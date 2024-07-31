package com.umeng.commonsdk.internal;

import android.content.Context;
import com.stub.StubApp;

/* renamed from: com.umeng.commonsdk.internal.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UMInternalData {

    /* renamed from: b */
    private static UMInternalData f38815b;

    /* renamed from: a */
    private Context f38816a;

    /* renamed from: c */
    private UMInternalDataProtocol f38817c;

    private UMInternalData(Context context) {
        this.f38816a = context;
        this.f38817c = new UMInternalDataProtocol(context);
    }

    /* renamed from: a */
    public static synchronized UMInternalData m13974a(Context context) {
        UMInternalData uMInternalData;
        synchronized (UMInternalData.class) {
            if (f38815b == null) {
                f38815b = new UMInternalData(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            }
            uMInternalData = f38815b;
        }
        return uMInternalData;
    }

    /* renamed from: a */
    public UMInternalDataProtocol m13975a() {
        return this.f38817c;
    }
}

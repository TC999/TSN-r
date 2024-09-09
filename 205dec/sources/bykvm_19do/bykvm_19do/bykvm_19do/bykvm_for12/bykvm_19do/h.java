package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do;

import android.annotation.SuppressLint;
import android.content.Context;

/* compiled from: DBAdapter.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class h extends i {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    private static volatile h f563d;

    private h(Context context) {
        super(context);
    }

    public static h a(Context context) {
        if (f563d == null) {
            synchronized (h.class) {
                if (f563d == null) {
                    f563d = new h(context);
                }
            }
        }
        return f563d;
    }
}

package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do;

import android.annotation.SuppressLint;
import android.content.Context;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.h */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class DBAdapter extends DBHelper {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d */
    private static volatile DBAdapter f570d;

    private DBAdapter(Context context) {
        super(context);
    }

    /* renamed from: a */
    public static DBAdapter m59403a(Context context) {
        if (f570d == null) {
            synchronized (DBAdapter.class) {
                if (f570d == null) {
                    f570d = new DBAdapter(context);
                }
            }
        }
        return f570d;
    }
}

package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: OfflineMapRemoveTask.java */
/* renamed from: com.amap.api.col.3l.i0  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class i0 {

    /* renamed from: a  reason: collision with root package name */
    private Context f8071a;

    public i0(Context context) {
        this.f8071a = context;
    }

    private static boolean b(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String X = a3.X(context);
        try {
            File file = new File(X + str2 + str + ".dat");
            if (file.exists()) {
                if (!z0.l(file)) {
                    return false;
                }
            }
            try {
                z0.h(X + str2);
                z0.k(str, context);
                return true;
            } catch (IOException e4) {
                e4.printStackTrace();
                return false;
            } catch (Exception e5) {
                e5.printStackTrace();
                return false;
            }
        } catch (IOException e6) {
            e6.printStackTrace();
            return false;
        } catch (Exception e7) {
            e7.printStackTrace();
            return false;
        }
    }

    private boolean c(ax axVar) {
        if (axVar != null) {
            String pinyin = axVar.getPinyin();
            boolean b4 = b(pinyin, this.f8071a, "vmap/");
            if (pinyin.equals("quanguogaiyaotu")) {
                pinyin = "quanguo";
            }
            boolean z3 = true;
            boolean z4 = b(pinyin, this.f8071a, "map/") || b4;
            if (!d(z0.i(axVar.getUrl()), this.f8071a, "map/") && !z4) {
                z3 = false;
            }
            if (z3) {
                axVar.E();
                return z3;
            }
            axVar.D();
        }
        return false;
    }

    private static boolean d(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String v3 = a3.v(context);
        try {
            File file = new File(v3 + str2 + str);
            if (file.exists()) {
                if (!z0.l(file)) {
                    return false;
                }
            }
            try {
                z0.h(v3 + str2);
                z0.k(str, context);
                return true;
            } catch (IOException e4) {
                e4.printStackTrace();
                return false;
            } catch (Exception e5) {
                e5.printStackTrace();
                return false;
            }
        } catch (IOException e6) {
            e6.printStackTrace();
            return false;
        } catch (Exception e7) {
            e7.printStackTrace();
            return false;
        }
    }

    public final void a(ax axVar) {
        c(axVar);
    }
}

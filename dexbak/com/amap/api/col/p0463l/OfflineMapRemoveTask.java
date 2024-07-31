package com.amap.api.col.p0463l;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

/* renamed from: com.amap.api.col.3l.i0 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class OfflineMapRemoveTask {

    /* renamed from: a */
    private Context f4485a;

    public OfflineMapRemoveTask(Context context) {
        this.f4485a = context;
    }

    /* renamed from: b */
    private static boolean m54735b(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String m55721X = C1732a3.m55721X(context);
        try {
            File file = new File(m55721X + str2 + str + ".dat");
            if (file.exists()) {
                if (!Utility.m53342l(file)) {
                    return false;
                }
            }
            try {
                Utility.m53346h(m55721X + str2);
                Utility.m53343k(str, context);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            return false;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    /* renamed from: c */
    private boolean m54734c(CityObject cityObject) {
        if (cityObject != null) {
            String pinyin = cityObject.getPinyin();
            boolean m54735b = m54735b(pinyin, this.f4485a, "vmap/");
            if (pinyin.equals("quanguogaiyaotu")) {
                pinyin = "quanguo";
            }
            boolean z = true;
            boolean z2 = m54735b(pinyin, this.f4485a, "map/") || m54735b;
            if (!m54733d(Utility.m53345i(cityObject.getUrl()), this.f4485a, "map/") && !z2) {
                z = false;
            }
            if (z) {
                cityObject.m55636D();
                return z;
            }
            cityObject.m55637C();
        }
        return false;
    }

    /* renamed from: d */
    private static boolean m54733d(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String m55688v = C1732a3.m55688v(context);
        try {
            File file = new File(m55688v + str2 + str);
            if (file.exists()) {
                if (!Utility.m53342l(file)) {
                    return false;
                }
            }
            try {
                Utility.m53346h(m55688v + str2);
                Utility.m53343k(str, context);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            return false;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public final void m54736a(CityObject cityObject) {
        m54734c(cityObject);
    }
}

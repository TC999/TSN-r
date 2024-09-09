package cn.jiguang.cl;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.JCoreManager;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {
    public static Bundle a(Context context, int i4, Bundle bundle) {
        Object obj;
        try {
            Bundle bundle2 = new Bundle();
            if (i4 == 4096) {
                if (bundle != null && (obj = bundle.get("arg1")) != null) {
                    JCoreManager.onEvent(context, null, 9, obj.toString(), null, new Object[0]);
                }
                return bundle2;
            } else if (i4 == 4098) {
                JCoreManager.init(context);
                return bundle2;
            } else if (i4 != 36864) {
                return null;
            } else {
                JCoreManager.onEvent(context, null, 52, null, bundle, new Object[0]);
                return null;
            }
        } catch (Throwable th) {
            d.e("JCoreInterface", "si e:" + th);
            return null;
        }
    }
}

package cn.jiguang.bx;

import android.content.Context;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e {
    public static Object a(Context context, String str, Object obj) {
        try {
            return cn.jiguang.bl.a.a(context, str, obj);
        } catch (Throwable th) {
            cn.jiguang.bq.d.j("JCommonPresenter", "jcommon call failed:" + th.getMessage());
            return null;
        }
    }
}

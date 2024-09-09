package cn.jiguang.bl;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.JDispatchAction;
import cn.jiguang.bq.d;
import cn.jiguang.internal.ActionManager;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cn.jiguang.bl.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class C0055a {

        /* renamed from: a  reason: collision with root package name */
        private static JDispatchAction f2740a;

        static {
            String str;
            ActionManager.getInstance();
            JDispatchAction jDispatchAction = ActionManager.getJDispatchAction("JPortrait");
            if (jDispatchAction != null) {
                f2740a = jDispatchAction;
                str = "instance jportrait";
            } else {
                f2740a = new cn.jiguang.ao.a();
                str = "instance jcommon";
            }
            d.c("JCoreToJPortrait", str);
        }
    }

    private static JDispatchAction a() {
        return C0055a.f2740a;
    }

    public static Object a(Context context, String str, Bundle bundle, Object obj) {
        return a().getDataByAction(context, "jportrait", str, bundle, obj);
    }

    public static Object a(Context context, String str, Object obj) {
        return a().getDataByAction(context, "jcommon", str, null, obj);
    }
}

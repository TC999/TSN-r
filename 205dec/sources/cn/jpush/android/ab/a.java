package cn.jpush.android.ab;

import android.content.Context;
import cn.jiguang.api.JCoreManager;
import cn.jpush.android.ab.c;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.ActionHelper;
import cn.jpush.android.local.JPushConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f3905a = "JPushStatusUtils";

    /* renamed from: b  reason: collision with root package name */
    private static boolean f3906b;

    public static void a(Context context) {
        try {
            if (Math.abs(System.currentTimeMillis() - ((Long) Sp.get(context, Key.PushStatusSyncTime())).longValue()) > -1702967296) {
                boolean d4 = cn.jpush.android.cache.a.d(context);
                String str = f3905a;
                StringBuilder sb = new StringBuilder();
                sb.append("push current status  =");
                sb.append(d4 ? "stop " : CampaignEx.JSON_NATIVE_VIDEO_RESUME);
                Logger.d(str, sb.toString());
                if (d4) {
                    f3906b = true;
                    JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, CampaignEx.JSON_NATIVE_VIDEO_RESUME, null);
                    ActionHelper.getInstance().setPushStatusWithCallBack(context, 4, 0);
                }
            }
        } catch (Throwable th) {
            String str2 = f3905a;
            Logger.d(str2, "syncCurrentStatus throwable=" + th);
        }
    }

    public static void a(Context context, int i4, int i5) {
        String str;
        if (i4 == 0) {
            str = "set success";
            if (i5 == 0) {
                if (f3906b) {
                    f3906b = false;
                    Sp.set(context, Key.PushStatusSyncTime().set(Long.valueOf(System.currentTimeMillis())));
                } else {
                    cn.jpush.android.x.b.a(context, 2007, i4, "set success");
                }
                cn.jpush.android.cache.a.a(context, 1);
                JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 0, null, null, new Object[0]);
                ActionHelper.getInstance().doSingleAction(context, "third_stop", null);
                return;
            } else if (1 != i5) {
                return;
            }
        } else {
            str = "set fail";
            if (i5 == 0) {
                cn.jpush.android.x.b.a(context, 2007, i4, "set fail");
                return;
            } else if (1 != i5) {
                return;
            }
        }
        cn.jpush.android.x.b.a(context, 2006, i4, str);
    }

    public static void a(Context context, long j4, int i4) {
        String str = f3905a;
        Logger.d(str, "dealCallBack code=" + i4);
        c.a a4 = c.a().a(context, j4, i4);
        a(context, i4, a4 != null ? a4.f3912b : -1);
    }
}

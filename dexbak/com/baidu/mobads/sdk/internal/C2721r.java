package com.baidu.mobads.sdk.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import androidx.core.app.NotificationCompat;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.baidu.mobads.sdk.api.CustomNotification;
import com.baidu.mobads.sdk.api.ICommonModuleObj;
import com.kwad.sdk.core.scene.URLPackage;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.umeng.ccg.CcgConstant;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.sdk.internal.r */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2721r implements ICommonModuleObj {

    /* renamed from: a */
    private static volatile C2721r f9121a;

    /* renamed from: b */
    private CustomNotification f9122b = new CustomNotification();

    private C2721r() {
    }

    /* renamed from: a */
    public static C2721r m50346a() {
        if (f9121a == null) {
            synchronized (C2721r.class) {
                if (f9121a == null) {
                    f9121a = new C2721r();
                }
            }
        }
        return f9121a;
    }

    @Override // com.baidu.mobads.sdk.api.ICommonModuleObj
    public Object createModuleObj(String str, JSONObject jSONObject) {
        if (!ICommonModuleObj.KEY_NOTIFICATION.equals(str) || jSONObject == null) {
            return null;
        }
        Context context = (Context) jSONObject.opt("context");
        int optInt = jSONObject.optInt(ConstantHelper.LOG_VS, 0);
        String optString = jSONObject.optString(URLPackage.KEY_CHANNEL_ID);
        String optString2 = jSONObject.optString("ticker");
        Bitmap bitmap = (Bitmap) jSONObject.opt(RewardPlus.ICON);
        String optString3 = jSONObject.optString("title");
        String optString4 = jSONObject.optString("content");
        String optString5 = jSONObject.optString("status");
        boolean optBoolean = jSONObject.optBoolean("autoCancel");
        int optInt2 = jSONObject.optInt(NotificationCompat.CATEGORY_PROGRESS);
        boolean optBoolean2 = jSONObject.optBoolean("indeterminate", false);
        int optInt3 = jSONObject.optInt("smallIcon");
        String optString6 = jSONObject.optString(CcgConstant.f38549t);
        PendingIntent pendingIntent = (PendingIntent) jSONObject.opt("pendingIntent");
        String optString7 = jSONObject.optString("action2");
        PendingIntent pendingIntent2 = (PendingIntent) jSONObject.opt("pendingIntent2");
        if (optInt == 1) {
            return this.f9122b.getNewNotification(context, optString2, optBoolean, bitmap, optString3, optString4, optInt2, optBoolean2, optString6, pendingIntent, optString7, pendingIntent2);
        }
        return this.f9122b.getCustomNotification(context, optString, optString2, bitmap, optString3, optString4, optString5, optBoolean, optInt2, optInt3, optString6, pendingIntent);
    }
}

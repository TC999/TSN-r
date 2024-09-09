package com.baidu.mobads.sdk.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.mobads.sdk.api.CustomNotification;
import com.baidu.mobads.sdk.api.ICommonModuleObj;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class r implements ICommonModuleObj {

    /* renamed from: a  reason: collision with root package name */
    private static volatile r f12907a;

    /* renamed from: b  reason: collision with root package name */
    private CustomNotification f12908b = new CustomNotification();

    private r() {
    }

    public static r a() {
        if (f12907a == null) {
            synchronized (r.class) {
                if (f12907a == null) {
                    f12907a = new r();
                }
            }
        }
        return f12907a;
    }

    @Override // com.baidu.mobads.sdk.api.ICommonModuleObj
    public Object createModuleObj(String str, JSONObject jSONObject) {
        if (!"key_notification".equals(str) || jSONObject == null) {
            return null;
        }
        Context context = (Context) jSONObject.opt("context");
        int optInt = jSONObject.optInt("version", 0);
        String optString = jSONObject.optString("channelId");
        String optString2 = jSONObject.optString("ticker");
        Bitmap bitmap = (Bitmap) jSONObject.opt(RewardPlus.ICON);
        String optString3 = jSONObject.optString("title");
        String optString4 = jSONObject.optString("content");
        String optString5 = jSONObject.optString("status");
        boolean optBoolean = jSONObject.optBoolean("autoCancel");
        int optInt2 = jSONObject.optInt("progress");
        boolean optBoolean2 = jSONObject.optBoolean("indeterminate", false);
        int optInt3 = jSONObject.optInt("smallIcon");
        String optString6 = jSONObject.optString("action");
        PendingIntent pendingIntent = (PendingIntent) jSONObject.opt("pendingIntent");
        String optString7 = jSONObject.optString("action2");
        PendingIntent pendingIntent2 = (PendingIntent) jSONObject.opt("pendingIntent2");
        if (optInt == 1) {
            return this.f12908b.getNewNotification(context, optString2, optBoolean, bitmap, optString3, optString4, optInt2, optBoolean2, optString6, pendingIntent, optString7, pendingIntent2);
        }
        return this.f12908b.getCustomNotification(context, optString, optString2, bitmap, optString3, optString4, optString5, optBoolean, optInt2, optInt3, optString6, pendingIntent);
    }
}

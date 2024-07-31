package com.beizi.p051ad.lance.p062a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import java.util.List;

/* renamed from: com.beizi.ad.lance.a.j */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class JumpTool {
    /* renamed from: a */
    public static boolean m49050a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return m49051a(context, m49049a(str));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public static Intent m49049a(String str) {
        return m49048a(str, (String) null);
    }

    /* renamed from: a */
    public static Intent m49048a(String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (!TextUtils.isEmpty(str2)) {
            intent.setPackage(str2);
        }
        intent.setFlags(268435456);
        return intent;
    }

    /* renamed from: a */
    public static boolean m49051a(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }
}

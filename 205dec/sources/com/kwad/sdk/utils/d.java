package com.kwad.sdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {
    private static final Map<String, String> aOe;

    static {
        HashMap hashMap = new HashMap();
        aOe = hashMap;
        hashMap.put("HUAWEI", "com.huawei.appmarket");
        hashMap.put(BaseConstants.ROM_OPPO_UPPER_CONSTANT, "com.oppo.market");
        hashMap.put("vivo", "com.bbk.appstore");
        hashMap.put("xiaomi", "com.xiaomi.market");
        hashMap.put("OnePlus", "com.oppo.market");
        hashMap.put("Meizu", "com.meizu.mstore");
        hashMap.put("samsung", "com.sec.android.app.samsungapps");
        hashMap.put("SMARTISAN", "com.smartisanos.appstore");
        hashMap.put("Realme", "com.oppo.market");
        hashMap.put("HONOR", "com.huawei.appmarket");
    }

    public static boolean a(Context context, final String str, final AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        return at.Me() && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.adStyle != 4 && com.kwad.sdk.core.download.a.b.a(context, str, new b.C0695b() { // from class: com.kwad.sdk.utils.d.1
            @Override // com.kwad.sdk.core.download.a.b.C0695b, com.kwad.sdk.core.download.a.b.a
            public final void onError(Throwable th) {
                super.onError(th);
                com.kwad.sdk.commercial.b.a.a(AdTemplate.this, str, "com.xiaomi.market", 0, 1, bn.t(th));
            }

            @Override // com.kwad.sdk.core.download.a.b.C0695b, com.kwad.sdk.core.download.a.b.a
            public final void onStart() {
                super.onStart();
                com.kwad.sdk.commercial.b.a.a(AdTemplate.this, str, "com.xiaomi.market", 0, 1);
            }

            @Override // com.kwad.sdk.core.download.a.b.C0695b, com.kwad.sdk.core.download.a.b.a
            public final void onSuccess() {
                super.onSuccess();
                AdTemplate adTemplate2 = AdTemplate.this;
                adTemplate2.mXiaomiAppStoreDetailViewOpen = true;
                adTemplate2.mClickOpenAppStore = true;
                com.kwad.sdk.commercial.b.a.b(adTemplate2, str, "com.xiaomi.market", 0, 1);
            }
        }) == 1;
    }

    private static boolean gq(String str) {
        return BaseConstants.ROM_OPPO_UPPER_CONSTANT.equals(Build.BRAND) && "com.heytap.market".equals(str);
    }

    public static boolean h(Context context, AdTemplate adTemplate) {
        String str;
        String str2;
        int i4;
        Intent intent;
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        String cQ = com.kwad.sdk.core.response.b.a.cQ(dQ);
        String ay = com.kwad.sdk.core.response.b.a.ay(dQ);
        if (context != null && !TextUtils.isEmpty(cQ)) {
            try {
                String str3 = Build.BRAND;
                if ("samsung".equals(str3)) {
                    cQ = "http://apps.samsung.com/appquery/appDetail.as?appId=" + ay;
                }
                String str4 = aOe.get(str3);
                try {
                    com.kwad.sdk.commercial.b.a.a(adTemplate, cQ, str4, 1, 0);
                    intent = new Intent("android.intent.action.VIEW", Uri.parse(cQ));
                    intent.addFlags(268435456);
                    for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
                        if (!a(resolveInfo)) {
                            String str5 = resolveInfo.activityInfo.packageName;
                            if (str5.equals(str4) || gq(str5)) {
                                intent.setComponent(new ComponentName(str5, resolveInfo.activityInfo.name));
                                context.startActivity(intent);
                                adTemplate.mClickOpenAppStore = true;
                                com.kwad.sdk.commercial.b.a.b(adTemplate, cQ, str4, 1, 0);
                                return true;
                            }
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    str2 = str4;
                    str = cQ;
                    i4 = 1;
                    com.kwad.sdk.commercial.b.a.a(adTemplate, str, str2, i4, 0, bn.t(th));
                    return false;
                }
                try {
                    context.startActivity(intent);
                    adTemplate.mClickOpenAppStore = true;
                    com.kwad.sdk.commercial.b.a.b(adTemplate, cQ, str4, 0, 0);
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    str2 = str4;
                    str = cQ;
                    i4 = 0;
                    com.kwad.sdk.commercial.b.a.a(adTemplate, str, str2, i4, 0, bn.t(th));
                    return false;
                }
            } catch (Throwable th3) {
                th = th3;
                str = cQ;
                str2 = null;
            }
        }
        return false;
    }

    private static boolean a(ResolveInfo resolveInfo) {
        ActivityInfo activityInfo;
        return resolveInfo == null || (activityInfo = resolveInfo.activityInfo) == null || TextUtils.isEmpty(activityInfo.packageName);
    }
}

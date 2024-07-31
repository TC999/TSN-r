package com.kwad.sdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bxkj.student.C4229c;
import com.kwad.sdk.commercial.p373b.C9819a;
import com.kwad.sdk.core.download.p395a.C10299b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.kwad.sdk.utils.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11079d {
    private static final Map<String, String> aOe;

    static {
        HashMap hashMap = new HashMap();
        aOe = hashMap;
        hashMap.put("HUAWEI", "com.huawei.appmarket");
        hashMap.put("OPPO", "com.oppo.market");
        hashMap.put("vivo", "com.bbk.appstore");
        hashMap.put(C4229c.f16088d, "com.xiaomi.market");
        hashMap.put("OnePlus", "com.oppo.market");
        hashMap.put("Meizu", "com.meizu.mstore");
        hashMap.put("samsung", "com.sec.android.app.samsungapps");
        hashMap.put("SMARTISAN", "com.smartisanos.appstore");
        hashMap.put("Realme", "com.oppo.market");
        hashMap.put("HONOR", "com.huawei.appmarket");
    }

    /* renamed from: a */
    public static boolean m23838a(Context context, final String str, final AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        return C11027at.m24079Me() && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.adStyle != 4 && C10299b.m26366a(context, str, new C10299b.C10301b() { // from class: com.kwad.sdk.utils.d.1
            @Override // com.kwad.sdk.core.download.p395a.C10299b.C10301b, com.kwad.sdk.core.download.p395a.C10299b.InterfaceC10300a
            public final void onError(Throwable th) {
                super.onError(th);
                C9819a.m27645a(AdTemplate.this, str, "com.xiaomi.market", 0, 1, C11064bn.m23856t(th));
            }

            @Override // com.kwad.sdk.core.download.p395a.C10299b.C10301b, com.kwad.sdk.core.download.p395a.C10299b.InterfaceC10300a
            public final void onStart() {
                super.onStart();
                C9819a.m27646a(AdTemplate.this, str, "com.xiaomi.market", 0, 1);
            }

            @Override // com.kwad.sdk.core.download.p395a.C10299b.C10301b, com.kwad.sdk.core.download.p395a.C10299b.InterfaceC10300a
            public final void onSuccess() {
                super.onSuccess();
                AdTemplate adTemplate2 = AdTemplate.this;
                adTemplate2.mXiaomiAppStoreDetailViewOpen = true;
                adTemplate2.mClickOpenAppStore = true;
                C9819a.m27643b(adTemplate2, str, "com.xiaomi.market", 0, 1);
            }
        }) == 1;
    }

    /* renamed from: gq */
    private static boolean m23836gq(String str) {
        return "OPPO".equals(Build.BRAND) && "com.heytap.market".equals(str);
    }

    /* renamed from: h */
    public static boolean m23835h(Context context, AdTemplate adTemplate) {
        String str;
        String str2;
        int i;
        Intent intent;
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        String m25837cQ = C10483a.m25837cQ(m25641dQ);
        String m25911ay = C10483a.m25911ay(m25641dQ);
        if (context != null && !TextUtils.isEmpty(m25837cQ)) {
            try {
                String str3 = Build.BRAND;
                if ("samsung".equals(str3)) {
                    m25837cQ = "http://apps.samsung.com/appquery/appDetail.as?appId=" + m25911ay;
                }
                String str4 = aOe.get(str3);
                try {
                    C9819a.m27646a(adTemplate, m25837cQ, str4, 1, 0);
                    intent = new Intent("android.intent.action.VIEW", Uri.parse(m25837cQ));
                    intent.addFlags(268435456);
                    for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
                        if (!m23837a(resolveInfo)) {
                            String str5 = resolveInfo.activityInfo.packageName;
                            if (str5.equals(str4) || m23836gq(str5)) {
                                intent.setComponent(new ComponentName(str5, resolveInfo.activityInfo.name));
                                context.startActivity(intent);
                                adTemplate.mClickOpenAppStore = true;
                                C9819a.m27643b(adTemplate, m25837cQ, str4, 1, 0);
                                return true;
                            }
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    str2 = str4;
                    str = m25837cQ;
                    i = 1;
                    C9819a.m27645a(adTemplate, str, str2, i, 0, C11064bn.m23856t(th));
                    return false;
                }
                try {
                    context.startActivity(intent);
                    adTemplate.mClickOpenAppStore = true;
                    C9819a.m27643b(adTemplate, m25837cQ, str4, 0, 0);
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    str2 = str4;
                    str = m25837cQ;
                    i = 0;
                    C9819a.m27645a(adTemplate, str, str2, i, 0, C11064bn.m23856t(th));
                    return false;
                }
            } catch (Throwable th3) {
                th = th3;
                str = m25837cQ;
                str2 = null;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m23837a(ResolveInfo resolveInfo) {
        ActivityInfo activityInfo;
        return resolveInfo == null || (activityInfo = resolveInfo.activityInfo) == null || TextUtils.isEmpty(activityInfo.packageName);
    }
}

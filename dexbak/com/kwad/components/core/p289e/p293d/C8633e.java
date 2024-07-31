package com.kwad.components.core.p289e.p293d;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.commercial.p380i.C9842a;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9912a;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p391c.C10232b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.crash.utils.C10738b;
import com.kwad.sdk.utils.C11064bn;

/* renamed from: com.kwad.components.core.e.d.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8633e {

    /* renamed from: Lj */
    private static boolean f28269Lj;

    /* renamed from: E */
    public static boolean m30102E(AdInfo adInfo) {
        AdInfo.SmallAppJumpInfo smallAppJumpInfo;
        return (adInfo == null || (smallAppJumpInfo = adInfo.adConversionInfo.smallAppJumpInfo) == null || TextUtils.isEmpty(smallAppJumpInfo.mediaSmallAppId) || TextUtils.isEmpty(adInfo.adConversionInfo.smallAppJumpInfo.originId) || TextUtils.isEmpty(adInfo.adConversionInfo.smallAppJumpInfo.smallAppJumpUrl)) ? false : true;
    }

    /* renamed from: a */
    public static int m30101a(Context context, String str, String str2, String str3, AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            Cursor cursor = null;
            try {
                C9842a.m27542a(adTemplate, str, str2, str3);
                Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.addFlags(268435456);
                intent.setComponent(launchIntentForPackage.getComponent());
                context.startActivity(intent);
                Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram"), null, null, new String[]{str, str2, str3, "0", ""}, null);
                if (query != null) {
                    try {
                        C10738b.closeQuietly(query);
                    } catch (Throwable th) {
                        th = th;
                        cursor = query;
                        try {
                            C9842a.m27541a(adTemplate, str, str2, str3, C11064bn.m23856t(th));
                            C9908c.m27297j(adTemplate, 2);
                            C10738b.closeQuietly(cursor);
                            return -1;
                        } catch (Throwable th2) {
                            C10738b.closeQuietly(cursor);
                            throw th2;
                        }
                    }
                }
                C9842a.m27539b(adTemplate, str, str2, str3);
                C9908c.m27339a(adTemplate, "wxsmallapp", 1, (C9912a) null);
                m30100a(str, str2, str3, adTemplate);
                C10738b.closeQuietly(query);
                return 1;
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            C9908c.m27297j(adTemplate, 1);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aA */
    public static void m30099aA(boolean z) {
        f28269Lj = z;
    }

    /* renamed from: d */
    public static int m30097d(Context context, AdTemplate adTemplate) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        if (C10483a.m25969S(m25641dQ) || C10483a.m25968T(m25641dQ)) {
            return 0;
        }
        AdInfo.SmallAppJumpInfo smallAppJumpInfo = m25641dQ.adConversionInfo.smallAppJumpInfo;
        return m30101a(context, smallAppJumpInfo.mediaSmallAppId, smallAppJumpInfo.originId, smallAppJumpInfo.smallAppJumpUrl, adTemplate);
    }

    /* renamed from: op */
    private static boolean m30096op() {
        return f28269Lj;
    }

    /* renamed from: a */
    private static void m30100a(final String str, final String str2, final String str3, final AdTemplate adTemplate) {
        if (m30096op()) {
            return;
        }
        m30099aA(true);
        int abs = Math.abs(C10251d.m26574BT());
        if (abs > 0) {
            C11064bn.m23862a(new Runnable() { // from class: com.kwad.components.core.e.d.e.1
                @Override // java.lang.Runnable
                public final void run() {
                    C8633e.m30099aA(false);
                    C10232b.m26625DD();
                    if (C10232b.isAppOnForeground()) {
                        return;
                    }
                    C9842a.m27538c(AdTemplate.this, str, str2, str3);
                    C9908c.m27315c(AdTemplate.this, "wxsmallapp", 1);
                }
            }, null, abs * 1000);
        } else {
            m30099aA(false);
        }
    }
}

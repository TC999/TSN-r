package com.beizi.fusion.p072g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.model.RequestInfo;
import com.beizi.fusion.p066d.AdManager;
import com.beizi.fusion.p068e.p069a.DevicesIDsHelper;

/* renamed from: com.beizi.fusion.g.ai */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class OaidUtil {

    /* renamed from: a */
    static String f11265a = "OaidUtil";

    /* renamed from: c */
    private static String f11267c;

    /* renamed from: b */
    public static DevicesIDsHelper.InterfaceC3094a f11266b = new DevicesIDsHelper.InterfaceC3094a() { // from class: com.beizi.fusion.g.ai.1
        @Override // com.beizi.fusion.p068e.p069a.DevicesIDsHelper.InterfaceC3094a
        /* renamed from: a */
        public void mo48445a(@NonNull String str) {
            String str2 = OaidUtil.f11265a;
            Log.e(str2, "code cn Oaid:" + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String unused = OaidUtil.f11267c = str;
            Context m48778e = AdManager.m48786a().m48778e();
            C3137at.m48315a(m48778e, "__OAID__", (Object) OaidUtil.f11267c);
            C3137at.m48315a(m48778e, "__CNOAID__", (Object) OaidUtil.f11267c);
            if (RequestInfo.getInstance(m48778e).getDevInfo() != null) {
                if (PersonalizedUtil.m48442b() && BeiZis.isLimitPersonalAds()) {
                    return;
                }
                RequestInfo.getInstance(m48778e).getDevInfo().setOaid(OaidUtil.f11267c);
                RequestInfo.getInstance(m48778e).getDevInfo().setCnOaid(OaidUtil.f11267c);
            }
        }
    };

    /* renamed from: d */
    private static boolean f11268d = true;
}

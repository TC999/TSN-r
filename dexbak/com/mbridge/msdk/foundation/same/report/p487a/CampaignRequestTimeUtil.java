package com.mbridge.msdk.foundation.same.report.p487a;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.LoadTime;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.p472db.LoadTimeDao;
import com.mbridge.msdk.foundation.tools.SameDiTool;

/* renamed from: com.mbridge.msdk.foundation.same.report.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class CampaignRequestTimeUtil {

    /* renamed from: a */
    private LoadTime f30897a;

    /* renamed from: b */
    private CommonSDKDBHelper f30898b;

    /* renamed from: c */
    private Context f30899c;

    public CampaignRequestTimeUtil(LoadTime loadTime) {
        Context context;
        this.f30898b = null;
        this.f30897a = loadTime;
        Context m22861j = MBSDKContext.m22865f().m22861j();
        this.f30899c = m22861j;
        this.f30898b = CommonSDKDBHelper.m22721a(m22861j);
        if (this.f30897a == null || (context = this.f30899c) == null) {
            return;
        }
        int m21804D = SameDiTool.m21804D(context);
        this.f30897a.m22525e(m21804D);
        this.f30897a.m22529c(SameDiTool.m21784a(this.f30899c, m21804D));
        this.f30897a.m22527d(2);
    }

    /* renamed from: a */
    public final void m22146a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f30897a.m22535a(str);
    }

    /* renamed from: b */
    public final void m22145b(int i) {
        LoadTime loadTime = this.f30897a;
        if (loadTime != null) {
            loadTime.m22530c(i);
        }
    }

    /* renamed from: c */
    public final void m22143c(int i) {
        LoadTime loadTime = this.f30897a;
        if (loadTime != null) {
            loadTime.m22536a(i);
        }
    }

    /* renamed from: b */
    public final void m22144b(String str) {
        LoadTime loadTime = this.f30897a;
        if (loadTime != null) {
            loadTime.m22532b(str);
        }
    }

    /* renamed from: a */
    public final void m22147a(int i) {
        LoadTime loadTime = this.f30897a;
        if (loadTime != null) {
            loadTime.m22533b(i);
        }
    }

    /* renamed from: a */
    public final void m22148a() {
        if (this.f30897a != null) {
            LoadTimeDao.m22695a(this.f30898b).m22694a(this.f30897a);
        }
    }
}

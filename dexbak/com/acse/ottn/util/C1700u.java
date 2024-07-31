package com.acse.ottn.util;

import android.accessibilityservice.AccessibilityService;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.acse.ottn.model.PageSettingTypeModel;
import com.acse.ottn.util.C1648S;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.util.u */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1700u implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ PageSettingTypeModel f3375a;

    /* renamed from: b */
    final /* synthetic */ String f3376b;

    /* renamed from: c */
    final /* synthetic */ C1617A f3377c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1700u(C1617A c1617a, PageSettingTypeModel pageSettingTypeModel, String str) {
        this.f3377c = c1617a;
        this.f3375a = pageSettingTypeModel;
        this.f3376b = str;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
        String str;
        C1617A c1617a;
        AccessibilityService accessibilityService;
        boolean z;
        PageSettingTypeModel pageSettingTypeModel;
        Handler handler;
        Runnable runnableC1695s;
        String str2;
        String m56328b;
        String str3;
        String str4;
        String str5;
        try {
            C1617A c1617a2 = this.f3377c;
            if (c1617a2.f3126r) {
                if (c1617a2.f3119k == null) {
                    c1617a2.f3119k = new ArrayList();
                    this.f3377c.f3120l = 0;
                }
                if (!C1652V.m56140a().m56129b(this.f3377c.f3119k) || !C1652V.m56140a().m56136a(this.f3377c.f3119k)) {
                    c1617a = this.f3377c;
                    accessibilityService = c1617a.f3122n;
                    z = c1617a.f3126r;
                    pageSettingTypeModel = this.f3375a;
                    c1617a.m56348a(accessibilityService, z, pageSettingTypeModel.getRead_description());
                    return;
                }
                TimerTask timerTask = C1617A.f3110b;
                if (timerTask != null) {
                    timerTask.cancel();
                    str5 = C1617A.f3113e;
                    C1694ra.m55917a(str5, "gainContent cancle2");
                    C1617A.f3110b = null;
                }
                str4 = C1617A.f3113e;
                C1694ra.m55917a(str4, this.f3377c.f3119k.toString());
                handler = new Handler(Looper.getMainLooper());
                runnableC1695s = new RunnableC1693r(this);
                handler.postDelayed(runnableC1695s, 0L);
            }
            if (c1617a2.f3119k != null) {
                str3 = C1617A.f3113e;
                C1694ra.m55917a(str3, this.f3377c.f3119k.toString());
            } else {
                c1617a2.f3120l = 0;
                c1617a2.f3119k = new ArrayList();
            }
            if (!C1652V.m56140a().m56135a(this.f3377c.f3119k, this.f3375a.getPackage_name(), this.f3375a.getRead_length())) {
                c1617a = this.f3377c;
                accessibilityService = c1617a.f3122n;
                z = c1617a.f3126r;
                pageSettingTypeModel = this.f3375a;
                c1617a.m56348a(accessibilityService, z, pageSettingTypeModel.getRead_description());
                return;
            }
            TimerTask timerTask2 = C1617A.f3110b;
            if (timerTask2 != null) {
                timerTask2.cancel();
                C1617A.f3110b = null;
            }
            this.f3377c.f3127s = "";
            if (this.f3375a.getPackage_name().equals(C1631H.m56262a().f3231ta) && this.f3375a.getIs_click_jd_title().equals("0")) {
                String m56086d = C1661ba.m56097a().m56086d("jd_view_id");
                str2 = C1617A.f3113e;
                StringBuilder sb = new StringBuilder();
                sb.append("jd id =");
                sb.append(m56086d);
                C1694ra.m55917a(str2, sb.toString());
                if (!TextUtils.isEmpty(m56086d)) {
                    C1617A c1617a3 = this.f3377c;
                    m56328b = c1617a3.m56328b(c1617a3.f3122n, m56086d);
                    c1617a3.f3127s = m56328b;
                    if (!TextUtils.isEmpty(this.f3377c.f3127s)) {
                        C1617A c1617a4 = this.f3377c;
                        c1617a4.f3119k.add(c1617a4.f3127s);
                    }
                }
            }
            handler = new Handler(Looper.getMainLooper());
            runnableC1695s = new RunnableC1695s(this);
            handler.postDelayed(runnableC1695s, 0L);
        } catch (Exception e) {
            str = C1617A.f3113e;
            C1694ra.m55917a(str, "gainContent=" + e.getMessage());
        }
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        String str;
        String str2;
        String str3;
        String str4;
        String m56328b;
        TimerTask timerTask = C1617A.f3110b;
        if (timerTask != null) {
            timerTask.cancel();
            C1617A.f3110b = null;
        }
        str = C1617A.f3113e;
        C1694ra.m55917a(str, "gainContent finish");
        List<String> list = this.f3377c.f3119k;
        if (list == null || list.size() < 6) {
            return;
        }
        this.f3377c.f3127s = "";
        str2 = C1617A.f3113e;
        C1694ra.m55917a(str2, "model.getPackage_name() =" + this.f3375a.getPackage_name() + "   model.getIs_click_jd_title()=" + this.f3375a.getIs_click_jd_title());
        if (this.f3375a.getPackage_name().equals(C1631H.m56262a().f3231ta) && this.f3375a.getIs_click_jd_title().equals("0")) {
            String m56086d = C1661ba.m56097a().m56086d("jd_view_id");
            str4 = C1617A.f3113e;
            C1694ra.m55917a(str4, "jd id =" + m56086d);
            if (!TextUtils.isEmpty(m56086d)) {
                C1617A c1617a = this.f3377c;
                m56328b = c1617a.m56328b(c1617a.f3122n, m56086d);
                c1617a.f3127s = m56328b;
                if (!TextUtils.isEmpty(this.f3377c.f3127s)) {
                    C1617A c1617a2 = this.f3377c;
                    c1617a2.f3119k.add(c1617a2.f3127s);
                }
            }
        }
        str3 = C1617A.f3113e;
        C1694ra.m55917a(str3, this.f3377c.f3119k.toString());
        new Handler(Looper.getMainLooper()).postDelayed(new RunnableC1698t(this), 0L);
    }
}

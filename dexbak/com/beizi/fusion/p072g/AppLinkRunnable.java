package com.beizi.fusion.p072g;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.model.TaskBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.EventCar;
import com.beizi.fusion.p066d.AdManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.beizi.fusion.g.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AppLinkRunnable implements Runnable {

    /* renamed from: a */
    private static String f11356a = "AppLinkRunnable";

    /* renamed from: b */
    private TaskBean.BackTaskArrayBean f11357b;

    /* renamed from: c */
    private Context f11358c;

    public AppLinkRunnable(Context context, TaskBean.BackTaskArrayBean backTaskArrayBean) {
        this.f11358c = context;
        this.f11357b = backTaskArrayBean;
    }

    /* renamed from: a */
    private void m48268a() {
        int i;
        ArrayList arrayList;
        try {
            ArrayList arrayList2 = new ArrayList();
            List<TaskBean.BackTaskArrayBean.AppLinkBean> apps = this.f11357b.getApps();
            if (apps == null || apps.size() <= 0) {
                return;
            }
            Iterator<TaskBean.BackTaskArrayBean.AppLinkBean> it = apps.iterator();
            while (true) {
                i = 0;
                if (!it.hasNext()) {
                    break;
                }
                TaskBean.BackTaskArrayBean.AppLinkBean next = it.next();
                String valueOf = C3138av.m48303a(this.f11358c, next.getTestLink()) ? String.valueOf(1) : String.valueOf(0);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appLinkId", next.getAppLinkId());
                jSONObject.put("isLink", valueOf);
                arrayList2.add(jSONObject.toString());
            }
            List<String> report = this.f11357b.getReport();
            if (report == null || report.size() <= 0) {
                return;
            }
            while (i < report.size()) {
                if (TextUtils.isEmpty(report.get(i))) {
                    arrayList = arrayList2;
                } else {
                    arrayList = arrayList2;
                    EventCar.m48869a(this.f11358c).m48862b(new EventBean(AdManager.f11053b, "", "590.200", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), "", arrayList2.toString(), report.get(i), false));
                }
                i++;
                arrayList2 = arrayList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f11357b != null) {
            try {
                if (System.currentTimeMillis() - C3138av.m48282p(this.f11358c).longValue() < 86400000) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (int i = 0; i < this.f11357b.getRepeatCount(); i++) {
                if (this.f11357b.getMethod().equalsIgnoreCase("GET")) {
                    try {
                        m48268a();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        EventCar.m48869a(this.f11358c).m48862b(new EventBean(AdManager.f11053b, "", "510.500", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                    }
                }
            }
            EventCar.m48869a(this.f11358c).m48862b(new EventBean(AdManager.f11053b, "", "510.200", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        }
    }
}

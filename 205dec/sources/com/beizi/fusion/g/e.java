package com.beizi.fusion.g;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.model.TaskBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AppLinkRunnable.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static String f14911a = "AppLinkRunnable";

    /* renamed from: b  reason: collision with root package name */
    private TaskBean.BackTaskArrayBean f14912b;

    /* renamed from: c  reason: collision with root package name */
    private Context f14913c;

    public e(Context context, TaskBean.BackTaskArrayBean backTaskArrayBean) {
        this.f14913c = context;
        this.f14912b = backTaskArrayBean;
    }

    private void a() {
        int i4;
        ArrayList arrayList;
        try {
            ArrayList arrayList2 = new ArrayList();
            List<TaskBean.BackTaskArrayBean.AppLinkBean> apps = this.f14912b.getApps();
            if (apps == null || apps.size() <= 0) {
                return;
            }
            Iterator<TaskBean.BackTaskArrayBean.AppLinkBean> it = apps.iterator();
            while (true) {
                i4 = 0;
                if (!it.hasNext()) {
                    break;
                }
                TaskBean.BackTaskArrayBean.AppLinkBean next = it.next();
                String valueOf = aw.a(this.f14913c, next.getTestLink()) ? String.valueOf(1) : String.valueOf(0);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appLinkId", next.getAppLinkId());
                jSONObject.put("isLink", valueOf);
                arrayList2.add(jSONObject.toString());
            }
            List<String> report = this.f14912b.getReport();
            if (report == null || report.size() <= 0) {
                return;
            }
            while (i4 < report.size()) {
                if (TextUtils.isEmpty(report.get(i4))) {
                    arrayList = arrayList2;
                } else {
                    arrayList = arrayList2;
                    com.beizi.fusion.b.c.a(this.f14913c).b(new com.beizi.fusion.b.b(com.beizi.fusion.d.b.f14592b, "", "590.200", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), "", arrayList2.toString(), report.get(i4), false));
                }
                i4++;
                arrayList2 = arrayList;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f14912b != null) {
            try {
                if (System.currentTimeMillis() - aw.p(this.f14913c).longValue() < 86400000) {
                    return;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            for (int i4 = 0; i4 < this.f14912b.getRepeatCount(); i4++) {
                if (this.f14912b.getMethod().equalsIgnoreCase("GET")) {
                    try {
                        a();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                        com.beizi.fusion.b.c.a(this.f14913c).b(new com.beizi.fusion.b.b(com.beizi.fusion.d.b.f14592b, "", "510.500", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                    }
                }
            }
            com.beizi.fusion.b.c.a(this.f14913c).b(new com.beizi.fusion.b.b(com.beizi.fusion.d.b.f14592b, "", "510.200", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        }
    }
}

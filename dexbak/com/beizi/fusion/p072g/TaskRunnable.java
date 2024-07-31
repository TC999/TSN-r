package com.beizi.fusion.p072g;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.model.TaskBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.EventCar;
import com.beizi.fusion.p066d.AdManager;
import java.util.List;

/* renamed from: com.beizi.fusion.g.aw */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class TaskRunnable implements Runnable {

    /* renamed from: a */
    private static String f11348a = "TaskRunnable";

    /* renamed from: b */
    private TaskBean.BackTaskArrayBean f11349b;

    /* renamed from: c */
    private Context f11350c;

    public TaskRunnable(Context context, TaskBean.BackTaskArrayBean backTaskArrayBean) {
        this.f11350c = context;
        this.f11349b = backTaskArrayBean;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f11349b != null) {
            for (int i = 0; i < this.f11349b.getRepeatCount(); i++) {
                if (this.f11349b.getMethod().equals("GET") && !TextUtils.isEmpty(this.f11349b.getContentUrl())) {
                    try {
                        EventBean eventBean = null;
                        HttpUtil.m48508a(StringUtil.m48310a(this.f11350c, this.f11349b.getContentUrl(), null), this.f11349b.getUserAgent());
                        Thread.sleep(this.f11349b.getSleepTime());
                        List<String> report = this.f11349b.getReport();
                        if (report != null && report.size() > 0) {
                            int i2 = 0;
                            while (i2 < report.size()) {
                                if (!TextUtils.isEmpty(report.get(i2))) {
                                    if (HttpUtil.m48508a(StringUtil.m48310a(this.f11350c, report.get(i2), eventBean), this.f11349b.getUserAgent()) != null) {
                                        EventCar.m48869a(this.f11350c).m48862b(new EventBean(AdManager.f11053b, "", "520.200", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                                    } else {
                                        EventCar.m48869a(this.f11350c).m48862b(new EventBean(AdManager.f11053b, "", "520.500", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                                    }
                                    Thread.sleep(this.f11349b.getSleepTime());
                                }
                                i2++;
                                eventBean = null;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        EventCar.m48869a(this.f11350c).m48862b(new EventBean(AdManager.f11053b, "", "510.500", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                    }
                }
            }
            EventCar.m48869a(this.f11350c).m48862b(new EventBean(AdManager.f11053b, "", "510.200", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        }
    }
}

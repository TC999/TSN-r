package com.beizi.fusion.p072g;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.model.TaskBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.EventCar;
import com.beizi.fusion.p066d.AdManager;
import com.stub.StubApp;
import java.util.List;

/* renamed from: com.beizi.fusion.g.o */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ClipUtil {

    /* renamed from: b */
    private static ClipUtil f11398b;

    /* renamed from: a */
    private String f11399a = "ClipUtil";

    /* renamed from: c */
    private Context f11400c;

    private ClipUtil(Context context) {
        this.f11400c = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    /* renamed from: a */
    public static ClipUtil m48235a(Context context) {
        if (f11398b == null) {
            synchronized (ClipUtil.class) {
                if (f11398b == null) {
                    f11398b = new ClipUtil(context);
                }
            }
        }
        return f11398b;
    }

    /* renamed from: a */
    public void m48233a(final TaskBean.BackTaskArrayBean backTaskArrayBean) {
        if (backTaskArrayBean != null && !TextUtils.isEmpty(backTaskArrayBean.getContentUrl())) {
            EventCar.m48869a(this.f11400c).m48868a(new EventBean(AdManager.f11053b, "", "510.200", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
            final List<String> report = backTaskArrayBean.getReport();
            if (report == null || report.size() <= 0) {
                return;
            }
            C3145h.m48264b().m48261e().execute(new Runnable() { // from class: com.beizi.fusion.g.o.1
                @Override // java.lang.Runnable
                public void run() {
                    for (int i = 0; i < report.size(); i++) {
                        if (!TextUtils.isEmpty((CharSequence) report.get(i))) {
                            if (HttpUtil.m48508a(StringUtil.m48310a(ClipUtil.this.f11400c, (String) report.get(i), null), backTaskArrayBean.getUserAgent()) != null) {
                                EventCar.m48869a(ClipUtil.this.f11400c).m48862b(new EventBean(AdManager.f11053b, "", "520.200", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                            } else {
                                EventCar.m48869a(ClipUtil.this.f11400c).m48862b(new EventBean(AdManager.f11053b, "", "520.500", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                            }
                            try {
                                Thread.sleep(backTaskArrayBean.getSleepTime());
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });
            return;
        }
        EventCar.m48869a(this.f11400c).m48868a(new EventBean(AdManager.f11053b, "", "510.500", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
    }
}

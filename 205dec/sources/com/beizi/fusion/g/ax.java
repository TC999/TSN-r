package com.beizi.fusion.g;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.model.TaskBean;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: TaskRunnable.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ax implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static String f14903a = "TaskRunnable";

    /* renamed from: b  reason: collision with root package name */
    private TaskBean.BackTaskArrayBean f14904b;

    /* renamed from: c  reason: collision with root package name */
    private Context f14905c;

    public ax(Context context, TaskBean.BackTaskArrayBean backTaskArrayBean) {
        this.f14905c = context;
        this.f14904b = backTaskArrayBean;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f14904b != null) {
            for (int i4 = 0; i4 < this.f14904b.getRepeatCount(); i4++) {
                if (this.f14904b.getMethod().equals("GET") && !TextUtils.isEmpty(this.f14904b.getContentUrl())) {
                    try {
                        com.beizi.fusion.b.b bVar = null;
                        ab.a(av.a(this.f14905c, this.f14904b.getContentUrl(), null), this.f14904b.getUserAgent());
                        Thread.sleep(this.f14904b.getSleepTime());
                        List<String> report = this.f14904b.getReport();
                        if (report != null && report.size() > 0) {
                            int i5 = 0;
                            while (i5 < report.size()) {
                                if (!TextUtils.isEmpty(report.get(i5))) {
                                    if (ab.a(av.a(this.f14905c, report.get(i5), bVar), this.f14904b.getUserAgent()) != null) {
                                        com.beizi.fusion.b.c.a(this.f14905c).b(new com.beizi.fusion.b.b(com.beizi.fusion.d.b.f14592b, "", "520.200", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                                    } else {
                                        com.beizi.fusion.b.c.a(this.f14905c).b(new com.beizi.fusion.b.b(com.beizi.fusion.d.b.f14592b, "", "520.500", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                                    }
                                    Thread.sleep(this.f14904b.getSleepTime());
                                }
                                i5++;
                                bVar = null;
                            }
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        com.beizi.fusion.b.c.a(this.f14905c).b(new com.beizi.fusion.b.b(com.beizi.fusion.d.b.f14592b, "", "510.500", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                    }
                }
            }
            com.beizi.fusion.b.c.a(this.f14905c).b(new com.beizi.fusion.b.b(com.beizi.fusion.d.b.f14592b, "", "510.200", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        }
    }
}

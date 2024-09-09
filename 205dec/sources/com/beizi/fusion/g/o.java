package com.beizi.fusion.g;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.model.TaskBean;
import com.stub.StubApp;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ClipUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class o {

    /* renamed from: b  reason: collision with root package name */
    private static o f14953b;

    /* renamed from: a  reason: collision with root package name */
    private String f14954a = "ClipUtil";

    /* renamed from: c  reason: collision with root package name */
    private Context f14955c;

    private o(Context context) {
        this.f14955c = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public static o a(Context context) {
        if (f14953b == null) {
            synchronized (o.class) {
                if (f14953b == null) {
                    f14953b = new o(context);
                }
            }
        }
        return f14953b;
    }

    public void a(final TaskBean.BackTaskArrayBean backTaskArrayBean) {
        if (backTaskArrayBean != null && !TextUtils.isEmpty(backTaskArrayBean.getContentUrl())) {
            com.beizi.fusion.b.c.a(this.f14955c).a(new com.beizi.fusion.b.b(com.beizi.fusion.d.b.f14592b, "", "510.200", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
            final List<String> report = backTaskArrayBean.getReport();
            if (report == null || report.size() <= 0) {
                return;
            }
            h.b().e().execute(new Runnable() { // from class: com.beizi.fusion.g.o.1
                @Override // java.lang.Runnable
                public void run() {
                    for (int i4 = 0; i4 < report.size(); i4++) {
                        if (!TextUtils.isEmpty((CharSequence) report.get(i4))) {
                            if (ab.a(av.a(o.this.f14955c, (String) report.get(i4), null), backTaskArrayBean.getUserAgent()) != null) {
                                com.beizi.fusion.b.c.a(o.this.f14955c).b(new com.beizi.fusion.b.b(com.beizi.fusion.d.b.f14592b, "", "520.200", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                            } else {
                                com.beizi.fusion.b.c.a(o.this.f14955c).b(new com.beizi.fusion.b.b(com.beizi.fusion.d.b.f14592b, "", "520.500", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                            }
                            try {
                                Thread.sleep(backTaskArrayBean.getSleepTime());
                            } catch (InterruptedException e4) {
                                e4.printStackTrace();
                            }
                        }
                    }
                }
            });
            return;
        }
        com.beizi.fusion.b.c.a(this.f14955c).a(new com.beizi.fusion.b.b(com.beizi.fusion.d.b.f14592b, "", "510.500", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
    }
}

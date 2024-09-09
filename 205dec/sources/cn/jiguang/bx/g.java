package cn.jiguang.bx;

import android.content.Context;
import android.os.Message;
import android.os.SystemClock;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static volatile g f3094a;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f3095b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private Context f3096c;

    /* renamed from: d  reason: collision with root package name */
    private cn.jiguang.cb.a f3097d = new cn.jiguang.cb.a() { // from class: cn.jiguang.bx.g.1
        @Override // cn.jiguang.cb.a
        public void a(Message message) {
            cn.jiguang.bq.d.c("PeriodWorker", "time is up, next period=" + (h.a().g() * 1000));
            g gVar = g.this;
            gVar.c(gVar.f3096c);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private long f3098e;

    private g() {
    }

    public static g a() {
        if (f3094a == null) {
            synchronized (f3095b) {
                if (f3094a == null) {
                    f3094a = new g();
                }
            }
        }
        return f3094a;
    }

    private void b(Context context) {
        this.f3098e = SystemClock.elapsedRealtime();
        if (((Boolean) cn.jiguang.g.b.a(context, cn.jiguang.g.a.Z())).booleanValue()) {
            a.a(context);
        } else {
            a.b(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context) {
        cn.jiguang.bq.d.c("PeriodWorker", "periodTask...");
        b(context);
        cn.jiguang.a.a.a(context, false, 0L);
        b.a().a(context, 19, 0, "periodTask");
        e.a(context, "periodtask", null);
        cn.jiguang.bm.e.c(context);
    }

    public void a(Context context) {
        this.f3096c = context;
        cn.jiguang.cb.b.a().a(AVMDLDataLoader.KeyIsLiveSetLoaderType, h.a().f() * 1000, this.f3097d);
    }

    public void a(Context context, boolean z3) {
        cn.jiguang.bq.d.f("PeriodWorker", "PeriodWorker resume");
        if (this.f3098e > 0 && SystemClock.elapsedRealtime() > this.f3098e + ((h.a().f() + 5) * 1000)) {
            cn.jiguang.bq.d.f("PeriodWorker", "schedule time is expired, execute now");
            a(context);
            c(context);
        } else if (!z3) {
            cn.jiguang.bq.d.c("PeriodWorker", "need not change period task");
        } else {
            a(context);
            b(context);
        }
    }

    public void b() {
        this.f3098e = SystemClock.elapsedRealtime();
        a.a(this.f3096c);
        cn.jiguang.cb.b.a().a(AVMDLDataLoader.KeyIsLiveSetLoaderType, h.a().f() * 1000, this.f3097d);
    }
}

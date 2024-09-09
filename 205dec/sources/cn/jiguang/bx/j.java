package cn.jiguang.bx;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import cn.jiguang.api.JCoreManager;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static volatile j f3145a = null;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f3146b = new Object();

    /* renamed from: e  reason: collision with root package name */
    private static long f3147e = 1;

    /* renamed from: d  reason: collision with root package name */
    private cn.jiguang.cb.a f3149d = new cn.jiguang.cb.a() { // from class: cn.jiguang.bx.j.1
        @Override // cn.jiguang.cb.a
        public void a(Message message) {
            long j4 = message.what - 100000;
            Bundle bundle = new Bundle();
            bundle.putLong("rid", j4);
            h.a().a(JCoreManager.getAppContext(null), "tcp_a6", bundle);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private Map<Long, d> f3148c = new HashMap();

    private j() {
    }

    public static j a() {
        if (f3145a == null) {
            synchronized (f3146b) {
                if (f3145a == null) {
                    f3145a = new j();
                }
            }
        }
        return f3145a;
    }

    private byte[] a(Context context, d dVar) {
        return cn.jiguang.bz.b.a(context, dVar.f3086d, dVar.f3087e, dVar.f3088f, dVar.f3089g, 0L);
    }

    public static long b() {
        long j4 = f3147e + 1;
        f3147e = j4;
        if (j4 >= 2147483647L) {
            f3147e = 1L;
        }
        return f3147e;
    }

    public d a(long j4) {
        return this.f3148c.get(Long.valueOf(j4));
    }

    public void a(Context context) {
        if (this.f3148c.isEmpty()) {
            cn.jiguang.bq.d.c("TcpRequestManager", "no cache request");
            return;
        }
        for (Map.Entry<Long, d> entry : this.f3148c.entrySet()) {
            if (entry.getValue().f3092j) {
                long nanoTime = System.nanoTime() - entry.getValue().f3090h;
                if (entry.getValue().f3091i - nanoTime >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                    entry.getValue().a();
                    cn.jiguang.bq.d.c("TcpRequestManager", "send again:" + entry.getValue());
                    h.a().c().d().a(a(context, entry.getValue()));
                } else {
                    cn.jiguang.bq.d.c("TcpRequestManager", "shoud not send again by 10000ms,hasRequestTime:" + nanoTime + ",timeout:" + entry.getValue().f3091i);
                }
            }
        }
    }

    public void a(Context context, long j4) {
        d remove = this.f3148c.remove(Long.valueOf(j4));
        if (remove != null) {
            if (remove.f3092j) {
                cn.jiguang.cb.b.a().b((int) (j4 + 100000));
            }
            cn.jiguang.bq.d.c("TcpRequestManager", "handle reponse :" + remove);
        }
    }

    public void a(Context context, long j4, int i4, int i5, byte[] bArr, String str) {
        long c4 = cn.jiguang.bv.c.c(context);
        if (this.f3148c.containsKey(Long.valueOf(c4))) {
            cn.jiguang.bq.d.j("TcpRequestManager", "Generator same rid,not do this msg");
            return;
        }
        d dVar = new d(j4, str, i4, i5, c4, 0L, bArr);
        if (h.a().d()) {
            h.a().c().d().a(a(context, dVar));
        } else {
            cn.jiguang.bq.d.k("TcpRequestManager", !cn.jiguang.f.a.e(context) ? "send error -tcp connect was invalid" : "current use not login success,wait a moment");
        }
        this.f3148c.put(Long.valueOf(c4), dVar);
    }

    public void a(Context context, long j4, int i4, int i5, byte[] bArr, String str, long j5) {
        long j6;
        if (i4 == 10) {
            j6 = j4;
        } else {
            long c4 = cn.jiguang.bv.c.c(context);
            cn.jiguang.bq.d.c("TcpRequestManager", "Generator new rid:" + c4);
            if (this.f3148c.containsKey(Long.valueOf(c4))) {
                cn.jiguang.bq.d.j("TcpRequestManager", "Generator same rid,not do this msg");
                return;
            }
            j6 = c4;
        }
        long j7 = j5 <= 0 ? 10000L : j5;
        d dVar = new d(j4, str, i4, i5, j6, j7, bArr);
        if (h.a().d()) {
            h.a().c().d().a(a(context, dVar));
        } else {
            cn.jiguang.bq.d.k("TcpRequestManager", !cn.jiguang.f.a.e(context) ? "send error -tcp connect was invalid" : "current use not login success,wait a moment");
        }
        dVar.f3090h = System.nanoTime();
        this.f3148c.put(Long.valueOf(j6), dVar);
        cn.jiguang.cb.b.a().b((int) (j6 + 100000), j7, this.f3149d);
    }

    public void b(Context context, long j4) {
        d remove = this.f3148c.remove(Long.valueOf(j4));
        if (remove == null) {
            cn.jiguang.bq.d.i("TcpRequestManager", "not found requst by rid:" + j4);
            return;
        }
        cn.jiguang.bq.d.c("TcpRequestManager", "request time out:" + remove);
        b.a().a(context, remove.f3085c, remove.f3084b, remove.f3086d);
    }
}

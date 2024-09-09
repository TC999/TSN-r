package cn.jiguang.q;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import cn.jiguang.ah.d;
import cn.jiguang.q.c;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    Context f3769a;

    /* renamed from: b  reason: collision with root package name */
    String f3770b = d.f("7vqR3nNqKoDAlUrx74tE1g==");

    /* renamed from: c  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f3771c = new LinkedBlockingQueue<>(1);

    /* renamed from: d  reason: collision with root package name */
    ServiceConnection f3772d = new ServiceConnection() { // from class: cn.jiguang.q.b.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                b.this.f3771c.put(iBinder);
            } catch (Throwable th) {
                cn.jiguang.w.a.f("MsaOpenIDHelper", "linkedBlockingQueue error: " + th.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public b(Context context) {
        this.f3769a = context;
    }

    private void a(String str) {
        Intent intent = new Intent();
        intent.setClassName(this.f3770b, d.f("dYE0CPNDFJTaYbJHvdYTELPkLL9xmlHysh4O1rCwUiLYHLJ6VxirNHcrSo3Xn2UJ"));
        intent.setAction(d.f("AdKS/+o+CvOMDbvCnPWRYS8wCU0Ooy6tyMT0tXjLMUvWRKeDq6D985Ar35mAOPu+"));
        intent.putExtra(d.f("iCmt493CpcicRY98bz8pUhEUlhy7cl4p/yoqnN2nlNM="), str);
        try {
            intent.putExtra(d.f("iCmt493CpcicRY98bz8pUjI+wbDT5u8oLPJxFa2B2Zg="), true);
            this.f3769a.startService(intent);
        } catch (Throwable th) {
            cn.jiguang.w.a.f("MsaOpenIDHelper", "startMsaklServer error: " + th.getMessage());
        }
    }

    public String a() {
        try {
            String packageName = this.f3769a.getPackageName();
            a(packageName);
            Intent intent = new Intent();
            intent.setClassName(this.f3770b, d.f("dYE0CPNDFJTaYbJHvdYTEBK/MhYfAvKlbba3ZFsuZ+on9OG47ABUmhfzcQhqhJOU"));
            intent.setAction(d.f("AdKS/+o+CvOMDbvCnPWRYUnA2ZKRLZpCerAAd95VliYNvOuVTnj4/o7GUNhJXhWl"));
            intent.putExtra(d.f("iCmt493CpcicRY98bz8pUhEUlhy7cl4p/yoqnN2nlNM="), packageName);
            if (this.f3769a.bindService(intent, this.f3772d, 1)) {
                c.a.C0064a c0064a = new c.a.C0064a(this.f3771c.take());
                String a4 = c0064a.a();
                c0064a.b();
                this.f3769a.unbindService(this.f3772d);
                this.f3769a.unbindService(this.f3772d);
                return a4;
            }
            return "";
        } catch (Throwable th) {
            cn.jiguang.w.a.f("MsaOpenIDHelper", "get o failed: " + th.getMessage());
            return "";
        }
    }
}

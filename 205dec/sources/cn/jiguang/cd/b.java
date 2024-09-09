package cn.jiguang.cd;

import android.content.Context;
import cn.jiguang.cd.a;
import com.bykv.vk.component.ttvideo.ILivePlayer;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static a f3279a;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f3280b = new Object();

    public static void a(Context context) {
        synchronized (f3280b) {
            a aVar = new a(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, false, new a.InterfaceC0059a() { // from class: cn.jiguang.cd.b.1
                @Override // cn.jiguang.cd.a.InterfaceC0059a
                public void a(cn.jiguang.ce.a aVar2) {
                    b.b(aVar2);
                }
            }, context);
            f3279a = aVar;
            aVar.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(cn.jiguang.ce.a aVar) {
        cn.jiguang.ce.b bVar = new cn.jiguang.ce.b();
        bVar.a("ANR");
        h.a().a(new c(bVar, aVar, aVar.a(), true));
    }
}

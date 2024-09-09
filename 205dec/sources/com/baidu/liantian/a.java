package com.baidu.liantian;

import android.content.Context;
import android.content.Intent;
import com.baidu.liantian.ac.Callback;
import com.baidu.liantian.core.g;
import com.stub.StubApp;
import java.util.HashMap;

/* compiled from: AwakeReceiver.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a {
    public static void a(Context context, Intent intent) {
        try {
            String[] g4 = com.baidu.liantian.b.e.g(context);
            String str = g4[0];
            String str2 = g4[1];
            b.a();
            com.baidu.liantian.core.e.a(context, 0, true);
            int i4 = 0;
            while (true) {
                Thread.sleep(500L);
                i4++;
                b.a();
                if (i4 > 60) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("0", "152");
                    hashMap.put("1", g4[0]);
                    com.baidu.liantian.b.e.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), "1014115", hashMap);
                    hashMap.toString();
                    b.a();
                    break;
                }
                g a4 = g.a();
                if (a4 == null) {
                    b.a();
                } else if (a4.d("com.baidu.liantian.x24") != null) {
                    break;
                }
            }
            b.a();
            com.baidu.liantian.core.e.a(100028, "onReceiveAwakeMessage", new Callback() { // from class: com.baidu.liantian.a.1
                @Override // com.baidu.liantian.ac.Callback
                public final Object onEnd(Object... objArr) {
                    return super.onEnd(objArr);
                }
            }, new Class[]{Context.class, Intent.class}, context, intent);
        } catch (Throwable unused) {
            b.a();
            com.baidu.liantian.b.e.a();
        }
    }
}

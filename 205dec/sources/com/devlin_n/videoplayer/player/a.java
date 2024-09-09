package com.devlin_n.videoplayer.player;

import android.content.Context;
import c1.e;
import com.danikula.videocache.file.f;
import com.danikula.videocache.i;
import com.stub.StubApp;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: VideoCacheManager.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static i f36975a;

    private a() {
    }

    public static boolean a(Context context) {
        return e.b(e.e(context));
    }

    public static boolean b(Context context, String str) {
        String generate = new f().generate(str);
        StringBuilder sb = new StringBuilder();
        sb.append(e.e(StubApp.getOrigApplicationContext(context.getApplicationContext())).getAbsolutePath());
        String str2 = File.separator;
        sb.append(str2);
        sb.append(generate);
        sb.append(".download");
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(e.e(StubApp.getOrigApplicationContext(context.getApplicationContext())).getAbsolutePath());
        sb3.append(str2);
        sb3.append(generate);
        return e.a(sb2) && e.a(sb3.toString());
    }

    public static i c(Context context) {
        i iVar = f36975a;
        if (iVar == null) {
            i d4 = d(context);
            f36975a = d4;
            return d4;
        }
        return iVar;
    }

    private static i d(Context context) {
        return new i.b(context).h(1073741824L).b();
    }
}

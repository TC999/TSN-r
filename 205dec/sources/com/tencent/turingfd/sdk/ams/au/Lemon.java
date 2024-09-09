package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.util.HashMap;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Lemon {

    /* renamed from: a  reason: collision with root package name */
    public static final String f52108a = Cextends.a(Cextends.A0);

    /* renamed from: b  reason: collision with root package name */
    public static final String f52109b = Cextends.a(Cextends.B0);

    /* renamed from: c  reason: collision with root package name */
    public static boolean f52110c = false;

    public static void a(Context context, Ginkgo ginkgo) {
        try {
            if (f52110c) {
                return;
            }
            f52110c = true;
            long a4 = ginkgo.a(context, "502");
            int myUid = Process.myUid();
            if (a4 == 0 || myUid == 0 || myUid == a4) {
                return;
            }
            ginkgo.a(context, "101", "", true);
            ginkgo.b(context, 0L);
            HashMap hashMap = new HashMap();
            hashMap.put("901", "");
            Ginkgo.a(context, hashMap);
            new File(a(context)).delete();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String a(Context context) {
        File dir = context.getDir(f52108a, 0);
        if (dir == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dir.getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append("1");
        File file = new File(sb.toString());
        if (file.exists() || file.mkdirs()) {
            return file.getAbsolutePath() + str + f52109b;
        }
        return "";
    }
}

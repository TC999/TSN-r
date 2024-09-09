package cn.jiguang.cj;

import android.os.Looper;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class a {
    private static boolean a(long j4) {
        return Looper.getMainLooper().getThread().getId() == j4;
    }

    public static boolean a(Thread thread) {
        return a(thread.getId());
    }
}

package cn.jpush.android.x;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static Queue<Integer> f4547a = new ConcurrentLinkedQueue();

    public static int a() {
        if (f4547a.size() > 0) {
            return f4547a.poll().intValue();
        }
        return 0;
    }

    public static boolean a(int i4) {
        return f4547a.offer(Integer.valueOf(i4));
    }

    public static int b() {
        return f4547a.size();
    }

    public static boolean b(int i4) {
        return f4547a.contains(Integer.valueOf(i4));
    }
}

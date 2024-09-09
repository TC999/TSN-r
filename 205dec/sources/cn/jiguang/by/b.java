package cn.jiguang.by;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.bq.d;
import cn.jiguang.f.g;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f3156a;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f3157b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private long f3158c = 36000000;

    /* renamed from: d  reason: collision with root package name */
    private long f3159d = 900000;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, Pair<InetAddress[], Long>> f3160e = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class a implements Callable<InetAddress[]> {

        /* renamed from: a  reason: collision with root package name */
        private Context f3161a;

        /* renamed from: b  reason: collision with root package name */
        private String f3162b;

        /* renamed from: c  reason: collision with root package name */
        private b f3163c;

        a(Context context, String str, b bVar) {
            this.f3161a = context;
            this.f3162b = str;
            this.f3163c = bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x006a  */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.net.InetAddress[] call() {
            /*
                Method dump skipped, instructions count: 254
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.by.b.a.call():java.net.InetAddress[]");
        }
    }

    private b() {
    }

    private Pair<InetAddress[], Boolean> a(Context context, String str, long j4, long j5) {
        InetAddress[] inetAddressArr;
        Pair<InetAddress[], Long> pair = this.f3160e.get(str);
        boolean z3 = pair == null || pair.first == null;
        long longValue = ((Long) (z3 ? cn.jiguang.g.b.a(context, cn.jiguang.g.a.c(str)) : pair.second)).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis > longValue + j4) {
            return null;
        }
        if (z3) {
            inetAddressArr = a(context, str);
            if (inetAddressArr != null) {
                this.f3160e.put(str, new Pair<>(inetAddressArr, Long.valueOf(longValue)));
            }
        } else {
            inetAddressArr = (InetAddress[]) pair.first;
        }
        if (inetAddressArr != null) {
            return new Pair<>(inetAddressArr, Boolean.valueOf(currentTimeMillis > longValue + j5));
        }
        return null;
    }

    public static b a() {
        if (f3156a == null) {
            synchronized (f3157b) {
                if (f3156a == null) {
                    f3156a = new b();
                }
            }
        }
        return f3156a;
    }

    private InetAddress a(String str) {
        if (g.f(str) || g.g(str)) {
            try {
                return InetAddress.getByName(str);
            } catch (UnknownHostException e4) {
                d.i("DNSLoader", "dns resolve failed:" + e4);
            }
        }
        return null;
    }

    private InetAddress[] a(Context context, String str) {
        String str2 = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.b(str));
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String[] split = str2.split(",");
        LinkedList linkedList = new LinkedList();
        for (String str3 : split) {
            InetAddress a4 = a(str3);
            if (a4 != null) {
                linkedList.add(a4);
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        return (InetAddress[]) linkedList.toArray(new InetAddress[0]);
    }

    public InetAddress a(Context context, String str, long j4, boolean z3) {
        InetAddress[] b4 = b(context, str, j4, z3);
        if (b4 == null || b4.length <= 0) {
            return null;
        }
        return b4[0];
    }

    public InetAddress[] b(Context context, String str, long j4, boolean z3) {
        InetAddress[] inetAddressArr;
        StringBuilder sb;
        String arrays;
        InetAddress[] inetAddressArr2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        InetAddress a4 = a(str);
        if (a4 != null) {
            return new InetAddress[]{a4};
        }
        Pair<InetAddress[], Boolean> a5 = a(context, str, this.f3158c, this.f3159d);
        if (a5 != null) {
            Object obj = a5.first;
            inetAddressArr = obj != null ? (InetAddress[]) obj : null;
            if (!((Boolean) a5.second).booleanValue()) {
                if (z3) {
                    cn.jiguang.bt.b.c(new FutureTask(new a(context, str, this)), new int[0]);
                }
                sb = new StringBuilder();
                sb.append("use cache=");
                arrays = Arrays.toString(inetAddressArr);
                sb.append(arrays);
                d.c("DNSLoader", sb.toString());
                return inetAddressArr;
            }
        } else {
            inetAddressArr = null;
        }
        FutureTask futureTask = new FutureTask(new a(context, str, this));
        cn.jiguang.bt.b.c(futureTask, new int[0]);
        if (j4 == 0) {
            sb = new StringBuilder();
        } else {
            try {
                d.c("DNSLoader", "waiting dns for " + str);
                inetAddressArr2 = (InetAddress[]) futureTask.get(j4, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                d.i("DNSLoader", "run futureTask e:" + th);
            }
            if (inetAddressArr2 != null) {
                d.c("DNSLoader", "use resolved result=" + Arrays.toString(inetAddressArr2));
                return inetAddressArr2;
            }
            sb = new StringBuilder();
        }
        sb.append("use cache=");
        arrays = Arrays.toString(inetAddressArr);
        sb.append(arrays);
        d.c("DNSLoader", sb.toString());
        return inetAddressArr;
    }
}

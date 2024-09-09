package cn.jiguang.bw;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static volatile l f3064a;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f3065b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private long f3066c = 86400000;

    /* renamed from: d  reason: collision with root package name */
    private long f3067d = 1800000;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, Pair<LinkedHashSet<cn.jiguang.bv.g>, Long>> f3068e = new HashMap();

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    static class a implements Callable<LinkedHashSet<cn.jiguang.bv.g>> {

        /* renamed from: a  reason: collision with root package name */
        private String f3069a;

        /* renamed from: b  reason: collision with root package name */
        private l f3070b;

        a(String str, l lVar) {
            this.f3069a = str;
            this.f3070b = lVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public LinkedHashSet<cn.jiguang.bv.g> call() {
            LinkedHashSet<cn.jiguang.bv.g> a4 = l.a(this.f3069a);
            if (a4 != null && a4.size() > 0) {
                this.f3070b.a(this.f3069a, new Pair(a4, Long.valueOf(System.currentTimeMillis())));
            }
            return a4;
        }
    }

    private l() {
    }

    private Pair<LinkedHashSet<cn.jiguang.bv.g>, Boolean> a(String str, long j4, long j5) {
        Object obj;
        Pair<LinkedHashSet<cn.jiguang.bv.g>, Long> pair = this.f3068e.get(str);
        boolean z3 = pair == null || (obj = pair.first) == null || ((LinkedHashSet) obj).size() == 0;
        long longValue = ((Long) (z3 ? cn.jiguang.g.b.a((Context) null, cn.jiguang.g.a.e(str)) : pair.second)).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis > longValue + j4) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (z3) {
            String str2 = (String) cn.jiguang.g.b.a((Context) null, cn.jiguang.g.a.d(str));
            if (!TextUtils.isEmpty(str2)) {
                for (String str3 : str2.split(",")) {
                    cn.jiguang.bv.g a4 = cn.jiguang.bv.g.a(str3);
                    if (a4 != null && a4.a()) {
                        linkedHashSet.add(a4);
                    }
                }
                this.f3068e.put(str, new Pair<>(linkedHashSet, Long.valueOf(System.currentTimeMillis())));
            }
        } else {
            linkedHashSet = (LinkedHashSet) pair.first;
        }
        if (linkedHashSet.isEmpty()) {
            return null;
        }
        return new Pair<>(linkedHashSet, Boolean.valueOf(currentTimeMillis > longValue + j5));
    }

    public static l a() {
        if (f3064a == null) {
            synchronized (f3065b) {
                if (f3064a == null) {
                    f3064a = new l();
                }
            }
        }
        return f3064a;
    }

    public static LinkedHashSet<cn.jiguang.bv.g> a(String str) {
        String[] a4;
        e eVar;
        i a5;
        h[] b4;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] b5 = b(str);
            cn.jiguang.bq.d.c("SRVLoader", "srv host:" + str);
            String a6 = cn.jiguang.cf.c.a().a(str);
            LinkedHashSet<cn.jiguang.bv.g> linkedHashSet = new LinkedHashSet<>();
            try {
                a4 = k.b().a();
            } catch (Throwable th) {
                cn.jiguang.bq.d.j("SRVLoader", "Get default ports error with Exception:" + th);
                cn.jiguang.cf.c.a().a(a6, 2);
            }
            if (a4 != null && a4.length != 0) {
                LinkedHashSet<InetAddress> linkedHashSet2 = new LinkedHashSet();
                cn.jiguang.by.b a7 = cn.jiguang.by.b.a();
                int length = a4.length;
                int i4 = 0;
                while (i4 < length) {
                    int i5 = i4;
                    InetAddress a8 = a7.a((Context) null, a4[i4], 3000L, false);
                    if (a8 != null) {
                        linkedHashSet2.add(a8);
                    }
                    i4 = i5 + 1;
                }
                for (InetAddress inetAddress : linkedHashSet2) {
                    try {
                        eVar = new e(o.a(null, new InetSocketAddress(inetAddress, 53), b5, System.currentTimeMillis() + 1000));
                        a5 = eVar.a();
                    } catch (IOException e4) {
                        cn.jiguang.bq.d.i("SRVLoader", "tcp send to  err:" + e4);
                    }
                    if (a5 == null) {
                        break;
                    }
                    for (h hVar : eVar.b(1)) {
                        if (hVar.d() == a5.g() && hVar.c() == a5.e() && hVar.b().equals(a5.d())) {
                            Iterator a9 = hVar.a();
                            while (a9.hasNext()) {
                                m mVar = (m) a9.next();
                                if (mVar.j() > 0) {
                                    String gVar = mVar.k().toString();
                                    if (!TextUtils.isEmpty(gVar)) {
                                        if (gVar.endsWith(".")) {
                                            gVar = gVar.substring(0, gVar.length() - 1);
                                        }
                                        cn.jiguang.bv.g gVar2 = new cn.jiguang.bv.g(gVar, mVar.j());
                                        if (gVar2.a()) {
                                            linkedHashSet.add(gVar2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                cn.jiguang.cf.c.a().a(a6, 0);
                return linkedHashSet;
            }
            return linkedHashSet;
        } catch (IOException e5) {
            cn.jiguang.bq.d.i("SRVLoader", "can't srv, create query:" + e5);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(String str, Pair<LinkedHashSet<cn.jiguang.bv.g>, Long> pair) {
        Object obj = pair.first;
        if (obj == null || ((LinkedHashSet) obj).size() <= 0 || pair.second == null) {
            return;
        }
        this.f3068e.put(str, pair);
        StringBuilder sb = new StringBuilder();
        Iterator it = ((LinkedHashSet) pair.first).iterator();
        while (it.hasNext()) {
            sb.append(((cn.jiguang.bv.g) it.next()).toString());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        cn.jiguang.g.b.a((Context) null, cn.jiguang.g.a.d(str).a((cn.jiguang.g.a<String>) sb.toString()), cn.jiguang.g.a.e(str).a((cn.jiguang.g.a<Long>) pair.second));
    }

    private static byte[] b(String str) {
        return e.a(i.a(g.a(g.a(str), g.f3042a), 33, 1)).c(65535);
    }

    public LinkedHashSet<cn.jiguang.bv.g> a(String str, long j4) {
        LinkedHashSet<cn.jiguang.bv.g> linkedHashSet;
        StringBuilder sb;
        LinkedHashSet<cn.jiguang.bv.g> linkedHashSet2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Pair<LinkedHashSet<cn.jiguang.bv.g>, Boolean> a4 = a(str, this.f3066c, this.f3067d);
        if (a4 != null) {
            Object obj = a4.first;
            linkedHashSet = (obj == null || ((LinkedHashSet) obj).size() <= 0) ? null : (LinkedHashSet) a4.first;
            if (!((Boolean) a4.second).booleanValue()) {
                return linkedHashSet;
            }
        } else {
            linkedHashSet = null;
        }
        FutureTask futureTask = new FutureTask(new a(str, this));
        cn.jiguang.bt.b.c(futureTask, new int[0]);
        if (j4 == 0) {
            sb = new StringBuilder();
        } else {
            try {
                linkedHashSet2 = (LinkedHashSet) futureTask.get(j4, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                cn.jiguang.bq.d.i("SRVLoader", "run futureTask e:" + th);
            }
            if (linkedHashSet2 != null && linkedHashSet2.size() > 0) {
                cn.jiguang.bq.d.c("SRVLoader", "use resolved result=" + linkedHashSet2);
                return linkedHashSet2;
            }
            sb = new StringBuilder();
        }
        sb.append("use cache=");
        sb.append(linkedHashSet);
        cn.jiguang.bq.d.c("SRVLoader", sb.toString());
        return linkedHashSet;
    }
}

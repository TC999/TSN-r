package cn.jiguang.bx;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.api.ReportCallBack;
import cn.jiguang.internal.JConstants;
import java.io.Closeable;
import java.io.File;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static i f3123a;

    /* renamed from: e  reason: collision with root package name */
    private static int f3124e;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f3125b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    private final Map<cn.jiguang.bv.g, Pair<Integer, cn.jiguang.ca.a>> f3126c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<cn.jiguang.bv.g, ConcurrentHashMap<Integer, b>> f3127d = new ConcurrentHashMap();

    /* renamed from: f  reason: collision with root package name */
    private Map<cn.jiguang.bv.g, Long> f3128f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private Map<String, Set<cn.jiguang.bv.g>> f3129g = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class a extends cn.jiguang.cb.a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Context f3130a;

        /* renamed from: d  reason: collision with root package name */
        private int f3131d;

        /* renamed from: e  reason: collision with root package name */
        private final Object f3132e;

        /* renamed from: f  reason: collision with root package name */
        private int f3133f;

        a(Context context, int i4, Object obj) {
            this.f3130a = context;
            this.f3131d = i4;
            this.f3132e = obj;
        }

        a(Context context, Object obj) {
            this.f3130a = context;
            this.f3132e = obj;
        }

        @Override // cn.jiguang.cb.a
        public void a(Message message) {
            int i4 = message.what;
            if (i4 >= 60000) {
                if (this.f3132e instanceof cn.jiguang.bv.g) {
                    cn.jiguang.bq.d.c("TcpReporter", "time to idle=" + this.f3132e);
                    i.a().a(this.f3130a, (cn.jiguang.bv.g) this.f3132e, 0);
                }
            } else if (i4 >= 50000) {
                Object obj = this.f3132e;
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    cn.jiguang.bq.d.c("TcpReporter", "onTimeout=" + bVar);
                    i.a().a(bVar.f3140g, bVar.f3139f);
                    i.a().a(this.f3130a, bVar);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                int i4 = this.f3131d;
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 == 3) {
                            Object obj = this.f3132e;
                            if (obj instanceof b) {
                                b bVar = (b) obj;
                                cn.jiguang.bq.d.c("TcpReporter", "onResult, data=" + bVar + " code=" + this.f3133f);
                                JCoreManager.onEvent(this.f3130a, JConstants.SDK_TYPE, 61, "", null, Integer.valueOf(this.f3133f), bVar.f3135b, bVar.f3136c, Integer.valueOf(bVar.f3134a), bVar.f3137d, bVar.f3138e, bVar.f3143j, bVar.f3144k);
                            }
                        }
                    } else if (this.f3132e instanceof cn.jiguang.bv.g) {
                        i.a().b(this.f3130a, (cn.jiguang.bv.g) this.f3132e);
                    }
                } else if (this.f3132e instanceof cn.jiguang.bv.g) {
                    i.a().a(this.f3130a, (cn.jiguang.bv.g) this.f3132e);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        int f3134a;

        /* renamed from: b  reason: collision with root package name */
        JSONObject f3135b;

        /* renamed from: c  reason: collision with root package name */
        byte[] f3136c;

        /* renamed from: d  reason: collision with root package name */
        File f3137d;

        /* renamed from: e  reason: collision with root package name */
        Set<String> f3138e;

        /* renamed from: f  reason: collision with root package name */
        int f3139f = -1;

        /* renamed from: g  reason: collision with root package name */
        cn.jiguang.bv.g f3140g;

        /* renamed from: h  reason: collision with root package name */
        LinkedHashSet<cn.jiguang.bv.g> f3141h;

        /* renamed from: i  reason: collision with root package name */
        boolean f3142i;

        /* renamed from: j  reason: collision with root package name */
        transient ReportCallBack f3143j;

        /* renamed from: k  reason: collision with root package name */
        transient String f3144k;

        public String toString() {
            return "TcpReportData{types=" + this.f3138e + ", seqId=" + this.f3139f + ", ipPort=" + this.f3140g + ", restUrls=" + this.f3141h + '}';
        }
    }

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b a(cn.jiguang.bv.g gVar, int i4) {
        ConcurrentHashMap<Integer, b> concurrentHashMap;
        if (gVar == null || (concurrentHashMap = this.f3127d.get(gVar)) == null) {
            return null;
        }
        b bVar = concurrentHashMap.get(Integer.valueOf(i4));
        concurrentHashMap.remove(Integer.valueOf(i4));
        return bVar;
    }

    public static i a() {
        if (f3123a == null) {
            synchronized (i.class) {
                if (f3123a == null) {
                    f3123a = new i();
                }
            }
        }
        return f3123a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x00dc, code lost:
        if (r10 != false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00e4, code lost:
        if (r10 != false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:?, code lost:
        return "ssl";
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:?, code lost:
        return "normal";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(java.lang.String r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bx.i.a(java.lang.String, boolean):java.lang.String");
    }

    private void a(Context context, int i4, cn.jiguang.ca.a aVar, cn.jiguang.bv.g gVar, b bVar) {
        byte[] a4 = a(context, bVar.f3136c, bVar.f3134a, bVar.f3139f);
        if (a4 == null || a4.length == 0) {
            cn.jiguang.bq.d.c("TcpReporter", "package data failed, give up, data=" + bVar);
            a(context, bVar, -1);
            return;
        }
        bVar.f3142i = true;
        int a5 = aVar.a(a4);
        StringBuilder sb = new StringBuilder();
        sb.append("send tcp data, len=");
        sb.append(a4.length);
        sb.append(", data=");
        sb.append(bVar);
        sb.append(", use ssl: ");
        sb.append(aVar instanceof cn.jiguang.ca.b);
        sb.append(", send ");
        sb.append(a5 == 0 ? "succeed" : "failed");
        cn.jiguang.bq.d.c("TcpReporter", sb.toString());
        cn.jiguang.cf.b a6 = cn.jiguang.cf.b.a();
        a6.b(aVar.f3213h + ":" + aVar.f3214i, bVar.f3138e.toString(), a4.length);
        cn.jiguang.cb.b.a().b(i4 + 60000, 31000L, new a(context, gVar));
        cn.jiguang.cb.b.a().b(bVar.f3139f + 50000, 15000L, new a(context, bVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, cn.jiguang.bv.g gVar) {
        cn.jiguang.ca.a aVar;
        if (gVar == null) {
            return;
        }
        try {
            Pair<Integer, cn.jiguang.ca.a> pair = this.f3126c.get(gVar);
            if (pair != null && (aVar = (cn.jiguang.ca.a) pair.second) != null && !aVar.b()) {
                String d4 = cn.jiguang.cf.c.a().d(gVar.f2943a, gVar.f2944b, aVar.f3212g);
                int a4 = aVar.a(gVar.f2943a, gVar.f2944b);
                cn.jiguang.bq.d.c("TcpReporter", "start tcp report socket(" + pair.first + "):" + gVar + ", code: " + a4);
                if (a4 != 0) {
                    a(context, gVar, 0);
                    cn.jiguang.cf.c.a().g(d4, a4);
                } else {
                    cn.jiguang.bt.b.b(new a(context, 2, gVar), new int[0]);
                    cn.jiguang.cf.c.a().g(d4, 0);
                    a aVar2 = new a(context, gVar);
                    while (!this.f3125b.get()) {
                        try {
                            a(context, aVar.a(), gVar);
                            cn.jiguang.cb.b.a().b(((Integer) pair.first).intValue() + 60000, 31000L, aVar2);
                        } catch (f e4) {
                            if (e4.f3093a != -997) {
                                cn.jiguang.bq.d.i("TcpReporter", "recv failed with error:" + e4);
                            }
                        }
                    }
                }
                a(context, gVar, 0);
                cn.jiguang.bq.d.i("TcpReporter", this.f3125b.get() ? "Break receiving by wantStop" : "disconnected");
            }
        } catch (Throwable th) {
            cn.jiguang.bq.d.b("TcpReporter", "socket exception", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, cn.jiguang.bv.g gVar, int i4) {
        int i5;
        StringBuilder sb;
        Pair<Integer, cn.jiguang.ca.a> remove = this.f3126c.remove(gVar);
        if (remove != null) {
            i5 = ((Integer) remove.first).intValue();
            cn.jiguang.f.i.a((Closeable) remove.second);
            cn.jiguang.bq.d.c("TcpReporter", "closeSocket final");
        } else {
            i5 = 0;
        }
        ConcurrentHashMap<Integer, b> remove2 = this.f3127d.remove(gVar);
        if (i4 == 0 && !cn.jiguang.f.a.e(context)) {
            i4 = -2;
        }
        if (remove2 == null || remove2.size() <= 0) {
            if (i5 > 0) {
                cn.jiguang.bq.d.c("TcpReporter", "socket(" + i5 + ") at " + gVar + " is disconnected, no task left");
                return;
            }
            return;
        }
        if (i4 == 0) {
            sb = new StringBuilder();
            sb.append("socket(");
            sb.append(i5);
            sb.append(") at ");
            sb.append(gVar);
            sb.append(" is disconnected, go on send waiting request");
        } else {
            sb = new StringBuilder();
            sb.append("socket(");
            sb.append(i5);
            sb.append(") at ");
            sb.append(gVar);
            sb.append(" is disconnected, finish waiting request, code=");
            sb.append(i4);
        }
        cn.jiguang.bq.d.c("TcpReporter", sb.toString());
        for (b bVar : remove2.values()) {
            if (bVar != null) {
                cn.jiguang.cb.b.a().b(bVar.f3139f + 50000);
                if (i4 == 0) {
                    a(context, bVar);
                } else {
                    a aVar = new a(context, 3, bVar);
                    aVar.f3133f = i4;
                    cn.jiguang.bt.b.b(aVar, new int[0]);
                }
            }
        }
    }

    private synchronized void a(Context context, cn.jiguang.bv.g gVar, b bVar) {
        String str;
        Pair<Integer, cn.jiguang.ca.a> pair = this.f3126c.get(gVar);
        cn.jiguang.ca.a aVar = pair != null ? (cn.jiguang.ca.a) pair.second : null;
        boolean a4 = a(context, bVar.f3138e);
        if (aVar == null) {
            this.f3126c.put(gVar, new Pair<>(Integer.valueOf(b()), a4 ? new cn.jiguang.ca.b(30720, 19) : new cn.jiguang.ca.c(30720, 19)));
            a aVar2 = new a(context, 1, gVar);
            if (!a4 && cn.jiguang.bv.c.d(context)) {
                str = "FUTURE_TASK";
                cn.jiguang.cm.d.a(str, aVar2);
            }
            str = "ONCE_TASK";
            cn.jiguang.cm.d.a(str, aVar2);
        } else if (aVar.b()) {
            a(context, ((Integer) pair.first).intValue(), aVar, gVar, bVar);
        }
    }

    private void a(Context context, b bVar, int i4) {
        ConcurrentHashMap<Integer, b> concurrentHashMap;
        cn.jiguang.bv.g gVar = bVar.f3140g;
        if (gVar != null && (concurrentHashMap = this.f3127d.get(gVar)) != null) {
            concurrentHashMap.remove(Integer.valueOf(bVar.f3139f));
        }
        cn.jiguang.cb.b.a().b(bVar.f3139f + 50000);
        a aVar = new a(context, 3, bVar);
        aVar.f3133f = i4;
        cn.jiguang.bt.b.b(aVar, new int[0]);
    }

    private void a(Context context, ByteBuffer byteBuffer, cn.jiguang.bv.g gVar) {
        if (byteBuffer != null) {
            try {
                if (byteBuffer.array() != null) {
                    cn.jiguang.bq.d.c("TcpReporter", "Received bytes - len:" + byteBuffer.array().length + ", ipPort: " + gVar);
                    if (byteBuffer.array().length != 19) {
                        b(context, gVar, 1);
                        a(context, gVar, -1);
                        cn.jiguang.cf.b.a().c(gVar.toString(), "unknown_receive", byteBuffer.array().length);
                        return;
                    }
                    byte b4 = byteBuffer.get(2);
                    if (b4 != 1 && b4 != 0) {
                        cn.jiguang.bq.d.i("TcpReporter", "wrong version " + ((int) b4));
                        b(context, gVar, 2);
                        a(context, gVar, -1);
                        cn.jiguang.cf.b.a().c(gVar.toString(), "unknown_receive", (long) byteBuffer.array().length);
                        return;
                    }
                    short s3 = byteBuffer.getShort(15);
                    short s4 = byteBuffer.getShort(17);
                    cn.jiguang.bq.d.c("TcpReporter", "onResult seqId=" + ((int) s3) + " code=" + ((int) s4));
                    cn.jiguang.cb.b.a().b(50000 + s3);
                    b a4 = a(gVar, s3);
                    if (a4 != null) {
                        if (s4 == 0) {
                            cn.jiguang.cf.b.a().c(gVar.toString(), a4.f3138e.toString(), byteBuffer.array().length);
                            a aVar = new a(context, 3, a4);
                            aVar.f3133f = s4;
                            cn.jiguang.bt.b.b(aVar, new int[0]);
                            return;
                        } else if (s4 == 401) {
                            a(context, gVar, s4);
                            return;
                        } else {
                            a(context, a4);
                            return;
                        }
                    }
                    return;
                }
            } catch (Throwable th) {
                cn.jiguang.bq.d.i("TcpReporter", "tcp reporter onReceive err:" + th);
                return;
            }
        }
        cn.jiguang.bq.d.i("TcpReporter", "onReceive buffer is null");
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            try {
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONArray optJSONArray = jSONObject.optJSONArray(next);
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    if (optJSONArray != null) {
                        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                            cn.jiguang.bv.g a4 = cn.jiguang.bv.g.a(optJSONArray.getString(i4));
                            if (a4 != null && a4.a()) {
                                linkedHashSet.add(a4);
                            }
                        }
                    }
                    hashMap.put(next, linkedHashSet);
                }
                if (hashMap.isEmpty()) {
                    return;
                }
                this.f3129g = hashMap;
            } catch (JSONException unused) {
            }
        }
    }

    private boolean a(Context context, Set<String> set) {
        return cn.jiguang.bv.c.d(context) && !(set != null && set.contains("sdk_jid") && set.size() == 1);
    }

    private static byte[] a(Context context, long j4, byte[] bArr) {
        String str = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.A());
        if (TextUtils.isEmpty(str)) {
            str = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.B());
        }
        String e4 = cn.jiguang.f.g.e(str);
        String b4 = cn.jiguang.f.g.b(bArr);
        byte[] c4 = cn.jiguang.f.g.c(j4 + e4 + b4);
        if (c4 == null) {
            return new byte[16];
        }
        if (c4.length == 16) {
            return c4;
        }
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 0, bArr2, 0, Math.min(c4.length, 16));
        return bArr2;
    }

    private byte[] a(Context context, byte[] bArr, int i4, int i5) {
        if (bArr == null || bArr.length == 0 || bArr.length > 30683) {
            return null;
        }
        cn.jiguang.cc.b bVar = new cn.jiguang.cc.b(bArr.length + 37);
        bVar.b(0);
        bVar.a(1);
        bVar.a(cn.jiguang.bx.b.a().b());
        long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.x())).longValue();
        bVar.b(longValue);
        bVar.a(a(context, longValue, bArr));
        bVar.a(i4);
        bVar.b(i5);
        bVar.a(bArr);
        bVar.b(bVar.a(), 0);
        return bVar.b();
    }

    private static synchronized int b() {
        int i4;
        synchronized (i.class) {
            i4 = (f3124e + 1) % 10000;
            f3124e = i4;
        }
        return i4;
    }

    public static synchronized int b(Context context) {
        int intValue;
        synchronized (i.class) {
            Integer num = (Integer) cn.jiguang.g.b.b(context, cn.jiguang.g.a.aj());
            if (num == null) {
                num = Integer.valueOf(Math.abs(new SecureRandom().nextInt(10000)));
            }
            Integer valueOf = Integer.valueOf((num.intValue() + 1) % 10000);
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.aj().a((cn.jiguang.g.a<Integer>) valueOf));
            intValue = valueOf.intValue();
        }
        return intValue;
    }

    private LinkedHashSet<cn.jiguang.bv.g> b(Context context, Set<String> set) {
        LinkedHashSet<cn.jiguang.bv.g> linkedHashSet = new LinkedHashSet<>();
        cn.jiguang.bv.g a4 = cn.jiguang.bv.g.a(cn.jiguang.bu.a.d());
        if (a4 == null || !a4.a()) {
            Set<cn.jiguang.bv.g> c4 = c(context, set);
            if (c4 != null) {
                for (cn.jiguang.bv.g gVar : c4) {
                    if (gVar != null && gVar.a()) {
                        linkedHashSet.add(gVar);
                    }
                }
            }
        } else {
            linkedHashSet.add(a4);
        }
        cn.jiguang.bq.d.c("TcpReporter", "tcp report find urls=" + linkedHashSet);
        try {
            Iterator<Map.Entry<cn.jiguang.bv.g, Long>> it = this.f3128f.entrySet().iterator();
            while (it.hasNext()) {
                if (System.currentTimeMillis() - it.next().getValue().longValue() > 600000) {
                    it.remove();
                }
            }
            for (cn.jiguang.bv.g gVar2 : this.f3128f.keySet()) {
                linkedHashSet.remove(gVar2);
            }
        } catch (Throwable th) {
            cn.jiguang.bq.d.d("TcpReporter", "remove black tcp urls err", th);
        }
        cn.jiguang.bq.d.c("TcpReporter", "tcp report find urls and remove black List Tcp Urls =" + linkedHashSet);
        return linkedHashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, cn.jiguang.bv.g gVar) {
        cn.jiguang.ca.a aVar;
        cn.jiguang.bq.d.c("TcpReporter", "socket at " + gVar + " is connected, deal with waiting request");
        ConcurrentHashMap<Integer, b> concurrentHashMap = this.f3127d.get(gVar);
        Pair<Integer, cn.jiguang.ca.a> pair = this.f3126c.get(gVar);
        if (pair == null) {
            return;
        }
        if (concurrentHashMap != null && (aVar = (cn.jiguang.ca.a) pair.second) != null && aVar.b()) {
            for (b bVar : concurrentHashMap.values()) {
                if (bVar != null && !bVar.f3142i) {
                    a(context, ((Integer) pair.first).intValue(), aVar, gVar, bVar);
                }
            }
        }
        cn.jiguang.cb.b.a().b(((Integer) pair.first).intValue() + 60000, 31000L, new a(context, gVar));
    }

    private void b(Context context, cn.jiguang.bv.g gVar, int i4) {
        if (gVar == null) {
            return;
        }
        try {
            InetAddress inetAddress = gVar.f2945c;
            cn.jiguang.bv.k.a(context).a(3, inetAddress != null ? inetAddress.getHostAddress() : gVar.f2943a, gVar.f2944b, cn.jiguang.d.b.b(context), 0L, i4);
        } catch (Throwable unused) {
        }
        this.f3128f.put(gVar, Long.valueOf(System.currentTimeMillis()));
    }

    private Set<cn.jiguang.bv.g> c(Context context, Set<String> set) {
        c(context);
        boolean a4 = a(context, set);
        String str = a4 ? "ssl" : "normal";
        if (set != null && !set.isEmpty()) {
            Set<cn.jiguang.bv.g> set2 = null;
            for (String str2 : set) {
                Set<cn.jiguang.bv.g> set3 = this.f3129g.get(a(str2, a4));
                if (set3 != null && !set3.isEmpty()) {
                    if (set2 == null) {
                        set2 = set3;
                    } else {
                        set2.retainAll(set3);
                    }
                    if (set2.isEmpty()) {
                    }
                }
            }
            return set2;
        }
        return this.f3129g.get(str);
    }

    private void c(Context context) {
        Map<String, Set<cn.jiguang.bv.g>> map = this.f3129g;
        if (map == null || map.isEmpty()) {
            String str = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.as());
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                a(new JSONObject(str));
            } catch (JSONException unused) {
            }
        }
    }

    public b a(Context context, JSONObject jSONObject, byte[] bArr, int i4, File file, Set<String> set, ReportCallBack reportCallBack, String str) {
        b bVar = new b();
        bVar.f3135b = jSONObject;
        bVar.f3134a = i4;
        bVar.f3136c = bArr;
        bVar.f3137d = file;
        bVar.f3138e = set;
        bVar.f3139f = b(context);
        bVar.f3143j = reportCallBack;
        bVar.f3144k = str;
        return bVar;
    }

    public void a(Context context) {
        cn.jiguang.bq.d.c("TcpReporter", "closeSocket sockets:" + this.f3126c);
        for (Map.Entry<cn.jiguang.bv.g, Pair<Integer, cn.jiguang.ca.a>> entry : this.f3126c.entrySet()) {
            cn.jiguang.bv.g key = entry.getKey();
            cn.jiguang.bq.d.c("TcpReporter", "closeSocket IpPort:" + key);
            a(context, key, -3);
        }
    }

    public void a(Context context, b bVar) {
        try {
            boolean z3 = bVar.f3141h == null;
            if (z3) {
                cn.jiguang.cb.b.a().a(context);
                bVar.f3141h = b(context, bVar.f3138e);
                cn.jiguang.bq.d.c("TcpReporter", "tcp report begin=" + bVar);
            }
            if (!cn.jiguang.f.a.e(context)) {
                a(context, bVar, -2);
                return;
            }
            LinkedHashSet<cn.jiguang.bv.g> linkedHashSet = bVar.f3141h;
            if (linkedHashSet != null && !linkedHashSet.isEmpty()) {
                cn.jiguang.bv.g gVar = null;
                Iterator<cn.jiguang.bv.g> it = this.f3126c.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    cn.jiguang.bv.g next = it.next();
                    if (bVar.f3141h.contains(next)) {
                        cn.jiguang.bq.d.c("TcpReporter", "use exist ipPort=" + next);
                        gVar = next;
                        break;
                    }
                }
                if (gVar == null) {
                    Iterator<cn.jiguang.bv.g> it2 = bVar.f3141h.iterator();
                    if (!it2.hasNext()) {
                        a(context, bVar, -1);
                        cn.jiguang.bq.d.c("TcpReporter", "use next no has ipPort ");
                        return;
                    }
                    gVar = it2.next();
                    cn.jiguang.bq.d.c("TcpReporter", "use next ipPort=" + gVar);
                }
                bVar.f3140g = gVar;
                bVar.f3141h.remove(gVar);
                if (z3) {
                    cn.jiguang.cb.b.a().b(bVar.f3139f + 50000, 15000L, new a(context, bVar));
                }
                ConcurrentHashMap<Integer, b> concurrentHashMap = this.f3127d.get(gVar);
                if (concurrentHashMap == null) {
                    concurrentHashMap = new ConcurrentHashMap<>();
                    this.f3127d.put(gVar, concurrentHashMap);
                }
                bVar.f3142i = false;
                concurrentHashMap.put(Integer.valueOf(bVar.f3139f), bVar);
                a(context, gVar, bVar);
                return;
            }
            a(context, bVar, -1);
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("TcpReporter", "tcp upload e:" + th);
        }
    }
}

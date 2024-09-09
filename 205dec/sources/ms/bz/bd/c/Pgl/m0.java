package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class m0 {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f61413a;

    /* renamed from: b  reason: collision with root package name */
    private static final Map<String, a> f61414b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private static Set<PglITokenObserver> f61415c = new CopyOnWriteArraySet();

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface pgla {
        Map<String, String> c(String str, byte[] bArr);

        void c(String str);

        void w(String str);
    }

    protected m0() {
    }

    static synchronized void a(Context context, String str) {
        synchronized (m0.class) {
            if (!f61413a) {
                Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                ms.bz.bd.c.Pgl.pgla.a().b(origApplicationContext);
                pblt.a(origApplicationContext, str);
                String str2 = (String) pblk.a(16777217, 0, 0L, "35f49f", new byte[]{108, 58, 6});
                pblb.c(16777218, new l());
                pblb.c(16777217, new w());
                String str3 = (String) pblk.a(16777217, 0, 0L, "b9a7fe", new byte[]{61, 54, 22});
                pblb.c(16777219, new e0());
                pblb.c(16777221, new f0());
                pblb.c(16777222, new g0());
                pblb.c(16777223, new h0());
                pblb.c(16777224, new i0());
                pblb.c(16777225, new j0());
                pblb.c(16777226, new k0());
                pblb.c(16777228, new b());
                pblb.c(16777232, new c());
                pblb.c(16777233, new d());
                pblb.c(16777235, new e());
                pblb.c(16777238, new f());
                pblb.c(16777239, new g());
                pblb.c(16777241, new h());
                pblb.c(16777242, new i());
                pblb.c(16777243, new j());
                pblb.c(16777244, new k());
                pblb.c(16777245, new m());
                pblb.c(16777246, new n());
                pblb.c(16777247, new o());
                pblb.c(16777248, new p());
                pblb.c(16777249, new q());
                pblb.c(16777250, new r());
                pblb.c(16777251, new s());
                pblb.c(16777240, new t());
                pblb.c(16777252, new u());
                pblb.c(16777253, new v());
                pblb.c(16777254, new x());
                pblb.c(16777255, new y());
                pblb.c(16777256, new z());
                pblb.c(16777257, new a0());
                pblb.c(16777258, new b0());
                pblb.c(16777259, new c0());
                pblb.c(33554435, new d0());
                pblj.a();
                com.volcengine.mobsecBiz.metasec.ml.b.a();
                pblk.a(16777219, 0, 0L, null, origApplicationContext);
                f61413a = true;
            }
        }
    }

    public static synchronized void b(String str) {
        synchronized (m0.class) {
            if (ms.bz.bd.c.Pgl.pgla.a().c() != null) {
                a aVar = f61414b.get(str);
                if (d(str) != null && aVar != null) {
                    f61415c.addAll(aVar.f61383o);
                    com.volcengine.mobsecBiz.metasec.ml.c a4 = com.volcengine.mobsecBiz.metasec.ml.d.a(str);
                    if (a4 != null) {
                        a4.c((String) pblk.a(16777217, 0, 0L, "8a8c95", new byte[]{22, 106, 69, 30, 18, 29, 41, 69, 121, 60, 59, 119}));
                    }
                }
            }
        }
    }

    public static synchronized boolean c(Context context, a aVar, String str, String str2) {
        synchronized (m0.class) {
            if (context != null) {
                if (aVar != null) {
                    String str3 = aVar.f61369a;
                    String str4 = (str3 == null || str3.length() <= 0) ? aVar.f61375g : aVar.f61369a;
                    if (str4 == null || str4.length() <= 0) {
                        throw new NullPointerException((String) pblk.a(16777217, 0, 0L, "9facb9", new byte[]{41, 116, 2, 62, 121, 110, 55, 82, 35, 39, 104, 102, 23, 87, 78, 43, 46}));
                    }
                    if (!f61413a) {
                        synchronized (m0.class) {
                            if (!f61413a) {
                                a(context, str);
                                f61413a = true;
                            }
                        }
                    }
                    if (f61414b.containsKey(str4)) {
                        return false;
                    }
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(aVar.a(aVar.f61369a));
                    jSONArray.put(aVar.a(aVar.f61376h));
                    jSONArray.put(aVar.a(aVar.f61375g));
                    jSONArray.put(aVar.a(aVar.f61377i));
                    jSONArray.put(aVar.a(l1.a()));
                    jSONArray.put(aVar.a(aVar.f61370b));
                    jSONArray.put(aVar.a(aVar.f61371c));
                    jSONArray.put(aVar.a(aVar.f61372d));
                    jSONArray.put(aVar.a(aVar.f61373e));
                    jSONArray.put(aVar.a(aVar.f61374f));
                    jSONArray.put(String.valueOf(aVar.f61378j));
                    jSONArray.put(String.valueOf(aVar.f61379k));
                    jSONArray.put(String.valueOf(aVar.f61380l));
                    JSONArray jSONArray2 = new JSONArray();
                    for (Map.Entry<String, String> entry : aVar.f61381m.entrySet()) {
                        if (!TextUtils.isEmpty(entry.getKey())) {
                            jSONArray2.put(aVar.a(entry.getKey()));
                            jSONArray2.put(aVar.a(entry.getValue()));
                        }
                    }
                    jSONArray.put(jSONArray2);
                    JSONArray jSONArray3 = new JSONArray();
                    for (Map.Entry<String, String> entry2 : aVar.f61382n.entrySet()) {
                        if (!TextUtils.isEmpty(entry2.getKey())) {
                            jSONArray3.put(aVar.a(entry2.getKey()));
                            jSONArray3.put(aVar.a(entry2.getValue()));
                        }
                    }
                    jSONArray.put(jSONArray3);
                    if (((Boolean) pblb.b(67108865, jSONArray.toString())).booleanValue()) {
                        f61414b.put(str4, aVar);
                        return true;
                    }
                    return false;
                }
                throw new NullPointerException((String) pblk.a(16777217, 0, 0L, "c1dc86", new byte[]{113, 60, 25, 17, 14, 38, 32, 19, 58, 38, 126, 55, 87, 25, 8, 53, 32, 18, 48, 115, 124, 38, 27, 27}));
            }
            throw new NullPointerException((String) pblk.a(16777217, 0, 0L, "423cf4", new byte[]{38, 63, 78, 3, 92, 59, 35, 83, 97, 60, 48, 60, 68, 87, 87, 44, 35, 83, 96, 54, 101, 62, 85, 27, 85}));
        }
    }

    public static synchronized pgla d(String str) {
        synchronized (m0.class) {
            if (str != null) {
                if (f61413a) {
                    Object b4 = pblb.b(67108866, str);
                    if (b4 == null) {
                        return null;
                    }
                    a aVar = f61414b.get(str);
                    if (aVar == null) {
                        return null;
                    }
                    return new l0(aVar, ms.bz.bd.c.Pgl.pgla.a().c(), ((Long) b4).longValue());
                }
                return null;
            }
            throw new NullPointerException((String) pblk.a(16777217, 0, 0L, "c7d8ef", new byte[]{115, 37, 7, 101, 126, 49, 109, 3, 38, 124, 50, 55, 18, 12, 73, 116, 116}));
        }
    }

    public static void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = (String) pblk.a(16777217, 0, 0L, "ab8355", new byte[]{Byte.MAX_VALUE, 110, 121, 66, 26, 45, 112, 87, 79, 106, 126, 105, 88, 79, 74, 54, 109, 72, 108, 109, 48, 45, 6, 10, 74});
        for (PglITokenObserver pglITokenObserver : f61415c) {
            pglITokenObserver.onTokenLoaded(str);
        }
    }
}

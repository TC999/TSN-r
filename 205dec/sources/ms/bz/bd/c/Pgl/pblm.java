package ms.bz.bd.c.Pgl;

import ms.bz.bd.c.Pgl.pblb;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class pblm extends pblb.pgla {

    /* renamed from: a  reason: collision with root package name */
    private static pblm f61432a;

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class pgla {

        /* renamed from: a  reason: collision with root package name */
        private long f61433a;

        /* renamed from: b  reason: collision with root package name */
        private long f61434b;

        /* renamed from: c  reason: collision with root package name */
        private String f61435c;

        /* renamed from: d  reason: collision with root package name */
        private String f61436d;

        public void a(String str) {
            this.f61435c = str;
            this.f61436d = null;
            this.f61433a = System.currentTimeMillis();
        }

        public void b(String str, int i4) {
            pblm c4 = pblm.c();
            if (c4 == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j4 = this.f61433a;
            long j5 = currentTimeMillis - j4;
            this.f61434b = j5;
            c4.d(j5, j4, this.f61435c, this.f61436d, str, i4, null);
        }

        public void c(String str, int i4) {
            pblm c4 = pblm.c();
            if (c4 == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j4 = this.f61433a;
            long j5 = currentTimeMillis - j4;
            this.f61434b = j5;
            c4.h(j5, j4, this.f61435c, this.f61436d, str, i4, null);
        }
    }

    public static synchronized pblm c() {
        pblm pblmVar;
        synchronized (pblm.class) {
            pblmVar = f61432a;
        }
        return pblmVar;
    }

    public static synchronized void f(pblm pblmVar) {
        synchronized (pblm.class) {
            f61432a = pblmVar;
        }
    }

    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object a(int i4, int i5, long j4, String str, Object obj) throws Throwable {
        if (i4 == 131073) {
            if (str == null || !g(str)) {
                return null;
            }
            return (String) pblk.a(16777217, 0, 0L, "61f16a", new byte[]{8, 24});
        }
        if (i4 == 131074) {
            String[] strArr = (String[]) obj;
            if (str != null && strArr != null && strArr.length != 0) {
                e(str, new JSONObject(strArr[0]), new JSONObject(strArr[1]), new JSONObject(strArr[2]));
            }
        }
        return null;
    }

    public abstract void d(long j4, long j5, String str, String str2, String str3, int i4, JSONObject jSONObject);

    public abstract void e(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3);

    public abstract boolean g(String str);

    public abstract void h(long j4, long j5, String str, String str2, String str3, int i4, JSONObject jSONObject);
}

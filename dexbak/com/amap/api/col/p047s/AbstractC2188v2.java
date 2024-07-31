package com.amap.api.col.p047s;

import android.content.Context;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.stub.StubApp;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BinaryRequest.java */
/* renamed from: com.amap.api.col.s.v2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class AbstractC2188v2 extends AbstractC2054f1 {

    /* renamed from: m */
    protected Context f6615m;

    /* renamed from: n */
    protected C2073i1 f6616n;

    /* renamed from: o */
    protected byte[] f6617o;

    public AbstractC2188v2(Context context, C2073i1 c2073i1) {
        if (context != null) {
            this.f6615m = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        this.f6616n = c2073i1;
        m53050y();
    }

    /* renamed from: H */
    private byte[] m52389H() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            Context context = this.f6615m;
            C2073i1 c2073i1 = this.f6616n;
            byte[] m53270f = C2016a1.m53270f(context, c2073i1 != null && "navi".equals(c2073i1.m52918d()));
            byteArrayOutputStream.write(m52386K(m53270f));
            byteArrayOutputStream.write(m53270f);
            byte[] m52862o = C2079j1.m52862o(mo52202M());
            if (m52862o != null && m52862o.length > 0) {
                byteArrayOutputStream.write(m52386K(m52862o));
                byteArrayOutputStream.write(m52862o);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            byte[] m52862o2 = C2079j1.m52862o(m52385N());
            if (m52862o2 != null && m52862o2.length > 0) {
                byteArrayOutputStream.write(m52386K(m52862o2));
                byteArrayOutputStream.write(m52862o2);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                C2041d2.m53085e(th, "bre", "gpd");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    C2041d2.m53085e(th2, "bre", "gred");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    C2041d2.m53085e(th3, "bre", "gred");
                }
            }
        }
    }

    /* renamed from: I */
    private static byte[] m52388I() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{0});
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                C2041d2.m53085e(th, "bre", "grrd");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    C2041d2.m53085e(th2, "bre", "grrd");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    C2041d2.m53085e(th3, "bre", "grrd");
                }
            }
        }
    }

    /* renamed from: J */
    private byte[] m52387J() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] mo52203L = mo52203L();
            if (mo52203L != null && mo52203L.length != 0) {
                byteArrayOutputStream.write(new byte[]{1});
                byte[] m53269g = C2016a1.m53269g(mo52203L);
                byteArrayOutputStream.write(m52386K(m53269g));
                byteArrayOutputStream.write(m53269g);
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                C2041d2.m53085e(th, "bre", "gred");
            }
            return byteArray;
        } catch (Throwable th2) {
            try {
                C2041d2.m53085e(th2, "bre", "gred");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    C2041d2.m53085e(th3, "bre", "gred");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    C2041d2.m53085e(th4, "bre", "gred");
                }
            }
        }
    }

    /* renamed from: K */
    private static byte[] m52386K(byte[] bArr) {
        return C2079j1.m52863n(bArr.length);
    }

    /* renamed from: O */
    private static byte[] m52384O() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(C2079j1.m52862o("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                C2041d2.m53085e(th, "bre", "gbh");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th2) {
                    C2041d2.m53085e(th2, "bre", "gbh");
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    C2041d2.m53085e(th3, "bre", "gbh");
                }
            }
        }
    }

    /* renamed from: L */
    public abstract byte[] mo52203L();

    /* renamed from: M */
    protected String mo52202M() {
        return "2.1";
    }

    /* renamed from: N */
    public final String m52385N() {
        return String.format("platform=Android&sdkversion=%s&product=%s", this.f6616n.m52916f(), this.f6616n.m52918d());
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: o */
    public final Map<String, String> mo52383o() {
        String m52327i = C2199x0.m52327i(this.f6615m);
        String m53275a = C2016a1.m53275a();
        String m53273c = C2016a1.m53273c(this.f6615m, m53275a, "key=".concat(String.valueOf(m52327i)));
        HashMap hashMap = new HashMap();
        hashMap.put("ts", m53275a);
        hashMap.put(DomainCampaignEx.LOOPBACK_KEY, m52327i);
        hashMap.put("scode", m53273c);
        return hashMap;
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: q */
    public final byte[] mo52382q() {
        byte[] bArr = this.f6617o;
        if (bArr != null) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(m52384O());
            byteArrayOutputStream.write(m52389H());
            byteArrayOutputStream.write(m52388I());
            byteArrayOutputStream.write(m52387J());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.f6617o = byteArray;
            return byteArray;
        } catch (Throwable th) {
            try {
                C2041d2.m53085e(th, "bre", "geb");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th2) {
                    C2041d2.m53085e(th2, "bre", "geb");
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    C2041d2.m53085e(th3, "bre", "geb");
                }
            }
        }
    }
}

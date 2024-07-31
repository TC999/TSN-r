package com.amap.api.col.p0463l;

import android.content.Context;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.stub.StubApp;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.amap.api.col.3l.q6 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class BinaryRequest extends IPV6Request {

    /* renamed from: a */
    protected Context f5132a;

    /* renamed from: b */
    protected SDKInfo f5133b;

    /* renamed from: c */
    protected byte[] f5134c;

    public BinaryRequest(Context context, SDKInfo sDKInfo) {
        if (context != null) {
            this.f5132a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        this.f5133b = sDKInfo;
        setBinary(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static byte[] m54105a(byte[] bArr) {
        return C1925p4.m54190n(bArr.length);
    }

    /* renamed from: i */
    private static byte[] m54103i() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(C1925p4.m54189o("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                BasicLogHandler.m54177e(th, "bre", "gbh");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th2) {
                    BasicLogHandler.m54177e(th2, "bre", "gbh");
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    BasicLogHandler.m54177e(th3, "bre", "gbh");
                }
            }
        }
    }

    /* renamed from: j */
    private byte[] m54102j() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            if (mo51368f()) {
                Context context = this.f5132a;
                boolean mo51366h = mo51366h();
                SDKInfo sDKInfo = this.f5133b;
                byte[] m54928f = ClientInfo.m54928f(context, mo51366h, sDKInfo != null && "navi".equals(sDKInfo.m54400a()));
                byteArrayOutputStream.write(m54105a(m54928f));
                byteArrayOutputStream.write(m54928f);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            byte[] m54189o = C1925p4.m54189o(mo54104e());
            if (m54189o != null && m54189o.length > 0) {
                byteArrayOutputStream.write(m54105a(m54189o));
                byteArrayOutputStream.write(m54189o);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            byte[] m54189o2 = C1925p4.m54189o(mo51367g());
            if (m54189o2 != null && m54189o2.length > 0) {
                byteArrayOutputStream.write(m54105a(m54189o2));
                byteArrayOutputStream.write(m54189o2);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                BasicLogHandler.m54177e(th, "bre", "gpd");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    BasicLogHandler.m54177e(th2, "bre", "gred");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    BasicLogHandler.m54177e(th3, "bre", "gred");
                }
            }
        }
    }

    /* renamed from: k */
    private byte[] m54101k() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] mo51373c = mo51373c();
            if (mo51373c != null && mo51373c.length != 0) {
                byteArrayOutputStream.write(new byte[]{1});
                byteArrayOutputStream.write(m54105a(mo51373c));
                byteArrayOutputStream.write(mo51373c);
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                BasicLogHandler.m54177e(th, "bre", "grrd");
            }
            return byteArray;
        } catch (Throwable th2) {
            try {
                BasicLogHandler.m54177e(th2, "bre", "grrd");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    BasicLogHandler.m54177e(th3, "bre", "grrd");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    BasicLogHandler.m54177e(th4, "bre", "grrd");
                }
            }
        }
    }

    /* renamed from: l */
    private byte[] m54100l() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] mo51370d = mo51370d();
            if (mo51370d != null && mo51370d.length != 0) {
                byteArrayOutputStream.write(new byte[]{1});
                byte[] m54927g = ClientInfo.m54927g(mo51370d);
                byteArrayOutputStream.write(m54105a(m54927g));
                byteArrayOutputStream.write(m54927g);
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                BasicLogHandler.m54177e(th, "bre", "gred");
            }
            return byteArray;
        } catch (Throwable th2) {
            try {
                BasicLogHandler.m54177e(th2, "bre", "gred");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    BasicLogHandler.m54177e(th3, "bre", "gred");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    BasicLogHandler.m54177e(th4, "bre", "gred");
                }
            }
        }
    }

    /* renamed from: c */
    public abstract byte[] mo51373c();

    /* renamed from: d */
    public abstract byte[] mo51370d();

    /* renamed from: e */
    protected String mo54104e() {
        return "2.1";
    }

    /* renamed from: f */
    public boolean mo51368f() {
        return true;
    }

    /* renamed from: g */
    public String mo51367g() {
        return String.format("platform=Android&sdkversion=%s&product=%s", this.f5133b.m54395f(), this.f5133b.m54400a());
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final byte[] getEntityBytes() {
        byte[] bArr = this.f5134c;
        if (bArr != null) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(m54103i());
            byteArrayOutputStream.write(m54102j());
            byteArrayOutputStream.write(m54101k());
            byteArrayOutputStream.write(m54100l());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.f5134c = byteArray;
            return byteArray;
        } catch (Throwable th) {
            try {
                BasicLogHandler.m54177e(th, "bre", "geb");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th2) {
                    BasicLogHandler.m54177e(th2, "bre", "geb");
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    BasicLogHandler.m54177e(th3, "bre", "geb");
                }
            }
        }
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public Map<String, String> getParams() {
        String m55240j = C1780e4.m55240j(this.f5132a);
        String m54933a = ClientInfo.m54933a();
        String m54931c = ClientInfo.m54931c(this.f5132a, m54933a, "key=".concat(String.valueOf(m55240j)));
        HashMap hashMap = new HashMap();
        hashMap.put("ts", m54933a);
        hashMap.put(DomainCampaignEx.LOOPBACK_KEY, m55240j);
        hashMap.put("scode", m54931c);
        return hashMap;
    }

    /* renamed from: h */
    protected boolean mo51366h() {
        return false;
    }
}

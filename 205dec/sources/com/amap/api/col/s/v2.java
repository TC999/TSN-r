package com.amap.api.col.s;

import android.content.Context;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.stub.StubApp;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BinaryRequest.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class v2 extends f1 {

    /* renamed from: m  reason: collision with root package name */
    protected Context f10343m;

    /* renamed from: n  reason: collision with root package name */
    protected i1 f10344n;

    /* renamed from: o  reason: collision with root package name */
    protected byte[] f10345o;

    public v2(Context context, i1 i1Var) {
        if (context != null) {
            this.f10343m = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        this.f10344n = i1Var;
        y();
    }

    private byte[] H() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            Context context = this.f10343m;
            i1 i1Var = this.f10344n;
            byte[] f4 = a1.f(context, i1Var != null && "navi".equals(i1Var.d()));
            byteArrayOutputStream.write(K(f4));
            byteArrayOutputStream.write(f4);
            byte[] o4 = j1.o(M());
            if (o4 != null && o4.length > 0) {
                byteArrayOutputStream.write(K(o4));
                byteArrayOutputStream.write(o4);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            byte[] o5 = j1.o(N());
            if (o5 != null && o5.length > 0) {
                byteArrayOutputStream.write(K(o5));
                byteArrayOutputStream.write(o5);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                d2.e(th, "bre", "gpd");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    d2.e(th2, "bre", "gred");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    d2.e(th3, "bre", "gred");
                }
            }
        }
    }

    private static byte[] I() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{0});
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                d2.e(th, "bre", "grrd");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    d2.e(th2, "bre", "grrd");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    d2.e(th3, "bre", "grrd");
                }
            }
        }
    }

    private byte[] J() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] L2 = L();
            if (L2 != null && L2.length != 0) {
                byteArrayOutputStream.write(new byte[]{1});
                byte[] g4 = a1.g(L2);
                byteArrayOutputStream.write(K(g4));
                byteArrayOutputStream.write(g4);
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                d2.e(th, "bre", "gred");
            }
            return byteArray;
        } catch (Throwable th2) {
            try {
                d2.e(th2, "bre", "gred");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    d2.e(th3, "bre", "gred");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    d2.e(th4, "bre", "gred");
                }
            }
        }
    }

    private static byte[] K(byte[] bArr) {
        return j1.n(bArr.length);
    }

    private static byte[] O() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(j1.o("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                d2.e(th, "bre", "gbh");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th2) {
                    d2.e(th2, "bre", "gbh");
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    d2.e(th3, "bre", "gbh");
                }
            }
        }
    }

    public abstract byte[] L();

    protected String M() {
        return "2.1";
    }

    public final String N() {
        return String.format("platform=Android&sdkversion=%s&product=%s", this.f10344n.f(), this.f10344n.d());
    }

    @Override // com.amap.api.col.s.dz
    public final Map<String, String> o() {
        String i4 = x0.i(this.f10343m);
        String a4 = a1.a();
        String c4 = a1.c(this.f10343m, a4, "key=".concat(String.valueOf(i4)));
        HashMap hashMap = new HashMap();
        hashMap.put("ts", a4);
        hashMap.put(DomainCampaignEx.LOOPBACK_KEY, i4);
        hashMap.put("scode", c4);
        return hashMap;
    }

    @Override // com.amap.api.col.s.dz
    public final byte[] q() {
        byte[] bArr = this.f10345o;
        if (bArr != null) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(O());
            byteArrayOutputStream.write(H());
            byteArrayOutputStream.write(I());
            byteArrayOutputStream.write(J());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.f10345o = byteArray;
            return byteArray;
        } catch (Throwable th) {
            try {
                d2.e(th, "bre", "geb");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th2) {
                    d2.e(th2, "bre", "geb");
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    d2.e(th3, "bre", "geb");
                }
            }
        }
    }
}

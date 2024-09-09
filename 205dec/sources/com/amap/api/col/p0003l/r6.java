package com.amap.api.col.p0003l;

import android.content.Context;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.stub.StubApp;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BinaryRequest.java */
/* renamed from: com.amap.api.col.3l.r6  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class r6 extends l4 {

    /* renamed from: a  reason: collision with root package name */
    protected Context f8906a;

    /* renamed from: b  reason: collision with root package name */
    protected p4 f8907b;

    /* renamed from: c  reason: collision with root package name */
    protected byte[] f8908c;

    /* compiled from: H5LocationClient.java */
    /* renamed from: com.amap.api.col.3l.r6$a */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class a implements ValueCallback<String> {
        a() {
        }

        @Override // android.webkit.ValueCallback
        public final /* bridge */ /* synthetic */ void onReceiveValue(String str) {
        }
    }

    /* compiled from: H5LocationClient.java */
    /* renamed from: com.amap.api.col.3l.r6$b */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f8910a;

        b(String str) {
            this.f8910a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            WebView f4 = r6.f(r6.this);
            f4.loadUrl("javascript:" + r6.a(r6.this) + "('" + this.f8910a + "')");
        }
    }

    /* compiled from: H5LocationClient.java */
    /* renamed from: com.amap.api.col.3l.r6$c */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class c implements AMapLocationListener {
        c() {
        }

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            if (r6.j(r6.this)) {
                r6.d(r6.this, r6.b(aMapLocation));
            }
        }
    }

    public r6(Context context, p4 p4Var) {
        if (context != null) {
            this.f8906a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        this.f8907b = p4Var;
        setBinary(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static byte[] a(byte[] bArr) {
        return q4.n(bArr.length);
    }

    private static byte[] i() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(q4.o("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                q5.e(th, "bre", "gbh");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th2) {
                    q5.e(th2, "bre", "gbh");
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    q5.e(th3, "bre", "gbh");
                }
            }
        }
    }

    private byte[] j() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            if (f()) {
                Context context = this.f8906a;
                boolean h4 = h();
                p4 p4Var = this.f8907b;
                byte[] f4 = h4.f(context, h4, p4Var != null && "navi".equals(p4Var.a()));
                byteArrayOutputStream.write(a(f4));
                byteArrayOutputStream.write(f4);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            byte[] o4 = q4.o(e());
            if (o4 != null && o4.length > 0) {
                byteArrayOutputStream.write(a(o4));
                byteArrayOutputStream.write(o4);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            byte[] o5 = q4.o(g());
            if (o5 != null && o5.length > 0) {
                byteArrayOutputStream.write(a(o5));
                byteArrayOutputStream.write(o5);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                q5.e(th, "bre", "gpd");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    q5.e(th2, "bre", "gred");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    q5.e(th3, "bre", "gred");
                }
            }
        }
    }

    private byte[] k() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] c4 = c();
            if (c4 != null && c4.length != 0) {
                byteArrayOutputStream.write(new byte[]{1});
                byteArrayOutputStream.write(a(c4));
                byteArrayOutputStream.write(c4);
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                q5.e(th, "bre", "grrd");
            }
            return byteArray;
        } catch (Throwable th2) {
            try {
                q5.e(th2, "bre", "grrd");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    q5.e(th3, "bre", "grrd");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    q5.e(th4, "bre", "grrd");
                }
            }
        }
    }

    private byte[] l() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] d4 = d();
            if (d4 != null && d4.length != 0) {
                byteArrayOutputStream.write(new byte[]{1});
                byte[] g4 = h4.g(d4);
                byteArrayOutputStream.write(a(g4));
                byteArrayOutputStream.write(g4);
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                q5.e(th, "bre", "gred");
            }
            return byteArray;
        } catch (Throwable th2) {
            try {
                q5.e(th2, "bre", "gred");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    q5.e(th3, "bre", "gred");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    q5.e(th4, "bre", "gred");
                }
            }
        }
    }

    public abstract byte[] c();

    public abstract byte[] d();

    protected String e() {
        return "2.1";
    }

    public boolean f() {
        return true;
    }

    public String g() {
        return String.format("platform=Android&sdkversion=%s&product=%s", this.f8907b.f(), this.f8907b.a());
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final byte[] getEntityBytes() {
        byte[] bArr = this.f8908c;
        if (bArr != null) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(i());
            byteArrayOutputStream.write(j());
            byteArrayOutputStream.write(k());
            byteArrayOutputStream.write(l());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.f8908c = byteArray;
            return byteArray;
        } catch (Throwable th) {
            try {
                q5.e(th, "bre", "geb");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th2) {
                    q5.e(th2, "bre", "geb");
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    q5.e(th3, "bre", "geb");
                }
            }
        }
    }

    @Override // com.amap.api.col.p0003l.Cif
    public Map<String, String> getParams() {
        String j4 = e4.j(this.f8906a);
        String a4 = h4.a();
        String c4 = h4.c(this.f8906a, a4, "key=".concat(String.valueOf(j4)));
        HashMap hashMap = new HashMap();
        hashMap.put("ts", a4);
        hashMap.put(DomainCampaignEx.LOOPBACK_KEY, j4);
        hashMap.put("scode", c4);
        return hashMap;
    }

    protected boolean h() {
        return false;
    }
}

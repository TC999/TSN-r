package cn.jpush.android.w;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.X509TrustManager;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f4483a;

    /* renamed from: b  reason: collision with root package name */
    private String f4484b;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, String> f4487e;

    /* renamed from: g  reason: collision with root package name */
    private Object f4489g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4490h;

    /* renamed from: l  reason: collision with root package name */
    private X509TrustManager f4494l;

    /* renamed from: m  reason: collision with root package name */
    private HostnameVerifier f4495m;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4491i = true;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4492j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4493k = false;

    /* renamed from: c  reason: collision with root package name */
    private int f4485c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f4486d = -1;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, String> f4488f = new HashMap();

    public c(String str) {
        this.f4483a = str;
    }

    public String a() {
        return this.f4483a;
    }

    public void a(Object obj) {
        this.f4489g = obj;
    }

    public void a(String str) {
        this.f4484b = str;
    }

    public void a(String str, String str2) {
        this.f4488f.put(str, str2);
    }

    public int b() {
        return this.f4485c;
    }

    public int c() {
        return this.f4486d;
    }

    public boolean d() {
        return this.f4490h;
    }

    public boolean e() {
        return this.f4493k;
    }

    public X509TrustManager f() {
        return this.f4494l;
    }

    public HostnameVerifier g() {
        return this.f4495m;
    }

    public byte[] h() {
        Object obj = this.f4489g;
        if (obj != null) {
            if (obj instanceof String) {
                if (!TextUtils.isEmpty((CharSequence) obj)) {
                    return ((String) this.f4489g).getBytes();
                }
            } else if (obj instanceof byte[]) {
                return (byte[]) obj;
            }
        }
        String a4 = e.a(this.f4487e);
        if (TextUtils.isEmpty(a4)) {
            return null;
        }
        return a4.getBytes();
    }

    public Map<String, String> i() {
        return this.f4488f;
    }

    public boolean j() {
        return this.f4491i;
    }

    public boolean k() {
        return this.f4492j;
    }

    public String l() {
        return this.f4484b;
    }
}

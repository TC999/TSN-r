package com.qq.e.comm.plugin.nativeadunified;

import android.text.TextUtils;
import com.qq.e.comm.plugin.g0.t;
import com.qq.e.comm.plugin.util.d1;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class g extends com.qq.e.comm.plugin.g0.e implements t {

    /* renamed from: g1  reason: collision with root package name */
    int f44924g1;

    /* renamed from: h1  reason: collision with root package name */
    List<String> f44925h1;

    /* renamed from: i1  reason: collision with root package name */
    String f44926i1;

    /* renamed from: j1  reason: collision with root package name */
    private int f44927j1;

    /* renamed from: k1  reason: collision with root package name */
    private double f44928k1;

    /* renamed from: l1  reason: collision with root package name */
    private String f44929l1;

    /* renamed from: m1  reason: collision with root package name */
    private int f44930m1;

    /* renamed from: n1  reason: collision with root package name */
    private long f44931n1;

    public g(String str, String str2, String str3, String str4, JSONObject jSONObject, com.qq.e.comm.plugin.b.l lVar) {
        super(str, str2, str3, str4, com.qq.e.comm.plugin.b.g.NATIVEUNIFIEDAD, jSONObject, lVar);
        this.f44925h1 = new ArrayList();
        h.a(this, jSONObject);
        com.qq.e.comm.plugin.g0.b bVar = this.A;
        if (bVar != null) {
            this.f44927j1 = bVar.i();
            this.f44928k1 = this.A.g();
            this.f44929l1 = this.A.e();
            this.f44930m1 = this.A.j();
            this.f44931n1 = this.A.c();
        }
    }

    public final void d(int i4) {
        this.f44930m1 = i4;
    }

    @Override // com.qq.e.comm.plugin.g0.t
    public String e() {
        return this.f44926i1;
    }

    public int o1() {
        if (l1()) {
            return 2;
        }
        if (this.f44925h1.size() == 3) {
            return 3;
        }
        return this.f44924g1 == 31 ? 4 : 1;
    }

    public final double p1() {
        return this.f44928k1;
    }

    public final int q1() {
        return this.f44927j1;
    }

    public final int r1() {
        return this.f44930m1;
    }

    public String s1() {
        String a4 = z() != null ? z().a() : "";
        if (TextUtils.isEmpty(a4)) {
            d1.a("\u975e\u8425\u9500\u7ec4\u4ef6\u5e7f\u544a", new Object[0]);
        }
        return a4;
    }

    public final long t1() {
        return this.f44931n1;
    }

    public final List<String> u1() {
        return this.f44925h1;
    }

    public final String v1() {
        return this.f44929l1;
    }
}

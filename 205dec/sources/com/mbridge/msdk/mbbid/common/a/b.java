package com.mbridge.msdk.mbbid.common.a;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.h;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.mbbid.out.BidListennning;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.lang.reflect.Method;

/* compiled from: RequesManager.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private String f39992a;

    /* renamed from: b  reason: collision with root package name */
    private String f39993b;

    /* renamed from: c  reason: collision with root package name */
    private String f39994c;

    /* renamed from: e  reason: collision with root package name */
    private BidListennning f39996e;

    /* renamed from: f  reason: collision with root package name */
    private BidResponsedEx f39997f;

    /* renamed from: g  reason: collision with root package name */
    private int f39998g;

    /* renamed from: i  reason: collision with root package name */
    private long f40000i;

    /* renamed from: j  reason: collision with root package name */
    private long f40001j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f40002k;

    /* renamed from: l  reason: collision with root package name */
    private int f40003l;

    /* renamed from: h  reason: collision with root package name */
    private boolean f39999h = false;

    /* renamed from: d  reason: collision with root package name */
    private Context f39995d = com.mbridge.msdk.foundation.controller.a.f().j();

    public b(String str, String str2, String str3) {
        this.f39992a = str;
        this.f39993b = str2;
        this.f39994c = str3;
    }

    public final void b(int i4) {
        this.f39998g = i4;
    }

    public final void b(long j4) {
        this.f40001j = j4;
    }

    public final void b(boolean z3) {
        try {
            if (!this.f39999h) {
                this.f39999h = true;
                if (this.f39995d == null) {
                    a("context is null");
                }
                com.mbridge.msdk.mbbid.common.b.a aVar = new com.mbridge.msdk.mbbid.common.b.a(this.f39995d);
                d dVar = new d();
                String k4 = com.mbridge.msdk.foundation.controller.a.f().k();
                dVar.a("app_id", k4);
                dVar.a("sign", SameMD5.getMD5(k4 + com.mbridge.msdk.foundation.controller.a.f().l()));
                dVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, this.f39993b);
                if (!TextUtils.isEmpty(this.f39992a)) {
                    dVar.a("placement_id", this.f39992a);
                }
                dVar.a("bid_floor", this.f39994c);
                dVar.a(d.f39596c, ac.b(this.f39995d, this.f39993b));
                dVar.a("install_ids", h.a(0));
                dVar.a(d.f39595b, com.mbridge.msdk.foundation.same.a.d.a(this.f39993b, ""));
                String str = "1";
                dVar.a("req_type", this.f40002k ? "1" : "2");
                dVar.a("orientation", t.t(this.f39995d) + "");
                int i4 = this.f39998g;
                if (i4 == 296) {
                    if (this.f40000i > 0 && this.f40001j > 0) {
                        dVar.a("unit_size", this.f40001j + "x" + this.f40000i);
                        try {
                            Method method = Class.forName("com.mbridge.msdk.mbbanner.common.util.BannerUtils").getMethod("getCloseIds", String.class);
                            if (method.invoke(null, this.f39993b) instanceof String) {
                                dVar.a("close_id", method.invoke(null, this.f39993b).toString());
                            }
                        } catch (Exception unused) {
                            a("banner module is miss");
                            return;
                        }
                    } else {
                        a("bid required param is missing or error");
                        return;
                    }
                } else if (i4 == 297) {
                    if (this.f40000i > 0 && this.f40001j > 0) {
                        dVar.a("unit_size", this.f40001j + "x" + this.f40000i);
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.f40003l);
                        sb.append("");
                        dVar.a("orientation", sb.toString());
                    } else {
                        a("ad display area is too small");
                        return;
                    }
                } else if (i4 == 298) {
                    if (this.f40000i > 0 && this.f40001j > 0) {
                        dVar.a("unit_size", this.f40001j + "x" + this.f40000i);
                    } else {
                        a("bid required param is missing or error");
                        return;
                    }
                } else {
                    if (!z3) {
                        str = "0";
                    }
                    dVar.a("rw_plus", str);
                }
                a aVar2 = new a(this.f39992a, this.f39993b) { // from class: com.mbridge.msdk.mbbid.common.a.b.1
                    @Override // com.mbridge.msdk.mbbid.common.b.b
                    public final void a(BidResponsedEx bidResponsedEx) {
                        b.this.f39999h = false;
                        b.this.f39997f = bidResponsedEx;
                        com.mbridge.msdk.mbbid.common.c.a.a(b.this.f39995d, b.this.f39993b, bidResponsedEx.getBidId());
                        b.a(b.this, (BidResponsed) bidResponsedEx);
                    }

                    @Override // com.mbridge.msdk.mbbid.common.b.b
                    public final void a(int i5, String str2) {
                        b.this.f39999h = false;
                        com.mbridge.msdk.mbbid.common.c.a.b(b.this.f39995d, b.this.f39993b, str2);
                        b.this.a(str2);
                    }
                };
                aVar2.f39551d = this.f39993b;
                aVar2.f39552e = this.f39992a;
                aVar.a(1, com.mbridge.msdk.foundation.same.net.f.d.a().a(false, ""), dVar, aVar2);
                return;
            }
            a("current unit is biding");
        } catch (Throwable th) {
            a(th.getMessage());
        }
    }

    public final void a(boolean z3) {
        this.f40002k = z3;
    }

    public final void a(int i4) {
        this.f40003l = i4;
    }

    public final void a(long j4) {
        this.f40000i = j4;
    }

    public final void a(BidListennning bidListennning) {
        this.f39996e = bidListennning;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        BidListennning bidListennning = this.f39996e;
        if (bidListennning != null) {
            bidListennning.onFailed(str);
        }
    }

    static /* synthetic */ void a(b bVar, BidResponsed bidResponsed) {
        BidListennning bidListennning = bVar.f39996e;
        if (bidListennning != null) {
            bidListennning.onSuccessed(bidResponsed);
        }
    }
}

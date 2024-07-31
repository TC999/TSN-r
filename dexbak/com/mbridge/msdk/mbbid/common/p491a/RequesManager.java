package com.mbridge.msdk.mbbid.common.p491a;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.same.net.p485f.RequestUrlUtil;
import com.mbridge.msdk.foundation.same.net.p486g.CommonRequestParams;
import com.mbridge.msdk.foundation.same.p474a.StaticDataPoll;
import com.mbridge.msdk.foundation.tools.DomainSameTool;
import com.mbridge.msdk.foundation.tools.SameDiTool;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.SameTool;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.mbbid.common.p492b.BidRequest;
import com.mbridge.msdk.mbbid.common.p493c.BidReport;
import com.mbridge.msdk.mbbid.out.BidListennning;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.lang.reflect.Method;

/* renamed from: com.mbridge.msdk.mbbid.common.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class RequesManager {

    /* renamed from: a */
    private String f31218a;

    /* renamed from: b */
    private String f31219b;

    /* renamed from: c */
    private String f31220c;

    /* renamed from: e */
    private BidListennning f31222e;

    /* renamed from: f */
    private BidResponsedEx f31223f;

    /* renamed from: g */
    private int f31224g;

    /* renamed from: i */
    private long f31226i;

    /* renamed from: j */
    private long f31227j;

    /* renamed from: k */
    private boolean f31228k;

    /* renamed from: l */
    private int f31229l;

    /* renamed from: h */
    private boolean f31225h = false;

    /* renamed from: d */
    private Context f31221d = MBSDKContext.m22865f().m22861j();

    public RequesManager(String str, String str2, String str3) {
        this.f31218a = str;
        this.f31219b = str2;
        this.f31220c = str3;
    }

    /* renamed from: b */
    public final void m21692b(int i) {
        this.f31224g = i;
    }

    /* renamed from: b */
    public final void m21691b(long j) {
        this.f31227j = j;
    }

    /* renamed from: b */
    public final void m21689b(boolean z) {
        try {
            if (!this.f31225h) {
                this.f31225h = true;
                if (this.f31221d == null) {
                    m21694a("context is null");
                }
                BidRequest bidRequest = new BidRequest(this.f31221d);
                CommonRequestParams commonRequestParams = new CommonRequestParams();
                String m22860k = MBSDKContext.m22865f().m22860k();
                commonRequestParams.m22222a("app_id", m22860k);
                commonRequestParams.m22222a("sign", SameMD5.getMD5(m22860k + MBSDKContext.m22865f().m22859l()));
                commonRequestParams.m22222a(MBridgeConstans.PROPERTIES_UNIT_ID, this.f31219b);
                if (!TextUtils.isEmpty(this.f31218a)) {
                    commonRequestParams.m22222a("placement_id", this.f31218a);
                }
                commonRequestParams.m22222a("bid_floor", this.f31220c);
                commonRequestParams.m22222a(CommonRequestParams.f30823c, SameTool.m22000b(this.f31221d, this.f31219b));
                commonRequestParams.m22222a("install_ids", DomainSameTool.m21874a(0));
                commonRequestParams.m22222a(CommonRequestParams.f30822b, StaticDataPoll.m22374a(this.f31219b, ""));
                String str = "1";
                commonRequestParams.m22222a("req_type", this.f31228k ? "1" : "2");
                commonRequestParams.m22222a("orientation", SameDiTool.m21772t(this.f31221d) + "");
                int i = this.f31224g;
                if (i == 296) {
                    if (this.f31226i > 0 && this.f31227j > 0) {
                        commonRequestParams.m22222a("unit_size", this.f31227j + "x" + this.f31226i);
                        try {
                            Method method = Class.forName("com.mbridge.msdk.mbbanner.common.util.BannerUtils").getMethod("getCloseIds", String.class);
                            if (method.invoke(null, this.f31219b) instanceof String) {
                                commonRequestParams.m22222a("close_id", method.invoke(null, this.f31219b).toString());
                            }
                        } catch (Exception unused) {
                            m21694a("banner module is miss");
                            return;
                        }
                    } else {
                        m21694a("bid required param is missing or error");
                        return;
                    }
                } else if (i == 297) {
                    if (this.f31226i > 0 && this.f31227j > 0) {
                        commonRequestParams.m22222a("unit_size", this.f31227j + "x" + this.f31226i);
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.f31229l);
                        sb.append("");
                        commonRequestParams.m22222a("orientation", sb.toString());
                    } else {
                        m21694a("ad display area is too small");
                        return;
                    }
                } else if (i == 298) {
                    if (this.f31226i > 0 && this.f31227j > 0) {
                        commonRequestParams.m22222a("unit_size", this.f31227j + "x" + this.f31226i);
                    } else {
                        m21694a("bid required param is missing or error");
                        return;
                    }
                } else {
                    if (!z) {
                        str = "0";
                    }
                    commonRequestParams.m22222a("rw_plus", str);
                }
                BidResultHandler bidResultHandler = new BidResultHandler(this.f31218a, this.f31219b) { // from class: com.mbridge.msdk.mbbid.common.a.b.1
                    @Override // com.mbridge.msdk.mbbid.common.p492b.BidResponseHandler
                    /* renamed from: a */
                    public final void mo21687a(BidResponsedEx bidResponsedEx) {
                        RequesManager.this.f31225h = false;
                        RequesManager.this.f31223f = bidResponsedEx;
                        BidReport.m21685a(RequesManager.this.f31221d, RequesManager.this.f31219b, bidResponsedEx.getBidId());
                        RequesManager.m21698a(RequesManager.this, (BidResponsed) bidResponsedEx);
                    }

                    @Override // com.mbridge.msdk.mbbid.common.p492b.BidResponseHandler
                    /* renamed from: a */
                    public final void mo21688a(int i2, String str2) {
                        RequesManager.this.f31225h = false;
                        BidReport.m21684b(RequesManager.this.f31221d, RequesManager.this.f31219b, str2);
                        RequesManager.this.m21694a(str2);
                    }
                };
                bidResultHandler.f30757d = this.f31219b;
                bidResultHandler.f30758e = this.f31218a;
                bidRequest.m22234a(1, RequestUrlUtil.m22248a().m22244a(false, ""), commonRequestParams, bidResultHandler);
                return;
            }
            m21694a("current unit is biding");
        } catch (Throwable th) {
            m21694a(th.getMessage());
        }
    }

    /* renamed from: a */
    public final void m21693a(boolean z) {
        this.f31228k = z;
    }

    /* renamed from: a */
    public final void m21702a(int i) {
        this.f31229l = i;
    }

    /* renamed from: a */
    public final void m21701a(long j) {
        this.f31226i = j;
    }

    /* renamed from: a */
    public final void m21695a(BidListennning bidListennning) {
        this.f31222e = bidListennning;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m21694a(String str) {
        BidListennning bidListennning = this.f31222e;
        if (bidListennning != null) {
            bidListennning.onFailed(str);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m21698a(RequesManager requesManager, BidResponsed bidResponsed) {
        BidListennning bidListennning = requesManager.f31222e;
        if (bidListennning != null) {
            bidListennning.onSuccessed(bidResponsed);
        }
    }
}

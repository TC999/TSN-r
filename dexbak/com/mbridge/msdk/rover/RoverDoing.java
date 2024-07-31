package com.mbridge.msdk.rover;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.CommonJumpLoader;
import com.mbridge.msdk.click.CommonLoaderListener;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.ReportController;
import com.mbridge.msdk.foundation.tools.SameBase64Tool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.mbridge.msdk.rover.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class RoverDoing {

    /* renamed from: b */
    private static String f31671b = "0";

    /* renamed from: d */
    private CampaignEx f31674d;

    /* renamed from: e */
    private Context f31675e;

    /* renamed from: c */
    private List<RoverReportData> f31673c = new ArrayList();

    /* renamed from: a */
    RoverListener f31672a = new RoverListener() { // from class: com.mbridge.msdk.rover.c.1
        @Override // com.mbridge.msdk.rover.RoverListener
        /* renamed from: a */
        public final void mo21315a(String str, int i, int i2, int i3, String str2, String str3) {
            RoverDoing.m21320a(RoverDoing.this, str, i, i2, i3, str2, str3);
        }

        @Override // com.mbridge.msdk.rover.RoverListener
        /* renamed from: b */
        public final void mo21314b(String str, int i, int i2, int i3, String str2, String str3) {
            RoverDoing.m21320a(RoverDoing.this, str, i, i2, i3, str2, str3);
        }

        @Override // com.mbridge.msdk.rover.RoverListener
        /* renamed from: c */
        public final void mo21313c(String str, int i, int i2, int i3, String str2, String str3) {
            RoverDoing.m21320a(RoverDoing.this, str, i, i2, i3, str2, str3);
        }
    };

    /* renamed from: f */
    private Map<String, String> f31676f = new HashMap();

    public RoverDoing(RoverCampaignUnit roverCampaignUnit, CampaignEx campaignEx, Context context) {
        CommonJumpLoader commonJumpLoader = new CommonJumpLoader(context, true);
        this.f31674d = campaignEx;
        this.f31675e = context;
        commonJumpLoader.m23170a("2", f31671b, campaignEx, new CommonLoaderListener() { // from class: com.mbridge.msdk.rover.c.3
            @Override // com.mbridge.msdk.click.CommonLoaderListener
            /* renamed from: a */
            public final void mo21318a(Object obj) {
            }

            @Override // com.mbridge.msdk.click.CommonLoaderListener
            /* renamed from: a */
            public final void mo21317a(Object obj, String str) {
                if (RoverDoing.this.f31674d == null || RoverDoing.this.f31674d.getRoverIsPost() != 1) {
                    return;
                }
                RoverDoing.m21319b(RoverDoing.this);
            }

            @Override // com.mbridge.msdk.click.CommonLoaderListener
            /* renamed from: b */
            public final void mo21316b(Object obj) {
                if (RoverDoing.this.f31674d == null || RoverDoing.this.f31674d.getRoverIsPost() != 1) {
                    return;
                }
                RoverDoing.m21319b(RoverDoing.this);
            }
        }, this.f31672a);
    }

    /* renamed from: b */
    static /* synthetic */ void m21319b(RoverDoing roverDoing) {
        if (roverDoing.f31675e != null) {
            ReportController reportController = new ReportController(roverDoing.f31675e);
            RoverReportResponseHandler roverReportResponseHandler = new RoverReportResponseHandler() { // from class: com.mbridge.msdk.rover.c.2
                @Override // com.mbridge.msdk.rover.RoverReportResponseHandler
                /* renamed from: a */
                public final void mo21305a(String str) {
                }

                @Override // com.mbridge.msdk.rover.RoverReportResponseHandler
                /* renamed from: f */
                public final void mo21304f() {
                }
            };
            if (Looper.myLooper() != Looper.getMainLooper()) {
                Looper.prepare();
            }
            reportController.m22102a(roverDoing.f31674d, roverDoing.f31673c, roverReportResponseHandler);
            if (Looper.myLooper() != Looper.getMainLooper()) {
                Looper.loop();
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m21320a(RoverDoing roverDoing, String str, int i, int i2, int i3, String str2, String str3) {
        try {
            if (roverDoing.f31676f == null) {
                roverDoing.f31676f = new HashMap();
            }
            if (roverDoing.f31676f.containsKey(str)) {
                return;
            }
            roverDoing.f31676f.put(str, null);
            if (TextUtils.isEmpty(str) || !str.contains("data:*/*;charset=utf-8;base64")) {
                RoverReportData roverReportData = new RoverReportData();
                roverReportData.m21310a(str);
                roverReportData.m21311a(i);
                roverReportData.m21309b(i2);
                roverReportData.m21307c(i3);
                roverReportData.m21308b(SameBase64Tool.m21813a(str2));
                roverReportData.m21306c(str3 == null ? "" : SameBase64Tool.m21813a(str3));
                List<RoverReportData> list = roverDoing.f31673c;
                if (list != null) {
                    list.add(roverReportData);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                roverDoing.f31673c = arrayList;
                arrayList.add(roverReportData);
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}

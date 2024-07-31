package com.mbridge.msdk.click;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.mbridge.msdk.click.CommonJumpLoader;
import com.mbridge.msdk.click.JavaHttpSpider;
import com.mbridge.msdk.click.WebViewSpider;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.p478e.CommonTask;
import com.mbridge.msdk.foundation.same.p478e.CommonTaskLoader;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameSDKTool;
import com.mbridge.msdk.rover.RoverConstans;
import com.mbridge.msdk.rover.RoverListener;
import java.util.concurrent.Semaphore;

/* renamed from: com.mbridge.msdk.click.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class WebViewSpiderLoader extends CommonLoader implements CommonTask.InterfaceC11325b {

    /* renamed from: c */
    private CommonLoaderListener f30123c;

    /* renamed from: d */
    private CommonJumpLoader.JumpLoaderResult f30124d;

    /* renamed from: f */
    private boolean f30126f;

    /* renamed from: g */
    private Context f30127g;

    /* renamed from: h */
    private CommonTaskLoader f30128h;

    /* renamed from: i */
    private JavaHttpSpider.C11224a f30129i;

    /* renamed from: k */
    private boolean f30131k;

    /* renamed from: a */
    private boolean f30121a = false;

    /* renamed from: b */
    private long f30122b = 0;

    /* renamed from: e */
    private boolean f30125e = true;

    /* renamed from: j */
    private Handler f30130j = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WebViewSpiderLoader.java */
    /* renamed from: com.mbridge.msdk.click.h$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public class C11232a extends CommonTask {

        /* renamed from: c */
        private final Context f30135c;

        /* renamed from: d */
        private String f30136d;

        /* renamed from: e */
        private String f30137e;

        /* renamed from: f */
        private String f30138f;

        /* renamed from: g */
        private String f30139g;

        /* renamed from: h */
        private RoverListener f30140h;

        /* renamed from: i */
        private CampaignEx f30141i;

        /* renamed from: j */
        private boolean f30142j;

        /* renamed from: k */
        private boolean f30143k;

        /* renamed from: l */
        private int f30144l;

        /* renamed from: b */
        private final Semaphore f30134b = new Semaphore(0);

        /* renamed from: m */
        private WebViewSpider.InterfaceC11230a f30145m = new WebViewSpider.InterfaceC11230a() { // from class: com.mbridge.msdk.click.h.a.1
            @Override // com.mbridge.msdk.click.WebViewSpider.InterfaceC11230a
            /* renamed from: a */
            public final boolean mo23007a(String str) {
                boolean m23013a = C11232a.this.m23013a(str);
                C11232a.m23014a(C11232a.this, false, true, str, "");
                if (m23013a) {
                    m23009a();
                }
                return m23013a;
            }

            @Override // com.mbridge.msdk.click.WebViewSpider.InterfaceC11230a
            /* renamed from: b */
            public final boolean mo23005b(String str) {
                boolean m23013a = C11232a.this.m23013a(str);
                C11232a.m23014a(C11232a.this, false, true, str, "");
                if (m23013a) {
                    C11232a.m23014a(C11232a.this, true, true, str, "");
                    m23009a();
                }
                return m23013a;
            }

            @Override // com.mbridge.msdk.click.WebViewSpider.InterfaceC11230a
            /* renamed from: c */
            public final boolean mo23004c(String str) {
                C11232a.m23014a(C11232a.this, false, false, str, "");
                return false;
            }

            @Override // com.mbridge.msdk.click.WebViewSpider.InterfaceC11230a
            /* renamed from: a */
            public final void mo23006a(String str, boolean z, String str2) {
                C11232a.this.m23013a(str);
                WebViewSpiderLoader.this.f30124d.setContent(str2);
                C11232a.m23014a(C11232a.this, true, false, str, "timeout");
                m23009a();
            }

            /* renamed from: a */
            private void m23009a() {
                synchronized (WebViewSpiderLoader.this) {
                    WebViewSpiderLoader.this.f30124d.setSuccess(true);
                    C11232a.m23016a(C11232a.this);
                }
            }

            @Override // com.mbridge.msdk.click.WebViewSpider.InterfaceC11230a
            /* renamed from: a */
            public final void mo23008a(int i, String str, String str2, String str3) {
                if (!TextUtils.isEmpty(str2)) {
                    WebViewSpiderLoader.this.f30124d.setExceptionMsg(str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    WebViewSpiderLoader.this.f30124d.setContent(str3);
                }
                C11232a.this.m23013a(str);
                C11232a.m23014a(C11232a.this, true, false, str, str2);
                m23009a();
            }
        };

        public C11232a(Context context, String str, String str2, String str3, String str4, RoverListener roverListener, CampaignEx campaignEx, boolean z, boolean z2, int i) {
            this.f30135c = context;
            this.f30136d = str;
            this.f30137e = str2;
            this.f30138f = str3;
            this.f30139g = str4;
            this.f30140h = roverListener;
            this.f30141i = campaignEx;
            this.f30142j = z;
            this.f30143k = z2;
            this.f30144l = i;
        }

        /* renamed from: b */
        private boolean m23011b(String str) {
            return !URLUtil.isNetworkUrl(str);
        }

        /* renamed from: c */
        private boolean m23010c(String str) {
            return !TextUtils.isEmpty(str) && str.toLowerCase().contains("apk");
        }

        @Override // com.mbridge.msdk.foundation.same.p478e.CommonTask
        public final void cancelTask() {
        }

        @Override // com.mbridge.msdk.foundation.same.p478e.CommonTask
        public final void pauseTask(boolean z) {
        }

        @Override // com.mbridge.msdk.foundation.same.p478e.CommonTask
        public final void runTask() {
            if (WebViewSpiderLoader.this.f30123c != null) {
                WebViewSpiderLoader.this.f30123c.mo21318a(null);
            }
            WebViewSpiderLoader.this.f30124d = new CommonJumpLoader.JumpLoaderResult();
            WebViewSpiderLoader.this.f30124d.setUrl(this.f30136d);
            WebViewSpiderLoader.this.f30124d = m23012a(this.f30136d, this.f30142j, this.f30143k, this.f30141i, this.f30144l);
            if (!TextUtils.isEmpty(WebViewSpiderLoader.this.f30124d.getExceptionMsg())) {
                WebViewSpiderLoader.this.f30124d.setSuccess(true);
            }
            if (WebViewSpiderLoader.this.f30125e && WebViewSpiderLoader.this.f30124d.isSuccess()) {
                if (WebViewSpiderLoader.this.f30129i != null) {
                    WebViewSpiderLoader.this.f30124d.setStatusCode(WebViewSpiderLoader.this.f30129i.f30086f);
                }
                if (!m23010c(WebViewSpiderLoader.this.f30124d.getUrl()) && !SameSDKTool.C11399a.m22026a(WebViewSpiderLoader.this.f30124d.getUrl()) && 200 == WebViewSpiderLoader.this.f30129i.f30086f && !TextUtils.isEmpty(WebViewSpiderLoader.this.f30124d.getContent()) && !WebViewSpiderLoader.this.f30124d.getContent().contains("EXCEPTION_CAMPAIGN_NOT_ACTIVE")) {
                    WebViewSpiderLoader.this.f30124d.setType(2);
                    if (!TextUtils.isEmpty(WebViewSpiderLoader.this.f30124d.getContent())) {
                        Log.e("302", "startWebViewHtmlParser");
                        new WebViewSpider(WebViewSpiderLoader.this.f30131k).m23049a(this.f30137e, this.f30138f, this.f30139g, this.f30135c, WebViewSpiderLoader.this.f30124d.getUrl(), WebViewSpiderLoader.this.f30124d.getContent(), this.f30145m);
                        SameLogTool.m21733d("302", "startWebViewHtmlParser");
                    } else {
                        SameLogTool.m21738a("302", "startWebViewSpider");
                        try {
                            new WebViewSpider(WebViewSpiderLoader.this.f30131k).m23050a(this.f30137e, this.f30138f, this.f30139g, this.f30135c, WebViewSpiderLoader.this.f30124d.getUrl(), this.f30145m);
                        } catch (Exception unused) {
                            SameLogTool.m21733d("TAG", "webview spider start error");
                        }
                    }
                    this.f30134b.acquireUninterruptibly();
                    return;
                }
                RoverListener roverListener = this.f30140h;
                if (roverListener != null) {
                    roverListener.mo21315a(WebViewSpiderLoader.this.f30124d.getUrl(), RoverConstans.f31661a, 0, 0, "", "");
                }
                if (WebViewSpiderLoader.this.f30129i != null) {
                    WebViewSpiderLoader.this.f30124d.setType(1);
                    WebViewSpiderLoader.this.f30124d.setExceptionMsg(WebViewSpiderLoader.this.f30129i.f30088h);
                    WebViewSpiderLoader.this.f30124d.setStatusCode(WebViewSpiderLoader.this.f30129i.f30086f);
                    WebViewSpiderLoader.this.f30124d.setHeader(WebViewSpiderLoader.this.f30129i.m23060a());
                    WebViewSpiderLoader.this.f30124d.setContent(WebViewSpiderLoader.this.f30129i.f30087g);
                }
                m23013a(WebViewSpiderLoader.this.f30124d.getUrl());
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:109:0x026b A[EDGE_INSN: B:109:0x026b->B:96:0x026b ?: BREAK  , SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private com.mbridge.msdk.click.CommonJumpLoader.JumpLoaderResult m23012a(java.lang.String r20, boolean r21, boolean r22, com.mbridge.msdk.foundation.entity.CampaignEx r23, int r24) {
            /*
                Method dump skipped, instructions count: 620
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.WebViewSpiderLoader.C11232a.m23012a(java.lang.String, boolean, boolean, com.mbridge.msdk.foundation.entity.CampaignEx, int):com.mbridge.msdk.click.CommonJumpLoader$JumpLoaderResult");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public boolean m23013a(String str) {
            CampaignEx campaignEx = this.f30141i;
            if (campaignEx != null) {
                campaignEx.getLinkType();
            }
            if (SameSDKTool.C11399a.m22026a(str)) {
                WebViewSpiderLoader.this.f30124d.setCode(1);
                WebViewSpiderLoader.this.f30124d.setUrl(str);
                WebViewSpiderLoader.this.f30124d.setjumpDone(true);
                return true;
            } else if (m23010c(str)) {
                WebViewSpiderLoader.this.f30124d.setCode(3);
                WebViewSpiderLoader.this.f30124d.setUrl(str);
                WebViewSpiderLoader.this.f30124d.setjumpDone(true);
                return true;
            } else {
                WebViewSpiderLoader.this.f30124d.setCode(2);
                WebViewSpiderLoader.this.f30124d.setUrl(str);
                return false;
            }
        }

        /* renamed from: a */
        static /* synthetic */ void m23014a(C11232a c11232a, boolean z, boolean z2, String str, String str2) {
            int i;
            long j = WebViewSpiderLoader.this.f30122b;
            if (j == 0) {
                WebViewSpiderLoader.this.f30122b = System.currentTimeMillis();
                i = 0;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                WebViewSpiderLoader.this.f30122b = currentTimeMillis;
                i = (int) (currentTimeMillis - j);
            }
            if (!z) {
                RoverListener roverListener = c11232a.f30140h;
                if (roverListener != null) {
                    roverListener.mo21314b(str, RoverConstans.f31662b, i, 0, "", str2);
                }
            } else if (z2) {
                if (c11232a.f30140h == null || WebViewSpiderLoader.this.f30121a) {
                    return;
                }
                WebViewSpiderLoader.this.f30121a = true;
                c11232a.f30140h.mo21315a(str, RoverConstans.f31662b, i, 0, "", str2);
            } else if (c11232a.f30140h == null || WebViewSpiderLoader.this.f30121a) {
            } else {
                WebViewSpiderLoader.this.f30121a = true;
                c11232a.f30140h.mo21313c(str, RoverConstans.f31662b, i, 0, "", str2);
            }
        }

        /* renamed from: a */
        static /* synthetic */ void m23016a(C11232a c11232a) {
            c11232a.f30134b.release();
        }
    }

    public WebViewSpiderLoader(Context context, boolean z) {
        this.f30127g = context;
        this.f30131k = z;
        if (z) {
            this.f30128h = new CommonTaskLoader(context, 2);
        } else {
            this.f30128h = new CommonTaskLoader(context);
        }
    }

    /* renamed from: a */
    public final void m23024a(String str, CommonLoaderListener commonLoaderListener, boolean z, String str2, String str3, String str4, RoverListener roverListener, CampaignEx campaignEx, boolean z2, boolean z3, int i) {
        this.f30123c = commonLoaderListener;
        this.f30126f = z;
        this.f30128h.m22314a(new C11232a(this.f30127g, str, str2, str3, str4, roverListener, campaignEx, z2, z3, i), this);
    }

    @Override // com.mbridge.msdk.click.CommonLoader
    /* renamed from: a */
    public final void mo23030a() {
        this.f30125e = false;
    }

    @Override // com.mbridge.msdk.foundation.same.p478e.CommonTask.InterfaceC11325b
    /* renamed from: a */
    public final void mo22311a(CommonTask.EnumC11324a enumC11324a) {
        if (enumC11324a == CommonTask.EnumC11324a.FINISH && this.f30125e) {
            this.f30130j.post(new Runnable() { // from class: com.mbridge.msdk.click.h.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (WebViewSpiderLoader.this.f30123c != null) {
                        if (WebViewSpiderLoader.this.f30124d.isSuccess()) {
                            WebViewSpiderLoader.this.f30123c.mo21316b(WebViewSpiderLoader.this.f30124d);
                        } else {
                            WebViewSpiderLoader.this.f30123c.mo21317a(WebViewSpiderLoader.this.f30124d, WebViewSpiderLoader.this.f30124d.getMsg());
                        }
                    }
                }
            });
        }
    }
}

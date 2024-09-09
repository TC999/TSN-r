package com.mbridge.msdk.click;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.mbridge.msdk.click.CommonJumpLoader;
import com.mbridge.msdk.click.f;
import com.mbridge.msdk.click.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.e.a;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.x;
import java.util.concurrent.Semaphore;

/* compiled from: WebViewSpiderLoader.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class h extends d implements a.b {

    /* renamed from: c  reason: collision with root package name */
    private e f38950c;

    /* renamed from: d  reason: collision with root package name */
    private CommonJumpLoader.JumpLoaderResult f38951d;

    /* renamed from: f  reason: collision with root package name */
    private boolean f38953f;

    /* renamed from: g  reason: collision with root package name */
    private Context f38954g;

    /* renamed from: h  reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.e.b f38955h;

    /* renamed from: i  reason: collision with root package name */
    private f.a f38956i;

    /* renamed from: k  reason: collision with root package name */
    private boolean f38958k;

    /* renamed from: a  reason: collision with root package name */
    private boolean f38948a = false;

    /* renamed from: b  reason: collision with root package name */
    private long f38949b = 0;

    /* renamed from: e  reason: collision with root package name */
    private boolean f38952e = true;

    /* renamed from: j  reason: collision with root package name */
    private Handler f38957j = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WebViewSpiderLoader.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public class a extends com.mbridge.msdk.foundation.same.e.a {

        /* renamed from: c  reason: collision with root package name */
        private final Context f38962c;

        /* renamed from: d  reason: collision with root package name */
        private String f38963d;

        /* renamed from: e  reason: collision with root package name */
        private String f38964e;

        /* renamed from: f  reason: collision with root package name */
        private String f38965f;

        /* renamed from: g  reason: collision with root package name */
        private String f38966g;

        /* renamed from: h  reason: collision with root package name */
        private com.mbridge.msdk.rover.d f38967h;

        /* renamed from: i  reason: collision with root package name */
        private CampaignEx f38968i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f38969j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f38970k;

        /* renamed from: l  reason: collision with root package name */
        private int f38971l;

        /* renamed from: b  reason: collision with root package name */
        private final Semaphore f38961b = new Semaphore(0);

        /* renamed from: m  reason: collision with root package name */
        private g.a f38972m = new g.a() { // from class: com.mbridge.msdk.click.h.a.1
            @Override // com.mbridge.msdk.click.g.a
            public final boolean a(String str) {
                boolean a4 = a.this.a(str);
                a.a(a.this, false, true, str, "");
                if (a4) {
                    a();
                }
                return a4;
            }

            @Override // com.mbridge.msdk.click.g.a
            public final boolean b(String str) {
                boolean a4 = a.this.a(str);
                a.a(a.this, false, true, str, "");
                if (a4) {
                    a.a(a.this, true, true, str, "");
                    a();
                }
                return a4;
            }

            @Override // com.mbridge.msdk.click.g.a
            public final boolean c(String str) {
                a.a(a.this, false, false, str, "");
                return false;
            }

            @Override // com.mbridge.msdk.click.g.a
            public final void a(String str, boolean z3, String str2) {
                a.this.a(str);
                h.this.f38951d.setContent(str2);
                a.a(a.this, true, false, str, "timeout");
                a();
            }

            private void a() {
                synchronized (h.this) {
                    h.this.f38951d.setSuccess(true);
                    a.a(a.this);
                }
            }

            @Override // com.mbridge.msdk.click.g.a
            public final void a(int i4, String str, String str2, String str3) {
                if (!TextUtils.isEmpty(str2)) {
                    h.this.f38951d.setExceptionMsg(str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    h.this.f38951d.setContent(str3);
                }
                a.this.a(str);
                a.a(a.this, true, false, str, str2);
                a();
            }
        };

        public a(Context context, String str, String str2, String str3, String str4, com.mbridge.msdk.rover.d dVar, CampaignEx campaignEx, boolean z3, boolean z4, int i4) {
            this.f38962c = context;
            this.f38963d = str;
            this.f38964e = str2;
            this.f38965f = str3;
            this.f38966g = str4;
            this.f38967h = dVar;
            this.f38968i = campaignEx;
            this.f38969j = z3;
            this.f38970k = z4;
            this.f38971l = i4;
        }

        private boolean b(String str) {
            return !URLUtil.isNetworkUrl(str);
        }

        private boolean c(String str) {
            return !TextUtils.isEmpty(str) && str.toLowerCase().contains("apk");
        }

        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void cancelTask() {
        }

        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void pauseTask(boolean z3) {
        }

        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void runTask() {
            if (h.this.f38950c != null) {
                h.this.f38950c.a(null);
            }
            h.this.f38951d = new CommonJumpLoader.JumpLoaderResult();
            h.this.f38951d.setUrl(this.f38963d);
            h.this.f38951d = a(this.f38963d, this.f38969j, this.f38970k, this.f38968i, this.f38971l);
            if (!TextUtils.isEmpty(h.this.f38951d.getExceptionMsg())) {
                h.this.f38951d.setSuccess(true);
            }
            if (h.this.f38952e && h.this.f38951d.isSuccess()) {
                if (h.this.f38956i != null) {
                    h.this.f38951d.setStatusCode(h.this.f38956i.f38913f);
                }
                if (!c(h.this.f38951d.getUrl()) && !ab.a.a(h.this.f38951d.getUrl()) && 200 == h.this.f38956i.f38913f && !TextUtils.isEmpty(h.this.f38951d.getContent()) && !h.this.f38951d.getContent().contains("EXCEPTION_CAMPAIGN_NOT_ACTIVE")) {
                    h.this.f38951d.setType(2);
                    if (!TextUtils.isEmpty(h.this.f38951d.getContent())) {
                        Log.e("302", "startWebViewHtmlParser");
                        new g(h.this.f38958k).a(this.f38964e, this.f38965f, this.f38966g, this.f38962c, h.this.f38951d.getUrl(), h.this.f38951d.getContent(), this.f38972m);
                        x.d("302", "startWebViewHtmlParser");
                    } else {
                        x.a("302", "startWebViewSpider");
                        try {
                            new g(h.this.f38958k).a(this.f38964e, this.f38965f, this.f38966g, this.f38962c, h.this.f38951d.getUrl(), this.f38972m);
                        } catch (Exception unused) {
                            x.d("TAG", "webview spider start error");
                        }
                    }
                    this.f38961b.acquireUninterruptibly();
                    return;
                }
                com.mbridge.msdk.rover.d dVar = this.f38967h;
                if (dVar != null) {
                    dVar.a(h.this.f38951d.getUrl(), com.mbridge.msdk.rover.a.f40432a, 0, 0, "", "");
                }
                if (h.this.f38956i != null) {
                    h.this.f38951d.setType(1);
                    h.this.f38951d.setExceptionMsg(h.this.f38956i.f38915h);
                    h.this.f38951d.setStatusCode(h.this.f38956i.f38913f);
                    h.this.f38951d.setHeader(h.this.f38956i.a());
                    h.this.f38951d.setContent(h.this.f38956i.f38914g);
                }
                a(h.this.f38951d.getUrl());
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:109:0x026b A[EDGE_INSN: B:109:0x026b->B:96:0x026b ?: BREAK  , SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private com.mbridge.msdk.click.CommonJumpLoader.JumpLoaderResult a(java.lang.String r20, boolean r21, boolean r22, com.mbridge.msdk.foundation.entity.CampaignEx r23, int r24) {
            /*
                Method dump skipped, instructions count: 620
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.h.a.a(java.lang.String, boolean, boolean, com.mbridge.msdk.foundation.entity.CampaignEx, int):com.mbridge.msdk.click.CommonJumpLoader$JumpLoaderResult");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(String str) {
            CampaignEx campaignEx = this.f38968i;
            if (campaignEx != null) {
                campaignEx.getLinkType();
            }
            if (ab.a.a(str)) {
                h.this.f38951d.setCode(1);
                h.this.f38951d.setUrl(str);
                h.this.f38951d.setjumpDone(true);
                return true;
            } else if (c(str)) {
                h.this.f38951d.setCode(3);
                h.this.f38951d.setUrl(str);
                h.this.f38951d.setjumpDone(true);
                return true;
            } else {
                h.this.f38951d.setCode(2);
                h.this.f38951d.setUrl(str);
                return false;
            }
        }

        static /* synthetic */ void a(a aVar, boolean z3, boolean z4, String str, String str2) {
            int i4;
            long j4 = h.this.f38949b;
            if (j4 == 0) {
                h.this.f38949b = System.currentTimeMillis();
                i4 = 0;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                h.this.f38949b = currentTimeMillis;
                i4 = (int) (currentTimeMillis - j4);
            }
            if (!z3) {
                com.mbridge.msdk.rover.d dVar = aVar.f38967h;
                if (dVar != null) {
                    dVar.b(str, com.mbridge.msdk.rover.a.f40433b, i4, 0, "", str2);
                }
            } else if (z4) {
                if (aVar.f38967h == null || h.this.f38948a) {
                    return;
                }
                h.this.f38948a = true;
                aVar.f38967h.a(str, com.mbridge.msdk.rover.a.f40433b, i4, 0, "", str2);
            } else if (aVar.f38967h == null || h.this.f38948a) {
            } else {
                h.this.f38948a = true;
                aVar.f38967h.c(str, com.mbridge.msdk.rover.a.f40433b, i4, 0, "", str2);
            }
        }

        static /* synthetic */ void a(a aVar) {
            aVar.f38961b.release();
        }
    }

    public h(Context context, boolean z3) {
        this.f38954g = context;
        this.f38958k = z3;
        if (z3) {
            this.f38955h = new com.mbridge.msdk.foundation.same.e.b(context, 2);
        } else {
            this.f38955h = new com.mbridge.msdk.foundation.same.e.b(context);
        }
    }

    public final void a(String str, e eVar, boolean z3, String str2, String str3, String str4, com.mbridge.msdk.rover.d dVar, CampaignEx campaignEx, boolean z4, boolean z5, int i4) {
        this.f38950c = eVar;
        this.f38953f = z3;
        this.f38955h.a(new a(this.f38954g, str, str2, str3, str4, dVar, campaignEx, z4, z5, i4), this);
    }

    @Override // com.mbridge.msdk.click.d
    public final void a() {
        this.f38952e = false;
    }

    @Override // com.mbridge.msdk.foundation.same.e.a.b
    public final void a(a.EnumC0740a enumC0740a) {
        if (enumC0740a == a.EnumC0740a.FINISH && this.f38952e) {
            this.f38957j.post(new Runnable() { // from class: com.mbridge.msdk.click.h.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (h.this.f38950c != null) {
                        if (h.this.f38951d.isSuccess()) {
                            h.this.f38950c.b(h.this.f38951d);
                        } else {
                            h.this.f38950c.a(h.this.f38951d, h.this.f38951d.getMsg());
                        }
                    }
                }
            });
        }
    }
}

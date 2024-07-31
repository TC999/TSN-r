package com.kwad.sdk.core.network.p405b;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.C10424i;
import com.kwad.sdk.core.network.C10434j;
import com.kwad.sdk.core.network.InterfaceC10435k;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.p438ip.direct.C10808a;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Random;

/* renamed from: com.kwad.sdk.core.network.b.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10414d implements InterfaceC10412b {
    private static boolean awN = true;
    public static double awO = 1.0d;
    private static volatile boolean awS = false;
    private static String awT = "";
    private long awP = -1;
    private long awQ = -1;
    private long awR = -1;
    private C10434j awU = new C10434j();

    public C10414d() {
        awO = new Random().nextDouble();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.p405b.InterfaceC10412b
    /* renamed from: Ek */
    public C10414d mo26154Ec() {
        this.awU.avY = SystemClock.elapsedRealtime();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.p405b.InterfaceC10412b
    /* renamed from: El */
    public C10414d mo26153Ed() {
        this.awQ = SystemClock.elapsedRealtime();
        m26119ec("this.responseReceiveTime:" + this.awQ);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.p405b.InterfaceC10412b
    /* renamed from: Em */
    public C10414d mo26152Ee() {
        if (m26137al(this.awP) && m26137al(this.awQ)) {
            this.awU.awf = this.awQ - this.awP;
            m26119ec("info.waiting_response_cost:" + this.awU.awf);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.p405b.InterfaceC10412b
    /* renamed from: En */
    public C10414d mo26151Ef() {
        if (m26137al(this.awU.avY)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.awP = elapsedRealtime;
            C10434j c10434j = this.awU;
            c10434j.avS = elapsedRealtime - c10434j.avY;
            if (m26137al(c10434j.avQ)) {
                C10434j c10434j2 = this.awU;
                c10434j2.avR = c10434j2.avS - c10434j2.avQ;
            }
            m26119ec("info.request_create_cost:" + this.awU.avS);
            m26119ec("info.requestAddParamsCost:" + this.awU.avR);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.p405b.InterfaceC10412b
    /* renamed from: Eo */
    public C10414d mo26149Eh() {
        if (m26137al(this.awQ)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.awR = elapsedRealtime;
            this.awU.awd = elapsedRealtime - this.awQ;
            m26119ec("info.response_parse_cost:" + this.awU.awd);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.p405b.InterfaceC10412b
    /* renamed from: Ep */
    public C10414d mo26148Ei() {
        if (m26137al(this.awR)) {
            this.awU.awk = SystemClock.elapsedRealtime() - this.awR;
            m26141Eq();
            m26119ec("info.response_done_cost:" + this.awU.awk);
        }
        return this;
    }

    /* renamed from: Eq */
    private void m26141Eq() {
        C10434j c10434j = this.awU;
        if (c10434j == null || c10434j.awj != 1 || m26134ao(c10434j.awk)) {
            return;
        }
        this.awU.awk = -1L;
    }

    /* renamed from: Er */
    private C10414d m26140Er() {
        this.awU.awn = (int) C10808a.m24775Ix();
        this.awU.awo = (int) C10808a.m24774Iy();
        this.awU.awp = (int) C10808a.m24773Iz();
        return this;
    }

    /* renamed from: Es */
    private void m26139Es() {
        C10424i m26132c = m26132c(this.awU);
        InterfaceC10435k interfaceC10435k = (InterfaceC10435k) ServiceProvider.get(InterfaceC10435k.class);
        if (interfaceC10435k != null) {
            interfaceC10435k.mo24877a(m26132c);
        }
        C10331c.m26254d("NetworkMonitorRecorder", "reportError" + m26132c.toJson().toString());
    }

    /* renamed from: al */
    private static boolean m26137al(long j) {
        return j != -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.p405b.InterfaceC10412b
    /* renamed from: am */
    public C10414d mo26138ak(long j) {
        this.awU.awe = j;
        m26119ec("responseSize:" + j);
        return this;
    }

    /* renamed from: an */
    private C10414d m26135an(long j) {
        this.awU.awg = j;
        m26119ec("totalCost:" + j);
        return this;
    }

    /* renamed from: ao */
    private static boolean m26134ao(long j) {
        return j >= 50;
    }

    /* renamed from: c */
    private static boolean m26133c(@NonNull C10424i c10424i) {
        if (TextUtils.isEmpty(c10424i.url)) {
            return true;
        }
        String lowerCase = c10424i.url.toLowerCase();
        return lowerCase.contains("beta") || lowerCase.contains("test") || lowerCase.contains("staging");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.p405b.InterfaceC10412b
    /* renamed from: dj */
    public C10414d mo26128df(int i) {
        this.awU.httpCode = i;
        m26119ec("http_code:" + i);
        return this;
    }

    /* renamed from: dk */
    private C10414d m26123dk(int i) {
        this.awU.awj = i;
        m26119ec("hasData:" + i);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.p405b.InterfaceC10412b
    /* renamed from: dl */
    public C10414d mo26126dh(int i) {
        this.awU.result = i;
        m26119ec("result:" + i);
        return this;
    }

    /* renamed from: ec */
    private static void m26119ec(String str) {
        if (awN) {
            C10331c.m26254d("NetworkMonitorRecorder", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.p405b.InterfaceC10412b
    /* renamed from: ed */
    public C10414d mo26131dX(String str) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        this.awU.url = str;
        if (str.contains("?")) {
            String[] split = str.split("\\?");
            if (split.length > 0) {
                str = split[0];
            }
        }
        if (!TextUtils.isEmpty(str)) {
            m26119ec("url:" + str);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.p405b.InterfaceC10412b
    /* renamed from: ee */
    public C10414d mo26130dY(String str) {
        try {
            Uri parse = Uri.parse(str);
            this.awU.host = parse.getHost();
            m26119ec("host:" + this.awU.host);
        } catch (Exception e) {
            C10331c.m26250e("NetworkMonitorRecorder", Log.getStackTraceString(e));
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.p405b.InterfaceC10412b
    /* renamed from: ef */
    public C10414d mo26129dZ(String str) {
        this.awU.errorMsg = str;
        m26119ec(str);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.p405b.InterfaceC10412b
    /* renamed from: eg */
    public C10414d mo26121ea(String str) {
        this.awU.avO = str;
        m26119ec("reqType:" + str);
        m26113ei(C10808a.m24776Iw());
        m26140Er();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.p405b.InterfaceC10412b
    /* renamed from: eh */
    public C10414d mo26120eb(String str) {
        this.awU.awi = str;
        m26119ec("requestId:" + str);
        return this;
    }

    /* renamed from: ei */
    private C10414d m26113ei(String str) {
        this.awU.awl = str;
        return this;
    }

    @Override // com.kwad.sdk.core.network.p405b.InterfaceC10412b
    /* renamed from: Eg */
    public final InterfaceC10412b mo26150Eg() {
        if (m26137al(this.awU.avY)) {
            this.awU.avQ = SystemClock.elapsedRealtime() - this.awU.avY;
            m26119ec("info.request_prepare_cost:" + this.awU.avQ);
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.p405b.InterfaceC10412b
    /* renamed from: dg */
    public final /* synthetic */ InterfaceC10412b mo26127dg(int i) {
        return m26123dk(1);
    }

    @Override // com.kwad.sdk.core.network.p405b.InterfaceC10412b
    /* renamed from: di */
    public final InterfaceC10412b mo26125di(int i) {
        C10434j c10434j = this.awU;
        c10434j.awm = i;
        if (i != 0) {
            c10434j.avP = 1;
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.p405b.InterfaceC10412b
    public final void report() {
        if (m26133c((C10424i) this.awU)) {
            return;
        }
        if (this.awU.httpCode != 200) {
            m26139Es();
            return;
        }
        long elapsedRealtime = m26137al(this.awU.avY) ? SystemClock.elapsedRealtime() - this.awU.avY : -1L;
        m26135an(elapsedRealtime);
        if (elapsedRealtime > 30000 || elapsedRealtime <= -1) {
            return;
        }
        InterfaceC10435k interfaceC10435k = (InterfaceC10435k) ServiceProvider.get(InterfaceC10435k.class);
        if (interfaceC10435k != null) {
            interfaceC10435k.mo24876a(this.awU);
        }
        m26119ec("report normal" + this.awU.toString());
    }

    /* renamed from: c */
    private static C10424i m26132c(C10434j c10434j) {
        C10424i c10424i = new C10424i();
        c10424i.errorMsg = c10434j.errorMsg;
        c10424i.host = c10434j.host;
        c10424i.httpCode = c10434j.httpCode;
        c10424i.avO = c10434j.avO;
        c10424i.url = c10434j.url;
        c10424i.avP = c10434j.avP;
        return c10424i;
    }
}

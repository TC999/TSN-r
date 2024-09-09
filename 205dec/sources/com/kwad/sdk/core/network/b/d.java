package com.kwad.sdk.core.network.b;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d implements b {
    private static boolean awN = true;
    public static double awO = 1.0d;
    private static volatile boolean awS = false;
    private static String awT = "";
    private long awP = -1;
    private long awQ = -1;
    private long awR = -1;
    private j awU = new j();

    public d() {
        awO = new Random().nextDouble();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: Ek */
    public d Ec() {
        this.awU.avY = SystemClock.elapsedRealtime();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: El */
    public d Ed() {
        this.awQ = SystemClock.elapsedRealtime();
        ec("this.responseReceiveTime:" + this.awQ);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: Em */
    public d Ee() {
        if (al(this.awP) && al(this.awQ)) {
            this.awU.awf = this.awQ - this.awP;
            ec("info.waiting_response_cost:" + this.awU.awf);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: En */
    public d Ef() {
        if (al(this.awU.avY)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.awP = elapsedRealtime;
            j jVar = this.awU;
            jVar.avS = elapsedRealtime - jVar.avY;
            if (al(jVar.avQ)) {
                j jVar2 = this.awU;
                jVar2.avR = jVar2.avS - jVar2.avQ;
            }
            ec("info.request_create_cost:" + this.awU.avS);
            ec("info.requestAddParamsCost:" + this.awU.avR);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: Eo */
    public d Eh() {
        if (al(this.awQ)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.awR = elapsedRealtime;
            this.awU.awd = elapsedRealtime - this.awQ;
            ec("info.response_parse_cost:" + this.awU.awd);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: Ep */
    public d Ei() {
        if (al(this.awR)) {
            this.awU.awk = SystemClock.elapsedRealtime() - this.awR;
            Eq();
            ec("info.response_done_cost:" + this.awU.awk);
        }
        return this;
    }

    private void Eq() {
        j jVar = this.awU;
        if (jVar == null || jVar.awj != 1 || ao(jVar.awk)) {
            return;
        }
        this.awU.awk = -1L;
    }

    private d Er() {
        this.awU.awn = (int) com.kwad.sdk.ip.direct.a.Ix();
        this.awU.awo = (int) com.kwad.sdk.ip.direct.a.Iy();
        this.awU.awp = (int) com.kwad.sdk.ip.direct.a.Iz();
        return this;
    }

    private void Es() {
        i c4 = c(this.awU);
        k kVar = (k) ServiceProvider.get(k.class);
        if (kVar != null) {
            kVar.a(c4);
        }
        com.kwad.sdk.core.e.c.d("NetworkMonitorRecorder", "reportError" + c4.toJson().toString());
    }

    private static boolean al(long j4) {
        return j4 != -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: am */
    public d ak(long j4) {
        this.awU.awe = j4;
        ec("responseSize:" + j4);
        return this;
    }

    private d an(long j4) {
        this.awU.awg = j4;
        ec("totalCost:" + j4);
        return this;
    }

    private static boolean ao(long j4) {
        return j4 >= 50;
    }

    private static boolean c(@NonNull i iVar) {
        if (TextUtils.isEmpty(iVar.url)) {
            return true;
        }
        String lowerCase = iVar.url.toLowerCase();
        return lowerCase.contains("beta") || lowerCase.contains("test") || lowerCase.contains("staging");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: dj */
    public d df(int i4) {
        this.awU.httpCode = i4;
        ec("http_code:" + i4);
        return this;
    }

    private d dk(int i4) {
        this.awU.awj = i4;
        ec("hasData:" + i4);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: dl */
    public d dh(int i4) {
        this.awU.result = i4;
        ec("result:" + i4);
        return this;
    }

    private static void ec(String str) {
        if (awN) {
            com.kwad.sdk.core.e.c.d("NetworkMonitorRecorder", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: ed */
    public d dX(String str) {
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
            ec("url:" + str);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: ee */
    public d dY(String str) {
        try {
            Uri parse = Uri.parse(str);
            this.awU.host = parse.getHost();
            ec("host:" + this.awU.host);
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.e("NetworkMonitorRecorder", Log.getStackTraceString(e4));
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: ef */
    public d dZ(String str) {
        this.awU.errorMsg = str;
        ec(str);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: eg */
    public d ea(String str) {
        this.awU.avO = str;
        ec("reqType:" + str);
        ei(com.kwad.sdk.ip.direct.a.Iw());
        Er();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: eh */
    public d eb(String str) {
        this.awU.awi = str;
        ec("requestId:" + str);
        return this;
    }

    private d ei(String str) {
        this.awU.awl = str;
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final b Eg() {
        if (al(this.awU.avY)) {
            this.awU.avQ = SystemClock.elapsedRealtime() - this.awU.avY;
            ec("info.request_prepare_cost:" + this.awU.avQ);
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final /* synthetic */ b dg(int i4) {
        return dk(1);
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final b di(int i4) {
        j jVar = this.awU;
        jVar.awm = i4;
        if (i4 != 0) {
            jVar.avP = 1;
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final void report() {
        if (c((i) this.awU)) {
            return;
        }
        if (this.awU.httpCode != 200) {
            Es();
            return;
        }
        long elapsedRealtime = al(this.awU.avY) ? SystemClock.elapsedRealtime() - this.awU.avY : -1L;
        an(elapsedRealtime);
        if (elapsedRealtime > PolicyConfig.mServerBusyRetryBaseInternal || elapsedRealtime <= -1) {
            return;
        }
        k kVar = (k) ServiceProvider.get(k.class);
        if (kVar != null) {
            kVar.a(this.awU);
        }
        ec("report normal" + this.awU.toString());
    }

    private static i c(j jVar) {
        i iVar = new i();
        iVar.errorMsg = jVar.errorMsg;
        iVar.host = jVar.host;
        iVar.httpCode = jVar.httpCode;
        iVar.avO = jVar.avO;
        iVar.url = jVar.url;
        iVar.avP = jVar.avP;
        return iVar;
    }
}

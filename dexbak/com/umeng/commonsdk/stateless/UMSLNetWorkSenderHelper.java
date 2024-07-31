package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.EnvelopeManager;
import com.umeng.commonsdk.statistics.common.DataHelper;

/* renamed from: com.umeng.commonsdk.stateless.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UMSLNetWorkSenderHelper {

    /* renamed from: a */
    private String f38907a = "10.0.0.172";

    /* renamed from: b */
    private int f38908b = 80;

    /* renamed from: c */
    private Context f38909c;

    public UMSLNetWorkSenderHelper(Context context) {
        this.f38909c = context;
    }

    /* renamed from: a */
    private void m13868a() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f38909c, "sl_domain_p", "");
        if (TextUtils.isEmpty(imprintProperty)) {
            return;
        }
        UMSLConfig.f38891i = DataHelper.assembleStatelessURL(imprintProperty);
    }

    /* renamed from: b */
    private void m13866b() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f38909c, "sl_domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f38909c, "oversea_sl_domain_p", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            UMSLConfig.f38890h = DataHelper.assembleStatelessURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            UMSLConfig.f38893k = DataHelper.assembleStatelessURL(imprintProperty2);
        }
        UMSLConfig.f38891i = UMSLConfig.f38893k;
        if (TextUtils.isEmpty(EnvelopeManager.f38918b)) {
            return;
        }
        if (EnvelopeManager.f38918b.startsWith("460") || EnvelopeManager.f38918b.startsWith("461")) {
            UMSLConfig.f38891i = UMSLConfig.f38890h;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0126, code lost:
        if (r11 == null) goto L26;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [javax.net.ssl.HttpsURLConnection, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m13867a(byte[] r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.UMSLNetWorkSenderHelper.m13867a(byte[], java.lang.String, java.lang.String, java.lang.String):boolean");
    }
}

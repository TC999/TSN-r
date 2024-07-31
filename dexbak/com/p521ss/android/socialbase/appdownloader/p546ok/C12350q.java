package com.p521ss.android.socialbase.appdownloader.p546ok;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.p521ss.android.socialbase.appdownloader.p543kf.C12315bl;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.appdownloader.ok.q */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12350q extends AbstractC12348ok {

    /* renamed from: n */
    private String f34811n;

    /* renamed from: s */
    private String f34812s;

    public C12350q(Context context, C12534ok c12534ok, String str, String str2, String str3) {
        super(context, c12534ok, str);
        this.f34812s = str2;
        this.f34811n = str3;
    }

    @Override // com.p521ss.android.socialbase.appdownloader.p546ok.InterfaceC12347n
    /* renamed from: a */
    public Intent mo18106a() {
        String str;
        String m17603bl = this.f34808a.m17603bl("s");
        String m18260ok = C12315bl.m18260ok(this.f34808a.m17603bl(SocializeProtocolConstants.PROTOCOL_KEY_AK), m17603bl);
        String m18260ok2 = C12315bl.m18260ok(this.f34808a.m17603bl(CommonNetImpl.f39529AM), m17603bl);
        String m18260ok3 = C12315bl.m18260ok(this.f34808a.m17603bl("an"), m17603bl);
        String str2 = null;
        if (!TextUtils.isEmpty(m18260ok3) && m18260ok3.split(",").length == 2) {
            String[] split = m18260ok3.split(",");
            String m18260ok4 = C12315bl.m18260ok(this.f34808a.m17603bl(CampaignEx.JSON_KEY_AD_AL), m17603bl);
            String m18260ok5 = C12315bl.m18260ok(this.f34808a.m17603bl("ao"), m17603bl);
            if (!TextUtils.isEmpty(m18260ok5) && m18260ok5.split(",").length == 2) {
                String[] split2 = m18260ok5.split(",");
                JSONObject m17588s = this.f34808a.m17588s("download_dir");
                if (m17588s != null) {
                    String optString = m17588s.optString("dir_name");
                    if (!TextUtils.isEmpty(optString) && optString.contains("%s")) {
                        try {
                            str = String.format(optString, this.f34811n);
                        } catch (Throwable unused) {
                            str = this.f34811n;
                        }
                    } else {
                        str = this.f34811n;
                    }
                    str2 = str;
                    if (str2.length() > 255) {
                        str2 = m18260ok4.substring(str2.length() - 255);
                    }
                }
                Intent intent = new Intent(m18260ok);
                intent.putExtra(split2[0], split2[1]);
                intent.putExtra(m18260ok2, this.f34812s);
                intent.putExtra(m18260ok4, str2);
                intent.putExtra(split[0], Integer.parseInt(split[1]));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}

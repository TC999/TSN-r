package com.beizi.fusion.update;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.model.RequestInfo;
import com.beizi.fusion.p072g.AesUtils;
import com.beizi.fusion.p072g.C3112ad;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3137at;
import com.beizi.fusion.p072g.C3144f;
import com.beizi.fusion.p072g.GzipUtil;
import com.beizi.fusion.p072g.HttpUtil;
import com.beizi.fusion.p072g.StringUtil;
import org.json.JSONObject;

/* renamed from: com.beizi.fusion.update.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class HeartSender extends AsyncTask<String, Integer, HeartResponse> {

    /* renamed from: a */
    private Context f11553a;

    /* renamed from: b */
    private HeartScheduler f11554b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HeartSender(Context context, HeartScheduler heartScheduler) {
        try {
            this.f11553a = context;
            this.f11554b = heartScheduler;
            C3137at.m48315a(context, "lastUpdateTime", Long.valueOf(System.currentTimeMillis()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public HeartResponse doInBackground(String... strArr) {
        String m48267a;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (!RequestInfo.getInstance(this.f11553a).isInit) {
                RequestInfo.getInstance(this.f11553a).init();
            }
            C3116af.m48496a("BeiZis", "init start:" + (System.currentTimeMillis() - currentTimeMillis));
            if (strArr != null && strArr.length > 0) {
                m48267a = strArr[0];
            } else {
                m48267a = C3144f.m48267a("aHR0cDovL3Nkay5iZWl6aS5iaXovdjQvYXBpL3Nkay9jZi9wP2FwcElkPV9fQVBQSURfXyZwYWNrYWdlTmFtZT1fX1BBQ0tBR0VOQU1FX18maW5zdGFsbFRpbWU9X19JTlNUQUxMVElNRV9fJnVwZGF0ZVRpbWU9X19VUERBVEVUSU1FX18mbm93VGltZT1fX05PV1RJTUVfXyZhcHBWZXJzaW9uPV9fQVBQVkVSU0lPTl9fJmFwcFZlcnNpb25Db2RlPV9fQVBQVkVSU0lPTkNPREVfXyZzZGtWZXJzaW9uPV9fU0RLVkVSU0lPTl9fJlVzZXJBZ2VudD1fX1VTRVJBR0VOVF9fJnNka1VJRD1fX1NES1VJRF9fJmlkZmE9X19JREZBX18maWRmdj1fX0lERlZfXyZvcz1fX09TX18mcGxhdGZvcm09X19QTEFURk9STV9fJmRldlR5cGU9X19ERVZUWVBFX18mYnJhbmQ9X19CUkFORF9fJm1vZGVsPV9fTU9ERUxfXyZyZXNvbHV0aW9uPV9fUkVTT0xVVElPTl9fJnNjcmVlblNpemU9X19TQ1JFRU5TSVpFX18mbGFuZ3VhZ2U9X19MQU5HVUFHRV9fJmRlbnNpdHk9X19ERU5TSVRZX18mcm9vdD1fX1JPT1RfXyZuZXQ9X19ORVRfXyZpc3A9X19JU1BfXyZiYXR0ZXJ5PV9fQkFUVEVSWV9fJmRldmVsb3Blck1vZGU9X19ERVZFTE9QRVJNT0RFX18maXNVc2I9X19JU1VTQl9fJmlzRGVidWdBcGs9X19JU0RFQlVHQVBLX18maXNEZWJ1Z0Nvbm5lY3RlZD1fX0lTREVCVUdDT05ORUNURURfXyZkZWJ1Z1N5c3RlbT1fX0RFQlVHU1lTVEVNX18maXNXaWZpUHJveHk9X19JU1dJRklQUk9YWV9fJmlzQmx1ZXRvb3RoPV9fSVNCTFVFVE9PVEhfXyZpc0NhbWVyYT1fX0lTQ0FNRVJBX18maXNMb2NrU2NyZWVuPV9fSVNMT0NLU0NSRUVOX18mbmVpZ2hib3JpbmdMYWM9X19ORUlHSEJPUklOR0xBQ19fJmlzVnBuPV9fSVNWUE5fXyZpc1NpbXVsYXRvcj1fX0lTU0lNVUxBVE9SX18mY29uZmlnVmVyc2lvbj1fX0NPTkZJR1ZFUlNJT05fXyZjb25maWd1cmF0b3JDb25maWdWZXJzaW9uPV9fQ09ORklHVVJBVE9SQ09ORklHVkVSU0lPTl9fJm1lc3NlbmdlckNvbmZpZ1ZlcnNpb249X19NRVNTRU5HRVJDT05GSUdWRVJTSU9OX18mYmFubmVyRXhjdXRvckZvckxpZVlpbmdDb25maWdWZXJzaW9uPV9fQkFOTkVSRVhDVVRPUkZPUkxJRVlJTkdDT05GSUdWRVJTSU9OX18maHJDb25maWdWZXJzaW9uPV9fSFJDT05GSUdWRVJTSU9OX18mbWFuYWdlckNvbmZpZ1ZlcnNpb249X19NQU5BR0VSQ09ORklHVkVSU0lPTl9fJmxvZ1ZlcnNpb249X19MT0dWRVJTSU9OX18mZXZlbnRUaW1lPV9fRVZFTlRUSU1FX18mdXBsb2FkdGltZT1fX1VQTE9BRFRJTUVfXyZTZXNzaW9uSUQ9X19TRVNTSU9OSURfXyZldmVudElEPV9fRVZFTlRJRF9fJmV2ZW50Q29kZT1fX0VWRU5UQ09ERV9fJmFkVHlwZT1fX0FEVFlQRV9fJnJlc2VydmVUaW1lPV9fUkVTRVJWRVRJTUVfXyZhZHhJRD1fX0FEWElEX18mYWRQb3NpdGlvbklkPV9fQURQT1NJVElPTklEX18mT0FJRD1fX09BSURfXyZHQUlEPV9fR0FJRF9fJl9fRVJSSU5GT19fJmFwcFN0YXJ0PV9fQVBQU1RBUlRfXyZhcHBJbml0PV9fQVBQU0RLSU5JVF9fJmFwcFNwbGFzaFJlcXVlc3Q9X19BUFBTUExBU0hSRVFVRVNUX18=");
                if (TextUtils.isEmpty(m48267a)) {
                    return null;
                }
                if (BeiZis.getTransferProtocol()) {
                    m48267a = m48267a.replace("http:", "https:");
                }
            }
            int indexOf = m48267a.indexOf("?");
            String substring = m48267a.substring(0, indexOf);
            String m48270a = AesUtils.m48270a(C3112ad.m48504a(), GzipUtil.m48152a(StringUtil.m48310a(this.f11553a, m48267a.substring(indexOf + 1), null)));
            if (m48270a != null) {
                String m48507a = HttpUtil.m48507a(substring, m48270a.getBytes());
                if (!TextUtils.isEmpty(m48507a)) {
                    JSONObject jSONObject = new JSONObject(m48507a);
                    if (jSONObject.optInt("code") == 200) {
                        String optString = jSONObject.optString("data");
                        if (!TextUtils.isEmpty(optString) && !optString.equals("null")) {
                            return new HeartResponse(this.f11553a, optString);
                        }
                    }
                }
            }
        } catch (Error e) {
            e.printStackTrace();
        } catch (RuntimeException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(HeartResponse heartResponse) {
        if (heartResponse == null) {
            HeartScheduler heartScheduler = this.f11554b;
            if (heartScheduler != null) {
                heartScheduler.m48106a(1000);
                return;
            }
            return;
        }
        this.f11554b.m48100a(heartResponse);
    }
}

package com.yxcorp.kuaishou.addfp;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.kuaishou.weapon.p205p0.C7282g;
import com.yxcorp.kuaishou.addfp.android.Orange;
import com.yxcorp.kuaishou.addfp.android.p576a.C13546c;
import com.yxcorp.kuaishou.addfp.android.p576a.C13547d;
import com.yxcorp.kuaishou.addfp.android.p576a.C13548e;
import com.yxcorp.kuaishou.addfp.android.p577b.C13555g;
import com.yxcorp.kuaishou.addfp.p578c.p579a.C13557a;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class KWEGIDDFP {
    private static final int EGID_LENGTH = 64;
    public static final int ERROR_TYPE_ACCESS_EXPTION = -1;
    public static final int ERROR_TYPE_NULL = -3;
    public static final int ERROR_TYPE_PROCESS = -4;
    public static final int ERROR_TYPE_UNKNOW = -2;
    private static int PROCESSALLOW = -1;
    private ResponseDfpCallback mCallBack;
    private String mEgid;
    private String mLocal;
    private Context mParamContext;
    private String mPkgName;
    private boolean mUserAgree;

    private KWEGIDDFP() {
        this.mPkgName = "";
        this.mEgid = "";
        this.mLocal = "";
        this.mUserAgree = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ KWEGIDDFP(RunnableC13543a runnableC13543a) {
        this();
    }

    public static String doSign(Context context, String str) {
        return Orange.getInstance().getClockWrapper(context, str.getBytes(), 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getEGid(ResponseDfpCallback responseDfpCallback) {
        try {
            getEGidImpl(new C13548e(this.mParamContext).m12890a());
            this.mLocal = C13546c.m12898c().m12903a(this.mParamContext, responseDfpCallback, TextUtils.isEmpty(this.mEgid));
            if (responseDfpCallback == null) {
                return;
            }
            if (!TextUtils.isEmpty(this.mEgid) || (!TextUtils.isEmpty(this.mLocal) && !this.mLocal.startsWith("KWE"))) {
                responseDfpCallback.onSuccess(this.mEgid, this.mLocal);
            } else if (this.mLocal.equals("KWE_PE")) {
            } else {
                responseDfpCallback.onFailed(-2, "need check");
            }
        } catch (Throwable th) {
            if (responseDfpCallback != null) {
                try {
                    responseDfpCallback.onFailed(-1, C13555g.m12873a(th));
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
    }

    private void getEGidImpl(boolean z) {
        Object obj;
        try {
            Pair m12897a = C13547d.m12896a(this.mParamContext).m12897a();
            if (m12897a != null && (obj = m12897a.second) != null) {
                String str = (String) ((ConcurrentHashMap) obj).get("cache_e");
                if (!TextUtils.isEmpty(str)) {
                    this.mEgid = str;
                }
            }
            if (TextUtils.isEmpty(this.mEgid)) {
                String m12866a = Build.VERSION.SDK_INT < 29 ? C13557a.m12866a(this.mParamContext, "k_w_o_d_out_dtt") : null;
                String m12894a = (TextUtils.isEmpty(m12866a) && C13555g.m12875a(this.mParamContext, new String[]{C7282g.f24951i, C7282g.f24952j})) ? C13547d.m12896a(this.mParamContext).m12894a("Lm91a2R0ZnQ=") : "";
                if (TextUtils.isEmpty(m12866a) && TextUtils.isEmpty(m12894a)) {
                    return;
                }
                LinkedHashMap m12891b = C13547d.m12896a(this.mParamContext).m12891b(m12866a);
                if (m12891b == null || m12891b.size() == 0) {
                    m12891b = C13547d.m12896a(this.mParamContext).m12891b(m12894a);
                }
                if (m12891b == null || m12891b.size() <= 0) {
                    return;
                }
                String str2 = (String) m12891b.get(C13546c.m12898c().m12905a());
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                this.mEgid = str2;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void handlePolicy(JSONObject jSONObject) {
        C13546c.m12901a(jSONObject);
    }

    public static KWEGIDDFP instance() {
        return C13556b.m12870a();
    }

    public void getEGidByCallback(Context context, boolean z, ResponseDfpCallback responseDfpCallback) {
        try {
            this.mCallBack = responseDfpCallback;
            this.mParamContext = context;
            this.mUserAgree = z;
            Thread thread = new Thread(new RunnableC13543a(this));
            thread.setName("adsence-dfp");
            thread.start();
        } catch (Throwable th) {
            String m12873a = C13555g.m12873a(th);
            if (responseDfpCallback != null) {
                responseDfpCallback.onFailed(-1, m12873a);
            }
        }
    }

    public String getEGidLocal(Context context, String str, boolean z) {
        if (TextUtils.isEmpty(this.mEgid)) {
            return null;
        }
        return this.mEgid;
    }

    public Context getParamContext() {
        return this.mParamContext;
    }

    public boolean setEgid(Context context, String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("DFP") && str.length() == 64) {
            C13547d.m12896a(context).m12893a(str, "");
            return true;
        }
        return false;
    }

    public void setLog(boolean z) {
        C13555g.m12872a(z);
    }
}

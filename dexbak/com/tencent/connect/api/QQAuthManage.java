package com.tencent.connect.api;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.connect.C12925a;
import com.tencent.connect.auth.C12949c;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.apireq.BaseResp;
import com.tencent.open.apireq.IApiCallback;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.C13066k;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class QQAuthManage extends BaseApi {

    /* compiled from: ProGuard */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class Resp extends BaseResp {
    }

    public QQAuthManage(C12949c c12949c, QQToken qQToken) {
        super(c12949c, qQToken);
    }

    public void gotoManagePage(final Activity activity, final IApiCallback iApiCallback) {
        SLog.m15127i("QQAuthManage", "gotoManagePage");
        final Resp resp = new Resp();
        if (C12925a.m15471a("QQAuthManage", null)) {
            resp.setCode(BaseResp.CODE_PERMISSION_NOT_GRANTED);
            iApiCallback.onResp(resp);
            return;
        }
        int m15464a = m15464a(activity);
        if (m15464a != 0) {
            resp.setCode(m15464a);
            iApiCallback.onResp(resp);
        } else if (this.f37136c.isSessionValid() && this.f37136c.getOpenId() != null) {
            this.f37135b.m15381a(new IUiListener() { // from class: com.tencent.connect.api.QQAuthManage.1
                @Override // com.tencent.tauth.IUiListener
                public void onCancel() {
                }

                @Override // com.tencent.tauth.IUiListener
                public void onComplete(Object obj) {
                    if (obj instanceof JSONObject) {
                        if (((JSONObject) obj).optInt("ret", -1) == 0) {
                            QQAuthManage.this.m15463a(activity, iApiCallback);
                            return;
                        }
                        SLog.m15127i("QQAuthManage", "gotoManagePage: checkLogin not login");
                        resp.setCode(BaseResp.CODE_NOT_LOGIN);
                        iApiCallback.onResp(resp);
                    }
                }

                @Override // com.tencent.tauth.IUiListener
                public void onError(UiError uiError) {
                    resp.setCode(uiError.errorCode);
                    resp.setErrorMsg(uiError.errorMessage);
                    SLog.m15129e("QQAuthManage", "gotoManagePage: checkLogin error. " + resp);
                    iApiCallback.onResp(resp);
                }

                @Override // com.tencent.tauth.IUiListener
                public void onWarning(int i) {
                }
            });
        } else {
            SLog.m15127i("QQAuthManage", "gotoManagePage: not login");
            resp.setCode(BaseResp.CODE_NOT_LOGIN);
            iApiCallback.onResp(resp);
        }
    }

    /* renamed from: a */
    private int m15464a(Activity activity) {
        if (!C13066k.m14984c(activity)) {
            SLog.m15127i("QQAuthManage", "gotoManagePage: not installed all qq");
            return -1000;
        } else if (!C13066k.m14989b(activity)) {
            SLog.m15127i("QQAuthManage", "gotoManagePage: only support mobile qq");
            return BaseResp.CODE_UNSUPPORTED_BRANCH;
        } else if (C13066k.m14983c(activity, "8.6.0") < 0) {
            SLog.m15127i("QQAuthManage", "gotoManagePage: low version");
            return BaseResp.CODE_QQ_LOW_VERSION;
        } else {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15463a(Activity activity, IApiCallback iApiCallback) {
        SLog.m15127i("QQAuthManage", "doGotoMangePage");
        StringBuilder sb = new StringBuilder("mqqapi://opensdk/open_auth_manage");
        m15310a(sb, activity);
        Intent intent = new Intent();
        intent.setData(Uri.parse(sb.toString()));
        intent.putExtra(Constants.PARAM_PKG_NAME, activity.getPackageName());
        intent.setPackage("com.tencent.mobileqq");
        intent.setFlags(335544320);
        activity.startActivity(intent);
        iApiCallback.onResp(new Resp());
    }
}

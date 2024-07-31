package com.tencent.connect.emotion;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import com.stub.StubApp;
import com.tencent.connect.C12925a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.C13066k;
import com.tencent.open.utils.C13071m;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class QQEmotion extends BaseApi {

    /* renamed from: a */
    private IUiListener f37146a;

    public QQEmotion(QQToken qQToken) {
        super(qQToken);
    }

    /* renamed from: a */
    private boolean m15301a(Context context, ArrayList<Uri> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        if (arrayList.size() > 9) {
            SLog.m15127i("QQEMOTION", "isLegality -->illegal, file count > 9, count = " + arrayList.size());
            return false;
        }
        long j = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            long m14967a = C13071m.m14967a(context, arrayList.get(i));
            if (m14967a > 1048576) {
                SLog.m15127i("QQEMOTION", "isLegality -->illegal, fileSize: " + m14967a);
                return false;
            }
            j += m14967a;
        }
        if (j > 3145728) {
            SLog.m15127i("QQEMOTION", "isLegality -->illegal, totalSize: " + j);
            return false;
        }
        SLog.m15127i("QQEMOTION", "isLegality -->legal, totalSize: " + j);
        return true;
    }

    public void setEmotions(Activity activity, ArrayList<Uri> arrayList, IUiListener iUiListener) {
        if (C12925a.m15471a("QQEmotion", iUiListener)) {
            return;
        }
        IUiListener iUiListener2 = this.f37146a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.f37146a = iUiListener;
        if (!C13066k.m14989b(activity)) {
            Toast.makeText(StubApp.getOrigApplicationContext(activity.getApplicationContext()), "当前手机未安装QQ，请安装最新版QQ后再试。", 1).show();
        } else if (C13066k.m14983c(activity, "8.0.0") < 0) {
            Toast.makeText(StubApp.getOrigApplicationContext(activity.getApplicationContext()), "当前手机QQ版本过低，不支持设置表情功能。", 1).show();
        } else if (!m15301a(StubApp.getOrigApplicationContext(activity.getApplicationContext()), arrayList)) {
            Toast.makeText(StubApp.getOrigApplicationContext(activity.getApplicationContext()), "图片不符合要求，不支持设置表情功能。", 1).show();
        } else {
            String m14968a = C13071m.m14968a(activity);
            StringBuffer stringBuffer = new StringBuffer("mqqapi://profile/sdk_face_collection?");
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(m14968a)) {
                if (m14968a.length() > 20) {
                    m14968a = m14968a.substring(0, 20) + "...";
                }
                sb.append(m14968a);
                stringBuffer.append("&app_name=" + Base64.encodeToString(C13071m.m14919j(m14968a), 2));
            }
            String appId = this.f37136c.getAppId();
            String openId = this.f37136c.getOpenId();
            if (!TextUtils.isEmpty(appId)) {
                stringBuffer.append("&share_id=" + appId);
                sb.append(appId);
            }
            if (!TextUtils.isEmpty(openId)) {
                sb.append(openId);
                stringBuffer.append("&open_id=" + Base64.encodeToString(C13071m.m14919j(openId), 2));
            }
            stringBuffer.append("&sdk_version=" + Base64.encodeToString(C13071m.m14919j(Constants.SDK_VERSION), 2));
            sb.append(Constants.SDK_VERSION);
            String m15302a = m15302a(activity, arrayList);
            if (!TextUtils.isEmpty(m15302a)) {
                sb.append(m15302a);
                stringBuffer.append("&set_uri_list=" + Base64.encodeToString(C13071m.m14919j(m15302a), 2));
                stringBuffer.append("&");
                stringBuffer.append(Constants.KEY_PPSTS);
                stringBuffer.append("=");
                stringBuffer.append(C13066k.m14999a(activity, sb.toString()));
                SLog.m15123v("QQEMOTION", "-->set avatar, url: " + stringBuffer.toString());
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(stringBuffer.toString()));
                intent.setPackage("com.tencent.mobileqq");
                intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
                UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_EDIT_EMOTION, iUiListener);
                m15317a(activity, Constants.REQUEST_EDIT_EMOTION, intent, false);
                return;
            }
            iUiListener.onError(new UiError(-6, Constants.MSG_UNKNOWN_ERROR, "picPathList is null"));
        }
    }

    /* renamed from: a */
    private String m15302a(Activity activity, ArrayList<Uri> arrayList) {
        StringBuilder sb = new StringBuilder();
        Iterator<Uri> it = arrayList.iterator();
        while (it.hasNext()) {
            Uri m14969a = C13071m.m14969a(activity, this.f37136c.getAppId(), C13071m.m14944b(activity, it.next()));
            if (m14969a == null) {
                SLog.m15129e("QQEmotion", "getFilePathListJson: grantedUri = null");
            } else {
                sb.append(m14969a);
                sb.append(";");
            }
        }
        String sb2 = sb.toString();
        SLog.m15127i("QQEmotion", "-->getFilePathListJson listStr : " + sb2);
        return sb2;
    }
}

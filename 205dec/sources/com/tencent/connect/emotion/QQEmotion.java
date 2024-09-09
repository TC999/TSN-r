package com.tencent.connect.emotion;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import com.stub.StubApp;
import com.tencent.connect.a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class QQEmotion extends BaseApi {

    /* renamed from: a  reason: collision with root package name */
    private IUiListener f51511a;

    public QQEmotion(QQToken qQToken) {
        super(qQToken);
    }

    private boolean a(Context context, ArrayList<Uri> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        if (arrayList.size() > 9) {
            SLog.i("QQEMOTION", "isLegality -->illegal, file count > 9, count = " + arrayList.size());
            return false;
        }
        long j4 = 0;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            long a4 = m.a(context, arrayList.get(i4));
            if (a4 > 1048576) {
                SLog.i("QQEMOTION", "isLegality -->illegal, fileSize: " + a4);
                return false;
            }
            j4 += a4;
        }
        if (j4 > 3145728) {
            SLog.i("QQEMOTION", "isLegality -->illegal, totalSize: " + j4);
            return false;
        }
        SLog.i("QQEMOTION", "isLegality -->legal, totalSize: " + j4);
        return true;
    }

    public void setEmotions(Activity activity, ArrayList<Uri> arrayList, IUiListener iUiListener) {
        if (a.a("QQEmotion", iUiListener)) {
            return;
        }
        IUiListener iUiListener2 = this.f51511a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.f51511a = iUiListener;
        if (!k.b(activity)) {
            Toast.makeText(StubApp.getOrigApplicationContext(activity.getApplicationContext()), "\u5f53\u524d\u624b\u673a\u672a\u5b89\u88c5QQ\uff0c\u8bf7\u5b89\u88c5\u6700\u65b0\u7248QQ\u540e\u518d\u8bd5\u3002", 1).show();
        } else if (k.c(activity, "8.0.0") < 0) {
            Toast.makeText(StubApp.getOrigApplicationContext(activity.getApplicationContext()), "\u5f53\u524d\u624b\u673aQQ\u7248\u672c\u8fc7\u4f4e\uff0c\u4e0d\u652f\u6301\u8bbe\u7f6e\u8868\u60c5\u529f\u80fd\u3002", 1).show();
        } else if (!a(StubApp.getOrigApplicationContext(activity.getApplicationContext()), arrayList)) {
            Toast.makeText(StubApp.getOrigApplicationContext(activity.getApplicationContext()), "\u56fe\u7247\u4e0d\u7b26\u5408\u8981\u6c42\uff0c\u4e0d\u652f\u6301\u8bbe\u7f6e\u8868\u60c5\u529f\u80fd\u3002", 1).show();
        } else {
            String a4 = m.a(activity);
            StringBuffer stringBuffer = new StringBuffer("mqqapi://profile/sdk_face_collection?");
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(a4)) {
                if (a4.length() > 20) {
                    a4 = a4.substring(0, 20) + "...";
                }
                sb.append(a4);
                stringBuffer.append("&app_name=" + Base64.encodeToString(m.j(a4), 2));
            }
            String appId = this.f51502c.getAppId();
            String openId = this.f51502c.getOpenId();
            if (!TextUtils.isEmpty(appId)) {
                stringBuffer.append("&share_id=" + appId);
                sb.append(appId);
            }
            if (!TextUtils.isEmpty(openId)) {
                sb.append(openId);
                stringBuffer.append("&open_id=" + Base64.encodeToString(m.j(openId), 2));
            }
            stringBuffer.append("&sdk_version=" + Base64.encodeToString(m.j("3.5.13.lite"), 2));
            sb.append("3.5.13.lite");
            String a5 = a(activity, arrayList);
            if (!TextUtils.isEmpty(a5)) {
                sb.append(a5);
                stringBuffer.append("&set_uri_list=" + Base64.encodeToString(m.j(a5), 2));
                stringBuffer.append("&");
                stringBuffer.append("ppsts");
                stringBuffer.append("=");
                stringBuffer.append(k.a(activity, sb.toString()));
                SLog.v("QQEMOTION", "-->set avatar, url: " + stringBuffer.toString());
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(stringBuffer.toString()));
                intent.setPackage("com.tencent.mobileqq");
                intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
                UIListenerManager.getInstance().setListenerWithRequestcode(10109, iUiListener);
                a(activity, 10109, intent, false);
                return;
            }
            iUiListener.onError(new UiError(-6, "\u672a\u77e5\u9519\u8bef!", "picPathList is null"));
        }
    }

    private String a(Activity activity, ArrayList<Uri> arrayList) {
        StringBuilder sb = new StringBuilder();
        Iterator<Uri> it = arrayList.iterator();
        while (it.hasNext()) {
            Uri a4 = m.a(activity, this.f51502c.getAppId(), m.b(activity, it.next()));
            if (a4 == null) {
                SLog.e("QQEmotion", "getFilePathListJson: grantedUri = null");
            } else {
                sb.append(a4);
                sb.append(";");
            }
        }
        String sb2 = sb.toString();
        SLog.i("QQEmotion", "-->getFilePathListJson listStr : " + sb2);
        return sb2;
    }
}

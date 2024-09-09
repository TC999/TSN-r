package com.tencent.tauth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.stub.StubApp;
import com.tencent.connect.common.AssistActivity;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class AuthActivity extends Activity {
    public static final String ACTION_SHARE_PRIZE = "sharePrize";

    /* renamed from: a  reason: collision with root package name */
    private static int f51863a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, ActionHandler> f51864b = new HashMap();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ProGuard */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    interface ActionHandler {
        void handleAction(Activity activity, Bundle bundle);
    }

    static {
        StubApp.interface11(24009);
    }

    private void a() {
        this.f51864b.put("action_common_channel", new ActionHandler() { // from class: com.tencent.tauth.AuthActivity.1
            @Override // com.tencent.tauth.AuthActivity.ActionHandler
            public void handleAction(Activity activity, Bundle bundle) {
                SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri--common channel. ");
                Intent intent = new Intent(activity, AssistActivity.class);
                intent.putExtras(bundle);
                intent.putExtra("key_request_code", 10114);
                intent.setFlags(603979776);
                AuthActivity.this.startActivity(intent);
                AuthActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    public void finish() {
        try {
            super.finish();
        } catch (Exception e4) {
            SLog.e("openSDK_LOG.AuthActivity", "activity finish exception: ", e4);
        }
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void a(Uri uri) {
        SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri--start");
        if (uri != null && uri.toString() != null) {
            String str = "";
            if (!uri.toString().equals("")) {
                String uri2 = uri.toString();
                Bundle a4 = m.a(uri2.substring(uri2.indexOf("#") + 1));
                if (a4 == null) {
                    SLog.w("openSDK_LOG.AuthActivity", "-->handleActionUri, bundle is null");
                    finish();
                    return;
                }
                String string = a4.getString("action");
                SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri, action: " + string);
                if (string == null) {
                    finish();
                    return;
                } else if (!string.equals("shareToQQ") && !string.equals("shareToQzone") && !string.equals("sendToMyComputer") && !string.equals("shareToTroopBar")) {
                    if (string.equals("addToQQFavorites")) {
                        Intent intent = getIntent();
                        intent.putExtras(a4);
                        intent.putExtra("key_action", "action_share");
                        IUiListener listnerWithAction = UIListenerManager.getInstance().getListnerWithAction(string);
                        if (listnerWithAction != null) {
                            UIListenerManager.getInstance().handleDataToListener(intent, listnerWithAction);
                        }
                        finish();
                        return;
                    } else if (string.equals("sharePrize")) {
                        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
                        try {
                            str = m.d(a4.getString("response")).getString("activityid");
                        } catch (Exception e4) {
                            SLog.e("openSDK_LOG.AuthActivity", "sharePrize parseJson has exception.", e4);
                        }
                        if (!TextUtils.isEmpty(str)) {
                            launchIntentForPackage.putExtra("sharePrize", true);
                            Bundle bundle = new Bundle();
                            bundle.putString("activityid", str);
                            launchIntentForPackage.putExtras(bundle);
                        }
                        startActivity(launchIntentForPackage);
                        finish();
                        return;
                    } else if (string.equals("sdkSetAvatar")) {
                        boolean booleanExtra = getIntent().getBooleanExtra("stay_back_stack", false);
                        Intent intent2 = new Intent(this, AssistActivity.class);
                        intent2.putExtra("key_request_code", 10108);
                        intent2.putExtra("stay_back_stack", booleanExtra);
                        intent2.putExtras(a4);
                        intent2.setFlags(603979776);
                        startActivity(intent2);
                        finish();
                        return;
                    } else if ("sdkSetDynamicAvatar".equals(string)) {
                        boolean booleanExtra2 = getIntent().getBooleanExtra("stay_back_stack", false);
                        Intent intent3 = new Intent(this, AssistActivity.class);
                        intent3.putExtra("key_request_code", 10110);
                        intent3.putExtra("stay_back_stack", booleanExtra2);
                        intent3.putExtras(a4);
                        intent3.setFlags(603979776);
                        startActivity(intent3);
                        finish();
                        return;
                    } else if (string.equals("sdkSetEmotion")) {
                        boolean booleanExtra3 = getIntent().getBooleanExtra("stay_back_stack", false);
                        Intent intent4 = new Intent(this, AssistActivity.class);
                        intent4.putExtra("key_request_code", 10109);
                        intent4.putExtra("stay_back_stack", booleanExtra3);
                        intent4.putExtras(a4);
                        intent4.setFlags(603979776);
                        startActivity(intent4);
                        finish();
                        return;
                    } else if (string.equals("bindGroup")) {
                        SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri--bind group callback.");
                        boolean booleanExtra4 = getIntent().getBooleanExtra("stay_back_stack", false);
                        Intent intent5 = new Intent(this, AssistActivity.class);
                        intent5.putExtra("key_request_code", 10112);
                        intent5.putExtra("stay_back_stack", booleanExtra4);
                        intent5.putExtras(a4);
                        intent5.setFlags(603979776);
                        startActivity(intent5);
                        finish();
                        return;
                    } else if (string.equals("joinGroup")) {
                        SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri--join group callback. ");
                        boolean booleanExtra5 = getIntent().getBooleanExtra("stay_back_stack", false);
                        Intent intent6 = new Intent(this, AssistActivity.class);
                        intent6.putExtra("key_request_code", 10111);
                        intent6.putExtra("stay_back_stack", booleanExtra5);
                        intent6.putExtras(a4);
                        intent6.setFlags(603979776);
                        startActivity(intent6);
                        finish();
                        return;
                    } else if ("guildOpen".equals(string)) {
                        Intent intent7 = new Intent(this, AssistActivity.class);
                        intent7.putExtras(a4);
                        intent7.putExtra("key_request_code", 10113);
                        intent7.setFlags(603979776);
                        startActivity(intent7);
                        finish();
                        return;
                    } else {
                        ActionHandler actionHandler = this.f51864b.get(string);
                        if (actionHandler != null) {
                            actionHandler.handleAction(this, a4);
                            return;
                        } else {
                            finish();
                            return;
                        }
                    }
                } else {
                    if (string.equals("shareToQzone") && k.a((Context) this, "com.tencent.mobileqq") != null && k.c(this, "5.2.0") < 0) {
                        int i4 = f51863a + 1;
                        f51863a = i4;
                        if (i4 == 2) {
                            f51863a = 0;
                            finish();
                            return;
                        }
                    }
                    SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri, most share action, start assistactivity");
                    Intent intent8 = new Intent(this, AssistActivity.class);
                    intent8.putExtras(a4);
                    intent8.setFlags(603979776);
                    startActivity(intent8);
                    finish();
                    return;
                }
            }
        }
        SLog.w("openSDK_LOG.AuthActivity", "-->handleActionUri, uri invalid");
        finish();
    }
}

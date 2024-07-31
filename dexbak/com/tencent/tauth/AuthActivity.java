package com.tencent.tauth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.stub.StubApp;
import com.tencent.connect.common.AssistActivity;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.C13066k;
import com.tencent.open.utils.C13071m;
import com.umeng.ccg.CcgConstant;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class AuthActivity extends Activity {
    public static final String ACTION_SHARE_PRIZE = "sharePrize";

    /* renamed from: a */
    private static int f37463a;

    /* renamed from: b */
    private Map<String, ActionHandler> f37464b = new HashMap();

    /* compiled from: ProGuard */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    interface ActionHandler {
        void handleAction(Activity activity, Bundle bundle);
    }

    static {
        StubApp.interface11(24009);
    }

    /* renamed from: a */
    private void m14899a() {
        this.f37464b.put("action_common_channel", new ActionHandler() { // from class: com.tencent.tauth.AuthActivity.1
            @Override // com.tencent.tauth.AuthActivity.ActionHandler
            public void handleAction(Activity activity, Bundle bundle) {
                SLog.m15127i("openSDK_LOG.AuthActivity", "-->handleActionUri--common channel. ");
                Intent intent = new Intent(activity, AssistActivity.class);
                intent.putExtras(bundle);
                intent.putExtra(Constants.KEY_REQUEST_CODE, Constants.REQUEST_COMMON_CHANNEL);
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
        } catch (Exception e) {
            SLog.m15128e("openSDK_LOG.AuthActivity", "activity finish exception: ", e);
        }
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    /* renamed from: a */
    private void m14898a(Uri uri) {
        SLog.m15127i("openSDK_LOG.AuthActivity", "-->handleActionUri--start");
        if (uri != null && uri.toString() != null) {
            String str = "";
            if (!uri.toString().equals("")) {
                String uri2 = uri.toString();
                Bundle m14960a = C13071m.m14960a(uri2.substring(uri2.indexOf("#") + 1));
                if (m14960a == null) {
                    SLog.m15121w("openSDK_LOG.AuthActivity", "-->handleActionUri, bundle is null");
                    finish();
                    return;
                }
                String string = m14960a.getString(CcgConstant.f38549t);
                SLog.m15127i("openSDK_LOG.AuthActivity", "-->handleActionUri, action: " + string);
                if (string == null) {
                    finish();
                    return;
                } else if (!string.equals("shareToQQ") && !string.equals("shareToQzone") && !string.equals("sendToMyComputer") && !string.equals("shareToTroopBar")) {
                    if (string.equals("addToQQFavorites")) {
                        Intent intent = getIntent();
                        intent.putExtras(m14960a);
                        intent.putExtra(Constants.KEY_ACTION, "action_share");
                        IUiListener listnerWithAction = UIListenerManager.getInstance().getListnerWithAction(string);
                        if (listnerWithAction != null) {
                            UIListenerManager.getInstance().handleDataToListener(intent, listnerWithAction);
                        }
                        finish();
                        return;
                    } else if (string.equals(ACTION_SHARE_PRIZE)) {
                        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
                        try {
                            str = C13071m.m14933d(m14960a.getString("response")).getString("activityid");
                        } catch (Exception e) {
                            SLog.m15128e("openSDK_LOG.AuthActivity", "sharePrize parseJson has exception.", e);
                        }
                        if (!TextUtils.isEmpty(str)) {
                            launchIntentForPackage.putExtra(ACTION_SHARE_PRIZE, true);
                            Bundle bundle = new Bundle();
                            bundle.putString("activityid", str);
                            launchIntentForPackage.putExtras(bundle);
                        }
                        startActivity(launchIntentForPackage);
                        finish();
                        return;
                    } else if (string.equals("sdkSetAvatar")) {
                        boolean booleanExtra = getIntent().getBooleanExtra(Constants.KEY_STAY, false);
                        Intent intent2 = new Intent(this, AssistActivity.class);
                        intent2.putExtra(Constants.KEY_REQUEST_CODE, Constants.REQUEST_EDIT_AVATAR);
                        intent2.putExtra(Constants.KEY_STAY, booleanExtra);
                        intent2.putExtras(m14960a);
                        intent2.setFlags(603979776);
                        startActivity(intent2);
                        finish();
                        return;
                    } else if ("sdkSetDynamicAvatar".equals(string)) {
                        boolean booleanExtra2 = getIntent().getBooleanExtra(Constants.KEY_STAY, false);
                        Intent intent3 = new Intent(this, AssistActivity.class);
                        intent3.putExtra(Constants.KEY_REQUEST_CODE, Constants.REQUEST_EDIT_DYNAMIC_AVATAR);
                        intent3.putExtra(Constants.KEY_STAY, booleanExtra2);
                        intent3.putExtras(m14960a);
                        intent3.setFlags(603979776);
                        startActivity(intent3);
                        finish();
                        return;
                    } else if (string.equals("sdkSetEmotion")) {
                        boolean booleanExtra3 = getIntent().getBooleanExtra(Constants.KEY_STAY, false);
                        Intent intent4 = new Intent(this, AssistActivity.class);
                        intent4.putExtra(Constants.KEY_REQUEST_CODE, Constants.REQUEST_EDIT_EMOTION);
                        intent4.putExtra(Constants.KEY_STAY, booleanExtra3);
                        intent4.putExtras(m14960a);
                        intent4.setFlags(603979776);
                        startActivity(intent4);
                        finish();
                        return;
                    } else if (string.equals("bindGroup")) {
                        SLog.m15127i("openSDK_LOG.AuthActivity", "-->handleActionUri--bind group callback.");
                        boolean booleanExtra4 = getIntent().getBooleanExtra(Constants.KEY_STAY, false);
                        Intent intent5 = new Intent(this, AssistActivity.class);
                        intent5.putExtra(Constants.KEY_REQUEST_CODE, Constants.REQUEST_BIND_GROUP);
                        intent5.putExtra(Constants.KEY_STAY, booleanExtra4);
                        intent5.putExtras(m14960a);
                        intent5.setFlags(603979776);
                        startActivity(intent5);
                        finish();
                        return;
                    } else if (string.equals("joinGroup")) {
                        SLog.m15127i("openSDK_LOG.AuthActivity", "-->handleActionUri--join group callback. ");
                        boolean booleanExtra5 = getIntent().getBooleanExtra(Constants.KEY_STAY, false);
                        Intent intent6 = new Intent(this, AssistActivity.class);
                        intent6.putExtra(Constants.KEY_REQUEST_CODE, Constants.REQUEST_JOIN_GROUP);
                        intent6.putExtra(Constants.KEY_STAY, booleanExtra5);
                        intent6.putExtras(m14960a);
                        intent6.setFlags(603979776);
                        startActivity(intent6);
                        finish();
                        return;
                    } else if ("guildOpen".equals(string)) {
                        Intent intent7 = new Intent(this, AssistActivity.class);
                        intent7.putExtras(m14960a);
                        intent7.putExtra(Constants.KEY_REQUEST_CODE, Constants.REQUEST_GUILD);
                        intent7.setFlags(603979776);
                        startActivity(intent7);
                        finish();
                        return;
                    } else {
                        ActionHandler actionHandler = this.f37464b.get(string);
                        if (actionHandler != null) {
                            actionHandler.handleAction(this, m14960a);
                            return;
                        } else {
                            finish();
                            return;
                        }
                    }
                } else {
                    if (string.equals("shareToQzone") && C13066k.m14996a((Context) this, "com.tencent.mobileqq") != null && C13066k.m14983c(this, "5.2.0") < 0) {
                        int i = f37463a + 1;
                        f37463a = i;
                        if (i == 2) {
                            f37463a = 0;
                            finish();
                            return;
                        }
                    }
                    SLog.m15127i("openSDK_LOG.AuthActivity", "-->handleActionUri, most share action, start assistactivity");
                    Intent intent8 = new Intent(this, AssistActivity.class);
                    intent8.putExtras(m14960a);
                    intent8.setFlags(603979776);
                    startActivity(intent8);
                    finish();
                    return;
                }
            }
        }
        SLog.m15121w("openSDK_LOG.AuthActivity", "-->handleActionUri, uri invalid");
        finish();
    }
}

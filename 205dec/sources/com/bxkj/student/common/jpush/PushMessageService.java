package com.bxkj.student.common.jpush;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import cn.jpush.android.api.CmdMessage;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.service.JPushMessageReceiver;
import com.orhanobut.logger.j;

/* loaded from: E:\TSN-r\205dec\4499832.dex */
public class PushMessageService extends JPushMessageReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f19569a = "PushMessageService";

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onAliasOperatorResult(Context context, JPushMessage jPushMessage) {
        super.onAliasOperatorResult(context, jPushMessage);
        int sequence = jPushMessage.getSequence();
        Log.i(f19569a, "action - onAliasOperatorResult, sequence:" + sequence + ",alias:" + jPushMessage.getAlias());
        if (jPushMessage.getErrorCode() == 0) {
            Log.i(f19569a, "action - modify alias Success,sequence:" + sequence);
            return;
        }
        Log.e(f19569a, "Failed to modify alias, errorCode:" + jPushMessage.getErrorCode());
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onCheckTagOperatorResult(Context context, JPushMessage jPushMessage) {
        super.onCheckTagOperatorResult(context, jPushMessage);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onCommandResult(Context context, CmdMessage cmdMessage) {
        Log.e(f19569a, "[onCommandResult] " + cmdMessage);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onConnected(Context context, boolean isConnected) {
        j.c("JPushInterface.getRegistrationID(getContext())=" + JPushInterface.getRegistrationID(context));
        Log.e(f19569a, "[onConnected] " + isConnected);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onMessage(Context context, CustomMessage customMessage) {
        Log.e(f19569a, "[onMessage] " + customMessage);
        Intent intent = new Intent("com.jiguang.demo.message");
        intent.putExtra("msg", customMessage.message);
        context.sendBroadcast(intent);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onMobileNumberOperatorResult(Context context, JPushMessage jPushMessage) {
        super.onMobileNumberOperatorResult(context, jPushMessage);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onMultiActionClicked(Context context, Intent intent) {
        Log.e(f19569a, "[onMultiActionClicked] \u7528\u6237\u70b9\u51fb\u4e86\u901a\u77e5\u680f\u6309\u94ae");
        String string = intent.getExtras().getString(JPushInterface.EXTRA_NOTIFICATION_ACTION_EXTRA);
        if (string == null) {
            Log.d(f19569a, "ACTION_NOTIFICATION_CLICK_ACTION nActionExtra is null");
        } else if (string.equals("my_extra1")) {
            Log.e(f19569a, "[onMultiActionClicked] \u7528\u6237\u70b9\u51fb\u901a\u77e5\u680f\u6309\u94ae\u4e00");
        } else if (string.equals("my_extra2")) {
            Log.e(f19569a, "[onMultiActionClicked] \u7528\u6237\u70b9\u51fb\u901a\u77e5\u680f\u6309\u94ae\u4e8c");
        } else if (string.equals("my_extra3")) {
            Log.e(f19569a, "[onMultiActionClicked] \u7528\u6237\u70b9\u51fb\u901a\u77e5\u680f\u6309\u94ae\u4e09");
        } else {
            Log.e(f19569a, "[onMultiActionClicked] \u7528\u6237\u70b9\u51fb\u901a\u77e5\u680f\u6309\u94ae\u672a\u5b9a\u4e49");
        }
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onNotificationSettingsCheck(Context context, boolean isOn, int source) {
        super.onNotificationSettingsCheck(context, isOn, source);
        Log.e(f19569a, "[onNotificationSettingsCheck] isOn:" + isOn + ",source:" + source);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onNotifyMessageArrived(Context context, NotificationMessage message) {
        Log.e(f19569a, "[onNotifyMessageArrived] " + message);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onNotifyMessageDismiss(Context context, NotificationMessage message) {
        Log.e(f19569a, "[onNotifyMessageDismiss] " + message);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onNotifyMessageOpened(Context context, NotificationMessage message) {
        Log.e(f19569a, "[onNotifyMessageOpened] " + message);
        super.onNotifyMessageOpened(context, message);
        Log.e(f19569a, "[onNotifyMessageOpened] " + message);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onRegister(Context context, String registrationId) {
        Log.e(f19569a, "[onRegister] " + registrationId);
        context.sendBroadcast(new Intent("com.jiguang.demo.register"));
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onTagOperatorResult(Context context, JPushMessage jPushMessage) {
        super.onTagOperatorResult(context, jPushMessage);
        int sequence = jPushMessage.getSequence();
        Log.i(f19569a, "action - onTagOperatorResult, sequence:" + sequence + ",tags:" + jPushMessage.getTags());
        StringBuilder sb = new StringBuilder();
        sb.append("tags size:");
        sb.append(jPushMessage.getTags().size());
        Log.i(f19569a, sb.toString());
        if (jPushMessage.getErrorCode() == 0) {
            Log.i(f19569a, "action - modify tag Success,sequence:" + sequence);
            return;
        }
        String str = "Failed to modify tags";
        if (jPushMessage.getErrorCode() == 6018) {
            str = "Failed to modify tags, tags is exceed limit need to clean";
        }
        Log.e(f19569a, str + ", errorCode:" + jPushMessage.getErrorCode());
    }
}

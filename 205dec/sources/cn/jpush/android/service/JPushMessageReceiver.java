package cn.jpush.android.service;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.jpush.android.api.CmdMessage;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.local.ActionHelper;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class JPushMessageReceiver extends BroadcastReceiver {
    public Notification getNotification(Context context, NotificationMessage notificationMessage) {
        return null;
    }

    public boolean isNeedShowNotification(Context context, NotificationMessage notificationMessage, String str) {
        return true;
    }

    public void onAliasOperatorResult(Context context, JPushMessage jPushMessage) {
    }

    public void onCheckTagOperatorResult(Context context, JPushMessage jPushMessage) {
    }

    public void onCommandResult(Context context, CmdMessage cmdMessage) {
    }

    public void onConnected(Context context, boolean z3) {
    }

    public void onGeofenceReceived(Context context, String str) {
    }

    public void onGeofenceRegion(Context context, String str, double d4, double d5) {
    }

    public void onInAppMessageClick(Context context, NotificationMessage notificationMessage) {
        ActionHelper.getInstance().onInAppMessageClick(context, notificationMessage);
    }

    public void onInAppMessageShow(Context context, NotificationMessage notificationMessage) {
        ActionHelper.getInstance().onInAppMessageShow(context, notificationMessage);
    }

    public void onMessage(Context context, CustomMessage customMessage) {
        ActionHelper.getInstance().onMessage(context, customMessage);
    }

    public void onMobileNumberOperatorResult(Context context, JPushMessage jPushMessage) {
    }

    public void onMultiActionClicked(Context context, Intent intent) {
        ActionHelper.getInstance().onMultiAction(context, intent);
    }

    public void onNotificationSettingsCheck(Context context, boolean z3, int i4) {
    }

    public void onNotifyMessageArrived(Context context, NotificationMessage notificationMessage) {
        ActionHelper.getInstance().onNotifyMessageArrived(context, notificationMessage);
    }

    public void onNotifyMessageDismiss(Context context, NotificationMessage notificationMessage) {
    }

    public void onNotifyMessageOpened(Context context, NotificationMessage notificationMessage) {
        ActionHelper.getInstance().onNotifyMessageOpened(context, notificationMessage);
    }

    public void onNotifyMessageUnShow(Context context, NotificationMessage notificationMessage) {
    }

    public void onPropertyOperatorResult(Context context, JPushMessage jPushMessage) {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        ActionHelper.getInstance().onJPushMessageReceive(context, this, intent);
    }

    public void onRegister(Context context, String str) {
    }

    public void onTagOperatorResult(Context context, JPushMessage jPushMessage) {
    }
}

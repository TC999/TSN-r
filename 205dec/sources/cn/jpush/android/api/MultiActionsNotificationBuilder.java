package cn.jpush.android.api;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.service.JNotifyActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class MultiActionsNotificationBuilder extends DefaultPushNotificationBuilder {
    private static final String INTENT_NOTIFICATION_CLICK_ACTION_PROXY = "cn.jpush.android.intent.NOTIFICATION_CLICK_ACTION_PROXY";
    private static final String NOTI_ACT_EXTRA_STR = "notification_action_extra_string";
    private static final String NOTI_ACT_RES_ID = "notification_action_res_id";
    private static final String NOTI_ACT_TEXT = "notification_action_text";
    private static final String TAG = "MultiActionsNotificationBuilder";
    private JSONArray actionJSONArray = new JSONArray();
    protected Context mContext;

    public MultiActionsNotificationBuilder(Context context) {
        this.mContext = context;
    }

    public static PushNotificationBuilder parseFromPreference(Context context, String str) {
        MultiActionsNotificationBuilder multiActionsNotificationBuilder = new MultiActionsNotificationBuilder(context);
        try {
            multiActionsNotificationBuilder.actionJSONArray = new JSONArray(str);
        } catch (JSONException e4) {
            Logger.ww(TAG, "Parse builder from preference failed!" + e4);
        }
        return multiActionsNotificationBuilder;
    }

    public void addJPushAction(int i4, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NOTI_ACT_RES_ID, i4);
            jSONObject.put(NOTI_ACT_TEXT, str);
            jSONObject.put(NOTI_ACT_EXTRA_STR, str2);
            this.actionJSONArray.put(jSONObject);
            Logger.i(TAG, this.actionJSONArray.toString());
        } catch (JSONException e4) {
            Logger.ww(TAG, "Construct action failed!" + e4);
        }
    }

    @Override // cn.jpush.android.api.DefaultPushNotificationBuilder
    @TargetApi(11)
    Notification getNotification(Notification.Builder builder) {
        for (int i4 = 0; i4 < this.actionJSONArray.length(); i4++) {
            try {
                JSONObject jSONObject = this.actionJSONArray.getJSONObject(i4);
                Intent intent = new Intent("cn.jpush.android.intent.NOTIFICATION_CLICK_ACTION_PROXY");
                intent.putExtra(JPushInterface.EXTRA_NOTIFICATION_ACTION_EXTRA, jSONObject.getString(NOTI_ACT_EXTRA_STR));
                intent.setClass(this.mContext, JNotifyActivity.class);
                intent.setFlags(8388608);
                intent.putExtra("isNotification", true);
                PendingIntent activity = PendingIntent.getActivity(this.mContext, i4, intent, 201326592);
                Logger.i(TAG, "Add notification action: res - " + jSONObject.getInt(NOTI_ACT_RES_ID) + ", string - " + jSONObject.getString(NOTI_ACT_TEXT) + ", extra - " + jSONObject.getString(NOTI_ACT_EXTRA_STR));
                builder.addAction(jSONObject.getInt(NOTI_ACT_RES_ID), jSONObject.getString(NOTI_ACT_TEXT), activity).setAutoCancel(true);
            } catch (JSONException e4) {
                Logger.ww(TAG, "Parse Action from preference preference failed!" + e4);
            }
        }
        return builder.build();
    }

    @Override // cn.jpush.android.api.DefaultPushNotificationBuilder
    public String toString() {
        return this.actionJSONArray.toString();
    }
}

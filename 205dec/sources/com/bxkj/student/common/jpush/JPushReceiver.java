package com.bxkj.student.common.jpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import cn.jpush.android.api.JPushInterface;
import com.bxkj.base.chat.ChatActivity;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.webview.H5DetailActivity;
import com.bxkj.student.MainActivity;
import com.bxkj.student.home.teaching.rollcall.BleSignActivity;
import com.bxkj.student.home.teaching.rollcall.term.ViewTermActivity;
import com.bxkj.student.main.MyFragment;
import com.bxkj.student.personal.customer.ContactCustomerActivity;
import com.bxkj.student.v2.ui.h5.H5AppActivity;
import com.orhanobut.logger.j;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\4499832.dex */
public class JPushReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f19568a = "JPush";

    private static String a(Bundle bundle) {
        StringBuilder sb = new StringBuilder();
        for (String str : bundle.keySet()) {
            if (str.equals(JPushInterface.EXTRA_NOTIFICATION_ID)) {
                sb.append("\nkey:" + str + ", value:" + bundle.getInt(str));
            } else if (str.equals(JPushInterface.EXTRA_CONNECTION_CHANGE)) {
                sb.append("\nkey:" + str + ", value:" + bundle.getBoolean(str));
            } else if (!str.equals(JPushInterface.EXTRA_EXTRA)) {
                sb.append("\nkey:" + str + ", value:" + bundle.getString(str));
            } else if (TextUtils.isEmpty(bundle.getString(JPushInterface.EXTRA_EXTRA))) {
                j.g(f19568a, "This message has no Extra data");
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(bundle.getString(JPushInterface.EXTRA_EXTRA));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String str2 = keys.next().toString();
                        sb.append("\nkey:" + str + ", value: [" + str2 + " - " + jSONObject.optString(str2) + "]");
                    }
                } catch (JSONException unused) {
                    Log.e(f19568a, "Get message extra JSON error!");
                }
            }
        }
        return sb.toString();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intent intent2;
        Intent intent3;
        MainActivity mainActivity;
        try {
            Bundle extras = intent.getExtras();
            Log.d(f19568a, "[JPushReceiver] onReceive - " + intent.getAction() + ", extras: " + a(extras));
            if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {
                String string = extras.getString(JPushInterface.EXTRA_REGISTRATION_ID);
                Log.d(f19568a, "[JPushReceiver] \u63a5\u6536Registration Id : " + string);
            } else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
                Log.d(f19568a, "[JPushReceiver] \u63a5\u6536\u5230\u63a8\u9001\u4e0b\u6765\u7684\u81ea\u5b9a\u4e49\u6d88\u606f: " + extras.getString(JPushInterface.EXTRA_MESSAGE));
            } else {
                String string2 = extras.getString(JPushInterface.EXTRA_EXTRA);
                if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())) {
                    Log.d(f19568a, "[JPushReceiver] \u63a5\u6536\u5230\u63a8\u9001\u4e0b\u6765\u7684\u901a\u77e5");
                    int i4 = extras.getInt(JPushInterface.EXTRA_NOTIFICATION_ID);
                    Log.d(f19568a, "[JPushReceiver] \u63a5\u6536\u5230\u63a8\u9001\u4e0b\u6765\u7684\u901a\u77e5\u7684ID: " + i4);
                    if (extras.containsKey(JPushInterface.EXTRA_EXTRA)) {
                        JSONObject jSONObject = new JSONObject(string2);
                        if (jSONObject.has("type")) {
                            if ("1".equals(jSONObject.getString("type"))) {
                                ContactCustomerActivity contactCustomerActivity = (ContactCustomerActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(ContactCustomerActivity.class);
                                if (contactCustomerActivity != null) {
                                    contactCustomerActivity.z0();
                                }
                                MyFragment myFragment = (MyFragment) cn.bluemobi.dylan.base.utils.a.n().o(MyFragment.class);
                                if (myFragment != null) {
                                    myFragment.Z();
                                }
                            } else if (!"0".equals(jSONObject.getString("type")) || (mainActivity = (MainActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(MainActivity.class)) == null) {
                            } else {
                                mainActivity.z0();
                            }
                        }
                    }
                } else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
                    Log.d(f19568a, "[JPushReceiver] \u7528\u6237\u70b9\u51fb\u6253\u5f00\u4e86\u901a\u77e5");
                    if (TextUtils.isEmpty(string2)) {
                        Log.i(f19568a, "This message has no Extra data");
                    }
                    try {
                        JSONObject jSONObject2 = new JSONObject(string2);
                        j.h(string2);
                        if (jSONObject2.has("type")) {
                            if ("0".equals(jSONObject2.getString("type"))) {
                                Intent intent4 = new Intent(context, H5DetailActivity.class);
                                if (jSONObject2.has("url")) {
                                    extras.putString("url", jSONObject2.getString("url"));
                                    extras.putString("title", jSONObject2.getString("title"));
                                }
                                intent4.putExtras(extras);
                                intent4.setFlags(335544320);
                                context.startActivity(intent4);
                            } else if ("1".equals(jSONObject2.getString("type"))) {
                                Intent intent5 = new Intent(context, ContactCustomerActivity.class);
                                intent5.putExtras(extras);
                                intent5.setFlags(335544320);
                                context.startActivity(intent5);
                            } else if ("2".equals(jSONObject2.getString("type"))) {
                                Intent intent6 = new Intent();
                                intent6.putExtras(extras);
                                intent6.setFlags(335544320);
                                if (!LoginUser.getLoginUser().isLogin()) {
                                    context.startActivity(intent6.setClass(context, MainActivity.class));
                                    return;
                                }
                                if (!LoginUser.getLoginUser().getSchoolId().equalsIgnoreCase("7") && !LoginUser.getLoginUser().getSchoolId().equalsIgnoreCase("85") && !LoginUser.getLoginUser().getSchoolId().equalsIgnoreCase("85") && !LoginUser.getLoginUser().getSchoolId().equalsIgnoreCase("130") && !LoginUser.getLoginUser().getSchoolId().equalsIgnoreCase("78") && !LoginUser.getLoginUser().getSchoolId().equalsIgnoreCase("97")) {
                                    context.startActivity(intent6.setClass(context, BleSignActivity.class));
                                    return;
                                }
                                context.startActivity(intent6.setClass(context, ViewTermActivity.class));
                            } else if ("3".equals(jSONObject2.getString("type"))) {
                                try {
                                    Intent intent7 = new Intent();
                                    if (LoginUser.getLoginUser().isLogin()) {
                                        intent7.setClass(context, ChatActivity.class);
                                    } else {
                                        context.startActivity(intent7.setClass(context, MainActivity.class));
                                    }
                                    intent7.putExtra("chatName", jSONObject2.getString("fromName"));
                                    int parseInt = Integer.parseInt(jSONObject2.getString("chatType"));
                                    intent7.putExtra("chatType", parseInt);
                                    if (parseInt == 1) {
                                        intent7.putExtra("userId", jSONObject2.getString("userId"));
                                    } else {
                                        intent7.putExtra("groupId", jSONObject2.getString("groupId"));
                                    }
                                    intent7.setFlags(335544320);
                                    context.startActivity(intent7);
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            }
                        } else if (LoginUser.getLoginUser().getSysType() == 2) {
                            if (jSONObject2.has("url") && !TextUtils.isEmpty(jSONObject2.getString("url"))) {
                                intent3 = new Intent(context, H5AppActivity.class);
                                extras.putString("url", jSONObject2.getString("url"));
                                extras.putString("title", jSONObject2.getString("title"));
                            } else {
                                intent3 = new Intent(context, com.bxkj.student.v2.ui.MainActivity.class);
                            }
                            intent3.putExtras(extras);
                            intent3.setFlags(268435456);
                            context.startActivity(intent3);
                        } else {
                            if (jSONObject2.has("url") && !TextUtils.isEmpty(jSONObject2.getString("url"))) {
                                intent2 = new Intent(context, H5DetailActivity.class);
                                extras.putString("url", jSONObject2.getString("url"));
                                extras.putString("title", jSONObject2.getString("title"));
                            } else {
                                intent2 = new Intent(context, MainActivity.class);
                            }
                            intent2.putExtras(extras);
                            intent2.setFlags(268435456);
                            context.startActivity(intent2);
                        }
                    } catch (JSONException unused) {
                        Log.e(f19568a, "Get message extra JSON error!");
                    }
                } else if (JPushInterface.ACTION_RICHPUSH_CALLBACK.equals(intent.getAction())) {
                    Log.d(f19568a, "[JPushReceiver] \u7528\u6237\u6536\u5230\u5230RICH PUSH CALLBACK: " + string2);
                } else if (JPushInterface.ACTION_CONNECTION_CHANGE.equals(intent.getAction())) {
                    boolean booleanExtra = intent.getBooleanExtra(JPushInterface.EXTRA_CONNECTION_CHANGE, false);
                    Log.w(f19568a, "[JPushReceiver]" + intent.getAction() + " connected state change to " + booleanExtra);
                } else {
                    Log.d(f19568a, "[JPushReceiver] Unhandled intent - " + intent.getAction());
                }
            }
        } catch (Exception unused2) {
        }
    }
}

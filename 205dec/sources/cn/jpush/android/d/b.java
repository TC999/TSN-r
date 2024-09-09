package cn.jpush.android.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {
    public static CustomMessage a(Intent intent) {
        String stringExtra;
        CustomMessage customMessage;
        CustomMessage customMessage2 = null;
        try {
            stringExtra = intent.getStringExtra("msgid");
            customMessage = new CustomMessage();
        } catch (Throwable th) {
            th = th;
        }
        try {
            customMessage.messageId = stringExtra;
            customMessage.appId = intent.getStringExtra("appId");
            customMessage.senderId = intent.getStringExtra("senderId");
            String stringExtra2 = intent.getStringExtra("data");
            if (stringExtra2 != null) {
                JSONObject jSONObject = new JSONObject(stringExtra2);
                customMessage.message = jSONObject.optString("message", "");
                customMessage.contentType = jSONObject.optString("content_type", "");
                customMessage.title = jSONObject.optString("title", "");
                customMessage.extra = jSONObject.optString("extras", "");
            }
            if (JPushConstants.SDK_VERSION_CODE >= 387) {
                customMessage.platform = intent.getByteExtra("platform", (byte) 0);
            }
            d.a(stringExtra, intent.getStringExtra("_j_data_"));
            return customMessage;
        } catch (Throwable th2) {
            th = th2;
            customMessage2 = customMessage;
            Logger.w("MessageHelper", "processMessage failed:" + th.getMessage());
            return customMessage2;
        }
    }

    private static cn.jpush.android.b.b a(d dVar) {
        try {
            cn.jpush.android.b.b a4 = cn.jpush.android.b.b.a(new JSONObject(dVar.f4132i).optJSONObject("geofence"));
            if (a4 != null) {
                a4.f4093t = dVar;
                return a4;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void a(Context context, int i4, long j4, long j5, String str) {
        JCoreHelper.sendData(context, JPushConstants.SDK_TYPE, 4, 3, j5, cn.jpush.android.z.b.a(0, (byte) i4, j4, str));
        try {
            int optInt = new JSONObject(str).optInt("data_msgtype");
            Logger.d("MessageHelper", " data_msgtype=" + optInt);
            if (1 == optInt || 3 == optInt || 5 == optInt) {
                cn.jpush.android.helper.c.a(j4 + "", 1108L, context);
            } else if (32 == optInt) {
                cn.jpush.android.helper.c.a(context, j4 + "", 1000L, 4);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, int i4, String str, String str2, String str3, long j4, byte b4) {
        if (!str2.equals(context.getPackageName())) {
            Logger.e("MessageHelper", "msg appId is not mine pkgname,appid:" + str2 + ",pkgname:" + context.getPackageName());
            return;
        }
        Logger.d("MessageHelper", "action:receivedPushMessage msgId = " + j4);
        d a4 = d.a(str, str2, str3, j4);
        if (a4 == null) {
            return;
        }
        if (a(i4, a4)) {
            Logger.d("MessageHelper", "ssp notification, msgType: " + i4);
        } else if (c.a(context, a4.a()) || cn.jpush.android.x.d.a(context, a4.f4127d, a4.f4131h)) {
        } else {
            if (b4 != 0) {
                a4.ah = b4;
            }
            a4.f4124a = i4;
            cn.jpush.android.b.b a5 = a(a4);
            if (a5 != null && !TextUtils.isEmpty(a5.f4074a)) {
                cn.jpush.android.b.d.a(context).a(a5);
                return;
            }
            d a6 = d.a(context, a4);
            if (a6 != null) {
                Logger.dd("MessageHelper", "notify inapp message received");
                a6.f4124a = i4;
                a6.ay = i4;
                cn.jpush.android.q.a.a().a(context, a4, a4.f4127d);
            } else if (i4 == 115) {
                cn.jpush.android.q.a.a().a(context, d.a(a4), a4.f4127d);
            } else {
                a(context, a4);
            }
        }
    }

    public static void a(Context context, d dVar) {
        Logger.d("MessageHelper", "processBasicEntity type:" + dVar.f4129f);
        int i4 = dVar.f4134k ? dVar.f4133j == 4 ? 3 : 1 : 2;
        dVar.f4129f = i4;
        if ((i4 & 2) != 0) {
            Logger.d("MessageHelper", "processBasicEntity user-defined message.");
            if (TextUtils.isEmpty(dVar.f4137n) && TextUtils.isEmpty(dVar.f4140q)) {
                Logger.ww("MessageHelper", "no message or extra send to user");
            } else {
                b(context, dVar);
            }
        }
        if ((dVar.f4129f & 1) != 0) {
            Logger.d("MessageHelper", "processBasicEntity notification");
            if (cn.jpush.android.cache.a.d(context)) {
                Logger.i("MessageHelper", "Service is stoped, give up all the message");
                return;
            }
            dVar.a(context);
            if (cn.jpush.android.x.b.b(context)) {
                cn.jpush.android.x.d.b(context, dVar.f4127d);
                cn.jpush.android.x.b.a(context, dVar);
                return;
            }
            cn.jpush.android.helper.c.a(dVar.f4127d, 986L, context);
            Logger.ii("MessageHelper", "push is invalidPushTime\uff0cIntercept the message");
        }
    }

    public static void a(Context context, cn.jpush.android.z.c cVar) {
        String d4 = d.d(cVar.c());
        a(context, cVar.a(), cVar.b(), cVar.getRid(), d4);
        long b4 = cVar.b();
        int a4 = cVar.a();
        String c4 = cVar.c();
        Logger.d("MessageHelper", "msgType = " + a4 + ", msgId = " + b4 + ", jdata = " + d4);
        StringBuilder sb = new StringBuilder();
        sb.append("msgContent: \n");
        sb.append(c4);
        Logger.v("MessageHelper", sb.toString());
        Logger.d("MessageHelper", "msgContent size:" + c4.getBytes().length);
        LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(c4));
        try {
            String readLine = lineNumberReader.readLine();
            String readLine2 = lineNumberReader.readLine();
            if (readLine == null) {
                Logger.e("MessageHelper", "NO appId");
            } else if (readLine2 == null) {
                Logger.e("MessageHelper", "NO senderId");
            } else {
                int length = readLine.length() + readLine2.length() + 2;
                if (c4.length() <= length + 1) {
                    Logger.d("MessageHelper", "No msgContent");
                    return;
                }
                String substring = c4.substring(length);
                if (!readLine2.equals(JCoreHelper.getAppKey(context))) {
                    Logger.e("MessageHelper", "msg senderId is not mine appkey,senderId:" + readLine2 + ",appkey:" + JCoreHelper.getAppKey(context));
                    return;
                }
                Logger.v("MessageHelper", "Message Fields - appId:" + readLine + ", senderId:" + readLine2 + ", msgContent:" + substring + ", contentLen: " + substring.length());
                if (a4 != 0 && a4 != 2) {
                    if (a4 == 20) {
                        cn.jpush.android.ab.b.a(context, substring, 0, -1L, -1);
                        return;
                    } else if (a4 != 115 && a4 != 100 && a4 != 101 && a4 != 103 && a4 != 104) {
                        Logger.d("MessageHelper", "unknown msg type, type: " + a4);
                        return;
                    }
                }
                a(context, a4, substring, readLine, readLine2, b4, (byte) 0);
            }
        } catch (Throwable th) {
            Logger.e("MessageHelper", "Parse msgContent failed", th);
        }
    }

    public static boolean a(int i4, d dVar) {
        String str = "";
        if (dVar != null && i4 == 0) {
            try {
                JSONObject optJSONObject = new JSONObject(dVar.f4132i).optJSONObject("m_content");
                if (optJSONObject != null) {
                    str = optJSONObject.optString("n_source", "");
                }
            } catch (Throwable unused) {
            }
            return TextUtils.equals(str, "ssp");
        }
        return false;
    }

    public static void b(Context context, d dVar) {
        try {
            String messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
            if (TextUtils.isEmpty(messageReceiverClass)) {
                Logger.dd("MessageHelper", "not found user push message,use old action to user");
                Intent intent = new Intent(JPushInterface.ACTION_MESSAGE_RECEIVED);
                intent.putExtra(JPushInterface.EXTRA_APP_KEY, dVar.f4126c);
                intent.putExtra(JPushInterface.EXTRA_MESSAGE, dVar.f4137n);
                intent.putExtra(JPushInterface.EXTRA_CONTENT_TYPE, dVar.f4138o);
                intent.putExtra(JPushInterface.EXTRA_TITLE, dVar.f4139p);
                intent.putExtra(JPushInterface.EXTRA_EXTRA, dVar.f4140q);
                intent.putExtra(JPushInterface.EXTRA_MSG_ID, dVar.f4127d);
                if (JPushConstants.SDK_VERSION_CODE >= 387) {
                    intent.putExtra(JPushInterface.EXTRA_TYPE_PLATFORM, dVar.ah);
                }
                intent.addCategory(dVar.f4125b);
                intent.setPackage(context.getPackageName());
                Locale locale = Locale.ENGLISH;
                context.sendBroadcast(intent, String.format(locale, "%s.permission.JPUSH_MESSAGE", dVar.f4125b));
                Logger.i("MessageHelper", "Send broadcast to app: " + String.format(locale, "%s.permission.JPUSH_MESSAGE", dVar.f4125b));
            } else {
                Intent intent2 = new Intent(context, Class.forName(messageReceiverClass));
                intent2.setAction(cn.jpush.android.ad.a.e(context, "custom_msg"));
                intent2.putExtra("data", dVar.f4132i);
                intent2.putExtra("msgid", dVar.f4127d);
                intent2.putExtra("appId", dVar.f4125b);
                intent2.putExtra("senderId", dVar.f4126c);
                intent2.putExtra("platform", dVar.ah);
                intent2.putExtra("_j_data_", dVar.f4130g);
                if (JPushConstants.getPushMessageReceiver(context) != null) {
                    JPushConstants.getPushMessageReceiver(context).onMessage(context, a(intent2));
                } else {
                    cn.jpush.android.helper.a.a(context, intent2);
                }
            }
            byte b4 = dVar.ah;
            if (b4 != 0) {
                cn.jpush.android.helper.c.a(dVar.f4127d, "", b4, 1106L, context);
            } else {
                cn.jpush.android.helper.c.a(dVar.f4127d, 1106L, context);
            }
        } catch (Throwable th) {
            Logger.e("MessageHelper", "sendBroadcastToApp error:" + th.getMessage());
        }
    }
}

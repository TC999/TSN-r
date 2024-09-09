package cn.jpush.android.ab;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.ad.h;
import cn.jpush.android.api.CallBackParams;
import cn.jpush.android.api.InAppSlotParams;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.helper.f;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.TagAliasReceiver;
import com.acse.ottn.f3;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static ConcurrentLinkedQueue<Long> f3907a = new ConcurrentLinkedQueue<>();

    private static int a(long j4) {
        if (f3907a.size() >= 10) {
            long longValue = j4 - f3907a.element().longValue();
            if (longValue < 0) {
                f3907a.clear();
                return 2;
            } else if (longValue <= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                return 1;
            } else {
                while (f3907a.size() >= 10) {
                    f3907a.poll();
                }
            }
        }
        f3907a.offer(Long.valueOf(j4));
        return 0;
    }

    public static long a(Context context, String str, int i4, long j4, int i5) {
        Logger.d("TagAliasHelper", "action - onRecvTagAliasCallBack");
        try {
            if (i4 == 4) {
                a.a(context, j4, i5);
                return j4;
            }
            JSONObject jSONObject = null;
            if (i4 != 3) {
                jSONObject = new JSONObject(str);
                i5 = jSONObject.optInt("code", JPushInterface.ErrorCode.UNKNOWN_ERROR);
                if (i4 == 0) {
                    j4 = jSONObject.optLong(InAppSlotParams.SLOT_KEY.SEQ);
                }
            }
            int i6 = i5;
            JSONObject jSONObject2 = jSONObject;
            Intent intent = new Intent();
            if (i4 == 0) {
                intent.setAction(TagAliasReceiver.ACTION_TAG_ALIAS_CALLBACK);
            } else {
                String messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
                if (!TextUtils.isEmpty(messageReceiverClass)) {
                    intent = new Intent(context, Class.forName(messageReceiverClass));
                }
                intent.setAction("tag_alias_message");
                if (i4 == 1) {
                    intent.putExtra("message_type", 1);
                } else if (i4 == 3) {
                    intent.putExtra("message_type", 3);
                    intent.putExtra("message_des", str);
                } else {
                    intent.putExtra("message_type", 2);
                }
            }
            intent.addCategory(context.getPackageName());
            intent.putExtra("proto_type", i4);
            intent.setPackage(context.getPackageName());
            intent.putExtra(TagAliasReceiver.KEY_TAGALIASOPERATOR_CALLBACKCODE, i6);
            intent.putExtra(TagAliasReceiver.KEY_TAGALIASOPERATOR_SEQID, j4);
            Intent a4 = i4 != 3 ? c.a().a(context, j4, i6, jSONObject2, intent) : c.a().a(context, j4, i6, intent);
            if (a4 != null) {
                cn.jpush.android.helper.a.a(context, a4);
            }
            return j4;
        } catch (Throwable unused) {
            Logger.w("TagAliasHelper", "tagalias msgContent:" + str);
            return -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String a(Context context, String str, long j4, int i4) {
        String jSONObject;
        if (c(i4)) {
            try {
                JSONObject a4 = a(i4);
                if (b(2, i4)) {
                    if (TextUtils.isEmpty(str)) {
                        Logger.ee("TagAliasHelper", "alias was empty. Give up action.");
                        a(context, 2, JPushInterface.ErrorCode.NULL_TAGANDALIAS, j4);
                        return null;
                    } else if (!a(context, 2, str, j4)) {
                        return null;
                    } else {
                        a4.put("alias", str);
                    }
                }
                jSONObject = a4.toString();
                Logger.d("TagAliasHelper", "alias str:" + jSONObject);
            } catch (Throwable th) {
                Logger.w("TagAliasHelper", "alias exception:" + th);
            }
            if (TextUtils.isEmpty(jSONObject)) {
                Logger.d("TagAliasHelper", "alias request action was empty");
                return null;
            }
            return jSONObject;
        }
        Logger.e("TagAliasHelper", "unsupport alias action type");
        a(context, 2, JPushInterface.ErrorCode.UNKNOWN_ERROR, j4);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v4, types: [org.json.JSONArray] */
    public static String a(Context context, List<String> list, long j4, int i4, int i5, int i6) {
        String jSONObject;
        if (i4 != 0) {
            try {
                JSONObject a4 = a(i4);
                if (a(1, i4)) {
                    if (list != null && !list.isEmpty()) {
                        HashSet hashSet = new HashSet(list);
                        if (!a(context, 1, hashSet, j4)) {
                            return null;
                        }
                        Object b4 = b(hashSet);
                        if (!b(context, b4, j4, 1)) {
                            return null;
                        }
                        if (i4 != 6) {
                            b4 = new JSONArray();
                            for (String str : list) {
                                b4.put(str);
                            }
                        } else if (TextUtils.isEmpty(b4)) {
                            Logger.ee("TagAliasHelper", "stags was empty. Give up action.");
                            a(context, 1, JPushInterface.ErrorCode.NULL_TAGANDALIAS, j4);
                            return null;
                        }
                        a4.put("tags", b4);
                    }
                    Logger.ee("TagAliasHelper", "tags was empty. Give up action.");
                    a(context, 1, JPushInterface.ErrorCode.NULL_TAGANDALIAS, j4);
                    return null;
                }
                if (i4 == 5) {
                    if (i6 == -1) {
                        i6 = 1;
                    }
                    a4.put("curr", i6);
                }
                jSONObject = a4.toString();
                Logger.d("TagAliasHelper", "tag str:" + jSONObject);
            } catch (Throwable th) {
                Logger.w("TagAliasHelper", "tag exception:" + th);
            }
            if (TextUtils.isEmpty(jSONObject)) {
                Logger.d("TagAliasHelper", "tag request action was empty");
                return null;
            }
            return jSONObject;
        }
        Logger.e("TagAliasHelper", "unsupport tag action type");
        a(context, 1, JPushInterface.ErrorCode.UNKNOWN_ERROR, j4);
        return null;
    }

    private static String a(Context context, List<String> list, String str, long j4) {
        String jSONObject;
        HashSet hashSet = list != null ? new HashSet(list) : null;
        if (str == null || a(context, 0, str, j4)) {
            if (hashSet == null || a(context, 0, hashSet, j4)) {
                String b4 = b(hashSet);
                if (b(context, b4, j4, 0)) {
                    if (b4 == null && str == null) {
                        Logger.ee("TagAliasHelper", "NULL alias and tags. Give up action.");
                        a(context, 0, JPushInterface.ErrorCode.NULL_TAGANDALIAS, j4);
                        return null;
                    }
                    Logger.dd("TagAliasHelper", "action:setAliasAndTags - alias:" + str + ", tags:" + b4);
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("platform", "a");
                        if (str != null) {
                            jSONObject2.put("alias", str);
                        }
                        if (hashSet != null) {
                            jSONObject2.put("tags", b4);
                        }
                        jSONObject = jSONObject2.toString();
                        Logger.d("TagAliasHelper", "tagalias str:" + jSONObject);
                    } catch (Throwable th) {
                        Logger.w("TagAliasHelper", "tagalias exception:" + th);
                        a(context, 0, JPushInterface.ErrorCode.UNKNOWN_ERROR, j4);
                    }
                    if (TextUtils.isEmpty(jSONObject)) {
                        Logger.d("TagAliasHelper", "tagalias request action was empty");
                        return null;
                    }
                    return jSONObject;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String a(Context context, Map<String, Object> map, long j4, int i4) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (d(i4)) {
            try {
                jSONObject = new JSONObject();
                jSONObject2 = new JSONObject();
            } catch (Throwable th) {
                Logger.w("TagAliasHelper", "pros exception:" + th);
            }
            if (i4 == 2) {
                return jSONObject.toString();
            }
            if (map.isEmpty()) {
                Logger.ee("TagAliasHelper", "pros was empty. Give up action.");
                a(context, 3, JPushInterface.ErrorCode.NULL_TAGANDALIAS, j4);
                return null;
            }
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                if (TextUtils.isEmpty(key)) {
                    Logger.ee("TagAliasHelper", "pros key was empty. Give up action.");
                    a(context, 3, JPushInterface.ErrorCode.NULL_TAGANDALIAS, j4);
                    return null;
                }
                Object value = entry.getValue();
                if (!(value instanceof Integer) && !(value instanceof Boolean)) {
                    if (value instanceof Date) {
                        value = ((Date) value).getTime() + "";
                    } else if (!(value instanceof String)) {
                        jSONObject2.put(key, value);
                    }
                    jSONObject.put(key, value);
                }
                value = value + "";
                jSONObject.put(key, value);
            }
            String jSONObject3 = jSONObject2.toString();
            if (!TextUtils.isEmpty(jSONObject3) && !jSONObject3.equals("{}")) {
                a(context, jSONObject3, 3, j4, JPushInterface.ErrorCode.ERROR_CODE_PROPERTY_ERROR);
                return null;
            } else if (TextUtils.isEmpty(jSONObject.toString())) {
                Logger.d("TagAliasHelper", "pros request action was empty");
                return null;
            } else {
                return jSONObject.toString();
            }
        }
        Logger.e("TagAliasHelper", "unsupport pros action type");
        a(context, 3, JPushInterface.ErrorCode.UNKNOWN_ERROR, j4);
        return null;
    }

    public static Set<String> a(Set<String> set) {
        if (set == null) {
            return null;
        }
        if (set.isEmpty()) {
            return set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i4 = 0;
        for (String str : set) {
            if (TextUtils.isEmpty(str) || !h.a(str)) {
                Logger.ee("TagAliasHelper", "Invalid tag : " + str);
            } else {
                linkedHashSet.add(str);
                i4++;
                if (i4 >= 1000) {
                    Logger.ww("TagAliasHelper", "The lenght of tags maybe more than 1000.");
                    return linkedHashSet;
                }
            }
        }
        return linkedHashSet;
    }

    private static JSONObject a(int i4) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", "a");
        jSONObject.put("op", b(i4));
        return jSONObject;
    }

    public static void a(Context context, int i4, int i5, long j4) {
        a(context, i4, i5, j4, -1);
    }

    public static void a(Context context, int i4, int i5, long j4, int i6) {
        try {
            if (i4 == 4) {
                a.a(context, i5, i6);
                return;
            }
            Intent intent = new Intent();
            intent.addCategory(context.getPackageName());
            intent.setPackage(context.getPackageName());
            if (i4 == 0) {
                intent.setAction(TagAliasReceiver.ACTION_TAG_ALIAS_CALLBACK);
            } else {
                intent.setAction("tag_alias_message");
                intent.setClass(context, Class.forName(JPushConstants.getMessageReceiverClass(context)));
                int i7 = 1;
                if (i4 != 1) {
                    i7 = 3;
                    if (i4 != 3) {
                        intent.putExtra("message_type", 2);
                    }
                }
                intent.putExtra("message_type", i7);
            }
            intent.putExtra(TagAliasReceiver.KEY_TAGALIASOPERATOR_CALLBACKCODE, i5);
            intent.putExtra(TagAliasReceiver.KEY_TAGALIASOPERATOR_SEQID, j4);
            cn.jpush.android.helper.a.a(context, intent);
        } catch (Throwable th) {
            Logger.ww("TagAliasHelper", "NotifyTagAliasError:" + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, int i4, long j4, String str) {
        Logger.dd("TagAliasHelper", "tagalias:" + str);
        if (str == null) {
            Logger.w("TagAliasHelper", "tagaliasRequest was null");
            return;
        }
        int i5 = i4 == 0 ? 10 : i4 == 1 ? 28 : 29;
        JCoreHelper.sendRequest(context, JPushConstants.SDK_TYPE, i5, i4 == 0 ? 4 : i4 == 1 ? 1 : 2, j4, 20000L, cn.jpush.android.z.b.a(JCoreHelper.getAppKey(context), i5, str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, long j4, int i4) {
        Logger.dd("TagAliasHelper", " protoType=" + i4);
        JCoreHelper.sendRequest(context, JPushConstants.SDK_TYPE, 40, 1, j4, 20000L, cn.jpush.android.z.b.a(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, long j4, String str, int i4) {
        Logger.dd("TagAliasHelper", "pros:" + str + " protoType=" + i4);
        if (str != null) {
            JCoreHelper.sendRequest(context, JPushConstants.SDK_TYPE, 38, 0, j4, 20000L, cn.jpush.android.z.b.a(i4, str));
        } else {
            Logger.w("TagAliasHelper", "prosRequest was null");
        }
    }

    public static void a(Context context, Bundle bundle) {
        int i4;
        int i5;
        ArrayList<String> arrayList;
        int i6;
        int i7;
        long j4;
        CallBackParams callBackParams;
        String str;
        int i8;
        ArrayList<String> arrayList2;
        String string = bundle.getString("alias");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("tags");
        CallBackParams callBackParams2 = (CallBackParams) bundle.getSerializable("callback");
        long j5 = bundle.getLong("seq", 0L);
        try {
            i4 = Integer.parseInt(bundle.getString("proto_type"));
        } catch (Throwable th) {
            Logger.w("TagAliasHelper", "load tag/alias proto type failed - error:" + th);
            a(context, 0, JPushInterface.ErrorCode.UNKNOWN_ERROR, j5);
            i4 = 0;
        }
        try {
            i5 = Integer.parseInt(bundle.getString("action_type"));
        } catch (Throwable th2) {
            Logger.w("TagAliasHelper", "load tag/alias action type failed - error:" + th2);
            a(context, i4, JPushInterface.ErrorCode.UNKNOWN_ERROR, j5);
            i5 = 0;
        }
        if (i4 == 4 && cn.jpush.android.cache.a.b(context, 0)) {
            a.a(context, 1, i5);
        } else if (cn.jpush.android.cache.a.d(context)) {
            a(context, i4, JPushInterface.ErrorCode.PUSH_STOPED, j5, i5);
        } else {
            int a4 = a(System.currentTimeMillis());
            if (a4 != 0) {
                Logger.w("TagAliasHelper", a4 == 1 ? "set tags/alias too soon,over 10 times in 10s" : "set tags/alias failed,time shaft error\uff0cplease try again");
                a(context, i4, a4 == 1 ? JPushInterface.ErrorCode.INVOKE_TOO_SOON : JPushInterface.ErrorCode.INCORRECT_TIME, j5, i5);
            } else if (c.a().a(context, i4, j5, i5)) {
                a(context, i4, JPushInterface.ErrorCode.ERROR_CODE_SERVER_UNAVAILABLE, j5, i5);
            } else {
                String str2 = null;
                if (i4 == 0) {
                    Logger.d("TagAliasHelper", "old tag/alias proto");
                    str2 = a(context, stringArrayList, string, j5);
                    arrayList = stringArrayList;
                    i6 = 2;
                    i7 = i4;
                } else if (i4 == 1) {
                    i6 = 2;
                    arrayList = stringArrayList;
                    i7 = i4;
                    str2 = a(context, stringArrayList, j5, i5, -1, -1);
                } else {
                    arrayList = stringArrayList;
                    i6 = 2;
                    i7 = i4;
                    if (i7 == 2) {
                        str2 = a(context, string, j5, i5);
                    } else if (i7 == 3) {
                        str2 = a(context, callBackParams2.pros, j5, i5);
                    }
                }
                Logger.d("TagAliasHelper", "onPushServiceTagAliasAction request=" + str2);
                if (str2 == null || !(i7 == 1 || i7 == i6)) {
                    j4 = j5;
                    callBackParams = callBackParams2;
                    str = string;
                    i8 = i7;
                    arrayList2 = arrayList;
                } else if (!c.a().a(i7)) {
                    int i9 = i7;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i9 == 1 ? "tag" : "alias");
                    sb.append(" is operatoring, please wait last operator complete");
                    Logger.w("TagAliasHelper", sb.toString());
                    a(context, i9, i9 == 1 ? JPushInterface.ErrorCode.ERROR_CODE_TAG_OPERATORING : JPushInterface.ErrorCode.ERROR_CODE_ALIAS_OPERATORING, j5);
                    return;
                } else {
                    j4 = j5;
                    callBackParams = callBackParams2;
                    str = string;
                    i8 = i7;
                    arrayList2 = arrayList;
                    c.a().a(i7, i5, j4, arrayList2, str, null);
                }
                if (str2 != null && i8 == 3) {
                    if (!c.a().a(i8)) {
                        Logger.w("TagAliasHelper", "pros is operatoring, please wait last operator complete");
                        a(context, i8, JPushInterface.ErrorCode.ERROR_CODE_PROPERTIES_OPERATORING, j4);
                        return;
                    }
                    c.a().a(i8, i5, j4, arrayList2, str, callBackParams.pros);
                }
                if (i8 == 4) {
                    if (!c.a().a(i8)) {
                        Logger.w("TagAliasHelper", "push status is operatoring, please wait last operator complete");
                        a(context, i8, JPushInterface.ErrorCode.ERROR_CODE_PROPERTIES_OPERATORING, j4, i5);
                        return;
                    }
                    c.a().a(i8, i5, j4, null, null, null);
                }
                if (i8 == 3) {
                    a(context, j4, str2, callBackParams.action);
                } else if (i8 == 4) {
                    a(context, j4, callBackParams.action);
                } else {
                    a(context, i8, j4, str2);
                }
            }
        }
    }

    public static void a(Context context, String str, Set<String> set, CallBackParams callBackParams) {
        int i4;
        long a4 = f.a();
        if (callBackParams != null) {
            d.a().a(context, Long.valueOf(a4), callBackParams);
        }
        if (!(context instanceof Application)) {
            context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (callBackParams != null && callBackParams.protoType == 0) {
            d.a().a(context);
        }
        Bundle bundle = new Bundle();
        bundle.putString("alias", str);
        bundle.putStringArrayList("tags", set != null ? new ArrayList<>(set) : null);
        if (callBackParams != null && (((i4 = callBackParams.protoType) == 3 && callBackParams.pros != null) || i4 == 4)) {
            bundle.putSerializable("callback", callBackParams);
        }
        bundle.putLong("seq", a4);
        StringBuilder sb = new StringBuilder();
        sb.append(callBackParams != null ? callBackParams.protoType : 0);
        sb.append("");
        bundle.putString("proto_type", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(callBackParams != null ? callBackParams.action : 0);
        sb2.append("");
        bundle.putString("action_type", sb2.toString());
        Logger.d("TagAliasHelper", "setAliasAndTags bundle=" + bundle);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "tagalis", bundle);
    }

    private static boolean a(int i4, int i5) {
        return i4 == 1 && (i5 == 1 || i5 == 2 || i5 == 3 || i5 == 6);
    }

    private static boolean a(Context context, int i4, String str, long j4) {
        int b4 = h.b(str);
        if (b4 != 0) {
            Logger.dd("TagAliasHelper", "Invalid alias: " + str + ", will not set alias this time.");
            a(context, i4, b4, j4);
            return false;
        }
        return true;
    }

    private static boolean a(Context context, int i4, Set<String> set, long j4) {
        int a4 = h.a(set);
        if (a4 != 0) {
            Logger.dd("TagAliasHelper", "Invalid tags, will not set tags this time.");
            a(context, i4, a4, j4);
            return false;
        }
        return true;
    }

    private static boolean a(String str, boolean z3) {
        int length = !TextUtils.isEmpty(str) ? str.getBytes().length + 0 : 0;
        Logger.v("TagAliasHelper", "tags length:" + length);
        if (z3) {
            if (length > 5000) {
                return false;
            }
        } else if (length > 7000) {
            return false;
        }
        return true;
    }

    private static String b(int i4) {
        switch (i4) {
            case 1:
                return "add";
            case 2:
                return f3.f5659h;
            case 3:
                return "del";
            case 4:
                return "clean";
            case 5:
                return f3.f5657f;
            case 6:
                return "valid";
            default:
                return null;
        }
    }

    public static String b(Set<String> set) {
        String str = null;
        if (set == null) {
            return null;
        }
        if (set.isEmpty()) {
            return "";
        }
        int i4 = 0;
        for (String str2 : set) {
            if (TextUtils.isEmpty(str2) || !h.a(str2)) {
                Logger.ee("TagAliasHelper", "Invalid tag: " + str2);
            } else {
                if (str != null) {
                    str2 = str + "," + str2;
                }
                i4++;
                if (i4 >= 1000) {
                    return str2;
                }
                str = str2;
            }
        }
        return str;
    }

    private static boolean b(int i4, int i5) {
        return i4 == 2 && i5 == 2;
    }

    private static boolean b(Context context, String str, long j4, int i4) {
        if (str != null) {
            if (!a(str.replaceAll(",", ""), i4 != 0)) {
                a(context, i4, JPushInterface.ErrorCode.TOO_LONG_TAGALIAS, j4);
                StringBuilder sb = new StringBuilder();
                sb.append("The length of tags should be less than ");
                sb.append(i4 != 0 ? 5000 : 7000);
                sb.append(" bytes.");
                Logger.ww("TagAliasHelper", sb.toString());
                return false;
            }
        }
        return true;
    }

    private static boolean c(int i4) {
        return i4 == 2 || i4 == 3 || i4 == 5;
    }

    private static boolean d(int i4) {
        return i4 == 0 || i4 == 1 || i4 == 2;
    }
}

package cn.jpush.android.ab;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import cn.jpush.android.ad.j;
import cn.jpush.android.api.CallBackParams;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.api.TagAliasCallback;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.service.TagAliasReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f3922a;

    /* renamed from: d  reason: collision with root package name */
    private static final Object f3923d = new Object();

    /* renamed from: b  reason: collision with root package name */
    private TagAliasReceiver f3924b;

    /* renamed from: c  reason: collision with root package name */
    private ConcurrentHashMap<Long, CallBackParams> f3925c = new ConcurrentHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private AtomicBoolean f3926e = new AtomicBoolean(false);

    private d() {
    }

    public static d a() {
        if (f3922a == null) {
            synchronized (f3923d) {
                if (f3922a == null) {
                    f3922a = new d();
                }
            }
        }
        return f3922a;
    }

    private String a(CallBackParams callBackParams) {
        if (callBackParams == null) {
            Logger.w("TagAliasOperator", "callBack was null");
            return null;
        }
        try {
            Set<String> set = callBackParams.tags;
            if (set != null && set.size() > 0) {
                return (String) callBackParams.tags.toArray()[0];
            }
        } catch (Throwable th) {
            Logger.d("TagAliasOperator", "get origin check tag failed, error:" + th);
        }
        return null;
    }

    private void a(Context context, int i4, long j4) {
        String str;
        if (i4 == JPushInterface.ErrorCode.TIMEOUT) {
            str = "action - onTimeout rid:" + j4;
        } else {
            str = "action - on send data over limit";
        }
        Logger.v("TagAliasOperator", str);
        CallBackParams a4 = a(j4);
        if (a4 != null) {
            b(j4);
            a(context, a4, i4, false);
            return;
        }
        Logger.w("TagAliasOperator", "tagalias callback is null; rid=" + j4);
    }

    private void a(Context context, int i4, long j4, Intent intent) {
        String str;
        Logger.v("TagAliasOperator", "SetAliasAndTags finish : errorCode:" + i4 + " rid:" + j4);
        CallBackParams a4 = a(j4);
        if (a4 == null) {
            Logger.w("TagAliasOperator", "tagalias callback is null; rid=" + j4);
            return;
        }
        a().b(j4);
        boolean z3 = false;
        if (intent != null) {
            try {
                int i5 = a4.action;
                if (i5 == 5) {
                    int i6 = a4.protoType;
                    if (i6 == 1) {
                        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tags");
                        if (stringArrayListExtra != null) {
                            a4.tags = new HashSet(stringArrayListExtra);
                            str = "all tags was loaded, value:" + a4.tags;
                        }
                    } else if (i6 == 2) {
                        a4.alias = intent.getStringExtra("alias");
                        str = "alias was loaded, value:" + a4.tags;
                    }
                    Logger.d("TagAliasOperator", str);
                } else if (i5 == 6) {
                    z3 = intent.getBooleanExtra("validated", false);
                }
            } catch (Throwable th) {
                Logger.d("TagAliasOperator", "get tag or alias failed - error:" + th);
            }
        }
        a(context, a4, i4, z3);
    }

    private void a(Context context, CallBackParams callBackParams, int i4, boolean z3) {
        Logger.d("TagAliasOperator", "action - invokeUserCallback, errorCode:" + i4 + ",callBack:" + callBackParams);
        if (callBackParams.protoType != 0) {
            Logger.w("TagAliasOperator", "new proto type do not call user callback");
            return;
        }
        TagAliasCallback tagAliasCallback = callBackParams.tagAliasCallBack;
        if (tagAliasCallback != null) {
            tagAliasCallback.gotResult(i4, callBackParams.alias, callBackParams.tags);
        }
    }

    private void c(Context context) {
        ConcurrentHashMap<Long, CallBackParams> concurrentHashMap = this.f3925c;
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Long, CallBackParams> entry : this.f3925c.entrySet()) {
            if (entry.getValue().isTimeOut(20000L)) {
                arrayList.add(entry.getKey());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Long l4 = (Long) it.next();
            Logger.w("TagAliasOperator", "cleanTimeOutCallback timeout rid:" + l4);
            a(context, JPushInterface.ErrorCode.TIMEOUT, l4.longValue());
        }
    }

    public CallBackParams a(long j4) {
        return this.f3925c.get(Long.valueOf(j4));
    }

    public JPushMessage a(Context context, Intent intent) {
        String str;
        long longExtra = intent.getLongExtra(TagAliasReceiver.KEY_TAGALIASOPERATOR_SEQID, -1L);
        boolean z3 = false;
        int intExtra = intent.getIntExtra(TagAliasReceiver.KEY_TAGALIASOPERATOR_CALLBACKCODE, 0);
        Logger.v("TagAliasOperator", "parseTagAliasResponse2JPushMessage, errorCode:" + intExtra + " rid:" + longExtra);
        CallBackParams a4 = a(longExtra);
        if (a4 == null) {
            Logger.w("TagAliasOperator", "tagalias callback is null; rid=" + longExtra);
            return null;
        }
        a().b(longExtra);
        if (intExtra == 0) {
            try {
                int i4 = a4.action;
                if (i4 == 5) {
                    int i5 = a4.protoType;
                    if (i5 == 1) {
                        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tags");
                        if (stringArrayListExtra != null) {
                            a4.tags = new HashSet(stringArrayListExtra);
                            str = "all tags was loaded, value:" + a4.tags;
                        }
                    } else if (i5 == 2) {
                        a4.alias = intent.getStringExtra("alias");
                        str = "alias was loaded, value:" + a4.tags;
                    }
                    Logger.d("TagAliasOperator", str);
                } else if (i4 == 6) {
                    z3 = intent.getBooleanExtra("validated", false);
                }
            } catch (Throwable th) {
                Logger.d("TagAliasOperator", "get tag or alias failed - error:" + th);
            }
        }
        JPushMessage jPushMessage = new JPushMessage();
        jPushMessage.setProtoType(a4.protoType);
        jPushMessage.setAction(a4.action);
        jPushMessage.setErrorCode(intExtra);
        jPushMessage.setSequence(a4.sequence);
        int i6 = a4.protoType;
        if (i6 == 1) {
            if (a4.action == 6) {
                jPushMessage.setCheckTag(a(a4));
                jPushMessage.setTagCheckStateResult(z3);
                jPushMessage.setTagCheckOperator(true);
            } else {
                jPushMessage.setTags(a4.tags);
            }
        } else if (i6 == 3) {
            try {
                String stringExtra = intent.getStringExtra("message_des");
                if (TextUtils.isEmpty(stringExtra)) {
                    jPushMessage.setPros(a4.pros);
                } else {
                    HashMap hashMap = new HashMap();
                    JSONObject jSONObject = new JSONObject(stringExtra);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject.get(next));
                    }
                    jPushMessage.setPros(hashMap);
                }
            } catch (Throwable th2) {
                Logger.d("TagAliasOperator", "pros des  failed - error:" + th2);
                jPushMessage.setPros(a4.pros);
            }
        } else {
            jPushMessage.setAlias(a4.alias);
        }
        return jPushMessage;
    }

    public synchronized void a(Context context) {
        if (this.f3926e.get()) {
            Logger.d("TagAliasOperator", "tag alias callback register is called");
        } else {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addCategory(context.getPackageName());
                intentFilter.addAction(TagAliasReceiver.ACTION_TAG_ALIAS_TIMEOUT);
                intentFilter.addAction(TagAliasReceiver.ACTION_TAG_ALIAS_CALLBACK);
                if (this.f3924b == null) {
                    this.f3924b = new TagAliasReceiver();
                }
                TagAliasReceiver tagAliasReceiver = this.f3924b;
                j.a(context, tagAliasReceiver, intentFilter, context.getPackageName() + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX, null);
                this.f3926e.set(true);
            } catch (Exception e4) {
                Logger.e("TagAliasOperator", "setTagAndAlias e:" + e4.getMessage());
            }
        }
    }

    public void a(Context context, long j4, int i4, Intent intent) {
        Logger.v("TagAliasOperator", "action - onTagAliasResponse rid:" + j4 + " tagAliasCallbacks :" + a().b());
        if (TagAliasReceiver.ACTION_TAG_ALIAS_TIMEOUT.equals(intent.getAction())) {
            a(context, i4, j4);
        } else {
            a(context, i4, j4, intent);
        }
        b(context);
    }

    public void a(Context context, Long l4, CallBackParams callBackParams) {
        c(context);
        this.f3925c.put(l4, callBackParams);
    }

    public ConcurrentHashMap<Long, CallBackParams> b() {
        return this.f3925c;
    }

    public void b(long j4) {
        this.f3925c.remove(Long.valueOf(j4));
    }

    public synchronized void b(Context context) {
        String str;
        String str2;
        ConcurrentHashMap<Long, CallBackParams> concurrentHashMap;
        String str3;
        String str4;
        c(context);
        if (this.f3926e.get() && (concurrentHashMap = this.f3925c) != null && concurrentHashMap.isEmpty()) {
            try {
                TagAliasReceiver tagAliasReceiver = this.f3924b;
                if (tagAliasReceiver != null) {
                    context.unregisterReceiver(tagAliasReceiver);
                    this.f3924b = null;
                }
            } catch (IllegalArgumentException e4) {
                e = e4;
                str3 = "TagAliasOperator";
                str4 = "Receiver not registered, cannot call unregisterReceiver";
                Logger.ww(str3, str4, e);
                this.f3926e.set(false);
                str = "TagAliasOperator";
                str2 = "unRegister tag alias callback";
                Logger.v(str, str2);
            } catch (Exception e5) {
                e = e5;
                str3 = "TagAliasOperator";
                str4 = "other exception";
                Logger.ww(str3, str4, e);
                this.f3926e.set(false);
                str = "TagAliasOperator";
                str2 = "unRegister tag alias callback";
                Logger.v(str, str2);
            }
            this.f3926e.set(false);
            str = "TagAliasOperator";
            str2 = "unRegister tag alias callback";
        } else {
            str = "TagAliasOperator";
            str2 = "tagAliasCallbacks is not empty";
        }
        Logger.v(str, str2);
    }
}

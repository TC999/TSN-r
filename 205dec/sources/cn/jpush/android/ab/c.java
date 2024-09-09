package cn.jpush.android.ab;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.service.TagAliasReceiver;
import com.acse.ottn.f3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f3908a;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f3909b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private ConcurrentHashMap<Long, a> f3910c = new ConcurrentHashMap<>();

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f3911a;

        /* renamed from: b  reason: collision with root package name */
        public int f3912b;

        /* renamed from: c  reason: collision with root package name */
        public long f3913c;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<String> f3914d;

        /* renamed from: e  reason: collision with root package name */
        public Map<String, Object> f3915e;

        /* renamed from: f  reason: collision with root package name */
        public String f3916f;

        /* renamed from: g  reason: collision with root package name */
        public int f3917g = -1;

        /* renamed from: h  reason: collision with root package name */
        public int f3918h = -1;

        /* renamed from: i  reason: collision with root package name */
        public int f3919i = 0;

        /* renamed from: j  reason: collision with root package name */
        public int f3920j;

        public a(int i4, int i5, long j4, ArrayList<String> arrayList, Map<String, Object> map, String str) {
            this.f3920j = 0;
            this.f3911a = i4;
            this.f3912b = i5;
            this.f3913c = j4;
            this.f3914d = arrayList;
            if (i4 == 1 && arrayList == null) {
                this.f3914d = new ArrayList<>();
            }
            this.f3915e = map;
            if (i4 == 3 && map == null) {
                this.f3915e = new HashMap();
            }
            this.f3916f = str;
            this.f3920j = 1;
        }

        public String toString() {
            return "TagAliasCacheBean{protoType=" + this.f3911a + ", actionType=" + this.f3912b + ", seqID=" + this.f3913c + ", tags=" + this.f3914d + ", pros=" + this.f3915e + ", alias='" + this.f3916f + "', totalPage=" + this.f3917g + ", currPage=" + this.f3918h + ", retryCount=" + this.f3919i + '}';
        }
    }

    private a a(JSONObject jSONObject, a aVar) {
        Logger.d("TagAliasNewProtoRetryHelper", "action - onUpdateCacheNode,responseJson:" + jSONObject + ",tagAliasCacheNode:" + aVar);
        if (aVar == null) {
            Logger.w("TagAliasNewProtoRetryHelper", "tagAliasCacheNode was null");
            return null;
        }
        if (TextUtils.equals(jSONObject.optString("op"), f3.f5657f)) {
            if (aVar.f3911a == 1) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("tags");
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        ArrayList arrayList = new ArrayList();
                        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                            arrayList.add(optJSONArray.getString(i4));
                        }
                        if (arrayList.size() > 0) {
                            aVar.f3914d.addAll(arrayList);
                        }
                    }
                } catch (Throwable th) {
                    Logger.e("TagAliasNewProtoRetryHelper", "parse tag list failed - error:" + th);
                }
            } else {
                String optString = jSONObject.optString("alias");
                if (optString != null) {
                    aVar.f3916f = optString;
                }
            }
        }
        return aVar;
    }

    public static c a() {
        if (f3908a == null) {
            synchronized (f3909b) {
                if (f3908a == null) {
                    f3908a = new c();
                }
            }
        }
        return f3908a;
    }

    private boolean a(Context context, int i4, a aVar) {
        int i5;
        Logger.d("TagAliasNewProtoRetryHelper", "action - CheckAndSendAgain, errorCode:" + i4 + ",tagAliasCacheNode:" + aVar);
        if (i4 == 1 && (i5 = aVar.f3919i) == 0) {
            aVar.f3919i = i5 + 1;
            if (a(context, aVar.f3911a, aVar.f3913c, aVar.f3912b)) {
                return true;
            }
            return b(context, aVar);
        }
        return false;
    }

    private boolean a(Context context, a aVar) {
        String str;
        if (aVar == null) {
            str = "tagAlias cache was null";
        } else {
            Logger.d("TagAliasNewProtoRetryHelper", "action - onTagAliasResponse, tagAliasCacheNode:" + aVar);
            if (aVar.f3918h < aVar.f3917g) {
                return true;
            }
            str = "all tags info was loaded";
        }
        Logger.d("TagAliasNewProtoRetryHelper", str);
        return false;
    }

    private boolean b(Context context, a aVar) {
        String str;
        String str2;
        Logger.d("TagAliasNewProtoRetryHelper", "action - onSendAgain, tagAliasCacheNode:" + aVar);
        if (aVar == null) {
            Logger.w("TagAliasNewProtoRetryHelper", "onSendAgain - tagAliasCacheNode was null");
            return false;
        }
        int i4 = aVar.f3911a;
        if (i4 == 1) {
            str = b.a(context, aVar.f3914d, aVar.f3913c, aVar.f3912b, aVar.f3917g, aVar.f3918h);
        } else if (i4 == 2) {
            str = b.a(context, aVar.f3916f, aVar.f3913c, i4);
        } else if (i4 == 3) {
            str = b.a(context, (Map<String, Object>) null, aVar.f3913c, aVar.f3912b);
        } else if (i4 != 4) {
            Logger.d("TagAliasNewProtoRetryHelper", "unsupport proto type");
            return false;
        } else {
            str = "PROTO_TYPE_PUSH_STATUS";
        }
        if (str != null) {
            if (aVar.f3919i > 200) {
                this.f3910c.remove(Long.valueOf(aVar.f3913c));
                b.a(context, aVar.f3911a, JPushInterface.ErrorCode.ERROR_CODE_TOO_BUSY, aVar.f3913c, aVar.f3912b);
                str2 = "same tag/alias request times greate than 200";
            } else {
                int i5 = aVar.f3911a;
                if (i5 == 3) {
                    b.a(context, aVar.f3913c, str, aVar.f3912b);
                } else if (i5 == 4) {
                    b.a(context, aVar.f3913c, aVar.f3912b);
                } else {
                    b.a(context, i5, aVar.f3913c, str);
                }
                aVar.f3919i++;
                this.f3910c.put(Long.valueOf(aVar.f3913c), aVar);
                str2 = "send request success";
            }
            Logger.d("TagAliasNewProtoRetryHelper", str2);
            return true;
        }
        return false;
    }

    public int a(int i4, int i5) {
        if (i4 == 0) {
            return i5;
        }
        if (i5 == 17) {
            try {
                return JPushInterface.ErrorCode.ERROR_CODE_ALIAS_LIMIT;
            } catch (Throwable unused) {
                return JPushInterface.ErrorCode.ERROR_CODE_INVALIDREQ;
            }
        } else if (i5 != 100) {
            if (i5 != 1013) {
                if (i5 != 1014) {
                    switch (i5) {
                        case 1:
                        case 2:
                            return JPushInterface.ErrorCode.ERROR_CODE_TOO_BUSY;
                        case 3:
                            return JPushInterface.ErrorCode.ERROR_CODE_BLACKLIST;
                        case 4:
                            return JPushInterface.ErrorCode.ERROR_CODE_INVALIDUSER;
                        case 5:
                            return JPushInterface.ErrorCode.ERROR_CODE_INVALIDREQ;
                        case 6:
                            return JPushInterface.ErrorCode.ERROR_CODE_INTERNEL_SERVER_ERROR;
                        case 7:
                        case 8:
                            return JPushInterface.ErrorCode.ERROR_CODE_GET_FAILED;
                        case 9:
                            return JPushInterface.ErrorCode.ERROR_CODE_TOO_MANY_TAGS;
                        default:
                            return i5;
                    }
                }
                return JPushInterface.ErrorCode.ERROR_CODE_PROPERTY_ERROR;
            }
            return JPushInterface.ErrorCode.ERROR_CODE_APPKEY_NOT_AUTH_TO_SET_PROPERTY;
        } else {
            return JPushInterface.ErrorCode.ERROR_CODE_SERVER_UNAVAILABLE;
        }
    }

    public int a(long j4) {
        Logger.d("TagAliasNewProtoRetryHelper", "action - onTagAliasTimeOut :" + j4);
        a remove = this.f3910c.remove(Long.valueOf(j4));
        Logger.d("TagAliasNewProtoRetryHelper", "onTagAliasTimeOut,removed cachenode:" + remove);
        if (remove != null) {
            return remove.f3911a;
        }
        return 0;
    }

    public Intent a(Context context, long j4, int i4, Intent intent) {
        Logger.d("TagAliasNewProtoRetryHelper", "action - onProsResponse, seqID:" + j4 + ",errorCode:" + i4 + ",intent:" + intent);
        a aVar = this.f3910c.get(Long.valueOf(j4));
        StringBuilder sb = new StringBuilder();
        sb.append("tagAliasCacheNode:");
        sb.append(aVar);
        Logger.d("TagAliasNewProtoRetryHelper", sb.toString());
        this.f3910c.remove(Long.valueOf(j4));
        if (aVar == null) {
            Logger.w("TagAliasNewProtoRetryHelper", "tagAliasCacheNode was null");
            return intent;
        } else if (a(context, i4, aVar)) {
            Logger.d("TagAliasNewProtoRetryHelper", "retry action was sended");
            return null;
        } else {
            if (i4 != 0) {
                int a4 = a(aVar.f3911a, i4);
                intent.putExtra(TagAliasReceiver.KEY_TAGALIASOPERATOR_CALLBACKCODE, a4);
                Logger.d("TagAliasNewProtoRetryHelper", "mapped errorCode:" + a4);
            }
            return intent;
        }
    }

    public Intent a(Context context, long j4, int i4, JSONObject jSONObject, Intent intent) {
        String str;
        String str2;
        Logger.d("TagAliasNewProtoRetryHelper", "action - onTagAliasResponse, seqID:" + j4 + ",errorCode:" + i4 + ",intent:" + intent);
        a aVar = this.f3910c.get(Long.valueOf(j4));
        StringBuilder sb = new StringBuilder();
        sb.append("tagAliasCacheNode:");
        sb.append(aVar);
        Logger.d("TagAliasNewProtoRetryHelper", sb.toString());
        this.f3910c.remove(Long.valueOf(j4));
        if (jSONObject == null) {
            Logger.w("TagAliasNewProtoRetryHelper", "responseJson was null");
            return intent;
        } else if (aVar == null) {
            Logger.w("TagAliasNewProtoRetryHelper", "tagAliasCacheNode was null");
            return intent;
        } else {
            if (!a(context, i4, aVar)) {
                if (i4 != 0) {
                    if (i4 == 100) {
                        long optLong = jSONObject.optLong("wait", -1L);
                        Logger.ww("TagAliasNewProtoRetryHelper", "set tag/alias action will freeze " + optLong + " seconds");
                        if (optLong > 0) {
                            cn.jpush.android.cache.a.a(context, optLong);
                        }
                    }
                    int a4 = a(aVar.f3911a, i4);
                    intent.putExtra(TagAliasReceiver.KEY_TAGALIASOPERATOR_CALLBACKCODE, a4);
                    Logger.d("TagAliasNewProtoRetryHelper", "mapped errorCode:" + a4);
                    return intent;
                }
                aVar.f3919i = 0;
                if (aVar.f3912b == 5) {
                    aVar.f3917g = jSONObject.optInt("total", -1);
                    aVar.f3918h = jSONObject.optInt("curr", -1);
                    a(jSONObject, aVar);
                }
                if (a(context, aVar)) {
                    aVar.f3918h++;
                    Logger.d("TagAliasNewProtoRetryHelper", "load next page, currpage:" + aVar.f3918h + ",totalPage:" + aVar.f3917g);
                    if (a(context, aVar.f3911a, aVar.f3913c, aVar.f3912b)) {
                        return null;
                    }
                    str2 = b(context, aVar) ? "get next page request was sended" : "get next page request was sended";
                }
                int i5 = aVar.f3912b;
                if (i5 == 5) {
                    int i6 = aVar.f3911a;
                    if (i6 == 1) {
                        if (aVar.f3914d.size() > 0) {
                            intent.putStringArrayListExtra("tags", aVar.f3914d);
                        }
                    } else if (i6 == 2 && (str = aVar.f3916f) != null) {
                        intent.putExtra("alias", str);
                    }
                } else if (i5 == 6) {
                    if (aVar.f3911a == 1) {
                        intent.putExtra("validated", jSONObject.optBoolean("validated", false));
                    } else {
                        Logger.w("TagAliasNewProtoRetryHelper", "unsupport  proto type");
                    }
                }
                return intent;
            }
            str2 = "retry action was sended";
            Logger.d("TagAliasNewProtoRetryHelper", str2);
            return null;
        }
    }

    public a a(Context context, long j4, int i4) {
        Logger.d("TagAliasNewProtoRetryHelper", "action - onProsResponse, seqID:" + j4 + ",errorCode:" + i4);
        a aVar = this.f3910c.get(Long.valueOf(j4));
        StringBuilder sb = new StringBuilder();
        sb.append("tagAliasCacheNode:");
        sb.append(aVar);
        Logger.d("TagAliasNewProtoRetryHelper", sb.toString());
        this.f3910c.remove(Long.valueOf(j4));
        if (aVar == null) {
            Logger.w("TagAliasNewProtoRetryHelper", "tagAliasCacheNode was null");
            return aVar;
        } else if (a(context, i4, aVar)) {
            Logger.d("TagAliasNewProtoRetryHelper", "retry action was sended");
            return null;
        } else {
            return aVar;
        }
    }

    public void a(int i4, int i5, long j4, ArrayList<String> arrayList, String str, Map<String, Object> map) {
        a aVar = new a(i4, i5, j4, arrayList, map, str);
        Logger.d("TagAliasNewProtoRetryHelper", "action - createNewCacheNode, tagAliasCacheNode:" + aVar);
        this.f3910c.put(Long.valueOf(j4), aVar);
    }

    public void a(Context context) {
        try {
            ConcurrentHashMap<Long, a> concurrentHashMap = this.f3910c;
            if (concurrentHashMap == null || concurrentHashMap.size() <= 0) {
                return;
            }
            for (Map.Entry<Long, a> entry : this.f3910c.entrySet()) {
                b(context, entry.getValue());
            }
        } catch (Throwable unused) {
        }
    }

    public boolean a(int i4) {
        ConcurrentHashMap<Long, a> concurrentHashMap = this.f3910c;
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            return true;
        }
        for (Map.Entry<Long, a> entry : this.f3910c.entrySet()) {
            a value = entry.getValue();
            if (value != null && value.f3911a == i4) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(Context context, int i4, long j4, int i5) {
        if ((i4 == 1 || i4 == 2 || i4 == 3 || i4 == 4) && cn.jpush.android.cache.a.j(context)) {
            Logger.w("TagAliasNewProtoRetryHelper", "tag/alias action was freezed");
            b.a(context, i4, JPushInterface.ErrorCode.ERROR_CODE_SERVER_UNAVAILABLE, j4, i5);
            return true;
        }
        return false;
    }
}

package cn.jiguang.ck;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.bq.d;
import cn.jiguang.g.b;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.api.InAppSlotParams;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Bundle f3427a = null;

    /* renamed from: b  reason: collision with root package name */
    private static long f3428b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static String f3429c = "ExceptionStatsManager";

    /* renamed from: d  reason: collision with root package name */
    private static String f3430d = "e_s.catch";

    /* renamed from: e  reason: collision with root package name */
    private static String f3431e = "data";

    /* renamed from: f  reason: collision with root package name */
    private static String f3432f = "exception_time";

    /* renamed from: g  reason: collision with root package name */
    private static String f3433g = "result";

    /* renamed from: h  reason: collision with root package name */
    private static String f3434h = "exception_type";

    /* renamed from: i  reason: collision with root package name */
    private static String f3435i = "extra";

    /* renamed from: j  reason: collision with root package name */
    private static String f3436j = "code";

    /* renamed from: k  reason: collision with root package name */
    private static long f3437k = 259200000;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cn.jiguang.ck.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static final class C0060a {

        /* renamed from: a  reason: collision with root package name */
        private static final a f3443a = new a();
    }

    private a() {
    }

    public static a a() {
        return C0060a.f3443a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a(Context context, JSONObject jSONObject, Bundle bundle) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Throwable unused) {
            }
        }
        if (TextUtils.isEmpty(bundle.getString(f3436j))) {
            return jSONObject;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (jSONObject.has(f3432f)) {
            JSONArray optJSONArray = jSONObject.optJSONArray(f3432f);
            int length = optJSONArray.length();
            if (length <= 1) {
                optJSONArray.put(currentTimeMillis / 1000);
            } else if (length > 1) {
                optJSONArray.put(1, currentTimeMillis / 1000);
            }
        } else {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(currentTimeMillis / 1000);
            b.a(context, cn.jiguang.g.a.W().a((cn.jiguang.g.a<Long>) Long.valueOf(currentTimeMillis)));
            jSONObject.put(f3432f, jSONArray);
        }
        String string = bundle.getString(f3436j);
        if (jSONObject.has(f3433g)) {
            String[] split = jSONObject.optString(f3433g).split("&");
            StringBuilder sb = new StringBuilder();
            boolean z3 = false;
            for (int i4 = 0; i4 < split.length; i4++) {
                String[] split2 = split[i4].split("_");
                String str = split2[0];
                int intValue = Integer.valueOf(split2[1]).intValue();
                sb.append(str);
                sb.append("_");
                if (string.equals(str)) {
                    sb.append(intValue + 1);
                    z3 = true;
                } else {
                    sb.append(intValue);
                }
                if (i4 != split.length - 1) {
                    sb.append("&");
                }
            }
            if (!z3) {
                sb.append("&");
                sb.append(string);
                sb.append("_1");
            }
            jSONObject.put(f3433g, sb.toString());
        } else {
            String str2 = f3433g;
            jSONObject.put(str2, string + "_1");
        }
        String str3 = f3434h;
        jSONObject.put(str3, bundle.getString(str3));
        jSONObject.put(f3435i, new JSONObject(bundle.getString(f3435i)));
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Bundle bundle) {
        Bundle bundle2;
        try {
            bundle2 = new Bundle();
            String str = f3435i;
            bundle2.putString(str, bundle.getString(str));
            String str2 = f3434h;
            bundle2.putString(str2, bundle.getString(str2));
            String str3 = f3436j;
            bundle2.putString(str3, bundle.getString(str3));
        } catch (Throwable unused) {
        }
        if (f3427a == null) {
            f3427a = bundle2;
            f3428b = System.currentTimeMillis();
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!a(f3427a, bundle2) || Math.abs(currentTimeMillis - f3428b) >= 300) {
            f3428b = currentTimeMillis;
            f3427a = bundle2;
            return false;
        }
        return true;
    }

    private boolean a(Bundle bundle, Bundle bundle2) {
        try {
            if (bundle.size() != bundle2.size()) {
                return false;
            }
            HashSet<String> hashSet = new HashSet(bundle.keySet());
            hashSet.addAll(bundle2.keySet());
            for (String str : hashSet) {
                if (bundle.containsKey(str) && bundle2.containsKey(str)) {
                    Object obj = bundle.get(str);
                    Object obj2 = bundle2.get(str);
                    if ((obj instanceof Bundle) && (obj2 instanceof Bundle) && !a((Bundle) obj, (Bundle) obj2)) {
                        return false;
                    }
                    if (obj == null) {
                        if (obj2 != null) {
                            return false;
                        }
                    } else if (!obj.equals(obj2)) {
                    }
                }
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArrayList<JSONArray> b(JSONArray jSONArray) {
        String str;
        StringBuilder sb;
        String message;
        if (jSONArray != null && jSONArray.length() != 0) {
            try {
                JSONArray jSONArray2 = new JSONArray();
                ArrayList<JSONArray> arrayList = new ArrayList<>();
                int i4 = 0;
                for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i5);
                    if (optJSONObject != null && optJSONObject.length() != 0) {
                        int length = optJSONObject.toString().getBytes("UTF-8").length;
                        i4 += length;
                        if (i4 > 102400) {
                            if (jSONArray2.length() > 0) {
                                arrayList.add(jSONArray2);
                            }
                            jSONArray2 = new JSONArray();
                            jSONArray2.put(optJSONObject);
                            i4 = length;
                        } else {
                            jSONArray2.put(optJSONObject);
                        }
                    }
                }
                if (jSONArray2.length() > 0) {
                    arrayList.add(jSONArray2);
                }
                return arrayList;
            } catch (UnsupportedEncodingException e4) {
                str = f3429c;
                sb = new StringBuilder();
                sb.append("partition exception:");
                message = e4.getMessage();
                sb.append(message);
                d.i(str, sb.toString());
                return null;
            } catch (Throwable th) {
                str = f3429c;
                sb = new StringBuilder();
                sb.append("partition throwable:");
                message = th.getMessage();
                sb.append(message);
                d.i(str, sb.toString());
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(Context context) {
        return Math.abs(System.currentTimeMillis() - ((Long) b.a(context, cn.jiguang.g.a.W())).longValue()) >= f3437k;
    }

    public void a(int i4) {
        Context context = JConstants.mApplicationContext;
        a(context, i4 + "", "2");
    }

    public void a(final Context context) {
        cn.jiguang.cm.d.a("DELAY_TASK", new cn.jiguang.cm.b() { // from class: cn.jiguang.ck.a.2
            @Override // cn.jiguang.cm.b
            public void a() {
                try {
                    Context context2 = context;
                    if (context2 == null) {
                        d.c(a.f3429c, "context is null,return");
                    } else if (!a.this.b(context2)) {
                        d.c(a.f3429c, "no report");
                    } else {
                        d.c(a.f3429c, "start to  report");
                        JSONObject jSONObject = (JSONObject) JCoreManager.onEvent(context, JConstants.SDK_TYPE, 42, null, null, a.f3430d);
                        if (jSONObject == null) {
                            jSONObject = new JSONObject();
                        }
                        JSONArray optJSONArray = jSONObject.optJSONArray(a.f3431e);
                        if (optJSONArray == null) {
                            optJSONArray = new JSONArray();
                        }
                        if (optJSONArray.length() == 0) {
                            d.c(a.f3429c, " report content is  null");
                            return;
                        }
                        ArrayList b4 = a.b(optJSONArray);
                        if (b4 != null && !b4.isEmpty()) {
                            int size = b4.size();
                            int i4 = 0;
                            while (i4 < size) {
                                JSONObject jSONObject2 = new JSONObject();
                                i4++;
                                jSONObject2.put("slice_index", i4);
                                jSONObject2.put("slice_count", size);
                                jSONObject2.put(a.f3431e, (JSONArray) b4.get(i4));
                                jSONObject2.put(InAppSlotParams.SLOT_KEY.SEQ, UUID.randomUUID().toString());
                                cn.jiguang.d.a.a(context, jSONObject2, "exception_stats");
                                JCoreManager.onEvent(context, JConstants.SDK_TYPE, 39, null, null, jSONObject2);
                            }
                            b.a(context, cn.jiguang.g.a.W().a((cn.jiguang.g.a<Long>) Long.valueOf(System.currentTimeMillis())));
                            context.deleteFile(a.f3430d);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }, 15000);
    }

    @TargetApi(19)
    public void a(final Context context, final Bundle bundle) {
        cn.jiguang.cm.d.a("FUTURE_TASK", new Runnable() { // from class: cn.jiguang.ck.a.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z3;
                JSONObject a4;
                synchronized (a.class) {
                    if (context == null) {
                        d.c(a.f3429c, "context is null,return");
                        return;
                    }
                    Bundle bundle2 = bundle;
                    if (bundle2 == null) {
                        d.c(a.f3429c, "bundle is null,return");
                        return;
                    }
                    String string = bundle2.getString(a.f3434h);
                    String str = a.f3429c;
                    d.c(str, " currentExceptionType=" + string);
                    if (TextUtils.isEmpty(string)) {
                        d.c(a.f3429c, "exception type is null,return");
                    } else if (string.equals("1") && a.this.a(bundle)) {
                        d.c(a.f3429c, "data is duplication,return");
                    } else {
                        String str2 = a.f3429c;
                        d.c(str2, "start to deal data=" + bundle);
                        try {
                            JSONObject jSONObject = (JSONObject) JCoreManager.onEvent(context, JConstants.SDK_TYPE, 42, null, null, a.f3430d);
                            if (jSONObject == null) {
                                jSONObject = new JSONObject();
                            }
                            JSONArray optJSONArray = jSONObject.optJSONArray(a.f3431e);
                            if (optJSONArray == null) {
                                optJSONArray = new JSONArray();
                            }
                            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                                JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i4);
                                if (jSONObject2 != null) {
                                    String optString = jSONObject2.optString(a.f3434h);
                                    if (!TextUtils.isEmpty(optString) && optString.equals(string)) {
                                        if ("1".equals(string) && jSONObject2.has(a.f3435i)) {
                                            String string2 = bundle.getString(a.f3435i);
                                            String string3 = jSONObject2.getString(a.f3435i);
                                            String str3 = a.f3429c;
                                            d.c(str3, "newExtra=" + string2 + " oldExtra=" + string3);
                                            if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && string3.equals(string2)) {
                                                a4 = a.this.a(context, jSONObject2, bundle);
                                                optJSONArray.remove(i4);
                                            }
                                        } else {
                                            a4 = a.this.a(context, jSONObject2, bundle);
                                            optJSONArray.remove(i4);
                                        }
                                        optJSONArray.put(a4);
                                        z3 = true;
                                        break;
                                    }
                                }
                            }
                            z3 = false;
                            if (!z3) {
                                optJSONArray.put(a.this.a(context, (JSONObject) null, bundle));
                            }
                            jSONObject.put(a.f3431e, optJSONArray);
                            String str4 = a.f3429c;
                            d.c(str4, "save data=" + jSONObject);
                            JCoreManager.onEvent(context, JConstants.SDK_TYPE, 41, null, null, a.f3430d, jSONObject);
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        });
    }

    public void a(Context context, String str, String str2) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString(f3436j, str);
            bundle.putString(f3434h, str2);
            a(context, bundle);
        } catch (Throwable unused) {
        }
    }

    public void b(int i4) {
        Context context = JConstants.mApplicationContext;
        a(context, i4 + "", "3");
    }
}

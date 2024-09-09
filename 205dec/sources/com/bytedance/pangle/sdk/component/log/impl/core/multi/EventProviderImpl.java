package com.bytedance.pangle.sdk.component.log.impl.core.multi;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.LogInternalManager;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.ParamEncode;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.bytedance.pangle.sdk.component.log.impl.debug.LDebug;
import com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class EventProviderImpl {
    private static final String FUN_AD_EVENT_DISPATCH = "adLogDispatch";
    private static final String FUN_AD_EVENT_START = "adLogStart";
    private static final String FUN_AD_EVENT_STOP = "adLogStop";
    private static final String FUN_TRACK_FAILED = "trackAdFailed";
    private static final String FUN_TRACK_URL = "trackAdUrl";
    private static final String TAG = "EventProviderImpl";
    private static final String T_EVENT_AD_EVENT = "gromore_ad_log_event";
    private Context mContext;

    public static void dispatchAdEvent(AdLogEventFace adLogEventFace) {
        if (adLogEventFace == null) {
            return;
        }
        try {
            ContentResolver resolver = getResolver();
            if (resolver != null) {
                String encode = ParamEncode.encode(adLogEventFace.toJsonString());
                resolver.getType(Uri.parse(getTable() + FUN_AD_EVENT_DISPATCH + "?event=" + encode));
                LDebug.d("dispatch event getType end ");
            }
        } catch (Throwable th) {
            LDebug.e("dispatch event Throwable:" + th.toString());
        }
    }

    private static ContentResolver getResolver() {
        try {
            if (LogInternalManager.getInstance().getContext() != null) {
                return LogInternalManager.getInstance().getContext().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String getTable() {
        return TTPathConst.sAuthority + TTPathConst.sSeparator + T_EVENT_AD_EVENT + TTPathConst.sSeparator;
    }

    public static void start() {
        LDebug.d("start()");
        if (LogInternalManager.getInstance().getContext() == null) {
            return;
        }
        try {
            ContentResolver resolver = getResolver();
            if (resolver != null) {
                resolver.getType(Uri.parse(getTable() + FUN_AD_EVENT_START));
            }
        } catch (Throwable unused) {
        }
    }

    public static void stop() {
        if (LogInternalManager.getInstance().getContext() == null) {
            return;
        }
        try {
            ContentResolver resolver = getResolver();
            if (resolver != null) {
                resolver.getType(Uri.parse(getTable() + FUN_AD_EVENT_STOP));
            }
        } catch (Throwable unused) {
        }
    }

    public static void track(String str, List<String> list, boolean z3) {
        if (!TextUtils.isEmpty(str) && list != null && !list.isEmpty()) {
            try {
                StringBuilder sb = new StringBuilder();
                for (String str2 : list) {
                    sb.append(ParamEncode.encode(str2));
                    sb.append(",");
                }
                String encode = ParamEncode.encode(sb.toString());
                String str3 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(encode) + "&replace=" + String.valueOf(z3);
                ContentResolver resolver = getResolver();
                if (resolver == null) {
                    return;
                }
                resolver.getType(Uri.parse(getTable() + FUN_TRACK_URL + str3));
            } catch (Throwable unused) {
            }
        }
    }

    public static void trackFailed(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver resolver = getResolver();
            if (resolver != null) {
                resolver.getType(Uri.parse(getTable() + FUN_TRACK_FAILED + "?did=" + String.valueOf(str)));
            }
        } catch (Throwable unused) {
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getTableName() {
        return T_EVENT_AD_EVENT;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003c, code lost:
        if (r0.equals(com.bytedance.pangle.sdk.component.log.impl.core.multi.EventProviderImpl.FUN_AD_EVENT_STOP) == false) goto L3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getType(android.net.Uri r8) {
        /*
            r7 = this;
            java.lang.String r0 = "gettype()"
            com.bytedance.pangle.sdk.component.log.impl.debug.LDebug.d(r0)
            java.lang.String r0 = r8.getPath()
            java.lang.String r1 = "/"
            java.lang.String[] r0 = r0.split(r1)
            r1 = 2
            r0 = r0[r1]
            r0.hashCode()
            int r2 = r0.hashCode()
            r3 = 0
            r4 = -1
            switch(r2) {
                case -482705237: goto L4a;
                case -171493183: goto L3f;
                case 964299715: goto L36;
                case 1025736635: goto L2b;
                case 1131732929: goto L20;
                default: goto L1e;
            }
        L1e:
            r1 = -1
            goto L54
        L20:
            java.lang.String r1 = "trackAdUrl"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L29
            goto L1e
        L29:
            r1 = 4
            goto L54
        L2b:
            java.lang.String r1 = "adLogDispatch"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L34
            goto L1e
        L34:
            r1 = 3
            goto L54
        L36:
            java.lang.String r2 = "adLogStop"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L54
            goto L1e
        L3f:
            java.lang.String r1 = "adLogStart"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L48
            goto L1e
        L48:
            r1 = 1
            goto L54
        L4a:
            java.lang.String r1 = "trackAdFailed"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L53
            goto L1e
        L53:
            r1 = 0
        L54:
            java.lang.String r0 = "did"
            java.lang.String r2 = "EventProviderImpl"
            switch(r1) {
                case 0: goto Ldb;
                case 1: goto Lce;
                case 2: goto Lc1;
                case 3: goto La4;
                case 4: goto L5d;
                default: goto L5b;
            }
        L5b:
            goto Le6
        L5d:
            java.lang.String r0 = r8.getQueryParameter(r0)     // Catch: java.lang.Throwable -> Le6
            java.lang.String r1 = "replace"
            java.lang.String r1 = r8.getQueryParameter(r1)     // Catch: java.lang.Throwable -> Le6
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> Le6
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> Le6
            java.lang.String r2 = "track"
            java.lang.String r8 = r8.getQueryParameter(r2)     // Catch: java.lang.Throwable -> Le6
            java.lang.String r8 = com.bytedance.pangle.sdk.component.log.impl.cache.db.ParamEncode.decode(r8)     // Catch: java.lang.Throwable -> Le6
            java.lang.String r2 = ","
            java.lang.String[] r8 = r8.split(r2)     // Catch: java.lang.Throwable -> Le6
            int r2 = r8.length     // Catch: java.lang.Throwable -> Le6
            if (r2 <= 0) goto Le6
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Le6
            r2.<init>()     // Catch: java.lang.Throwable -> Le6
            int r4 = r8.length     // Catch: java.lang.Throwable -> Le6
        L88:
            if (r3 >= r4) goto L9c
            r5 = r8[r3]     // Catch: java.lang.Throwable -> Le6
            java.lang.String r5 = com.bytedance.pangle.sdk.component.log.impl.cache.db.ParamEncode.decode(r5)     // Catch: java.lang.Throwable -> Le6
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> Le6
            if (r6 != 0) goto L99
            r2.add(r5)     // Catch: java.lang.Throwable -> Le6
        L99:
            int r3 = r3 + 1
            goto L88
        L9c:
            com.bytedance.pangle.sdk.component.log.impl.LogInternalManager r8 = com.bytedance.pangle.sdk.component.log.impl.LogInternalManager.getInstance()     // Catch: java.lang.Throwable -> Le6
            r8.track(r0, r2, r1)     // Catch: java.lang.Throwable -> Le6
            goto Le6
        La4:
            java.lang.String r0 = "dispatch FUN_AD_EVENT_DISPATCH"
            com.bytedance.pangle.sdk.component.log.impl.debug.LDebug.d(r2, r0)
            java.lang.String r0 = "event"
            java.lang.String r8 = r8.getQueryParameter(r0)
            java.lang.String r8 = com.bytedance.pangle.sdk.component.log.impl.cache.db.ParamEncode.decode(r8)
            com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace r8 = com.bytedance.pangle.sdk.component.log.impl.event.ad.AdLogEvent.toEventObj(r8)
            if (r8 == 0) goto Le6
            com.bytedance.pangle.sdk.component.log.impl.LogInternalManager r0 = com.bytedance.pangle.sdk.component.log.impl.LogInternalManager.getInstance()
            r0.reportEvent(r8)
            goto Le6
        Lc1:
            java.lang.String r8 = "====ad event function will be stop===="
            com.bytedance.pangle.sdk.component.log.impl.debug.LDebug.d(r2, r8)
            com.bytedance.pangle.sdk.component.log.impl.LogInternalManager r8 = com.bytedance.pangle.sdk.component.log.impl.LogInternalManager.getInstance()
            r8.stop()
            goto Le6
        Lce:
            java.lang.String r8 = "EventProviderImpl====ad event function will be start===="
            com.bytedance.pangle.sdk.component.log.impl.debug.LDebug.d(r8)
            com.bytedance.pangle.sdk.component.log.impl.LogInternalManager r8 = com.bytedance.pangle.sdk.component.log.impl.LogInternalManager.getInstance()
            r8.start()
            goto Le6
        Ldb:
            java.lang.String r8 = r8.getQueryParameter(r0)
            com.bytedance.pangle.sdk.component.log.impl.LogInternalManager r0 = com.bytedance.pangle.sdk.component.log.impl.LogInternalManager.getInstance()
            r0.trackFailedUrls(r8)
        Le6:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.sdk.component.log.impl.core.multi.EventProviderImpl.getType(android.net.Uri):java.lang.String");
    }

    public void init() {
    }

    public void injectContext(Context context) {
        this.mContext = context;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}

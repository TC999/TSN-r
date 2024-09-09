package com.bytedance.sdk.openadsdk.mediation.init;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationConfigUserInfoForSegment implements Serializable {
    public static final String GENDER_FEMALE = "female";
    public static final String GENDER_MALE = "male";
    public static final String GENDER_UNKNOWN = "unknown";

    /* renamed from: r  reason: collision with root package name */
    private Map<String, String> f36156r;
    public final String TAG = "TTMediationSDK";

    /* renamed from: c  reason: collision with root package name */
    private String f36154c = "";

    /* renamed from: w  reason: collision with root package name */
    private String f36157w = "";
    private String xv = "";
    private int sr = 0;
    private String ux = "";

    /* renamed from: f  reason: collision with root package name */
    private String f36155f = "";

    public static boolean checkValid(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[A-Za-z0-9-_]{1,100}");
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b1, code lost:
        if (r7 == null) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r6 != r7) goto L4
            return r0
        L4:
            r1 = 0
            if (r7 == 0) goto Lbd
            java.lang.Class r2 = r6.getClass()
            java.lang.Class r3 = r7.getClass()
            if (r2 == r3) goto L13
            goto Lbd
        L13:
            com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment r7 = (com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment) r7
            int r2 = r6.getAge()
            int r3 = r7.getAge()
            if (r2 != r3) goto L67
            java.lang.String r2 = r6.getUserValueGroup()
            java.lang.String r3 = r7.getUserValueGroup()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L67
            java.lang.String r2 = r6.getUserId()
            java.lang.String r3 = r7.getUserId()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L67
            java.lang.String r2 = r6.getChannel()
            java.lang.String r3 = r7.getChannel()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L67
            java.lang.String r2 = r6.getSubChannel()
            java.lang.String r3 = r7.getSubChannel()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L67
            java.lang.String r2 = r6.getGender()
            java.lang.String r3 = r7.getGender()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L67
            r2 = 1
            goto L68
        L67:
            r2 = 0
        L68:
            java.util.Map r7 = r7.getCustomInfos()
            java.util.Map<java.lang.String, java.lang.String> r3 = r6.f36156r
            if (r3 == 0) goto Laf
            if (r7 == 0) goto Laf
            int r3 = r3.size()
            int r4 = r7.size()
            if (r3 == r4) goto L7d
            goto Lb5
        L7d:
            java.util.Map<java.lang.String, java.lang.String> r3 = r6.f36156r
            java.util.Set r3 = r3.keySet()
            java.util.Iterator r3 = r3.iterator()
        L87:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto Lb3
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L9a
            goto L87
        L9a:
            java.util.Map<java.lang.String, java.lang.String> r5 = r6.f36156r
            java.lang.Object r5 = r5.get(r4)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.Object r4 = r7.get(r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.equals(r5, r4)
            if (r4 != 0) goto L87
            goto Lb5
        Laf:
            if (r3 != 0) goto Lb5
            if (r7 != 0) goto Lb5
        Lb3:
            r7 = 1
            goto Lb6
        Lb5:
            r7 = 0
        Lb6:
            if (r2 == 0) goto Lbb
            if (r7 == 0) goto Lbb
            goto Lbc
        Lbb:
            r0 = 0
        Lbc:
            return r0
        Lbd:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment.equals(java.lang.Object):boolean");
    }

    public int getAge() {
        return this.sr;
    }

    @Nullable
    public String getChannel() {
        return this.f36157w;
    }

    @Nullable
    public Map<String, String> getCustomInfos() {
        return this.f36156r;
    }

    @Nullable
    public String getGender() {
        return this.ux;
    }

    @Nullable
    public String getSubChannel() {
        return this.xv;
    }

    @Nullable
    public String getUserId() {
        return this.f36154c;
    }

    @Nullable
    public String getUserValueGroup() {
        return this.f36155f;
    }

    public void setAge(int i4) {
        this.sr = i4;
    }

    public void setChannel(String str) {
        if (checkValid(str)) {
            this.f36157w = str;
        } else {
            Log.e("TTMediationSDK", "\u6d41\u91cf\u5206\u7ec4channer\u5b57\u6bb5\u5b58\u5728\u4e0d\u5408\u6cd5\u8f93\u5165");
        }
    }

    public void setCustomInfos(Map<String, String> map) {
        this.f36156r = new HashMap();
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                if (!checkValid(entry.getKey())) {
                    Log.e("TTMediationSDK", "\u6d41\u91cf\u5206\u7ec4" + entry.getKey() + "\u5b57\u6bb5\u5b58\u5728\u4e0d\u5408\u6cd5\u8f93\u5165");
                } else if (checkValid(entry.getValue())) {
                    this.f36156r.put(entry.getKey(), entry.getValue());
                } else {
                    Log.e("TTMediationSDK", "\u6d41\u91cf\u5206\u7ec4" + entry.getKey() + "\u5b57\u6bb5\u7684\u503c" + entry.getValue() + "\u5b58\u5728\u4e0d\u5408\u6cd5\u8f93\u5165");
                }
            }
        }
    }

    public void setGender(String str) {
        if (checkValid(str)) {
            this.ux = str;
        } else {
            Log.e("TTMediationSDK", "\u6d41\u91cf\u5206\u7ec4gender\u5b57\u6bb5\u5b58\u5728\u4e0d\u5408\u6cd5\u8f93\u5165");
        }
    }

    public void setSubChannel(String str) {
        if (checkValid(str)) {
            this.xv = str;
        } else {
            Log.e("TTMediationSDK", "\u6d41\u91cf\u5206\u7ec4sub_channer\u5b57\u6bb5\u5b58\u5728\u4e0d\u5408\u6cd5\u8f93\u5165");
        }
    }

    public void setUserId(String str) {
        if (checkValid(str)) {
            this.f36154c = str;
        } else {
            Log.e("TTMediationSDK", "\u6d41\u91cf\u5206\u7ec4user_id\u5b57\u6bb5\u5b58\u5728\u4e0d\u5408\u6cd5\u8f93\u5165");
        }
    }

    public void setUserValueGroup(String str) {
        if (checkValid(str)) {
            this.f36155f = str;
        } else {
            Log.e("TTMediationSDK", "\u6d41\u91cf\u5206\u7ec4user_value_group\u5b57\u6bb5\u5b58\u5728\u4e0d\u5408\u6cd5\u8f93\u5165");
        }
    }
}

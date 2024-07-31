package com.bytedance.sdk.openadsdk.mediation.init;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MediationConfigUserInfoForSegment implements Serializable {
    public static final String GENDER_FEMALE = "female";
    public static final String GENDER_MALE = "male";
    public static final String GENDER_UNKNOWN = "unknown";

    /* renamed from: h */
    private Map<String, String> f22797h;
    public final String TAG = "TTMediationSDK";

    /* renamed from: ok */
    private String f22800ok = "";

    /* renamed from: a */
    private String f22795a = "";

    /* renamed from: bl */
    private String f22796bl = "";

    /* renamed from: s */
    private int f22801s = 0;

    /* renamed from: n */
    private String f22799n = "";

    /* renamed from: kf */
    private String f22798kf = "";

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
            java.util.Map<java.lang.String, java.lang.String> r3 = r6.f22797h
            if (r3 == 0) goto Laf
            if (r7 == 0) goto Laf
            int r3 = r3.size()
            int r4 = r7.size()
            if (r3 == r4) goto L7d
            goto Lb5
        L7d:
            java.util.Map<java.lang.String, java.lang.String> r3 = r6.f22797h
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
            java.util.Map<java.lang.String, java.lang.String> r5 = r6.f22797h
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
        return this.f22801s;
    }

    @Nullable
    public String getChannel() {
        return this.f22795a;
    }

    @Nullable
    public Map<String, String> getCustomInfos() {
        return this.f22797h;
    }

    @Nullable
    public String getGender() {
        return this.f22799n;
    }

    @Nullable
    public String getSubChannel() {
        return this.f22796bl;
    }

    @Nullable
    public String getUserId() {
        return this.f22800ok;
    }

    @Nullable
    public String getUserValueGroup() {
        return this.f22798kf;
    }

    public void setAge(int i) {
        this.f22801s = i;
    }

    public void setChannel(String str) {
        if (checkValid(str)) {
            this.f22795a = str;
        } else {
            Log.e("TTMediationSDK", "流量分组channer字段存在不合法输入");
        }
    }

    public void setCustomInfos(Map<String, String> map) {
        this.f22797h = new HashMap();
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                if (!checkValid(entry.getKey())) {
                    Log.e("TTMediationSDK", "流量分组" + entry.getKey() + "字段存在不合法输入");
                } else if (checkValid(entry.getValue())) {
                    this.f22797h.put(entry.getKey(), entry.getValue());
                } else {
                    Log.e("TTMediationSDK", "流量分组" + entry.getKey() + "字段的值" + entry.getValue() + "存在不合法输入");
                }
            }
        }
    }

    public void setGender(String str) {
        if (checkValid(str)) {
            this.f22799n = str;
        } else {
            Log.e("TTMediationSDK", "流量分组gender字段存在不合法输入");
        }
    }

    public void setSubChannel(String str) {
        if (checkValid(str)) {
            this.f22796bl = str;
        } else {
            Log.e("TTMediationSDK", "流量分组sub_channer字段存在不合法输入");
        }
    }

    public void setUserId(String str) {
        if (checkValid(str)) {
            this.f22800ok = str;
        } else {
            Log.e("TTMediationSDK", "流量分组user_id字段存在不合法输入");
        }
    }

    public void setUserValueGroup(String str) {
        if (checkValid(str)) {
            this.f22798kf = str;
        } else {
            Log.e("TTMediationSDK", "流量分组user_value_group字段存在不合法输入");
        }
    }
}

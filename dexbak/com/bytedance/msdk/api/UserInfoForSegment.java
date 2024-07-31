package com.bytedance.msdk.api;

import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class UserInfoForSegment {
    public static final String GENDER_FEMALE = "female";
    public static final String GENDER_MALE = "male";
    public static final String GENDER_UNKNOWN = "unknown";

    /* renamed from: a */
    private String f21699a = "";

    /* renamed from: b */
    private String f21700b = "";

    /* renamed from: c */
    private String f21701c = "";

    /* renamed from: d */
    private int f21702d = 0;

    /* renamed from: e */
    private String f21703e = "";

    /* renamed from: f */
    private String f21704f = "";

    /* renamed from: g */
    private Map<String, String> f21705g;

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00af, code lost:
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
            if (r7 == 0) goto Lbb
            java.lang.Class r2 = r7.getClass()
            java.lang.Class<com.bytedance.msdk.api.UserInfoForSegment> r3 = com.bytedance.msdk.api.UserInfoForSegment.class
            if (r3 == r2) goto L11
            goto Lbb
        L11:
            com.bytedance.msdk.api.UserInfoForSegment r7 = (com.bytedance.msdk.api.UserInfoForSegment) r7
            int r2 = r6.getAge()
            int r3 = r7.getAge()
            if (r2 != r3) goto L65
            java.lang.String r2 = r6.getUserValueGroup()
            java.lang.String r3 = r7.getUserValueGroup()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L65
            java.lang.String r2 = r6.getUserId()
            java.lang.String r3 = r7.getUserId()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L65
            java.lang.String r2 = r6.getChannel()
            java.lang.String r3 = r7.getChannel()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L65
            java.lang.String r2 = r6.getSubChannel()
            java.lang.String r3 = r7.getSubChannel()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L65
            java.lang.String r2 = r6.getGender()
            java.lang.String r3 = r7.getGender()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L65
            r2 = 1
            goto L66
        L65:
            r2 = 0
        L66:
            java.util.Map r7 = r7.getCustomInfos()
            java.util.Map<java.lang.String, java.lang.String> r3 = r6.f21705g
            if (r3 == 0) goto Lad
            if (r7 == 0) goto Lad
            int r3 = r3.size()
            int r4 = r7.size()
            if (r3 == r4) goto L7b
            goto Lb3
        L7b:
            java.util.Map<java.lang.String, java.lang.String> r3 = r6.f21705g
            java.util.Set r3 = r3.keySet()
            java.util.Iterator r3 = r3.iterator()
        L85:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto Lb1
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L98
            goto L85
        L98:
            java.util.Map<java.lang.String, java.lang.String> r5 = r6.f21705g
            java.lang.Object r5 = r5.get(r4)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.Object r4 = r7.get(r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.equals(r5, r4)
            if (r4 != 0) goto L85
            goto Lb3
        Lad:
            if (r3 != 0) goto Lb3
            if (r7 != 0) goto Lb3
        Lb1:
            r7 = 1
            goto Lb4
        Lb3:
            r7 = 0
        Lb4:
            if (r2 == 0) goto Lb9
            if (r7 == 0) goto Lb9
            goto Lba
        Lb9:
            r0 = 0
        Lba:
            return r0
        Lbb:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.api.UserInfoForSegment.equals(java.lang.Object):boolean");
    }

    public int getAge() {
        return this.f21702d;
    }

    public String getChannel() {
        return this.f21700b;
    }

    public Map<String, String> getCustomInfos() {
        return this.f21705g;
    }

    public String getGender() {
        return this.f21703e;
    }

    public String getSubChannel() {
        return this.f21701c;
    }

    public String getUserId() {
        return this.f21699a;
    }

    public String getUserValueGroup() {
        return this.f21704f;
    }

    public void setAge(int i) {
        this.f21702d = i;
    }

    public void setChannel(String str) {
        this.f21700b = str;
    }

    public void setCustomInfos(Map<String, String> map) {
        this.f21705g = map;
    }

    public void setGender(String str) {
        this.f21703e = str;
    }

    public void setSubChannel(String str) {
        this.f21701c = str;
    }

    public void setUserId(String str) {
        this.f21699a = str;
    }

    public void setUserValueGroup(String str) {
        this.f21704f = str;
    }
}

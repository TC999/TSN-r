package com.amap.api.col.p0463l;

import com.baidu.idl.face.platform.common.ConstantHelper;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;

@EntityClass(m54740a = "update_item")
/* renamed from: com.amap.api.col.3l.p0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DTInfo {
    @EntityField(m54738a = "localPath", m54737b = 6)

    /* renamed from: h */
    protected String f5034h;
    @EntityField(m54738a = "mCompleteCode", m54737b = 2)

    /* renamed from: j */
    protected int f5036j;
    @EntityField(m54738a = "mState", m54737b = 2)

    /* renamed from: l */
    public int f5038l;
    @EntityField(m54738a = "title", m54737b = 6)

    /* renamed from: a */
    protected String f5027a = null;
    @EntityField(m54738a = "url", m54737b = 6)

    /* renamed from: b */
    protected String f5028b = null;
    @EntityField(m54738a = "mAdcode", m54737b = 6)

    /* renamed from: c */
    protected String f5029c = null;
    @EntityField(m54738a = TTDownloadField.TT_FILE_NAME, m54737b = 6)

    /* renamed from: d */
    protected String f5030d = null;
    @EntityField(m54738a = ConstantHelper.LOG_VS, m54737b = 6)

    /* renamed from: e */
    protected String f5031e = "";
    @EntityField(m54738a = "lLocalLength", m54737b = 5)

    /* renamed from: f */
    protected long f5032f = 0;
    @EntityField(m54738a = "lRemoteLength", m54737b = 5)

    /* renamed from: g */
    protected long f5033g = 0;
    @EntityField(m54738a = "isProvince", m54737b = 2)

    /* renamed from: i */
    protected int f5035i = 0;
    @EntityField(m54738a = "mCityCode", m54737b = 6)

    /* renamed from: k */
    protected String f5037k = "";
    @EntityField(m54738a = "mPinyin", m54737b = 6)

    /* renamed from: m */
    public String f5039m = "";

    /* renamed from: f */
    public static String m54251f(String str) {
        return "mAdcode='" + str + "'";
    }

    /* renamed from: h */
    public static String m54249h(String str) {
        return "mPinyin='" + str + "'";
    }

    /* renamed from: a */
    public final String m54256a() {
        return this.f5027a;
    }

    /* renamed from: b */
    public final void m54255b(String str) {
        this.f5029c = str;
    }

    /* renamed from: c */
    public final String m54254c() {
        return this.f5031e;
    }

    /* renamed from: d */
    public final void m54253d(String str) {
        this.f5037k = str;
    }

    /* renamed from: e */
    public final String m54252e() {
        return this.f5029c;
    }

    /* renamed from: g */
    public final String m54250g() {
        return this.f5028b;
    }

    /* renamed from: i */
    public final int m54248i() {
        return this.f5036j;
    }

    /* renamed from: j */
    public final String m54247j() {
        return this.f5039m;
    }
}

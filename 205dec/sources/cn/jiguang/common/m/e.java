package cn.jiguang.common.m;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f3507a;

    /* renamed from: b  reason: collision with root package name */
    public String f3508b;

    /* renamed from: c  reason: collision with root package name */
    public String f3509c;

    /* renamed from: d  reason: collision with root package name */
    public String f3510d;

    /* renamed from: e  reason: collision with root package name */
    public long f3511e;

    /* renamed from: f  reason: collision with root package name */
    public long f3512f;

    private static CharSequence a(CharSequence charSequence, int i4) {
        return (i4 < 0 || i4 >= charSequence.length()) ? charSequence : charSequence.subSequence(0, i4);
    }

    public JSONObject a(int i4) {
        try {
            return new JSONObject().put("pkg", a(this.f3507a, i4)).put("install_time", this.f3511e).put("update_time", this.f3512f).put("sign_md5", this.f3508b).put("sign_sha1", this.f3509c).put("sign_sha256", this.f3510d);
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.f3507a;
        String str2 = ((e) obj).f3507a;
        return str != null ? str.equals(str2) : str2 == null;
    }
}

package com.qq.e.comm.plugin.n0;

import android.text.TextUtils;
import com.qq.e.comm.plugin.util.d1;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f {

    /* renamed from: e  reason: collision with root package name */
    private static final String f44746e = "f";

    /* renamed from: a  reason: collision with root package name */
    private boolean f44747a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Integer> f44748b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    private final Set<Integer> f44749c = new HashSet();

    /* renamed from: d  reason: collision with root package name */
    private final Set<Integer> f44750d = new HashSet();

    public f(JSONObject jSONObject) {
        String[] split;
        String[] split2;
        String[] split3;
        try {
            this.f44747a = jSONObject.optInt("ea", 0) == 1;
            for (String str : jSONObject.optString("ei", "").split(",")) {
                if (!TextUtils.isEmpty(str)) {
                    this.f44748b.add(Integer.valueOf(Integer.parseInt(str)));
                }
            }
            for (String str2 : jSONObject.optString("ek", "").split(",")) {
                if (!TextUtils.isEmpty(str2)) {
                    this.f44749c.add(Integer.valueOf(Integer.parseInt(str2)));
                }
            }
            for (String str3 : jSONObject.optString("adt", "").split(",")) {
                if (!TextUtils.isEmpty(str3)) {
                    this.f44750d.add(Integer.valueOf(Integer.parseInt(str3)));
                }
            }
        } catch (Exception e4) {
            d1.a(f44746e, "parse error", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i4, Integer num) {
        if (this.f44747a) {
            return true;
        }
        if (num == null || num.intValue() == 0 || this.f44750d.isEmpty() || this.f44750d.contains(num)) {
            if (this.f44748b.contains(Integer.valueOf(i4))) {
                return true;
            }
            return this.f44749c.contains(Integer.valueOf(i4 / 1000));
        }
        return false;
    }
}

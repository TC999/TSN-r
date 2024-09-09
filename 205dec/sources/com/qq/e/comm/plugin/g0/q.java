package com.qq.e.comm.plugin.g0;

import android.text.TextUtils;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.comm.plugin.util.d1;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class q extends e implements t {

    /* renamed from: g1  reason: collision with root package name */
    private int f43729g1;

    /* renamed from: h1  reason: collision with root package name */
    private int f43730h1;

    /* renamed from: i1  reason: collision with root package name */
    private VideoOption f43731i1;

    /* renamed from: j1  reason: collision with root package name */
    String f43732j1;

    /* renamed from: k1  reason: collision with root package name */
    List<String> f43733k1;

    /* renamed from: l1  reason: collision with root package name */
    int f43734l1;

    public q(String str, String str2, String str3, String str4, com.qq.e.comm.plugin.b.g gVar, com.qq.e.comm.plugin.b.l lVar, JSONObject jSONObject, int i4, int i5, VideoOption videoOption) {
        super(str, str2, str3, str4, gVar, jSONObject, lVar);
        this.f43733k1 = new ArrayList();
        r.a(this, jSONObject);
        this.f43729g1 = i4;
        this.f43730h1 = i5;
        this.f43731i1 = videoOption;
        c(3);
    }

    private boolean r1() {
        return this.f43733k1.size() == 3;
    }

    public void a(int i4, int i5) {
        this.f43729g1 = i4;
        this.f43730h1 = i5;
    }

    @Override // com.qq.e.comm.plugin.g0.t
    public String e() {
        return this.f43732j1;
    }

    public final int o1() {
        return this.f43730h1;
    }

    public final VideoOption p1() {
        return this.f43731i1;
    }

    public final int q1() {
        return this.f43729g1;
    }

    public void s1() {
        t1();
        if (r1() && TextUtils.isEmpty(this.f43525g)) {
            try {
                this.f43506L.put("img2", this.f43733k1.get(0));
            } catch (Exception e4) {
                d1.a("ExpressAdDataModel", "setImage2UrlWith3Image error", e4);
            }
            this.M = null;
        }
    }

    public void t1() {
        if (r1() && TextUtils.isEmpty(this.f43522f)) {
            try {
                this.f43506L.put("img", this.f43733k1.get(0));
            } catch (Exception e4) {
                d1.a("ExpressAdDataModel", "setImageUrlWith3Image error", e4);
            }
            this.M = null;
        }
    }
}

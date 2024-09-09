package com.bytedance.sdk.openadsdk.core.u;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private String f34628c;

    /* renamed from: f  reason: collision with root package name */
    private long f34629f;
    private List<me> sr = new ArrayList();
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private int f34630w;
    private String xv;

    public void c(String str) {
        this.f34628c = str;
    }

    public void w(String str) {
        this.xv = str;
    }

    public String xv() {
        return this.ux;
    }

    public int c() {
        return this.f34630w;
    }

    public List<me> w() {
        return this.sr;
    }

    public void xv(String str) {
        this.ux = str;
    }

    public void c(int i4) {
        this.f34630w = i4;
    }

    public void c(me meVar) {
        this.sr.add(meVar);
    }

    public void c(List<me> list) {
        this.sr = list;
    }

    public void c(long j4) {
        this.f34629f = j4;
    }

    public static Map<String, me> c(c cVar) {
        if (cVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (me meVar : cVar.w()) {
            if (!TextUtils.isEmpty(meVar.jd())) {
                hashMap.put(meVar.jd(), meVar);
            }
        }
        if (hashMap.size() != 0) {
            return hashMap;
        }
        return null;
    }
}

package com.amap.api.services.cloud;

import com.amap.api.services.cloud.CloudSearch;
import java.util.ArrayList;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class CloudResult {

    /* renamed from: a */
    private int f7238a;

    /* renamed from: b */
    private ArrayList<CloudItem> f7239b;

    /* renamed from: c */
    private int f7240c;

    /* renamed from: d */
    private int f7241d;

    /* renamed from: e */
    private CloudSearch.Query f7242e;

    /* renamed from: f */
    private CloudSearch.SearchBound f7243f;

    private CloudResult(CloudSearch.Query query, int i, CloudSearch.SearchBound searchBound, int i2, ArrayList<CloudItem> arrayList) {
        this.f7242e = query;
        this.f7240c = i;
        this.f7241d = i2;
        this.f7238a = m51901a(i);
        this.f7239b = arrayList;
        this.f7243f = searchBound;
    }

    /* renamed from: a */
    private int m51901a(int i) {
        int i2 = this.f7241d;
        return ((i + i2) - 1) / i2;
    }

    public static CloudResult createPagedResult(CloudSearch.Query query, int i, CloudSearch.SearchBound searchBound, int i2, ArrayList<CloudItem> arrayList) {
        return new CloudResult(query, i, searchBound, i2, arrayList);
    }

    public final CloudSearch.SearchBound getBound() {
        return this.f7243f;
    }

    public final ArrayList<CloudItem> getClouds() {
        return this.f7239b;
    }

    public final int getPageCount() {
        return this.f7238a;
    }

    public final CloudSearch.Query getQuery() {
        return this.f7242e;
    }

    public final int getTotalCount() {
        return this.f7240c;
    }
}

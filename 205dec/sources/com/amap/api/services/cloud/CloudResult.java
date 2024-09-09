package com.amap.api.services.cloud;

import com.amap.api.services.cloud.CloudSearch;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class CloudResult {

    /* renamed from: a  reason: collision with root package name */
    private int f10934a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<CloudItem> f10935b;

    /* renamed from: c  reason: collision with root package name */
    private int f10936c;

    /* renamed from: d  reason: collision with root package name */
    private int f10937d;

    /* renamed from: e  reason: collision with root package name */
    private CloudSearch.Query f10938e;

    /* renamed from: f  reason: collision with root package name */
    private CloudSearch.SearchBound f10939f;

    private CloudResult(CloudSearch.Query query, int i4, CloudSearch.SearchBound searchBound, int i5, ArrayList<CloudItem> arrayList) {
        this.f10938e = query;
        this.f10936c = i4;
        this.f10937d = i5;
        this.f10934a = a(i4);
        this.f10935b = arrayList;
        this.f10939f = searchBound;
    }

    private int a(int i4) {
        int i5 = this.f10937d;
        return ((i4 + i5) - 1) / i5;
    }

    public static CloudResult createPagedResult(CloudSearch.Query query, int i4, CloudSearch.SearchBound searchBound, int i5, ArrayList<CloudItem> arrayList) {
        return new CloudResult(query, i4, searchBound, i5, arrayList);
    }

    public final CloudSearch.SearchBound getBound() {
        return this.f10939f;
    }

    public final ArrayList<CloudItem> getClouds() {
        return this.f10935b;
    }

    public final int getPageCount() {
        return this.f10934a;
    }

    public final CloudSearch.Query getQuery() {
        return this.f10938e;
    }

    public final int getTotalCount() {
        return this.f10936c;
    }
}

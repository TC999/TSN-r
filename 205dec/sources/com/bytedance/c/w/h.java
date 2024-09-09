package com.bytedance.c.w;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private Map<xv, List<a>> f26531a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private Map<String, String> f26532b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final List<c> f26533c = new CopyOnWriteArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final List<c> f26534d = new CopyOnWriteArrayList();

    /* renamed from: e  reason: collision with root package name */
    private final List<c> f26535e = new CopyOnWriteArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final List<c> f26536f = new CopyOnWriteArrayList();

    /* renamed from: g  reason: collision with root package name */
    private e f26537g = null;

    @Nullable
    public List<a> a(xv xvVar) {
        return this.f26531a.get(xvVar);
    }

    public Map<String, String> b() {
        return this.f26532b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(e eVar) {
        this.f26537g = eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Map<? extends String, ? extends String> map) {
        this.f26532b.putAll(map);
    }

    @Nullable
    public e e() {
        return this.f26537g;
    }

    @NonNull
    public List<c> f() {
        return this.f26534d;
    }

    @NonNull
    public List<c> g() {
        return this.f26536f;
    }
}

package com.bytedance.msdk.xv.sr;

import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.sr.f;
import com.bytedance.msdk.c.ux;
import com.bytedance.msdk.core.k.p;
import com.bytedance.msdk.xv.sr;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends c {
    @Override // com.bytedance.msdk.xv.sr.c
    public void c(final sr srVar, final com.bytedance.msdk.api.c.w wVar, final String str, final boolean z3, final String str2, final int i4, final Map<String, Object> map) {
        if (com.bytedance.msdk.core.c.w().w()) {
            final long currentTimeMillis = System.currentTimeMillis();
            f.sr(new Runnable() { // from class: com.bytedance.msdk.xv.sr.w.1
                @Override // java.lang.Runnable
                public void run() {
                    srVar.c(System.currentTimeMillis() - currentTimeMillis);
                    w.super.c(srVar, wVar, str, z3, str2, i4, map);
                }
            });
            return;
        }
        super.c(srVar, wVar, str, z3, str2, i4, map);
    }

    @Override // com.bytedance.msdk.xv.sr.c
    public void c(final sr srVar, final ux uxVar, final com.bytedance.msdk.api.c.w wVar, final com.bytedance.msdk.core.k.w wVar2, final long j4, final String str, final boolean z3, final int i4, final boolean z4, final boolean z5) {
        if (com.bytedance.msdk.core.c.w().w()) {
            f.sr(new Runnable() { // from class: com.bytedance.msdk.xv.sr.w.10
                @Override // java.lang.Runnable
                public void run() {
                    w.super.c(srVar, uxVar, wVar, wVar2, j4, str, z3, i4, z4, z5);
                }
            });
        } else {
            super.c(srVar, uxVar, wVar, wVar2, j4, str, z3, i4, z4, z5);
        }
    }

    @Override // com.bytedance.msdk.xv.sr.c
    public void c(final sr srVar, final com.bytedance.msdk.api.c.w wVar, final ux uxVar, final long j4, final int i4, final int i5, final int i6, final String str, final int i7, final int i8, final com.bytedance.msdk.core.k.w wVar2, final JSONObject jSONObject) {
        if (com.bytedance.msdk.core.c.w().w()) {
            f.sr(new Runnable() { // from class: com.bytedance.msdk.xv.sr.w.11
                @Override // java.lang.Runnable
                public void run() {
                    w.super.c(srVar, wVar, uxVar, j4, i4, i5, i6, str, i7, i8, wVar2, jSONObject);
                }
            });
        } else {
            super.c(srVar, wVar, uxVar, j4, i4, i5, i6, str, i7, i8, wVar2, jSONObject);
        }
    }

    @Override // com.bytedance.msdk.xv.sr.c
    public void c(final sr srVar, @Nullable final com.bytedance.msdk.api.c.w wVar, final com.bytedance.msdk.api.c cVar, final String str, final String str2) {
        if (com.bytedance.msdk.core.c.w().w()) {
            f.sr(new Runnable() { // from class: com.bytedance.msdk.xv.sr.w.12
                @Override // java.lang.Runnable
                public void run() {
                    w.super.c(srVar, wVar, cVar, str, str2);
                }
            });
        } else {
            super.c(srVar, wVar, cVar, str, str2);
        }
    }

    @Override // com.bytedance.msdk.xv.sr.c
    public void c(final sr srVar, final p pVar, final com.bytedance.msdk.api.c.w wVar, final String str, final boolean z3, final int i4, final int i5, final int i6, final int i7, final com.bytedance.msdk.api.c cVar, final long j4, final boolean z4, final boolean z5) {
        if (com.bytedance.msdk.core.c.w().w()) {
            f.sr(new Runnable() { // from class: com.bytedance.msdk.xv.sr.w.13
                @Override // java.lang.Runnable
                public void run() {
                    w.super.c(srVar, pVar, wVar, str, z3, i4, i5, i6, i7, cVar, j4, z4, z5);
                }
            });
        } else {
            super.c(srVar, pVar, wVar, str, z3, i4, i5, i6, i7, cVar, j4, z4, z5);
        }
    }

    @Override // com.bytedance.msdk.xv.sr.c
    public void c(final sr srVar, final ux uxVar, final int i4, final String str, final long j4, final com.bytedance.msdk.api.c.w wVar, final int i5, final int i6, final int i7, final String str2, final long j5, final long j6) {
        if (com.bytedance.msdk.core.c.w().w()) {
            f.sr(new Runnable() { // from class: com.bytedance.msdk.xv.sr.w.14
                @Override // java.lang.Runnable
                public void run() {
                    w.super.c(srVar, uxVar, i4, str, j4, wVar, i5, i6, i7, str2, j5, j6);
                }
            });
        } else {
            super.c(srVar, uxVar, i4, str, j4, wVar, i5, i6, i7, str2, j5, j6);
        }
    }

    @Override // com.bytedance.msdk.xv.sr.c
    public void c(final sr srVar, final com.bytedance.msdk.api.c cVar, final com.bytedance.msdk.api.c.w wVar, final p pVar, final int i4, final int i5, final int i6, final String str, final long j4, final String str2, final String str3, final String str4, final long j5) {
        if (com.bytedance.msdk.core.c.w().w()) {
            f.sr(new Runnable() { // from class: com.bytedance.msdk.xv.sr.w.15
                @Override // java.lang.Runnable
                public void run() {
                    w.super.c(srVar, cVar, wVar, pVar, i4, i5, i6, str, j4, str2, str3, str4, j5);
                }
            });
        } else {
            super.c(srVar, cVar, wVar, pVar, i4, i5, i6, str, j4, str2, str3, str4, j5);
        }
    }

    @Override // com.bytedance.msdk.xv.sr.c
    public void c(final sr srVar, final p pVar, final com.bytedance.msdk.api.c.w wVar, final int i4, final int i5) {
        if (com.bytedance.msdk.core.c.w().w()) {
            f.sr(new Runnable() { // from class: com.bytedance.msdk.xv.sr.w.16
                @Override // java.lang.Runnable
                public void run() {
                    w.super.c(srVar, pVar, wVar, i4, i5);
                }
            });
        } else {
            super.c(srVar, pVar, wVar, i4, i5);
        }
    }

    @Override // com.bytedance.msdk.xv.sr.c
    public void c(final sr srVar, final com.bytedance.msdk.api.c.w wVar, final int i4) {
        if (com.bytedance.msdk.core.c.w().w()) {
            f.sr(new Runnable() { // from class: com.bytedance.msdk.xv.sr.w.17
                @Override // java.lang.Runnable
                public void run() {
                    w.super.c(srVar, wVar, i4);
                }
            });
        } else {
            super.c(srVar, wVar, i4);
        }
    }

    @Override // com.bytedance.msdk.xv.sr.c
    public void c(final sr srVar, final ux uxVar, final com.bytedance.msdk.api.c.w wVar, final List<ux> list, final List<ux> list2) {
        if (com.bytedance.msdk.core.c.w().w()) {
            f.sr(new Runnable() { // from class: com.bytedance.msdk.xv.sr.w.2
                @Override // java.lang.Runnable
                public void run() {
                    w.super.c(srVar, uxVar, wVar, list, list2);
                }
            });
        } else {
            super.c(srVar, uxVar, wVar, list, list2);
        }
    }

    @Override // com.bytedance.msdk.xv.sr.c
    public void c(final sr srVar, final com.bytedance.msdk.api.c.w wVar, final String str, final JSONObject jSONObject) {
        if (com.bytedance.msdk.core.c.w().w()) {
            f.sr(new Runnable() { // from class: com.bytedance.msdk.xv.sr.w.3
                @Override // java.lang.Runnable
                public void run() {
                    w.super.c(srVar, wVar, str, jSONObject);
                }
            });
        } else {
            super.c(srVar, wVar, str, jSONObject);
        }
    }

    @Override // com.bytedance.msdk.xv.sr.c
    public void c(final sr srVar, final com.bytedance.msdk.api.c.w wVar, final com.bytedance.msdk.core.sr.w wVar2, final String str, final int i4) {
        if (com.bytedance.msdk.core.c.w().w()) {
            f.sr(new Runnable() { // from class: com.bytedance.msdk.xv.sr.w.4
                @Override // java.lang.Runnable
                public void run() {
                    w.super.c(srVar, wVar, wVar2, str, i4);
                }
            });
        } else {
            super.c(srVar, wVar, wVar2, str, i4);
        }
    }

    @Override // com.bytedance.msdk.xv.sr.c
    public void c(final sr srVar, final p pVar, final com.bytedance.msdk.api.c.w wVar, final String str) {
        if (com.bytedance.msdk.core.c.w().w()) {
            f.sr(new Runnable() { // from class: com.bytedance.msdk.xv.sr.w.5
                @Override // java.lang.Runnable
                public void run() {
                    w.super.c(srVar, pVar, wVar, str);
                }
            });
        } else {
            super.c(srVar, pVar, wVar, str);
        }
    }

    @Override // com.bytedance.msdk.xv.sr.c
    public void c(final sr srVar, final ux uxVar, final com.bytedance.msdk.api.c.w wVar, final p pVar, final long j4) {
        if (com.bytedance.msdk.core.c.w().w()) {
            f.sr(new Runnable() { // from class: com.bytedance.msdk.xv.sr.w.6
                @Override // java.lang.Runnable
                public void run() {
                    w.super.c(srVar, uxVar, wVar, pVar, j4);
                }
            });
        } else {
            super.c(srVar, uxVar, wVar, pVar, j4);
        }
    }

    @Override // com.bytedance.msdk.xv.sr.c
    public void c(final sr srVar, final ux uxVar, final com.bytedance.msdk.api.c.w wVar, final p pVar) {
        if (com.bytedance.msdk.core.c.w().w()) {
            f.sr(new Runnable() { // from class: com.bytedance.msdk.xv.sr.w.7
                @Override // java.lang.Runnable
                public void run() {
                    w.super.c(srVar, uxVar, wVar, pVar);
                }
            });
        } else {
            super.c(srVar, uxVar, wVar, pVar);
        }
    }

    @Override // com.bytedance.msdk.xv.sr.c
    public void c(final sr srVar, final com.bytedance.msdk.api.c.w wVar, final ux uxVar, final p pVar) {
        if (com.bytedance.msdk.core.c.w().w()) {
            f.sr(new Runnable() { // from class: com.bytedance.msdk.xv.sr.w.8
                @Override // java.lang.Runnable
                public void run() {
                    w.super.c(srVar, wVar, uxVar, pVar);
                }
            });
        } else {
            super.c(srVar, wVar, uxVar, pVar);
        }
    }

    @Override // com.bytedance.msdk.xv.sr.c
    public void c(final sr srVar, final com.bytedance.msdk.api.c.w wVar, final ux uxVar, final long j4, final String str) {
        if (com.bytedance.msdk.core.c.w().w()) {
            f.sr(new Runnable() { // from class: com.bytedance.msdk.xv.sr.w.9
                @Override // java.lang.Runnable
                public void run() {
                    w.super.c(srVar, wVar, uxVar, j4, str);
                }
            });
        } else {
            super.c(srVar, wVar, uxVar, j4, str);
        }
    }
}

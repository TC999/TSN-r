package com.kwad.sdk.core.download;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class d implements c {
    private AdInfo mAdInfo;

    public d(AdTemplate adTemplate) {
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, int i4, int i5, int i6) {
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, int i4, String str2, e eVar) {
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, e eVar) {
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, String str2, e eVar) {
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, Throwable th, e eVar) {
    }

    @Override // com.kwad.sdk.core.download.c
    public final void b(String str, e eVar) {
    }

    @Override // com.kwad.sdk.core.download.c
    public void b(String str, String str2, e eVar) {
    }

    @Override // com.kwad.sdk.core.download.c
    public final void c(String str, e eVar) {
    }

    @Override // com.kwad.sdk.core.download.c
    public final void d(String str, e eVar) {
    }

    @Override // com.kwad.sdk.core.download.c
    public final void e(String str, e eVar) {
    }

    @Override // com.kwad.sdk.core.download.c
    public final void f(String str, e eVar) {
    }

    @Override // com.kwad.sdk.core.download.c
    public final void g(String str, e eVar) {
    }

    @Override // com.kwad.sdk.core.download.c
    public final String nX() {
        return this.mAdInfo.downloadId;
    }

    @Override // com.kwad.sdk.core.download.c
    public final String nY() {
        return this.mAdInfo.adBaseInfo.appPackageName;
    }
}

package com.ss.android.socialbase.downloader.f;

import androidx.annotation.NonNull;
import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
class ev implements ux {

    /* renamed from: c  reason: collision with root package name */
    private final ux f49601c;

    /* renamed from: w  reason: collision with root package name */
    private final ux f49602w;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ev(ux uxVar, ux uxVar2) {
        this.f49601c = uxVar;
        this.f49602w = uxVar2;
    }

    @Override // com.ss.android.socialbase.downloader.f.ux
    public void w(@NonNull c cVar) throws IOException {
        cVar.f49600w = this.f49602w;
        this.f49601c.w(cVar);
    }
}

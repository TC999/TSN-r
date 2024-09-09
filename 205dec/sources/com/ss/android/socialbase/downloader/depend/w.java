package com.ss.android.socialbase.downloader.depend;

import java.util.List;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public abstract class w implements q {

    /* renamed from: c  reason: collision with root package name */
    private boolean f49400c = false;

    public void c(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f49400c = true;
    }

    public boolean c() {
        return this.f49400c;
    }
}

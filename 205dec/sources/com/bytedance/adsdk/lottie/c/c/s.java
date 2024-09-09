package com.bytedance.adsdk.lottie.c.c;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private final List<i> f25454a = new ArrayList();

    public void a(Path path) {
        for (int size = this.f25454a.size() - 1; size >= 0; size--) {
            com.bytedance.adsdk.lottie.f.b.j(path, this.f25454a.get(size));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(i iVar) {
        this.f25454a.add(iVar);
    }
}

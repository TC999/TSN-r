package com.bytedance.sdk.openadsdk.core.playable;

import java.io.File;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev extends com.bytedance.sdk.openadsdk.core.gd.w {
    public ev(int i4, int i5) {
        super(i4, i5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.gd.w, com.bytedance.sdk.openadsdk.core.gd.c
    protected void c(List<File> list) {
        int size = list.size();
        if (c(0L, size)) {
            return;
        }
        for (File file : list) {
            com.bytedance.sdk.component.utils.f.xv(file);
            size--;
            if (c(file, 0L, size)) {
                return;
            }
        }
    }
}

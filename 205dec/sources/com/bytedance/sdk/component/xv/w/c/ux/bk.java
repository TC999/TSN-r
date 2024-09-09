package com.bytedance.sdk.component.xv.w.c.ux;

import java.io.IOException;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface bk {

    /* renamed from: c  reason: collision with root package name */
    public static final bk f30818c = new bk() { // from class: com.bytedance.sdk.component.xv.w.c.ux.bk.1
        @Override // com.bytedance.sdk.component.xv.w.c.ux.bk
        public void c(int i4, w wVar) {
        }

        @Override // com.bytedance.sdk.component.xv.w.c.ux.bk
        public boolean c(int i4, com.bytedance.sdk.component.xv.c.ux uxVar, int i5, boolean z3) throws IOException {
            uxVar.ev(i5);
            return true;
        }

        @Override // com.bytedance.sdk.component.xv.w.c.ux.bk
        public boolean c(int i4, List<xv> list) {
            return true;
        }

        @Override // com.bytedance.sdk.component.xv.w.c.ux.bk
        public boolean c(int i4, List<xv> list, boolean z3) {
            return true;
        }
    };

    void c(int i4, w wVar);

    boolean c(int i4, com.bytedance.sdk.component.xv.c.ux uxVar, int i5, boolean z3) throws IOException;

    boolean c(int i4, List<xv> list);

    boolean c(int i4, List<xv> list, boolean z3);
}

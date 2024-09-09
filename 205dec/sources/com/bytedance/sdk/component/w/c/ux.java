package com.bytedance.sdk.component.w.c;

import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class ux extends ys {

    /* renamed from: c  reason: collision with root package name */
    List<String> f30432c;

    /* renamed from: w  reason: collision with root package name */
    List<String> f30433w;

    ux(List<String> list, List<String> list2) {
        this.f30432c = list;
        this.f30433w = list2;
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        private final List<String> f30434c = new ArrayList();

        /* renamed from: w  reason: collision with root package name */
        private final List<String> f30435w = new ArrayList();

        public c c(String str, String str2) {
            this.f30434c.add(str);
            this.f30435w.add(str2);
            return this;
        }

        public ux c() {
            return new ux(this.f30434c, this.f30435w);
        }
    }
}

package com.bykv.c.c.c.c;

import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: E:\TSN-r\205dec\4499832.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f24732a = false;

    /* renamed from: b  reason: collision with root package name */
    private int f24733b = -1;

    /* renamed from: c  reason: collision with root package name */
    private String f24734c = null;

    /* renamed from: d  reason: collision with root package name */
    private ValueSet f24735d = null;

    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    private static final class b implements Result {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f24736a;

        /* renamed from: b  reason: collision with root package name */
        private final int f24737b;

        /* renamed from: c  reason: collision with root package name */
        private final String f24738c;

        /* renamed from: d  reason: collision with root package name */
        private final ValueSet f24739d;

        @Override // com.bykv.vk.openvk.api.proto.Result
        public int code() {
            return this.f24737b;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public boolean isSuccess() {
            return this.f24736a;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public String message() {
            return this.f24738c;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public ValueSet values() {
            return this.f24739d;
        }

        private b(boolean z3, int i4, String str, ValueSet valueSet) {
            this.f24736a = z3;
            this.f24737b = i4;
            this.f24738c = str;
            this.f24739d = valueSet;
        }
    }

    private a() {
    }

    public static final a a() {
        return new a();
    }

    public a b(int i4) {
        this.f24733b = i4;
        return this;
    }

    public a c(ValueSet valueSet) {
        this.f24735d = valueSet;
        return this;
    }

    public a d(String str) {
        this.f24734c = str;
        return this;
    }

    public a e(boolean z3) {
        this.f24732a = z3;
        return this;
    }

    public Result f() {
        boolean z3 = this.f24732a;
        int i4 = this.f24733b;
        String str = this.f24734c;
        ValueSet valueSet = this.f24735d;
        if (valueSet == null) {
            valueSet = com.bykv.c.c.c.c.b.a().l();
        }
        return new b(z3, i4, str, valueSet);
    }
}

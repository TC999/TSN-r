package com.bykv.ok.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f24754a = false;

    /* renamed from: b  reason: collision with root package name */
    private int f24755b = -1;

    /* renamed from: c  reason: collision with root package name */
    private String f24756c = null;

    /* renamed from: d  reason: collision with root package name */
    private ValueSet f24757d = null;

    /* renamed from: com.bykv.ok.ok.ok.ok.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    private static final class C0330b implements Result {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f24758a;

        /* renamed from: b  reason: collision with root package name */
        private final int f24759b;

        /* renamed from: c  reason: collision with root package name */
        private final String f24760c;

        /* renamed from: d  reason: collision with root package name */
        private final ValueSet f24761d;

        @Override // com.bykv.vk.openvk.api.proto.Result
        public int code() {
            return this.f24759b;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public boolean isSuccess() {
            return this.f24758a;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public String message() {
            return this.f24760c;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public ValueSet values() {
            return this.f24761d;
        }

        private C0330b(boolean z3, int i4, String str, ValueSet valueSet) {
            this.f24758a = z3;
            this.f24759b = i4;
            this.f24760c = str;
            this.f24761d = valueSet;
        }
    }

    private b() {
    }

    public static final b b() {
        return new b();
    }

    public Result a() {
        boolean z3 = this.f24754a;
        int i4 = this.f24755b;
        String str = this.f24756c;
        ValueSet valueSet = this.f24757d;
        if (valueSet == null) {
            valueSet = com.bykv.ok.ok.ok.ok.a.b().a();
        }
        return new C0330b(z3, i4, str, valueSet);
    }

    public b c(int i4) {
        this.f24755b = i4;
        return this;
    }

    public b d(ValueSet valueSet) {
        this.f24757d = valueSet;
        return this;
    }

    public b e(String str) {
        this.f24756c = str;
        return this;
    }

    public b f(boolean z3) {
        this.f24754a = z3;
        return this;
    }
}

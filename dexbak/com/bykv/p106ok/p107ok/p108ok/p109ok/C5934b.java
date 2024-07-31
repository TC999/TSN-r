package com.bykv.p106ok.p107ok.p108ok.p109ok;

import com.bykv.p110vk.openvk.api.proto.Result;
import com.bykv.p110vk.openvk.api.proto.ValueSet;

/* renamed from: com.bykv.ok.ok.ok.ok.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C5934b {

    /* renamed from: a */
    private boolean f21286a = false;

    /* renamed from: b */
    private int f21287b = -1;

    /* renamed from: c */
    private String f21288c = null;

    /* renamed from: d */
    private ValueSet f21289d = null;

    /* renamed from: com.bykv.ok.ok.ok.ok.b$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    private static final class C5936b implements Result {

        /* renamed from: a */
        private final boolean f21290a;

        /* renamed from: b */
        private final int f21291b;

        /* renamed from: c */
        private final String f21292c;

        /* renamed from: d */
        private final ValueSet f21293d;

        @Override // com.bykv.p110vk.openvk.api.proto.Result
        public int code() {
            return this.f21291b;
        }

        @Override // com.bykv.p110vk.openvk.api.proto.Result
        public boolean isSuccess() {
            return this.f21290a;
        }

        @Override // com.bykv.p110vk.openvk.api.proto.Result
        public String message() {
            return this.f21292c;
        }

        @Override // com.bykv.p110vk.openvk.api.proto.Result
        public ValueSet values() {
            return this.f21293d;
        }

        private C5936b(boolean z, int i, String str, ValueSet valueSet) {
            this.f21290a = z;
            this.f21291b = i;
            this.f21292c = str;
            this.f21293d = valueSet;
        }
    }

    private C5934b() {
    }

    /* renamed from: b */
    public static final C5934b m37914b() {
        return new C5934b();
    }

    /* renamed from: a */
    public Result m37915a() {
        boolean z = this.f21286a;
        int i = this.f21287b;
        String str = this.f21288c;
        ValueSet valueSet = this.f21289d;
        if (valueSet == null) {
            valueSet = C5930a.m37925b().m37926a();
        }
        return new C5936b(z, i, str, valueSet);
    }

    /* renamed from: c */
    public C5934b m37913c(int i) {
        this.f21287b = i;
        return this;
    }

    /* renamed from: d */
    public C5934b m37912d(ValueSet valueSet) {
        this.f21289d = valueSet;
        return this;
    }

    /* renamed from: e */
    public C5934b m37911e(String str) {
        this.f21288c = str;
        return this;
    }

    /* renamed from: f */
    public C5934b m37910f(boolean z) {
        this.f21286a = z;
        return this;
    }
}

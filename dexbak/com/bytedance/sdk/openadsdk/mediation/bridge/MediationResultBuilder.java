package com.bytedance.sdk.openadsdk.mediation.bridge;

import com.bykv.p110vk.openvk.api.proto.Result;
import com.bykv.p110vk.openvk.api.proto.ValueSet;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MediationResultBuilder {

    /* renamed from: ok */
    private boolean f22712ok = false;

    /* renamed from: a */
    private int f22710a = -1;

    /* renamed from: bl */
    private String f22711bl = null;

    /* renamed from: s */
    private ValueSet f22713s = null;

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    private static final class ResultImpl implements Result {

        /* renamed from: a */
        private final int f22714a;

        /* renamed from: bl */
        private final String f22715bl;

        /* renamed from: ok */
        private final boolean f22716ok;

        /* renamed from: s */
        private final ValueSet f22717s;

        @Override // com.bykv.p110vk.openvk.api.proto.Result
        public int code() {
            return this.f22714a;
        }

        @Override // com.bykv.p110vk.openvk.api.proto.Result
        public boolean isSuccess() {
            return this.f22716ok;
        }

        @Override // com.bykv.p110vk.openvk.api.proto.Result
        public String message() {
            return this.f22715bl;
        }

        @Override // com.bykv.p110vk.openvk.api.proto.Result
        public ValueSet values() {
            return this.f22717s;
        }

        private ResultImpl(boolean z, int i, String str, ValueSet valueSet) {
            this.f22716ok = z;
            this.f22714a = i;
            this.f22715bl = str;
            this.f22717s = valueSet;
        }
    }

    private MediationResultBuilder() {
    }

    public static final MediationResultBuilder create() {
        return new MediationResultBuilder();
    }

    public Result build() {
        boolean z = this.f22712ok;
        int i = this.f22710a;
        String str = this.f22711bl;
        ValueSet valueSet = this.f22713s;
        if (valueSet == null) {
            valueSet = MediationValueSetBuilder.create().build();
        }
        return new ResultImpl(z, i, str, valueSet);
    }

    public MediationResultBuilder setCode(int i) {
        this.f22710a = i;
        return this;
    }

    public MediationResultBuilder setMessage(String str) {
        this.f22711bl = str;
        return this;
    }

    public MediationResultBuilder setSuccess(boolean z) {
        this.f22712ok = z;
        return this;
    }

    public MediationResultBuilder setValues(ValueSet valueSet) {
        this.f22713s = valueSet;
        return this;
    }
}

package com.bytedance.sdk.openadsdk.mediation.bridge;

import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationResultBuilder {

    /* renamed from: c  reason: collision with root package name */
    private boolean f36059c = false;

    /* renamed from: w  reason: collision with root package name */
    private int f36060w = -1;
    private String xv = null;
    private ValueSet sr = null;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    private static final class ResultImpl implements Result {

        /* renamed from: c  reason: collision with root package name */
        private final boolean f36061c;
        private final ValueSet sr;

        /* renamed from: w  reason: collision with root package name */
        private final int f36062w;
        private final String xv;

        @Override // com.bykv.vk.openvk.api.proto.Result
        public int code() {
            return this.f36062w;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public boolean isSuccess() {
            return this.f36061c;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public String message() {
            return this.xv;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public ValueSet values() {
            return this.sr;
        }

        private ResultImpl(boolean z3, int i4, String str, ValueSet valueSet) {
            this.f36061c = z3;
            this.f36062w = i4;
            this.xv = str;
            this.sr = valueSet;
        }
    }

    private MediationResultBuilder() {
    }

    public static final MediationResultBuilder create() {
        return new MediationResultBuilder();
    }

    public Result build() {
        boolean z3 = this.f36059c;
        int i4 = this.f36060w;
        String str = this.xv;
        ValueSet valueSet = this.sr;
        if (valueSet == null) {
            valueSet = MediationValueSetBuilder.create().build();
        }
        return new ResultImpl(z3, i4, str, valueSet);
    }

    public MediationResultBuilder setCode(int i4) {
        this.f36060w = i4;
        return this;
    }

    public MediationResultBuilder setMessage(String str) {
        this.xv = str;
        return this;
    }

    public MediationResultBuilder setSuccess(boolean z3) {
        this.f36059c = z3;
        return this;
    }

    public MediationResultBuilder setValues(ValueSet valueSet) {
        this.sr = valueSet;
        return this;
    }
}

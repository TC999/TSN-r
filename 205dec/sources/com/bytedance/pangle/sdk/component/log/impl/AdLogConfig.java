package com.bytedance.pangle.sdk.component.log.impl;

import com.bytedance.pangle.sdk.component.log.impl.cache.IDBCallback;
import com.bytedance.pangle.sdk.component.log.impl.core.IUploader;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class AdLogConfig {
    private IAdLogDepend adLogDepend;
    private PolicyConfig batchPolicyConfig;
    private IDBCallback dbCallback;
    private PolicyConfig highPolicyConfig;
    private PolicyConfig normalPolicyConfig;
    private PolicyConfig otherConfig;
    private boolean supportMultiProcess;
    private IUploader uploader;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class Builder {
        private IAdLogDepend adLogDepend;
        private PolicyConfig batchPolicyConfig;
        private IDBCallback dbCallback;
        private PolicyConfig highPolicyConfig;
        private PolicyConfig normalPolicyConfig;
        private PolicyConfig otherPolicyConfig;
        private boolean supportMultiProcess;
        private IUploader uploader;

        public Builder adLogDepend(IAdLogDepend iAdLogDepend) {
            this.adLogDepend = iAdLogDepend;
            return this;
        }

        public Builder batchPolicyConfig(PolicyConfig policyConfig) {
            this.batchPolicyConfig = policyConfig;
            return this;
        }

        public AdLogConfig build() {
            AdLogConfig adLogConfig = new AdLogConfig();
            adLogConfig.uploader = this.uploader;
            adLogConfig.highPolicyConfig = this.highPolicyConfig;
            adLogConfig.normalPolicyConfig = this.normalPolicyConfig;
            adLogConfig.batchPolicyConfig = this.batchPolicyConfig;
            adLogConfig.supportMultiProcess = this.supportMultiProcess;
            adLogConfig.adLogDepend = this.adLogDepend;
            adLogConfig.dbCallback = this.dbCallback;
            return adLogConfig;
        }

        public Builder highPolicyConfig(PolicyConfig policyConfig) {
            this.highPolicyConfig = policyConfig;
            return this;
        }

        public Builder normalPolicyConfig(PolicyConfig policyConfig) {
            this.normalPolicyConfig = policyConfig;
            return this;
        }

        public Builder otherPolicyConfig(PolicyConfig policyConfig) {
            this.otherPolicyConfig = policyConfig;
            return this;
        }

        public Builder setDBCallback(IDBCallback iDBCallback) {
            this.dbCallback = iDBCallback;
            return this;
        }

        public Builder supportMultiProcess(boolean z3) {
            this.supportMultiProcess = z3;
            return this;
        }

        public Builder uploader(IUploader iUploader) {
            this.uploader = iUploader;
            return this;
        }
    }

    public IAdLogDepend getAdLogDepend() {
        return this.adLogDepend;
    }

    public PolicyConfig getBatchPolicyConfig() {
        return this.batchPolicyConfig;
    }

    public IDBCallback getDbCallback() {
        return this.dbCallback;
    }

    public PolicyConfig getHighPolicyConfig() {
        return this.highPolicyConfig;
    }

    public PolicyConfig getNormalPolicyConfig() {
        return this.normalPolicyConfig;
    }

    public PolicyConfig getOtherConfig() {
        return this.otherConfig;
    }

    public IUploader getUploader() {
        return this.uploader;
    }

    public boolean isSupportMultiProcess() {
        return this.supportMultiProcess;
    }

    private AdLogConfig() {
    }
}

package com.beizi.p051ad;

import android.os.Bundle;
import com.beizi.p051ad.internal.Validator;
import com.beizi.p051ad.internal.network.AdRequestImpl;
import com.beizi.p051ad.p055b.MediationAdapter;
import java.util.Date;
import java.util.Set;

/* renamed from: com.beizi.ad.AdRequest */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class AdRequest {
    public static final String DEVICE_ID_EMULATOR = AdRequestImpl.f10373b;
    public static final int ERROR_CODE_AD_CACHE_FAILED = 6;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_MEDIATION_AD_NOT_AVAILABLE = 3;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NOT_READY_TO_REQUEST = 4;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int ERROR_CODE_SUCCESS = -1;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    public static final int INVALID_DISPLAY = 5;
    public static final int MAX_CONTENT_URL_LENGTH = 512;

    /* renamed from: a */
    private final AdRequestImpl.C2918a f9338a;

    /* renamed from: com.beizi.ad.AdRequest$Builder */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class Builder {
        private final AdRequestImpl.C2918a mImpl;

        public Builder() {
            AdRequestImpl.C2918a c2918a = new AdRequestImpl.C2918a();
            this.mImpl = c2918a;
            c2918a.m49328b(AdRequest.DEVICE_ID_EMULATOR);
        }

        public Builder addKeyword(String str) {
            this.mImpl.m49333a(str);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.mImpl.m49334a(cls, bundle);
            return this;
        }

        public Builder addTestDevice(String str) {
            this.mImpl.m49328b(str);
            return this;
        }

        public AdRequest build() {
            return new AdRequest(this);
        }

        public Builder setBirthday(Date date) {
            this.mImpl.m49332a(date);
            return this;
        }

        public Builder setContentUrl(String str) {
            Validator.m49297a(str, (Object) "Content URL must be non-null.");
            Validator.m49296a(str, (Object) "Content URL must be non-empty.");
            Validator.m49294a(str.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", 512, Integer.valueOf(str.length()));
            this.mImpl.m49324c(str);
            return this;
        }

        public Builder setGender(int i) {
            this.mImpl.m49337a(i);
            return this;
        }

        public Builder setIsDesignedForFamilies(boolean z) {
            this.mImpl.m49327b(z);
            return this;
        }

        public Builder setRequestAgent(String str) {
            this.mImpl.m49321d(str);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean z) {
            this.mImpl.m49331a(z);
            return this;
        }
    }

    public Date getBirthday() {
        return this.f9338a.m49338a();
    }

    public String getContentUrl() {
        return this.f9338a.m49330b();
    }

    public int getGender() {
        return this.f9338a.m49326c();
    }

    public Set<String> getKeywords() {
        return this.f9338a.m49323d();
    }

    public <T> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.f9338a.m49335a((Class<? extends MediationAdapter>) cls);
    }

    public AdRequestImpl.C2918a impl() {
        return this.f9338a;
    }

    private AdRequest(Builder builder) {
        this.f9338a = builder.mImpl;
    }
}

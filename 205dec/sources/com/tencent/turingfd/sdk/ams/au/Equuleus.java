package com.tencent.turingfd.sdk.ams.au;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import javax.security.auth.x500.X500Principal;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class Equuleus {

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Equuleus$do  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class Cdo extends Equuleus {

        /* renamed from: a  reason: collision with root package name */
        public KeyGenParameterSpec.Builder f52036a;

        public Cdo(String str, int i4) {
            this.f52036a = null;
            this.f52036a = new KeyGenParameterSpec.Builder(str, i4);
        }

        @Override // com.tencent.turingfd.sdk.ams.au.Equuleus
        public AlgorithmParameterSpec a() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            return this.f52036a.build();
        }

        @Override // com.tencent.turingfd.sdk.ams.au.Equuleus
        public Equuleus b(String... strArr) {
            this.f52036a.setSignaturePaddings(strArr);
            return this;
        }

        @Override // com.tencent.turingfd.sdk.ams.au.Equuleus
        public Equuleus a(String... strArr) {
            this.f52036a.setDigests(strArr);
            return this;
        }
    }

    public static Equuleus a(String str, int i4) {
        if (Build.VERSION.SDK_INT >= 23) {
            return new Cdo(str, i4);
        }
        return new Cif(str, i4);
    }

    public abstract Equuleus a(String... strArr);

    public abstract AlgorithmParameterSpec a() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;

    public abstract Equuleus b(String... strArr);

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Equuleus$if  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class Cif extends Equuleus {

        /* renamed from: a  reason: collision with root package name */
        public final String f52037a;

        /* renamed from: b  reason: collision with root package name */
        public int f52038b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f52039c;

        /* renamed from: d  reason: collision with root package name */
        public String[] f52040d;

        public Cif(String str, int i4) {
            if (str != null) {
                if (!str.isEmpty()) {
                    this.f52037a = str;
                    this.f52038b = i4;
                    return;
                }
                throw new IllegalArgumentException("keystoreAlias must not be empty");
            }
            throw new NullPointerException("keystoreAlias == null");
        }

        @Override // com.tencent.turingfd.sdk.ams.au.Equuleus
        public AlgorithmParameterSpec a() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            Class<?> cls = Class.forName("android.security.keystore.KeyGenParameterSpec");
            Class<?> cls2 = Integer.TYPE;
            Class<?> cls3 = Boolean.TYPE;
            return (AlgorithmParameterSpec) cls.getConstructor(String.class, cls2, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, java.util.Date.class, java.util.Date.class, java.util.Date.class, java.util.Date.class, java.util.Date.class, cls2, String[].class, String[].class, String[].class, String[].class, cls3, cls3, cls2).newInstance(this.f52037a, -1, null, null, null, null, null, null, null, null, Integer.valueOf(this.f52038b), this.f52039c, null, this.f52040d, null, Boolean.TRUE, Boolean.FALSE, -1);
        }

        @Override // com.tencent.turingfd.sdk.ams.au.Equuleus
        public Equuleus b(String... strArr) {
            if (strArr.length > 0) {
                strArr = (String[]) strArr.clone();
            }
            this.f52040d = strArr;
            return this;
        }

        @Override // com.tencent.turingfd.sdk.ams.au.Equuleus
        public Equuleus a(String... strArr) {
            if (strArr.length > 0) {
                strArr = (String[]) strArr.clone();
            }
            this.f52039c = strArr;
            return this;
        }
    }
}

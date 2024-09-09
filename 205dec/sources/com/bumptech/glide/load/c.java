package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: Key.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public interface c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f16792a = "UTF-8";

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f16793b = Charset.forName("UTF-8");

    void b(@NonNull MessageDigest messageDigest);

    boolean equals(Object obj);

    int hashCode();
}

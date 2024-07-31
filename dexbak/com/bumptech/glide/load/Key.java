package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface Key {

    /* renamed from: a */
    public static final String f13469a = "UTF-8";

    /* renamed from: b */
    public static final Charset f13470b = Charset.forName("UTF-8");

    /* renamed from: b */
    void mo44432b(@NonNull MessageDigest messageDigest);

    boolean equals(Object obj);

    int hashCode();
}

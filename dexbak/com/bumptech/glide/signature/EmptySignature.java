package com.bumptech.glide.signature;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.signature.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class EmptySignature implements Key {

    /* renamed from: c */
    private static final EmptySignature f14526c = new EmptySignature();

    private EmptySignature() {
    }

    @NonNull
    /* renamed from: c */
    public static EmptySignature m44433c() {
        return f14526c;
    }

    @Override // com.bumptech.glide.load.Key
    /* renamed from: b */
    public void mo44432b(@NonNull MessageDigest messageDigest) {
    }

    public String toString() {
        return "EmptySignature";
    }
}

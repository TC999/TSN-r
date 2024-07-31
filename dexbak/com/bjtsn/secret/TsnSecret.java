package com.bjtsn.secret;

import android.content.Context;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: TsnSecret.kt */
@Metadata(m12617d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086 J\u0011\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0086 J\u0011\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0086 J\u0011\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0086 J\u0011\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0086 J\u0011\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0086 J\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0086 J\u0011\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0086 J\u0011\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0086 ¨\u0006\u0011"}, m12616d2 = {"Lcom/bjtsn/secret/TsnSecret;", "", "()V", "checkSignature", "", "context", "Landroid/content/Context;", "getKey", "", "getQRCodeKey", "getSignatureMD5", "getSignatureSHA1", "getSignatureSHA256", "getVersionCode", "", "getVersionName", "getWJXYNFCKey", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1}, m12612xi = 48)
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class TsnSecret {
    @NotNull

    /* renamed from: a */
    public static final TsnSecret f13210a = new TsnSecret();

    static {
        System.loadLibrary("tsnsecret");
    }

    private TsnSecret() {
    }

    public final native boolean checkSignature(@NotNull Context context);

    @NotNull
    public final native String getKey(@NotNull Context context);

    @NotNull
    public final native String getQRCodeKey(@NotNull Context context);

    @NotNull
    public final native String getSignatureMD5(@NotNull Context context);

    @NotNull
    public final native String getSignatureSHA1(@NotNull Context context);

    @NotNull
    public final native String getSignatureSHA256(@NotNull Context context);

    public final native int getVersionCode(@NotNull Context context);

    @NotNull
    public final native String getVersionName(@NotNull Context context);

    @NotNull
    public final native String getWJXYNFCKey(@NotNull Context context);
}

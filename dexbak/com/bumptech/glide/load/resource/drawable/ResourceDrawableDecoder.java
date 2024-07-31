package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.stub.StubApp;
import java.util.List;

/* renamed from: com.bumptech.glide.load.resource.drawable.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ResourceDrawableDecoder implements ResourceDecoder<Uri, Drawable> {

    /* renamed from: b */
    private static final String f14184b = "android";

    /* renamed from: c */
    private static final int f14185c = 0;

    /* renamed from: d */
    private static final int f14186d = 2;

    /* renamed from: e */
    private static final int f14187e = 0;

    /* renamed from: f */
    private static final int f14188f = 1;

    /* renamed from: g */
    private static final int f14189g = 1;

    /* renamed from: h */
    private static final int f14190h = 0;

    /* renamed from: a */
    private final Context f14191a;

    public ResourceDrawableDecoder(Context context) {
        this.f14191a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @NonNull
    /* renamed from: d */
    private Context m44866d(Uri uri, String str) {
        if (str.equals(this.f14191a.getPackageName())) {
            return this.f14191a;
        }
        try {
            return this.f14191a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            if (str.contains(this.f14191a.getPackageName())) {
                return this.f14191a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e);
        }
    }

    @DrawableRes
    /* renamed from: e */
    private int m44865e(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e);
        }
    }

    @DrawableRes
    /* renamed from: f */
    private int m44864f(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    @DrawableRes
    /* renamed from: g */
    private int m44863g(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return m44864f(context, uri);
        }
        if (pathSegments.size() == 1) {
            return m44865e(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    @Nullable
    /* renamed from: c */
    public Resource<Drawable> mo2813b(@NonNull Uri uri, int i, int i2, @NonNull Options options) {
        Context m44866d = m44866d(uri, uri.getAuthority());
        return NonOwnedDrawableResource.m44868d(DrawableDecoderCompat.m44882b(this.f14191a, m44866d, m44863g(m44866d, uri)));
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: h */
    public boolean mo2814a(@NonNull Uri uri, @NonNull Options options) {
        return uri.getScheme().equals("android.resource");
    }
}

package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.g;
import com.stub.StubApp;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ResourceDrawableDecoder.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class e implements g<Uri, Drawable> {

    /* renamed from: b  reason: collision with root package name */
    private static final String f17501b = "android";

    /* renamed from: c  reason: collision with root package name */
    private static final int f17502c = 0;

    /* renamed from: d  reason: collision with root package name */
    private static final int f17503d = 2;

    /* renamed from: e  reason: collision with root package name */
    private static final int f17504e = 0;

    /* renamed from: f  reason: collision with root package name */
    private static final int f17505f = 1;

    /* renamed from: g  reason: collision with root package name */
    private static final int f17506g = 1;

    /* renamed from: h  reason: collision with root package name */
    private static final int f17507h = 0;

    /* renamed from: a  reason: collision with root package name */
    private final Context f17508a;

    public e(Context context) {
        this.f17508a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @NonNull
    private Context d(Uri uri, String str) {
        if (str.equals(this.f17508a.getPackageName())) {
            return this.f17508a;
        }
        try {
            return this.f17508a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e4) {
            if (str.contains(this.f17508a.getPackageName())) {
                return this.f17508a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e4);
        }
    }

    @DrawableRes
    private int e(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e4) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e4);
        }
    }

    @DrawableRes
    private int f(Context context, Uri uri) {
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
    private int g(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return f(context, uri);
        }
        if (pathSegments.size() == 1) {
            return e(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    @Override // com.bumptech.glide.load.g
    @Nullable
    /* renamed from: c */
    public u<Drawable> b(@NonNull Uri uri, int i4, int i5, @NonNull com.bumptech.glide.load.f fVar) {
        Context d4 = d(uri, uri.getAuthority());
        return d.d(a.b(this.f17508a, d4, g(d4, uri)));
    }

    @Override // com.bumptech.glide.load.g
    /* renamed from: h */
    public boolean a(@NonNull Uri uri, @NonNull com.bumptech.glide.load.f fVar) {
        return uri.getScheme().equals("android.resource");
    }
}

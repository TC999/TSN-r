package com.bumptech.glide.load.model;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.model.n;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: AssetUriLoader.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class a<Data> implements n<Uri, Data> {

    /* renamed from: c  reason: collision with root package name */
    private static final String f17256c = "android_asset";

    /* renamed from: d  reason: collision with root package name */
    private static final String f17257d = "file:///android_asset/";

    /* renamed from: e  reason: collision with root package name */
    private static final int f17258e = 22;

    /* renamed from: a  reason: collision with root package name */
    private final AssetManager f17259a;

    /* renamed from: b  reason: collision with root package name */
    private final InterfaceC0174a<Data> f17260b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: AssetUriLoader.java */
    /* renamed from: com.bumptech.glide.load.model.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface InterfaceC0174a<Data> {
        com.bumptech.glide.load.data.d<Data> b(AssetManager assetManager, String str);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: AssetUriLoader.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class b implements o<Uri, ParcelFileDescriptor>, InterfaceC0174a<ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f17261a;

        public b(AssetManager assetManager) {
            this.f17261a = assetManager;
        }

        @Override // com.bumptech.glide.load.model.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.model.a.InterfaceC0174a
        public com.bumptech.glide.load.data.d<ParcelFileDescriptor> b(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.data.h(assetManager, str);
        }

        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<Uri, ParcelFileDescriptor> c(r rVar) {
            return new a(this.f17261a, this);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: AssetUriLoader.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class c implements o<Uri, InputStream>, InterfaceC0174a<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f17262a;

        public c(AssetManager assetManager) {
            this.f17262a = assetManager;
        }

        @Override // com.bumptech.glide.load.model.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.model.a.InterfaceC0174a
        public com.bumptech.glide.load.data.d<InputStream> b(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.data.m(assetManager, str);
        }

        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<Uri, InputStream> c(r rVar) {
            return new a(this.f17262a, this);
        }
    }

    public a(AssetManager assetManager, InterfaceC0174a<Data> interfaceC0174a) {
        this.f17259a = assetManager;
        this.f17260b = interfaceC0174a;
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: c */
    public n.a<Data> b(@NonNull Uri uri, int i4, int i5, @NonNull com.bumptech.glide.load.f fVar) {
        return new n.a<>(new com.bumptech.glide.signature.d(uri), this.f17260b.b(this.f17259a, uri.toString().substring(f17258e)));
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: d */
    public boolean a(@NonNull Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }
}

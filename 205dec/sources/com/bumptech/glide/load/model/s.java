package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.model.n;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ResourceLoader.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class s<Data> implements n<Integer, Data> {

    /* renamed from: c  reason: collision with root package name */
    private static final String f17341c = "ResourceLoader";

    /* renamed from: a  reason: collision with root package name */
    private final n<Uri, Data> f17342a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f17343b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ResourceLoader.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class a implements o<Integer, AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f17344a;

        public a(Resources resources) {
            this.f17344a = resources;
        }

        @Override // com.bumptech.glide.load.model.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.model.o
        public n<Integer, AssetFileDescriptor> c(r rVar) {
            return new s(this.f17344a, rVar.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ResourceLoader.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class b implements o<Integer, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f17345a;

        public b(Resources resources) {
            this.f17345a = resources;
        }

        @Override // com.bumptech.glide.load.model.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<Integer, ParcelFileDescriptor> c(r rVar) {
            return new s(this.f17345a, rVar.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ResourceLoader.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class c implements o<Integer, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f17346a;

        public c(Resources resources) {
            this.f17346a = resources;
        }

        @Override // com.bumptech.glide.load.model.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<Integer, InputStream> c(r rVar) {
            return new s(this.f17346a, rVar.d(Uri.class, InputStream.class));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ResourceLoader.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class d implements o<Integer, Uri> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f17347a;

        public d(Resources resources) {
            this.f17347a = resources;
        }

        @Override // com.bumptech.glide.load.model.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<Integer, Uri> c(r rVar) {
            return new s(this.f17347a, v.c());
        }
    }

    public s(Resources resources, n<Uri, Data> nVar) {
        this.f17343b = resources;
        this.f17342a = nVar;
    }

    @Nullable
    private Uri d(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f17343b.getResourcePackageName(num.intValue()) + '/' + this.f17343b.getResourceTypeName(num.intValue()) + '/' + this.f17343b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e4) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                Log.w("ResourceLoader", "Received invalid resource id: " + num, e4);
                return null;
            }
            return null;
        }
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: c */
    public n.a<Data> b(@NonNull Integer num, int i4, int i5, @NonNull com.bumptech.glide.load.f fVar) {
        Uri d4 = d(num);
        if (d4 == null) {
            return null;
        }
        return this.f17342a.b(d4, i4, i5, fVar);
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: e */
    public boolean a(@NonNull Integer num) {
        return true;
    }
}

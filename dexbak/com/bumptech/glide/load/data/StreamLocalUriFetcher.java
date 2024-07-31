package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import androidx.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.data.n */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class StreamLocalUriFetcher extends LocalUriFetcher<InputStream> {

    /* renamed from: e */
    private static final int f13525e = 1;

    /* renamed from: f */
    private static final int f13526f = 2;

    /* renamed from: g */
    private static final int f13527g = 3;

    /* renamed from: h */
    private static final int f13528h = 4;

    /* renamed from: i */
    private static final int f13529i = 5;

    /* renamed from: j */
    private static final UriMatcher f13530j;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f13530j = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        uriMatcher.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public StreamLocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    /* renamed from: h */
    private InputStream m45439h(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        int match = f13530j.match(uri);
        if (match != 1) {
            if (match == 3) {
                return m45438i(contentResolver, uri);
            }
            if (match != 5) {
                return contentResolver.openInputStream(uri);
            }
        }
        Uri lookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (lookupContact != null) {
            return m45438i(contentResolver, lookupContact);
        }
        throw new FileNotFoundException("Contact cannot be found");
    }

    /* renamed from: i */
    private InputStream m45438i(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    /* renamed from: a */
    public Class<InputStream> mo45010a() {
        return InputStream.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    /* renamed from: f */
    public void mo45443c(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    /* renamed from: g */
    public InputStream mo45442e(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        InputStream m45439h = m45439h(uri, contentResolver);
        if (m45439h != null) {
            return m45439h;
        }
        throw new FileNotFoundException("InputStream is null for " + uri);
    }
}

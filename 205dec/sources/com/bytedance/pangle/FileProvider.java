package com.bytedance.pangle;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class FileProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f28599a = {"_display_name", "_size"};

    /* renamed from: b  reason: collision with root package name */
    private static final File f28600b = new File(TTPathConst.sSeparator);

    /* renamed from: c  reason: collision with root package name */
    private static a f28601c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface a {
        Uri a(File file);

        File a(Uri uri);
    }

    public static void a(Plugin plugin, XmlResourceParser xmlResourceParser) {
        try {
            try {
                String str = plugin.mPkgName;
                Context wrapperContext = ZeusTransformUtils.wrapperContext(Zeus.getAppApplication(), plugin.mPkgName);
                b bVar = (b) f28601c;
                while (true) {
                    int next = xmlResourceParser.next();
                    if (next == 1) {
                        return;
                    }
                    if (next == 2) {
                        String name = xmlResourceParser.getName();
                        File file = null;
                        String attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        String attributeValue2 = xmlResourceParser.getAttributeValue(null, "path");
                        if ("root-path".equals(name)) {
                            file = f28600b;
                        } else if ("files-path".equals(name)) {
                            file = wrapperContext.getFilesDir();
                        } else if ("cache-path".equals(name)) {
                            file = wrapperContext.getCacheDir();
                        } else if ("external-files-path".equals(name)) {
                            File[] externalFilesDirs = Build.VERSION.SDK_INT >= 19 ? wrapperContext.getExternalFilesDirs(null) : new File[]{wrapperContext.getExternalFilesDir(null)};
                            if (externalFilesDirs.length > 0) {
                                file = externalFilesDirs[0];
                            }
                        } else if ("external-cache-path".equals(name)) {
                            File[] externalCacheDirs = Build.VERSION.SDK_INT >= 19 ? wrapperContext.getExternalCacheDirs() : new File[]{wrapperContext.getExternalCacheDir()};
                            if (externalCacheDirs.length > 0) {
                                file = externalCacheDirs[0];
                            }
                        } else if (Build.VERSION.SDK_INT >= 21 && "external-media-path".equals(name)) {
                            File[] externalMediaDirs = wrapperContext.getExternalMediaDirs();
                            if (externalMediaDirs.length > 0) {
                                file = externalMediaDirs[0];
                            }
                        }
                        if (file != null) {
                            String str2 = str + "_" + attributeValue;
                            File a4 = a(file, attributeValue2);
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    bVar.f28602a.put(str2, a4.getCanonicalFile());
                                } catch (IOException e4) {
                                    throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(a4)), e4);
                                }
                            } else {
                                throw new IllegalArgumentException("Name must not be empty");
                            }
                        } else {
                            continue;
                        }
                    }
                }
            } catch (XmlPullParserException e5) {
                e = e5;
                e.printStackTrace();
            }
        } catch (IOException e6) {
            e = e6;
            e.printStackTrace();
        }
    }

    @Keep
    public static Uri getUriForFile(@NonNull File file) {
        return f28601c.a(file);
    }

    @Override // android.content.ContentProvider
    public void attachInfo(@NonNull Context context, @NonNull ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (!providerInfo.exported) {
            if (providerInfo.grantUriPermissions) {
                if (f28601c == null) {
                    f28601c = new b(providerInfo.authority);
                    return;
                }
                throw new SecurityException("\u4ec5\u5141\u8bb8\u5b9a\u4e49\u4e00\u4e2aFileProvider");
            }
            throw new SecurityException("Provider must grant uri permissions");
        }
        throw new SecurityException("Provider must not be exported");
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return f28601c.a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public String getType(@NonNull Uri uri) {
        File a4 = f28601c.a(uri);
        int lastIndexOf = a4.getName().lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(a4.getName().substring(lastIndexOf + 1));
            return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
        }
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(@NonNull Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(@NonNull Uri uri, @NonNull String str) {
        int i4;
        File a4 = f28601c.a(uri);
        if ("r".equals(str)) {
            i4 = 268435456;
        } else if ("w".equals(str) || "wt".equals(str)) {
            i4 = 738197504;
        } else if ("wa".equals(str)) {
            i4 = 704643072;
        } else if ("rw".equals(str)) {
            i4 = 939524096;
        } else if (!"rwt".equals(str)) {
            throw new IllegalArgumentException("Invalid mode: ".concat(String.valueOf(str)));
        } else {
            i4 = 1006632960;
        }
        return ParcelFileDescriptor.open(a4, i4);
    }

    @Override // android.content.ContentProvider
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        int i4;
        File a4 = f28601c.a(uri);
        if (strArr == null) {
            strArr = f28599a;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i5 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i5] = "_display_name";
                i4 = i5 + 1;
                objArr[i5] = a4.getName();
            } else if ("_size".equals(str3)) {
                strArr3[i5] = "_size";
                i4 = i5 + 1;
                objArr[i5] = Long.valueOf(a4.length());
            }
            i5 = i4;
        }
        String[] strArr4 = new String[i5];
        System.arraycopy(strArr3, 0, strArr4, 0, i5);
        Object[] objArr2 = new Object[i5];
        System.arraycopy(objArr, 0, objArr2, 0, i5);
        MatrixCursor matrixCursor = new MatrixCursor(strArr4, 1);
        matrixCursor.addRow(objArr2);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class b implements a {

        /* renamed from: a  reason: collision with root package name */
        final HashMap<String, File> f28602a = new HashMap<>();

        /* renamed from: b  reason: collision with root package name */
        private final String f28603b;

        b(String str) {
            this.f28603b = str;
        }

        @Override // com.bytedance.pangle.FileProvider.a
        public final Uri a(File file) {
            String substring;
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.f28602a.entrySet()) {
                    String path = entry2.getValue().getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry != null) {
                    String path2 = entry.getValue().getPath();
                    if (path2.endsWith(TTPathConst.sSeparator)) {
                        substring = canonicalPath.substring(path2.length());
                    } else {
                        substring = canonicalPath.substring(path2.length() + 1);
                    }
                    return new Uri.Builder().scheme("content").authority(this.f28603b).encodedPath(Uri.encode(entry.getKey()) + '/' + Uri.encode(substring, TTPathConst.sSeparator)).build();
                }
                throw new IllegalArgumentException("Failed to find configured root that contains ".concat(String.valueOf(canonicalPath)));
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(file)));
            }
        }

        @Override // com.bytedance.pangle.FileProvider.a
        public final File a(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = this.f28602a.get(decode);
            if (file != null) {
                File file2 = new File(file, decode2);
                try {
                    File canonicalFile = file2.getCanonicalFile();
                    if (canonicalFile.getPath().startsWith(file.getPath())) {
                        return canonicalFile;
                    }
                    throw new SecurityException("Resolved path jumped beyond configured root");
                } catch (IOException unused) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(file2)));
                }
            }
            throw new IllegalArgumentException("Unable to find configured root for ".concat(String.valueOf(uri)));
        }
    }

    private static File a(File file, String... strArr) {
        for (int i4 = 0; i4 <= 0; i4++) {
            String str = strArr[0];
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }
}

package xyz.adscope.common.cache;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import xyz.adscope.common.cache.model.CacheModel;
import xyz.adscope.common.db.DataBaseManager;
import xyz.adscope.common.imageloader.StorageUtils;
import xyz.adscope.common.tool.security.MD5Util;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class CacheManager {

    /* renamed from: c  reason: collision with root package name */
    public static final String f64565c = "image_cache" + File.separator;

    /* renamed from: d  reason: collision with root package name */
    public static CacheManager f64566d;

    /* renamed from: a  reason: collision with root package name */
    public DataBaseManager f64567a;

    /* renamed from: b  reason: collision with root package name */
    public Context f64568b;

    public CacheManager(Context context) {
        this.f64568b = context;
        DataBaseManager dataBaseManager = new DataBaseManager(context);
        this.f64567a = dataBaseManager;
        dataBaseManager.setTableNameAndModel("cache_image_video_table", CacheModel.class);
        File filesCacheDirectory = StorageUtils.getFilesCacheDirectory(context, f64565c);
        if (filesCacheDirectory.exists()) {
            return;
        }
        filesCacheDirectory.mkdirs();
    }

    public static CacheManager getInstance(Context context) {
        if (f64566d == null) {
            synchronized (CacheManager.class) {
                if (f64566d == null) {
                    f64566d = new CacheManager(context);
                }
            }
        }
        return f64566d;
    }

    public final long a(File file) {
        File[] listFiles;
        long j4 = 0;
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                j4 += file2.length();
            }
        }
        return j4;
    }

    public final File a(boolean z3, String str) {
        File filesCacheDirectory = StorageUtils.getFilesCacheDirectory(this.f64568b, z3 ? a() : c());
        if (!filesCacheDirectory.exists()) {
            filesCacheDirectory.mkdirs();
        }
        return new File(filesCacheDirectory.getPath(), str);
    }

    public final String a() {
        return f64565c + "can_delete";
    }

    public final void a(String str) {
        File a4 = a(true, str);
        if (a4.exists()) {
            a4.delete();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("fileName", str);
        DataBaseManager dataBaseManager = this.f64567a;
        if (dataBaseManager != null) {
            dataBaseManager.delete(hashMap);
        }
    }

    public final List<CacheModel> b() {
        DataBaseManager dataBaseManager = this.f64567a;
        if (dataBaseManager != null) {
            List query = dataBaseManager.query(null);
            int size = (query == null || query.size() <= 0) ? 0 : query.size() / 2;
            DataBaseManager dataBaseManager2 = this.f64567a;
            List<CacheModel> query2 = dataBaseManager2.query("lastUsedTime", size + "");
            if (query2 != null && query2.size() > 0) {
                return query2;
            }
        }
        return null;
    }

    public final String c() {
        return f64565c + "no_delete";
    }

    public Bitmap getBitmapByFileName(String str, boolean z3) {
        if (z3 && this.f64567a != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("fileName", MD5Util.md5(str));
            ContentValues contentValues = new ContentValues();
            contentValues.put("lastUsedTime", Long.valueOf(System.currentTimeMillis()));
            this.f64567a.update((Object) hashMap, contentValues);
        }
        File a4 = a(z3, MD5Util.md5(str));
        if (!a4.exists() || a4.length() <= 0) {
            return null;
        }
        return BitmapFactory.decodeFile(a4.getAbsolutePath());
    }

    public void performCacheCleanup() {
        List<CacheModel> b4;
        if (a(StorageUtils.getFilesCacheDirectory(this.f64568b, a())) <= 209715200 || (b4 = b()) == null || b4.size() <= 0) {
            return;
        }
        for (CacheModel cacheModel : b4) {
            a(cacheModel.getFileName());
        }
    }

    public void saveImage(String str, Bitmap bitmap, boolean z3) {
        File a4 = a(z3, MD5Util.md5(str));
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(a4));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (z3) {
            CacheModel cacheModel = new CacheModel();
            cacheModel.setFileSize(a4.length());
            cacheModel.setFileName(MD5Util.md5(str));
            cacheModel.setCanDelete(!z3 ? 1 : 0);
            cacheModel.setLastUsedTime(System.currentTimeMillis());
            DataBaseManager dataBaseManager = this.f64567a;
            if (dataBaseManager != null) {
                dataBaseManager.insert(cacheModel);
            }
        }
    }
}

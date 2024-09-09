package ulL.WeEFDVoZmmWVmW.yXd;

import android.content.SharedPreferences;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.AccessDeniedException;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import ulL.WeEFDVoZmmWVmW.yXd.services.FileResult;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class XSharedPreferences implements SharedPreferences {
    private static final String TAG = "XSharedPreferences";
    private static WatchService sWatcher;
    private final File mFile;
    private long mFileSize;
    private final String mFilename;
    private long mLastModified;
    private final HashMap mListeners;
    private boolean mLoaded;
    private Map mMap;
    private WatchKey mWatchKey;
    private static final HashMap sWatcherKeyInstances = new HashMap();
    private static final Object sContent = new Object();
    private static Thread sWatcherDaemon = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public class PrefsData {
        private byte[] mHash;
        public final XSharedPreferences mPrefs;
        private long mSize;

        public PrefsData(XSharedPreferences xSharedPreferences) {
            this.mPrefs = xSharedPreferences;
            this.mSize = XSharedPreferences.tryGetFileSize(xSharedPreferences.mFilename);
            this.mHash = XSharedPreferences.tryGetFileHash(xSharedPreferences.mFilename);
        }

        public boolean hasChanged() {
            long tryGetFileSize = XSharedPreferences.tryGetFileSize(this.mPrefs.mFilename);
            if (tryGetFileSize < 1) {
                return false;
            }
            if (tryGetFileSize != this.mSize) {
                this.mSize = tryGetFileSize;
                this.mHash = XSharedPreferences.tryGetFileHash(this.mPrefs.mFilename);
                return true;
            }
            byte[] tryGetFileHash = XSharedPreferences.tryGetFileHash(this.mPrefs.mFilename);
            if (Arrays.equals(tryGetFileHash, this.mHash)) {
                return false;
            }
            this.mHash = tryGetFileHash;
            return true;
        }
    }

    public XSharedPreferences(File file) {
        this.mListeners = new HashMap();
        this.mLoaded = false;
        this.mFile = file;
        this.mFilename = file.getAbsolutePath();
        init();
    }

    private void awaitLoadedLocked() {
        while (!this.mLoaded) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    private void init() {
        startLoadFromDisk();
    }

    private static void initWatcherDaemon() {
        Thread thread = new Thread() { // from class: ulL.WeEFDVoZmmWVmW.yXd.XSharedPreferences.1
            /* JADX WARN: Removed duplicated region for block: B:24:0x007b  */
            @Override // java.lang.Thread, java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r7 = this;
                L0:
                    java.nio.file.WatchService r0 = ulL.WeEFDVoZmmWVmW.yXd.XSharedPreferences.d()     // Catch: java.lang.InterruptedException -> L8d java.nio.file.ClosedWatchServiceException -> L8e
                    java.nio.file.WatchKey r0 = r0.take()     // Catch: java.lang.InterruptedException -> L8d java.nio.file.ClosedWatchServiceException -> L8e
                    java.util.List r1 = r0.pollEvents()
                    java.util.Iterator r1 = r1.iterator()
                L10:
                    boolean r2 = r1.hasNext()
                    if (r2 == 0) goto L88
                    java.lang.Object r2 = r1.next()
                    java.nio.file.WatchEvent r2 = (java.nio.file.WatchEvent) r2
                    java.nio.file.WatchEvent$Kind r3 = r2.kind()
                    java.nio.file.WatchEvent$Kind r4 = java.nio.file.StandardWatchEventKinds.OVERFLOW
                    if (r3 != r4) goto L25
                    goto L10
                L25:
                    java.nio.file.Watchable r4 = r0.watchable()
                    java.nio.file.Path r4 = (java.nio.file.Path) r4
                    java.lang.Object r2 = r2.context()
                    java.nio.file.Path r2 = (java.nio.file.Path) r2
                    java.nio.file.Path r2 = r4.resolve(r2)
                    java.lang.String r2 = r2.toString()
                    java.lang.String r4 = ".bak"
                    boolean r5 = r2.endsWith(r4)
                    if (r5 == 0) goto L46
                    java.nio.file.WatchEvent$Kind r2 = java.nio.file.StandardWatchEventKinds.ENTRY_DELETE
                    if (r3 == r2) goto L55
                    goto L10
                L46:
                    ulL.WeEFDVoZmmWVmW.yXd.services.BaseService r3 = ulL.WeEFDVoZmmWVmW.yXd.SELinuxHelper.getAppDataFileService()
                    java.lang.String r2 = r2.concat(r4)
                    boolean r2 = r3.checkFileExists(r2)
                    if (r2 == 0) goto L55
                    goto L10
                L55:
                    java.util.HashMap r2 = ulL.WeEFDVoZmmWVmW.yXd.XSharedPreferences.e()
                    java.lang.Object r2 = r2.get(r0)
                    ulL.WeEFDVoZmmWVmW.yXd.XSharedPreferences$PrefsData r2 = (ulL.WeEFDVoZmmWVmW.yXd.XSharedPreferences.PrefsData) r2
                    if (r2 == 0) goto L10
                    boolean r3 = r2.hasChanged()
                    if (r3 == 0) goto L10
                    ulL.WeEFDVoZmmWVmW.yXd.XSharedPreferences r3 = r2.mPrefs
                    java.util.HashMap r3 = ulL.WeEFDVoZmmWVmW.yXd.XSharedPreferences.b(r3)
                    java.util.Set r3 = r3.keySet()
                    java.util.Iterator r3 = r3.iterator()
                L75:
                    boolean r4 = r3.hasNext()
                    if (r4 == 0) goto L10
                    java.lang.Object r4 = r3.next()
                    android.content.SharedPreferences$OnSharedPreferenceChangeListener r4 = (android.content.SharedPreferences.OnSharedPreferenceChangeListener) r4
                    ulL.WeEFDVoZmmWVmW.yXd.XSharedPreferences r5 = r2.mPrefs     // Catch: java.lang.Throwable -> L75
                    r6 = 0
                    r4.onSharedPreferenceChanged(r5, r6)     // Catch: java.lang.Throwable -> L75
                    goto L75
                L88:
                    r0.reset()
                    goto L0
                L8d:
                    return
                L8e:
                    ulL.WeEFDVoZmmWVmW.yXd.XSharedPreferences.f()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: ulL.WeEFDVoZmmWVmW.yXd.XSharedPreferences.AnonymousClass1.run():void");
            }
        };
        sWatcherDaemon = thread;
        thread.setName("XSharedPreferences-Daemon");
        sWatcherDaemon.setDaemon(true);
        sWatcherDaemon.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void loadFromDiskLocked() {
        /*
            Method dump skipped, instructions count: 196
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ulL.WeEFDVoZmmWVmW.yXd.XSharedPreferences.loadFromDiskLocked():void");
    }

    private void startLoadFromDisk() {
        synchronized (this) {
            this.mLoaded = false;
        }
        new Thread("XSharedPreferences-load") { // from class: ulL.WeEFDVoZmmWVmW.yXd.XSharedPreferences.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                synchronized (XSharedPreferences.this) {
                    XSharedPreferences.this.loadFromDiskLocked();
                }
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] tryGetFileHash(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            InputStream fileInputStream = SELinuxHelper.getAppDataFileService().getFileInputStream(str);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    fileInputStream.close();
                    return messageDigest.digest();
                }
                messageDigest.update(bArr, 0, read);
            }
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long tryGetFileSize(String str) {
        try {
            return SELinuxHelper.getAppDataFileService().getFileSize(str);
        } catch (IOException unused) {
            return 0L;
        }
    }

    private void tryRegisterWatcher() {
        WatchKey watchKey = this.mWatchKey;
        if (watchKey == null || !watchKey.isValid()) {
            HashMap hashMap = sWatcherKeyInstances;
            synchronized (hashMap) {
                try {
                    Path path = this.mFile.toPath();
                    try {
                        if (sWatcher == null) {
                            sWatcher = new File(C1455d.f54605b.e("")).toPath().getFileSystem().newWatchService();
                        }
                        WatchKey register = path.getParent().register(sWatcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);
                        this.mWatchKey = register;
                        hashMap.put(register, new PrefsData(this));
                        Thread thread = sWatcherDaemon;
                        if (thread == null || !thread.isAlive()) {
                            initWatcherDaemon();
                        }
                    } catch (AccessDeniedException unused) {
                    } catch (Exception e4) {
                        Log.e(TAG, "tryRegisterWatcher: failed to register file watcher", e4);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private void tryUnregisterWatcher() {
        HashMap hashMap = sWatcherKeyInstances;
        synchronized (hashMap) {
            try {
                WatchKey watchKey = this.mWatchKey;
                if (watchKey != null) {
                    hashMap.remove(watchKey);
                    this.mWatchKey.cancel();
                    this.mWatchKey = null;
                }
                boolean z3 = false;
                for (WatchKey watchKey2 : hashMap.keySet()) {
                    z3 |= watchKey2.isValid();
                }
                if (!z3) {
                    try {
                        sWatcher.close();
                    } catch (Exception unused) {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        boolean containsKey;
        synchronized (this) {
            awaitLoadedLocked();
            containsKey = this.mMap.containsKey(str);
        }
        return containsKey;
    }

    @Override // android.content.SharedPreferences
    @Deprecated
    public SharedPreferences.Editor edit() {
        throw new UnsupportedOperationException("read-only implementation");
    }

    @Override // android.content.SharedPreferences
    public Map getAll() {
        HashMap hashMap;
        synchronized (this) {
            awaitLoadedLocked();
            hashMap = new HashMap(this.mMap);
        }
        return hashMap;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z3) {
        synchronized (this) {
            try {
                awaitLoadedLocked();
                Boolean bool = (Boolean) this.mMap.get(str);
                if (bool != null) {
                    z3 = bool.booleanValue();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z3;
    }

    public File getFile() {
        return this.mFile;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f4) {
        synchronized (this) {
            try {
                awaitLoadedLocked();
                Float f5 = (Float) this.mMap.get(str);
                if (f5 != null) {
                    f4 = f5.floatValue();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f4;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i4) {
        synchronized (this) {
            try {
                awaitLoadedLocked();
                Integer num = (Integer) this.mMap.get(str);
                if (num != null) {
                    i4 = num.intValue();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i4;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j4) {
        synchronized (this) {
            try {
                awaitLoadedLocked();
                Long l4 = (Long) this.mMap.get(str);
                if (l4 != null) {
                    j4 = l4.longValue();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return j4;
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        synchronized (this) {
            awaitLoadedLocked();
            String str3 = (String) this.mMap.get(str);
            if (str3 != null) {
                str2 = str3;
            }
        }
        return str2;
    }

    @Override // android.content.SharedPreferences
    public Set getStringSet(String str, Set set) {
        synchronized (this) {
            awaitLoadedLocked();
            Set set2 = (Set) this.mMap.get(str);
            if (set2 != null) {
                set = set2;
            }
        }
        return set;
    }

    public synchronized boolean hasFileChanged() {
        boolean z3;
        z3 = true;
        try {
            FileResult statFile = SELinuxHelper.getAppDataFileService().statFile(this.mFilename);
            if (this.mLastModified == statFile.mtime) {
                if (this.mFileSize == statFile.size) {
                    z3 = false;
                }
            }
        } catch (FileNotFoundException unused) {
            return true;
        } catch (IOException e4) {
            Log.w(TAG, "hasFileChanged", e4);
            return true;
        }
        return z3;
    }

    public boolean makeWorldReadable() {
        if (SELinuxHelper.getAppDataFileService().hasDirectFileAccess() && this.mFile.exists() && this.mFile.setReadable(true, false)) {
            if (this.mFile.getParentFile() != null) {
                this.mFile.getParentFile().setReadable(true, false);
            }
            if (!this.mListeners.isEmpty()) {
                tryRegisterWatcher();
            }
            return true;
        }
        return false;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (onSharedPreferenceChangeListener == null) {
            throw new IllegalArgumentException("listener cannot be null");
        }
        synchronized (this) {
            try {
                if (this.mListeners.put(onSharedPreferenceChangeListener, sContent) == null) {
                    tryRegisterWatcher();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized void reload() {
        if (hasFileChanged()) {
            init();
        }
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this) {
            try {
                if (this.mListeners.remove(onSharedPreferenceChangeListener) != null && this.mListeners.isEmpty()) {
                    tryUnregisterWatcher();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public XSharedPreferences(String str) {
        this(str, str + "_preferences");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public XSharedPreferences(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String r0 = "xposedminversion"
            r7.<init>()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r7.mListeners = r1
            r1 = 0
            r7.mLoaded = r1
            java.util.Map r2 = ulL.WeEFDVoZmmWVmW.yXd.XposedInit.getLoadedModules()
            java.util.Optional r3 = java.util.Optional.empty()
            java.lang.Object r2 = r2.getOrDefault(r8, r3)
            java.util.Optional r2 = (java.util.Optional) r2
            boolean r3 = r2.isPresent()
            java.lang.String r4 = ".xml"
            if (r3 == 0) goto La1
            r3 = -1
            java.io.File r5 = new java.io.File     // Catch: java.io.IOException -> L64 java.lang.NumberFormatException -> L67
            java.lang.Object r2 = r2.get()     // Catch: java.io.IOException -> L64 java.lang.NumberFormatException -> L67
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.io.IOException -> L64 java.lang.NumberFormatException -> L67
            r5.<init>(r2)     // Catch: java.io.IOException -> L64 java.lang.NumberFormatException -> L67
            P r2 = new P     // Catch: java.io.IOException -> L64 java.lang.NumberFormatException -> L67
            r2.<init>(r5)     // Catch: java.io.IOException -> L64 java.lang.NumberFormatException -> L67
            java.lang.Object r2 = r2.f53a     // Catch: java.io.IOException -> L64 java.lang.NumberFormatException -> L67
            java.util.HashMap r2 = (java.util.HashMap) r2     // Catch: java.io.IOException -> L64 java.lang.NumberFormatException -> L67
            boolean r5 = r2.containsKey(r0)     // Catch: java.io.IOException -> L64 java.lang.NumberFormatException -> L67
            if (r5 == 0) goto L7c
            java.lang.Object r0 = r2.get(r0)     // Catch: java.io.IOException -> L4f java.lang.NumberFormatException -> L51
            boolean r6 = r0 instanceof java.lang.Integer     // Catch: java.io.IOException -> L4f java.lang.NumberFormatException -> L51
            if (r6 == 0) goto L53
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.io.IOException -> L4f java.lang.NumberFormatException -> L51
            int r3 = r0.intValue()     // Catch: java.io.IOException -> L4f java.lang.NumberFormatException -> L51
            goto L5d
        L4f:
            r0 = move-exception
            goto L69
        L51:
            r0 = move-exception
            goto L69
        L53:
            boolean r6 = r0 instanceof java.lang.String     // Catch: java.io.IOException -> L4f java.lang.NumberFormatException -> L51
            if (r6 == 0) goto L5d
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.io.IOException -> L4f java.lang.NumberFormatException -> L51
            int r3 = defpackage.P.b(r0)     // Catch: java.io.IOException -> L4f java.lang.NumberFormatException -> L51
        L5d:
            java.lang.String r0 = "xposedsharedprefs"
            boolean r1 = r2.containsKey(r0)     // Catch: java.io.IOException -> L4f java.lang.NumberFormatException -> L51
            goto L7c
        L64:
            r0 = move-exception
        L65:
            r5 = r1
            goto L69
        L67:
            r0 = move-exception
            goto L65
        L69:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r6 = "Apk parser fails: "
            r2.<init>(r6)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r2 = "XSharedPreferences"
            android.util.Log.w(r2, r0)
        L7c:
            if (r5 == 0) goto La1
            r0 = 92
            if (r3 > r0) goto L84
            if (r1 == 0) goto La1
        L84:
            java.io.File r0 = new java.io.File
            d r1 = defpackage.C1455d.f54605b
            java.lang.String r8 = r1.e(r8)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r9)
            r1.append(r4)
            java.lang.String r9 = r1.toString()
            r0.<init>(r8, r9)
            r7.mFile = r0
            goto Lc5
        La1:
            java.io.File r0 = new java.io.File
            java.io.File r1 = android.os.Environment.getDataDirectory()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "data/"
            r2.<init>(r3)
            r2.append(r8)
            java.lang.String r8 = "/shared_prefs/"
            r2.append(r8)
            r2.append(r9)
            r2.append(r4)
            java.lang.String r8 = r2.toString()
            r0.<init>(r1, r8)
            r7.mFile = r0
        Lc5:
            java.io.File r8 = r7.mFile
            java.lang.String r8 = r8.getAbsolutePath()
            r7.mFilename = r8
            r7.init()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ulL.WeEFDVoZmmWVmW.yXd.XSharedPreferences.<init>(java.lang.String, java.lang.String):void");
    }
}

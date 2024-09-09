package com.umeng.analytics.filter;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class EventList extends c implements FileLockCallback {
    private static final int DELETE_LIST_DATA = 2;
    private static final int LOAD_LIST_DATA = 1;
    private static final int SAVE_LIST_DATA = 0;
    private Context mAppContext;
    protected String mEventList;
    protected String mEventListKey;
    protected String mEventListName;
    protected String mEventListVersionKey;
    private FileLockUtil mFileLock = new FileLockUtil();

    public EventList(String str, String str2) {
        this.mEventListName = str;
        this.mEventListKey = str;
        this.mEventListVersionKey = str2;
    }

    private void deleteDataFile(File file) {
        if (this.mAppContext != null) {
            synchronized (this.mFileLock) {
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    private boolean loadEventListFromFile(Context context, File file) {
        Throwable th;
        BufferedReader bufferedReader;
        String sb;
        if (file.exists() && TextUtils.isEmpty(this.mEventList)) {
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                }
                try {
                    StringBuilder sb2 = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb2.append(readLine);
                    }
                    sb = sb2.toString();
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        UMCrashManager.reportCrash(context, th);
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return false;
                    } catch (Throwable th4) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th5) {
                                UMCrashManager.reportCrash(context, th5);
                            }
                        }
                        throw th4;
                    }
                }
                if (!TextUtils.isEmpty(sb)) {
                    String md5 = HelperUtils.getMD5(sb);
                    String imprintProperty = UMEnvelopeBuild.imprintProperty(context, this.mEventListVersionKey, "");
                    this.mEventList = sb;
                    eventListChange();
                    UMRTLog.i("MobclickRT", "--->>> loadEventListFromFile: mEventList = " + this.mEventList);
                    if (UMUtils.isMainProgress(context)) {
                        if (md5.equalsIgnoreCase(imprintProperty)) {
                            this.mEventList = sb;
                            setMD5ClearFlag(false);
                            try {
                                bufferedReader.close();
                            } catch (Throwable th6) {
                                UMCrashManager.reportCrash(context, th6);
                            }
                            return true;
                        }
                        setMD5ClearFlag(true);
                        try {
                            bufferedReader.close();
                        } catch (Throwable th7) {
                            UMCrashManager.reportCrash(context, th7);
                        }
                        return false;
                    } else if (md5.equalsIgnoreCase(imprintProperty)) {
                        this.mEventList = sb;
                        eventListChange();
                        try {
                            bufferedReader.close();
                        } catch (Throwable th8) {
                            UMCrashManager.reportCrash(context, th8);
                        }
                        return true;
                    } else {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th9) {
                            UMCrashManager.reportCrash(context, th9);
                        }
                        return false;
                    }
                }
                bufferedReader.close();
            } catch (Throwable th10) {
                UMCrashManager.reportCrash(context, th10);
            }
        }
        return false;
    }

    private void saveEventListToFile(Context context, File file) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(this.mEventList.getBytes());
            fileOutputStream.close();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public boolean enabled() {
        synchronized (this) {
            return this.mEventList != null;
        }
    }

    protected void eventListChange() {
    }

    public boolean matchHit(String str) {
        return false;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(File file, int i4) {
        if (i4 == 0) {
            synchronized (this) {
                saveEventListToFile(this.mAppContext, file);
            }
        } else if (i4 == 1) {
            synchronized (this) {
                if (loadEventListFromFile(this.mAppContext, file)) {
                    UMRTLog.i("MobclickRT", "--->>> find event list data file, load it.");
                } else {
                    UMRTLog.i("MobclickRT", "--->>> can't find event list file.");
                }
            }
        } else if (i4 == 2) {
            synchronized (this) {
                this.mEventList = null;
                deleteDataFile(file);
            }
        }
        return true;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str) {
        return false;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str, Object obj) {
        return false;
    }

    @Override // com.umeng.analytics.filter.c, com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
    public void onImprintValueChanged(String str, String str2) {
        if ("ekv_bl_ver".equals(str) && str2 == null) {
            UMRTLog.i("MobclickRT", "--->>> disable black list for ekv.");
            this.mFileLock.doFileOperateion(new File(this.mAppContext.getFilesDir(), this.mEventListName), this, 2);
        }
        if ("ekv_wl_ver".equals(str) && str2 == null) {
            UMRTLog.i("MobclickRT", "--->>> disable white list for ekv.");
            this.mFileLock.doFileOperateion(new File(this.mAppContext.getFilesDir(), this.mEventListName), this, 2);
        }
    }

    @Override // com.umeng.analytics.filter.c, com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback
    public boolean onPreProcessImprintKey(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return true;
        }
        int length = str2.length();
        UMRTLog.i("MobclickRT", "--->>> onPreProcessImprintKey: key = " + str + "; len of value=" + length);
        StringBuilder sb = new StringBuilder();
        sb.append("--->>> onPreProcessImprintKey: value = ");
        sb.append(str2);
        UMRTLog.i("MobclickRT", sb.toString());
        this.mEventList = str2;
        eventListChange();
        File file = new File(this.mAppContext.getFilesDir(), this.mEventListName);
        if (!file.exists()) {
            try {
                try {
                    file.createNewFile();
                } catch (IOException unused) {
                    file.createNewFile();
                }
            } catch (IOException e4) {
                UMCrashManager.reportCrash(this.mAppContext, e4);
            }
        }
        this.mFileLock.doFileOperateion(file, this, 0);
        setMD5ClearFlag(false);
        return true;
    }

    public void register(Context context) {
        if (this.mAppContext == null) {
            this.mAppContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        File file = new File(this.mAppContext.getFilesDir(), this.mEventListName);
        if (!TextUtils.isEmpty(UMEnvelopeBuild.imprintProperty(this.mAppContext, this.mEventListVersionKey, ""))) {
            if (file.exists()) {
                this.mFileLock.doFileOperateion(file, this, 1);
            } else {
                setMD5ClearFlag(true);
            }
        }
        if (UMUtils.isMainProgress(this.mAppContext)) {
            ImprintHandler.getImprintService(this.mAppContext).registPreProcessCallback(this.mEventListKey, this);
            ImprintHandler.getImprintService(this.mAppContext).registImprintCallback(this.mEventListVersionKey, this);
        }
    }

    public void setMD5ClearFlag(boolean z3) {
    }

    public String toString() {
        if (TextUtils.isEmpty(this.mEventListName) || TextUtils.isEmpty(this.mEventListKey)) {
            return "Uninitialized EventList.";
        }
        StringBuilder sb = new StringBuilder("[");
        sb.append("EventListName:" + this.mEventListName + ",");
        sb.append("listKey:" + this.mEventListKey + ",");
        if (!TextUtils.isEmpty(this.mEventList)) {
            sb.append("listKeyValue:" + this.mEventList + "]");
        } else {
            sb.append("listKeyValue:empty,");
        }
        if (!TextUtils.isEmpty(this.mEventListVersionKey)) {
            sb.append("listKeyVer:" + this.mEventListVersionKey + "]");
        } else {
            sb.append("listKeyVer:empty]");
        }
        return sb.toString();
    }
}

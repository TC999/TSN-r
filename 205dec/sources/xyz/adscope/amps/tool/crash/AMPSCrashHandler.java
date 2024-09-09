package xyz.adscope.amps.tool.crash;

import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.stub.StubApp;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.model.crash.AMPSCrashRequestModel;
import xyz.adscope.amps.tool.persistent.sp.AMPSSpUtil;
import xyz.adscope.common.tool.LogUtil;
import xyz.adscope.common.tool.utils.FileUtils;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSCrashHandler implements Thread.UncaughtExceptionHandler {
    private static final String CRASH_AFFILIATED_ADSCOPE_AMPS = "Adscope-AMPS";
    private static final String CRASH_AFFILIATED_ADSCOPE_ASMS = "Adscope-ASMS";
    private static final String CRASH_AFFILIATED_ADSCOPE_ASNP = "Adscope-ASNP";
    private static final String CRASH_AFFILIATED_ADSCOPE_COMMON = "Adscope-COMMON";
    private static final String CRASH_AFFILIATED_APP = "APP";
    private static final String CRASH_FILE_PATH = "/AMPS/crash/log/";
    private static final String CRASH_PACKAGE_NAME_ADSCOPE_AMPS = "xyz.adscope.amps";
    private static final String CRASH_PACKAGE_NAME_ADSCOPE_ASMS = "xyz.adscope.asms";
    private static final String CRASH_PACKAGE_NAME_ADSCOPE_ASNP = "xyz.adscope.amps";
    private static final String CRASH_PACKAGE_NAME_ADSCOPE_COMMON = "xyz.adscope.common";
    private static final boolean DEBUG = true;
    private static final String FILE_NAME = "crash_";
    private static final String FILE_NAME_SUFFIX = ".trace";
    private static final String TAG = "CrashHandler";
    private static AMPSCrashHandler sInstance = new AMPSCrashHandler();
    private Context mContext;
    private Thread.UncaughtExceptionHandler mDefaultCrashHandler;

    private AMPSCrashHandler() {
    }

    public static AMPSCrashHandler getInstance() {
        return sInstance;
    }

    private boolean handleException(final Throwable th) {
        if (th == null) {
            return false;
        }
        new Thread(new Runnable() { // from class: xyz.adscope.amps.tool.crash.AMPSCrashHandler.1
            @Override // java.lang.Runnable
            public void run() {
                Looper.prepare();
                AMPSCrashHandler.this.writeCrash(th);
                Looper.loop();
            }
        }).start();
        try {
            Thread.sleep(1000L);
            return true;
        } catch (InterruptedException e4) {
            LogUtil.e(TAG, "e : " + e4);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeCrash(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            cause.printStackTrace(printWriter);
        }
        printWriter.close();
        String obj = stringWriter.toString();
        if (!TextUtils.isEmpty(obj) && obj.contains(AMPSConstants.AMPS_CRASH_REQUEST_SDK_PACKAGENAME)) {
            AMPSSpUtil.put(AMPSConstants.AMPS_CRASH_REASON_KEY, Boolean.TRUE);
        }
        writeLog(obj);
    }

    private void writeLog(String str) {
        File appRootPath;
        try {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                LogUtil.e(TAG, "sdcard unmounted,skip dump exception");
                return;
            }
            Context context = this.mContext;
            if (context == null || (appRootPath = FileUtils.getAppRootPath(context)) == null) {
                return;
            }
            String str2 = appRootPath.getPath() + CRASH_FILE_PATH;
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            long currentTimeMillis = System.currentTimeMillis();
            String format = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS").format(new Date(currentTimeMillis));
            String str3 = FILE_NAME + currentTimeMillis + FILE_NAME_SUFFIX;
            HashMap hashMap = new HashMap();
            hashMap.put(str3, "false");
            AMPSSpUtil.put(AMPSConstants.AMPS_CRASH_REPORT_KEY, hashMap.toString());
            File file2 = new File(str2 + str3);
            file2.createNewFile();
            FileWriter fileWriter = new FileWriter(file2, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(format);
            bufferedWriter.write("\r\n");
            bufferedWriter.write("------------------crash----------------------");
            bufferedWriter.write("\r\n");
            bufferedWriter.write(str);
            bufferedWriter.write("\r\n");
            bufferedWriter.write("-------------------end-----------------------");
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception unused) {
        } catch (Throwable th) {
            LogUtil.e(TAG, "e : " + th);
        }
    }

    public List<AMPSCrashRequestModel> getCrashData() {
        String str;
        List<File> fileList = FileUtils.getFileList(FileUtils.getAppRootPath(this.mContext).getPath() + CRASH_FILE_PATH);
        Map<String, String> mapStringToMap = mapStringToMap(AMPSSpUtil.getString(AMPSConstants.AMPS_CRASH_REPORT_KEY));
        ArrayList arrayList = new ArrayList();
        if (fileList != null && fileList.size() > 0) {
            for (File file : fileList) {
                String name = file.getName();
                LogUtil.e("File", "file:" + file);
                if (file.exists() && mapStringToMap != null && mapStringToMap.size() > 0) {
                    if (mapStringToMap.containsKey(name) && "false".equals(mapStringToMap.get(name))) {
                        String readFileContent = FileUtils.readFileContent(file);
                        if (!TextUtils.isEmpty(readFileContent)) {
                            AMPSCrashRequestModel aMPSCrashRequestModel = new AMPSCrashRequestModel();
                            aMPSCrashRequestModel.setException(readFileContent);
                            aMPSCrashRequestModel.setLog_time(String.valueOf(System.currentTimeMillis()));
                            if (readFileContent.contains("xyz.adscope.common")) {
                                str = CRASH_AFFILIATED_ADSCOPE_COMMON;
                            } else if (readFileContent.contains("xyz.adscope.amps")) {
                                str = CRASH_AFFILIATED_ADSCOPE_ASNP;
                            } else if (readFileContent.contains(CRASH_PACKAGE_NAME_ADSCOPE_ASMS)) {
                                str = CRASH_AFFILIATED_ADSCOPE_ASMS;
                            } else {
                                str = readFileContent.contains("xyz.adscope.amps") ? CRASH_AFFILIATED_ADSCOPE_AMPS : CRASH_AFFILIATED_APP;
                            }
                            aMPSCrashRequestModel.setAffiliated(str);
                            arrayList.add(aMPSCrashRequestModel);
                            LogUtil.e("File", "affiliated:" + str + "\n;execption:" + readFileContent);
                        }
                        mapStringToMap.put(name, "true");
                    } else {
                        mapStringToMap.remove(name);
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                } else if (file.exists()) {
                    file.delete();
                }
            }
            if (mapStringToMap != null && !mapStringToMap.isEmpty()) {
                AMPSSpUtil.put(AMPSConstants.AMPS_CRASH_REPORT_KEY, mapStringToMap.toString());
            } else {
                AMPSSpUtil.put(AMPSConstants.AMPS_CRASH_REPORT_KEY, "");
            }
        } else if (mapStringToMap != null && mapStringToMap.size() > 0) {
            AMPSSpUtil.put(AMPSConstants.AMPS_CRASH_REPORT_KEY, "");
        }
        return arrayList;
    }

    public void init(Context context) {
        if (context == null) {
            return;
        }
        this.mDefaultCrashHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.mContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public Map<String, String> mapStringToMap(String str) {
        try {
            if (!TextUtils.isEmpty(str.trim()) && str.length() >= 2) {
                String[] split = str.substring(1, str.length() - 1).split(",");
                HashMap hashMap = new HashMap();
                for (String str2 : split) {
                    String[] split2 = str2.split("=");
                    if (split2.length == 2) {
                        hashMap.put(split2[0].trim(), split2[1].trim());
                    } else {
                        LogUtil.e(TAG, "Invalid key-value pair: " + str2);
                    }
                }
                return hashMap;
            }
        } catch (Exception e4) {
            LogUtil.e(TAG, "Exception: " + e4);
        }
        return null;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            handleException(th);
        } catch (Exception e4) {
            LogUtil.e(TAG, "e : " + e4);
        } catch (Throwable th2) {
            LogUtil.e(TAG, "e : " + th2);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mDefaultCrashHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            Process.killProcess(Process.myPid());
        }
    }
}

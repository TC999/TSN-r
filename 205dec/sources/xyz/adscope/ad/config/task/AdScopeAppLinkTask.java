package xyz.adscope.ad.config.task;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;
import xyz.adscope.ad.constants.Constants;
import xyz.adscope.ad.control.action.util.PageJumpUtil;
import xyz.adscope.ad.model.http.request.ad.AdRequestInfo;
import xyz.adscope.ad.model.http.request.ad.AppInstallModel;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;
import xyz.adscope.ad.model.http.response.config.PkgModel;
import xyz.adscope.ad.model.http.response.config.TaskModel;
import xyz.adscope.ad.model.http.response.config.TaskUrlsModel;
import xyz.adscope.ad.tool.event.model.AdScopeEventReportModel;
import xyz.adscope.ad.tool.event.model.EventReportCode;
import xyz.adscope.ad.tool.event.report.AdScopeEventReport;
import xyz.adscope.ad.tool.event.report.AdScopeModifyMacro;
import xyz.adscope.ad.tool.persistent.sp.AdScopeSpUtil;
import xyz.adscope.ad.tool.request.AdScopeHttpRequest;
import xyz.adscope.ad.tool.request.inter.IHttpResponseCallback;
import xyz.adscope.ad.tool.task.TimerOutTask;
import xyz.adscope.ad.tool.task.inter.ITimerTaskCallback;
import xyz.adscope.common.json.JSONParse;
import xyz.adscope.common.tool.LogUtil;
import xyz.adscope.common.tool.utils.SystemUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdScopeAppLinkTask implements Runnable {
    private static final int AD_REQUEST_ADDRESS_CALL = 999;
    private static final int AD_REQUEST_CALL_BACK_ALL = 2;
    private static final int AD_REQUEST_TYPE = 1;
    private static final long CHECK_APP_INSTALL_TIME = 604800000;
    private String apiKey;
    private Context context;
    private List<TaskModel> taskModelList;
    private int TASK_TYPE_INSTALL = 1;
    private int TASK_TYPE_REQUEST_URL = 2;
    private String TASK_URL_GET = "GET";
    private String TASK_URL_POST = "POST";
    private String TASK_URL_WEB_VIEW = "WEBVIEW";
    private String TASK_URL_DEEP_LINK = "DEEPLINK";
    private String appInstall = "__APP_INSTALLS__";

    public AdScopeAppLinkTask(Context context, List<TaskModel> list, String str) {
        this.context = context;
        this.taskModelList = list;
        this.apiKey = str;
    }

    private void doGetRequestTask(String str) {
        try {
            String str2 = Constants.TAG;
            LogUtil.i(str2, "task_execute_asnp doGetRequestTask : " + str);
            new AdScopeHttpRequest().requestWithGetMethod(str, new IHttpResponseCallback<Object>() { // from class: xyz.adscope.ad.config.task.AdScopeAppLinkTask.1
                @Override // xyz.adscope.ad.tool.request.inter.IHttpResponseCallback
                public void failCallback(String str3, int i4) {
                    String str4 = Constants.TAG;
                    LogUtil.i(str4, "failCallback sendGetRequestTask : msg " + str3 + " , code : " + str3);
                }

                @Override // xyz.adscope.ad.tool.request.inter.IHttpResponseCallback
                public void successCallback(Object obj) {
                    String str3 = Constants.TAG;
                    LogUtil.i(str3, "successCallback sendGetRequestTask : object " + obj);
                }
            });
        } catch (Throwable th) {
            String str3 = Constants.TAG;
            LogUtil.i(str3, "e : " + th);
        }
    }

    private void doPostInstallsTask(String str, String str2, String str3) {
        String substring;
        try {
            String str4 = Constants.TAG;
            LogUtil.i(str4, "task_execute_asnp doPostURlRequestTask taskUrl : " + str + " , macro : " + str2 + " , appLinks : " + str3);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String str5 = "";
            if (!TextUtils.isEmpty(str2)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(replaceMacroUrl(str2, str3));
                substring = arrayList.toString();
            } else {
                if (str.contains("?")) {
                    substring = str.substring(str.indexOf("?") + 1);
                }
                doPostRequestTask(str, str5);
            }
            str5 = substring;
            doPostRequestTask(str, str5);
        } catch (Throwable th) {
            String str6 = Constants.TAG;
            LogUtil.i(str6, "e : " + th);
        }
    }

    private void doPostRequestTask(String str, String str2) {
        try {
            new AdScopeHttpRequest().requestWithPostMethod(str, str2, new IHttpResponseCallback<Object>() { // from class: xyz.adscope.ad.config.task.AdScopeAppLinkTask.2
                @Override // xyz.adscope.ad.tool.request.inter.IHttpResponseCallback
                public void failCallback(String str3, int i4) {
                    String str4 = Constants.TAG;
                    LogUtil.i(str4, "failCallback doPostRequestTask : msg " + str3 + " , code : " + str3);
                }

                @Override // xyz.adscope.ad.tool.request.inter.IHttpResponseCallback
                public void successCallback(Object obj) {
                    String str3 = Constants.TAG;
                    LogUtil.i(str3, "successCallback doPostRequestTask : object " + obj);
                }
            });
        } catch (Throwable th) {
            String str3 = Constants.TAG;
            LogUtil.i(str3, "e : " + th);
        }
    }

    private void doPostURlRequestTask(String str) {
        try {
            String str2 = Constants.TAG;
            LogUtil.i(str2, "task_execute_asnp doPostURlRequestTask replaceUrl : " + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String str3 = "";
            if (str.contains("?")) {
                str3 = str.substring(str.indexOf("?") + 1);
                str = str.substring(0, str.indexOf("?"));
            }
            doPostRequestTask(str, str3);
        } catch (Throwable th) {
            String str4 = Constants.TAG;
            LogUtil.i(str4, "e : " + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendRequestUrl$2(TaskUrlsModel taskUrlsModel, TimerOutTask timerOutTask) {
        if (!TextUtils.isEmpty(taskUrlsModel.getImplement())) {
            if (this.TASK_URL_GET.equals(taskUrlsModel.getImplement().toUpperCase())) {
                doGetRequestTask(taskUrlsModel.getUrl());
            } else if (this.TASK_URL_POST.equals(taskUrlsModel.getImplement().toUpperCase())) {
                doPostURlRequestTask(taskUrlsModel.getUrl());
            } else if (this.TASK_URL_WEB_VIEW.equals(taskUrlsModel.getImplement().toUpperCase())) {
                startWebViewPage(taskUrlsModel.getUrl());
            } else if (this.TASK_URL_DEEP_LINK.equals(taskUrlsModel.getImplement().toUpperCase())) {
                launchDeepLink(taskUrlsModel.getUrl());
            }
        }
        timerOutTask.cancelReportTrackTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startTaskWithInfo$0(TaskModel taskModel, TimerOutTask timerOutTask) {
        reportAppLink(taskModel);
        timerOutTask.cancelReportTrackTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startTaskWithInfo$1(TaskModel taskModel, TimerOutTask timerOutTask) {
        sendRequestUrl(taskModel);
        timerOutTask.cancelReportTrackTimer();
    }

    private void launchDeepLink(String str) {
        String str2 = Constants.TAG;
        LogUtil.i(str2, "task_execute_asnp launchDeepLink url : " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        PageJumpUtil.launchDeepLink(str);
    }

    private String replaceMacroUrl(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        AdScopeEventReportModel buildASNPRequestReportModel = AdScopeEventReport.getInstance().buildASNPRequestReportModel(null, EventReportCode.EVENT_REPORT_APP_INSTALLS_CODE.getCodeStr(), "", this.apiKey);
        buildASNPRequestReportModel.setAppInstalls(str2);
        return AdScopeModifyMacro.modifyMacroWithModel(buildASNPRequestReportModel, str);
    }

    private void reportAppLink(TaskModel taskModel) {
        ArrayList<AppInstallModel> arrayList;
        boolean z3;
        String str;
        JSONArray jSONArray;
        String str2 = AdRequestConstant.AD_REQUEST_CONTEXT_EXT_APP_INSTALL_KEY;
        try {
            ArrayList arrayList2 = new ArrayList();
            List<PkgModel> pkgs = taskModel.getPkgs();
            String macros = taskModel.getMacros();
            if (pkgs == null || pkgs.size() <= 0) {
                return;
            }
            String string = AdScopeSpUtil.getString(AdRequestConstant.AD_REQUEST_CONTEXT_EXT_APP_INSTALL_KEY + this.apiKey);
            ArrayList arrayList3 = new ArrayList();
            if (TextUtils.isEmpty(string)) {
                arrayList = null;
            } else {
                JSONArray jSONArray2 = new JSONArray(string);
                if (jSONArray2.length() > 0) {
                    int length = jSONArray2.length();
                    arrayList = new ArrayList();
                    int i4 = 0;
                    while (i4 < length) {
                        JSONObject jSONObject = jSONArray2.getJSONObject(i4);
                        AppInstallModel appInstallModel = new AppInstallModel();
                        if (!jSONObject.has(AdRequestConstant.AD_REQUEST_CONTEXT_EXT_APP_INSTALL_INSTALL_KEY) || TextUtils.isEmpty(jSONObject.optString(AdRequestConstant.AD_REQUEST_CONTEXT_EXT_APP_INSTALL_INSTALL_KEY))) {
                            jSONArray = jSONArray2;
                        } else {
                            jSONArray = jSONArray2;
                            appInstallModel.setInstall(jSONObject.optString(AdRequestConstant.AD_REQUEST_CONTEXT_EXT_APP_INSTALL_INSTALL_KEY));
                        }
                        if (jSONObject.has(AdRequestConstant.AD_REQUEST_CONTEXT_EXT_APP_INSTALL_LINK_ID_KEY) && !TextUtils.isEmpty(jSONObject.optString(AdRequestConstant.AD_REQUEST_CONTEXT_EXT_APP_INSTALL_LINK_ID_KEY))) {
                            appInstallModel.setLinkId(jSONObject.optString(AdRequestConstant.AD_REQUEST_CONTEXT_EXT_APP_INSTALL_LINK_ID_KEY));
                        }
                        if (jSONObject.has(AdRequestConstant.AD_REQUEST_CONTEXT_EXT_APP_INSTALL_UPDATE_TIME_KEY) && !TextUtils.isEmpty(jSONObject.optString(AdRequestConstant.AD_REQUEST_CONTEXT_EXT_APP_INSTALL_UPDATE_TIME_KEY))) {
                            appInstallModel.setUpdateTime(jSONObject.optString(AdRequestConstant.AD_REQUEST_CONTEXT_EXT_APP_INSTALL_UPDATE_TIME_KEY));
                        }
                        arrayList.add(appInstallModel);
                        i4++;
                        jSONArray2 = jSONArray;
                    }
                } else {
                    arrayList = null;
                }
                arrayList3.addAll(arrayList);
            }
            for (PkgModel pkgModel : pkgs) {
                if (arrayList != null && !arrayList.isEmpty()) {
                    for (AppInstallModel appInstallModel2 : arrayList) {
                        if (!TextUtils.isEmpty(appInstallModel2.getLinkId()) && !TextUtils.isEmpty(pkgModel.getLinkId()) && appInstallModel2.getLinkId().equals(pkgModel.getLinkId())) {
                            z3 = true;
                            break;
                        }
                    }
                }
                z3 = false;
                appInstallModel2 = null;
                String valueOf = SystemUtil.checkAppInstalled(this.context, pkgModel.getLink()) ? String.valueOf(1) : String.valueOf(0);
                if (z3) {
                    if (System.currentTimeMillis() - Long.parseLong(appInstallModel2.getUpdateTime()) > 604800000) {
                        StringBuilder sb = new StringBuilder();
                        str = str2;
                        sb.append(System.currentTimeMillis());
                        sb.append("");
                        appInstallModel2.setUpdateTime(sb.toString());
                        appInstallModel2.setInstall(valueOf);
                    } else {
                        str = str2;
                    }
                } else {
                    str = str2;
                    appInstallModel2 = new AppInstallModel();
                    appInstallModel2.setLinkId(pkgModel.getLinkId());
                    appInstallModel2.setInstall(valueOf);
                    appInstallModel2.setUpdateTime(System.currentTimeMillis() + "");
                    arrayList3.add(appInstallModel2);
                }
                arrayList2.add(appInstallModel2);
                str2 = str;
            }
            String str3 = str2;
            if (taskModel.getTaskReport() == 1) {
                AdScopeSpUtil.putString(str3 + this.apiKey, new JSONParse().toJson(arrayList2));
                AdRequestInfo.getInstance().setAppInstall(arrayList2);
            } else if (taskModel.getTaskReport() == 2) {
                AdScopeSpUtil.putString(str3 + this.apiKey, new JSONParse().toJson(arrayList3));
                AdRequestInfo.getInstance().setAppInstall(arrayList3);
            } else if (taskModel.getTaskReport() == 999) {
                doPostInstallsTask(taskModel.getReportUrl(), macros, string);
            }
        } catch (Throwable th) {
            String str4 = Constants.TAG;
            LogUtil.e(str4, "e : " + th);
        }
    }

    private void sendRequestUrl(TaskModel taskModel) {
        try {
            List<TaskUrlsModel> taskUrls = taskModel.getTaskUrls();
            if (taskUrls != null && !taskUrls.isEmpty()) {
                for (final TaskUrlsModel taskUrlsModel : taskUrls) {
                    final TimerOutTask timerOutTask = new TimerOutTask();
                    timerOutTask.buildReportTrackTimerTask(taskUrlsModel.getNextTime() + new Random().nextInt((int) taskUrlsModel.getRandomTime()) + 1, new ITimerTaskCallback() { // from class: xyz.adscope.ad.config.task.c
                        @Override // xyz.adscope.ad.tool.task.inter.ITimerTaskCallback
                        public final void scheduleTimeEndCall() {
                            AdScopeAppLinkTask.this.lambda$sendRequestUrl$2(taskUrlsModel, timerOutTask);
                        }
                    });
                }
            }
        } catch (Throwable th) {
            String str = Constants.TAG;
            LogUtil.i(str, "e : " + th);
        }
    }

    private void startTaskWithInfo(final TaskModel taskModel) {
        try {
            if (taskModel.getTaskType() == this.TASK_TYPE_INSTALL) {
                if (taskModel.getDelay() != 0) {
                    final TimerOutTask timerOutTask = new TimerOutTask();
                    timerOutTask.buildReportTrackTimerTask(taskModel.getDelay(), new ITimerTaskCallback() { // from class: xyz.adscope.ad.config.task.a
                        @Override // xyz.adscope.ad.tool.task.inter.ITimerTaskCallback
                        public final void scheduleTimeEndCall() {
                            AdScopeAppLinkTask.this.lambda$startTaskWithInfo$0(taskModel, timerOutTask);
                        }
                    });
                } else {
                    reportAppLink(taskModel);
                }
            } else if (taskModel.getTaskType() == this.TASK_TYPE_REQUEST_URL) {
                if (taskModel.getDelay() != 0) {
                    final TimerOutTask timerOutTask2 = new TimerOutTask();
                    timerOutTask2.buildReportTrackTimerTask(taskModel.getDelay(), new ITimerTaskCallback() { // from class: xyz.adscope.ad.config.task.b
                        @Override // xyz.adscope.ad.tool.task.inter.ITimerTaskCallback
                        public final void scheduleTimeEndCall() {
                            AdScopeAppLinkTask.this.lambda$startTaskWithInfo$1(taskModel, timerOutTask2);
                        }
                    });
                } else {
                    sendRequestUrl(taskModel);
                }
            }
        } catch (Throwable th) {
            String str = Constants.TAG;
            LogUtil.i(str, "e : " + th);
        }
    }

    private void startWebViewPage(String str) {
        String str2 = Constants.TAG;
        LogUtil.i(str2, "task_execute_asnp startWebViewPage url : " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        PageJumpUtil.startUrlPage(str);
    }

    @Override // java.lang.Runnable
    public void run() {
        List<TaskModel> list = this.taskModelList;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (TaskModel taskModel : this.taskModelList) {
            startTaskWithInfo(taskModel);
        }
    }
}

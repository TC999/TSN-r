package cn.bluemobi.dylan.http;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.http.MessageManager;
import cn.bluemobi.dylan.http.dialog.DialogOnDismissListener;
import cn.bluemobi.dylan.http.dialog.DialogOnKeyListener;
import cn.bluemobi.dylan.http.dialog.LoadingDialog;
import com.bjtsn.dylan.lifecycleobserver.LifecycleObserver;
import com.bjtsn.dylan.lifecycleobserver.b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.net.SocketTimeoutException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;
import retrofit2.Response;
import rx.android.schedulers.a;
import rx.e;
import rx.l;
import rx.m;
import rx.schedulers.c;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class HttpRequest {
    private WeakReference<Context> context;
    private String loadingMessage;
    private e<? extends Response<ResponseBody>> observable;
    private ResponseInterceptor responseInterceptor;
    private boolean isShowLoadingDialog = true;
    private LoadingDialog loadingDialog = null;
    private boolean isShowSuccessMessage = true;
    private boolean isShowOtherStatusMessage = true;
    private boolean isShowFailMessage = true;
    private boolean canCancel = true;
    private HttpJsonKey httpJsonKey = JsonParse.getJsonParse();

    public HttpRequest(Context context) {
        this.context = new WeakReference<>(context);
    }

    private void addLifeCycle(Context context, final m mVar) {
        if (context instanceof FragmentActivity) {
            new LifecycleObserver((FragmentActivity) context).c(new b() { // from class: cn.bluemobi.dylan.http.HttpRequest.3
                @Override // com.bjtsn.dylan.lifecycleobserver.b
                public void onDestroy() {
                    m mVar2 = mVar;
                    if (mVar2 != null && !mVar2.isUnsubscribed()) {
                        mVar.unsubscribe();
                    }
                    super.onDestroy();
                }
            });
        }
    }

    private String convertFileSize(long j4) {
        if (j4 >= 1073741824) {
            return String.format("%.1f GB", Float.valueOf(((float) j4) / ((float) 1073741824)));
        }
        if (j4 >= 1048576) {
            float f4 = ((float) j4) / ((float) 1048576);
            return String.format(f4 > 100.0f ? "%.0f MB" : "%.1f MB", Float.valueOf(f4));
        } else if (j4 >= 1024) {
            float f5 = ((float) j4) / ((float) 1024);
            return String.format(f5 > 100.0f ? "%.0f KB" : "%.1f KB", Float.valueOf(f5));
        } else {
            return String.format("%d B", Long.valueOf(j4));
        }
    }

    private String getPartHeaders(MultipartBody.Part part) {
        Field field;
        try {
            field = part.getClass().getDeclaredField("headers");
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
            field = null;
        }
        field.setAccessible(true);
        try {
            return ((Headers) field.get(part)).get("content-disposition").split(";")[1].split("=")[1].replace("\"", "");
        } catch (IllegalAccessException e5) {
            e5.printStackTrace();
            return "";
        } catch (Exception e6) {
            e6.printStackTrace();
            return "";
        }
    }

    private String getRequestBody(MultipartBody.Part part) {
        Field field;
        try {
            field = part.getClass().getDeclaredField("body");
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
            field = null;
        }
        field.setAccessible(true);
        try {
            RequestBody requestBody = (RequestBody) field.get(part);
            MediaType contentType = requestBody.contentType();
            if (!contentType.type().equals("multipart")) {
                return contentType.type().equals("image") ? convertFileSize(requestBody.contentLength()) : "";
            }
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);
            return buffer.readString(contentType.charset(Charset.forName("UTF-8")));
        } catch (IOException e5) {
            e5.printStackTrace();
            return "";
        } catch (IllegalAccessException e6) {
            e6.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> getRequestParement(Request request) {
        ArrayMap arrayMap = new ArrayMap();
        if (request.body() instanceof FormBody) {
            FormBody formBody = (FormBody) request.body();
            for (int i4 = 0; i4 < formBody.size(); i4++) {
                arrayMap.put(formBody.name(i4), formBody.value(i4));
            }
        } else if (request.body() instanceof MultipartBody) {
            for (MultipartBody.Part part : ((MultipartBody) request.body()).parts()) {
                String partHeaders = getPartHeaders(part);
                String str = null;
                try {
                    str = URLDecoder.decode(getRequestBody(part).replaceAll("%(?![0-9a-fA-F]{2})", "%25"), "UTF-8");
                } catch (UnsupportedEncodingException e4) {
                    e4.printStackTrace();
                }
                arrayMap.put(partHeaders, str);
            }
        }
        return arrayMap;
    }

    public LoadingDialog getLoadingDialog() {
        return this.loadingDialog;
    }

    public HttpRequest hideFailMessage() {
        this.isShowFailMessage = false;
        return this;
    }

    public HttpRequest hideLoadingDialog() {
        this.isShowLoadingDialog = false;
        return this;
    }

    public HttpRequest hideOtherStatusMessage() {
        this.isShowOtherStatusMessage = false;
        return this;
    }

    public HttpRequest hideSuccessMessage() {
        this.isShowSuccessMessage = false;
        return this;
    }

    public HttpRequest setCanCancel(boolean z3) {
        this.canCancel = z3;
        return this;
    }

    public m setDataListener(final HttpCallBack httpCallBack) {
        final Context context = this.context.get();
        if ((context instanceof Activity) && ((Activity) context).isDestroyed()) {
            return null;
        }
        String str = MessageManager.getMessageManager().isUseEnglishLanguage() ? "Network  unusual" : "\u7f51\u7edc\u4e0d\u53ef\u7528";
        if (!NetworkUtil.isNetworkAvailable(context)) {
            Toast.makeText(context, str, 0).show();
            if (httpCallBack != null) {
                httpCallBack.netOnFailure(new Exception(str));
                httpCallBack.netOnFinish();
            }
            return null;
        }
        if (this.isShowLoadingDialog) {
            if (this.loadingDialog == null) {
                this.loadingDialog = new LoadingDialog(context);
            }
        } else {
            this.loadingDialog = null;
        }
        m q5 = this.observable.v5(c.e()).H3(a.b()).q5(new l<Response<ResponseBody>>() { // from class: cn.bluemobi.dylan.http.HttpRequest.1
            private void showErrorMessage(String str2, Exception exc) {
                if (HttpRequest.this.responseInterceptor != null) {
                    HttpRequest.this.responseInterceptor.onError(context, exc);
                }
                if (MessageManager.getMessageManager().getShowMessageModel() != MessageManager.MessageModel.NO && HttpRequest.this.isShowFailMessage) {
                    Toast.makeText(context, str2, 0).show();
                }
                HttpCallBack httpCallBack2 = httpCallBack;
                if (httpCallBack2 != null) {
                    httpCallBack2.netOnFailure(exc);
                }
                if (Http.getHttp().isDebugMode()) {
                    exc.printStackTrace();
                }
            }

            @Override // rx.f
            public void onCompleted() {
                if (HttpRequest.this.loadingDialog != null) {
                    HttpRequest.this.loadingDialog.dismiss();
                }
                HttpCallBack httpCallBack2 = httpCallBack;
                if (httpCallBack2 != null) {
                    httpCallBack2.netOnFinish();
                }
            }

            @Override // rx.f
            public void onError(Throwable th) {
                if (Http.getHttp().isDebugMode()) {
                    th.printStackTrace();
                }
                if (HttpRequest.this.responseInterceptor != null) {
                    HttpRequest.this.responseInterceptor.onError(context, th);
                }
                if (HttpRequest.this.isShowFailMessage) {
                    if (th instanceof SocketTimeoutException) {
                        Toast.makeText(context, "\u7f51\u7edc\u8fde\u63a5\u8d85\u65f6,\u8bf7\u91cd\u65b0\u518d\u8bd5", 0).show();
                    } else {
                        Toast.makeText(context, "\u7f51\u7edc\u8fde\u63a5\u9519\u8bef,\u9519\u8bef\u7801\uff1a-2", 0).show();
                    }
                }
                HttpCallBack httpCallBack2 = httpCallBack;
                if (httpCallBack2 != null) {
                    httpCallBack2.netOnFailure(th);
                }
                onCompleted();
            }

            @Override // rx.l
            public void onStart() {
                if (HttpRequest.this.loadingDialog != null) {
                    HttpRequest.this.loadingDialog.show(HttpRequest.this.loadingMessage);
                }
                HttpCallBack httpCallBack2 = httpCallBack;
                if (httpCallBack2 != null) {
                    httpCallBack2.netOnStart();
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
            /* JADX WARN: Removed duplicated region for block: B:58:0x0182  */
            /* JADX WARN: Removed duplicated region for block: B:71:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // rx.f
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onNext(retrofit2.Response<okhttp3.ResponseBody> r12) {
                /*
                    Method dump skipped, instructions count: 453
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.bluemobi.dylan.http.HttpRequest.AnonymousClass1.onNext(retrofit2.Response):void");
            }
        });
        if (q5 != null) {
            LoadingDialog loadingDialog = this.loadingDialog;
            if (loadingDialog != null) {
                loadingDialog.setOnKeyListener(new DialogOnKeyListener(loadingDialog, this.canCancel));
                this.loadingDialog.setOnDismissListener(new DialogOnDismissListener(q5));
            } else {
                addLifeCycle(context, q5);
            }
        }
        return q5;
    }

    public HttpRequest setHttpJsonKey(HttpJsonKey httpJsonKey) {
        this.httpJsonKey = httpJsonKey;
        return this;
    }

    public HttpRequest setLoadingMessage(String str) {
        this.loadingMessage = str;
        return this;
    }

    public HttpRequest setObservable(e<? extends Response<ResponseBody>> eVar) {
        this.observable = eVar;
        return this;
    }

    public HttpRequest setResponseInterceptor(ResponseInterceptor responseInterceptor) {
        this.responseInterceptor = responseInterceptor;
        return this;
    }

    public HttpRequest setShowLoadingDialog(boolean z3) {
        this.isShowLoadingDialog = z3;
        return this;
    }

    public HttpRequest setTimeout(long j4, TimeUnit timeUnit) {
        RetrofitManager.getRetrofitManager().setTimeout(j4, timeUnit);
        return this;
    }

    public m setDataListener(final OriginalHttpResponse originalHttpResponse) {
        String str = MessageManager.getMessageManager().isUseEnglishLanguage() ? "Network  unusual" : "\u7f51\u7edc\u4e0d\u53ef\u7528";
        final String errorMessage = MessageManager.getMessageManager().isUseEnglishLanguage() ? "Network  error" : MessageManager.getMessageManager().getErrorMessage();
        if (!NetworkUtil.isNetworkAvailable(this.context.get())) {
            Toast.makeText(this.context.get(), str, 0).show();
            if (originalHttpResponse != null) {
                originalHttpResponse.netOnFailure(new Exception(str));
                originalHttpResponse.netOnFinish();
            }
            return null;
        }
        if (this.isShowLoadingDialog) {
            if (this.loadingDialog == null) {
                this.loadingDialog = new LoadingDialog(this.context.get());
            }
        } else {
            this.loadingDialog = null;
        }
        m q5 = this.observable.v5(c.e()).H3(a.b()).q5(new l<Response<ResponseBody>>() { // from class: cn.bluemobi.dylan.http.HttpRequest.2
            @Override // rx.f
            public void onCompleted() {
                if (HttpRequest.this.loadingDialog != null) {
                    HttpRequest.this.loadingDialog.dismiss();
                }
                OriginalHttpResponse originalHttpResponse2 = originalHttpResponse;
                if (originalHttpResponse2 != null) {
                    originalHttpResponse2.netOnFinish();
                }
            }

            @Override // rx.f
            public void onError(Throwable th) {
                if (Http.getHttp().isDebugMode()) {
                    th.printStackTrace();
                }
                if (HttpRequest.this.isShowFailMessage) {
                    Toast.makeText((Context) HttpRequest.this.context.get(), errorMessage, 0).show();
                }
                OriginalHttpResponse originalHttpResponse2 = originalHttpResponse;
                if (originalHttpResponse2 != null) {
                    originalHttpResponse2.netOnFailure(th);
                }
                onCompleted();
            }

            @Override // rx.l
            public void onStart() {
                if (HttpRequest.this.loadingDialog != null) {
                    HttpRequest.this.loadingDialog.show(HttpRequest.this.loadingMessage);
                }
                OriginalHttpResponse originalHttpResponse2 = originalHttpResponse;
                if (originalHttpResponse2 != null) {
                    originalHttpResponse2.netOnStart();
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0084 A[Catch: Exception -> 0x0088, TRY_LEAVE, TryCatch #1 {Exception -> 0x0088, blocks: (B:18:0x0080, B:20:0x0084), top: B:37:0x0080 }] */
            /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r1v1 */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v7, types: [cn.bluemobi.dylan.http.ResponseInterceptor] */
            @Override // rx.f
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onNext(retrofit2.Response<okhttp3.ResponseBody> r8) {
                /*
                    r7 = this;
                    cn.bluemobi.dylan.http.HttpRequest r0 = cn.bluemobi.dylan.http.HttpRequest.this
                    cn.bluemobi.dylan.http.dialog.LoadingDialog r0 = cn.bluemobi.dylan.http.HttpRequest.access$000(r0)
                    if (r0 == 0) goto L11
                    cn.bluemobi.dylan.http.HttpRequest r0 = cn.bluemobi.dylan.http.HttpRequest.this
                    cn.bluemobi.dylan.http.dialog.LoadingDialog r0 = cn.bluemobi.dylan.http.HttpRequest.access$000(r0)
                    r0.dismiss()
                L11:
                    boolean r0 = r8.isSuccessful()
                    java.lang.String r1 = ""
                    if (r0 != 0) goto L22
                    okhttp3.ResponseBody r0 = r8.errorBody()     // Catch: java.io.IOException -> L7b
                    java.lang.String r0 = r0.string()     // Catch: java.io.IOException -> L7b
                    goto L2c
                L22:
                    java.lang.Object r0 = r8.body()     // Catch: java.io.IOException -> L7b
                    okhttp3.ResponseBody r0 = (okhttp3.ResponseBody) r0     // Catch: java.io.IOException -> L7b
                    java.lang.String r0 = r0.string()     // Catch: java.io.IOException -> L7b
                L2c:
                    cn.bluemobi.dylan.http.HttpRequest r1 = cn.bluemobi.dylan.http.HttpRequest.this     // Catch: java.io.IOException -> L78
                    cn.bluemobi.dylan.http.ResponseInterceptor r1 = cn.bluemobi.dylan.http.HttpRequest.access$200(r1)     // Catch: java.io.IOException -> L78
                    if (r1 == 0) goto L80
                    cn.bluemobi.dylan.http.HttpRequest r1 = cn.bluemobi.dylan.http.HttpRequest.this     // Catch: java.io.IOException -> L78
                    okhttp3.Response r2 = r8.raw()     // Catch: java.io.IOException -> L78
                    okhttp3.Request r2 = r2.request()     // Catch: java.io.IOException -> L78
                    java.util.Map r4 = cn.bluemobi.dylan.http.HttpRequest.access$400(r1, r2)     // Catch: java.io.IOException -> L78
                    cn.bluemobi.dylan.http.HttpRequest r1 = cn.bluemobi.dylan.http.HttpRequest.this     // Catch: java.io.IOException -> L78
                    cn.bluemobi.dylan.http.ResponseInterceptor r1 = cn.bluemobi.dylan.http.HttpRequest.access$200(r1)     // Catch: java.io.IOException -> L78
                    cn.bluemobi.dylan.http.HttpRequest r2 = cn.bluemobi.dylan.http.HttpRequest.this     // Catch: java.io.IOException -> L78
                    java.lang.ref.WeakReference r2 = cn.bluemobi.dylan.http.HttpRequest.access$800(r2)     // Catch: java.io.IOException -> L78
                    java.lang.Object r2 = r2.get()     // Catch: java.io.IOException -> L78
                    android.content.Context r2 = (android.content.Context) r2     // Catch: java.io.IOException -> L78
                    okhttp3.Response r3 = r8.raw()     // Catch: java.io.IOException -> L78
                    okhttp3.Request r3 = r3.request()     // Catch: java.io.IOException -> L78
                    okhttp3.HttpUrl r3 = r3.url()     // Catch: java.io.IOException -> L78
                    java.net.URL r3 = r3.url()     // Catch: java.io.IOException -> L78
                    java.lang.String r3 = r3.toString()     // Catch: java.io.IOException -> L78
                    okhttp3.Response r8 = r8.raw()     // Catch: java.io.IOException -> L78
                    int r6 = r8.code()     // Catch: java.io.IOException -> L78
                    r5 = r0
                    boolean r8 = r1.onResponseStart(r2, r3, r4, r5, r6)     // Catch: java.io.IOException -> L78
                    if (r8 == 0) goto L80
                    return
                L78:
                    r8 = move-exception
                    r1 = r0
                    goto L7c
                L7b:
                    r8 = move-exception
                L7c:
                    r8.printStackTrace()
                    r0 = r1
                L80:
                    cn.bluemobi.dylan.http.OriginalHttpResponse r8 = r2     // Catch: java.lang.Exception -> L88
                    if (r8 == 0) goto Lc7
                    r8.netOnSuccess(r0)     // Catch: java.lang.Exception -> L88
                    goto Lc7
                L88:
                    r8 = move-exception
                    cn.bluemobi.dylan.http.MessageManager r0 = cn.bluemobi.dylan.http.MessageManager.getMessageManager()
                    cn.bluemobi.dylan.http.MessageManager$MessageModel r0 = r0.getShowMessageModel()
                    cn.bluemobi.dylan.http.MessageManager$MessageModel r1 = cn.bluemobi.dylan.http.MessageManager.MessageModel.NO
                    if (r0 == r1) goto Lb3
                    cn.bluemobi.dylan.http.HttpRequest r0 = cn.bluemobi.dylan.http.HttpRequest.this
                    boolean r0 = cn.bluemobi.dylan.http.HttpRequest.access$300(r0)
                    if (r0 == 0) goto Lb3
                    cn.bluemobi.dylan.http.HttpRequest r0 = cn.bluemobi.dylan.http.HttpRequest.this
                    java.lang.ref.WeakReference r0 = cn.bluemobi.dylan.http.HttpRequest.access$800(r0)
                    java.lang.Object r0 = r0.get()
                    android.content.Context r0 = (android.content.Context) r0
                    java.lang.String r1 = r3
                    r2 = 0
                    android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r2)
                    r0.show()
                Lb3:
                    cn.bluemobi.dylan.http.OriginalHttpResponse r0 = r2
                    if (r0 == 0) goto Lba
                    r0.netOnFailure(r8)
                Lba:
                    cn.bluemobi.dylan.http.Http r0 = cn.bluemobi.dylan.http.Http.getHttp()
                    boolean r0 = r0.isDebugMode()
                    if (r0 == 0) goto Lc7
                    r8.printStackTrace()
                Lc7:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.bluemobi.dylan.http.HttpRequest.AnonymousClass2.onNext(retrofit2.Response):void");
            }
        });
        if (q5 != null) {
            LoadingDialog loadingDialog = this.loadingDialog;
            if (loadingDialog != null) {
                loadingDialog.setOnKeyListener(new DialogOnKeyListener(loadingDialog, this.canCancel));
                this.loadingDialog.setOnDismissListener(new DialogOnDismissListener(q5));
            } else {
                addLifeCycle(this.context.get(), q5);
            }
        }
        return q5;
    }
}

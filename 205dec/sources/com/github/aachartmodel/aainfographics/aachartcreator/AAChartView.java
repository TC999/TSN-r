package com.github.aachartmodel.aainfographics.aachartcreator;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartView;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAChart;
import com.github.aachartmodel.aainfographics.aatools.AAJSStringPurer;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.f0;
import kotlin.text.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AAChartView.kt */
@Metadata(bv = {}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0004\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001UB\u0011\b\u0016\u0012\u0006\u0010M\u001a\u00020L\u00a2\u0006\u0004\bN\u0010OB\u001b\b\u0016\u0012\u0006\u0010M\u001a\u00020L\u0012\b\u0010Q\u001a\u0004\u0018\u00010P\u00a2\u0006\u0004\bN\u0010RB#\b\u0016\u0012\u0006\u0010M\u001a\u00020L\u0012\b\u0010Q\u001a\u0004\u0018\u00010P\u0012\u0006\u0010S\u001a\u00020%\u00a2\u0006\u0004\bN\u0010TJ\b\u0010\u0003\u001a\u00020\u0002H\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u001c\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\u0012\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0007J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004J\u001b\u0010\u001d\u001a\u00020\u00022\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u00a2\u0006\u0004\b\u001d\u0010\u001eJ#\u0010\u001d\u001a\u00020\u00022\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b\u001d\u0010!J\u0016\u0010$\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u001fJ\"\u0010(\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%2\u0006\u0010\"\u001a\u00020\f2\b\b\u0002\u0010'\u001a\u00020\u001fH\u0007J.\u0010(\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010)\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%J\u000e\u0010*\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%J\u000e\u0010,\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u001bJ\u000e\u0010-\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%J\u000e\u0010/\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u000bR.\u00102\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u0001008\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R.\u00108\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u0001008\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00103\u001a\u0004\b9\u00105\"\u0004\b:\u00107R.\u0010;\u001a\u0004\u0018\u00010\u001f2\b\u00101\u001a\u0004\u0018\u00010\u001f8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R.\u0010A\u001a\u0004\u0018\u00010\u001f2\b\u00101\u001a\u0004\u0018\u00010\u001f8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010<\u001a\u0004\bA\u0010>\"\u0004\bB\u0010@R$\u0010D\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0018\u0010J\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010K\u00a8\u0006V"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartView;", "Landroid/webkit/WebView;", "Lkotlin/f1;", "setupBasicContent", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAOptions;", "aaOptions", "loadLocalFilesAndDrawChart", "chartOptions", "configureChartOptionsAndDrawChart", "showJavaScriptAlertView", "", "", "", "messageBody", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAMoveOverEventMessageModel;", "getEventMessageModel", "javaScriptString", "safeEvaluateJavaScriptString", "message", "androidMethod", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "chartModel", "aa_drawChartWithChartModel", "aa_refreshChartWithChartModel", "aa_drawChartWithChartOptions", "aa_refreshChartWithChartOptions", "", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;", "seriesElementsArr", "aa_onlyRefreshTheChartDataWithChartOptionsSeriesArray", "([Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;)V", "", "animation", "([Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;Z)V", "options", "redraw", "aa_updateChartWithOptions", "", "elementIndex", "shift", "aa_addPointToChartSeriesElement", "aa_showTheSeriesElementContent", "aa_hideTheSeriesElementContent", "aaSeriesElement", "aa_addElementToChartSeries", "aa_removeElementFromChartSeries", "jsFunctionStr", "aa_evaluateTheJavaScriptStringFunction", "", "value", "contentWidth", "Ljava/lang/Number;", "getContentWidth", "()Ljava/lang/Number;", "setContentWidth", "(Ljava/lang/Number;)V", "contentHeight", "getContentHeight", "setContentHeight", "chartSeriesHidden", "Ljava/lang/Boolean;", "getChartSeriesHidden", "()Ljava/lang/Boolean;", "setChartSeriesHidden", "(Ljava/lang/Boolean;)V", "isClearBackgroundColor", "setClearBackgroundColor", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartView$AAChartViewCallBack;", "callBack", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartView$AAChartViewCallBack;", "getCallBack", "()Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartView$AAChartViewCallBack;", "setCallBack", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartView$AAChartViewCallBack;)V", "optionsJson", "Ljava/lang/String;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "AAChartViewCallBack", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class AAChartView extends WebView {
    private HashMap _$_findViewCache;
    @Nullable
    private AAChartViewCallBack callBack;
    @Nullable
    private Boolean chartSeriesHidden;
    @Nullable
    private Number contentHeight;
    @Nullable
    private Number contentWidth;
    @Nullable
    private Boolean isClearBackgroundColor;
    private String optionsJson;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: AAChartView.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartView$AAChartViewCallBack;", "", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartView;", "aaChartView", "Lkotlin/f1;", "chartViewDidFinishLoad", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAMoveOverEventMessageModel;", "messageModel", "chartViewMoveOverEventMessage", "charts_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public interface AAChartViewCallBack {
        void chartViewDidFinishLoad(@NotNull AAChartView aAChartView);

        void chartViewMoveOverEventMessage(@NotNull AAChartView aAChartView, @NotNull AAMoveOverEventMessageModel aAMoveOverEventMessageModel);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AAChartView(@NotNull Context context) {
        super(context);
        f0.p(context, "context");
        setupBasicContent();
    }

    public static /* synthetic */ void aa_addPointToChartSeriesElement$default(AAChartView aAChartView, int i4, Object obj, boolean z3, int i5, Object obj2) {
        if ((i5 & 4) != 0) {
            z3 = true;
        }
        aAChartView.aa_addPointToChartSeriesElement(i4, obj, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void configureChartOptionsAndDrawChart(AAOptions aAOptions) {
        Boolean bool = this.isClearBackgroundColor;
        f0.m(bool);
        if (bool.booleanValue()) {
            AAChart chart = aAOptions.getChart();
            f0.m(chart);
            chart.backgroundColor("rgba(0,0,0,0)");
        }
        String json = new Gson().toJson(aAOptions);
        this.optionsJson = json;
        safeEvaluateJavaScriptString("loadTheHighChartView('" + json + "','" + this.contentWidth + "','" + this.contentHeight + "')");
    }

    private final AAMoveOverEventMessageModel getEventMessageModel(Map<String, ? extends Object> map) {
        AAMoveOverEventMessageModel aAMoveOverEventMessageModel = new AAMoveOverEventMessageModel();
        aAMoveOverEventMessageModel.setName(String.valueOf(map.get("name")));
        aAMoveOverEventMessageModel.setX((Double) map.get("x"));
        aAMoveOverEventMessageModel.setY((Double) map.get("y"));
        aAMoveOverEventMessageModel.setCategory(String.valueOf(map.get("category")));
        aAMoveOverEventMessageModel.setOffset((LinkedTreeMap) map.get("offset"));
        Double d4 = (Double) map.get("index");
        aAMoveOverEventMessageModel.setIndex(d4 != null ? Integer.valueOf((int) d4.doubleValue()) : null);
        return aAMoveOverEventMessageModel;
    }

    private final void loadLocalFilesAndDrawChart(final AAOptions aAOptions) {
        loadUrl("file:///android_asset/AAChartView.html");
        setWebViewClient(new WebViewClient() { // from class: com.github.aachartmodel.aainfographics.aachartcreator.AAChartView$loadLocalFilesAndDrawChart$1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(@NotNull WebView view, @NotNull String url) {
                f0.p(view, "view");
                f0.p(url, "url");
                AAChartView.this.configureChartOptionsAndDrawChart(aAOptions);
                AAChartView.AAChartViewCallBack callBack = AAChartView.this.getCallBack();
                if (callBack != null) {
                    callBack.chartViewDidFinishLoad(AAChartView.this);
                }
            }
        });
    }

    private final void safeEvaluateJavaScriptString(String str) {
        if (isInEditMode()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            evaluateJavascript("javascript:" + str, new ValueCallback<String>() { // from class: com.github.aachartmodel.aainfographics.aachartcreator.AAChartView$safeEvaluateJavaScriptString$1
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(String str2) {
                }
            });
            return;
        }
        loadUrl("javascript:" + str);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private final void setupBasicContent() {
        if (isInEditMode()) {
            return;
        }
        setContentWidth(Float.valueOf(420.0f));
        setContentHeight(Float.valueOf(580.0f));
        setClearBackgroundColor(Boolean.FALSE);
        WebSettings settings = getSettings();
        f0.o(settings, "settings");
        settings.setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        addJavascriptInterface(this, "androidObject");
    }

    private final void showJavaScriptAlertView() {
        setWebChromeClient(new WebChromeClient() { // from class: com.github.aachartmodel.aainfographics.aachartcreator.AAChartView$showJavaScriptAlertView$1
            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(@NotNull WebView view, @NotNull String url, @NotNull String message, @NotNull JsResult result) {
                f0.p(view, "view");
                f0.p(url, "url");
                f0.p(message, "message");
                f0.p(result, "result");
                super.onJsAlert(view, url, message, result);
                new AlertDialog.Builder(AAChartView.this.getContext()).setTitle("JavaScript alert Information").setMessage(("url --->" + url + "\n\n\n") + ("message --->" + message + "\n\n\n") + ("result --->" + result)).setNeutralButton("sure", (DialogInterface.OnClickListener) null).show();
                return true;
            }
        });
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i4) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i4));
        if (view == null) {
            View findViewById = findViewById(i4);
            this._$_findViewCache.put(Integer.valueOf(i4), findViewById);
            return findViewById;
        }
        return view;
    }

    public final void aa_addElementToChartSeries(@NotNull AASeriesElement aaSeriesElement) {
        f0.p(aaSeriesElement, "aaSeriesElement");
        String json = new Gson().toJson(aaSeriesElement);
        safeEvaluateJavaScriptString("addElementToChartSeriesWithElement('" + json + "')");
    }

    @JvmOverloads
    public final void aa_addPointToChartSeriesElement(int i4, @NotNull Object obj) {
        aa_addPointToChartSeriesElement$default(this, i4, obj, false, 4, null);
    }

    @JvmOverloads
    public final void aa_addPointToChartSeriesElement(int i4, @NotNull Object options, boolean z3) {
        f0.p(options, "options");
        aa_addPointToChartSeriesElement(i4, options, true, z3, true);
    }

    public final void aa_drawChartWithChartModel(@NotNull AAChartModel chartModel) {
        f0.p(chartModel, "chartModel");
        aa_drawChartWithChartOptions(AAChartModelKt.aa_toAAOptions(chartModel));
    }

    public final void aa_drawChartWithChartOptions(@NotNull AAOptions chartOptions) {
        f0.p(chartOptions, "chartOptions");
        if (this.optionsJson != null) {
            aa_refreshChartWithChartOptions(chartOptions);
            return;
        }
        loadLocalFilesAndDrawChart(chartOptions);
        showJavaScriptAlertView();
    }

    public final void aa_evaluateTheJavaScriptStringFunction(@NotNull String jsFunctionStr) {
        f0.p(jsFunctionStr, "jsFunctionStr");
        String pureJavaScriptFunctionString = AAJSStringPurer.INSTANCE.pureJavaScriptFunctionString(jsFunctionStr);
        safeEvaluateJavaScriptString("evaluateTheJavaScriptStringFunction('" + pureJavaScriptFunctionString + "')");
    }

    public final void aa_hideTheSeriesElementContent(int i4) {
        safeEvaluateJavaScriptString("hideTheSeriesElementContentWithIndex('" + i4 + "')");
    }

    public final void aa_onlyRefreshTheChartDataWithChartOptionsSeriesArray(@NotNull AASeriesElement[] seriesElementsArr) {
        f0.p(seriesElementsArr, "seriesElementsArr");
        aa_onlyRefreshTheChartDataWithChartOptionsSeriesArray(seriesElementsArr, true);
    }

    public final void aa_refreshChartWithChartModel(@NotNull AAChartModel chartModel) {
        f0.p(chartModel, "chartModel");
        aa_refreshChartWithChartOptions(AAChartModelKt.aa_toAAOptions(chartModel));
    }

    public final void aa_refreshChartWithChartOptions(@NotNull AAOptions chartOptions) {
        f0.p(chartOptions, "chartOptions");
        configureChartOptionsAndDrawChart(chartOptions);
    }

    public final void aa_removeElementFromChartSeries(int i4) {
        safeEvaluateJavaScriptString("removeElementFromChartSeriesWithElementIndex('" + i4 + "')");
    }

    public final void aa_showTheSeriesElementContent(int i4) {
        safeEvaluateJavaScriptString("showTheSeriesElementContentWithIndex('" + i4 + "')");
    }

    public final void aa_updateChartWithOptions(@NotNull Object options, boolean z3) {
        String k22;
        String optionsStr;
        f0.p(options, "options");
        if (options instanceof AAOptions) {
            optionsStr = new Gson().toJson(options);
            f0.o(optionsStr, "aaOptionsMapStr");
        } else {
            String classNameStr = options.getClass().getSimpleName();
            f0.o(classNameStr, "classNameStr");
            k22 = w.k2(classNameStr, "AA", "", false, 4, null);
            if (k22 != null) {
                String substring = k22.substring(0, 1);
                f0.o(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                Locale locale = Locale.ROOT;
                f0.o(locale, "Locale.ROOT");
                if (substring != null) {
                    String lowerCase = substring.toLowerCase(locale);
                    f0.o(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    String substring2 = k22.substring(1);
                    f0.o(substring2, "(this as java.lang.String).substring(startIndex)");
                    String str = lowerCase + substring2;
                    HashMap hashMap = new HashMap();
                    hashMap.put(str, options);
                    optionsStr = new Gson().toJson(hashMap);
                    f0.o(optionsStr, "optionsStr");
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
        safeEvaluateJavaScriptString("updateChart('" + optionsStr + "','" + z3 + "')");
    }

    @JavascriptInterface
    @NotNull
    public final String androidMethod(@Nullable String str) {
        Object fromJson = new Gson().fromJson(str, (Class<Object>) new HashMap().getClass());
        f0.o(fromJson, "Gson().fromJson(message, messageBody.javaClass)");
        AAMoveOverEventMessageModel eventMessageModel = getEventMessageModel((HashMap) fromJson);
        AAChartViewCallBack aAChartViewCallBack = this.callBack;
        if (aAChartViewCallBack != null) {
            aAChartViewCallBack.chartViewMoveOverEventMessage(this, eventMessageModel);
            return "";
        }
        return "";
    }

    @Nullable
    public final AAChartViewCallBack getCallBack() {
        return this.callBack;
    }

    @Nullable
    public final Boolean getChartSeriesHidden() {
        return this.chartSeriesHidden;
    }

    @Override // android.webkit.WebView
    @Nullable
    public final Number getContentHeight() {
        return this.contentHeight;
    }

    @Nullable
    public final Number getContentWidth() {
        return this.contentWidth;
    }

    @Nullable
    public final Boolean isClearBackgroundColor() {
        return this.isClearBackgroundColor;
    }

    public final void setCallBack(@Nullable AAChartViewCallBack aAChartViewCallBack) {
        this.callBack = aAChartViewCallBack;
    }

    public final void setChartSeriesHidden(@Nullable Boolean bool) {
        this.chartSeriesHidden = bool;
        safeEvaluateJavaScriptString("setChartSeriesHidden('" + this.chartSeriesHidden + "')");
    }

    public final void setClearBackgroundColor(@Nullable Boolean bool) {
        this.isClearBackgroundColor = bool;
        if (f0.g(bool, Boolean.TRUE)) {
            setBackgroundColor(0);
            Drawable background = getBackground();
            if (background != null) {
                background.setAlpha(0);
                return;
            }
            return;
        }
        setBackgroundColor(1);
        Drawable background2 = getBackground();
        if (background2 != null) {
            background2.setAlpha(255);
        }
    }

    public final void setContentHeight(@Nullable Number number) {
        this.contentHeight = number;
        safeEvaluateJavaScriptString("setTheChartViewContentHeight('" + this.contentHeight + "')");
    }

    public final void setContentWidth(@Nullable Number number) {
        this.contentWidth = number;
        safeEvaluateJavaScriptString("setTheChartViewContentWidth('" + this.contentWidth + "')");
    }

    public final void aa_addPointToChartSeriesElement(int i4, @NotNull Object options, boolean z3, boolean z4, boolean z5) {
        String obj;
        f0.p(options, "options");
        if (!(options instanceof Integer) && !(options instanceof Float) && !(options instanceof Double)) {
            obj = new Gson().toJson(options);
            f0.o(obj, "Gson().toJson(options)");
        } else {
            obj = options.toString();
        }
        safeEvaluateJavaScriptString("addPointToChartSeries('" + i4 + "','" + obj + "','" + z3 + "','" + z4 + "','" + z5 + "')");
    }

    public final void aa_onlyRefreshTheChartDataWithChartOptionsSeriesArray(@NotNull AASeriesElement[] seriesElementsArr, boolean z3) {
        f0.p(seriesElementsArr, "seriesElementsArr");
        String json = new Gson().toJson(seriesElementsArr);
        safeEvaluateJavaScriptString("onlyRefreshTheChartDataWithSeries('" + json + "','" + z3 + "')");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AAChartView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        f0.p(context, "context");
        setupBasicContent();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AAChartView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        f0.p(context, "context");
        setupBasicContent();
    }
}

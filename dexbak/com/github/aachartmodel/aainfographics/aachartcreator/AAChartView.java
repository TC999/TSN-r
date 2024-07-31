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
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.C14342f0;
import kotlin.text.StringsJVM;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: AAChartView.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0004\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001UB\u0011\b\u0016\u0012\u0006\u0010M\u001a\u00020L¢\u0006\u0004\bN\u0010OB\u001b\b\u0016\u0012\u0006\u0010M\u001a\u00020L\u0012\b\u0010Q\u001a\u0004\u0018\u00010P¢\u0006\u0004\bN\u0010RB#\b\u0016\u0012\u0006\u0010M\u001a\u00020L\u0012\b\u0010Q\u001a\u0004\u0018\u00010P\u0012\u0006\u0010S\u001a\u00020%¢\u0006\u0004\bN\u0010TJ\b\u0010\u0003\u001a\u00020\u0002H\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u001c\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\u0012\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0007J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004J\u001b\u0010\u001d\u001a\u00020\u00022\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010\u001d\u001a\u00020\u00022\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b\u001d\u0010!J\u0016\u0010$\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u001fJ\"\u0010(\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%2\u0006\u0010\"\u001a\u00020\f2\b\b\u0002\u0010'\u001a\u00020\u001fH\u0007J.\u0010(\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010)\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%J\u000e\u0010*\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%J\u000e\u0010,\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u001bJ\u000e\u0010-\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%J\u000e\u0010/\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u000bR.\u00102\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u0001008\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R.\u00108\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u0001008\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00103\u001a\u0004\b9\u00105\"\u0004\b:\u00107R.\u0010;\u001a\u0004\u0018\u00010\u001f2\b\u00101\u001a\u0004\u0018\u00010\u001f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R.\u0010A\u001a\u0004\u0018\u00010\u001f2\b\u00101\u001a\u0004\u0018\u00010\u001f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010<\u001a\u0004\bA\u0010>\"\u0004\bB\u0010@R$\u0010D\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0018\u0010J\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010K¨\u0006V"}, m12616d2 = {"Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartView;", "Landroid/webkit/WebView;", "Lkotlin/f1;", "setupBasicContent", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAOptions;", "aaOptions", "loadLocalFilesAndDrawChart", "chartOptions", "configureChartOptionsAndDrawChart", "showJavaScriptAlertView", "", "", "", "messageBody", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAMoveOverEventMessageModel;", "getEventMessageModel", "javaScriptString", "safeEvaluateJavaScriptString", "message", "androidMethod", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "chartModel", "aa_drawChartWithChartModel", "aa_refreshChartWithChartModel", "aa_drawChartWithChartOptions", "aa_refreshChartWithChartOptions", "", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;", "seriesElementsArr", "aa_onlyRefreshTheChartDataWithChartOptionsSeriesArray", "([Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;)V", "", "animation", "([Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;Z)V", "options", "redraw", "aa_updateChartWithOptions", "", "elementIndex", "shift", "aa_addPointToChartSeriesElement", "aa_showTheSeriesElementContent", "aa_hideTheSeriesElementContent", "aaSeriesElement", "aa_addElementToChartSeries", "aa_removeElementFromChartSeries", "jsFunctionStr", "aa_evaluateTheJavaScriptStringFunction", "", DomainCampaignEx.LOOPBACK_VALUE, "contentWidth", "Ljava/lang/Number;", "getContentWidth", "()Ljava/lang/Number;", "setContentWidth", "(Ljava/lang/Number;)V", "contentHeight", "getContentHeight", "setContentHeight", "chartSeriesHidden", "Ljava/lang/Boolean;", "getChartSeriesHidden", "()Ljava/lang/Boolean;", "setChartSeriesHidden", "(Ljava/lang/Boolean;)V", "isClearBackgroundColor", "setClearBackgroundColor", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartView$AAChartViewCallBack;", "callBack", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartView$AAChartViewCallBack;", "getCallBack", "()Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartView$AAChartViewCallBack;", "setCallBack", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartView$AAChartViewCallBack;)V", "optionsJson", "Ljava/lang/String;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "AAChartViewCallBack", "charts_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
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

    /* compiled from: AAChartView.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\t"}, m12616d2 = {"Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartView$AAChartViewCallBack;", "", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartView;", "aaChartView", "Lkotlin/f1;", "chartViewDidFinishLoad", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAMoveOverEventMessageModel;", "messageModel", "chartViewMoveOverEventMessage", "charts_release"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface AAChartViewCallBack {
        void chartViewDidFinishLoad(@NotNull AAChartView aAChartView);

        void chartViewMoveOverEventMessage(@NotNull AAChartView aAChartView, @NotNull AAMoveOverEventMessageModel aAMoveOverEventMessageModel);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AAChartView(@NotNull Context context) {
        super(context);
        C14342f0.m8184p(context, "context");
        setupBasicContent();
    }

    public static /* synthetic */ void aa_addPointToChartSeriesElement$default(AAChartView aAChartView, int i, Object obj, boolean z, int i2, Object obj2) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        aAChartView.aa_addPointToChartSeriesElement(i, obj, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void configureChartOptionsAndDrawChart(AAOptions aAOptions) {
        Boolean bool = this.isClearBackgroundColor;
        C14342f0.m8187m(bool);
        if (bool.booleanValue()) {
            AAChart chart = aAOptions.getChart();
            C14342f0.m8187m(chart);
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
        aAMoveOverEventMessageModel.setOffset((LinkedTreeMap) map.get(IjkMediaPlayer.OnNativeInvokeListener.ARG_OFFSET));
        Double d = (Double) map.get("index");
        aAMoveOverEventMessageModel.setIndex(d != null ? Integer.valueOf((int) d.doubleValue()) : null);
        return aAMoveOverEventMessageModel;
    }

    private final void loadLocalFilesAndDrawChart(final AAOptions aAOptions) {
        loadUrl("file:///android_asset/AAChartView.html");
        setWebViewClient(new WebViewClient() { // from class: com.github.aachartmodel.aainfographics.aachartcreator.AAChartView$loadLocalFilesAndDrawChart$1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(@NotNull WebView view, @NotNull String url) {
                C14342f0.m8184p(view, "view");
                C14342f0.m8184p(url, "url");
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
        C14342f0.m8185o(settings, "settings");
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
                C14342f0.m8184p(view, "view");
                C14342f0.m8184p(url, "url");
                C14342f0.m8184p(message, "message");
                C14342f0.m8184p(result, "result");
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

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    public final void aa_addElementToChartSeries(@NotNull AASeriesElement aaSeriesElement) {
        C14342f0.m8184p(aaSeriesElement, "aaSeriesElement");
        String json = new Gson().toJson(aaSeriesElement);
        safeEvaluateJavaScriptString("addElementToChartSeriesWithElement('" + json + "')");
    }

    @JvmOverloads
    public final void aa_addPointToChartSeriesElement(int i, @NotNull Object obj) {
        aa_addPointToChartSeriesElement$default(this, i, obj, false, 4, null);
    }

    @JvmOverloads
    public final void aa_addPointToChartSeriesElement(int i, @NotNull Object options, boolean z) {
        C14342f0.m8184p(options, "options");
        aa_addPointToChartSeriesElement(i, options, true, z, true);
    }

    public final void aa_drawChartWithChartModel(@NotNull AAChartModel chartModel) {
        C14342f0.m8184p(chartModel, "chartModel");
        aa_drawChartWithChartOptions(AAChartModelKt.aa_toAAOptions(chartModel));
    }

    public final void aa_drawChartWithChartOptions(@NotNull AAOptions chartOptions) {
        C14342f0.m8184p(chartOptions, "chartOptions");
        if (this.optionsJson != null) {
            aa_refreshChartWithChartOptions(chartOptions);
            return;
        }
        loadLocalFilesAndDrawChart(chartOptions);
        showJavaScriptAlertView();
    }

    public final void aa_evaluateTheJavaScriptStringFunction(@NotNull String jsFunctionStr) {
        C14342f0.m8184p(jsFunctionStr, "jsFunctionStr");
        String pureJavaScriptFunctionString = AAJSStringPurer.INSTANCE.pureJavaScriptFunctionString(jsFunctionStr);
        safeEvaluateJavaScriptString("evaluateTheJavaScriptStringFunction('" + pureJavaScriptFunctionString + "')");
    }

    public final void aa_hideTheSeriesElementContent(int i) {
        safeEvaluateJavaScriptString("hideTheSeriesElementContentWithIndex('" + i + "')");
    }

    public final void aa_onlyRefreshTheChartDataWithChartOptionsSeriesArray(@NotNull AASeriesElement[] seriesElementsArr) {
        C14342f0.m8184p(seriesElementsArr, "seriesElementsArr");
        aa_onlyRefreshTheChartDataWithChartOptionsSeriesArray(seriesElementsArr, true);
    }

    public final void aa_refreshChartWithChartModel(@NotNull AAChartModel chartModel) {
        C14342f0.m8184p(chartModel, "chartModel");
        aa_refreshChartWithChartOptions(AAChartModelKt.aa_toAAOptions(chartModel));
    }

    public final void aa_refreshChartWithChartOptions(@NotNull AAOptions chartOptions) {
        C14342f0.m8184p(chartOptions, "chartOptions");
        configureChartOptionsAndDrawChart(chartOptions);
    }

    public final void aa_removeElementFromChartSeries(int i) {
        safeEvaluateJavaScriptString("removeElementFromChartSeriesWithElementIndex('" + i + "')");
    }

    public final void aa_showTheSeriesElementContent(int i) {
        safeEvaluateJavaScriptString("showTheSeriesElementContentWithIndex('" + i + "')");
    }

    public final void aa_updateChartWithOptions(@NotNull Object options, boolean z) {
        String m6568k2;
        String optionsStr;
        C14342f0.m8184p(options, "options");
        if (options instanceof AAOptions) {
            optionsStr = new Gson().toJson(options);
            C14342f0.m8185o(optionsStr, "aaOptionsMapStr");
        } else {
            String classNameStr = options.getClass().getSimpleName();
            C14342f0.m8185o(classNameStr, "classNameStr");
            m6568k2 = StringsJVM.m6568k2(classNameStr, "AA", "", false, 4, null);
            if (m6568k2 != null) {
                String substring = m6568k2.substring(0, 1);
                C14342f0.m8185o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                Locale locale = Locale.ROOT;
                C14342f0.m8185o(locale, "Locale.ROOT");
                if (substring != null) {
                    String lowerCase = substring.toLowerCase(locale);
                    C14342f0.m8185o(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    String substring2 = m6568k2.substring(1);
                    C14342f0.m8185o(substring2, "(this as java.lang.String).substring(startIndex)");
                    String str = lowerCase + substring2;
                    HashMap hashMap = new HashMap();
                    hashMap.put(str, options);
                    optionsStr = new Gson().toJson(hashMap);
                    C14342f0.m8185o(optionsStr, "optionsStr");
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
        safeEvaluateJavaScriptString("updateChart('" + optionsStr + "','" + z + "')");
    }

    @JavascriptInterface
    @NotNull
    public final String androidMethod(@Nullable String str) {
        Object fromJson = new Gson().fromJson(str, (Class<Object>) new HashMap().getClass());
        C14342f0.m8185o(fromJson, "Gson().fromJson(message, messageBody.javaClass)");
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
        if (C14342f0.m8193g(bool, Boolean.TRUE)) {
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

    public final void aa_addPointToChartSeriesElement(int i, @NotNull Object options, boolean z, boolean z2, boolean z3) {
        String obj;
        C14342f0.m8184p(options, "options");
        if (!(options instanceof Integer) && !(options instanceof Float) && !(options instanceof Double)) {
            obj = new Gson().toJson(options);
            C14342f0.m8185o(obj, "Gson().toJson(options)");
        } else {
            obj = options.toString();
        }
        safeEvaluateJavaScriptString("addPointToChartSeries('" + i + "','" + obj + "','" + z + "','" + z2 + "','" + z3 + "')");
    }

    public final void aa_onlyRefreshTheChartDataWithChartOptionsSeriesArray(@NotNull AASeriesElement[] seriesElementsArr, boolean z) {
        C14342f0.m8184p(seriesElementsArr, "seriesElementsArr");
        String json = new Gson().toJson(seriesElementsArr);
        safeEvaluateJavaScriptString("onlyRefreshTheChartDataWithSeries('" + json + "','" + z + "')");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AAChartView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        C14342f0.m8184p(context, "context");
        setupBasicContent();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AAChartView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C14342f0.m8184p(context, "context");
        setupBasicContent();
    }
}

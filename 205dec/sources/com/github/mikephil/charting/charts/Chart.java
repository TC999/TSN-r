package com.github.mikephil.charting.charts;

import android.animation.ValueAnimator;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.RequiresApi;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.IMarker;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.IHighlighter;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.LegendRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class Chart<T extends ChartData<? extends IDataSet<? extends Entry>>> extends ViewGroup implements ChartInterface {
    public static final String LOG_TAG = "MPAndroidChart";
    public static final int PAINT_CENTER_TEXT = 14;
    public static final int PAINT_DESCRIPTION = 11;
    public static final int PAINT_GRID_BACKGROUND = 4;
    public static final int PAINT_HOLE = 13;
    public static final int PAINT_INFO = 7;
    public static final int PAINT_LEGEND_LABEL = 18;
    protected ChartAnimator mAnimator;
    protected ChartTouchListener mChartTouchListener;
    protected T mData;
    protected DefaultValueFormatter mDefaultValueFormatter;
    protected Paint mDescPaint;
    protected Description mDescription;
    private boolean mDragDecelerationEnabled;
    private float mDragDecelerationFrictionCoef;
    protected boolean mDrawMarkers;
    private float mExtraBottomOffset;
    private float mExtraLeftOffset;
    private float mExtraRightOffset;
    private float mExtraTopOffset;
    private OnChartGestureListener mGestureListener;
    protected boolean mHighLightPerTapEnabled;
    protected IHighlighter mHighlighter;
    protected Highlight[] mIndicesToHighlight;
    protected Paint mInfoPaint;
    protected ArrayList<Runnable> mJobs;
    protected Legend mLegend;
    protected LegendRenderer mLegendRenderer;
    protected boolean mLogEnabled;
    protected IMarker mMarker;
    protected float mMaxHighlightDistance;
    private String mNoDataText;
    private boolean mOffsetsCalculated;
    protected DataRenderer mRenderer;
    protected OnChartValueSelectedListener mSelectionListener;
    protected boolean mTouchEnabled;
    private boolean mUnbind;
    protected ViewPortHandler mViewPortHandler;
    protected XAxis mXAxis;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* renamed from: com.github.mikephil.charting.charts.Chart$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$CompressFormat;

        static {
            int[] iArr = new int[Bitmap.CompressFormat.values().length];
            $SwitchMap$android$graphics$Bitmap$CompressFormat = iArr;
            try {
                iArr[Bitmap.CompressFormat.PNG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$CompressFormat[Bitmap.CompressFormat.WEBP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$CompressFormat[Bitmap.CompressFormat.JPEG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public Chart(Context context) {
        super(context);
        this.mLogEnabled = false;
        this.mData = null;
        this.mHighLightPerTapEnabled = true;
        this.mDragDecelerationEnabled = true;
        this.mDragDecelerationFrictionCoef = 0.9f;
        this.mDefaultValueFormatter = new DefaultValueFormatter(0);
        this.mTouchEnabled = true;
        this.mNoDataText = "No chart data available.";
        this.mViewPortHandler = new ViewPortHandler();
        this.mExtraTopOffset = 0.0f;
        this.mExtraRightOffset = 0.0f;
        this.mExtraBottomOffset = 0.0f;
        this.mExtraLeftOffset = 0.0f;
        this.mOffsetsCalculated = false;
        this.mMaxHighlightDistance = 0.0f;
        this.mDrawMarkers = true;
        this.mJobs = new ArrayList<>();
        this.mUnbind = false;
        init();
    }

    private void unbindDrawables(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback(null);
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        int i4 = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i4 < viewGroup.getChildCount()) {
                unbindDrawables(viewGroup.getChildAt(i4));
                i4++;
            } else {
                viewGroup.removeAllViews();
                return;
            }
        }
    }

    public void addViewportJob(Runnable runnable) {
        if (this.mViewPortHandler.hasChartDimens()) {
            post(runnable);
        } else {
            this.mJobs.add(runnable);
        }
    }

    @RequiresApi(11)
    public void animateX(int i4, Easing.EasingFunction easingFunction) {
        this.mAnimator.animateX(i4, easingFunction);
    }

    @RequiresApi(11)
    public void animateXY(int i4, int i5, Easing.EasingFunction easingFunction, Easing.EasingFunction easingFunction2) {
        this.mAnimator.animateXY(i4, i5, easingFunction, easingFunction2);
    }

    @RequiresApi(11)
    public void animateY(int i4, Easing.EasingFunction easingFunction) {
        this.mAnimator.animateY(i4, easingFunction);
    }

    protected abstract void calcMinMax();

    protected abstract void calculateOffsets();

    public void clear() {
        this.mData = null;
        this.mOffsetsCalculated = false;
        this.mIndicesToHighlight = null;
        this.mChartTouchListener.setLastHighlighted(null);
        invalidate();
    }

    public void clearAllViewportJobs() {
        this.mJobs.clear();
    }

    public void clearValues() {
        this.mData.clearValues();
        invalidate();
    }

    public void disableScroll() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void drawDescription(Canvas canvas) {
        float f4;
        float f5;
        Description description = this.mDescription;
        if (description == null || !description.isEnabled()) {
            return;
        }
        MPPointF position = this.mDescription.getPosition();
        this.mDescPaint.setTypeface(this.mDescription.getTypeface());
        this.mDescPaint.setTextSize(this.mDescription.getTextSize());
        this.mDescPaint.setColor(this.mDescription.getTextColor());
        this.mDescPaint.setTextAlign(this.mDescription.getTextAlign());
        if (position == null) {
            f5 = (getWidth() - this.mViewPortHandler.offsetRight()) - this.mDescription.getXOffset();
            f4 = (getHeight() - this.mViewPortHandler.offsetBottom()) - this.mDescription.getYOffset();
        } else {
            float f6 = position.f37332x;
            f4 = position.f37333y;
            f5 = f6;
        }
        canvas.drawText(this.mDescription.getText(), f5, f4, this.mDescPaint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void drawMarkers(Canvas canvas) {
        if (this.mMarker == null || !isDrawMarkersEnabled() || !valuesToHighlight()) {
            return;
        }
        int i4 = 0;
        while (true) {
            Highlight[] highlightArr = this.mIndicesToHighlight;
            if (i4 >= highlightArr.length) {
                return;
            }
            Highlight highlight = highlightArr[i4];
            IDataSet dataSetByIndex = this.mData.getDataSetByIndex(highlight.getDataSetIndex());
            Entry entryForHighlight = this.mData.getEntryForHighlight(this.mIndicesToHighlight[i4]);
            int entryIndex = dataSetByIndex.getEntryIndex(entryForHighlight);
            if (entryForHighlight != null && entryIndex <= dataSetByIndex.getEntryCount() * this.mAnimator.getPhaseX()) {
                float[] markerPosition = getMarkerPosition(highlight);
                if (this.mViewPortHandler.isInBounds(markerPosition[0], markerPosition[1])) {
                    this.mMarker.refreshContent(entryForHighlight, highlight);
                    this.mMarker.draw(canvas, markerPosition[0], markerPosition[1]);
                }
            }
            i4++;
        }
    }

    public void enableScroll() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    public ChartAnimator getAnimator() {
        return this.mAnimator;
    }

    public MPPointF getCenter() {
        return MPPointF.getInstance(getWidth() / 2.0f, getHeight() / 2.0f);
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public MPPointF getCenterOfView() {
        return getCenter();
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public MPPointF getCenterOffsets() {
        return this.mViewPortHandler.getContentCenter();
    }

    public Bitmap getChartBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        draw(canvas);
        return createBitmap;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public RectF getContentRect() {
        return this.mViewPortHandler.getContentRect();
    }

    public T getData() {
        return this.mData;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public ValueFormatter getDefaultValueFormatter() {
        return this.mDefaultValueFormatter;
    }

    public Description getDescription() {
        return this.mDescription;
    }

    public float getDragDecelerationFrictionCoef() {
        return this.mDragDecelerationFrictionCoef;
    }

    public float getExtraBottomOffset() {
        return this.mExtraBottomOffset;
    }

    public float getExtraLeftOffset() {
        return this.mExtraLeftOffset;
    }

    public float getExtraRightOffset() {
        return this.mExtraRightOffset;
    }

    public float getExtraTopOffset() {
        return this.mExtraTopOffset;
    }

    public Highlight getHighlightByTouchPoint(float f4, float f5) {
        if (this.mData == null) {
            Log.e("MPAndroidChart", "Can't select by touch. No data set.");
            return null;
        }
        return getHighlighter().getHighlight(f4, f5);
    }

    public Highlight[] getHighlighted() {
        return this.mIndicesToHighlight;
    }

    public IHighlighter getHighlighter() {
        return this.mHighlighter;
    }

    public ArrayList<Runnable> getJobs() {
        return this.mJobs;
    }

    public Legend getLegend() {
        return this.mLegend;
    }

    public LegendRenderer getLegendRenderer() {
        return this.mLegendRenderer;
    }

    public IMarker getMarker() {
        return this.mMarker;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float[] getMarkerPosition(Highlight highlight) {
        return new float[]{highlight.getDrawX(), highlight.getDrawY()};
    }

    @Deprecated
    public IMarker getMarkerView() {
        return getMarker();
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getMaxHighlightDistance() {
        return this.mMaxHighlightDistance;
    }

    public OnChartGestureListener getOnChartGestureListener() {
        return this.mGestureListener;
    }

    public ChartTouchListener getOnTouchListener() {
        return this.mChartTouchListener;
    }

    public Paint getPaint(int i4) {
        if (i4 != 7) {
            if (i4 != 11) {
                return null;
            }
            return this.mDescPaint;
        }
        return this.mInfoPaint;
    }

    public DataRenderer getRenderer() {
        return this.mRenderer;
    }

    public ViewPortHandler getViewPortHandler() {
        return this.mViewPortHandler;
    }

    public XAxis getXAxis() {
        return this.mXAxis;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getXChartMax() {
        return this.mXAxis.mAxisMaximum;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getXChartMin() {
        return this.mXAxis.mAxisMinimum;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getXRange() {
        return this.mXAxis.mAxisRange;
    }

    public float getYMax() {
        return this.mData.getYMax();
    }

    public float getYMin() {
        return this.mData.getYMin();
    }

    public void highlightValue(float f4, int i4) {
        highlightValue(f4, i4, true);
    }

    public void highlightValues(Highlight[] highlightArr) {
        this.mIndicesToHighlight = highlightArr;
        setLastHighlighted(highlightArr);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setWillNotDraw(false);
        this.mAnimator = new ChartAnimator(new ValueAnimator.AnimatorUpdateListener() { // from class: com.github.mikephil.charting.charts.Chart.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Chart.this.postInvalidate();
            }
        });
        Utils.init(getContext());
        this.mMaxHighlightDistance = Utils.convertDpToPixel(500.0f);
        this.mDescription = new Description();
        Legend legend = new Legend();
        this.mLegend = legend;
        this.mLegendRenderer = new LegendRenderer(this.mViewPortHandler, legend);
        this.mXAxis = new XAxis();
        this.mDescPaint = new Paint(1);
        Paint paint = new Paint(1);
        this.mInfoPaint = paint;
        paint.setColor(Color.rgb((int) MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, (int) MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SHARP, 51));
        this.mInfoPaint.setTextAlign(Paint.Align.CENTER);
        this.mInfoPaint.setTextSize(Utils.convertDpToPixel(12.0f));
        if (this.mLogEnabled) {
            Log.i("", "Chart.init()");
        }
    }

    public boolean isDragDecelerationEnabled() {
        return this.mDragDecelerationEnabled;
    }

    @Deprecated
    public boolean isDrawMarkerViewsEnabled() {
        return isDrawMarkersEnabled();
    }

    public boolean isDrawMarkersEnabled() {
        return this.mDrawMarkers;
    }

    public boolean isEmpty() {
        T t3 = this.mData;
        return t3 == null || t3.getEntryCount() <= 0;
    }

    public boolean isHighlightPerTapEnabled() {
        return this.mHighLightPerTapEnabled;
    }

    public boolean isLogEnabled() {
        return this.mLogEnabled;
    }

    public abstract void notifyDataSetChanged();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mUnbind) {
            unbindDrawables(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mData == null) {
            if (!TextUtils.isEmpty(this.mNoDataText)) {
                MPPointF center = getCenter();
                canvas.drawText(this.mNoDataText, center.f37332x, center.f37333y, this.mInfoPaint);
            }
        } else if (this.mOffsetsCalculated) {
        } else {
            calculateOffsets();
            this.mOffsetsCalculated = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            getChildAt(i8).layout(i4, i5, i6, i7);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        int convertDpToPixel = (int) Utils.convertDpToPixel(50.0f);
        setMeasuredDimension(Math.max(getSuggestedMinimumWidth(), ViewGroup.resolveSize(convertDpToPixel, i4)), Math.max(getSuggestedMinimumHeight(), ViewGroup.resolveSize(convertDpToPixel, i5)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i4, int i5, int i6, int i7) {
        if (this.mLogEnabled) {
            Log.i("MPAndroidChart", "OnSizeChanged()");
        }
        if (i4 > 0 && i5 > 0 && i4 < 10000 && i5 < 10000) {
            if (this.mLogEnabled) {
                Log.i("MPAndroidChart", "Setting chart dimens, width: " + i4 + ", height: " + i5);
            }
            this.mViewPortHandler.setChartDimens(i4, i5);
        } else if (this.mLogEnabled) {
            Log.w("MPAndroidChart", "*Avoiding* setting chart dimens! width: " + i4 + ", height: " + i5);
        }
        notifyDataSetChanged();
        Iterator<Runnable> it = this.mJobs.iterator();
        while (it.hasNext()) {
            post(it.next());
        }
        this.mJobs.clear();
        super.onSizeChanged(i4, i5, i6, i7);
    }

    public void removeViewportJob(Runnable runnable) {
        this.mJobs.remove(runnable);
    }

    public boolean saveToGallery(String str, String str2, String str3, Bitmap.CompressFormat compressFormat, int i4) {
        i4 = (i4 < 0 || i4 > 100) ? 50 : 50;
        long currentTimeMillis = System.currentTimeMillis();
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        File file = new File(externalStorageDirectory.getAbsolutePath() + "/DCIM/" + str2);
        if (file.exists() || file.mkdirs()) {
            int i5 = AnonymousClass2.$SwitchMap$android$graphics$Bitmap$CompressFormat[compressFormat.ordinal()];
            String str4 = "image/png";
            if (i5 != 1) {
                if (i5 != 2) {
                    if (!str.endsWith(".jpg") && !str.endsWith(".jpeg")) {
                        str = str + ".jpg";
                    }
                    str4 = "image/jpeg";
                } else {
                    if (!str.endsWith(".webp")) {
                        str = str + ".webp";
                    }
                    str4 = "image/webp";
                }
            } else if (!str.endsWith(".png")) {
                str = str + ".png";
            }
            String str5 = file.getAbsolutePath() + TTPathConst.sSeparator + str;
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(str5);
                getChartBitmap().compress(compressFormat, i4, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                long length = new File(str5).length();
                ContentValues contentValues = new ContentValues(8);
                contentValues.put("title", str);
                contentValues.put("_display_name", str);
                contentValues.put("date_added", Long.valueOf(currentTimeMillis));
                contentValues.put("mime_type", str4);
                contentValues.put("description", str3);
                contentValues.put("orientation", (Integer) 0);
                contentValues.put("_data", str5);
                contentValues.put("_size", Long.valueOf(length));
                return getContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues) != null;
            } catch (IOException e4) {
                e4.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public boolean saveToPath(String str, String str2) {
        Bitmap chartBitmap = getChartBitmap();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(Environment.getExternalStorageDirectory().getPath() + str2 + TTPathConst.sSeparator + str + ".png");
            chartBitmap.compress(Bitmap.CompressFormat.PNG, 40, fileOutputStream);
            fileOutputStream.close();
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public void setData(T t3) {
        this.mData = t3;
        this.mOffsetsCalculated = false;
        if (t3 == null) {
            return;
        }
        setupDefaultFormatter(t3.getYMin(), t3.getYMax());
        for (IDataSet iDataSet : this.mData.getDataSets()) {
            if (iDataSet.needsFormatter() || iDataSet.getValueFormatter() == this.mDefaultValueFormatter) {
                iDataSet.setValueFormatter(this.mDefaultValueFormatter);
            }
        }
        notifyDataSetChanged();
        if (this.mLogEnabled) {
            Log.i("MPAndroidChart", "Data is set.");
        }
    }

    public void setDescription(Description description) {
        this.mDescription = description;
    }

    public void setDragDecelerationEnabled(boolean z3) {
        this.mDragDecelerationEnabled = z3;
    }

    public void setDragDecelerationFrictionCoef(float f4) {
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        if (f4 >= 1.0f) {
            f4 = 0.999f;
        }
        this.mDragDecelerationFrictionCoef = f4;
    }

    @Deprecated
    public void setDrawMarkerViews(boolean z3) {
        setDrawMarkers(z3);
    }

    public void setDrawMarkers(boolean z3) {
        this.mDrawMarkers = z3;
    }

    public void setExtraBottomOffset(float f4) {
        this.mExtraBottomOffset = Utils.convertDpToPixel(f4);
    }

    public void setExtraLeftOffset(float f4) {
        this.mExtraLeftOffset = Utils.convertDpToPixel(f4);
    }

    public void setExtraOffsets(float f4, float f5, float f6, float f7) {
        setExtraLeftOffset(f4);
        setExtraTopOffset(f5);
        setExtraRightOffset(f6);
        setExtraBottomOffset(f7);
    }

    public void setExtraRightOffset(float f4) {
        this.mExtraRightOffset = Utils.convertDpToPixel(f4);
    }

    public void setExtraTopOffset(float f4) {
        this.mExtraTopOffset = Utils.convertDpToPixel(f4);
    }

    public void setHardwareAccelerationEnabled(boolean z3) {
        if (z3) {
            setLayerType(2, null);
        } else {
            setLayerType(1, null);
        }
    }

    public void setHighlightPerTapEnabled(boolean z3) {
        this.mHighLightPerTapEnabled = z3;
    }

    public void setHighlighter(ChartHighlighter chartHighlighter) {
        this.mHighlighter = chartHighlighter;
    }

    protected void setLastHighlighted(Highlight[] highlightArr) {
        if (highlightArr != null && highlightArr.length > 0 && highlightArr[0] != null) {
            this.mChartTouchListener.setLastHighlighted(highlightArr[0]);
        } else {
            this.mChartTouchListener.setLastHighlighted(null);
        }
    }

    public void setLogEnabled(boolean z3) {
        this.mLogEnabled = z3;
    }

    public void setMarker(IMarker iMarker) {
        this.mMarker = iMarker;
    }

    @Deprecated
    public void setMarkerView(IMarker iMarker) {
        setMarker(iMarker);
    }

    public void setMaxHighlightDistance(float f4) {
        this.mMaxHighlightDistance = Utils.convertDpToPixel(f4);
    }

    public void setNoDataText(String str) {
        this.mNoDataText = str;
    }

    public void setNoDataTextColor(int i4) {
        this.mInfoPaint.setColor(i4);
    }

    public void setNoDataTextTypeface(Typeface typeface) {
        this.mInfoPaint.setTypeface(typeface);
    }

    public void setOnChartGestureListener(OnChartGestureListener onChartGestureListener) {
        this.mGestureListener = onChartGestureListener;
    }

    public void setOnChartValueSelectedListener(OnChartValueSelectedListener onChartValueSelectedListener) {
        this.mSelectionListener = onChartValueSelectedListener;
    }

    public void setOnTouchListener(ChartTouchListener chartTouchListener) {
        this.mChartTouchListener = chartTouchListener;
    }

    public void setPaint(Paint paint, int i4) {
        if (i4 == 7) {
            this.mInfoPaint = paint;
        } else if (i4 != 11) {
        } else {
            this.mDescPaint = paint;
        }
    }

    public void setRenderer(DataRenderer dataRenderer) {
        if (dataRenderer != null) {
            this.mRenderer = dataRenderer;
        }
    }

    public void setTouchEnabled(boolean z3) {
        this.mTouchEnabled = z3;
    }

    public void setUnbindEnabled(boolean z3) {
        this.mUnbind = z3;
    }

    protected void setupDefaultFormatter(float f4, float f5) {
        float max;
        T t3 = this.mData;
        if (t3 != null && t3.getEntryCount() >= 2) {
            max = Math.abs(f5 - f4);
        } else {
            max = Math.max(Math.abs(f4), Math.abs(f5));
        }
        this.mDefaultValueFormatter.setup(Utils.getDecimals(max));
    }

    public boolean valuesToHighlight() {
        Highlight[] highlightArr = this.mIndicesToHighlight;
        return (highlightArr == null || highlightArr.length <= 0 || highlightArr[0] == null) ? false : true;
    }

    @RequiresApi(11)
    public void animateX(int i4) {
        this.mAnimator.animateX(i4);
    }

    @RequiresApi(11)
    public void animateXY(int i4, int i5, Easing.EasingFunction easingFunction) {
        this.mAnimator.animateXY(i4, i5, easingFunction);
    }

    @RequiresApi(11)
    public void animateY(int i4) {
        this.mAnimator.animateY(i4);
    }

    public void highlightValue(float f4, float f5, int i4) {
        highlightValue(f4, f5, i4, true);
    }

    @RequiresApi(11)
    public void animateXY(int i4, int i5) {
        this.mAnimator.animateXY(i4, i5);
    }

    public void highlightValue(float f4, int i4, boolean z3) {
        highlightValue(f4, Float.NaN, i4, z3);
    }

    public void highlightValue(float f4, float f5, int i4, boolean z3) {
        if (i4 >= 0 && i4 < this.mData.getDataSetCount()) {
            highlightValue(new Highlight(f4, f5, i4), z3);
        } else {
            highlightValue((Highlight) null, z3);
        }
    }

    public void highlightValue(Highlight highlight) {
        highlightValue(highlight, false);
    }

    public void highlightValue(Highlight highlight, boolean z3) {
        Entry entry = null;
        if (highlight == null) {
            this.mIndicesToHighlight = null;
        } else {
            if (this.mLogEnabled) {
                Log.i("MPAndroidChart", "Highlighted: " + highlight.toString());
            }
            Entry entryForHighlight = this.mData.getEntryForHighlight(highlight);
            if (entryForHighlight == null) {
                this.mIndicesToHighlight = null;
                highlight = null;
            } else {
                this.mIndicesToHighlight = new Highlight[]{highlight};
            }
            entry = entryForHighlight;
        }
        setLastHighlighted(this.mIndicesToHighlight);
        if (z3 && this.mSelectionListener != null) {
            if (!valuesToHighlight()) {
                this.mSelectionListener.onNothingSelected();
            } else {
                this.mSelectionListener.onValueSelected(entry, highlight);
            }
        }
        invalidate();
    }

    public Chart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLogEnabled = false;
        this.mData = null;
        this.mHighLightPerTapEnabled = true;
        this.mDragDecelerationEnabled = true;
        this.mDragDecelerationFrictionCoef = 0.9f;
        this.mDefaultValueFormatter = new DefaultValueFormatter(0);
        this.mTouchEnabled = true;
        this.mNoDataText = "No chart data available.";
        this.mViewPortHandler = new ViewPortHandler();
        this.mExtraTopOffset = 0.0f;
        this.mExtraRightOffset = 0.0f;
        this.mExtraBottomOffset = 0.0f;
        this.mExtraLeftOffset = 0.0f;
        this.mOffsetsCalculated = false;
        this.mMaxHighlightDistance = 0.0f;
        this.mDrawMarkers = true;
        this.mJobs = new ArrayList<>();
        this.mUnbind = false;
        init();
    }

    public boolean saveToGallery(String str, int i4) {
        return saveToGallery(str, "", "MPAndroidChart-Library Save", Bitmap.CompressFormat.PNG, i4);
    }

    public boolean saveToGallery(String str) {
        return saveToGallery(str, "", "MPAndroidChart-Library Save", Bitmap.CompressFormat.PNG, 40);
    }

    public Chart(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.mLogEnabled = false;
        this.mData = null;
        this.mHighLightPerTapEnabled = true;
        this.mDragDecelerationEnabled = true;
        this.mDragDecelerationFrictionCoef = 0.9f;
        this.mDefaultValueFormatter = new DefaultValueFormatter(0);
        this.mTouchEnabled = true;
        this.mNoDataText = "No chart data available.";
        this.mViewPortHandler = new ViewPortHandler();
        this.mExtraTopOffset = 0.0f;
        this.mExtraRightOffset = 0.0f;
        this.mExtraBottomOffset = 0.0f;
        this.mExtraLeftOffset = 0.0f;
        this.mOffsetsCalculated = false;
        this.mMaxHighlightDistance = 0.0f;
        this.mDrawMarkers = true;
        this.mJobs = new ArrayList<>();
        this.mUnbind = false;
        init();
    }
}

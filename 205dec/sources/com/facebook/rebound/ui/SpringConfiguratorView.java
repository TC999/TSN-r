package com.facebook.rebound.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.facebook.rebound.OrigamiValueConverter;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringConfigRegistry;
import com.facebook.rebound.SpringListener;
import com.facebook.rebound.SpringSystem;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class SpringConfiguratorView extends FrameLayout {

    /* renamed from: n  reason: collision with root package name */
    private static final int f37087n = 100000;

    /* renamed from: o  reason: collision with root package name */
    private static final float f37088o = 0.0f;

    /* renamed from: p  reason: collision with root package name */
    private static final float f37089p = 200.0f;

    /* renamed from: q  reason: collision with root package name */
    private static final float f37090q = 0.0f;

    /* renamed from: r  reason: collision with root package name */
    private static final float f37091r = 50.0f;

    /* renamed from: s  reason: collision with root package name */
    private static final DecimalFormat f37092s = new DecimalFormat("#.#");

    /* renamed from: a  reason: collision with root package name */
    private final SpinnerAdapter f37093a;

    /* renamed from: b  reason: collision with root package name */
    private final List<SpringConfig> f37094b;

    /* renamed from: c  reason: collision with root package name */
    private final Spring f37095c;

    /* renamed from: d  reason: collision with root package name */
    private final float f37096d;

    /* renamed from: e  reason: collision with root package name */
    private final float f37097e;

    /* renamed from: f  reason: collision with root package name */
    private final SpringConfigRegistry f37098f;

    /* renamed from: g  reason: collision with root package name */
    private final int f37099g;

    /* renamed from: h  reason: collision with root package name */
    private SeekBar f37100h;

    /* renamed from: i  reason: collision with root package name */
    private SeekBar f37101i;

    /* renamed from: j  reason: collision with root package name */
    private Spinner f37102j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f37103k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f37104l;

    /* renamed from: m  reason: collision with root package name */
    private SpringConfig f37105m;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class OnNubTouchListener implements View.OnTouchListener {
        private OnNubTouchListener() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                SpringConfiguratorView.this.q();
                return true;
            }
            return true;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    private class RevealerSpringListener implements SpringListener {
        private RevealerSpringListener() {
        }

        @Override // com.facebook.rebound.SpringListener
        public void onSpringActivate(Spring spring) {
        }

        @Override // com.facebook.rebound.SpringListener
        public void onSpringAtRest(Spring spring) {
        }

        @Override // com.facebook.rebound.SpringListener
        public void onSpringEndStateChange(Spring spring) {
        }

        @Override // com.facebook.rebound.SpringListener
        public void onSpringUpdate(Spring spring) {
            float f4 = (float) spring.f();
            float f5 = SpringConfiguratorView.this.f37097e;
            SpringConfiguratorView.this.setTranslationY((f4 * (SpringConfiguratorView.this.f37096d - f5)) + f5);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    private class SeekbarListener implements SeekBar.OnSeekBarChangeListener {
        private SeekbarListener() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i4, boolean z3) {
            if (seekBar == SpringConfiguratorView.this.f37100h) {
                double d4 = ((i4 * 200.0f) / 100000.0f) + 0.0f;
                SpringConfiguratorView.this.f37105m.f37078b = OrigamiValueConverter.d(d4);
                String format = SpringConfiguratorView.f37092s.format(d4);
                SpringConfiguratorView.this.f37104l.setText("T:" + format);
            }
            if (seekBar == SpringConfiguratorView.this.f37101i) {
                double d5 = ((i4 * 50.0f) / 100000.0f) + 0.0f;
                SpringConfiguratorView.this.f37105m.f37077a = OrigamiValueConverter.a(d5);
                String format2 = SpringConfiguratorView.f37092s.format(d5);
                SpringConfiguratorView.this.f37103k.setText("F:" + format2);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class SpinnerAdapter extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final Context f37109a;

        /* renamed from: b  reason: collision with root package name */
        private final List<String> f37110b = new ArrayList();

        public SpinnerAdapter(Context context) {
            this.f37109a = context;
        }

        public void a(String str) {
            this.f37110b.add(str);
            notifyDataSetChanged();
        }

        public void b() {
            this.f37110b.clear();
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f37110b.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i4) {
            return this.f37110b.get(i4);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i4) {
            return i4;
        }

        @Override // android.widget.Adapter
        public View getView(int i4, View view, ViewGroup viewGroup) {
            TextView textView;
            if (view == null) {
                textView = new TextView(this.f37109a);
                textView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                int f4 = Util.f(12.0f, SpringConfiguratorView.this.getResources());
                textView.setPadding(f4, f4, f4, f4);
                textView.setTextColor(SpringConfiguratorView.this.f37099g);
            } else {
                textView = (TextView) view;
            }
            textView.setText(this.f37110b.get(i4));
            return textView;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    private class SpringSelectedListener implements AdapterView.OnItemSelectedListener {
        private SpringSelectedListener() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
            SpringConfiguratorView springConfiguratorView = SpringConfiguratorView.this;
            springConfiguratorView.f37105m = (SpringConfig) springConfiguratorView.f37094b.get(i4);
            SpringConfiguratorView springConfiguratorView2 = SpringConfiguratorView.this;
            springConfiguratorView2.r(springConfiguratorView2.f37105m);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public SpringConfiguratorView(Context context) {
        this(context, null);
    }

    private View o(Context context) {
        Resources resources = getResources();
        int f4 = Util.f(5.0f, resources);
        int f5 = Util.f(10.0f, resources);
        int f6 = Util.f(20.0f, resources);
        TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.setMargins(0, 0, f4, 0);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(Util.a(-1, Util.f(300.0f, resources)));
        FrameLayout frameLayout2 = new FrameLayout(context);
        FrameLayout.LayoutParams b4 = Util.b();
        b4.setMargins(0, f6, 0, 0);
        frameLayout2.setLayoutParams(b4);
        frameLayout2.setBackgroundColor(Color.argb(100, 0, 0, 0));
        frameLayout.addView(frameLayout2);
        this.f37102j = new Spinner(context, 0);
        FrameLayout.LayoutParams c4 = Util.c();
        c4.gravity = 48;
        c4.setMargins(f5, f5, f5, 0);
        this.f37102j.setLayoutParams(c4);
        frameLayout2.addView(this.f37102j);
        LinearLayout linearLayout = new LinearLayout(context);
        FrameLayout.LayoutParams c5 = Util.c();
        c5.setMargins(0, 0, 0, Util.f(80.0f, resources));
        c5.gravity = 80;
        linearLayout.setLayoutParams(c5);
        linearLayout.setOrientation(1);
        frameLayout2.addView(linearLayout);
        LinearLayout linearLayout2 = new LinearLayout(context);
        FrameLayout.LayoutParams c6 = Util.c();
        c6.setMargins(f5, f5, f5, f6);
        linearLayout2.setPadding(f5, f5, f5, f5);
        linearLayout2.setLayoutParams(c6);
        linearLayout2.setOrientation(0);
        linearLayout.addView(linearLayout2);
        SeekBar seekBar = new SeekBar(context);
        this.f37100h = seekBar;
        seekBar.setLayoutParams(layoutParams);
        linearLayout2.addView(this.f37100h);
        TextView textView = new TextView(getContext());
        this.f37104l = textView;
        textView.setTextColor(this.f37099g);
        FrameLayout.LayoutParams a4 = Util.a(Util.f(50.0f, resources), -1);
        this.f37104l.setGravity(19);
        this.f37104l.setLayoutParams(a4);
        this.f37104l.setMaxLines(1);
        linearLayout2.addView(this.f37104l);
        LinearLayout linearLayout3 = new LinearLayout(context);
        FrameLayout.LayoutParams c7 = Util.c();
        c7.setMargins(f5, f5, f5, f6);
        linearLayout3.setPadding(f5, f5, f5, f5);
        linearLayout3.setLayoutParams(c7);
        linearLayout3.setOrientation(0);
        linearLayout.addView(linearLayout3);
        SeekBar seekBar2 = new SeekBar(context);
        this.f37101i = seekBar2;
        seekBar2.setLayoutParams(layoutParams);
        linearLayout3.addView(this.f37101i);
        TextView textView2 = new TextView(getContext());
        this.f37103k = textView2;
        textView2.setTextColor(this.f37099g);
        FrameLayout.LayoutParams a5 = Util.a(Util.f(50.0f, resources), -1);
        this.f37103k.setGravity(19);
        this.f37103k.setLayoutParams(a5);
        this.f37103k.setMaxLines(1);
        linearLayout3.addView(this.f37103k);
        View view = new View(context);
        FrameLayout.LayoutParams a6 = Util.a(Util.f(60.0f, resources), Util.f(40.0f, resources));
        a6.gravity = 49;
        view.setLayoutParams(a6);
        view.setOnTouchListener(new OnNubTouchListener());
        view.setBackgroundColor(Color.argb(255, 0, (int) MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_REAL_TIME, 209));
        frameLayout.addView(view);
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.f37095c.x(this.f37095c.h() == 1.0d ? 0.0d : 1.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(SpringConfig springConfig) {
        int round = Math.round(((((float) OrigamiValueConverter.c(springConfig.f37078b)) - 0.0f) * 100000.0f) / 200.0f);
        int round2 = Math.round(((((float) OrigamiValueConverter.b(springConfig.f37077a)) - 0.0f) * 100000.0f) / 50.0f);
        this.f37100h.setProgress(round);
        this.f37101i.setProgress(round2);
    }

    public void n() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        this.f37095c.d();
    }

    public void p() {
        Map<SpringConfig, String> b4 = this.f37098f.b();
        this.f37093a.b();
        this.f37094b.clear();
        for (Map.Entry<SpringConfig, String> entry : b4.entrySet()) {
            if (entry.getKey() != SpringConfig.f37076c) {
                this.f37094b.add(entry.getKey());
                this.f37093a.a(entry.getValue());
            }
        }
        this.f37094b.add(SpringConfig.f37076c);
        this.f37093a.a(b4.get(SpringConfig.f37076c));
        this.f37093a.notifyDataSetChanged();
        if (this.f37094b.size() > 0) {
            this.f37102j.setSelection(0);
        }
    }

    public SpringConfiguratorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @TargetApi(11)
    public SpringConfiguratorView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f37094b = new ArrayList();
        this.f37099g = Color.argb(255, 225, 225, 225);
        SpringSystem m4 = SpringSystem.m();
        this.f37098f = SpringConfigRegistry.c();
        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(context);
        this.f37093a = spinnerAdapter;
        Resources resources = getResources();
        this.f37097e = Util.f(40.0f, resources);
        float f4 = Util.f(280.0f, resources);
        this.f37096d = f4;
        Spring d4 = m4.d();
        this.f37095c = d4;
        d4.v(1.0d).x(1.0d).a(new RevealerSpringListener());
        addView(o(context));
        SeekbarListener seekbarListener = new SeekbarListener();
        this.f37100h.setMax(100000);
        this.f37100h.setOnSeekBarChangeListener(seekbarListener);
        this.f37101i.setMax(100000);
        this.f37101i.setOnSeekBarChangeListener(seekbarListener);
        this.f37102j.setAdapter((android.widget.SpinnerAdapter) spinnerAdapter);
        this.f37102j.setOnItemSelectedListener(new SpringSelectedListener());
        p();
        setTranslationY(f4);
    }
}

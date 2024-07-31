package com.facebook.rebound.p198ui;

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
import com.facebook.rebound.OrigamiValueConverter;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringConfigRegistry;
import com.facebook.rebound.SpringListener;
import com.facebook.rebound.SpringSystem;
import com.github.mikephil.charting.utils.Utils;
import com.p518qq.p519e.comm.adevent.AdEventType;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.rebound.ui.SpringConfiguratorView */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SpringConfiguratorView extends FrameLayout {

    /* renamed from: n */
    private static final int f23491n = 100000;

    /* renamed from: o */
    private static final float f23492o = 0.0f;

    /* renamed from: p */
    private static final float f23493p = 200.0f;

    /* renamed from: q */
    private static final float f23494q = 0.0f;

    /* renamed from: r */
    private static final float f23495r = 50.0f;

    /* renamed from: s */
    private static final DecimalFormat f23496s = new DecimalFormat("#.#");

    /* renamed from: a */
    private final SpinnerAdapter f23497a;

    /* renamed from: b */
    private final List<SpringConfig> f23498b;

    /* renamed from: c */
    private final Spring f23499c;

    /* renamed from: d */
    private final float f23500d;

    /* renamed from: e */
    private final float f23501e;

    /* renamed from: f */
    private final SpringConfigRegistry f23502f;

    /* renamed from: g */
    private final int f23503g;

    /* renamed from: h */
    private SeekBar f23504h;

    /* renamed from: i */
    private SeekBar f23505i;

    /* renamed from: j */
    private Spinner f23506j;

    /* renamed from: k */
    private TextView f23507k;

    /* renamed from: l */
    private TextView f23508l;

    /* renamed from: m */
    private SpringConfig f23509m;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.rebound.ui.SpringConfiguratorView$OnNubTouchListener */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class OnNubTouchListener implements View.OnTouchListener {
        private OnNubTouchListener() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                SpringConfiguratorView.this.m35529q();
                return true;
            }
            return true;
        }
    }

    /* renamed from: com.facebook.rebound.ui.SpringConfiguratorView$RevealerSpringListener */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
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
            float m35592f = (float) spring.m35592f();
            float f = SpringConfiguratorView.this.f23501e;
            SpringConfiguratorView.this.setTranslationY((m35592f * (SpringConfiguratorView.this.f23500d - f)) + f);
        }
    }

    /* renamed from: com.facebook.rebound.ui.SpringConfiguratorView$SeekbarListener */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    private class SeekbarListener implements SeekBar.OnSeekBarChangeListener {
        private SeekbarListener() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (seekBar == SpringConfiguratorView.this.f23504h) {
                double d = ((i * 200.0f) / 100000.0f) + 0.0f;
                SpringConfiguratorView.this.f23509m.f23482b = OrigamiValueConverter.m35603d(d);
                String format = SpringConfiguratorView.f23496s.format(d);
                SpringConfiguratorView.this.f23508l.setText("T:" + format);
            }
            if (seekBar == SpringConfiguratorView.this.f23505i) {
                double d2 = ((i * 50.0f) / 100000.0f) + 0.0f;
                SpringConfiguratorView.this.f23509m.f23481a = OrigamiValueConverter.m35606a(d2);
                String format2 = SpringConfiguratorView.f23496s.format(d2);
                SpringConfiguratorView.this.f23507k.setText("F:" + format2);
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
    /* renamed from: com.facebook.rebound.ui.SpringConfiguratorView$SpinnerAdapter */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class SpinnerAdapter extends BaseAdapter {

        /* renamed from: a */
        private final Context f23513a;

        /* renamed from: b */
        private final List<String> f23514b = new ArrayList();

        public SpinnerAdapter(Context context) {
            this.f23513a = context;
        }

        /* renamed from: a */
        public void m35527a(String str) {
            this.f23514b.add(str);
            notifyDataSetChanged();
        }

        /* renamed from: b */
        public void m35526b() {
            this.f23514b.clear();
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f23514b.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.f23514b.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView textView;
            if (view == null) {
                textView = new TextView(this.f23513a);
                textView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                int m35520f = Util.m35520f(12.0f, SpringConfiguratorView.this.getResources());
                textView.setPadding(m35520f, m35520f, m35520f, m35520f);
                textView.setTextColor(SpringConfiguratorView.this.f23503g);
            } else {
                textView = (TextView) view;
            }
            textView.setText(this.f23514b.get(i));
            return textView;
        }
    }

    /* renamed from: com.facebook.rebound.ui.SpringConfiguratorView$SpringSelectedListener */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    private class SpringSelectedListener implements AdapterView.OnItemSelectedListener {
        private SpringSelectedListener() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            SpringConfiguratorView springConfiguratorView = SpringConfiguratorView.this;
            springConfiguratorView.f23509m = (SpringConfig) springConfiguratorView.f23498b.get(i);
            SpringConfiguratorView springConfiguratorView2 = SpringConfiguratorView.this;
            springConfiguratorView2.m35528r(springConfiguratorView2.f23509m);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public SpringConfiguratorView(Context context) {
        this(context, null);
    }

    /* renamed from: o */
    private View m35531o(Context context) {
        Resources resources = getResources();
        int m35520f = Util.m35520f(5.0f, resources);
        int m35520f2 = Util.m35520f(10.0f, resources);
        int m35520f3 = Util.m35520f(20.0f, resources);
        TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.setMargins(0, 0, m35520f, 0);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(Util.m35525a(-1, Util.m35520f(300.0f, resources)));
        FrameLayout frameLayout2 = new FrameLayout(context);
        FrameLayout.LayoutParams m35524b = Util.m35524b();
        m35524b.setMargins(0, m35520f3, 0, 0);
        frameLayout2.setLayoutParams(m35524b);
        frameLayout2.setBackgroundColor(Color.argb(100, 0, 0, 0));
        frameLayout.addView(frameLayout2);
        this.f23506j = new Spinner(context, 0);
        FrameLayout.LayoutParams m35523c = Util.m35523c();
        m35523c.gravity = 48;
        m35523c.setMargins(m35520f2, m35520f2, m35520f2, 0);
        this.f23506j.setLayoutParams(m35523c);
        frameLayout2.addView(this.f23506j);
        LinearLayout linearLayout = new LinearLayout(context);
        FrameLayout.LayoutParams m35523c2 = Util.m35523c();
        m35523c2.setMargins(0, 0, 0, Util.m35520f(80.0f, resources));
        m35523c2.gravity = 80;
        linearLayout.setLayoutParams(m35523c2);
        linearLayout.setOrientation(1);
        frameLayout2.addView(linearLayout);
        LinearLayout linearLayout2 = new LinearLayout(context);
        FrameLayout.LayoutParams m35523c3 = Util.m35523c();
        m35523c3.setMargins(m35520f2, m35520f2, m35520f2, m35520f3);
        linearLayout2.setPadding(m35520f2, m35520f2, m35520f2, m35520f2);
        linearLayout2.setLayoutParams(m35523c3);
        linearLayout2.setOrientation(0);
        linearLayout.addView(linearLayout2);
        SeekBar seekBar = new SeekBar(context);
        this.f23504h = seekBar;
        seekBar.setLayoutParams(layoutParams);
        linearLayout2.addView(this.f23504h);
        TextView textView = new TextView(getContext());
        this.f23508l = textView;
        textView.setTextColor(this.f23503g);
        FrameLayout.LayoutParams m35525a = Util.m35525a(Util.m35520f(50.0f, resources), -1);
        this.f23508l.setGravity(19);
        this.f23508l.setLayoutParams(m35525a);
        this.f23508l.setMaxLines(1);
        linearLayout2.addView(this.f23508l);
        LinearLayout linearLayout3 = new LinearLayout(context);
        FrameLayout.LayoutParams m35523c4 = Util.m35523c();
        m35523c4.setMargins(m35520f2, m35520f2, m35520f2, m35520f3);
        linearLayout3.setPadding(m35520f2, m35520f2, m35520f2, m35520f2);
        linearLayout3.setLayoutParams(m35523c4);
        linearLayout3.setOrientation(0);
        linearLayout.addView(linearLayout3);
        SeekBar seekBar2 = new SeekBar(context);
        this.f23505i = seekBar2;
        seekBar2.setLayoutParams(layoutParams);
        linearLayout3.addView(this.f23505i);
        TextView textView2 = new TextView(getContext());
        this.f23507k = textView2;
        textView2.setTextColor(this.f23503g);
        FrameLayout.LayoutParams m35525a2 = Util.m35525a(Util.m35520f(50.0f, resources), -1);
        this.f23507k.setGravity(19);
        this.f23507k.setLayoutParams(m35525a2);
        this.f23507k.setMaxLines(1);
        linearLayout3.addView(this.f23507k);
        View view = new View(context);
        FrameLayout.LayoutParams m35525a3 = Util.m35525a(Util.m35520f(60.0f, resources), Util.m35520f(40.0f, resources));
        m35525a3.gravity = 49;
        view.setLayoutParams(m35525a3);
        view.setOnTouchListener(new OnNubTouchListener());
        view.setBackgroundColor(Color.argb(255, 0, 164, (int) AdEventType.VIDEO_INIT));
        frameLayout.addView(view);
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m35529q() {
        this.f23499c.m35574x(this.f23499c.m35590h() == 1.0d ? Utils.DOUBLE_EPSILON : 1.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m35528r(SpringConfig springConfig) {
        int round = Math.round(((((float) OrigamiValueConverter.m35604c(springConfig.f23482b)) - 0.0f) * 100000.0f) / 200.0f);
        int round2 = Math.round(((((float) OrigamiValueConverter.m35605b(springConfig.f23481a)) - 0.0f) * 100000.0f) / 50.0f);
        this.f23504h.setProgress(round);
        this.f23505i.setProgress(round2);
    }

    /* renamed from: n */
    public void m35532n() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        this.f23499c.m35594d();
    }

    /* renamed from: p */
    public void m35530p() {
        Map<SpringConfig, String> m35560b = this.f23502f.m35560b();
        this.f23497a.m35526b();
        this.f23498b.clear();
        for (Map.Entry<SpringConfig, String> entry : m35560b.entrySet()) {
            if (entry.getKey() != SpringConfig.f23480c) {
                this.f23498b.add(entry.getKey());
                this.f23497a.m35527a(entry.getValue());
            }
        }
        this.f23498b.add(SpringConfig.f23480c);
        this.f23497a.m35527a(m35560b.get(SpringConfig.f23480c));
        this.f23497a.notifyDataSetChanged();
        if (this.f23498b.size() > 0) {
            this.f23506j.setSelection(0);
        }
    }

    public SpringConfiguratorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @TargetApi(11)
    public SpringConfiguratorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23498b = new ArrayList();
        this.f23503g = Color.argb(255, 225, 225, 225);
        SpringSystem m35555m = SpringSystem.m35555m();
        this.f23502f = SpringConfigRegistry.m35559c();
        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(context);
        this.f23497a = spinnerAdapter;
        Resources resources = getResources();
        this.f23501e = Util.m35520f(40.0f, resources);
        float m35520f = Util.m35520f(280.0f, resources);
        this.f23500d = m35520f;
        Spring m35638d = m35555m.m35638d();
        this.f23499c = m35638d;
        m35638d.m35576v(1.0d).m35574x(1.0d).m35597a(new RevealerSpringListener());
        addView(m35531o(context));
        SeekbarListener seekbarListener = new SeekbarListener();
        this.f23504h.setMax(100000);
        this.f23504h.setOnSeekBarChangeListener(seekbarListener);
        this.f23505i.setMax(100000);
        this.f23505i.setOnSeekBarChangeListener(seekbarListener);
        this.f23506j.setAdapter((android.widget.SpinnerAdapter) spinnerAdapter);
        this.f23506j.setOnItemSelectedListener(new SpringSelectedListener());
        m35530p();
        setTranslationY(m35520f);
    }
}

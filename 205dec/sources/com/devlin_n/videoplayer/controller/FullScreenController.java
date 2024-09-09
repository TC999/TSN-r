package com.devlin_n.videoplayer.controller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import c1.c;
import c1.f;
import com.devlin_n.videoplayer.R;
import com.devlin_n.videoplayer.controller.BaseVideoController;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class FullScreenController extends BaseVideoController implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    protected ImageView A;
    protected ImageView B;
    protected ImageView C;
    protected TextView D;
    private boolean E;
    private boolean F;
    private ProgressBar G;
    private ImageView H;
    private ProgressBar I;
    private LinearLayout J;
    private Animation K;

    /* renamed from: L  reason: collision with root package name */
    private Animation f36894L;
    private PopupMenu M;

    /* renamed from: v  reason: collision with root package name */
    protected TextView f36895v;

    /* renamed from: w  reason: collision with root package name */
    protected TextView f36896w;

    /* renamed from: x  reason: collision with root package name */
    protected LinearLayout f36897x;

    /* renamed from: y  reason: collision with root package name */
    protected LinearLayout f36898y;

    /* renamed from: z  reason: collision with root package name */
    protected SeekBar f36899z;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    class a implements PopupMenu.OnMenuItemClickListener {
        a() {
        }

        @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.scale_default) {
                FullScreenController.this.f36864b.e(0);
            } else if (itemId == R.id.scale_original) {
                FullScreenController.this.f36864b.e(4);
            } else if (itemId == R.id.scale_match) {
                FullScreenController.this.f36864b.e(3);
            } else if (itemId == R.id.scale_16_9) {
                FullScreenController.this.f36864b.e(1);
            } else if (itemId == R.id.scale_4_3) {
                FullScreenController.this.f36864b.e(2);
            }
            FullScreenController.this.M.dismiss();
            return false;
        }
    }

    public FullScreenController(@NonNull Context context) {
        this(context, null);
    }

    private void m() {
        if (this.f36868f) {
            this.f36868f = false;
            this.f36865c = false;
            this.f36873k = true;
            g();
            this.C.setSelected(false);
            Toast.makeText(getContext(), R.string.unlocked, 0).show();
        } else {
            d();
            this.f36868f = true;
            this.f36873k = false;
            this.C.setSelected(true);
            Toast.makeText(getContext(), R.string.locked, 0).show();
        }
        this.f36864b.setLock(this.f36868f);
    }

    private void n() {
        this.f36898y.setVisibility(8);
        this.f36898y.startAnimation(this.f36894L);
        this.f36897x.setVisibility(8);
        this.f36897x.startAnimation(this.f36894L);
    }

    private void o(int i4) {
        if (!this.f36865c) {
            if (this.f36864b.b()) {
                this.C.setVisibility(0);
                if (!this.f36868f) {
                    p();
                }
            } else {
                p();
            }
            if (!this.f36868f && !this.E) {
                this.G.setVisibility(8);
                this.G.startAnimation(this.f36894L);
            }
            this.f36865c = true;
        }
        removeCallbacks(this.f36879q);
        if (i4 != 0) {
            postDelayed(this.f36879q, i4);
        }
    }

    private void p() {
        this.f36897x.setVisibility(0);
        this.f36897x.startAnimation(this.K);
        this.f36898y.setVisibility(0);
        this.f36898y.startAnimation(this.K);
        f.n(getContext());
        f.m(getContext());
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void d() {
        if (this.f36865c) {
            if (this.f36864b.b()) {
                this.C.setVisibility(8);
                if (!this.f36868f) {
                    n();
                    f.j(getContext());
                    f.i(getContext());
                }
            } else {
                n();
            }
            if (!this.E && !this.f36868f) {
                this.G.setVisibility(0);
                this.G.startAnimation(this.K);
            }
            this.f36865c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void e() {
        super.e();
        ImageView imageView = (ImageView) this.f36863a.findViewById(R.id.more_menu);
        this.A = imageView;
        imageView.setOnClickListener(this);
        this.f36897x = (LinearLayout) this.f36863a.findViewById(R.id.bottom_container);
        this.f36898y = (LinearLayout) this.f36863a.findViewById(R.id.top_container);
        SeekBar seekBar = (SeekBar) this.f36863a.findViewById(R.id.seekBar);
        this.f36899z = seekBar;
        seekBar.setOnSeekBarChangeListener(this);
        this.f36895v = (TextView) this.f36863a.findViewById(R.id.total_time);
        this.f36896w = (TextView) this.f36863a.findViewById(R.id.curr_time);
        ImageView imageView2 = (ImageView) this.f36863a.findViewById(R.id.back);
        this.B = imageView2;
        imageView2.setOnClickListener(this);
        ImageView imageView3 = (ImageView) this.f36863a.findViewById(R.id.lock);
        this.C = imageView3;
        imageView3.setOnClickListener(this);
        ImageView imageView4 = (ImageView) this.f36863a.findViewById(R.id.iv_play);
        this.H = imageView4;
        imageView4.setOnClickListener(this);
        this.I = (ProgressBar) this.f36863a.findViewById(R.id.loading);
        this.G = (ProgressBar) this.f36863a.findViewById(R.id.bottom_progress);
        ((ImageView) this.f36863a.findViewById(R.id.iv_replay)).setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.f36863a.findViewById(R.id.complete_container);
        this.J = linearLayout;
        linearLayout.setOnClickListener(this);
        this.D = (TextView) this.f36863a.findViewById(R.id.title);
        PopupMenu popupMenu = new PopupMenu(getContext(), this.A, 8388613);
        this.M = popupMenu;
        popupMenu.getMenuInflater().inflate(R.menu.controller_menu, this.M.getMenu());
        this.M.setOnMenuItemClickListener(new a());
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    protected int f() {
        BaseVideoController.d dVar = this.f36864b;
        if (dVar == null || this.F) {
            return 0;
        }
        int currentPosition = dVar.getCurrentPosition();
        int duration = this.f36864b.getDuration();
        SeekBar seekBar = this.f36899z;
        if (seekBar != null) {
            if (duration > 0) {
                seekBar.setEnabled(true);
                double d4 = currentPosition;
                Double.isNaN(d4);
                double d5 = duration;
                Double.isNaN(d5);
                double d6 = (d4 * 1.0d) / d5;
                double max = this.f36899z.getMax();
                Double.isNaN(max);
                int i4 = (int) (d6 * max);
                this.f36899z.setProgress(i4);
                this.G.setProgress(i4);
            } else {
                seekBar.setEnabled(false);
            }
            int bufferPercentage = this.f36864b.getBufferPercentage();
            if (bufferPercentage >= 95) {
                SeekBar seekBar2 = this.f36899z;
                seekBar2.setSecondaryProgress(seekBar2.getMax());
                ProgressBar progressBar = this.G;
                progressBar.setSecondaryProgress(progressBar.getMax());
            } else {
                int i5 = bufferPercentage * 10;
                this.f36899z.setSecondaryProgress(i5);
                this.G.setSecondaryProgress(i5);
            }
        }
        TextView textView = this.f36895v;
        if (textView != null) {
            textView.setText(k(duration));
        }
        TextView textView2 = this.f36896w;
        if (textView2 != null) {
            textView2.setText(k(currentPosition));
        }
        TextView textView3 = this.D;
        if (textView3 != null) {
            textView3.setText(this.f36864b.getTitle());
        }
        return currentPosition;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void g() {
        o(this.f36869g);
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    protected int getLayoutId() {
        return R.layout.layout_fullscreen_controller;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void i(float f4) {
        if (this.E) {
            this.f36883u = false;
        } else {
            super.i(f4);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.lock) {
            m();
        } else if (id != R.id.iv_play && id != R.id.iv_replay) {
            if (id == R.id.more_menu) {
                this.M.show();
                g();
            } else if (id == R.id.back) {
                f.l(getContext()).finish();
            }
        } else {
            b();
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i4, boolean z3) {
        if (z3) {
            long duration = (this.f36864b.getDuration() * i4) / this.f36899z.getMax();
            TextView textView = this.f36896w;
            if (textView != null) {
                textView.setText(k((int) duration));
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        this.F = true;
        removeCallbacks(this.f36878p);
        removeCallbacks(this.f36879q);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        this.f36864b.seekTo((int) ((this.f36864b.getDuration() * seekBar.getProgress()) / this.f36899z.getMax()));
        this.F = false;
        post(this.f36878p);
        g();
    }

    public void q() {
        this.D.setVisibility(0);
    }

    public void setLive(boolean z3) {
        this.E = z3;
        this.G.setVisibility(8);
        this.f36899z.setVisibility(4);
        this.f36895v.setVisibility(4);
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void setPlayState(int i4) {
        super.setPlayState(i4);
        switch (i4) {
            case -1:
                c.b("STATE_ERROR");
                return;
            case 0:
                c.b("STATE_IDLE");
                d();
                this.f36868f = false;
                this.C.setSelected(false);
                this.f36864b.setLock(false);
                this.J.setVisibility(8);
                this.G.setVisibility(8);
                this.I.setVisibility(8);
                return;
            case 1:
                c.b("STATE_PREPARING");
                this.J.setVisibility(8);
                this.I.setVisibility(0);
                return;
            case 2:
                c.b("STATE_PREPARED");
                if (!this.E) {
                    this.G.setVisibility(0);
                }
                this.I.setVisibility(8);
                return;
            case 3:
                c.b("STATE_PLAYING");
                post(this.f36878p);
                this.H.setSelected(true);
                this.J.setVisibility(8);
                return;
            case 4:
                c.b("STATE_PAUSED");
                this.H.setSelected(false);
                return;
            case 5:
                c.b("STATE_PLAYBACK_COMPLETED");
                d();
                this.J.setVisibility(0);
                this.G.setProgress(0);
                this.G.setSecondaryProgress(0);
                this.f36868f = false;
                this.f36864b.setLock(false);
                return;
            case 6:
                c.b("STATE_BUFFERING");
                this.I.setVisibility(0);
                return;
            case 7:
                this.I.setVisibility(8);
                c.b("STATE_BUFFERED");
                return;
            default:
                return;
        }
    }

    public FullScreenController(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FullScreenController(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i4) {
        super(context, attributeSet, i4);
        this.K = AnimationUtils.loadAnimation(getContext(), R.anim.anim_alpha_in);
        this.f36894L = AnimationUtils.loadAnimation(getContext(), R.anim.anim_alpha_out);
    }
}

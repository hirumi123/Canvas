package com.example.canvas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.AudioManager;
import android.media.MediaCas;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Canvas mCanvas;
    private Paint mPaint = new Paint();
    private Paint mPaintText = new Paint(Paint.UNDERLINE_TEXT_FLAG);
    private Bitmap mBitmap;
    private ImageView mImageView;
    private Rect mRect = new Rect();
    private Rect mBounds = new Rect();

    private static final int OFFSET = 120;
    private int mOffset = OFFSET;
    private static final int MULTIPLIER = 100;

    private int frameCount = 0;
    private int mColorBackground;
    private int mColorRectangle;
    private int mColorAccent;
    private int colorBlack;

    private int kuning;

    private int biru;

    private int cokelat;
    private int colorWhite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer mPlayer = MediaPlayer.create(MainActivity.this, R.raw.evangelinee);
        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 20, 0);
        mPlayer.start();
        mPlayer.getDuration();
        mPlayer.getTimestamp();

        mColorBackground = ResourcesCompat.getColor(getResources(), R.color.colorBackground, null);
        mColorAccent = ResourcesCompat.getColor(getResources(), R.color.colorAccent, null);
        mColorRectangle = ResourcesCompat.getColor(getResources(), R.color.colorRectangle, null);

        mPaint.setColor(mColorBackground);
        mPaintText.setColor(ResourcesCompat.getColor(getResources(), R.color.black, null));
        mPaintText.setTextSize(70);

        // color
        colorBlack = ResourcesCompat.getColor(getResources(),
                R.color.black, null);
        colorWhite = ResourcesCompat.getColor(getResources(),
                R.color.white, null);
        kuning = ResourcesCompat.getColor(getResources(), R.color.kuning, null);
        biru = ResourcesCompat.getColor(getResources(), R.color.biru, null);
        cokelat = ResourcesCompat.getColor(getResources(), R.color.cokelat, null);

        mImageView = findViewById(R.id.myimageview);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawSomething(view);
            }
        });
    }

    public void drawSomething(View view) {
        int vWidth = view.getWidth();
        int vHeight = view.getHeight();
        int halfWidth = vWidth/2;
        int halfHeight = vHeight/2;
        // face coordinate
        Point faceA = new Point(halfWidth-400, halfHeight-180);
        Point faceB = new Point(halfWidth+400, halfHeight-180);
        Point faceC = new Point(halfWidth, halfHeight+200);
        Point faceD = new Point(faceA.x+170, faceA.y+200);
        Point faceE = new Point(faceB.x-170, faceB.y+200);
        Point faceF = new Point(faceD.x, faceD.y-500);


        //Mata
        Point leftEye = new Point(faceA.x+170, faceA.y+50);
        Point rightEye = new Point(faceB.x-170, faceB.y+50);
        //Mulut
        Point mulut = new Point(faceC.x, faceC.y);
        Point nangis = new Point(mulut.x, mulut.y+300);
        //Nangis
        Point a = new Point(faceD.x+90, faceD.y+500);
        Point b = new Point(faceD.x-90, faceD.y+500);
        Point c = new Point(faceD.x-90, faceD.y-50);
        Point d = new Point(faceD.x+90, faceD.y-50);
        Point e = new Point(faceE.x-90, faceE.y+500);
        Point f = new Point(faceE.x+90, faceE.y+500);
        Point g = new Point(faceE.x+90, faceE.y-50);
        Point h = new Point(faceE.x-90, faceE.y-50);
        //Mata
        Point i = new Point(faceF.x+10, faceF.y+40);
        Point j = new Point(faceF.x-10, faceF.y+40);
        Point k = new Point(faceF.x-30, faceF.y-10);
        Point l = new Point(faceF.x+30, faceF.y-10);

        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(16 * getResources().getDisplayMetrics().density);
        textPaint.setColor(0xFF000000);

        Point aa = new Point(halfWidth + 1000, halfHeight - 1000);
        Point bb = new Point(halfWidth - 1000, halfHeight - 1000);
        Point cc = new Point(halfWidth - 1000, halfHeight - 600);
        Point dd = new Point(halfWidth + 1000, halfHeight - 600);


        switch (frameCount) {
            case 0:
                // init canvas
                mBitmap = Bitmap.createBitmap(vWidth, vHeight, Bitmap.Config.ARGB_8888);
                mImageView.setImageBitmap(mBitmap);
                mCanvas = new Canvas(mBitmap);
                mPaint.setColor(kuning);
                mCanvas.save();
                mCanvas.drawCircle(halfWidth, halfHeight, 500, mPaint);
                mCanvas.restore();
                break;
            case 1:
                mPaint.setColor(colorWhite);
                mCanvas.drawCircle(leftEye.x, leftEye.y, 100, mPaint);
                mCanvas.drawCircle(rightEye.x, rightEye.y, 100, mPaint);

                mPaint.setColor(cokelat);
                mCanvas.drawOval(new RectF(mulut.x+120, mulut.y-60, mulut.x-120, mulut.y+60),
                        mPaint);

                //Bola Mata
                mPaint.setColor(colorBlack);
                mCanvas.drawOval(new RectF(leftEye.x-130, leftEye.y-130,
                        leftEye.x+130, leftEye.y+130), mPaint);
                mCanvas.drawOval(new RectF(rightEye.x-130, rightEye.y-130,
                        rightEye.x+130, rightEye.y+130), mPaint);



                mPaint.setColor(colorWhite);
                mCanvas.drawCircle(leftEye.x+50, leftEye.y+30, 20, mPaint);
                mCanvas.drawCircle(leftEye.x-40, leftEye.y-30, 65, mPaint);
                mCanvas.drawCircle(rightEye.x+50, rightEye.y+30, 20, mPaint);
                mCanvas.drawCircle(rightEye.x-40, rightEye.y-30, 65, mPaint);


                String text = "\n\n POV ketemu cewek terus stalk profilnya \uD83D\uDE3B";

                int widthz = (int) textPaint.measureText(text);
                StaticLayout staticLayout = new StaticLayout(text, textPaint, (int) widthz, Layout.Alignment.ALIGN_CENTER, 1.0f, 0, false);
                staticLayout.draw(mCanvas);
                break;
            case 2 :
                // untuk nutup tulisan aja
                mPaint.setColor(colorWhite);
                Path pathz  = new Path();
                pathz.setFillType(Path.FillType.EVEN_ODD);
                pathz.setFillType(Path.FillType.EVEN_ODD);
                pathz.lineTo(aa.x, aa.y);
                pathz.lineTo(bb.x, bb.y);
                pathz.lineTo(cc.x, cc.y);
                pathz.lineTo(dd.x, dd.y);
                pathz.lineTo(aa.x, aa.y);
                pathz.close();

                mCanvas.drawPath(pathz, mPaint);
                break;

            case 3 :
                // untuk nutup tulisan aja
                mPaint.setColor(colorWhite);
                pathz = new Path();
                pathz.setFillType(Path.FillType.EVEN_ODD);
                pathz.setFillType(Path.FillType.EVEN_ODD);
                pathz.lineTo(aa.x, aa.y);
                pathz.lineTo(bb.x, bb.y);
                pathz.lineTo(cc.x, cc.y);
                pathz.lineTo(dd.x, dd.y);
                pathz.lineTo(aa.x, aa.y);
                pathz.close();

                mCanvas.drawPath(pathz, mPaint);
                break;
            case 4:
                String texto = "\n\n Tapi";

                int width2= (int) textPaint.measureText(texto);
                StaticLayout staticLayout2 = new StaticLayout(texto, textPaint, (int) width2, Layout.Alignment.ALIGN_CENTER, 1.0f, 0, false);
                staticLayout2.draw(mCanvas);
                break;
            case 5:
                // untuk nutup tulisan aja
                mPaint.setColor(colorWhite);
                pathz = new Path();
                pathz.setFillType(Path.FillType.EVEN_ODD);
                pathz.setFillType(Path.FillType.EVEN_ODD);
                pathz.lineTo(aa.x, aa.y);
                pathz.lineTo(bb.x, bb.y);
                pathz.lineTo(cc.x, cc.y);
                pathz.lineTo(dd.x, dd.y);
                pathz.lineTo(aa.x, aa.y);
                pathz.close();

                mCanvas.drawPath(pathz, mPaint);
                break;
            case 6 :
                String texts = "\n\n Ternyata dah punya pacar";

                int width1= (int) textPaint.measureText(texts);
                StaticLayout staticLayout1 = new StaticLayout(texts, textPaint, (int) width1, Layout.Alignment.ALIGN_CENTER, 1.0f, 0, false);
                staticLayout1.draw(mCanvas);

                mPaint.setColor(biru);
                Path path  = new Path();
                path.setFillType(Path.FillType.EVEN_ODD);
                path.lineTo(a.x, a.y);
                path.lineTo(b.x, b.y);
                path.lineTo(c.x, c.y);
                path.lineTo(d.x, d.y);
                path.lineTo(a.x, a.y);
                path.close();

                path.lineTo(e.x, e.y);
                path.lineTo(f.x, f.y);
                path.lineTo(g.x, g.y);
                path.lineTo(h.x, h.y);
                path.lineTo(e.x, e.y);
                path.close();

//                path.lineTo(i.x, i.y);
//                path.lineTo(j.x, j.y);
//                path.lineTo(k.x, k.y);
//                path.lineTo(l.x, l.y);
//                path.lineTo(i.x, i.y);
//                path.close();
                mCanvas.drawPath(path, mPaint);

                mPaint.setColor(cokelat);Path paths  = new Path();
                path.setFillType(Path.FillType.EVEN_ODD);
                path.lineTo(i.x, i.y);
                path.lineTo(j.x, j.y);
                path.lineTo(k.x, k.y);
                path.lineTo(l.x, l.y);
                path.lineTo(i.x, i.y);
                path.close();

                mCanvas.drawPath(paths, mPaint);


                // Air mata bawah
                mPaint.setColor(biru);
                mCanvas.drawOval(new RectF(nangis.x-500, nangis.y-100, nangis.x+500, nangis.y+100), mPaint);
                break;


        }

        frameCount++;
        view.invalidate();

//        if (mOffset == OFFSET){
//            mBitmap = Bitmap.createBitmap(vWidth, vHeight, Bitmap.Config.ARGB_8888);
//            mImageView.setImageBitmap(mBitmap);
//            mCanvas = new Canvas(mBitmap);
//            mCanvas.drawColor(mColorBackground);
//            mCanvas.drawText(getString(R.string.keep_tapping), 100,100, mPaintText);
//            mOffset += OFFSET;
//        }
//        else {
//            if (mOffset < halfWidth && mOffset < halfHeight) {
//                mPaint.setColor(mColorRectangle - MULTIPLIER * mOffset);
//
//                mRect.set(mOffset, mOffset, vWidth - mOffset, vHeight - mOffset);
//                mCanvas.drawRect(mRect, mPaint);
//                mOffset += OFFSET;
//            }
//            else {
//                mPaint.setColor(mColorAccent - MULTIPLIER * OFFSET);
//                mCanvas.drawCircle(halfWidth, halfHeight, halfWidth/3, mPaint);
//                mOffset =+ OFFSET;
//
//
//                Point a = new Point(halfWidth, halfHeight - 200);
//                Point b = new Point(halfWidth + 200, halfHeight);
//                Point c = new Point(halfWidth + 250, halfHeight + 200);
//                Point d = new Point(halfWidth + 100, halfHeight + 200);
//                Point e = new Point(halfWidth, halfHeight + 75);
//                Point f = new Point(halfWidth - 100, halfHeight + 200);
//                Point g = new Point(halfWidth - 250, halfHeight + 200);
//                Point h = new Point(halfWidth - 200, halfHeight);
//
//
//                Path path  = new Path();
//                path.setFillType(Path.FillType.INVERSE_EVEN_ODD);
//                path.lineTo(a.x, a.y);
//                path.lineTo(b.x, b.y);
//                path.lineTo(c.x, c.y);
//                path.lineTo(d.x, d.y);
//                path.lineTo(e.x, e.y);
//                path.lineTo(f.x, f.y);
//                path.lineTo(g.x, g.y);
//                path.lineTo(h.x, h.y);
//                path.lineTo(a.x, a.y);
//                path.close();
//                mPaint.setColor(mColorRectangle - MULTIPLIER * OFFSET);
//
//                mCanvas.drawPath(path, mPaint);
////                String text = getString(R.string.done);
////                mPaintText.getTextBounds(text, 0, text.length(), mBounds);
////                int x = halfWidth - mBounds.centerX();
////                int y = halfHeight - mBounds.centerY();
////                mCanvas.drawText(text, x, y, mPaintText);
//            }
//        }
//
//        view.invalidate();
    }
}
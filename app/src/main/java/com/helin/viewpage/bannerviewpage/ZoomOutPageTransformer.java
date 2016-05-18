package com.helin.viewpage.bannerviewpage;

import android.support.v4.view.ViewPager.PageTransformer;
import android.util.Log;
import android.view.View;
/**
 * 
 * @author helin
 *
 */
public class ZoomOutPageTransformer implements PageTransformer {
	private static float MIN_SCALE = 0.85f;

	private static float MIN_ALPHA = 0.5f;

	@Override
	public void transformPage(View view, float position) {
		int pageWidth = view.getWidth();
		int pageHeight = view.getHeight();

		Log.d("postion",position+"");

		if (position < -1) {
			view.setAlpha(0.5f);
		} else if (position <= 1) {
			float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
			float vertMargin = pageHeight * (1 - scaleFactor) / 2;
			float horzMargin = pageWidth * (1 - scaleFactor) / 2;
			if (position < 0) {
				view.setTranslationX(horzMargin - vertMargin / 2);
			} else {
				view.setTranslationX(-horzMargin + vertMargin / 2);
			}
			view.setScaleX(scaleFactor);
			view.setScaleY(scaleFactor);
			view.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE)
					/ (1 - MIN_SCALE) * (1 - MIN_ALPHA));
		} else {
			view.setAlpha(0.5f);
		}
	}
}

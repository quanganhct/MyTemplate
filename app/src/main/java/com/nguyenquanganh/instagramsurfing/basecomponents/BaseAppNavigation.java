package com.nguyenquanganh.instagramsurfing.basecomponents;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.nguyenquanganh.instagramsurfing.R;


// TODO: Auto-generated Javadoc
/**
 * The Class BaseAppNavigation.
 */
public class BaseAppNavigation {

	/**
	 * Start activity.
	 * 
	 * @param mActivity
	 *            the m activity
	 * @param activity
	 *            the activity
	 * @param hasBack
	 *            : activity should add to navigation stack or not
	 */
	public static void startActivity(Activity mActivity, Class<?> activity,
			boolean hasBack) {

		if (mActivity.getClass().equals(activity)) {
			mActivity.onBackPressed();
			return;
		}

		Intent contact = new Intent(mActivity, activity);

		if (!hasBack) {
			contact.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
			mActivity.startActivity(contact);
			mActivity.finish();
		} else {
			mActivity.startActivity(contact);
		}

	}

	/**
	 * Start activity.
	 * 
	 * @param mActivity
	 *            the m activity
	 * @param activity
	 *            the activity
	 * @param extras
	 *            the extras
	 * @param hasBack
	 *            activity should add to navigation stack or not
	 */
	public static void startActivity(Activity mActivity, Class<?> activity,
			Bundle extras, boolean hasBack) {

		if (mActivity.getClass().equals(activity)) {
			mActivity.onBackPressed();
			return;
		}

		Intent intent = new Intent(mActivity, activity);
		intent.putExtras(extras);
		if (!hasBack) {
			intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
			mActivity.startActivity(intent);
			mActivity.finish();
		} else {
			mActivity.startActivity(intent);
		}
	}

	/**
	 * Adds the support fragment.
	 * 
	 * @param activity
	 *            the activity
	 * @param fragmentClass
	 *            the fragment class
	 * @param bundle
	 *            the bundle
	 * @param resId
	 *            the content resource Id
	 * @return the fragment
	 */
	public static Fragment addSupportFragment(FragmentActivity activity,
			Class<? extends Fragment> fragmentClass, Bundle bundle, int resId, boolean addToBackStack) {

		if (bundle == null) {
			bundle = new Bundle();
		}

		FragmentTransaction transaction = activity.getSupportFragmentManager()
				.beginTransaction();

		transaction.setCustomAnimations(R.anim.slide_in_left,
				R.anim.slide_out_left, R.anim.slide_in_right,
				R.anim.slide_out_right);

		Fragment fragment = Fragment.instantiate(activity,
				fragmentClass.getName(), bundle);
		transaction.add(resId, fragment, fragmentClass.getName());

		if( addToBackStack ){
			transaction.addToBackStack(fragmentClass.getName());
		}


		transaction.commit();

		return fragment;

	}

	/**
	 * Adds the support fragment.
	 * 
	 * @param activity
	 *            the activity
	 * @param fragment
	 *            the fragment
	 * @param resId
	 *            the content resource Id
	 * @return the fragment
	 */
	public static Fragment addSupportFragment(FragmentActivity activity,
			Fragment fragment, int resId, boolean addToBackStack) {

		FragmentTransaction transaction = activity.getSupportFragmentManager()
				.beginTransaction();

		transaction.setCustomAnimations(R.anim.slide_in_left,
				R.anim.slide_out_left, R.anim.slide_in_right,
				R.anim.slide_out_right);

		transaction.add(resId, fragment, fragment.getClass().getName());

		if( addToBackStack ){
			transaction.addToBackStack(activity.getClass().getName());
		}


		transaction.commit();

		return fragment;

	}

	/**
	 * Adds the support fragment slide up.
	 * 
	 * @param context
	 *            the context
	 * @param fragmentManager
	 *            the fragment manager
	 * @param fragment
	 *            the fragment
	 * @param resId
	 *            the content resource Id
	 */
	public static void addSupportFragmentSlideUp(Context context,
			FragmentManager fragmentManager, Fragment fragment, int resId, boolean addToBackStack) {

		FragmentTransaction transaction = fragmentManager.beginTransaction();

		transaction.setCustomAnimations(R.anim.slide_in_up,
				R.anim.slide_out_up, R.anim.slide_in_down,
				R.anim.slide_out_down);

		transaction.add(resId, fragment, fragment.getClass().getName());

		if( addToBackStack ){
			transaction.addToBackStack(fragment.getClass().getName());
		}


		transaction.commit();

	}

	/**
	 * Adds the support fragment slide up.
	 * 
	 * @param context
	 *            the context
	 * @param fragmentManager
	 *            the fragment manager
	 * @param fragmentClass
	 *            the fragment class
	 * @param bundle
	 *            the bundle
	 * @param resId
	 *            the content resource Id
	 * @return the fragment
	 */
	public static Fragment addSupportFragmentSlideUp(Context context,
			FragmentManager fragmentManager,
			Class<? extends Fragment> fragmentClass, Bundle bundle, int resId, boolean addToBackStack) {

		if (bundle == null) {
			bundle = new Bundle();
		}

		FragmentTransaction transaction = fragmentManager.beginTransaction();

		transaction.setCustomAnimations(R.anim.slide_in_up,
				R.anim.slide_out_up, R.anim.slide_in_down,
				R.anim.slide_out_down);

		Fragment fragment = Fragment.instantiate(context,
				fragmentClass.getName(), bundle);
		transaction.add(resId, fragment, fragmentClass.getName());
		if( addToBackStack ){
			transaction.addToBackStack(fragment.getClass().getName());
		}

		transaction.commit();

		return fragment;

	}

	/**
	 * Adds the fragment.
	 * 
	 * @param activity
	 *            the activity
	 * @param fragmentClass
	 *            the fragment class
	 * @param bundle
	 *            the bundle
	 * @param resId
	 *            the content resource Id
	 * @return the android.app. fragment
	 */
	public static android.app.Fragment addFragment(Activity activity,
			Class<? extends android.app.Fragment> fragmentClass, Bundle bundle,
			int resId, boolean addToBackStack) {

		if (bundle == null) {
			bundle = new Bundle();
		}

		android.app.Fragment fragment = android.app.Fragment.instantiate(
				activity, fragmentClass.getName(), bundle);

		android.app.FragmentTransaction transaction = activity.getFragmentManager().beginTransaction();

		transaction.add(resId, fragment, fragmentClass.getName());

		if( addToBackStack ){
			transaction.addToBackStack(fragment.getClass().getName());
		}

		return fragment;
	}

	/**
	 * Adds the support fragment.
	 * 
	 * @param activity
	 *            the activity
	 * @param fragmentClass
	 *            the fragment class
	 * @param bundle
	 *            the bundle
	 * @param resId
	 *            the content resource Id
	 * @return the fragment
	 */
	public static Fragment replaceSupportFragment(FragmentActivity activity,
			Class<? extends Fragment> fragmentClass, Bundle bundle, int resId, boolean addToBackStack ) {

		if (bundle == null) {
			bundle = new Bundle();
		}

		FragmentTransaction transaction = activity.getSupportFragmentManager()
				.beginTransaction();

		transaction.setCustomAnimations(R.anim.slide_in_left,
				R.anim.slide_out_left, R.anim.slide_in_right,
				R.anim.slide_out_right);

		Fragment fragment = Fragment.instantiate(activity,
				fragmentClass.getName(), bundle);
		transaction.replace(resId, fragment, fragmentClass.getName());

		if( addToBackStack ){
			transaction.addToBackStack(fragment.getClass().getName());
		}

		transaction.commit();

		return fragment;

	}

	/**
	 * Adds the support fragment.
	 * 
	 * @param activity
	 *            the activity
	 * @param fragment
	 *            the fragment
	 * @param resId
	 *            the content resource Id
	 * @return the fragment
	 */
	public static Fragment replaceSupportFragment(FragmentActivity activity,
			Fragment fragment, int resId, boolean addToBackStack) {

		FragmentTransaction transaction = activity.getSupportFragmentManager()
				.beginTransaction();

		transaction.setCustomAnimations(R.anim.slide_in_left,
				R.anim.slide_out_left, R.anim.slide_in_right,
				R.anim.slide_out_right);

		transaction.replace(resId, fragment, fragment.getClass().getName());

		if( addToBackStack ){
			transaction.addToBackStack(activity.getClass().getName());
		}

		transaction.commit();

		return fragment;

	}

	/**
	 * Adds the support fragment slide up.
	 * 
	 * @param context
	 *            the context
	 * @param fragmentManager
	 *            the fragment manager
	 * @param fragment
	 *            the fragment
	 * @param resId
	 *            the content resource Id
	 */
	public static void replaceSupportFragmentSlideUp(Context context,
			FragmentManager fragmentManager, Fragment fragment, int resId, boolean addToBackStack) {

		FragmentTransaction transaction = fragmentManager.beginTransaction();

		transaction.setCustomAnimations(R.anim.slide_in_up,
				R.anim.slide_out_up, R.anim.slide_in_down,
				R.anim.slide_out_down);

		transaction.replace(resId, fragment, fragment.getClass().getName());

		if( addToBackStack ){
			transaction.addToBackStack(fragment.getClass().getName());
		}

		transaction.commit();

	}

	/**
	 * Adds the support fragment slide up.
	 * 
	 * @param context
	 *            the context
	 * @param fragmentManager
	 *            the fragment manager
	 * @param fragmentClass
	 *            the fragment class
	 * @param bundle
	 *            the bundle
	 * @param resId
	 *            the content resource Id
	 * @return the fragment
	 */
	public static Fragment replaceSupportFragmentSlideUp(Context context,
			FragmentManager fragmentManager,
			Class<? extends Fragment> fragmentClass, Bundle bundle, int resId, boolean addToBackStack) {

		if (bundle == null) {
			bundle = new Bundle();
		}

		FragmentTransaction transaction = fragmentManager.beginTransaction();

		transaction.setCustomAnimations(R.anim.slide_in_up,
				R.anim.slide_out_up, R.anim.slide_in_down,
				R.anim.slide_out_down);

		Fragment fragment = Fragment.instantiate(context,
				fragmentClass.getName(), bundle);
		transaction.replace(resId, fragment, fragmentClass.getName());

		if( addToBackStack ){
			transaction.addToBackStack(fragmentClass.getName());
		}


		transaction.commit();

		return fragment;

	}

}
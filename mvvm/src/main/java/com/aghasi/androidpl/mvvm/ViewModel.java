package com.aghasi.androidpl.mvvm;


import android.app.Activity;
import android.app.Fragment;
import android.app.TaskStackBuilder;
import android.app.assist.AssistContent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;

public class ViewModel implements PageStateObserver {

    protected MvvmActivity _mvvmActivity;
    protected PageStateObservable _pageStat;

    public ViewModel(MvvmActivity mvvmActivity, PageStateObservable pageStat) {

        _mvvmActivity = mvvmActivity;
        _pageStat = pageStat;
    }

    @Override
    public void update(PageStateObservable observable, String statKey) {

    }

    protected void onRestart() {
    }

    public void onActivityReenter(int resultCode, Intent data) {
    }

    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
    }

    protected void onDestroy() {
    }

    protected void onPause() {
    }

    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
    }

    protected void onPostResume() {
    }

    protected void onResume() {
    }

    protected void onResumeFragments() {
    }

    protected void onStart() {
    }

    protected void onStop() {
    }

    protected void onUserLeaveHint() {
    }


    public void onAttachedToWindow() {
    }

    public void onAttachFragment(Fragment fragment) {
    }

    public void onAttachFragment(android.support.v4.app.Fragment fragment) {
    }

    public void onDetachedFromWindow() {
    }

    public void onEnterAnimationComplete() {
    }




    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    public boolean onContextItemSelected(MenuItem item) {
        return false;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return false;
    }

    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        return false;
    }

    public void onContextMenuClosed(Menu menu) {
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        return false;
    }

    public boolean onMenuOpened(int featureId, Menu menu) {
        return false;
    }

    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        return false;
    }

    public void onPanelClosed(int featureId, Menu menu) {
    }

    @Nullable
    public View onCreatePanelView(int featureId) {
        return null;
    }




    protected void onRestoreInstanceState(Bundle savedInstanceState) {
    }

    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    protected void onSaveInstanceState(Bundle outState) {
    }

    public void onStateNotSaved() {
    }

    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    }




    @Nullable
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {

        return null;
    }

    @Nullable
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int type) {
        return null;
    }

    public void onActionModeFinished(ActionMode mode) {
    }

    public void onActionModeStarted(ActionMode mode) {
    }

    @Nullable
    public android.support.v7.view.ActionMode onWindowStartingSupportActionMode(android.support.v7.view.ActionMode.Callback callback) {
        return null;
    }

    public void onSupportActionModeFinished(android.support.v7.view.ActionMode mode) {
    }

    public void onSupportActionModeStarted(android.support.v7.view.ActionMode mode) {
    }




    public boolean onGenericMotionEvent(MotionEvent event) {
        return false;
    }

    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        return false;
    }

    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        return false;
    }

    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        return false;
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return false;
    }

    public boolean onNavigateUp() {
        return false;
    }

    public boolean onNavigateUpFromChild(Activity child) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    public boolean onTrackballEvent(MotionEvent event) {
        return false;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return false;
    }

    public boolean onSupportNavigateUp() {
        return false;
    }

    public void onUserInteraction() {
    }

    public void onBackPressed() {
    }




    public boolean onSearchRequested() {
        return false;
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        return false;
    }




    public void onPrepareNavigateUpTaskStack(TaskStackBuilder builder) {
    }

    public void onCreateSupportNavigateUpTaskStack(android.support.v4.app.TaskStackBuilder builder) {
    }

    public void onPrepareSupportNavigateUpTaskStack(android.support.v4.app.TaskStackBuilder builder) {
    }

    public void onCreateNavigateUpTaskStack(TaskStackBuilder builder) {
    }




    public void onProvideAssistContent(AssistContent outContent) {
    }

    public void onProvideAssistData(Bundle data) {
    }

    public Uri onProvideReferrer() {
        return null;
    }




    protected void onChildTitleChanged(Activity childActivity, CharSequence title) {
    }

    public void onContentChanged() {
    }

    public void onConfigurationChanged(Configuration newConfig) {
    }

    protected void onTitleChanged(CharSequence title, int color) {
    }

    @Nullable
    public CharSequence onCreateDescription() {
        return null;
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
    }

    public void onWindowFocusChanged(boolean hasFocus) {
    }




    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
    }




    public void onLowMemory() {
    }

    public void onTrimMemory(int level) {
    }




    public void onVisibleBehindCanceled() {
    }

    protected void onNewIntent(Intent intent) {
    }

    public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
        return false;
    }

    protected void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {

    }


    ///////////////////////////////////////////////
    //////////////////////////////////////////////
    /////////////////////////////////////////////
    ////////////////////////////////////////////



    public void onFragmentDestroy() {
    }

    public void onFragmentDestroyView() {
    }

    public void onFragmentAttach(Context context) {
    }

    public void onFragmentStop() {
    }

    public void onFragmentViewCreated(View view, Bundle savedInstanceState) {
    }

    public void onFragmentStart() {
    }

    public void onFragmentResume() {
    }

    public void onFragmentPause() {
    }

    public void onFragmentInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
    }

    public void onFragmentDetach() {
    }

    public void onFragmentActivityCreated(Bundle savedInstanceState) {
    }

    public Animation onFragmentCreateAnimation(int transit, boolean enter, int nextAnim) {
        return null;
    }





    public void onFragmentViewStateRestored(Bundle savedInstanceState) {
    }

    public void onFragmentSaveInstanceState(Bundle outState) {
    }





    public boolean onFragmentContextItemSelected(MenuItem item) {
        return false;
    }

    public boolean onFragmentOptionsItemSelected(MenuItem item) {
        return false;
    }

    public void onFragmentCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
    }

    public void onFragmentCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    }

    public void onFragmentDestroyOptionsMenu() {
    }

    public void onFragmentOptionsMenuClosed(Menu menu) {
    }

    public void onFragmentPrepareOptionsMenu(Menu menu) {
    }





    public void onFragmentRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
    }

    public void onFragmentActivityResult(int requestCode, int resultCode, Intent data) {
    }



    public void onFragmentLowMemory() {
    }



    public void onFragmentConfigurationChanged(Configuration newConfig) {
    }

    public void onFragmentHiddenChanged(boolean hidden) {
    }
}

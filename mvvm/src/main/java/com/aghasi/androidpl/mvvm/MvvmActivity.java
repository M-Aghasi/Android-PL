package com.aghasi.androidpl.mvvm;


import android.app.Activity;
import android.app.Fragment;
import android.app.TaskStackBuilder;
import android.app.assist.AssistContent;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class MvvmActivity extends AppCompatActivity {

    protected List<ViewModel> _viewModels = new ArrayList<>();



    @Override
    protected void onRestart() {

        for (ViewModel vModel : _viewModels) {
            vModel.onRestart();
        }
        super.onRestart();
    }

    @Override
    public void onActivityReenter(int resultCode, Intent data) {

        for (ViewModel vModel : _viewModels) {
            vModel.onActivityReenter(resultCode, data);
        }
        super.onActivityReenter(resultCode, data);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {

        for (ViewModel vModel : _viewModels) {
            vModel.onPostCreate(savedInstanceState, persistentState);
        }
        super.onPostCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onDestroy() {

        for (ViewModel vModel : _viewModels) {
            vModel.onDestroy();
        }
        super.onDestroy();
    }

    @Override
    protected void onPause() {

        for (ViewModel vModel : _viewModels) {
            vModel.onPause();
        }
        super.onPause();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {

        for (ViewModel vModel : _viewModels) {
            vModel.onPostCreate(savedInstanceState);
        }
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onPostResume() {

        for (ViewModel vModel : _viewModels) {
            vModel.onPostResume();
        }
        super.onPostResume();
    }

    @Override
    protected void onResume() {

        for (ViewModel vModel : _viewModels) {
            vModel.onResume();
        }
        super.onResume();
    }

    @Override
    protected void onResumeFragments() {

        for (ViewModel vModel : _viewModels) {
            vModel.onResumeFragments();
        }
        super.onResumeFragments();
    }

    @Override
    protected void onStart() {

        for (ViewModel vModel : _viewModels) {
            vModel.onStart();
        }
        super.onStart();
    }

    @Override
    protected void onStop() {

        for (ViewModel vModel : _viewModels) {
            vModel.onStop();
        }
        super.onStop();
    }

    @Override
    protected void onUserLeaveHint() {

        for (ViewModel vModel : _viewModels) {
            vModel.onUserLeaveHint();
        }
        super.onUserLeaveHint();
    }

    @Override
    public void onAttachedToWindow() {

        for (ViewModel vModel : _viewModels) {
            vModel.onAttachedToWindow();
        }
        super.onAttachedToWindow();
    }

    @Override
    public void onAttachFragment(Fragment fragment) {

        for (ViewModel vModel : _viewModels) {
            vModel.onAttachFragment(fragment);
        }
        super.onAttachFragment(fragment);
    }

    @Override
    public void onAttachFragment(android.support.v4.app.Fragment fragment) {

        for (ViewModel vModel : _viewModels) {
            vModel.onAttachFragment(fragment);
        }
        super.onAttachFragment(fragment);
    }

    @Override
    public void onDetachedFromWindow() {

        for (ViewModel vModel : _viewModels) {
            vModel.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override
    public void onEnterAnimationComplete() {

        for (ViewModel vModel : _viewModels) {
            vModel.onEnterAnimationComplete();
        }
        super.onEnterAnimationComplete();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        for (ViewModel vModel : _viewModels) {
            boolean res = vModel.onCreateOptionsMenu(menu);
            if(res) {
                return true;
            }
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        for (ViewModel vModel : _viewModels) {
            boolean res = vModel.onContextItemSelected(item);
            if(res) {
                return true;
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        for (ViewModel vModel : _viewModels) {
            boolean res = vModel.onOptionsItemSelected(item);
            if(res) {
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        for (ViewModel vModel : _viewModels) {
            boolean res = vModel.onPrepareOptionsMenu(menu);
            if(res) {
                return true;
            }
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {

        for (ViewModel vModel : _viewModels) {
            boolean res = vModel.onPrepareOptionsPanel(view, menu);
            if(res) {
                return true;
            }
        }
        return super.onPrepareOptionsPanel(view, menu);
    }

    @Override
    public void onContextMenuClosed(Menu menu) {

        for (ViewModel vModel : _viewModels) {
            vModel.onContextMenuClosed(menu);
        }
        super.onContextMenuClosed(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        for (ViewModel vModel : _viewModels) {
            vModel.onCreateContextMenu(menu, v, menuInfo);
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {

        for (ViewModel vModel : _viewModels) {
            vModel.onOptionsMenuClosed(menu);
        }
        super.onOptionsMenuClosed(menu);
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {

        for (ViewModel vModel : _viewModels) {
            boolean res = vModel.onCreatePanelMenu(featureId, menu);
            if(res) {
                return true;
            }
        }
        return super.onCreatePanelMenu(featureId, menu);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {

        for (ViewModel vModel : _viewModels) {
            boolean res = vModel.onMenuOpened(featureId, menu);
            if(res) {
                return true;
            }
        }
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public boolean onPreparePanel(int featureId, View view, Menu menu) {

        for (ViewModel vModel : _viewModels) {
            boolean res = vModel.onPreparePanel(featureId, view, menu);
            if(res) {
                return true;
            }
        }
        return super.onPreparePanel(featureId, view, menu);
    }

    @Override
    public void onPanelClosed(int featureId, Menu menu) {

        for (ViewModel vModel : _viewModels) {
            vModel.onPanelClosed(featureId, menu);
        }
        super.onPanelClosed(featureId, menu);
    }

    @Nullable
    @Override
    public View onCreatePanelView(int featureId) {

        for (ViewModel vModel : _viewModels) {
            View res = vModel.onCreatePanelView(featureId);
            if(res != null) {
                return res;
            }
        }
        return super.onCreatePanelView(featureId);
    }




    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        for (ViewModel vModel : _viewModels) {
            vModel.onRestoreInstanceState(savedInstanceState);
        }
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {

        for (ViewModel vModel : _viewModels) {
            vModel.onRestoreInstanceState(savedInstanceState, persistentState);
        }
        super.onRestoreInstanceState(savedInstanceState, persistentState);
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {

        for (ViewModel vModel : _viewModels) {
            Object res = vModel.onRetainCustomNonConfigurationInstance();
            if(res != null) {
                return res;
            }
        }
        return super.onRetainCustomNonConfigurationInstance();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        for (ViewModel vModel : _viewModels) {
            vModel.onSaveInstanceState(outState);
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onStateNotSaved() {

        for (ViewModel vModel : _viewModels) {
            vModel.onStateNotSaved();
        }
        super.onStateNotSaved();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {

        for (ViewModel vModel : _viewModels) {
            vModel.onSaveInstanceState(outState, outPersistentState);
        }
        super.onSaveInstanceState(outState, outPersistentState);
    }




    @Nullable
    @Override
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {

        for (ViewModel vModel : _viewModels) {
            ActionMode res = vModel.onWindowStartingActionMode(callback);
            if(res != null) {
                return res;
            }
        }
        return super.onWindowStartingActionMode(callback);
    }

    @Nullable
    @Override
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int type) {

        for (ViewModel vModel : _viewModels) {
            ActionMode res = vModel.onWindowStartingActionMode(callback, type);
            if(res != null) {
                return res;
            }
        }
        return super.onWindowStartingActionMode(callback, type);
    }

    @Override
    public void onActionModeFinished(ActionMode mode) {

        for (ViewModel vModel : _viewModels) {
            vModel.onActionModeFinished(mode);
        }
        super.onActionModeFinished(mode);
    }

    @Override
    public void onActionModeStarted(ActionMode mode) {

        for (ViewModel vModel : _viewModels) {
            vModel.onActionModeStarted(mode);
        }
        super.onActionModeStarted(mode);
    }

    @Nullable
    @Override
    public android.support.v7.view.ActionMode onWindowStartingSupportActionMode(android.support.v7.view.ActionMode.Callback callback) {

        for (ViewModel vModel : _viewModels) {
            android.support.v7.view.ActionMode res = vModel.onWindowStartingSupportActionMode(callback);
            if(res != null) {
                return res;
            }
        }
        return super.onWindowStartingSupportActionMode(callback);
    }

    @Override
    public void onSupportActionModeFinished(android.support.v7.view.ActionMode mode) {

        for (ViewModel vModel : _viewModels) {
            vModel.onSupportActionModeFinished(mode);
        }
        super.onSupportActionModeFinished(mode);
    }

    @Override
    public void onSupportActionModeStarted(android.support.v7.view.ActionMode mode) {

        for (ViewModel vModel : _viewModels) {
            vModel.onSupportActionModeStarted(mode);
        }
        super.onSupportActionModeStarted(mode);
    }




    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {

        for (ViewModel vModel : _viewModels) {
            boolean res = vModel.onGenericMotionEvent(event);
            if(res) {
                return true;
            }
        }
        return super.onGenericMotionEvent(event);
    }

    @Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {

        for (ViewModel vModel : _viewModels) {
            boolean res = vModel.onKeyShortcut(keyCode, event);
            if(res) {
                return true;
            }
        }
        return super.onKeyShortcut(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {

        for (ViewModel vModel : _viewModels) {
            boolean res = vModel.onKeyLongPress(keyCode, event);
            if(res) {
                return true;
            }
        }
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {

        for (ViewModel vModel : _viewModels) {
            boolean res = vModel.onKeyMultiple(keyCode, repeatCount, event);
            if(res) {
                return true;
            }
        }
        return super.onKeyMultiple(keyCode, repeatCount, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        for (ViewModel vModel : _viewModels) {
            boolean res = vModel.onKeyUp(keyCode, event);
            if(res) {
                return true;
            }
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onNavigateUp() {

        for (ViewModel vModel : _viewModels) {
            boolean res = vModel.onNavigateUp();
            if(res) {
                return true;
            }
        }
        return super.onNavigateUp();
    }

    @Override
    public boolean onNavigateUpFromChild(Activity child) {

        for (ViewModel vModel : _viewModels) {
            boolean res = vModel.onNavigateUpFromChild(child);
            if(res) {
                return true;
            }
        }
        return super.onNavigateUpFromChild(child);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        for (ViewModel vModel : _viewModels) {
            boolean res = vModel.onTouchEvent(event);
            if(res) {
                return true;
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event) {

        for (ViewModel vModel : _viewModels) {
            boolean res = vModel.onTrackballEvent(event);
            if(res) {
                return true;
            }
        }
        return super.onTrackballEvent(event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        for (ViewModel vModel : _viewModels) {
            boolean res = vModel.onKeyDown(keyCode, event);
            if(res) {
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onSupportNavigateUp() {

        for (ViewModel vModel : _viewModels) {
            boolean res = vModel.onSupportNavigateUp();
            if(res) {
                return true;
            }
        }
        return super.onSupportNavigateUp();
    }

    @Override
    public void onUserInteraction() {

        for (ViewModel vModel : _viewModels) {
            vModel.onUserInteraction();
        }
        super.onUserInteraction();
    }

    @Override
    public void onBackPressed() {

        for (ViewModel vModel : _viewModels) {
            vModel.onBackPressed();
        }
    }

    public void defaultOnBackPressed() {

        super.onBackPressed();
    }




    @Override
    public boolean onSearchRequested() {

        for (ViewModel vModel : _viewModels) {
            boolean res = vModel.onSearchRequested();
            if(res) {
                return true;
            }
        }
        return super.onSearchRequested();
    }

    @Override
    public boolean onSearchRequested(SearchEvent searchEvent) {

        for (ViewModel vModel : _viewModels) {
            boolean res = vModel.onSearchRequested(searchEvent);
            if(res) {
                return true;
            }
        }
        return super.onSearchRequested(searchEvent);
    }




    @Override
    public void onPrepareNavigateUpTaskStack(TaskStackBuilder builder) {

        for (ViewModel vModel : _viewModels) {
            vModel.onPrepareNavigateUpTaskStack(builder);
        }
        super.onPrepareNavigateUpTaskStack(builder);
    }

    @Override
    public void onCreateSupportNavigateUpTaskStack(android.support.v4.app.TaskStackBuilder builder) {

        for (ViewModel vModel : _viewModels) {
            vModel.onCreateSupportNavigateUpTaskStack(builder);
        }
        super.onCreateSupportNavigateUpTaskStack(builder);
    }

    @Override
    public void onPrepareSupportNavigateUpTaskStack(android.support.v4.app.TaskStackBuilder builder) {

        for (ViewModel vModel : _viewModels) {
            vModel.onPrepareSupportNavigateUpTaskStack(builder);
        }
        super.onPrepareSupportNavigateUpTaskStack(builder);
    }

    @Override
    public void onCreateNavigateUpTaskStack(TaskStackBuilder builder) {

        for (ViewModel vModel : _viewModels) {
            vModel.onCreateNavigateUpTaskStack(builder);
        }
        super.onCreateNavigateUpTaskStack(builder);
    }




    @Override
    public void onProvideAssistContent(AssistContent outContent) {

        for (ViewModel vModel : _viewModels) {
            vModel.onProvideAssistContent(outContent);
        }
        super.onProvideAssistContent(outContent);
    }

    @Override
    public void onProvideAssistData(Bundle data) {

        for (ViewModel vModel : _viewModels) {
            vModel.onProvideAssistData(data);
        }
        super.onProvideAssistData(data);
    }

    @Override
    public Uri onProvideReferrer() {

        for (ViewModel vModel : _viewModels) {
            Uri res = vModel.onProvideReferrer();
            if(res != null) {
                return res;
            }
        }
        return super.onProvideReferrer();
    }




    @Override
    protected void onChildTitleChanged(Activity childActivity, CharSequence title) {

        for (ViewModel vModel : _viewModels) {
            vModel.onChildTitleChanged(childActivity, title);
        }
        super.onChildTitleChanged(childActivity, title);
    }

    @Override
    public void onContentChanged() {

        for (ViewModel vModel : _viewModels) {
            vModel.onContentChanged();
        }
        super.onContentChanged();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

        for (ViewModel vModel : _viewModels) {
            vModel.onConfigurationChanged(newConfig);
        }
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {

        for (ViewModel vModel : _viewModels) {
            vModel.onTitleChanged(title, color);
        }
        super.onTitleChanged(title, color);
    }

    @Nullable
    @Override
    public CharSequence onCreateDescription() {

        for (ViewModel vModel : _viewModels) {
            vModel.onCreateDescription();
        }
        return super.onCreateDescription();
    }

    @Override
    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {

        for (ViewModel vModel : _viewModels) {
            vModel.onWindowAttributesChanged(params);
        }
        super.onWindowAttributesChanged(params);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

        for (ViewModel vModel : _viewModels) {
            vModel.onWindowFocusChanged(hasFocus);
        }
        super.onWindowFocusChanged(hasFocus);
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        for (ViewModel vModel : _viewModels) {
            vModel.onActivityResult(requestCode, resultCode, data);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        for (ViewModel vModel : _viewModels) {
            vModel.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }




    @Override
    public void onLowMemory() {

        for (ViewModel vModel : _viewModels) {
            vModel.onLowMemory();
        }
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {

        for (ViewModel vModel : _viewModels) {
            vModel.onTrimMemory(level);
        }
        super.onTrimMemory(level);
    }




    @Override
    public void onVisibleBehindCanceled() {

        for (ViewModel vModel : _viewModels) {
            vModel.onVisibleBehindCanceled();
        }
        super.onVisibleBehindCanceled();
    }

    @Override
    protected void onNewIntent(Intent intent) {

        for (ViewModel vModel : _viewModels) {
            vModel.onNewIntent(intent);
        }
        super.onNewIntent(intent);
    }

    @Override
    public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {

        for (ViewModel vModel : _viewModels) {
            boolean res = vModel.onCreateThumbnail(outBitmap, canvas);
            if(res) {
                return true;
            }
        }
        return super.onCreateThumbnail(outBitmap, canvas);
    }

    @Override
    protected void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {

        for (ViewModel vModel : _viewModels) {
            vModel.onApplyThemeResource(theme, resid, first);
        }
        super.onApplyThemeResource(theme, resid, first);
    }
}

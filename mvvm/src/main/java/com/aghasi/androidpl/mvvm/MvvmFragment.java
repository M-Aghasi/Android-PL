package com.aghasi.androidpl.mvvm;


import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;


public class MvvmFragment extends Fragment {

    protected ViewModel _viewModel;



    @Override
    public void onDestroy() {

        _viewModel.onFragmentDestroy();
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {

        _viewModel.onFragmentDestroyView();
        super.onDestroyView();
    }

    @Override
    public void onAttach(Context context) {

        _viewModel.onFragmentAttach(context);
        super.onAttach(context);
    }

    @Override
    public void onStop() {

        _viewModel.onFragmentStop();
        super.onStop();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        _viewModel.onFragmentViewCreated(view, savedInstanceState);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {

        _viewModel.onFragmentStart();
        super.onStart();
    }

    @Override
    public void onResume() {

        _viewModel.onFragmentResume();
        super.onResume();
    }

    @Override
    public void onPause() {

        _viewModel.onFragmentPause();
        super.onPause();
    }

    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {

        _viewModel.onFragmentInflate(context, attrs, savedInstanceState);
        super.onInflate(context, attrs, savedInstanceState);
    }

    @Override
    public void onDetach() {

        _viewModel.onFragmentDetach();
        super.onDetach();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        _viewModel.onFragmentActivityCreated(savedInstanceState);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {

        Animation res = _viewModel.onFragmentCreateAnimation(transit, enter, nextAnim);
        if(res != null) {
            return res;
        }
        return super.onCreateAnimation(transit, enter, nextAnim);
    }





    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {

        _viewModel.onFragmentViewStateRestored(savedInstanceState);
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        _viewModel.onFragmentSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }





    @Override
    public boolean onContextItemSelected(MenuItem item) {

        boolean res = _viewModel.onFragmentContextItemSelected(item);

        return res || super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        boolean res = _viewModel.onFragmentOptionsItemSelected(item);
        return res || super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        _viewModel.onFragmentCreateContextMenu(menu, v, menuInfo);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        _viewModel.onFragmentCreateOptionsMenu(menu, inflater);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onDestroyOptionsMenu() {

        _viewModel.onFragmentDestroyOptionsMenu();
        super.onDestroyOptionsMenu();
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {

        _viewModel.onFragmentOptionsMenuClosed(menu);
        super.onOptionsMenuClosed(menu);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {

        _viewModel.onFragmentPrepareOptionsMenu(menu);
        super.onPrepareOptionsMenu(menu);
    }





    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        _viewModel.onFragmentRequestPermissionsResult(requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        _viewModel.onFragmentActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }



    @Override
    public void onLowMemory() {

        _viewModel.onFragmentLowMemory();
        super.onLowMemory();
    }



    @Override
    public void onConfigurationChanged(Configuration newConfig) {

        _viewModel.onFragmentConfigurationChanged(newConfig);
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {

        _viewModel.onFragmentHiddenChanged(hidden);
        super.onHiddenChanged(hidden);
    }
}

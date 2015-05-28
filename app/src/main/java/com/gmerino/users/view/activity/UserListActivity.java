package com.gmerino.users.view.activity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SearchView;

import com.gmerino.users.R;
import com.gmerino.users.view.fragment.UserListFragment;

import java.util.ArrayList;
import java.util.List;


public class UserListActivity extends BaseActivity
        implements SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = UserListActivity.class.getCanonicalName();
    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

//    private boolean firstTime = true;

    private SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        swipeLayout.setOnRefreshListener(this);
        swipeLayout.setColorScheme(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        if (findViewById(R.id.user_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((UserListFragment) getFragmentManager()
                    .findFragmentById(R.id.user_list))
                    .setActivateOnItemClick(true);
        }

        handleIntent(getIntent());
    }

    @Override
    protected List<Object> getModules() {
        return new ArrayList<>();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

//        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
//            String query = intent.getStringExtra(SearchManager.QUERY);
//            Log.d(TAG, "Searching " + query);
//            UserHandler.getInstance().setFilter(query);
//        }
    }

//    @Override
//    public void onItemSelected(String id) {
//        if (mTwoPane) {
//            // In two-pane mode, show the detail view in this activity by
//            // adding or replacing the detail fragment using a
//            // fragment transaction.
////            Bundle arguments = new Bundle();
////            arguments.putString(UserDetailFragment.ARG_ITEM_ID, id);
//            UserDetailFragment fragment = new UserDetailFragment();
////            fragment.setArguments(arguments);
//            getFragmentManager().beginTransaction()
//                    .replace(R.id.user_detail_container, fragment)
//                    .commit();
//
//        } else {
//            // In single-pane mode, simply start the detail activity
//            // for the selected item ID.
//            Intent detailIntent = new Intent(this, UserDetailActivity.class);
////            detailIntent.putExtra(UserDetailFragment.ARG_ITEM_ID, id);
//            startActivity(detailIntent);
//        }
//    }

//    @Override
//    public void onFragmentAttached() {
//        if (firstTime) {
//            refresh();
//        }
//    }

//    private void refresh() {
//        firstTime = false;
//        UserHandler.getInstance().populate(40);
//    }

    @Override
    public void onRefresh() {
//        UserHandler.getInstance().setFilter("");
//        refresh();
//
//        swipeLayout.setRefreshing(false);
//        Toast.makeText(this, getString(R.string.update_info),
//                Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }
}
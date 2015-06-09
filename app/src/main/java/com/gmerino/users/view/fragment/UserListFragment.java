package com.gmerino.users.view.fragment;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.domain.user.data.User;
import com.gmerino.users.R;
import com.gmerino.users.presenter.UserListPresenter;
import com.gmerino.users.view.ProgressView;
import com.gmerino.users.view.adapter.UserAdapter;

import java.util.List;

import javax.inject.Inject;

/*
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * A list fragment representing a list of Users. This fragment
 * also supports tablet devices by allowing list items to be given an
 * 'activated' state upon selection. This helps indicate which item is
 * currently being viewed in a {@link UserDetailFragment}.
 */
public class UserListFragment extends ListFragment implements UserListView, ProgressView {

    private static final String TAG = UserListFragment.class.getCanonicalName();

    @Inject
    UserListPresenter presenter;

    /**
     * The serialization (saved instance state) Bundle key representing the
     * activated item position. Only used on tablets.
     */
    private static final String STATE_ACTIVATED_POSITION = "activated_position";

    //
//    /**
//     * The fragment's current callback object, which is notified of list item
//     * clicks.
//     */
    private Callback callback = null;
//
    /**
     * The current activated item position. Only used on tablets.
     */
    private int mActivatedPosition = ListView.INVALID_POSITION;

    private UserAdapter adapter;

    private FragmentInjector injector = new FragmentInjector(this);

    @Override
    public void showProgress() {
        callback.showProgress(true);
    }

    @Override
    public void dismissProgress() {
        callback.showProgress(false);
    }
//
//    @Override
//    public void update(Observable observable, Object data) {
//        //Let's reload the data...
//        Log.d(TAG, "Reloading data");
//        adapter.setUsers(UserHandler.getInstance().getUserList(), UserHandler.getInstance().getDeletedUsers());
//        adapter.notifyDataSetChanged();
//    }
//

    /**
     * A callback interface that all activities containing this fragment must
     * implement. This mechanism allows activities to be notified of item
     * selections.
     */
    public interface Callback {
        /**
         * Callback for when an item has been selected.
         */
        void onItemSelected(String id);

        void showProgress(boolean show);
    }
//
//    /**
//     * A dummy implementation of the {@link Callback} interface that does
//     * nothing. Used only when this fragment is not attached to an activity.
//     */
//    private static Callback sDummyCallbacks = new Callback() {
//        @Override
//        public void onItemSelected(String id) {
//        }
//
//        @Override
//        public void onFragmentAttached() {
//
//        }
//    };
//

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public UserListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

////        adapter = new UserAdapter(getActivity(), R.id.user_list, UserHandler.getInstance().getUserList());
        adapter = new UserAdapter(getActivity(), R.id.user_list);

        presenter.setView(this);
        presenter.setProgressView(this);

        setListAdapter(adapter);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Restore the previously serialized activated item position.
        if (savedInstanceState != null
                && savedInstanceState.containsKey(STATE_ACTIVATED_POSITION)) {
            setActivatedPosition(savedInstanceState.getInt(STATE_ACTIVATED_POSITION));
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        injector.attemptFragmentInjection();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        injector.attemptFragmentInjection();
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        super.onListItemClick(listView, view, position, id);

        Log.d(TAG, "onListItemClick");

        // Notify the active callbacks interface (the activity, if the
        // fragment is attached to one) that an item has been selected.
        callback.onItemSelected(((User) listView.getAdapter().getItem(position)).getMd5());
//        presenter.onUserClicked((User) listView.getAdapter().getItem(position));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mActivatedPosition != ListView.INVALID_POSITION) {
            // Serialize and persist the activated item position.
            outState.putInt(STATE_ACTIVATED_POSITION, mActivatedPosition);
        }
    }

    /**
     * Turns on activate-on-click mode. When this mode is on, list items will be
     * given the 'activated' state when touched.
     */
    public void setActivateOnItemClick(boolean activateOnItemClick) {
        // When setting CHOICE_MODE_SINGLE, ListView will automatically
        // give items the 'activated' state when touched.
        getListView().setChoiceMode(activateOnItemClick
                ? ListView.CHOICE_MODE_SINGLE
                : ListView.CHOICE_MODE_NONE);
    }

    private void setActivatedPosition(int position) {
        if (position == ListView.INVALID_POSITION) {
            getListView().setItemChecked(mActivatedPosition, false);
        } else {
            getListView().setItemChecked(position, true);
        }

        mActivatedPosition = position;
    }

    @Override
    public void onUsersLoaded(List<User> users) {
        adapter.updateUsers(users, null);
        adapter.notifyDataSetChanged();
    }

    public void setCallback(Callback callback){
        this.callback = callback;
    }

    public void refresh(){
        presenter.loadUsers();
    }
}

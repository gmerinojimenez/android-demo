package com.gmerino.users.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.domain.user.data.User;
import com.gmerino.users.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserAdapter extends ArrayAdapter<User> {

    private Activity activity;
    private List<User> users = new ArrayList<>();


    public UserAdapter(Activity activity, int layoutResourceId, List<User> data) {
        super(activity, layoutResourceId, data);
        this.activity = activity;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    public void setUsers(List<User> userList, Map<String, User> deleted) {
        this.users.clear();
        for (User user : userList) {
            if (!deleted.containsKey(user.getMd5()) &&
                    (!UserHandler.getInstance().shouldFilter() || user.getName().toString().toLowerCase().contains(UserHandler.getInstance().getFilter().toLowerCase()))) {
                this.users.add(user);
            }
        }

    }


    private class ViewHolder {
        public TextView name;
        public TextView email;
        public TextView phone;
        public ImageView picture;
        public CheckBox starred;
        public Button delete;
    }


//    @Override
//    public void registerDataSetObserver(DataSetObserver observer) {
//        Log.d("borrame", "registerDataSetObserver");
//    }
//
//    @Override
//    public void unregisterDataSetObserver(DataSetObserver observer) {
//        Log.d("borrame", "unregisterDataSetObserver");
//    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public User getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

//    @Override
//    public boolean hasStableIds() {
//        return false;
//    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View ret = convertView;
        ViewHolder holder;
        if (ret == null) { // Inflate the view and set attributes
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.row_user, parent, false);

            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.email = (TextView) convertView.findViewById(R.id.email);
            holder.phone = (TextView) convertView.findViewById(R.id.phone);
            holder.picture = (ImageView) convertView.findViewById(R.id.picture);
            holder.starred = (CheckBox) convertView.findViewById(R.id.starred);
            holder.delete = (Button) convertView.findViewById(R.id.delete);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) ret.getTag();
        }

        final User user = (User) getItem(position);

        if (user != null) {

            holder.name.setText(user.getName().toString());
            holder.email.setText(user.getEmail());
            holder.phone.setText(user.getPhone());

            SetImageRunnable aux = new SetImageRunnable(user.getPicture().getThumbnail(), holder.picture);
            Thread t = new Thread(aux);
            t.start();

            holder.starred.setChecked(UserHandler.getInstance().isUserStarred(user));

            //This should be on viewholder
            holder.starred.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    UserHandler.getInstance().addStarred(user, isChecked);
                }
            });

            //This should be on viewholder
            holder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    UserHandler.getInstance().removeUser(user);
                }
            });
        }

        return convertView;
    }


//    @Override
//    public int getItemViewType(int position) {
//        return 1;
//    }
//
//    @Override
//    public int getViewTypeCount() {
//        return 1;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return users.size() == 0;
//    }


}
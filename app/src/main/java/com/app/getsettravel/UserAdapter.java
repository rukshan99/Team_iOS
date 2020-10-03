package com.app.getsettravel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.app.getsettravel.Database.UserDBHelper;
import com.app.getsettravel.model.User;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {

    private Context mContext;
    UserDBHelper userDbHelper;

    ArrayList<User> arrayList;
    /*
    private ArrayList<String> Id = new ArrayList<String>();
    private ArrayList<String> Name = new ArrayList<String>();
    private ArrayList<String> Mail = new ArrayList<String>();
    private ArrayList<String> Phone = new ArrayList<String>();
    private ArrayList<String> Address = new ArrayList<String>();


     */

    public UserAdapter(Context  context, ArrayList<User> arrayList) {

        this.mContext = context;
        this.arrayList = arrayList;

    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       /* final    viewHolder holder;*/
        userDbHelper =new UserDBHelper(mContext);
        LayoutInflater layoutInflater;

            layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.activity_users, null);

            TextView t1 = (TextView) convertView.findViewById(R.id.Aname);
            TextView t2 = (TextView) convertView.findViewById(R.id.Aemail);
            TextView t3 = (TextView) convertView.findViewById(R.id.Aaddress);
            TextView t4 = (TextView) convertView.findViewById(R.id.Aphone);


            User user = arrayList.get(position);

            t1.setText(user.getName());
            t2.setText(user.getEmail());
            t3.setText(user.getAdd());
            t4.setText(user.getPhone());

        return convertView;
    }
    /*
    public class viewHolder {

        TextView id;
        TextView name;
        TextView mail;
        TextView phone;
        TextView Address;
    }*/

}

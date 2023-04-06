package com.example.homework2472;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class DashboardActivity extends AppCompatActivity {

    LinearLayout main_back;
    ListView listView;
    HashMap <String, String> hashMap;
    ArrayList < HashMap <String, String> > arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        main_back = findViewById(R.id.main_back);
        listView = findViewById(R.id.listView);


        //////////////////////////////////////////////////////////////////////////




        if (!CheckInternet()){

            Dialog dialog = new Dialog(DashboardActivity.this);
            dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.getWindow().getAttributes().windowAnimations
                    = android.R.style.Animation_Dialog;

            dialog.setContentView(R.layout.no_internet);
            dialog.setCancelable(false);
            ImageView retry;
            retry = dialog.findViewById(R.id.retry);

            retry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recreate();
                }
            });
            dialog.show();

        }








        createTable();

        myAdaptar adaptar = new myAdaptar();
        listView.setAdapter(adaptar);




    }///////////////////////////////////////////////////////////////////


    //listview custom adapter=========================================

    public class myAdaptar extends BaseAdapter{
        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView = layoutInflater.inflate(R.layout.album_list, parent, false);

            ////////id///////////
            ImageView artistIMG = myView.findViewById(R.id.artistIMG);
            TextView artistName = myView.findViewById(R.id.artistName);
            TextView artistDes = myView.findViewById(R.id.artistDes);
            LinearLayout albumlly = myView.findViewById(R.id.albumlly);
            ////////id end///////


            hashMap = arrayList.get(position);

            String artistImg = hashMap.get("img");
            String aName = hashMap.get("name");
            String aDes = hashMap.get("des");

            //////////add data//////
            Picasso.get().load(artistImg).placeholder(R.drawable.load).into(artistIMG);
            artistName.setText(aName);
            artistDes.setText(aDes);
            //////add data end//////

            /////////////////new activity///////////////
            albumlly.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //
                    if (aName.contains("Arijit Singh")){

                        SongListActivity.singerTopName = aName;
                        Bitmap bitmap =( (BitmapDrawable) artistIMG.getDrawable() ).getBitmap();
                        SongListActivity.MY_BITMAP = bitmap;

                        startActivity(new Intent(DashboardActivity.this, SongListActivity.class));

                    } else if (aName.contains("Atif Aslam")) {

                        SongListActivity.singerTopName = aName;
                        Bitmap bitmap =( (BitmapDrawable) artistIMG.getDrawable() ).getBitmap();
                        SongListActivity.MY_BITMAP = bitmap;

                        startActivity(new Intent(DashboardActivity.this, SongListActivity.class));

                    }else if (aName.contains("Jubin Nautiyal")) {

                        SongListActivity.singerTopName = aName;
                        Bitmap bitmap =( (BitmapDrawable) artistIMG.getDrawable() ).getBitmap();
                        SongListActivity.MY_BITMAP = bitmap;

                        startActivity(new Intent(DashboardActivity.this, SongListActivity.class));

                    }else if (aName.contains("Imran Khan")) {

                        SongListActivity.singerTopName = aName;
                        Bitmap bitmap =( (BitmapDrawable) artistIMG.getDrawable() ).getBitmap();
                        SongListActivity.MY_BITMAP = bitmap;

                        startActivity(new Intent(DashboardActivity.this, SongListActivity.class));

                    }else if (aName.contains("Javed Ali")) {

                        SongListActivity.singerTopName = aName;
                        Bitmap bitmap =( (BitmapDrawable) artistIMG.getDrawable() ).getBitmap();
                        SongListActivity.MY_BITMAP = bitmap;

                        startActivity(new Intent(DashboardActivity.this, SongListActivity.class));

                    }
                    //
                }
            });
            /////////////////new activity end///////////

            return myView;
        }
    }

    //listview custom adapter end=====================================


    //hasmap mathod===================================================

    public void createTable(){

        hashMap = new HashMap<>();
        hashMap.put("img", "https://static.toiimg.com/thumb/msid-96585261,width-400,resizemode-4/96585261.jpg");
        hashMap.put("name", "Arijit Singh");
        hashMap.put("des", "Arijit Singh is most popular singer in India");
        arrayList.add(hashMap);
        //
        hashMap = new HashMap<>();
        hashMap.put("img", "https://timesofindia.indiatimes.com/thumb/msid-80172462,width-1200,height-900,resizemode-4/.jpg");
        hashMap.put("name", "Atif Aslam");
        hashMap.put("des", "Atif Aslam is most popular singer in Pakistan");
        arrayList.add(hashMap);
        //
        hashMap = new HashMap<>();
        hashMap.put("img", "https://filmfare.wwmindia.com/thumb/content/2022/jun/toptensongsofjubinnautiyalyoumustlistentoonhisbirthday11655189119.jpg?width=1200&height=900");
        hashMap.put("name", "Jubin Nautiyal");
        hashMap.put("des", "Jubin Nautiyal is most popular singer in India");
        arrayList.add(hashMap);
        //
        hashMap = new HashMap<>();
        hashMap.put("img", "https://cdn.celpox.com/bby_uploads/celeb/5d247af7ba598d753bb593324a3fd95d.jpg");
        hashMap.put("name", "Imran Khan");
        hashMap.put("des", "Imran Khan is most popular singer in Pakistan");
        arrayList.add(hashMap);
        //
        hashMap = new HashMap<>();
        hashMap.put("img", "https://www.pabsttheatergroup.com/assets/img/678x399-TICKETINGJaved-Ali-5164ad702f.png");
        hashMap.put("name", "Javed Ali");
        hashMap.put("des", "Javed Ali is most popular singer in India");
        arrayList.add(hashMap);
        //

    }

    //hasmap mathod end===============================================






    ///////==========================================
    private boolean CheckInternet(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo==null || !networkInfo.isAvailable() || !networkInfo.isConnected()){
            return false;
        }
        return true;

    }

    //






    ///custom exit dialog================

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Dialog dialog = new Dialog(DashboardActivity.this);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations
                = android.R.style.Animation_Dialog;
        dialog.setContentView(R.layout.exitdialog);

        ImageView nobtn = dialog.findViewById(R.id.no);
        ImageView yesbtn = dialog.findViewById(R.id.yes);
        nobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        yesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        dialog.show();
    }

    ///custom exit dialog end============
    ///custom exit dialog end============


}
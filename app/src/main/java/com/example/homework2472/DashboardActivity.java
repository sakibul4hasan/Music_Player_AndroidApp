package com.example.homework2472;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

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
            LinearLayout lly = myView.findViewById(R.id.lly);
            ////////id end///////


            hashMap = arrayList.get(position);

            String aIMG = hashMap.get("img");
            String aName = hashMap.get("name");
            String aDes = hashMap.get("des");

            //////////add data//////
            Picasso.get().load(aIMG).placeholder(R.drawable.img).into(artistIMG);
            artistName.setText(aName);
            artistDes.setText(aDes);
            //////add data end//////

            /////////////////new activity///////////////
            if (aName.contains("Arijit Singh")){
                lly.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Bitmap bitmap = ( (BitmapDrawable) artistIMG.getDrawable() ).getBitmap();
                        SongListActivity.bitmap = bitmap;
                        SongListActivity.bitmap2 = bitmap;
                        SongListActivity.aTopName = aName;
                        SongListActivity.SingerName = aName;
                        SongListActivity.main_arrayList = SongListActivity.Arjit_list;
                        startActivity(new Intent(DashboardActivity.this, SongListActivity.class));

                    }
                });
            }
            //
            if (aName.contains("Atif Aslam")){
                lly.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Bitmap bitmap = ( (BitmapDrawable) artistIMG.getDrawable() ).getBitmap();
                        SongListActivity.bitmap = bitmap;
                        SongListActivity.bitmap2 = bitmap;
                        SongListActivity.aTopName = aName;
                        SongListActivity.SingerName = aName;
                        SongListActivity.main_arrayList = SongListActivity.Atif_list;
                        startActivity(new Intent(DashboardActivity.this, SongListActivity.class));

                    }
                });
            }
            //
            if (aName.contains("Jubin Nautiyal")){
                lly.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Bitmap bitmap = ( (BitmapDrawable) artistIMG.getDrawable() ).getBitmap();
                        SongListActivity.bitmap = bitmap;
                        SongListActivity.bitmap2 = bitmap;
                        SongListActivity.aTopName = aName;
                        SongListActivity.SingerName = aName;
                        startActivity(new Intent(DashboardActivity.this, SongListActivity.class));

                    }
                });
            }
            //
            if (aName.contains("Imran Khan")){
                lly.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Bitmap bitmap = ( (BitmapDrawable) artistIMG.getDrawable() ).getBitmap();
                        SongListActivity.bitmap = bitmap;
                        SongListActivity.bitmap2 = bitmap;
                        SongListActivity.aTopName = aName;
                        SongListActivity.SingerName = aName;
                        startActivity(new Intent(DashboardActivity.this, SongListActivity.class));

                    }
                });
            }
            //
            if (aName.contains("Javed Ali")){
                lly.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Bitmap bitmap = ( (BitmapDrawable) artistIMG.getDrawable() ).getBitmap();
                        SongListActivity.bitmap = bitmap;
                        SongListActivity.bitmap2 = bitmap;
                        SongListActivity.aTopName = aName;
                        SongListActivity.SingerName = aName;
                        startActivity(new Intent(DashboardActivity.this, SongListActivity.class));

                    }
                });
            }
            //

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


}
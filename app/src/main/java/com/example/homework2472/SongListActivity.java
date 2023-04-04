package com.example.homework2472;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class SongListActivity extends AppCompatActivity {

    TextView artistTopname;
    ImageView artistIMG;
    public static String aTopName = "";
    public static String SingerName = "";
    public static Bitmap bitmap = null;
    public static Bitmap bitmap2 = null;
    ListView listView;
    static HashMap <String, String> hashMap;
    static ArrayList < HashMap <String, String> > main_arrayList = new ArrayList<>();
    static ArrayList < HashMap <String, String> > Arjit_list = new ArrayList<>();
    static ArrayList < HashMap <String, String> > Atif_list = new ArrayList<>();
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);
        listView = findViewById(R.id.listView);
        artistTopname = findViewById(R.id.artistTopname);
        artistIMG = findViewById(R.id.artistIMG);



        ////////////////////////////////////////////////////////////////////////////

        artistTopname.setText(aTopName);
        if (bitmap!=null) artistIMG.setImageBitmap(bitmap);


        Main_arrylist();
        myAdaptar adaptar = new myAdaptar();
        listView.setAdapter(adaptar);




    }//////////////////////////////////////////////////////////////////////////


    //listview custom adapter=========================================

    public class myAdaptar extends BaseAdapter{

        @Override
        public int getCount() {
            return main_arrayList.size();
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
            View myView = layoutInflater.inflate(R.layout.song_list, parent, false);

            ////////ID//////////
            ImageView artistIMG = myView.findViewById(R.id.artistIMG);
            TextView songName = myView.findViewById(R.id.songName);
            TextView artistName = myView.findViewById(R.id.artistName);
            LinearLayout lly = myView.findViewById(R.id.lly);
            ImageView player = myView.findViewById(R.id.player);
            ////////ID end//////

            //////random color/////////
            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            lly.setBackgroundColor(color);
            //////random color end/////


            hashMap = main_arrayList.get(position);
            //convert hash to string//////////////
            String title = hashMap.get("Title");
            String Load_song = hashMap.get("s_url");
            //convert hash to string end//////////

            //add data///////////////////
            if (bitmap2!=null) artistIMG.setImageBitmap(bitmap2);
            songName.setText(title);
            artistName.setText(SingerName);

            if (position==0){
                player.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        songPlay(Load_song);
                    }
                });
            }
            //
            if (position==1){
                player.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        songPlay(Load_song);
                    }
                });
            }
            //
            if (position==2){
                player.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        songPlay(Load_song);
                    }
                });
            }
            //
            if (position==3){
                player.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        songPlay(Load_song);
                    }
                });
            }
            //
            if (position==4){
                player.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        songPlay(Load_song);
                    }
                });
            }


            //add data end///////////////

            return myView;
        }
    }

    //listview custom adapter end=====================================




    //Hasmap method=====================================

    public static void Main_arrylist (){

        main_arrayList = new ArrayList<>();
        hashMap = new HashMap<>();
        hashMap.put("Title", "song title");
        hashMap.put("s_url", "https://od.lk/s/NTNfMjc4MTI1MjVf/Chhod%20Diya%20%28Lyrics%29%20-%20Arijit%20Singh_%20Kanika%20Kapoor%20_%20Baazaar.mp3");
        main_arrayList.add(hashMap);
        //
        hashMap = new HashMap<>();
        hashMap.put("Title", "song title");
        hashMap.put("s_url", "https://od.lk/s/NTNfMjc4MTI1MjVf/Chhod%20Diya%20%28Lyrics%29%20-%20Arijit%20Singh_%20Kanika%20Kapoor%20_%20Baazaar.mp3");
        main_arrayList.add(hashMap);
        //
        hashMap = new HashMap<>();
        hashMap.put("Title", "song title");
        hashMap.put("s_url", "https://od.lk/s/NTNfMjc4MTI1MjVf/Chhod%20Diya%20%28Lyrics%29%20-%20Arijit%20Singh_%20Kanika%20Kapoor%20_%20Baazaar.mp3");
        main_arrayList.add(hashMap);
        //
        hashMap = new HashMap<>();
        hashMap.put("Title", "song title");
        hashMap.put("s_url", "https://od.lk/s/NTNfMjc4MTI1MjVf/Chhod%20Diya%20%28Lyrics%29%20-%20Arijit%20Singh_%20Kanika%20Kapoor%20_%20Baazaar.mp3");
        main_arrayList.add(hashMap);
        //
        hashMap = new HashMap<>();
        hashMap.put("Title", "song title");
        hashMap.put("s_url", "https://od.lk/s/NTNfMjc4MTI1MjVf/Chhod%20Diya%20%28Lyrics%29%20-%20Arijit%20Singh_%20Kanika%20Kapoor%20_%20Baazaar.mp3");
        main_arrayList.add(hashMap);
        //

    }

    //Hasmap method end=================================

    //2nd
    //Hasmap method=====================================

    public static void Arjit_album_song (){

        Arjit_list = new ArrayList<>();
        hashMap = new HashMap<>();
        hashMap.put("Title", "song title");
        hashMap.put("s_url", "https://od.lk/s/NTNfMjc4MTI0ODRf/Bulleya_Ae_Dil_Hai_Mushkil.mp3");
        Arjit_list.add(hashMap);
        //
        hashMap = new HashMap<>();
        hashMap.put("Title", "song title");
        hashMap.put("s_url", "https://od.lk/s/NTNfMjc4MTI1MjVf/Chhod%20Diya%20%28Lyrics%29%20-%20Arijit%20Singh_%20Kanika%20Kapoor%20_%20Baazaar.mp3");
        Arjit_list.add(hashMap);
        //
        hashMap = new HashMap<>();
        hashMap.put("Title", "song title");
        hashMap.put("s_url", "https://od.lk/s/NTNfMjc4MTI1MjVf/Chhod%20Diya%20%28Lyrics%29%20-%20Arijit%20Singh_%20Kanika%20Kapoor%20_%20Baazaar.mp3");
        Arjit_list.add(hashMap);
        //
        hashMap = new HashMap<>();
        hashMap.put("Title", "song title");
        hashMap.put("s_url", "https://od.lk/s/NTNfMjc4MTI1MjVf/Chhod%20Diya%20%28Lyrics%29%20-%20Arijit%20Singh_%20Kanika%20Kapoor%20_%20Baazaar.mp3");
        Arjit_list.add(hashMap);
        //
        hashMap = new HashMap<>();
        hashMap.put("Title", "song title");
        hashMap.put("s_url", "https://od.lk/s/NTNfMjc4MTI1MjVf/Chhod%20Diya%20%28Lyrics%29%20-%20Arijit%20Singh_%20Kanika%20Kapoor%20_%20Baazaar.mp3");
        Arjit_list.add(hashMap);
        //

    }

    //Hasmap method end=================================

    //3rd////
    //Hasmap method=====================================

    public static void Atif_album_song (){

        Atif_list = new ArrayList<>();
        hashMap = new HashMap<>();
        hashMap.put("Title", "song title");
        hashMap.put("s_url", "https://od.lk/s/NTNfMjc2MzU3Njdf/World%20Best%20Ringtone.mp3");
        Atif_list.add(hashMap);
        //
        hashMap = new HashMap<>();
        hashMap.put("Title", "song title");
        hashMap.put("s_url", "https://od.lk/s/NTNfMjc4MTI1MjVf/Chhod%20Diya%20%28Lyrics%29%20-%20Arijit%20Singh_%20Kanika%20Kapoor%20_%20Baazaar.mp3");
        Atif_list.add(hashMap);
        //
        hashMap = new HashMap<>();
        hashMap.put("Title", "song title");
        hashMap.put("s_url", "https://od.lk/s/NTNfMjc4MTI1MjVf/Chhod%20Diya%20%28Lyrics%29%20-%20Arijit%20Singh_%20Kanika%20Kapoor%20_%20Baazaar.mp3");
        Atif_list.add(hashMap);
        //
        hashMap = new HashMap<>();
        hashMap.put("Title", "song title");
        hashMap.put("s_url", "https://od.lk/s/NTNfMjc4MTI1MjVf/Chhod%20Diya%20%28Lyrics%29%20-%20Arijit%20Singh_%20Kanika%20Kapoor%20_%20Baazaar.mp3");
        Atif_list.add(hashMap);
        //
        hashMap = new HashMap<>();
        hashMap.put("Title", "song title");
        hashMap.put("s_url", "https://od.lk/s/NTNfMjc4MTI1MjVf/Chhod%20Diya%20%28Lyrics%29%20-%20Arijit%20Singh_%20Kanika%20Kapoor%20_%20Baazaar.mp3");
        Atif_list.add(hashMap);
        //

    }

    //Hasmap method end=================================










    /////////////////////////////////////////////////////
    //song play method////////////////////////////////////

    public void songPlay (String song_url){

        ImageView player = (ImageView)findViewById(R.id.player);

        if (player.getTag()!=null && player.getTag().toString().contains("NOT PLAYING")){


            if (mediaPlayer!=null) mediaPlayer.release();
            mediaPlayer = new MediaPlayer();
            try {
                mediaPlayer.setDataSource(song_url);
                mediaPlayer.prepare();
                mediaPlayer.start();
                player.setImageResource(R.drawable.pause);
                player.setTag("PLAYING NOW");
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        player.setImageResource(R.drawable.play);
                        player.setTag("NOT PLAYING");
                    }
                });

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }else {
            if (mediaPlayer!=null) mediaPlayer.release();
            player.setImageResource(R.drawable.play);
            player.setTag("NOT PLAYING");
        }





    }

    //song play method end////////////////////////////////



}
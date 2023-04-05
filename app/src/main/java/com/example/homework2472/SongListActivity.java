package com.example.homework2472;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioManager;
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
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class SongListActivity extends AppCompatActivity {

    TextView artistTopname;
    ImageView artistIMG;
    public static String singerTopName ="";
    public static Bitmap MY_BITMAP = null;
    ListView listView;
    HashMap<String, String> hashMap;
    ArrayList< HashMap<String, String> > arrayList = new ArrayList<>();
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);
        artistTopname = findViewById(R.id.artistTopname);
        artistIMG = findViewById(R.id.artistIMG);
        listView = findViewById(R.id.listView);

        ////////////////////////////////////////////////////////////////////

        ///java code hear==============
        artistTopname.setText(singerTopName);
        if (MY_BITMAP!=null)
            artistIMG.setImageBitmap(MY_BITMAP);


        if (singerTopName.contains("Arijit Singh")){
          arijitList();
        } else if (singerTopName.contains("Atif Aslam")) {
            atifList();
        }else if (singerTopName.contains("Jubin Nautiyal")) {
            jubinList();
        }else if (singerTopName.contains("Imran Khan")) {
            imranList();
        }else if (singerTopName.contains("Javed Ali")) {
            javedList();
        }
        myAdaptar adaptar = new myAdaptar();
        listView.setAdapter(adaptar);





    }///////////////////////////////////////////////////////////////////////

    ////listView create Adaptar============================
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
            View myView = layoutInflater.inflate(R.layout.song_list, parent, false);

            hashMap = arrayList.get(position);
            //Id=============
            LinearLayout Song_lly = myView.findViewById(R.id.Song_lly);
            ImageView artistIMG = myView.findViewById(R.id.artistIMG);
            ImageView player = myView.findViewById(R.id.player);
            TextView songName = myView.findViewById(R.id.songName);
            TextView artistName = myView.findViewById(R.id.artistName);
            //Id end=========
            //Id end=========



            //add data====================
            String SongName = hashMap.get("songName");
            String song = hashMap.get("songUrl");
            //

            artistName.setText(singerTopName);
            songName.setText(SongName);
            if (MY_BITMAP!=null)
                artistIMG.setImageBitmap(MY_BITMAP);

            //music add
            player.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //
                    if (player.getTag()!=null && player.getTag().toString().contains("NOT_PLAYING")) {

                        if (mediaPlayer!=null)
                            mediaPlayer.release();


                        String audioUrl = song;
                        mediaPlayer = new MediaPlayer();
                        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

                        try {

                            mediaPlayer.setDataSource(audioUrl);

                            // below line is use to prepare
                            // and start our media player.

                            mediaPlayer.prepare();
                            mediaPlayer.start();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }



                        // below line is use to display a toast message.
                        Toast.makeText(SongListActivity.this, ""+SongName+" is playing", Toast.LENGTH_SHORT).show();


                        player.setTag("NOW_PLAYING");
                        player.setImageResource(R.drawable.pause);

                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {

                                player.setTag("NOT_PLAYING");
                                player.setImageResource(R.drawable.play);
                            }
                        });


                    } else {

                        if (mediaPlayer!=null) mediaPlayer.release();
                        player.setImageResource(R.drawable.play);
                        player.setTag("NOT_PLAYING");
                    }
                    //
                }
            });
            //add data end================
            //add data end================


            return myView;
        }
    }
    ////listView create Adaptar end========================
    ////listView create Adaptar end========================




    ///create a arrylist===============================
    public void arijitList (){
        //
        hashMap = new HashMap<>();
        hashMap.put("songName", "Pata chala ");
        hashMap.put("songUrl", "https://od.lk/s/NTNfMjc4MTI1MjVf/Chhod%20Diya%20%28Lyrics%29%20-%20Arijit%20Singh_%20Kanika%20Kapoor%20_%20Baazaar.mp3");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("songName", "Hamdard (Ek Villain)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("songName", "Gerua (Dilwale)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("songName", "Gerua (Dilwale)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("songName", " Zaalima (Raees)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", "Mast Magan (2 States)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", "Muskurane (CityLights)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", "Tum Hi Ho (Aashiqui 2)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", "Soch Na Sake (Airlift)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", "Sooiyan (Guddu Rangeela)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", " Samjhawan (Humpty Sharma Ki Dulhania)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", " Kabhi Jo Baadal Barse (Jackpot)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", "Laal Ishq (Goliyon Ki Rasleela Ram-Leela)");
        hashMap.put("songUrl", "https://od.lk/s/NTNfMjc4MTI1MjVf/Chhod%20Diya%20%28Lyrics%29%20-%20Arijit%20Singh_%20Kanika%20Kapoor%20_%20Baazaar.mp3");
        arrayList.add(hashMap);
        //
    }

    //

    public void atifList (){
        //
        hashMap = new HashMap<>();
        hashMap.put("songName", "Pata chala ");
        hashMap.put("songUrl", "https://od.lk/s/NTNfMjc4MTI0Nzhf/Borsha%20Chokh%20Bangla%20Music%20Video%20By%20Imran.mp3");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("songName", "Hamdard (Ek Villain)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("songName", "Gerua (Dilwale)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("songName", "Gerua (Dilwale)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("songName", " Zaalima (Raees)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", "Mast Magan (2 States)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", "Muskurane (CityLights)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", "Tum Hi Ho (Aashiqui 2)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", "Soch Na Sake (Airlift)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", "Sooiyan (Guddu Rangeela)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", " Samjhawan (Humpty Sharma Ki Dulhania)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", " Kabhi Jo Baadal Barse (Jackpot)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", "Laal Ishq (Goliyon Ki Rasleela Ram-Leela)");
        hashMap.put("songUrl", "https://od.lk/s/NTNfMjc4MTI0Nzhf/Borsha%20Chokh%20Bangla%20Music%20Video%20By%20Imran.mp3");
        arrayList.add(hashMap);
        //
    }

    //

    public void jubinList (){
        //
        hashMap = new HashMap<>();
        hashMap.put("songName", "Pata chala ");
        hashMap.put("songUrl", "https://od.lk/s/NTNfMjc4MTI0ODRf/Bulleya%20Ae%20Dil%20Hai%20Mushkil.mp3");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("songName", "Hamdard (Ek Villain)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("songName", "Gerua (Dilwale)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("songName", "Gerua (Dilwale)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("songName", " Zaalima (Raees)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", "Mast Magan (2 States)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", "Muskurane (CityLights)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", "Tum Hi Ho (Aashiqui 2)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", "Soch Na Sake (Airlift)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", "Sooiyan (Guddu Rangeela)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", " Samjhawan (Humpty Sharma Ki Dulhania)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", " Kabhi Jo Baadal Barse (Jackpot)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", "Laal Ishq (Goliyon Ki Rasleela Ram-Leela)");
        hashMap.put("songUrl", "https://od.lk/s/NTNfMjc4MTI0ODRf/Bulleya%20Ae%20Dil%20Hai%20Mushkil.mp3");
        arrayList.add(hashMap);
        //
    }

    //

    public void imranList (){
        //
        hashMap = new HashMap<>();
        hashMap.put("songName", "Pata chala ");
        hashMap.put("songUrl", "https://od.lk/s/NTNfMjc2NDU3NzVf/falakh.mp3");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("songName", "Hamdard (Ek Villain)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("songName", "Gerua (Dilwale)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("songName", "Gerua (Dilwale)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("songName", " Zaalima (Raees)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", "Mast Magan (2 States)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", "Muskurane (CityLights)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", "Tum Hi Ho (Aashiqui 2)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", "Soch Na Sake (Airlift)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", "Sooiyan (Guddu Rangeela)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", " Samjhawan (Humpty Sharma Ki Dulhania)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", " Kabhi Jo Baadal Barse (Jackpot)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", "Laal Ishq (Goliyon Ki Rasleela Ram-Leela)");
        hashMap.put("songUrl", "https://od.lk/s/NTNfMjc2NDU3NzVf/falakh.mp3");
        arrayList.add(hashMap);
        //
    }

    //

    public void javedList (){
        //
        hashMap = new HashMap<>();
        hashMap.put("songName", "Pata chala ");
        hashMap.put("songUrl", "https://od.lk/s/NTNfMjc2MzU3NjFf/ummon%20hiyonat%20ringtone.mp3");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("songName", "Hamdard (Ek Villain)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("songName", "Gerua (Dilwale)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("songName", "Gerua (Dilwale)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("songName", " Zaalima (Raees)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", "Mast Magan (2 States)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", "Muskurane (CityLights)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", "Tum Hi Ho (Aashiqui 2)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", "Soch Na Sake (Airlift)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", "Sooiyan (Guddu Rangeela)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", " Samjhawan (Humpty Sharma Ki Dulhania)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", " Kabhi Jo Baadal Barse (Jackpot)");
        hashMap.put("songUrl", "https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_100KB_MP3.mp3");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("songName", "Laal Ishq (Goliyon Ki Rasleela Ram-Leela)");
        hashMap.put("songUrl", "https://od.lk/s/NTNfMjc2MzU3NjFf/ummon%20hiyonat%20ringtone.mp3");
        arrayList.add(hashMap);
        //
    }
    ///create a arrylist end===========================
    ///create a arrylist end===========================


}
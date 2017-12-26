package com.chape.daoandphp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chape.daoandphp.base.dao.dao.DBManager;
import com.chape.daoandphp.base.dao.dao.Picurl;
import com.chape.daoandphp.utils.HttpUtil;
import com.chape.daoandphp.utils.MyApplication;
import com.chape.daoandphp.utils.ParseHtml;
import com.chape.daoandphp.utils.ParseHtml2;
import com.chape.daoandphp.utils.ParseHtml3;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.btn_get);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              new getData().execute("http://www.33mn.net/ns/7");
            }
        });
    }
    private class getData extends AsyncTask<String,Integer,String> {
        @Override
        //
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        //
        protected String doInBackground(String... params) {


            return  HttpUtil.get(params[0]);
        }

        @Override
        //
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if(result!=null){

              //  String str=result.substring(result.indexOf("<div id=\"tu\" class=\"tu\">")+1, result.lastIndexOf("</div> <div class=\"tub\">"));
          //   String str= ParseHtml.getHtmlString(result);
                List<String> titlelist=new ArrayList<>();
                List<String> contentlist=new ArrayList<>();
                contentlist= ParseHtml2.getAllImageUrlFromHtml(result);
                titlelist= ParseHtml3.getAllImageUrlFromHtml(result);
                DBManager dbManager = DBManager.getInstance(getApplicationContext());
            /*    for (int i=0;i<titlelist.size();i++){
                    Picurl picurl=new Picurl();
                    picurl.setPic_title(titlelist.get(i));
                    picurl.setPic_content(contentlist.get(i));
                    dbManager.insertUser(picurl);
                }*/
                List<Picurl> picurls=dbManager.queryUserList();
                for (Picurl picurl:picurls){
                    Log.d("MainActivity",picurl.getId()+"--"+picurl.getPic_title()+"--"+picurl.getPic_content());
                }
                // strlist=ParseHtml.getAllImageUrlFromHtml(str);

               //Toast.makeText(MainActivity.this,strlist.get(0),Toast.LENGTH_LONG).show();
                //Toast.makeText(MainActivity.this,result,Toast.LENGTH_LONG).show();
            }else {

            }



        }
    }
}

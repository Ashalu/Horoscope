package com.developer.aashish.horoscopemy;

/**
 * Created by Aashish on 8/2/2017.
 */import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;



public class Aries extends Activity{
    TextView tv,tv1,tv2,tv3;
    ImageView iv;
    Boolean connected;

    private String finalUrl="http://feeds.feedburner.com/AstroSageAries?format=xml";
    private HandleXML obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common);
        init();
        tv.setText(R.string.Aries);
//        iv.setBackgroundResource(R.drawable.aquarius);
        fetch();
    }

    private void init() {
        tv=(TextView)findViewById(R.id.textView);
        tv1=(TextView)findViewById(R.id.textView1);
        tv2=(TextView)findViewById(R.id.textView2);
        iv=(ImageView)findViewById(R.id.imageView);
    }

    public void fetch(){
        obj = new HandleXML(finalUrl);
        obj.fetchXML();
        while(obj.parsingComplete);
        tv1.setText(obj.getTitle());
        tv2.setText(obj.getDescription());
    }

}

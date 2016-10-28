package com.habijabi.ranna;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] web;

    public CustomAdapter(Activity context,
                         String[] web) {
        super(context, R.layout.list_single, web);
        this.context = context;
        this.web = web;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_single, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.chktxt);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);

        if (web[position].contains("এলাচ"))
            imageView.setImageResource(R.drawable.cardamom);
        else if (web[position].contains("আটা"))
            imageView.setImageResource(R.drawable.aata);
        else if (web[position].contains("বাঁধাকপি"))
            imageView.setImageResource(R.drawable.bandhakopi);
        else if (web[position].contains("বেগুন"))
            imageView.setImageResource(R.drawable.begun);
        else if (web[position].contains("আখের গুড়"))
            imageView.setImageResource(R.drawable.cane_jaggery);
        else  if (web[position].contains("ফুলকপি"))
            imageView.setImageResource(R.drawable.cauliflower);
        else  if (web[position].contains("লঙ্কা"))
            imageView.setImageResource(R.drawable.chilly);
        else if (web[position].contains("লাল মরিচ গুঁড়া"))
            imageView.setImageResource(R.drawable.chilly_pow);
        else if (web[position].contains("দুধ"))
            imageView.setImageResource(R.drawable.milk);
        else  if (web[position].contains("লবঙ্গ"))
            imageView.setImageResource(R.drawable.cloves);
        else if (web[position].contains("নারকেল"))
            imageView.setImageResource(R.drawable.coconut);
        else  if (web[position].contains("ধনে গুঁড়া"))
            imageView.setImageResource(R.drawable.coriander_pow);
        else  if (web[position].contains("শসা"))
            imageView.setImageResource(R.drawable.cucumber);
        else     if (web[position].contains("গোটা জিরা"))
            imageView.setImageResource(R.drawable.cumin);
        else  if (web[position].contains("জিরা গুঁড়া"))
            imageView.setImageResource(R.drawable.cumin_po);
        else  if (web[position].contains("ডিম"))
            imageView.setImageResource(R.drawable.eggs);
        else  if (web[position].contains("এঁচোড়"))
            imageView.setImageResource(R.drawable.enchor);
        else  if (web[position].contains("রসুন"))
            imageView.setImageResource(R.drawable.garlic);
        else   if (web[position].contains("আদা"))
            imageView.setImageResource(R.drawable.ginger);
        else if (web[position].contains("ইলিশ মাছ"))
            imageView.setImageResource(R.drawable.ilish);
        else if (web[position].contains("কালো জিরে"))
            imageView.setImageResource(R.drawable.kala_jeera);
        else if (web[position].contains("কাসুন্দি"))
            imageView.setImageResource(R.drawable.kasundi);
        else  if (web[position].contains("করলা"))
            imageView.setImageResource(R.drawable.korola);
        else  if (web[position].contains("লাউ"))
            imageView.setImageResource(R.drawable.lau);
        else  if (web[position].contains("ময়দা"))
            imageView.setImageResource(R.drawable.maida);
        else if (web[position].contains("মেথি"))
            imageView.setImageResource(R.drawable.methi);
        else  if (web[position].contains("মৌব়ি"))
            imageView.setImageResource(R.drawable.mouri);
        else if (web[position].contains("দুধ"))
            imageView.setImageResource(R.drawable.milk);
        else if (web[position].contains("দুধ"))
            imageView.setImageResource(R.drawable.milk);
////////////

        else if (web[position].contains("শর্ষের তেল"))
            imageView.setImageResource(R.drawable.mustad_oil);

        else if (web[position].contains("শর্ষে") && !(web[position].contains("শর্ষের তেল")))
            imageView.setImageResource(R.drawable.mustard);


        else if (web[position].contains("পেঁয়াজ"))
            imageView.setImageResource(R.drawable.onion);

        else if (web[position].contains("খেজুরের গুড়"))
            imageView.setImageResource(R.drawable.palm_jaggery);

        else if (web[position].contains("গোলমরিচ"))
            imageView.setImageResource(R.drawable.pepper);

        else if (web[position].contains("আলু"))
            imageView.setImageResource(R.drawable.potato);

        else if (web[position].contains("পটল"))
            imageView.setImageResource(R.drawable.potol);

        else if (web[position].contains("চিংড়ি"))
            imageView.setImageResource(R.drawable.prawn);

        else if (web[position].contains("পুইঁশাক"))
            imageView.setImageResource(R.drawable.pui);

        else if (web[position].contains("কুমড়া"))
            imageView.setImageResource(R.drawable.pumkin);

        else if (web[position].contains("লাল মরিচ") && !(web[position].contains("লাল মরিচ গুঁড়া") ))
        imageView.setImageResource(R.drawable.red_chilly);

        else if (web[position].contains("রীফাইন্ড তেল"))
            imageView.setImageResource(R.drawable.refined_oil);

        else if (web[position].contains("চাল"))
            imageView.setImageResource(R.drawable.rice);

        else if (web[position].contains("রুই মাছ"))
            imageView.setImageResource(R.drawable.rogu);

        else if (web[position].contains("লবণ"))
            imageView.setImageResource(R.drawable.salt);

        else if (web[position].contains("পালং শাক"))
            imageView.setImageResource(R.drawable.spinach);

        else if (web[position].contains("তেজপাতা"))
            imageView.setImageResource(R.drawable.tejpata);

        else if (web[position].contains("দুধ"))
            imageView.setImageResource(R.drawable.milk);

        else if (web[position].contains("টমেটো"))
            imageView.setImageResource(R.drawable.tomato);

        else if (web[position].contains("হলুদ"))
            imageView.setImageResource(R.drawable.turmeric);

        else if (web[position].contains("মাখন"))
            imageView.setImageResource(R.drawable.butter);

        else if (web[position].contains("ঘি"))
            imageView.setImageResource(R.drawable.ghee);

        else if (web[position].contains("পোস্ত"))
            imageView.setImageResource(R.drawable.posto);

        else if (web[position].contains("বেকিং পাউডার"))
            imageView.setImageResource(R.drawable.baking_powder);

        else if (web[position].contains("চিনি"))
            imageView.setImageResource(R.drawable.sugar);



///////////////////orrect//////////////
        else
            imageView.setImageResource(R.drawable.test);

        // web[position]=web[position].replaceAll("_", " ");
        txtTitle.setText(web[position]);

        return rowView;
    }
}

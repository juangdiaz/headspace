package com.juangdiaz.headspace.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.juangdiaz.headspace.R;
import com.juangdiaz.headspace.models.Items;

import java.util.List;

public class ItemsAdapter extends PagerAdapter {

    private List<Items> items;
    private Context context;


    public ItemsAdapter(Context context, List<Items> items) {

        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup collection, int position) {

        LayoutInflater inflater = LayoutInflater.from(context);
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.row_items, collection, false);

        final TextView nameTextView = view.findViewById(R.id.tvName);
        nameTextView.setText(items.get(position).getName());

        final TextView priceTextView = view.findViewById(R.id.tvSalePrice);
        String price = "$ " + String.format( "%.2f", items.get(position).getSalePrice());
        priceTextView.setText(price);

        final ImageView  itemImageView = view.findViewById(R.id.ivLargeImage);
        Glide.with(context).load(items.get(position).getLargeImage()).into(itemImageView);

        collection.addView(view);
        return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object view) {
        container.removeView((View) view);
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}

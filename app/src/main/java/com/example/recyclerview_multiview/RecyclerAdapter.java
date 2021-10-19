package com.example.recyclerview_multiview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter {

    private static final String TAG = "RecyclerAdapter";
    int count = 0;

    //Class er instanceVariables BEGIN
    List<String> moviesList;
    private RecyclerViewClickInterface recyclerViewClickInterface;
    //Class er instanceVariables END

    //Constructor
    public RecyclerAdapter(List<String> moviesList, RecyclerViewClickInterface recyclerViewClickInterface) {
        this.moviesList = moviesList;
        this.recyclerViewClickInterface = recyclerViewClickInterface;
    }

    //METHODS Begin

    //Ei Method NIJEKE Alada vabe OVERRIDE kora lagbe... Extend korle ei Method ashbe nah
    //Ei method ekta INT return korbe jeita Define korbe oi Particular Position ee Amra kon MULTIVIEW er moddhe kon VIEW ta Show korte chai
    @Override
    public int getItemViewType(int position) {
        if(moviesList.get(position).toLowerCase().contains("iron"))
        {
            return 0;
        }

        else
        {
            return 1;
        }
        //return super.getItemViewType(position);
    }



    //Extend korle ei nicher 3 ta Method ashbe
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view;

        if(viewType==0)
        {
            view = layoutInflater.inflate(R.layout.row_item,parent,false);
            return new ViewHolderOne(view);
        }

        else
        {
            view = layoutInflater.inflate(R.layout.another_row_item,parent,false);
            return new ViewHolderTwo(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if(moviesList.get(position).toLowerCase().contains("iron"))
        {
            //bind ViewHolder One
            ViewHolderOne viewHolderOne = (ViewHolderOne) holder;
            viewHolderOne.textView.setText(moviesList.get(position));
            viewHolderOne.rowCountTextView.setText(String.valueOf(position));
        }

        else
        {
            //bind ViewHolder Two
            ViewHolderTwo viewHolderTwo = (ViewHolderTwo) holder;
            viewHolderTwo.textView.setText(moviesList.get(position));
            viewHolderTwo.rowCountTextView.setText(String.valueOf(position));
        }

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    //METHODS End


    //row_item.xml er jonno
    class ViewHolderOne extends RecyclerView.ViewHolder{

        TextView textView, rowCountTextView;
        ImageView imageView;
        public ViewHolderOne(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            rowCountTextView = itemView.findViewById(R.id.rowCountTextView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    //another_row_item.xml er jonno
    class ViewHolderTwo extends RecyclerView.ViewHolder{

        TextView textView, rowCountTextView;
        public ViewHolderTwo(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            rowCountTextView = itemView.findViewById(R.id.rowCountTextView);
        }
    }
}

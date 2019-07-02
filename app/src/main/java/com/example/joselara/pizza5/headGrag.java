package com.example.joselara.pizza5;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class headGrag extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.headgrag_layout, container, false);

        TextView cart = view.findViewById(R.id.cart);
        TextView pizza = view.findViewById(R.id.pizza);
        final TextView menu = view.findViewById(R.id.menu);

        final Intent cartIntent = new Intent(getActivity(),cart.class);
        final Intent pizzaIntent = new Intent(getActivity(),toppings.class );
        final Intent menuIntent = new Intent(getActivity(),page3.class );

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(cartIntent);
            }
        });

        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(pizzaIntent);
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(menuIntent);
            }
        });

        return view;
    }

}

package com.example.ulugbek.frgroup;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListFragment extends Fragment {

    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHashMap;

    @SuppressLint("WrongViewCast")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_fragment,container,false);
        expandableListView = rootView.findViewById(R.id.expandableListview_listFragment);
        initData();
        expandableListAdapter = new ExpandableListAdapter(this.getActivity(),listDataHeader,listHashMap);
        expandableListView.setAdapter(expandableListAdapter);


        return rootView;

    }

    private void initData(){

        listDataHeader = new ArrayList<>();
        listHashMap = new HashMap<>();

        listDataHeader.add("Вода / Напитки");
        listDataHeader.add("Бакалея");
        listDataHeader.add("Овощи и фрукты");
        listDataHeader.add("Яйца / Молоко и молочные изделия");
        listDataHeader.add("Мясо и мясные изделия");
        listDataHeader.add("Чай/Кофе");
        listDataHeader.add("Замороженные продукты");
        listDataHeader.add("Хлеб и хлебо-булочные изделия");
        listDataHeader.add("Торты и сладости");


        List<String> drink = new ArrayList<>();
        drink.add("Соки");
        drink.add("Квас");
        drink.add("Морс");
        drink.add("Вода");
        drink.add("Газированные напитки");
        drink.add("Прохладительрые напитки");
        drink.add("Энергетические напитки");


        List<String> bakery = new ArrayList<>();
        bakery.add("Крупы в упаковке");
        bakery.add("Мука");
        bakery.add("Сахар/Нават/Соль");
        bakery.add("Макаронные изделия");
        bakery.add("Масло растительное");
        bakery.add("Мёд/Варенье/Джем/Молоко сгущенное");
        bakery.add("Маргарин");
        bakery.add("Сухие завтраки");
        bakery.add("Продукты быстрого приготовления");
        bakery.add("Кетчупы/Соусы/Майонез");
        bakery.add("Приправы/Специи/Смеси для выпечки");
        bakery.add("Семечки/Чипсы/Курт/Попкорн");

        List<String> fruits = new ArrayList<>();
        fruits.add("Овощи");
        fruits.add("Фрукты");
        fruits.add("Зелень");
        fruits.add("Сухофрукты/Орехи");

        List<String> milk = new ArrayList<>();
        milk.add("Молоко/Молочные коктейли");
        milk.add("Кефир/Ряженка/Айран");
        milk.add("Йогурт");
        milk.add("Каймак/Сливки");
        milk.add("Сметана");
        milk.add("Творог");
        milk.add("Сырки");
        milk.add("Масло сливочное");
        milk.add("Сыры");
        milk.add("Сулугуни");
        milk.add("Брынза");
        milk.add("Яйца");


        List<String> meat = new ArrayList<>();
        meat.add("Говядина");
        meat.add("Баранина");
        meat.add("Мясо птицы");
        meat.add("Крольчатина");
        meat.add("Рыбные изделия");
        meat.add("Колбасные изделия");
        meat.add("Сосиски");
        meat.add("Мясные деликатесы");


        List<String> tea = new ArrayList<>();
        tea.add("Чай чёрный");
        tea.add("Чай зеленый");
        tea.add("Кофе/Какао/Сливки");


        List<String> frozen = new ArrayList<>();
        frozen.add("Мороженое");
        frozen.add("Полуфабрикаты");
        frozen.add("Морепродукты");
        frozen.add("Кулинария");

        List<String> bread = new ArrayList<>();
        bread.add("Свежая выпечка");
        bread.add("Багеты/Батоны/Лепешки");
        bread.add("Хлеб ржаной/с отрубями/с семечками");
        bread.add("Сушки/сухари/крекеры");
        bread.add("Лаваш");


        List<String> cake = new ArrayList<>();
        cake.add("Торты и пирожные");
        cake.add("Печенье/Вафли/Пряники");
        cake.add("Диабетические продукты");
        cake.add("Прочие сладости");
        cake.add("Шоколадные изделия");



        listHashMap.put(listDataHeader.get(0),drink);
        listHashMap.put(listDataHeader.get(1),bakery);
        listHashMap.put(listDataHeader.get(2),fruits);
        listHashMap.put(listDataHeader.get(3),milk);
        listHashMap.put(listDataHeader.get(4),meat);
        listHashMap.put(listDataHeader.get(5),tea);
        listHashMap.put(listDataHeader.get(6),frozen);
        listHashMap.put(listDataHeader.get(7),bread);
        listHashMap.put(listDataHeader.get(8),cake);

    }
}

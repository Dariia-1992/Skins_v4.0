package com.hi.appskin_v40.fragment;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hi.appskin_v40.R;
import com.hi.appskin_v40.adapter.SkinsAdapter;
import com.hi.appskin_v40.model.Skin;
import com.hi.appskin_v40.model.SkinsRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment{
    private List<Skin> fulSkins = new ArrayList<>();
    private List<Skin> currentList = new ArrayList<>();
    private final List<Skin> filterSkins = new ArrayList<>();
    private List<Skin> favoriteSkins = new ArrayList<>();

    private View view;
    private SkinsAdapter adapter;
    private String searchStr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        adapter = new SkinsAdapter(currentList, listener);
        RecyclerView recyclerView = view.findViewById(R.id.contentView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        loadSkinsInfo();

        favoriteSkins = SkinsRepository.getFavorite(fulSkins);
        TextView allSkins = view.findViewById(R.id.button_text);
        TextView favoriteList = view.findViewById(R.id.button_favorite);
        allSkins.setOnClickListener(v -> {
            setCheckedState(allSkins, true);
            setCheckedState(favoriteList, false);
            setCurrent(fulSkins);
        });
        favoriteList.setOnClickListener(v -> {
            setCheckedState(favoriteList, true);
            setCheckedState(allSkins, false);
            setCurrent(favoriteSkins);
        });
        View searchButton = view.findViewById(R.id.toolbar_search);
        searchButton.setOnClickListener(v -> setupSearch(true));

        return view;
    }

    private void loadSkinsInfo() {
        List<Skin> skins = SkinsRepository.getItems();
        if (skins ==null || skins.isEmpty())
            return;
        fulSkins.clear();
        fulSkins.addAll(skins);

        setCurrent(fulSkins);
    }

    private void setupSearch(boolean show){
        View searchButton = view.findViewById(R.id.toolbar_search);
        View toolbarText = view.findViewById(R.id.toolbar_name);
        SearchView searchView = view.findViewById(R.id.search);

        searchView.setOnCloseListener(() -> {
            setupSearch(false);
            return false;
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) { return false; }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchStr = newText;
                filterData();
                return false;
            }
        });

        searchButton.setVisibility(show ? View.GONE : View.VISIBLE);
        toolbarText.setVisibility(show ? View.GONE : View.VISIBLE);
        searchView.setVisibility(show ? View.VISIBLE : View.GONE);

        if (show) {
            searchView.setIconified(false);
            searchView.requestFocusFromTouch();
        }
    }

    private void filterData() {

    }

    private void setCheckedState(TextView textView, boolean isChecked) {
        if (getContext() == null)
            return;
        textView.setTextColor(ContextCompat.getColor(getContext(), isChecked ? R.color.toolbar_text_color : R.color.toolbar_text_color_favorite));
    }

    private void setCurrent(List<Skin> skins) {
        currentList.clear();
        currentList.addAll(skins);
        adapter.notifyDataSetChanged();
    }

    private final SkinsAdapter.OnClickItem listener = id -> {
        View view = getView();
        if (view == null)
            return;
        Bundle bundle = new Bundle();
        bundle.putString(ModDetailsFragment.ARG_ITEM_ID, id);
        Navigation.findNavController(getView()).navigate(R.id.action_mainFragment_to_modDetailsFragment, bundle);
    };
}

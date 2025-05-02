package com.example.csc313assignment2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.csc313assignment2.databinding.FragmentBrowseBooksBinding;
import com.example.csc313assignment2.model.Textbook;
import com.example.csc313assignment2.model.TextbookAdapter;

import java.util.ArrayList;
import java.util.List;

public class BrowseBooksFragment extends Fragment {

    private FragmentBrowseBooksBinding binding;
    private TextbookAdapter adapter;
    private List<Textbook> textbookList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentBrowseBooksBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Sample data — you can later fetch this from a database or shared ViewModel
        textbookList.add(new Textbook("Java Programming", "Ms Nzimase", 5, 350.00));
        textbookList.add(new Textbook("Android Development", "Mr Mqingwana", 3, 450.00));
        textbookList.add(new Textbook("Data Structures", "Ms Mathontsi", 4, 300.00));
        textbookList.add(new Textbook("OOP Concepts", "Mr Loliwe", 2, 400.00));


        adapter = new TextbookAdapter(textbookList);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerView.setAdapter(adapter);

        // Set up search functionality
        binding.searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not needed
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterTextbooks(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Not needed
            }
        });
    }

    private void filterTextbooks(String query) {
        List<Textbook> filteredList = new ArrayList<>();
        for (Textbook textbook : textbookList) {
            if (textbook.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    textbook.getSeller().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(textbook);
            }
        }
        adapter.updateList(filteredList);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

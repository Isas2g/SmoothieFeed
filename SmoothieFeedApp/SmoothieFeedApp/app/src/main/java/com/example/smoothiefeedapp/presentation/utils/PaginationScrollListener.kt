package com.example.smoothiefeedapp.presentation.utils

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PaginationScrollListener(
    private val layoutManager: LinearLayoutManager,
    private val newsIsLoad: Flow<Boolean>,
    private val getNewItems: () -> Unit,
    private val countOfWatchedItems: (Int) -> Unit
): RecyclerView.OnScrollListener() {
    private var isLoading = true

    init {
        CoroutineScope(Dispatchers.IO).launch {
            newsIsLoad.collect { isLoading = it }
        }
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        with(layoutManager){
            if (dy<=0) return@with

            val scrolledOffItems = findFirstVisibleItemPosition()
            val visibleItems = childCount
            val itemsTotal = itemCount

            countOfWatchedItems(scrolledOffItems+visibleItems)

            if (isLoading && visibleItems + scrolledOffItems+1>=itemsTotal){
                getNewItems()
                isLoading = false
            }
        }
    }
}
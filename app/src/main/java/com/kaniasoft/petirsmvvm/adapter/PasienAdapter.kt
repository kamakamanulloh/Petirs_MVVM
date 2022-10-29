package com.kaniasoft.petirsmvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kaniasoft.petirsmvvm.model.Result
import java.util.*

class PasienAdapter : RecyclerView.Adapter<PasienAdapter.ViewHolder>() {
    private var pasienList = ArrayList<Result>()
    fun setPasienList(pasienList: List<Result>) {
        this.pasienList = pasienList as ArrayList<Result>
        notifyDataSetChanged()
    }

    class ViewHolder(val binding:PasienLayoutBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            PasienLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.tv_pasien.text = pasienList[position].nama
    }

    override fun getItemCount(): Int {
        return pasienList.size
    }
}
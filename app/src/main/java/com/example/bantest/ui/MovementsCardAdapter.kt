package com.example.bantest.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bantest.R
import com.example.bantest.databinding.ItemMovementsBinding
import com.example.bantest.domain.models.MovementsModel

class MovementsCardAdapter (
    private val listMovements: List<MovementsModel>,
    private val context: Context
) : RecyclerView.Adapter<MovementsCardAdapter.MovementsHolder> (){

    class MovementsHolder(
        private val binding: ItemMovementsBinding,
        private val context: Context
    ) : RecyclerView.ViewHolder(binding.root){

        fun bind(movement: MovementsModel){
            with(binding){
                tvMovementDescription.text = movement.description
                tvMovementDate.text = movement.date
                tvMovementAmount.text = context.getString(R.string.format_amount, movement.amount)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovementsHolder {
        val binding = ItemMovementsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return MovementsHolder(binding, context)
    }

    override fun getItemCount(): Int = listMovements.size

    override fun onBindViewHolder(holder: MovementsHolder, position: Int) {
        holder.bind(listMovements[position])
    }
}
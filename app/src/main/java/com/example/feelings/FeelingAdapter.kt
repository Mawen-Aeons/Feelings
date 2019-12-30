package com.example.feelings

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat

class FeelingAdapter internal constructor(context: Context)
    : RecyclerView.Adapter<FeelingAdapter.FeelingViewHolder>()
{
    private val inflater : LayoutInflater = LayoutInflater.from(context)
    private var feelingList = emptyList<Feeling>() // cached copy of feeling records

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeelingViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        val itemView = inflater.inflate(
            R.layout.feeling_record,
            parent,
            false)

        return FeelingViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return feelingList.size
    }

    override fun onBindViewHolder(holder: FeelingViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        //position = record position
        val feeling = feelingList.get(position)

        if(feeling.mode == 1){
            holder.imageViewFeeling.setImageResource(R.drawable.ic_sentiment_dissatisfied_black_24dp)

        }
        else if(feeling.mode == 2){

            holder.imageViewFeeling.setImageResource(R.drawable.ic_sentiment_neutral_green_24dp)
        }
        else{
            holder.imageViewFeeling.setImageResource(R.drawable.ic_sentiment_satisfied_yellow_24dp)
        }

        holder.textViewRemark.text = feeling.remarks
        holder.textViewDate.text = SimpleDateFormat("yyyy.MM.dd.HH.MM")
            .format(feeling.created_at)

        holder.imageViewFeeling
    }

    inner class FeelingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageViewFeeling: ImageView = itemView.findViewById(R.id.imageViewHappy)

        val textViewRemark: TextView =
            itemView.findViewById(R.id.textViewRemark)

        val textViewDate: TextView =
            itemView.findViewById(R.id.textViewDate)

    }

    fun setFeelingList(feelingList: List<Feeling>){
        this.feelingList = feelingList
        notifyDataSetChanged()

    }
}

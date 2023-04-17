package com.example.crudinroom

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crudinroom.databinding.ItemNoteBinding
import com.example.crudinroom.room.DataNote
import com.example.crudinroom.room.NoteDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class NoteAdapter(var listNote : List<DataNote>): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    var DBNote : NoteDatabase? = null
    class ViewHolder(var binding : ItemNoteBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.ViewHolder {
        var view = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteAdapter.ViewHolder, position: Int) {
        holder.binding.noteId.text = listNote[position].id.toString()
        holder.binding.noteTitle.text = listNote[position].content
        holder.binding.btnDeleteNote.setOnClickListener{
            DBNote = NoteDatabase.getInstance(it.context)

            GlobalScope.async {
                val del = DBNote?.noteDao()?.deleteNote(listNote[position])
                (holder.itemView.context as MainActivity).runOnUiThread{
                    (holder.itemView.context as MainActivity).getAllNote()
                }

            }
        }

        holder.binding.btnEditNote.setOnClickListener {
            var move = Intent(it.context, EditActivity::class.java)
            move.putExtra("dataedit", listNote[position])
            it.context.startActivity(move)
        }
        holder.binding.klik.setOnClickListener{
            var detail = Intent(it.context, DetailActivity::class.java)
            detail.putExtra("detail", listNote[position])
            it.context.startActivity(detail)
        }
    }

    override fun getItemCount(): Int {
        return  listNote.size
    }

    fun setNoteData(listNote: ArrayList<DataNote>)
    {
        this.listNote=listNote
    }
}

package com.example.android_keyboard2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter(private val messageList: List<Message>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_OUTGOING = 1
    private val VIEW_TYPE_INCOMING = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_OUTGOING) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_outgoing_message, parent, false)
            OutgoingMessageViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_incoming_message, parent, false)
            IncomingMessageViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = messageList[position]

        if (holder is OutgoingMessageViewHolder) {
            holder.bind(message)
        } else if (holder is IncomingMessageViewHolder) {
            holder.bind(message)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (messageList[position].isOutgoing) VIEW_TYPE_OUTGOING else VIEW_TYPE_INCOMING
    }

    override fun getItemCount(): Int = messageList.size

    class OutgoingMessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val messageBody: TextView = itemView.findViewById(R.id.text_message_body)

        fun bind(message: Message) {
            messageBody.text = message.text
        }
    }

    class IncomingMessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val messageBody: TextView = itemView.findViewById(R.id.text_message_body)

        fun bind(message: Message) {
            messageBody.text = message.text
        }
    }
}

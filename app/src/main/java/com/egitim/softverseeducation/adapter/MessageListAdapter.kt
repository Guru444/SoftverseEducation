package com.egitim.softverseeducation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.egitim.softverseeducation.databinding.MessageItemLayoutBinding
import com.egitim.softverseeducation.model.Message


class MessageListAdapter : RecyclerView.Adapter<MessageListAdapter.MessageViewHolder>() {

    private var messageList: ArrayList<Message> = arrayListOf()

    var removeItemCLickListener: (Message) -> Unit = { _->}
    var clickItemListener: (Message) -> Unit = { _->}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val binding = MessageItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return MessageViewHolder(binding)
    }

    override fun getItemCount(): Int = messageList.size

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.degerleriBas(messageList[position])
    }

    inner class MessageViewHolder(val binding: MessageItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun degerleriBas(msg: Message){
            binding.apply {
                tvUserName.text = msg.userName
                tvLastMessage.text = msg.userLastMessage
                msg.messageTime?.let {
                    tvTime.text = it.toString()
                }

                ivRemove.setOnClickListener {
                    removeItemCLickListener(msg)
                }
                itemLayout.setOnClickListener {
                    clickItemListener(msg)
                }
            }
        }
    }

    fun setMessageList(mesageList: ArrayList<Message>){
        messageList = mesageList
        notifyDataSetChanged()
    }

}
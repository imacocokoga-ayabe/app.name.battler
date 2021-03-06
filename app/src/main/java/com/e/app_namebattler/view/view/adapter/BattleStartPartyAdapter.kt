package com.e.app_namebattler.view.view.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.e.app_namebattler.R
import com.e.app_namebattler.view.party.player.CharacterAllData

class BattleStartPartyAdapter(val context: Context, val PartyList: ArrayList<CharacterAllData>) :
    BaseAdapter() {

    @SuppressLint("ViewHolder", "SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.data_character_status, null)
        val Name = view.findViewById<TextView>(R.id.data_character_status_data_name_text_id)
        val Job = view.findViewById<TextView>(R.id.data_character_status_data_job_text_id)
        val Hp = view.findViewById<TextView>(R.id.data_character_status_data_hp_text_id)
        val Mp = view.findViewById<TextView>(R.id.data_character_status_data_mp_text_id)
        val Str = view.findViewById<TextView>(R.id.data_character_status_data_str_text_id)
        val Def = view.findViewById<TextView>(R.id.data_character_status_data_def_text_id)
        val Agi = view.findViewById<TextView>(R.id.data_character_status_data_agi_text_id)

        val character = PartyList[position]

        Name.text = "  ".plus(character.name)
        Job.text = "  ".plus(character.job)
        Hp.text = "   HP:".plus(character.hp.toString())
        Mp.text = "   MP:".plus(character.mp.toString())
        Str.text = "   STR".plus(character.str.toString())
        Def.text = "   DEF:".plus(character.def.toString())
        Agi.text = "   AGI:".plus(character.agi.toString())

        return view
    }

    // データの中身
    override fun getItem(position: Int): Any {
        return PartyList[position]
    }

    // データのID
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // データの総数
    override fun getCount(): Int {
        return PartyList.count()
    }
}
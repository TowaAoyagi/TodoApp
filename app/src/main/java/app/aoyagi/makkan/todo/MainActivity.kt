package app.aoyagi.makkan.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1)
        listView.adapter = adapter

        listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent: AdapterView<*>?, view: View?, position: Int, id: Long ->

                val adapter: ArrayAdapter<String> = listView.adapter as ArrayAdapter<String>
                val item = adapter.getItem(position)
                adapter.remove(item)
                adapter.insert(item,position + 1)
            }
        listView.onItemLongClickListener =
            AdapterView.OnItemLongClickListener { parent: AdapterView<*>?, view: View?, position: Int, id: Long ->

                val adapter = listView.adapter as ArrayAdapter<String>
                val item = adapter.getItem(position)
                Toast.makeText(this,  item + "を削除しました", Toast.LENGTH_SHORT).show()
                adapter.remove(item)

                false
            }
    }

    fun addView(v: View) {
        val text: String = editText.text.toString()
        Toast.makeText(this, text + "を追加しました", Toast.LENGTH_SHORT).show()
        adapter.add(text)
        editText.text = null
    }
}

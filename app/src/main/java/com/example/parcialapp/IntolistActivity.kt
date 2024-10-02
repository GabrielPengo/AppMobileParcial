import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ListAdapter
    private lateinit var addButton: FloatingActionButton
    private lateinit var editButton: FloatingActionButton
    private lateinit var searchEditText: TextInputEditText

    private var lists: MutableList<ListItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        recyclerView = findViewById(R.id.recyclerView)
        addButton = findViewById(R.id.floatingActionButton4)
        editButton = findViewById(R.id.floatingActionButton3)
        searchEditText = findViewById(R.id.editText5)

        adapter = ListAdapter(lists)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        addButton.setOnClickListener { addNewList() }
        editButton.setOnClickListener { editList() }
        searchEditText.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Add logic to search for lists
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Add logic to filter lists
                return true
            }
        })
    }

    private fun addNewList() {
        // Add logic to add a new list to the lists collection
        // For example, you can get the list from the previous activity using an intent
        val newList = intent.getParcelableExtra<ListItem>("new_list")
        lists.add(newList)
        adapter.notifyDataSetChanged()
    }

    private fun editList() {
        // Add logic to edit an existing list
        // For example, you can get the list to edit from the recycler view
        val listToEdit = lists[0] // Get the first list as an example
// Start an intent to edit the
    }
}

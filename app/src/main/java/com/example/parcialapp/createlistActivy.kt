import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class createlistActivity : AppCompatActivity() {

    private lateinit var editText: TextInputEditText
    private lateinit var addButton: Button
    private lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_list)

        editText = findViewById(R.id.editText6)
        addButton = findViewById(R.id.button5)
        fab = findViewById(R.id.floatingActionButton2)

        addButton.setOnClickListener { createNewList() }
        fab.setOnClickListener { takePicture() }
    }

    private fun createNewList() {
        val listName = editText.text.toString()
        if (listName.isEmpty()) {
            Toast.makeText(this, "Please enter a list name", Toast.LENGTH_SHORT).show()
            return
        }
        // Add logic to create a new list with the given name
        // For example, you can store the list name in a database or a list of lists
        Toast.makeText(this, "List created successfully", Toast.LENGTH_SHORT).show()
    }

    private fun takePicture() {
        // Add logic to take a picture using the camera
        // For example, you can use the CameraX API or the Android Camera API
        Toast.makeText(this, "Picture taken successfully", Toast.LENGTH_SHORT).show()
    }
}
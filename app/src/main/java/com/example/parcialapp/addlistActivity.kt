import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.parcialapp.databinding.ActivityMainBinding // Substitua pelo nome correto do seu layout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val itemsList = mutableListOf<Item>() // Lista para armazenar os itens

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button4.setOnClickListener {
            val name = binding.editText4.text.toString()
            val quantity = binding.editText2.text.toString().toIntOrNull()
            val units = binding.editText3.text.toString()
            val category = binding.editText4.text.toString()

            // Validação básica
            if (quantity == null || quantity <= 0) {
                Toast.makeText(this, "Quantidade inválida", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            adProdutoLista (nome,quantidade,unidade,categoria)

            // Cria um novo item e adiciona à lista
            val newItem = Produto(name, quantity, units, category)
            itemsList.add(newItem)

            // Atualiza a interface (exemplo com Toast)
            Toast.makeText(this, "Item adicionado: $newItem", Toast.LENGTH_SHORT).show()

            // Limpa os campos de entrada
            binding.editText2.text.clear()
            binding.editText3.text.clear()
            binding.editText4.text.clear()
        }
    }
    private fun adProdutoLista(nome: Any, quantidade: Any, unidade: Any, categoria: Any) {

    }
}
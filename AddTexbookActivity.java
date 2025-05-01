public class AddTextbookActivity extends AppCompatActivity {

    private EditText titleInput, authorInput, copiesInput, priceInput, bankingInput;
    private Button saveButton;
    private List<Textbook> textbookList = new ArrayList<>(); // Simulates saved data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_textbook);

        titleInput = findViewById(R.id.editTitle);
        authorInput = findViewById(R.id.editAuthor);
        copiesInput = findViewById(R.id.editCopies);
        priceInput = findViewById(R.id.editPrice);
        bankingInput = findViewById(R.id.editBanking);
        saveButton = findViewById(R.id.btnSave);

        saveButton.setOnClickListener(v -> {
            String title = titleInput.getText().toString();
            String author = authorInput.getText().toString();
            int copies = Integer.parseInt(copiesInput.getText().toString());
            double price = Double.parseDouble(priceInput.getText().toString());
            String banking = bankingInput.getText().toString();

            Textbook textbook = new Textbook(title, author, copies, price, banking);
            textbookList.add(textbook);

            Toast.makeText(this, "Textbook saved!", Toast.LENGTH_SHORT).show();
        });
    }
}

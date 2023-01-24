package aws.dynamo.test.rest;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import aws.dynamo.test.model.Book;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

  private final DynamoDBMapper dynamoDBMapper;

  @PostMapping
  public String createBook(@RequestBody Book book) {
      String id = UUID.randomUUID().toString();
      book.setId(id);
      dynamoDBMapper.save(book);
      return id;
  }

  @GetMapping("/{id}")
  public Book getBook(@PathVariable String id) {
    return dynamoDBMapper.load(Book.class, id);
  }

  @DeleteMapping("/{id}")
  public void deleteBook(@PathVariable String id) {
    dynamoDBMapper.delete(id);
  }

  @GetMapping
  public List<Book> getAllBooks() {
    return dynamoDBMapper.scan(Book.class, new DynamoDBScanExpression());
  }

}

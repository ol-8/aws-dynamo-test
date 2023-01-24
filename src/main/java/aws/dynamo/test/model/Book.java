package aws.dynamo.test.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;

@Data
@DynamoDBTable(tableName = "books")
public class Book {

  @DynamoDBHashKey(attributeName = "id")
  private String id;

  @DynamoDBAttribute
  private String title;

  @DynamoDBAttribute
  private String author;

  @DynamoDBAttribute
  private Integer published;

}

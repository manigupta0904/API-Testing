import io.restassured.response.Response;
import java.lang.ref.SoftReference;
import java.util.*;
import static io.restassured.RestAssured.given;

public class MainClassJson {


    public  String baseURI="https://jsonplaceholder.typicode.com";
    public String data = "{\n" +
            "    \"userId\": 1,\n" +
            "    \"id\": 1,\n" +
            "    \"title\": \"sunt aut facere re reprehenderit\",\n" +
            "    \"body\": \"quia et suscipit\\nsuscisequr expedita et cum\\nrept quas totam\\nnostrum rto\"\n" +
            "}";


    //  Give the Get Request to an API and get the output
    public void getDataFromAPI()
    {
        Response response = given().header("content-type","application/json").baseUri(baseURI).
                when().get("/posts").
                then().assertThat().statusCode(200).assertThat().
                extract().response();
        printResponse(response.getBody().asString());
    }


    //  Give the Post Request to an API and get output
    public void postDataIntoAPI()
    {
        Response response = given().header("content-type","application/json").
                baseUri(baseURI).body(data).
                when().post("/posts").
                then().extract().response();
        printResponse(response.getBody().asString());
    }


    // Give The PUT Request to an API and update data
    public void updateDataInAPI()
    {
        Response response = given().header("content-type","application/json").
                baseUri(baseURI).body(data).
                when().put("/posts/1").
                then().extract().response();
        printResponse(response.getBody().asString());
    }


    //Give the Delete request to an API and Delete Data
    public void deleteDataFromAPI()
    {
        Response response = given().header("content-type","application/json").
                baseUri(baseURI).
                when().delete("/posts/1").
                then().assertThat().statusCode(200).assertThat().
                extract().response();
        printResponse(response.getBody().asString());
    }


    // Method To Display Output
    public void printResponse(String outputResponse)
    {
        System.out.println(outputResponse);
    }


    //Main Method
    public static void main(String[] args) {

        MainClassJson apiTesting = new MainClassJson();
        Scanner scanner = new Scanner(System.in);
        System.out.print("1: Get data from API\n2: Post data into API\n3: Update data in API\n4: Delete data from aPI\n");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                apiTesting.getDataFromAPI();
                break;
            }
            case 2: {
                apiTesting.postDataIntoAPI();
                break;
            }
            case 3: {
                apiTesting.updateDataInAPI();
                break;
            }
            case 4: {
                apiTesting.deleteDataFromAPI();
                break;
            }
            default: {
                System.out.print("Invalid Input1");
            }
        }
    }
}
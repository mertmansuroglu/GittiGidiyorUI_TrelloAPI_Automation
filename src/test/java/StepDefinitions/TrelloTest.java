package StepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import payload.payloadTrello;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class TrelloTest {
    public static Response response;
    public ValidatableResponse json;
    public RequestSpecification request;
    public String ENDPOINT = "https://api.trello.com/1";
    String key = "b9fbd30e3b9675e0cc2f605dd0c8b08a";
    String token = "28d5dae6bcb2edbc674cba9f24cf17c928e54bb7bb3f816838a785225ca1bdc1";


    @Given("create new trello board called {string}")
    public void createNewTrelloBoardCalledNewMert(String boardName) {
        RestAssured.baseURI = ENDPOINT;

        response = given().contentType(ContentType.JSON).queryParam("key", key).queryParam("token", token).queryParam("name", boardName).when().
                post("/boards/").then().assertThat().statusCode(200).log().all().extract().response();

    }


    @When("I create two new cards on the board")
    public void iCreateTwoNewCardsOnTheBoard() {
        String ListId = getTheListId();
        response = given().contentType(ContentType.JSON).queryParam("name", "new card").queryParam("idList", ListId).queryParam("key", key).queryParam("token", token).when().
                post("/cards").then().assertThat().log().all().extract().response();

        response = given().contentType(ContentType.JSON).queryParam("name", "new card2").queryParam("idList", ListId).queryParam("key", key).queryParam("token", token).when().
                post("/cards").then().assertThat().log().all().extract().response();


    }


    @Given("get the list Id")
    public static String getTheListId() {
        String getTrelloResponse = response.asString();
        String key = "b9fbd30e3b9675e0cc2f605dd0c8b08a";
        String token = "28d5dae6bcb2edbc674cba9f24cf17c928e54bb7bb3f816838a785225ca1bdc1";
        JsonPath js2 = new JsonPath(getTrelloResponse);
        String boardId = js2.getString("id");
        String res = given().contentType(ContentType.JSON).queryParam("key", key).queryParam("token", token).when().
                get("boards/" + boardId + "/lists").then().assertThat().log().all().extract().response().asString();
        JsonPath js1 = new JsonPath(res);
        List<String> a = js1.getList("id");
        return a.get(0);
    }


    @Then("I verify that the cards have been added successfully")
    public void iVerifyThatTheCardsHaveBeenAddedSuccessfully() {


        String boardId = response.asString();
        JsonPath js2 = new JsonPath(boardId);
        boardId = js2.getString("idBoard");
        response = given().contentType(ContentType.JSON).queryParam("key", key).queryParam("token", token).when().
                get("/boards/" + boardId + "/cards").then().assertThat().extract().response();

        String allcards = response.asString();
        JsonPath js1 = new JsonPath(allcards);
        JSONArray jsonArray = new JSONArray(allcards);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String cardName = jsonObject.getString("name");
            if (cardName.equalsIgnoreCase("new card") || cardName.equalsIgnoreCase("new card2")) {
                Assert.assertTrue(true);
                break;
            } else
                Assert.fail();

        }


    }


    @When("I update one of the card as adding a new description")
    public void iUpdateOneOfTheCardAsAddingANewDescription() {
        String allcards = response.asString();
        JsonPath js1 = new JsonPath(allcards);
        JSONArray jsonArray = new JSONArray(allcards);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String boardId = jsonObject.getString("idBoard");
            String listId = jsonObject.getString("idList");
            String cardName = jsonObject.getString("name");
            if (cardName.equalsIgnoreCase("new card")) {
                given().contentType(ContentType.JSON).queryParam("key", key).queryParam("token", token).body(payloadTrello.updateCard(cardName, "new description", boardId, listId)).when().
                        post("/cards").then().assertThat().log().all().extract().response().asString();
            } else
                break;
        }
    }

    @Then("I should be able to delete the created cards")
    public void iShouldBeAbleToDeleteTheCreatedCards() {
        String allcards = response.asString();
        JsonPath js1 = new JsonPath(allcards);
        List<String> idss = js1.getList("idBoard");
        String boardId = idss.get(0);
        response = given().contentType(ContentType.JSON).queryParam("key", key).queryParam("token", token).when().
                get("/boards/" + boardId + "/cards").then().log().all().assertThat().extract().response();
        String allnewCards = response.asString();
        JsonPath js = new JsonPath(allnewCards);
        List<String> ids = js.getList("id");
        for (int i = 0; i < ids.size(); i++) {
            String cardId = ids.get(i);
            given().contentType(ContentType.JSON).queryParam("key", key).queryParam("token", token).when().
                    delete("/cards/" + cardId).then().assertThat().log().all();
        }
    }

    @Then("I should be able to delete the created board")
    public void iShouldBeAbleToDeleteTheCreatedBoard() {
        String takeBoardId = response.asString();
        JsonPath js1 = new JsonPath(takeBoardId);
        List<String> idss = js1.getList("idBoard");
        for (int i = 0; i < idss.size(); i++) {
            given().contentType(ContentType.JSON).queryParam("key", key).queryParam("token", token).when().
                    delete("/boards/" + idss.get(i)).then().assertThat().log().all();

        }
    }
}

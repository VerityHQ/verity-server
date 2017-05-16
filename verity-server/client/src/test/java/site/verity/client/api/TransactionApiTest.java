/**
 * VerityReputation
 * This is a simple Verity reputation API. You can find out more about Verity at <a href='http://getcrystal.net'>http://getcrystal.net</a>  For this sample, you can use the api key 'special-key' for tests that need authorization (authorization filters).  Where possible we specify multi-hashes as unique identifiers that can be used by distributed cryptographically secure systems (blockchains) Where possible we specify hyper-media links (e.g. JSON-LD) to describe data that is linked in graph structures by nature (blockchain data, IPFS data, etc.)  Agents, Entity and Activity should map to provenance ontology described in https://www.w3.org/TR/prov-o Transaction is an implementation that maps to TrustAtoms. https://github.com/CoMakery/trust-exchange/blob/master/README.md This is a simple Verity reputation API. You can find out more about Verity at <a href='http://getcrystal.net'>http://getcrystal.net</a>  For this sample, you can use the api key 'special-key' for tests that need authorization (authorization filters).  Where possible we specify multi-hashes as unique identifiers that can be used by distributed cryptographically secure systems (blockchains) Where possible we specify hyper-media links (e.g. JSON-LD) to describe data that is linked in graph structures by nature (blockchain data, IPFS data, etc.)  Agents, Entity and Activity should map to provenance ontology described in https://www.w3.org/TR/prov-o Transaction is an implementation that maps to TrustAtoms. https://github.com/CoMakery/trust-exchange/blob/master/README.md
 *
 * OpenAPI spec version: 1.0.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package site.verity.client.api;

import site.verity.client.ApiException;
import site.verity.client.ApiResponse;
import io.swagger.client.model.Transaction;
import io.swagger.client.model.ValueAction;
import io.swagger.client.model.ActionType;
import io.swagger.client.model.Agent;
import io.swagger.client.model.Community;
import io.swagger.client.model.Organization;
import io.swagger.client.model.Person;

import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;

/**
 * API tests for TransactionApi
 */
public class TransactionApiTest {
	//TODO: extract general purpose setup helper methods into a commont static class
    
	//TODO:this should be driven from the config, not a constant
    private static final String API_BASE_PATH = "http://localhost:8080/verity/core";
    private final static TransactionApi transactionApi = new TransactionApi();
    private final static OrganizationApi organizationApi = new OrganizationApi();
    private final static PersonApi personApi = new PersonApi();
    private final static ValueActionApi valueActionApi = new ValueActionApi();
    private final static ActionTypeApi actionTypeApi = new ActionTypeApi();
    
    //TODO: refactor to get rid of these fields
    private static Person personA = new Person();
    private static Person personB = new Person();
    private static ValueAction contentKarmaValueAction;
	private static ValueAction discussionInsightValueAction;
    
    @BeforeClass
    public static void runOnceBeforeClass() throws ApiException {
    	transactionApi.getApiClient().setBasePath(API_BASE_PATH);
    	organizationApi.getApiClient().setBasePath(API_BASE_PATH);
    	personApi.getApiClient().setBasePath(API_BASE_PATH);
    	valueActionApi.getApiClient().setBasePath(API_BASE_PATH);
    	actionTypeApi.getApiClient().setBasePath(API_BASE_PATH);
        setupForTransactionTest();
    }
    
    /*
     * shows how to create all the things needed before you can
     * create a transaction
     */
    public static void setupForTransactionTest() throws ApiException{
    	//create org, person, actionType
    	Organization organization = buildOrganizationAndCommunity();
		ApiResponse<Organization> organizationResponse = organizationApi.createOrganizationWithHttpInfo(organization);
		assertEquals(organizationResponse.getStatusCode(), 200);
		String orgId = organizationResponse.getData().getUuid();
		
    	personA = buildPerson(orgId);
    	personB = buildPerson(orgId);
		
    	ApiResponse<Person> personResponseA = personApi.createPersonWithHttpInfo(personA);
		assertEquals(personResponseA.getStatusCode(), 200);
		personA = personResponseA.getData(); //we have the newly create person with the newly generated ids
		assertNotEquals("", personA.getUuid());
		assertNotEquals("", personA.getAgent().getUuid());
		
		ApiResponse<Person> personResponseB = personApi.createPersonWithHttpInfo(personB);
		assertEquals(personResponseB.getStatusCode(), 200);
		personB = personResponseB.getData();
		assertNotEquals("", personB.getUuid());
		assertNotEquals("", personB.getAgent().getUuid());

		ActionType karmaActionType = createActionType(
				organizationResponse.getData().getCommunity().getUuid(), 
				"Karma", 
				"Represents good behavior for any actions this community deems worthy in it's charter. "
				+ "A general measure of community participation to be encouraged by community norms.",
				1);
		
		contentKarmaValueAction = createValueAction(karmaActionType, "Content Karma Points: UpVote content by " 
				+ karmaActionType.getDefaultPoints() + " points.");
		
		
		ActionType insightActionType = createActionType(
				organizationResponse.getData().getCommunity().getUuid(), 
				"Insight", 
				"Represents insight expressed in response to topic under discussion."
				+ "An insight should synthesize existing information and add a new perspective to the discussion.",
				3);
		
		discussionInsightValueAction = createValueAction(insightActionType, 
				"Discussion Insight Points: Add points to members account for contributing insight in a post");
		
    }


	/**
     * create transaction
     * 
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createTransactionTest() throws ApiException {
        Transaction body = new Transaction();
        body.setSourceAgentId(personA.getAgent().getUuid());
        body.setTargetAgentId(personB.getAgent().getUuid());
        body.setValue("5");
        body.setValueActionId(contentKarmaValueAction.getUuid()); //TODO:
        body.setTimeStamp(DateTime.now().toString());
        body.setUuid(""); //TODO: what purpose does the UUID setter have? would we ever use it?

        ApiResponse<Transaction> response = transactionApi.createTransactionWithHttpInfo(body);
		assertEquals(response.getStatusCode(), 200);
        // TODO: test validations
    }
    
    /**
     * get Transactions by targetAgentId
     *
     * TODO:consider paginating results in similar way to reddit API https://www.reddit.com/dev/api/
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getTransactionByTargetAgentIdTest() throws ApiException {
        String targetAgentId = null;
        // List<Transaction> response = api.getTransactionByTargetAgentId(targetAgentId);

        // TODO: test validations
    }
    
    /**
     * get transactions by targetAgent and contentKarmaValueAction
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getTransactionByTargetAgentIdByValueActionIdTest() throws ApiException {
        String targetAgentId = null;
        String valueActionId = null;
        // api.getTransactionByTargetAgentIdByValueActionId(targetAgentId, contentKarmaValueAction);

        // TODO: test validations
    }
    
    /**
     * get Transactions by Dates
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getTransactionsByDatesTest() throws ApiException {
        String targetAgentId = null;
        String fromdate = null;
        String todate = null;
        // List<Transaction> response = api.getTransactionsByDates(targetAgentId, fromdate, todate);

        // TODO: test validations
    }
    
    
	private static Organization buildOrganizationAndCommunity() {
		Organization body = new Organization();
		body.setUuid("");
		body.setOrgName("Wikipedia");
		
        Agent orgAgent = new Agent();
        orgAgent.setUuid("");
        orgAgent.setAttestationUrls(Arrays.asList("foo","bar"));
        orgAgent.setPublicKey("somereallylongpublickeystring129-408-120481-590810235159159058190-589");
		body.setAgent(orgAgent);
        
        Agent communityAgent = new Agent();
        communityAgent.setUuid("");
        communityAgent.setAttestationUrls(Arrays.asList("http://keybase.io/some/key","http://twitter.com/my_pk_encrypedtweet"));
        communityAgent.setPublicKey("another_publickeystring129-408-120481-590810235159159058190-589");
		
        Community community = new Community();
        community.setAgent(communityAgent);
        community.setCommunityName("Content Creators");
        community.setUuid("");
        
        body.setCommunity(community);
		return body;
	}
	
    private static Person buildPerson(String orgId) {
    	Person person = new Person();
    	person.setUuid("");
    	person.setOrganizationId(orgId);
    	person.setFirstName(RandomStringUtils.randomAlphabetic(10));
    	person.setLastName(RandomStringUtils.randomAlphabetic(10));
    	person.setNickName(RandomStringUtils.randomAlphabetic(6));
    	
        Agent orgAgent = new Agent();
        orgAgent.setUuid("");
        orgAgent.setAttestationUrls(Arrays.asList(
        		"http://keybase.io/keys/" + RandomStringUtils.randomAlphabetic(20).toLowerCase(),
        		"http://keybase.io/keys/" + RandomStringUtils.randomAlphabetic(20).toLowerCase())
        		);
        orgAgent.setPublicKey(RandomStringUtils.randomAlphanumeric(50));
		person.setAgent(orgAgent);
		return person;
	}

	private static ActionType createActionType(String communityId, String name, String content, int points) throws ApiException {
		ActionType actionType = new ActionType();
		actionType.setActionName(name);
		actionType.setCommunityId(communityId);
		actionType.setContent(content);
		actionType.setDefaultPoints(3);
		actionType.setUuid("");
		ApiResponse<ActionType> response = actionTypeApi.createActiontypeWithHttpInfo(actionType);
		return response.getData();
	}

	private static ValueAction createValueAction(ActionType actionType, String description) throws ApiException {
		ValueAction valueAction = new ValueAction();
		valueAction.setActionTypeId(actionType.getUuid());
		valueAction.setArchived(false);
		valueAction.setAmount(actionType.getDefaultPoints());
		valueAction.setDescription(description);
		valueAction.setUuid("");
		ApiResponse<ValueAction> response = valueActionApi.createValueActionWithHttpInfo(valueAction);
		return response.getData();
	}

}

package io.swagger.api;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.web3j.protocol.Web3j;
//import org.web3j.protocol.core.methods.response.Web3ClientVersion;
//import org.web3j.protocol.http.HttpService;

import io.swagger.annotations.ApiParam;
import io.swagger.model.Agent;
import io.swagger.model.Organization;
import io.swagger.model.Person;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-11-16T05:42:22.193Z")

@Controller
public class PersonApiController implements PersonApi {

    public ResponseEntity<Person> personGet(@ApiParam(value = "multi-hash id of person record on the blockchain", required = true) @RequestParam(value = "id", required = true) String id) {
        Person person = this.getPerson();
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }

	private Person getPerson() {
		// do some magic!
    	//get person from blockchain via web3j    	
    	Person person = new Person();

    	// https://github.com/web3j/web3j
    	// 
    	// http://stackoverflow.com/questions/33487896/eclipse-does-not-allow-access-to-static-interface-method-in-external-jar-from-an
    	// have to use Java 8 for this to work. 
    	// Set your Project.Properties.BuildPath to Java 8 
    	// as well as the Compiler to Java 8
    	// and the Project Properties -> Project Facets
    	// start geth: geth --rpcapi personal,db,eth,net,web3 --rpc --testnet
//    	Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/
//    	Web3ClientVersion web3ClientVersion;
//		try {
//			web3ClientVersion = web3.web3ClientVersion().send();
//	    	String clientVersion = web3ClientVersion.getWeb3ClientVersion();
//	    	person.setNickName(clientVersion);
//	    	
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
    	person.setFirstName("Vitalik");
    	person.setLastName("Buterin");
    	
    	Agent personAgent = new Agent();
    	personAgent.setHashId("theAgentHashID#12345");
    	personAgent.setKey("415059D5FDEC734D");
    	personAgent.setUrl("https://keybase.io/dwking");
    	person.setAgent(personAgent);
    	
    	Organization org = new Organization();
    	org.setOrgName("grant");
    	Agent orgAgent = new Agent();
    	orgAgent.setHashId("organizationHashCode123123");
    	orgAgent.setKey("someOrgKey");
    	orgAgent.setUrl("ipfs://aweozdypyqwe4t/qewtypy");
    	org.setAgent(orgAgent);

    	person.setOrganization(org);
		return person;
	}

    public ResponseEntity<String> personPost(@ApiParam(value = ""  ) @RequestBody Person body) {
        // create person and persist
    	
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    public ResponseEntity<Void> personPut(@ApiParam(value = ""  ) @RequestBody Person body) {
        // update person
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}

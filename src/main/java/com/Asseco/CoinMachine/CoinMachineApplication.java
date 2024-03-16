package com.Asseco.CoinMachine;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CoinMachineApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoinMachineApplication.class, args);
	}

}

@RestController
@RequestMapping("/coins")
class CoinsController {

	@PostMapping
    public Map<String, Long> countOccurrences(@RequestBody Payload payload) {
       
        List<String> listOfPeople = Arrays.asList("rightPerson", "leftPerson");
        
        //To maintain the order in result that is why i choosed LinkedHashMap
        Map<String, Long> result = new LinkedHashMap<>();

        // Initialize counters for 'P' and 'R' added by each person
        long rightPersonPCount = 0;
        long leftPersonPCount = 0;
        long rightPersonRCount = 0;
        long leftPersonRCount = 0; 


        for (String person : listOfPeople) {
            List<String> personList = person.equals("rightPerson") ? payload.getRightPerson() : payload.getLeftPerson();
            
            //The count how many of each action was perfomed by each person
            if(person.equals("rightPerson")) {
            	rightPersonPCount =   countChars(personList,"P");
            	rightPersonRCount = countChars(personList,"R");
            	
            }
            else {
            	leftPersonPCount =  countChars(personList,"P");
            	leftPersonRCount =  countChars(personList,"R");
            }
            
        }
        
        long totalRight = countTotalChars(leftPersonPCount, rightPersonRCount, rightPersonPCount);
        
        long totalLeft = countTotalChars(rightPersonPCount, leftPersonRCount, leftPersonPCount);
        
        //Put each person in the Map with is specif coins
        for(String person : listOfPeople) {
        	long total = person.equals("rightPerson") ? totalRight : totalLeft;
        	result.put(person, total);
        }
            
        // Return the result map
        return result;
    }
    //Tell how many coins in the end each person stays
	private long countTotalChars(long Person1PCount, long Person2RCount, long Person2PCount) {
		long total = 0;
		if(Person1PCount >= Person2RCount) {
        	total = (Person2RCount*3)-Person2PCount;	
        }
        else {
        	total = (Person1PCount*3)-Person2PCount;
        }
		total = total +3;
		return total < 0 ? 0 : total;
	}
	//Count how of many times specif action happens
	private long countChars(List<String> List, String letter) {
		long countP = List.stream().filter(x -> x.equals(letter)).count();
		return countP;
	}
	
    	
     
}



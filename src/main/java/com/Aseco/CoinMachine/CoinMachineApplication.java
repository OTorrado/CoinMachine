package com.Aseco.CoinMachine;

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
    	
        List<String> orderOfPeople = Arrays.asList("rightPerson", "leftPerson");
        
        //Need to use to main order, PreviousMap didn't Maintain
        Map<String, Long> result = new LinkedHashMap<>();

        for (String person : orderOfPeople) {
            List<String> personList = getPersonList(payload, person);
            long totalCount = countTotal(personList) + 3;
            result.put(person, totalCount);
        }

        return result;
    }

    private List<String> getPersonList(Payload payload, String person) {
        switch (person) {
            case "rightPerson":
                return payload.getRightPerson();
            case "leftPerson":
                return payload.getLeftPerson();
            default:
                return Collections.emptyList();
        }
    }

	
	private long countTotal(List<String> list) {
        
		 return list.stream()
                .mapToInt(character -> character.equals("P") ? -1 : 3)
                .sum();
    }
	
    	
    	
    
     
}



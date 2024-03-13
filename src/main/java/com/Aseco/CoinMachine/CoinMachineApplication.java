package com.Aseco.CoinMachine;

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
        
		Map<String, List<String>>peopleMap = Map.of(
                "rightPerson", payload.getRightPerson(),
                "leftPerson", payload.getLeftPerson()
        );
		

        return peopleMap.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (long) countTotal(entry.getValue())+3
                ));
	}
	
	 private long countTotal(List<String> list) {
        
		 return list.stream()
                .mapToInt(character -> character.equals("P") ? -1 : 3)
                .sum();
    }
	
    	
    	
    
     
}



package com.springKafka.liveDashboard.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springKafka.liveDashboard.model.UserEvent;
import com.springKafka.liveDashboard.model.UserRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class KafkaConsumerService{
	
	@Autowired
	SimpMessagingTemplate template;

	private Map<String, String> userMac= new HashMap<>();


	@KafkaListener(topics="${kafka.topic}")
	public void consume(@Payload String payload) throws IOException {
		userMac.put("1", "iurie");
		userMac.put("2", "traian");
		userMac.put("3", "marius");
		userMac.put("4", "mzg");

		ObjectMapper objectMapper = new ObjectMapper();
		UserEvent userEvent = objectMapper.readValue(payload, UserEvent.class);

		template.convertAndSend("/topic/userZone", userEvent.getMacIds().size());

		UserRoom userRoom = new UserRoom();
		userRoom.setRoomId(userEvent.getRoomId());
		userRoom.setPersonName(userEvent.getMacIds().stream().map(macId -> userMac.get(macId)).collect(Collectors.toList()));

		if (userRoom.getRoomId().equals("1")) {
			template.convertAndSend("/topic/userRoom1", userRoom);
		}
		if (userRoom.getRoomId().equals("2")) {
			template.convertAndSend("/topic/userRoom2", userRoom);
		}
	}

	public  boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    @SuppressWarnings("unused")
		double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
}

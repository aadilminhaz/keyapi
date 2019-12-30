package com.myexample.keyapi.controller;

import java.util.HashMap;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myexample.keyapi.model.KeyRequest;

@RestController
public class KeyController {
	
	private static HashMap<Integer, String> keyValueStore = new HashMap<Integer, String>();
	
	
	@RequestMapping(value= {"/store"}, method=RequestMethod.GET)
	public String getValueByKey(@RequestBody KeyRequest keyRequest) {
		//Call to service layer
		//Map<Integer, String> response = new HashMap<Integer, String>();
		return keyValueStore.get(keyRequest.getKey());
		
		
	}
	
	@RequestMapping(value= {"/store"}, method=RequestMethod.POST)
	public Boolean saveValue(@RequestBody KeyRequest keyRequest) {
		
		
		try {
			keyValueStore.put(keyRequest.getKey(), keyRequest.getValue());
		} catch (NullPointerException e) {
			return false;
		} catch(Exception e) {
		
			return false;
		}
		return true;
	}
}

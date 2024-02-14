package com.tunehub.project1.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.tunehub.project1.entity.Users;
import com.tunehub.project1.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PaymentController {
	private static final String Finally = null;
	@Autowired
	UsersService service;
	@GetMapping("/pay")
	
		public String pay(@RequestParam String param)
		{
			return "pay";
		}
	


@SuppressWarnings("finally")
@PostMapping("/createOrder")
@ResponseBody
public String createOrder(HttpSession session) {

	int  amount  = 5000;
	Order order=null;
	try {
		RazorpayClient razorpay=new RazorpayClient("rzp_test_lFbmt3XVOIYN8b", "jQVG1zgGBTEOGf9rtuLFDcaQ");

		JSONObject orderRequest = new JSONObject();
		orderRequest.put("amount", amount*100); // amount in the smallest currency unit
		orderRequest.put("currency", "INR");
		orderRequest.put("receipt", "order_rcptid_11");

		order = razorpay.orders.create(orderRequest);

		String mail =  (String) session.getAttribute("email");

		Users u = service.getUser(mail);
		u.setPremium(true);
		service.updateUser(u);

	} 
	finally {
		return order.toString();
	}
}	
}
	
	
	




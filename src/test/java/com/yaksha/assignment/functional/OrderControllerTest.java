package com.yaksha.assignment.functional;

import static com.yaksha.assignment.utils.TestUtils.businessTestFile;
import static com.yaksha.assignment.utils.TestUtils.currentTest;
import static com.yaksha.assignment.utils.TestUtils.testReport;
import static com.yaksha.assignment.utils.TestUtils.yakshaAssert;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.yaksha.assignment.controller.OrderController;
import com.yaksha.assignment.utils.JavaParserUtils;

@WebMvcTest(OrderController.class)
public class OrderControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testGetOrderById() throws Exception {
		// Perform GET request to /orders/{id} endpoint and capture the response
		String response = mockMvc.perform(get("/orders/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()) // Expect HTTP status 200 OK
				.andReturn().getResponse().getContentAsString(); // Get the response body as a string

		System.out.println(response);
		// Assert using YakshaAssert that the response contains expected values
		boolean result = response.contains("\"id\":1");

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}

	@Test
	public void testGetAllOrders() throws Exception {
		// Perform GET request to /orders endpoint and capture the response
		String response = mockMvc.perform(get("/orders").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()) // Expect HTTP status 200 OK
				.andReturn().getResponse().getContentAsString(); // Get the response body as a string

		// Assert using YakshaAssert that the response contains expected values
		System.out.println(response);
		boolean result = response.contains("id") && response.contains("totalAmount")
				&& response.contains("customerName") && response.contains("product");

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}

	@Test
	public void testCreateOrder() throws Exception {
		// Create a new order JSON object
		String orderJson = "{\"orderId\":3,\"totalAmount\":199.99,\"customerName\":\"John Doe\",\"status\":\"Pending\"}";

		// Perform POST request to create the new order
		String response = mockMvc.perform(post("/orders").contentType(MediaType.APPLICATION_JSON).content(orderJson))
				.andExpect(status().isOk()) // Expect HTTP status 200 OK
				.andReturn().getResponse().getContentAsString(); // Get the response body as a string

		System.out.println(response);
		// Assert using YakshaAssert that the response contains expected values
		boolean result = response.contains("id") && response.contains("\"totalAmount\":199.99")
				&& response.contains("\"customerName\":\"John Doe\"");

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}

	@Test
	public void testUpdateOrder() throws Exception {
		// Create a new order JSON object to update an existing order
		String orderJson = "{\"id\":1,\"totalAmount\":150.00,\"customerName\":\"Jane Doe\",\"status\":\"Shipped\"}";

		// Perform PUT request to update the order with ID 1
		String response = mockMvc.perform(put("/orders/1").contentType(MediaType.APPLICATION_JSON).content(orderJson))
				.andExpect(status().isOk()) // Expect HTTP status 200 OK
				.andReturn().getResponse().getContentAsString(); // Get the response body as a string

		System.out.println(response);
		// Assert using YakshaAssert that the response contains updated values
		boolean result = response.contains("\"id\":1") && response.contains("\"totalAmount\":150.0")
				&& response.contains("\"customerName\":\"Jane Doe\"");

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}

	@Test
	public void testRestControllerAnnotation() throws Exception {
		// Specify the file path to the OrderController class
		String filePath = "src/main/java/com/yaksha/assignment/controller/OrderController.java"; // Update path to your
																									// controller

		// Check if the class is annotated with @RestController
		boolean result = JavaParserUtils.checkClassAnnotation(filePath, "RestController");

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}

	@Test
	public void testReturnTypeOfGetOrder() throws Exception {
		// Specify the file path to the OrderController class
		String filePath = "src/main/java/com/yaksha/assignment/controller/OrderController.java"; // Update path to your
																									// controller

		// Check if the getOrder method has the correct return type (Order)
		boolean result = JavaParserUtils.checkMethodReturnType(filePath, "getOrder", "Order");

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}

	@Test
	public void testGetOrderAnnotation() throws Exception {
		// Specify the file path to the OrderController class
		String filePath = "src/main/java/com/yaksha/assignment/controller/OrderController.java"; // Update path to your
																									// controller

		// Check if the getOrder method has @GetMapping annotation with value "/{id}"
		boolean result = JavaParserUtils.checkMethodAnnotation(filePath, "getOrder", "GetMapping")
				&& JavaParserUtils.checkMethodParameterAnnotation(filePath, "getOrder", "id", "PathVariable");

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}

	@Test
	public void testGetAllOrdersAnnotation() throws Exception {
		// Specify the file path to the OrderController class
		String filePath = "src/main/java/com/yaksha/assignment/controller/OrderController.java"; // Update path to your
																									// controller

		// Check if the getAllOrders method has @GetMapping annotation
		boolean result = JavaParserUtils.checkMethodAnnotation(filePath, "getAllOrders", "GetMapping");

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}

	@Test
	public void testCreateOrderAnnotation() throws Exception {
		// Specify the file path to the OrderController class
		String filePath = "src/main/java/com/yaksha/assignment/controller/OrderController.java"; // Update path to your
																									// controller

		// Check if the createOrder method has @PostMapping annotation
		boolean result = JavaParserUtils.checkMethodAnnotation(filePath, "createOrder", "PostMapping");

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}

	@Test
	public void testUpdateOrderAnnotation() throws Exception {
		// Specify the file path to the OrderController class
		String filePath = "src/main/java/com/yaksha/assignment/controller/OrderController.java"; // Update path to your
																									// controller

		// Check if the updateOrder method has @PutMapping annotation with value "/{id}"
		boolean result = JavaParserUtils.checkMethodAnnotation(filePath, "updateOrder", "PutMapping")
				&& JavaParserUtils.checkMethodParameterAnnotation(filePath, "updateOrder", "id", "PathVariable");

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}

	@Test
	public void testDeleteOrderAnnotation() throws Exception {
		// Specify the file path to the OrderController class
		String filePath = "src/main/java/com/yaksha/assignment/controller/OrderController.java"; // Update path to your
																									// controller

		// Check if the deleteOrder method has @DeleteMapping annotation with value
		// "/{id}"
		boolean result = JavaParserUtils.checkMethodAnnotation(filePath, "deleteOrder", "DeleteMapping")
				&& JavaParserUtils.checkMethodParameterAnnotation(filePath, "deleteOrder", "id", "PathVariable");

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}
}
